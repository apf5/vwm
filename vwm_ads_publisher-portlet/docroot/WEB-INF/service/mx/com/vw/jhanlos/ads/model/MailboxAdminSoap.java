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
 * This class is used by SOAP remote services, specifically {@link mx.com.vw.jhanlos.ads.service.http.MailboxAdminServiceSoap}.
 *
 * @author    Jorge Loayza
 * @see       mx.com.vw.jhanlos.ads.service.http.MailboxAdminServiceSoap
 * @generated
 */
public class MailboxAdminSoap implements Serializable {
	public static MailboxAdminSoap toSoapModel(MailboxAdmin model) {
		MailboxAdminSoap soapModel = new MailboxAdminSoap();

		soapModel.setMailboxAdminId(model.getMailboxAdminId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMailboxId(model.getMailboxId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static MailboxAdminSoap[] toSoapModels(MailboxAdmin[] models) {
		MailboxAdminSoap[] soapModels = new MailboxAdminSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MailboxAdminSoap[][] toSoapModels(MailboxAdmin[][] models) {
		MailboxAdminSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MailboxAdminSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MailboxAdminSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MailboxAdminSoap[] toSoapModels(List<MailboxAdmin> models) {
		List<MailboxAdminSoap> soapModels = new ArrayList<MailboxAdminSoap>(models.size());

		for (MailboxAdmin model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MailboxAdminSoap[soapModels.size()]);
	}

	public MailboxAdminSoap() {
	}

	public long getPrimaryKey() {
		return _mailboxAdminId;
	}

	public void setPrimaryKey(long pk) {
		setMailboxAdminId(pk);
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

	private long _mailboxAdminId;
	private long _createDate;
	private long _modifiedDate;
	private long _mailboxId;
	private long _userId;
}