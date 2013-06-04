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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the portlet hit local service. This utility wraps {@link com.liferay.consistent.tracking.service.impl.PortletHitLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PortletHitLocalService
 * @see com.liferay.consistent.tracking.service.base.PortletHitLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.impl.PortletHitLocalServiceImpl
 * @generated
 */
public class PortletHitLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.consistent.tracking.service.impl.PortletHitLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the portlet hit to the database. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @return the portlet hit that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit addPortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPortletHit(portletHit);
	}

	/**
	* Creates a new portlet hit with the primary key. Does not add the portlet hit to the database.
	*
	* @param hitId the primary key for the new portlet hit
	* @return the new portlet hit
	*/
	public static com.liferay.consistent.tracking.model.PortletHit createPortletHit(
		long hitId) {
		return getService().createPortletHit(hitId);
	}

	/**
	* Deletes the portlet hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the portlet hit
	* @return the portlet hit that was removed
	* @throws PortalException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit deletePortletHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortletHit(hitId);
	}

	/**
	* Deletes the portlet hit from the database. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @return the portlet hit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit deletePortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortletHit(portletHit);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.consistent.tracking.model.PortletHit fetchPortletHit(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPortletHit(hitId);
	}

	/**
	* Returns the portlet hit with the primary key.
	*
	* @param hitId the primary key of the portlet hit
	* @return the portlet hit
	* @throws PortalException if a portlet hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit getPortletHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletHit(hitId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.consistent.tracking.model.PortletHit> getPortletHits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletHits(start, end);
	}

	/**
	* Returns the number of portlet hits.
	*
	* @return the number of portlet hits
	* @throws SystemException if a system exception occurred
	*/
	public static int getPortletHitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletHitsCount();
	}

	/**
	* Updates the portlet hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @return the portlet hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit updatePortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortletHit(portletHit);
	}

	/**
	* Updates the portlet hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletHit the portlet hit
	* @param merge whether to merge the portlet hit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portlet hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.PortletHit updatePortletHit(
		com.liferay.consistent.tracking.model.PortletHit portletHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortletHit(portletHit, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.consistent.tracking.model.PortletHit addPortletHit(
		long companyId, java.lang.String portletId, boolean guest, long userId,
		long userlogId, java.util.Date access)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPortletHit(companyId, portletId, guest, userId,
			userlogId, access);
	}

	public static void clearService() {
		_service = null;
	}

	public static PortletHitLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PortletHitLocalService.class.getName());

			if (invokableLocalService instanceof PortletHitLocalService) {
				_service = (PortletHitLocalService)invokableLocalService;
			}
			else {
				_service = new PortletHitLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PortletHitLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PortletHitLocalService service) {
	}

	private static PortletHitLocalService _service;
}