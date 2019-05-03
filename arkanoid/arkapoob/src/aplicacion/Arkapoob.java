package aplicacion;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.io.*;
import persistencia.*;

public class Arkapoob implements Serializable{
	private Bola bola;
	private Jugador jugador;
	private ArrayList<Bloque> bloques;
	private int maxX;
	private int maxY;
	private String ultimoBloqueEliminado;
	private static transient ArkapoobDAO arkaDAO;
	private static final long serialVersionUID = 8799656478674716638L;
	
	public Arkapoob(int maxX ,int maxY)  {
		
		this.maxX=maxX;
		this.maxY=maxY;
		bloques=new ArrayList<Bloque>();
		jugador=new Jugador(this);
		ultimoBloqueEliminado="";
		bola=new Bola(jugador.getPlatform().getX()+jugador.getPlatform().getWidth()/2 , jugador.getPlatform().getY()-10);
		for (int j =224;j<225;j+=25) {
			for (int i =0;i<maxX;i+=45) {
				bloques.add(new BloqueResistente(this,i,j));
			}
		}
		arkaDAO=new ArkapoobDAO();
	}
	/**
	 * determina si el jugador perdio la partida
	 * @return true si el numero de vidas del jugador 0 ;false si no
	 */
	public boolean isGameOver() {
		return jugador.getLives()==0;
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
		return bloquesRestantes==0;
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
	/**
	 * detecta si la bola se colisiona con algun objeto y si es asi cambia su direccion, finalmente mueve la bola
	 */
	public void moverBola() {
		//System.out.println(ultimoBloqueEliminado);
		bolaEnBorde();
		colisionBolaBloques();
		colisionJugador();
		bola.move();
	}
	/**
	 * detecta si la bola se colisiona con la barra del jugador y si es asi cambia la direccion de la bola
	 */
	private void colisionJugador() {
		if(jugador.collision(bola.getShape())) {
			bola.setDy(Bola.ARRIBA);
			if(jugador.collisionRight(bola.getShape())) {
				bola.setDx(Bola.DERECHA);
			}
			else {
				bola.setDx(Bola.IZQUIERDA);
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
		
	/**
	 * detecta si la bola esta en alguno de los bordes y cambia su direccion si se trata del borde superior o alguno de los laterales
	 * si es el borde inferior resta una vida y reinicia la bola 
	 */
	private void bolaEnBorde() {
		if(bola.getX()>maxX||bola.getX()<0) {
			bola.setDx(bola.getDx()*-1);
		}
		else if(bola.getY()<0) {
			bola.setDy(bola.ABAJO);
		}
		else if(bola.getY()>maxY) {
			bola=new Bola(jugador.getPlatform().getX()+jugador.getPlatform().getWidth()/2 , jugador.getPlatform().getY()-10);
			jugador.setVidas(jugador.getLives()-1);
		}
	}
	/**
	 * retorna el puntaje del jugador como un entero
	 * @return retorna el puntaje del jugador
	 */
	public int getPuntajeJugador() {
		return jugador.getScore();
	}
	/**
	 * mueve al jugador a la derecha  si es posible
	 */
	public void moverPlataformaDerecha() {
		jugador.moverPlataformaDerecha();
	}
	/**
	 * mueve al jugador a la izquierda  si es posible
	 */
	public void moverPlataformaIzquierda() {
		jugador.moverPlataformaIzquierda();
	}
	/**
	 *  
	 * @return el jugador
	 */
	public Jugador getJugador() {
		return jugador;
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
		jugador.sumarPuntos(puntaje);
	}
	public void sumarVidaJugador() {
		jugador.setVidas(jugador.getLives()+1);
	}
	public void setUltimoBloqueEliminado(String ultimo) {
		ultimoBloqueEliminado=ultimo;
	}
	public String getUltimoBloqueEliminado() {
		return ultimoBloqueEliminado;
	}
	public void añadirBloque(Bloque o) {
		System.out.println("hola");
		bloques.add(o);
	}
	public void salvar(File file) throws ArkapoobException{
		arkaDAO.salvar(this,file);
	}
	public Arkapoob abrir(File file) throws ArkapoobException{
		return arkaDAO.abrir(file);
	}
}
