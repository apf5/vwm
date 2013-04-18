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
 * This class is a wrapper for {@link MailboxAdmin}.
 * </p>
 *
 * @author    Jorge Loayza
 * @see       MailboxAdmin
 * @generated
 */
public class MailboxAdminWrapper implements MailboxAdmin,
	ModelWrapper<MailboxAdmin> {
	public MailboxAdminWrapper(MailboxAdmin mailboxAdmin) {
		_mailboxAdmin = mailboxAdmin;
	}

	public Class<?> getModelClass() {
		return MailboxAdmin.class;
	}

	public String getModelClassName() {
		return MailboxAdmin.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mailboxAdminId", getMailboxAdminId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mailboxId", getMailboxId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long mailboxAdminId = (Long)attributes.get("mailboxAdminId");

		if (mailboxAdminId != null) {
			setMailboxAdminId(mailboxAdminId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long mailboxId = (Long)attributes.get("mailboxId");

		if (mailboxId != null) {
			setMailboxId(mailboxId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this mailbox admin.
	*
	* @return the primary key of this mailbox admin
	*/
	public long getPrimaryKey() {
		return _mailboxAdmin.getPrimaryKey();
	}

	/**
	* Sets the primary key of this mailbox admin.
	*
	* @param primaryKey the primary key of this mailbox admin
	*/
	public void setPrimaryKey(long primaryKey) {
		_mailboxAdmin.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mailbox admin ID of this mailbox admin.
	*
	* @return the mailbox admin ID of this mailbox admin
	*/
	public long getMailboxAdminId() {
		return _mailboxAdmin.getMailboxAdminId();
	}

	/**
	* Sets the mailbox admin ID of this mailbox admin.
	*
	* @param mailboxAdminId the mailbox admin ID of this mailbox admin
	*/
	public void setMailboxAdminId(long mailboxAdminId) {
		_mailboxAdmin.setMailboxAdminId(mailboxAdminId);
	}

	/**
	* Returns the create date of this mailbox admin.
	*
	* @return the create date of this mailbox admin
	*/
	public long getCreateDate() {
		return _mailboxAdmin.getCreateDate();
	}

	/**
	* Sets the create date of this mailbox admin.
	*
	* @param createDate the create date of this mailbox admin
	*/
	public void setCreateDate(long createDate) {
		_mailboxAdmin.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this mailbox admin.
	*
	* @return the modified date of this mailbox admin
	*/
	public long getModifiedDate() {
		return _mailboxAdmin.getModifiedDate();
	}

	/**
	* Sets the modified date of this mailbox admin.
	*
	* @param modifiedDate the modified date of this mailbox admin
	*/
	public void setModifiedDate(long modifiedDate) {
		_mailboxAdmin.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the mailbox ID of this mailbox admin.
	*
	* @return the mailbox ID of this mailbox admin
	*/
	public long getMailboxId() {
		return _mailboxAdmin.getMailboxId();
	}

	/**
	* Sets the mailbox ID of this mailbox admin.
	*
	* @param mailboxId the mailbox ID of this mailbox admin
	*/
	public void setMailboxId(long mailboxId) {
		_mailboxAdmin.setMailboxId(mailboxId);
	}

	/**
	* Returns the user ID of this mailbox admin.
	*
	* @return the user ID of this mailbox admin
	*/
	public long getUserId() {
		return _mailboxAdmin.getUserId();
	}

	/**
	* Sets the user ID of this mailbox admin.
	*
	* @param userId the user ID of this mailbox admin
	*/
	public void setUserId(long userId) {
		_mailboxAdmin.setUserId(userId);
	}

	/**
	* Returns the user uuid of this mailbox admin.
	*
	* @return the user uuid of this mailbox admin
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxAdmin.getUserUuid();
	}

	/**
	* Sets the user uuid of this mailbox admin.
	*
	* @param userUuid the user uuid of this mailbox admin
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_mailboxAdmin.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _mailboxAdmin.isNew();
	}

	public void setNew(boolean n) {
		_mailboxAdmin.setNew(n);
	}

	public boolean isCachedModel() {
		return _mailboxAdmin.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_mailboxAdmin.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _mailboxAdmin.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _mailboxAdmin.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_mailboxAdmin.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mailboxAdmin.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mailboxAdmin.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MailboxAdminWrapper((MailboxAdmin)_mailboxAdmin.clone());
	}

	public int compareTo(mx.com.vw.jhanlos.ads.model.MailboxAdmin mailboxAdmin) {
		return _mailboxAdmin.compareTo(mailboxAdmin);
	}

	@Override
	public int hashCode() {
		return _mailboxAdmin.hashCode();
	}

	public com.liferay.portal.model.CacheModel<mx.com.vw.jhanlos.ads.model.MailboxAdmin> toCacheModel() {
		return _mailboxAdmin.toCacheModel();
	}

	public mx.com.vw.jhanlos.ads.model.MailboxAdmin toEscapedModel() {
		return new MailboxAdminWrapper(_mailboxAdmin.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _mailboxAdmin.toString();
	}

	public java.lang.String toXmlString() {
		return _mailboxAdmin.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_mailboxAdmin.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public MailboxAdmin getWrappedMailboxAdmin() {
		return _mailboxAdmin;
	}

	public MailboxAdmin getWrappedModel() {
		return _mailboxAdmin;
	}

	public void resetOriginalValues() {
		_mailboxAdmin.resetOriginalValues();
	}

	private MailboxAdmin _mailboxAdmin;
}