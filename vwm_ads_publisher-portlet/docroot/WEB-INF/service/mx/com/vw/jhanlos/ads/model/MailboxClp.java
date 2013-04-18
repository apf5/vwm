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

import mx.com.vw.jhanlos.ads.service.MailboxLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza
 */
public class MailboxClp extends BaseModelImpl<Mailbox> implements Mailbox {
	public MailboxClp() {
	}

	public Class<?> getModelClass() {
		return Mailbox.class;
	}

	public String getModelClassName() {
		return Mailbox.class.getName();
	}

	public long getPrimaryKey() {
		return _mailboxId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMailboxId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_mailboxId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getMailboxId() {
		return _mailboxId;
	}

	public void setMailboxId(long mailboxId) {
		_mailboxId = mailboxId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getIconId() {
		return _iconId;
	}

	public void setIconId(long iconId) {
		_iconId = iconId;
	}

	public BaseModel<?> getMailboxRemoteModel() {
		return _mailboxRemoteModel;
	}

	public void setMailboxRemoteModel(BaseModel<?> mailboxRemoteModel) {
		_mailboxRemoteModel = mailboxRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			MailboxLocalServiceUtil.addMailbox(this);
		}
		else {
			MailboxLocalServiceUtil.updateMailbox(this);
		}
	}

	@Override
	public Mailbox toEscapedModel() {
		return (Mailbox)Proxy.newProxyInstance(Mailbox.class.getClassLoader(),
			new Class[] { Mailbox.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MailboxClp clone = new MailboxClp();

		clone.setMailboxId(getMailboxId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setIconId(getIconId());

		return clone;
	}

	public int compareTo(Mailbox mailbox) {
		int value = 0;

		value = getName().compareTo(mailbox.getName());

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

		MailboxClp mailbox = null;

		try {
			mailbox = (MailboxClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = mailbox.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{mailboxId=");
		sb.append(getMailboxId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", iconId=");
		sb.append(getIconId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("mx.com.vw.jhanlos.ads.model.Mailbox");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mailboxId</column-name><column-value><![CDATA[");
		sb.append(getMailboxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconId</column-name><column-value><![CDATA[");
		sb.append(getIconId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mailboxId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _createDate;
	private long _modifiedDate;
	private String _name;
	private long _iconId;
	private BaseModel<?> _mailboxRemoteModel;
}