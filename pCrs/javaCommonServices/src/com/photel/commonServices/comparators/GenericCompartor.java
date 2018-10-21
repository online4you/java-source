package com.photel.commonServices.comparators;

import java.util.Comparator;
import java.lang.reflect.Method;



public class GenericCompartor implements Comparator<Object>{
	private String sortBy="id";
	private boolean sortDesc=false;

	private static boolean esInteger(String str)
	{
	  return str.matches("\\d+"); //d representa un valor de a 9
	}
	
	public int compare(Object o1, Object o2) {
		String[] sortByFields = sortBy.split("##");
		
	    Integer retorno=0;
	    for (String sortField:sortByFields){
	    	Object r1 = getObject(o1,sortField);
	 	    Object r2 = getObject(o2,sortField);
	 	    if (r1!=null && r2!=null){
	 	    	retorno=compareObjects(r1, r2);
	 	    }
	 	    if (retorno!=0){
	 	    	break;
	 	    }
	    }
		return retorno;
	}
	

	private Integer compareObjects(Object obj1, Object obj2){
		Integer retorno=0;
		Method[] allMethods;
		Class<? extends Object> cr1 = obj1.getClass();
			allMethods = cr1.getMethods();
			for (Method m : allMethods) {
				String mname = m.getName();
				if (mname.equalsIgnoreCase("compareTo")) {
					Object ret = null;
					try {
						ret = m.invoke(obj1, obj2);
					} catch (Exception e) {
						e.printStackTrace();
					}
					retorno = (Integer) ret;
					if (sortDesc){
						retorno=retorno*(-1);
					}
					break;			
				}
			}
			return retorno;
	}
	private Object getObject(Object obj, String field) {
		if (field==null || obj==null) return 0;
		
		String[] filterSortByFields;
		if (field.indexOf(".")!=-1) {
			filterSortByFields = field.split("\\.");
		} else {
			filterSortByFields = new String[1];
			filterSortByFields [0] = field; 
		}
		
		
		Method method=null;
	    Method[] allMethods;
	    Object next = null;
	    Object object = null;
	    object=obj;
		for (int i=0; i< filterSortByFields.length; i++) {
			String unSortBy = filterSortByFields[i];
			
			String metodo = null;
			if (esInteger(unSortBy)){
				metodo="get"; //get(0); get(10);...
			} else {
				metodo="get"+unSortBy.substring(0, 1).toUpperCase()+unSortBy.substring(1, unSortBy.length());
			}
		
		    
		    
		    allMethods = object.getClass().getMethods();
		    for (Method m : allMethods) {
		    	String mname = m.getName();
		    	if (mname.equalsIgnoreCase(metodo)) {
		    		method=m;
		    		break;
		    	}
	 		}
		    
		    if (method!=null){
		    	method.setAccessible(true);
		    	 
		    	 try {
		    		next = method.invoke(object);
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	 
		    	 object = next;
		    }
		    
		}
		return object;
		
	}
	public boolean isSortDesc() {
		return sortDesc;
	}



	public void setSortDesc(boolean sortDesc) {
		this.sortDesc = sortDesc;
	}



	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}





}
 
 
