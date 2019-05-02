package aplicacion;
import java.awt.*;
import java.awt.geom.RectangularShape;

public class BloqueResistente extends Bloque {

	public BloqueResistente(Arkapoob tablero,int x, int y) {
		super(tablero,x, y);
		resistance=2;
		color=Color.GREEN;
		puntaje=200;
	}
	public void reactToColission(Bola bola) {
		color=Color.RED;
		super.reactToColission(bola);
	}
}
