package aplicacion;
import java.util.*;
import java.io.*;

/**
 * Representa un generador de niveles
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class Nivel implements Serializable{
	/**
	 * crea un nuevo generador
	 */
	public Nivel() {
	}
	/**
	 * genera una nueva configuracion aleatoria de bloques
	 * @return un arreglo de bloques aleatorios
	 */
	public ArrayList<Bloque>  generarNivel() {
		Arkapoob tablero=Arkapoob.demeTablero();
		ArrayList<Bloque> bloques=new ArrayList<Bloque>();
		for (int j =100;j<225;j+=25) {
			for (int i =0;i<tablero.getMaxX();i+=45) {
				Random random =new Random();
				
				Bloque b =generarBloque(i,j,random.nextInt(100));
				
				if(b!=null) {
					bloques.add(b);
				}
			}
		}
		return bloques;
	}
	/**
	 * genera un bloque aleatorio en una posicion i,j a partir de un numero aleatorio
	 * @param i la posicion X que tendra el bloque
	 * @param j la posicion Y que tendra el bloque
	 * @param valor un numero aleatorio usado para determinar que bloque crear
	 * @return un bloque aleatorio entre los distintos tipos de bloques
	 */
	public Bloque generarBloque(int i ,int j, int valor){
		Bloque b=null;
		if (valor<5) b= new BloqueVida(i,j);
		else if (valor>4&&valor<10)b=new BloqueNivel(i,j);
		else if(valor>9&&valor<20)b=new BloqueCamaleon(i,j);
		else if(valor>19&&valor<30)b=new BloqueSorpresa(i,j);
		else if(valor>29&&valor<40)b= new BloqueIndestructible(i,j);
		else if(valor>39&&valor<50)b=new BloqueEscurridizo(i,j);
		else if(valor >49&& valor<60)b=null;
		else if(valor>59&&valor<80)b=new Bloque(i,j);
		else if(valor>79&&valor<100)b=new BloqueResistente(i,j);
		return b;
	}
}
