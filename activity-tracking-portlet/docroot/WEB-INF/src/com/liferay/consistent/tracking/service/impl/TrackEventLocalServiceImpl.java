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

package com.liferay.consistent.tracking.service.impl;

import com.liferay.consistent.tracking.model.TrackEvent;
import com.liferay.consistent.tracking.service.base.TrackEventLocalServiceBaseImpl;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the track event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.TrackEventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.TrackEventLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.TrackEventLocalServiceUtil
 */
public class TrackEventLocalServiceImpl extends TrackEventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.TrackEventLocalServiceUtil} to access the track event local service.
	 */
	
	public TrackEvent addAuditMessage(AuditMessage auditMessage)
			throws SystemException {

			long trackEventId = counterLocalService.increment();

			TrackEvent trackEvent = trackEventPersistence.create(trackEventId);

			trackEvent.setCompanyId(auditMessage.getCompanyId());
			//trackEvent.setUserId(auditMessage.getUserId());
			trackEvent.setUserName(auditMessage.getUserName());
			trackEvent.setCreateDate(auditMessage.getTimestamp().getTime());
			trackEvent.setEventType(auditMessage.getEventType());
			trackEvent.setClassName(auditMessage.getClassName());
			trackEvent.setClassPK(auditMessage.getClassPK());
			trackEvent.setMessage(auditMessage.getMessage());
			trackEvent.setClientHost(auditMessage.getClientHost());
			trackEvent.setClientAddr(auditMessage.getClientIP());
			trackEvent.setServerName(auditMessage.getServerName());
			trackEvent.setServerPort(auditMessage.getServerPort());
			//trackEvent.setSessionID(auditMessage.getSessionID());
			trackEvent.setServerPort(auditMessage.getServerPort());
			trackEvent.setAdditionalInfo(
				String.valueOf(auditMessage.getAdditionalInfo()));

			trackEventPersistence.update(trackEvent, false);

			return trackEvent;
		}

		public List<TrackEvent> getTrackEvents(
				long companyId, int start, int end,
				OrderByComparator orderByComparator)
			throws SystemException {

			return trackEventPersistence.findByCompanyId(
				companyId, start, end, orderByComparator);
		}

		public List<TrackEvent> getTrackEvents(
				long companyId, long userId, String userName, Date createDateGT,
				Date createDateLT, String eventType, String className,
				String classPK, String clientHost, String clientIP,
				String serverName, int serverPort, String sessionID,
				boolean andSearch, int start, int end,
				OrderByComparator orderByComparator)
			throws SystemException {

			DynamicQuery dynamicQuery = buildDynamicQuery(
				companyId, userId, userName, createDateGT, createDateLT, eventType,
				className, classPK, clientHost, clientIP, serverName, serverPort,
				sessionID, andSearch);

			return dynamicQuery(dynamicQuery, start, end, orderByComparator);
		}

		public int getTrackEventsCount(long companyId) throws SystemException {
			return trackEventPersistence.countByCompanyId(companyId);
		}

		public int getTrackEventsCount(
				long companyId, long userId, String userName, Date createDateGT,
				Date createDateLT, String eventType, String className,
				String classPK, String clientHost, String clientIP,
				String serverName, int serverPort, String sessionID,
				boolean andSearch)
			throws SystemException {

			DynamicQuery dynamicQuery = buildDynamicQuery(
				companyId, userId, userName, createDateGT, createDateLT, eventType,
				className, classPK, clientHost, clientIP, serverName, serverPort,
				sessionID, andSearch);

			return (int)dynamicQueryCount(dynamicQuery);
		}

		protected DynamicQuery buildDynamicQuery(
			long companyId, long userId, String userName, Date createDateGT,
			Date createDateLT, String eventType, String className, String classPK,
			String clientHost, String clientIP, String serverName, int serverPort,
			String sessionID, boolean andSearch) {

			Junction junction = null;

			if (andSearch) {
				junction = RestrictionsFactoryUtil.conjunction();
			}
			else {
				junction = RestrictionsFactoryUtil.disjunction();
			}

			if (userId > 0) {
				Property property = PropertyFactoryUtil.forName("userId");

				junction.add(property.eq(userId));
			}

			if (Validator.isNotNull(userName)) {
				Property property = PropertyFactoryUtil.forName("userName");

				String value = StringPool.PERCENT + userName + StringPool.PERCENT;

				junction.add(property.like(value));
			}

			if (Validator.isNotNull(eventType)) {
				Property property = PropertyFactoryUtil.forName("eventType");

				String value = StringPool.PERCENT + eventType + StringPool.PERCENT;

				junction.add(property.like(value));
			}

			if (Validator.isNotNull(className)) {
				Property property = PropertyFactoryUtil.forName("className");

				String value = StringPool.PERCENT + className + StringPool.PERCENT;

				junction.add(property.like(value));
			}

			if (Validator.isNotNull(classPK)) {
				Property property = PropertyFactoryUtil.forName("classPK");

				junction.add(property.eq(classPK));
			}

			if (Validator.isNotNull(clientHost)) {
				Property property = PropertyFactoryUtil.forName("clientHost");

				String value = StringPool.PERCENT + clientHost + StringPool.PERCENT;

				junction.add(property.like(value));
			}

			if (Validator.isNotNull(clientIP)) {
				Property property = PropertyFactoryUtil.forName("clientIP");

				String value = StringPool.PERCENT + clientIP + StringPool.PERCENT;

				junction.add(property.like(value));
			}

			if (Validator.isNotNull(serverName)) {
				Property property = PropertyFactoryUtil.forName("serverName");

				String value = StringPool.PERCENT + serverName + StringPool.PERCENT;

				junction.add(property.like(value));
			}

			if (serverPort > 0) {
				Property property = PropertyFactoryUtil.forName("serverPort");

				junction.add(property.eq(serverPort));
			}

			if (Validator.isNotNull(sessionID)) {
				Property property = PropertyFactoryUtil.forName("sessionID");

				String value = StringPool.PERCENT + sessionID + StringPool.PERCENT;

				junction.add(property.like(value));
			}

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				TrackEvent.class, getClassLoader());

			if (companyId > 0) {
				Property property = PropertyFactoryUtil.forName("companyId");

				dynamicQuery.add(property.eq(companyId));
			}

			if (createDateGT != null) {
				Property property = PropertyFactoryUtil.forName("createDate");

				dynamicQuery.add(property.gt(createDateGT));
			}

			if (createDateLT != null) {
				Property property = PropertyFactoryUtil.forName("createDate");

				dynamicQuery.add(property.lt(createDateLT));
			}

			return dynamicQuery.add(junction);
		}
}