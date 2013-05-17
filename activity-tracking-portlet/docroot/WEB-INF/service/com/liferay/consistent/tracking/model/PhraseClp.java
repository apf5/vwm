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

import com.liferay.consistent.tracking.service.PhraseLocalServiceUtil;

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
public class PhraseClp extends BaseModelImpl<Phrase> implements Phrase {
	public PhraseClp() {
	}

	public Class<?> getModelClass() {
		return Phrase.class;
	}

	public String getModelClassName() {
		return Phrase.class.getName();
	}

	public long getPrimaryKey() {
		return _phraseId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPhraseId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_phraseId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phraseId", getPhraseId());
		attributes.put("phraseName", getPhraseName());

		return attributes;
	}

	@Override
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

	public long getPhraseId() {
		return _phraseId;
	}

	public void setPhraseId(long phraseId) {
		_phraseId = phraseId;
	}

	public String getPhraseName() {
		return _phraseName;
	}

	public void setPhraseName(String phraseName) {
		_phraseName = phraseName;
	}

	public BaseModel<?> getPhraseRemoteModel() {
		return _phraseRemoteModel;
	}

	public void setPhraseRemoteModel(BaseModel<?> phraseRemoteModel) {
		_phraseRemoteModel = phraseRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PhraseLocalServiceUtil.addPhrase(this);
		}
		else {
			PhraseLocalServiceUtil.updatePhrase(this);
		}
	}

	@Override
	public Phrase toEscapedModel() {
		return (Phrase)Proxy.newProxyInstance(Phrase.class.getClassLoader(),
			new Class[] { Phrase.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PhraseClp clone = new PhraseClp();

		clone.setPhraseId(getPhraseId());
		clone.setPhraseName(getPhraseName());

		return clone;
	}

	public int compareTo(Phrase phrase) {
		int value = 0;

		value = getPhraseName().compareTo(phrase.getPhraseName());

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

		PhraseClp phrase = null;

		try {
			phrase = (PhraseClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = phrase.getPrimaryKey();

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

		sb.append("{phraseId=");
		sb.append(getPhraseId());
		sb.append(", phraseName=");
		sb.append(getPhraseName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.Phrase");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>phraseId</column-name><column-value><![CDATA[");
		sb.append(getPhraseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phraseName</column-name><column-value><![CDATA[");
		sb.append(getPhraseName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _phraseId;
	private String _phraseName;
	private BaseModel<?> _phraseRemoteModel;
}