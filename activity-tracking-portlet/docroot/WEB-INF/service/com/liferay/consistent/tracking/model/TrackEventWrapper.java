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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TrackEvent}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       TrackEvent
 * @generated
 */
public class TrackEventWrapper implements TrackEvent, ModelWrapper<TrackEvent> {
	public TrackEventWrapper(TrackEvent trackEvent) {
		_trackEvent = trackEvent;
	}

	public Class<?> getModelClass() {
		return TrackEvent.class;
	}

	public String getModelClassName() {
		return TrackEvent.class.getName();
	}

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

	/**
	* Returns the primary key of this track event.
	*
	* @return the primary key of this track event
	*/
	public long getPrimaryKey() {
		return _trackEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this track event.
	*
	* @param primaryKey the primary key of this track event
	*/
	public void setPrimaryKey(long primaryKey) {
		_trackEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the track event ID of this track event.
	*
	* @return the track event ID of this track event
	*/
	public long getTrackEventId() {
		return _trackEvent.getTrackEventId();
	}

	/**
	* Sets the track event ID of this track event.
	*
	* @param trackEventId the track event ID of this track event
	*/
	public void setTrackEventId(long trackEventId) {
		_trackEvent.setTrackEventId(trackEventId);
	}

	/**
	* Returns the company ID of this track event.
	*
	* @return the company ID of this track event
	*/
	public long getCompanyId() {
		return _trackEvent.getCompanyId();
	}

	/**
	* Sets the company ID of this track event.
	*
	* @param companyId the company ID of this track event
	*/
	public void setCompanyId(long companyId) {
		_trackEvent.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this track event.
	*
	* @return the user name of this track event
	*/
	public java.lang.String getUserName() {
		return _trackEvent.getUserName();
	}

	/**
	* Sets the user name of this track event.
	*
	* @param userName the user name of this track event
	*/
	public void setUserName(java.lang.String userName) {
		_trackEvent.setUserName(userName);
	}

	/**
	* Returns the create date of this track event.
	*
	* @return the create date of this track event
	*/
	public long getCreateDate() {
		return _trackEvent.getCreateDate();
	}

	/**
	* Sets the create date of this track event.
	*
	* @param createDate the create date of this track event
	*/
	public void setCreateDate(long createDate) {
		_trackEvent.setCreateDate(createDate);
	}

	/**
	* Returns the userlog ID of this track event.
	*
	* @return the userlog ID of this track event
	*/
	public long getUserlogId() {
		return _trackEvent.getUserlogId();
	}

	/**
	* Sets the userlog ID of this track event.
	*
	* @param userlogId the userlog ID of this track event
	*/
	public void setUserlogId(long userlogId) {
		_trackEvent.setUserlogId(userlogId);
	}

	/**
	* Returns the event type of this track event.
	*
	* @return the event type of this track event
	*/
	public java.lang.String getEventType() {
		return _trackEvent.getEventType();
	}

	/**
	* Sets the event type of this track event.
	*
	* @param eventType the event type of this track event
	*/
	public void setEventType(java.lang.String eventType) {
		_trackEvent.setEventType(eventType);
	}

	/**
	* Returns the class name of this track event.
	*
	* @return the class name of this track event
	*/
	public java.lang.String getClassName() {
		return _trackEvent.getClassName();
	}

	/**
	* Sets the class name of this track event.
	*
	* @param className the class name of this track event
	*/
	public void setClassName(java.lang.String className) {
		_trackEvent.setClassName(className);
	}

	/**
	* Returns the class p k of this track event.
	*
	* @return the class p k of this track event
	*/
	public java.lang.String getClassPK() {
		return _trackEvent.getClassPK();
	}

	/**
	* Sets the class p k of this track event.
	*
	* @param classPK the class p k of this track event
	*/
	public void setClassPK(java.lang.String classPK) {
		_trackEvent.setClassPK(classPK);
	}

	/**
	* Returns the message of this track event.
	*
	* @return the message of this track event
	*/
	public java.lang.String getMessage() {
		return _trackEvent.getMessage();
	}

	/**
	* Sets the message of this track event.
	*
	* @param message the message of this track event
	*/
	public void setMessage(java.lang.String message) {
		_trackEvent.setMessage(message);
	}

	/**
	* Returns the client host of this track event.
	*
	* @return the client host of this track event
	*/
	public java.lang.String getClientHost() {
		return _trackEvent.getClientHost();
	}

	/**
	* Sets the client host of this track event.
	*
	* @param clientHost the client host of this track event
	*/
	public void setClientHost(java.lang.String clientHost) {
		_trackEvent.setClientHost(clientHost);
	}

	/**
	* Returns the client addr of this track event.
	*
	* @return the client addr of this track event
	*/
	public java.lang.String getClientAddr() {
		return _trackEvent.getClientAddr();
	}

	/**
	* Sets the client addr of this track event.
	*
	* @param clientAddr the client addr of this track event
	*/
	public void setClientAddr(java.lang.String clientAddr) {
		_trackEvent.setClientAddr(clientAddr);
	}

	/**
	* Returns the server name of this track event.
	*
	* @return the server name of this track event
	*/
	public java.lang.String getServerName() {
		return _trackEvent.getServerName();
	}

	/**
	* Sets the server name of this track event.
	*
	* @param serverName the server name of this track event
	*/
	public void setServerName(java.lang.String serverName) {
		_trackEvent.setServerName(serverName);
	}

	/**
	* Returns the server port of this track event.
	*
	* @return the server port of this track event
	*/
	public int getServerPort() {
		return _trackEvent.getServerPort();
	}

	/**
	* Sets the server port of this track event.
	*
	* @param serverPort the server port of this track event
	*/
	public void setServerPort(int serverPort) {
		_trackEvent.setServerPort(serverPort);
	}

	/**
	* Returns the additional info of this track event.
	*
	* @return the additional info of this track event
	*/
	public java.lang.String getAdditionalInfo() {
		return _trackEvent.getAdditionalInfo();
	}

	/**
	* Sets the additional info of this track event.
	*
	* @param additionalInfo the additional info of this track event
	*/
	public void setAdditionalInfo(java.lang.String additionalInfo) {
		_trackEvent.setAdditionalInfo(additionalInfo);
	}

	public boolean isNew() {
		return _trackEvent.isNew();
	}

	public void setNew(boolean n) {
		_trackEvent.setNew(n);
	}

	public boolean isCachedModel() {
		return _trackEvent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_trackEvent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _trackEvent.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _trackEvent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trackEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trackEvent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trackEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrackEventWrapper((TrackEvent)_trackEvent.clone());
	}

	public int compareTo(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent) {
		return _trackEvent.compareTo(trackEvent);
	}

	@Override
	public int hashCode() {
		return _trackEvent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.TrackEvent> toCacheModel() {
		return _trackEvent.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.TrackEvent toEscapedModel() {
		return new TrackEventWrapper(_trackEvent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trackEvent.toString();
	}

	public java.lang.String toXmlString() {
		return _trackEvent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trackEvent.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TrackEvent getWrappedTrackEvent() {
		return _trackEvent;
	}

	public TrackEvent getWrappedModel() {
		return _trackEvent;
	}

	public void resetOriginalValues() {
		_trackEvent.resetOriginalValues();
	}

	private TrackEvent _trackEvent;
}