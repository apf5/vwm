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

package mx.com.vw.jhanlos.ads.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import mx.com.vw.jhanlos.ads.NoSuchPropertieException;
import mx.com.vw.jhanlos.ads.model.Propertie;
import mx.com.vw.jhanlos.ads.model.impl.PropertieImpl;
import mx.com.vw.jhanlos.ads.model.impl.PropertieModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the propertie service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see PropertiePersistence
 * @see PropertieUtil
 * @generated
 */
public class PropertiePersistenceImpl extends BasePersistenceImpl<Propertie>
	implements PropertiePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PropertieUtil} to access the propertie persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PropertieImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PropertieModelImpl.ENTITY_CACHE_ENABLED,
			PropertieModelImpl.FINDER_CACHE_ENABLED, PropertieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PropertieModelImpl.ENTITY_CACHE_ENABLED,
			PropertieModelImpl.FINDER_CACHE_ENABLED, PropertieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PropertieModelImpl.ENTITY_CACHE_ENABLED,
			PropertieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the propertie in the entity cache if it is enabled.
	 *
	 * @param propertie the propertie
	 */
	public void cacheResult(Propertie propertie) {
		EntityCacheUtil.putResult(PropertieModelImpl.ENTITY_CACHE_ENABLED,
			PropertieImpl.class, propertie.getPrimaryKey(), propertie);

		propertie.resetOriginalValues();
	}

	/**
	 * Caches the properties in the entity cache if it is enabled.
	 *
	 * @param properties the properties
	 */
	public void cacheResult(List<Propertie> properties) {
		for (Propertie propertie : properties) {
			if (EntityCacheUtil.getResult(
						PropertieModelImpl.ENTITY_CACHE_ENABLED,
						PropertieImpl.class, propertie.getPrimaryKey()) == null) {
				cacheResult(propertie);
			}
			else {
				propertie.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all properties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PropertieImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PropertieImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the propertie.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Propertie propertie) {
		EntityCacheUtil.removeResult(PropertieModelImpl.ENTITY_CACHE_ENABLED,
			PropertieImpl.class, propertie.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Propertie> properties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Propertie propertie : properties) {
			EntityCacheUtil.removeResult(PropertieModelImpl.ENTITY_CACHE_ENABLED,
				PropertieImpl.class, propertie.getPrimaryKey());
		}
	}

	/**
	 * Creates a new propertie with the primary key. Does not add the propertie to the database.
	 *
	 * @param propertieId the primary key for the new propertie
	 * @return the new propertie
	 */
	public Propertie create(long propertieId) {
		Propertie propertie = new PropertieImpl();

		propertie.setNew(true);
		propertie.setPrimaryKey(propertieId);

		return propertie;
	}

	/**
	 * Removes the propertie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param propertieId the primary key of the propertie
	 * @return the propertie that was removed
	 * @throws mx.com.vw.jhanlos.ads.NoSuchPropertieException if a propertie with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Propertie remove(long propertieId)
		throws NoSuchPropertieException, SystemException {
		return remove(Long.valueOf(propertieId));
	}

	/**
	 * Removes the propertie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the propertie
	 * @return the propertie that was removed
	 * @throws mx.com.vw.jhanlos.ads.NoSuchPropertieException if a propertie with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Propertie remove(Serializable primaryKey)
		throws NoSuchPropertieException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Propertie propertie = (Propertie)session.get(PropertieImpl.class,
					primaryKey);

			if (propertie == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPropertieException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(propertie);
		}
		catch (NoSuchPropertieException nsee) {
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
	protected Propertie removeImpl(Propertie propertie)
		throws SystemException {
		propertie = toUnwrappedModel(propertie);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, propertie);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(propertie);

		return propertie;
	}

	@Override
	public Propertie updateImpl(
		mx.com.vw.jhanlos.ads.model.Propertie propertie, boolean merge)
		throws SystemException {
		propertie = toUnwrappedModel(propertie);

		boolean isNew = propertie.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, propertie, merge);

			propertie.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PropertieModelImpl.ENTITY_CACHE_ENABLED,
			PropertieImpl.class, propertie.getPrimaryKey(), propertie);

		return propertie;
	}

	protected Propertie toUnwrappedModel(Propertie propertie) {
		if (propertie instanceof PropertieImpl) {
			return propertie;
		}

		PropertieImpl propertieImpl = new PropertieImpl();

		propertieImpl.setNew(propertie.isNew());
		propertieImpl.setPrimaryKey(propertie.getPrimaryKey());

		propertieImpl.setPropertieId(propertie.getPropertieId());
		propertieImpl.setCompanyId(propertie.getCompanyId());
		propertieImpl.setUserId(propertie.getUserId());
		propertieImpl.setCreateDate(propertie.getCreateDate());
		propertieImpl.setModifiedDate(propertie.getModifiedDate());
		propertieImpl.setName(propertie.getName());
		propertieImpl.setValue(propertie.getValue());

		return propertieImpl;
	}

	/**
	 * Returns the propertie with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the propertie
	 * @return the propertie
	 * @throws com.liferay.portal.NoSuchModelException if a propertie with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Propertie findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the propertie with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchPropertieException} if it could not be found.
	 *
	 * @param propertieId the primary key of the propertie
	 * @return the propertie
	 * @throws mx.com.vw.jhanlos.ads.NoSuchPropertieException if a propertie with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Propertie findByPrimaryKey(long propertieId)
		throws NoSuchPropertieException, SystemException {
		Propertie propertie = fetchByPrimaryKey(propertieId);

		if (propertie == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + propertieId);
			}

			throw new NoSuchPropertieException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				propertieId);
		}

		return propertie;
	}

	/**
	 * Returns the propertie with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the propertie
	 * @return the propertie, or <code>null</code> if a propertie with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Propertie fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the propertie with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param propertieId the primary key of the propertie
	 * @return the propertie, or <code>null</code> if a propertie with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Propertie fetchByPrimaryKey(long propertieId)
		throws SystemException {
		Propertie propertie = (Propertie)EntityCacheUtil.getResult(PropertieModelImpl.ENTITY_CACHE_ENABLED,
				PropertieImpl.class, propertieId);

		if (propertie == _nullPropertie) {
			return null;
		}

		if (propertie == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				propertie = (Propertie)session.get(PropertieImpl.class,
						Long.valueOf(propertieId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (propertie != null) {
					cacheResult(propertie);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PropertieModelImpl.ENTITY_CACHE_ENABLED,
						PropertieImpl.class, propertieId, _nullPropertie);
				}

				closeSession(session);
			}
		}

		return propertie;
	}

	/**
	 * Returns all the properties.
	 *
	 * @return the properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<Propertie> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of properties
	 * @param end the upper bound of the range of properties (not inclusive)
	 * @return the range of properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<Propertie> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of properties
	 * @param end the upper bound of the range of properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<Propertie> findAll(int start, int end,
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

		List<Propertie> list = (List<Propertie>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROPERTIE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPERTIE.concat(PropertieModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Propertie>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Propertie>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the properties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Propertie propertie : findAll()) {
			remove(propertie);
		}
	}

	/**
	 * Returns the number of properties.
	 *
	 * @return the number of properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROPERTIE);

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
	 * Initializes the propertie persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.mx.com.vw.jhanlos.ads.model.Propertie")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Propertie>> listenersList = new ArrayList<ModelListener<Propertie>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Propertie>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PropertieImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = MailboxPersistence.class)
	protected MailboxPersistence mailboxPersistence;
	@BeanReference(type = MailboxAdminPersistence.class)
	protected MailboxAdminPersistence mailboxAdminPersistence;
	@BeanReference(type = PropertiePersistence.class)
	protected PropertiePersistence propertiePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PROPERTIE = "SELECT propertie FROM Propertie propertie";
	private static final String _SQL_COUNT_PROPERTIE = "SELECT COUNT(propertie) FROM Propertie propertie";
	private static final String _ORDER_BY_ENTITY_ALIAS = "propertie.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Propertie exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PropertiePersistenceImpl.class);
	private static Propertie _nullPropertie = new PropertieImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Propertie> toCacheModel() {
				return _nullPropertieCacheModel;
			}
		};

	private static CacheModel<Propertie> _nullPropertieCacheModel = new CacheModel<Propertie>() {
			public Propertie toEntityModel() {
				return _nullPropertie;
			}
		};
}