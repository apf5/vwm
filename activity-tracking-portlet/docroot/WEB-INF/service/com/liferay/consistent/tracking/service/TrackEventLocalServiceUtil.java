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
 * The utility for the track event local service. This utility wraps {@link com.liferay.consistent.tracking.service.impl.TrackEventLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see TrackEventLocalService
 * @see com.liferay.consistent.tracking.service.base.TrackEventLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.impl.TrackEventLocalServiceImpl
 * @generated
 */
public class TrackEventLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.consistent.tracking.service.impl.TrackEventLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the track event to the database. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @return the track event that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent addTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTrackEvent(trackEvent);
	}

	/**
	* Creates a new track event with the primary key. Does not add the track event to the database.
	*
	* @param trackEventId the primary key for the new track event
	* @return the new track event
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent createTrackEvent(
		long trackEventId) {
		return getService().createTrackEvent(trackEventId);
	}

	/**
	* Deletes the track event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event that was removed
	* @throws PortalException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent deleteTrackEvent(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTrackEvent(trackEventId);
	}

	/**
	* Deletes the track event from the database. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @return the track event that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent deleteTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTrackEvent(trackEvent);
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

	public static com.liferay.consistent.tracking.model.TrackEvent fetchTrackEvent(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTrackEvent(trackEventId);
	}

	/**
	* Returns the track event with the primary key.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event
	* @throws PortalException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent getTrackEvent(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrackEvent(trackEventId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the track events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @return the range of track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> getTrackEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrackEvents(start, end);
	}

	/**
	* Returns the number of track events.
	*
	* @return the number of track events
	* @throws SystemException if a system exception occurred
	*/
	public static int getTrackEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrackEventsCount();
	}

	/**
	* Updates the track event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @return the track event that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent updateTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTrackEvent(trackEvent);
	}

	/**
	* Updates the track event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @param merge whether to merge the track event with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the track event that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent updateTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTrackEvent(trackEvent, merge);
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

	public static com.liferay.consistent.tracking.model.TrackEvent addAuditMessage(
		com.liferay.portal.kernel.audit.AuditMessage auditMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAuditMessage(auditMessage);
	}

	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> getTrackEvents(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTrackEvents(companyId, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> getTrackEvents(
		long companyId, long userId, java.lang.String userName,
		java.util.Date createDateGT, java.util.Date createDateLT,
		java.lang.String eventType, java.lang.String className,
		java.lang.String classPK, java.lang.String clientHost,
		java.lang.String clientIP, java.lang.String serverName, int serverPort,
		java.lang.String sessionID, boolean andSearch, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTrackEvents(companyId, userId, userName, createDateGT,
			createDateLT, eventType, className, classPK, clientHost, clientIP,
			serverName, serverPort, sessionID, andSearch, start, end,
			orderByComparator);
	}

	public static int getTrackEventsCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrackEventsCount(companyId);
	}

	public static int getTrackEventsCount(long companyId, long userId,
		java.lang.String userName, java.util.Date createDateGT,
		java.util.Date createDateLT, java.lang.String eventType,
		java.lang.String className, java.lang.String classPK,
		java.lang.String clientHost, java.lang.String clientIP,
		java.lang.String serverName, int serverPort,
		java.lang.String sessionID, boolean andSearch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTrackEventsCount(companyId, userId, userName,
			createDateGT, createDateLT, eventType, className, classPK,
			clientHost, clientIP, serverName, serverPort, sessionID, andSearch);
	}

	public static void clearService() {
		_service = null;
	}

	public static TrackEventLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TrackEventLocalService.class.getName());

			if (invokableLocalService instanceof TrackEventLocalService) {
				_service = (TrackEventLocalService)invokableLocalService;
			}
			else {
				_service = new TrackEventLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TrackEventLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TrackEventLocalService service) {
	}

	private static TrackEventLocalService _service;
}