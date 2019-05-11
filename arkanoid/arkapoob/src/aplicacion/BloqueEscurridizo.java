package aplicacion;

import java.awt.*;

public class BloqueEscurridizo extends Bloque {

	public BloqueEscurridizo( int x, int y) {
		super( x, y);
		color=new Color(243,102,15);
		puntaje=500;
	}
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

