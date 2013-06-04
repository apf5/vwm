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

import com.liferay.consistent.tracking.NoSuchBrowserException;
import com.liferay.consistent.tracking.model.Browser;
import com.liferay.consistent.tracking.model.impl.BrowserImpl;
import com.liferay.consistent.tracking.model.impl.BrowserModelImpl;

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
 * The persistence implementation for the browser service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see BrowserPersistence
 * @see BrowserUtil
 * @generated
 */
public class BrowserPersistenceImpl extends BasePersistenceImpl<Browser>
	implements BrowserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BrowserUtil} to access the browser persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BrowserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserModelImpl.FINDER_CACHE_ENABLED, BrowserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			BrowserModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserModelImpl.FINDER_CACHE_ENABLED, BrowserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserModelImpl.FINDER_CACHE_ENABLED, BrowserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the browser in the entity cache if it is enabled.
	 *
	 * @param browser the browser
	 */
	public void cacheResult(Browser browser) {
		EntityCacheUtil.putResult(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserImpl.class, browser.getPrimaryKey(), browser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { browser.getName() }, browser);

		browser.resetOriginalValues();
	}

	/**
	 * Caches the browsers in the entity cache if it is enabled.
	 *
	 * @param browsers the browsers
	 */
	public void cacheResult(List<Browser> browsers) {
		for (Browser browser : browsers) {
			if (EntityCacheUtil.getResult(
						BrowserModelImpl.ENTITY_CACHE_ENABLED,
						BrowserImpl.class, browser.getPrimaryKey()) == null) {
				cacheResult(browser);
			}
			else {
				browser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all browsers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BrowserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BrowserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the browser.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Browser browser) {
		EntityCacheUtil.removeResult(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserImpl.class, browser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(browser);
	}

	@Override
	public void clearCache(List<Browser> browsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Browser browser : browsers) {
			EntityCacheUtil.removeResult(BrowserModelImpl.ENTITY_CACHE_ENABLED,
				BrowserImpl.class, browser.getPrimaryKey());

			clearUniqueFindersCache(browser);
		}
	}

	protected void clearUniqueFindersCache(Browser browser) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { browser.getName() });
	}

	/**
	 * Creates a new browser with the primary key. Does not add the browser to the database.
	 *
	 * @param browserId the primary key for the new browser
	 * @return the new browser
	 */
	public Browser create(long browserId) {
		Browser browser = new BrowserImpl();

		browser.setNew(true);
		browser.setPrimaryKey(browserId);

		return browser;
	}

	/**
	 * Removes the browser with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param browserId the primary key of the browser
	 * @return the browser that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchBrowserException if a browser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browser remove(long browserId)
		throws NoSuchBrowserException, SystemException {
		return remove(Long.valueOf(browserId));
	}

	/**
	 * Removes the browser with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the browser
	 * @return the browser that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchBrowserException if a browser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Browser remove(Serializable primaryKey)
		throws NoSuchBrowserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Browser browser = (Browser)session.get(BrowserImpl.class, primaryKey);

			if (browser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrowserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(browser);
		}
		catch (NoSuchBrowserException nsee) {
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
	protected Browser removeImpl(Browser browser) throws SystemException {
		browser = toUnwrappedModel(browser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, browser);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(browser);

		return browser;
	}

	@Override
	public Browser updateImpl(
		com.liferay.consistent.tracking.model.Browser browser, boolean merge)
		throws SystemException {
		browser = toUnwrappedModel(browser);

		boolean isNew = browser.isNew();

		BrowserModelImpl browserModelImpl = (BrowserModelImpl)browser;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, browser, merge);

			browser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BrowserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BrowserModelImpl.ENTITY_CACHE_ENABLED,
			BrowserImpl.class, browser.getPrimaryKey(), browser);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { browser.getName() }, browser);
		}
		else {
			if ((browserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { browserModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
					new Object[] { browser.getName() }, browser);
			}
		}

		return browser;
	}

	protected Browser toUnwrappedModel(Browser browser) {
		if (browser instanceof BrowserImpl) {
			return browser;
		}

		BrowserImpl browserImpl = new BrowserImpl();

		browserImpl.setNew(browser.isNew());
		browserImpl.setPrimaryKey(browser.getPrimaryKey());

		browserImpl.setBrowserId(browser.getBrowserId());
		browserImpl.setName(browser.getName());

		return browserImpl;
	}

	/**
	 * Returns the browser with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the browser
	 * @return the browser
	 * @throws com.liferay.portal.NoSuchModelException if a browser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Browser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the browser with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchBrowserException} if it could not be found.
	 *
	 * @param browserId the primary key of the browser
	 * @return the browser
	 * @throws com.liferay.consistent.tracking.NoSuchBrowserException if a browser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browser findByPrimaryKey(long browserId)
		throws NoSuchBrowserException, SystemException {
		Browser browser = fetchByPrimaryKey(browserId);

		if (browser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + browserId);
			}

			throw new NoSuchBrowserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				browserId);
		}

		return browser;
	}

	/**
	 * Returns the browser with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the browser
	 * @return the browser, or <code>null</code> if a browser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Browser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the browser with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param browserId the primary key of the browser
	 * @return the browser, or <code>null</code> if a browser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browser fetchByPrimaryKey(long browserId) throws SystemException {
		Browser browser = (Browser)EntityCacheUtil.getResult(BrowserModelImpl.ENTITY_CACHE_ENABLED,
				BrowserImpl.class, browserId);

		if (browser == _nullBrowser) {
			return null;
		}

		if (browser == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				browser = (Browser)session.get(BrowserImpl.class,
						Long.valueOf(browserId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (browser != null) {
					cacheResult(browser);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BrowserModelImpl.ENTITY_CACHE_ENABLED,
						BrowserImpl.class, browserId, _nullBrowser);
				}

				closeSession(session);
			}
		}

		return browser;
	}

	/**
	 * Returns the browser where name = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchBrowserException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching browser
	 * @throws com.liferay.consistent.tracking.NoSuchBrowserException if a matching browser could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browser findByName(String name)
		throws NoSuchBrowserException, SystemException {
		Browser browser = fetchByName(name);

		if (browser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBrowserException(msg.toString());
		}

		return browser;
	}

	/**
	 * Returns the browser where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching browser, or <code>null</code> if a matching browser could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browser fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the browser where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching browser, or <code>null</code> if a matching browser could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Browser fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Browser) {
			Browser browser = (Browser)result;

			if (!Validator.equals(name, browser.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BROWSER_WHERE);

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

			query.append(BrowserModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				List<Browser> list = q.list();

				result = list;

				Browser browser = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					browser = list.get(0);

					cacheResult(browser);

					if ((browser.getName() == null) ||
							!browser.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, browser);
					}
				}

				return browser;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
				return (Browser)result;
			}
		}
	}

	/**
	 * Returns all the browsers.
	 *
	 * @return the browsers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the browsers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of browsers
	 * @param end the upper bound of the range of browsers (not inclusive)
	 * @return the range of browsers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browser> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the browsers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of browsers
	 * @param end the upper bound of the range of browsers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of browsers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Browser> findAll(int start, int end,
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

		List<Browser> list = (List<Browser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BROWSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BROWSER.concat(BrowserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Browser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Browser>)QueryUtil.list(q, getDialect(),
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
	 * Removes the browser where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the browser that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Browser removeByName(String name)
		throws NoSuchBrowserException, SystemException {
		Browser browser = findByName(name);

		return remove(browser);
	}

	/**
	 * Removes all the browsers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Browser browser : findAll()) {
			remove(browser);
		}
	}

	/**
	 * Returns the number of browsers where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching browsers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BROWSER_WHERE);

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
	 * Returns the number of browsers.
	 *
	 * @return the number of browsers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BROWSER);

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
	 * Initializes the browser persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.Browser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Browser>> listenersList = new ArrayList<ModelListener<Browser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Browser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BrowserImpl.class.getName());
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
	private static final String _SQL_SELECT_BROWSER = "SELECT browser FROM Browser browser";
	private static final String _SQL_SELECT_BROWSER_WHERE = "SELECT browser FROM Browser browser WHERE ";
	private static final String _SQL_COUNT_BROWSER = "SELECT COUNT(browser) FROM Browser browser";
	private static final String _SQL_COUNT_BROWSER_WHERE = "SELECT COUNT(browser) FROM Browser browser WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "browser.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "browser.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(browser.name IS NULL OR browser.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "browser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Browser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Browser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BrowserPersistenceImpl.class);
	private static Browser _nullBrowser = new BrowserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Browser> toCacheModel() {
				return _nullBrowserCacheModel;
			}
		};

	private static CacheModel<Browser> _nullBrowserCacheModel = new CacheModel<Browser>() {
			public Browser toEntityModel() {
				return _nullBrowser;
			}
		};
}