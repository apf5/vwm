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
 * This class is a wrapper for {@link PortletHit}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       PortletHit
 * @generated
 */
public class PortletHitWrapper implements PortletHit, ModelWrapper<PortletHit> {
	public PortletHitWrapper(PortletHit portletHit) {
		_portletHit = portletHit;
	}

	public Class<?> getModelClass() {
		return PortletHit.class;
	}

	public String getModelClassName() {
		return PortletHit.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("portletId", getPortletId());
		attributes.put("guest", getGuest());
		attributes.put("userId", getUserId());
		attributes.put("userlogId", getUserlogId());
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

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Boolean guest = (Boolean)attributes.get("guest");

		if (guest != null) {
			setGuest(guest);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}
	}

	/**
	* Returns the primary key of this portlet hit.
	*
	* @return the primary key of this portlet hit
	*/
	public long getPrimaryKey() {
		return _portletHit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this portlet hit.
	*
	* @param primaryKey the primary key of this portlet hit
	*/
	public void setPrimaryKey(long primaryKey) {
		_portletHit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the hit ID of this portlet hit.
	*
	* @return the hit ID of this portlet hit
	*/
	public long getHitId() {
		return _portletHit.getHitId();
	}

	/**
	* Sets the hit ID of this portlet hit.
	*
	* @param hitId the hit ID of this portlet hit
	*/
	public void setHitId(long hitId) {
		_portletHit.setHitId(hitId);
	}

	/**
	* Returns the company ID of this portlet hit.
	*
	* @return the company ID of this portlet hit
	*/
	public long getCompanyId() {
		return _portletHit.getCompanyId();
	}

	/**
	* Sets the company ID of this portlet hit.
	*
	* @param companyId the company ID of this portlet hit
	*/
	public void setCompanyId(long companyId) {
		_portletHit.setCompanyId(companyId);
	}

	/**
	* Returns the portlet ID of this portlet hit.
	*
	* @return the portlet ID of this portlet hit
	*/
	public java.lang.String getPortletId() {
		return _portletHit.getPortletId();
	}

	/**
	* Sets the portlet ID of this portlet hit.
	*
	* @param portletId the portlet ID of this portlet hit
	*/
	public void setPortletId(java.lang.String portletId) {
		_portletHit.setPortletId(portletId);
	}

	/**
	* Returns the guest of this portlet hit.
	*
	* @return the guest of this portlet hit
	*/
	public boolean getGuest() {
		return _portletHit.getGuest();
	}

	/**
	* Returns <code>true</code> if this portlet hit is guest.
	*
	* @return <code>true</code> if this portlet hit is guest; <code>false</code> otherwise
	*/
	public boolean isGuest() {
		return _portletHit.isGuest();
	}

	/**
	* Sets whether this portlet hit is guest.
	*
	* @param guest the guest of this portlet hit
	*/
	public void setGuest(boolean guest) {
		_portletHit.setGuest(guest);
	}

	/**
	* Returns the user ID of this portlet hit.
	*
	* @return the user ID of this portlet hit
	*/
	public long getUserId() {
		return _portletHit.getUserId();
	}

	/**
	* Sets the user ID of this portlet hit.
	*
	* @param userId the user ID of this portlet hit
	*/
	public void setUserId(long userId) {
		_portletHit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this portlet hit.
	*
	* @return the user uuid of this portlet hit
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHit.getUserUuid();
	}

	/**
	* Sets the user uuid of this portlet hit.
	*
	* @param userUuid the user uuid of this portlet hit
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_portletHit.setUserUuid(userUuid);
	}

	/**
	* Returns the userlog ID of this portlet hit.
	*
	* @return the userlog ID of this portlet hit
	*/
	public long getUserlogId() {
		return _portletHit.getUserlogId();
	}

	/**
	* Sets the userlog ID of this portlet hit.
	*
	* @param userlogId the userlog ID of this portlet hit
	*/
	public void setUserlogId(long userlogId) {
		_portletHit.setUserlogId(userlogId);
	}

	/**
	* Returns the access date of this portlet hit.
	*
	* @return the access date of this portlet hit
	*/
	public long getAccessDate() {
		return _portletHit.getAccessDate();
	}

	/**
	* Sets the access date of this portlet hit.
	*
	* @param accessDate the access date of this portlet hit
	*/
	public void setAccessDate(long accessDate) {
		_portletHit.setAccessDate(accessDate);
	}

	public boolean isNew() {
		return _portletHit.isNew();
	}

	public void setNew(boolean n) {
		_portletHit.setNew(n);
	}

	public boolean isCachedModel() {
		return _portletHit.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_portletHit.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _portletHit.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _portletHit.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portletHit.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portletHit.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portletHit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortletHitWrapper((PortletHit)_portletHit.clone());
	}

	public int compareTo(
		com.liferay.consistent.tracking.model.PortletHit portletHit) {
		return _portletHit.compareTo(portletHit);
	}

	@Override
	public int hashCode() {
		return _portletHit.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.PortletHit> toCacheModel() {
		return _portletHit.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.PortletHit toEscapedModel() {
		return new PortletHitWrapper(_portletHit.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portletHit.toString();
	}

	public java.lang.String toXmlString() {
		return _portletHit.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletHit.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PortletHit getWrappedPortletHit() {
		return _portletHit;
	}

	public PortletHit getWrappedModel() {
		return _portletHit;
	}

	public void resetOriginalValues() {
		_portletHit.resetOriginalValues();
	}

	private PortletHit _portletHit;
}