package aplicacion;

public class PoderCambioEspecial extends Poder {
	public PoderCambioEspecial(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.img="/resources/especial.png";
	}

	@Override
	public void reactToCollision(Jugador jugador) {
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaEspecial(p.getX(),p.getY(), tablero));
		tablero.removerPoder(this);


	}

}
