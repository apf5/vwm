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

import com.liferay.consistent.tracking.model.Browsinglog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Browsinglog in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see Browsinglog
 * @generated
 */
public class BrowsinglogCacheModel implements CacheModel<Browsinglog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{browsinglogId=");
		sb.append(browsinglogId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userlogId=");
		sb.append(userlogId);
		sb.append(", userAgent=");
		sb.append(userAgent);
		sb.append(", url=");
		sb.append(url);
		sb.append(", plId=");
		sb.append(plId);
		sb.append(", accessName=");
		sb.append(accessName);
		sb.append(", accessFound=");
		sb.append(accessFound);
		sb.append(", accessDate=");
		sb.append(accessDate);
		sb.append(", elapseLoad=");
		sb.append(elapseLoad);
		sb.append(", uploadSize=");
		sb.append(uploadSize);
		sb.append(", downloadSize=");
		sb.append(downloadSize);
		sb.append("}");

		return sb.toString();
	}

	public Browsinglog toEntityModel() {
		BrowsinglogImpl browsinglogImpl = new BrowsinglogImpl();

		browsinglogImpl.setBrowsinglogId(browsinglogId);
		browsinglogImpl.setCompanyId(companyId);
		browsinglogImpl.setUserlogId(userlogId);

		if (userAgent == null) {
			browsinglogImpl.setUserAgent(StringPool.BLANK);
		}
		else {
			browsinglogImpl.setUserAgent(userAgent);
		}

		if (url == null) {
			browsinglogImpl.setUrl(StringPool.BLANK);
		}
		else {
			browsinglogImpl.setUrl(url);
		}

		browsinglogImpl.setPlId(plId);

		if (accessName == null) {
			browsinglogImpl.setAccessName(StringPool.BLANK);
		}
		else {
			browsinglogImpl.setAccessName(accessName);
		}

		browsinglogImpl.setAccessFound(accessFound);
		browsinglogImpl.setAccessDate(accessDate);
		browsinglogImpl.setElapseLoad(elapseLoad);
		browsinglogImpl.setUploadSize(uploadSize);
		browsinglogImpl.setDownloadSize(downloadSize);

		browsinglogImpl.resetOriginalValues();

		return browsinglogImpl;
	}

	public long browsinglogId;
	public long companyId;
	public long userlogId;
	public String userAgent;
	public String url;
	public long plId;
	public String accessName;
	public boolean accessFound;
	public long accessDate;
	public long elapseLoad;
	public long uploadSize;
	public long downloadSize;
}