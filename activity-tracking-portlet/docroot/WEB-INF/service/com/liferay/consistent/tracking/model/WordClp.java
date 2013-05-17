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

import com.liferay.consistent.tracking.service.WordLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza Soloisolo
 */
public class WordClp extends BaseModelImpl<Word> implements Word {
	public WordClp() {
	}

	public Class<?> getModelClass() {
		return Word.class;
	}

	public String getModelClassName() {
		return Word.class.getName();
	}

	public long getPrimaryKey() {
		return _wordId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWordId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_wordId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wordId", getWordId());
		attributes.put("wordName", getWordName());

		return attributes;
	}

	@Override
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

	public long getWordId() {
		return _wordId;
	}

	public void setWordId(long wordId) {
		_wordId = wordId;
	}

	public String getWordName() {
		return _wordName;
	}

	public void setWordName(String wordName) {
		_wordName = wordName;
	}

	public BaseModel<?> getWordRemoteModel() {
		return _wordRemoteModel;
	}

	public void setWordRemoteModel(BaseModel<?> wordRemoteModel) {
		_wordRemoteModel = wordRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WordLocalServiceUtil.addWord(this);
		}
		else {
			WordLocalServiceUtil.updateWord(this);
		}
	}

	@Override
	public Word toEscapedModel() {
		return (Word)Proxy.newProxyInstance(Word.class.getClassLoader(),
			new Class[] { Word.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WordClp clone = new WordClp();

		clone.setWordId(getWordId());
		clone.setWordName(getWordName());

		return clone;
	}

	public int compareTo(Word word) {
		int value = 0;

		value = getWordName().compareTo(word.getWordName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WordClp word = null;

		try {
			word = (WordClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = word.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{wordId=");
		sb.append(getWordId());
		sb.append(", wordName=");
		sb.append(getWordName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.Word");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>wordId</column-name><column-value><![CDATA[");
		sb.append(getWordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wordName</column-name><column-value><![CDATA[");
		sb.append(getWordName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _wordId;
	private String _wordName;
	private BaseModel<?> _wordRemoteModel;
}