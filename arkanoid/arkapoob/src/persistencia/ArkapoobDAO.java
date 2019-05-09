package persistencia;

import java.io.*;
import java.lang.reflect.*;
import aplicacion.*;
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
			throw new ArkapoobException("Ocurrio un error al salvar " + file.getName());
		}
	}
	
	public Arkapoob abrir(File file) throws ArkapoobException{
		if (!file.getName().endsWith(".dat")) throw new ArkapoobException(ArkapoobException.TIPO_DE_ARCHIVO_INCORRECTO);
		Arkapoob arka = null;
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			arka = (Arkapoob) in.readObject();
			in.close();
		}
		catch(ClassNotFoundException e) {
			throw new ArkapoobException("Ocurrio un error al encontrar la clase");
		}catch (IOException e) {
			throw new ArkapoobException("Ocurrio un error al abrir el archivo " + file.getName());
		}
		return arka;
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
	
}