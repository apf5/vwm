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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the userlog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see UserlogPersistenceImpl
 * @see UserlogUtil
 * @generated
 */
public interface UserlogPersistence extends BasePersistence<Userlog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserlogUtil} to access the userlog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the userlog in the entity cache if it is enabled.
	*
	* @param userlog the userlog
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.Userlog userlog);

	/**
	* Caches the userlogs in the entity cache if it is enabled.
	*
	* @param userlogs the userlogs
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Userlog> userlogs);

	/**
	* Creates a new userlog with the primary key. Does not add the userlog to the database.
	*
	* @param userlogId the primary key for the new userlog
	* @return the new userlog
	*/
	public com.liferay.consistent.tracking.model.Userlog create(long userlogId);

	/**
	* Removes the userlog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog that was removed
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog remove(long userlogId)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.Userlog updateImpl(
		com.liferay.consistent.tracking.model.Userlog userlog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the userlog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchUserlogException} if it could not be found.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog findByPrimaryKey(
		long userlogId)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the userlog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog, or <code>null</code> if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog fetchByPrimaryKey(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the userlogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Userlog> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Userlog> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Userlog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog
	* @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last userlog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Userlog[] findByCompanyId_PrevAndNext(
		long userlogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchUserlogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the userlogs.
	*
	* @return the userlogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Userlog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Userlog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Userlog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the userlogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the userlogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userlogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching userlogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userlogs.
	*
	* @return the number of userlogs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}