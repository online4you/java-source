package com.photel.model.gen.objects;

import com.photel.interfaces.model.gen.listas.ILista;


public class Lista implements ILista {
	private String Key;
	private String Value;
	/**
	 * @return the key
	 */
	public String getKey() {
		return Key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		Key = key;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return Value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		Value = value;
	}
	
	
}
