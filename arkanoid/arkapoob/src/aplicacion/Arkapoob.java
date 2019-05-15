package aplicacion;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import persistencia.*;

public class Arkapoob implements Serializable{
	private Bola bola;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Bloque> bloques;
	private static final int maxX= 485; 
	private static final int maxY=665;
	private String ultimoBloqueEliminado;
	private static transient ArkapoobDAO arkaDAO;
	private static final long serialVersionUID = 8799656478674716638L;
	private ArrayList<Poder> poderes;
	private int nivel;
	private Nivel generador;
	private int ultimoJugador;
	private static Arkapoob tablero=null;
	private boolean usarCpu;
	private String tipo;
	private Timer arkaTimer;
	
	private Arkapoob()  {
		nivel=0;
		ultimoJugador=0;
		ultimoBloqueEliminado="";
		bloques=new ArrayList<Bloque>();
		generador=new Nivel();
		poderes=new ArrayList<Poder>();
		jugadores=new ArrayList<Jugador>();
		arkaDAO=new ArkapoobDAO();
		
		arkaTimer = new Timer(3, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//moverJugadores();
			}

		});
		arkaTimer.start();
	}
	
	/**
	 * retorna una referencia al tablero de juego 
	 * @return el tablero de juego
	 */
	public static Arkapoob demeTablero() {
        if (tablero==null){
            tablero=new Arkapoob();
        }
        return tablero;
    }
	/**
	 * crea un nuevo tablero de arkapoob
	 */
	public static void nuevoTablero() {
        tablero=new Arkapoob();
    }   
	/**
	 * determina si el jugador perdio la partida
	 * @return true si el numero de vidas de alguno de los  jugadores es  0 ;false si no
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
	 *determina si algun jugador gano la partida 
	 * @return true si el jugador ha superado todos los niveles ; false si no
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
	/**
	 * posiciona la bola sobre alguno de los jugadores y carga un nuevo nivel
	 */
	public void generarNuevoNivel() {
		setBall();
		bloques= generador.generarNivel();
		nivel+=1;
		poderes.clear();
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
	 * retorna la lista de poderes que estan activos en la partida
	 * @return la lista de poderes
	 */
	public ArrayList<Poder> getPoderes(){
		return poderes;
	}
	/**
	 * intenta mover los poderes,si algun poder se encuentra fuera del escenario se elimina de la lista
	 */
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
	 * intenta mover los elementos del juego y detectando si hay colisiones entre ellos 
	 */
	public void moverElementos() {
		
		colisionJugadorPoderes();
		moverPoderes();
		colisionBolaBloques();
		colisionJugador();
		bola.move();
	}
	/**
	 * detecta si alguno de los jugadores se colisiona con algun poder
	 */
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
	/**
	 * detecta si existe alguna colision entre un objeto del juego (representado por una forma geometrica RectangularShape) y algun bloque
	 * retorna el indice del bloque con el que se colisiona el objeto
	 * @param inShape la forma geometrica que representa al objeto con el que se quiere detectar la colision
	 * @return el indice del bloque que genera la colision con el objeto entrante
	 */
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
	 * posiciona la bola sobre la plataforma de alguno de los jugadores, la seleccion de jugador es aleatoria
	 */
	public void setBall() {
		Random random =new Random();
		int p =random.nextInt(jugadores.size());
		ultimoJugador=p;//temp
		Jugador jugador=jugadores.get(p);
		bola=new Bola(jugador.getPlatform().getX()+jugador.getPlatform().getWidth()/2 , jugador.getPlatform().getY()-10);
	}
		
	/**
	 * retorna el puntaje de alguno de los jugadores
	 * @param numeroJugador el indice del jugador en la lista de jugadores
	 * @return el puntaje del jugador seleccionado
	 */
	public int getPuntajeJugador(int numeroJugador) {
		return jugadores.get(numeroJugador).getScore();
	}
	/**
	 * detecta si existe una colision entre los jugadores de la partida
	 * @return true si existe una colision entre los jugadores; false si no
	 */
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
	/**
	 * 
	 * @return la maxima  coordenada x
	 */
	public int getMaxX() {
		return maxX;
	}
	/**
	 * 
	 * @return la maxima  coordenada y
	 */
	public int getMaxY() {
		return maxY;
	}
	/**
	 * elimina un bloque de la lista de bloques
	 * @param bloque el bloque que se desea eliminar
	 */
	public void remove(Bloque bloque) {
		bloques.remove(bloque);
	}
	/**
	 *suma puntos al ultimo jugador que hizo rebotar la bola en su plataforma 
	 * @param puntaje la cantidad de puntos que se le sumaran al jugador
	 * 
	 */
	public void sumarPuntosJugador(int puntaje) {
		jugadores.get(ultimoJugador).sumarPuntos(puntaje);
	}
	/**
	 * aumenta en uno las vidas de los jugadores 
	 */
	public void sumarVidaJugadores() {
		for(Jugador jugador:jugadores) {
			jugador.setVidas(jugador.getLives()+1);
	
		}
	}
	/**
	 * resta en uno las vidas de los jugadores 
	 */
	public void restarVidaJugadores() {
		for(Jugador jugador :jugadores) {
			jugador.setVidas(jugador.getLives()-1);
		}
	}
	/**
	 * guarda el nombre de la clase que representa al ultimo bloque eliminado en la partida
	 * @param ultimo
	 */
	public void setUltimoBloqueEliminado(String ultimo) {
		ultimoBloqueEliminado=ultimo;
	}
	/**
	 * retorna el nombre de la clase que representa al ultimo bloque eliminado en la partida
	 * @return el nombre de la clase que representa al ultimo bloque eliminado en la partida
	 */
	public String getUltimoBloqueEliminado() {
		return ultimoBloqueEliminado;
	}
	/**
	 * añade un bloque a la configuracion
	 * @param b el bloque se va a añadir
	 */
	public void anadirBloque(Bloque b) {
		bloques.add(b);
	}
	/**
	 * añade un poder a la lista de poderes activos 
	 * @param p el poder que se va a añadir
	 */
	public void anadirPoder(Poder p) {
		poderes.add(p);
	}
	/**
	 * salva una partida de arkapoob
	 * @param file el archivo que representa la partida
	 */
	public void salvar(File file) throws ArkapoobException{
		arkaDAO.salvar(this,file);
	}
	/**
	 * abre una partida de arkapoob
	 * @param file el archivo que representa la partida
	 * @return una partida de arkpoob
	 */
	public Arkapoob abrir(File file) throws ArkapoobException{
		return arkaDAO.abrir(file);
	}
	/**
	 * elimina un poder de la lista de poderes activos	
	 * @param poderel poder a eliminar
	 */
	public void removerPoder(Poder poder) {
		poderes.remove(poder);
	}
	/**
	 * ordena al jugador a usar la habilidad de su plataforma
	 * @param numeroJugador el indice del jugador que va a usar la habilidad
	 */
	public void usarHabilidadJugador(int numeroJugador) {
		jugadores.get(numeroJugador).usarHabilidadPlataforma();
	}
	/**
	 * retorna el numero de jugadores en la partida
	 * @return el numero de jugadores en la partida
	 */
	public int getNJugadores(){
		return jugadores.size();
	}
	/**
	 * añade un jugador a la partida
	 * @param jugador el jugador a añadir
	 */
	public void anadirJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	/**
	 * actualiza el tablero
	 * @param game game es el nuevo tablero
	 */
	public static void cambiarTablero(Arkapoob game){
		
		tablero=game;
	}
	
	public void setUsarCpu(boolean usarCpu){
		
		this.usarCpu=usarCpu;
	}
	
	public boolean getUsarCpu(){
		
		return usarCpu;
	}
	
	public void anadirMaquina(String tipo){
		
		anadirJugador(new Jugador(485-120,620));
	}
	
	public void setTipo(String tipo){
		
		this.tipo=tipo;
	}
	
	public String getTipo(){
		
		return tipo;
	}
	
	public void moverJugadores(){}
	
	public void pareTimers(){
		arkaTimer.stop();
	}
}
