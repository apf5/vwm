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

import com.liferay.consistent.tracking.NoSuchPortletHitException;
import com.liferay.consistent.tracking.model.PortletHit;
import com.liferay.consistent.tracking.model.impl.PortletHitImpl;
import com.liferay.consistent.tracking.model.impl.PortletHitModelImpl;

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
 * The persistence implementation for the portlet hit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PortletHitPersistence
 * @see PortletHitUtil
 * @generated
 */
public class PortletHitPersistenceImpl extends BasePersistenceImpl<PortletHit>
	implements PortletHitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortletHitUtil} to access the portlet hit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortletHitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			PortletHitModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			PortletHitModelImpl.COMPANYID_COLUMN_BITMASK |
			PortletHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P_G = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_P_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_P_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			PortletHitModelImpl.COMPANYID_COLUMN_BITMASK |
			PortletHitModelImpl.PORTLETID_COLUMN_BITMASK |
			PortletHitModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_P_G = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P_U = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_P_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_U = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_P_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			PortletHitModelImpl.COMPANYID_COLUMN_BITMASK |
			PortletHitModelImpl.PORTLETID_COLUMN_BITMASK |
			PortletHitModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_P_U = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, PortletHitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the portlet hit in the entity cache if it is enabled.
	 *
	 * @param portletHit the portlet hit
	 */
	public void cacheResult(PortletHit portletHit) {
		EntityCacheUtil.putResult(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitImpl.class, portletHit.getPrimaryKey(), portletHit);

		portletHit.resetOriginalValues();
	}

	/**
	 * Caches the portlet hits in the entity cache if it is enabled.
	 *
	 * @param portletHits the portlet hits
	 */
	public void cacheResult(List<PortletHit> portletHits) {
		for (PortletHit portletHit : portletHits) {
			if (EntityCacheUtil.getResult(
						PortletHitModelImpl.ENTITY_CACHE_ENABLED,
						PortletHitImpl.class, portletHit.getPrimaryKey()) == null) {
				cacheResult(portletHit);
			}
			else {
				portletHit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portlet hits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortletHitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortletHitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the portlet hit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortletHit portletHit) {
		EntityCacheUtil.removeResult(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitImpl.class, portletHit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortletHit> portletHits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortletHit portletHit : portletHits) {
			EntityCacheUtil.removeResult(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
				PortletHitImpl.class, portletHit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new portlet hit with the primary key. Does not add the portlet hit to the database.
	 *
	 * @param hitId the primary key for the new portlet hit
	 * @return the new portlet hit
	 */
	public PortletHit create(long hitId) {
		PortletHit portletHit = new PortletHitImpl();

		portletHit.setNew(true);
		portletHit.setPrimaryKey(hitId);

		return portletHit;
	}

	/**
	 * Removes the portlet hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hitId the primary key of the portlet hit
	 * @return the portlet hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit remove(long hitId)
		throws NoSuchPortletHitException, SystemException {
		return remove(Long.valueOf(hitId));
	}

	/**
	 * Removes the portlet hit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the portlet hit
	 * @return the portlet hit that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletHit remove(Serializable primaryKey)
		throws NoSuchPortletHitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortletHit portletHit = (PortletHit)session.get(PortletHitImpl.class,
					primaryKey);

			if (portletHit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortletHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portletHit);
		}
		catch (NoSuchPortletHitException nsee) {
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
	protected PortletHit removeImpl(PortletHit portletHit)
		throws SystemException {
		portletHit = toUnwrappedModel(portletHit);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, portletHit);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(portletHit);

		return portletHit;
	}

	@Override
	public PortletHit updateImpl(
		com.liferay.consistent.tracking.model.PortletHit portletHit,
		boolean merge) throws SystemException {
		portletHit = toUnwrappedModel(portletHit);

		boolean isNew = portletHit.isNew();

		PortletHitModelImpl portletHitModelImpl = (PortletHitModelImpl)portletHit;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, portletHit, merge);

			portletHit.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortletHitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portletHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletHitModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(portletHitModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((portletHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletHitModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(portletHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(portletHitModelImpl.getCompanyId()),
						Boolean.valueOf(portletHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((portletHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletHitModelImpl.getOriginalCompanyId()),
						
						portletHitModelImpl.getOriginalPortletId(),
						Boolean.valueOf(portletHitModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G,
					args);

				args = new Object[] {
						Long.valueOf(portletHitModelImpl.getCompanyId()),
						
						portletHitModelImpl.getPortletId(),
						Boolean.valueOf(portletHitModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G,
					args);
			}

			if ((portletHitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletHitModelImpl.getOriginalCompanyId()),
						
						portletHitModelImpl.getOriginalPortletId(),
						Long.valueOf(portletHitModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_U,
					args);

				args = new Object[] {
						Long.valueOf(portletHitModelImpl.getCompanyId()),
						
						portletHitModelImpl.getPortletId(),
						Long.valueOf(portletHitModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_U,
					args);
			}
		}

		EntityCacheUtil.putResult(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
			PortletHitImpl.class, portletHit.getPrimaryKey(), portletHit);

		return portletHit;
	}

	protected PortletHit toUnwrappedModel(PortletHit portletHit) {
		if (portletHit instanceof PortletHitImpl) {
			return portletHit;
		}

		PortletHitImpl portletHitImpl = new PortletHitImpl();

		portletHitImpl.setNew(portletHit.isNew());
		portletHitImpl.setPrimaryKey(portletHit.getPrimaryKey());

		portletHitImpl.setHitId(portletHit.getHitId());
		portletHitImpl.setCompanyId(portletHit.getCompanyId());
		portletHitImpl.setPortletId(portletHit.getPortletId());
		portletHitImpl.setGuest(portletHit.isGuest());
		portletHitImpl.setUserId(portletHit.getUserId());
		portletHitImpl.setUserlogId(portletHit.getUserlogId());
		portletHitImpl.setAccessDate(portletHit.getAccessDate());

		return portletHitImpl;
	}

	/**
	 * Returns the portlet hit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet hit
	 * @return the portlet hit
	 * @throws com.liferay.portal.NoSuchModelException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletHit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet hit with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchPortletHitException} if it could not be found.
	 *
	 * @param hitId the primary key of the portlet hit
	 * @return the portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByPrimaryKey(long hitId)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByPrimaryKey(hitId);

		if (portletHit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hitId);
			}

			throw new NoSuchPortletHitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				hitId);
		}

		return portletHit;
	}

	/**
	 * Returns the portlet hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet hit
	 * @return the portlet hit, or <code>null</code> if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletHit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet hit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hitId the primary key of the portlet hit
	 * @return the portlet hit, or <code>null</code> if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByPrimaryKey(long hitId) throws SystemException {
		PortletHit portletHit = (PortletHit)EntityCacheUtil.getResult(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
				PortletHitImpl.class, hitId);

		if (portletHit == _nullPortletHit) {
			return null;
		}

		if (portletHit == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				portletHit = (PortletHit)session.get(PortletHitImpl.class,
						Long.valueOf(hitId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (portletHit != null) {
					cacheResult(portletHit);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PortletHitModelImpl.ENTITY_CACHE_ENABLED,
						PortletHitImpl.class, hitId, _nullPortletHit);
				}

				closeSession(session);
			}
		}

		return portletHit;
	}

	/**
	 * Returns all the portlet hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the portlet hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @return the range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet hits where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByCompanyId(long companyId, int start, int end,
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

		List<PortletHit> list = (List<PortletHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletHit portletHit : list) {
				if ((companyId != portletHit.getCompanyId())) {
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

			query.append(_SQL_SELECT_PORTLETHIT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<PortletHit>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first portlet hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the first portlet hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortletHit> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<PortletHit> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63;.
	 *
	 * @param hitId the primary key of the current portlet hit
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit[] findByCompanyId_PrevAndNext(long hitId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			PortletHit[] array = new PortletHitImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, portletHit,
					companyId, orderByComparator, true);

			array[1] = portletHit;

			array[2] = getByCompanyId_PrevAndNext(session, portletHit,
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

	protected PortletHit getByCompanyId_PrevAndNext(Session session,
		PortletHit portletHit, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETHIT_WHERE);

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
			query.append(PortletHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_G(long companyId, boolean guest)
		throws SystemException {
		return findByC_G(companyId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @return the range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_G(long companyId, boolean guest, int start,
		int end) throws SystemException {
		return findByC_G(companyId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet hits where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_G(long companyId, boolean guest, int start,
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

		List<PortletHit> list = (List<PortletHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletHit portletHit : list) {
				if ((companyId != portletHit.getCompanyId()) ||
						(guest != portletHit.getGuest())) {
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

			query.append(_SQL_SELECT_PORTLETHIT_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(guest);

				list = (List<PortletHit>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByC_G_First(companyId, guest,
				orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the first portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortletHit> list = findByC_G(companyId, guest, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByC_G_Last(companyId, guest,
				orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, guest);

		List<PortletHit> list = findByC_G(companyId, guest, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current portlet hit
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit[] findByC_G_PrevAndNext(long hitId, long companyId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			PortletHit[] array = new PortletHitImpl[3];

			array[0] = getByC_G_PrevAndNext(session, portletHit, companyId,
					guest, orderByComparator, true);

			array[1] = portletHit;

			array[2] = getByC_G_PrevAndNext(session, portletHit, companyId,
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

	protected PortletHit getByC_G_PrevAndNext(Session session,
		PortletHit portletHit, long companyId, boolean guest,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETHIT_WHERE);

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
			query.append(PortletHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @return the matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_P_G(long companyId, String portletId,
		boolean guest) throws SystemException {
		return findByC_P_G(companyId, portletId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @return the range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_P_G(long companyId, String portletId,
		boolean guest, int start, int end) throws SystemException {
		return findByC_P_G(companyId, portletId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_P_G(long companyId, String portletId,
		boolean guest, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_G;
			finderArgs = new Object[] { companyId, portletId, guest };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P_G;
			finderArgs = new Object[] {
					companyId, portletId, guest,
					
					start, end, orderByComparator
				};
		}

		List<PortletHit> list = (List<PortletHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletHit portletHit : list) {
				if ((companyId != portletHit.getCompanyId()) ||
						!Validator.equals(portletId, portletHit.getPortletId()) ||
						(guest != portletHit.getGuest())) {
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

			query.append(_SQL_SELECT_PORTLETHIT_WHERE);

			query.append(_FINDER_COLUMN_C_P_G_COMPANYID_2);

			if (portletId == null) {
				query.append(_FINDER_COLUMN_C_P_G_PORTLETID_1);
			}
			else {
				if (portletId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_P_G_PORTLETID_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_P_G_PORTLETID_2);
				}
			}

			query.append(_FINDER_COLUMN_C_P_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (portletId != null) {
					qPos.add(portletId);
				}

				qPos.add(guest);

				list = (List<PortletHit>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByC_P_G_First(long companyId, String portletId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByC_P_G_First(companyId, portletId, guest,
				orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", portletId=");
		msg.append(portletId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByC_P_G_First(long companyId, String portletId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		List<PortletHit> list = findByC_P_G(companyId, portletId, guest, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByC_P_G_Last(long companyId, String portletId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByC_P_G_Last(companyId, portletId, guest,
				orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", portletId=");
		msg.append(portletId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByC_P_G_Last(long companyId, String portletId,
		boolean guest, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_P_G(companyId, portletId, guest);

		List<PortletHit> list = findByC_P_G(companyId, portletId, guest,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * @param hitId the primary key of the current portlet hit
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit[] findByC_P_G_PrevAndNext(long hitId, long companyId,
		String portletId, boolean guest, OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			PortletHit[] array = new PortletHitImpl[3];

			array[0] = getByC_P_G_PrevAndNext(session, portletHit, companyId,
					portletId, guest, orderByComparator, true);

			array[1] = portletHit;

			array[2] = getByC_P_G_PrevAndNext(session, portletHit, companyId,
					portletId, guest, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletHit getByC_P_G_PrevAndNext(Session session,
		PortletHit portletHit, long companyId, String portletId, boolean guest,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETHIT_WHERE);

		query.append(_FINDER_COLUMN_C_P_G_COMPANYID_2);

		if (portletId == null) {
			query.append(_FINDER_COLUMN_C_P_G_PORTLETID_1);
		}
		else {
			if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_P_G_PORTLETID_3);
			}
			else {
				query.append(_FINDER_COLUMN_C_P_G_PORTLETID_2);
			}
		}

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
			query.append(PortletHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (portletId != null) {
			qPos.add(portletId);
		}

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @return the matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_P_U(long companyId, String portletId,
		long userId) throws SystemException {
		return findByC_P_U(companyId, portletId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @return the range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_P_U(long companyId, String portletId,
		long userId, int start, int end) throws SystemException {
		return findByC_P_U(companyId, portletId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findByC_P_U(long companyId, String portletId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P_U;
			finderArgs = new Object[] { companyId, portletId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P_U;
			finderArgs = new Object[] {
					companyId, portletId, userId,
					
					start, end, orderByComparator
				};
		}

		List<PortletHit> list = (List<PortletHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletHit portletHit : list) {
				if ((companyId != portletHit.getCompanyId()) ||
						!Validator.equals(portletId, portletHit.getPortletId()) ||
						(userId != portletHit.getUserId())) {
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

			query.append(_SQL_SELECT_PORTLETHIT_WHERE);

			query.append(_FINDER_COLUMN_C_P_U_COMPANYID_2);

			if (portletId == null) {
				query.append(_FINDER_COLUMN_C_P_U_PORTLETID_1);
			}
			else {
				if (portletId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_P_U_PORTLETID_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_P_U_PORTLETID_2);
				}
			}

			query.append(_FINDER_COLUMN_C_P_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletHitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (portletId != null) {
					qPos.add(portletId);
				}

				qPos.add(userId);

				list = (List<PortletHit>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByC_P_U_First(long companyId, String portletId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByC_P_U_First(companyId, portletId,
				userId, orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", portletId=");
		msg.append(portletId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the first portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByC_P_U_First(long companyId, String portletId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PortletHit> list = findByC_P_U(companyId, portletId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit findByC_P_U_Last(long companyId, String portletId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = fetchByC_P_U_Last(companyId, portletId, userId,
				orderByComparator);

		if (portletHit != null) {
			return portletHit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", portletId=");
		msg.append(portletId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletHitException(msg.toString());
	}

	/**
	 * Returns the last portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet hit, or <code>null</code> if a matching portlet hit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit fetchByC_P_U_Last(long companyId, String portletId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_P_U(companyId, portletId, userId);

		List<PortletHit> list = findByC_P_U(companyId, portletId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portlet hits before and after the current portlet hit in the ordered set where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * @param hitId the primary key of the current portlet hit
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet hit
	 * @throws com.liferay.consistent.tracking.NoSuchPortletHitException if a portlet hit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletHit[] findByC_P_U_PrevAndNext(long hitId, long companyId,
		String portletId, long userId, OrderByComparator orderByComparator)
		throws NoSuchPortletHitException, SystemException {
		PortletHit portletHit = findByPrimaryKey(hitId);

		Session session = null;

		try {
			session = openSession();

			PortletHit[] array = new PortletHitImpl[3];

			array[0] = getByC_P_U_PrevAndNext(session, portletHit, companyId,
					portletId, userId, orderByComparator, true);

			array[1] = portletHit;

			array[2] = getByC_P_U_PrevAndNext(session, portletHit, companyId,
					portletId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletHit getByC_P_U_PrevAndNext(Session session,
		PortletHit portletHit, long companyId, String portletId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETHIT_WHERE);

		query.append(_FINDER_COLUMN_C_P_U_COMPANYID_2);

		if (portletId == null) {
			query.append(_FINDER_COLUMN_C_P_U_PORTLETID_1);
		}
		else {
			if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_P_U_PORTLETID_3);
			}
			else {
				query.append(_FINDER_COLUMN_C_P_U_PORTLETID_2);
			}
		}

		query.append(_FINDER_COLUMN_C_P_U_USERID_2);

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
			query.append(PortletHitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (portletId != null) {
			qPos.add(portletId);
		}

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletHit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletHit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet hits.
	 *
	 * @return the portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @return the range of portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet hits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet hits
	 * @param end the upper bound of the range of portlet hits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletHit> findAll(int start, int end,
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

		List<PortletHit> list = (List<PortletHit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTLETHIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTLETHIT.concat(PortletHitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PortletHit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PortletHit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the portlet hits where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (PortletHit portletHit : findByCompanyId(companyId)) {
			remove(portletHit);
		}
	}

	/**
	 * Removes all the portlet hits where companyId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, boolean guest)
		throws SystemException {
		for (PortletHit portletHit : findByC_G(companyId, guest)) {
			remove(portletHit);
		}
	}

	/**
	 * Removes all the portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_P_G(long companyId, String portletId, boolean guest)
		throws SystemException {
		for (PortletHit portletHit : findByC_P_G(companyId, portletId, guest)) {
			remove(portletHit);
		}
	}

	/**
	 * Removes all the portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_P_U(long companyId, String portletId, long userId)
		throws SystemException {
		for (PortletHit portletHit : findByC_P_U(companyId, portletId, userId)) {
			remove(portletHit);
		}
	}

	/**
	 * Removes all the portlet hits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PortletHit portletHit : findAll()) {
			remove(portletHit);
		}
	}

	/**
	 * Returns the number of portlet hits where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTLETHIT_WHERE);

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
	 * Returns the number of portlet hits where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the number of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PORTLETHIT_WHERE);

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
	 * Returns the number of portlet hits where companyId = &#63; and portletId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param guest the guest
	 * @return the number of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_P_G(long companyId, String portletId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, portletId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_P_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PORTLETHIT_WHERE);

			query.append(_FINDER_COLUMN_C_P_G_COMPANYID_2);

			if (portletId == null) {
				query.append(_FINDER_COLUMN_C_P_G_PORTLETID_1);
			}
			else {
				if (portletId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_P_G_PORTLETID_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_P_G_PORTLETID_2);
				}
			}

			query.append(_FINDER_COLUMN_C_P_G_GUEST_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (portletId != null) {
					qPos.add(portletId);
				}

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
	 * Returns the number of portlet hits where companyId = &#63; and portletId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param userId the user ID
	 * @return the number of matching portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_P_U(long companyId, String portletId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, portletId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_P_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PORTLETHIT_WHERE);

			query.append(_FINDER_COLUMN_C_P_U_COMPANYID_2);

			if (portletId == null) {
				query.append(_FINDER_COLUMN_C_P_U_PORTLETID_1);
			}
			else {
				if (portletId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_P_U_PORTLETID_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_P_U_PORTLETID_2);
				}
			}

			query.append(_FINDER_COLUMN_C_P_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (portletId != null) {
					qPos.add(portletId);
				}

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_P_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portlet hits.
	 *
	 * @return the number of portlet hits
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PORTLETHIT);

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
	 * Initializes the portlet hit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.PortletHit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortletHit>> listenersList = new ArrayList<ModelListener<PortletHit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortletHit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortletHitImpl.class.getName());
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
	private static final String _SQL_SELECT_PORTLETHIT = "SELECT portletHit FROM PortletHit portletHit";
	private static final String _SQL_SELECT_PORTLETHIT_WHERE = "SELECT portletHit FROM PortletHit portletHit WHERE ";
	private static final String _SQL_COUNT_PORTLETHIT = "SELECT COUNT(portletHit) FROM PortletHit portletHit";
	private static final String _SQL_COUNT_PORTLETHIT_WHERE = "SELECT COUNT(portletHit) FROM PortletHit portletHit WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "portletHit.companyId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "portletHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GUEST_2 = "portletHit.guest = ?";
	private static final String _FINDER_COLUMN_C_P_G_COMPANYID_2 = "portletHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_G_PORTLETID_1 = "portletHit.portletId IS NULL AND ";
	private static final String _FINDER_COLUMN_C_P_G_PORTLETID_2 = "portletHit.portletId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_G_PORTLETID_3 = "(portletHit.portletId IS NULL OR portletHit.portletId = ?) AND ";
	private static final String _FINDER_COLUMN_C_P_G_GUEST_2 = "portletHit.guest = ?";
	private static final String _FINDER_COLUMN_C_P_U_COMPANYID_2 = "portletHit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_U_PORTLETID_1 = "portletHit.portletId IS NULL AND ";
	private static final String _FINDER_COLUMN_C_P_U_PORTLETID_2 = "portletHit.portletId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_U_PORTLETID_3 = "(portletHit.portletId IS NULL OR portletHit.portletId = ?) AND ";
	private static final String _FINDER_COLUMN_C_P_U_USERID_2 = "portletHit.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portletHit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortletHit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortletHit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortletHitPersistenceImpl.class);
	private static PortletHit _nullPortletHit = new PortletHitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortletHit> toCacheModel() {
				return _nullPortletHitCacheModel;
			}
		};

	private static CacheModel<PortletHit> _nullPortletHitCacheModel = new CacheModel<PortletHit>() {
			public PortletHit toEntityModel() {
				return _nullPortletHit;
			}
		};
}