package com.photel.interfaces.data.BDL;


public interface IBdlConfigSite {

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#getId()
	 */
	public abstract IBdlConfigSitePK getId();

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#setId(com.photel.data.BDL.ddbb.hibernate.pojo.GenConfigSitePK)
	 */
	public abstract void setId(IBdlConfigSitePK id);

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#getBdlValue()
	 */
	public abstract java.lang.String getBdlValue();

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#setBdlValue(java.lang.String)
	 */
	public abstract void setBdlValue(java.lang.String bdlValue);

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#equals(java.lang.Object)
	 */
	public abstract boolean equals(Object obj);

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#hashCode()
	 */
	public abstract int hashCode();

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#toString()
	 */
	public abstract String toString();

}