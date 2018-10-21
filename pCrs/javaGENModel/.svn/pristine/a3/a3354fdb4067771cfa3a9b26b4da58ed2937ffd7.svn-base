package com.photel.mail.helpers;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import com.photel.interfaces.mail.IGenMailTemplatesAtt;


/**
 * Clase para enviar mensajes de correo electrï¿½nico en formato HTML sin imï¿½genes
 *
 * @author  Manuel Martï¿½n Prieto
 * @version 3.0
 */
public class MailHelper  {

    /** Nos indica si se ha inicilizado correctamente la clase */
    private  boolean bEstado;

    /** Host SMTP */
    private  String strSMTPHost;

    /** Puerto del Host SMTP */
    private int intSMTPPuerto;

    /** Usuario del Host SMTP */
    private  String strUsuario;

    /** Password del usuario */
    private  String strPassword;

    /** Nombre de la persona o instituciï¿½n que envï¿½a en correo */
    private  String strNombreFrom;
    private  Properties oPropiedades;
    private  Session oSesion;


    /**
     * Crea una referencia de la clase clsCorreo.
     * Inicializa la clase con los valores en el fichero de configuraciï¿½n.
     *
     * @param ficheroConfiguracion Fichero de configuraciï¿½n donde se encuentran los datos del servidor de correo
     */
    public MailHelper(String SMTPHost,String SMTPPort, String usuario, String password, String from){
            boolean host=SMTPHost!=null && !SMTPHost.equalsIgnoreCase("");
            boolean user=usuario!=null && !usuario.equalsIgnoreCase("");
            boolean pass=password!=null && !password.equalsIgnoreCase("");
            boolean para=from!=null && !from.equalsIgnoreCase("");
            boolean port=SMTPPort!=null && !SMTPPort.equalsIgnoreCase("");
            
    		if (host && user && pass && para && port){
	    		//El estado inicialmente lo ponemos a false
	            bEstado = false;
	            //Cargamos el fichero de configuraciï¿½n
	            //Lectura del fichero de configuraciï¿½n
	            //strSMTPHost = DBProperties.dameValor("SMTP_HOST");
	            strSMTPHost =SMTPHost;
	            intSMTPPuerto=Integer.parseInt(SMTPPort);
	            strUsuario = usuario;
	            strPassword = password;
	            strNombreFrom = from;
	
	            //Obtenemos las propiedades del sistema
	            //oPropiedades = System.getProperties();
	            oPropiedades = new Properties();

	         // Nombre del host de correo, es smtp.gmail.com
	            oPropiedades.setProperty("mail.smtp.host", strSMTPHost);

	         // TLS si está disponible
	            oPropiedades.setProperty("mail.smtp.starttls.enable", "true");

	         // Puerto de gmail para envio de correos
	            oPropiedades.setProperty("mail.smtp.port",SMTPPort);

	         // Nombre del usuario
	            oPropiedades.setProperty("mail.smtp.user", from);

	         // Si requiere o no usuario y password para conectarse.
	            oPropiedades.setProperty("mail.smtp.auth", "true");
	          
	          
	            //Obtenemos la sesiï¿½n
	            oSesion = Session.getInstance(oPropiedades,null);
	
	            //Cambiamos el estado
	            bEstado = true;

    		}

    }







    /**
     * Envï¿½a un mensaje de correo electrï¿½nico a la direciï¿½n indicada con
     * formato HTML.
     *
     * @param cuerpoMensaje Cuerpo del mensaje que se desea enviar
     * @param asuntoMensaje Asunto del mensaje que se desea enviar
     * @param destinoMensaje Direcciï¿½n de correo destino
     * @return boolean Devuelve true si se ha completado con ï¿½xito
     */
    public  boolean send(String asuntoMensaje, String cuerpoMensaje,String destinoMensaje){
        return sendEmail(asuntoMensaje, cuerpoMensaje, destinoMensaje, "text/html");
    }

