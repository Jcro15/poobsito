package aplicacion;

import java.util.ArrayList;

public class Arkapoob {
	private Bola bola;
	private Jugador jugador;
	private ArrayList<Bloque> bloques;
	private int maxX;
	private int maxY;
	
	public Arkapoob(int maxX ,int maxY) {
		this.maxX=maxX;
		this.maxY=maxY;
		bloques=new ArrayList<Bloque>();
		jugador=new Jugador(); 
		bola=new Bola(jugador.getPlatform().getX()+jugador.getPlatform().getWidth()/2 , jugador.getPlatform().getY()-10);
		for (int j =100;j<225;j+=25) {
			for (int i =0;i<maxX;i+=45) {
				bloques.add(new Bloque(i,j));
			}
		}
			
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
		return bloques.size()==0;
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
		bolaEnBorde();
		colisionBloques();
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
	/**
	 * detecta si la bola se colisiona con alguno de los bloques y si es asi cambia la direccion de la bola
	 * y hace daño al edificio, si el edificio es destruido se remueve de la lista de bloques
	 */
	private void colisionBloques() {
		for(int j=0;j<bloques.size();j++) {
			Bloque b=bloques.get(j);
			if(b.collision(bola.getShape())) {
				b.reduceResistance(bola.getDamage());
				if(b.verticalCollision(bola.getShape())) {
					bola.setDy(bola.getDy()*-1);
				}
				else{
					bola.setDx(bola.getDx()*-1);
				}
				if (b.destroyed()) {
					bloques.remove(j);
					jugador.sumarPuntos(b.getPuntaje());
				}
				break;
			}
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
			bola.setDy(bola.getDy()*-1);
		}
		else if(bola.getY()>maxY) {
			bola=new Bola(jugador.getPlatform().getX()+jugador.getPlatform().getWidth()/2 , jugador.getPlatform().getY()-10);
			jugador.quitarVida();
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
		if (jugador.getPlatform().getX()+jugador.getPlatform().getWidth()<maxX) {
		jugador.moverPlataformaDerecha();
		}
	}
	/**
	 * mueve al jugador a la izquierda  si es posible
	 */
	public void moverPlataformaIzquierda() {
		if (jugador.getPlatform().getX()-1>0) {
			jugador.moverPlataformaIzquierda();
		}
	}
	/**
	 *  
	 * @return el jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}
	
}
