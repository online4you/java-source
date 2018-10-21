package com.photel.mail.helpers;

import java.util.Enumeration;
import java.util.Hashtable;

import org.antlr.stringtemplate.StringTemplate;

public class TemplateHelper {
	
	
	public String generate(String template, Hashtable<String,Object> att) {
		StringTemplate temp = new StringTemplate(template);
		Enumeration<String> keys = att.keys();
		String key;
		while (keys.hasMoreElements()){
			key=keys.nextElement();
			temp.setAttribute(key, att.get(key));
		}

	        /* Uncomment to view graphically
		StringTemplateTreeView viz = new StringTemplateTreeView("viz",temp);
		viz.setVisible(true);
	        */

	       String page = temp.toString(); // render page
	       return page;
	    }
}
