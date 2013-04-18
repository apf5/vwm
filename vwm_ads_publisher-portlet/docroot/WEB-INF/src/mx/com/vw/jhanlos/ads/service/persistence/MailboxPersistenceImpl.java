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

import mx.com.vw.jhanlos.ads.NoSuchMailboxException;
import mx.com.vw.jhanlos.ads.model.Mailbox;
import mx.com.vw.jhanlos.ads.model.impl.MailboxImpl;
import mx.com.vw.jhanlos.ads.model.impl.MailboxModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the mailbox service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxPersistence
 * @see MailboxUtil
 * @generated
 */
public class MailboxPersistenceImpl extends BasePersistenceImpl<Mailbox>
	implements MailboxPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MailboxUtil} to access the mailbox persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MailboxImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, MailboxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, MailboxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the mailbox in the entity cache if it is enabled.
	 *
	 * @param mailbox the mailbox
	 */
	public void cacheResult(Mailbox mailbox) {
		EntityCacheUtil.putResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxImpl.class, mailbox.getPrimaryKey(), mailbox);

		mailbox.resetOriginalValues();
	}

	/**
	 * Caches the mailboxs in the entity cache if it is enabled.
	 *
	 * @param mailboxs the mailboxs
	 */
	public void cacheResult(List<Mailbox> mailboxs) {
		for (Mailbox mailbox : mailboxs) {
			if (EntityCacheUtil.getResult(
						MailboxModelImpl.ENTITY_CACHE_ENABLED,
						MailboxImpl.class, mailbox.getPrimaryKey()) == null) {
				cacheResult(mailbox);
			}
			else {
				mailbox.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mailboxs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MailboxImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MailboxImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mailbox.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Mailbox mailbox) {
		EntityCacheUtil.removeResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxImpl.class, mailbox.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Mailbox> mailboxs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Mailbox mailbox : mailboxs) {
			EntityCacheUtil.removeResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
				MailboxImpl.class, mailbox.getPrimaryKey());
		}
	}

	/**
	 * Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	 *
	 * @param mailboxId the primary key for the new mailbox
	 * @return the new mailbox
	 */
	public Mailbox create(long mailboxId) {
		Mailbox mailbox = new MailboxImpl();

		mailbox.setNew(true);
		mailbox.setPrimaryKey(mailboxId);

		return mailbox;
	}

	/**
	 * Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailboxId the primary key of the mailbox
	 * @return the mailbox that was removed
	 * @throws mx.com.vw.jhanlos.ads.NoSuchMailboxException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Mailbox remove(long mailboxId)
		throws NoSuchMailboxException, SystemException {
		return remove(Long.valueOf(mailboxId));
	}

	/**
	 * Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mailbox
	 * @return the mailbox that was removed
	 * @throws mx.com.vw.jhanlos.ads.NoSuchMailboxException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox remove(Serializable primaryKey)
		throws NoSuchMailboxException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Mailbox mailbox = (Mailbox)session.get(MailboxImpl.class, primaryKey);

			if (mailbox == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMailboxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(mailbox);
		}
		catch (NoSuchMailboxException nsee) {
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
	protected Mailbox removeImpl(Mailbox mailbox) throws SystemException {
		mailbox = toUnwrappedModel(mailbox);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, mailbox);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(mailbox);

		return mailbox;
	}

	@Override
	public Mailbox updateImpl(mx.com.vw.jhanlos.ads.model.Mailbox mailbox,
		boolean merge) throws SystemException {
		mailbox = toUnwrappedModel(mailbox);

		boolean isNew = mailbox.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, mailbox, merge);

			mailbox.setNew(false);
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

		EntityCacheUtil.putResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxImpl.class, mailbox.getPrimaryKey(), mailbox);

		return mailbox;
	}

	protected Mailbox toUnwrappedModel(Mailbox mailbox) {
		if (mailbox instanceof MailboxImpl) {
			return mailbox;
		}

		MailboxImpl mailboxImpl = new MailboxImpl();

		mailboxImpl.setNew(mailbox.isNew());
		mailboxImpl.setPrimaryKey(mailbox.getPrimaryKey());

		mailboxImpl.setMailboxId(mailbox.getMailboxId());
		mailboxImpl.setCompanyId(mailbox.getCompanyId());
		mailboxImpl.setUserId(mailbox.getUserId());
		mailboxImpl.setCreateDate(mailbox.getCreateDate());
		mailboxImpl.setModifiedDate(mailbox.getModifiedDate());
		mailboxImpl.setName(mailbox.getName());
		mailboxImpl.setIconId(mailbox.getIconId());

		return mailboxImpl;
	}

	/**
	 * Returns the mailbox with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the mailbox
	 * @return the mailbox
	 * @throws com.liferay.portal.NoSuchModelException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the mailbox with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchMailboxException} if it could not be found.
	 *
	 * @param mailboxId the primary key of the mailbox
	 * @return the mailbox
	 * @throws mx.com.vw.jhanlos.ads.NoSuchMailboxException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Mailbox findByPrimaryKey(long mailboxId)
		throws NoSuchMailboxException, SystemException {
		Mailbox mailbox = fetchByPrimaryKey(mailboxId);

		if (mailbox == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + mailboxId);
			}

			throw new NoSuchMailboxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				mailboxId);
		}

		return mailbox;
	}

	/**
	 * Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mailbox
	 * @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mailboxId the primary key of the mailbox
	 * @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Mailbox fetchByPrimaryKey(long mailboxId) throws SystemException {
		Mailbox mailbox = (Mailbox)EntityCacheUtil.getResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
				MailboxImpl.class, mailboxId);

		if (mailbox == _nullMailbox) {
			return null;
		}

		if (mailbox == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				mailbox = (Mailbox)session.get(MailboxImpl.class,
						Long.valueOf(mailboxId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (mailbox != null) {
					cacheResult(mailbox);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
						MailboxImpl.class, mailboxId, _nullMailbox);
				}

				closeSession(session);
			}
		}

		return mailbox;
	}

	/**
	 * Returns all the mailboxs.
	 *
	 * @return the mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Mailbox> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mailboxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of mailboxs
	 * @param end the upper bound of the range of mailboxs (not inclusive)
	 * @return the range of mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Mailbox> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mailboxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of mailboxs
	 * @param end the upper bound of the range of mailboxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Mailbox> findAll(int start, int end,
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

		List<Mailbox> list = (List<Mailbox>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MAILBOX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAILBOX.concat(MailboxModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Mailbox>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Mailbox>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the mailboxs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Mailbox mailbox : findAll()) {
			remove(mailbox);
		}
	}

	/**
	 * Returns the number of mailboxs.
	 *
	 * @return the number of mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MAILBOX);

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
	 * Initializes the mailbox persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.mx.com.vw.jhanlos.ads.model.Mailbox")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Mailbox>> listenersList = new ArrayList<ModelListener<Mailbox>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Mailbox>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MailboxImpl.class.getName());
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
	private static final String _SQL_SELECT_MAILBOX = "SELECT mailbox FROM Mailbox mailbox";
	private static final String _SQL_COUNT_MAILBOX = "SELECT COUNT(mailbox) FROM Mailbox mailbox";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mailbox.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Mailbox exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MailboxPersistenceImpl.class);
	private static Mailbox _nullMailbox = new MailboxImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Mailbox> toCacheModel() {
				return _nullMailboxCacheModel;
			}
		};

	private static CacheModel<Mailbox> _nullMailboxCacheModel = new CacheModel<Mailbox>() {
			public Mailbox toEntityModel() {
				return _nullMailbox;
			}
		};
}