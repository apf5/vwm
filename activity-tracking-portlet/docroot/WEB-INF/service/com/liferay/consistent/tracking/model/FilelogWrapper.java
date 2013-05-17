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
 * This class is a wrapper for {@link Filelog}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       Filelog
 * @generated
 */
public class FilelogWrapper implements Filelog, ModelWrapper<Filelog> {
	public FilelogWrapper(Filelog filelog) {
		_filelog = filelog;
	}

	public Class<?> getModelClass() {
		return Filelog.class;
	}

	public String getModelClassName() {
		return Filelog.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FilelogId", getFilelogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("guest", getGuest());
		attributes.put("userlogId", getUserlogId());
		attributes.put("fileId", getFileId());
		attributes.put("accessDate", getAccessDate());
		attributes.put("elapseLoad", getElapseLoad());
		attributes.put("trafic", getTrafic());
		attributes.put("status", getStatus());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long FilelogId = (Long)attributes.get("FilelogId");

		if (FilelogId != null) {
			setFilelogId(FilelogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Boolean guest = (Boolean)attributes.get("guest");

		if (guest != null) {
			setGuest(guest);
		}

		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}

		Long elapseLoad = (Long)attributes.get("elapseLoad");

		if (elapseLoad != null) {
			setElapseLoad(elapseLoad);
		}

		Boolean trafic = (Boolean)attributes.get("trafic");

		if (trafic != null) {
			setTrafic(trafic);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this filelog.
	*
	* @return the primary key of this filelog
	*/
	public long getPrimaryKey() {
		return _filelog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this filelog.
	*
	* @param primaryKey the primary key of this filelog
	*/
	public void setPrimaryKey(long primaryKey) {
		_filelog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the filelog ID of this filelog.
	*
	* @return the filelog ID of this filelog
	*/
	public long getFilelogId() {
		return _filelog.getFilelogId();
	}

	/**
	* Sets the filelog ID of this filelog.
	*
	* @param FilelogId the filelog ID of this filelog
	*/
	public void setFilelogId(long FilelogId) {
		_filelog.setFilelogId(FilelogId);
	}

	/**
	* Returns the company ID of this filelog.
	*
	* @return the company ID of this filelog
	*/
	public long getCompanyId() {
		return _filelog.getCompanyId();
	}

	/**
	* Sets the company ID of this filelog.
	*
	* @param companyId the company ID of this filelog
	*/
	public void setCompanyId(long companyId) {
		_filelog.setCompanyId(companyId);
	}

	/**
	* Returns the guest of this filelog.
	*
	* @return the guest of this filelog
	*/
	public boolean getGuest() {
		return _filelog.getGuest();
	}

	/**
	* Returns <code>true</code> if this filelog is guest.
	*
	* @return <code>true</code> if this filelog is guest; <code>false</code> otherwise
	*/
	public boolean isGuest() {
		return _filelog.isGuest();
	}

	/**
	* Sets whether this filelog is guest.
	*
	* @param guest the guest of this filelog
	*/
	public void setGuest(boolean guest) {
		_filelog.setGuest(guest);
	}

	/**
	* Returns the userlog ID of this filelog.
	*
	* @return the userlog ID of this filelog
	*/
	public long getUserlogId() {
		return _filelog.getUserlogId();
	}

	/**
	* Sets the userlog ID of this filelog.
	*
	* @param userlogId the userlog ID of this filelog
	*/
	public void setUserlogId(long userlogId) {
		_filelog.setUserlogId(userlogId);
	}

	/**
	* Returns the file ID of this filelog.
	*
	* @return the file ID of this filelog
	*/
	public long getFileId() {
		return _filelog.getFileId();
	}

	/**
	* Sets the file ID of this filelog.
	*
	* @param fileId the file ID of this filelog
	*/
	public void setFileId(long fileId) {
		_filelog.setFileId(fileId);
	}

	/**
	* Returns the access date of this filelog.
	*
	* @return the access date of this filelog
	*/
	public long getAccessDate() {
		return _filelog.getAccessDate();
	}

	/**
	* Sets the access date of this filelog.
	*
	* @param accessDate the access date of this filelog
	*/
	public void setAccessDate(long accessDate) {
		_filelog.setAccessDate(accessDate);
	}

	/**
	* Returns the elapse load of this filelog.
	*
	* @return the elapse load of this filelog
	*/
	public long getElapseLoad() {
		return _filelog.getElapseLoad();
	}

	/**
	* Sets the elapse load of this filelog.
	*
	* @param elapseLoad the elapse load of this filelog
	*/
	public void setElapseLoad(long elapseLoad) {
		_filelog.setElapseLoad(elapseLoad);
	}

	/**
	* Returns the trafic of this filelog.
	*
	* @return the trafic of this filelog
	*/
	public boolean getTrafic() {
		return _filelog.getTrafic();
	}

	/**
	* Returns <code>true</code> if this filelog is trafic.
	*
	* @return <code>true</code> if this filelog is trafic; <code>false</code> otherwise
	*/
	public boolean isTrafic() {
		return _filelog.isTrafic();
	}

	/**
	* Sets whether this filelog is trafic.
	*
	* @param trafic the trafic of this filelog
	*/
	public void setTrafic(boolean trafic) {
		_filelog.setTrafic(trafic);
	}

	/**
	* Returns the status of this filelog.
	*
	* @return the status of this filelog
	*/
	public boolean getStatus() {
		return _filelog.getStatus();
	}

	/**
	* Returns <code>true</code> if this filelog is status.
	*
	* @return <code>true</code> if this filelog is status; <code>false</code> otherwise
	*/
	public boolean isStatus() {
		return _filelog.isStatus();
	}

	/**
	* Sets whether this filelog is status.
	*
	* @param status the status of this filelog
	*/
	public void setStatus(boolean status) {
		_filelog.setStatus(status);
	}

	public boolean isNew() {
		return _filelog.isNew();
	}

	public void setNew(boolean n) {
		_filelog.setNew(n);
	}

	public boolean isCachedModel() {
		return _filelog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_filelog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _filelog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _filelog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_filelog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _filelog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_filelog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FilelogWrapper((Filelog)_filelog.clone());
	}

	public int compareTo(com.liferay.consistent.tracking.model.Filelog filelog) {
		return _filelog.compareTo(filelog);
	}

	@Override
	public int hashCode() {
		return _filelog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.Filelog> toCacheModel() {
		return _filelog.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.Filelog toEscapedModel() {
		return new FilelogWrapper(_filelog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _filelog.toString();
	}

	public java.lang.String toXmlString() {
		return _filelog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_filelog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Filelog getWrappedFilelog() {
		return _filelog;
	}

	public Filelog getWrappedModel() {
		return _filelog;
	}

	public void resetOriginalValues() {
		_filelog.resetOriginalValues();
	}

	private Filelog _filelog;
}