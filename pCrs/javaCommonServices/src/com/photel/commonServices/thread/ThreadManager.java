package com.photel.commonServices.thread;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Manager de gesti�n de hilos del tipo {@link ThreadBase}
 * Estos hilos se utilizan para lanzar un metodo concreto de un objeto concreto, que se pasan
 * en el momento de creaci�n del hilo (y son invocados por Reflexi�n) * 
 * @author Globalia
 *
 */
public class ThreadManager {


	/**
	 * Constructor del hilo
	 * @param nombreHilo Nombre del hilo
	 * @param objeto Objeto que contiene el metodo a ejecutar
	 * @param metodo M�todo a ejecutar
	 * @param tiposParametros Tipos de los par�metros necesarios para ejecutar el m�tido
	 * @param parametros Par�metros necesarios para ejecutar el m�todo
	 * @param timeout Tiempo de vida del hilo
	 * @return El hilo creado, arrancado.
	 * @throws ThreadException
	 */
	public static ThreadBase start(String nombreHilo, Object objeto, String metodo,
			Class[] tiposParametros, Object[] parametros, long timeout) throws ThreadException {

		Class[] tipos = new Class[tiposParametros.length];
		ThreadBase hilo = null;
		try {
			for (int i = 0; i < tiposParametros.length; i++) {
				tipos[i] = tiposParametros[i];
			}
			Method met = objeto.getClass().getMethod(metodo, tipos);
			hilo = new ThreadBase(objeto, met, parametros, timeout);
			hilo.setName(nombreHilo);
			hilo.start();
		}
		catch (Exception e) {
			throw new ThreadException("Fallo al crear el hilo ", ThreadManager.class, "start", metodo, e);
		}
		return hilo;
	}

	/**
	 * Para un {@link ThreadBase}
	 * @param hilo
	 */
	public static void stop(ThreadBase hilo) {
		try {
			hilo.join(1);
		}
		catch (InterruptedException e) {
		}
		hilo = null;
	}


	/**
	 * Espera para continuar a que terminen una lista de hilos. Si estos hilos no finalizan en el tiempo
	 * establecido (timeout), los hilos se paran manualmente.
	 * @param lista Lista con los hilos
	 * @throws ThreadException
	 */
	public static void esperarTerminacionHilos(List<ThreadBase> lista) throws ThreadException {
		int i = 0;
		ThreadBase hilo = null;

		try {
			if (lista!=null && lista.size()>0){
				//Cogemos el tiempo del primer hilo
				hilo = lista.get(i);		
				long creacion=hilo.getFechaCreacion().getTime();
				long ahora=new Date().getTime();			
				long transcurrido=ahora-creacion;			
				long tiempoRestante = hilo.getTimeout() - transcurrido;						
				while (tiempoRestante > 0 && i < lista.size()) {
					hilo = lista.get(i);
					ahora=new Date().getTime();
					transcurrido=ahora-creacion;
					tiempoRestante = hilo.getTimeout() - transcurrido;
					if (tiempoRestante>0){
						hilo.join(tiempoRestante);	
					}				
					i++;				
				}
	
				//Matamos todos los hilos				
				for (int j = 0; j < lista.size(); j++) {
					hilo = lista.get(j);
					stop(hilo);
				}
			}
		}
		catch (Exception e) {
			throw new ThreadException("Fallo al esperar la terminaci�n de los hilos", ThreadManager.class, "esperarTerminacionHilos", hilo, e);
		}

	}
}
