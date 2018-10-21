package com.photel.model.gen.helpers;

import java.util.GregorianCalendar;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;



public class LDAPFactory {
	private String host;
	private String domain;
	private String port;
	
	/**
	 * Consturtor per amb parámetres
	 * 
	 * @param host
	 * @param domain
	 * @param port
	 */
	public LDAPFactory(String host, String port, String domain) {
		super();
		this.host=host;
		this.domain=domain;
		this.port=port;		

	}
	/**
	 * Consturtor per defecte
	 * 
	 */
	public LDAPFactory() {
		super();
		this.host="ldaps.globalia.com";
		this.domain="globalia.com";
		this.port="389";
	}

	/**
	 * 
	 * Retrona els atributs si el login es correcte, null altrament.
	 * 
	 * @param username
	 * @param password
	 * @param searchBase
	 * @return
	 */
    public Hashtable<String,Object> authenticateUser(String username, String password, String searchBase){
           String returnedAtts[] ={ "sn", "givenName", "mail" };
           String searchFilter = "(&(objectClass=user)(sAMAccountName=" + username + "))";

           SearchControls searchCtls = new SearchControls();
           searchCtls.setReturningAttributes(returnedAtts);
           
           //Abast
           searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
           Hashtable environment = new Hashtable();
           environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
          
           //Params de connexió
           environment.put(Context.PROVIDER_URL, "ldap://" + host + ":" + port);
           environment.put(Context.SECURITY_AUTHENTICATION, "simple");
           
           //user=ldapadmin@globalia.com
           //pass=unicsajk
           
           environment.put(Context.SECURITY_PRINCIPAL, username + "@" + domain);
           environment.put(Context.SECURITY_CREDENTIALS, password);
           LdapContext ctxGC = null;
           try
           {
                 ctxGC = new InitialLdapContext(environment, null);
                 //Resultats
                 NamingEnumeration answer = ctxGC.search(searchBase, searchFilter, searchCtls);
                 while (answer.hasMoreElements())
                 {
                       SearchResult sr = (SearchResult)answer.next();
                       Attributes attrs = sr.getAttributes();
                       if (attrs != null){
                    	  Hashtable<String,Object> att=new Hashtable<String,Object>();
                    	  NamingEnumeration<? extends Attribute> enu = attrs.getAll();
                    	  Attribute elem;
                    	  while(enu.hasMoreElements()){
                    		  elem= enu.next();
                    		  att.put(elem.getID(), (String) elem.get(0));
                    	  }
                    	  att.put("user", username);
                    	  att.put("password", password);
                    	  att.put("timestamp", new GregorianCalendar());
                          //Per envant
                    	  return att;
                       }
                 }
            }
           catch (NamingException e){}
           //S'han col·lat
           return null;
     }





}