    /**
     * Envï¿½a un mensaje de correo electrï¿½nico a la direciï¿½n indicada con
     * formato HTML.
     *
     * @param cuerpoMensaje Cuerpo del mensaje que se desea enviar
     * @param asuntoMensaje Asunto del mensaje que se desea enviar
     * @param destinoMensaje Direcciï¿½n de correo destino
     * @return boolean Devuelve true si se ha completado con ï¿½xito
     */
    public  boolean send(String asuntoMensaje, String cuerpoMensaje,String destinoMensaje, String from){
        return sendEmail(asuntoMensaje, cuerpoMensaje, destinoMensaje, "text/html", from);
    }
    /**
     * Envï¿½a un mensaje de correo electrï¿½nico a la direciï¿½n indicada con
     * formato HTML.
     *
     * @param cuerpoMensaje Cuerpo del mensaje que se desea enviar
     * @param asuntoMensaje Asunto del mensaje que se desea enviar
     * @param destinoMensaje Direcciï¿½n de correo destino
     * @return boolean Devuelve true si se ha completado con ï¿½xito
     */
    public  boolean sendImagesEmbebed(String images, String asuntoMensaje, String cuerpoMensaje,String destinoMensaje,String destinoMensajeCC,String destinoMensajeCCO, String from,ArrayList<IGenMailTemplatesAtt> attachList){
        return sendEmailMultiPart(images,asuntoMensaje, cuerpoMensaje, destinoMensaje,destinoMensajeCC,destinoMensajeCCO, "text/html", from, attachList);
    }

    /**
     * Envï¿½a un mensaje de correo electrï¿½nico a la direciï¿½n indicada con
     * formato HTML con un fichero adjunto.
     *
     * @param cuerpoMensaje Cuerpo del mensaje que se desea enviar
     * @param asuntoMensaje Asunto del mensaje que se desea enviar
     * @param destinoMensaje Direcciï¿½n de correo destino
     * @return boolean Devuelve true si se ha completado con ï¿½xito
     */
    public  boolean send(String asuntoMensaje, String cuerpoMensaje,String destinoMensaje, String from,String pdfFileUrl){
        return sendEmail(asuntoMensaje, cuerpoMensaje, destinoMensaje, "text/html", from,pdfFileUrl);
    }
    /**
     * Envï¿½a un mensaje de correo electrï¿½nico a la direciï¿½n indicada con
     * formato de texto plano.
     *
     * @param cuerpoMensaje Cuerpo del mensaje que se desea enviar
     * @param asuntoMensaje Asunto del mensaje que se desea enviar
     * @param destinoMensaje Direcciï¿½n de correo destino
     * @return boolean Devuelve true si se ha completado con ï¿½xito
     */
    public boolean sendTexto(String asuntoMensaje,String cuerpoMensaje,String destinoMensaje) {
        return sendEmail(asuntoMensaje, cuerpoMensaje, destinoMensaje, "text/plain");
    }


