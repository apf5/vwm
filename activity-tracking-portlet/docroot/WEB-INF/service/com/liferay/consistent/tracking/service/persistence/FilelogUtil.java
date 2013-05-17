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

import com.liferay.consistent.tracking.model.Filelog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the filelog service. This utility wraps {@link FilelogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see FilelogPersistence
 * @see FilelogPersistenceImpl
 * @generated
 */
public class FilelogUtil {
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
	public static void clearCache(Filelog filelog) {
		getPersistence().clearCache(filelog);
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
	public static List<Filelog> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Filelog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Filelog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Filelog update(Filelog filelog, boolean merge)
		throws SystemException {
		return getPersistence().update(filelog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Filelog update(Filelog filelog, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(filelog, merge, serviceContext);
	}

	/**
	* Caches the filelog in the entity cache if it is enabled.
	*
	* @param filelog the filelog
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.Filelog filelog) {
		getPersistence().cacheResult(filelog);
	}

	/**
	* Caches the filelogs in the entity cache if it is enabled.
	*
	* @param filelogs the filelogs
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Filelog> filelogs) {
		getPersistence().cacheResult(filelogs);
	}

	/**
	* Creates a new filelog with the primary key. Does not add the filelog to the database.
	*
	* @param FilelogId the primary key for the new filelog
	* @return the new filelog
	*/
	public static com.liferay.consistent.tracking.model.Filelog create(
		long FilelogId) {
		return getPersistence().create(FilelogId);
	}

	/**
	* Removes the filelog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog that was removed
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog remove(
		long FilelogId)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(FilelogId);
	}

	public static com.liferay.consistent.tracking.model.Filelog updateImpl(
		com.liferay.consistent.tracking.model.Filelog filelog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(filelog, merge);
	}

	/**
	* Returns the filelog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchFilelogException} if it could not be found.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog findByPrimaryKey(
		long FilelogId)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(FilelogId);
	}

	/**
	* Returns the filelog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog, or <code>null</code> if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog fetchByPrimaryKey(
		long FilelogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(FilelogId);
	}

	/**
	* Returns all the filelogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the filelogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @return the range of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the filelogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the filelogs before and after the current filelog in the ordered set where companyId = &#63;.
	*
	* @param FilelogId the primary key of the current filelog
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog[] findByCompanyId_PrevAndNext(
		long FilelogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(FilelogId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the filelogs where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest);
	}

	/**
	* Returns a range of all the filelogs where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @return the range of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest, start, end);
	}

	/**
	* Returns an ordered range of all the filelogs where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, guest, start, end, orderByComparator);
	}

	/**
	* Returns the first filelog in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the first filelog in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last filelog in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last filelog in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the filelogs before and after the current filelog in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param FilelogId the primary key of the current filelog
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog[] findByC_G_PrevAndNext(
		long FilelogId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(FilelogId, companyId, guest,
			orderByComparator);
	}

	/**
	* Returns all the filelogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByUserlogId(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserlogId(userlogId);
	}

	/**
	* Returns a range of all the filelogs where userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @return the range of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByUserlogId(
		long userlogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserlogId(userlogId, start, end);
	}

	/**
	* Returns an ordered range of all the filelogs where userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findByUserlogId(
		long userlogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId(userlogId, start, end, orderByComparator);
	}

	/**
	* Returns the first filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog findByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_First(userlogId, orderByComparator);
	}

	/**
	* Returns the first filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog fetchByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserlogId_First(userlogId, orderByComparator);
	}

	/**
	* Returns the last filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog findByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_Last(userlogId, orderByComparator);
	}

	/**
	* Returns the last filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog fetchByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserlogId_Last(userlogId, orderByComparator);
	}

	/**
	* Returns the filelogs before and after the current filelog in the ordered set where userlogId = &#63;.
	*
	* @param FilelogId the primary key of the current filelog
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.Filelog[] findByUserlogId_PrevAndNext(
		long FilelogId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_PrevAndNext(FilelogId, userlogId,
			orderByComparator);
	}

	/**
	* Returns all the filelogs.
	*
	* @return the filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the filelogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @return the range of filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the filelogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.Filelog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the filelogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the filelogs where companyId = &#63; and guest = &#63; from the database.
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
	* Removes all the filelogs where userlogId = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserlogId(userlogId);
	}

	/**
	* Removes all the filelogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of filelogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of filelogs where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, guest);
	}

	/**
	* Returns the number of filelogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the number of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserlogId(userlogId);
	}

	/**
	* Returns the number of filelogs.
	*
	* @return the number of filelogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FilelogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FilelogPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					FilelogPersistence.class.getName());

			ReferenceRegistry.registerReference(FilelogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(FilelogPersistence persistence) {
	}

	private static FilelogPersistence _persistence;
}