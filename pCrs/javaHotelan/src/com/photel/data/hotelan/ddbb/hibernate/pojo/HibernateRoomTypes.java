package com.photel.data.hotelan.ddbb.hibernate.pojo;

public class HibernateRoomTypes {
	private HibernateIdLangPK id;
	private String description;
	
	public HibernateRoomTypes(){
		super();
	}
	public HibernateRoomTypes(HibernateIdLangPK pk){
		this.id=pk;
	}
	
	public HibernateIdLangPK getId() {
		return id;
	}
	public void setId(HibernateIdLangPK id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
