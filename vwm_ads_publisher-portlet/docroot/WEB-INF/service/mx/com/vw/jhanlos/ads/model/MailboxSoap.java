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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link mx.com.vw.jhanlos.ads.service.http.MailboxServiceSoap}.
 *
 * @author    Jorge Loayza
 * @see       mx.com.vw.jhanlos.ads.service.http.MailboxServiceSoap
 * @generated
 */
public class MailboxSoap implements Serializable {
	public static MailboxSoap toSoapModel(Mailbox model) {
		MailboxSoap soapModel = new MailboxSoap();

		soapModel.setMailboxId(model.getMailboxId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setIconId(model.getIconId());

		return soapModel;
	}

	public static MailboxSoap[] toSoapModels(Mailbox[] models) {
		MailboxSoap[] soapModels = new MailboxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MailboxSoap[][] toSoapModels(Mailbox[][] models) {
		MailboxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MailboxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MailboxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MailboxSoap[] toSoapModels(List<Mailbox> models) {
		List<MailboxSoap> soapModels = new ArrayList<MailboxSoap>(models.size());

		for (Mailbox model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MailboxSoap[soapModels.size()]);
	}

	public MailboxSoap() {
	}

	public long getPrimaryKey() {
		return _mailboxId;
	}

	public void setPrimaryKey(long pk) {
		setMailboxId(pk);
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

	private long _mailboxId;
	private long _companyId;
	private long _userId;
	private long _createDate;
	private long _modifiedDate;
	private String _name;
	private long _iconId;
}