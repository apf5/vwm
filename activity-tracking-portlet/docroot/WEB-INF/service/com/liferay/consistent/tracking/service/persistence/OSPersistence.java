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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the o s service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see OSPersistenceImpl
 * @see OSUtil
 * @generated
 */
public interface OSPersistence extends BasePersistence<OS> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OSUtil} to access the o s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the o s in the entity cache if it is enabled.
	*
	* @param os the o s
	*/
	public void cacheResult(com.liferay.consistent.tracking.model.OS os);

	/**
	* Caches the o ses in the entity cache if it is enabled.
	*
	* @param oses the o ses
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.OS> oses);

	/**
	* Creates a new o s with the primary key. Does not add the o s to the database.
	*
	* @param osId the primary key for the new o s
	* @return the new o s
	*/
	public com.liferay.consistent.tracking.model.OS create(long osId);

	/**
	* Removes the o s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param osId the primary key of the o s
	* @return the o s that was removed
	* @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.OS remove(long osId)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.OS updateImpl(
		com.liferay.consistent.tracking.model.OS os, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the o s with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchOSException} if it could not be found.
	*
	* @param osId the primary key of the o s
	* @return the o s
	* @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.OS findByPrimaryKey(long osId)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the o s with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param osId the primary key of the o s
	* @return the o s, or <code>null</code> if a o s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.OS fetchByPrimaryKey(long osId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the o s where name = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchOSException} if it could not be found.
	*
	* @param name the name
	* @return the matching o s
	* @throws com.liferay.consistent.tracking.NoSuchOSException if a matching o s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.OS findByName(
		java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the o s where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching o s, or <code>null</code> if a matching o s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.OS fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the o s where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching o s, or <code>null</code> if a matching o s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.OS fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the o ses.
	*
	* @return the o ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.OS> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.OS> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.OS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the o s where name = &#63; from the database.
	*
	* @param name the name
	* @return the o s that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.OS removeByName(
		java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchOSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the o ses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o ses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching o ses
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o ses.
	*
	* @return the number of o ses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}