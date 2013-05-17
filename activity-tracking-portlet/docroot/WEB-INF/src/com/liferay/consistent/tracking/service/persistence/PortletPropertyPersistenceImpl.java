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

import com.liferay.consistent.tracking.NoSuchPortletPropertyException;
import com.liferay.consistent.tracking.model.PortletProperty;
import com.liferay.consistent.tracking.model.impl.PortletPropertyImpl;
import com.liferay.consistent.tracking.model.impl.PortletPropertyModelImpl;

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
 * The persistence implementation for the portlet property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PortletPropertyPersistence
 * @see PortletPropertyUtil
 * @generated
 */
public class PortletPropertyPersistenceImpl extends BasePersistenceImpl<PortletProperty>
	implements PortletPropertyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortletPropertyUtil} to access the portlet property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortletPropertyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED,
			PortletPropertyImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { Long.class.getName(), String.class.getName() },
			PortletPropertyModelImpl.COMPANYID_COLUMN_BITMASK |
			PortletPropertyModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED,
			PortletPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED,
			PortletPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			PortletPropertyModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED,
			PortletPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED,
			PortletPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the portlet property in the entity cache if it is enabled.
	 *
	 * @param portletProperty the portlet property
	 */
	public void cacheResult(PortletProperty portletProperty) {
		EntityCacheUtil.putResult(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyImpl.class, portletProperty.getPrimaryKey(),
			portletProperty);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] {
				Long.valueOf(portletProperty.getCompanyId()),
				
			portletProperty.getName()
			}, portletProperty);

		portletProperty.resetOriginalValues();
	}

	/**
	 * Caches the portlet properties in the entity cache if it is enabled.
	 *
	 * @param portletProperties the portlet properties
	 */
	public void cacheResult(List<PortletProperty> portletProperties) {
		for (PortletProperty portletProperty : portletProperties) {
			if (EntityCacheUtil.getResult(
						PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
						PortletPropertyImpl.class,
						portletProperty.getPrimaryKey()) == null) {
				cacheResult(portletProperty);
			}
			else {
				portletProperty.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portlet properties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortletPropertyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortletPropertyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the portlet property.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortletProperty portletProperty) {
		EntityCacheUtil.removeResult(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyImpl.class, portletProperty.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(portletProperty);
	}

	@Override
	public void clearCache(List<PortletProperty> portletProperties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortletProperty portletProperty : portletProperties) {
			EntityCacheUtil.removeResult(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
				PortletPropertyImpl.class, portletProperty.getPrimaryKey());

			clearUniqueFindersCache(portletProperty);
		}
	}

	protected void clearUniqueFindersCache(PortletProperty portletProperty) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] {
				Long.valueOf(portletProperty.getCompanyId()),
				
			portletProperty.getName()
			});
	}

	/**
	 * Creates a new portlet property with the primary key. Does not add the portlet property to the database.
	 *
	 * @param propertyId the primary key for the new portlet property
	 * @return the new portlet property
	 */
	public PortletProperty create(long propertyId) {
		PortletProperty portletProperty = new PortletPropertyImpl();

		portletProperty.setNew(true);
		portletProperty.setPrimaryKey(propertyId);

		return portletProperty;
	}

	/**
	 * Removes the portlet property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param propertyId the primary key of the portlet property
	 * @return the portlet property that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a portlet property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty remove(long propertyId)
		throws NoSuchPortletPropertyException, SystemException {
		return remove(Long.valueOf(propertyId));
	}

	/**
	 * Removes the portlet property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the portlet property
	 * @return the portlet property that was removed
	 * @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a portlet property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletProperty remove(Serializable primaryKey)
		throws NoSuchPortletPropertyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortletProperty portletProperty = (PortletProperty)session.get(PortletPropertyImpl.class,
					primaryKey);

			if (portletProperty == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortletPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portletProperty);
		}
		catch (NoSuchPortletPropertyException nsee) {
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
	protected PortletProperty removeImpl(PortletProperty portletProperty)
		throws SystemException {
		portletProperty = toUnwrappedModel(portletProperty);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, portletProperty);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(portletProperty);

		return portletProperty;
	}

	@Override
	public PortletProperty updateImpl(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty,
		boolean merge) throws SystemException {
		portletProperty = toUnwrappedModel(portletProperty);

		boolean isNew = portletProperty.isNew();

		PortletPropertyModelImpl portletPropertyModelImpl = (PortletPropertyModelImpl)portletProperty;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, portletProperty, merge);

			portletProperty.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortletPropertyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portletPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletPropertyModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(portletPropertyModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
			PortletPropertyImpl.class, portletProperty.getPrimaryKey(),
			portletProperty);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] {
					Long.valueOf(portletProperty.getCompanyId()),
					
				portletProperty.getName()
				}, portletProperty);
		}
		else {
			if ((portletPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletPropertyModelImpl.getOriginalCompanyId()),
						
						portletPropertyModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
					new Object[] {
						Long.valueOf(portletProperty.getCompanyId()),
						
					portletProperty.getName()
					}, portletProperty);
			}
		}

		return portletProperty;
	}

	protected PortletProperty toUnwrappedModel(PortletProperty portletProperty) {
		if (portletProperty instanceof PortletPropertyImpl) {
			return portletProperty;
		}

		PortletPropertyImpl portletPropertyImpl = new PortletPropertyImpl();

		portletPropertyImpl.setNew(portletProperty.isNew());
		portletPropertyImpl.setPrimaryKey(portletProperty.getPrimaryKey());

		portletPropertyImpl.setPropertyId(portletProperty.getPropertyId());
		portletPropertyImpl.setCompanyId(portletProperty.getCompanyId());
		portletPropertyImpl.setName(portletProperty.getName());
		portletPropertyImpl.setValue(portletProperty.getValue());

		return portletPropertyImpl;
	}

	/**
	 * Returns the portlet property with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet property
	 * @return the portlet property
	 * @throws com.liferay.portal.NoSuchModelException if a portlet property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletProperty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet property with the primary key or throws a {@link com.liferay.consistent.tracking.NoSuchPortletPropertyException} if it could not be found.
	 *
	 * @param propertyId the primary key of the portlet property
	 * @return the portlet property
	 * @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a portlet property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty findByPrimaryKey(long propertyId)
		throws NoSuchPortletPropertyException, SystemException {
		PortletProperty portletProperty = fetchByPrimaryKey(propertyId);

		if (portletProperty == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + propertyId);
			}

			throw new NoSuchPortletPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				propertyId);
		}

		return portletProperty;
	}

	/**
	 * Returns the portlet property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet property
	 * @return the portlet property, or <code>null</code> if a portlet property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletProperty fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param propertyId the primary key of the portlet property
	 * @return the portlet property, or <code>null</code> if a portlet property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty fetchByPrimaryKey(long propertyId)
		throws SystemException {
		PortletProperty portletProperty = (PortletProperty)EntityCacheUtil.getResult(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
				PortletPropertyImpl.class, propertyId);

		if (portletProperty == _nullPortletProperty) {
			return null;
		}

		if (portletProperty == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				portletProperty = (PortletProperty)session.get(PortletPropertyImpl.class,
						Long.valueOf(propertyId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (portletProperty != null) {
					cacheResult(portletProperty);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PortletPropertyModelImpl.ENTITY_CACHE_ENABLED,
						PortletPropertyImpl.class, propertyId,
						_nullPortletProperty);
				}

				closeSession(session);
			}
		}

		return portletProperty;
	}

	/**
	 * Returns the portlet property where companyId = &#63; and name = &#63; or throws a {@link com.liferay.consistent.tracking.NoSuchPortletPropertyException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching portlet property
	 * @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a matching portlet property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty findByName(long companyId, String name)
		throws NoSuchPortletPropertyException, SystemException {
		PortletProperty portletProperty = fetchByName(companyId, name);

		if (portletProperty == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPortletPropertyException(msg.toString());
		}

		return portletProperty;
	}

	/**
	 * Returns the portlet property where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching portlet property, or <code>null</code> if a matching portlet property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty fetchByName(long companyId, String name)
		throws SystemException {
		return fetchByName(companyId, name, true);
	}

	/**
	 * Returns the portlet property where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching portlet property, or <code>null</code> if a matching portlet property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty fetchByName(long companyId, String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof PortletProperty) {
			PortletProperty portletProperty = (PortletProperty)result;

			if ((companyId != portletProperty.getCompanyId()) ||
					!Validator.equals(name, portletProperty.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PORTLETPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_NAME_COMPANYID_2);

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

			query.append(PortletPropertyModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (name != null) {
					qPos.add(name);
				}

				List<PortletProperty> list = q.list();

				result = list;

				PortletProperty portletProperty = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					portletProperty = list.get(0);

					cacheResult(portletProperty);

					if ((portletProperty.getCompanyId() != companyId) ||
							(portletProperty.getName() == null) ||
							!portletProperty.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, portletProperty);
					}
				}

				return portletProperty;
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
				return (PortletProperty)result;
			}
		}
	}

	/**
	 * Returns all the portlet properties where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletProperty> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the portlet properties where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portlet properties
	 * @param end the upper bound of the range of portlet properties (not inclusive)
	 * @return the range of matching portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletProperty> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet properties where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portlet properties
	 * @param end the upper bound of the range of portlet properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletProperty> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<PortletProperty> list = (List<PortletProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletProperty portletProperty : list) {
				if ((companyId != portletProperty.getCompanyId())) {
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

			query.append(_SQL_SELECT_PORTLETPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<PortletProperty>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first portlet property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet property
	 * @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a matching portlet property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletPropertyException, SystemException {
		PortletProperty portletProperty = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (portletProperty != null) {
			return portletProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletPropertyException(msg.toString());
	}

	/**
	 * Returns the first portlet property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet property, or <code>null</code> if a matching portlet property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortletProperty> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portlet property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet property
	 * @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a matching portlet property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletPropertyException, SystemException {
		PortletProperty portletProperty = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (portletProperty != null) {
			return portletProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletPropertyException(msg.toString());
	}

	/**
	 * Returns the last portlet property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet property, or <code>null</code> if a matching portlet property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<PortletProperty> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portlet properties before and after the current portlet property in the ordered set where companyId = &#63;.
	 *
	 * @param propertyId the primary key of the current portlet property
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet property
	 * @throws com.liferay.consistent.tracking.NoSuchPortletPropertyException if a portlet property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty[] findByCompanyId_PrevAndNext(long propertyId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPortletPropertyException, SystemException {
		PortletProperty portletProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			PortletProperty[] array = new PortletPropertyImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, portletProperty,
					companyId, orderByComparator, true);

			array[1] = portletProperty;

			array[2] = getByCompanyId_PrevAndNext(session, portletProperty,
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

	protected PortletProperty getByCompanyId_PrevAndNext(Session session,
		PortletProperty portletProperty, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETPROPERTY_WHERE);

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
			query.append(PortletPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet properties.
	 *
	 * @return the portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletProperty> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet properties
	 * @param end the upper bound of the range of portlet properties (not inclusive)
	 * @return the range of portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletProperty> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet properties
	 * @param end the upper bound of the range of portlet properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletProperty> findAll(int start, int end,
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

		List<PortletProperty> list = (List<PortletProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTLETPROPERTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTLETPROPERTY.concat(PortletPropertyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PortletProperty>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PortletProperty>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes the portlet property where companyId = &#63; and name = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the portlet property that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public PortletProperty removeByName(long companyId, String name)
		throws NoSuchPortletPropertyException, SystemException {
		PortletProperty portletProperty = findByName(companyId, name);

		return remove(portletProperty);
	}

	/**
	 * Removes all the portlet properties where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (PortletProperty portletProperty : findByCompanyId(companyId)) {
			remove(portletProperty);
		}
	}

	/**
	 * Removes all the portlet properties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PortletProperty portletProperty : findAll()) {
			remove(portletProperty);
		}
	}

	/**
	 * Returns the number of portlet properties where companyId = &#63; and name = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the number of matching portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(long companyId, String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PORTLETPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_NAME_COMPANYID_2);

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

				qPos.add(companyId);

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
	 * Returns the number of portlet properties where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTLETPROPERTY_WHERE);

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
	 * Returns the number of portlet properties.
	 *
	 * @return the number of portlet properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PORTLETPROPERTY);

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
	 * Initializes the portlet property persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consistent.tracking.model.PortletProperty")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortletProperty>> listenersList = new ArrayList<ModelListener<PortletProperty>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortletProperty>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortletPropertyImpl.class.getName());
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
	private static final String _SQL_SELECT_PORTLETPROPERTY = "SELECT portletProperty FROM PortletProperty portletProperty";
	private static final String _SQL_SELECT_PORTLETPROPERTY_WHERE = "SELECT portletProperty FROM PortletProperty portletProperty WHERE ";
	private static final String _SQL_COUNT_PORTLETPROPERTY = "SELECT COUNT(portletProperty) FROM PortletProperty portletProperty";
	private static final String _SQL_COUNT_PORTLETPROPERTY_WHERE = "SELECT COUNT(portletProperty) FROM PortletProperty portletProperty WHERE ";
	private static final String _FINDER_COLUMN_NAME_COMPANYID_2 = "portletProperty.companyId = ? AND ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "portletProperty.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "portletProperty.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(portletProperty.name IS NULL OR portletProperty.name = ?)";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "portletProperty.companyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portletProperty.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortletProperty exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortletProperty exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortletPropertyPersistenceImpl.class);
	private static PortletProperty _nullPortletProperty = new PortletPropertyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortletProperty> toCacheModel() {
				return _nullPortletPropertyCacheModel;
			}
		};

	private static CacheModel<PortletProperty> _nullPortletPropertyCacheModel = new CacheModel<PortletProperty>() {
			public PortletProperty toEntityModel() {
				return _nullPortletProperty;
			}
		};
}