package com.photel.commonServices.filters;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;





public class GenericFilter {


	public static boolean match(String filterBy,String filterField,boolean ini, boolean fin,boolean caseSensitive, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {       
	    String metodo="get"+filterField.substring(0, 1).toUpperCase()+filterField.substring(1, filterField.length());
	    Method m1=null;
	    boolean ret=false;
	    Method[] allMethods;
	    allMethods = obj.getClass().getMethods();
	    for (Method m : allMethods) {
	    	String mname = m.getName();
	    	if (mname.equalsIgnoreCase(metodo)) {
	    		m1=m;
	    		break;
	    	}
 		}
	  
	    if (m1!=null ){
	    	 m1.setAccessible(true);
			 Object r1;
			 	r1 = m1.invoke(obj);
				 	if (r1!=null){
					 	String eval;
					
						if (!(r1 instanceof String)){
							eval=String.valueOf(r1);
							if (r1 instanceof Date){
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								eval=sdf.format(r1);	
							}
						}else{
							eval=(String) r1;}
						
						if (!caseSensitive){
							filterBy=filterBy.toUpperCase();
							eval=eval.toUpperCase();}
						
						if(!ini && !fin){
							ret=eval.equals(filterBy);
							return ret;
						}else if(ini && !fin){
							ret= eval.startsWith(filterBy);
							return ret;
						}else if(!ini && fin){
							ret= eval.endsWith(filterBy);
							return ret;
						}else if(ini && fin){
							ret= eval.contains(filterBy);
							return ret;
						}
				 	}else{
							return false;
						}
			 
			
	    }
		return ret;
	}
	

	public static  <T> ArrayList<T> filter(String filterBy,String filterField,boolean ini, boolean fin,boolean caseSensitive, ArrayList<T> list) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException  {
		T elem;
		boolean isIn;
		ArrayList<T> ret=new ArrayList<T>();
		for (int i=0;i<list.size();i++){
			elem = list.get(i);
			isIn = match (filterBy,filterField,ini,fin,caseSensitive,elem);
			if (isIn){
				ret.add(elem);
			}
		}
		return ret;
	}
	
	public static <T> ArrayList<T> filter(String[] filterBy, String[] filterField, boolean caseSensitive, boolean or,ArrayList<T> list) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ArrayList<T> ret =list;
		ArrayList<T> auxRet =list;
		ArrayList<ArrayList<T>> retOr= new ArrayList<ArrayList<T>>();
		boolean ini;
		boolean fin;
		if (filterBy.length==filterField.length){
			for (int i=0;i<filterBy.length;i++){
				ini=false;
				fin=false;
				if(filterBy[i].substring(0, 1).equals("*")){
					fin=true;
					filterBy[i]=filterBy[i].substring(1, filterBy[i].length());
				}
				if(filterBy[i].substring(filterBy[i].length()-1, filterBy[i].length()).equals("*")){
					ini=true;
					filterBy[i]=filterBy[i].substring(0, filterBy[i].length()-1);
				}
				if (!or){
					ret=filter(filterBy[i], filterField[i], ini, fin, caseSensitive, ret);
				}else{
					ret =list;
					ret=filter(filterBy[i], filterField[i], ini, fin, caseSensitive, ret);
					retOr.add(ret);
					//auxRet.contains(re)
				}
			}
				
			}
		
		if (or){
			ret=new ArrayList<T>();
			for (int i=0;i<retOr.size();i++){
				ret.addAll(retOr.get(i));
			}
		}
		ret=getOutDuplicates(ret);
		return ret;
	}

	private static <T> ArrayList<T> getOutDuplicates(ArrayList<T> list){
		ArrayList<T> ret = list;
		Hashtable<String,T> hAux=new Hashtable<String,T>();
		for(int k=0;k<ret.size();k++){
			hAux.put(ret.get(k).toString(), ret.get(k));
		}
		ret=new ArrayList<T>();
		Enumeration<String> hKeys = hAux.keys();
		while(hKeys.hasMoreElements()){
			ret.add(hAux.get(hKeys.nextElement()));
		}
		return ret;
	}




}
 
