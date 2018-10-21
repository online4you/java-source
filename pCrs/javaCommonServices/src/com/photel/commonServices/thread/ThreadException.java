package com.photel.commonServices.thread;


/**
 * Excepci�n especifica para el {@link ThreadManager} 
 * @author Globalia
 *
 */
public class ThreadException extends Exception {

	/**
	 * Constructor principal
	 * @param codigoError C�digo de b�squeda del error en DB
	 * @param c Clase donde se produce la excepci�n
	 * @param metodo M�todo de la clase donde se produce la excepci�n
	 * @param obj Objeto VO que interviene en la excepci�n
	 * @param e La excepci�n creada
	 */
	public ThreadException(String codigoError, Class c, String metodo, Object obj, Exception e){
		super();
		//super("THREAD", c, metodo, obj, e, codigoError);
	}
	
	/**
	 * Constructor principal
	 * @param codigoError C�digo de b�squeda del error en DB
	 * @param c Clase donde se produce la excepci�n
	 * @param metodo M�todo de la clase donde se produce la excepci�n
	 * @param obj Objeto VO que interviene en la excepci�n
	 * @param e La excepci�n creada
	 * @param idUsuarioMaquina
	 * @param tipoProducto
	 */
	public ThreadException(String codigoError, Class c, String metodo, Object obj, Exception e,String idUsuarioMaquina,String tipoProducto){
		super();
		//super("THREAD", c, metodo, obj, e, codigoError,idUsuarioMaquina,tipoProducto);
	}

}
