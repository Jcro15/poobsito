package aplicacion;
import java.awt.TexturePaint;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PoderDisminuirVelocidad extends Poder {

	public PoderDisminuirVelocidad(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
	}
	public  void reactToCollision(Plataforma plataforma) {
		tablero.getBola().disminuirVelocidad();
		tablero.removerPoder(this);
	}
	
	public void putImg(Graphics2D g2){
		BufferedImage img = null;
		URL ruta=getClass().getResource("/resources/resta1.png");
		try{
			img=ImageIO.read(ruta);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		Rectangle2D r1=new Rectangle2D.Double(getX(),getY(),getShape().getWidth(),getShape().getHeight());
		TexturePaint tp =new TexturePaint(img,r1);
		g2.setPaint(tp);
		g2.fill(getShape());
	}

}
