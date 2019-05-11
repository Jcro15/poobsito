package aplicacion;

import java.awt.geom.Rectangle2D;
/**deja la bola pegada a ella cuando esta colisiona , solo dura 3 turnos
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class PlataformaPegajosa extends Plataforma {
	private boolean bolaAtrapada;
	private Bola bola;
	public PlataformaPegajosa(double x, double y) {
		super(x, y);
		uses=3;
		bolaAtrapada=false;
	}
	public PlataformaPegajosa(double x,double y,int height,int width) {
		super(x, y,  height, width);
		uses=3;
		bolaAtrapada=false;
	}
	@Override
	/**deja la bola pegada a la plataforma cuando esta colisiona
	 * @param b la bola que colisiona con la plataforma
	 */
	public void reactToCollision(Bola b) {
		bolaAtrapada=true;
		bola=b;
		bola.setDx(Bola.V0);
		bola.setDy(Bola.V0);
	}
	/**
	 * dispara la bola con la velocidad que tenia inicialmente y en la direccion que indique su posicion en la plataforma
	 */
	public void usarHabilidad() {
		if(bolaAtrapada) {
			uses-=1;
			super.reactToCollision(bola);
			bola.move();
			bola=null;
			bolaAtrapada=false;
		}
	}
	@Override
	/**
	 *ordena a la bola que se mueva a la derecha junto con la plataforma
	 */
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
	@Override
	/**
	 *ordena a la bola que se mueva a la izquierda junto con la plataforma
	 */
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
	/**
	 * disoara la bola si esta se encuentra pegada al momento de chocar con otra plataforma
	 */
	public void reactToCollision(Plataforma platform) {
		usarHabilidad();
		super.reactToCollision(platform);
	}
	
}
