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

package com.liferay.consistent.tracking.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SiteHitLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       SiteHitLocalService
 * @generated
 */
public class SiteHitLocalServiceWrapper implements SiteHitLocalService,
	ServiceWrapper<SiteHitLocalService> {
	public SiteHitLocalServiceWrapper(SiteHitLocalService siteHitLocalService) {
		_siteHitLocalService = siteHitLocalService;
	}

	/**
	* Adds the site hit to the database. Also notifies the appropriate model listeners.
	*
	* @param siteHit the site hit
	* @return the site hit that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit addSiteHit(
		com.liferay.consistent.tracking.model.SiteHit siteHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.addSiteHit(siteHit);
	}

	/**
	* Creates a new site hit with the primary key. Does not add the site hit to the database.
	*
	* @param hitId the primary key for the new site hit
	* @return the new site hit
	*/
	public com.liferay.consistent.tracking.model.SiteHit createSiteHit(
		long hitId) {
		return _siteHitLocalService.createSiteHit(hitId);
	}

	/**
	* Deletes the site hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit that was removed
	* @throws PortalException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit deleteSiteHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.deleteSiteHit(hitId);
	}

	/**
	* Deletes the site hit from the database. Also notifies the appropriate model listeners.
	*
	* @param siteHit the site hit
	* @return the site hit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit deleteSiteHit(
		com.liferay.consistent.tracking.model.SiteHit siteHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.deleteSiteHit(siteHit);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _siteHitLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.SiteHit fetchSiteHit(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.fetchSiteHit(hitId);
	}

	/**
	* Returns the site hit with the primary key.
	*
	* @param hitId the primary key of the site hit
	* @return the site hit
	* @throws PortalException if a site hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit getSiteHit(long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.getSiteHit(hitId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the site hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of site hits
	* @param end the upper bound of the range of site hits (not inclusive)
	* @return the range of site hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SiteHit> getSiteHits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.getSiteHits(start, end);
	}

	/**
	* Returns the number of site hits.
	*
	* @return the number of site hits
	* @throws SystemException if a system exception occurred
	*/
	public int getSiteHitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.getSiteHitsCount();
	}

	/**
	* Updates the site hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param siteHit the site hit
	* @return the site hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit updateSiteHit(
		com.liferay.consistent.tracking.model.SiteHit siteHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.updateSiteHit(siteHit);
	}

	/**
	* Updates the site hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param siteHit the site hit
	* @param merge whether to merge the site hit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the site hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SiteHit updateSiteHit(
		com.liferay.consistent.tracking.model.SiteHit siteHit, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.updateSiteHit(siteHit, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _siteHitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_siteHitLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _siteHitLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.liferay.consistent.tracking.model.SiteHit addSiteHit(
		long companyId, long siteId, boolean guest, java.util.Date access)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteHitLocalService.addSiteHit(companyId, siteId, guest, access);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SiteHitLocalService getWrappedSiteHitLocalService() {
		return _siteHitLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSiteHitLocalService(
		SiteHitLocalService siteHitLocalService) {
		_siteHitLocalService = siteHitLocalService;
	}

	public SiteHitLocalService getWrappedService() {
		return _siteHitLocalService;
	}

	public void setWrappedService(SiteHitLocalService siteHitLocalService) {
		_siteHitLocalService = siteHitLocalService;
	}

	private SiteHitLocalService _siteHitLocalService;
}