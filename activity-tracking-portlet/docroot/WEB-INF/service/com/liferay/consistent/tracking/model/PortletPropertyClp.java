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

import com.liferay.consistent.tracking.service.PortletPropertyLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza Soloisolo
 */
public class PortletPropertyClp extends BaseModelImpl<PortletProperty>
	implements PortletProperty {
	public PortletPropertyClp() {
	}

	public Class<?> getModelClass() {
		return PortletProperty.class;
	}

	public String getModelClassName() {
		return PortletProperty.class.getName();
	}

	public long getPrimaryKey() {
		return _propertyId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPropertyId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_propertyId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertyId", getPropertyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
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

	public long getPropertyId() {
		return _propertyId;
	}

	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public BaseModel<?> getPortletPropertyRemoteModel() {
		return _portletPropertyRemoteModel;
	}

	public void setPortletPropertyRemoteModel(
		BaseModel<?> portletPropertyRemoteModel) {
		_portletPropertyRemoteModel = portletPropertyRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PortletPropertyLocalServiceUtil.addPortletProperty(this);
		}
		else {
			PortletPropertyLocalServiceUtil.updatePortletProperty(this);
		}
	}

	@Override
	public PortletProperty toEscapedModel() {
		return (PortletProperty)Proxy.newProxyInstance(PortletProperty.class.getClassLoader(),
			new Class[] { PortletProperty.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortletPropertyClp clone = new PortletPropertyClp();

		clone.setPropertyId(getPropertyId());
		clone.setCompanyId(getCompanyId());
		clone.setName(getName());
		clone.setValue(getValue());

		return clone;
	}

	public int compareTo(PortletProperty portletProperty) {
		int value = 0;

		value = getName().compareTo(portletProperty.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PortletPropertyClp portletProperty = null;

		try {
			portletProperty = (PortletPropertyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = portletProperty.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{propertyId=");
		sb.append(getPropertyId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.PortletProperty");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>propertyId</column-name><column-value><![CDATA[");
		sb.append(getPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _propertyId;
	private long _companyId;
	private String _name;
	private String _value;
	private BaseModel<?> _portletPropertyRemoteModel;
}