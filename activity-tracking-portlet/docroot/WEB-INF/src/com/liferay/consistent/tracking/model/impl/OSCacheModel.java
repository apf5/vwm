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

import com.liferay.consistent.tracking.model.OS;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing OS in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see OS
 * @generated
 */
public class OSCacheModel implements CacheModel<OS>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{osId=");
		sb.append(osId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public OS toEntityModel() {
		OSImpl osImpl = new OSImpl();

		osImpl.setOsId(osId);

		if (name == null) {
			osImpl.setName(StringPool.BLANK);
		}
		else {
			osImpl.setName(name);
		}

		osImpl.resetOriginalValues();

		return osImpl;
	}

	public long osId;
	public String name;
}