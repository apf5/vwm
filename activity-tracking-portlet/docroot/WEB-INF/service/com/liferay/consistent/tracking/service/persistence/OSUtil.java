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

import com.liferay.consistent.tracking.model.OS;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the o s service. This utility wraps {@link OSPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see OSPersistence
 * @see OSPersistenceImpl
 * @generated
 */
public class OSUtil {
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
	public static void clearCache(OS os) {
		getPersistence().clearCache(os);
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
	public static List<OS> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OS> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OS> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static OS update(OS os, boolean merge) throws SystemException {
		return getPersistence().update(os, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static OS update(OS os, boolean merge, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(os, merge, serviceContext);
	}

	/**
	* Caches the o s in the entity cache if it is enabled.
	*
	* @param os the o s
	*/
	public static void cacheResult(com.liferay.consistent.tracking.model.OS os) {
		getPersistence().cacheResult(os);
	}

	/**
	* Caches the o ses in the entity cache if it is enabled.
	*
	* @param oses the o ses
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.OS> oses) {
		getPersistence().cacheResult(oses);
	}

	/**
	* Creates a new o s with the primary key. Does not add the o s to the database.
	*
	* @param osId the primary key for the new o s
	* @return the new o s
	*/
	public static com.liferay.consistent.tracking.model.OS create(long osId) {
		return getPersistence().create(osId);
	}

	/**
	* Removes the o s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param osId the primary key of the o s
	* @return the o s that was removed
	* @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OS remove(long osId)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(osId);
	}

	public static com.liferay.consistent.tracking.model.OS updateImpl(
		com.liferay.consistent.tracking.model.OS os, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(os, merge);
	}

	/**
	* Returns the o s with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchOSException} if it could not be found.
	*
	* @param osId the primary key of the o s
	* @return the o s
	* @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OS findByPrimaryKey(
		long osId)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(osId);
	}

	/**
	* Returns the o s with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param osId the primary key of the o s
	* @return the o s, or <code>null</code> if a o s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OS fetchByPrimaryKey(
		long osId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(osId);
	}

	/**
	* Returns the o s where name = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchOSException} if it could not be found.
	*
	* @param name the name
	* @return the matching o s
	* @throws com.liferay.consistent.tracking.NoSuchOSException if a matching o s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OS findByName(
		java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the o s where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching o s, or <code>null</code> if a matching o s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OS fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the o s where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching o s, or <code>null</code> if a matching o s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OS fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Returns all the o ses.
	*
	* @return the o ses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OS> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the o ses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o ses
	* @param end the upper bound of the range of o ses (not inclusive)
	* @return the range of o ses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OS> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the o ses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o ses
	* @param end the upper bound of the range of o ses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of o ses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the o s where name = &#63; from the database.
	*
	* @param name the name
	* @return the o s that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OS removeByName(
		java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByName(name);
	}

	/**
	* Removes all the o ses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of o ses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching o ses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the number of o ses.
	*
	* @return the number of o ses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OSPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OSPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					OSPersistence.class.getName());

			ReferenceRegistry.registerReference(OSUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OSPersistence persistence) {
	}

	private static OSPersistence _persistence;
}