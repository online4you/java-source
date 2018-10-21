package com.pRemote.net;


/*
 * @(#)Servidor
 *
 */
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Aquesta classe es connecta amb un servidor que escolta en el port 8080
 * Es fan peticions a recursos web i es retorna el resultat en format texte
 *
 * @author	Guillem Puigròs Gómez
 * @version	1 08/10/2005
 * @see		Client
 * @see		Servidor
 * @see		GestionaConnexió
 * @see		GetPaginaWeb
 */
public class OutGoing {

    /**
     * Únic métode de la classe que sol·licita recursos a mostrar
     */
	public static void main(String args[]) {

	BufferedReader in = null;
	PrintStream out = null;
	Socket s = null;
	char getChar;
	String getStr;
	String getLine;
	int port=80;
	
	String remoteHost="localhost";
	remoteHost="37.152.91.12";
	

	try {
		//Porvocarà una exepcio si el paràmetre no és un nombre
		getChar=1;
			while (true){
				System.out.println("[device_node_systemFrom##device_node_systemTo##messageType_Operation##time##validUntill]");
				System.out.println("Exemple:");
				System.out.println("[0001_0001_0001##0000_0000_0001##ONOFF_ON##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000]");
				System.out.println("Cadena:");
				
				//Es crea un nou socket amb [args[0]] per port [port]
	    		try{s = new Socket(remoteHost, port);}
	    		catch (Exception e) { 
	    			System.out.println("No ha estat possible fer la connexió\nComprovi que el servidor está funcionant i que la IP es correcta i el port es 8080");
	    			System.exit(1);}
	
		        //in serà el canal d'entrada
	    		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    		//out serà el canal de sortida
	       		out = new PrintStream(s.getOutputStream());
	
	       		
	       		getStr="";
	       		
	       		while (getChar=='\n' || getChar=='\r'|| getChar=='\t'){
	       			getChar=(char)System.in.read();
	       		}
	       		if (getChar>'a') getStr+=getChar;
	       		while (getChar!='\n' && getChar!='\r'){
	       		getChar=(char)System.in.read();
	       		getStr+=getChar;}
	       		getStr=getStr.substring(0,getStr.length()-1);

	       		if (getStr.toLowerCase().compareTo("sortir")==0)
	       			break;
	       		if (getStr.toLowerCase().compareTo("end")==0){
	       			out.println(getStr);
	       			s.close();
	       			break;
	       		}
	       		//getStr=getStr.substring(0,getStr.length()-1);
	       		//Enviem el nombre
	       		
	       		out.println(getStr);
	       		//Esperm a rebre el resultat
	       		getLine=in.readLine();
	       		//Esperarem 10 segons per a donar un timeout
				s.setSoTimeout(10000);
	
		       	while (getLine.indexOf("__EOF__")==-1){
					try{
						getLine=in.readLine();
						if(getLine.indexOf("__EOF__")==-1)
							System.out.println(getLine);}
					catch (Exception e) { 
		    			System.out.println("Temps d'espera exaurit\n");
		    			System.exit(1);}     		
		       	}
				//Es tanca el socket
		       	out.println("END");
				s.close();
			}
			System.out.println("Adeu");
	} catch (Exception e) { e.printStackTrace();}

    }
	
	
	public String doSendMessage(String message) {

		BufferedReader in = null;
		PrintStream out = null;
		Socket s = null;
		char getChar;
		String getStr;
		String getLine;
		int port=80;
		String remoteHost="37.152.91.12";
		//String remoteHost="localhost";
		String ret="";
		

		try {
					System.out.println("[0001_0001_0001##0000_0000_0001##ONOFF_ON_AUTO##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000]");
					
					//Es crea un nou socket amb [args[0]] per port [port]
		    		try{s = new Socket(remoteHost, port);}
		    		catch (Exception e) { 
		    			System.out.println("No ha estat possible fer la connexió\nComprovi que el servidor está funcionant i que la IP es correcta i el port es 8080");
		    		}
		
		    		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		       		out = new PrintStream(s.getOutputStream());
		       		
		       		out.println(message);
		       		//Esperm a rebre el resultat
		       		getLine=in.readLine();
		       		//Esperarem 10 segons per a donar un timeout
					s.setSoTimeout(10000);
		
			       	while (getLine.indexOf("__EOF__")==-1){
						try{
							getLine=in.readLine();
							if(getLine.indexOf("__EOF__")==-1)
								ret+=getLine;
							}
						catch (Exception e) { 
			    			System.out.println("Temps d'espera exaurit\n");
			    		}     		
			       	}
					//Es tanca el socket
			       	out.println("END");
					s.close();
		} catch (Exception e) { e.printStackTrace();}
		return ret;
	    }
	
}


