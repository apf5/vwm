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

import com.liferay.consistent.tracking.NoSuchOSException;
import com.liferay.consistent.tracking.model.OS;
import com.liferay.consistent.tracking.model.impl.OSImpl;
import com.liferay.consistent.tracking.model.impl.OSModelImpl;

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
 * The persistence implementation for the o s service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see OSPersistence
 * @see OSUtil
 * @generated
 */
public class OSPersistenceImpl extends BasePersistenceImpl<OS>
	implements OSPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OSUtil} to access the o s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OSImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, OSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, OSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			OSModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_N_V = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, OSImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByN_V",
			new String[] { String.class.getName(), String.class.getName() },
			OSModelImpl.NAME_COLUMN_BITMASK |
			OSModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_N_V = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_V",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, OSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, OSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the o s in the entity cache if it is enabled.
	 *
	 * @param os the o s
	 */
	public void cacheResult(OS os) {
		EntityCacheUtil.putResult(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSImpl.class, os.getPrimaryKey(), os);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_V,
			new Object[] { os.getName(), os.getVersion() }, os);

		os.resetOriginalValues();
	}

	/**
	 * Caches the o ses in the entity cache if it is enabled.
	 *
	 * @param oses the o ses
	 */
	public void cacheResult(List<OS> oses) {
		for (OS os : oses) {
			if (EntityCacheUtil.getResult(OSModelImpl.ENTITY_CACHE_ENABLED,
						OSImpl.class, os.getPrimaryKey()) == null) {
				cacheResult(os);
			}
			else {
				os.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all o ses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OSImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OSImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the o s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OS os) {
		EntityCacheUtil.removeResult(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSImpl.class, os.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(os);
	}

	@Override
	public void clearCache(List<OS> oses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OS os : oses) {
			EntityCacheUtil.removeResult(OSModelImpl.ENTITY_CACHE_ENABLED,
				OSImpl.class, os.getPrimaryKey());

			clearUniqueFindersCache(os);
		}
	}

	protected void clearUniqueFindersCache(OS os) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_N_V,
			new Object[] { os.getName(), os.getVersion() });
	}

	/**
	 * Creates a new o s with the primary key. Does not add the o s to the database.
	 *
	 * @param osId the primary key for the new o s
	 * @return the new o s
	 */
	public OS create(long osId) {
		OS os = new OSImpl();

		os.setNew(true);
		os.setPrimaryKey(osId);

		return os;
	}

	/**
	 * Removes the o s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param osId the primary key of the o s
	 * @return the o s that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS remove(long osId) throws NoSuchOSException, SystemException {
		return remove(Long.valueOf(osId));
	}

	/**
	 * Removes the o s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the o s
	 * @return the o s that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OS remove(Serializable primaryKey)
		throws NoSuchOSException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OS os = (OS)session.get(OSImpl.class, primaryKey);

			if (os == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(os);
		}
		catch (NoSuchOSException nsee) {
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
	protected OS removeImpl(OS os) throws SystemException {
		os = toUnwrappedModel(os);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, os);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(os);

		return os;
	}

	@Override
	public OS updateImpl(com.liferay.consistent.tracking.model.OS os,
		boolean merge) throws SystemException {
		os = toUnwrappedModel(os);

		boolean isNew = os.isNew();

		OSModelImpl osModelImpl = (OSModelImpl)os;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, os, merge);

			os.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OSModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((osModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { osModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { osModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(OSModelImpl.ENTITY_CACHE_ENABLED,
			OSImpl.class, os.getPrimaryKey(), os);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_V,
				new Object[] { os.getName(), os.getVersion() }, os);
		}
		else {
			if ((osModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_N_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						osModelImpl.getOriginalName(),
						
						osModelImpl.getOriginalVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_V, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_N_V, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_V,
					new Object[] { os.getName(), os.getVersion() }, os);
			}
		}

		return os;
	}

	protected OS toUnwrappedModel(OS os) {
		if (os instanceof OSImpl) {
			return os;
		}

		OSImpl osImpl = new OSImpl();

		osImpl.setNew(os.isNew());
		osImpl.setPrimaryKey(os.getPrimaryKey());

		osImpl.setOsId(os.getOsId());
		osImpl.setName(os.getName());
		osImpl.setVersion(os.getVersion());

		return osImpl;
	}

	/**
	 * Returns the o s with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the o s
	 * @return the o s
	 * @throws com.liferay.portal.NoSuchModelException if a o s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the o s with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchOSException} if it could not be found.
	 *
	 * @param osId the primary key of the o s
	 * @return the o s
	 * @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS findByPrimaryKey(long osId)
		throws NoSuchOSException, SystemException {
		OS os = fetchByPrimaryKey(osId);

		if (os == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + osId);
			}

			throw new NoSuchOSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				osId);
		}

		return os;
	}

	/**
	 * Returns the o s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the o s
	 * @return the o s, or <code>null</code> if a o s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OS fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the o s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param osId the primary key of the o s
	 * @return the o s, or <code>null</code> if a o s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS fetchByPrimaryKey(long osId) throws SystemException {
		OS os = (OS)EntityCacheUtil.getResult(OSModelImpl.ENTITY_CACHE_ENABLED,
				OSImpl.class, osId);

		if (os == _nullOS) {
			return null;
		}

		if (os == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				os = (OS)session.get(OSImpl.class, Long.valueOf(osId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (os != null) {
					cacheResult(os);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OSModelImpl.ENTITY_CACHE_ENABLED,
						OSImpl.class, osId, _nullOS);
				}

				closeSession(session);
			}
		}

		return os;
	}

	/**
	 * Returns all the o ses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching o ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<OS> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the o ses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of o ses
	 * @param end the upper bound of the range of o ses (not inclusive)
	 * @return the range of matching o ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<OS> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the o ses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of o ses
	 * @param end the upper bound of the range of o ses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<OS> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<OS> list = (List<OS>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OS os : list) {
				if (!Validator.equals(name, os.getName())) {
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

			query.append(_SQL_SELECT_OS_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<OS>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first o s in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o s
	 * @throws com.liferay.consistent.tracking.NoSuchOSException if a matching o s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS findByName_First(String name, OrderByComparator orderByComparator)
		throws NoSuchOSException, SystemException {
		OS os = fetchByName_First(name, orderByComparator);

		if (os != null) {
			return os;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOSException(msg.toString());
	}

	/**
	 * Returns the first o s in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o s, or <code>null</code> if a matching o s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS fetchByName_First(String name, OrderByComparator orderByComparator)
		throws SystemException {
		List<OS> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last o s in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o s
	 * @throws com.liferay.consistent.tracking.NoSuchOSException if a matching o s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS findByName_Last(String name, OrderByComparator orderByComparator)
		throws NoSuchOSException, SystemException {
		OS os = fetchByName_Last(name, orderByComparator);

		if (os != null) {
			return os;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOSException(msg.toString());
	}

	/**
	 * Returns the last o s in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o s, or <code>null</code> if a matching o s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS fetchByName_Last(String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByName(name);

		List<OS> list = findByName(name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the o ses before and after the current o s in the ordered set where name = &#63;.
	 *
	 * @param osId the primary key of the current o s
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o s
	 * @throws com.liferay.consistent.tracking.NoSuchOSException if a o s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS[] findByName_PrevAndNext(long osId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchOSException, SystemException {
		OS os = findByPrimaryKey(osId);

		Session session = null;

		try {
			session = openSession();

			OS[] array = new OSImpl[3];

			array[0] = getByName_PrevAndNext(session, os, name,
					orderByComparator, true);

			array[1] = os;

			array[2] = getByName_PrevAndNext(session, os, name,
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

	protected OS getByName_PrevAndNext(Session session, OS os, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OS_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(OSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(os);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the o s where name = &#63; and version = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchOSException} if it could not be found.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the matching o s
	 * @throws com.liferay.consistent.tracking.NoSuchOSException if a matching o s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS findByN_V(String name, String version)
		throws NoSuchOSException, SystemException {
		OS os = fetchByN_V(name, version);

		if (os == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", version=");
			msg.append(version);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOSException(msg.toString());
		}

		return os;
	}

	/**
	 * Returns the o s where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the matching o s, or <code>null</code> if a matching o s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS fetchByN_V(String name, String version) throws SystemException {
		return fetchByN_V(name, version, true);
	}

	/**
	 * Returns the o s where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param version the version
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching o s, or <code>null</code> if a matching o s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OS fetchByN_V(String name, String version, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, version };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_N_V,
					finderArgs, this);
		}

		if (result instanceof OS) {
			OS os = (OS)result;

			if (!Validator.equals(name, os.getName()) ||
					!Validator.equals(version, os.getVersion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_OS_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_N_V_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_V_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_V_NAME_2);
				}
			}

			if (version == null) {
				query.append(_FINDER_COLUMN_N_V_VERSION_1);
			}
			else {
				if (version.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_V_VERSION_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_V_VERSION_2);
				}
			}

			query.append(OSModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (version != null) {
					qPos.add(version);
				}

				List<OS> list = q.list();

				result = list;

				OS os = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_V,
						finderArgs, list);
				}
				else {
					os = list.get(0);

					cacheResult(os);

					if ((os.getName() == null) || !os.getName().equals(name) ||
							(os.getVersion() == null) ||
							!os.getVersion().equals(version)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_V,
							finderArgs, os);
					}
				}

				return os;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_N_V,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (OS)result;
			}
		}
	}

	/**
	 * Returns all the o ses.
	 *
	 * @return the o ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<OS> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the o ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of o ses
	 * @param end the upper bound of the range of o ses (not inclusive)
	 * @return the range of o ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<OS> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the o ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of o ses
	 * @param end the upper bound of the range of o ses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of o ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<OS> findAll(int start, int end,
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

		List<OS> list = (List<OS>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OS.concat(OSModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<OS>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OS>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the o ses where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name) throws SystemException {
		for (OS os : findByName(name)) {
			remove(os);
		}
	}

	/**
	 * Removes the o s where name = &#63; and version = &#63; from the database.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the o s that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public OS removeByN_V(String name, String version)
		throws NoSuchOSException, SystemException {
		OS os = findByN_V(name, version);

		return remove(os);
	}

	/**
	 * Removes all the o ses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (OS os : findAll()) {
			remove(os);
		}
	}

	/**
	 * Returns the number of o ses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching o ses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OS_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o ses where name = &#63; and version = &#63;.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the number of matching o ses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByN_V(String name, String version)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, version };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_N_V,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OS_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_N_V_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_V_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_V_NAME_2);
				}
			}

			if (version == null) {
				query.append(_FINDER_COLUMN_N_V_VERSION_1);
			}
			else {
				if (version.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_V_VERSION_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_V_VERSION_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (version != null) {
					qPos.add(version);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_N_V, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o ses.
	 *
	 * @return the number of o ses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OS);

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
	 * Initializes the o s persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.OS")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OS>> listenersList = new ArrayList<ModelListener<OS>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OS>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OSImpl.class.getName());
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
	private static final String _SQL_SELECT_OS = "SELECT os FROM OS os";
	private static final String _SQL_SELECT_OS_WHERE = "SELECT os FROM OS os WHERE ";
	private static final String _SQL_COUNT_OS = "SELECT COUNT(os) FROM OS os";
	private static final String _SQL_COUNT_OS_WHERE = "SELECT COUNT(os) FROM OS os WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "os.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "os.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(os.name IS NULL OR os.name = ?)";
	private static final String _FINDER_COLUMN_N_V_NAME_1 = "os.name IS NULL AND ";
	private static final String _FINDER_COLUMN_N_V_NAME_2 = "os.name = ? AND ";
	private static final String _FINDER_COLUMN_N_V_NAME_3 = "(os.name IS NULL OR os.name = ?) AND ";
	private static final String _FINDER_COLUMN_N_V_VERSION_1 = "os.version IS NULL";
	private static final String _FINDER_COLUMN_N_V_VERSION_2 = "os.version = ?";
	private static final String _FINDER_COLUMN_N_V_VERSION_3 = "(os.version IS NULL OR os.version = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "os.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OS exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OS exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OSPersistenceImpl.class);
	private static OS _nullOS = new OSImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OS> toCacheModel() {
				return _nullOSCacheModel;
			}
		};

	private static CacheModel<OS> _nullOSCacheModel = new CacheModel<OS>() {
			public OS toEntityModel() {
				return _nullOS;
			}
		};
}