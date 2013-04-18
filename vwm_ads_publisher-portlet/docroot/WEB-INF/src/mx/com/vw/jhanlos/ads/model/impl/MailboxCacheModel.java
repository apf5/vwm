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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import mx.com.vw.jhanlos.ads.model.Mailbox;

import java.io.Serializable;

/**
 * The cache model class for representing Mailbox in entity cache.
 *
 * @author Jorge Loayza
 * @see Mailbox
 * @generated
 */
public class MailboxCacheModel implements CacheModel<Mailbox>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{mailboxId=");
		sb.append(mailboxId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", iconId=");
		sb.append(iconId);
		sb.append("}");

		return sb.toString();
	}

	public Mailbox toEntityModel() {
		MailboxImpl mailboxImpl = new MailboxImpl();

		mailboxImpl.setMailboxId(mailboxId);
		mailboxImpl.setCompanyId(companyId);
		mailboxImpl.setUserId(userId);
		mailboxImpl.setCreateDate(createDate);
		mailboxImpl.setModifiedDate(modifiedDate);

		if (name == null) {
			mailboxImpl.setName(StringPool.BLANK);
		}
		else {
			mailboxImpl.setName(name);
		}

		mailboxImpl.setIconId(iconId);

		mailboxImpl.resetOriginalValues();

		return mailboxImpl;
	}

	public long mailboxId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long iconId;
}