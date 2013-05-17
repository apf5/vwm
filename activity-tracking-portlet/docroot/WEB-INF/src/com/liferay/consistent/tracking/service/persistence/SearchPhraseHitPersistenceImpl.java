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

import com.liferay.consistent.tracking.NoSuchSearchPhraseHitException;
import com.liferay.consistent.tracking.model.SearchPhraseHit;
import com.liferay.consistent.tracking.model.impl.SearchPhraseHitImpl;
import com.liferay.consistent.tracking.model.impl.SearchPhraseHitModelImpl;

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
 * The persistence implementation for the search phrase hit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SearchPhraseHitPersistence
 * @see SearchPhraseHitUtil
 * @generated
 */
public class SearchPhraseHitPersistenceImpl extends BasePersistenceImpl<SearchPhraseHit>
	implements SearchPhraseHitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SearchPhraseHitUtil} to access the search phrase hit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SearchPhraseHitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			SearchPhraseHitModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SearchPhraseHitModelImpl.COMPANYID_COLUMN_BITMASK |
			SearchPhraseHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P_G = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_P_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_P_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			SearchPhraseHitModelImpl.COMPANYID_COLUMN_BITMASK |
			SearchPhraseHitModelImpl.PHRASEID_COLUMN_BITMASK |
			SearchPhraseHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_P_G = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED,
			SearchPhraseHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the search phrase hit in the entity cache if it is enabled.
	 *
	 * @param searchPhraseHit the search phrase hit
	 */
	public void cacheResult(SearchPhraseHit searchPhraseHit) {
		EntityCacheUtil.putResult(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitImpl.class, searchPhraseHit.getPrimaryKey(),
			searchPhraseHit);

		searchPhraseHit.resetOriginalValues();
	}

	/**
	 * Caches the search phrase hits in the entity cache if it is enabled.
	 *
	 * @param searchPhraseHits the search phrase hits
	 */
	public void cacheResult(List<SearchPhraseHit> searchPhraseHits) {
		for (SearchPhraseHit searchPhraseHit : searchPhraseHits) {
			if (EntityCacheUtil.getResult(
						SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
						SearchPhraseHitImpl.class,
						searchPhraseHit.getPrimaryKey()) == null) {
				cacheResult(searchPhraseHit);
			}
			else {
				searchPhraseHit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all search phrase hits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SearchPhraseHitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SearchPhraseHitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the search phrase hit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SearchPhraseHit searchPhraseHit) {
		EntityCacheUtil.removeResult(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitImpl.class, searchPhraseHit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SearchPhraseHit> searchPhraseHits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SearchPhraseHit searchPhraseHit : searchPhraseHits) {
			EntityCacheUtil.removeResult(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
				SearchPhraseHitImpl.class, searchPhraseHit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new search phrase hit with the primary key. Does not add the search phrase hit to the database.
	 *
	 * @param hitId the primary key for the new search phrase hit
	 * @return the new search phrase hit
	 */
	public SearchPhraseHit create(long hitId) {
		SearchPhraseHit searchPhraseHit = new SearchPhraseHitImpl();

		searchPhraseHit.setNew(true);
		searchPhraseHit.setPrimaryKey(hitId);

		return searchPhraseHit;
	}

	/**
	 * Removes the search phrase hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hitId the primary key of the search phrase hit
	 * @return the search phrase hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit remove(long hitId)
		throws NoSuchSearchPhraseHitException, SystemException {
		return remove(Long.valueOf(hitId));
	}

	/**
	 * Removes the search phrase hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the search phrase hit
	 * @return the search phrase hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchPhraseHit remove(Serializable primaryKey)
		throws NoSuchSearchPhraseHitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SearchPhraseHit searchPhraseHit = (SearchPhraseHit)session.get(SearchPhraseHitImpl.class,
					primaryKey);

			if (searchPhraseHit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSearchPhraseHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(searchPhraseHit);
		}
		catch (NoSuchSearchPhraseHitException nsee) {
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
	protected SearchPhraseHit removeImpl(SearchPhraseHit searchPhraseHit)
		throws SystemException {
		searchPhraseHit = toUnwrappedModel(searchPhraseHit);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, searchPhraseHit);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(searchPhraseHit);

		return searchPhraseHit;
	}

	@Override
	public SearchPhraseHit updateImpl(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit,
		boolean merge) throws SystemException {
		searchPhraseHit = toUnwrappedModel(searchPhraseHit);

		boolean isNew = searchPhraseHit.isNew();

		SearchPhraseHitModelImpl searchPhraseHitModelImpl = (SearchPhraseHitModelImpl)searchPhraseHit;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, searchPhraseHit, merge);

			searchPhraseHit.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SearchPhraseHitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((searchPhraseHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(searchPhraseHitModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(searchPhraseHitModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((searchPhraseHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(searchPhraseHitModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(searchPhraseHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(searchPhraseHitModelImpl.getCompanyId()),
						Boolean.valueOf(searchPhraseHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((searchPhraseHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(searchPhraseHitModelImpl.getOriginalCompanyId()),
						Long.valueOf(searchPhraseHitModelImpl.getOriginalPhraseId()),
						Boolean.valueOf(searchPhraseHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G,
					args);

				args = new Object[] {
						Long.valueOf(searchPhraseHitModelImpl.getCompanyId()),
						Long.valueOf(searchPhraseHitModelImpl.getPhraseId()),
						Boolean.valueOf(searchPhraseHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G,
					args);
			}
		}

		EntityCacheUtil.putResult(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
			SearchPhraseHitImpl.class, searchPhraseHit.getPrimaryKey(),
			searchPhraseHit);

		return searchPhraseHit;
	}

	protected SearchPhraseHit toUnwrappedModel(SearchPhraseHit searchPhraseHit) {
		if (searchPhraseHit instanceof SearchPhraseHitImpl) {
			return searchPhraseHit;
		}

		SearchPhraseHitImpl searchPhraseHitImpl = new SearchPhraseHitImpl();

		searchPhraseHitImpl.setNew(searchPhraseHit.isNew());
		searchPhraseHitImpl.setPrimaryKey(searchPhraseHit.getPrimaryKey());

		searchPhraseHitImpl.setHitId(searchPhraseHit.getHitId());
		searchPhraseHitImpl.setCompanyId(searchPhraseHit.getCompanyId());
		searchPhraseHitImpl.setPhraseId(searchPhraseHit.getPhraseId());
		searchPhraseHitImpl.setGuest(searchPhraseHit.isGuest());
		searchPhraseHitImpl.setAccessDate(searchPhraseHit.getAccessDate());

		return searchPhraseHitImpl;
	}

	/**
	 * Returns the search phrase hit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the search phrase hit
	 * @return the search phrase hit
	 * @throws com.liferay.portal.NoSuchModelException if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchPhraseHit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the search phrase hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchSearchPhraseHitException} if it could not be found.
	 *
	 * @param hitId the primary key of the search phrase hit
	 * @return the search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit findByPrimaryKey(long hitId)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = fetchByPrimaryKey(hitId);

		if (searchPhraseHit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hitId);
			}

			throw new NoSuchSearchPhraseHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				hitId);
		}

		return searchPhraseHit;
	}

	/**
	 * Returns the search phrase hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the search phrase hit
	 * @return the search phrase hit, or <code>null</code> if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchPhraseHit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the search phrase hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hitId the primary key of the search phrase hit
	 * @return the search phrase hit, or <code>null</code> if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit fetchByPrimaryKey(long hitId)
		throws SystemException {
		SearchPhraseHit searchPhraseHit = (SearchPhraseHit)EntityCacheUtil.getResult(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
				SearchPhraseHitImpl.class, hitId);

		if (searchPhraseHit == _nullSearchPhraseHit) {
			return null;
		}

		if (searchPhraseHit == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				searchPhraseHit = (SearchPhraseHit)session.get(SearchPhraseHitImpl.class,
						Long.valueOf(hitId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (searchPhraseHit != null) {
					cacheResult(searchPhraseHit);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SearchPhraseHitModelImpl.ENTITY_CACHE_ENABLED,
						SearchPhraseHitImpl.class, hitId, _nullSearchPhraseHit);
				}

				closeSession(session);
			}
		}

		return searchPhraseHit;
	}

	/**
	 * Returns all the search phrase hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the search phrase hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @return the range of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search phrase hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByCompanyId(long companyId, int start,
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

		List<SearchPhraseHit> list = (List<SearchPhraseHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchPhraseHit searchPhraseHit : list) {
				if ((companyId != searchPhraseHit.getCompanyId())) {
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

			query.append(_SQL_SELECT_SEARCHPHRASEHIT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SearchPhraseHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<SearchPhraseHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search phrase hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (searchPhraseHit != null) {
			return searchPhraseHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchPhraseHitException(msg.toString());
	}

	/**
	 * Returns the first search phrase hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchPhraseHit> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search phrase hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (searchPhraseHit != null) {
			return searchPhraseHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchPhraseHitException(msg.toString());
	}

	/**
	 * Returns the last search phrase hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<SearchPhraseHit> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search phrase hits before and after the current search phrase hit in the ordered set where companyId = &#63;.
	 *
	 * @param hitId the primary key of the current search phrase hit
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit[] findByCompanyId_PrevAndNext(long hitId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SearchPhraseHit[] array = new SearchPhraseHitImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, searchPhraseHit,
					companyId, orderByComparator, true);

			array[1] = searchPhraseHit;

			array[2] = getByCompanyId_PrevAndNext(session, searchPhraseHit,
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

	protected SearchPhraseHit getByCompanyId_PrevAndNext(Session session,
		SearchPhraseHit searchPhraseHit, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHPHRASEHIT_WHERE);

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
			query.append(SearchPhraseHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchPhraseHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchPhraseHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search phrase hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByC_G(long companyId, boolean guest)
		throws SystemException {
		return findByC_G(companyId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search phrase hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @return the range of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByC_G(long companyId, boolean guest,
		int start, int end) throws SystemException {
		return findByC_G(companyId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search phrase hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByC_G(long companyId, boolean guest,
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

		List<SearchPhraseHit> list = (List<SearchPhraseHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchPhraseHit searchPhraseHit : list) {
				if ((companyId != searchPhraseHit.getCompanyId()) ||
						(guest != searchPhraseHit.getGuest())) {
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

			query.append(_SQL_SELECT_SEARCHPHRASEHIT_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SearchPhraseHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(guest);

				list = (List<SearchPhraseHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit findByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = fetchByC_G_First(companyId, guest,
				orderByComparator);

		if (searchPhraseHit != null) {
			return searchPhraseHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchPhraseHitException(msg.toString());
	}

	/**
	 * Returns the first search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit fetchByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchPhraseHit> list = findByC_G(companyId, guest, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit findByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = fetchByC_G_Last(companyId, guest,
				orderByComparator);

		if (searchPhraseHit != null) {
			return searchPhraseHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchPhraseHitException(msg.toString());
	}

	/**
	 * Returns the last search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit fetchByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, guest);

		List<SearchPhraseHit> list = findByC_G(companyId, guest, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search phrase hits before and after the current search phrase hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current search phrase hit
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit[] findByC_G_PrevAndNext(long hitId, long companyId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SearchPhraseHit[] array = new SearchPhraseHitImpl[3];

			array[0] = getByC_G_PrevAndNext(session, searchPhraseHit,
					companyId, guest, orderByComparator, true);

			array[1] = searchPhraseHit;

			array[2] = getByC_G_PrevAndNext(session, searchPhraseHit,
					companyId, guest, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchPhraseHit getByC_G_PrevAndNext(Session session,
		SearchPhraseHit searchPhraseHit, long companyId, boolean guest,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHPHRASEHIT_WHERE);

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
			query.append(SearchPhraseHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchPhraseHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchPhraseHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @return the matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByC_P_G(long companyId, long phraseId,
		boolean guest) throws SystemException {
		return findByC_P_G(companyId, phraseId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @return the range of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByC_P_G(long companyId, long phraseId,
		boolean guest, int start, int end) throws SystemException {
		return findByC_P_G(companyId, phraseId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findByC_P_G(long companyId, long phraseId,
		boolean guest, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G;
			finderArgs = new Object[] { companyId, phraseId, guest };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P_G;
			finderArgs = new Object[] {
					companyId, phraseId, guest,
					
					start, end, orderByComparator
				};
		}

		List<SearchPhraseHit> list = (List<SearchPhraseHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchPhraseHit searchPhraseHit : list) {
				if ((companyId != searchPhraseHit.getCompanyId()) ||
						(phraseId != searchPhraseHit.getPhraseId()) ||
						(guest != searchPhraseHit.getGuest())) {
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

			query.append(_SQL_SELECT_SEARCHPHRASEHIT_WHERE);

			query.append(_FINDER_COLUMN_C_P_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_P_G_PHRASEID_2);

			query.append(_FINDER_COLUMN_C_P_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SearchPhraseHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(phraseId);

				qPos.add(guest);

				list = (List<SearchPhraseHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit findByC_P_G_First(long companyId, long phraseId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = fetchByC_P_G_First(companyId,
				phraseId, guest, orderByComparator);

		if (searchPhraseHit != null) {
			return searchPhraseHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", phraseId=");
		msg.append(phraseId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchPhraseHitException(msg.toString());
	}

	/**
	 * Returns the first search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit fetchByC_P_G_First(long companyId, long phraseId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchPhraseHit> list = findByC_P_G(companyId, phraseId, guest, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit findByC_P_G_Last(long companyId, long phraseId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = fetchByC_P_G_Last(companyId,
				phraseId, guest, orderByComparator);

		if (searchPhraseHit != null) {
			return searchPhraseHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", phraseId=");
		msg.append(phraseId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchPhraseHitException(msg.toString());
	}

	/**
	 * Returns the last search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search phrase hit, or <code>null</code> if a matching search phrase hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit fetchByC_P_G_Last(long companyId, long phraseId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_P_G(companyId, phraseId, guest);

		List<SearchPhraseHit> list = findByC_P_G(companyId, phraseId, guest,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search phrase hits before and after the current search phrase hit in the ordered set where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current search phrase hit
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search phrase hit
	 * @throws com.liferay.consistent.tracking.NoSuchSearchPhraseHitException if a search phrase hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SearchPhraseHit[] findByC_P_G_PrevAndNext(long hitId,
		long companyId, long phraseId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSearchPhraseHitException, SystemException {
		SearchPhraseHit searchPhraseHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SearchPhraseHit[] array = new SearchPhraseHitImpl[3];

			array[0] = getByC_P_G_PrevAndNext(session, searchPhraseHit,
					companyId, phraseId, guest, orderByComparator, true);

			array[1] = searchPhraseHit;

			array[2] = getByC_P_G_PrevAndNext(session, searchPhraseHit,
					companyId, phraseId, guest, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchPhraseHit getByC_P_G_PrevAndNext(Session session,
		SearchPhraseHit searchPhraseHit, long companyId, long phraseId,
		boolean guest, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHPHRASEHIT_WHERE);

		query.append(_FINDER_COLUMN_C_P_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_P_G_PHRASEID_2);

		query.append(_FINDER_COLUMN_C_P_G_GUEST_2);

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
			query.append(SearchPhraseHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(phraseId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchPhraseHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchPhraseHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search phrase hits.
	 *
	 * @return the search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search phrase hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @return the range of search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the search phrase hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of search phrase hits
	 * @param end the upper bound of the range of search phrase hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SearchPhraseHit> findAll(int start, int end,
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

		List<SearchPhraseHit> list = (List<SearchPhraseHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEARCHPHRASEHIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEARCHPHRASEHIT.concat(SearchPhraseHitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SearchPhraseHit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SearchPhraseHit>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the search phrase hits where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (SearchPhraseHit searchPhraseHit : findByCompanyId(companyId)) {
			remove(searchPhraseHit);
		}
	}

	/**
	 * Removes all the search phrase hits where companyId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, boolean guest)
		throws SystemException {
		for (SearchPhraseHit searchPhraseHit : findByC_G(companyId, guest)) {
			remove(searchPhraseHit);
		}
	}

	/**
	 * Removes all the search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_P_G(long companyId, long phraseId, boolean guest)
		throws SystemException {
		for (SearchPhraseHit searchPhraseHit : findByC_P_G(companyId, phraseId,
				guest)) {
			remove(searchPhraseHit);
		}
	}

	/**
	 * Removes all the search phrase hits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SearchPhraseHit searchPhraseHit : findAll()) {
			remove(searchPhraseHit);
		}
	}

	/**
	 * Returns the number of search phrase hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHPHRASEHIT_WHERE);

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
	 * Returns the number of search phrase hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the number of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEARCHPHRASEHIT_WHERE);

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
	 * Returns the number of search phrase hits where companyId = &#63; and phraseId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param phraseId the phrase ID
	 * @param guest the guest
	 * @return the number of matching search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_P_G(long companyId, long phraseId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, phraseId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_P_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SEARCHPHRASEHIT_WHERE);

			query.append(_FINDER_COLUMN_C_P_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_P_G_PHRASEID_2);

			query.append(_FINDER_COLUMN_C_P_G_GUEST_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(phraseId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_P_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of search phrase hits.
	 *
	 * @return the number of search phrase hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEARCHPHRASEHIT);

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
	 * Initializes the search phrase hit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.SearchPhraseHit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SearchPhraseHit>> listenersList = new ArrayList<ModelListener<SearchPhraseHit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SearchPhraseHit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SearchPhraseHitImpl.class.getName());
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
	private static final String _SQL_SELECT_SEARCHPHRASEHIT = "SELECT searchPhraseHit FROM SearchPhraseHit searchPhraseHit";
	private static final String _SQL_SELECT_SEARCHPHRASEHIT_WHERE = "SELECT searchPhraseHit FROM SearchPhraseHit searchPhraseHit WHERE ";
	private static final String _SQL_COUNT_SEARCHPHRASEHIT = "SELECT COUNT(searchPhraseHit) FROM SearchPhraseHit searchPhraseHit";
	private static final String _SQL_COUNT_SEARCHPHRASEHIT_WHERE = "SELECT COUNT(searchPhraseHit) FROM SearchPhraseHit searchPhraseHit WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "searchPhraseHit.companyId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "searchPhraseHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GUEST_2 = "searchPhraseHit.guest = ?";
	private static final String _FINDER_COLUMN_C_P_G_COMPANYID_2 = "searchPhraseHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_G_PHRASEID_2 = "searchPhraseHit.phraseId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_G_GUEST_2 = "searchPhraseHit.guest = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "searchPhraseHit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SearchPhraseHit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SearchPhraseHit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SearchPhraseHitPersistenceImpl.class);
	private static SearchPhraseHit _nullSearchPhraseHit = new SearchPhraseHitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SearchPhraseHit> toCacheModel() {
				return _nullSearchPhraseHitCacheModel;
			}
		};

	private static CacheModel<SearchPhraseHit> _nullSearchPhraseHitCacheModel = new CacheModel<SearchPhraseHit>() {
			public SearchPhraseHit toEntityModel() {
				return _nullSearchPhraseHit;
			}
		};
}