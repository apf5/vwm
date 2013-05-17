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
 * This class is a wrapper for {@link SearchWordHit}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       SearchWordHit
 * @generated
 */
public class SearchWordHitWrapper implements SearchWordHit,
	ModelWrapper<SearchWordHit> {
	public SearchWordHitWrapper(SearchWordHit searchWordHit) {
		_searchWordHit = searchWordHit;
	}

	public Class<?> getModelClass() {
		return SearchWordHit.class;
	}

	public String getModelClassName() {
		return SearchWordHit.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("wordId", getWordId());
		attributes.put("guest", getGuest());
		attributes.put("accessDate", getAccessDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long hitId = (Long)attributes.get("hitId");

		if (hitId != null) {
			setHitId(hitId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long wordId = (Long)attributes.get("wordId");

		if (wordId != null) {
			setWordId(wordId);
		}

		Boolean guest = (Boolean)attributes.get("guest");

		if (guest != null) {
			setGuest(guest);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}
	}

	/**
	* Returns the primary key of this search word hit.
	*
	* @return the primary key of this search word hit
	*/
	public long getPrimaryKey() {
		return _searchWordHit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this search word hit.
	*
	* @param primaryKey the primary key of this search word hit
	*/
	public void setPrimaryKey(long primaryKey) {
		_searchWordHit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the hit ID of this search word hit.
	*
	* @return the hit ID of this search word hit
	*/
	public long getHitId() {
		return _searchWordHit.getHitId();
	}

	/**
	* Sets the hit ID of this search word hit.
	*
	* @param hitId the hit ID of this search word hit
	*/
	public void setHitId(long hitId) {
		_searchWordHit.setHitId(hitId);
	}

	/**
	* Returns the company ID of this search word hit.
	*
	* @return the company ID of this search word hit
	*/
	public long getCompanyId() {
		return _searchWordHit.getCompanyId();
	}

	/**
	* Sets the company ID of this search word hit.
	*
	* @param companyId the company ID of this search word hit
	*/
	public void setCompanyId(long companyId) {
		_searchWordHit.setCompanyId(companyId);
	}

	/**
	* Returns the word ID of this search word hit.
	*
	* @return the word ID of this search word hit
	*/
	public long getWordId() {
		return _searchWordHit.getWordId();
	}

	/**
	* Sets the word ID of this search word hit.
	*
	* @param wordId the word ID of this search word hit
	*/
	public void setWordId(long wordId) {
		_searchWordHit.setWordId(wordId);
	}

	/**
	* Returns the guest of this search word hit.
	*
	* @return the guest of this search word hit
	*/
	public boolean getGuest() {
		return _searchWordHit.getGuest();
	}

	/**
	* Returns <code>true</code> if this search word hit is guest.
	*
	* @return <code>true</code> if this search word hit is guest; <code>false</code> otherwise
	*/
	public boolean isGuest() {
		return _searchWordHit.isGuest();
	}

	/**
	* Sets whether this search word hit is guest.
	*
	* @param guest the guest of this search word hit
	*/
	public void setGuest(boolean guest) {
		_searchWordHit.setGuest(guest);
	}

	/**
	* Returns the access date of this search word hit.
	*
	* @return the access date of this search word hit
	*/
	public long getAccessDate() {
		return _searchWordHit.getAccessDate();
	}

	/**
	* Sets the access date of this search word hit.
	*
	* @param accessDate the access date of this search word hit
	*/
	public void setAccessDate(long accessDate) {
		_searchWordHit.setAccessDate(accessDate);
	}

	public boolean isNew() {
		return _searchWordHit.isNew();
	}

	public void setNew(boolean n) {
		_searchWordHit.setNew(n);
	}

	public boolean isCachedModel() {
		return _searchWordHit.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_searchWordHit.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _searchWordHit.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _searchWordHit.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_searchWordHit.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _searchWordHit.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_searchWordHit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SearchWordHitWrapper((SearchWordHit)_searchWordHit.clone());
	}

	public int compareTo(
		com.liferay.consistent.tracking.model.SearchWordHit searchWordHit) {
		return _searchWordHit.compareTo(searchWordHit);
	}

	@Override
	public int hashCode() {
		return _searchWordHit.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.SearchWordHit> toCacheModel() {
		return _searchWordHit.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.SearchWordHit toEscapedModel() {
		return new SearchWordHitWrapper(_searchWordHit.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _searchWordHit.toString();
	}

	public java.lang.String toXmlString() {
		return _searchWordHit.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_searchWordHit.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SearchWordHit getWrappedSearchWordHit() {
		return _searchWordHit;
	}

	public SearchWordHit getWrappedModel() {
		return _searchWordHit;
	}

	public void resetOriginalValues() {
		_searchWordHit.resetOriginalValues();
	}

	private SearchWordHit _searchWordHit;
}