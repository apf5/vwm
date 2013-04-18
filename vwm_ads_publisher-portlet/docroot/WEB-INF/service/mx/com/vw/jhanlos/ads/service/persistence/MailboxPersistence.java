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

import mx.com.vw.jhanlos.ads.model.Mailbox;

/**
 * The persistence interface for the mailbox service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxPersistenceImpl
 * @see MailboxUtil
 * @generated
 */
public interface MailboxPersistence extends BasePersistence<Mailbox> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MailboxUtil} to access the mailbox persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the mailbox in the entity cache if it is enabled.
	*
	* @param mailbox the mailbox
	*/
	public void cacheResult(mx.com.vw.jhanlos.ads.model.Mailbox mailbox);

	/**
	* Caches the mailboxs in the entity cache if it is enabled.
	*
	* @param mailboxs the mailboxs
	*/
	public void cacheResult(
		java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> mailboxs);

	/**
	* Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	*
	* @param mailboxId the primary key for the new mailbox
	* @return the new mailbox
	*/
	public mx.com.vw.jhanlos.ads.model.Mailbox create(long mailboxId);

	/**
	* Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox that was removed
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.Mailbox remove(long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxException;

	public mx.com.vw.jhanlos.ads.model.Mailbox updateImpl(
		mx.com.vw.jhanlos.ads.model.Mailbox mailbox, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the mailbox with the primary key or throws a {@link mx.com.vw.jhanlos.ads.NoSuchMailboxException} if it could not be found.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox
	* @throws mx.com.vw.jhanlos.ads.NoSuchMailboxException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.Mailbox findByPrimaryKey(long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException,
			mx.com.vw.jhanlos.ads.NoSuchMailboxException;

	/**
	* Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public mx.com.vw.jhanlos.ads.model.Mailbox fetchByPrimaryKey(long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the mailboxs.
	*
	* @return the mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the mailboxs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of mailboxs.
	*
	* @return the number of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}