package aplicacion;
import java.awt.geom.*;

public class Bola {
	private int xPosition;
	private int yPosition;
	private int dx;
	private int dy;
	private int velocity;
	private Ellipse2D.Double shape;

	public Bola(int x ,int y, int velocity) {
		xPosition=x;
		yPosition=y;
		shape=new Ellipse2D.Double(xPosition,yPosition,20,20);
		dx=1;
		dy=-1;
		this.velocity=velocity;
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
	public void move() {
		xPosition+=(dx*velocity);
		yPosition+=(dy*velocity);
		shape=new Ellipse2D.Double(xPosition,yPosition,20,20);
	}
	public void outOfHorizontal (int maxX) {
		boolean out=false;
		if(xPosition<0||xPosition>maxX) {
			dx=-dx;
			out=true;
		}
	//	return out;
	}
	public void outOfVertical (int maxY) {
		boolean out=false;
		if(yPosition<0||yPosition>maxY) {
			dy=-dy;
			out=true;
		}
		//return out;
	}
	
}
