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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import mx.com.vw.jhanlos.ads.model.Mailbox;

import java.util.List;

/**
 * The persistence utility for the mailbox service. This utility wraps {@link MailboxPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxPersistence
 * @see MailboxPersistenceImpl
 * @generated
 */
public class MailboxUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Mailbox mailbox) {
		getPersistence().clearCache(mailbox);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Mailbox> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Mailbox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Mailbox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Mailbox update(Mailbox mailbox, boolean merge)
		throws SystemException {
		return getPersistence().update(mailbox, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Mailbox update(Mailbox mailbox, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(mailbox, merge, serviceContext);
	}

	/**
	* Caches the mailbox in the entity cache if it is enabled.
	*
	* @param mailbox the mailbox
	*/
	public static void cacheResult(mx.com.vw.jhanlos.ads.model.Mailbox mailbox) {
		getPersistence().cacheResult(mailbox);
	}

	/**
	* Caches the mailboxs in the entity cache if it is enabled.
	*
	* @param mailboxs the mailboxs
	*/
	public static void cacheResult(
		java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> mailboxs) {
		getPersistence().cacheResult(mailboxs);
	}

	/**
	* Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	*
	* @param mailboxId the primary key for the new mailbox
	* @return the new mailbox
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox create(long mailboxId) {
		return getPersistence().create(mailboxId);
	}

	/**
	* Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox that was removed
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox remove(long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxException {
		return getPersistence().remove(mailboxId);
	}

	public static mx.com.vw.jhanlos.ads.model.Mailbox updateImpl(
		mx.com.vw.jhanlos.ads.model.Mailbox mailbox, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(mailbox, merge);
	}

	/**
	* Returns the mailbox with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchMailboxException} if it could not be found.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox findByPrimaryKey(
		long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxException {
		return getPersistence().findByPrimaryKey(mailboxId);
	}

	/**
	* Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox fetchByPrimaryKey(
		long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mailboxId);
	}

	/**
	* Returns all the mailboxs.
	*
	* @return the mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the mailboxs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of mailboxs.
	*
	* @return the number of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MailboxPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MailboxPersistence)PortletBeanLocatorUtil.locate(mx.com.vw.jhanlos.ads.service.ClpSerializer.getServletContextName(),
					MailboxPersistence.class.getName());

			ReferenceRegistry.registerReference(MailboxUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(MailboxPersistence persistence) {
	}

	private static MailboxPersistence _persistence;
}