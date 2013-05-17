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

import com.liferay.consistent.tracking.model.Browsinglog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the browsinglog service. This utility wraps {@link BrowsinglogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see BrowsinglogPersistence
 * @see BrowsinglogPersistenceImpl
 * @generated
 */
public class BrowsinglogUtil {
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
	public static void clearCache(Browsinglog browsinglog) {
		getPersistence().clearCache(browsinglog);
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
	public static List<Browsinglog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Browsinglog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Browsinglog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Browsinglog update(Browsinglog browsinglog, boolean merge)
		throws SystemException {
		return getPersistence().update(browsinglog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Browsinglog update(Browsinglog browsinglog, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(browsinglog, merge, serviceContext);
	}

	/**
	* Caches the browsinglog in the entity cache if it is enabled.
	*
	* @param browsinglog the browsinglog
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.Browsinglog browsinglog) {
		getPersistence().cacheResult(browsinglog);
	}

	/**
	* Caches the browsinglogs in the entity cache if it is enabled.
	*
	* @param browsinglogs the browsinglogs
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Browsinglog> browsinglogs) {
		getPersistence().cacheResult(browsinglogs);
	}

	/**
	* Creates a new browsinglog with the primary key. Does not add the browsinglog to the database.
	*
	* @param browsinglogId the primary key for the new browsinglog
	* @return the new browsinglog
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog create(
		long browsinglogId) {
		return getPersistence().create(browsinglogId);
	}

	/**
	* Removes the browsinglog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param browsinglogId the primary key of the browsinglog
	* @return the browsinglog that was removed
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog remove(
		long browsinglogId)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(browsinglogId);
	}

	public static com.liferay.consistent.tracking.model.Browsinglog updateImpl(
		com.liferay.consistent.tracking.model.Browsinglog browsinglog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(browsinglog, merge);
	}

	/**
	* Returns the browsinglog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchBrowsinglogException} if it could not be found.
	*
	* @param browsinglogId the primary key of the browsinglog
	* @return the browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog findByPrimaryKey(
		long browsinglogId)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(browsinglogId);
	}

	/**
	* Returns the browsinglog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param browsinglogId the primary key of the browsinglog
	* @return the browsinglog, or <code>null</code> if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog fetchByPrimaryKey(
		long browsinglogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(browsinglogId);
	}

	/**
	* Returns all the browsinglogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the browsinglogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of browsinglogs
	* @param end the upper bound of the range of browsinglogs (not inclusive)
	* @return the range of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the browsinglogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of browsinglogs
	* @param end the upper bound of the range of browsinglogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the browsinglogs before and after the current browsinglog in the ordered set where companyId = &#63;.
	*
	* @param browsinglogId the primary key of the current browsinglog
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog[] findByCompanyId_PrevAndNext(
		long browsinglogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(browsinglogId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the browsinglogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByUserlogId(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserlogId(userlogId);
	}

	/**
	* Returns a range of all the browsinglogs where userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of browsinglogs
	* @param end the upper bound of the range of browsinglogs (not inclusive)
	* @return the range of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByUserlogId(
		long userlogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserlogId(userlogId, start, end);
	}

	/**
	* Returns an ordered range of all the browsinglogs where userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of browsinglogs
	* @param end the upper bound of the range of browsinglogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByUserlogId(
		long userlogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId(userlogId, start, end, orderByComparator);
	}

	/**
	* Returns the first browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog findByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_First(userlogId, orderByComparator);
	}

	/**
	* Returns the first browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog fetchByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserlogId_First(userlogId, orderByComparator);
	}

	/**
	* Returns the last browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog findByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_Last(userlogId, orderByComparator);
	}

	/**
	* Returns the last browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog fetchByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserlogId_Last(userlogId, orderByComparator);
	}

	/**
	* Returns the browsinglogs before and after the current browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param browsinglogId the primary key of the current browsinglog
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Browsinglog[] findByUserlogId_PrevAndNext(
		long browsinglogId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_PrevAndNext(browsinglogId, userlogId,
			orderByComparator);
	}

	/**
	* Returns all the browsinglogs.
	*
	* @return the browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the browsinglogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of browsinglogs
	* @param end the upper bound of the range of browsinglogs (not inclusive)
	* @return the range of browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the browsinglogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of browsinglogs
	* @param end the upper bound of the range of browsinglogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the browsinglogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the browsinglogs where userlogId = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserlogId(userlogId);
	}

	/**
	* Removes all the browsinglogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of browsinglogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of browsinglogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the number of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserlogId(userlogId);
	}

	/**
	* Returns the number of browsinglogs.
	*
	* @return the number of browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BrowsinglogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BrowsinglogPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					BrowsinglogPersistence.class.getName());

			ReferenceRegistry.registerReference(BrowsinglogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BrowsinglogPersistence persistence) {
	}

	private static BrowsinglogPersistence _persistence;
}