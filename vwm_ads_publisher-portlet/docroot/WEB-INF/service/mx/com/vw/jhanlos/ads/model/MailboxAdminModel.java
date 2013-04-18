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

package mx.com.vw.jhanlos.ads.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MailboxAdmin service. Represents a row in the &quot;vwm_ads_MailboxAdmin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link mx.com.vw.jhanlos.ads.model.impl.MailboxAdminModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link mx.com.vw.jhanlos.ads.model.impl.MailboxAdminImpl}.
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxAdmin
 * @see mx.com.vw.jhanlos.ads.model.impl.MailboxAdminImpl
 * @see mx.com.vw.jhanlos.ads.model.impl.MailboxAdminModelImpl
 * @generated
 */
public interface MailboxAdminModel extends BaseModel<MailboxAdmin> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a mailbox admin model instance should use the {@link MailboxAdmin} interface instead.
	 */

	/**
	 * Returns the primary key of this mailbox admin.
	 *
	 * @return the primary key of this mailbox admin
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this mailbox admin.
	 *
	 * @param primaryKey the primary key of this mailbox admin
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mailbox admin ID of this mailbox admin.
	 *
	 * @return the mailbox admin ID of this mailbox admin
	 */
	public long getMailboxAdminId();

	/**
	 * Sets the mailbox admin ID of this mailbox admin.
	 *
	 * @param mailboxAdminId the mailbox admin ID of this mailbox admin
	 */
	public void setMailboxAdminId(long mailboxAdminId);

	/**
	 * Returns the create date of this mailbox admin.
	 *
	 * @return the create date of this mailbox admin
	 */
	public long getCreateDate();

	/**
	 * Sets the create date of this mailbox admin.
	 *
	 * @param createDate the create date of this mailbox admin
	 */
	public void setCreateDate(long createDate);

	/**
	 * Returns the modified date of this mailbox admin.
	 *
	 * @return the modified date of this mailbox admin
	 */
	public long getModifiedDate();

	/**
	 * Sets the modified date of this mailbox admin.
	 *
	 * @param modifiedDate the modified date of this mailbox admin
	 */
	public void setModifiedDate(long modifiedDate);

	/**
	 * Returns the mailbox ID of this mailbox admin.
	 *
	 * @return the mailbox ID of this mailbox admin
	 */
	public long getMailboxId();

	/**
	 * Sets the mailbox ID of this mailbox admin.
	 *
	 * @param mailboxId the mailbox ID of this mailbox admin
	 */
	public void setMailboxId(long mailboxId);

	/**
	 * Returns the user ID of this mailbox admin.
	 *
	 * @return the user ID of this mailbox admin
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this mailbox admin.
	 *
	 * @param userId the user ID of this mailbox admin
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this mailbox admin.
	 *
	 * @return the user uuid of this mailbox admin
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this mailbox admin.
	 *
	 * @param userUuid the user uuid of this mailbox admin
	 */
	public void setUserUuid(String userUuid);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(MailboxAdmin mailboxAdmin);

	public int hashCode();

	public CacheModel<MailboxAdmin> toCacheModel();

	public MailboxAdmin toEscapedModel();

	public String toString();

	public String toXmlString();
}