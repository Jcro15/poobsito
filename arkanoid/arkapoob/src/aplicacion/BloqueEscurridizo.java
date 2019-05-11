package aplicacion;

import java.awt.*;
/**
 * representa un bloque que tiene la habilidad de esquivar la bola moviendose hacia arriba 
 * @author @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class BloqueEscurridizo extends Bloque {

	public BloqueEscurridizo( int x, int y) {
		super( x, y);
		color=new Color(243,102,15);
		puntaje=500;
	}
	@Override
	/**
	 * detecta si tiene espacio para moverse, si lo tiene se mueve hacia arriba para esquivar la bola ,sino es destruido
	 * @param bola la bola que genera la colision
	 */
	public void reactToColission(Bola bola) {
		Arkapoob tablero=Arkapoob.demeTablero();
		Rectangle move=new Rectangle(xPosition,yPosition-height,width,height);
		boolean colisionAbajo=verticalCollision(bola.getShape())&&bola.getShape().getMaxY()>yPosition+height;
		if (tablero.colisionBloques(move)==null&&yPosition-height>0&&colisionAbajo) {
			shape=move;
			yPosition-=height;
		}
		else {
			super.reactToColission(bola);
		}
	}
}

