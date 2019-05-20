package aplicacion;

public class CpuMimo extends Jugador {
	private double ultimoXJugador;
	public CpuMimo(int x, int y) {
		super(x, y);
		Arkapoob tablero=Arkapoob.demeTablero();
		ultimoXJugador=tablero.getJugador(0).getPlatform().getX();
	}
	public void moverPlataforma() {
		comprobarUsos();
		Arkapoob tablero=Arkapoob.demeTablero();
		double actualXJugador=tablero.getJugador(0).getPlatform().getX();
		if(actualXJugador-ultimoXJugador>0) {
			platform.setDx(Plataforma.DERECHA);
			platform.move();
			platform.setDx(Plataforma.QUIETO);
		}
		else if(actualXJugador-ultimoXJugador<0) {
			platform.setDx(Plataforma.IZQUIERDA);
			platform.move();
			platform.setDx(Plataforma.QUIETO);
		}
		ultimoXJugador=actualXJugador;
	}
}
