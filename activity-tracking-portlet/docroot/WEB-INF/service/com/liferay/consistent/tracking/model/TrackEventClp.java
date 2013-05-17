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

import com.liferay.consistent.tracking.service.TrackEventLocalServiceUtil;

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
public class TrackEventClp extends BaseModelImpl<TrackEvent>
	implements TrackEvent {
	public TrackEventClp() {
	}

	public Class<?> getModelClass() {
		return TrackEvent.class;
	}

	public String getModelClassName() {
		return TrackEvent.class.getName();
	}

	public long getPrimaryKey() {
		return _trackEventId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTrackEventId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_trackEventId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("trackEventId", getTrackEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("userlogId", getUserlogId());
		attributes.put("eventType", getEventType());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("message", getMessage());
		attributes.put("clientHost", getClientHost());
		attributes.put("clientAddr", getClientAddr());
		attributes.put("serverName", getServerName());
		attributes.put("serverPort", getServerPort());
		attributes.put("additionalInfo", getAdditionalInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long trackEventId = (Long)attributes.get("trackEventId");

		if (trackEventId != null) {
			setTrackEventId(trackEventId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String classPK = (String)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
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

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}
	}

	public long getTrackEventId() {
		return _trackEventId;
	}

	public void setTrackEventId(long trackEventId) {
		_trackEventId = trackEventId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	public long getUserlogId() {
		return _userlogId;
	}

	public void setUserlogId(long userlogId) {
		_userlogId = userlogId;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public String getClassPK() {
		return _classPK;
	}

	public void setClassPK(String classPK) {
		_classPK = classPK;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
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

	public String getAdditionalInfo() {
		return _additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;
	}

	public BaseModel<?> getTrackEventRemoteModel() {
		return _trackEventRemoteModel;
	}

	public void setTrackEventRemoteModel(BaseModel<?> trackEventRemoteModel) {
		_trackEventRemoteModel = trackEventRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TrackEventLocalServiceUtil.addTrackEvent(this);
		}
		else {
			TrackEventLocalServiceUtil.updateTrackEvent(this);
		}
	}

	@Override
	public TrackEvent toEscapedModel() {
		return (TrackEvent)Proxy.newProxyInstance(TrackEvent.class.getClassLoader(),
			new Class[] { TrackEvent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TrackEventClp clone = new TrackEventClp();

		clone.setTrackEventId(getTrackEventId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setUserlogId(getUserlogId());
		clone.setEventType(getEventType());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setMessage(getMessage());
		clone.setClientHost(getClientHost());
		clone.setClientAddr(getClientAddr());
		clone.setServerName(getServerName());
		clone.setServerPort(getServerPort());
		clone.setAdditionalInfo(getAdditionalInfo());

		return clone;
	}

	public int compareTo(TrackEvent trackEvent) {
		int value = 0;

		if (getCreateDate() < trackEvent.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > trackEvent.getCreateDate()) {
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

		TrackEventClp trackEvent = null;

		try {
			trackEvent = (TrackEventClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = trackEvent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{trackEventId=");
		sb.append(getTrackEventId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", userlogId=");
		sb.append(getUserlogId());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", clientHost=");
		sb.append(getClientHost());
		sb.append(", clientAddr=");
		sb.append(getClientAddr());
		sb.append(", serverName=");
		sb.append(getServerName());
		sb.append(", serverPort=");
		sb.append(getServerPort());
		sb.append(", additionalInfo=");
		sb.append(getAdditionalInfo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.TrackEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>trackEventId</column-name><column-value><![CDATA[");
		sb.append(getTrackEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userlogId</column-name><column-value><![CDATA[");
		sb.append(getUserlogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
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
			"<column><column-name>additionalInfo</column-name><column-value><![CDATA[");
		sb.append(getAdditionalInfo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _trackEventId;
	private long _companyId;
	private String _userName;
	private long _createDate;
	private long _userlogId;
	private String _eventType;
	private String _className;
	private String _classPK;
	private String _message;
	private String _clientHost;
	private String _clientAddr;
	private String _serverName;
	private int _serverPort;
	private String _additionalInfo;
	private BaseModel<?> _trackEventRemoteModel;
}