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

package com.liferay.consistent.tracking.service.persistence;

import com.liferay.consistent.tracking.model.Word;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the word service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see WordPersistenceImpl
 * @see WordUtil
 * @generated
 */
public interface WordPersistence extends BasePersistence<Word> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WordUtil} to access the word persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the word in the entity cache if it is enabled.
	*
	* @param word the word
	*/
	public void cacheResult(com.liferay.consistent.tracking.model.Word word);

	/**
	* Caches the words in the entity cache if it is enabled.
	*
	* @param words the words
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Word> words);

	/**
	* Creates a new word with the primary key. Does not add the word to the database.
	*
	* @param wordId the primary key for the new word
	* @return the new word
	*/
	public com.liferay.consistent.tracking.model.Word create(long wordId);

	/**
	* Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordId the primary key of the word
	* @return the word that was removed
	* @throws com.liferay.consistent.tracking.NoSuchWordException if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word remove(long wordId)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.Word updateImpl(
		com.liferay.consistent.tracking.model.Word word, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the word with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchWordException} if it could not be found.
	*
	* @param wordId the primary key of the word
	* @return the word
	* @throws com.liferay.consistent.tracking.NoSuchWordException if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word findByPrimaryKey(
		long wordId)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the word with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wordId the primary key of the word
	* @return the word, or <code>null</code> if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word fetchByPrimaryKey(
		long wordId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the word where wordName = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchWordException} if it could not be found.
	*
	* @param wordName the word name
	* @return the matching word
	* @throws com.liferay.consistent.tracking.NoSuchWordException if a matching word could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word findByWordName(
		java.lang.String wordName)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the word where wordName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param wordName the word name
	* @return the matching word, or <code>null</code> if a matching word could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word fetchByWordName(
		java.lang.String wordName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the word where wordName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param wordName the word name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching word, or <code>null</code> if a matching word could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word fetchByWordName(
		java.lang.String wordName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the words.
	*
	* @return the words
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Word> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the words.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of words
	* @param end the upper bound of the range of words (not inclusive)
	* @return the range of words
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Word> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the words.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of words
	* @param end the upper bound of the range of words (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of words
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Word> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the word where wordName = &#63; from the database.
	*
	* @param wordName the word name
	* @return the word that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word removeByWordName(
		java.lang.String wordName)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the words from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of words where wordName = &#63;.
	*
	* @param wordName the word name
	* @return the number of matching words
	* @throws SystemException if a system exception occurred
	*/
	public int countByWordName(java.lang.String wordName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of words.
	*
	* @return the number of words
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}