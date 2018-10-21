package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilitiesPK;


/**
 * This is an object that contains data related to the bdlv_hdetail_facilities table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdlv_hdetail_facilities"
 */

public abstract class BaseBdlvHdetailFacilities  implements Serializable, IBdlvHdetailFacilities {

	public static String REF = "BdlvHdetailFacilities";
	public static String PROP_AGETO = "Ageto";
	public static String PROP_ORDER = "Order";
	public static String PROP_TEXTFLAG = "Textflag";
	public static String PROP_BEACHAPARTFLAG = "Beachapartflag";
	public static String PROP_BEACHACCESSFLAG = "Beachaccessflag";
	public static String PROP_NUMBERFLAG = "Numberflag";
	public static String PROP_BASICFLAG = "Basicflag";
	public static String PROP_CONCEPTFLAG = "Conceptflag";
	public static String PROP_AGEFROM = "Agefrom";
	public static String PROP_AGETOFLAG = "Agetoflag";
	public static String PROP_DISTANCEFLAG = "Distanceflag";
	public static String PROP_GROUPDES = "Groupdes";
	public static String PROP_DYNAMICFLAG = "Dynamicflag";
	public static String PROP_BEACHAPART = "Beachapart";
	public static String PROP_TYPOLOGYCODE = "Typologycode";
	public static String PROP_LOGICFLAG = "Logicflag";
	public static String PROP_WALKINGDISTANCEFLAG = "Walkingdistanceflag";
	public static String PROP_TRANSPORTDISTANCE = "Transportdistance";
	public static String PROP_DISTANCE = "Distance";
	public static String PROP_FEE = "Fee";
	public static String PROP_NUMBER = "Number";
	public static String PROP_CARDISTANCEFLAG = "Cardistanceflag";
	public static String PROP_CONCEPT = "Concept";
	public static String PROP_AGEFROMFLAG = "Agefromflag";
	public static String PROP_FEEFLAG = "Feeflag";
	public static String PROP_NAME = "Name";
	public static String PROP_LOGIC = "Logic";
	public static String PROP_WALKINGDISTANCE = "Walkingdistance";
	public static String PROP_TRANSPORTDISTANCEFLAG = "Transportdistanceflag";
	public static String PROP_ID = "Id";
	public static String PROP_BEACHACCESS = "Beachaccess";
	public static String PROP_CARDISTANCE = "Cardistance";


