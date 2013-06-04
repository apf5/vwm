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

import com.liferay.consistent.tracking.NoSuchUserlogException;
import com.liferay.consistent.tracking.model.Userlog;
import com.liferay.consistent.tracking.model.impl.UserlogImpl;
import com.liferay.consistent.tracking.model.impl.UserlogModelImpl;

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
 * The persistence implementation for the userlog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see UserlogPersistence
 * @see UserlogUtil
 * @generated
 */
public class UserlogPersistenceImpl extends BasePersistenceImpl<Userlog>
	implements UserlogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserlogUtil} to access the userlog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserlogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			UserlogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			UserlogModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OSID = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOSId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OSID = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOSId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserlogModelImpl.COMPANYID_COLUMN_BITMASK |
			UserlogModelImpl.OSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OSID = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOSId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OS_MANUFACTURER =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOS_Manufacturer",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_MANUFACTURER =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOS_Manufacturer",
			new String[] { Long.class.getName(), String.class.getName() },
			UserlogModelImpl.COMPANYID_COLUMN_BITMASK |
			UserlogModelImpl.OSMANUFACTURER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OS_MANUFACTURER = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOS_Manufacturer",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BROWSERID =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrowserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSERID =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrowserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserlogModelImpl.COMPANYID_COLUMN_BITMASK |
			UserlogModelImpl.BROWSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BROWSERID = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrowserId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BROWSER_N_V =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrowser_N_V",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_N_V =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrowser_N_V",
			new String[] { Long.class.getName(), String.class.getName() },
			UserlogModelImpl.BROWSERID_COLUMN_BITMASK |
			UserlogModelImpl.BROWSERVERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BROWSER_N_V = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrowser_N_V",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OS_U = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOS_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_U = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOS_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserlogModelImpl.OSID_COLUMN_BITMASK |
			UserlogModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OS_U = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOS_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BROWSER_U =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrowser_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_U =
		new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrowser_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserlogModelImpl.BROWSERID_COLUMN_BITMASK |
			UserlogModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BROWSER_U = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrowser_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, UserlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the userlog in the entity cache if it is enabled.
	 *
	 * @param userlog the userlog
	 */
	public void cacheResult(Userlog userlog) {
		EntityCacheUtil.putResult(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogImpl.class, userlog.getPrimaryKey(), userlog);

		userlog.resetOriginalValues();
	}

	/**
	 * Caches the userlogs in the entity cache if it is enabled.
	 *
	 * @param userlogs the userlogs
	 */
	public void cacheResult(List<Userlog> userlogs) {
		for (Userlog userlog : userlogs) {
			if (EntityCacheUtil.getResult(
						UserlogModelImpl.ENTITY_CACHE_ENABLED,
						UserlogImpl.class, userlog.getPrimaryKey()) == null) {
				cacheResult(userlog);
			}
			else {
				userlog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all userlogs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserlogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserlogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the userlog.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Userlog userlog) {
		EntityCacheUtil.removeResult(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogImpl.class, userlog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Userlog> userlogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Userlog userlog : userlogs) {
			EntityCacheUtil.removeResult(UserlogModelImpl.ENTITY_CACHE_ENABLED,
				UserlogImpl.class, userlog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new userlog with the primary key. Does not add the userlog to the database.
	 *
	 * @param userlogId the primary key for the new userlog
	 * @return the new userlog
	 */
	public Userlog create(long userlogId) {
		Userlog userlog = new UserlogImpl();

		userlog.setNew(true);
		userlog.setPrimaryKey(userlogId);

		return userlog;
	}

	/**
	 * Removes the userlog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userlogId the primary key of the userlog
	 * @return the userlog that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog remove(long userlogId)
		throws NoSuchUserlogException, SystemException {
		return remove(Long.valueOf(userlogId));
	}

	/**
	 * Removes the userlog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the userlog
	 * @return the userlog that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Userlog remove(Serializable primaryKey)
		throws NoSuchUserlogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Userlog userlog = (Userlog)session.get(UserlogImpl.class, primaryKey);

			if (userlog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserlogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userlog);
		}
		catch (NoSuchUserlogException nsee) {
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
	protected Userlog removeImpl(Userlog userlog) throws SystemException {
		userlog = toUnwrappedModel(userlog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userlog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userlog);

		return userlog;
	}

	@Override
	public Userlog updateImpl(
		com.liferay.consistent.tracking.model.Userlog userlog, boolean merge)
		throws SystemException {
		userlog = toUnwrappedModel(userlog);

		boolean isNew = userlog.isNew();

		UserlogModelImpl userlogModelImpl = (UserlogModelImpl)userlog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userlog, merge);

			userlog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserlogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(userlogModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { Long.valueOf(userlogModelImpl.getUserId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalCompanyId()),
						Long.valueOf(userlogModelImpl.getOriginalOsId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OSID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OSID,
					args);

				args = new Object[] {
						Long.valueOf(userlogModelImpl.getCompanyId()),
						Long.valueOf(userlogModelImpl.getOsId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OSID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OSID,
					args);
			}

			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_MANUFACTURER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalCompanyId()),
						
						userlogModelImpl.getOriginalOsManufacturer()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OS_MANUFACTURER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_MANUFACTURER,
					args);

				args = new Object[] {
						Long.valueOf(userlogModelImpl.getCompanyId()),
						
						userlogModelImpl.getOsManufacturer()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OS_MANUFACTURER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_MANUFACTURER,
					args);
			}

			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalCompanyId()),
						Long.valueOf(userlogModelImpl.getOriginalBrowserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROWSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSERID,
					args);

				args = new Object[] {
						Long.valueOf(userlogModelImpl.getCompanyId()),
						Long.valueOf(userlogModelImpl.getBrowserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROWSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSERID,
					args);
			}

			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_N_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalBrowserId()),
						
						userlogModelImpl.getOriginalBrowserVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROWSER_N_V,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_N_V,
					args);

				args = new Object[] {
						Long.valueOf(userlogModelImpl.getBrowserId()),
						
						userlogModelImpl.getBrowserVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROWSER_N_V,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_N_V,
					args);
			}

			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalOsId()),
						Long.valueOf(userlogModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OS_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_U,
					args);

				args = new Object[] {
						Long.valueOf(userlogModelImpl.getOsId()),
						Long.valueOf(userlogModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OS_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_U,
					args);
			}

			if ((userlogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userlogModelImpl.getOriginalBrowserId()),
						Long.valueOf(userlogModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROWSER_U,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_U,
					args);

				args = new Object[] {
						Long.valueOf(userlogModelImpl.getBrowserId()),
						Long.valueOf(userlogModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROWSER_U,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_U,
					args);
			}
		}

		EntityCacheUtil.putResult(UserlogModelImpl.ENTITY_CACHE_ENABLED,
			UserlogImpl.class, userlog.getPrimaryKey(), userlog);

		return userlog;
	}

	protected Userlog toUnwrappedModel(Userlog userlog) {
		if (userlog instanceof UserlogImpl) {
			return userlog;
		}

		UserlogImpl userlogImpl = new UserlogImpl();

		userlogImpl.setNew(userlog.isNew());
		userlogImpl.setPrimaryKey(userlog.getPrimaryKey());

		userlogImpl.setUserlogId(userlog.getUserlogId());
		userlogImpl.setCompanyId(userlog.getCompanyId());
		userlogImpl.setUserId(userlog.getUserId());
		userlogImpl.setUserName(userlog.getUserName());
		userlogImpl.setServerName(userlog.getServerName());
		userlogImpl.setServerPort(userlog.getServerPort());
		userlogImpl.setRemoteHost(userlog.getRemoteHost());
		userlogImpl.setRemoteAddress(userlog.getRemoteAddress());
		userlogImpl.setOsId(userlog.getOsId());
		userlogImpl.setOsManufacturer(userlog.getOsManufacturer());
		userlogImpl.setBrowserId(userlog.getBrowserId());
		userlogImpl.setBrowserVersion(userlog.getBrowserVersion());
		userlogImpl.setSessionId(userlog.getSessionId());
		userlogImpl.setAccessDate(userlog.getAccessDate());
		userlogImpl.setTimeSlapse(userlog.getTimeSlapse());

		return userlogImpl;
	}

	/**
	 * Returns the userlog with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the userlog
	 * @return the userlog
	 * @throws com.liferay.portal.NoSuchModelException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Userlog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the userlog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchUserlogException} if it could not be found.
	 *
	 * @param userlogId the primary key of the userlog
	 * @return the userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByPrimaryKey(long userlogId)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByPrimaryKey(userlogId);

		if (userlog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userlogId);
			}

			throw new NoSuchUserlogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userlogId);
		}

		return userlog;
	}

	/**
	 * Returns the userlog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the userlog
	 * @return the userlog, or <code>null</code> if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Userlog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the userlog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userlogId the primary key of the userlog
	 * @return the userlog, or <code>null</code> if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByPrimaryKey(long userlogId) throws SystemException {
		Userlog userlog = (Userlog)EntityCacheUtil.getResult(UserlogModelImpl.ENTITY_CACHE_ENABLED,
				UserlogImpl.class, userlogId);

		if (userlog == _nullUserlog) {
			return null;
		}

		if (userlog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userlog = (Userlog)session.get(UserlogImpl.class,
						Long.valueOf(userlogId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userlog != null) {
					cacheResult(userlog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserlogModelImpl.ENTITY_CACHE_ENABLED,
						UserlogImpl.class, userlogId, _nullUserlog);
				}

				closeSession(session);
			}
		}

		return userlog;
	}

	/**
	 * Returns all the userlogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the userlogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByCompanyId(long companyId, int start, int end,
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

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((companyId != userlog.getCompanyId())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByCompanyId_First(companyId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Userlog> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByCompanyId_Last(companyId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<Userlog> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByCompanyId_PrevAndNext(long userlogId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, userlog, companyId,
					orderByComparator, true);

			array[1] = userlog;

			array[2] = getByCompanyId_PrevAndNext(session, userlog, companyId,
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

	protected Userlog getByCompanyId_PrevAndNext(Session session,
		Userlog userlog, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userlogs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((userId != userlog.getUserId())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByUserId_First(userId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Userlog> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByUserId_Last(userId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<Userlog> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where userId = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByUserId_PrevAndNext(long userlogId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByUserId_PrevAndNext(session, userlog, userId,
					orderByComparator, true);

			array[1] = userlog;

			array[2] = getByUserId_PrevAndNext(session, userlog, userId,
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

	protected Userlog getByUserId_PrevAndNext(Session session, Userlog userlog,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs where companyId = &#63; and osId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOSId(long companyId, long osId)
		throws SystemException {
		return findByOSId(companyId, osId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userlogs where companyId = &#63; and osId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOSId(long companyId, long osId, int start,
		int end) throws SystemException {
		return findByOSId(companyId, osId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where companyId = &#63; and osId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOSId(long companyId, long osId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OSID;
			finderArgs = new Object[] { companyId, osId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OSID;
			finderArgs = new Object[] {
					companyId, osId,
					
					start, end, orderByComparator
				};
		}

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((companyId != userlog.getCompanyId()) ||
						(osId != userlog.getOsId())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_OSID_COMPANYID_2);

			query.append(_FINDER_COLUMN_OSID_OSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(osId);

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where companyId = &#63; and osId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByOSId_First(long companyId, long osId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByOSId_First(companyId, osId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", osId=");
		msg.append(osId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where companyId = &#63; and osId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByOSId_First(long companyId, long osId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Userlog> list = findByOSId(companyId, osId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63; and osId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByOSId_Last(long companyId, long osId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByOSId_Last(companyId, osId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", osId=");
		msg.append(osId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63; and osId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByOSId_Last(long companyId, long osId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOSId(companyId, osId);

		List<Userlog> list = findByOSId(companyId, osId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63; and osId = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByOSId_PrevAndNext(long userlogId, long companyId,
		long osId, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByOSId_PrevAndNext(session, userlog, companyId, osId,
					orderByComparator, true);

			array[1] = userlog;

			array[2] = getByOSId_PrevAndNext(session, userlog, companyId, osId,
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

	protected Userlog getByOSId_PrevAndNext(Session session, Userlog userlog,
		long companyId, long osId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

		query.append(_FINDER_COLUMN_OSID_COMPANYID_2);

		query.append(_FINDER_COLUMN_OSID_OSID_2);

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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(osId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOS_Manufacturer(long companyId,
		String osManufacturer) throws SystemException {
		return findByOS_Manufacturer(companyId, osManufacturer,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userlogs where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOS_Manufacturer(long companyId,
		String osManufacturer, int start, int end) throws SystemException {
		return findByOS_Manufacturer(companyId, osManufacturer, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOS_Manufacturer(long companyId,
		String osManufacturer, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_MANUFACTURER;
			finderArgs = new Object[] { companyId, osManufacturer };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OS_MANUFACTURER;
			finderArgs = new Object[] {
					companyId, osManufacturer,
					
					start, end, orderByComparator
				};
		}

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((companyId != userlog.getCompanyId()) ||
						!Validator.equals(osManufacturer,
							userlog.getOsManufacturer())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_OS_MANUFACTURER_COMPANYID_2);

			if (osManufacturer == null) {
				query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_1);
			}
			else {
				if (osManufacturer.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_3);
				}
				else {
					query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (osManufacturer != null) {
					qPos.add(osManufacturer);
				}

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByOS_Manufacturer_First(long companyId,
		String osManufacturer, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByOS_Manufacturer_First(companyId,
				osManufacturer, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", osManufacturer=");
		msg.append(osManufacturer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByOS_Manufacturer_First(long companyId,
		String osManufacturer, OrderByComparator orderByComparator)
		throws SystemException {
		List<Userlog> list = findByOS_Manufacturer(companyId, osManufacturer,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByOS_Manufacturer_Last(long companyId,
		String osManufacturer, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByOS_Manufacturer_Last(companyId,
				osManufacturer, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", osManufacturer=");
		msg.append(osManufacturer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByOS_Manufacturer_Last(long companyId,
		String osManufacturer, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOS_Manufacturer(companyId, osManufacturer);

		List<Userlog> list = findByOS_Manufacturer(companyId, osManufacturer,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByOS_Manufacturer_PrevAndNext(long userlogId,
		long companyId, String osManufacturer,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByOS_Manufacturer_PrevAndNext(session, userlog,
					companyId, osManufacturer, orderByComparator, true);

			array[1] = userlog;

			array[2] = getByOS_Manufacturer_PrevAndNext(session, userlog,
					companyId, osManufacturer, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Userlog getByOS_Manufacturer_PrevAndNext(Session session,
		Userlog userlog, long companyId, String osManufacturer,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

		query.append(_FINDER_COLUMN_OS_MANUFACTURER_COMPANYID_2);

		if (osManufacturer == null) {
			query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_1);
		}
		else {
			if (osManufacturer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_3);
			}
			else {
				query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_2);
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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (osManufacturer != null) {
			qPos.add(osManufacturer);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs where companyId = &#63; and browserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowserId(long companyId, long browserId)
		throws SystemException {
		return findByBrowserId(companyId, browserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userlogs where companyId = &#63; and browserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowserId(long companyId, long browserId,
		int start, int end) throws SystemException {
		return findByBrowserId(companyId, browserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where companyId = &#63; and browserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowserId(long companyId, long browserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSERID;
			finderArgs = new Object[] { companyId, browserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BROWSERID;
			finderArgs = new Object[] {
					companyId, browserId,
					
					start, end, orderByComparator
				};
		}

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((companyId != userlog.getCompanyId()) ||
						(browserId != userlog.getBrowserId())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_BROWSERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_BROWSERID_BROWSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(browserId);

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByBrowserId_First(long companyId, long browserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByBrowserId_First(companyId, browserId,
				orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", browserId=");
		msg.append(browserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByBrowserId_First(long companyId, long browserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Userlog> list = findByBrowserId(companyId, browserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByBrowserId_Last(long companyId, long browserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByBrowserId_Last(companyId, browserId,
				orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", browserId=");
		msg.append(browserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByBrowserId_Last(long companyId, long browserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBrowserId(companyId, browserId);

		List<Userlog> list = findByBrowserId(companyId, browserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where companyId = &#63; and browserId = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByBrowserId_PrevAndNext(long userlogId,
		long companyId, long browserId, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByBrowserId_PrevAndNext(session, userlog, companyId,
					browserId, orderByComparator, true);

			array[1] = userlog;

			array[2] = getByBrowserId_PrevAndNext(session, userlog, companyId,
					browserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Userlog getByBrowserId_PrevAndNext(Session session,
		Userlog userlog, long companyId, long browserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

		query.append(_FINDER_COLUMN_BROWSERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_BROWSERID_BROWSERID_2);

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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(browserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs where browserId = &#63; and browserVersion = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowser_N_V(long browserId, String browserVersion)
		throws SystemException {
		return findByBrowser_N_V(browserId, browserVersion, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userlogs where browserId = &#63; and browserVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowser_N_V(long browserId,
		String browserVersion, int start, int end) throws SystemException {
		return findByBrowser_N_V(browserId, browserVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where browserId = &#63; and browserVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowser_N_V(long browserId,
		String browserVersion, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_N_V;
			finderArgs = new Object[] { browserId, browserVersion };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BROWSER_N_V;
			finderArgs = new Object[] {
					browserId, browserVersion,
					
					start, end, orderByComparator
				};
		}

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((browserId != userlog.getBrowserId()) ||
						!Validator.equals(browserVersion,
							userlog.getBrowserVersion())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERID_2);

			if (browserVersion == null) {
				query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_1);
			}
			else {
				if (browserVersion.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_3);
				}
				else {
					query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(browserId);

				if (browserVersion != null) {
					qPos.add(browserVersion);
				}

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByBrowser_N_V_First(long browserId,
		String browserVersion, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByBrowser_N_V_First(browserId, browserVersion,
				orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("browserId=");
		msg.append(browserId);

		msg.append(", browserVersion=");
		msg.append(browserVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByBrowser_N_V_First(long browserId,
		String browserVersion, OrderByComparator orderByComparator)
		throws SystemException {
		List<Userlog> list = findByBrowser_N_V(browserId, browserVersion, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByBrowser_N_V_Last(long browserId,
		String browserVersion, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByBrowser_N_V_Last(browserId, browserVersion,
				orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("browserId=");
		msg.append(browserId);

		msg.append(", browserVersion=");
		msg.append(browserVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByBrowser_N_V_Last(long browserId,
		String browserVersion, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBrowser_N_V(browserId, browserVersion);

		List<Userlog> list = findByBrowser_N_V(browserId, browserVersion,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where browserId = &#63; and browserVersion = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByBrowser_N_V_PrevAndNext(long userlogId,
		long browserId, String browserVersion,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByBrowser_N_V_PrevAndNext(session, userlog,
					browserId, browserVersion, orderByComparator, true);

			array[1] = userlog;

			array[2] = getByBrowser_N_V_PrevAndNext(session, userlog,
					browserId, browserVersion, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Userlog getByBrowser_N_V_PrevAndNext(Session session,
		Userlog userlog, long browserId, String browserVersion,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

		query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERID_2);

		if (browserVersion == null) {
			query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_1);
		}
		else {
			if (browserVersion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_3);
			}
			else {
				query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_2);
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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(browserId);

		if (browserVersion != null) {
			qPos.add(browserVersion);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs where osId = &#63; and userId = &#63;.
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOS_U(long osId, long userId)
		throws SystemException {
		return findByOS_U(osId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the userlogs where osId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOS_U(long osId, long userId, int start, int end)
		throws SystemException {
		return findByOS_U(osId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where osId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByOS_U(long osId, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OS_U;
			finderArgs = new Object[] { osId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OS_U;
			finderArgs = new Object[] {
					osId, userId,
					
					start, end, orderByComparator
				};
		}

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((osId != userlog.getOsId()) ||
						(userId != userlog.getUserId())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_OS_U_OSID_2);

			query.append(_FINDER_COLUMN_OS_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(osId);

				qPos.add(userId);

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where osId = &#63; and userId = &#63;.
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByOS_U_First(long osId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByOS_U_First(osId, userId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("osId=");
		msg.append(osId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where osId = &#63; and userId = &#63;.
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByOS_U_First(long osId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Userlog> list = findByOS_U(osId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where osId = &#63; and userId = &#63;.
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByOS_U_Last(long osId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByOS_U_Last(osId, userId, orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("osId=");
		msg.append(osId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where osId = &#63; and userId = &#63;.
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByOS_U_Last(long osId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOS_U(osId, userId);

		List<Userlog> list = findByOS_U(osId, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where osId = &#63; and userId = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param osId the os ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByOS_U_PrevAndNext(long userlogId, long osId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByOS_U_PrevAndNext(session, userlog, osId, userId,
					orderByComparator, true);

			array[1] = userlog;

			array[2] = getByOS_U_PrevAndNext(session, userlog, osId, userId,
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

	protected Userlog getByOS_U_PrevAndNext(Session session, Userlog userlog,
		long osId, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

		query.append(_FINDER_COLUMN_OS_U_OSID_2);

		query.append(_FINDER_COLUMN_OS_U_USERID_2);

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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(osId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs where browserId = &#63; and userId = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @return the matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowser_U(long browserId, long userId)
		throws SystemException {
		return findByBrowser_U(browserId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userlogs where browserId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowser_U(long browserId, long userId,
		int start, int end) throws SystemException {
		return findByBrowser_U(browserId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs where browserId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findByBrowser_U(long browserId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROWSER_U;
			finderArgs = new Object[] { browserId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BROWSER_U;
			finderArgs = new Object[] {
					browserId, userId,
					
					start, end, orderByComparator
				};
		}

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Userlog userlog : list) {
				if ((browserId != userlog.getBrowserId()) ||
						(userId != userlog.getUserId())) {
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

			query.append(_SQL_SELECT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_BROWSER_U_BROWSERID_2);

			query.append(_FINDER_COLUMN_BROWSER_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserlogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(browserId);

				qPos.add(userId);

				list = (List<Userlog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first userlog in the ordered set where browserId = &#63; and userId = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByBrowser_U_First(long browserId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByBrowser_U_First(browserId, userId,
				orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("browserId=");
		msg.append(browserId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the first userlog in the ordered set where browserId = &#63; and userId = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByBrowser_U_First(long browserId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Userlog> list = findByBrowser_U(browserId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last userlog in the ordered set where browserId = &#63; and userId = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog findByBrowser_U_Last(long browserId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = fetchByBrowser_U_Last(browserId, userId,
				orderByComparator);

		if (userlog != null) {
			return userlog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("browserId=");
		msg.append(browserId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserlogException(msg.toString());
	}

	/**
	 * Returns the last userlog in the ordered set where browserId = &#63; and userId = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching userlog, or <code>null</code> if a matching userlog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog fetchByBrowser_U_Last(long browserId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBrowser_U(browserId, userId);

		List<Userlog> list = findByBrowser_U(browserId, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the userlogs before and after the current userlog in the ordered set where browserId = &#63; and userId = &#63;.
	 *
	 * @param userlogId the primary key of the current userlog
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next userlog
	 * @throws com.liferay.consistent.tracking.NoSuchUserlogException if a userlog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Userlog[] findByBrowser_U_PrevAndNext(long userlogId,
		long browserId, long userId, OrderByComparator orderByComparator)
		throws NoSuchUserlogException, SystemException {
		Userlog userlog = findByPrimaryKey(userlogId);

		Session session = null;

		try {
			session = openSession();

			Userlog[] array = new UserlogImpl[3];

			array[0] = getByBrowser_U_PrevAndNext(session, userlog, browserId,
					userId, orderByComparator, true);

			array[1] = userlog;

			array[2] = getByBrowser_U_PrevAndNext(session, userlog, browserId,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Userlog getByBrowser_U_PrevAndNext(Session session,
		Userlog userlog, long browserId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLOG_WHERE);

		query.append(_FINDER_COLUMN_BROWSER_U_BROWSERID_2);

		query.append(_FINDER_COLUMN_BROWSER_U_USERID_2);

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
			query.append(UserlogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(browserId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userlog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Userlog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the userlogs.
	 *
	 * @return the userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userlogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @return the range of userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the userlogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of userlogs
	 * @param end the upper bound of the range of userlogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Userlog> findAll(int start, int end,
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

		List<Userlog> list = (List<Userlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERLOG.concat(UserlogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Userlog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Userlog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the userlogs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Userlog userlog : findByCompanyId(companyId)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (Userlog userlog : findByUserId(userId)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs where companyId = &#63; and osId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOSId(long companyId, long osId)
		throws SystemException {
		for (Userlog userlog : findByOSId(companyId, osId)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs where companyId = &#63; and osManufacturer = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOS_Manufacturer(long companyId, String osManufacturer)
		throws SystemException {
		for (Userlog userlog : findByOS_Manufacturer(companyId, osManufacturer)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs where companyId = &#63; and browserId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBrowserId(long companyId, long browserId)
		throws SystemException {
		for (Userlog userlog : findByBrowserId(companyId, browserId)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs where browserId = &#63; and browserVersion = &#63; from the database.
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBrowser_N_V(long browserId, String browserVersion)
		throws SystemException {
		for (Userlog userlog : findByBrowser_N_V(browserId, browserVersion)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs where osId = &#63; and userId = &#63; from the database.
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOS_U(long osId, long userId) throws SystemException {
		for (Userlog userlog : findByOS_U(osId, userId)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs where browserId = &#63; and userId = &#63; from the database.
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBrowser_U(long browserId, long userId)
		throws SystemException {
		for (Userlog userlog : findByBrowser_U(browserId, userId)) {
			remove(userlog);
		}
	}

	/**
	 * Removes all the userlogs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Userlog userlog : findAll()) {
			remove(userlog);
		}
	}

	/**
	 * Returns the number of userlogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERLOG_WHERE);

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
	 * Returns the number of userlogs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of userlogs where companyId = &#63; and osId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osId the os ID
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOSId(long companyId, long osId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, osId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OSID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_OSID_COMPANYID_2);

			query.append(_FINDER_COLUMN_OSID_OSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(osId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OSID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of userlogs where companyId = &#63; and osManufacturer = &#63;.
	 *
	 * @param companyId the company ID
	 * @param osManufacturer the os manufacturer
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOS_Manufacturer(long companyId, String osManufacturer)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, osManufacturer };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OS_MANUFACTURER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_OS_MANUFACTURER_COMPANYID_2);

			if (osManufacturer == null) {
				query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_1);
			}
			else {
				if (osManufacturer.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_3);
				}
				else {
					query.append(_FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (osManufacturer != null) {
					qPos.add(osManufacturer);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OS_MANUFACTURER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of userlogs where companyId = &#63; and browserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param browserId the browser ID
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBrowserId(long companyId, long browserId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, browserId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BROWSERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_BROWSERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_BROWSERID_BROWSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(browserId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BROWSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of userlogs where browserId = &#63; and browserVersion = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param browserVersion the browser version
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBrowser_N_V(long browserId, String browserVersion)
		throws SystemException {
		Object[] finderArgs = new Object[] { browserId, browserVersion };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BROWSER_N_V,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERID_2);

			if (browserVersion == null) {
				query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_1);
			}
			else {
				if (browserVersion.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_3);
				}
				else {
					query.append(_FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(browserId);

				if (browserVersion != null) {
					qPos.add(browserVersion);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BROWSER_N_V,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of userlogs where osId = &#63; and userId = &#63;.
	 *
	 * @param osId the os ID
	 * @param userId the user ID
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOS_U(long osId, long userId) throws SystemException {
		Object[] finderArgs = new Object[] { osId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OS_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_OS_U_OSID_2);

			query.append(_FINDER_COLUMN_OS_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(osId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OS_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of userlogs where browserId = &#63; and userId = &#63;.
	 *
	 * @param browserId the browser ID
	 * @param userId the user ID
	 * @return the number of matching userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBrowser_U(long browserId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { browserId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BROWSER_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERLOG_WHERE);

			query.append(_FINDER_COLUMN_BROWSER_U_BROWSERID_2);

			query.append(_FINDER_COLUMN_BROWSER_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(browserId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BROWSER_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of userlogs.
	 *
	 * @return the number of userlogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERLOG);

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
	 * Initializes the userlog persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.Userlog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Userlog>> listenersList = new ArrayList<ModelListener<Userlog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Userlog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserlogImpl.class.getName());
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
	private static final String _SQL_SELECT_USERLOG = "SELECT userlog FROM Userlog userlog";
	private static final String _SQL_SELECT_USERLOG_WHERE = "SELECT userlog FROM Userlog userlog WHERE ";
	private static final String _SQL_COUNT_USERLOG = "SELECT COUNT(userlog) FROM Userlog userlog";
	private static final String _SQL_COUNT_USERLOG_WHERE = "SELECT COUNT(userlog) FROM Userlog userlog WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "userlog.companyId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userlog.userId = ?";
	private static final String _FINDER_COLUMN_OSID_COMPANYID_2 = "userlog.companyId = ? AND ";
	private static final String _FINDER_COLUMN_OSID_OSID_2 = "userlog.osId = ?";
	private static final String _FINDER_COLUMN_OS_MANUFACTURER_COMPANYID_2 = "userlog.companyId = ? AND ";
	private static final String _FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_1 = "userlog.osManufacturer IS NULL";
	private static final String _FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_2 = "userlog.osManufacturer = ?";
	private static final String _FINDER_COLUMN_OS_MANUFACTURER_OSMANUFACTURER_3 = "(userlog.osManufacturer IS NULL OR userlog.osManufacturer = ?)";
	private static final String _FINDER_COLUMN_BROWSERID_COMPANYID_2 = "userlog.companyId = ? AND ";
	private static final String _FINDER_COLUMN_BROWSERID_BROWSERID_2 = "userlog.browserId = ?";
	private static final String _FINDER_COLUMN_BROWSER_N_V_BROWSERID_2 = "userlog.browserId = ? AND ";
	private static final String _FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_1 = "userlog.browserVersion IS NULL";
	private static final String _FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_2 = "userlog.browserVersion = ?";
	private static final String _FINDER_COLUMN_BROWSER_N_V_BROWSERVERSION_3 = "(userlog.browserVersion IS NULL OR userlog.browserVersion = ?)";
	private static final String _FINDER_COLUMN_OS_U_OSID_2 = "userlog.osId = ? AND ";
	private static final String _FINDER_COLUMN_OS_U_USERID_2 = "userlog.userId = ?";
	private static final String _FINDER_COLUMN_BROWSER_U_BROWSERID_2 = "userlog.browserId = ? AND ";
	private static final String _FINDER_COLUMN_BROWSER_U_USERID_2 = "userlog.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userlog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Userlog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Userlog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserlogPersistenceImpl.class);
	private static Userlog _nullUserlog = new UserlogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Userlog> toCacheModel() {
				return _nullUserlogCacheModel;
			}
		};

	private static CacheModel<Userlog> _nullUserlogCacheModel = new CacheModel<Userlog>() {
			public Userlog toEntityModel() {
				return _nullUserlog;
			}
		};
}