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

package mx.com.vw.jhanlos.ads.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Propertie}.
 * </p>
 *
 * @author    Jorge Loayza
 * @see       Propertie
 * @generated
 */
public class PropertieWrapper implements Propertie, ModelWrapper<Propertie> {
	public PropertieWrapper(Propertie propertie) {
		_propertie = propertie;
	}

	public Class<?> getModelClass() {
		return Propertie.class;
	}

	public String getModelClassName() {
		return Propertie.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertieId", getPropertieId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertieId = (Long)attributes.get("propertieId");

		if (propertieId != null) {
			setPropertieId(propertieId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this propertie.
	*
	* @return the primary key of this propertie
	*/
	public long getPrimaryKey() {
		return _propertie.getPrimaryKey();
	}

	/**
	* Sets the primary key of this propertie.
	*
	* @param primaryKey the primary key of this propertie
	*/
	public void setPrimaryKey(long primaryKey) {
		_propertie.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the propertie ID of this propertie.
	*
	* @return the propertie ID of this propertie
	*/
	public long getPropertieId() {
		return _propertie.getPropertieId();
	}

	/**
	* Sets the propertie ID of this propertie.
	*
	* @param propertieId the propertie ID of this propertie
	*/
	public void setPropertieId(long propertieId) {
		_propertie.setPropertieId(propertieId);
	}

	/**
	* Returns the company ID of this propertie.
	*
	* @return the company ID of this propertie
	*/
	public long getCompanyId() {
		return _propertie.getCompanyId();
	}

	/**
	* Sets the company ID of this propertie.
	*
	* @param companyId the company ID of this propertie
	*/
	public void setCompanyId(long companyId) {
		_propertie.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this propertie.
	*
	* @return the user ID of this propertie
	*/
	public long getUserId() {
		return _propertie.getUserId();
	}

	/**
	* Sets the user ID of this propertie.
	*
	* @param userId the user ID of this propertie
	*/
	public void setUserId(long userId) {
		_propertie.setUserId(userId);
	}

	/**
	* Returns the user uuid of this propertie.
	*
	* @return the user uuid of this propertie
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propertie.getUserUuid();
	}

	/**
	* Sets the user uuid of this propertie.
	*
	* @param userUuid the user uuid of this propertie
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_propertie.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this propertie.
	*
	* @return the create date of this propertie
	*/
	public long getCreateDate() {
		return _propertie.getCreateDate();
	}

	/**
	* Sets the create date of this propertie.
	*
	* @param createDate the create date of this propertie
	*/
	public void setCreateDate(long createDate) {
		_propertie.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this propertie.
	*
	* @return the modified date of this propertie
	*/
	public long getModifiedDate() {
		return _propertie.getModifiedDate();
	}

	/**
	* Sets the modified date of this propertie.
	*
	* @param modifiedDate the modified date of this propertie
	*/
	public void setModifiedDate(long modifiedDate) {
		_propertie.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this propertie.
	*
	* @return the name of this propertie
	*/
	public java.lang.String getName() {
		return _propertie.getName();
	}

	/**
	* Sets the name of this propertie.
	*
	* @param name the name of this propertie
	*/
	public void setName(java.lang.String name) {
		_propertie.setName(name);
	}

	/**
	* Returns the value of this propertie.
	*
	* @return the value of this propertie
	*/
	public java.lang.String getValue() {
		return _propertie.getValue();
	}

	/**
	* Sets the value of this propertie.
	*
	* @param value the value of this propertie
	*/
	public void setValue(java.lang.String value) {
		_propertie.setValue(value);
	}

	public boolean isNew() {
		return _propertie.isNew();
	}

	public void setNew(boolean n) {
		_propertie.setNew(n);
	}

	public boolean isCachedModel() {
		return _propertie.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_propertie.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _propertie.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _propertie.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_propertie.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _propertie.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_propertie.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PropertieWrapper((Propertie)_propertie.clone());
	}

	public int compareTo(mx.com.vw.jhanlos.ads.model.Propertie propertie) {
		return _propertie.compareTo(propertie);
	}

	@Override
	public int hashCode() {
		return _propertie.hashCode();
	}

	public com.liferay.portal.model.CacheModel<mx.com.vw.jhanlos.ads.model.Propertie> toCacheModel() {
		return _propertie.toCacheModel();
	}

	public mx.com.vw.jhanlos.ads.model.Propertie toEscapedModel() {
		return new PropertieWrapper(_propertie.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _propertie.toString();
	}

	public java.lang.String toXmlString() {
		return _propertie.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_propertie.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Propertie getWrappedPropertie() {
		return _propertie;
	}

	public Propertie getWrappedModel() {
		return _propertie;
	}

	public void resetOriginalValues() {
		_propertie.resetOriginalValues();
	}

	private Propertie _propertie;
}