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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import mx.com.vw.jhanlos.ads.service.MailboxAdminLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza
 */
public class MailboxAdminClp extends BaseModelImpl<MailboxAdmin>
	implements MailboxAdmin {
	public MailboxAdminClp() {
	}

	public Class<?> getModelClass() {
		return MailboxAdmin.class;
	}

	public String getModelClassName() {
		return MailboxAdmin.class.getName();
	}

	public long getPrimaryKey() {
		return _mailboxAdminId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMailboxAdminId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_mailboxAdminId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mailboxAdminId", getMailboxAdminId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mailboxId", getMailboxId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
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

	public long getMailboxAdminId() {
		return _mailboxAdminId;
	}

	public void setMailboxAdminId(long mailboxAdminId) {
		_mailboxAdminId = mailboxAdminId;
	}

	public long getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	public long getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getMailboxId() {
		return _mailboxId;
	}

	public void setMailboxId(long mailboxId) {
		_mailboxId = mailboxId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getMailboxAdminRemoteModel() {
		return _mailboxAdminRemoteModel;
	}

	public void setMailboxAdminRemoteModel(BaseModel<?> mailboxAdminRemoteModel) {
		_mailboxAdminRemoteModel = mailboxAdminRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			MailboxAdminLocalServiceUtil.addMailboxAdmin(this);
		}
		else {
			MailboxAdminLocalServiceUtil.updateMailboxAdmin(this);
		}
	}

	@Override
	public MailboxAdmin toEscapedModel() {
		return (MailboxAdmin)Proxy.newProxyInstance(MailboxAdmin.class.getClassLoader(),
			new Class[] { MailboxAdmin.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MailboxAdminClp clone = new MailboxAdminClp();

		clone.setMailboxAdminId(getMailboxAdminId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMailboxId(getMailboxId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(MailboxAdmin mailboxAdmin) {
		int value = 0;

		if (getMailboxId() < mailboxAdmin.getMailboxId()) {
			value = -1;
		}
		else if (getMailboxId() > mailboxAdmin.getMailboxId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		MailboxAdminClp mailboxAdmin = null;

		try {
			mailboxAdmin = (MailboxAdminClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = mailboxAdmin.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{mailboxAdminId=");
		sb.append(getMailboxAdminId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", mailboxId=");
		sb.append(getMailboxId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("mx.com.vw.jhanlos.ads.model.MailboxAdmin");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mailboxAdminId</column-name><column-value><![CDATA[");
		sb.append(getMailboxAdminId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mailboxId</column-name><column-value><![CDATA[");
		sb.append(getMailboxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mailboxAdminId;
	private long _createDate;
	private long _modifiedDate;
	private long _mailboxId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _mailboxAdminRemoteModel;
}