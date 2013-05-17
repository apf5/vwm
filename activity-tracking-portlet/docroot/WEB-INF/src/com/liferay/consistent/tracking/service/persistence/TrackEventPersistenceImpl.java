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

import com.liferay.consistent.tracking.NoSuchTrackEventException;
import com.liferay.consistent.tracking.model.TrackEvent;
import com.liferay.consistent.tracking.model.impl.TrackEventImpl;
import com.liferay.consistent.tracking.model.impl.TrackEventModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the track event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see TrackEventPersistence
 * @see TrackEventUtil
 * @generated
 */
public class TrackEventPersistenceImpl extends BasePersistenceImpl<TrackEvent>
	implements TrackEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrackEventUtil} to access the track event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrackEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TrackEventModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERLOGID =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserlogId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserlogId",
			new String[] { Long.class.getName() },
			TrackEventModelImpl.USERLOGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERLOGID = new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserlogId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UID_EVENT =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUId_Event",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUId_Event",
			new String[] { Long.class.getName(), String.class.getName() },
			TrackEventModelImpl.USERLOGID_COLUMN_BITMASK |
			TrackEventModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UID_EVENT = new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUId_Event",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UID_EVENT_CLASS =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUId_Event_Class",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT_CLASS =
		new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUId_Event_Class",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			TrackEventModelImpl.USERLOGID_COLUMN_BITMASK |
			TrackEventModelImpl.EVENTTYPE_COLUMN_BITMASK |
			TrackEventModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UID_EVENT_CLASS = new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUId_Event_Class",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, TrackEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the track event in the entity cache if it is enabled.
	 *
	 * @param trackEvent the track event
	 */
	public void cacheResult(TrackEvent trackEvent) {
		EntityCacheUtil.putResult(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventImpl.class, trackEvent.getPrimaryKey(), trackEvent);

		trackEvent.resetOriginalValues();
	}

	/**
	 * Caches the track events in the entity cache if it is enabled.
	 *
	 * @param trackEvents the track events
	 */
	public void cacheResult(List<TrackEvent> trackEvents) {
		for (TrackEvent trackEvent : trackEvents) {
			if (EntityCacheUtil.getResult(
						TrackEventModelImpl.ENTITY_CACHE_ENABLED,
						TrackEventImpl.class, trackEvent.getPrimaryKey()) == null) {
				cacheResult(trackEvent);
			}
			else {
				trackEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all track events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrackEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrackEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the track event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrackEvent trackEvent) {
		EntityCacheUtil.removeResult(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventImpl.class, trackEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TrackEvent> trackEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrackEvent trackEvent : trackEvents) {
			EntityCacheUtil.removeResult(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
				TrackEventImpl.class, trackEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new track event with the primary key. Does not add the track event to the database.
	 *
	 * @param trackEventId the primary key for the new track event
	 * @return the new track event
	 */
	public TrackEvent create(long trackEventId) {
		TrackEvent trackEvent = new TrackEventImpl();

		trackEvent.setNew(true);
		trackEvent.setPrimaryKey(trackEventId);

		return trackEvent;
	}

	/**
	 * Removes the track event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trackEventId the primary key of the track event
	 * @return the track event that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrackEvent remove(long trackEventId)
		throws NoSuchTrackEventException, SystemException {
		return remove(Long.valueOf(trackEventId));
	}

	/**
	 * Removes the track event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the track event
	 * @return the track event that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackEvent remove(Serializable primaryKey)
		throws NoSuchTrackEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrackEvent trackEvent = (TrackEvent)session.get(TrackEventImpl.class,
					primaryKey);

			if (trackEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrackEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trackEvent);
		}
		catch (NoSuchTrackEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TrackEvent removeImpl(TrackEvent trackEvent)
		throws SystemException {
		trackEvent = toUnwrappedModel(trackEvent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, trackEvent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(trackEvent);

		return trackEvent;
	}

	@Override
	public TrackEvent updateImpl(
		com.liferay.consistent.tracking.model.TrackEvent trackEvent,
		boolean merge) throws SystemException {
		trackEvent = toUnwrappedModel(trackEvent);

		boolean isNew = trackEvent.isNew();

		TrackEventModelImpl trackEventModelImpl = (TrackEventModelImpl)trackEvent;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, trackEvent, merge);

			trackEvent.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrackEventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trackEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(trackEventModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(trackEventModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((trackEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(trackEventModelImpl.getOriginalUserlogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID,
					args);

				args = new Object[] {
						Long.valueOf(trackEventModelImpl.getUserlogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID,
					args);
			}

			if ((trackEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(trackEventModelImpl.getOriginalUserlogId()),
						
						trackEventModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UID_EVENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT,
					args);

				args = new Object[] {
						Long.valueOf(trackEventModelImpl.getUserlogId()),
						
						trackEventModelImpl.getEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UID_EVENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT,
					args);
			}

			if ((trackEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT_CLASS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(trackEventModelImpl.getOriginalUserlogId()),
						
						trackEventModelImpl.getOriginalEventType(),
						
						trackEventModelImpl.getOriginalClassName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UID_EVENT_CLASS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT_CLASS,
					args);

				args = new Object[] {
						Long.valueOf(trackEventModelImpl.getUserlogId()),
						
						trackEventModelImpl.getEventType(),
						
						trackEventModelImpl.getClassName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UID_EVENT_CLASS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT_CLASS,
					args);
			}
		}

		EntityCacheUtil.putResult(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
			TrackEventImpl.class, trackEvent.getPrimaryKey(), trackEvent);

		return trackEvent;
	}

	protected TrackEvent toUnwrappedModel(TrackEvent trackEvent) {
		if (trackEvent instanceof TrackEventImpl) {
			return trackEvent;
		}

		TrackEventImpl trackEventImpl = new TrackEventImpl();

		trackEventImpl.setNew(trackEvent.isNew());
		trackEventImpl.setPrimaryKey(trackEvent.getPrimaryKey());

		trackEventImpl.setTrackEventId(trackEvent.getTrackEventId());
		trackEventImpl.setCompanyId(trackEvent.getCompanyId());
		trackEventImpl.setUserName(trackEvent.getUserName());
		trackEventImpl.setCreateDate(trackEvent.getCreateDate());
		trackEventImpl.setUserlogId(trackEvent.getUserlogId());
		trackEventImpl.setEventType(trackEvent.getEventType());
		trackEventImpl.setClassName(trackEvent.getClassName());
		trackEventImpl.setClassPK(trackEvent.getClassPK());
		trackEventImpl.setMessage(trackEvent.getMessage());
		trackEventImpl.setClientHost(trackEvent.getClientHost());
		trackEventImpl.setClientAddr(trackEvent.getClientAddr());
		trackEventImpl.setServerName(trackEvent.getServerName());
		trackEventImpl.setServerPort(trackEvent.getServerPort());
		trackEventImpl.setAdditionalInfo(trackEvent.getAdditionalInfo());

		return trackEventImpl;
	}

	/**
	 * Returns the track event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the track event
	 * @return the track event
	 * @throws com.liferay.portal.NoSuchModelException if a track event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the track event with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchTrackEventException} if it could not be found.
	 *
	 * @param trackEventId the primary key of the track event
	 * @return the track event
	 * @throws com.liferay.consistent.tracking.NoSuchTrackEventException if a track event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrackEvent findByPrimaryKey(long trackEventId)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByPrimaryKey(trackEventId);

		if (trackEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + trackEventId);
			}

			throw new NoSuchTrackEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				trackEventId);
		}

		return trackEvent;
	}

	/**
	 * Returns the track event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the track event
	 * @return the track event, or <code>null</code> if a track event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the track event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trackEventId the primary key of the track event
	 * @return the track event, or <code>null</code> if a track event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrackEvent fetchByPrimaryKey(long trackEventId)
		throws SystemException {
		TrackEvent trackEvent = (TrackEvent)EntityCacheUtil.getResult(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
				TrackEventImpl.class, trackEventId);

		if (trackEvent == _nullTrackEvent) {
			return null;
		}

		if (trackEvent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				trackEvent = (TrackEvent)session.get(TrackEventImpl.class,
						Long.valueOf(trackEventId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (trackEvent != null) {
					cacheResult(trackEvent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TrackEventModelImpl.ENTITY_CACHE_ENABLED,
						TrackEventImpl.class, trackEventId, _nullTrackEvent);
				}

				closeSession(session);
			}
		}

		return trackEvent;
	}

	/**
	 * Returns all the track events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching track events
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrackEvent> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<TrackEvent> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	public List<TrackEvent> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<TrackEvent> list = (List<TrackEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackEvent trackEvent : list) {
				if ((companyId != trackEvent.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrackEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<TrackEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public TrackEvent findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
	}

	/**
	 * Returns the first track event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching track event, or <code>null</code> if a matching track event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrackEvent fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrackEvent> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
	}

	/**
	 * Returns the last track event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching track event, or <code>null</code> if a matching track event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrackEvent fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<TrackEvent> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent[] findByCompanyId_PrevAndNext(long trackEventId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = findByPrimaryKey(trackEventId);

		Session session = null;

		try {
			session = openSession();

			TrackEvent[] array = new TrackEventImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, trackEvent,
					companyId, orderByComparator, true);

			array[1] = trackEvent;

			array[2] = getByCompanyId_PrevAndNext(session, trackEvent,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackEvent getByCompanyId_PrevAndNext(Session session,
		TrackEvent trackEvent, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKEVENT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TrackEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the track events where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @return the matching track events
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrackEvent> findByUserlogId(long userlogId)
		throws SystemException {
		return findByUserlogId(userlogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<TrackEvent> findByUserlogId(long userlogId, int start, int end)
		throws SystemException {
		return findByUserlogId(userlogId, start, end, null);
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
	public List<TrackEvent> findByUserlogId(long userlogId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID;
			finderArgs = new Object[] { userlogId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERLOGID;
			finderArgs = new Object[] { userlogId, start, end, orderByComparator };
		}

		List<TrackEvent> list = (List<TrackEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackEvent trackEvent : list) {
				if ((userlogId != trackEvent.getUserlogId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_USERLOGID_USERLOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrackEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				list = (List<TrackEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public TrackEvent findByUserlogId_First(long userlogId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByUserlogId_First(userlogId,
				orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
	}

	/**
	 * Returns the first track event in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching track event, or <code>null</code> if a matching track event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrackEvent fetchByUserlogId_First(long userlogId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrackEvent> list = findByUserlogId(userlogId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent findByUserlogId_Last(long userlogId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByUserlogId_Last(userlogId,
				orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
	}

	/**
	 * Returns the last track event in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching track event, or <code>null</code> if a matching track event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrackEvent fetchByUserlogId_Last(long userlogId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserlogId(userlogId);

		List<TrackEvent> list = findByUserlogId(userlogId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent[] findByUserlogId_PrevAndNext(long trackEventId,
		long userlogId, OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = findByPrimaryKey(trackEventId);

		Session session = null;

		try {
			session = openSession();

			TrackEvent[] array = new TrackEventImpl[3];

			array[0] = getByUserlogId_PrevAndNext(session, trackEvent,
					userlogId, orderByComparator, true);

			array[1] = trackEvent;

			array[2] = getByUserlogId_PrevAndNext(session, trackEvent,
					userlogId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackEvent getByUserlogId_PrevAndNext(Session session,
		TrackEvent trackEvent, long userlogId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKEVENT_WHERE);

		query.append(_FINDER_COLUMN_USERLOGID_USERLOGID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TrackEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userlogId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the track events where userlogId = &#63; and eventType = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param eventType the event type
	 * @return the matching track events
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrackEvent> findByUId_Event(long userlogId, String eventType)
		throws SystemException {
		return findByUId_Event(userlogId, eventType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<TrackEvent> findByUId_Event(long userlogId, String eventType,
		int start, int end) throws SystemException {
		return findByUId_Event(userlogId, eventType, start, end, null);
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
	public List<TrackEvent> findByUId_Event(long userlogId, String eventType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT;
			finderArgs = new Object[] { userlogId, eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UID_EVENT;
			finderArgs = new Object[] {
					userlogId, eventType,
					
					start, end, orderByComparator
				};
		}

		List<TrackEvent> list = (List<TrackEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackEvent trackEvent : list) {
				if ((userlogId != trackEvent.getUserlogId()) ||
						!Validator.equals(eventType, trackEvent.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_UID_EVENT_USERLOGID_2);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrackEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				if (eventType != null) {
					qPos.add(eventType);
				}

				list = (List<TrackEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public TrackEvent findByUId_Event_First(long userlogId, String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByUId_Event_First(userlogId, eventType,
				orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
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
	public TrackEvent fetchByUId_Event_First(long userlogId, String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrackEvent> list = findByUId_Event(userlogId, eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent findByUId_Event_Last(long userlogId, String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByUId_Event_Last(userlogId, eventType,
				orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
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
	public TrackEvent fetchByUId_Event_Last(long userlogId, String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUId_Event(userlogId, eventType);

		List<TrackEvent> list = findByUId_Event(userlogId, eventType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent[] findByUId_Event_PrevAndNext(long trackEventId,
		long userlogId, String eventType, OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = findByPrimaryKey(trackEventId);

		Session session = null;

		try {
			session = openSession();

			TrackEvent[] array = new TrackEventImpl[3];

			array[0] = getByUId_Event_PrevAndNext(session, trackEvent,
					userlogId, eventType, orderByComparator, true);

			array[1] = trackEvent;

			array[2] = getByUId_Event_PrevAndNext(session, trackEvent,
					userlogId, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackEvent getByUId_Event_PrevAndNext(Session session,
		TrackEvent trackEvent, long userlogId, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKEVENT_WHERE);

		query.append(_FINDER_COLUMN_UID_EVENT_USERLOGID_2);

		if (eventType == null) {
			query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_1);
		}
		else {
			if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TrackEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userlogId);

		if (eventType != null) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public List<TrackEvent> findByUId_Event_Class(long userlogId,
		String eventType, String className) throws SystemException {
		return findByUId_Event_Class(userlogId, eventType, className,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TrackEvent> findByUId_Event_Class(long userlogId,
		String eventType, String className, int start, int end)
		throws SystemException {
		return findByUId_Event_Class(userlogId, eventType, className, start,
			end, null);
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
	public List<TrackEvent> findByUId_Event_Class(long userlogId,
		String eventType, String className, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UID_EVENT_CLASS;
			finderArgs = new Object[] { userlogId, eventType, className };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UID_EVENT_CLASS;
			finderArgs = new Object[] {
					userlogId, eventType, className,
					
					start, end, orderByComparator
				};
		}

		List<TrackEvent> list = (List<TrackEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackEvent trackEvent : list) {
				if ((userlogId != trackEvent.getUserlogId()) ||
						!Validator.equals(eventType, trackEvent.getEventType()) ||
						!Validator.equals(className, trackEvent.getClassName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_UID_EVENT_CLASS_USERLOGID_2);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_2);
				}
			}

			if (className == null) {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_1);
			}
			else {
				if (className.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrackEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				if (eventType != null) {
					qPos.add(eventType);
				}

				if (className != null) {
					qPos.add(className);
				}

				list = (List<TrackEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public TrackEvent findByUId_Event_Class_First(long userlogId,
		String eventType, String className, OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByUId_Event_Class_First(userlogId,
				eventType, className, orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
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
	public TrackEvent fetchByUId_Event_Class_First(long userlogId,
		String eventType, String className, OrderByComparator orderByComparator)
		throws SystemException {
		List<TrackEvent> list = findByUId_Event_Class(userlogId, eventType,
				className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent findByUId_Event_Class_Last(long userlogId,
		String eventType, String className, OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = fetchByUId_Event_Class_Last(userlogId,
				eventType, className, orderByComparator);

		if (trackEvent != null) {
			return trackEvent;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventException(msg.toString());
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
	public TrackEvent fetchByUId_Event_Class_Last(long userlogId,
		String eventType, String className, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUId_Event_Class(userlogId, eventType, className);

		List<TrackEvent> list = findByUId_Event_Class(userlogId, eventType,
				className, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TrackEvent[] findByUId_Event_Class_PrevAndNext(long trackEventId,
		long userlogId, String eventType, String className,
		OrderByComparator orderByComparator)
		throws NoSuchTrackEventException, SystemException {
		TrackEvent trackEvent = findByPrimaryKey(trackEventId);

		Session session = null;

		try {
			session = openSession();

			TrackEvent[] array = new TrackEventImpl[3];

			array[0] = getByUId_Event_Class_PrevAndNext(session, trackEvent,
					userlogId, eventType, className, orderByComparator, true);

			array[1] = trackEvent;

			array[2] = getByUId_Event_Class_PrevAndNext(session, trackEvent,
					userlogId, eventType, className, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackEvent getByUId_Event_Class_PrevAndNext(Session session,
		TrackEvent trackEvent, long userlogId, String eventType,
		String className, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKEVENT_WHERE);

		query.append(_FINDER_COLUMN_UID_EVENT_CLASS_USERLOGID_2);

		if (eventType == null) {
			query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_1);
		}
		else {
			if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_2);
			}
		}

		if (className == null) {
			query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_1);
		}
		else {
			if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TrackEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userlogId);

		if (eventType != null) {
			qPos.add(eventType);
		}

		if (className != null) {
			qPos.add(className);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the track events.
	 *
	 * @return the track events
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrackEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TrackEvent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<TrackEvent> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TrackEvent> list = (List<TrackEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRACKEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRACKEVENT.concat(TrackEventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TrackEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TrackEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the track events where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (TrackEvent trackEvent : findByCompanyId(companyId)) {
			remove(trackEvent);
		}
	}

	/**
	 * Removes all the track events where userlogId = &#63; from the database.
	 *
	 * @param userlogId the userlog ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserlogId(long userlogId) throws SystemException {
		for (TrackEvent trackEvent : findByUserlogId(userlogId)) {
			remove(trackEvent);
		}
	}

	/**
	 * Removes all the track events where userlogId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userlogId the userlog ID
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUId_Event(long userlogId, String eventType)
		throws SystemException {
		for (TrackEvent trackEvent : findByUId_Event(userlogId, eventType)) {
			remove(trackEvent);
		}
	}

	/**
	 * Removes all the track events where userlogId = &#63; and eventType = &#63; and className = &#63; from the database.
	 *
	 * @param userlogId the userlog ID
	 * @param eventType the event type
	 * @param className the class name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUId_Event_Class(long userlogId, String eventType,
		String className) throws SystemException {
		for (TrackEvent trackEvent : findByUId_Event_Class(userlogId,
				eventType, className)) {
			remove(trackEvent);
		}
	}

	/**
	 * Removes all the track events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TrackEvent trackEvent : findAll()) {
			remove(trackEvent);
		}
	}

	/**
	 * Returns the number of track events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching track events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of track events where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @return the number of matching track events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserlogId(long userlogId) throws SystemException {
		Object[] finderArgs = new Object[] { userlogId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERLOGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_USERLOGID_USERLOGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERLOGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of track events where userlogId = &#63; and eventType = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param eventType the event type
	 * @return the number of matching track events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUId_Event(long userlogId, String eventType)
		throws SystemException {
		Object[] finderArgs = new Object[] { userlogId, eventType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UID_EVENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_UID_EVENT_USERLOGID_2);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_UID_EVENT_EVENTTYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				if (eventType != null) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UID_EVENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByUId_Event_Class(long userlogId, String eventType,
		String className) throws SystemException {
		Object[] finderArgs = new Object[] { userlogId, eventType, className };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UID_EVENT_CLASS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TRACKEVENT_WHERE);

			query.append(_FINDER_COLUMN_UID_EVENT_CLASS_USERLOGID_2);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_2);
				}
			}

			if (className == null) {
				query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_1);
			}
			else {
				if (className.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				if (eventType != null) {
					qPos.add(eventType);
				}

				if (className != null) {
					qPos.add(className);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UID_EVENT_CLASS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of track events.
	 *
	 * @return the number of track events
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRACKEVENT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the track event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.TrackEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrackEvent>> listenersList = new ArrayList<ModelListener<TrackEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrackEvent>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TrackEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BrowserPersistence.class)
	protected BrowserPersistence browserPersistence;
	@BeanReference(type = BrowsinglogPersistence.class)
	protected BrowsinglogPersistence browsinglogPersistence;
	@BeanReference(type = FilelogPersistence.class)
	protected FilelogPersistence filelogPersistence;
	@BeanReference(type = OrganizationHitPersistence.class)
	protected OrganizationHitPersistence organizationHitPersistence;
	@BeanReference(type = OSPersistence.class)
	protected OSPersistence osPersistence;
	@BeanReference(type = PhrasePersistence.class)
	protected PhrasePersistence phrasePersistence;
	@BeanReference(type = PortletHitPersistence.class)
	protected PortletHitPersistence portletHitPersistence;
	@BeanReference(type = PortletPropertyPersistence.class)
	protected PortletPropertyPersistence portletPropertyPersistence;
	@BeanReference(type = SearchPhraseHitPersistence.class)
	protected SearchPhraseHitPersistence searchPhraseHitPersistence;
	@BeanReference(type = SearchWordHitPersistence.class)
	protected SearchWordHitPersistence searchWordHitPersistence;
	@BeanReference(type = SiteHitPersistence.class)
	protected SiteHitPersistence siteHitPersistence;
	@BeanReference(type = TrackEventPersistence.class)
	protected TrackEventPersistence trackEventPersistence;
	@BeanReference(type = UserlogPersistence.class)
	protected UserlogPersistence userlogPersistence;
	@BeanReference(type = WordPersistence.class)
	protected WordPersistence wordPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TRACKEVENT = "SELECT trackEvent FROM TrackEvent trackEvent";
	private static final String _SQL_SELECT_TRACKEVENT_WHERE = "SELECT trackEvent FROM TrackEvent trackEvent WHERE ";
	private static final String _SQL_COUNT_TRACKEVENT = "SELECT COUNT(trackEvent) FROM TrackEvent trackEvent";
	private static final String _SQL_COUNT_TRACKEVENT_WHERE = "SELECT COUNT(trackEvent) FROM TrackEvent trackEvent WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "trackEvent.companyId = ?";
	private static final String _FINDER_COLUMN_USERLOGID_USERLOGID_2 = "trackEvent.userlogId = ?";
	private static final String _FINDER_COLUMN_UID_EVENT_USERLOGID_2 = "trackEvent.userlogId = ? AND ";
	private static final String _FINDER_COLUMN_UID_EVENT_EVENTTYPE_1 = "trackEvent.eventType IS NULL";
	private static final String _FINDER_COLUMN_UID_EVENT_EVENTTYPE_2 = "trackEvent.eventType = ?";
	private static final String _FINDER_COLUMN_UID_EVENT_EVENTTYPE_3 = "(trackEvent.eventType IS NULL OR trackEvent.eventType = ?)";
	private static final String _FINDER_COLUMN_UID_EVENT_CLASS_USERLOGID_2 = "trackEvent.userlogId = ? AND ";
	private static final String _FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_1 = "trackEvent.eventType IS NULL AND ";
	private static final String _FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_2 = "trackEvent.eventType = ? AND ";
	private static final String _FINDER_COLUMN_UID_EVENT_CLASS_EVENTTYPE_3 = "(trackEvent.eventType IS NULL OR trackEvent.eventType = ?) AND ";
	private static final String _FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_1 = "trackEvent.className IS NULL";
	private static final String _FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_2 = "trackEvent.className = ?";
	private static final String _FINDER_COLUMN_UID_EVENT_CLASS_CLASSNAME_3 = "(trackEvent.className IS NULL OR trackEvent.className = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trackEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrackEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrackEvent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrackEventPersistenceImpl.class);
	private static TrackEvent _nullTrackEvent = new TrackEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrackEvent> toCacheModel() {
				return _nullTrackEventCacheModel;
			}
		};

	private static CacheModel<TrackEvent> _nullTrackEventCacheModel = new CacheModel<TrackEvent>() {
			public TrackEvent toEntityModel() {
				return _nullTrackEvent;
			}
		};
}