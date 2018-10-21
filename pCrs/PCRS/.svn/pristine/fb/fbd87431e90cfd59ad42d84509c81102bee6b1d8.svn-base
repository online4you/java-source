package com.photel.apps.actions.gen.maps;




import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.photel.apps.actions.MainAction;


public class GenericMap extends MainAction{

	private static final long serialVersionUID = 1L;
	private String lat;
	private String lng;
	private String zoom; 
	private String loadScript;
    

    

	
	public String executeHalconAction() throws Exception{
		loadScript=loadScript==null?"true":loadScript;
		return SUCCESS;
	}


	public boolean loadGoogleScript(){
		if (loadScript!=null && loadScript.equalsIgnoreCase("false")){
			return false;
		}
		return true;
	}



	public String getLoadScript() {
		return loadScript;
	}






	public void setLoadScript(String loadScript) {
		this.loadScript = loadScript;
	}






	public String getLat() {
		return lat;
	}






	public void setLat(String lat) {
		this.lat = lat;
	}






	public String getLng() {
		return lng;
	}






	public void setLng(String lng) {
		this.lng = lng;
	}






	public String getZoom() {
		return zoom;
	}






	public void setZoom(String zoom) {
		this.zoom = zoom;
	}

	
} 