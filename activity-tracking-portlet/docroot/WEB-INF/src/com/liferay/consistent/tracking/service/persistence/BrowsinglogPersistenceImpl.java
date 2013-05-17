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

import com.liferay.consistent.tracking.NoSuchBrowsinglogException;
import com.liferay.consistent.tracking.model.Browsinglog;
import com.liferay.consistent.tracking.model.impl.BrowsinglogImpl;
import com.liferay.consistent.tracking.model.impl.BrowsinglogModelImpl;

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
 * The persistence implementation for the browsinglog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see BrowsinglogPersistence
 * @see BrowsinglogUtil
 * @generated
 */
public class BrowsinglogPersistenceImpl extends BasePersistenceImpl<Browsinglog>
	implements BrowsinglogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BrowsinglogUtil} to access the browsinglog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BrowsinglogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, BrowsinglogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, BrowsinglogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			BrowsinglogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERLOGID =
		new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, BrowsinglogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserlogId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID =
		new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, BrowsinglogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserlogId",
			new String[] { Long.class.getName() },
			BrowsinglogModelImpl.USERLOGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERLOGID = new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserlogId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, BrowsinglogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, BrowsinglogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the browsinglog in the entity cache if it is enabled.
	 *
	 * @param browsinglog the browsinglog
	 */
	public void cacheResult(Browsinglog browsinglog) {
		EntityCacheUtil.putResult(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogImpl.class, browsinglog.getPrimaryKey(), browsinglog);

		browsinglog.resetOriginalValues();
	}

	/**
	 * Caches the browsinglogs in the entity cache if it is enabled.
	 *
	 * @param browsinglogs the browsinglogs
	 */
	public void cacheResult(List<Browsinglog> browsinglogs) {
		for (Browsinglog browsinglog : browsinglogs) {
			if (EntityCacheUtil.getResult(
						BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
						BrowsinglogImpl.class, browsinglog.getPrimaryKey()) == null) {
				cacheResult(browsinglog);
			}
			else {
				browsinglog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all browsinglogs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BrowsinglogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BrowsinglogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the browsinglog.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Browsinglog browsinglog) {
		EntityCacheUtil.removeResult(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogImpl.class, browsinglog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Browsinglog> browsinglogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Browsinglog browsinglog : browsinglogs) {
			EntityCacheUtil.removeResult(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
				BrowsinglogImpl.class, browsinglog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new browsinglog with the primary key. Does not add the browsinglog to the database.
	 *
	 * @param browsinglogId the primary key for the new browsinglog
	 * @return the new browsinglog
	 */
	public Browsinglog create(long browsinglogId) {
		Browsinglog browsinglog = new BrowsinglogImpl();

		browsinglog.setNew(true);
		browsinglog.setPrimaryKey(browsinglogId);

		return browsinglog;
	}

	/**
	 * Removes the browsinglog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param browsinglogId the primary key of the browsinglog
	 * @return the browsinglog that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog remove(long browsinglogId)
		throws NoSuchBrowsinglogException, SystemException {
		return remove(Long.valueOf(browsinglogId));
	}

	/**
	 * Removes the browsinglog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the browsinglog
	 * @return the browsinglog that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Browsinglog remove(Serializable primaryKey)
		throws NoSuchBrowsinglogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Browsinglog browsinglog = (Browsinglog)session.get(BrowsinglogImpl.class,
					primaryKey);

			if (browsinglog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrowsinglogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(browsinglog);
		}
		catch (NoSuchBrowsinglogException nsee) {
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
	protected Browsinglog removeImpl(Browsinglog browsinglog)
		throws SystemException {
		browsinglog = toUnwrappedModel(browsinglog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, browsinglog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(browsinglog);

		return browsinglog;
	}

	@Override
	public Browsinglog updateImpl(
		com.liferay.consistent.tracking.model.Browsinglog browsinglog,
		boolean merge) throws SystemException {
		browsinglog = toUnwrappedModel(browsinglog);

		boolean isNew = browsinglog.isNew();

		BrowsinglogModelImpl browsinglogModelImpl = (BrowsinglogModelImpl)browsinglog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, browsinglog, merge);

			browsinglog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BrowsinglogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((browsinglogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(browsinglogModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(browsinglogModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((browsinglogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(browsinglogModelImpl.getOriginalUserlogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID,
					args);

				args = new Object[] {
						Long.valueOf(browsinglogModelImpl.getUserlogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID,
					args);
			}
		}

		EntityCacheUtil.putResult(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
			BrowsinglogImpl.class, browsinglog.getPrimaryKey(), browsinglog);

		return browsinglog;
	}

	protected Browsinglog toUnwrappedModel(Browsinglog browsinglog) {
		if (browsinglog instanceof BrowsinglogImpl) {
			return browsinglog;
		}

		BrowsinglogImpl browsinglogImpl = new BrowsinglogImpl();

		browsinglogImpl.setNew(browsinglog.isNew());
		browsinglogImpl.setPrimaryKey(browsinglog.getPrimaryKey());

		browsinglogImpl.setBrowsinglogId(browsinglog.getBrowsinglogId());
		browsinglogImpl.setCompanyId(browsinglog.getCompanyId());
		browsinglogImpl.setUserlogId(browsinglog.getUserlogId());
		browsinglogImpl.setUserAgent(browsinglog.getUserAgent());
		browsinglogImpl.setUrl(browsinglog.getUrl());
		browsinglogImpl.setPlId(browsinglog.getPlId());
		browsinglogImpl.setAccessName(browsinglog.getAccessName());
		browsinglogImpl.setAccessFound(browsinglog.isAccessFound());
		browsinglogImpl.setAccessDate(browsinglog.getAccessDate());
		browsinglogImpl.setElapseLoad(browsinglog.getElapseLoad());
		browsinglogImpl.setUploadSize(browsinglog.getUploadSize());
		browsinglogImpl.setDownloadSize(browsinglog.getDownloadSize());

		return browsinglogImpl;
	}

	/**
	 * Returns the browsinglog with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the browsinglog
	 * @return the browsinglog
	 * @throws com.liferay.portal.NoSuchModelException if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Browsinglog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the browsinglog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchBrowsinglogException} if it could not be found.
	 *
	 * @param browsinglogId the primary key of the browsinglog
	 * @return the browsinglog
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog findByPrimaryKey(long browsinglogId)
		throws NoSuchBrowsinglogException, SystemException {
		Browsinglog browsinglog = fetchByPrimaryKey(browsinglogId);

		if (browsinglog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + browsinglogId);
			}

			throw new NoSuchBrowsinglogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				browsinglogId);
		}

		return browsinglog;
	}

	/**
	 * Returns the browsinglog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the browsinglog
	 * @return the browsinglog, or <code>null</code> if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Browsinglog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the browsinglog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param browsinglogId the primary key of the browsinglog
	 * @return the browsinglog, or <code>null</code> if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog fetchByPrimaryKey(long browsinglogId)
		throws SystemException {
		Browsinglog browsinglog = (Browsinglog)EntityCacheUtil.getResult(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
				BrowsinglogImpl.class, browsinglogId);

		if (browsinglog == _nullBrowsinglog) {
			return null;
		}

		if (browsinglog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				browsinglog = (Browsinglog)session.get(BrowsinglogImpl.class,
						Long.valueOf(browsinglogId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (browsinglog != null) {
					cacheResult(browsinglog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BrowsinglogModelImpl.ENTITY_CACHE_ENABLED,
						BrowsinglogImpl.class, browsinglogId, _nullBrowsinglog);
				}

				closeSession(session);
			}
		}

		return browsinglog;
	}

	/**
	 * Returns all the browsinglogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the browsinglogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of browsinglogs
	 * @param end the upper bound of the range of browsinglogs (not inclusive)
	 * @return the range of matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the browsinglogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of browsinglogs
	 * @param end the upper bound of the range of browsinglogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<Browsinglog> list = (List<Browsinglog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Browsinglog browsinglog : list) {
				if ((companyId != browsinglog.getCompanyId())) {
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

			query.append(_SQL_SELECT_BROWSINGLOG_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BrowsinglogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Browsinglog>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first browsinglog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browsinglog
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBrowsinglogException, SystemException {
		Browsinglog browsinglog = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (browsinglog != null) {
			return browsinglog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrowsinglogException(msg.toString());
	}

	/**
	 * Returns the first browsinglog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Browsinglog> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last browsinglog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browsinglog
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBrowsinglogException, SystemException {
		Browsinglog browsinglog = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (browsinglog != null) {
			return browsinglog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrowsinglogException(msg.toString());
	}

	/**
	 * Returns the last browsinglog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<Browsinglog> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the browsinglogs before and after the current browsinglog in the ordered set where companyId = &#63;.
	 *
	 * @param browsinglogId the primary key of the current browsinglog
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next browsinglog
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog[] findByCompanyId_PrevAndNext(long browsinglogId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchBrowsinglogException, SystemException {
		Browsinglog browsinglog = findByPrimaryKey(browsinglogId);

		Session session = null;

		try {
			session = openSession();

			Browsinglog[] array = new BrowsinglogImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, browsinglog,
					companyId, orderByComparator, true);

			array[1] = browsinglog;

			array[2] = getByCompanyId_PrevAndNext(session, browsinglog,
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

	protected Browsinglog getByCompanyId_PrevAndNext(Session session,
		Browsinglog browsinglog, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BROWSINGLOG_WHERE);

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
			query.append(BrowsinglogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(browsinglog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Browsinglog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the browsinglogs where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @return the matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findByUserlogId(long userlogId)
		throws SystemException {
		return findByUserlogId(userlogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the browsinglogs where userlogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userlogId the userlog ID
	 * @param start the lower bound of the range of browsinglogs
	 * @param end the upper bound of the range of browsinglogs (not inclusive)
	 * @return the range of matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findByUserlogId(long userlogId, int start, int end)
		throws SystemException {
		return findByUserlogId(userlogId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the browsinglogs where userlogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userlogId the userlog ID
	 * @param start the lower bound of the range of browsinglogs
	 * @param end the upper bound of the range of browsinglogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findByUserlogId(long userlogId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<Browsinglog> list = (List<Browsinglog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Browsinglog browsinglog : list) {
				if ((userlogId != browsinglog.getUserlogId())) {
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

			query.append(_SQL_SELECT_BROWSINGLOG_WHERE);

			query.append(_FINDER_COLUMN_USERLOGID_USERLOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BrowsinglogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				list = (List<Browsinglog>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first browsinglog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browsinglog
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog findByUserlogId_First(long userlogId,
		OrderByComparator orderByComparator)
		throws NoSuchBrowsinglogException, SystemException {
		Browsinglog browsinglog = fetchByUserlogId_First(userlogId,
				orderByComparator);

		if (browsinglog != null) {
			return browsinglog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrowsinglogException(msg.toString());
	}

	/**
	 * Returns the first browsinglog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog fetchByUserlogId_First(long userlogId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Browsinglog> list = findByUserlogId(userlogId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last browsinglog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browsinglog
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog findByUserlogId_Last(long userlogId,
		OrderByComparator orderByComparator)
		throws NoSuchBrowsinglogException, SystemException {
		Browsinglog browsinglog = fetchByUserlogId_Last(userlogId,
				orderByComparator);

		if (browsinglog != null) {
			return browsinglog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrowsinglogException(msg.toString());
	}

	/**
	 * Returns the last browsinglog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browsinglog, or <code>null</code> if a matching browsinglog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog fetchByUserlogId_Last(long userlogId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserlogId(userlogId);

		List<Browsinglog> list = findByUserlogId(userlogId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the browsinglogs before and after the current browsinglog in the ordered set where userlogId = &#63;.
	 *
	 * @param browsinglogId the primary key of the current browsinglog
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next browsinglog
	 * @throws com.liferay.consistent.tracking.NoSuchBrowsinglogException if a browsinglog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browsinglog[] findByUserlogId_PrevAndNext(long browsinglogId,
		long userlogId, OrderByComparator orderByComparator)
		throws NoSuchBrowsinglogException, SystemException {
		Browsinglog browsinglog = findByPrimaryKey(browsinglogId);

		Session session = null;

		try {
			session = openSession();

			Browsinglog[] array = new BrowsinglogImpl[3];

			array[0] = getByUserlogId_PrevAndNext(session, browsinglog,
					userlogId, orderByComparator, true);

			array[1] = browsinglog;

			array[2] = getByUserlogId_PrevAndNext(session, browsinglog,
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

	protected Browsinglog getByUserlogId_PrevAndNext(Session session,
		Browsinglog browsinglog, long userlogId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BROWSINGLOG_WHERE);

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
			query.append(BrowsinglogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userlogId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(browsinglog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Browsinglog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the browsinglogs.
	 *
	 * @return the browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the browsinglogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of browsinglogs
	 * @param end the upper bound of the range of browsinglogs (not inclusive)
	 * @return the range of browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the browsinglogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of browsinglogs
	 * @param end the upper bound of the range of browsinglogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browsinglog> findAll(int start, int end,
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

		List<Browsinglog> list = (List<Browsinglog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BROWSINGLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BROWSINGLOG.concat(BrowsinglogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Browsinglog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Browsinglog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the browsinglogs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Browsinglog browsinglog : findByCompanyId(companyId)) {
			remove(browsinglog);
		}
	}

	/**
	 * Removes all the browsinglogs where userlogId = &#63; from the database.
	 *
	 * @param userlogId the userlog ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserlogId(long userlogId) throws SystemException {
		for (Browsinglog browsinglog : findByUserlogId(userlogId)) {
			remove(browsinglog);
		}
	}

	/**
	 * Removes all the browsinglogs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Browsinglog browsinglog : findAll()) {
			remove(browsinglog);
		}
	}

	/**
	 * Returns the number of browsinglogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BROWSINGLOG_WHERE);

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
	 * Returns the number of browsinglogs where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @return the number of matching browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserlogId(long userlogId) throws SystemException {
		Object[] finderArgs = new Object[] { userlogId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERLOGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BROWSINGLOG_WHERE);

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
	 * Returns the number of browsinglogs.
	 *
	 * @return the number of browsinglogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BROWSINGLOG);

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
	 * Initializes the browsinglog persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.Browsinglog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Browsinglog>> listenersList = new ArrayList<ModelListener<Browsinglog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Browsinglog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BrowsinglogImpl.class.getName());
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
	private static final String _SQL_SELECT_BROWSINGLOG = "SELECT browsinglog FROM Browsinglog browsinglog";
	private static final String _SQL_SELECT_BROWSINGLOG_WHERE = "SELECT browsinglog FROM Browsinglog browsinglog WHERE ";
	private static final String _SQL_COUNT_BROWSINGLOG = "SELECT COUNT(browsinglog) FROM Browsinglog browsinglog";
	private static final String _SQL_COUNT_BROWSINGLOG_WHERE = "SELECT COUNT(browsinglog) FROM Browsinglog browsinglog WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "browsinglog.companyId = ?";
	private static final String _FINDER_COLUMN_USERLOGID_USERLOGID_2 = "browsinglog.userlogId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "browsinglog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Browsinglog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Browsinglog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BrowsinglogPersistenceImpl.class);
	private static Browsinglog _nullBrowsinglog = new BrowsinglogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Browsinglog> toCacheModel() {
				return _nullBrowsinglogCacheModel;
			}
		};

	private static CacheModel<Browsinglog> _nullBrowsinglogCacheModel = new CacheModel<Browsinglog>() {
			public Browsinglog toEntityModel() {
				return _nullBrowsinglog;
			}
		};
}