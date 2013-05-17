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

import com.liferay.consistent.tracking.NoSuchWordException;
import com.liferay.consistent.tracking.model.Word;
import com.liferay.consistent.tracking.model.impl.WordImpl;
import com.liferay.consistent.tracking.model.impl.WordModelImpl;

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
 * The persistence implementation for the word service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see WordPersistence
 * @see WordUtil
 * @generated
 */
public class WordPersistenceImpl extends BasePersistenceImpl<Word>
	implements WordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WordUtil} to access the word persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_WORDNAME = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, WordImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWordName",
			new String[] { String.class.getName() },
			WordModelImpl.WORDNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORDNAME = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWordName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, WordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, WordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the word in the entity cache if it is enabled.
	 *
	 * @param word the word
	 */
	public void cacheResult(Word word) {
		EntityCacheUtil.putResult(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordImpl.class, word.getPrimaryKey(), word);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDNAME,
			new Object[] { word.getWordName() }, word);

		word.resetOriginalValues();
	}

	/**
	 * Caches the words in the entity cache if it is enabled.
	 *
	 * @param words the words
	 */
	public void cacheResult(List<Word> words) {
		for (Word word : words) {
			if (EntityCacheUtil.getResult(WordModelImpl.ENTITY_CACHE_ENABLED,
						WordImpl.class, word.getPrimaryKey()) == null) {
				cacheResult(word);
			}
			else {
				word.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all words.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WordImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WordImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the word.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Word word) {
		EntityCacheUtil.removeResult(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordImpl.class, word.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(word);
	}

	@Override
	public void clearCache(List<Word> words) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Word word : words) {
			EntityCacheUtil.removeResult(WordModelImpl.ENTITY_CACHE_ENABLED,
				WordImpl.class, word.getPrimaryKey());

			clearUniqueFindersCache(word);
		}
	}

	protected void clearUniqueFindersCache(Word word) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDNAME,
			new Object[] { word.getWordName() });
	}

	/**
	 * Creates a new word with the primary key. Does not add the word to the database.
	 *
	 * @param wordId the primary key for the new word
	 * @return the new word
	 */
	public Word create(long wordId) {
		Word word = new WordImpl();

		word.setNew(true);
		word.setPrimaryKey(wordId);

		return word;
	}

	/**
	 * Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wordId the primary key of the word
	 * @return the word that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchWordException if a word with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Word remove(long wordId) throws NoSuchWordException, SystemException {
		return remove(Long.valueOf(wordId));
	}

	/**
	 * Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the word
	 * @return the word that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchWordException if a word with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Word remove(Serializable primaryKey)
		throws NoSuchWordException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Word word = (Word)session.get(WordImpl.class, primaryKey);

			if (word == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(word);
		}
		catch (NoSuchWordException nsee) {
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
	protected Word removeImpl(Word word) throws SystemException {
		word = toUnwrappedModel(word);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, word);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(word);

		return word;
	}

	@Override
	public Word updateImpl(com.liferay.consistent.tracking.model.Word word,
		boolean merge) throws SystemException {
		word = toUnwrappedModel(word);

		boolean isNew = word.isNew();

		WordModelImpl wordModelImpl = (WordModelImpl)word;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, word, merge);

			word.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WordModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordImpl.class, word.getPrimaryKey(), word);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDNAME,
				new Object[] { word.getWordName() }, word);
		}
		else {
			if ((wordModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WORDNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { wordModelImpl.getOriginalWordName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORDNAME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDNAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDNAME,
					new Object[] { word.getWordName() }, word);
			}
		}

		return word;
	}

	protected Word toUnwrappedModel(Word word) {
		if (word instanceof WordImpl) {
			return word;
		}

		WordImpl wordImpl = new WordImpl();

		wordImpl.setNew(word.isNew());
		wordImpl.setPrimaryKey(word.getPrimaryKey());

		wordImpl.setWordId(word.getWordId());
		wordImpl.setWordName(word.getWordName());

		return wordImpl;
	}

	/**
	 * Returns the word with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the word
	 * @return the word
	 * @throws com.liferay.portal.NoSuchModelException if a word with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Word findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the word with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchWordException} if it could not be found.
	 *
	 * @param wordId the primary key of the word
	 * @return the word
	 * @throws com.liferay.consistent.tracking.NoSuchWordException if a word with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Word findByPrimaryKey(long wordId)
		throws NoSuchWordException, SystemException {
		Word word = fetchByPrimaryKey(wordId);

		if (word == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + wordId);
			}

			throw new NoSuchWordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				wordId);
		}

		return word;
	}

	/**
	 * Returns the word with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the word
	 * @return the word, or <code>null</code> if a word with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Word fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the word with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wordId the primary key of the word
	 * @return the word, or <code>null</code> if a word with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Word fetchByPrimaryKey(long wordId) throws SystemException {
		Word word = (Word)EntityCacheUtil.getResult(WordModelImpl.ENTITY_CACHE_ENABLED,
				WordImpl.class, wordId);

		if (word == _nullWord) {
			return null;
		}

		if (word == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				word = (Word)session.get(WordImpl.class, Long.valueOf(wordId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (word != null) {
					cacheResult(word);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WordModelImpl.ENTITY_CACHE_ENABLED,
						WordImpl.class, wordId, _nullWord);
				}

				closeSession(session);
			}
		}

		return word;
	}

	/**
	 * Returns the word where wordName = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchWordException} if it could not be found.
	 *
	 * @param wordName the word name
	 * @return the matching word
	 * @throws com.liferay.consistent.tracking.NoSuchWordException if a matching word could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Word findByWordName(String wordName)
		throws NoSuchWordException, SystemException {
		Word word = fetchByWordName(wordName);

		if (word == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("wordName=");
			msg.append(wordName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWordException(msg.toString());
		}

		return word;
	}

	/**
	 * Returns the word where wordName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wordName the word name
	 * @return the matching word, or <code>null</code> if a matching word could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Word fetchByWordName(String wordName) throws SystemException {
		return fetchByWordName(wordName, true);
	}

	/**
	 * Returns the word where wordName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wordName the word name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching word, or <code>null</code> if a matching word could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Word fetchByWordName(String wordName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { wordName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WORDNAME,
					finderArgs, this);
		}

		if (result instanceof Word) {
			Word word = (Word)result;

			if (!Validator.equals(wordName, word.getWordName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WORD_WHERE);

			if (wordName == null) {
				query.append(_FINDER_COLUMN_WORDNAME_WORDNAME_1);
			}
			else {
				if (wordName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_WORDNAME_WORDNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_WORDNAME_WORDNAME_2);
				}
			}

			query.append(WordModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (wordName != null) {
					qPos.add(wordName);
				}

				List<Word> list = q.list();

				result = list;

				Word word = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDNAME,
						finderArgs, list);
				}
				else {
					word = list.get(0);

					cacheResult(word);

					if ((word.getWordName() == null) ||
							!word.getWordName().equals(wordName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDNAME,
							finderArgs, word);
					}
				}

				return word;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDNAME,
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
				return (Word)result;
			}
		}
	}

	/**
	 * Returns all the words.
	 *
	 * @return the words
	 * @throws SystemException if a system exception occurred
	 */
	public List<Word> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the words.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of words
	 * @param end the upper bound of the range of words (not inclusive)
	 * @return the range of words
	 * @throws SystemException if a system exception occurred
	 */
	public List<Word> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the words.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of words
	 * @param end the upper bound of the range of words (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of words
	 * @throws SystemException if a system exception occurred
	 */
	public List<Word> findAll(int start, int end,
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

		List<Word> list = (List<Word>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORD.concat(WordModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Word>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Word>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes the word where wordName = &#63; from the database.
	 *
	 * @param wordName the word name
	 * @return the word that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Word removeByWordName(String wordName)
		throws NoSuchWordException, SystemException {
		Word word = findByWordName(wordName);

		return remove(word);
	}

	/**
	 * Removes all the words from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Word word : findAll()) {
			remove(word);
		}
	}

	/**
	 * Returns the number of words where wordName = &#63;.
	 *
	 * @param wordName the word name
	 * @return the number of matching words
	 * @throws SystemException if a system exception occurred
	 */
	public int countByWordName(String wordName) throws SystemException {
		Object[] finderArgs = new Object[] { wordName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORDNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORD_WHERE);

			if (wordName == null) {
				query.append(_FINDER_COLUMN_WORDNAME_WORDNAME_1);
			}
			else {
				if (wordName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_WORDNAME_WORDNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_WORDNAME_WORDNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (wordName != null) {
					qPos.add(wordName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORDNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of words.
	 *
	 * @return the number of words
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORD);

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
	 * Initializes the word persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.Word")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Word>> listenersList = new ArrayList<ModelListener<Word>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Word>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WordImpl.class.getName());
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
	private static final String _SQL_SELECT_WORD = "SELECT word FROM Word word";
	private static final String _SQL_SELECT_WORD_WHERE = "SELECT word FROM Word word WHERE ";
	private static final String _SQL_COUNT_WORD = "SELECT COUNT(word) FROM Word word";
	private static final String _SQL_COUNT_WORD_WHERE = "SELECT COUNT(word) FROM Word word WHERE ";
	private static final String _FINDER_COLUMN_WORDNAME_WORDNAME_1 = "word.wordName IS NULL";
	private static final String _FINDER_COLUMN_WORDNAME_WORDNAME_2 = "word.wordName = ?";
	private static final String _FINDER_COLUMN_WORDNAME_WORDNAME_3 = "(word.wordName IS NULL OR word.wordName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "word.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Word exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Word exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WordPersistenceImpl.class);
	private static Word _nullWord = new WordImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Word> toCacheModel() {
				return _nullWordCacheModel;
			}
		};

	private static CacheModel<Word> _nullWordCacheModel = new CacheModel<Word>() {
			public Word toEntityModel() {
				return _nullWord;
			}
		};
}