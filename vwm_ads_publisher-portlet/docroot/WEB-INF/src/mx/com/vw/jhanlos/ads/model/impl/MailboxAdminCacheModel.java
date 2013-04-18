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

package mx.com.vw.jhanlos.ads.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import mx.com.vw.jhanlos.ads.model.MailboxAdmin;

import java.io.Serializable;

/**
 * The cache model class for representing MailboxAdmin in entity cache.
 *
 * @author Jorge Loayza
 * @see MailboxAdmin
 * @generated
 */
public class MailboxAdminCacheModel implements CacheModel<MailboxAdmin>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{mailboxAdminId=");
		sb.append(mailboxAdminId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", mailboxId=");
		sb.append(mailboxId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public MailboxAdmin toEntityModel() {
		MailboxAdminImpl mailboxAdminImpl = new MailboxAdminImpl();

		mailboxAdminImpl.setMailboxAdminId(mailboxAdminId);
		mailboxAdminImpl.setCreateDate(createDate);
		mailboxAdminImpl.setModifiedDate(modifiedDate);
		mailboxAdminImpl.setMailboxId(mailboxId);
		mailboxAdminImpl.setUserId(userId);

		mailboxAdminImpl.resetOriginalValues();

		return mailboxAdminImpl;
	}

	public long mailboxAdminId;
	public long createDate;
	public long modifiedDate;
	public long mailboxId;
	public long userId;
}