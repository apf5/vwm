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

import com.liferay.consistent.tracking.model.Browser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Browser in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see Browser
 * @generated
 */
public class BrowserCacheModel implements CacheModel<Browser>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{browserId=");
		sb.append(browserId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Browser toEntityModel() {
		BrowserImpl browserImpl = new BrowserImpl();

		browserImpl.setBrowserId(browserId);

		if (name == null) {
			browserImpl.setName(StringPool.BLANK);
		}
		else {
			browserImpl.setName(name);
		}

		browserImpl.resetOriginalValues();

		return browserImpl;
	}

	public long browserId;
	public String name;
}