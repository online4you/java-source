package com.pRemote.commonServices.util;


import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class XMLUtil {
	
	public static Document getDom(String xml) throws DocumentException{
		Document document = DocumentHelper.parseText(xml);
        return document;
	}
	public static String getXml(Document doc) throws DocumentException{
		String ret=doc.asXML();
        return ret;
	}
	
	public static void main(String[] args) throws DocumentException {
		String xml="";
		//xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		xml+="<a>";
			xml+="<b name=\"ssssssss\">";
				xml+="bbbbbbbbb";
			xml+="</b>";	
		xml+="</a>";
		Document document = getDom(xml); 
		//List list = document.selectNodes( "//foo/bar" );

        Node node = document.selectSingleNode( "//b" );
        
        String name = node.valueOf( "@name" );
        String val = node.getText();
        
		System.out.println(getXml(document));
	}
}
