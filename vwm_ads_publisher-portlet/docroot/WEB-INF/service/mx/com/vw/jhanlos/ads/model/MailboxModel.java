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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Mailbox service. Represents a row in the &quot;vwm_ads_Mailbox&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link mx.com.vw.jhanlos.ads.model.impl.MailboxModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link mx.com.vw.jhanlos.ads.model.impl.MailboxImpl}.
 * </p>
 *
 * @author Jorge Loayza
 * @see Mailbox
 * @see mx.com.vw.jhanlos.ads.model.impl.MailboxImpl
 * @see mx.com.vw.jhanlos.ads.model.impl.MailboxModelImpl
 * @generated
 */
public interface MailboxModel extends BaseModel<Mailbox> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a mailbox model instance should use the {@link Mailbox} interface instead.
	 */

	/**
	 * Returns the primary key of this mailbox.
	 *
	 * @return the primary key of this mailbox
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this mailbox.
	 *
	 * @param primaryKey the primary key of this mailbox
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mailbox ID of this mailbox.
	 *
	 * @return the mailbox ID of this mailbox
	 */
	public long getMailboxId();

	/**
	 * Sets the mailbox ID of this mailbox.
	 *
	 * @param mailboxId the mailbox ID of this mailbox
	 */
	public void setMailboxId(long mailboxId);

	/**
	 * Returns the company ID of this mailbox.
	 *
	 * @return the company ID of this mailbox
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this mailbox.
	 *
	 * @param companyId the company ID of this mailbox
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this mailbox.
	 *
	 * @return the user ID of this mailbox
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this mailbox.
	 *
	 * @param userId the user ID of this mailbox
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this mailbox.
	 *
	 * @return the user uuid of this mailbox
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this mailbox.
	 *
	 * @param userUuid the user uuid of this mailbox
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this mailbox.
	 *
	 * @return the create date of this mailbox
	 */
	public long getCreateDate();

	/**
	 * Sets the create date of this mailbox.
	 *
	 * @param createDate the create date of this mailbox
	 */
	public void setCreateDate(long createDate);

	/**
	 * Returns the modified date of this mailbox.
	 *
	 * @return the modified date of this mailbox
	 */
	public long getModifiedDate();

	/**
	 * Sets the modified date of this mailbox.
	 *
	 * @param modifiedDate the modified date of this mailbox
	 */
	public void setModifiedDate(long modifiedDate);

	/**
	 * Returns the name of this mailbox.
	 *
	 * @return the name of this mailbox
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this mailbox.
	 *
	 * @param name the name of this mailbox
	 */
	public void setName(String name);

	/**
	 * Returns the icon ID of this mailbox.
	 *
	 * @return the icon ID of this mailbox
	 */
	public long getIconId();

	/**
	 * Sets the icon ID of this mailbox.
	 *
	 * @param iconId the icon ID of this mailbox
	 */
	public void setIconId(long iconId);

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

	public int compareTo(Mailbox mailbox);

	public int hashCode();

	public CacheModel<Mailbox> toCacheModel();

	public Mailbox toEscapedModel();

	public String toString();

	public String toXmlString();
}