package aplicacion;


public class ArkapoobException extends Exception{
	public static final String TIPO_DE_ARCHIVO_INCORRECTO = " El tipo de archivo es incorrecto";
	public ArkapoobException(String mensaje){
		super(mensaje);
	}
}