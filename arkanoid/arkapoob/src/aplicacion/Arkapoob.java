package aplicacion;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import persistencia.*;

public class Arkapoob implements Serializable{
	private Bola bola;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Bloque> bloques;
	private int maxX;
	private int maxY;
	private String ultimoBloqueEliminado;
	private static transient ArkapoobDAO arkaDAO;
	private static final long serialVersionUID = 8799656478674716638L;
	private ArrayList<Poder> poderes;
	private int nivel;
	private Nivel generador;
	private int nJugadores;
	private int ultimoJugador;
	private int i;
	
	public Arkapoob(int nJugadores,int maxX ,int maxY)  {
		nivel=0;
		i=0;
		this.maxX=maxX;
		this.maxY=maxY;
		this.nJugadores=nJugadores;
		ultimoJugador=0;
		ultimoBloqueEliminado="";
		bloques=new ArrayList<Bloque>();
		generador=new Nivel(maxX,maxY);
		poderes=new ArrayList<Poder>();
		jugadores=new ArrayList<Jugador>();
		if(nJugadores==1) {
			jugadores.add(new Jugador(this,202,620));
		}
		else if(nJugadores==2) {
			jugadores.add(new Jugador(this,0,620));
			jugadores.add(new Jugador(this,maxX-120,620));
		}
		generarNuevoNivel();
		arkaDAO=new ArkapoobDAO();
	}
	/**
	 * determina si el jugador perdio la partida
	 * @return true si el numero de vidas del jugador 0 ;false si no
	 */
	public boolean isGameOver() {
		boolean over= false;
		for (Jugador jugador:jugadores) {
			if (jugador.getLives()<=0) {
				over=true;
				break;
			}
		}
		return over;
	}
	/**
	 *determina si el jugador gano la partida 
	 * @return true si el numero de bloques destruibles es 0 ; false si no
	 */
	public boolean playerWin() {
		int bloquesRestantes=0;
		for(Bloque b:bloques) {
			if (b.isDestroyable())bloquesRestantes+=1;
		}
		if(bloquesRestantes==0&&nivel<5) {
			generarNuevoNivel();
		}
		return nivel>5;
	}
	public void generarNuevoNivel() {
		setBall();
		//bloques= generador.generarNivel(this);
		for (int j =100;j<225;j+=25) {
			for (int i =0;i<maxX;i+=45) {
				bloques.add(new BloqueSorpresa(this,i,j));
			}
		}
		nivel+=1;
	}
	/**
	 * retorna la bola que se esta usando en el juego
	 * @return la bola usada en el juego
	 */
	public Bola getBola(){
		return bola;
	}

	/**
	 * retorna la lista de bloques que quedan en la partida
	 * @return los bloques de la partida
	 */
	public ArrayList<Bloque> getBloques() {
		return bloques;
	}
	public ArrayList<Poder> getPoderes(){
		return poderes;
	}
	private void moverPoderes() {
		ArrayList<Poder> borrar=new ArrayList<Poder>();
		for(Poder p:poderes) {
			if(!p.move())borrar.add(p);
		}
		for(Poder p:borrar) {
			poderes.remove(p);
		}
	}
	/**
	 * detecta si la bola se colisiona con algun objeto y si es asi cambia su direccion, finalmente mueve la bola
	 */
	public void moverElementos() {
		
		colisionJugadorPoderes();
		moverPoderes();
		colisionBolaBloques();
		colisionJugador();
		bola.move();
		
		//System.out.println(i);
		//i+=1;
	}
	private void colisionJugadorPoderes() {
		for(Jugador jugador:jugadores) {
			for(Poder p:poderes) {
				if (jugador.collision(p.getShape())){
					p.reactToCollision(jugador);
					break;
				}
			}
		}
	}
	/**
	 * detecta si la bola se colisiona con la barra del jugador y si es asi cambia la direccion de la bola
	 */
	private void colisionJugador() {
		for(int i=0;i<jugadores.size();i++) {
			if(jugadores.get(i).collision(bola.getShape())) {
				jugadores.get(i).reactToCollision(bola);
				ultimoJugador=i;
			}
		}
	}
	public Bloque colisionBloques(RectangularShape inShape) {
		Bloque res= null;
		for (Bloque b:bloques) {
			if (b.collision(inShape)) {
				res=b;
				break;
			}
		}
		return res;
	}
	/**
	 * detecta si la bola se colisiona con alguno de los bloques y si es asi cambia la direccion de la bola
	 * y hace daño al edificio, si el edificio es destruido se remueve de la lista de bloques
	 */
	private void colisionBolaBloques() {
		Bloque b=colisionBloques(bola.getShape());
		if(b!=null) {
			b.reactToColission(bola);
		}
	}
	public void setBall() {
		Random random =new Random();
		int p =random.nextInt(nJugadores);
		ultimoJugador=p;//temp
		Jugador jugador=jugadores.get(p);
		bola=new Bola(jugador.getPlatform().getX()+jugador.getPlatform().getWidth()/2 , jugador.getPlatform().getY()-10,this);
	}
		

