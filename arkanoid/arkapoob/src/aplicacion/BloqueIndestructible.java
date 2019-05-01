package aplicacion;

import java.awt.*;

public class BloqueIndestructible extends Bloque {

	public BloqueIndestructible(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=Color.GRAY;
		puntaje=0;
		destroyable=false;
	}
	public boolean destroyed() {
		return false;
	}
}
