package persistencia;

import java.io.*;
import java.lang.reflect.*;
import aplicacion.*;
import presentacion.*;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class ArkapoobDAO{
	public static String nombre="arkapoob";
	public ArkapoobDAO(){}
	
	public void salvar(Arkapoob arka, File file) throws ArkapoobException{
		if (!file.getName().endsWith(".dat")) throw new ArkapoobException(ArkapoobException.TIPO_DE_ARCHIVO_INCORRECTO);
		
		try{
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(arka);
			out.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			registre(e);
			throw new ArkapoobException("Ocurrio un error al salvar " + file.getName());
		}
	}
	
	public Arkapoob abrir(File file) throws ArkapoobException{
		if (!file.getName().endsWith(".dat")) throw new ArkapoobException(ArkapoobException.TIPO_DE_ARCHIVO_INCORRECTO);
		Arkapoob arka = null;
		Arkapoob arka1= null;
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			arka = (Arkapoob) in.readObject(); 
			Arkapoob.cambiarTablero(arka);
			arka1 = arka.demeTablero();
			in.close();
		}
		catch(ClassNotFoundException e) {
			throw new ArkapoobException("Ocurrio un error al encontrar la clase");
		}catch (IOException e) {
			throw new ArkapoobException("Ocurrio un error al abrir el archivo " + file.getName());
		}
		return arka1;
	}
	

    
    public static void registre(Exception e){
        try{
            Logger logger=Logger.getLogger(nombre);
            logger.setUseParentHandlers(false);
            FileHandler file=new FileHandler(nombre+".log",true);
            file.setFormatter(new SimpleFormatter());
            logger.addHandler(file);
            logger.log(Level.SEVERE,e.toString(),e);
            file.close();
        }catch (Exception oe){
            oe.printStackTrace();
            System.exit(0);
        }
    }
	
	public void setPantalla(File file)throws ArkapoobException{
		if (!file.getName().endsWith(".txt")) throw new ArkapoobException(ArkapoobException.TIPO_DE_ARCHIVO_INCORRECTO);
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String l = in.readLine();
			int Line = 1;
			pantallaJuego p = null;
			if(l==null) {
				in.close();
				throw new ArkapoobException("el archivo se encuentra vacio");
			}
			while(l!=null){
				String[] lis = l.split(" ");
				
				if (lis.length==3){
					if(!lis[2].equals("Verde")&&!lis[2].equals("Azul")&&!lis[2].equals("Amarillo")&&!lis[2].equals("Rojo")){
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[2]+" no es un color valido.");
					}
					try{
						Integer.parseInt(lis[0]);
					}
					catch(NumberFormatException e){
						in.close();
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[0]+" no es un entero.");
					}
				    p= new pantallaJuego(Integer.parseInt(lis[0]),lis[1],lis[2]);
					p.setVisible(true);
				}
				else if(lis.length==6) {
					if(!lis[2].equals("Verde")&&!lis[2].equals("Azul")&&!lis[2].equals("Amarillo")&&!lis[2].equals("Rojo")){
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[2]+" no es un color valido.");
					}
					if(!lis[4].equals("Verde")&&!lis[4].equals("Azul")&&!lis[4].equals("Amarillo")&&!lis[4].equals("Rojo")){
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[4]+" no es un color valido.");
					}
					try{
						Integer.parseInt(lis[0]);
					}
					catch(NumberFormatException e){
						in.close();
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[0]+" no es un entero.");
					}
					try{
						Boolean.parseBoolean(lis[5]);
					}
					
					catch(Exception e){
						in.close();
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[5]+" no es un booleano.");
					}
					p= new pantallaJuego(Integer.parseInt(lis[0]),lis[1],lis[2],lis[3],lis[4],Boolean.parseBoolean(lis[5]));
					p.setVisible(true);
					
				}
				else if(lis.length==7){
					if(!lis[2].equals("Verde")&&!lis[2].equals("Azul")&&!lis[2].equals("Amarillo")&&!lis[2].equals("Rojo")){
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[2]+" no es un color valido.");
					}
					if(!lis[4].equals("Verde")&&!lis[4].equals("Azul")&&!lis[4].equals("Amarillo")&&!lis[4].equals("Rojo")){
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[4]+" no es un color valido.");
					}
					if(!lis[3].equals("Curioso")&&!lis[3].equals("Destructor")&&!lis[3].equals("Mimo")){
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[3]+" no es un color valido.");
					}
					try{
						Integer.parseInt(lis[0]);
					}
					catch(NumberFormatException e){
						in.close();
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[1]+" no es un entero.");
					}
					try{
						Boolean.parseBoolean(lis[5]);
					}
					catch(Exception e){
						in.close();
						throw new ArkapoobException("Error en la linea "+Line+": el dato "+lis[5]+" no es un booleano.");
					}
					p=new pantallaJuego(Integer.parseInt(lis[0]),lis[1],lis[2],lis[3],lis[4],Boolean.parseBoolean(lis[5]),lis[6]);
					p.setVisible(true);
					
				}
				
				Line += 1;
				l = in.readLine();
			}
			in.close();

		}catch(IOException e ) {
			throw new ArkapoobException("Ocurrio un error al importar el archivo " + file.getName());
		}
	}
	
}