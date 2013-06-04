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

import com.liferay.consistent.tracking.model.Browser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the browser service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see BrowserPersistenceImpl
 * @see BrowserUtil
 * @generated
 */
public interface BrowserPersistence extends BasePersistence<Browser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrowserUtil} to access the browser persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the browser in the entity cache if it is enabled.
	*
	* @param browser the browser
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.Browser browser);

	/**
	* Caches the browsers in the entity cache if it is enabled.
	*
	* @param browsers the browsers
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.Browser> browsers);

	/**
	* Creates a new browser with the primary key. Does not add the browser to the database.
	*
	* @param browserId the primary key for the new browser
	* @return the new browser
	*/
	public com.liferay.consistent.tracking.model.Browser create(long browserId);

	/**
	* Removes the browser with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param browserId the primary key of the browser
	* @return the browser that was removed
	* @throws com.liferay.consistent.tracking.NoSuchBrowserException if a browser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browser remove(long browserId)
		throws com.liferay.consistent.tracking.NoSuchBrowserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.Browser updateImpl(
		com.liferay.consistent.tracking.model.Browser browser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the browser with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchBrowserException} if it could not be found.
	*
	* @param browserId the primary key of the browser
	* @return the browser
	* @throws com.liferay.consistent.tracking.NoSuchBrowserException if a browser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browser findByPrimaryKey(
		long browserId)
		throws com.liferay.consistent.tracking.NoSuchBrowserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the browser with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param browserId the primary key of the browser
	* @return the browser, or <code>null</code> if a browser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browser fetchByPrimaryKey(
		long browserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the browser where name = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchBrowserException} if it could not be found.
	*
	* @param name the name
	* @return the matching browser
	* @throws com.liferay.consistent.tracking.NoSuchBrowserException if a matching browser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browser findByName(
		java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchBrowserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the browser where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching browser, or <code>null</code> if a matching browser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browser fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the browser where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching browser, or <code>null</code> if a matching browser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browser fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the browsers.
	*
	* @return the browsers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Browser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the browsers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of browsers
	* @param end the upper bound of the range of browsers (not inclusive)
	* @return the range of browsers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Browser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the browsers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of browsers
	* @param end the upper bound of the range of browsers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of browsers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Browser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the browser where name = &#63; from the database.
	*
	* @param name the name
	* @return the browser that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Browser removeByName(
		java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchBrowserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the browsers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of browsers where name = &#63;.
	*
	* @param name the name
	* @return the number of matching browsers
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of browsers.
	*
	* @return the number of browsers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}