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

import mx.com.vw.jhanlos.ads.model.MailboxAdmin;

import java.util.List;

/**
 * The persistence utility for the mailbox admin service. This utility wraps {@link MailboxAdminPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxAdminPersistence
 * @see MailboxAdminPersistenceImpl
 * @generated
 */
public class MailboxAdminUtil {
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
	public static void clearCache(MailboxAdmin mailboxAdmin) {
		getPersistence().clearCache(mailboxAdmin);
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
	public static List<MailboxAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MailboxAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MailboxAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static MailboxAdmin update(MailboxAdmin mailboxAdmin, boolean merge)
		throws SystemException {
		return getPersistence().update(mailboxAdmin, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static MailboxAdmin update(MailboxAdmin mailboxAdmin, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(mailboxAdmin, merge, serviceContext);
	}

	/**
	* Caches the mailbox admin in the entity cache if it is enabled.
	*
	* @param mailboxAdmin the mailbox admin
	*/
	public static void cacheResult(
		mx.com.vw.jhanlos.ads.model.MailboxAdmin mailboxAdmin) {
		getPersistence().cacheResult(mailboxAdmin);
	}

	/**
	* Caches the mailbox admins in the entity cache if it is enabled.
	*
	* @param mailboxAdmins the mailbox admins
	*/
	public static void cacheResult(
		java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> mailboxAdmins) {
		getPersistence().cacheResult(mailboxAdmins);
	}

	/**
	* Creates a new mailbox admin with the primary key. Does not add the mailbox admin to the database.
	*
	* @param mailboxAdminId the primary key for the new mailbox admin
	* @return the new mailbox admin
	*/
	public static mx.com.vw.jhanlos.ads.model.MailboxAdmin create(
		long mailboxAdminId) {
		return getPersistence().create(mailboxAdminId);
	}

	/**
	* Removes the mailbox admin with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailboxAdminId the primary key of the mailbox admin
	* @return the mailbox admin that was removed
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException if a mailbox admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.MailboxAdmin remove(
		long mailboxAdminId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException {
		return getPersistence().remove(mailboxAdminId);
	}

	public static mx.com.vw.jhanlos.ads.model.MailboxAdmin updateImpl(
		mx.com.vw.jhanlos.ads.model.MailboxAdmin mailboxAdmin, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(mailboxAdmin, merge);
	}

	/**
	* Returns the mailbox admin with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException} if it could not be found.
	*
	* @param mailboxAdminId the primary key of the mailbox admin
	* @return the mailbox admin
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException if a mailbox admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.MailboxAdmin findByPrimaryKey(
		long mailboxAdminId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException {
		return getPersistence().findByPrimaryKey(mailboxAdminId);
	}

	/**
	* Returns the mailbox admin with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mailboxAdminId the primary key of the mailbox admin
	* @return the mailbox admin, or <code>null</code> if a mailbox admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.MailboxAdmin fetchByPrimaryKey(
		long mailboxAdminId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mailboxAdminId);
	}

	/**
	* Returns all the mailbox admins.
	*
	* @return the mailbox admins
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the mailbox admins from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of mailbox admins.
	*
	* @return the number of mailbox admins
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MailboxAdminPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MailboxAdminPersistence)PortletBeanLocatorUtil.locate(mx.com.vw.jhanlos.ads.service.ClpSerializer.getServletContextName(),
					MailboxAdminPersistence.class.getName());

			ReferenceRegistry.registerReference(MailboxAdminUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(MailboxAdminPersistence persistence) {
	}

	private static MailboxAdminPersistence _persistence;
}