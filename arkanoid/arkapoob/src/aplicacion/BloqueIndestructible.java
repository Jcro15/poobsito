package aplicacion;

import java.awt.*;
/**
* representa un bloque que no puede ser  destruido
* @author @author Juan Camilo Rojas & Juan Camilo Angel
*
*/
public class BloqueIndestructible extends Bloque {

	public BloqueIndestructible( int x, int y) {
		super( x, y);
		color=Color.GRAY;
		puntaje=0;
		destroyable=false;
	}
	/**
	 * @return false ,puesto que no es posible destruirlo
	 */
	public boolean destroyed() {
		return false;
	}
}
