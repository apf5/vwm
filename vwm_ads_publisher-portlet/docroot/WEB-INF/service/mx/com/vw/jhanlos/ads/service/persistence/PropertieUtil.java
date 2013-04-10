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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import mx.com.vw.jhanlos.ads.model.Propertie;

import java.util.List;

/**
 * The persistence utility for the propertie service. This utility wraps {@link PropertiePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see PropertiePersistence
 * @see PropertiePersistenceImpl
 * @generated
 */
public class PropertieUtil {
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
	public static void clearCache(Propertie propertie) {
		getPersistence().clearCache(propertie);
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
	public static List<Propertie> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Propertie> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Propertie> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Propertie update(Propertie propertie, boolean merge)
		throws SystemException {
		return getPersistence().update(propertie, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Propertie update(Propertie propertie, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(propertie, merge, serviceContext);
	}

	/**
	* Caches the propertie in the entity cache if it is enabled.
	*
	* @param propertie the propertie
	*/
	public static void cacheResult(
		mx.com.vw.jhanlos.ads.model.Propertie propertie) {
		getPersistence().cacheResult(propertie);
	}

	/**
	* Caches the properties in the entity cache if it is enabled.
	*
	* @param properties the properties
	*/
	public static void cacheResult(
		java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> properties) {
		getPersistence().cacheResult(properties);
	}

	/**
	* Creates a new propertie with the primary key. Does not add the propertie to the database.
	*
	* @param propertieId the primary key for the new propertie
	* @return the new propertie
	*/
	public static mx.com.vw.jhanlos.ads.model.Propertie create(long propertieId) {
		return getPersistence().create(propertieId);
	}

	/**
	* Removes the propertie with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertieId the primary key of the propertie
	* @return the propertie that was removed
	* @throws mx.com.vw.jhanlos.ads.NoSuchPropertieException if a propertie with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Propertie remove(long propertieId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchPropertieException {
		return getPersistence().remove(propertieId);
	}

	public static mx.com.vw.jhanlos.ads.model.Propertie updateImpl(
		mx.com.vw.jhanlos.ads.model.Propertie propertie, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(propertie, merge);
	}

	/**
	* Returns the propertie with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchPropertieException} if it could not be found.
	*
	* @param propertieId the primary key of the propertie
	* @return the propertie
	* @throws mx.com.vw.jhanlos.ads.NoSuchPropertieException if a propertie with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Propertie findByPrimaryKey(
		long propertieId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchPropertieException {
		return getPersistence().findByPrimaryKey(propertieId);
	}

	/**
	* Returns the propertie with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertieId the primary key of the propertie
	* @return the propertie, or <code>null</code> if a propertie with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Propertie fetchByPrimaryKey(
		long propertieId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(propertieId);
	}

	/**
	* Returns all the properties.
	*
	* @return the properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<mx.com.vw.jhanlos.ads.model.Propertie> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of properties.
	*
	* @return the number of properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PropertiePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PropertiePersistence)PortletBeanLocatorUtil.locate(mx.com.vw.jhanlos.ads.service.ClpSerializer.getServletContextName(),
					PropertiePersistence.class.getName());

			ReferenceRegistry.registerReference(PropertieUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PropertiePersistence persistence) {
	}

	private static PropertiePersistence _persistence;
}