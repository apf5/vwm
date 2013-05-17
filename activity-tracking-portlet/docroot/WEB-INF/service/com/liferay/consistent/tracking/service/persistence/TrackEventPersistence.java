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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the track event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see TrackEventPersistenceImpl
 * @see TrackEventUtil
 * @generated
 */
public interface TrackEventPersistence extends BasePersistence<TrackEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrackEventUtil} to access the track event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the track event in the entity cache if it is enabled.
	*
	* @param trackEvent the track event
	*/
	public void cacheResult(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent);

	/**
	* Caches the track events in the entity cache if it is enabled.
	*
	* @param trackEvents the track events
	*/
	public void cacheResult(
		java.util.List<com.liferay.consistent.tracking.model.TrackEvent> trackEvents);

	/**
	* Creates a new track event with the primary key. Does not add the track event to the database.
	*
	* @param trackEventId the primary key for the new track event
	* @return the new track event
	*/
	public com.liferay.consistent.tracking.model.TrackEvent create(
		long trackEventId);

	/**
	* Removes the track event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event that was removed
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent remove(
		long trackEventId)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consistent.tracking.model.TrackEvent updateImpl(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the track event with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchTrackEventException} if it could not be found.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent findByPrimaryKey(
		long trackEventId)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the track event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param trackEventId the primary key of the track event
	* @return the track event, or <code>null</code> if a track event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent fetchByPrimaryKey(
		long trackEventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the track events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last track event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent[] findByCompanyId_PrevAndNext(
		long trackEventId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the track events where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUserlogId(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUserlogId(
		long userlogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUserlogId(
		long userlogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent findByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent fetchByUserlogId_First(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event
	* @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent findByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last track event in the ordered set where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent fetchByUserlogId_Last(
		long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent[] findByUserlogId_PrevAndNext(
		long trackEventId, long userlogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the track events where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event(
		long userlogId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event(
		long userlogId, java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event(
		long userlogId, java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_First(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first track event in the ordered set where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_First(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_Last(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last track event in the ordered set where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching track event, or <code>null</code> if a matching track event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_Last(
		long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent[] findByUId_Event_PrevAndNext(
		long trackEventId, long userlogId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the track events where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @return the matching track events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event_Class(
		long userlogId, java.lang.String eventType, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event_Class(
		long userlogId, java.lang.String eventType, java.lang.String className,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findByUId_Event_Class(
		long userlogId, java.lang.String eventType, java.lang.String className,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_Class_First(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_Class_First(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent findByUId_Event_Class_Last(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent fetchByUId_Event_Class_Last(
		long userlogId, java.lang.String eventType, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.consistent.tracking.model.TrackEvent[] findByUId_Event_Class_PrevAndNext(
		long trackEventId, long userlogId, java.lang.String eventType,
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consistent.tracking.NoSuchTrackEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the track events.
	*
	* @return the track events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.consistent.tracking.model.TrackEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the track events where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the track events where userlogId = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the track events where userlogId = &#63; and eventType = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUId_Event(long userlogId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the track events where userlogId = &#63; and eventType = &#63; and className = &#63; from the database.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUId_Event_Class(long userlogId,
		java.lang.String eventType, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the track events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of track events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of track events where userlogId = &#63;.
	*
	* @param userlogId the userlog ID
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserlogId(long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of track events where userlogId = &#63; and eventType = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public int countByUId_Event(long userlogId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of track events where userlogId = &#63; and eventType = &#63; and className = &#63;.
	*
	* @param userlogId the userlog ID
	* @param eventType the event type
	* @param className the class name
	* @return the number of matching track events
	* @throws SystemException if a system exception occurred
	*/
	public int countByUId_Event_Class(long userlogId,
		java.lang.String eventType, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of track events.
	*
	* @return the number of track events
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}