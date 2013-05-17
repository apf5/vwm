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
 * This class is a wrapper for {@link PortletProperty}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       PortletProperty
 * @generated
 */
public class PortletPropertyWrapper implements PortletProperty,
	ModelWrapper<PortletProperty> {
	public PortletPropertyWrapper(PortletProperty portletProperty) {
		_portletProperty = portletProperty;
	}

	public Class<?> getModelClass() {
		return PortletProperty.class;
	}

	public String getModelClassName() {
		return PortletProperty.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertyId", getPropertyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this portlet property.
	*
	* @return the primary key of this portlet property
	*/
	public long getPrimaryKey() {
		return _portletProperty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this portlet property.
	*
	* @param primaryKey the primary key of this portlet property
	*/
	public void setPrimaryKey(long primaryKey) {
		_portletProperty.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the property ID of this portlet property.
	*
	* @return the property ID of this portlet property
	*/
	public long getPropertyId() {
		return _portletProperty.getPropertyId();
	}

	/**
	* Sets the property ID of this portlet property.
	*
	* @param propertyId the property ID of this portlet property
	*/
	public void setPropertyId(long propertyId) {
		_portletProperty.setPropertyId(propertyId);
	}

	/**
	* Returns the company ID of this portlet property.
	*
	* @return the company ID of this portlet property
	*/
	public long getCompanyId() {
		return _portletProperty.getCompanyId();
	}

	/**
	* Sets the company ID of this portlet property.
	*
	* @param companyId the company ID of this portlet property
	*/
	public void setCompanyId(long companyId) {
		_portletProperty.setCompanyId(companyId);
	}

	/**
	* Returns the name of this portlet property.
	*
	* @return the name of this portlet property
	*/
	public java.lang.String getName() {
		return _portletProperty.getName();
	}

	/**
	* Sets the name of this portlet property.
	*
	* @param name the name of this portlet property
	*/
	public void setName(java.lang.String name) {
		_portletProperty.setName(name);
	}

	/**
	* Returns the value of this portlet property.
	*
	* @return the value of this portlet property
	*/
	public java.lang.String getValue() {
		return _portletProperty.getValue();
	}

	/**
	* Sets the value of this portlet property.
	*
	* @param value the value of this portlet property
	*/
	public void setValue(java.lang.String value) {
		_portletProperty.setValue(value);
	}

	public boolean isNew() {
		return _portletProperty.isNew();
	}

	public void setNew(boolean n) {
		_portletProperty.setNew(n);
	}

	public boolean isCachedModel() {
		return _portletProperty.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_portletProperty.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _portletProperty.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _portletProperty.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portletProperty.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portletProperty.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portletProperty.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortletPropertyWrapper((PortletProperty)_portletProperty.clone());
	}

	public int compareTo(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty) {
		return _portletProperty.compareTo(portletProperty);
	}

	@Override
	public int hashCode() {
		return _portletProperty.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.PortletProperty> toCacheModel() {
		return _portletProperty.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.PortletProperty toEscapedModel() {
		return new PortletPropertyWrapper(_portletProperty.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portletProperty.toString();
	}

	public java.lang.String toXmlString() {
		return _portletProperty.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletProperty.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PortletProperty getWrappedPortletProperty() {
		return _portletProperty;
	}

	public PortletProperty getWrappedModel() {
		return _portletProperty;
	}

	public void resetOriginalValues() {
		_portletProperty.resetOriginalValues();
	}

	private PortletProperty _portletProperty;
}