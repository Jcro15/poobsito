package aplicacion;

import java.awt.geom.Rectangle2D;
/**
 * Representa una plataforma que se mueve de forma inversa a las ordenes del jugador
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class PlataformaEspecial extends Plataforma {

	public PlataformaEspecial(double x,double y) {
		super(x, y);
	}
	public PlataformaEspecial(double x,double y,int height,int width) {
		super(x, y,  height, width);
	}
	@Override
	/**
	 * mueve la plataforma a la izquierda
	 */
	public void moveRight() {
		super.moveLeft();
	}
	@Override
	/**
	 * mueve la plataforma a la derecha
	 */
	public void moveLeft() {
		super.moveRight();
	}
	@Override
	/**
	 * Describe el comportamiendo de la plataforma al colisionar con otra plataforma
	 * @param platform la plataforma con la que se genera la colision
	 */
	public void reactToCollision(Plataforma platform) {
		for(int i=0;i<25;i++) {
			if(collisionRight(platform.getShape())) {
				if(canMoveLeft()) super.moveLeft();
			}
			else {
				if(canMoveRight())super.moveRight();
			}
		}	
	}
}
