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
public class TrackEventSoap implements Serializable {
	public static TrackEventSoap toSoapModel(TrackEvent model) {
		TrackEventSoap soapModel = new TrackEventSoap();

		soapModel.setTrackEventId(model.getTrackEventId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUserlogId(model.getUserlogId());
		soapModel.setEventType(model.getEventType());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setMessage(model.getMessage());
		soapModel.setClientHost(model.getClientHost());
		soapModel.setClientAddr(model.getClientAddr());
		soapModel.setServerName(model.getServerName());
		soapModel.setServerPort(model.getServerPort());
		soapModel.setAdditionalInfo(model.getAdditionalInfo());

		return soapModel;
	}

	public static TrackEventSoap[] toSoapModels(TrackEvent[] models) {
		TrackEventSoap[] soapModels = new TrackEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrackEventSoap[][] toSoapModels(TrackEvent[][] models) {
		TrackEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrackEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrackEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrackEventSoap[] toSoapModels(List<TrackEvent> models) {
		List<TrackEventSoap> soapModels = new ArrayList<TrackEventSoap>(models.size());

		for (TrackEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrackEventSoap[soapModels.size()]);
	}

	public TrackEventSoap() {
	}

	public long getPrimaryKey() {
		return _trackEventId;
	}

	public void setPrimaryKey(long pk) {
		setTrackEventId(pk);
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
}