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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Phrase service. Represents a row in the &quot;CONSIS_TRACK_Phrase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.consistent.tracking.model.impl.PhraseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.consistent.tracking.model.impl.PhraseImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see Phrase
 * @see com.liferay.consistent.tracking.model.impl.PhraseImpl
 * @see com.liferay.consistent.tracking.model.impl.PhraseModelImpl
 * @generated
 */
public interface PhraseModel extends BaseModel<Phrase> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a phrase model instance should use the {@link Phrase} interface instead.
	 */

	/**
	 * Returns the primary key of this phrase.
	 *
	 * @return the primary key of this phrase
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this phrase.
	 *
	 * @param primaryKey the primary key of this phrase
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the phrase ID of this phrase.
	 *
	 * @return the phrase ID of this phrase
	 */
	public long getPhraseId();

	/**
	 * Sets the phrase ID of this phrase.
	 *
	 * @param phraseId the phrase ID of this phrase
	 */
	public void setPhraseId(long phraseId);

	/**
	 * Returns the phrase name of this phrase.
	 *
	 * @return the phrase name of this phrase
	 */
	@AutoEscape
	public String getPhraseName();

	/**
	 * Sets the phrase name of this phrase.
	 *
	 * @param phraseName the phrase name of this phrase
	 */
	public void setPhraseName(String phraseName);

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

	public int compareTo(Phrase phrase);

	public int hashCode();

	public CacheModel<Phrase> toCacheModel();

	public Phrase toEscapedModel();

	public String toString();

	public String toXmlString();
}