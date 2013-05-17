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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the browsinglog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see BrowsinglogPersistenceImpl
 * @see BrowsinglogUtil
 * @generated
 */
public interface BrowsinglogPersistence extends BasePersistence<Browsinglog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrowsinglogUtil} to access the browsinglog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the browsinglog in the entity cache if it is enabled.
	*
	* @param browsinglog the browsinglog
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.Browsinglog browsinglog);

	/**
	* Caches the browsinglogs in the entity cache if it is enabled.
	*
	* @param browsinglogs the browsinglogs
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Browsinglog> browsinglogs);

	/**
	* Creates a new browsinglog with the primary key. Does not add the browsinglog to the database.
	*
	* @param browsinglogId the primary key for the new browsinglog
	* @return the new browsinglog
	*/
	public com.liferay.consistent.tracking.model.Browsinglog create(
		long browsinglogId);

	/**
	* Removes the browsinglog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param browsinglogId the primary key of the browsinglog
	* @return the browsinglog that was removed
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog remove(
		long browsinglogId)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.Browsinglog updateImpl(
		com.liferay.consistent.tracking.model.Browsinglog browsinglog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the browsinglog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchBrowsinglogException} if it could not be found.
	*
	* @param browsinglogId the primary key of the browsinglog
	* @return the browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog findByPrimaryKey(
		long browsinglogId)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the browsinglog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param browsinglogId the primary key of the browsinglog
	* @return the browsinglog, or <code>null</code> if a browsinglog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog fetchByPrimaryKey(
		long browsinglogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the browsinglogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last browsinglog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Browsinglog[] findByCompanyId_PrevAndNext(
		long browsinglogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the browsinglogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByUserlogId(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByUserlogId(
		long userlogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findByUserlogId(
		long userlogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog findByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog fetchByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog
	* @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog findByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last browsinglog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browsinglog fetchByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Browsinglog[] findByUserlogId_PrevAndNext(
		long browsinglogId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchBrowsinglogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the browsinglogs.
	*
	* @return the browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Browsinglog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the browsinglogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the browsinglogs where userlogId = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the browsinglogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of browsinglogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of browsinglogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the number of matching browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of browsinglogs.
	*
	* @return the number of browsinglogs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}