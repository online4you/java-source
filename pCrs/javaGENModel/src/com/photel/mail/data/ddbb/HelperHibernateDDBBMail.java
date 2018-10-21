package com.photel.mail.data.ddbb;


import java.util.ArrayList;

import com.photel.interfaces.mail.IGenMailTemplates;
import com.photel.interfaces.mail.IGenMailTemplatesAtt;
import com.photel.mail.data.ddbb.hibernate.HibernateSessionFactory;
import com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplates;
import com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplatesAtt;

import org.hibernate.Session;





public class HelperHibernateDDBBMail {
		
	protected void finalize() throws Throwable {
		HibernateSessionFactory.closeSession();
		super.finalize();
	}

	private Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	public void closeSession(){
		HibernateSessionFactory.closeSession();
	}
	public void clearSession(){
		Session ses = getSession();
		ses.clear();
		ses.flush();
	}
	public IGenMailTemplates getTemplates(String title,String lang){		
    	
    	String sql;
    	
		sql="SELECT GMT_TITLE,GMT_TEMPLATE,GMT_VAL FROM GEN_MAIL_TEMPLATES ";
		sql+="WHERE GMT_TITLE='" + title + "' AND GMT_VAL='S' AND GMT_LANG='" + lang + "'";
						    
    	ArrayList<IGenMailTemplates> temp=(ArrayList<IGenMailTemplates>) getSession().createSQLQuery(sql).addEntity(GenMailTemplates.class).list();	
    	if (temp.size()!=0){
    		return temp.get(0);
    	}
		return null;
	}
	public ArrayList<IGenMailTemplatesAtt> getTemplatesAttachements(String title,String lang){		
    	
    	String sql;
    	
		sql="SELECT GMA_LANG, GMA_TITLE, GMA_FILENAME,GMA_CONTENTTYPE, GMA_ATTACHMENT, GMA_VAL FROM GEN_MAIL_TEMPLATES_ATT ";
		sql+="WHERE GMA_TITLE='" + title + "' AND GMA_VAL='S' AND GMA_LANG='" + lang + "'";
						    
    	ArrayList<IGenMailTemplatesAtt> temp=(ArrayList<IGenMailTemplatesAtt>) getSession().createSQLQuery(sql).addEntity(GenMailTemplatesAtt.class).list();	
		return temp;
	}


}
