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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the search phrase hit service. This utility wraps {@link SearchPhraseHitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SearchPhraseHitPersistence
 * @see SearchPhraseHitPersistenceImpl
 * @generated
 */
public class SearchPhraseHitUtil {
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
	public static void clearCache(SearchPhraseHit searchPhraseHit) {
		getPersistence().clearCache(searchPhraseHit);
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
	public static List<SearchPhraseHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SearchPhraseHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SearchPhraseHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SearchPhraseHit update(SearchPhraseHit searchPhraseHit,
		boolean merge) throws SystemException {
		return getPersistence().update(searchPhraseHit, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SearchPhraseHit update(SearchPhraseHit searchPhraseHit,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(searchPhraseHit, merge, serviceContext);
	}

	/**
	* Caches the search phrase hit in the entity cache if it is enabled.
	*
	* @param searchPhraseHit the search phrase hit
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit) {
		getPersistence().cacheResult(searchPhraseHit);
	}

	/**
	* Caches the search phrase hits in the entity cache if it is enabled.
	*
	* @param searchPhraseHits the search phrase hits
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> searchPhraseHits) {
		getPersistence().cacheResult(searchPhraseHits);
	}

	/**
	* Creates a new search phrase hit with the primary key. Does not add the search phrase hit to the database.
	*
	* @param hitId the primary key for the new search phrase hit
	* @return the new search phrase hit
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit create(
		long hitId) {
		return getPersistence().create(hitId);
	}

	/**
	* Removes the search phrase hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit that was removed
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit remove(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(hitId);
	}

	public static com.liferay.consistent.tracking.model.SearchPhraseHit updateImpl(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(searchPhraseHit, merge);
	}

	/**
	* Returns the search phrase hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchSearchPhraseHitException} if it could not be found.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit findByPrimaryKey(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(hitId);
	}

	/**
	* Returns the search phrase hit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit, or <code>null</code> if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit fetchByPrimaryKey(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(hitId);
	}

	/**
	* Returns all the search phrase hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit
	* @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit[] findByCompanyId_PrevAndNext(
		long hitId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(hitId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the search phrase hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest, start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, guest, start, end, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the first search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, guest, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, guest, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit[] findByC_G_PrevAndNext(
		long hitId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(hitId, companyId, guest,
			orderByComparator);
	}

	/**
	* Returns all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @return the matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_P_G(
		long companyId, long phraseId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_P_G(companyId, phraseId, guest);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_P_G(
		long companyId, long phraseId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G(companyId, phraseId, guest, start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findByC_P_G(
		long companyId, long phraseId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G(companyId, phraseId, guest, start, end,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit findByC_P_G_First(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G_First(companyId, phraseId, guest,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_P_G_First(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_P_G_First(companyId, phraseId, guest,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit findByC_P_G_Last(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G_Last(companyId, phraseId, guest,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit fetchByC_P_G_Last(
		long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_P_G_Last(companyId, phraseId, guest,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SearchPhraseHit[] findByC_P_G_PrevAndNext(
		long hitId, long companyId, long phraseId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G_PrevAndNext(hitId, companyId, phraseId, guest,
			orderByComparator);
	}

	/**
	* Returns all the search phrase hits.
	*
	* @return the search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the search phrase hits where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the search phrase hits where companyId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G(companyId, guest);
	}

	/**
	* Removes all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_P_G(long companyId, long phraseId,
		boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_P_G(companyId, phraseId, guest);
	}

	/**
	* Removes all the search phrase hits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of search phrase hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of search phrase hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, guest);
	}

	/**
	* Returns the number of search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param phraseId the phrase ID
	* @param guest the guest
	* @return the number of matching search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_P_G(long companyId, long phraseId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_P_G(companyId, phraseId, guest);
	}

	/**
	* Returns the number of search phrase hits.
	*
	* @return the number of search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SearchPhraseHitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SearchPhraseHitPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					SearchPhraseHitPersistence.class.getName());

			ReferenceRegistry.registerReference(SearchPhraseHitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SearchPhraseHitPersistence persistence) {
	}

	private static SearchPhraseHitPersistence _persistence;
}