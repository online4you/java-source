package com.pRemote.commonServices.util;



import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;





public class JaxbUtil {

	/**
	 * Deserializa un xml a uno/varios objeto/s java
	 * @param jaxbContext (Creado con el fichero donde se encuentre el ObjectFactory)
	 * @param xml
	 * @return objeto relleno con la informacion del xml
	 */
	public static Object xmlToObject(JAXBContext jaxbContext,String xml){
		
		Unmarshaller u;
		Object objeto =null;
		try {
			u = jaxbContext.createUnmarshaller();
			objeto = u.unmarshal(new StringReader(xml) );
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		               
		
		return objeto;
		
	}
	/**
	 * Serializa un objeto a un xml
	 * @param jaxbContext (Creado con el fichero donde se encuentre el ObjectFactory)
	 * @param Objeto a serializar
	 * @return xml (String)
	 */
	public static String objectToXml(JAXBContext jaxbContext,Object objeto){
		StringWriter out=new StringWriter();
        Marshaller formateador;
		try {
			formateador = jaxbContext.createMarshaller();
			formateador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			formateador.marshal(objeto,out);		
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}			
        return out.toString();		
	}

	
}
