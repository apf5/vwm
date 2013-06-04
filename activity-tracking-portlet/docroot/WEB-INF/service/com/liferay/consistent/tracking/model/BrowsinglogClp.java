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

import com.liferay.consistent.tracking.service.BrowsinglogLocalServiceUtil;

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
public class BrowsinglogClp extends BaseModelImpl<Browsinglog>
	implements Browsinglog {
	public BrowsinglogClp() {
	}

	public Class<?> getModelClass() {
		return Browsinglog.class;
	}

	public String getModelClassName() {
		return Browsinglog.class.getName();
	}

	public long getPrimaryKey() {
		return _browsinglogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBrowsinglogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_browsinglogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("browsinglogId", getBrowsinglogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userlogId", getUserlogId());
		attributes.put("clientHost", getClientHost());
		attributes.put("clientAddr", getClientAddr());
		attributes.put("serverName", getServerName());
		attributes.put("serverPort", getServerPort());
		attributes.put("userAgent", getUserAgent());
		attributes.put("url", getUrl());
		attributes.put("plId", getPlId());
		attributes.put("accessName", getAccessName());
		attributes.put("accessFound", getAccessFound());
		attributes.put("accessDate", getAccessDate());
		attributes.put("elapseLoad", getElapseLoad());
		attributes.put("uploadSize", getUploadSize());
		attributes.put("downloadSize", getDownloadSize());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long browsinglogId = (Long)attributes.get("browsinglogId");

		if (browsinglogId != null) {
			setBrowsinglogId(browsinglogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
		}

		String clientHost = (String)attributes.get("clientHost");

		if (clientHost != null) {
			setClientHost(clientHost);
		}

		String clientAddr = (String)attributes.get("clientAddr");

		if (clientAddr != null) {
			setClientAddr(clientAddr);
		}

		String serverName = (String)attributes.get("serverName");

		if (serverName != null) {
			setServerName(serverName);
		}

		Integer serverPort = (Integer)attributes.get("serverPort");

		if (serverPort != null) {
			setServerPort(serverPort);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long plId = (Long)attributes.get("plId");

		if (plId != null) {
			setPlId(plId);
		}

		String accessName = (String)attributes.get("accessName");

		if (accessName != null) {
			setAccessName(accessName);
		}

		Boolean accessFound = (Boolean)attributes.get("accessFound");

		if (accessFound != null) {
			setAccessFound(accessFound);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}

		Long elapseLoad = (Long)attributes.get("elapseLoad");

		if (elapseLoad != null) {
			setElapseLoad(elapseLoad);
		}

		Long uploadSize = (Long)attributes.get("uploadSize");

		if (uploadSize != null) {
			setUploadSize(uploadSize);
		}

		Long downloadSize = (Long)attributes.get("downloadSize");

		if (downloadSize != null) {
			setDownloadSize(downloadSize);
		}
	}

	public long getBrowsinglogId() {
		return _browsinglogId;
	}

	public void setBrowsinglogId(long browsinglogId) {
		_browsinglogId = browsinglogId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserlogId() {
		return _userlogId;
	}

	public void setUserlogId(long userlogId) {
		_userlogId = userlogId;
	}

	public String getClientHost() {
		return _clientHost;
	}

	public void setClientHost(String clientHost) {
		_clientHost = clientHost;
	}

	public String getClientAddr() {
		return _clientAddr;
	}

	public void setClientAddr(String clientAddr) {
		_clientAddr = clientAddr;
	}

	public String getServerName() {
		return _serverName;
	}

	public void setServerName(String serverName) {
		_serverName = serverName;
	}

	public int getServerPort() {
		return _serverPort;
	}

	public void setServerPort(int serverPort) {
		_serverPort = serverPort;
	}

	public String getUserAgent() {
		return _userAgent;
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public long getPlId() {
		return _plId;
	}

	public void setPlId(long plId) {
		_plId = plId;
	}

	public String getAccessName() {
		return _accessName;
	}

	public void setAccessName(String accessName) {
		_accessName = accessName;
	}

	public boolean getAccessFound() {
		return _accessFound;
	}

	public boolean isAccessFound() {
		return _accessFound;
	}

	public void setAccessFound(boolean accessFound) {
		_accessFound = accessFound;
	}

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_accessDate = accessDate;
	}

	public long getElapseLoad() {
		return _elapseLoad;
	}

	public void setElapseLoad(long elapseLoad) {
		_elapseLoad = elapseLoad;
	}

	public long getUploadSize() {
		return _uploadSize;
	}

	public void setUploadSize(long uploadSize) {
		_uploadSize = uploadSize;
	}

	public long getDownloadSize() {
		return _downloadSize;
	}

	public void setDownloadSize(long downloadSize) {
		_downloadSize = downloadSize;
	}

	public BaseModel<?> getBrowsinglogRemoteModel() {
		return _browsinglogRemoteModel;
	}

	public void setBrowsinglogRemoteModel(BaseModel<?> browsinglogRemoteModel) {
		_browsinglogRemoteModel = browsinglogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BrowsinglogLocalServiceUtil.addBrowsinglog(this);
		}
		else {
			BrowsinglogLocalServiceUtil.updateBrowsinglog(this);
		}
	}

	@Override
	public Browsinglog toEscapedModel() {
		return (Browsinglog)Proxy.newProxyInstance(Browsinglog.class.getClassLoader(),
			new Class[] { Browsinglog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BrowsinglogClp clone = new BrowsinglogClp();

		clone.setBrowsinglogId(getBrowsinglogId());
		clone.setCompanyId(getCompanyId());
		clone.setUserlogId(getUserlogId());
		clone.setClientHost(getClientHost());
		clone.setClientAddr(getClientAddr());
		clone.setServerName(getServerName());
		clone.setServerPort(getServerPort());
		clone.setUserAgent(getUserAgent());
		clone.setUrl(getUrl());
		clone.setPlId(getPlId());
		clone.setAccessName(getAccessName());
		clone.setAccessFound(getAccessFound());
		clone.setAccessDate(getAccessDate());
		clone.setElapseLoad(getElapseLoad());
		clone.setUploadSize(getUploadSize());
		clone.setDownloadSize(getDownloadSize());

		return clone;
	}

	public int compareTo(Browsinglog browsinglog) {
		int value = 0;

		if (getAccessDate() < browsinglog.getAccessDate()) {
			value = -1;
		}
		else if (getAccessDate() > browsinglog.getAccessDate()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		BrowsinglogClp browsinglog = null;

		try {
			browsinglog = (BrowsinglogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = browsinglog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{browsinglogId=");
		sb.append(getBrowsinglogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userlogId=");
		sb.append(getUserlogId());
		sb.append(", clientHost=");
		sb.append(getClientHost());
		sb.append(", clientAddr=");
		sb.append(getClientAddr());
		sb.append(", serverName=");
		sb.append(getServerName());
		sb.append(", serverPort=");
		sb.append(getServerPort());
		sb.append(", userAgent=");
		sb.append(getUserAgent());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", plId=");
		sb.append(getPlId());
		sb.append(", accessName=");
		sb.append(getAccessName());
		sb.append(", accessFound=");
		sb.append(getAccessFound());
		sb.append(", accessDate=");
		sb.append(getAccessDate());
		sb.append(", elapseLoad=");
		sb.append(getElapseLoad());
		sb.append(", uploadSize=");
		sb.append(getUploadSize());
		sb.append(", downloadSize=");
		sb.append(getDownloadSize());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.Browsinglog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>browsinglogId</column-name><column-value><![CDATA[");
		sb.append(getBrowsinglogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userlogId</column-name><column-value><![CDATA[");
		sb.append(getUserlogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clientHost</column-name><column-value><![CDATA[");
		sb.append(getClientHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clientAddr</column-name><column-value><![CDATA[");
		sb.append(getClientAddr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverName</column-name><column-value><![CDATA[");
		sb.append(getServerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverPort</column-name><column-value><![CDATA[");
		sb.append(getServerPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userAgent</column-name><column-value><![CDATA[");
		sb.append(getUserAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plId</column-name><column-value><![CDATA[");
		sb.append(getPlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessName</column-name><column-value><![CDATA[");
		sb.append(getAccessName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessFound</column-name><column-value><![CDATA[");
		sb.append(getAccessFound());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessDate</column-name><column-value><![CDATA[");
		sb.append(getAccessDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elapseLoad</column-name><column-value><![CDATA[");
		sb.append(getElapseLoad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadSize</column-name><column-value><![CDATA[");
		sb.append(getUploadSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadSize</column-name><column-value><![CDATA[");
		sb.append(getDownloadSize());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _browsinglogId;
	private long _companyId;
	private long _userlogId;
	private String _clientHost;
	private String _clientAddr;
	private String _serverName;
	private int _serverPort;
	private String _userAgent;
	private String _url;
	private long _plId;
	private String _accessName;
	private boolean _accessFound;
	private long _accessDate;
	private long _elapseLoad;
	private long _uploadSize;
	private long _downloadSize;
	private BaseModel<?> _browsinglogRemoteModel;
}