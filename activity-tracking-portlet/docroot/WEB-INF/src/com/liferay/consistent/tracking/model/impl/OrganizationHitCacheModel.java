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

import com.liferay.consistent.tracking.model.OrganizationHit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing OrganizationHit in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see OrganizationHit
 * @generated
 */
public class OrganizationHitCacheModel implements CacheModel<OrganizationHit>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{hitId=");
		sb.append(hitId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", guest=");
		sb.append(guest);
		sb.append(", accessDate=");
		sb.append(accessDate);
		sb.append("}");

		return sb.toString();
	}

	public OrganizationHit toEntityModel() {
		OrganizationHitImpl organizationHitImpl = new OrganizationHitImpl();

		organizationHitImpl.setHitId(hitId);
		organizationHitImpl.setCompanyId(companyId);
		organizationHitImpl.setOrganizationId(organizationId);
		organizationHitImpl.setGuest(guest);
		organizationHitImpl.setAccessDate(accessDate);

		organizationHitImpl.resetOriginalValues();

		return organizationHitImpl;
	}

	public long hitId;
	public long companyId;
	public long organizationId;
	public boolean guest;
	public long accessDate;
}