	// constructors
	public BaseBdlvHdetailFacilities () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlvHdetailFacilities (IBdlvHdetailFacilitiesPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdlvHdetailFacilities (
		IBdlvHdetailFacilitiesPK id,
		java.lang.String order,
		java.lang.String basicflag,
		java.lang.String typologycode,
		java.lang.String textflag,
		java.lang.String numberflag,
		java.lang.String logicflag,
		java.lang.String feeflag,
		java.lang.String distanceflag,
		java.lang.String walkingdistanceflag,
		java.lang.String transportdistanceflag,
		java.lang.String cardistanceflag,
		java.lang.String agefromflag,
		java.lang.String agetoflag,
		java.lang.String beachaccessflag,
		java.lang.String beachapartflag,
		java.lang.String dynamicflag,
		java.lang.String conceptflag,
		java.lang.String name,
		java.lang.String groupdes) {

		this.setId(id);
		this.setOrder(order);
		this.setBasicflag(basicflag);
		this.setTypologycode(typologycode);
		this.setTextflag(textflag);
		this.setNumberflag(numberflag);
		this.setLogicflag(logicflag);
		this.setFeeflag(feeflag);
		this.setDistanceflag(distanceflag);
		this.setWalkingdistanceflag(walkingdistanceflag);
		this.setTransportdistanceflag(transportdistanceflag);
		this.setCardistanceflag(cardistanceflag);
		this.setAgefromflag(agefromflag);
		this.setAgetoflag(agetoflag);
		this.setBeachaccessflag(beachaccessflag);
		this.setBeachapartflag(beachapartflag);
		this.setDynamicflag(dynamicflag);
		this.setConceptflag(conceptflag);
		this.setName(name);
		this.setGroupdes(groupdes);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IBdlvHdetailFacilitiesPK id;

	// fields
	private java.lang.String order;
	private java.lang.String number;
	private java.lang.String logic;
	private java.lang.String fee;
	private java.lang.String distance;
	private java.lang.String walkingdistance;
	private java.lang.String transportdistance;
	private java.lang.String cardistance;
	private java.lang.String agefrom;
	private java.lang.String ageto;
	private java.lang.String beachaccess;
	private java.lang.String beachapart;
	private java.lang.String concept;
	private java.lang.String basicflag;
	private java.lang.String typologycode;
	private java.lang.String textflag;
	private java.lang.String numberflag;
	private java.lang.String logicflag;
	private java.lang.String feeflag;
	private java.lang.String distanceflag;
	private java.lang.String walkingdistanceflag;
	private java.lang.String transportdistanceflag;
	private java.lang.String cardistanceflag;
	private java.lang.String agefromflag;
	private java.lang.String agetoflag;
	private java.lang.String beachaccessflag;
	private java.lang.String beachapartflag;
	private java.lang.String dynamicflag;
	private java.lang.String conceptflag;
	private java.lang.String name;
	private java.lang.String groupdes;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getId()
	 */
	@Override
	public IBdlvHdetailFacilitiesPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setId(com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK)
	 */
	@Override
	public void setId (IBdlvHdetailFacilitiesPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getOrder()
	 */
	@Override
	public java.lang.String getOrder () {
		return order;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setOrder(java.lang.String)
	 */
	@Override
	public void setOrder (java.lang.String order) {
		this.order = order;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getNumber()
	 */
	@Override
	public java.lang.String getNumber () {
		return number;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setNumber(java.lang.String)
	 */
	@Override
	public void setNumber (java.lang.String number) {
		this.number = number;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getLogic()
	 */
	@Override
	public java.lang.String getLogic () {
		return logic;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setLogic(java.lang.String)
	 */
	@Override
	public void setLogic (java.lang.String logic) {
		this.logic = logic;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getFee()
	 */
	@Override
	public java.lang.String getFee () {
		return fee;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setFee(java.lang.String)
	 */
	@Override
	public void setFee (java.lang.String fee) {
		this.fee = fee;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getDistance()
	 */
	@Override
	public java.lang.String getDistance () {
		return distance;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setDistance(java.lang.String)
	 */
	@Override
	public void setDistance (java.lang.String distance) {
		this.distance = distance;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getWalkingdistance()
	 */
	@Override
	public java.lang.String getWalkingdistance () {
		return walkingdistance;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setWalkingdistance(java.lang.String)
	 */
	@Override
	public void setWalkingdistance (java.lang.String walkingdistance) {
		this.walkingdistance = walkingdistance;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getTransportdistance()
	 */
	@Override
	public java.lang.String getTransportdistance () {
		return transportdistance;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setTransportdistance(java.lang.String)
	 */
	@Override
	public void setTransportdistance (java.lang.String transportdistance) {
		this.transportdistance = transportdistance;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getCardistance()
	 */
	@Override
	public java.lang.String getCardistance () {
		return cardistance;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setCardistance(java.lang.String)
	 */
	@Override
	public void setCardistance (java.lang.String cardistance) {
		this.cardistance = cardistance;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getAgefrom()
	 */
	@Override
	public java.lang.String getAgefrom () {
		return agefrom;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setAgefrom(java.lang.String)
	 */
	@Override
	public void setAgefrom (java.lang.String agefrom) {
		this.agefrom = agefrom;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getAgeto()
	 */
	@Override
	public java.lang.String getAgeto () {
		return ageto;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setAgeto(java.lang.String)
	 */
	@Override
	public void setAgeto (java.lang.String ageto) {
		this.ageto = ageto;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getBeachaccess()
	 */
	@Override
	public java.lang.String getBeachaccess () {
		return beachaccess;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setBeachaccess(java.lang.String)
	 */
	@Override
	public void setBeachaccess (java.lang.String beachaccess) {
		this.beachaccess = beachaccess;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getBeachapart()
	 */
	@Override
	public java.lang.String getBeachapart () {
		return beachapart;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setBeachapart(java.lang.String)
	 */
	@Override
	public void setBeachapart (java.lang.String beachapart) {
		this.beachapart = beachapart;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getConcept()
	 */
	@Override
	public java.lang.String getConcept () {
		return concept;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setConcept(java.lang.String)
	 */
	@Override
	public void setConcept (java.lang.String concept) {
		this.concept = concept;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getBasicflag()
	 */
	@Override
	public java.lang.String getBasicflag () {
		return basicflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setBasicflag(java.lang.String)
	 */
	@Override
	public void setBasicflag (java.lang.String basicflag) {
		this.basicflag = basicflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getTypologycode()
	 */
	@Override
	public java.lang.String getTypologycode () {
		return typologycode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setTypologycode(java.lang.String)
	 */
	@Override
	public void setTypologycode (java.lang.String typologycode) {
		this.typologycode = typologycode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getTextflag()
	 */
	@Override
	public java.lang.String getTextflag () {
		return textflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setTextflag(java.lang.String)
	 */
	@Override
	public void setTextflag (java.lang.String textflag) {
		this.textflag = textflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getNumberflag()
	 */
	@Override
	public java.lang.String getNumberflag () {
		return numberflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setNumberflag(java.lang.String)
	 */
	@Override
	public void setNumberflag (java.lang.String numberflag) {
		this.numberflag = numberflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getLogicflag()
	 */
	@Override
	public java.lang.String getLogicflag () {
		return logicflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setLogicflag(java.lang.String)
	 */
	@Override
	public void setLogicflag (java.lang.String logicflag) {
		this.logicflag = logicflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getFeeflag()
	 */
	@Override
	public java.lang.String getFeeflag () {
		return feeflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setFeeflag(java.lang.String)
	 */
	@Override
	public void setFeeflag (java.lang.String feeflag) {
		this.feeflag = feeflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getDistanceflag()
	 */
	@Override
	public java.lang.String getDistanceflag () {
		return distanceflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setDistanceflag(java.lang.String)
	 */
	@Override
	public void setDistanceflag (java.lang.String distanceflag) {
		this.distanceflag = distanceflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getWalkingdistanceflag()
	 */
	@Override
	public java.lang.String getWalkingdistanceflag () {
		return walkingdistanceflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setWalkingdistanceflag(java.lang.String)
	 */
	@Override
	public void setWalkingdistanceflag (java.lang.String walkingdistanceflag) {
		this.walkingdistanceflag = walkingdistanceflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getTransportdistanceflag()
	 */
	@Override
	public java.lang.String getTransportdistanceflag () {
		return transportdistanceflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setTransportdistanceflag(java.lang.String)
	 */
	@Override
	public void setTransportdistanceflag (java.lang.String transportdistanceflag) {
		this.transportdistanceflag = transportdistanceflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getCardistanceflag()
	 */
	@Override
	public java.lang.String getCardistanceflag () {
		return cardistanceflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setCardistanceflag(java.lang.String)
	 */
	@Override
	public void setCardistanceflag (java.lang.String cardistanceflag) {
		this.cardistanceflag = cardistanceflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getAgefromflag()
	 */
	@Override
	public java.lang.String getAgefromflag () {
		return agefromflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setAgefromflag(java.lang.String)
	 */
	@Override
	public void setAgefromflag (java.lang.String agefromflag) {
		this.agefromflag = agefromflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getAgetoflag()
	 */
	@Override
	public java.lang.String getAgetoflag () {
		return agetoflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setAgetoflag(java.lang.String)
	 */
	@Override
	public void setAgetoflag (java.lang.String agetoflag) {
		this.agetoflag = agetoflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getBeachaccessflag()
	 */
	@Override
	public java.lang.String getBeachaccessflag () {
		return beachaccessflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setBeachaccessflag(java.lang.String)
	 */
	@Override
	public void setBeachaccessflag (java.lang.String beachaccessflag) {
		this.beachaccessflag = beachaccessflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getBeachapartflag()
	 */
	@Override
	public java.lang.String getBeachapartflag () {
		return beachapartflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setBeachapartflag(java.lang.String)
	 */
	@Override
	public void setBeachapartflag (java.lang.String beachapartflag) {
		this.beachapartflag = beachapartflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getDynamicflag()
	 */
	@Override
	public java.lang.String getDynamicflag () {
		return dynamicflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setDynamicflag(java.lang.String)
	 */
	@Override
	public void setDynamicflag (java.lang.String dynamicflag) {
		this.dynamicflag = dynamicflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getConceptflag()
	 */
	@Override
	public java.lang.String getConceptflag () {
		return conceptflag;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setConceptflag(java.lang.String)
	 */
	@Override
	public void setConceptflag (java.lang.String conceptflag) {
		this.conceptflag = conceptflag;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getName()
	 */
	@Override
	public java.lang.String getName () {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setName(java.lang.String)
	 */
	@Override
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#getGroupdes()
	 */
	@Override
	public java.lang.String getGroupdes () {
		return groupdes;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#setGroupdes(java.lang.String)
	 */
	@Override
	public void setGroupdes (java.lang.String groupdes) {
		this.groupdes = groupdes;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHdetailFacilities)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHdetailFacilities bdlvHdetailFacilities = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHdetailFacilities) obj;
			if (null == this.getId() || null == bdlvHdetailFacilities.getId()) return false;
			else return (this.getId().equals(bdlvHdetailFacilities.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#hashCode()
	 */
	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilities#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}