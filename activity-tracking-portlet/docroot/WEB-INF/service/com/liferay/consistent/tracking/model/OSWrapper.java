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
 * This class is a wrapper for {@link OS}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       OS
 * @generated
 */
public class OSWrapper implements OS, ModelWrapper<OS> {
	public OSWrapper(OS os) {
		_os = os;
	}

	public Class<?> getModelClass() {
		return OS.class;
	}

	public String getModelClassName() {
		return OS.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("osId", getOsId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long osId = (Long)attributes.get("osId");

		if (osId != null) {
			setOsId(osId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this o s.
	*
	* @return the primary key of this o s
	*/
	public long getPrimaryKey() {
		return _os.getPrimaryKey();
	}

	/**
	* Sets the primary key of this o s.
	*
	* @param primaryKey the primary key of this o s
	*/
	public void setPrimaryKey(long primaryKey) {
		_os.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the os ID of this o s.
	*
	* @return the os ID of this o s
	*/
	public long getOsId() {
		return _os.getOsId();
	}

	/**
	* Sets the os ID of this o s.
	*
	* @param osId the os ID of this o s
	*/
	public void setOsId(long osId) {
		_os.setOsId(osId);
	}

	/**
	* Returns the name of this o s.
	*
	* @return the name of this o s
	*/
	public java.lang.String getName() {
		return _os.getName();
	}

	/**
	* Sets the name of this o s.
	*
	* @param name the name of this o s
	*/
	public void setName(java.lang.String name) {
		_os.setName(name);
	}

	public boolean isNew() {
		return _os.isNew();
	}

	public void setNew(boolean n) {
		_os.setNew(n);
	}

	public boolean isCachedModel() {
		return _os.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_os.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _os.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _os.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_os.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _os.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_os.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OSWrapper((OS)_os.clone());
	}

	public int compareTo(com.liferay.consistent.tracking.model.OS os) {
		return _os.compareTo(os);
	}

	@Override
	public int hashCode() {
		return _os.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.OS> toCacheModel() {
		return _os.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.OS toEscapedModel() {
		return new OSWrapper(_os.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _os.toString();
	}

	public java.lang.String toXmlString() {
		return _os.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_os.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public OS getWrappedOS() {
		return _os;
	}

	public OS getWrappedModel() {
		return _os;
	}

	public void resetOriginalValues() {
		_os.resetOriginalValues();
	}

	private OS _os;
}