package com.pRemote.commonServices.util;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLStreamUtil {

	/**
	 * XStream general
	 */
	private static XStream _xstream = null;
	
	/**
	 * XStream especifico para tipo BDL
	 */
	private static XStream _xstream_BDL = null;

	/**
	 * Obtiene el XStream para un tipo
	 * @param tipo
	 * @return
	 */
	public static synchronized XStream getXStream(String tipo) {
		if (tipo==null){
			if (_xstream == null) {
				createXStream();		
			}			
			return _xstream;
		}
		
		return null;
	}

	/**
	 * Crea el obteto XStream
	 */
	private static synchronized void createXStream() {		
		_xstream = new XStream(new DomDriver());
	}

	
	/**
	 * Convierte un objero a xml
	 * @param tipo
	 * @param obj
	 * @return
	 */
	public static String xmlSaveObject (String tipo,Object obj) {
		XStream xstream = getXStream(tipo);

		String objectXML = xstream.toXML (obj);
		return objectXML;

	}
	/**
	 * Convierte un objeto a xml
	 * @param obj
	 * @return
	 */
	public static String xmlSaveObject (Object obj) {		
		return xmlSaveObject(null,obj);
	}


	/**
	 * Convierte un xml a un objeto
	 * @param tipo
	 * @param xml
	 * @return
	 */
	public static Object xmlLoadObject (String tipo,String xml) {
		XStream xstream = getXStream(tipo);
		Object obj = xstream.fromXML (xml);
		return obj;
	}
	
	/**
	 * Convierte un xml a un objeto
	 * @param xml
	 * @return
	 */
	public static Object xmlLoadObject (String xml) {
		XStream xstream = getXStream(null);
		Object obj = xstream.fromXML (xml);
		return obj;

	}

}
