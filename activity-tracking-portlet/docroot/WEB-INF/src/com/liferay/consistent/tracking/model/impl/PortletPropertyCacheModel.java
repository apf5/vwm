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

import com.liferay.consistent.tracking.model.PortletProperty;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing PortletProperty in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see PortletProperty
 * @generated
 */
public class PortletPropertyCacheModel implements CacheModel<PortletProperty>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{propertyId=");
		sb.append(propertyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	public PortletProperty toEntityModel() {
		PortletPropertyImpl portletPropertyImpl = new PortletPropertyImpl();

		portletPropertyImpl.setPropertyId(propertyId);
		portletPropertyImpl.setCompanyId(companyId);

		if (name == null) {
			portletPropertyImpl.setName(StringPool.BLANK);
		}
		else {
			portletPropertyImpl.setName(name);
		}

		if (value == null) {
			portletPropertyImpl.setValue(StringPool.BLANK);
		}
		else {
			portletPropertyImpl.setValue(value);
		}

		portletPropertyImpl.resetOriginalValues();

		return portletPropertyImpl;
	}

	public long propertyId;
	public long companyId;
	public String name;
	public String value;
}