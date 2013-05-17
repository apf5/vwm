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

import com.liferay.consistent.tracking.model.Phrase;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the phrase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PhrasePersistenceImpl
 * @see PhraseUtil
 * @generated
 */
public interface PhrasePersistence extends BasePersistence<Phrase> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhraseUtil} to access the phrase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the phrase in the entity cache if it is enabled.
	*
	* @param phrase the phrase
	*/
	public void cacheResult(com.liferay.consistent.tracking.model.Phrase phrase);

	/**
	* Caches the phrases in the entity cache if it is enabled.
	*
	* @param phrases the phrases
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Phrase> phrases);

	/**
	* Creates a new phrase with the primary key. Does not add the phrase to the database.
	*
	* @param phraseId the primary key for the new phrase
	* @return the new phrase
	*/
	public com.liferay.consistent.tracking.model.Phrase create(long phraseId);

	/**
	* Removes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param phraseId the primary key of the phrase
	* @return the phrase that was removed
	* @throws com.liferay.consistent.tracking.NoSuchPhraseException if a phrase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase remove(long phraseId)
		throws com.liferay.consistent.tracking.NoSuchPhraseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.Phrase updateImpl(
		com.liferay.consistent.tracking.model.Phrase phrase, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phrase with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchPhraseException} if it could not be found.
	*
	* @param phraseId the primary key of the phrase
	* @return the phrase
	* @throws com.liferay.consistent.tracking.NoSuchPhraseException if a phrase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase findByPrimaryKey(
		long phraseId)
		throws com.liferay.consistent.tracking.NoSuchPhraseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phrase with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param phraseId the primary key of the phrase
	* @return the phrase, or <code>null</code> if a phrase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase fetchByPrimaryKey(
		long phraseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phrase where phraseName = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchPhraseException} if it could not be found.
	*
	* @param phraseName the phrase name
	* @return the matching phrase
	* @throws com.liferay.consistent.tracking.NoSuchPhraseException if a matching phrase could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase findByPhraseName(
		java.lang.String phraseName)
		throws com.liferay.consistent.tracking.NoSuchPhraseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phrase where phraseName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param phraseName the phrase name
	* @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase fetchByPhraseName(
		java.lang.String phraseName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phrase where phraseName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param phraseName the phrase name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase fetchByPhraseName(
		java.lang.String phraseName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phrases.
	*
	* @return the phrases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Phrase> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phrases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of phrases
	* @param end the upper bound of the range of phrases (not inclusive)
	* @return the range of phrases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Phrase> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the phrases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of phrases
	* @param end the upper bound of the range of phrases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of phrases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Phrase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the phrase where phraseName = &#63; from the database.
	*
	* @param phraseName the phrase name
	* @return the phrase that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase removeByPhraseName(
		java.lang.String phraseName)
		throws com.liferay.consistent.tracking.NoSuchPhraseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the phrases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phrases where phraseName = &#63;.
	*
	* @param phraseName the phrase name
	* @return the number of matching phrases
	* @throws SystemException if a system exception occurred
	*/
	public int countByPhraseName(java.lang.String phraseName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phrases.
	*
	* @return the number of phrases
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}