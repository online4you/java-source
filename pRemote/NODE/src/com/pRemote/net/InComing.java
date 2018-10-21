package com.pRemote.net;



/*
 * @(#)Servidor
 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

import com.pRemote.net.node.MessageProcess;

/**
 * Aquesta classe escolta en un socket de servidor, quan detecta una connexi� crea un fil
 * que s'encarregar� de gestionar la connex�.
 *
 * @author	Guillem Puigr�s G�mez
 * @version	1 08/10/2005
 * @see		Servidor
 * @see		GestionaConnexi�
 * @see		GetPaginaWeb
 */
public class InComing {

    /**
     * �nic m�tode de la classe que crea fils per a cada connexi�
     */	
	public static void main(String args[]) {

	int port = 80;
	ServerSocket ss = null;

	for (String arg: args) {
        System.out.println("Port " + arg);
        port=Integer.parseInt(arg);
    }
	System.out.println("Local Port: " + port);
	
	
	try {
    		//Es crea un nou socket de Servidor
		ss = new ServerSocket(port);

        	while (true) {

        	Socket s = ss.accept();
			//Delegam la gesti� a un fil d'execuci� nou per tal de 
        	//Poder acceptar noves peticions
        	MessageProcess p = new MessageProcess(s);
			p.start();
			//s.close();
        	}
        	
	} catch (Exception e) { e.printStackTrace();}
    }
}




