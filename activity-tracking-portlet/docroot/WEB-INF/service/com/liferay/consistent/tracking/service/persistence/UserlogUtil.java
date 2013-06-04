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

import com.liferay.consistent.tracking.model.Userlog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the userlog service. This utility wraps {@link UserlogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see UserlogPersistence
 * @see UserlogPersistenceImpl
 * @generated
 */
public class UserlogUtil {
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
	public static void clearCache(Userlog userlog) {
		getPersistence().clearCache(userlog);
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
	public static List<Userlog> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Userlog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Userlog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Userlog update(Userlog userlog, boolean merge)
		throws SystemException {
		return getPersistence().update(userlog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Userlog update(Userlog userlog, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userlog, merge, serviceContext);
	}

	/**
	* Caches the userlog in the entity cache if it is enabled.
	*
	* @param userlog the userlog
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.Userlog userlog) {
		getPersistence().cacheResult(userlog);
	}

	/**
	* Caches the userlogs in the entity cache if it is enabled.
	*
	* @param userlogs the userlogs
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Userlog> userlogs) {
		getPersistence().cacheResult(userlogs);
	}

	/**
	* Creates a new userlog with the primary key. Does not add the userlog to the database.
	*
	* @param userlogId the primary key for the new userlog
	* @return the new userlog
	*/
	public static com.liferay.consistent.tracking.model.Userlog create(
		long userlogId) {
		return getPersistence().create(userlogId);
	}

	/**
	* Removes the userlog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog that was removed
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog remove(
		long userlogId)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userlogId);
	}

	public static com.liferay.consistent.tracking.model.Userlog updateImpl(
		com.liferay.consistent.tracking.model.Userlog userlog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userlog, merge);
	}

	/**
	* Returns the userlog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchUserlogException} if it could not be found.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByPrimaryKey(
		long userlogId)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userlogId);
	}

	/**
	* Returns the userlog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog, or <code>null</code> if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByPrimaryKey(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userlogId);
	}

	/**
	* Returns all the userlogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the userlogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByCompanyId_PrevAndNext(
		long userlogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(userlogId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the userlogs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the userlogs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where userId = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByUserId_PrevAndNext(
		long userlogId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(userlogId, userId,
			orderByComparator);
	}

	/**
	* Returns all the userlogs where companyId = &#63; and osId = &#63;.
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOSId(
		long companyId, long osId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOSId(companyId, osId);
	}

	/**
	* Returns a range of all the userlogs where companyId = &#63; and osId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOSId(
		long companyId, long osId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOSId(companyId, osId, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where companyId = &#63; and osId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOSId(
		long companyId, long osId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOSId(companyId, osId, start, end, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63; and osId = &#63;.
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByOSId_First(
		long companyId, long osId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOSId_First(companyId, osId, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63; and osId = &#63;.
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByOSId_First(
		long companyId, long osId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOSId_First(companyId, osId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63; and osId = &#63;.
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByOSId_Last(
		long companyId, long osId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOSId_Last(companyId, osId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63; and osId = &#63;.
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByOSId_Last(
		long companyId, long osId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOSId_Last(companyId, osId, orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63; and osId = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param companyId the company ID
	* @param osId the os ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByOSId_PrevAndNext(
		long userlogId, long companyId, long osId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOSId_PrevAndNext(userlogId, companyId, osId,
			orderByComparator);
	}

	/**
	* Returns all the userlogs where companyId = &#63; and osManufacturer = &#63;.
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOS_Manufacturer(
		long companyId, java.lang.String osManufacturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOS_Manufacturer(companyId, osManufacturer);
	}

	/**
	* Returns a range of all the userlogs where companyId = &#63; and osManufacturer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOS_Manufacturer(
		long companyId, java.lang.String osManufacturer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOS_Manufacturer(companyId, osManufacturer, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where companyId = &#63; and osManufacturer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOS_Manufacturer(
		long companyId, java.lang.String osManufacturer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOS_Manufacturer(companyId, osManufacturer, start,
			end, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByOS_Manufacturer_First(
		long companyId, java.lang.String osManufacturer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOS_Manufacturer_First(companyId, osManufacturer,
			orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByOS_Manufacturer_First(
		long companyId, java.lang.String osManufacturer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOS_Manufacturer_First(companyId, osManufacturer,
			orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByOS_Manufacturer_Last(
		long companyId, java.lang.String osManufacturer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOS_Manufacturer_Last(companyId, osManufacturer,
			orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByOS_Manufacturer_Last(
		long companyId, java.lang.String osManufacturer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOS_Manufacturer_Last(companyId, osManufacturer,
			orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByOS_Manufacturer_PrevAndNext(
		long userlogId, long companyId, java.lang.String osManufacturer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOS_Manufacturer_PrevAndNext(userlogId, companyId,
			osManufacturer, orderByComparator);
	}

	/**
	* Returns all the userlogs where companyId = &#63; and browserId = &#63;.
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowserId(
		long companyId, long browserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrowserId(companyId, browserId);
	}

	/**
	* Returns a range of all the userlogs where companyId = &#63; and browserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowserId(
		long companyId, long browserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrowserId(companyId, browserId, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where companyId = &#63; and browserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowserId(
		long companyId, long browserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowserId(companyId, browserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByBrowserId_First(
		long companyId, long browserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowserId_First(companyId, browserId,
			orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByBrowserId_First(
		long companyId, long browserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrowserId_First(companyId, browserId,
			orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByBrowserId_Last(
		long companyId, long browserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowserId_Last(companyId, browserId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByBrowserId_Last(
		long companyId, long browserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrowserId_Last(companyId, browserId,
			orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param companyId the company ID
	* @param browserId the browser ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByBrowserId_PrevAndNext(
		long userlogId, long companyId, long browserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowserId_PrevAndNext(userlogId, companyId,
			browserId, orderByComparator);
	}

	/**
	* Returns all the userlogs where browserId = &#63; and browserVersion = &#63;.
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowser_N_V(
		long browserId, java.lang.String browserVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrowser_N_V(browserId, browserVersion);
	}

	/**
	* Returns a range of all the userlogs where browserId = &#63; and browserVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowser_N_V(
		long browserId, java.lang.String browserVersion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_N_V(browserId, browserVersion, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where browserId = &#63; and browserVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowser_N_V(
		long browserId, java.lang.String browserVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_N_V(browserId, browserVersion, start, end,
			orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByBrowser_N_V_First(
		long browserId, java.lang.String browserVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_N_V_First(browserId, browserVersion,
			orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByBrowser_N_V_First(
		long browserId, java.lang.String browserVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrowser_N_V_First(browserId, browserVersion,
			orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByBrowser_N_V_Last(
		long browserId, java.lang.String browserVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_N_V_Last(browserId, browserVersion,
			orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByBrowser_N_V_Last(
		long browserId, java.lang.String browserVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrowser_N_V_Last(browserId, browserVersion,
			orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByBrowser_N_V_PrevAndNext(
		long userlogId, long browserId, java.lang.String browserVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_N_V_PrevAndNext(userlogId, browserId,
			browserVersion, orderByComparator);
	}

	/**
	* Returns all the userlogs where osId = &#63; and userId = &#63;.
	*
	* @param osId the os ID
	* @param userId the user ID
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOS_U(
		long osId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOS_U(osId, userId);
	}

	/**
	* Returns a range of all the userlogs where osId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param osId the os ID
	* @param userId the user ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOS_U(
		long osId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOS_U(osId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where osId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param osId the os ID
	* @param userId the user ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByOS_U(
		long osId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOS_U(osId, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where osId = &#63; and userId = &#63;.
	*
	* @param osId the os ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByOS_U_First(
		long osId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOS_U_First(osId, userId, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where osId = &#63; and userId = &#63;.
	*
	* @param osId the os ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByOS_U_First(
		long osId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOS_U_First(osId, userId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where osId = &#63; and userId = &#63;.
	*
	* @param osId the os ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByOS_U_Last(
		long osId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOS_U_Last(osId, userId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where osId = &#63; and userId = &#63;.
	*
	* @param osId the os ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByOS_U_Last(
		long osId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOS_U_Last(osId, userId, orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where osId = &#63; and userId = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param osId the os ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByOS_U_PrevAndNext(
		long userlogId, long osId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOS_U_PrevAndNext(userlogId, osId, userId,
			orderByComparator);
	}

	/**
	* Returns all the userlogs where browserId = &#63; and userId = &#63;.
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowser_U(
		long browserId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrowser_U(browserId, userId);
	}

	/**
	* Returns a range of all the userlogs where browserId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowser_U(
		long browserId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrowser_U(browserId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the userlogs where browserId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findByBrowser_U(
		long browserId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_U(browserId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where browserId = &#63; and userId = &#63;.
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByBrowser_U_First(
		long browserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_U_First(browserId, userId, orderByComparator);
	}

	/**
	* Returns the first userlog in the ordered set where browserId = &#63; and userId = &#63;.
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByBrowser_U_First(
		long browserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrowser_U_First(browserId, userId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where browserId = &#63; and userId = &#63;.
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog findByBrowser_U_Last(
		long browserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_U_Last(browserId, userId, orderByComparator);
	}

	/**
	* Returns the last userlog in the ordered set where browserId = &#63; and userId = &#63;.
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog fetchByBrowser_U_Last(
		long browserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrowser_U_Last(browserId, userId, orderByComparator);
	}

	/**
	* Returns the userlogs before and after the current userlog in the ordered set where browserId = &#63; and userId = &#63;.
	*
	* @param userlogId the primary key of the current userlog
	* @param browserId the browser ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Userlog[] findByBrowser_U_PrevAndNext(
		long userlogId, long browserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrowser_U_PrevAndNext(userlogId, browserId, userId,
			orderByComparator);
	}

	/**
	* Returns all the userlogs.
	*
	* @return the userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the userlogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the userlogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Userlog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the userlogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the userlogs where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the userlogs where companyId = &#63; and osId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOSId(long companyId, long osId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOSId(companyId, osId);
	}

	/**
	* Removes all the userlogs where companyId = &#63; and osManufacturer = &#63; from the database.
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOS_Manufacturer(long companyId,
		java.lang.String osManufacturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOS_Manufacturer(companyId, osManufacturer);
	}

	/**
	* Removes all the userlogs where companyId = &#63; and browserId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrowserId(long companyId, long browserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrowserId(companyId, browserId);
	}

	/**
	* Removes all the userlogs where browserId = &#63; and browserVersion = &#63; from the database.
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrowser_N_V(long browserId,
		java.lang.String browserVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrowser_N_V(browserId, browserVersion);
	}

	/**
	* Removes all the userlogs where osId = &#63; and userId = &#63; from the database.
	*
	* @param osId the os ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOS_U(long osId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOS_U(osId, userId);
	}

	/**
	* Removes all the userlogs where browserId = &#63; and userId = &#63; from the database.
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrowser_U(long browserId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrowser_U(browserId, userId);
	}

	/**
	* Removes all the userlogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of userlogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of userlogs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of userlogs where companyId = &#63; and osId = &#63;.
	*
	* @param companyId the company ID
	* @param osId the os ID
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOSId(long companyId, long osId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOSId(companyId, osId);
	}

	/**
	* Returns the number of userlogs where companyId = &#63; and osManufacturer = &#63;.
	*
	* @param companyId the company ID
	* @param osManufacturer the os manufacturer
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOS_Manufacturer(long companyId,
		java.lang.String osManufacturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOS_Manufacturer(companyId, osManufacturer);
	}

	/**
	* Returns the number of userlogs where companyId = &#63; and browserId = &#63;.
	*
	* @param companyId the company ID
	* @param browserId the browser ID
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrowserId(long companyId, long browserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrowserId(companyId, browserId);
	}

	/**
	* Returns the number of userlogs where browserId = &#63; and browserVersion = &#63;.
	*
	* @param browserId the browser ID
	* @param browserVersion the browser version
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrowser_N_V(long browserId,
		java.lang.String browserVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrowser_N_V(browserId, browserVersion);
	}

	/**
	* Returns the number of userlogs where osId = &#63; and userId = &#63;.
	*
	* @param osId the os ID
	* @param userId the user ID
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOS_U(long osId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOS_U(osId, userId);
	}

	/**
	* Returns the number of userlogs where browserId = &#63; and userId = &#63;.
	*
	* @param browserId the browser ID
	* @param userId the user ID
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrowser_U(long browserId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrowser_U(browserId, userId);
	}

	/**
	* Returns the number of userlogs.
	*
	* @return the number of userlogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserlogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserlogPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					UserlogPersistence.class.getName());

			ReferenceRegistry.registerReference(UserlogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UserlogPersistence persistence) {
	}

	private static UserlogPersistence _persistence;
}