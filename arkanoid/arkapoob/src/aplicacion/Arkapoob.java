package aplicacion;

import java.util.ArrayList;

public class Arkapoob {
	private Bola bola;
	private Jugador jugador;
	private ArrayList<Bloque> bloques;
	private int maxX;
	private int maxY;
	
	public Arkapoob(int maxX ,int maxY) {
		this.maxX=maxX;
		this.maxY=maxY;
		bola=new Bola(400 , 450);//temporal
		bloques=new ArrayList<Bloque>();
		for (int i =0;i<maxX;i+=45) {
			bloques.add(new Bloque(i,300));
		}
			
	}
	public Bola getBola(){
		return bola;
	}
	public ArrayList<Bloque> getBloques() {
		return bloques;
	}
	public void moverBola() {
		bolaEnBorde();
		colisionBloques();
		bola.move();
	}
	
	private void colisionBloques() {
		for(int j=0;j<bloques.size();j++) {
			Bloque b=bloques.get(j);
			if(bola.getShape().intersects(b.getX(), b.getY(), b.getWidth(), 1)||
					bola.getShape().intersects(b.getX(), b.getY()+b.getHeight()-1, b.getWidth(), 2)) {
				bola.invertYComponent();
				bloques.remove(j);
			}
			else if(bola.getShape().intersects(b.getX(), b.getY(), 2, b.getHeight() )||
					bola.getShape().intersects(b.getX()+b.getWidth()-1, b.getY(), 2, b.getHeight())) {
				bola.invertXComponent();
				bloques.remove(j);
			}
		}
		
	}
	private void bolaEnBorde() {
		if(bola.getX()>maxX||bola.getX()<0) {
			bola.invertXComponent();
		}
		else if(bola.getY()<0||bola.getY()>maxY) {
			bola.invertYComponent();
		}
	}
	
}
