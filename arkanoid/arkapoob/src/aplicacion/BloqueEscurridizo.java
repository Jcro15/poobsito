package aplicacion;

import java.awt.*;

public class BloqueEscurridizo extends Bloque {

	public BloqueEscurridizo(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=new Color(243,102,15);
		puntaje=500;
	}
	public void reactToColission(Bola bola) {
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

