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

import com.liferay.consistent.tracking.model.PortletHit;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the portlet hit service. This utility wraps {@link PortletHitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PortletHitPersistence
 * @see PortletHitPersistenceImpl
 * @generated
 */
public class PortletHitUtil {
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
	public static void clearCache(PortletHit portletHit) {
		getPersistence().clearCache(portletHit);
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
	public static List<PortletHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortletHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortletHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PortletHit update(PortletHit portletHit, boolean merge)
		throws SystemException {
		return getPersistence().update(portletHit, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PortletHit update(PortletHit portletHit, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portletHit, merge, serviceContext);
	}

	/**
	* Caches the portlet hit in the entity cache if it is enabled.
	*
	* @param portletHit the portlet hit
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.PortletHit portletHit) {
		getPersistence().cacheResult(portletHit);
	}

	/**
	* Caches the portlet hits in the entity cache if it is enabled.
	*
	* @param portletHits the portlet hits
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.PortletHit> portletHits) {
		getPersistence().cacheResult(portletHits);
	}

	/**
	* Creates a new portlet hit with the primary key. Does not add the portlet hit to the database.
	*
	* @param hitId the primary key for the new portlet hit
	* @return the new portlet hit
	*/
	public static com.liferay.consistent.tracking.model.PortletHit create(
		long hitId) {
		return getPersistence().create(hitId);
	}

	/**
	* Removes the portlet hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the portlet hit
	* @return the portlet hit that was removed
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit remove(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(hitId);
	}

	public static com.liferay.consistent.tracking.model.PortletHit updateImpl(
		com.liferay.consistent.tracking.model.PortletHit portletHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portletHit, merge);
	}

	/**
	* Returns the portlet hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchPortletHitException} if it could not be found.
	*
	* @param hitId the primary key of the portlet hit
	* @return the portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByPrimaryKey(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(hitId);
	}

	/**
	* Returns the portlet hit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hitId the primary key of the portlet hit
	* @return the portlet hit, or <code>null</code> if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByPrimaryKey(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(hitId);
	}

	/**
	* Returns all the portlet hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the portlet hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @return the range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63;.
	*
	* @param hitId the primary key of the current portlet hit
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit[] findByCompanyId_PrevAndNext(
		long hitId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(hitId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the portlet hits where companyId = &#63; and userlogId = &#63;.
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @return the matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_S(
		long companyId, long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S(companyId, userlogId);
	}

	/**
	* Returns a range of all the portlet hits where companyId = &#63; and userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @return the range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_S(
		long companyId, long userlogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S(companyId, userlogId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet hits where companyId = &#63; and userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_S(
		long companyId, long userlogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S(companyId, userlogId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and userlogId = &#63;.
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_S_First(
		long companyId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S_First(companyId, userlogId, orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and userlogId = &#63;.
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_S_First(
		long companyId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_S_First(companyId, userlogId, orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and userlogId = &#63;.
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_S_Last(
		long companyId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S_Last(companyId, userlogId, orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and userlogId = &#63;.
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_S_Last(
		long companyId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_S_Last(companyId, userlogId, orderByComparator);
	}

	/**
	* Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63; and userlogId = &#63;.
	*
	* @param hitId the primary key of the current portlet hit
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit[] findByC_S_PrevAndNext(
		long hitId, long companyId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S_PrevAndNext(hitId, companyId, userlogId,
			orderByComparator);
	}

	/**
	* Returns all the portlet hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest);
	}

	/**
	* Returns a range of all the portlet hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @return the range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest, start, end);
	}

	/**
	* Returns an ordered range of all the portlet hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, guest, start, end, orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current portlet hit
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit[] findByC_G_PrevAndNext(
		long hitId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(hitId, companyId, guest,
			orderByComparator);
	}

	/**
	* Returns all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @return the matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_P_G(
		long companyId, java.lang.String portletId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_P_G(companyId, portletId, guest);
	}

	/**
	* Returns a range of all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @return the range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_P_G(
		long companyId, java.lang.String portletId, boolean guest, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G(companyId, portletId, guest, start, end);
	}

	/**
	* Returns an ordered range of all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_P_G(
		long companyId, java.lang.String portletId, boolean guest, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G(companyId, portletId, guest, start, end,
			orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_P_G_First(
		long companyId, java.lang.String portletId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G_First(companyId, portletId, guest,
			orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_P_G_First(
		long companyId, java.lang.String portletId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_P_G_First(companyId, portletId, guest,
			orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_P_G_Last(
		long companyId, java.lang.String portletId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G_Last(companyId, portletId, guest,
			orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_P_G_Last(
		long companyId, java.lang.String portletId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_P_G_Last(companyId, portletId, guest,
			orderByComparator);
	}

	/**
	* Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current portlet hit
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit[] findByC_P_G_PrevAndNext(
		long hitId, long companyId, java.lang.String portletId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_G_PrevAndNext(hitId, companyId, portletId, guest,
			orderByComparator);
	}

	/**
	* Returns all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @return the matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_P_U(
		long companyId, java.lang.String portletId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_P_U(companyId, portletId, userId);
	}

	/**
	* Returns a range of all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @return the range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_P_U(
		long companyId, java.lang.String portletId, long userId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_U(companyId, portletId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findByC_P_U(
		long companyId, java.lang.String portletId, long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_U(companyId, portletId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_P_U_First(
		long companyId, java.lang.String portletId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_U_First(companyId, portletId, userId,
			orderByComparator);
	}

	/**
	* Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_P_U_First(
		long companyId, java.lang.String portletId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_P_U_First(companyId, portletId, userId,
			orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit findByC_P_U_Last(
		long companyId, java.lang.String portletId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_U_Last(companyId, portletId, userId,
			orderByComparator);
	}

	/**
	* Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit fetchByC_P_U_Last(
		long companyId, java.lang.String portletId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_P_U_Last(companyId, portletId, userId,
			orderByComparator);
	}

	/**
	* Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* @param hitId the primary key of the current portlet hit
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet hit
	* @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit[] findByC_P_U_PrevAndNext(
		long hitId, long companyId, java.lang.String portletId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_P_U_PrevAndNext(hitId, companyId, portletId,
			userId, orderByComparator);
	}

	/**
	* Returns all the portlet hits.
	*
	* @return the portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the portlet hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @return the range of portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the portlet hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the portlet hits where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the portlet hits where companyId = &#63; and userlogId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_S(long companyId, long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_S(companyId, userlogId);
	}

	/**
	* Removes all the portlet hits where companyId = &#63; and guest = &#63; from the database.
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
	* Removes all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_P_G(long companyId,
		java.lang.String portletId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_P_G(companyId, portletId, guest);
	}

	/**
	* Removes all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_P_U(long companyId,
		java.lang.String portletId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_P_U(companyId, portletId, userId);
	}

	/**
	* Removes all the portlet hits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of portlet hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of portlet hits where companyId = &#63; and userlogId = &#63;.
	*
	* @param companyId the company ID
	* @param userlogId the userlog ID
	* @return the number of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_S(long companyId, long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_S(companyId, userlogId);
	}

	/**
	* Returns the number of portlet hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, guest);
	}

	/**
	* Returns the number of portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param guest the guest
	* @return the number of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_P_G(long companyId, java.lang.String portletId,
		boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_P_G(companyId, portletId, guest);
	}

	/**
	* Returns the number of portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param userId the user ID
	* @return the number of matching portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_P_U(long companyId, java.lang.String portletId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_P_U(companyId, portletId, userId);
	}

	/**
	* Returns the number of portlet hits.
	*
	* @return the number of portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortletHitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortletHitPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					PortletHitPersistence.class.getName());

			ReferenceRegistry.registerReference(PortletHitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PortletHitPersistence persistence) {
	}

	private static PortletHitPersistence _persistence;
}