package aplicacion;


public class ArkapoobException extends Exception{
	public static final String TIPO_DE_ARCHIVO_INCORRECTO = " El tipo de archivo es incorrecto";
	public static final String NOMBRE_VACIO = "Por favor ingresa tu nombre";
	public ArkapoobException(String mensaje){
		super(mensaje);
	}
}