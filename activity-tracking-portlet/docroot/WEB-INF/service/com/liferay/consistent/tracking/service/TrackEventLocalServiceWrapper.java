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
 * This class is a wrapper for {@link TrackEventLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       TrackEventLocalService
 * @generated
 */
public class TrackEventLocalServiceWrapper implements TrackEventLocalService,
	ServiceWrapper<TrackEventLocalService> {
	public TrackEventLocalServiceWrapper(
		TrackEventLocalService trackEventLocalService) {
		_trackEventLocalService = trackEventLocalService;
	}

	/**
	* Adds the track event to the database. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @return the track event that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent addTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.addTrackEvent(trackEvent);
	}

	/**
	* Creates a new track event with the primary key. Does not add the track event to the database.
	*
	* @param trackEventId the primary key for the new track event
	* @return the new track event
	*/
	public com.liferay.consistent.tracking.model.TrackEvent createTrackEvent(
		long trackEventId) {
		return _trackEventLocalService.createTrackEvent(trackEventId);
	}

	/**
	* Deletes the track event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event that was removed
	* @throws PortalException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent deleteTrackEvent(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.deleteTrackEvent(trackEventId);
	}

	/**
	* Deletes the track event from the database. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @return the track event that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent deleteTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.deleteTrackEvent(trackEvent);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trackEventLocalService.dynamicQuery();
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
		return _trackEventLocalService.dynamicQuery(dynamicQuery);
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
		return _trackEventLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _trackEventLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _trackEventLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.TrackEvent fetchTrackEvent(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.fetchTrackEvent(trackEventId);
	}

	/**
	* Returns the track event with the primary key.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event
	* @throws PortalException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent getTrackEvent(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getTrackEvent(trackEventId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> getTrackEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getTrackEvents(start, end);
	}

	/**
	* Returns the number of track events.
	*
	* @return the number of track events
	* @throws SystemException if a system exception occurred
	*/
	public int getTrackEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getTrackEventsCount();
	}

	/**
	* Updates the track event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @return the track event that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent updateTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.updateTrackEvent(trackEvent);
	}

	/**
	* Updates the track event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trackEvent the track event
	* @param merge whether to merge the track event with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the track event that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent updateTrackEvent(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.updateTrackEvent(trackEvent, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _trackEventLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trackEventLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _trackEventLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.liferay.consistent.tracking.model.TrackEvent addAuditMessage(
		com.liferay.portal.kernel.audit.AuditMessage auditMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.addAuditMessage(auditMessage);
	}

	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> getTrackEvents(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getTrackEvents(companyId, start, end,
			orderByComparator);
	}

	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> getTrackEvents(
		long companyId, long userId, java.lang.String userName,
		java.util.Date createDateGT, java.util.Date createDateLT,
		java.lang.String eventType, java.lang.String className,
		java.lang.String classPK, java.lang.String clientHost,
		java.lang.String clientIP, java.lang.String serverName, int serverPort,
		java.lang.String sessionID, boolean andSearch, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getTrackEvents(companyId, userId,
			userName, createDateGT, createDateLT, eventType, className,
			classPK, clientHost, clientIP, serverName, serverPort, sessionID,
			andSearch, start, end, orderByComparator);
	}

	public int getTrackEventsCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getTrackEventsCount(companyId);
	}

	public int getTrackEventsCount(long companyId, long userId,
		java.lang.String userName, java.util.Date createDateGT,
		java.util.Date createDateLT, java.lang.String eventType,
		java.lang.String className, java.lang.String classPK,
		java.lang.String clientHost, java.lang.String clientIP,
		java.lang.String serverName, int serverPort,
		java.lang.String sessionID, boolean andSearch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackEventLocalService.getTrackEventsCount(companyId, userId,
			userName, createDateGT, createDateLT, eventType, className,
			classPK, clientHost, clientIP, serverName, serverPort, sessionID,
			andSearch);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TrackEventLocalService getWrappedTrackEventLocalService() {
		return _trackEventLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTrackEventLocalService(
		TrackEventLocalService trackEventLocalService) {
		_trackEventLocalService = trackEventLocalService;
	}

	public TrackEventLocalService getWrappedService() {
		return _trackEventLocalService;
	}

	public void setWrappedService(TrackEventLocalService trackEventLocalService) {
		_trackEventLocalService = trackEventLocalService;
	}

	private TrackEventLocalService _trackEventLocalService;
}