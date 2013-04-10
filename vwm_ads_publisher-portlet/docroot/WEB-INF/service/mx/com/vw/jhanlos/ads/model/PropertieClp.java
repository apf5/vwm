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

package mx.com.vw.jhanlos.ads.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import mx.com.vw.jhanlos.ads.service.PropertieLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza
 */
public class PropertieClp extends BaseModelImpl<Propertie> implements Propertie {
	public PropertieClp() {
	}

	public Class<?> getModelClass() {
		return Propertie.class;
	}

	public String getModelClassName() {
		return Propertie.class.getName();
	}

	public long getPrimaryKey() {
		return _propertieId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPropertieId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_propertieId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertieId", getPropertieId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertieId = (Long)attributes.get("propertieId");

		if (propertieId != null) {
			setPropertieId(propertieId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
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

	public long getPropertieId() {
		return _propertieId;
	}

	public void setPropertieId(long propertieId) {
		_propertieId = propertieId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	public long getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		_modifiedDate = modifiedDate;
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

	public BaseModel<?> getPropertieRemoteModel() {
		return _propertieRemoteModel;
	}

	public void setPropertieRemoteModel(BaseModel<?> propertieRemoteModel) {
		_propertieRemoteModel = propertieRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PropertieLocalServiceUtil.addPropertie(this);
		}
		else {
			PropertieLocalServiceUtil.updatePropertie(this);
		}
	}

	@Override
	public Propertie toEscapedModel() {
		return (Propertie)Proxy.newProxyInstance(Propertie.class.getClassLoader(),
			new Class[] { Propertie.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PropertieClp clone = new PropertieClp();

		clone.setPropertieId(getPropertieId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setValue(getValue());

		return clone;
	}

	public int compareTo(Propertie propertie) {
		int value = 0;

		value = getName().compareTo(propertie.getName());

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

		PropertieClp propertie = null;

		try {
			propertie = (PropertieClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = propertie.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{propertieId=");
		sb.append(getPropertieId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("mx.com.vw.jhanlos.ads.model.Propertie");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>propertieId</column-name><column-value><![CDATA[");
		sb.append(getPropertieId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
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

	private long _propertieId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _createDate;
	private long _modifiedDate;
	private String _name;
	private String _value;
	private BaseModel<?> _propertieRemoteModel;
}