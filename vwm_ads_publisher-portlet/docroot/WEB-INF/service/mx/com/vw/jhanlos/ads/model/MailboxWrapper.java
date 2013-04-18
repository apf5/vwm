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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Mailbox}.
 * </p>
 *
 * @author    Jorge Loayza
 * @see       Mailbox
 * @generated
 */
public class MailboxWrapper implements Mailbox, ModelWrapper<Mailbox> {
	public MailboxWrapper(Mailbox mailbox) {
		_mailbox = mailbox;
	}

	public Class<?> getModelClass() {
		return Mailbox.class;
	}

	public String getModelClassName() {
		return Mailbox.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mailboxId", getMailboxId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("iconId", getIconId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long mailboxId = (Long)attributes.get("mailboxId");

		if (mailboxId != null) {
			setMailboxId(mailboxId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long iconId = (Long)attributes.get("iconId");

		if (iconId != null) {
			setIconId(iconId);
		}
	}

	/**
	* Returns the primary key of this mailbox.
	*
	* @return the primary key of this mailbox
	*/
	public long getPrimaryKey() {
		return _mailbox.getPrimaryKey();
	}

	/**
	* Sets the primary key of this mailbox.
	*
	* @param primaryKey the primary key of this mailbox
	*/
	public void setPrimaryKey(long primaryKey) {
		_mailbox.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mailbox ID of this mailbox.
	*
	* @return the mailbox ID of this mailbox
	*/
	public long getMailboxId() {
		return _mailbox.getMailboxId();
	}

	/**
	* Sets the mailbox ID of this mailbox.
	*
	* @param mailboxId the mailbox ID of this mailbox
	*/
	public void setMailboxId(long mailboxId) {
		_mailbox.setMailboxId(mailboxId);
	}

	/**
	* Returns the company ID of this mailbox.
	*
	* @return the company ID of this mailbox
	*/
	public long getCompanyId() {
		return _mailbox.getCompanyId();
	}

	/**
	* Sets the company ID of this mailbox.
	*
	* @param companyId the company ID of this mailbox
	*/
	public void setCompanyId(long companyId) {
		_mailbox.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this mailbox.
	*
	* @return the user ID of this mailbox
	*/
	public long getUserId() {
		return _mailbox.getUserId();
	}

	/**
	* Sets the user ID of this mailbox.
	*
	* @param userId the user ID of this mailbox
	*/
	public void setUserId(long userId) {
		_mailbox.setUserId(userId);
	}

	/**
	* Returns the user uuid of this mailbox.
	*
	* @return the user uuid of this mailbox
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailbox.getUserUuid();
	}

	/**
	* Sets the user uuid of this mailbox.
	*
	* @param userUuid the user uuid of this mailbox
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_mailbox.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this mailbox.
	*
	* @return the create date of this mailbox
	*/
	public long getCreateDate() {
		return _mailbox.getCreateDate();
	}

	/**
	* Sets the create date of this mailbox.
	*
	* @param createDate the create date of this mailbox
	*/
	public void setCreateDate(long createDate) {
		_mailbox.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this mailbox.
	*
	* @return the modified date of this mailbox
	*/
	public long getModifiedDate() {
		return _mailbox.getModifiedDate();
	}

	/**
	* Sets the modified date of this mailbox.
	*
	* @param modifiedDate the modified date of this mailbox
	*/
	public void setModifiedDate(long modifiedDate) {
		_mailbox.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this mailbox.
	*
	* @return the name of this mailbox
	*/
	public java.lang.String getName() {
		return _mailbox.getName();
	}

	/**
	* Sets the name of this mailbox.
	*
	* @param name the name of this mailbox
	*/
	public void setName(java.lang.String name) {
		_mailbox.setName(name);
	}

	/**
	* Returns the icon ID of this mailbox.
	*
	* @return the icon ID of this mailbox
	*/
	public long getIconId() {
		return _mailbox.getIconId();
	}

	/**
	* Sets the icon ID of this mailbox.
	*
	* @param iconId the icon ID of this mailbox
	*/
	public void setIconId(long iconId) {
		_mailbox.setIconId(iconId);
	}

	public boolean isNew() {
		return _mailbox.isNew();
	}

	public void setNew(boolean n) {
		_mailbox.setNew(n);
	}

	public boolean isCachedModel() {
		return _mailbox.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_mailbox.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _mailbox.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _mailbox.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_mailbox.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mailbox.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mailbox.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MailboxWrapper((Mailbox)_mailbox.clone());
	}

	public int compareTo(mx.com.vw.jhanlos.ads.model.Mailbox mailbox) {
		return _mailbox.compareTo(mailbox);
	}

	@Override
	public int hashCode() {
		return _mailbox.hashCode();
	}

	public com.liferay.portal.model.CacheModel<mx.com.vw.jhanlos.ads.model.Mailbox> toCacheModel() {
		return _mailbox.toCacheModel();
	}

	public mx.com.vw.jhanlos.ads.model.Mailbox toEscapedModel() {
		return new MailboxWrapper(_mailbox.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _mailbox.toString();
	}

	public java.lang.String toXmlString() {
		return _mailbox.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_mailbox.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Mailbox getWrappedMailbox() {
		return _mailbox;
	}

	public Mailbox getWrappedModel() {
		return _mailbox;
	}

	public void resetOriginalValues() {
		_mailbox.resetOriginalValues();
	}

	private Mailbox _mailbox;
}