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

package com.liferay.consistent.tracking.model.impl;

import com.liferay.consistent.tracking.model.PortletHit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing PortletHit in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see PortletHit
 * @generated
 */
public class PortletHitCacheModel implements CacheModel<PortletHit>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{hitId=");
		sb.append(hitId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", guest=");
		sb.append(guest);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userlogId=");
		sb.append(userlogId);
		sb.append(", accessDate=");
		sb.append(accessDate);
		sb.append("}");

		return sb.toString();
	}

	public PortletHit toEntityModel() {
		PortletHitImpl portletHitImpl = new PortletHitImpl();

		portletHitImpl.setHitId(hitId);
		portletHitImpl.setCompanyId(companyId);

		if (portletId == null) {
			portletHitImpl.setPortletId(StringPool.BLANK);
		}
		else {
			portletHitImpl.setPortletId(portletId);
		}

		portletHitImpl.setGuest(guest);
		portletHitImpl.setUserId(userId);
		portletHitImpl.setUserlogId(userlogId);
		portletHitImpl.setAccessDate(accessDate);

		portletHitImpl.resetOriginalValues();

		return portletHitImpl;
	}

	public long hitId;
	public long companyId;
	public String portletId;
	public boolean guest;
	public long userId;
	public long userlogId;
	public long accessDate;
}