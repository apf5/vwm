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
 * This class is a wrapper for {@link OrganizationHit}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       OrganizationHit
 * @generated
 */
public class OrganizationHitWrapper implements OrganizationHit,
	ModelWrapper<OrganizationHit> {
	public OrganizationHitWrapper(OrganizationHit organizationHit) {
		_organizationHit = organizationHit;
	}

	public Class<?> getModelClass() {
		return OrganizationHit.class;
	}

	public String getModelClassName() {
		return OrganizationHit.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("organizationId", getOrganizationId());
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

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
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
	* Returns the primary key of this organization hit.
	*
	* @return the primary key of this organization hit
	*/
	public long getPrimaryKey() {
		return _organizationHit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organization hit.
	*
	* @param primaryKey the primary key of this organization hit
	*/
	public void setPrimaryKey(long primaryKey) {
		_organizationHit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the hit ID of this organization hit.
	*
	* @return the hit ID of this organization hit
	*/
	public long getHitId() {
		return _organizationHit.getHitId();
	}

	/**
	* Sets the hit ID of this organization hit.
	*
	* @param hitId the hit ID of this organization hit
	*/
	public void setHitId(long hitId) {
		_organizationHit.setHitId(hitId);
	}

	/**
	* Returns the company ID of this organization hit.
	*
	* @return the company ID of this organization hit
	*/
	public long getCompanyId() {
		return _organizationHit.getCompanyId();
	}

	/**
	* Sets the company ID of this organization hit.
	*
	* @param companyId the company ID of this organization hit
	*/
	public void setCompanyId(long companyId) {
		_organizationHit.setCompanyId(companyId);
	}

	/**
	* Returns the organization ID of this organization hit.
	*
	* @return the organization ID of this organization hit
	*/
	public long getOrganizationId() {
		return _organizationHit.getOrganizationId();
	}

	/**
	* Sets the organization ID of this organization hit.
	*
	* @param organizationId the organization ID of this organization hit
	*/
	public void setOrganizationId(long organizationId) {
		_organizationHit.setOrganizationId(organizationId);
	}

	/**
	* Returns the guest of this organization hit.
	*
	* @return the guest of this organization hit
	*/
	public boolean getGuest() {
		return _organizationHit.getGuest();
	}

	/**
	* Returns <code>true</code> if this organization hit is guest.
	*
	* @return <code>true</code> if this organization hit is guest; <code>false</code> otherwise
	*/
	public boolean isGuest() {
		return _organizationHit.isGuest();
	}

	/**
	* Sets whether this organization hit is guest.
	*
	* @param guest the guest of this organization hit
	*/
	public void setGuest(boolean guest) {
		_organizationHit.setGuest(guest);
	}

	/**
	* Returns the access date of this organization hit.
	*
	* @return the access date of this organization hit
	*/
	public long getAccessDate() {
		return _organizationHit.getAccessDate();
	}

	/**
	* Sets the access date of this organization hit.
	*
	* @param accessDate the access date of this organization hit
	*/
	public void setAccessDate(long accessDate) {
		_organizationHit.setAccessDate(accessDate);
	}

	public boolean isNew() {
		return _organizationHit.isNew();
	}

	public void setNew(boolean n) {
		_organizationHit.setNew(n);
	}

	public boolean isCachedModel() {
		return _organizationHit.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_organizationHit.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _organizationHit.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _organizationHit.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organizationHit.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organizationHit.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organizationHit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationHitWrapper((OrganizationHit)_organizationHit.clone());
	}

	public int compareTo(
		com.liferay.consistent.tracking.model.OrganizationHit organizationHit) {
		return _organizationHit.compareTo(organizationHit);
	}

	@Override
	public int hashCode() {
		return _organizationHit.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.OrganizationHit> toCacheModel() {
		return _organizationHit.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.OrganizationHit toEscapedModel() {
		return new OrganizationHitWrapper(_organizationHit.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organizationHit.toString();
	}

	public java.lang.String toXmlString() {
		return _organizationHit.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organizationHit.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public OrganizationHit getWrappedOrganizationHit() {
		return _organizationHit;
	}

	public OrganizationHit getWrappedModel() {
		return _organizationHit;
	}

	public void resetOriginalValues() {
		_organizationHit.resetOriginalValues();
	}

	private OrganizationHit _organizationHit;
}