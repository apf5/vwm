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
 * This class is a wrapper for {@link Browsinglog}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       Browsinglog
 * @generated
 */
public class BrowsinglogWrapper implements Browsinglog,
	ModelWrapper<Browsinglog> {
	public BrowsinglogWrapper(Browsinglog browsinglog) {
		_browsinglog = browsinglog;
	}

	public Class<?> getModelClass() {
		return Browsinglog.class;
	}

	public String getModelClassName() {
		return Browsinglog.class.getName();
	}

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

	/**
	* Returns the primary key of this browsinglog.
	*
	* @return the primary key of this browsinglog
	*/
	public long getPrimaryKey() {
		return _browsinglog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this browsinglog.
	*
	* @param primaryKey the primary key of this browsinglog
	*/
	public void setPrimaryKey(long primaryKey) {
		_browsinglog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the browsinglog ID of this browsinglog.
	*
	* @return the browsinglog ID of this browsinglog
	*/
	public long getBrowsinglogId() {
		return _browsinglog.getBrowsinglogId();
	}

	/**
	* Sets the browsinglog ID of this browsinglog.
	*
	* @param browsinglogId the browsinglog ID of this browsinglog
	*/
	public void setBrowsinglogId(long browsinglogId) {
		_browsinglog.setBrowsinglogId(browsinglogId);
	}

	/**
	* Returns the company ID of this browsinglog.
	*
	* @return the company ID of this browsinglog
	*/
	public long getCompanyId() {
		return _browsinglog.getCompanyId();
	}

	/**
	* Sets the company ID of this browsinglog.
	*
	* @param companyId the company ID of this browsinglog
	*/
	public void setCompanyId(long companyId) {
		_browsinglog.setCompanyId(companyId);
	}

	/**
	* Returns the userlog ID of this browsinglog.
	*
	* @return the userlog ID of this browsinglog
	*/
	public long getUserlogId() {
		return _browsinglog.getUserlogId();
	}

	/**
	* Sets the userlog ID of this browsinglog.
	*
	* @param userlogId the userlog ID of this browsinglog
	*/
	public void setUserlogId(long userlogId) {
		_browsinglog.setUserlogId(userlogId);
	}

	/**
	* Returns the client host of this browsinglog.
	*
	* @return the client host of this browsinglog
	*/
	public java.lang.String getClientHost() {
		return _browsinglog.getClientHost();
	}

	/**
	* Sets the client host of this browsinglog.
	*
	* @param clientHost the client host of this browsinglog
	*/
	public void setClientHost(java.lang.String clientHost) {
		_browsinglog.setClientHost(clientHost);
	}

	/**
	* Returns the client addr of this browsinglog.
	*
	* @return the client addr of this browsinglog
	*/
	public java.lang.String getClientAddr() {
		return _browsinglog.getClientAddr();
	}

	/**
	* Sets the client addr of this browsinglog.
	*
	* @param clientAddr the client addr of this browsinglog
	*/
	public void setClientAddr(java.lang.String clientAddr) {
		_browsinglog.setClientAddr(clientAddr);
	}

	/**
	* Returns the server name of this browsinglog.
	*
	* @return the server name of this browsinglog
	*/
	public java.lang.String getServerName() {
		return _browsinglog.getServerName();
	}

	/**
	* Sets the server name of this browsinglog.
	*
	* @param serverName the server name of this browsinglog
	*/
	public void setServerName(java.lang.String serverName) {
		_browsinglog.setServerName(serverName);
	}

	/**
	* Returns the server port of this browsinglog.
	*
	* @return the server port of this browsinglog
	*/
	public int getServerPort() {
		return _browsinglog.getServerPort();
	}

	/**
	* Sets the server port of this browsinglog.
	*
	* @param serverPort the server port of this browsinglog
	*/
	public void setServerPort(int serverPort) {
		_browsinglog.setServerPort(serverPort);
	}

	/**
	* Returns the user agent of this browsinglog.
	*
	* @return the user agent of this browsinglog
	*/
	public java.lang.String getUserAgent() {
		return _browsinglog.getUserAgent();
	}

	/**
	* Sets the user agent of this browsinglog.
	*
	* @param userAgent the user agent of this browsinglog
	*/
	public void setUserAgent(java.lang.String userAgent) {
		_browsinglog.setUserAgent(userAgent);
	}

	/**
	* Returns the url of this browsinglog.
	*
	* @return the url of this browsinglog
	*/
	public java.lang.String getUrl() {
		return _browsinglog.getUrl();
	}

	/**
	* Sets the url of this browsinglog.
	*
	* @param url the url of this browsinglog
	*/
	public void setUrl(java.lang.String url) {
		_browsinglog.setUrl(url);
	}

	/**
	* Returns the pl ID of this browsinglog.
	*
	* @return the pl ID of this browsinglog
	*/
	public long getPlId() {
		return _browsinglog.getPlId();
	}

	/**
	* Sets the pl ID of this browsinglog.
	*
	* @param plId the pl ID of this browsinglog
	*/
	public void setPlId(long plId) {
		_browsinglog.setPlId(plId);
	}

	/**
	* Returns the access name of this browsinglog.
	*
	* @return the access name of this browsinglog
	*/
	public java.lang.String getAccessName() {
		return _browsinglog.getAccessName();
	}

	/**
	* Sets the access name of this browsinglog.
	*
	* @param accessName the access name of this browsinglog
	*/
	public void setAccessName(java.lang.String accessName) {
		_browsinglog.setAccessName(accessName);
	}

	/**
	* Returns the access found of this browsinglog.
	*
	* @return the access found of this browsinglog
	*/
	public boolean getAccessFound() {
		return _browsinglog.getAccessFound();
	}

	/**
	* Returns <code>true</code> if this browsinglog is access found.
	*
	* @return <code>true</code> if this browsinglog is access found; <code>false</code> otherwise
	*/
	public boolean isAccessFound() {
		return _browsinglog.isAccessFound();
	}

	/**
	* Sets whether this browsinglog is access found.
	*
	* @param accessFound the access found of this browsinglog
	*/
	public void setAccessFound(boolean accessFound) {
		_browsinglog.setAccessFound(accessFound);
	}

	/**
	* Returns the access date of this browsinglog.
	*
	* @return the access date of this browsinglog
	*/
	public long getAccessDate() {
		return _browsinglog.getAccessDate();
	}

	/**
	* Sets the access date of this browsinglog.
	*
	* @param accessDate the access date of this browsinglog
	*/
	public void setAccessDate(long accessDate) {
		_browsinglog.setAccessDate(accessDate);
	}

	/**
	* Returns the elapse load of this browsinglog.
	*
	* @return the elapse load of this browsinglog
	*/
	public long getElapseLoad() {
		return _browsinglog.getElapseLoad();
	}

	/**
	* Sets the elapse load of this browsinglog.
	*
	* @param elapseLoad the elapse load of this browsinglog
	*/
	public void setElapseLoad(long elapseLoad) {
		_browsinglog.setElapseLoad(elapseLoad);
	}

	/**
	* Returns the upload size of this browsinglog.
	*
	* @return the upload size of this browsinglog
	*/
	public long getUploadSize() {
		return _browsinglog.getUploadSize();
	}

	/**
	* Sets the upload size of this browsinglog.
	*
	* @param uploadSize the upload size of this browsinglog
	*/
	public void setUploadSize(long uploadSize) {
		_browsinglog.setUploadSize(uploadSize);
	}

	/**
	* Returns the download size of this browsinglog.
	*
	* @return the download size of this browsinglog
	*/
	public long getDownloadSize() {
		return _browsinglog.getDownloadSize();
	}

	/**
	* Sets the download size of this browsinglog.
	*
	* @param downloadSize the download size of this browsinglog
	*/
	public void setDownloadSize(long downloadSize) {
		_browsinglog.setDownloadSize(downloadSize);
	}

	public boolean isNew() {
		return _browsinglog.isNew();
	}

	public void setNew(boolean n) {
		_browsinglog.setNew(n);
	}

	public boolean isCachedModel() {
		return _browsinglog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_browsinglog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _browsinglog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _browsinglog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_browsinglog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _browsinglog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_browsinglog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BrowsinglogWrapper((Browsinglog)_browsinglog.clone());
	}

	public int compareTo(
		com.liferay.consistent.tracking.model.Browsinglog browsinglog) {
		return _browsinglog.compareTo(browsinglog);
	}

	@Override
	public int hashCode() {
		return _browsinglog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.Browsinglog> toCacheModel() {
		return _browsinglog.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.Browsinglog toEscapedModel() {
		return new BrowsinglogWrapper(_browsinglog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _browsinglog.toString();
	}

	public java.lang.String toXmlString() {
		return _browsinglog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_browsinglog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Browsinglog getWrappedBrowsinglog() {
		return _browsinglog;
	}

	public Browsinglog getWrappedModel() {
		return _browsinglog;
	}

	public void resetOriginalValues() {
		_browsinglog.resetOriginalValues();
	}

	private Browsinglog _browsinglog;
}