package com.photel.interfaces.data.gen;

public interface IGenTracking {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="sequence"
	 *  column="GTR_SEQ"
	 */
	public abstract java.lang.Integer getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public abstract void setId(java.lang.Integer id);

	/**
	 * Return the value associated with the column: GTR_IDESES
	 */
	public abstract java.lang.String getGtrIdeses();

	/**
	 * Set the value related to the column: GTR_IDESES
	 * @param gtrIdeses the GTR_IDESES value
	 */
	public abstract void setGtrIdeses(java.lang.String gtrIdeses);

	/**
	 * Return the value associated with the column: GTR_TMPVEN
	 */
	public abstract java.lang.String getGtrTmpven();

	/**
	 * Set the value related to the column: GTR_TMPVEN
	 * @param gtrTmpven the GTR_TMPVEN value
	 */
	public abstract void setGtrTmpven(java.lang.String gtrTmpven);

	/**
	 * Return the value associated with the column: GTR_IDVEN
	 */
	public abstract java.lang.String getGtrIdven();

	/**
	 * Set the value related to the column: GTR_IDVEN
	 * @param gtrIdven the GTR_IDVEN value
	 */
	public abstract void setGtrIdven(java.lang.String gtrIdven);

	/**
	 * Return the value associated with the column: GTR_NUMEXP
	 */
	public abstract java.lang.String getGtrNumexp();

	/**
	 * Set the value related to the column: GTR_NUMEXP
	 * @param gtrNumexp the GTR_NUMEXP value
	 */
	public abstract void setGtrNumexp(java.lang.String gtrNumexp);

	/**
	 * Return the value associated with the column: GTR_DATCRE
	 */
	public abstract java.util.Date getGtrDatcre();

	/**
	 * Set the value related to the column: GTR_DATCRE
	 * @param gtrDatcre the GTR_DATCRE value
	 */
	public abstract void setGtrDatcre(java.util.Date gtrDatcre);

	/**
	 * Return the value associated with the column: GTR_ORICLA
	 */
	public abstract java.lang.String getGtrOricla();

	/**
	 * Set the value related to the column: GTR_ORICLA
	 * @param gtrOricla the GTR_ORICLA value
	 */
	public abstract void setGtrOricla(java.lang.String gtrOricla);

	/**
	 * Return the value associated with the column: GTR_ORIMET
	 */
	public abstract java.lang.String getGtrOrimet();

	/**
	 * Set the value related to the column: GTR_ORIMET
	 * @param gtrOrimet the GTR_ORIMET value
	 */
	public abstract void setGtrOrimet(java.lang.String gtrOrimet);

	/**
	 * Return the value associated with the column: GTR_DESGTR
	 */
	public abstract java.lang.String getGtrDesgtr();

	/**
	 * Set the value related to the column: GTR_DESGTR
	 * @param gtrDesgtr the GTR_DESGTR value
	 */
	public abstract void setGtrDesgtr(java.lang.String gtrDesgtr);

	/**
	 * Return the value associated with the column: GTR_TIPGTR
	 */
	public abstract java.lang.String getGtrTipgtr();

	/**
	 * Set the value related to the column: GTR_TIPGTR
	 * @param gtrTipgtr the GTR_TIPGTR value
	 */
	public abstract void setGtrTipgtr(java.lang.String gtrTipgtr);

	/**
	 * Return the value associated with the column: GTR_DATOS
	 */
	public abstract java.lang.String getGtrDatos();

	/**
	 * Set the value related to the column: GTR_DATOS
	 * @param gtrDatos the GTR_DATOS value
	 */
	public abstract void setGtrDatos(java.lang.String gtrDatos);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();
	
	public java.lang.String getGtrNivel();
	public void setGtrNivel(java.lang.String gtrNivel);

	public java.lang.String getGtrMaquina();
	public void setGtrMaquina(java.lang.String gtrMaquina);
	public java.lang.String getGtrSite() ;
	public void setGtrSite(java.lang.String gtrSite);
	
	public java.lang.String getGtrLine() ;
	public void setGtrLine(java.lang.String gtrLine);
}