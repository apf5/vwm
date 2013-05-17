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

import com.liferay.consistent.tracking.model.SiteHit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SiteHit in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see SiteHit
 * @generated
 */
public class SiteHitCacheModel implements CacheModel<SiteHit>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{hitId=");
		sb.append(hitId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", siteId=");
		sb.append(siteId);
		sb.append(", guest=");
		sb.append(guest);
		sb.append(", accessDate=");
		sb.append(accessDate);
		sb.append("}");

		return sb.toString();
	}

	public SiteHit toEntityModel() {
		SiteHitImpl siteHitImpl = new SiteHitImpl();

		siteHitImpl.setHitId(hitId);
		siteHitImpl.setCompanyId(companyId);
		siteHitImpl.setSiteId(siteId);
		siteHitImpl.setGuest(guest);
		siteHitImpl.setAccessDate(accessDate);

		siteHitImpl.resetOriginalValues();

		return siteHitImpl;
	}

	public long hitId;
	public long companyId;
	public long siteId;
	public boolean guest;
	public long accessDate;
}