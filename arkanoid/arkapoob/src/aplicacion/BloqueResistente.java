package aplicacion;
import java.awt.*;
import java.awt.geom.RectangularShape;

public class BloqueResistente extends Bloque {

	public BloqueResistente(int x, int y) {
		super(x, y);
		resistance=2;
		color=Color.GREEN;
		puntaje=200;
	}
	public void reactToColission(Bola bola) {
		color=Color.RED;
		super.reactToColission(bola);
	}
}