	/**
	 * retorna el puntaje del jugador como un entero
	 * @return retorna el puntaje del jugador
	 */
	public int getPuntajeJugador(int numeroJugador) {
		return jugadores.get(numeroJugador).getScore();
	}
	public boolean ColisionJugadores() {
		boolean  colision =false;
		for(int i=0;i<jugadores.size();i++) {
			for(int j=i;j<jugadores.size();j++) {
				if(i!=j&&jugadores.get(i).collision(jugadores.get(j).getPlatform().getShape())) {
					colision =true;
					jugadores.get(i).reactToCollision(jugadores.get(j));
				}
			}
		}
		return colision;
	}
	/**
	 * mueve al jugador a la derecha  si es posible
	 */
	public void moverPlataformaDerecha(int numeroJugador) {
		boolean colision = ColisionJugadores();
		if (!colision)jugadores.get(numeroJugador).moverPlataformaDerecha();
		
	}
	/**
	 * mueve al jugador a la izquierda  si es posible
	 */
	public void moverPlataformaIzquierda(int numeroJugador) {
		boolean colision =ColisionJugadores();
		if(!colision)jugadores.get(numeroJugador).moverPlataformaIzquierda();
		
	}
	/**
	 *  
	 * @return el jugador
	 */
	public Jugador getJugador(int numeroJugador) {
		return jugadores.get(numeroJugador);
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void remove(Bloque bloque) {
		bloques.remove(bloque);
	}
	public void sumarPuntosJugador(int puntaje) {
		jugadores.get(ultimoJugador).sumarPuntos(puntaje);
	}
	public void sumarVidaJugador() {
		jugadores.get(ultimoJugador).setVidas(jugadores.get(ultimoJugador).getLives()+1);
	}
	public void restarVidaJugador() {
		jugadores.get(ultimoJugador).setVidas(jugadores.get(ultimoJugador).getLives()-1);
	}
	public void setUltimoBloqueEliminado(String ultimo) {
		ultimoBloqueEliminado=ultimo;
	}
	public String getUltimoBloqueEliminado() {
		return ultimoBloqueEliminado;
	}
	public void añadirBloque(Bloque b) {
		bloques.add(b);
	}
	public void anadirBloque(Bloque b) {
		bloques.add(b);
	}
	public void añadirPoder(Poder p) {
		poderes.add(p);
	}
	public void anadirPoder(Poder p) {
		poderes.add(p);
	}
	
	public void salvar(File file) throws ArkapoobException{
		arkaDAO.salvar(this,file);
	}
	public Arkapoob abrir(File file) throws ArkapoobException{
		return arkaDAO.abrir(file);
	}
	public void removerPoder(Poder poder) {
		poderes.remove(poder);
	}
	public void usarHabilidadJugador(int numeroJugador) {
		jugadores.get(numeroJugador).usarHabilidadPlataforma();
	}
	public int getNJugadores(){
		return nJugadores;
	}

}
