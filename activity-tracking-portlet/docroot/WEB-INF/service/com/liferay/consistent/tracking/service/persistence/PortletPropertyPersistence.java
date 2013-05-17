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

import com.liferay.consistent.tracking.model.PortletProperty;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the portlet property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PortletPropertyPersistenceImpl
 * @see PortletPropertyUtil
 * @generated
 */
public interface PortletPropertyPersistence extends BasePersistence<PortletProperty> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortletPropertyUtil} to access the portlet property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the portlet property in the entity cache if it is enabled.
	*
	* @param portletProperty the portlet property
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty);

	/**
	* Caches the portlet properties in the entity cache if it is enabled.
	*
	* @param portletProperties the portlet properties
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.PortletProperty> portletProperties);

	/**
	* Creates a new portlet property with the primary key. Does not add the portlet property to the database.
	*
	* @param propertyId the primary key for the new portlet property
	* @return the new portlet property
	*/
	public com.liferay.consistent.tracking.model.PortletProperty create(
		long propertyId);

	/**
	* Removes the portlet property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the portlet property
	* @return the portlet property that was removed
	* @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a portlet property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty remove(
		long propertyId)
		throws com.liferay.consistent.tracking.NoSuchPortletPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.PortletProperty updateImpl(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet property with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchPortletPropertyException} if it could not be found.
	*
	* @param propertyId the primary key of the portlet property
	* @return the portlet property
	* @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a portlet property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty findByPrimaryKey(
		long propertyId)
		throws com.liferay.consistent.tracking.NoSuchPortletPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertyId the primary key of the portlet property
	* @return the portlet property, or <code>null</code> if a portlet property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty fetchByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet property where companyId = &#63; and name = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchPortletPropertyException} if it could not be found.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching portlet property
	* @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a matching portlet property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty findByName(
		long companyId, java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchPortletPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet property where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching portlet property, or <code>null</code> if a matching portlet property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty fetchByName(
		long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet property where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching portlet property, or <code>null</code> if a matching portlet property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty fetchByName(
		long companyId, java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portlet properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletProperty> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portlet properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of portlet properties
	* @param end the upper bound of the range of portlet properties (not inclusive)
	* @return the range of matching portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletProperty> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portlet properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of portlet properties
	* @param end the upper bound of the range of portlet properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletProperty> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portlet property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet property
	* @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a matching portlet property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portlet property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet property, or <code>null</code> if a matching portlet property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portlet property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet property
	* @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a matching portlet property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portlet property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet property, or <code>null</code> if a matching portlet property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet properties before and after the current portlet property in the ordered set where companyId = &#63;.
	*
	* @param propertyId the primary key of the current portlet property
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet property
	* @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a portlet property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty[] findByCompanyId_PrevAndNext(
		long propertyId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchPortletPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portlet properties.
	*
	* @return the portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portlet properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet properties
	* @param end the upper bound of the range of portlet properties (not inclusive)
	* @return the range of portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletProperty> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portlet properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet properties
	* @param end the upper bound of the range of portlet properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletProperty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the portlet property where companyId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the portlet property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty removeByName(
		long companyId, java.lang.String name)
		throws com.liferay.consistent.tracking.NoSuchPortletPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portlet properties where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portlet properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet properties where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet properties.
	*
	* @return the number of portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}