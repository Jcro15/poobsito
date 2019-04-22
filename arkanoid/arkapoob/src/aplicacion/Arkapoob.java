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
		bola=new Bola(360 , 641);//temporal
		bloques=new ArrayList<Bloque>();
		jugador=new Jugador(); // no recibe nombre
		for (int j =100;j<225;j+=25) {
			for (int i =0;i<maxX;i+=45) {
				bloques.add(new Bloque(i,j));
			}
		}
			
	}
	public boolean isGameOver() {
		return jugador.getLives()==0;
	}
	public boolean playerWin() {
		return bloques.size()==0;
	}
	public Bola getBola(){
		return bola;
	}
	public ArrayList<Bloque> getBloques() {
		return bloques;
	}
	public void moverBola() {
		bolaEnBorde();
		colisionBloques();
		colisionJugador();
		bola.move();
	}
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
	private void bolaEnBorde() {
		if(bola.getX()>maxX||bola.getX()<0) {
			bola.setDx(bola.getDx()*-1);
		}
		else if(bola.getY()<0) {
			bola.setDy(bola.getDy()*-1);
		}
		else if(bola.getY()>maxY) {
			bola=new Bola(360 , 641);
			jugador.quitarVida();
		}
	}
	
	public int getPuntajeJugador() {
		return jugador.getScore();
	}
	public void moverPlataformaDerecha() {
		if (jugador.getPlatform().getX()+jugador.getPlatform().getWidth()<maxX) {
		jugador.moverPlataformaDerecha();
		}
	}
	public void moverPlataformaIzquierda() {
		if (jugador.getPlatform().getX()-1>0) {
			jugador.moverPlataformaIzquierda();
		}
	}
	public Jugador getJugador() {
		return jugador;
	}
	
}
