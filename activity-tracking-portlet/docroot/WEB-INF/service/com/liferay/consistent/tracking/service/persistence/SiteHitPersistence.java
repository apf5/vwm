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

import com.liferay.consistent.tracking.model.SiteHit;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the site hit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SiteHitPersistenceImpl
 * @see SiteHitUtil
 * @generated
 */
public interface SiteHitPersistence extends BasePersistence<SiteHit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SiteHitUtil} to access the site hit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the site hit in the entity cache if it is enabled.
	*
	* @param siteHit the site hit
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.SiteHit siteHit);

	/**
	* Caches the site hits in the entity cache if it is enabled.
	*
	* @param siteHits the site hits
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.SiteHit> siteHits);

	/**
	* Creates a new site hit with the primary key. Does not add the site hit to the database.
	*
	* @param hitId the primary key for the new site hit
	* @return the new site hit
	*/
	public com.liferay.consistent.tracking.model.SiteHit create(long hitId);

	/**
	* Removes the site hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit that was removed
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit remove(long hitId)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.SiteHit updateImpl(
		com.liferay.consistent.tracking.model.SiteHit siteHit, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the site hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchSiteHitException} if it could not be found.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit findByPrimaryKey(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the site hit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit, or <code>null</code> if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit fetchByPrimaryKey(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the site hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the site hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @return the range of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the site hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the site hits before and after the current site hit in the ordered set where companyId = &#63;.
	*
	* @param hitId the primary key of the current site hit
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit[] findByCompanyId_PrevAndNext(
		long hitId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the site hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the site hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @return the range of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the site hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first site hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first site hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last site hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last site hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the site hits before and after the current site hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current site hit
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit[] findByC_G_PrevAndNext(
		long hitId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @return the matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_S_G(
		long companyId, long siteId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @return the range of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_S_G(
		long companyId, long siteId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_S_G(
		long companyId, long siteId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit findByC_S_G_First(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit fetchByC_S_G_First(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit findByC_S_G_Last(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit fetchByC_S_G_Last(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the site hits before and after the current site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current site hit
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit[] findByC_S_G_PrevAndNext(
		long hitId, long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the site hits.
	*
	* @return the site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the site hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @return the range of site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the site hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the site hits where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the site hits where companyId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_S_G(long companyId, long siteId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the site hits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of site hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of site hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @return the number of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_S_G(long companyId, long siteId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of site hits.
	*
	* @return the number of site hits
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}