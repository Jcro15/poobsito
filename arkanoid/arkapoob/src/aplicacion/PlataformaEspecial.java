package aplicacion;

import java.awt.geom.Rectangle2D;

public class PlataformaEspecial extends Plataforma {

	public PlataformaEspecial(double x,double y) {
		super(x, y);
	}
	public PlataformaEspecial(double x,double y,int height,int width) {
		super(x, y,  height, width);
	}
	public void moveRight() {
		super.moveLeft();
	}
	public void moveLeft() {
		super.moveRight();
	}
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
