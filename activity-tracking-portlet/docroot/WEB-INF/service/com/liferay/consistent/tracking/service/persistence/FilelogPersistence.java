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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the filelog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see FilelogPersistenceImpl
 * @see FilelogUtil
 * @generated
 */
public interface FilelogPersistence extends BasePersistence<Filelog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FilelogUtil} to access the filelog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the filelog in the entity cache if it is enabled.
	*
	* @param filelog the filelog
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.Filelog filelog);

	/**
	* Caches the filelogs in the entity cache if it is enabled.
	*
	* @param filelogs the filelogs
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Filelog> filelogs);

	/**
	* Creates a new filelog with the primary key. Does not add the filelog to the database.
	*
	* @param FilelogId the primary key for the new filelog
	* @return the new filelog
	*/
	public com.liferay.consistent.tracking.model.Filelog create(long FilelogId);

	/**
	* Removes the filelog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog that was removed
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog remove(long FilelogId)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.Filelog updateImpl(
		com.liferay.consistent.tracking.model.Filelog filelog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the filelog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchFilelogException} if it could not be found.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog findByPrimaryKey(
		long FilelogId)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the filelog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog, or <code>null</code> if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog fetchByPrimaryKey(
		long FilelogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the filelogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last filelog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Filelog[] findByCompanyId_PrevAndNext(
		long FilelogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the filelogs where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Filelog findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first filelog in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Filelog findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last filelog in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Filelog[] findByC_G_PrevAndNext(
		long FilelogId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the filelogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByUserlogId(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByUserlogId(
		long userlogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findByUserlogId(
		long userlogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog findByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog fetchByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog
	* @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog findByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last filelog in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog fetchByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.Filelog[] findByUserlogId_PrevAndNext(
		long FilelogId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchFilelogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the filelogs.
	*
	* @return the filelogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the filelogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the filelogs where companyId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the filelogs where userlogId = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the filelogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of filelogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of filelogs where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of filelogs where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the number of matching filelogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of filelogs.
	*
	* @return the number of filelogs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}