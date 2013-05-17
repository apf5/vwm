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

import com.liferay.consistent.tracking.NoSuchSearchWordHitException;
import com.liferay.consistent.tracking.model.SearchWordHit;
import com.liferay.consistent.tracking.model.impl.SearchWordHitImpl;
import com.liferay.consistent.tracking.model.impl.SearchWordHitModelImpl;

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
 * The persistence implementation for the search word hit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SearchWordHitPersistence
 * @see SearchWordHitUtil
 * @generated
 */
public class SearchWordHitPersistenceImpl extends BasePersistenceImpl<SearchWordHit>
	implements SearchWordHitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SearchWordHitUtil} to access the search word hit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SearchWordHitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			SearchWordHitModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SearchWordHitModelImpl.COMPANYID_COLUMN_BITMASK |
			SearchWordHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_W_G = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_W_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_W_G = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_W_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			SearchWordHitModelImpl.COMPANYID_COLUMN_BITMASK |
			SearchWordHitModelImpl.WORDID_COLUMN_BITMASK |
			SearchWordHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_W_G = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_W_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED,
			SearchWordHitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the search word hit in the entity cache if it is enabled.
	 *
	 * @param searchWordHit the search word hit
	 */
	public void cacheResult(SearchWordHit searchWordHit) {
		EntityCacheUtil.putResult(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitImpl.class, searchWordHit.getPrimaryKey(),
			searchWordHit);

		searchWordHit.resetOriginalValues();
	}

	/**
	 * Caches the search word hits in the entity cache if it is enabled.
	 *
	 * @param searchWordHits the search word hits
	 */
	public void cacheResult(List<SearchWordHit> searchWordHits) {
		for (SearchWordHit searchWordHit : searchWordHits) {
			if (EntityCacheUtil.getResult(
						SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
						SearchWordHitImpl.class, searchWordHit.getPrimaryKey()) == null) {
				cacheResult(searchWordHit);
			}
			else {
				searchWordHit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all search word hits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SearchWordHitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SearchWordHitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the search word hit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SearchWordHit searchWordHit) {
		EntityCacheUtil.removeResult(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitImpl.class, searchWordHit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SearchWordHit> searchWordHits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SearchWordHit searchWordHit : searchWordHits) {
			EntityCacheUtil.removeResult(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
				SearchWordHitImpl.class, searchWordHit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new search word hit with the primary key. Does not add the search word hit to the database.
	 *
	 * @param hitId the primary key for the new search word hit
	 * @return the new search word hit
	 */
	public SearchWordHit create(long hitId) {
		SearchWordHit searchWordHit = new SearchWordHitImpl();

		searchWordHit.setNew(true);
		searchWordHit.setPrimaryKey(hitId);

		return searchWordHit;
	}

	/**
	 * Removes the search word hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hitId the primary key of the search word hit
	 * @return the search word hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit remove(long hitId)
		throws NoSuchSearchWordHitException, SystemException {
		return remove(Long.valueOf(hitId));
	}

	/**
	 * Removes the search word hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the search word hit
	 * @return the search word hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchWordHit remove(Serializable primaryKey)
		throws NoSuchSearchWordHitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SearchWordHit searchWordHit = (SearchWordHit)session.get(SearchWordHitImpl.class,
					primaryKey);

			if (searchWordHit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSearchWordHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(searchWordHit);
		}
		catch (NoSuchSearchWordHitException nsee) {
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
	protected SearchWordHit removeImpl(SearchWordHit searchWordHit)
		throws SystemException {
		searchWordHit = toUnwrappedModel(searchWordHit);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, searchWordHit);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(searchWordHit);

		return searchWordHit;
	}

	@Override
	public SearchWordHit updateImpl(
		com.liferay.consistent.tracking.model.SearchWordHit searchWordHit,
		boolean merge) throws SystemException {
		searchWordHit = toUnwrappedModel(searchWordHit);

		boolean isNew = searchWordHit.isNew();

		SearchWordHitModelImpl searchWordHitModelImpl = (SearchWordHitModelImpl)searchWordHit;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, searchWordHit, merge);

			searchWordHit.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SearchWordHitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((searchWordHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(searchWordHitModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(searchWordHitModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((searchWordHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(searchWordHitModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(searchWordHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(searchWordHitModelImpl.getCompanyId()),
						Boolean.valueOf(searchWordHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((searchWordHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_W_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(searchWordHitModelImpl.getOriginalCompanyId()),
						Long.valueOf(searchWordHitModelImpl.getOriginalWordId()),
						Boolean.valueOf(searchWordHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_W_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_W_G,
					args);

				args = new Object[] {
						Long.valueOf(searchWordHitModelImpl.getCompanyId()),
						Long.valueOf(searchWordHitModelImpl.getWordId()),
						Boolean.valueOf(searchWordHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_W_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_W_G,
					args);
			}
		}

		EntityCacheUtil.putResult(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchWordHitImpl.class, searchWordHit.getPrimaryKey(),
			searchWordHit);

		return searchWordHit;
	}

	protected SearchWordHit toUnwrappedModel(SearchWordHit searchWordHit) {
		if (searchWordHit instanceof SearchWordHitImpl) {
			return searchWordHit;
		}

		SearchWordHitImpl searchWordHitImpl = new SearchWordHitImpl();

		searchWordHitImpl.setNew(searchWordHit.isNew());
		searchWordHitImpl.setPrimaryKey(searchWordHit.getPrimaryKey());

		searchWordHitImpl.setHitId(searchWordHit.getHitId());
		searchWordHitImpl.setCompanyId(searchWordHit.getCompanyId());
		searchWordHitImpl.setWordId(searchWordHit.getWordId());
		searchWordHitImpl.setGuest(searchWordHit.isGuest());
		searchWordHitImpl.setAccessDate(searchWordHit.getAccessDate());

		return searchWordHitImpl;
	}

	/**
	 * Returns the search word hit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the search word hit
	 * @return the search word hit
	 * @throws com.liferay.portal.NoSuchModelException if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchWordHit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the search word hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchSearchWordHitException} if it could not be found.
	 *
	 * @param hitId the primary key of the search word hit
	 * @return the search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit findByPrimaryKey(long hitId)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = fetchByPrimaryKey(hitId);

		if (searchWordHit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hitId);
			}

			throw new NoSuchSearchWordHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				hitId);
		}

		return searchWordHit;
	}

	/**
	 * Returns the search word hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the search word hit
	 * @return the search word hit, or <code>null</code> if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchWordHit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the search word hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hitId the primary key of the search word hit
	 * @return the search word hit, or <code>null</code> if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit fetchByPrimaryKey(long hitId)
		throws SystemException {
		SearchWordHit searchWordHit = (SearchWordHit)EntityCacheUtil.getResult(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
				SearchWordHitImpl.class, hitId);

		if (searchWordHit == _nullSearchWordHit) {
			return null;
		}

		if (searchWordHit == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				searchWordHit = (SearchWordHit)session.get(SearchWordHitImpl.class,
						Long.valueOf(hitId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (searchWordHit != null) {
					cacheResult(searchWordHit);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SearchWordHitModelImpl.ENTITY_CACHE_ENABLED,
						SearchWordHitImpl.class, hitId, _nullSearchWordHit);
				}

				closeSession(session);
			}
		}

		return searchWordHit;
	}

	/**
	 * Returns all the search word hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the search word hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @return the range of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search word hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByCompanyId(long companyId, int start,
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

		List<SearchWordHit> list = (List<SearchWordHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchWordHit searchWordHit : list) {
				if ((companyId != searchWordHit.getCompanyId())) {
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

			query.append(_SQL_SELECT_SEARCHWORDHIT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SearchWordHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<SearchWordHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search word hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (searchWordHit != null) {
			return searchWordHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchWordHitException(msg.toString());
	}

	/**
	 * Returns the first search word hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search word hit, or <code>null</code> if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchWordHit> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search word hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (searchWordHit != null) {
			return searchWordHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchWordHitException(msg.toString());
	}

	/**
	 * Returns the last search word hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search word hit, or <code>null</code> if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<SearchWordHit> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search word hits before and after the current search word hit in the ordered set where companyId = &#63;.
	 *
	 * @param hitId the primary key of the current search word hit
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit[] findByCompanyId_PrevAndNext(long hitId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SearchWordHit[] array = new SearchWordHitImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, searchWordHit,
					companyId, orderByComparator, true);

			array[1] = searchWordHit;

			array[2] = getByCompanyId_PrevAndNext(session, searchWordHit,
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

	protected SearchWordHit getByCompanyId_PrevAndNext(Session session,
		SearchWordHit searchWordHit, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHWORDHIT_WHERE);

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
			query.append(SearchWordHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchWordHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchWordHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search word hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByC_G(long companyId, boolean guest)
		throws SystemException {
		return findByC_G(companyId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search word hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @return the range of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByC_G(long companyId, boolean guest,
		int start, int end) throws SystemException {
		return findByC_G(companyId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search word hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByC_G(long companyId, boolean guest,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, guest };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, guest,
					
					start, end, orderByComparator
				};
		}

		List<SearchWordHit> list = (List<SearchWordHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchWordHit searchWordHit : list) {
				if ((companyId != searchWordHit.getCompanyId()) ||
						(guest != searchWordHit.getGuest())) {
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

			query.append(_SQL_SELECT_SEARCHWORDHIT_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SearchWordHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(guest);

				list = (List<SearchWordHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search word hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit findByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = fetchByC_G_First(companyId, guest,
				orderByComparator);

		if (searchWordHit != null) {
			return searchWordHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchWordHitException(msg.toString());
	}

	/**
	 * Returns the first search word hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search word hit, or <code>null</code> if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit fetchByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchWordHit> list = findByC_G(companyId, guest, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search word hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit findByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = fetchByC_G_Last(companyId, guest,
				orderByComparator);

		if (searchWordHit != null) {
			return searchWordHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchWordHitException(msg.toString());
	}

	/**
	 * Returns the last search word hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search word hit, or <code>null</code> if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit fetchByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, guest);

		List<SearchWordHit> list = findByC_G(companyId, guest, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search word hits before and after the current search word hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current search word hit
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit[] findByC_G_PrevAndNext(long hitId, long companyId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SearchWordHit[] array = new SearchWordHitImpl[3];

			array[0] = getByC_G_PrevAndNext(session, searchWordHit, companyId,
					guest, orderByComparator, true);

			array[1] = searchWordHit;

			array[2] = getByC_G_PrevAndNext(session, searchWordHit, companyId,
					guest, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchWordHit getByC_G_PrevAndNext(Session session,
		SearchWordHit searchWordHit, long companyId, boolean guest,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHWORDHIT_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GUEST_2);

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
			query.append(SearchWordHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchWordHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchWordHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search word hits where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @return the matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByC_W_G(long companyId, long wordId,
		boolean guest) throws SystemException {
		return findByC_W_G(companyId, wordId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search word hits where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @return the range of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByC_W_G(long companyId, long wordId,
		boolean guest, int start, int end) throws SystemException {
		return findByC_W_G(companyId, wordId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search word hits where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findByC_W_G(long companyId, long wordId,
		boolean guest, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_W_G;
			finderArgs = new Object[] { companyId, wordId, guest };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_W_G;
			finderArgs = new Object[] {
					companyId, wordId, guest,
					
					start, end, orderByComparator
				};
		}

		List<SearchWordHit> list = (List<SearchWordHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchWordHit searchWordHit : list) {
				if ((companyId != searchWordHit.getCompanyId()) ||
						(wordId != searchWordHit.getWordId()) ||
						(guest != searchWordHit.getGuest())) {
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

			query.append(_SQL_SELECT_SEARCHWORDHIT_WHERE);

			query.append(_FINDER_COLUMN_C_W_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_W_G_WORDID_2);

			query.append(_FINDER_COLUMN_C_W_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SearchWordHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(wordId);

				qPos.add(guest);

				list = (List<SearchWordHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search word hit in the ordered set where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit findByC_W_G_First(long companyId, long wordId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = fetchByC_W_G_First(companyId, wordId,
				guest, orderByComparator);

		if (searchWordHit != null) {
			return searchWordHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", wordId=");
		msg.append(wordId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchWordHitException(msg.toString());
	}

	/**
	 * Returns the first search word hit in the ordered set where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search word hit, or <code>null</code> if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit fetchByC_W_G_First(long companyId, long wordId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchWordHit> list = findByC_W_G(companyId, wordId, guest, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search word hit in the ordered set where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit findByC_W_G_Last(long companyId, long wordId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = fetchByC_W_G_Last(companyId, wordId,
				guest, orderByComparator);

		if (searchWordHit != null) {
			return searchWordHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", wordId=");
		msg.append(wordId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchWordHitException(msg.toString());
	}

	/**
	 * Returns the last search word hit in the ordered set where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search word hit, or <code>null</code> if a matching search word hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit fetchByC_W_G_Last(long companyId, long wordId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_W_G(companyId, wordId, guest);

		List<SearchWordHit> list = findByC_W_G(companyId, wordId, guest,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search word hits before and after the current search word hit in the ordered set where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current search word hit
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search word hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchWordHitException if a search word hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchWordHit[] findByC_W_G_PrevAndNext(long hitId, long companyId,
		long wordId, boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSearchWordHitException, SystemException {
		SearchWordHit searchWordHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SearchWordHit[] array = new SearchWordHitImpl[3];

			array[0] = getByC_W_G_PrevAndNext(session, searchWordHit,
					companyId, wordId, guest, orderByComparator, true);

			array[1] = searchWordHit;

			array[2] = getByC_W_G_PrevAndNext(session, searchWordHit,
					companyId, wordId, guest, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchWordHit getByC_W_G_PrevAndNext(Session session,
		SearchWordHit searchWordHit, long companyId, long wordId,
		boolean guest, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHWORDHIT_WHERE);

		query.append(_FINDER_COLUMN_C_W_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_W_G_WORDID_2);

		query.append(_FINDER_COLUMN_C_W_G_GUEST_2);

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
			query.append(SearchWordHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(wordId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchWordHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchWordHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search word hits.
	 *
	 * @return the search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search word hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @return the range of search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the search word hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of search word hits
	 * @param end the upper bound of the range of search word hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchWordHit> findAll(int start, int end,
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

		List<SearchWordHit> list = (List<SearchWordHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEARCHWORDHIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEARCHWORDHIT.concat(SearchWordHitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SearchWordHit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SearchWordHit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the search word hits where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (SearchWordHit searchWordHit : findByCompanyId(companyId)) {
			remove(searchWordHit);
		}
	}

	/**
	 * Removes all the search word hits where companyId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, boolean guest)
		throws SystemException {
		for (SearchWordHit searchWordHit : findByC_G(companyId, guest)) {
			remove(searchWordHit);
		}
	}

	/**
	 * Removes all the search word hits where companyId = &#63; and wordId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_W_G(long companyId, long wordId, boolean guest)
		throws SystemException {
		for (SearchWordHit searchWordHit : findByC_W_G(companyId, wordId, guest)) {
			remove(searchWordHit);
		}
	}

	/**
	 * Removes all the search word hits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SearchWordHit searchWordHit : findAll()) {
			remove(searchWordHit);
		}
	}

	/**
	 * Returns the number of search word hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHWORDHIT_WHERE);

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
	 * Returns the number of search word hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the number of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEARCHWORDHIT_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GUEST_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(guest);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of search word hits where companyId = &#63; and wordId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param wordId the word ID
	 * @param guest the guest
	 * @return the number of matching search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_W_G(long companyId, long wordId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, wordId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_W_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SEARCHWORDHIT_WHERE);

			query.append(_FINDER_COLUMN_C_W_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_W_G_WORDID_2);

			query.append(_FINDER_COLUMN_C_W_G_GUEST_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(wordId);

				qPos.add(guest);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_W_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of search word hits.
	 *
	 * @return the number of search word hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEARCHWORDHIT);

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
	 * Initializes the search word hit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.SearchWordHit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SearchWordHit>> listenersList = new ArrayList<ModelListener<SearchWordHit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SearchWordHit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SearchWordHitImpl.class.getName());
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
	private static final String _SQL_SELECT_SEARCHWORDHIT = "SELECT searchWordHit FROM SearchWordHit searchWordHit";
	private static final String _SQL_SELECT_SEARCHWORDHIT_WHERE = "SELECT searchWordHit FROM SearchWordHit searchWordHit WHERE ";
	private static final String _SQL_COUNT_SEARCHWORDHIT = "SELECT COUNT(searchWordHit) FROM SearchWordHit searchWordHit";
	private static final String _SQL_COUNT_SEARCHWORDHIT_WHERE = "SELECT COUNT(searchWordHit) FROM SearchWordHit searchWordHit WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "searchWordHit.companyId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "searchWordHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GUEST_2 = "searchWordHit.guest = ?";
	private static final String _FINDER_COLUMN_C_W_G_COMPANYID_2 = "searchWordHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_W_G_WORDID_2 = "searchWordHit.wordId = ? AND ";
	private static final String _FINDER_COLUMN_C_W_G_GUEST_2 = "searchWordHit.guest = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "searchWordHit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SearchWordHit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SearchWordHit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SearchWordHitPersistenceImpl.class);
	private static SearchWordHit _nullSearchWordHit = new SearchWordHitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SearchWordHit> toCacheModel() {
				return _nullSearchWordHitCacheModel;
			}
		};

	private static CacheModel<SearchWordHit> _nullSearchWordHitCacheModel = new CacheModel<SearchWordHit>() {
			public SearchWordHit toEntityModel() {
				return _nullSearchWordHit;
			}
		};
}