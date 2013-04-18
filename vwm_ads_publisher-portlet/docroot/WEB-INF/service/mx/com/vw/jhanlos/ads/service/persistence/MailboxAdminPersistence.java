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

import com.liferay.portal.service.persistence.BasePersistence;

import mx.com.vw.jhanlos.ads.model.MailboxAdmin;

/**
 * The persistence interface for the mailbox admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxAdminPersistenceImpl
 * @see MailboxAdminUtil
 * @generated
 */
public interface MailboxAdminPersistence extends BasePersistence<MailboxAdmin> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MailboxAdminUtil} to access the mailbox admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the mailbox admin in the entity cache if it is enabled.
	*
	* @param mailboxAdmin the mailbox admin
	*/
	public void cacheResult(
		mx.com.vw.jhanlos.ads.model.MailboxAdmin mailboxAdmin);

	/**
	* Caches the mailbox admins in the entity cache if it is enabled.
	*
	* @param mailboxAdmins the mailbox admins
	*/
	public void cacheResult(
		java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> mailboxAdmins);

	/**
	* Creates a new mailbox admin with the primary key. Does not add the mailbox admin to the database.
	*
	* @param mailboxAdminId the primary key for the new mailbox admin
	* @return the new mailbox admin
	*/
	public mx.com.vw.jhanlos.ads.model.MailboxAdmin create(long mailboxAdminId);

	/**
	* Removes the mailbox admin with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailboxAdminId the primary key of the mailbox admin
	* @return the mailbox admin that was removed
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException if a mailbox admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.MailboxAdmin remove(long mailboxAdminId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException;

	public mx.com.vw.jhanlos.ads.model.MailboxAdmin updateImpl(
		mx.com.vw.jhanlos.ads.model.MailboxAdmin mailboxAdmin, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the mailbox admin with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException} if it could not be found.
	*
	* @param mailboxAdminId the primary key of the mailbox admin
	* @return the mailbox admin
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException if a mailbox admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.MailboxAdmin findByPrimaryKey(
		long mailboxAdminId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxAdminException;

	/**
	* Returns the mailbox admin with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mailboxAdminId the primary key of the mailbox admin
	* @return the mailbox admin, or <code>null</code> if a mailbox admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.MailboxAdmin fetchByPrimaryKey(
		long mailboxAdminId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the mailbox admins.
	*
	* @return the mailbox admins
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<mx.com.vw.jhanlos.ads.model.MailboxAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the mailbox admins from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of mailbox admins.
	*
	* @return the number of mailbox admins
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}