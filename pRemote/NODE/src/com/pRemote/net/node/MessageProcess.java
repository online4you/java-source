package com.pRemote.net.node;

/*
 * @(#)GestionaConnexio.java
 *
 */
import gnu.io.CommPortIdentifier;

import java.io.BufferedReader;
import com.pRemote.usb.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Enumeration;
/**
 * Aquesta classe és el fil creat per a cada client que demani una url.
 * Fa ús de GetPaginaWeb per a servir el recurs http en format de text.
 *
 * @author	Guillem Puigròs Gómez
 * @version	1 08/10/2005
 * @see		Servidor
 * @see		GestionaConnexió
 * @see		GetPaginaWeb
 */
public class MessageProcess extends Thread { 
	private Socket s;
	private static SerialUSBComm serial;
    /**
     * Métode constructor
     * @throws Exception 
      */		
	public MessageProcess(Socket s) throws Exception { 
		this.s = s; 
		if (serial==null){
			Enumeration portList = CommPortIdentifier.getPortIdentifiers();
			while (portList.hasMoreElements()) {
		    	System.out.println("PortList");
		    	CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
		    	System.out.println("Type: " + portId.getPortType());
		    	System.out.println("Name: " + portId.getName());
		    }
			serial= new SerialUSBComm("/dev/ttyACM0",9600);
		}
	}
    /**
     * Métode que gestiona la connexió del client.
     * Crea un objecte de tipus GetPaginaWeb per tal de crear un 
     * socket client que sol·licitarà la url
     */	
 	public void run() { 
 		BufferedReader in = null;
 		PrintStream out = null;
 		String message;
 		String retron=null;
 		// Gestiona la connesió
 		try {
 			//in serà el canal d'entrada
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
			//out serà el canal de sortida
        out = new PrintStream(s.getOutputStream());

			//Legim la url sol·licitada
        message=in.readLine();
        	
        	try {
	        	System.out.println("Gestionant peticio ["+message+"] de: " + s.getRemoteSocketAddress());
	        	String data=message.split("##")[2].split("_")[1];
	        	if(data.equals("ON")){
	        		data="1";
	        	}else if(data.equals("OFF")){
	        		data="0";
	        	}else if(data.equals("BLINK")){
	        		data="2";
	        	}
	        	retron="ini\n";
	        	retron=retron+serial.sendDataToDevice(data);
	        	//Enviem el resultat
	    		out.println(retron.toString());
	    			//Esperem que el client faci la lectura i tanquem el socket que s'havia creat a partir de ss.accept()
	    		out.println("__EOF__");
	    		System.out.println("Enviant resultat de ["+message+"] a : " + s.getRemoteSocketAddress());
	    		message=in.readLine();
	    		s.close();
	        }catch  (Exception e) {out.println("No ha estat possible recuperar el recurs sol·licitat");}
	 	} catch (Exception e) {}
	} 
}