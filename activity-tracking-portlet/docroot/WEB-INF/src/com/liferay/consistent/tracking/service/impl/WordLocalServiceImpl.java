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

package com.liferay.consistent.tracking.service.impl;

import com.liferay.consistent.tracking.NoSuchWordException;
import com.liferay.consistent.tracking.model.Word;
import com.liferay.consistent.tracking.service.base.WordLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the word local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.WordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.WordLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.WordLocalServiceUtil
 */
public class WordLocalServiceImpl extends WordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.WordLocalServiceUtil} to access the word local service.
	 */
	
	public Word getWord(String wordName)
			throws SystemException{
		Word word = null;
		
		try {
			word = wordPersistence.findByWordName(wordName);
		} catch (NoSuchWordException e) {
			word = wordPersistence.create(counterLocalService.increment(
					Word.class.getName()));
			word.setWordName(wordName);
			wordPersistence.update(word, false);
		}
					
		return word;
	}
	
}