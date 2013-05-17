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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SiteHit}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       SiteHit
 * @generated
 */
public class SiteHitWrapper implements SiteHit, ModelWrapper<SiteHit> {
	public SiteHitWrapper(SiteHit siteHit) {
		_siteHit = siteHit;
	}

	public Class<?> getModelClass() {
		return SiteHit.class;
	}

	public String getModelClassName() {
		return SiteHit.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("siteId", getSiteId());
		attributes.put("guest", getGuest());
		attributes.put("accessDate", getAccessDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long hitId = (Long)attributes.get("hitId");

		if (hitId != null) {
			setHitId(hitId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}

		Boolean guest = (Boolean)attributes.get("guest");

		if (guest != null) {
			setGuest(guest);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}
	}

	/**
	* Returns the primary key of this site hit.
	*
	* @return the primary key of this site hit
	*/
	public long getPrimaryKey() {
		return _siteHit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this site hit.
	*
	* @param primaryKey the primary key of this site hit
	*/
	public void setPrimaryKey(long primaryKey) {
		_siteHit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the hit ID of this site hit.
	*
	* @return the hit ID of this site hit
	*/
	public long getHitId() {
		return _siteHit.getHitId();
	}

	/**
	* Sets the hit ID of this site hit.
	*
	* @param hitId the hit ID of this site hit
	*/
	public void setHitId(long hitId) {
		_siteHit.setHitId(hitId);
	}

	/**
	* Returns the company ID of this site hit.
	*
	* @return the company ID of this site hit
	*/
	public long getCompanyId() {
		return _siteHit.getCompanyId();
	}

	/**
	* Sets the company ID of this site hit.
	*
	* @param companyId the company ID of this site hit
	*/
	public void setCompanyId(long companyId) {
		_siteHit.setCompanyId(companyId);
	}

	/**
	* Returns the site ID of this site hit.
	*
	* @return the site ID of this site hit
	*/
	public long getSiteId() {
		return _siteHit.getSiteId();
	}

	/**
	* Sets the site ID of this site hit.
	*
	* @param siteId the site ID of this site hit
	*/
	public void setSiteId(long siteId) {
		_siteHit.setSiteId(siteId);
	}

	/**
	* Returns the guest of this site hit.
	*
	* @return the guest of this site hit
	*/
	public boolean getGuest() {
		return _siteHit.getGuest();
	}

	/**
	* Returns <code>true</code> if this site hit is guest.
	*
	* @return <code>true</code> if this site hit is guest; <code>false</code> otherwise
	*/
	public boolean isGuest() {
		return _siteHit.isGuest();
	}

	/**
	* Sets whether this site hit is guest.
	*
	* @param guest the guest of this site hit
	*/
	public void setGuest(boolean guest) {
		_siteHit.setGuest(guest);
	}

	/**
	* Returns the access date of this site hit.
	*
	* @return the access date of this site hit
	*/
	public long getAccessDate() {
		return _siteHit.getAccessDate();
	}

	/**
	* Sets the access date of this site hit.
	*
	* @param accessDate the access date of this site hit
	*/
	public void setAccessDate(long accessDate) {
		_siteHit.setAccessDate(accessDate);
	}

	public boolean isNew() {
		return _siteHit.isNew();
	}

	public void setNew(boolean n) {
		_siteHit.setNew(n);
	}

	public boolean isCachedModel() {
		return _siteHit.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_siteHit.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _siteHit.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _siteHit.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_siteHit.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _siteHit.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_siteHit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SiteHitWrapper((SiteHit)_siteHit.clone());
	}

	public int compareTo(com.liferay.consistent.tracking.model.SiteHit siteHit) {
		return _siteHit.compareTo(siteHit);
	}

	@Override
	public int hashCode() {
		return _siteHit.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.SiteHit> toCacheModel() {
		return _siteHit.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.SiteHit toEscapedModel() {
		return new SiteHitWrapper(_siteHit.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _siteHit.toString();
	}

	public java.lang.String toXmlString() {
		return _siteHit.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_siteHit.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SiteHit getWrappedSiteHit() {
		return _siteHit;
	}

	public SiteHit getWrappedModel() {
		return _siteHit;
	}

	public void resetOriginalValues() {
		_siteHit.resetOriginalValues();
	}

	private SiteHit _siteHit;
}