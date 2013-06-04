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
 * This class is a wrapper for {@link PortletHitLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       PortletHitLocalService
 * @generated
 */
public class PortletHitLocalServiceWrapper implements PortletHitLocalService,
	ServiceWrapper<PortletHitLocalService> {
	public PortletHitLocalServiceWrapper(
		PortletHitLocalService portletHitLocalService) {
		_portletHitLocalService = portletHitLocalService;
	}

	/**
	* Adds the portlet hit to the database. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @return the portlet hit that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletHit addPortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.addPortletHit(portletHit);
	}

	/**
	* Creates a new portlet hit with the primary key. Does not add the portlet hit to the database.
	*
	* @param hitId the primary key for the new portlet hit
	* @return the new portlet hit
	*/
	public com.liferay.consistent.tracking.model.PortletHit createPortletHit(
		long hitId) {
		return _portletHitLocalService.createPortletHit(hitId);
	}

	/**
	* Deletes the portlet hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the portlet hit
	* @return the portlet hit that was removed
	* @throws PortalException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletHit deletePortletHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.deletePortletHit(hitId);
	}

	/**
	* Deletes the portlet hit from the database. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @return the portlet hit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletHit deletePortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.deletePortletHit(portletHit);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portletHitLocalService.dynamicQuery();
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
		return _portletHitLocalService.dynamicQuery(dynamicQuery);
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
		return _portletHitLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _portletHitLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _portletHitLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.PortletHit fetchPortletHit(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.fetchPortletHit(hitId);
	}

	/**
	* Returns the portlet hit with the primary key.
	*
	* @param hitId the primary key of the portlet hit
	* @return the portlet hit
	* @throws PortalException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletHit getPortletHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.getPortletHit(hitId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the portlet hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet hits
	* @param end the upper bound of the range of portlet hits (not inclusive)
	* @return the range of portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletHit> getPortletHits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.getPortletHits(start, end);
	}

	/**
	* Returns the number of portlet hits.
	*
	* @return the number of portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public int getPortletHitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.getPortletHitsCount();
	}

	/**
	* Updates the portlet hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @return the portlet hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletHit updatePortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.updatePortletHit(portletHit);
	}

	/**
	* Updates the portlet hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @param merge whether to merge the portlet hit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portlet hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletHit updatePortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.updatePortletHit(portletHit, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _portletHitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portletHitLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portletHitLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.liferay.consistent.tracking.model.PortletHit addPortletHit(
		long companyId, java.lang.String portletId, boolean guest, long userId,
		long userlogId, java.util.Date access)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletHitLocalService.addPortletHit(companyId, portletId,
			guest, userId, userlogId, access);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PortletHitLocalService getWrappedPortletHitLocalService() {
		return _portletHitLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPortletHitLocalService(
		PortletHitLocalService portletHitLocalService) {
		_portletHitLocalService = portletHitLocalService;
	}

	public PortletHitLocalService getWrappedService() {
		return _portletHitLocalService;
	}

	public void setWrappedService(PortletHitLocalService portletHitLocalService) {
		_portletHitLocalService = portletHitLocalService;
	}

	private PortletHitLocalService _portletHitLocalService;
}