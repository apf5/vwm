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
 * This class is a wrapper for {@link Browser}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       Browser
 * @generated
 */
public class BrowserWrapper implements Browser, ModelWrapper<Browser> {
	public BrowserWrapper(Browser browser) {
		_browser = browser;
	}

	public Class<?> getModelClass() {
		return Browser.class;
	}

	public String getModelClassName() {
		return Browser.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("browserId", getBrowserId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long browserId = (Long)attributes.get("browserId");

		if (browserId != null) {
			setBrowserId(browserId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this browser.
	*
	* @return the primary key of this browser
	*/
	public long getPrimaryKey() {
		return _browser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this browser.
	*
	* @param primaryKey the primary key of this browser
	*/
	public void setPrimaryKey(long primaryKey) {
		_browser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the browser ID of this browser.
	*
	* @return the browser ID of this browser
	*/
	public long getBrowserId() {
		return _browser.getBrowserId();
	}

	/**
	* Sets the browser ID of this browser.
	*
	* @param browserId the browser ID of this browser
	*/
	public void setBrowserId(long browserId) {
		_browser.setBrowserId(browserId);
	}

	/**
	* Returns the name of this browser.
	*
	* @return the name of this browser
	*/
	public java.lang.String getName() {
		return _browser.getName();
	}

	/**
	* Sets the name of this browser.
	*
	* @param name the name of this browser
	*/
	public void setName(java.lang.String name) {
		_browser.setName(name);
	}

	public boolean isNew() {
		return _browser.isNew();
	}

	public void setNew(boolean n) {
		_browser.setNew(n);
	}

	public boolean isCachedModel() {
		return _browser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_browser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _browser.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _browser.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_browser.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _browser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_browser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BrowserWrapper((Browser)_browser.clone());
	}

	public int compareTo(com.liferay.consistent.tracking.model.Browser browser) {
		return _browser.compareTo(browser);
	}

	@Override
	public int hashCode() {
		return _browser.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.Browser> toCacheModel() {
		return _browser.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.Browser toEscapedModel() {
		return new BrowserWrapper(_browser.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _browser.toString();
	}

	public java.lang.String toXmlString() {
		return _browser.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_browser.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Browser getWrappedBrowser() {
		return _browser;
	}

	public Browser getWrappedModel() {
		return _browser;
	}

	public void resetOriginalValues() {
		_browser.resetOriginalValues();
	}

	private Browser _browser;
}