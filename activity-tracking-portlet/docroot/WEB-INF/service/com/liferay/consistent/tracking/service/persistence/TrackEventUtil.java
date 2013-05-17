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

import com.liferay.consistent.tracking.model.TrackEvent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the track event service. This utility wraps {@link TrackEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see TrackEventPersistence
 * @see TrackEventPersistenceImpl
 * @generated
 */
public class TrackEventUtil {
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
	public static void clearCache(TrackEvent trackEvent) {
		getPersistence().clearCache(trackEvent);
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
	public static List<TrackEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrackEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrackEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TrackEvent update(TrackEvent trackEvent, boolean merge)
		throws SystemException {
		return getPersistence().update(trackEvent, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TrackEvent update(TrackEvent trackEvent, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(trackEvent, merge, serviceContext);
	}

	/**
	* Caches the track event in the entity cache if it is enabled.
	*
	* @param trackEvent the track event
	*/
	public static void cacheResult(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent) {
		getPersistence().cacheResult(trackEvent);
	}

	/**
	* Caches the track events in the entity cache if it is enabled.
	*
	* @param trackEvents the track events
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.TrackEvent> trackEvents) {
		getPersistence().cacheResult(trackEvents);
	}

	/**
	* Creates a new track event with the primary key. Does not add the track event to the database.
	*
	* @param trackEventId the primary key for the new track event
	* @return the new track event
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent create(
		long trackEventId) {
		return getPersistence().create(trackEventId);
	}

	/**
	* Removes the track event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event that was removed
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent remove(
		long trackEventId)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(trackEventId);
	}

	public static com.liferay.consistent.tracking.model.TrackEvent updateImpl(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(trackEvent, merge);
	}

	/**
	* Returns the track event with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchTrackEventException} if it could not be found.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByPrimaryKey(
		long trackEventId)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(trackEventId);
	}

	/**
	* Returns the track event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event, or <code>null</code> if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByPrimaryKey(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(trackEventId);
	}

	/**
	* Returns all the track events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the track events where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @return the range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the track events where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the track events before and after the current track event in the ordered set where companyId = &#63;.
	*
	* @param trackEventId the primary key of the current track event
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent[] findByCompanyId_PrevAndNext(
		long trackEventId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(trackEventId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the track events where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUserlogId(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserlogId(userlogId);
	}

	/**
	* Returns a range of all the track events where userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @return the range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUserlogId(
		long userlogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserlogId(userlogId, start, end);
	}

	/**
	* Returns an ordered range of all the track events where userlogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUserlogId(
		long userlogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId(userlogId, start, end, orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_First(userlogId, orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserlogId_First(userlogId, orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_Last(userlogId, orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserlogId_Last(userlogId, orderByComparator);
	}

	/**
	* Returns the track events before and after the current track event in the ordered set where userlogId = &#63;.
	*
	* @param trackEventId the primary key of the current track event
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent[] findByUserlogId_PrevAndNext(
		long trackEventId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserlogId_PrevAndNext(trackEventId, userlogId,
			orderByComparator);
	}

	/**
	* Returns all the track events where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event(
		long userlogId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUId_Event(userlogId, eventType);
	}

	/**
	* Returns a range of all the track events where userlogId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @return the range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event(
		long userlogId, java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUId_Event(userlogId, eventType, start, end);
	}

	/**
	* Returns an ordered range of all the track events where userlogId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event(
		long userlogId, java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event(userlogId, eventType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_First(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_First(userlogId, eventType,
			orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_First(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUId_Event_First(userlogId, eventType,
			orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_Last(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_Last(userlogId, eventType, orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_Last(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUId_Event_Last(userlogId, eventType,
			orderByComparator);
	}

	/**
	* Returns the track events before and after the current track event in the ordered set where userlogId = &#63; and eventType = &#63;.
	*
	* @param trackEventId the primary key of the current track event
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent[] findByUId_Event_PrevAndNext(
		long trackEventId, long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_PrevAndNext(trackEventId, userlogId,
			eventType, orderByComparator);
	}

	/**
	* Returns all the track events where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event_Class(
		long userlogId, java.lang.String eventType, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_Class(userlogId, eventType, className);
	}

	/**
	* Returns a range of all the track events where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @return the range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event_Class(
		long userlogId, java.lang.String eventType, java.lang.String className,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_Class(userlogId, eventType, className,
			start, end);
	}

	/**
	* Returns an ordered range of all the track events where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event_Class(
		long userlogId, java.lang.String eventType, java.lang.String className,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_Class(userlogId, eventType, className,
			start, end, orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_Class_First(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_Class_First(userlogId, eventType,
			className, orderByComparator);
	}

	/**
	* Returns the first track event in the ordered set where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_Class_First(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUId_Event_Class_First(userlogId, eventType,
			className, orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_Class_Last(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_Class_Last(userlogId, eventType, className,
			orderByComparator);
	}

	/**
	* Returns the last track event in the ordered set where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_Class_Last(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUId_Event_Class_Last(userlogId, eventType,
			className, orderByComparator);
	}

	/**
	* Returns the track events before and after the current track event in the ordered set where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param trackEventId the primary key of the current track event
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consistent.tracking.model.TrackEvent[] findByUId_Event_Class_PrevAndNext(
		long trackEventId, long userlogId, java.lang.String eventType,
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUId_Event_Class_PrevAndNext(trackEventId, userlogId,
			eventType, className, orderByComparator);
	}

	/**
	* Returns all the track events.
	*
	* @return the track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the track events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of track events
	* @param end the upper bound of the range of track events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of track events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the track events where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the track events where userlogId = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserlogId(userlogId);
	}

	/**
	* Removes all the track events where userlogId = &#63; and eventType = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUId_Event(long userlogId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUId_Event(userlogId, eventType);
	}

	/**
	* Removes all the track events where userlogId = &#63; and eventType = &#63; and className = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUId_Event_Class(long userlogId,
		java.lang.String eventType, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUId_Event_Class(userlogId, eventType, className);
	}

	/**
	* Removes all the track events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of track events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of track events where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserlogId(userlogId);
	}

	/**
	* Returns the number of track events where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUId_Event(long userlogId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUId_Event(userlogId, eventType);
	}

	/**
	* Returns the number of track events where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUId_Event_Class(long userlogId,
		java.lang.String eventType, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUId_Event_Class(userlogId, eventType, className);
	}

	/**
	* Returns the number of track events.
	*
	* @return the number of track events
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TrackEventPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TrackEventPersistence)PortletBeanLocatorUtil.locate(com.liferay.consistent.tracking.service.ClpSerializer.getServletContextName(),
					TrackEventPersistence.class.getName());

			ReferenceRegistry.registerReference(TrackEventUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TrackEventPersistence persistence) {
	}

	private static TrackEventPersistence _persistence;
}