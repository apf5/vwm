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

import mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException;
import mx.com.vw.jhanlos.ads.model.MailboxAdmin;
import mx.com.vw.jhanlos.ads.model.impl.MailboxAdminImpl;
import mx.com.vw.jhanlos.ads.model.impl.MailboxAdminModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the mailbox admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxAdminPersistence
 * @see MailboxAdminUtil
 * @generated
 */
public class MailboxAdminPersistenceImpl extends BasePersistenceImpl<MailboxAdmin>
	implements MailboxAdminPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MailboxAdminUtil} to access the mailbox admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MailboxAdminImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
			MailboxAdminModelImpl.FINDER_CACHE_ENABLED, MailboxAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
			MailboxAdminModelImpl.FINDER_CACHE_ENABLED, MailboxAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
			MailboxAdminModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the mailbox admin in the entity cache if it is enabled.
	 *
	 * @param mailboxAdmin the mailbox admin
	 */
	public void cacheResult(MailboxAdmin mailboxAdmin) {
		EntityCacheUtil.putResult(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
			MailboxAdminImpl.class, mailboxAdmin.getPrimaryKey(), mailboxAdmin);

		mailboxAdmin.resetOriginalValues();
	}

	/**
	 * Caches the mailbox admins in the entity cache if it is enabled.
	 *
	 * @param mailboxAdmins the mailbox admins
	 */
	public void cacheResult(List<MailboxAdmin> mailboxAdmins) {
		for (MailboxAdmin mailboxAdmin : mailboxAdmins) {
			if (EntityCacheUtil.getResult(
						MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
						MailboxAdminImpl.class, mailboxAdmin.getPrimaryKey()) == null) {
				cacheResult(mailboxAdmin);
			}
			else {
				mailboxAdmin.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mailbox admins.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MailboxAdminImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MailboxAdminImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mailbox admin.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MailboxAdmin mailboxAdmin) {
		EntityCacheUtil.removeResult(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
			MailboxAdminImpl.class, mailboxAdmin.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MailboxAdmin> mailboxAdmins) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MailboxAdmin mailboxAdmin : mailboxAdmins) {
			EntityCacheUtil.removeResult(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
				MailboxAdminImpl.class, mailboxAdmin.getPrimaryKey());
		}
	}

	/**
	 * Creates a new mailbox admin with the primary key. Does not add the mailbox admin to the database.
	 *
	 * @param mailboxAdminId the primary key for the new mailbox admin
	 * @return the new mailbox admin
	 */
	public MailboxAdmin create(long mailboxAdminId) {
		MailboxAdmin mailboxAdmin = new MailboxAdminImpl();

		mailboxAdmin.setNew(true);
		mailboxAdmin.setPrimaryKey(mailboxAdminId);

		return mailboxAdmin;
	}

	/**
	 * Removes the mailbox admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailboxAdminId the primary key of the mailbox admin
	 * @return the mailbox admin that was removed
	 * @throws mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException if a mailbox admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MailboxAdmin remove(long mailboxAdminId)
		throws NoSuchMailboxAdminException, SystemException {
		return remove(Long.valueOf(mailboxAdminId));
	}

	/**
	 * Removes the mailbox admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mailbox admin
	 * @return the mailbox admin that was removed
	 * @throws mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException if a mailbox admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MailboxAdmin remove(Serializable primaryKey)
		throws NoSuchMailboxAdminException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MailboxAdmin mailboxAdmin = (MailboxAdmin)session.get(MailboxAdminImpl.class,
					primaryKey);

			if (mailboxAdmin == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMailboxAdminException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(mailboxAdmin);
		}
		catch (NoSuchMailboxAdminException nsee) {
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
	protected MailboxAdmin removeImpl(MailboxAdmin mailboxAdmin)
		throws SystemException {
		mailboxAdmin = toUnwrappedModel(mailboxAdmin);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, mailboxAdmin);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(mailboxAdmin);

		return mailboxAdmin;
	}

	@Override
	public MailboxAdmin updateImpl(
		mx.com.vw.jhanlos.ads.model.MailboxAdmin mailboxAdmin, boolean merge)
		throws SystemException {
		mailboxAdmin = toUnwrappedModel(mailboxAdmin);

		boolean isNew = mailboxAdmin.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, mailboxAdmin, merge);

			mailboxAdmin.setNew(false);
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

		EntityCacheUtil.putResult(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
			MailboxAdminImpl.class, mailboxAdmin.getPrimaryKey(), mailboxAdmin);

		return mailboxAdmin;
	}

	protected MailboxAdmin toUnwrappedModel(MailboxAdmin mailboxAdmin) {
		if (mailboxAdmin instanceof MailboxAdminImpl) {
			return mailboxAdmin;
		}

		MailboxAdminImpl mailboxAdminImpl = new MailboxAdminImpl();

		mailboxAdminImpl.setNew(mailboxAdmin.isNew());
		mailboxAdminImpl.setPrimaryKey(mailboxAdmin.getPrimaryKey());

		mailboxAdminImpl.setMailboxAdminId(mailboxAdmin.getMailboxAdminId());
		mailboxAdminImpl.setCreateDate(mailboxAdmin.getCreateDate());
		mailboxAdminImpl.setModifiedDate(mailboxAdmin.getModifiedDate());
		mailboxAdminImpl.setMailboxId(mailboxAdmin.getMailboxId());
		mailboxAdminImpl.setUserId(mailboxAdmin.getUserId());

		return mailboxAdminImpl;
	}

	/**
	 * Returns the mailbox admin with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the mailbox admin
	 * @return the mailbox admin
	 * @throws com.liferay.portal.NoSuchModelException if a mailbox admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MailboxAdmin findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the mailbox admin with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException} if it could not be found.
	 *
	 * @param mailboxAdminId the primary key of the mailbox admin
	 * @return the mailbox admin
	 * @throws mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException if a mailbox admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MailboxAdmin findByPrimaryKey(long mailboxAdminId)
		throws NoSuchMailboxAdminException, SystemException {
		MailboxAdmin mailboxAdmin = fetchByPrimaryKey(mailboxAdminId);

		if (mailboxAdmin == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + mailboxAdminId);
			}

			throw new NoSuchMailboxAdminException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				mailboxAdminId);
		}

		return mailboxAdmin;
	}

	/**
	 * Returns the mailbox admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mailbox admin
	 * @return the mailbox admin, or <code>null</code> if a mailbox admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MailboxAdmin fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the mailbox admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mailboxAdminId the primary key of the mailbox admin
	 * @return the mailbox admin, or <code>null</code> if a mailbox admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MailboxAdmin fetchByPrimaryKey(long mailboxAdminId)
		throws SystemException {
		MailboxAdmin mailboxAdmin = (MailboxAdmin)EntityCacheUtil.getResult(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
				MailboxAdminImpl.class, mailboxAdminId);

		if (mailboxAdmin == _nullMailboxAdmin) {
			return null;
		}

		if (mailboxAdmin == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				mailboxAdmin = (MailboxAdmin)session.get(MailboxAdminImpl.class,
						Long.valueOf(mailboxAdminId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (mailboxAdmin != null) {
					cacheResult(mailboxAdmin);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MailboxAdminModelImpl.ENTITY_CACHE_ENABLED,
						MailboxAdminImpl.class, mailboxAdminId,
						_nullMailboxAdmin);
				}

				closeSession(session);
			}
		}

		return mailboxAdmin;
	}

	/**
	 * Returns all the mailbox admins.
	 *
	 * @return the mailbox admins
	 * @throws SystemException if a system exception occurred
	 */
	public List<MailboxAdmin> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mailbox admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of mailbox admins
	 * @param end the upper bound of the range of mailbox admins (not inclusive)
	 * @return the range of mailbox admins
	 * @throws SystemException if a system exception occurred
	 */
	public List<MailboxAdmin> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mailbox admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of mailbox admins
	 * @param end the upper bound of the range of mailbox admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mailbox admins
	 * @throws SystemException if a system exception occurred
	 */
	public List<MailboxAdmin> findAll(int start, int end,
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

		List<MailboxAdmin> list = (List<MailboxAdmin>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MAILBOXADMIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAILBOXADMIN.concat(MailboxAdminModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<MailboxAdmin>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<MailboxAdmin>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the mailbox admins from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (MailboxAdmin mailboxAdmin : findAll()) {
			remove(mailboxAdmin);
		}
	}

	/**
	 * Returns the number of mailbox admins.
	 *
	 * @return the number of mailbox admins
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MAILBOXADMIN);

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
	 * Initializes the mailbox admin persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.mx.com.vw.jhanlos.ads.model.MailboxAdmin")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MailboxAdmin>> listenersList = new ArrayList<ModelListener<MailboxAdmin>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MailboxAdmin>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MailboxAdminImpl.class.getName());
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
	private static final String _SQL_SELECT_MAILBOXADMIN = "SELECT mailboxAdmin FROM MailboxAdmin mailboxAdmin";
	private static final String _SQL_COUNT_MAILBOXADMIN = "SELECT COUNT(mailboxAdmin) FROM MailboxAdmin mailboxAdmin";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mailboxAdmin.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MailboxAdmin exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MailboxAdminPersistenceImpl.class);
	private static MailboxAdmin _nullMailboxAdmin = new MailboxAdminImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MailboxAdmin> toCacheModel() {
				return _nullMailboxAdminCacheModel;
			}
		};

	private static CacheModel<MailboxAdmin> _nullMailboxAdminCacheModel = new CacheModel<MailboxAdmin>() {
			public MailboxAdmin toEntityModel() {
				return _nullMailboxAdmin;
			}
		};
}