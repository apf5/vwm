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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the site hit service. This utility wraps {@link SiteHitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SiteHitPersistence
 * @see SiteHitPersistenceImpl
 * @generated
 */
public class SiteHitUtil {
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
	public static void clearCache(SiteHit siteHit) {
		getPersistence().clearCache(siteHit);
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
	public static List<SiteHit> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SiteHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SiteHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SiteHit update(SiteHit siteHit, boolean merge)
		throws SystemException {
		return getPersistence().update(siteHit, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SiteHit update(SiteHit siteHit, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(siteHit, merge, serviceContext);
	}

	/**
	* Caches the site hit in the entity cache if it is enabled.
	*
	* @param siteHit the site hit
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.SiteHit siteHit) {
		getPersistence().cacheResult(siteHit);
	}

	/**
	* Caches the site hits in the entity cache if it is enabled.
	*
	* @param siteHits the site hits
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.SiteHit> siteHits) {
		getPersistence().cacheResult(siteHits);
	}

	/**
	* Creates a new site hit with the primary key. Does not add the site hit to the database.
	*
	* @param hitId the primary key for the new site hit
	* @return the new site hit
	*/
	public static com.liferay.consistent.tracking.model.SiteHit create(
		long hitId) {
		return getPersistence().create(hitId);
	}

	/**
	* Removes the site hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit that was removed
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit remove(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(hitId);
	}

	public static com.liferay.consistent.tracking.model.SiteHit updateImpl(
		com.liferay.consistent.tracking.model.SiteHit siteHit, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(siteHit, merge);
	}

	/**
	* Returns the site hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchSiteHitException} if it could not be found.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit findByPrimaryKey(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(hitId);
	}

	/**
	* Returns the site hit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit, or <code>null</code> if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit fetchByPrimaryKey(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(hitId);
	}

	/**
	* Returns all the site hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit
	* @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last site hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit[] findByCompanyId_PrevAndNext(
		long hitId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(hitId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the site hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest, start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, guest, start, end, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the first site hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, guest, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last site hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.SiteHit fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, guest, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit[] findByC_G_PrevAndNext(
		long hitId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(hitId, companyId, guest,
			orderByComparator);
	}

	/**
	* Returns all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @return the matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_S_G(
		long companyId, long siteId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S_G(companyId, siteId, guest);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_S_G(
		long companyId, long siteId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S_G(companyId, siteId, guest, start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findByC_S_G(
		long companyId, long siteId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S_G(companyId, siteId, guest, start, end,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit findByC_S_G_First(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S_G_First(companyId, siteId, guest,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit fetchByC_S_G_First(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_S_G_First(companyId, siteId, guest,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit findByC_S_G_Last(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S_G_Last(companyId, siteId, guest, orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit fetchByC_S_G_Last(
		long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_S_G_Last(companyId, siteId, guest,
			orderByComparator);
	}

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
	public static com.liferay.consistent.tracking.model.SiteHit[] findByC_S_G_PrevAndNext(
		long hitId, long companyId, long siteId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchSiteHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S_G_PrevAndNext(hitId, companyId, siteId, guest,
			orderByComparator);
	}

	/**
	* Returns all the site hits.
	*
	* @return the site hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.consistent.tracking.model.SiteHit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the site hits where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the site hits where companyId = &#63; and guest = &#63; from the database.
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
	* Removes all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_S_G(long companyId, long siteId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_S_G(companyId, siteId, guest);
	}

	/**
	* Removes all the site hits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of site hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of site hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, guest);
	}

	/**
	* Returns the number of site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param siteId the site ID
	* @param guest the guest
	* @return the number of matching site hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_S_G(long companyId, long siteId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_S_G(companyId, siteId, guest);
	}

	/**
	* Returns the number of site hits.
	*
	* @return the number of site hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SiteHitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SiteHitPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					SiteHitPersistence.class.getName());

			ReferenceRegistry.registerReference(SiteHitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SiteHitPersistence persistence) {
	}

	private static SiteHitPersistence _persistence;
}