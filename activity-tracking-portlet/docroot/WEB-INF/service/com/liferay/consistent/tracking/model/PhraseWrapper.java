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
 * This class is a wrapper for {@link Phrase}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       Phrase
 * @generated
 */
public class PhraseWrapper implements Phrase, ModelWrapper<Phrase> {
	public PhraseWrapper(Phrase phrase) {
		_phrase = phrase;
	}

	public Class<?> getModelClass() {
		return Phrase.class;
	}

	public String getModelClassName() {
		return Phrase.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phraseId", getPhraseId());
		attributes.put("phraseName", getPhraseName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long phraseId = (Long)attributes.get("phraseId");

		if (phraseId != null) {
			setPhraseId(phraseId);
		}

		String phraseName = (String)attributes.get("phraseName");

		if (phraseName != null) {
			setPhraseName(phraseName);
		}
	}

	/**
	* Returns the primary key of this phrase.
	*
	* @return the primary key of this phrase
	*/
	public long getPrimaryKey() {
		return _phrase.getPrimaryKey();
	}

	/**
	* Sets the primary key of this phrase.
	*
	* @param primaryKey the primary key of this phrase
	*/
	public void setPrimaryKey(long primaryKey) {
		_phrase.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the phrase ID of this phrase.
	*
	* @return the phrase ID of this phrase
	*/
	public long getPhraseId() {
		return _phrase.getPhraseId();
	}

	/**
	* Sets the phrase ID of this phrase.
	*
	* @param phraseId the phrase ID of this phrase
	*/
	public void setPhraseId(long phraseId) {
		_phrase.setPhraseId(phraseId);
	}

	/**
	* Returns the phrase name of this phrase.
	*
	* @return the phrase name of this phrase
	*/
	public java.lang.String getPhraseName() {
		return _phrase.getPhraseName();
	}

	/**
	* Sets the phrase name of this phrase.
	*
	* @param phraseName the phrase name of this phrase
	*/
	public void setPhraseName(java.lang.String phraseName) {
		_phrase.setPhraseName(phraseName);
	}

	public boolean isNew() {
		return _phrase.isNew();
	}

	public void setNew(boolean n) {
		_phrase.setNew(n);
	}

	public boolean isCachedModel() {
		return _phrase.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_phrase.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _phrase.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _phrase.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_phrase.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _phrase.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_phrase.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhraseWrapper((Phrase)_phrase.clone());
	}

	public int compareTo(com.liferay.consistent.tracking.model.Phrase phrase) {
		return _phrase.compareTo(phrase);
	}

	@Override
	public int hashCode() {
		return _phrase.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.Phrase> toCacheModel() {
		return _phrase.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.Phrase toEscapedModel() {
		return new PhraseWrapper(_phrase.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _phrase.toString();
	}

	public java.lang.String toXmlString() {
		return _phrase.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_phrase.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Phrase getWrappedPhrase() {
		return _phrase;
	}

	public Phrase getWrappedModel() {
		return _phrase;
	}

	public void resetOriginalValues() {
		_phrase.resetOriginalValues();
	}

	private Phrase _phrase;
}