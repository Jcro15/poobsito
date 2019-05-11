package aplicacion;
import java.awt.*;
import java.awt.geom.RectangularShape;
/**
 * representa un bloque que resiste dos golpes
 * @author @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class BloqueResistente extends Bloque {

	public BloqueResistente(int x, int y) {
		super(x, y);
		resistance=2;
		color=Color.GREEN;
		puntaje=200;
	}
	@Override
	/**
	 * al recibir el primer golpe cambia de color
	 * @param bola la bola que genera la colision
	 */
	public void reactToColission(Bola bola) {
		color=Color.RED;
		super.reactToColission(bola);
	}
}
