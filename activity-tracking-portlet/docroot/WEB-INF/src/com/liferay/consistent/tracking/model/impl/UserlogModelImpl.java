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

package com.liferay.consistent.tracking.model.impl;

import com.liferay.consistent.tracking.model.Userlog;
import com.liferay.consistent.tracking.model.UserlogModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Userlog service. Represents a row in the &quot;CONSIS_TRACK_Userlog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.consistent.tracking.model.UserlogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserlogImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see UserlogImpl
 * @see com.liferay.consistent.tracking.model.Userlog
 * @see com.liferay.consistent.tracking.model.UserlogModel
 * @generated
 */
public class UserlogModelImpl extends BaseModelImpl<Userlog>
	implements UserlogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a userlog model instance should use the {@link com.liferay.consistent.tracking.model.Userlog} interface instead.
	 */
	public static final String TABLE_NAME = "CONSIS_TRACK_Userlog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userlogId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "serverName", Types.VARCHAR },
			{ "serverPort", Types.INTEGER },
			{ "remoteHost", Types.VARCHAR },
			{ "remoteAddress", Types.VARCHAR },
			{ "osId", Types.BIGINT },
			{ "browserId", Types.BIGINT },
			{ "sessionId", Types.VARCHAR },
			{ "accessDate", Types.BIGINT },
			{ "timeSlapse", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table CONSIS_TRACK_Userlog (userlogId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,serverName VARCHAR(75) null,serverPort INTEGER,remoteHost VARCHAR(75) null,remoteAddress VARCHAR(75) null,osId LONG,browserId LONG,sessionId VARCHAR(75) null,accessDate LONG,timeSlapse LONG)";
	public static final String TABLE_SQL_DROP = "drop table CONSIS_TRACK_Userlog";
	public static final String ORDER_BY_JPQL = " ORDER BY userlog.accessDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CONSIS_TRACK_Userlog.accessDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.consistent.tracking.model.Userlog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.consistent.tracking.model.Userlog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.consistent.tracking.model.Userlog"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.consistent.tracking.model.Userlog"));

	public UserlogModelImpl() {
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

	public Class<?> getModelClass() {
		return Userlog.class;
	}

	public String getModelClassName() {
		return Userlog.class.getName();
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
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getServerName() {
		if (_serverName == null) {
			return StringPool.BLANK;
		}
		else {
			return _serverName;
		}
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
		if (_remoteHost == null) {
			return StringPool.BLANK;
		}
		else {
			return _remoteHost;
		}
	}

	public void setRemoteHost(String remoteHost) {
		_remoteHost = remoteHost;
	}

	public String getRemoteAddress() {
		if (_remoteAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _remoteAddress;
		}
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
		if (_sessionId == null) {
			return StringPool.BLANK;
		}
		else {
			return _sessionId;
		}
	}

	public void setSessionId(String sessionId) {
		_sessionId = sessionId;
	}

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_columnBitmask = -1L;

		_accessDate = accessDate;
	}

	public long getTimeSlapse() {
		return _timeSlapse;
	}

	public void setTimeSlapse(long timeSlapse) {
		_timeSlapse = timeSlapse;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Userlog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Userlog toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Userlog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		UserlogImpl userlogImpl = new UserlogImpl();

		userlogImpl.setUserlogId(getUserlogId());
		userlogImpl.setCompanyId(getCompanyId());
		userlogImpl.setUserId(getUserId());
		userlogImpl.setUserName(getUserName());
		userlogImpl.setServerName(getServerName());
		userlogImpl.setServerPort(getServerPort());
		userlogImpl.setRemoteHost(getRemoteHost());
		userlogImpl.setRemoteAddress(getRemoteAddress());
		userlogImpl.setOsId(getOsId());
		userlogImpl.setBrowserId(getBrowserId());
		userlogImpl.setSessionId(getSessionId());
		userlogImpl.setAccessDate(getAccessDate());
		userlogImpl.setTimeSlapse(getTimeSlapse());

		userlogImpl.resetOriginalValues();

		return userlogImpl;
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

		Userlog userlog = null;

		try {
			userlog = (Userlog)obj;
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
	public void resetOriginalValues() {
		UserlogModelImpl userlogModelImpl = this;

		userlogModelImpl._originalCompanyId = userlogModelImpl._companyId;

		userlogModelImpl._setOriginalCompanyId = false;

		userlogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Userlog> toCacheModel() {
		UserlogCacheModel userlogCacheModel = new UserlogCacheModel();

		userlogCacheModel.userlogId = getUserlogId();

		userlogCacheModel.companyId = getCompanyId();

		userlogCacheModel.userId = getUserId();

		userlogCacheModel.userName = getUserName();

		String userName = userlogCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			userlogCacheModel.userName = null;
		}

		userlogCacheModel.serverName = getServerName();

		String serverName = userlogCacheModel.serverName;

		if ((serverName != null) && (serverName.length() == 0)) {
			userlogCacheModel.serverName = null;
		}

		userlogCacheModel.serverPort = getServerPort();

		userlogCacheModel.remoteHost = getRemoteHost();

		String remoteHost = userlogCacheModel.remoteHost;

		if ((remoteHost != null) && (remoteHost.length() == 0)) {
			userlogCacheModel.remoteHost = null;
		}

		userlogCacheModel.remoteAddress = getRemoteAddress();

		String remoteAddress = userlogCacheModel.remoteAddress;

		if ((remoteAddress != null) && (remoteAddress.length() == 0)) {
			userlogCacheModel.remoteAddress = null;
		}

		userlogCacheModel.osId = getOsId();

		userlogCacheModel.browserId = getBrowserId();

		userlogCacheModel.sessionId = getSessionId();

		String sessionId = userlogCacheModel.sessionId;

		if ((sessionId != null) && (sessionId.length() == 0)) {
			userlogCacheModel.sessionId = null;
		}

		userlogCacheModel.accessDate = getAccessDate();

		userlogCacheModel.timeSlapse = getTimeSlapse();

		return userlogCacheModel;
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

	private static ClassLoader _classLoader = Userlog.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Userlog.class
		};
	private long _userlogId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
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
	private long _columnBitmask;
	private Userlog _escapedModelProxy;
}