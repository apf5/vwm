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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SearchPhraseHit service. Represents a row in the &quot;CONSIS_TRACK_SearchPhraseHit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.consistent.tracking.model.impl.SearchPhraseHitModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.consistent.tracking.model.impl.SearchPhraseHitImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SearchPhraseHit
 * @see com.liferay.consistent.tracking.model.impl.SearchPhraseHitImpl
 * @see com.liferay.consistent.tracking.model.impl.SearchPhraseHitModelImpl
 * @generated
 */
public interface SearchPhraseHitModel extends BaseModel<SearchPhraseHit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a search phrase hit model instance should use the {@link SearchPhraseHit} interface instead.
	 */

	/**
	 * Returns the primary key of this search phrase hit.
	 *
	 * @return the primary key of this search phrase hit
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this search phrase hit.
	 *
	 * @param primaryKey the primary key of this search phrase hit
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the hit ID of this search phrase hit.
	 *
	 * @return the hit ID of this search phrase hit
	 */
	public long getHitId();

	/**
	 * Sets the hit ID of this search phrase hit.
	 *
	 * @param hitId the hit ID of this search phrase hit
	 */
	public void setHitId(long hitId);

	/**
	 * Returns the company ID of this search phrase hit.
	 *
	 * @return the company ID of this search phrase hit
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this search phrase hit.
	 *
	 * @param companyId the company ID of this search phrase hit
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the phrase ID of this search phrase hit.
	 *
	 * @return the phrase ID of this search phrase hit
	 */
	public long getPhraseId();

	/**
	 * Sets the phrase ID of this search phrase hit.
	 *
	 * @param phraseId the phrase ID of this search phrase hit
	 */
	public void setPhraseId(long phraseId);

	/**
	 * Returns the guest of this search phrase hit.
	 *
	 * @return the guest of this search phrase hit
	 */
	public boolean getGuest();

	/**
	 * Returns <code>true</code> if this search phrase hit is guest.
	 *
	 * @return <code>true</code> if this search phrase hit is guest; <code>false</code> otherwise
	 */
	public boolean isGuest();

	/**
	 * Sets whether this search phrase hit is guest.
	 *
	 * @param guest the guest of this search phrase hit
	 */
	public void setGuest(boolean guest);

	/**
	 * Returns the access date of this search phrase hit.
	 *
	 * @return the access date of this search phrase hit
	 */
	public long getAccessDate();

	/**
	 * Sets the access date of this search phrase hit.
	 *
	 * @param accessDate the access date of this search phrase hit
	 */
	public void setAccessDate(long accessDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(SearchPhraseHit searchPhraseHit);

	public int hashCode();

	public CacheModel<SearchPhraseHit> toCacheModel();

	public SearchPhraseHit toEscapedModel();

	public String toString();

	public String toXmlString();
}