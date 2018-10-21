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
 * Aquesta classe escolta en un socket de servidor, quan detecta una connexió crea un fil
 * que s'encarregarà de gestionar la connexó.
 *
 * @author	Guillem Puigròs Gómez
 * @version	1 08/10/2005
 * @see		Servidor
 * @see		GestionaConnexió
 * @see		GetPaginaWeb
 */
public class InComing {

    /**
     * Únic métode de la classe que crea fils per a cada connexió
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
			//Delegam la gestió a un fil d'execució nou per tal de 
        	//Poder acceptar noves peticions
        	MessageProcess p = new MessageProcess(s);
			p.start();
			//s.close();
        	}
        	
	} catch (Exception e) { e.printStackTrace();}
    }
}




