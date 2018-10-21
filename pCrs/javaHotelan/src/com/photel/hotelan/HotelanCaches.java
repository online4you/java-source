package com.photel.hotelan;

import java.util.Map;

public class HotelanCaches {
	Map<String,Map<String,String>> boards;
	Map<String,Map<String,String>> zones;
	Map<String,Map<String,String>> destinations;
	Map<String,Map<String,String>> cathegories;
	Map<String,Map<String,String>> roomTypes;
	Map<String,Map<String,String>> hotelTypes;
	
	private String getValue(Map<String,Map<String,String>> map,String key, String lang) {
		String ret=null;
		if (lang!=null){
			Map<String, String> obj = map.get(lang);
			if(obj!=null){
				ret=obj.get(key);
			}
		}
		return ret;
	}
	public String getBoard(String key, String lang) {
		return getValue(boards,key,lang);
	}
	public String getZone(String key, String lang) {
		return getValue(zones,key,lang);
	}
	public String getDestination(String key, String lang) {
		return getValue(destinations,key,lang);
	}
	public String getCathegory(String key, String lang) {
		return getValue(cathegories,key,lang);
	}
	public String getRoomType(String key, String lang) {
		return getValue(roomTypes,key,lang);
	}
	public String getHotelType(String key, String lang) {
		return getValue(hotelTypes,key,lang);
	}
	
	
	
	
	
	public Map<String, String> getHotelTypes(String lang) {
		return hotelTypes.get(lang);
	}
	public void setHotelTypes(Map<String, Map<String, String>> hotelTypes) {
		this.hotelTypes = hotelTypes;
	}
	public void setBoards(Map<String, Map<String, String>> boards) {
		this.boards = boards;
	}
	public void setZones(Map<String, Map<String, String>> zones) {
		this.zones = zones;
	}
	public void setDestinations(Map<String, Map<String, String>> destinations) {
		this.destinations = destinations;
	}
	public void setCathegories(Map<String, Map<String, String>> cathegories) {
		this.cathegories = cathegories;
	}
	public void setRoomTypes(Map<String, Map<String, String>> roomTypes) {
		this.roomTypes = roomTypes;
	}
	
	
	
	
}
