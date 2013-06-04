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

import com.liferay.consistent.tracking.NoSuchFilelogException;
import com.liferay.consistent.tracking.model.Filelog;
import com.liferay.consistent.tracking.model.impl.FilelogImpl;
import com.liferay.consistent.tracking.model.impl.FilelogModelImpl;

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
 * The persistence implementation for the filelog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see FilelogPersistence
 * @see FilelogUtil
 * @generated
 */
public class FilelogPersistenceImpl extends BasePersistenceImpl<Filelog>
	implements FilelogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FilelogUtil} to access the filelog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FilelogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			FilelogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			FilelogModelImpl.COMPANYID_COLUMN_BITMASK |
			FilelogModelImpl.GUEST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERLOGID =
		new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserlogId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID =
		new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserlogId",
			new String[] { Long.class.getName() },
			FilelogModelImpl.USERLOGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERLOGID = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserlogId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, FilelogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the filelog in the entity cache if it is enabled.
	 *
	 * @param filelog the filelog
	 */
	public void cacheResult(Filelog filelog) {
		EntityCacheUtil.putResult(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogImpl.class, filelog.getPrimaryKey(), filelog);

		filelog.resetOriginalValues();
	}

	/**
	 * Caches the filelogs in the entity cache if it is enabled.
	 *
	 * @param filelogs the filelogs
	 */
	public void cacheResult(List<Filelog> filelogs) {
		for (Filelog filelog : filelogs) {
			if (EntityCacheUtil.getResult(
						FilelogModelImpl.ENTITY_CACHE_ENABLED,
						FilelogImpl.class, filelog.getPrimaryKey()) == null) {
				cacheResult(filelog);
			}
			else {
				filelog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all filelogs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FilelogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FilelogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the filelog.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Filelog filelog) {
		EntityCacheUtil.removeResult(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogImpl.class, filelog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Filelog> filelogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Filelog filelog : filelogs) {
			EntityCacheUtil.removeResult(FilelogModelImpl.ENTITY_CACHE_ENABLED,
				FilelogImpl.class, filelog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new filelog with the primary key. Does not add the filelog to the database.
	 *
	 * @param FilelogId the primary key for the new filelog
	 * @return the new filelog
	 */
	public Filelog create(long FilelogId) {
		Filelog filelog = new FilelogImpl();

		filelog.setNew(true);
		filelog.setPrimaryKey(FilelogId);

		return filelog;
	}

	/**
	 * Removes the filelog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param FilelogId the primary key of the filelog
	 * @return the filelog that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog remove(long FilelogId)
		throws NoSuchFilelogException, SystemException {
		return remove(Long.valueOf(FilelogId));
	}

	/**
	 * Removes the filelog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the filelog
	 * @return the filelog that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Filelog remove(Serializable primaryKey)
		throws NoSuchFilelogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Filelog filelog = (Filelog)session.get(FilelogImpl.class, primaryKey);

			if (filelog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFilelogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(filelog);
		}
		catch (NoSuchFilelogException nsee) {
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
	protected Filelog removeImpl(Filelog filelog) throws SystemException {
		filelog = toUnwrappedModel(filelog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, filelog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(filelog);

		return filelog;
	}

	@Override
	public Filelog updateImpl(
		com.liferay.consistent.tracking.model.Filelog filelog, boolean merge)
		throws SystemException {
		filelog = toUnwrappedModel(filelog);

		boolean isNew = filelog.isNew();

		FilelogModelImpl filelogModelImpl = (FilelogModelImpl)filelog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, filelog, merge);

			filelog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FilelogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((filelogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(filelogModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(filelogModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((filelogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(filelogModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(filelogModelImpl.getOriginalGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(filelogModelImpl.getCompanyId()),
						Boolean.valueOf(filelogModelImpl.getGuest())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((filelogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(filelogModelImpl.getOriginalUserlogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID,
					args);

				args = new Object[] {
						Long.valueOf(filelogModelImpl.getUserlogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERLOGID,
					args);
			}
		}

		EntityCacheUtil.putResult(FilelogModelImpl.ENTITY_CACHE_ENABLED,
			FilelogImpl.class, filelog.getPrimaryKey(), filelog);

		return filelog;
	}

	protected Filelog toUnwrappedModel(Filelog filelog) {
		if (filelog instanceof FilelogImpl) {
			return filelog;
		}

		FilelogImpl filelogImpl = new FilelogImpl();

		filelogImpl.setNew(filelog.isNew());
		filelogImpl.setPrimaryKey(filelog.getPrimaryKey());

		filelogImpl.setFilelogId(filelog.getFilelogId());
		filelogImpl.setCompanyId(filelog.getCompanyId());
		filelogImpl.setGuest(filelog.isGuest());
		filelogImpl.setUserlogId(filelog.getUserlogId());
		filelogImpl.setFileId(filelog.getFileId());
		filelogImpl.setFileVersion(filelog.getFileVersion());
		filelogImpl.setAccessDate(filelog.getAccessDate());
		filelogImpl.setElapseLoad(filelog.getElapseLoad());
		filelogImpl.setTrafic(filelog.isTrafic());
		filelogImpl.setStatus(filelog.isStatus());

		return filelogImpl;
	}

	/**
	 * Returns the filelog with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the filelog
	 * @return the filelog
	 * @throws com.liferay.portal.NoSuchModelException if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Filelog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the filelog with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchFilelogException} if it could not be found.
	 *
	 * @param FilelogId the primary key of the filelog
	 * @return the filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog findByPrimaryKey(long FilelogId)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = fetchByPrimaryKey(FilelogId);

		if (filelog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + FilelogId);
			}

			throw new NoSuchFilelogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				FilelogId);
		}

		return filelog;
	}

	/**
	 * Returns the filelog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the filelog
	 * @return the filelog, or <code>null</code> if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Filelog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the filelog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param FilelogId the primary key of the filelog
	 * @return the filelog, or <code>null</code> if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog fetchByPrimaryKey(long FilelogId) throws SystemException {
		Filelog filelog = (Filelog)EntityCacheUtil.getResult(FilelogModelImpl.ENTITY_CACHE_ENABLED,
				FilelogImpl.class, FilelogId);

		if (filelog == _nullFilelog) {
			return null;
		}

		if (filelog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				filelog = (Filelog)session.get(FilelogImpl.class,
						Long.valueOf(FilelogId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (filelog != null) {
					cacheResult(filelog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FilelogModelImpl.ENTITY_CACHE_ENABLED,
						FilelogImpl.class, FilelogId, _nullFilelog);
				}

				closeSession(session);
			}
		}

		return filelog;
	}

	/**
	 * Returns all the filelogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the filelogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @return the range of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the filelogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByCompanyId(long companyId, int start, int end,
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

		List<Filelog> list = (List<Filelog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Filelog filelog : list) {
				if ((companyId != filelog.getCompanyId())) {
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

			query.append(_SQL_SELECT_FILELOG_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FilelogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Filelog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first filelog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = fetchByCompanyId_First(companyId, orderByComparator);

		if (filelog != null) {
			return filelog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFilelogException(msg.toString());
	}

	/**
	 * Returns the first filelog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Filelog> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last filelog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = fetchByCompanyId_Last(companyId, orderByComparator);

		if (filelog != null) {
			return filelog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFilelogException(msg.toString());
	}

	/**
	 * Returns the last filelog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<Filelog> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the filelogs before and after the current filelog in the ordered set where companyId = &#63;.
	 *
	 * @param FilelogId the primary key of the current filelog
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog[] findByCompanyId_PrevAndNext(long FilelogId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = findByPrimaryKey(FilelogId);

		Session session = null;

		try {
			session = openSession();

			Filelog[] array = new FilelogImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, filelog, companyId,
					orderByComparator, true);

			array[1] = filelog;

			array[2] = getByCompanyId_PrevAndNext(session, filelog, companyId,
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

	protected Filelog getByCompanyId_PrevAndNext(Session session,
		Filelog filelog, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FILELOG_WHERE);

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
			query.append(FilelogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(filelog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Filelog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the filelogs where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByC_G(long companyId, boolean guest)
		throws SystemException {
		return findByC_G(companyId, guest, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the filelogs where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @return the range of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByC_G(long companyId, boolean guest, int start,
		int end) throws SystemException {
		return findByC_G(companyId, guest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the filelogs where companyId = &#63; and guest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByC_G(long companyId, boolean guest, int start,
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

		List<Filelog> list = (List<Filelog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Filelog filelog : list) {
				if ((companyId != filelog.getCompanyId()) ||
						(guest != filelog.getGuest())) {
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

			query.append(_SQL_SELECT_FILELOG_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FilelogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(guest);

				list = (List<Filelog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first filelog in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog findByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = fetchByC_G_First(companyId, guest, orderByComparator);

		if (filelog != null) {
			return filelog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFilelogException(msg.toString());
	}

	/**
	 * Returns the first filelog in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog fetchByC_G_First(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		List<Filelog> list = findByC_G(companyId, guest, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last filelog in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog findByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = fetchByC_G_Last(companyId, guest, orderByComparator);

		if (filelog != null) {
			return filelog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", guest=");
		msg.append(guest);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFilelogException(msg.toString());
	}

	/**
	 * Returns the last filelog in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog fetchByC_G_Last(long companyId, boolean guest,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, guest);

		List<Filelog> list = findByC_G(companyId, guest, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the filelogs before and after the current filelog in the ordered set where companyId = &#63; and guest = &#63;.
	 *
	 * @param FilelogId the primary key of the current filelog
	 * @param companyId the company ID
	 * @param guest the guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog[] findByC_G_PrevAndNext(long FilelogId, long companyId,
		boolean guest, OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = findByPrimaryKey(FilelogId);

		Session session = null;

		try {
			session = openSession();

			Filelog[] array = new FilelogImpl[3];

			array[0] = getByC_G_PrevAndNext(session, filelog, companyId, guest,
					orderByComparator, true);

			array[1] = filelog;

			array[2] = getByC_G_PrevAndNext(session, filelog, companyId, guest,
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

	protected Filelog getByC_G_PrevAndNext(Session session, Filelog filelog,
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

		query.append(_SQL_SELECT_FILELOG_WHERE);

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
			query.append(FilelogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(guest);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(filelog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Filelog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the filelogs where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @return the matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByUserlogId(long userlogId)
		throws SystemException {
		return findByUserlogId(userlogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the filelogs where userlogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userlogId the userlog ID
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @return the range of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByUserlogId(long userlogId, int start, int end)
		throws SystemException {
		return findByUserlogId(userlogId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the filelogs where userlogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userlogId the userlog ID
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findByUserlogId(long userlogId, int start, int end,
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

		List<Filelog> list = (List<Filelog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Filelog filelog : list) {
				if ((userlogId != filelog.getUserlogId())) {
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

			query.append(_SQL_SELECT_FILELOG_WHERE);

			query.append(_FINDER_COLUMN_USERLOGID_USERLOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FilelogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userlogId);

				list = (List<Filelog>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first filelog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog findByUserlogId_First(long userlogId,
		OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = fetchByUserlogId_First(userlogId, orderByComparator);

		if (filelog != null) {
			return filelog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFilelogException(msg.toString());
	}

	/**
	 * Returns the first filelog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filelog, or <code>null</code> if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog fetchByUserlogId_First(long userlogId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Filelog> list = findByUserlogId(userlogId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last filelog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog findByUserlogId_Last(long userlogId,
		OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = fetchByUserlogId_Last(userlogId, orderByComparator);

		if (filelog != null) {
			return filelog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userlogId=");
		msg.append(userlogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFilelogException(msg.toString());
	}

	/**
	 * Returns the last filelog in the ordered set where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filelog, or <code>null</code> if a matching filelog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog fetchByUserlogId_Last(long userlogId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserlogId(userlogId);

		List<Filelog> list = findByUserlogId(userlogId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the filelogs before and after the current filelog in the ordered set where userlogId = &#63;.
	 *
	 * @param FilelogId the primary key of the current filelog
	 * @param userlogId the userlog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next filelog
	 * @throws com.liferay.consistent.tracking.NoSuchFilelogException if a filelog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Filelog[] findByUserlogId_PrevAndNext(long FilelogId,
		long userlogId, OrderByComparator orderByComparator)
		throws NoSuchFilelogException, SystemException {
		Filelog filelog = findByPrimaryKey(FilelogId);

		Session session = null;

		try {
			session = openSession();

			Filelog[] array = new FilelogImpl[3];

			array[0] = getByUserlogId_PrevAndNext(session, filelog, userlogId,
					orderByComparator, true);

			array[1] = filelog;

			array[2] = getByUserlogId_PrevAndNext(session, filelog, userlogId,
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

	protected Filelog getByUserlogId_PrevAndNext(Session session,
		Filelog filelog, long userlogId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FILELOG_WHERE);

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
			query.append(FilelogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userlogId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(filelog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Filelog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the filelogs.
	 *
	 * @return the filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the filelogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @return the range of filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the filelogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of filelogs
	 * @param end the upper bound of the range of filelogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Filelog> findAll(int start, int end,
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

		List<Filelog> list = (List<Filelog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FILELOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FILELOG.concat(FilelogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Filelog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Filelog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the filelogs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Filelog filelog : findByCompanyId(companyId)) {
			remove(filelog);
		}
	}

	/**
	 * Removes all the filelogs where companyId = &#63; and guest = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, boolean guest)
		throws SystemException {
		for (Filelog filelog : findByC_G(companyId, guest)) {
			remove(filelog);
		}
	}

	/**
	 * Removes all the filelogs where userlogId = &#63; from the database.
	 *
	 * @param userlogId the userlog ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserlogId(long userlogId) throws SystemException {
		for (Filelog filelog : findByUserlogId(userlogId)) {
			remove(filelog);
		}
	}

	/**
	 * Removes all the filelogs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Filelog filelog : findAll()) {
			remove(filelog);
		}
	}

	/**
	 * Returns the number of filelogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FILELOG_WHERE);

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
	 * Returns the number of filelogs where companyId = &#63; and guest = &#63;.
	 *
	 * @param companyId the company ID
	 * @param guest the guest
	 * @return the number of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, boolean guest)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, guest };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FILELOG_WHERE);

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
	 * Returns the number of filelogs where userlogId = &#63;.
	 *
	 * @param userlogId the userlog ID
	 * @return the number of matching filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserlogId(long userlogId) throws SystemException {
		Object[] finderArgs = new Object[] { userlogId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERLOGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FILELOG_WHERE);

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
	 * Returns the number of filelogs.
	 *
	 * @return the number of filelogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FILELOG);

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
	 * Initializes the filelog persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.Filelog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Filelog>> listenersList = new ArrayList<ModelListener<Filelog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Filelog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FilelogImpl.class.getName());
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
	private static final String _SQL_SELECT_FILELOG = "SELECT filelog FROM Filelog filelog";
	private static final String _SQL_SELECT_FILELOG_WHERE = "SELECT filelog FROM Filelog filelog WHERE ";
	private static final String _SQL_COUNT_FILELOG = "SELECT COUNT(filelog) FROM Filelog filelog";
	private static final String _SQL_COUNT_FILELOG_WHERE = "SELECT COUNT(filelog) FROM Filelog filelog WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "filelog.companyId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "filelog.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GUEST_2 = "filelog.guest = ?";
	private static final String _FINDER_COLUMN_USERLOGID_USERLOGID_2 = "filelog.userlogId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "filelog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Filelog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Filelog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FilelogPersistenceImpl.class);
	private static Filelog _nullFilelog = new FilelogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Filelog> toCacheModel() {
				return _nullFilelogCacheModel;
			}
		};

	private static CacheModel<Filelog> _nullFilelogCacheModel = new CacheModel<Filelog>() {
			public Filelog toEntityModel() {
				return _nullFilelog;
			}
		};
}