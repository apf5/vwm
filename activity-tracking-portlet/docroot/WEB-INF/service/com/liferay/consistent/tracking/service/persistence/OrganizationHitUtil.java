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

import com.liferay.consistent.tracking.model.OrganizationHit;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the organization hit service. This utility wraps {@link OrganizationHitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see OrganizationHitPersistence
 * @see OrganizationHitPersistenceImpl
 * @generated
 */
public class OrganizationHitUtil {
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
	public static void clearCache(OrganizationHit organizationHit) {
		getPersistence().clearCache(organizationHit);
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
	public static List<OrganizationHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationHit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static OrganizationHit update(OrganizationHit organizationHit,
		boolean merge) throws SystemException {
		return getPersistence().update(organizationHit, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static OrganizationHit update(OrganizationHit organizationHit,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(organizationHit, merge, serviceContext);
	}

	/**
	* Caches the organization hit in the entity cache if it is enabled.
	*
	* @param organizationHit the organization hit
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.OrganizationHit organizationHit) {
		getPersistence().cacheResult(organizationHit);
	}

	/**
	* Caches the organization hits in the entity cache if it is enabled.
	*
	* @param organizationHits the organization hits
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> organizationHits) {
		getPersistence().cacheResult(organizationHits);
	}

	/**
	* Creates a new organization hit with the primary key. Does not add the organization hit to the database.
	*
	* @param hitId the primary key for the new organization hit
	* @return the new organization hit
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit create(
		long hitId) {
		return getPersistence().create(hitId);
	}

	/**
	* Removes the organization hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the organization hit
	* @return the organization hit that was removed
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit remove(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(hitId);
	}

	public static com.liferay.consistent.tracking.model.OrganizationHit updateImpl(
		com.liferay.consistent.tracking.model.OrganizationHit organizationHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(organizationHit, merge);
	}

	/**
	* Returns the organization hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchOrganizationHitException} if it could not be found.
	*
	* @param hitId the primary key of the organization hit
	* @return the organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit findByPrimaryKey(
		long hitId)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(hitId);
	}

	/**
	* Returns the organization hit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hitId the primary key of the organization hit
	* @return the organization hit, or <code>null</code> if a organization hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit fetchByPrimaryKey(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(hitId);
	}

	/**
	* Returns all the organization hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the organization hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @return the range of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the organization hits where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first organization hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first organization hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization hit, or <code>null</code> if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last organization hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last organization hit in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization hit, or <code>null</code> if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the organization hits before and after the current organization hit in the ordered set where companyId = &#63;.
	*
	* @param hitId the primary key of the current organization hit
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit[] findByCompanyId_PrevAndNext(
		long hitId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(hitId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the organization hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByC_G(
		long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest);
	}

	/**
	* Returns a range of all the organization hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @return the range of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByC_G(
		long companyId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, guest, start, end);
	}

	/**
	* Returns an ordered range of all the organization hits where companyId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByC_G(
		long companyId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, guest, start, end, orderByComparator);
	}

	/**
	* Returns the first organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit findByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the first organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization hit, or <code>null</code> if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit fetchByC_G_First(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit findByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the last organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization hit, or <code>null</code> if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit fetchByC_G_Last(
		long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, guest, orderByComparator);
	}

	/**
	* Returns the organization hits before and after the current organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current organization hit
	* @param companyId the company ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit[] findByC_G_PrevAndNext(
		long hitId, long companyId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(hitId, companyId, guest,
			orderByComparator);
	}

	/**
	* Returns all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @return the matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByC_O_G(
		long companyId, long organizationId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_O_G(companyId, organizationId, guest);
	}

	/**
	* Returns a range of all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @return the range of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByC_O_G(
		long companyId, long organizationId, boolean guest, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_O_G(companyId, organizationId, guest, start, end);
	}

	/**
	* Returns an ordered range of all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findByC_O_G(
		long companyId, long organizationId, boolean guest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_O_G(companyId, organizationId, guest, start, end,
			orderByComparator);
	}

	/**
	* Returns the first organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit findByC_O_G_First(
		long companyId, long organizationId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_O_G_First(companyId, organizationId, guest,
			orderByComparator);
	}

	/**
	* Returns the first organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization hit, or <code>null</code> if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit fetchByC_O_G_First(
		long companyId, long organizationId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_O_G_First(companyId, organizationId, guest,
			orderByComparator);
	}

	/**
	* Returns the last organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit findByC_O_G_Last(
		long companyId, long organizationId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_O_G_Last(companyId, organizationId, guest,
			orderByComparator);
	}

	/**
	* Returns the last organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization hit, or <code>null</code> if a matching organization hit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit fetchByC_O_G_Last(
		long companyId, long organizationId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_O_G_Last(companyId, organizationId, guest,
			orderByComparator);
	}

	/**
	* Returns the organization hits before and after the current organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* @param hitId the primary key of the current organization hit
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organization hit
	* @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.OrganizationHit[] findByC_O_G_PrevAndNext(
		long hitId, long companyId, long organizationId, boolean guest,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchOrganizationHitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_O_G_PrevAndNext(hitId, companyId, organizationId,
			guest, orderByComparator);
	}

	/**
	* Returns all the organization hits.
	*
	* @return the organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the organization hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @return the range of organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the organization hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of organization hits
	* @param end the upper bound of the range of organization hits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.OrganizationHit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the organization hits where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the organization hits where companyId = &#63; and guest = &#63; from the database.
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
	* Removes all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63; from the database.
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_O_G(long companyId, long organizationId,
		boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_O_G(companyId, organizationId, guest);
	}

	/**
	* Removes all the organization hits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of organization hits where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of organization hits where companyId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param guest the guest
	* @return the number of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, guest);
	}

	/**
	* Returns the number of organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	*
	* @param companyId the company ID
	* @param organizationId the organization ID
	* @param guest the guest
	* @return the number of matching organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_O_G(long companyId, long organizationId,
		boolean guest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_O_G(companyId, organizationId, guest);
	}

	/**
	* Returns the number of organization hits.
	*
	* @return the number of organization hits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrganizationHitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrganizationHitPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					OrganizationHitPersistence.class.getName());

			ReferenceRegistry.registerReference(OrganizationHitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OrganizationHitPersistence persistence) {
	}

	private static OrganizationHitPersistence _persistence;
}