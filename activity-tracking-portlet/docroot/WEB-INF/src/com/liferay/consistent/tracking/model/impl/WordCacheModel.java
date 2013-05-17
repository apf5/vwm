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

import com.liferay.consistent.tracking.model.Word;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Word in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see Word
 * @generated
 */
public class WordCacheModel implements CacheModel<Word>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{wordId=");
		sb.append(wordId);
		sb.append(", wordName=");
		sb.append(wordName);
		sb.append("}");

		return sb.toString();
	}

	public Word toEntityModel() {
		WordImpl wordImpl = new WordImpl();

		wordImpl.setWordId(wordId);

		if (wordName == null) {
			wordImpl.setWordName(StringPool.BLANK);
		}
		else {
			wordImpl.setWordName(wordName);
		}

		wordImpl.resetOriginalValues();

		return wordImpl;
	}

	public long wordId;
	public String wordName;
}