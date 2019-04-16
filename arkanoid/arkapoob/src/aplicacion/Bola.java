package aplicacion;
import java.awt.geom.*;

public class Bola {
	private int xPosition;
	private int yPosition;
	private Ellipse2D.Double shape;

	public Bola(int x ,int y) {
		xPosition=x;
		yPosition=y;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
	}
	public Ellipse2D.Double getShape(){
		return shape;
	}
	public int getX() {
		return xPosition;
	}
	public int getY() {
		return yPosition;
	}
	public void goTo(int x,int y) {
		xPosition=x;
		yPosition=y;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
	}
}
