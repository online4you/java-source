package com.photel.interfaces.data.BDL;

public interface IBdlvHimages {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 */
	public abstract IBdlvHimagesPK getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public abstract void setId(IBdlvHimagesPK id);

	/**
	 * Return the value associated with the column: VISUALIZATIONORDER
	 */
	public abstract java.lang.String getVisualizationorder();

	/**
	 * Set the value related to the column: VISUALIZATIONORDER
	 * @param visualizationorder the VISUALIZATIONORDER value
	 */
	public abstract void setVisualizationorder(
			java.lang.String visualizationorder);

	/**
	 * Return the value associated with the column: IMAGEPATH
	 */
	public abstract java.lang.String getImagepath();

	/**
	 * Set the value related to the column: IMAGEPATH
	 * @param imagepath the IMAGEPATH value
	 */
	public abstract void setImagepath(java.lang.String imagepath);

	/**
	 * Return the value associated with the column: NAME
	 */
	public abstract java.lang.String getName();

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public abstract void setName(java.lang.String name);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}