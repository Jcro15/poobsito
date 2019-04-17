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
		bola=new Bola(500 , 500);//temporal
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
		for(Bloque i:bloques) {
			System.out.println(bola.getY());
			System.out.println(bola.getShape().intersects(i.getX(), i.getY(), i.getWidth(), 2));
			
			if(bola.getShape().intersects(i.getX(), i.getY(), i.getWidth(), 1)||
					bola.getShape().intersects(i.getX(), i.getY()+i.getHeight()-1, i.getWidth(), 2)) {
				bola.invertYComponent();
			}
			else if(bola.getShape().intersects(i.getX(), i.getY(), 2, i.getHeight() )||
					bola.getShape().intersects(i.getX()+i.getWidth()-1, i.getY(), 2, i.getHeight())) {
				bola.invertXComponent();
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
