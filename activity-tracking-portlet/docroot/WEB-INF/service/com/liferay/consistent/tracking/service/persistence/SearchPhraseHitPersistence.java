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

import com.liferay.consistent.tracking.model.SearchPhraseHit;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the search phrase hit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SearchPhraseHitPersistenceImpl
 * @see SearchPhraseHitUtil
 * @generated
 */
public interface SearchPhraseHitPersistence extends BasePersistence<SearchPhraseHit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SearchPhraseHitUtil} to access the search phrase hit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the search phrase hit in the entity cache if it is enabled.
	*
	* @param searchPhraseHit the search phrase hit
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit);

	/**
	* Caches the search phrase hits in the entity cache if it is enabled.
	*
	* @param searchPhraseHits the search phrase hits
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> searchPhraseHits);

	/**
	* Creates a new search phrase hit with the primary key. Does not add the search phrase hit to the database.
	*
	* @param hitId the primary key for the new search phrase hit
	* @return the new search phrase hit
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit create(
		long hitId);

	/**
	* Removes the search phrase hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit that was removed
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit remove(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.SearchPhraseHit updateImpl(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search phrase hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchSearchPhraseHitException} if it could not be found.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit findByPrimaryKey(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search phrase hit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit, or <code>null</code> if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchByPrimaryKey(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search phrase hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search phrase hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @return the range of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search phrase hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search phrase hits before and after the current search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param hitId the primary key of the current search phrase hit
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit[] findByCompanyId_PrevAndNext(
		long hitId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search phrase hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search phrase hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @return the range of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search phrase hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search phrase hits before and after the current search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current search phrase hit
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit[] findByC_G_PrevAndNext(
		long hitId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @return the matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_P_G(
		long companyId, long phraseId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @return the range of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_P_G(
		long companyId, long phraseId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_P_G(
		long companyId, long phraseId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit findByC_P_G_First(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_P_G_First(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit findByC_P_G_Last(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_P_G_Last(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search phrase hits before and after the current search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current search phrase hit
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit[] findByC_P_G_PrevAndNext(
		long hitId, long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search phrase hits.
	*
	* @return the search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search phrase hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @return the range of search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search phrase hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the search phrase hits where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the search phrase hits where companyId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_P_G(long companyId, long phraseId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the search phrase hits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search phrase hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search phrase hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @return the number of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_P_G(long companyId, long phraseId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search phrase hits.
	*
	* @return the number of search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}