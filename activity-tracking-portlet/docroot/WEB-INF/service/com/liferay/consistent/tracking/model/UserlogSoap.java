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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Jorge Loayza Soloisolo
 * @generated
 */
public class UserlogSoap implements Serializable {
	public static UserlogSoap toSoapModel(Userlog model) {
		UserlogSoap soapModel = new UserlogSoap();

		soapModel.setUserlogId(model.getUserlogId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setServerName(model.getServerName());
		soapModel.setServerPort(model.getServerPort());
		soapModel.setRemoteHost(model.getRemoteHost());
		soapModel.setRemoteAddress(model.getRemoteAddress());
		soapModel.setOsId(model.getOsId());
		soapModel.setOsManufacturer(model.getOsManufacturer());
		soapModel.setBrowserId(model.getBrowserId());
		soapModel.setBrowserVersion(model.getBrowserVersion());
		soapModel.setSessionId(model.getSessionId());
		soapModel.setAccessDate(model.getAccessDate());
		soapModel.setTimeSlapse(model.getTimeSlapse());

		return soapModel;
	}

	public static UserlogSoap[] toSoapModels(Userlog[] models) {
		UserlogSoap[] soapModels = new UserlogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserlogSoap[][] toSoapModels(Userlog[][] models) {
		UserlogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserlogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserlogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserlogSoap[] toSoapModels(List<Userlog> models) {
		List<UserlogSoap> soapModels = new ArrayList<UserlogSoap>(models.size());

		for (Userlog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserlogSoap[soapModels.size()]);
	}

	public UserlogSoap() {
	}

	public long getPrimaryKey() {
		return _userlogId;
	}

	public void setPrimaryKey(long pk) {
		setUserlogId(pk);
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

	public String getOsManufacturer() {
		return _osManufacturer;
	}

	public void setOsManufacturer(String osManufacturer) {
		_osManufacturer = osManufacturer;
	}

	public long getBrowserId() {
		return _browserId;
	}

	public void setBrowserId(long browserId) {
		_browserId = browserId;
	}

	public String getBrowserVersion() {
		return _browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		_browserVersion = browserVersion;
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

	private long _userlogId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private String _serverName;
	private int _serverPort;
	private String _remoteHost;
	private String _remoteAddress;
	private long _osId;
	private String _osManufacturer;
	private long _browserId;
	private String _browserVersion;
	private String _sessionId;
	private long _accessDate;
	private long _timeSlapse;
}