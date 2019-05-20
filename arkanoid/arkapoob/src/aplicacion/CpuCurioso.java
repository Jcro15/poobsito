package aplicacion;

public class CpuCurioso extends Jugador {

	public CpuCurioso(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void moverPlataforma() {
		comprobarUsos();
		double minDelta=999999;
		int x=0;
		for(Poder poder:Arkapoob.demeTablero().getPoderes()) {
			if(Math.abs((platform.getX()+platform.getWidth()/2)-poder.getX())<minDelta) {
				x=poder.getX();
			}
		}
		if(x!=0) {
			if (x<(platform.getX()+platform.getWidth()/2))platform.moveLeft();
			else if(x>(platform.getX()+platform.getWidth()/2))platform.moveRight();
		}
	}
}
