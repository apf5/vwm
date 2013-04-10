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

package mx.com.vw.jhanlos.ads.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import mx.com.vw.jhanlos.ads.model.Propertie;

/**
 * The persistence interface for the propertie service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see PropertiePersistenceImpl
 * @see PropertieUtil
 * @generated
 */
public interface PropertiePersistence extends BasePersistence<Propertie> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PropertieUtil} to access the propertie persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the propertie in the entity cache if it is enabled.
	*
	* @param propertie the propertie
	*/
	public void cacheResult(mx.com.vw.jhanlos.ads.model.Propertie propertie);

	/**
	* Caches the properties in the entity cache if it is enabled.
	*
	* @param properties the properties
	*/
	public void cacheResult(
		java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> properties);

	/**
	* Creates a new propertie with the primary key. Does not add the propertie to the database.
	*
	* @param propertieId the primary key for the new propertie
	* @return the new propertie
	*/
	public mx.com.vw.jhanlos.ads.model.Propertie create(long propertieId);

	/**
	* Removes the propertie with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertieId the primary key of the propertie
	* @return the propertie that was removed
	* @throws mx.com.vw.jhanlos.ads.NoSuchPropertieException if a propertie with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.Propertie remove(long propertieId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchPropertieException;

	public mx.com.vw.jhanlos.ads.model.Propertie updateImpl(
		mx.com.vw.jhanlos.ads.model.Propertie propertie, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the propertie with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchPropertieException} if it could not be found.
	*
	* @param propertieId the primary key of the propertie
	* @return the propertie
	* @throws mx.com.vw.jhanlos.ads.NoSuchPropertieException if a propertie with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.Propertie findByPrimaryKey(
		long propertieId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchPropertieException;

	/**
	* Returns the propertie with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertieId the primary key of the propertie
	* @return the propertie, or <code>null</code> if a propertie with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.Propertie fetchByPrimaryKey(
		long propertieId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the properties.
	*
	* @return the properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of properties
	* @param end the upper bound of the range of properties (not inclusive)
	* @return the range of properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of properties
	* @param end the upper bound of the range of properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of properties.
	*
	* @return the number of properties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}