package com.photel.data.hotelan.ddbb.hibernate.pojo;

import java.io.Serializable;

public class HibernateHotel  implements Serializable{
	private HibernateIdLangPK idHotel;
	private String name;
	private Integer typeId;
	private String typeDes;
	private Integer catId;
	private String catDes;
	private Integer destinationId;
	private String destinationDes;
	private Integer zoneId;
	private String zoneDes;
	private String address;
	private String zipCode;
	private String region;
	private String country;
	private String telephone;
	private String fax;
	private String web;
	private String email;
	private Integer active;
	private String acces;
	private String details;
	private String mainImg;
	private String rooms;
	private String pax;
	private String latitude;
	private String longitude;
	public HibernateHotel(){
		super();
	}
	
	public HibernateHotel (HibernateIdLangPK idHotel) {
		this.idHotel=idHotel;
	}
	
	public HibernateIdLangPK getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(HibernateIdLangPK idHotel) {
		this.idHotel = idHotel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeDes() {
		return typeDes;
	}
	public void setTypeDes(String typeDes) {
		this.typeDes = typeDes;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getCatDes() {
		return catDes;
	}
	public void setCatDes(String catDes) {
		this.catDes = catDes;
	}
	public Integer getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}
	public String getDestinationDes() {
		return destinationDes;
	}
	public void setDestinationDes(String destinationDes) {
		this.destinationDes = destinationDes;
	}
	public Integer getZoneId() {
		return zoneId;
	}
	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}
	public String getZoneDes() {
		return zoneDes;
	}
	public void setZoneDes(String zoneDes) {
		this.zoneDes = zoneDes;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}

	public String getAcces() {
		return acces;
	}

	public void setAcces(String acces) {
		this.acces = acces;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getPax() {
		return pax;
	}

	public void setPax(String pax) {
		this.pax = pax;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
