package persistencia;

import java.io.*;
import java.lang.reflect.*;
import aplicacion.*;

public class ArkapoobDAO{
	public ArkapoobDAO(){}
	
	public void salvar(Arkapoob arka, File file) throws ArkapoobException{
		if (!file.getName().endsWith(".dat")) throw new ArkapoobException(ArkapoobException.TIPO_DE_ARCHIVO_INCORRECTO);
		
		try{
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(arka);
			out.close();
		}
		catch(IOException e){
			throw new ArkapoobException("Ocurrio un error al salvar " + file.getName());
		}
	}
	
	public Arkapoob abrir(File file) throws ArkapoobException{
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
	
}