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
 * This class is a wrapper for {@link Userlog}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       Userlog
 * @generated
 */
public class UserlogWrapper implements Userlog, ModelWrapper<Userlog> {
	public UserlogWrapper(Userlog userlog) {
		_userlog = userlog;
	}

	public Class<?> getModelClass() {
		return Userlog.class;
	}

	public String getModelClassName() {
		return Userlog.class.getName();
	}

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
		attributes.put("osManufacturer", getOsManufacturer());
		attributes.put("browserId", getBrowserId());
		attributes.put("browserVersion", getBrowserVersion());
		attributes.put("sessionId", getSessionId());
		attributes.put("accessDate", getAccessDate());
		attributes.put("timeSlapse", getTimeSlapse());

		return attributes;
	}

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

		String osManufacturer = (String)attributes.get("osManufacturer");

		if (osManufacturer != null) {
			setOsManufacturer(osManufacturer);
		}

		Long browserId = (Long)attributes.get("browserId");

		if (browserId != null) {
			setBrowserId(browserId);
		}

		String browserVersion = (String)attributes.get("browserVersion");

		if (browserVersion != null) {
			setBrowserVersion(browserVersion);
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

	/**
	* Returns the primary key of this userlog.
	*
	* @return the primary key of this userlog
	*/
	public long getPrimaryKey() {
		return _userlog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this userlog.
	*
	* @param primaryKey the primary key of this userlog
	*/
	public void setPrimaryKey(long primaryKey) {
		_userlog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the userlog ID of this userlog.
	*
	* @return the userlog ID of this userlog
	*/
	public long getUserlogId() {
		return _userlog.getUserlogId();
	}

	/**
	* Sets the userlog ID of this userlog.
	*
	* @param userlogId the userlog ID of this userlog
	*/
	public void setUserlogId(long userlogId) {
		_userlog.setUserlogId(userlogId);
	}

	/**
	* Returns the company ID of this userlog.
	*
	* @return the company ID of this userlog
	*/
	public long getCompanyId() {
		return _userlog.getCompanyId();
	}

	/**
	* Sets the company ID of this userlog.
	*
	* @param companyId the company ID of this userlog
	*/
	public void setCompanyId(long companyId) {
		_userlog.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this userlog.
	*
	* @return the user ID of this userlog
	*/
	public long getUserId() {
		return _userlog.getUserId();
	}

	/**
	* Sets the user ID of this userlog.
	*
	* @param userId the user ID of this userlog
	*/
	public void setUserId(long userId) {
		_userlog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this userlog.
	*
	* @return the user uuid of this userlog
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlog.getUserUuid();
	}

	/**
	* Sets the user uuid of this userlog.
	*
	* @param userUuid the user uuid of this userlog
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_userlog.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this userlog.
	*
	* @return the user name of this userlog
	*/
	public java.lang.String getUserName() {
		return _userlog.getUserName();
	}

	/**
	* Sets the user name of this userlog.
	*
	* @param userName the user name of this userlog
	*/
	public void setUserName(java.lang.String userName) {
		_userlog.setUserName(userName);
	}

	/**
	* Returns the server name of this userlog.
	*
	* @return the server name of this userlog
	*/
	public java.lang.String getServerName() {
		return _userlog.getServerName();
	}

	/**
	* Sets the server name of this userlog.
	*
	* @param serverName the server name of this userlog
	*/
	public void setServerName(java.lang.String serverName) {
		_userlog.setServerName(serverName);
	}

	/**
	* Returns the server port of this userlog.
	*
	* @return the server port of this userlog
	*/
	public int getServerPort() {
		return _userlog.getServerPort();
	}

	/**
	* Sets the server port of this userlog.
	*
	* @param serverPort the server port of this userlog
	*/
	public void setServerPort(int serverPort) {
		_userlog.setServerPort(serverPort);
	}

	/**
	* Returns the remote host of this userlog.
	*
	* @return the remote host of this userlog
	*/
	public java.lang.String getRemoteHost() {
		return _userlog.getRemoteHost();
	}

	/**
	* Sets the remote host of this userlog.
	*
	* @param remoteHost the remote host of this userlog
	*/
	public void setRemoteHost(java.lang.String remoteHost) {
		_userlog.setRemoteHost(remoteHost);
	}

	/**
	* Returns the remote address of this userlog.
	*
	* @return the remote address of this userlog
	*/
	public java.lang.String getRemoteAddress() {
		return _userlog.getRemoteAddress();
	}

	/**
	* Sets the remote address of this userlog.
	*
	* @param remoteAddress the remote address of this userlog
	*/
	public void setRemoteAddress(java.lang.String remoteAddress) {
		_userlog.setRemoteAddress(remoteAddress);
	}

	/**
	* Returns the os ID of this userlog.
	*
	* @return the os ID of this userlog
	*/
	public long getOsId() {
		return _userlog.getOsId();
	}

	/**
	* Sets the os ID of this userlog.
	*
	* @param osId the os ID of this userlog
	*/
	public void setOsId(long osId) {
		_userlog.setOsId(osId);
	}

	/**
	* Returns the os manufacturer of this userlog.
	*
	* @return the os manufacturer of this userlog
	*/
	public java.lang.String getOsManufacturer() {
		return _userlog.getOsManufacturer();
	}

	/**
	* Sets the os manufacturer of this userlog.
	*
	* @param osManufacturer the os manufacturer of this userlog
	*/
	public void setOsManufacturer(java.lang.String osManufacturer) {
		_userlog.setOsManufacturer(osManufacturer);
	}

	/**
	* Returns the browser ID of this userlog.
	*
	* @return the browser ID of this userlog
	*/
	public long getBrowserId() {
		return _userlog.getBrowserId();
	}

	/**
	* Sets the browser ID of this userlog.
	*
	* @param browserId the browser ID of this userlog
	*/
	public void setBrowserId(long browserId) {
		_userlog.setBrowserId(browserId);
	}

	/**
	* Returns the browser version of this userlog.
	*
	* @return the browser version of this userlog
	*/
	public java.lang.String getBrowserVersion() {
		return _userlog.getBrowserVersion();
	}

	/**
	* Sets the browser version of this userlog.
	*
	* @param browserVersion the browser version of this userlog
	*/
	public void setBrowserVersion(java.lang.String browserVersion) {
		_userlog.setBrowserVersion(browserVersion);
	}

	/**
	* Returns the session ID of this userlog.
	*
	* @return the session ID of this userlog
	*/
	public java.lang.String getSessionId() {
		return _userlog.getSessionId();
	}

	/**
	* Sets the session ID of this userlog.
	*
	* @param sessionId the session ID of this userlog
	*/
	public void setSessionId(java.lang.String sessionId) {
		_userlog.setSessionId(sessionId);
	}

	/**
	* Returns the access date of this userlog.
	*
	* @return the access date of this userlog
	*/
	public long getAccessDate() {
		return _userlog.getAccessDate();
	}

	/**
	* Sets the access date of this userlog.
	*
	* @param accessDate the access date of this userlog
	*/
	public void setAccessDate(long accessDate) {
		_userlog.setAccessDate(accessDate);
	}

	/**
	* Returns the time slapse of this userlog.
	*
	* @return the time slapse of this userlog
	*/
	public long getTimeSlapse() {
		return _userlog.getTimeSlapse();
	}

	/**
	* Sets the time slapse of this userlog.
	*
	* @param timeSlapse the time slapse of this userlog
	*/
	public void setTimeSlapse(long timeSlapse) {
		_userlog.setTimeSlapse(timeSlapse);
	}

	public boolean isNew() {
		return _userlog.isNew();
	}

	public void setNew(boolean n) {
		_userlog.setNew(n);
	}

	public boolean isCachedModel() {
		return _userlog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userlog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userlog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userlog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userlog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userlog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userlog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserlogWrapper((Userlog)_userlog.clone());
	}

	public int compareTo(com.liferay.consistent.tracking.model.Userlog userlog) {
		return _userlog.compareTo(userlog);
	}

	@Override
	public int hashCode() {
		return _userlog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.Userlog> toCacheModel() {
		return _userlog.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.Userlog toEscapedModel() {
		return new UserlogWrapper(_userlog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userlog.toString();
	}

	public java.lang.String toXmlString() {
		return _userlog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userlog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Userlog getWrappedUserlog() {
		return _userlog;
	}

	public Userlog getWrappedModel() {
		return _userlog;
	}

	public void resetOriginalValues() {
		_userlog.resetOriginalValues();
	}

	private Userlog _userlog;
}