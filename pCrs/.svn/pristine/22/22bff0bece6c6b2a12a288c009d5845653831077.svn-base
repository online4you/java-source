package com.photel.commonServices.excel;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelUtil<T> {

	public HSSFWorkbook getExcel(ArrayList<ArrayList<T>> list, ArrayList<Hashtable<String,String>> titulos) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet;
			HSSFRow row;
			HSSFCell cell;
			HSSFCellStyle estiloCabecera = creaEstilo( wb, "Tahoma", 14,true);
			HSSFCellStyle estiloDatos = creaEstilo( wb, "Tahoma", 10,false);
			
			for (int h=0;h<list.size();h++){
				Hashtable<String, String> titles=null;
				if (titulos!=null && titulos.size()>h){
					titles = titulos.get(h);
				}
				
				ArrayList<T> hoja = list.get(h);
				//Creamos hoja
				sheet = wb.createSheet(String.valueOf(h));
				for (int r=0;r<hoja.size();r++){
					//Creamos registro
					
					T registro = hoja.get(r);
					ArrayList<Method> getters = getGetters(registro);
					Hashtable<String,String> campos = getFields(registro);
					if (r==0){
						row = sheet.createRow(r);
						for (int c=0;c<getters.size();c++){
							cell = row.createCell(c);
							cell.setCellStyle( estiloCabecera);
							String titulo = campos.get(getters.get(c).getName());
							if (titles!=null){
								titulo=titles.get(titulo)==null?titulo:titles.get(titulo);
							}
							cell.setCellValue( new HSSFRichTextString(titulo));
						}
						
					}
					row = sheet.createRow(r+1);
					for (int c=0;c<getters.size();c++){
						cell = row.createCell(c);
						cell.setCellStyle( estiloDatos);
						Method getter = getters.get(c); 
						getter.setAccessible(true);
						Object value=getter.invoke(registro);
						if (value!=null){
							if (value instanceof Date){
								GregorianCalendar cal=new GregorianCalendar(); 
								cal.setTime((Date) value);
								String dia=String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
								dia=dia.length()==1?"0"+dia:dia;
								String mes=String.valueOf(cal.get(Calendar.MONTH));
								mes=mes.length()==1?"0"+mes:mes;
								String anyo=String.valueOf(cal.get(Calendar.YEAR));
								cell.setCellValue( new HSSFRichTextString(dia+"/"+mes+"/"+anyo));
							}else if (value instanceof String && ((String)value).length()==1){
								value=value.equals("S")?"Si":value;
								value=value.equals("N")?"No":value;
								cell.setCellValue( new HSSFRichTextString(value.toString()));
							}else{
								cell.setCellValue( new HSSFRichTextString(value.toString()));
							}
						}else{
							cell.setCellValue( new HSSFRichTextString(""));
						}
					}
				}
			}
			return wb;
			/*/
			res.setContentType("application/vnd.ms-excel");
			OutputStream out = res.getOutputStream();
			wb.write(out);
			out.close();
			*/
		
	}
	private HSSFCellStyle creaEstilo (HSSFWorkbook wb, String nomFuente, int  tamanoFuente, boolean esNegrita) {
		HSSFFont fuente = wb.createFont();
		fuente.setFontHeightInPoints( (short) tamanoFuente );
		fuente.setFontName( nomFuente );
		if ( esNegrita ){
			fuente.setBoldweight(fuente.BOLDWEIGHT_NORMAL);}
		HSSFCellStyle estilo = wb.createCellStyle();
		estilo.setFont( fuente );

		return estilo;
	}
	private ArrayList<Method> getGetters(Object obj){
		ArrayList<Method> getters=new ArrayList<Method>();
		Method[] allMethods = obj.getClass().getMethods();
		boolean takeIt;
		for (Method m : allMethods) {
			takeIt=true;
			takeIt=!m.getName().equals("getClass") && takeIt?true:false;
			takeIt=!m.getName().equals("getDel") && takeIt?true:false;
			takeIt=!m.getName().startsWith("getAdt") && takeIt?true:false;
			if (m.getName().startsWith("get")&& takeIt) {
	    		getters.add(m);
	    	}
 		}
		return getters;
	}
	private Hashtable<String,String> getFields(Object obj){
		ArrayList<Method> getters=getGetters(obj);
		Hashtable<String,String> gettersNames=new Hashtable<String,String>();
		String name;
		for (int i=0;i<getters.size();i++){
			name=getters.get(i).getName();
			name=name.substring(3, 4).toLowerCase();
			name+=getters.get(i).getName().substring(4, getters.get(i).getName().length());
			gettersNames.put(getters.get(i).getName(),name);
		}
		return gettersNames;
	}
	public void saveWorkbookToFile(HSSFWorkbook wb, String file) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, FileNotFoundException, IOException{
		FileOutputStream out = new FileOutputStream(file);
		wb.write(out);
	}

	public void saveWorkbookToFile(ArrayList<ArrayList<T>> list, String file, ArrayList<Hashtable<String, String>> titulos) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, FileNotFoundException, IOException{
		HSSFWorkbook wb = this.getExcel(list,titulos);
		FileOutputStream out = new FileOutputStream(file);
		wb.write(out);
	}
	public ByteArrayOutputStream getExcelOutputStream (ArrayList<ArrayList<T>> list,ArrayList<Hashtable<String, String>> titulos) throws SQLException, Exception {
		HSSFWorkbook wb = this.getExcel(list, titulos);
		ByteArrayOutputStream ret = new ByteArrayOutputStream(); 
		wb.write(ret);
		return ret;
	}
	public byte[] getExcelBytes(ArrayList<ArrayList<T>> list, ArrayList<Hashtable<String, String>> titulos) throws SQLException, Exception {
		ByteArrayOutputStream out = this.getExcelOutputStream(list, titulos);
		byte[] bytes = out.toByteArray();
		return bytes;
	}

	public ByteArrayInputStream getExcelIntutStream(ArrayList<ArrayList<T>> list, ArrayList<Hashtable<String, String>> titulos) throws SQLException, Exception {
		byte[] bytes = getExcelBytes(list, titulos);
		ByteArrayInputStream ret = new ByteArrayInputStream(bytes); 
		return ret;
		
	}

}
