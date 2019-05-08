package aplicacion;

import java.awt.geom.Rectangle2D;

public class PlataformaPegajosa extends Plataforma {
	private boolean bolaAtrapada;
	private Bola bola;
	public PlataformaPegajosa(double x, double y, Arkapoob tablero) {
		super(x, y, tablero);
		uses=3;
		bolaAtrapada=false;
	}
	public PlataformaPegajosa(double x,double y,Arkapoob tablero,int height,int width) {
		super(x, y, tablero, height, width);
		uses=3;
		bolaAtrapada=false;
	}
	public void reactToCollision(Bola b) {
		bolaAtrapada=true;
		bola=b;
		bola.setDx(Bola.V0);
		bola.setDy(Bola.V0);
	}
	public void usarHabilidad() {
		if(bolaAtrapada) {
			uses-=1;
			super.reactToCollision(bola);
			bola.move();
			bola=null;
			bolaAtrapada=false;
		}
	}

	public void moveRight() {
		if(bolaAtrapada&&canMoveRight()) {
			double v=bola.getVelocity();
			bola.setDx(Bola.DERECHA);
			bola.setVelocity(velocity);
			bola.move();
			bola.setVelocity(v);
			bola.setDx(Bola.V0);
		}
		super.moveRight();
	}
	public void moveLeft() {
		if(bolaAtrapada&&canMoveLeft()) {
			double v=bola.getVelocity();
			bola.setDx(Bola.IZQUIERDA);
			bola.setVelocity(velocity);
			bola.move();
			bola.setVelocity(v);
			bola.setDx(Bola.V0);
		}
		super.moveLeft();
	}
	public void reactToCollision(Plataforma platform) {
		usarHabilidad();
		super.reactToCollision(platform);
	}
	
}
