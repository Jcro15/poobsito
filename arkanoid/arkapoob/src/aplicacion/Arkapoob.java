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
		bola=new Bola(300 , 600);//temporal
		bloques=new ArrayList<Bloque>();
		jugador=new Jugador("assd");
		for (int i =0;i<maxX;i+=45) {
			bloques.add(new Bloque(i,300));
		}
			
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
		if(jugador.collisionRight(bola.getShape())) {
			bola.setRight();
			bola.invertYComponent();
		}
		else if(jugador.collisionLeft(bola.getShape())) {
			bola.setLeft();
			bola.invertYComponent();
		}
	}
	private void colisionBloques() {
		for(int j=0;j<bloques.size();j++) {
			Bloque b=bloques.get(j);
			if(b.collision(bola.getShape())) {
				if(b.verticalCollision(bola.getShape())) {
					bola.invertYComponent();
				}
				else if(b.horizontalCollision(bola.getShape())) {
					bola.invertXComponent();
				}
				b.reduceResistance(bola.getDamage());
				if (b.destroyed())bloques.remove(j);
			}
		}
		
	}
	private void bolaEnBorde() {
		if(bola.getX()>maxX||bola.getX()<0) {
			bola.invertXComponent();
		}
		else if(bola.getY()<0||bola.getY()>maxY) {
			bola.invertYComponent();
		}
	}

	public void moverPlataformaDerecha() {
		
		jugador.moverPlataformaDerecha();
	}
	public void moverPlataformaIzquierda() {
		jugador.moverPlataformaIzquierda();
	}
	public Jugador getJugador() {
		return jugador;
	}
	
}
