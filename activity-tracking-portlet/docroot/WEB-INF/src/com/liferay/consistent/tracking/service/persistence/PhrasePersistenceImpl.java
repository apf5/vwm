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

import com.liferay.consistent.tracking.NoSuchPhraseException;
import com.liferay.consistent.tracking.model.Phrase;
import com.liferay.consistent.tracking.model.impl.PhraseImpl;
import com.liferay.consistent.tracking.model.impl.PhraseModelImpl;

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
 * The persistence implementation for the phrase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PhrasePersistence
 * @see PhraseUtil
 * @generated
 */
public class PhrasePersistenceImpl extends BasePersistenceImpl<Phrase>
	implements PhrasePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhraseUtil} to access the phrase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhraseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_PHRASENAME = new FinderPath(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseModelImpl.FINDER_CACHE_ENABLED, PhraseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPhraseName",
			new String[] { String.class.getName() },
			PhraseModelImpl.PHRASENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PHRASENAME = new FinderPath(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhraseName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseModelImpl.FINDER_CACHE_ENABLED, PhraseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseModelImpl.FINDER_CACHE_ENABLED, PhraseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the phrase in the entity cache if it is enabled.
	 *
	 * @param phrase the phrase
	 */
	public void cacheResult(Phrase phrase) {
		EntityCacheUtil.putResult(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseImpl.class, phrase.getPrimaryKey(), phrase);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PHRASENAME,
			new Object[] { phrase.getPhraseName() }, phrase);

		phrase.resetOriginalValues();
	}

	/**
	 * Caches the phrases in the entity cache if it is enabled.
	 *
	 * @param phrases the phrases
	 */
	public void cacheResult(List<Phrase> phrases) {
		for (Phrase phrase : phrases) {
			if (EntityCacheUtil.getResult(
						PhraseModelImpl.ENTITY_CACHE_ENABLED, PhraseImpl.class,
						phrase.getPrimaryKey()) == null) {
				cacheResult(phrase);
			}
			else {
				phrase.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phrases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PhraseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PhraseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phrase.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Phrase phrase) {
		EntityCacheUtil.removeResult(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseImpl.class, phrase.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(phrase);
	}

	@Override
	public void clearCache(List<Phrase> phrases) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Phrase phrase : phrases) {
			EntityCacheUtil.removeResult(PhraseModelImpl.ENTITY_CACHE_ENABLED,
				PhraseImpl.class, phrase.getPrimaryKey());

			clearUniqueFindersCache(phrase);
		}
	}

	protected void clearUniqueFindersCache(Phrase phrase) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PHRASENAME,
			new Object[] { phrase.getPhraseName() });
	}

	/**
	 * Creates a new phrase with the primary key. Does not add the phrase to the database.
	 *
	 * @param phraseId the primary key for the new phrase
	 * @return the new phrase
	 */
	public Phrase create(long phraseId) {
		Phrase phrase = new PhraseImpl();

		phrase.setNew(true);
		phrase.setPrimaryKey(phraseId);

		return phrase;
	}

	/**
	 * Removes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchPhraseException if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase remove(long phraseId)
		throws NoSuchPhraseException, SystemException {
		return remove(Long.valueOf(phraseId));
	}

	/**
	 * Removes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchPhraseException if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Phrase remove(Serializable primaryKey)
		throws NoSuchPhraseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Phrase phrase = (Phrase)session.get(PhraseImpl.class, primaryKey);

			if (phrase == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhraseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(phrase);
		}
		catch (NoSuchPhraseException nsee) {
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
	protected Phrase removeImpl(Phrase phrase) throws SystemException {
		phrase = toUnwrappedModel(phrase);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, phrase);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(phrase);

		return phrase;
	}

	@Override
	public Phrase updateImpl(
		com.liferay.consistent.tracking.model.Phrase phrase, boolean merge)
		throws SystemException {
		phrase = toUnwrappedModel(phrase);

		boolean isNew = phrase.isNew();

		PhraseModelImpl phraseModelImpl = (PhraseModelImpl)phrase;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, phrase, merge);

			phrase.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PhraseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PhraseModelImpl.ENTITY_CACHE_ENABLED,
			PhraseImpl.class, phrase.getPrimaryKey(), phrase);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PHRASENAME,
				new Object[] { phrase.getPhraseName() }, phrase);
		}
		else {
			if ((phraseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PHRASENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phraseModelImpl.getOriginalPhraseName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PHRASENAME,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PHRASENAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PHRASENAME,
					new Object[] { phrase.getPhraseName() }, phrase);
			}
		}

		return phrase;
	}

	protected Phrase toUnwrappedModel(Phrase phrase) {
		if (phrase instanceof PhraseImpl) {
			return phrase;
		}

		PhraseImpl phraseImpl = new PhraseImpl();

		phraseImpl.setNew(phrase.isNew());
		phraseImpl.setPrimaryKey(phrase.getPrimaryKey());

		phraseImpl.setPhraseId(phrase.getPhraseId());
		phraseImpl.setPhraseName(phrase.getPhraseName());

		return phraseImpl;
	}

	/**
	 * Returns the phrase with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the phrase
	 * @return the phrase
	 * @throws com.liferay.portal.NoSuchModelException if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Phrase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the phrase with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchPhraseException} if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase
	 * @throws com.liferay.consistent.tracking.NoSuchPhraseException if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase findByPrimaryKey(long phraseId)
		throws NoSuchPhraseException, SystemException {
		Phrase phrase = fetchByPrimaryKey(phraseId);

		if (phrase == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + phraseId);
			}

			throw new NoSuchPhraseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				phraseId);
		}

		return phrase;
	}

	/**
	 * Returns the phrase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phrase
	 * @return the phrase, or <code>null</code> if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Phrase fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the phrase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase, or <code>null</code> if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase fetchByPrimaryKey(long phraseId) throws SystemException {
		Phrase phrase = (Phrase)EntityCacheUtil.getResult(PhraseModelImpl.ENTITY_CACHE_ENABLED,
				PhraseImpl.class, phraseId);

		if (phrase == _nullPhrase) {
			return null;
		}

		if (phrase == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				phrase = (Phrase)session.get(PhraseImpl.class,
						Long.valueOf(phraseId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (phrase != null) {
					cacheResult(phrase);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PhraseModelImpl.ENTITY_CACHE_ENABLED,
						PhraseImpl.class, phraseId, _nullPhrase);
				}

				closeSession(session);
			}
		}

		return phrase;
	}

	/**
	 * Returns the phrase where phraseName = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchPhraseException} if it could not be found.
	 *
	 * @param phraseName the phrase name
	 * @return the matching phrase
	 * @throws com.liferay.consistent.tracking.NoSuchPhraseException if a matching phrase could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase findByPhraseName(String phraseName)
		throws NoSuchPhraseException, SystemException {
		Phrase phrase = fetchByPhraseName(phraseName);

		if (phrase == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("phraseName=");
			msg.append(phraseName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPhraseException(msg.toString());
		}

		return phrase;
	}

	/**
	 * Returns the phrase where phraseName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param phraseName the phrase name
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase fetchByPhraseName(String phraseName)
		throws SystemException {
		return fetchByPhraseName(phraseName, true);
	}

	/**
	 * Returns the phrase where phraseName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param phraseName the phrase name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching phrase, or <code>null</code> if a matching phrase could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase fetchByPhraseName(String phraseName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { phraseName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PHRASENAME,
					finderArgs, this);
		}

		if (result instanceof Phrase) {
			Phrase phrase = (Phrase)result;

			if (!Validator.equals(phraseName, phrase.getPhraseName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PHRASE_WHERE);

			if (phraseName == null) {
				query.append(_FINDER_COLUMN_PHRASENAME_PHRASENAME_1);
			}
			else {
				if (phraseName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PHRASENAME_PHRASENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_PHRASENAME_PHRASENAME_2);
				}
			}

			query.append(PhraseModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (phraseName != null) {
					qPos.add(phraseName);
				}

				List<Phrase> list = q.list();

				result = list;

				Phrase phrase = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PHRASENAME,
						finderArgs, list);
				}
				else {
					phrase = list.get(0);

					cacheResult(phrase);

					if ((phrase.getPhraseName() == null) ||
							!phrase.getPhraseName().equals(phraseName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PHRASENAME,
							finderArgs, phrase);
					}
				}

				return phrase;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PHRASENAME,
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
				return (Phrase)result;
			}
		}
	}

	/**
	 * Returns all the phrases.
	 *
	 * @return the phrases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Phrase> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @return the range of phrases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Phrase> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phrases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of phrases
	 * @param end the upper bound of the range of phrases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phrases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Phrase> findAll(int start, int end,
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

		List<Phrase> list = (List<Phrase>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PHRASE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHRASE.concat(PhraseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Phrase>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Phrase>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes the phrase where phraseName = &#63; from the database.
	 *
	 * @param phraseName the phrase name
	 * @return the phrase that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase removeByPhraseName(String phraseName)
		throws NoSuchPhraseException, SystemException {
		Phrase phrase = findByPhraseName(phraseName);

		return remove(phrase);
	}

	/**
	 * Removes all the phrases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Phrase phrase : findAll()) {
			remove(phrase);
		}
	}

	/**
	 * Returns the number of phrases where phraseName = &#63;.
	 *
	 * @param phraseName the phrase name
	 * @return the number of matching phrases
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPhraseName(String phraseName) throws SystemException {
		Object[] finderArgs = new Object[] { phraseName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PHRASENAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHRASE_WHERE);

			if (phraseName == null) {
				query.append(_FINDER_COLUMN_PHRASENAME_PHRASENAME_1);
			}
			else {
				if (phraseName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PHRASENAME_PHRASENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_PHRASENAME_PHRASENAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (phraseName != null) {
					qPos.add(phraseName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PHRASENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of phrases.
	 *
	 * @return the number of phrases
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHRASE);

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
	 * Initializes the phrase persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.Phrase")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Phrase>> listenersList = new ArrayList<ModelListener<Phrase>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Phrase>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PhraseImpl.class.getName());
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
	private static final String _SQL_SELECT_PHRASE = "SELECT phrase FROM Phrase phrase";
	private static final String _SQL_SELECT_PHRASE_WHERE = "SELECT phrase FROM Phrase phrase WHERE ";
	private static final String _SQL_COUNT_PHRASE = "SELECT COUNT(phrase) FROM Phrase phrase";
	private static final String _SQL_COUNT_PHRASE_WHERE = "SELECT COUNT(phrase) FROM Phrase phrase WHERE ";
	private static final String _FINDER_COLUMN_PHRASENAME_PHRASENAME_1 = "phrase.phraseName IS NULL";
	private static final String _FINDER_COLUMN_PHRASENAME_PHRASENAME_2 = "phrase.phraseName = ?";
	private static final String _FINDER_COLUMN_PHRASENAME_PHRASENAME_3 = "(phrase.phraseName IS NULL OR phrase.phraseName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "phrase.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Phrase exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Phrase exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PhrasePersistenceImpl.class);
	private static Phrase _nullPhrase = new PhraseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Phrase> toCacheModel() {
				return _nullPhraseCacheModel;
			}
		};

	private static CacheModel<Phrase> _nullPhraseCacheModel = new CacheModel<Phrase>() {
			public Phrase toEntityModel() {
				return _nullPhrase;
			}
		};
}