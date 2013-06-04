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

import com.liferay.consistent.tracking.model.Filelog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Filelog in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see Filelog
 * @generated
 */
public class FilelogCacheModel implements CacheModel<Filelog>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{FilelogId=");
		sb.append(FilelogId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", guest=");
		sb.append(guest);
		sb.append(", userlogId=");
		sb.append(userlogId);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileVersion=");
		sb.append(fileVersion);
		sb.append(", accessDate=");
		sb.append(accessDate);
		sb.append(", elapseLoad=");
		sb.append(elapseLoad);
		sb.append(", trafic=");
		sb.append(trafic);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public Filelog toEntityModel() {
		FilelogImpl filelogImpl = new FilelogImpl();

		filelogImpl.setFilelogId(FilelogId);
		filelogImpl.setCompanyId(companyId);
		filelogImpl.setGuest(guest);
		filelogImpl.setUserlogId(userlogId);
		filelogImpl.setFileId(fileId);

		if (fileVersion == null) {
			filelogImpl.setFileVersion(StringPool.BLANK);
		}
		else {
			filelogImpl.setFileVersion(fileVersion);
		}

		filelogImpl.setAccessDate(accessDate);
		filelogImpl.setElapseLoad(elapseLoad);
		filelogImpl.setTrafic(trafic);
		filelogImpl.setStatus(status);

		filelogImpl.resetOriginalValues();

		return filelogImpl;
	}

	public long FilelogId;
	public long companyId;
	public boolean guest;
	public long userlogId;
	public long fileId;
	public String fileVersion;
	public long accessDate;
	public long elapseLoad;
	public boolean trafic;
	public boolean status;
}