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

package com.liferay.consistent.tracking.model.impl;

import com.liferay.consistent.tracking.model.Phrase;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Phrase in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see Phrase
 * @generated
 */
public class PhraseCacheModel implements CacheModel<Phrase>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{phraseId=");
		sb.append(phraseId);
		sb.append(", phraseName=");
		sb.append(phraseName);
		sb.append("}");

		return sb.toString();
	}

	public Phrase toEntityModel() {
		PhraseImpl phraseImpl = new PhraseImpl();

		phraseImpl.setPhraseId(phraseId);

		if (phraseName == null) {
			phraseImpl.setPhraseName(StringPool.BLANK);
		}
		else {
			phraseImpl.setPhraseName(phraseName);
		}

		phraseImpl.resetOriginalValues();

		return phraseImpl;
	}

	public long phraseId;
	public String phraseName;
}