    /**
     * Envia un mensaje de correo electrï¿½nico a la direcciï¿½n indicada y con
     * tipo MIME que se ha indicado.
     */
    private  boolean sendEmail(String asuntoMensaje, String cuerpoMensaje,String destinosMensaje,String contentType) {
        Transport oTransporte;
        String cuentaEnvioDefecto = "callcenter@halconviajes.com";

        //Comprobamos que el estado es el correcto
        if (bEstado){
 
	    // Aseguramos que tenemos un destinatario.
	    if ((destinosMensaje==null)||(destinosMensaje.length()==0))
	        destinosMensaje=cuentaEnvioDefecto;

            try {
                //Definimos el mensaje
                MimeMessage mmMensaje = new MimeMessage(oSesion);
                //Introducimos el campo FROM
                if (strNombreFrom.equals("")){
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));
                }else{
//                  mmMensaje.setFrom(new InternetAddress(strEMailFrom,strNombreFrom));
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));
                }
                //Insertamos el reply-to

                Address reply[] = new Address[1];
                reply[0] = new InternetAddress(strNombreFrom);
                mmMensaje.setReplyTo(reply);


                // Obtenemos un array de strings a partir de la cadena de direcciones.
		String[] recipients = (String[]) destinosMensaje.split(";");
		// Recorremos el string de destinatarios aï¿½adiendo destinatarios (mï¿½ximo 2).
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++)
		{
		    addressTo[i] = new InternetAddress(recipients[i]);
		}
		// Aï¿½adimos las direcciones de envio.
		mmMensaje.setRecipients(Message.RecipientType.TO,addressTo);
                //Introducimos el asunto del mensaje
                mmMensaje.setSubject(asuntoMensaje);
                //Introducimos el cuerpo del mensaje
                mmMensaje.setContent(cuerpoMensaje, contentType);
                //Mandamos el mensaje
                mmMensaje.saveChanges();
                oTransporte = oSesion.getTransport("smtp");
                oTransporte.connect(strSMTPHost,strUsuario,strPassword);
                oTransporte.sendMessage(mmMensaje, mmMensaje.getAllRecipients());
                oTransporte.close();
            }
            catch(Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Envia un mensaje de correo electrï¿½nico a la direcciï¿½n indicada y con
     * tipo MIME que se ha indicado.
     */
    private  boolean sendEmail(String asuntoMensaje, String cuerpoMensaje,String destinoMensaje,String contentType, String from) {
        Transport oTransporte;
        //Comprobamos que el estado es el correcto
        if (bEstado){
            try {

                //Definimos el mensaje
                MimeMessage mmMensaje = new MimeMessage(oSesion);

                //Introducimos el campo FROM
                strNombreFrom= from;
                if (strNombreFrom.equals(""))
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));
                else
                    //mmMensaje.setFrom(new InternetAddress(strEMailFrom,strNombreFrom));
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));

                
                
                
                //Insertamos el reply-to

                Address reply[] = new Address[1];
                reply[0] = new InternetAddress(strNombreFrom);
                mmMensaje.setReplyTo(reply);


                // Obtenemos un array de strings a partir de la cadena de direcciones.
                String[] recipients = (String[]) destinoMensaje.split(";");
                // 	Recorremos el string de destinatarios aï¿½adiendo destinatarios (mï¿½ximo 2).
                InternetAddress[] addressTo = new InternetAddress[recipients.length];
                for (int i = 0; i < recipients.length; i++)
                {
                	addressTo[i] = new InternetAddress(recipients[i]);
                }
                // 	Aï¿½adimos las direcciones de envio.
                mmMensaje.setRecipients(Message.RecipientType.TO,addressTo);
                
                //Introducimos el asunto del mensaje
                mmMensaje.setSubject(asuntoMensaje);

                //Introducimos el cuerpo del mensaje
                mmMensaje.setContent(cuerpoMensaje, contentType);
                //Mandamos el mensaje
                mmMensaje.saveChanges();
                oTransporte = oSesion.getTransport("smtp");
                //oTransporte.connect(strSMTPHost,strUsuario,strPassword);
                //oLog.error("Entrando en envï¿½o de mail:" + strSMTPHost);
                oTransporte.connect(strSMTPHost,strUsuario,strPassword);
                oTransporte.sendMessage(mmMensaje, mmMensaje.getAllRecipients());
                oTransporte.close();
            }
            catch(Exception e) {
                 return false;
            }
        }
        return true;
    }
    /**
     * Envia un mensaje de correo electrï¿½nico a la direcciï¿½n indicada y con
     * tipo MIME que se ha indicado.
     */
    private  boolean sendEmailMultiPart(String imagesDataSources, String asuntoMensaje, String cuerpoMensaje,String destinoMensaje,String destinoMensajeCC,String destinoMensajeCCO,String contentType, String from,ArrayList<IGenMailTemplatesAtt> attachList) {
        Transport oTransporte;
        //Comprobamos que el estado es el correcto
        if (bEstado){
             try {

                //Definimos el mensaje
                MimeMessage mmMensaje = new MimeMessage(oSesion);

                //Introducimos el campo FROM
                strNombreFrom= from;
                if (strNombreFrom.equals(""))
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));
                else
                    //mmMensaje.setFrom(new InternetAddress(strEMailFrom,strNombreFrom));
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));

                //Introducimos el campo TO
                String[] recipients = (String[]) destinoMensaje.split(";");
                for (int i = 0; i < recipients.length; i++){
                	mmMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients[i]));}
                
                //CC
                if (destinoMensajeCC!=null && !destinoMensajeCC.equalsIgnoreCase("")){
                	recipients = (String[]) destinoMensajeCC.split(";");
                    for (int i = 0; i < recipients.length; i++){
                    	mmMensaje.addRecipient(Message.RecipientType.CC, new InternetAddress(recipients[i]));}
                }
                //CCO
                if (destinoMensajeCCO!=null && !destinoMensajeCCO.equalsIgnoreCase("")){
                	recipients = (String[]) destinoMensajeCCO.split(";");
                    for (int i = 0; i < recipients.length; i++){
                    	mmMensaje.addRecipient(Message.RecipientType.BCC, new InternetAddress(recipients[i]));}
                }
                //Introducimos el asunto del mensaje
                mmMensaje.setSubject(asuntoMensaje);

                //Creamos el mensaje
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setContent(cuerpoMensaje,contentType);

                // create the Multipart and add its parts to it
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                
                try {
	                //Creamos la parte con el adjunto
	                MimeBodyPart mbp2 = new MimeBodyPart();
	                FileDataSource fds;
	                String fichero;
	                //Las imagenes
	                if (imagesDataSources!=null && !imagesDataSources.equalsIgnoreCase("")){
		                String[] images=imagesDataSources.split(";");
		                
		                
		                for (int i=0;i<images.length;i++){
		                fds = new FileDataSource(images[i]);
		                	mbp2 = new MimeBodyPart();
		                	images[i]=images[i].replace("\\", "/");
		                	images[i]=images[i].replace("//", "/");
		                	fds = new FileDataSource(images[i]);
		                	mbp2.setDataHandler(new DataHandler(fds));
		                	fichero = images[i].substring(images[i].lastIndexOf("/")+1, images[i].length());
		                	mbp2.setFileName(fichero);
		                	mp.addBodyPart(mbp2);

		                }
	                }
	                IGenMailTemplatesAtt imageBin;
	                for (int i=0;i<attachList.size();i++){
	                	mbp2 = new MimeBodyPart();
	                	imageBin = attachList.get(i);
	                	byte[] binaryToSend = imageBin.getGmaAttahment();
		                mbp2.setContent(binaryToSend,imageBin.getGmaContentType());
		                mbp2.setFileName(imageBin.getId().getGmaFilename());
		                mp.addBodyPart(mbp2);
		                }

	                //Introducimos el cuerpo del mensaje
	                mmMensaje.setContent(mp);
	                
	                //Introducimos el cuerpo del mensaje
	               // mmMensaje.setContent(cuerpoMensaje, contentType);
	                
	                //Mandamos el mensaje
	                mmMensaje.saveChanges();
	                oTransporte = oSesion.getTransport("smtp");
	                //oTransporte.connect(strSMTPHost,strUsuario,strPassword);
	                //oLog.error("Entrando en envï¿½o de mail:" + strSMTPHost);
	                oTransporte.connect(strSMTPHost,intSMTPPuerto, strUsuario,strPassword);
	                oTransporte.sendMessage(mmMensaje, mmMensaje.getAllRecipients());
	                oTransporte.close();
                } catch(Exception e) {
                	//Si falla por el fichero lo volvemos a enviar sin el
                	e.printStackTrace();
                	if (e instanceof FileNotFoundException || e instanceof MessagingException){
                		mp = new MimeMultipart();
                        mp.addBodyPart(mbp1);

    	                //Introducimos el cuerpo del mensaje
    	                mmMensaje.setContent(mp);
    	                
    	                //Introducimos el cuerpo del mensaje
    	               // mmMensaje.setContent(cuerpoMensaje, contentType);
    	                
    	                //Mandamos el mensaje
    	                mmMensaje.saveChanges();
    	                oTransporte = oSesion.getTransport("smtp");
    	                //oTransporte.connect(strSMTPHost,strUsuario,strPassword);
    	                //oLog.error("Entrando en envï¿½o de mail:" + strSMTPHost);
    	                oTransporte.connect(strSMTPHost,intSMTPPuerto,strUsuario,strPassword);
    	                oTransporte.sendMessage(mmMensaje, mmMensaje.getAllRecipients());
    	                oTransporte.close();
                	}
                }
            }
            catch(Exception e) {
            	e.printStackTrace();
                return false;
            }
        }
        return true;
    }


    /**
     * Envia un mensaje de correo electrï¿½nico a la direcciï¿½n indicada y con
     * tipo MIME que se ha indicado con un fichero adjunto.
     */
    private  boolean sendEmail(String asuntoMensaje, String cuerpoMensaje,String destinoMensaje,String contentType, String from,String pdfFileUrl) {
        Transport oTransporte;
        //Comprobamos que el estado es el correcto
        if (bEstado){
             try {

                //Definimos el mensaje
                MimeMessage mmMensaje = new MimeMessage(oSesion);

                //Introducimos el campo FROM
                strNombreFrom= from;
                if (strNombreFrom.equals(""))
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));
                else
                    //mmMensaje.setFrom(new InternetAddress(strEMailFrom,strNombreFrom));
                    mmMensaje.setFrom(new InternetAddress(strNombreFrom));

                //Introducimos el campo TO
                mmMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinoMensaje));

                //Introducimos el asunto del mensaje
                mmMensaje.setSubject(asuntoMensaje);

                //Creamos el mensaje
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setContent(cuerpoMensaje,contentType);

                // create the Multipart and add its parts to it
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                
                try {
	                //Creamos la parte con el adjunto
	                MimeBodyPart mbp2 = new MimeBodyPart();
	
	                //Adjuntamos el fichero PDF
	                FileDataSource fds = new FileDataSource(pdfFileUrl);
	                mbp2.setDataHandler(new DataHandler(fds));
	                //mbp2.setFileName(fds.getName());
	                String extFichero = pdfFileUrl.substring(pdfFileUrl.lastIndexOf(".")+1, pdfFileUrl.length());
	                mbp2.setFileName("resumen_reserva."+ extFichero);
	                mp.addBodyPart(mbp2);

	                //Introducimos el cuerpo del mensaje
	                mmMensaje.setContent(mp);
	                
	                //Introducimos el cuerpo del mensaje
	               // mmMensaje.setContent(cuerpoMensaje, contentType);
	                
	                //Mandamos el mensaje
	                mmMensaje.saveChanges();
	                oTransporte = oSesion.getTransport("smtp");
	                //oTransporte.connect(strSMTPHost,strUsuario,strPassword);
	                //oLog.error("Entrando en envï¿½o de mail:" + strSMTPHost);
	                oTransporte.connect(strSMTPHost,strUsuario,strPassword);
	                oTransporte.sendMessage(mmMensaje, mmMensaje.getAllRecipients());
	                oTransporte.close();
                } catch(Exception e) {
                	//Si falla por el fichero lo volvemos a enviar sin el
                	if (e instanceof FileNotFoundException || e instanceof MessagingException){
                		mp = new MimeMultipart();
                        mp.addBodyPart(mbp1);

    	                //Introducimos el cuerpo del mensaje
    	                mmMensaje.setContent(mp);
    	                
    	                //Introducimos el cuerpo del mensaje
    	               // mmMensaje.setContent(cuerpoMensaje, contentType);
    	                
    	                //Mandamos el mensaje
    	                mmMensaje.saveChanges();
    	                oTransporte = oSesion.getTransport("smtp");
    	                //oTransporte.connect(strSMTPHost,strUsuario,strPassword);
    	                //oLog.error("Entrando en envï¿½o de mail:" + strSMTPHost);
    	                oTransporte.connect(strSMTPHost,strUsuario,strPassword);
    	                oTransporte.sendMessage(mmMensaje, mmMensaje.getAllRecipients());
    	                oTransporte.close();
                	}
                }
            }
            catch(Exception e) {
                return false;
            }
        }
        return true;
    }

    
 }
