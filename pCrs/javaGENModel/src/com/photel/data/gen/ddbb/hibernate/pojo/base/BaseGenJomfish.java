package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenJomfish;


/**
 * This is an object that contains data related to the gen_jomfish table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="gen_jomfish"
 */

public abstract class BaseGenJomfish  implements Serializable, IGenJomfish {

	public static String REF = "GenJomfish";
	public static String PROP_REFERENCE_TABLE = "ReferenceTable";
	public static String PROP_VALUE = "Value";
	public static String PROP_PUBLISHED = "Published";
	public static String PROP_SHORTCODE = "Shortcode";
	public static String PROP_MODIFIED = "Modified";
	public static String PROP_MODIFIED_BY = "ModifiedBy";
	public static String PROP_REFERENCE_FIELD = "ReferenceField";
	public static String PROP_ID = "Id";
	public static String PROP_ORIGINAL_TEXT = "OriginalText";
	public static String PROP_ORIGINAL_VALUE = "OriginalValue";
	public static String PROP_LANGUAGE_ID = "LanguageId";
	public static String PROP_REFERENCE_ID = "ReferenceId";


	// constructors
	public BaseGenJomfish () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenJomfish (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGenJomfish (
		java.lang.Integer id,
		java.lang.Integer languageId,
		java.lang.Integer referenceId,
		java.lang.String referenceTable,
		java.lang.String referenceField,
		java.lang.String value,
		java.lang.String originalText,
		java.util.Date modified,
		java.lang.Integer modifiedBy,
		boolean published) {

		this.setId(id);
		this.setLanguageId(languageId);
		this.setReferenceId(referenceId);
		this.setReferenceTable(referenceTable);
		this.setReferenceField(referenceField);
		this.setValue(value);
		this.setOriginalText(originalText);
		this.setModified(modified);
		this.setModifiedBy(modifiedBy);
		this.setPublished(published);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String shortcode;
	private java.lang.Integer languageId;
	private java.lang.Integer referenceId;
	private java.lang.String referenceTable;
	private java.lang.String referenceField;
	private java.lang.String value;
	private java.lang.String originalValue;
	private java.lang.String originalText;
	private java.util.Date modified;
	private java.lang.Integer modifiedBy;
	private boolean published;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getId()
	 */
	@Override
	public java.lang.Integer getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setId(java.lang.Integer)
	 */
	@Override
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getShortcode()
	 */
	@Override
	public java.lang.String getShortcode () {
		return shortcode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setShortcode(java.lang.String)
	 */
	@Override
	public void setShortcode (java.lang.String shortcode) {
		this.shortcode = shortcode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getLanguageId()
	 */
	@Override
	public java.lang.Integer getLanguageId () {
		return languageId;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setLanguageId(java.lang.Integer)
	 */
	@Override
	public void setLanguageId (java.lang.Integer languageId) {
		this.languageId = languageId;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getReferenceId()
	 */
	@Override
	public java.lang.Integer getReferenceId () {
		return referenceId;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setReferenceId(java.lang.Integer)
	 */
	@Override
	public void setReferenceId (java.lang.Integer referenceId) {
		this.referenceId = referenceId;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getReferenceTable()
	 */
	@Override
	public java.lang.String getReferenceTable () {
		return referenceTable;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setReferenceTable(java.lang.String)
	 */
	@Override
	public void setReferenceTable (java.lang.String referenceTable) {
		this.referenceTable = referenceTable;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getReferenceField()
	 */
	@Override
	public java.lang.String getReferenceField () {
		return referenceField;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setReferenceField(java.lang.String)
	 */
	@Override
	public void setReferenceField (java.lang.String referenceField) {
		this.referenceField = referenceField;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getValue()
	 */
	@Override
	public java.lang.String getValue () {
		return value;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setValue(java.lang.String)
	 */
	@Override
	public void setValue (java.lang.String value) {
		this.value = value;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getOriginalValue()
	 */
	@Override
	public java.lang.String getOriginalValue () {
		return originalValue;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setOriginalValue(java.lang.String)
	 */
	@Override
	public void setOriginalValue (java.lang.String originalValue) {
		this.originalValue = originalValue;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getOriginalText()
	 */
	@Override
	public java.lang.String getOriginalText () {
		return originalText;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setOriginalText(java.lang.String)
	 */
	@Override
	public void setOriginalText (java.lang.String originalText) {
		this.originalText = originalText;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getModified()
	 */
	@Override
	public java.util.Date getModified () {
		return modified;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setModified(java.util.Date)
	 */
	@Override
	public void setModified (java.util.Date modified) {
		this.modified = modified;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#getModifiedBy()
	 */
	@Override
	public java.lang.Integer getModifiedBy () {
		return modifiedBy;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setModifiedBy(java.lang.Integer)
	 */
	@Override
	public void setModifiedBy (java.lang.Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#isPublished()
	 */
	@Override
	public boolean isPublished () {
		return published;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#setPublished(boolean)
	 */
	@Override
	public void setPublished (boolean published) {
		this.published = published;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenJomfish)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenJomfish genJomfish = (com.photel.data.gen.ddbb.hibernate.pojo.GenJomfish) obj;
			if (null == this.getId() || null == genJomfish.getId()) return false;
			else return (this.getId().equals(genJomfish.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#hashCode()
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
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenJomfish#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}