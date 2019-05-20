package aplicacion;

public class CpuDestructor extends Jugador {

	public CpuDestructor(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void moverPlataforma() {
		comprobarUsos();
		Arkapoob tablero= Arkapoob.demeTablero();
		Bola bola= tablero.getBola();
		if(bola.getX()>platform.getX()+(platform.getWidth()/2)+bola.getDx()) {
			platform.setDx(Plataforma.DERECHA);
			platform.move();
			platform.setDx(Plataforma.QUIETO);
		}
		else if(bola.getX()<platform.getX()+(platform.getWidth()/2)+bola.getDx()) {
			platform.setDx(Plataforma.IZQUIERDA);
			platform.move();
			platform.setDx(Plataforma.QUIETO);
		}
		
	}

}
