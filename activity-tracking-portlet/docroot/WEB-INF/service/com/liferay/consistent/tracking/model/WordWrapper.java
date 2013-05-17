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
 * This class is a wrapper for {@link Word}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       Word
 * @generated
 */
public class WordWrapper implements Word, ModelWrapper<Word> {
	public WordWrapper(Word word) {
		_word = word;
	}

	public Class<?> getModelClass() {
		return Word.class;
	}

	public String getModelClassName() {
		return Word.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wordId", getWordId());
		attributes.put("wordName", getWordName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long wordId = (Long)attributes.get("wordId");

		if (wordId != null) {
			setWordId(wordId);
		}

		String wordName = (String)attributes.get("wordName");

		if (wordName != null) {
			setWordName(wordName);
		}
	}

	/**
	* Returns the primary key of this word.
	*
	* @return the primary key of this word
	*/
	public long getPrimaryKey() {
		return _word.getPrimaryKey();
	}

	/**
	* Sets the primary key of this word.
	*
	* @param primaryKey the primary key of this word
	*/
	public void setPrimaryKey(long primaryKey) {
		_word.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the word ID of this word.
	*
	* @return the word ID of this word
	*/
	public long getWordId() {
		return _word.getWordId();
	}

	/**
	* Sets the word ID of this word.
	*
	* @param wordId the word ID of this word
	*/
	public void setWordId(long wordId) {
		_word.setWordId(wordId);
	}

	/**
	* Returns the word name of this word.
	*
	* @return the word name of this word
	*/
	public java.lang.String getWordName() {
		return _word.getWordName();
	}

	/**
	* Sets the word name of this word.
	*
	* @param wordName the word name of this word
	*/
	public void setWordName(java.lang.String wordName) {
		_word.setWordName(wordName);
	}

	public boolean isNew() {
		return _word.isNew();
	}

	public void setNew(boolean n) {
		_word.setNew(n);
	}

	public boolean isCachedModel() {
		return _word.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_word.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _word.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _word.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_word.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _word.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_word.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WordWrapper((Word)_word.clone());
	}

	public int compareTo(com.liferay.consistent.tracking.model.Word word) {
		return _word.compareTo(word);
	}

	@Override
	public int hashCode() {
		return _word.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.consistent.tracking.model.Word> toCacheModel() {
		return _word.toCacheModel();
	}

	public com.liferay.consistent.tracking.model.Word toEscapedModel() {
		return new WordWrapper(_word.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _word.toString();
	}

	public java.lang.String toXmlString() {
		return _word.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_word.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Word getWrappedWord() {
		return _word;
	}

	public Word getWrappedModel() {
		return _word;
	}

	public void resetOriginalValues() {
		_word.resetOriginalValues();
	}

	private Word _word;
}