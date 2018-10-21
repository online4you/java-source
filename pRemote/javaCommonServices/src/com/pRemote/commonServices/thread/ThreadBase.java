package com.pRemote.commonServices.thread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;



/**
 * Hilo Base que es controlado por {@link ThreadManager}, para su creaci�n necesita:
 * <ul>
 * <li>Objeto: Objeto que contiene el metodo a ejecutar</li>
 * <li>Metodo: M�todo a ejecutar</li>
 * <li>Par�metros: Par�metros necesarios para ejecutar el m�todo</li>
 * <li>Timeout: Tiempo de vida del hilo</li>
 * </ul>
 * 
 * @author Globalia
 */
public class ThreadBase extends Thread {

	private Object objeto;
	private Method metodo;
	private Object returnedValue;
	private Object[] parametros;
	private long timeout;
	private Date fechaCreacion = null;
	
	/**
	 * Constructor
	 * 
	 * @param objeto Objeto que contiene el metodo a ejecutar
	 * @param metodo M�todo a ejecutar
	 * @param parametros Par�metros necesarios para ejecutar el m�todo
	 * @param timeout Tiempo de vida del hilo
	 */
	public ThreadBase(Object objeto, Method metodo, Object[] parametros, long timeout) {
		this.objeto = objeto;
		this.metodo = metodo;
		this.parametros = parametros;
		this.timeout = timeout;
		this.fechaCreacion = new Date();
	}

	/**
	 * Fecha de creaci�n del hilo
	 * 
	 * @return
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	@Override
	public void run() {
		try {			
			returnedValue=metodo.invoke(objeto, parametros);
		}
		catch (InvocationTargetException ite) {
			String strParametros = "";
			for (int i=0;i<parametros.length; i++){
				strParametros = strParametros + parametros[i].toString();
			}
			Throwable cause = ite.getTargetException();
			//ErrorManager.registarError("ThreadBase ERROR HILO: " + objeto.getClass().getName(), cause.getMessage(), strParametros);			
		}
		catch (Exception e) {
			String strParametros = "";
			for (int i=0;i<parametros.length; i++){
				strParametros = strParametros + parametros[i].toString();
			}
			//ErrorManager.registarError("ThreadBase ERROR HILO: " + objeto.getClass().getName(), e.getMessage(), strParametros);			
		}
	}

	/**
	 * Tiempo de vida del hilo
	 * 
	 * @return
	 */
	public long getTimeout() {
		return timeout;
	}

	public Object getReturnedValue() {
		return returnedValue;
	}
	

}
