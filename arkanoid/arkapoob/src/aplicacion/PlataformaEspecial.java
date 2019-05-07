package aplicacion;

import java.awt.geom.Rectangle2D;

public class PlataformaEspecial extends Plataforma {

	public PlataformaEspecial(double x,double y,Arkapoob tablero) {
		super(x, y,tablero);
	}
	public PlataformaEspecial(double x,double y,Arkapoob tablero,int height,int width) {
		super(x, y, tablero, height, width);
	}
	public void moveRight() {
		super.moveLeft();
	}
	public void moveLeft() {
		super.moveRight();
	}
}
