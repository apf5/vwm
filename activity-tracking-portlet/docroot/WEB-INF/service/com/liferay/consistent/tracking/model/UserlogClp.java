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

import com.liferay.consistent.tracking.service.UserlogLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza Soloisolo
 */
public class UserlogClp extends BaseModelImpl<Userlog> implements Userlog {
	public UserlogClp() {
	}

	public Class<?> getModelClass() {
		return Userlog.class;
	}

	public String getModelClassName() {
		return Userlog.class.getName();
	}

	public long getPrimaryKey() {
		return _userlogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserlogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userlogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userlogId", getUserlogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("serverName", getServerName());
		attributes.put("serverPort", getServerPort());
		attributes.put("remoteHost", getRemoteHost());
		attributes.put("remoteAddress", getRemoteAddress());
		attributes.put("osId", getOsId());
		attributes.put("browserId", getBrowserId());
		attributes.put("sessionId", getSessionId());
		attributes.put("accessDate", getAccessDate());
		attributes.put("timeSlapse", getTimeSlapse());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String serverName = (String)attributes.get("serverName");

		if (serverName != null) {
			setServerName(serverName);
		}

		Integer serverPort = (Integer)attributes.get("serverPort");

		if (serverPort != null) {
			setServerPort(serverPort);
		}

		String remoteHost = (String)attributes.get("remoteHost");

		if (remoteHost != null) {
			setRemoteHost(remoteHost);
		}

		String remoteAddress = (String)attributes.get("remoteAddress");

		if (remoteAddress != null) {
			setRemoteAddress(remoteAddress);
		}

		Long osId = (Long)attributes.get("osId");

		if (osId != null) {
			setOsId(osId);
		}

		Long browserId = (Long)attributes.get("browserId");

		if (browserId != null) {
			setBrowserId(browserId);
		}

		String sessionId = (String)attributes.get("sessionId");

		if (sessionId != null) {
			setSessionId(sessionId);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}

		Long timeSlapse = (Long)attributes.get("timeSlapse");

		if (timeSlapse != null) {
			setTimeSlapse(timeSlapse);
		}
	}

	public long getUserlogId() {
		return _userlogId;
	}

	public void setUserlogId(long userlogId) {
		_userlogId = userlogId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getRemoteHost() {
		return _remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		_remoteHost = remoteHost;
	}

	public String getRemoteAddress() {
		return _remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		_remoteAddress = remoteAddress;
	}

	public long getOsId() {
		return _osId;
	}

	public void setOsId(long osId) {
		_osId = osId;
	}

	public long getBrowserId() {
		return _browserId;
	}

	public void setBrowserId(long browserId) {
		_browserId = browserId;
	}

	public String getSessionId() {
		return _sessionId;
	}

	public void setSessionId(String sessionId) {
		_sessionId = sessionId;
	}

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_accessDate = accessDate;
	}

	public long getTimeSlapse() {
		return _timeSlapse;
	}

	public void setTimeSlapse(long timeSlapse) {
		_timeSlapse = timeSlapse;
	}

	public BaseModel<?> getUserlogRemoteModel() {
		return _userlogRemoteModel;
	}

	public void setUserlogRemoteModel(BaseModel<?> userlogRemoteModel) {
		_userlogRemoteModel = userlogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UserlogLocalServiceUtil.addUserlog(this);
		}
		else {
			UserlogLocalServiceUtil.updateUserlog(this);
		}
	}

	@Override
	public Userlog toEscapedModel() {
		return (Userlog)Proxy.newProxyInstance(Userlog.class.getClassLoader(),
			new Class[] { Userlog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserlogClp clone = new UserlogClp();

		clone.setUserlogId(getUserlogId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setServerName(getServerName());
		clone.setServerPort(getServerPort());
		clone.setRemoteHost(getRemoteHost());
		clone.setRemoteAddress(getRemoteAddress());
		clone.setOsId(getOsId());
		clone.setBrowserId(getBrowserId());
		clone.setSessionId(getSessionId());
		clone.setAccessDate(getAccessDate());
		clone.setTimeSlapse(getTimeSlapse());

		return clone;
	}

	public int compareTo(Userlog userlog) {
		int value = 0;

		if (getAccessDate() < userlog.getAccessDate()) {
			value = -1;
		}
		else if (getAccessDate() > userlog.getAccessDate()) {
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

		UserlogClp userlog = null;

		try {
			userlog = (UserlogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = userlog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{userlogId=");
		sb.append(getUserlogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", serverName=");
		sb.append(getServerName());
		sb.append(", serverPort=");
		sb.append(getServerPort());
		sb.append(", remoteHost=");
		sb.append(getRemoteHost());
		sb.append(", remoteAddress=");
		sb.append(getRemoteAddress());
		sb.append(", osId=");
		sb.append(getOsId());
		sb.append(", browserId=");
		sb.append(getBrowserId());
		sb.append(", sessionId=");
		sb.append(getSessionId());
		sb.append(", accessDate=");
		sb.append(getAccessDate());
		sb.append(", timeSlapse=");
		sb.append(getTimeSlapse());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.Userlog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userlogId</column-name><column-value><![CDATA[");
		sb.append(getUserlogId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>remoteHost</column-name><column-value><![CDATA[");
		sb.append(getRemoteHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteAddress</column-name><column-value><![CDATA[");
		sb.append(getRemoteAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>osId</column-name><column-value><![CDATA[");
		sb.append(getOsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>browserId</column-name><column-value><![CDATA[");
		sb.append(getBrowserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionId</column-name><column-value><![CDATA[");
		sb.append(getSessionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessDate</column-name><column-value><![CDATA[");
		sb.append(getAccessDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeSlapse</column-name><column-value><![CDATA[");
		sb.append(getTimeSlapse());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userlogId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private String _serverName;
	private int _serverPort;
	private String _remoteHost;
	private String _remoteAddress;
	private long _osId;
	private long _browserId;
	private String _sessionId;
	private long _accessDate;
	private long _timeSlapse;
	private BaseModel<?> _userlogRemoteModel;
}