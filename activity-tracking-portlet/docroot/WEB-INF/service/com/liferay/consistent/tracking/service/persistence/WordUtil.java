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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the word service. This utility wraps {@link WordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see WordPersistence
 * @see WordPersistenceImpl
 * @generated
 */
public class WordUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Word word) {
		getPersistence().clearCache(word);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Word> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Word> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Word> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Word update(Word word, boolean merge)
		throws SystemException {
		return getPersistence().update(word, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Word update(Word word, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(word, merge, serviceContext);
	}

	/**
	* Caches the word in the entity cache if it is enabled.
	*
	* @param word the word
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.Word word) {
		getPersistence().cacheResult(word);
	}

	/**
	* Caches the words in the entity cache if it is enabled.
	*
	* @param words the words
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Word> words) {
		getPersistence().cacheResult(words);
	}

	/**
	* Creates a new word with the primary key. Does not add the word to the database.
	*
	* @param wordId the primary key for the new word
	* @return the new word
	*/
	public static com.liferay.consistent.tracking.model.Word create(long wordId) {
		return getPersistence().create(wordId);
	}

	/**
	* Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordId the primary key of the word
	* @return the word that was removed
	* @throws com.liferay.consistent.tracking.NoSuchWordException if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Word remove(long wordId)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(wordId);
	}

	public static com.liferay.consistent.tracking.model.Word updateImpl(
		com.liferay.consistent.tracking.model.Word word, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(word, merge);
	}

	/**
	* Returns the word with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchWordException} if it could not be found.
	*
	* @param wordId the primary key of the word
	* @return the word
	* @throws com.liferay.consistent.tracking.NoSuchWordException if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Word findByPrimaryKey(
		long wordId)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(wordId);
	}

	/**
	* Returns the word with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wordId the primary key of the word
	* @return the word, or <code>null</code> if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Word fetchByPrimaryKey(
		long wordId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wordId);
	}

	/**
	* Returns the word where wordName = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchWordException} if it could not be found.
	*
	* @param wordName the word name
	* @return the matching word
	* @throws com.liferay.consistent.tracking.NoSuchWordException if a matching word could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Word findByWordName(
		java.lang.String wordName)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWordName(wordName);
	}

	/**
	* Returns the word where wordName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param wordName the word name
	* @return the matching word, or <code>null</code> if a matching word could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Word fetchByWordName(
		java.lang.String wordName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWordName(wordName);
	}

	/**
	* Returns the word where wordName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param wordName the word name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching word, or <code>null</code> if a matching word could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Word fetchByWordName(
		java.lang.String wordName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWordName(wordName, retrieveFromCache);
	}

	/**
	* Returns all the words.
	*
	* @return the words
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Word> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.Word> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.Word> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the word where wordName = &#63; from the database.
	*
	* @param wordName the word name
	* @return the word that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Word removeByWordName(
		java.lang.String wordName)
		throws com.liferay.consistent.tracking.NoSuchWordException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByWordName(wordName);
	}

	/**
	* Removes all the words from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of words where wordName = &#63;.
	*
	* @param wordName the word name
	* @return the number of matching words
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWordName(java.lang.String wordName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWordName(wordName);
	}

	/**
	* Returns the number of words.
	*
	* @return the number of words
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WordPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WordPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					WordPersistence.class.getName());

			ReferenceRegistry.registerReference(WordUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(WordPersistence persistence) {
	}

	private static WordPersistence _persistence;
}