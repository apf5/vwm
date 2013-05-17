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

import com.liferay.consistent.tracking.NoSuchSiteHitException;
import com.liferay.consistent.tracking.model.SiteHit;
import com.liferay.consistent.tracking.model.impl.SiteHitImpl;
import com.liferay.consistent.tracking.model.impl.SiteHitModelImpl;

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
 * The persistence implementation for the site hit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SiteHitPersistence
 * @see SiteHitUtil
 * @generated
 */
public class SiteHitPersistenceImpl extends BasePersistenceImpl<SiteHit>
	implements SiteHitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SiteHitUtil} to access the site hit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SiteHitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			SiteHitModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SiteHitModelImpl.COMPANYID_COLUMN_BITMASK |
			SiteHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S_G = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S_G = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			SiteHitModelImpl.COMPANYID_COLUMN_BITMASK |
			SiteHitModelImpl.SITEID_COLUMN_BITMASK |
			SiteHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_S_G = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, SiteHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the site hit in the entity cache if it is enabled.
	 *
	 * @param siteHit the site hit
	 */
	public void cacheResult(SiteHit siteHit) {
		EntityCacheUtil.putResult(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitImpl.class, siteHit.getPrimaryKey(), siteHit);

		siteHit.resetOriginalValues();
	}

	/**
	 * Caches the site hits in the entity cache if it is enabled.
	 *
	 * @param siteHits the site hits
	 */
	public void cacheResult(List<SiteHit> siteHits) {
		for (SiteHit siteHit : siteHits) {
			if (EntityCacheUtil.getResult(
						SiteHitModelImpl.ENTITY_CACHE_ENABLED,
						SiteHitImpl.class, siteHit.getPrimaryKey()) == null) {
				cacheResult(siteHit);
			}
			else {
				siteHit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all site hits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SiteHitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SiteHitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the site hit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SiteHit siteHit) {
		EntityCacheUtil.removeResult(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitImpl.class, siteHit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SiteHit> siteHits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SiteHit siteHit : siteHits) {
			EntityCacheUtil.removeResult(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
				SiteHitImpl.class, siteHit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new site hit with the primary key. Does not add the site hit to the database.
	 *
	 * @param hitId the primary key for the new site hit
	 * @return the new site hit
	 */
	public SiteHit create(long hitId) {
		SiteHit siteHit = new SiteHitImpl();

		siteHit.setNew(true);
		siteHit.setPrimaryKey(hitId);

		return siteHit;
	}

	/**
	 * Removes the site hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hitId the primary key of the site hit
	 * @return the site hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit remove(long hitId)
		throws NoSuchSiteHitException, SystemException {
		return remove(Long.valueOf(hitId));
	}

	/**
	 * Removes the site hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the site hit
	 * @return the site hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteHit remove(Serializable primaryKey)
		throws NoSuchSiteHitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SiteHit siteHit = (SiteHit)session.get(SiteHitImpl.class, primaryKey);

			if (siteHit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSiteHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(siteHit);
		}
		catch (NoSuchSiteHitException nsee) {
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
	protected SiteHit removeImpl(SiteHit siteHit) throws SystemException {
		siteHit = toUnwrappedModel(siteHit);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, siteHit);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(siteHit);

		return siteHit;
	}

	@Override
	public SiteHit updateImpl(
		com.liferay.consistent.tracking.model.SiteHit siteHit, boolean merge)
		throws SystemException {
		siteHit = toUnwrappedModel(siteHit);

		boolean isNew = siteHit.isNew();

		SiteHitModelImpl siteHitModelImpl = (SiteHitModelImpl)siteHit;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, siteHit, merge);

			siteHit.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SiteHitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((siteHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(siteHitModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(siteHitModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((siteHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(siteHitModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(siteHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(siteHitModelImpl.getCompanyId()),
						Boolean.valueOf(siteHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((siteHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(siteHitModelImpl.getOriginalCompanyId()),
						Long.valueOf(siteHitModelImpl.getOriginalSiteId()),
						Boolean.valueOf(siteHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S_G,
					args);

				args = new Object[] {
						Long.valueOf(siteHitModelImpl.getCompanyId()),
						Long.valueOf(siteHitModelImpl.getSiteId()),
						Boolean.valueOf(siteHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S_G,
					args);
			}
		}

		EntityCacheUtil.putResult(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
			SiteHitImpl.class, siteHit.getPrimaryKey(), siteHit);

		return siteHit;
	}

	protected SiteHit toUnwrappedModel(SiteHit siteHit) {
		if (siteHit instanceof SiteHitImpl) {
			return siteHit;
		}

		SiteHitImpl siteHitImpl = new SiteHitImpl();

		siteHitImpl.setNew(siteHit.isNew());
		siteHitImpl.setPrimaryKey(siteHit.getPrimaryKey());

		siteHitImpl.setHitId(siteHit.getHitId());
		siteHitImpl.setCompanyId(siteHit.getCompanyId());
		siteHitImpl.setSiteId(siteHit.getSiteId());
		siteHitImpl.setGuest(siteHit.isGuest());
		siteHitImpl.setAccessDate(siteHit.getAccessDate());

		return siteHitImpl;
	}

	/**
	 * Returns the site hit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the site hit
	 * @return the site hit
	 * @throws com.liferay.portal.NoSuchModelException if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteHit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the site hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchSiteHitException} if it could not be found.
	 *
	 * @param hitId the primary key of the site hit
	 * @return the site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit findByPrimaryKey(long hitId)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = fetchByPrimaryKey(hitId);

		if (siteHit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hitId);
			}

			throw new NoSuchSiteHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				hitId);
		}

		return siteHit;
	}

	/**
	 * Returns the site hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the site hit
	 * @return the site hit, or <code>null</code> if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteHit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the site hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hitId the primary key of the site hit
	 * @return the site hit, or <code>null</code> if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit fetchByPrimaryKey(long hitId) throws SystemException {
		SiteHit siteHit = (SiteHit)EntityCacheUtil.getResult(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
				SiteHitImpl.class, hitId);

		if (siteHit == _nullSiteHit) {
			return null;
		}

		if (siteHit == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				siteHit = (SiteHit)session.get(SiteHitImpl.class,
						Long.valueOf(hitId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (siteHit != null) {
					cacheResult(siteHit);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SiteHitModelImpl.ENTITY_CACHE_ENABLED,
						SiteHitImpl.class, hitId, _nullSiteHit);
				}

				closeSession(session);
			}
		}

		return siteHit;
	}

	/**
	 * Returns all the site hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the site hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @return the range of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the site hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByCompanyId(long companyId, int start, int end,
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

		List<SiteHit> list = (List<SiteHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SiteHit siteHit : list) {
				if ((companyId != siteHit.getCompanyId())) {
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

			query.append(_SQL_SELECT_SITEHIT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SiteHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<SiteHit>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first site hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = fetchByCompanyId_First(companyId, orderByComparator);

		if (siteHit != null) {
			return siteHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteHitException(msg.toString());
	}

	/**
	 * Returns the first site hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SiteHit> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last site hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = fetchByCompanyId_Last(companyId, orderByComparator);

		if (siteHit != null) {
			return siteHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteHitException(msg.toString());
	}

	/**
	 * Returns the last site hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<SiteHit> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the site hits before and after the current site hit in the ordered set where companyId = &#63;.
	 *
	 * @param hitId the primary key of the current site hit
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit[] findByCompanyId_PrevAndNext(long hitId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SiteHit[] array = new SiteHitImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, siteHit, companyId,
					orderByComparator, true);

			array[1] = siteHit;

			array[2] = getByCompanyId_PrevAndNext(session, siteHit, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SiteHit getByCompanyId_PrevAndNext(Session session,
		SiteHit siteHit, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITEHIT_WHERE);

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
			query.append(SiteHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(siteHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SiteHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the site hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByC_G(long companyId, boolean guest)
		throws SystemException {
		return findByC_G(companyId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the site hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @return the range of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByC_G(long companyId, boolean guest, int start,
		int end) throws SystemException {
		return findByC_G(companyId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the site hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByC_G(long companyId, boolean guest, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<SiteHit> list = (List<SiteHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SiteHit siteHit : list) {
				if ((companyId != siteHit.getCompanyId()) ||
						(guest != siteHit.getGuest())) {
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

			query.append(_SQL_SELECT_SITEHIT_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SiteHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(guest);

				list = (List<SiteHit>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first site hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit findByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = fetchByC_G_First(companyId, guest, orderByComparator);

		if (siteHit != null) {
			return siteHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteHitException(msg.toString());
	}

	/**
	 * Returns the first site hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit fetchByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		List<SiteHit> list = findByC_G(companyId, guest, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last site hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit findByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = fetchByC_G_Last(companyId, guest, orderByComparator);

		if (siteHit != null) {
			return siteHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteHitException(msg.toString());
	}

	/**
	 * Returns the last site hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit fetchByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, guest);

		List<SiteHit> list = findByC_G(companyId, guest, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the site hits before and after the current site hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current site hit
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit[] findByC_G_PrevAndNext(long hitId, long companyId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SiteHit[] array = new SiteHitImpl[3];

			array[0] = getByC_G_PrevAndNext(session, siteHit, companyId, guest,
					orderByComparator, true);

			array[1] = siteHit;

			array[2] = getByC_G_PrevAndNext(session, siteHit, companyId, guest,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SiteHit getByC_G_PrevAndNext(Session session, SiteHit siteHit,
		long companyId, boolean guest, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITEHIT_WHERE);

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
			query.append(SiteHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(siteHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SiteHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @return the matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByC_S_G(long companyId, long siteId, boolean guest)
		throws SystemException {
		return findByC_S_G(companyId, siteId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @return the range of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByC_S_G(long companyId, long siteId,
		boolean guest, int start, int end) throws SystemException {
		return findByC_S_G(companyId, siteId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findByC_S_G(long companyId, long siteId,
		boolean guest, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S_G;
			finderArgs = new Object[] { companyId, siteId, guest };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S_G;
			finderArgs = new Object[] {
					companyId, siteId, guest,
					
					start, end, orderByComparator
				};
		}

		List<SiteHit> list = (List<SiteHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SiteHit siteHit : list) {
				if ((companyId != siteHit.getCompanyId()) ||
						(siteId != siteHit.getSiteId()) ||
						(guest != siteHit.getGuest())) {
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

			query.append(_SQL_SELECT_SITEHIT_WHERE);

			query.append(_FINDER_COLUMN_C_S_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_S_G_SITEID_2);

			query.append(_FINDER_COLUMN_C_S_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SiteHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(siteId);

				qPos.add(guest);

				list = (List<SiteHit>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit findByC_S_G_First(long companyId, long siteId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = fetchByC_S_G_First(companyId, siteId, guest,
				orderByComparator);

		if (siteHit != null) {
			return siteHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", siteId=");
		msg.append(siteId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteHitException(msg.toString());
	}

	/**
	 * Returns the first site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site hit, or <code>null</code> if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit fetchByC_S_G_First(long companyId, long siteId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		List<SiteHit> list = findByC_S_G(companyId, siteId, guest, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit findByC_S_G_Last(long companyId, long siteId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = fetchByC_S_G_Last(companyId, siteId, guest,
				orderByComparator);

		if (siteHit != null) {
			return siteHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", siteId=");
		msg.append(siteId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteHitException(msg.toString());
	}

	/**
	 * Returns the last site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site hit, or <code>null</code> if a matching site hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit fetchByC_S_G_Last(long companyId, long siteId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_S_G(companyId, siteId, guest);

		List<SiteHit> list = findByC_S_G(companyId, siteId, guest, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the site hits before and after the current site hit in the ordered set where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current site hit
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site hit
	 * @throws com.liferay.consistent.tracking.NoSuchSiteHitException if a site hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SiteHit[] findByC_S_G_PrevAndNext(long hitId, long companyId,
		long siteId, boolean guest, OrderByComparator orderByComparator)
		throws NoSuchSiteHitException, SystemException {
		SiteHit siteHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			SiteHit[] array = new SiteHitImpl[3];

			array[0] = getByC_S_G_PrevAndNext(session, siteHit, companyId,
					siteId, guest, orderByComparator, true);

			array[1] = siteHit;

			array[2] = getByC_S_G_PrevAndNext(session, siteHit, companyId,
					siteId, guest, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SiteHit getByC_S_G_PrevAndNext(Session session, SiteHit siteHit,
		long companyId, long siteId, boolean guest,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITEHIT_WHERE);

		query.append(_FINDER_COLUMN_C_S_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_S_G_SITEID_2);

		query.append(_FINDER_COLUMN_C_S_G_GUEST_2);

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
			query.append(SiteHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(siteId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(siteHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SiteHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the site hits.
	 *
	 * @return the site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the site hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @return the range of site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the site hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of site hits
	 * @param end the upper bound of the range of site hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of site hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<SiteHit> findAll(int start, int end,
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

		List<SiteHit> list = (List<SiteHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SITEHIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SITEHIT.concat(SiteHitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SiteHit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SiteHit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the site hits where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (SiteHit siteHit : findByCompanyId(companyId)) {
			remove(siteHit);
		}
	}

	/**
	 * Removes all the site hits where companyId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, boolean guest)
		throws SystemException {
		for (SiteHit siteHit : findByC_G(companyId, guest)) {
			remove(siteHit);
		}
	}

	/**
	 * Removes all the site hits where companyId = &#63; and siteId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_S_G(long companyId, long siteId, boolean guest)
		throws SystemException {
		for (SiteHit siteHit : findByC_S_G(companyId, siteId, guest)) {
			remove(siteHit);
		}
	}

	/**
	 * Removes all the site hits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SiteHit siteHit : findAll()) {
			remove(siteHit);
		}
	}

	/**
	 * Returns the number of site hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SITEHIT_WHERE);

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
	 * Returns the number of site hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the number of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SITEHIT_WHERE);

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
	 * Returns the number of site hits where companyId = &#63; and siteId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param siteId the site ID
	 * @param guest the guest
	 * @return the number of matching site hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_S_G(long companyId, long siteId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, siteId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_S_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SITEHIT_WHERE);

			query.append(_FINDER_COLUMN_C_S_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_S_G_SITEID_2);

			query.append(_FINDER_COLUMN_C_S_G_GUEST_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(siteId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_S_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of site hits.
	 *
	 * @return the number of site hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SITEHIT);

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
	 * Initializes the site hit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.SiteHit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SiteHit>> listenersList = new ArrayList<ModelListener<SiteHit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SiteHit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SiteHitImpl.class.getName());
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
	private static final String _SQL_SELECT_SITEHIT = "SELECT siteHit FROM SiteHit siteHit";
	private static final String _SQL_SELECT_SITEHIT_WHERE = "SELECT siteHit FROM SiteHit siteHit WHERE ";
	private static final String _SQL_COUNT_SITEHIT = "SELECT COUNT(siteHit) FROM SiteHit siteHit";
	private static final String _SQL_COUNT_SITEHIT_WHERE = "SELECT COUNT(siteHit) FROM SiteHit siteHit WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "siteHit.companyId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "siteHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GUEST_2 = "siteHit.guest = ?";
	private static final String _FINDER_COLUMN_C_S_G_COMPANYID_2 = "siteHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_G_SITEID_2 = "siteHit.siteId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_G_GUEST_2 = "siteHit.guest = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "siteHit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SiteHit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SiteHit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SiteHitPersistenceImpl.class);
	private static SiteHit _nullSiteHit = new SiteHitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SiteHit> toCacheModel() {
				return _nullSiteHitCacheModel;
			}
		};

	private static CacheModel<SiteHit> _nullSiteHitCacheModel = new CacheModel<SiteHit>() {
			public SiteHit toEntityModel() {
				return _nullSiteHit;
			}
		};
}