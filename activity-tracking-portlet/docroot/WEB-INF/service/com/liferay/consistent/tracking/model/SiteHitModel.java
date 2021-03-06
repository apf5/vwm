/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.consistent.tracking.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SiteHit service. Represents a row in the &quot;CONSIS_TRACK_SiteHit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.consistent.tracking.model.impl.SiteHitModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.consistent.tracking.model.impl.SiteHitImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SiteHit
 * @see com.liferay.consistent.tracking.model.impl.SiteHitImpl
 * @see com.liferay.consistent.tracking.model.impl.SiteHitModelImpl
 * @generated
 */
public interface SiteHitModel extends BaseModel<SiteHit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a site hit model instance should use the {@link SiteHit} interface instead.
	 */

	/**
	 * Returns the primary key of this site hit.
	 *
	 * @return the primary key of this site hit
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this site hit.
	 *
	 * @param primaryKey the primary key of this site hit
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the hit ID of this site hit.
	 *
	 * @return the hit ID of this site hit
	 */
	public long getHitId();

	/**
	 * Sets the hit ID of this site hit.
	 *
	 * @param hitId the hit ID of this site hit
	 */
	public void setHitId(long hitId);

	/**
	 * Returns the company ID of this site hit.
	 *
	 * @return the company ID of this site hit
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this site hit.
	 *
	 * @param companyId the company ID of this site hit
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the site ID of this site hit.
	 *
	 * @return the site ID of this site hit
	 */
	public long getSiteId();

	/**
	 * Sets the site ID of this site hit.
	 *
	 * @param siteId the site ID of this site hit
	 */
	public void setSiteId(long siteId);

	/**
	 * Returns the guest of this site hit.
	 *
	 * @return the guest of this site hit
	 */
	public boolean getGuest();

	/**
	 * Returns <code>true</code> if this site hit is guest.
	 *
	 * @return <code>true</code> if this site hit is guest; <code>false</code> otherwise
	 */
	public boolean isGuest();

	/**
	 * Sets whether this site hit is guest.
	 *
	 * @param guest the guest of this site hit
	 */
	public void setGuest(boolean guest);

	/**
	 * Returns the access date of this site hit.
	 *
	 * @return the access date of this site hit
	 */
	public long getAccessDate();

	/**
	 * Sets the access date of this site hit.
	 *
	 * @param accessDate the access date of this site hit
	 */
	public void setAccessDate(long accessDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(SiteHit siteHit);

	public int hashCode();

	public CacheModel<SiteHit> toCacheModel();

	public SiteHit toEscapedModel();

	public String toString();

	public String toXmlString();
}