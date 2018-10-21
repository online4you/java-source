package com.photel.commonServices.util;

/**
 * Título:Clase para el tratamiento de cadenas Descripcion: Copyright: Copyright (c) 2001 Empresa:
 * $Revision: 1.13 $ $Date: 2008/06/16 06:48:40 $ $Author: msanjuan $
 */
/*
 * Clase con métodos para transformar y tratar cadenas
 */

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * Cargamos lo que para nosotros son caracteres no válidos en un listado donde la clave es el
	 * valor a intercambiar por el que encontramos en la cadena de descripción
	 */
	private static HashMap htCaracteres = inicializaCaracteresNoValidos();

	public static String[] abecedario = { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","0","P","Q","R","S","T","U","V","W","X","Y","Z" };

	/** Caracteres no válidos a intercambiar */
	// private static String caracteresRaros = "àáäâéèëêíïîóôöúûü";
	public StringUtil() {
	}

	/**
	 * Método que evita que se muestren nulos, comprobando si el String tiene valor "null"
	 * @param cadena
	 *        String de entrada
	 * @return String de salida
	 */
	public static String isNull(String cadena) {
		if (cadena == null || cadena.equalsIgnoreCase("null")) {
			return "";
		}
		else
			return cadena;
	}

	public static String quitaLetras(String cadena) {
		StringBuffer sb = new StringBuffer(cadena);
		StringBuffer sbNew = new StringBuffer("");
		char car;
		int lon = sb.length();

		for (int i = 0; i < lon; i++) {
			car = sb.charAt(i);
			if (car == '0')
				sbNew.append(car);
			else if (car == '1')
				sbNew.append(car);
			else if (car == '2')
				sbNew.append(car);
			else if (car == '3')
				sbNew.append(car);
			else if (car == '4')
				sbNew.append(car);
			else if (car == '5')
				sbNew.append(car);
			else if (car == '6')
				sbNew.append(car);
			else if (car == '7')
				sbNew.append(car);
			else if (car == '8')
				sbNew.append(car);
			else if (car == '9')
				sbNew.append(car);
		}
		return sbNew.toString();
	}

	/**
	 * Método que elimina de la cadena el caracter solicitado
	 * @param cadena
	 *        String
	 * @param caracter
	 *        char
	 * @return String
	 */

	public static String quitaLetras(String cadena, char caracter) {
		StringBuffer sb = new StringBuffer(cadena);
		StringBuffer sbNew = new StringBuffer("");
		char car;
		int lon = sb.length();

		for (int i = 0; i < lon; i++) {
			car = sb.charAt(i);
			if (car != caracter) {
				sbNew.append(car);
			}
		}
		return sbNew.toString();
	}

	/**
	 * Método que dada una cadena, la corta hasta la longitud dada como parametro
	 * @param cadena
	 *        cadena de entrada
	 * @param longitud
	 *        de la cadena
	 * @return String con la cadena con la logitud menor o igual a la dada
	 */

	public static String cortarCadenaLongitud(String cadena, int longitud) {
		if (cadena.length() > longitud) {
			return cadena.substring(0, longitud);
		}
		else
			return cadena;
	}

	/**
	 * Método que dada una cadena, la corta hasta la longitud dada como parametro
	 * @param cadena
	 *        cadena de entrada
	 * @param longitud
	 *        de la cadena
	 * @param caracterIndicativo
	 *        para indicar que la cadena es más larga
	 * @return String con la cadena con la logitud menor o igual a la dada
	 */
	public static String cortarCadenaLongitud(String cadena, int longitud, String caracterIndicativo) {
		if (cadena.length() > longitud) {
			return cadena.substring(0, longitud) + caracterIndicativo;
		}
		else
			return cadena;
	}

	/**
	 * Método que dada una cadena, la corta hasta la longitud o si es menor la rellena (según indice
	 * ya que es para los combos y con que sea el primero del tamaño vale)
	 * @param cadena
	 *        cadena de entrada
	 * @param longitud
	 *        de la cadena
	 * @param caracterIndicativo
	 *        para indicar que la cadena es más larga
	 * @return String con la cadena con la logitud menor o igual a la dada
	 */
	public static String formateaCadenaLongitud(String cadena, int longitud,
			String caracterIndicativo, int indice, String caracterRelleno) {
		if (cadena.length() > longitud) {
			int longiCaract = caracterIndicativo != null ? caracterIndicativo.length() : 0;
			return ((cadena.substring(0, longitud - longiCaract)) + caracterIndicativo);
		}
		else {
			if (indice == 0) {
				return completarCadenaLongitud(cadena, longitud, caracterRelleno);
			}
		}
		return cadena;
	}

	/**
	 * Método que dada una cadena, la corta hasta la longitud
	 * @param cadena
	 *        cadena de entrada
	 * @param longitud
	 *        de la cadena
	 * @param caracterIndicativo
	 *        para indicar que la cadena es más larga
	 * @return String con la cadena con la logitud menor o igual a la dada
	 */
	public static String formateaCadenaLongitud(String cadena, int longitud,
			String caracterIndicativo) {
		if (cadena == null)
			return "";
		if (cadena.length() > longitud) {
			int longiCaract = caracterIndicativo != null ? caracterIndicativo.length() : 0;
			return ((cadena.substring(0, longitud - longiCaract)) + caracterIndicativo);
		}
		return cadena;
	}

	/**
	 * Método que dada una cadena, la corta hasta la longitud y convierte a mayusculas, minusculas o
	 * initCap
	 * @param cadena
	 *        cadena de entrada
	 * @param longitud
	 *        de la cadena
	 * @param caracterIndicativo
	 *        para indicar que la cadena es más larga
	 * @param Indica
	 *        el case (mayusculas, minusculas o initcap) del string.
	 * @return String con la cadena con la logitud menor o igual a la dada
	 */
	public static String formateaCadenaLongitud(String cadena, int longitud,
			String caracterIndicativo, int Cap) {
		// String auxiliar.
		String strCadena = cadena;

		if (cadena == null)
			return "";
		if (cadena.length() > longitud) {
			int longiCaract = caracterIndicativo != null ? caracterIndicativo.length() : 0;
			strCadena = ((cadena.substring(0, longitud - longiCaract)) + caracterIndicativo);
		}

		switch (Cap) {
			case 1:
				strCadena = strCadena.toUpperCase();
				break;
			case 2:
				strCadena = strCadena.toLowerCase();
				break;
		}

		return strCadena;
	}

	/**
	 * Método que dada una cadena, la alarga hasta la longitud dada como parametro
	 * @param cadena
	 *        cadena de entrada
	 * @param longitud
	 *        de la cadena
	 * @return String con la cadena con la logitud mayor o igual a la dada
	 */

	public static String completarCadenaLongitud(String cadena, int longitud) {
		if (cadena.length() >= longitud) {
			return cadena;
		}
		else {
			int longCadena = longitud - cadena.length();
			StringBuffer sb = new StringBuffer(longCadena);
			for (int i = 0; i < longCadena; i++) {
				sb.append(" ");
			}
			return cadena + sb.toString();
		}
	}

	/**
	 * Método que dada una cadena, la alarga hasta la longitud dada como parametro
	 * @param cadena
	 *        cadena de entrada
	 * @param caracteres
	 *        a sumar
	 * @param longitud
	 *        de la cadena
	 * @return String con la cadena con la logitud mayor o igual a la dada
	 */

	public static String completarCadenaLongitud(String cadena, int longitud, String caracteres) {
		if (cadena.length() >= longitud) {
			return cadena;
		}
		else {
			int longCadena = longitud - cadena.length();
			StringBuffer sb = new StringBuffer(longCadena);
			for (int i = 0; i < longCadena; i++) {
				sb.append(caracteres);
			}
			return cadena + sb.toString();
		}
	}

	/**
	 * Método que dada una cadena, la formatea para que no tenga ni acentos ni comillas simples ni
	 * dobles (Es para que no den problemas los nombres de los productos) retornara la cadena en
	 * formato html cambiando los acentos por código html
	 * @param cadena
	 *        cadena de entrada
	 * @return String con la cadena con la cadena formateada
	 */
	public static String formateaDescripcionProductos(String cadena) {
		if (cadena == null) {
			return null;
		}
		String aux;
		StringBuffer sb = new StringBuffer();
		int size = cadena.length();
		for (int i = 0; i < size; i++) {
			aux = cadena.substring(i, i + 1);
			if (htCaracteres.containsKey(aux)) {
				sb.append((String) htCaracteres.get(aux));
			}
			else {
				sb.append(aux);
			}
		}
		return sb.toString();
	}

	/**
	 * Cargamos lo que para nosotros son caracteres no válidos en un listado donde la clave es el
	 * valor a intercambiar por el que encontramos en la cadena de descripción
	 * @return Hashtable con todos los datos no válidos
	 */
	private static HashMap inicializaCaracteresNoValidos() {
		HashMap<String, String> ht = new HashMap<String, String>();
		ht.put("à", "a");
		ht.put("á", "a");
		ht.put("ä", "a");
		ht.put("â", "a");
		ht.put("é", "e");
		ht.put("è", "e");
		ht.put("ë", "e");
		ht.put("ê", "e");
		ht.put("í", "i");
		ht.put("ï", "i");
		ht.put("î", "i");
		ht.put("ó", "o");
		ht.put("ô", "o");
		ht.put("ö", "o");
		ht.put("ú", "u");
		ht.put("û", "u");
		ht.put("ü", "u");
		ht.put("<", "");// para el foro
		ht.put(">", "");// para el foro
		return ht;
	}

	public static boolean buscaSimbolo(String strCadena, String strSeparador) {
		boolean encontrado = true;
		int i = strCadena.indexOf(strSeparador);
		if (i == -1) {
			encontrado = false;
		}
		return encontrado;

	}

	public static String formateaCadena(String strCadena, String strSeparador1, String strSeparador2) {

		try {
			int i = strCadena.indexOf(strSeparador1);
			String cadena = strCadena.substring(i + 1, strCadena.indexOf(strSeparador2));
			return cadena;
		}
		catch (Exception e) {
			int i = strCadena.indexOf(strSeparador1);
			String cadena = strCadena.substring(i + 1, strCadena.length());
			return cadena;
		}

	}

	public static String buscaDesdePrincipio(String strCadena, String strSeparador) {

		int i = strCadena.indexOf(strSeparador);
		String cadena = strCadena.substring(0, i);
		return cadena;

	}

	public static String normalizar(String cadena) {
		cadena = cadena.toUpperCase();
		cadena = cadena.replace('Ñ', 'N');
		cadena = cadena.replace('Á', 'A');
		cadena = cadena.replace('É', 'E');
		cadena = cadena.replace('Í', 'I');
		cadena = cadena.replace('Ó', 'O');
		cadena = cadena.replace('Ú', 'U');
		cadena = cadena.replace('À', 'A');
		cadena = cadena.replace('È', 'E');
		cadena = cadena.replace('Ì', 'I');
		cadena = cadena.replace('Ò', 'O');
		cadena = cadena.replace('Ù', 'U');
		cadena = cadena.replace('Ü', 'U');
		cadena = cadena.replace('Ö', 'O');
		cadena = cadena.replace('(', ' ');
		cadena = cadena.replace(')', ' ');
		cadena = cadena.replace('ñ', 'n');
		cadena = cadena.replace('á', 'a');
		cadena = cadena.replace('é', 'e');
		cadena = cadena.replace('í', 'i');
		cadena = cadena.replace('ó', 'o');
		cadena = cadena.replace('ú', 'u');
		cadena = cadena.replace('à', 'a');
		cadena = cadena.replace('è', 'e');
		cadena = cadena.replace('ì', 'i');
		cadena = cadena.replace('ò', 'o');
		cadena = cadena.replace('ù', 'u');
		cadena = cadena.replace('ü', 'u');
		cadena = cadena.replace('ö', 'o');
		return cadena;
	}

	public static String normalizarURL(String cadena) {
		cadena = cadena.toUpperCase();
		if (cadena.startsWith("HOTEL")){
			cadena = cadena.replaceFirst("HOTEL", "");
		}
		if (cadena.startsWith("-")){
			cadena = cadena.replaceFirst("-", "");
		}
		cadena = cadena.replace('Ñ', 'N');
		cadena = cadena.replace('Á', 'A');
		cadena = cadena.replace('É', 'E');
		cadena = cadena.replace('Í', 'I');
		cadena = cadena.replace('Ó', 'O');
		cadena = cadena.replace('Ú', 'U');
		cadena = cadena.replace('À', 'A');
		cadena = cadena.replace('È', 'E');
		cadena = cadena.replace('Ì', 'I');
		cadena = cadena.replace('Ò', 'O');
		cadena = cadena.replace('Ù', 'U');
		cadena = cadena.replace('Ü', 'U');
		cadena = cadena.replace('Ö', 'O');
		
		cadena = cadena.replace("(", "");
		cadena = cadena.replace(")", "");
		cadena = cadena.replace("'", "");
		cadena = cadena.replace(".", "");
		cadena = cadena.replace("ª", "");
		cadena = cadena.replace("º", "");
		cadena = cadena.replace(",", "");
		cadena = cadena.replace("`", "");
		cadena = cadena.replace("only", "");
		cadena = cadena.replace("solo", "");
		cadena = cadena.replace("atlas", "");
		cadena = cadena.replace("?", "");
		cadena = cadena.replace("¿", "");
		cadena = cadena.replace("Ç", "C");
		cadena = cadena.replace("\"", "");
		cadena = cadena.replace("1*", "");
		cadena = cadena.replace("2*", "");
		cadena = cadena.replace("3*", "");
		cadena = cadena.replace("4*", "");
		cadena = cadena.replace("5*", "");
		cadena = cadena.replace("duplicate", "");
		cadena = cadena.replace("duplicado", "");
		cadena = cadena.replace("*", "");
		cadena = cadena.replace("**", "");
		cadena = cadena.replace("***", "");
		cadena = cadena.replace("****", "");
		cadena = cadena.replace("*****", "");
		cadena = cadena.replace("&", "");
		cadena = cadena.replace("----", "-");
		cadena = cadena.replace("---", "-");
		cadena = cadena.replace("--", "-");
		
		
		
		
		cadena = cadena.replace('ñ', 'n');
		cadena = cadena.replace('á', 'a');
		cadena = cadena.replace('é', 'e');
		cadena = cadena.replace('í', 'i');
		cadena = cadena.replace('ó', 'o');
		cadena = cadena.replace('ú', 'u');
		cadena = cadena.replace('à', 'a');
		cadena = cadena.replace('è', 'e');
		cadena = cadena.replace('ì', 'i');
		cadena = cadena.replace('ò', 'o');
		cadena = cadena.replace('ù', 'u');
		cadena = cadena.replace('ü', 'u');
		cadena = cadena.replace('ö', 'o');
		return cadena;
	}
	
	public static String normalizar2(String cadena) {

		cadena = cadena.replace('"', '´');
		cadena = cadena.replace('\'', '´');

		return cadena;
	}

	// carmen 28/09/2006 globalia-sistemas
	// 0000423: CONTROLAR EN TEXTOS VACACIONAL LOS RETORNOS DE CARRO
	// cambia un retorno de carro de un texto html de un campo de base de datos
	// por <br> para evitar que falle el mostrar textos sacados de base de datos
	// retorna la cadena sin retornos de carro y con <br> en su lugar.-

	public static String cambiarRetornoCarro(String cadena) {
		String cadenaFinal;
		cadenaFinal = cadena.replaceAll("\r\n", "<br>");
		return cadenaFinal;

	}

	/**
	 * Capitaliza todas las palabras de la cadena
	 * @param s
	 * @return
	 */
	public static String capitalizar(String s) {
		if(s != null && !s.equalsIgnoreCase("")){
			return initCap(s, false);
		}else{
			return "";
		}
	}

	/**
	 * @param strIn
	 *        Cadena a capitalizar
	 * @param soloPrimeraPalabra
	 *        Capitaliza solo la primer palabra de la cadena
	 * @return
	 */
	public static String initCap(String cadena, boolean soloPrimeraPalabra) {
		//boolean primeraPalabra = true;
		if (cadena == null)
			return "";

		if (soloPrimeraPalabra) {
			//return cadena.substring(0, 1).toUpperCase() + cadena.substring(1).toLowerCase();
			String result = cadena.substring(0, 1).toUpperCase() + cadena.substring(1).toLowerCase();			
			return initCap(result);
		}
		else {
			cadena = cadena.toUpperCase();
			StringBuffer strBuf = new StringBuffer();
			StringTokenizer st = new StringTokenizer(cadena);	 		
			while ((st.hasMoreTokens())) {
				String palabra = st.nextToken();												
				strBuf.append(initCap(palabra, true) + " ");
			}
			return strBuf.toString().trim();
		}

	}

	/**
	 * Método para devolver si el valor pasado está nulo o vacío
	 */

	public static boolean isNuloVacio(String valor) {
		return (valor == null || valor.equals(""));
	}

	/**
	 * Método que dado una cadena de elementos String con un separador dado retorna un array de
	 * Strings con los tokens
	 * @param. String y Elemento separador
	 * @return String[] con la cadena desglosada , null si el separador o la cadena está vacía o no
	 *         tienen valores válidos
	 */
	public static String[] CadenaStringList(String strCadena, String strSeparador) {

		// Si la cadena es nula o vacia devolvemos null;
		if ((strCadena == null) || (strCadena.equals(""))) {
			return null;
		}

		// Si el separador es nulo o no existe devolvemos null
		if ((strSeparador == null) || (strSeparador.equals(""))) {
			return null;
		}

		StringTokenizer st = new StringTokenizer(strCadena.trim(), strSeparador, false);
		int length = st.countTokens();
		String[] arlLista = new String[length];

		// Recorremos la cadena en busca de tokens si todo es correcto.
		for (int i = 0; i < length; i++) {
			arlLista[i] = (String) st.nextToken();
		}
		// devolvemos el array.
		return arlLista;
	}

	/**
	 * Método que dada una cadena, la devuelve codificada en UTF-8 (UNICODE de 8 bits)
	 * @param. String
	 * @return String
	 */
	public static String encodeUTF8(String cadena) {
		String texto = null;
		try {
			texto = URLEncoder.encode(cadena, "UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			return null;
		}
		return texto;

	}
	
	public static boolean compararArrays(List<String> lista1,List<String> lista2,List<String> lista3){
		boolean repetidos=false;
		List<String> textos= new ArrayList<String>();
		for (int i = 0; i < lista1.size(); i++) {
			String cadena="";
			if (lista1.get(i)!=null) cadena=lista1.get(i).toUpperCase().trim();
			if (lista2.get(i)!=null) cadena+=lista2.get(i).toUpperCase().trim();
			if (lista3.get(i)!=null) cadena+=lista3.get(i).toUpperCase().trim();
			if (textos.contains(cadena)){
				repetidos=true;
				break;
			}else{
				textos.add(cadena);
			}			
		}
		return repetidos;
	}
	
	/**
	 * Método que dada una expresion regular y una cadena, comprueba si dicha cadena cumple la expresion
	 * @param. String, String
	 * @return boolean
	 */
	public static boolean validarCadena(String expRegular, String cadena){
		boolean valida = false;
		Pattern p = Pattern.compile(expRegular);
		Matcher m = p.matcher(cadena);
		if (m.find())
			valida = true;
		return valida;
	}
	
	/***************************************************************************************************************************/
	/*******   Funcion que devuelve cadena vacia si lo que se le pasa es null, y sino devuelve lo que se le este pasando  ******/
	/***************************************************************************************************************************/
	public static String nvl(String cadena){
		if(cadena == null)
			return "";
		else return cadena;
	}

	/***************************************************************************************************************************/
	/*******   Funcion que devuelve la cadena del 2 parametro si lo que se le pasa es null, y sino devuelve lo que se le este pasando  ******/
	/***************************************************************************************************************************/
	public static String nvl(String cadena, String cadena2){
		if(cadena == null)
			return cadena2;
		else return cadena;
	}
	
	public static String encryptMD5(String textToConvert,String encoding) throws Exception {
		MessageDigest msgDigest = null;
		String hashValue = null;
		try {
				msgDigest = MessageDigest.getInstance("MD5");

	            byte[] defaultBytes = textToConvert.getBytes();
	            msgDigest.reset();
	            msgDigest.update(defaultBytes);
	            byte messageDigest[] = msgDigest.digest();
	            StringBuffer hexString = new StringBuffer();

	            for (int i = 0; i < messageDigest.length; i++)
	            {
	                String hex = Integer.toHexString(0xFF & messageDigest[i]);
	                if (hex.length() == 1)
	                {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }
	            hashValue = hexString.toString();
			} catch (NoSuchAlgorithmException e) {
				return null;
			}
			return hashValue;
		}
	
	public static String limpiaString(String cadena) {

		if (cadena != null){
			cadena = cadena.replace('"','\'');
			cadena = cadena.replaceAll("'", "\'");
			cadena = cadena.replaceAll("\n", "\\\\n");
			cadena = cadena.replaceAll("\r", "");
			cadena = cadena.replaceAll("#"," ");
		}
		return cadena;
	}
	
	/**************************************************************************
	 * 	Init Cap Words With Spaces
	 * 	@param in string
	 * 	@return init cap
	 */
	public static String initCap (String in)
	{
		if (in == null || in.length() == 0)
			return in;
		//
		boolean capitalize = true;
		char[] data = in.toCharArray();
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == ' ' || data[i] == '-' || Character.isWhitespace(data[i]))
				capitalize = true;
			else if (capitalize)
			{
				data[i] = Character.toUpperCase (data[i]);
				capitalize = false;
			}
			else
				data[i] = Character.toLowerCase (data[i]);
		}
		return new String (data);
	}	//	initCap

	/**
	 * Función que elimina acentos y caracteres especiales de
	 * una cadena de texto.
	 * @param input
	 * @return cadena de texto limpia de acentos y caracteres especiales.
	 */
	public static String quitarTildes(String input) {
	    // Cadena de caracteres original a sustituir.
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    // Cadena de caracteres ASCII que reemplazarán los originales.
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }//for i
	    return output;
	}
	
}
