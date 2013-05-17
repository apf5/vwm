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

import com.liferay.consistent.tracking.NoSuchOrganizationHitException;
import com.liferay.consistent.tracking.model.OrganizationHit;
import com.liferay.consistent.tracking.model.impl.OrganizationHitImpl;
import com.liferay.consistent.tracking.model.impl.OrganizationHitModelImpl;

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
 * The persistence implementation for the organization hit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see OrganizationHitPersistence
 * @see OrganizationHitUtil
 * @generated
 */
public class OrganizationHitPersistenceImpl extends BasePersistenceImpl<OrganizationHit>
	implements OrganizationHitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationHitUtil} to access the organization hit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationHitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			OrganizationHitModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			OrganizationHitModelImpl.COMPANYID_COLUMN_BITMASK |
			OrganizationHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_O_G = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_O_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_O_G = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_O_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			OrganizationHitModelImpl.COMPANYID_COLUMN_BITMASK |
			OrganizationHitModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			OrganizationHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_O_G = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_O_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED,
			OrganizationHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the organization hit in the entity cache if it is enabled.
	 *
	 * @param organizationHit the organization hit
	 */
	public void cacheResult(OrganizationHit organizationHit) {
		EntityCacheUtil.putResult(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitImpl.class, organizationHit.getPrimaryKey(),
			organizationHit);

		organizationHit.resetOriginalValues();
	}

	/**
	 * Caches the organization hits in the entity cache if it is enabled.
	 *
	 * @param organizationHits the organization hits
	 */
	public void cacheResult(List<OrganizationHit> organizationHits) {
		for (OrganizationHit organizationHit : organizationHits) {
			if (EntityCacheUtil.getResult(
						OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationHitImpl.class,
						organizationHit.getPrimaryKey()) == null) {
				cacheResult(organizationHit);
			}
			else {
				organizationHit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organization hits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizationHitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizationHitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization hit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationHit organizationHit) {
		EntityCacheUtil.removeResult(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitImpl.class, organizationHit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrganizationHit> organizationHits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrganizationHit organizationHit : organizationHits) {
			EntityCacheUtil.removeResult(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationHitImpl.class, organizationHit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new organization hit with the primary key. Does not add the organization hit to the database.
	 *
	 * @param hitId the primary key for the new organization hit
	 * @return the new organization hit
	 */
	public OrganizationHit create(long hitId) {
		OrganizationHit organizationHit = new OrganizationHitImpl();

		organizationHit.setNew(true);
		organizationHit.setPrimaryKey(hitId);

		return organizationHit;
	}

	/**
	 * Removes the organization hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hitId the primary key of the organization hit
	 * @return the organization hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit remove(long hitId)
		throws NoSuchOrganizationHitException, SystemException {
		return remove(Long.valueOf(hitId));
	}

	/**
	 * Removes the organization hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization hit
	 * @return the organization hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationHit remove(Serializable primaryKey)
		throws NoSuchOrganizationHitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrganizationHit organizationHit = (OrganizationHit)session.get(OrganizationHitImpl.class,
					primaryKey);

			if (organizationHit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organizationHit);
		}
		catch (NoSuchOrganizationHitException nsee) {
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
	protected OrganizationHit removeImpl(OrganizationHit organizationHit)
		throws SystemException {
		organizationHit = toUnwrappedModel(organizationHit);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, organizationHit);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(organizationHit);

		return organizationHit;
	}

	@Override
	public OrganizationHit updateImpl(
		com.liferay.consistent.tracking.model.OrganizationHit organizationHit,
		boolean merge) throws SystemException {
		organizationHit = toUnwrappedModel(organizationHit);

		boolean isNew = organizationHit.isNew();

		OrganizationHitModelImpl organizationHitModelImpl = (OrganizationHitModelImpl)organizationHit;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, organizationHit, merge);

			organizationHit.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrganizationHitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((organizationHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(organizationHitModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(organizationHitModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((organizationHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(organizationHitModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(organizationHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(organizationHitModelImpl.getCompanyId()),
						Boolean.valueOf(organizationHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((organizationHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_O_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(organizationHitModelImpl.getOriginalCompanyId()),
						Long.valueOf(organizationHitModelImpl.getOriginalOrganizationId()),
						Boolean.valueOf(organizationHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_O_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_O_G,
					args);

				args = new Object[] {
						Long.valueOf(organizationHitModelImpl.getCompanyId()),
						Long.valueOf(organizationHitModelImpl.getOrganizationId()),
						Boolean.valueOf(organizationHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_O_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_O_G,
					args);
			}
		}

		EntityCacheUtil.putResult(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationHitImpl.class, organizationHit.getPrimaryKey(),
			organizationHit);

		return organizationHit;
	}

	protected OrganizationHit toUnwrappedModel(OrganizationHit organizationHit) {
		if (organizationHit instanceof OrganizationHitImpl) {
			return organizationHit;
		}

		OrganizationHitImpl organizationHitImpl = new OrganizationHitImpl();

		organizationHitImpl.setNew(organizationHit.isNew());
		organizationHitImpl.setPrimaryKey(organizationHit.getPrimaryKey());

		organizationHitImpl.setHitId(organizationHit.getHitId());
		organizationHitImpl.setCompanyId(organizationHit.getCompanyId());
		organizationHitImpl.setOrganizationId(organizationHit.getOrganizationId());
		organizationHitImpl.setGuest(organizationHit.isGuest());
		organizationHitImpl.setAccessDate(organizationHit.getAccessDate());

		return organizationHitImpl;
	}

	/**
	 * Returns the organization hit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization hit
	 * @return the organization hit
	 * @throws com.liferay.portal.NoSuchModelException if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationHit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the organization hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchOrganizationHitException} if it could not be found.
	 *
	 * @param hitId the primary key of the organization hit
	 * @return the organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit findByPrimaryKey(long hitId)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = fetchByPrimaryKey(hitId);

		if (organizationHit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hitId);
			}

			throw new NoSuchOrganizationHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				hitId);
		}

		return organizationHit;
	}

	/**
	 * Returns the organization hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization hit
	 * @return the organization hit, or <code>null</code> if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationHit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the organization hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hitId the primary key of the organization hit
	 * @return the organization hit, or <code>null</code> if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit fetchByPrimaryKey(long hitId)
		throws SystemException {
		OrganizationHit organizationHit = (OrganizationHit)EntityCacheUtil.getResult(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationHitImpl.class, hitId);

		if (organizationHit == _nullOrganizationHit) {
			return null;
		}

		if (organizationHit == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				organizationHit = (OrganizationHit)session.get(OrganizationHitImpl.class,
						Long.valueOf(hitId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (organizationHit != null) {
					cacheResult(organizationHit);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OrganizationHitModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationHitImpl.class, hitId, _nullOrganizationHit);
				}

				closeSession(session);
			}
		}

		return organizationHit;
	}

	/**
	 * Returns all the organization hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the organization hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @return the range of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByCompanyId(long companyId, int start,
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

		List<OrganizationHit> list = (List<OrganizationHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrganizationHit organizationHit : list) {
				if ((companyId != organizationHit.getCompanyId())) {
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

			query.append(_SQL_SELECT_ORGANIZATIONHIT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OrganizationHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<OrganizationHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (organizationHit != null) {
			return organizationHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationHitException(msg.toString());
	}

	/**
	 * Returns the first organization hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization hit, or <code>null</code> if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrganizationHit> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (organizationHit != null) {
			return organizationHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationHitException(msg.toString());
	}

	/**
	 * Returns the last organization hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization hit, or <code>null</code> if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<OrganizationHit> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization hits before and after the current organization hit in the ordered set where companyId = &#63;.
	 *
	 * @param hitId the primary key of the current organization hit
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit[] findByCompanyId_PrevAndNext(long hitId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			OrganizationHit[] array = new OrganizationHitImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, organizationHit,
					companyId, orderByComparator, true);

			array[1] = organizationHit;

			array[2] = getByCompanyId_PrevAndNext(session, organizationHit,
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

	protected OrganizationHit getByCompanyId_PrevAndNext(Session session,
		OrganizationHit organizationHit, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONHIT_WHERE);

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
			query.append(OrganizationHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizationHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrganizationHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the organization hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByC_G(long companyId, boolean guest)
		throws SystemException {
		return findByC_G(companyId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @return the range of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByC_G(long companyId, boolean guest,
		int start, int end) throws SystemException {
		return findByC_G(companyId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByC_G(long companyId, boolean guest,
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

		List<OrganizationHit> list = (List<OrganizationHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrganizationHit organizationHit : list) {
				if ((companyId != organizationHit.getCompanyId()) ||
						(guest != organizationHit.getGuest())) {
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

			query.append(_SQL_SELECT_ORGANIZATIONHIT_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OrganizationHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(guest);

				list = (List<OrganizationHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit findByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = fetchByC_G_First(companyId, guest,
				orderByComparator);

		if (organizationHit != null) {
			return organizationHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationHitException(msg.toString());
	}

	/**
	 * Returns the first organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization hit, or <code>null</code> if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit fetchByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrganizationHit> list = findByC_G(companyId, guest, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit findByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = fetchByC_G_Last(companyId, guest,
				orderByComparator);

		if (organizationHit != null) {
			return organizationHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationHitException(msg.toString());
	}

	/**
	 * Returns the last organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization hit, or <code>null</code> if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit fetchByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, guest);

		List<OrganizationHit> list = findByC_G(companyId, guest, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization hits before and after the current organization hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current organization hit
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit[] findByC_G_PrevAndNext(long hitId, long companyId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			OrganizationHit[] array = new OrganizationHitImpl[3];

			array[0] = getByC_G_PrevAndNext(session, organizationHit,
					companyId, guest, orderByComparator, true);

			array[1] = organizationHit;

			array[2] = getByC_G_PrevAndNext(session, organizationHit,
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

	protected OrganizationHit getByC_G_PrevAndNext(Session session,
		OrganizationHit organizationHit, long companyId, boolean guest,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONHIT_WHERE);

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
			query.append(OrganizationHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizationHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrganizationHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @return the matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByC_O_G(long companyId,
		long organizationId, boolean guest) throws SystemException {
		return findByC_O_G(companyId, organizationId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @return the range of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByC_O_G(long companyId,
		long organizationId, boolean guest, int start, int end)
		throws SystemException {
		return findByC_O_G(companyId, organizationId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findByC_O_G(long companyId,
		long organizationId, boolean guest, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_O_G;
			finderArgs = new Object[] { companyId, organizationId, guest };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_O_G;
			finderArgs = new Object[] {
					companyId, organizationId, guest,
					
					start, end, orderByComparator
				};
		}

		List<OrganizationHit> list = (List<OrganizationHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrganizationHit organizationHit : list) {
				if ((companyId != organizationHit.getCompanyId()) ||
						(organizationId != organizationHit.getOrganizationId()) ||
						(guest != organizationHit.getGuest())) {
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

			query.append(_SQL_SELECT_ORGANIZATIONHIT_WHERE);

			query.append(_FINDER_COLUMN_C_O_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_O_G_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_C_O_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OrganizationHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(organizationId);

				qPos.add(guest);

				list = (List<OrganizationHit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit findByC_O_G_First(long companyId,
		long organizationId, boolean guest, OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = fetchByC_O_G_First(companyId,
				organizationId, guest, orderByComparator);

		if (organizationHit != null) {
			return organizationHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationHitException(msg.toString());
	}

	/**
	 * Returns the first organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization hit, or <code>null</code> if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit fetchByC_O_G_First(long companyId,
		long organizationId, boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		List<OrganizationHit> list = findByC_O_G(companyId, organizationId,
				guest, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit findByC_O_G_Last(long companyId,
		long organizationId, boolean guest, OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = fetchByC_O_G_Last(companyId,
				organizationId, guest, orderByComparator);

		if (organizationHit != null) {
			return organizationHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationHitException(msg.toString());
	}

	/**
	 * Returns the last organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization hit, or <code>null</code> if a matching organization hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit fetchByC_O_G_Last(long companyId,
		long organizationId, boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_O_G(companyId, organizationId, guest);

		List<OrganizationHit> list = findByC_O_G(companyId, organizationId,
				guest, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization hits before and after the current organization hit in the ordered set where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current organization hit
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization hit
	 * @throws com.liferay.consistent.tracking.NoSuchOrganizationHitException if a organization hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrganizationHit[] findByC_O_G_PrevAndNext(long hitId,
		long companyId, long organizationId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationHitException, SystemException {
		OrganizationHit organizationHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			OrganizationHit[] array = new OrganizationHitImpl[3];

			array[0] = getByC_O_G_PrevAndNext(session, organizationHit,
					companyId, organizationId, guest, orderByComparator, true);

			array[1] = organizationHit;

			array[2] = getByC_O_G_PrevAndNext(session, organizationHit,
					companyId, organizationId, guest, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrganizationHit getByC_O_G_PrevAndNext(Session session,
		OrganizationHit organizationHit, long companyId, long organizationId,
		boolean guest, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONHIT_WHERE);

		query.append(_FINDER_COLUMN_C_O_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_O_G_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_C_O_G_GUEST_2);

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
			query.append(OrganizationHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(organizationId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizationHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrganizationHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the organization hits.
	 *
	 * @return the organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @return the range of organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization hits
	 * @param end the upper bound of the range of organization hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrganizationHit> findAll(int start, int end,
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

		List<OrganizationHit> list = (List<OrganizationHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZATIONHIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONHIT.concat(OrganizationHitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<OrganizationHit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrganizationHit>)QueryUtil.list(q,
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
	 * Removes all the organization hits where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (OrganizationHit organizationHit : findByCompanyId(companyId)) {
			remove(organizationHit);
		}
	}

	/**
	 * Removes all the organization hits where companyId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, boolean guest)
		throws SystemException {
		for (OrganizationHit organizationHit : findByC_G(companyId, guest)) {
			remove(organizationHit);
		}
	}

	/**
	 * Removes all the organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_O_G(long companyId, long organizationId, boolean guest)
		throws SystemException {
		for (OrganizationHit organizationHit : findByC_O_G(companyId,
				organizationId, guest)) {
			remove(organizationHit);
		}
	}

	/**
	 * Removes all the organization hits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (OrganizationHit organizationHit : findAll()) {
			remove(organizationHit);
		}
	}

	/**
	 * Returns the number of organization hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATIONHIT_WHERE);

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
	 * Returns the number of organization hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the number of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORGANIZATIONHIT_WHERE);

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
	 * Returns the number of organization hits where companyId = &#63; and organizationId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param organizationId the organization ID
	 * @param guest the guest
	 * @return the number of matching organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_O_G(long companyId, long organizationId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, organizationId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_O_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ORGANIZATIONHIT_WHERE);

			query.append(_FINDER_COLUMN_C_O_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_O_G_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_C_O_G_GUEST_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(organizationId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_O_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of organization hits.
	 *
	 * @return the number of organization hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATIONHIT);

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
	 * Initializes the organization hit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.OrganizationHit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrganizationHit>> listenersList = new ArrayList<ModelListener<OrganizationHit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrganizationHit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganizationHitImpl.class.getName());
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
	private static final String _SQL_SELECT_ORGANIZATIONHIT = "SELECT organizationHit FROM OrganizationHit organizationHit";
	private static final String _SQL_SELECT_ORGANIZATIONHIT_WHERE = "SELECT organizationHit FROM OrganizationHit organizationHit WHERE ";
	private static final String _SQL_COUNT_ORGANIZATIONHIT = "SELECT COUNT(organizationHit) FROM OrganizationHit organizationHit";
	private static final String _SQL_COUNT_ORGANIZATIONHIT_WHERE = "SELECT COUNT(organizationHit) FROM OrganizationHit organizationHit WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "organizationHit.companyId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "organizationHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GUEST_2 = "organizationHit.guest = ?";
	private static final String _FINDER_COLUMN_C_O_G_COMPANYID_2 = "organizationHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_O_G_ORGANIZATIONID_2 = "organizationHit.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_C_O_G_GUEST_2 = "organizationHit.guest = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationHit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrganizationHit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrganizationHit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizationHitPersistenceImpl.class);
	private static OrganizationHit _nullOrganizationHit = new OrganizationHitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrganizationHit> toCacheModel() {
				return _nullOrganizationHitCacheModel;
			}
		};

	private static CacheModel<OrganizationHit> _nullOrganizationHitCacheModel = new CacheModel<OrganizationHit>() {
			public OrganizationHit toEntityModel() {
				return _nullOrganizationHit;
			}
		};
}