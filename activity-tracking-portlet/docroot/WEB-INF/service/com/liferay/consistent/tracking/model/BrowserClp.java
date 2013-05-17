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

import com.liferay.consistent.tracking.service.BrowserLocalServiceUtil;

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
public class BrowserClp extends BaseModelImpl<Browser> implements Browser {
	public BrowserClp() {
	}

	public Class<?> getModelClass() {
		return Browser.class;
	}

	public String getModelClassName() {
		return Browser.class.getName();
	}

	public long getPrimaryKey() {
		return _browserId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBrowserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_browserId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("browserId", getBrowserId());
		attributes.put("name", getName());
		attributes.put("version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long browserId = (Long)attributes.get("browserId");

		if (browserId != null) {
			setBrowserId(browserId);
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

	public long getBrowserId() {
		return _browserId;
	}

	public void setBrowserId(long browserId) {
		_browserId = browserId;
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

	public BaseModel<?> getBrowserRemoteModel() {
		return _browserRemoteModel;
	}

	public void setBrowserRemoteModel(BaseModel<?> browserRemoteModel) {
		_browserRemoteModel = browserRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BrowserLocalServiceUtil.addBrowser(this);
		}
		else {
			BrowserLocalServiceUtil.updateBrowser(this);
		}
	}

	@Override
	public Browser toEscapedModel() {
		return (Browser)Proxy.newProxyInstance(Browser.class.getClassLoader(),
			new Class[] { Browser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BrowserClp clone = new BrowserClp();

		clone.setBrowserId(getBrowserId());
		clone.setName(getName());
		clone.setVersion(getVersion());

		return clone;
	}

	public int compareTo(Browser browser) {
		int value = 0;

		value = getName().compareTo(browser.getName());

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

		BrowserClp browser = null;

		try {
			browser = (BrowserClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = browser.getPrimaryKey();

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

		sb.append("{browserId=");
		sb.append(getBrowserId());
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
		sb.append("com.liferay.consistent.tracking.model.Browser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>browserId</column-name><column-value><![CDATA[");
		sb.append(getBrowserId());
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

	private long _browserId;
	private String _name;
	private String _version;
	private BaseModel<?> _browserRemoteModel;
}