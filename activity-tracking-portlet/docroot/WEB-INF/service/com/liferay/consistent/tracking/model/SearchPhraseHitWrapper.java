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
 * This class is a wrapper for {@link SearchPhraseHit}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       SearchPhraseHit
 * @generated
 */
public class SearchPhraseHitWrapper implements SearchPhraseHit,
	ModelWrapper<SearchPhraseHit> {
	public SearchPhraseHitWrapper(SearchPhraseHit searchPhraseHit) {
		_searchPhraseHit = searchPhraseHit;
	}

	public Class<?> getModelClass() {
		return SearchPhraseHit.class;
	}

	public String getModelClassName() {
		return SearchPhraseHit.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("phraseId", getPhraseId());
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

		Long phraseId = (Long)attributes.get("phraseId");

		if (phraseId != null) {
			setPhraseId(phraseId);
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
	* Returns the primary key of this search phrase hit.
	*
	* @return the primary key of this search phrase hit
	*/
	public long getPrimaryKey() {
		return _searchPhraseHit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this search phrase hit.
	*
	* @param primaryKey the primary key of this search phrase hit
	*/
	public void setPrimaryKey(long primaryKey) {
		_searchPhraseHit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the hit ID of this search phrase hit.
	*
	* @return the hit ID of this search phrase hit
	*/
	public long getHitId() {
		return _searchPhraseHit.getHitId();
	}

	/**
	* Sets the hit ID of this search phrase hit.
	*
	* @param hitId the hit ID of this search phrase hit
	*/
	public void setHitId(long hitId) {
		_searchPhraseHit.setHitId(hitId);
	}

	/**
	* Returns the company ID of this search phrase hit.
	*
	* @return the company ID of this search phrase hit
	*/
	public long getCompanyId() {
		return _searchPhraseHit.getCompanyId();
	}

	/**
	* Sets the company ID of this search phrase hit.
	*
	* @param companyId the company ID of this search phrase hit
	*/
	public void setCompanyId(long companyId) {
		_searchPhraseHit.setCompanyId(companyId);
	}

	/**
	* Returns the phrase ID of this search phrase hit.
	*
	* @return the phrase ID of this search phrase hit
	*/
	public long getPhraseId() {
		return _searchPhraseHit.getPhraseId();
	}

	/**
	* Sets the phrase ID of this search phrase hit.
	*
	* @param phraseId the phrase ID of this search phrase hit
	*/
	public void setPhraseId(long phraseId) {
		_searchPhraseHit.setPhraseId(phraseId);
	}

	/**
	* Returns the guest of this search phrase hit.
	*
	* @return the guest of this search phrase hit
	*/
	public boolean getGuest() {
		return _searchPhraseHit.getGuest();
	}

	/**
	* Returns <code>true</code> if this search phrase hit is guest.
	*
	* @return <code>true</code> if this search phrase hit is guest; <code>false</code> otherwise
	*/
	public boolean isGuest() {
		return _searchPhraseHit.isGuest();
	}

	/**
	* Sets whether this search phrase hit is guest.
	*
	* @param guest the guest of this search phrase hit
	*/
	public void setGuest(boolean guest) {
		_searchPhraseHit.setGuest(guest);
	}

	/**
	* Returns the access date of this search phrase hit.
	*
	* @return the access date of this search phrase hit
	*/
	public long getAccessDate() {
		return _searchPhraseHit.getAccessDate();
	}

	/**
	* Sets the access date of this search phrase hit.
	*
	* @param accessDate the access date of this search phrase hit
	*/
	public void setAccessDate(long accessDate) {
		_searchPhraseHit.setAccessDate(accessDate);
	}

	public boolean isNew() {
		return _searchPhraseHit.isNew();
	}

	public void setNew(boolean n) {
		_searchPhraseHit.setNew(n);
	}

	public boolean isCachedModel() {
		return _searchPhraseHit.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_searchPhraseHit.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _searchPhraseHit.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _searchPhraseHit.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_searchPhraseHit.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _searchPhraseHit.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_searchPhraseHit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SearchPhraseHitWrapper((SearchPhraseHit)_searchPhraseHit.clone());
	}

	public int compareTo(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit) {
		return _searchPhraseHit.compareTo(searchPhraseHit);
	}

	@Override
	public int hashCode() {
		return _searchPhraseHit.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.SearchPhraseHit> toCacheModel() {
		return _searchPhraseHit.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.SearchPhraseHit toEscapedModel() {
		return new SearchPhraseHitWrapper(_searchPhraseHit.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _searchPhraseHit.toString();
	}

	public java.lang.String toXmlString() {
		return _searchPhraseHit.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_searchPhraseHit.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SearchPhraseHit getWrappedSearchPhraseHit() {
		return _searchPhraseHit;
	}

	public SearchPhraseHit getWrappedModel() {
		return _searchPhraseHit;
	}

	public void resetOriginalValues() {
		_searchPhraseHit.resetOriginalValues();
	}

	private SearchPhraseHit _searchPhraseHit;
}