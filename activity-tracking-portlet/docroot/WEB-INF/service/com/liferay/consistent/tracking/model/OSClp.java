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

import com.liferay.consistent.tracking.service.OSLocalServiceUtil;

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
public class OSClp extends BaseModelImpl<OS> implements OS {
	public OSClp() {
	}

	public Class<?> getModelClass() {
		return OS.class;
	}

	public String getModelClassName() {
		return OS.class.getName();
	}

	public long getPrimaryKey() {
		return _osId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOsId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_osId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("osId", getOsId());
		attributes.put("name", getName());
		attributes.put("version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long osId = (Long)attributes.get("osId");

		if (osId != null) {
			setOsId(osId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}
	}

	public long getOsId() {
		return _osId;
	}

	public void setOsId(long osId) {
		_osId = osId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public BaseModel<?> getOSRemoteModel() {
		return _osRemoteModel;
	}

	public void setOSRemoteModel(BaseModel<?> osRemoteModel) {
		_osRemoteModel = osRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OSLocalServiceUtil.addOS(this);
		}
		else {
			OSLocalServiceUtil.updateOS(this);
		}
	}

	@Override
	public OS toEscapedModel() {
		return (OS)Proxy.newProxyInstance(OS.class.getClassLoader(),
			new Class[] { OS.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OSClp clone = new OSClp();

		clone.setOsId(getOsId());
		clone.setName(getName());
		clone.setVersion(getVersion());

		return clone;
	}

	public int compareTo(OS os) {
		int value = 0;

		value = getName().compareTo(os.getName());

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

		OSClp os = null;

		try {
			os = (OSClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = os.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{osId=");
		sb.append(getOsId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.OS");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>osId</column-name><column-value><![CDATA[");
		sb.append(getOsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _osId;
	private String _name;
	private String _version;
	private BaseModel<?> _osRemoteModel;
}