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

import mx.com.vw.jhanlos.ads.model.Propertie;

import java.io.Serializable;

/**
 * The cache model class for representing Propertie in entity cache.
 *
 * @author Jorge Loayza
 * @see Propertie
 * @generated
 */
public class PropertieCacheModel implements CacheModel<Propertie>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{propertieId=");
		sb.append(propertieId);
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
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	public Propertie toEntityModel() {
		PropertieImpl propertieImpl = new PropertieImpl();

		propertieImpl.setPropertieId(propertieId);
		propertieImpl.setCompanyId(companyId);
		propertieImpl.setUserId(userId);
		propertieImpl.setCreateDate(createDate);
		propertieImpl.setModifiedDate(modifiedDate);

		if (name == null) {
			propertieImpl.setName(StringPool.BLANK);
		}
		else {
			propertieImpl.setName(name);
		}

		if (value == null) {
			propertieImpl.setValue(StringPool.BLANK);
		}
		else {
			propertieImpl.setValue(value);
		}

		propertieImpl.resetOriginalValues();

		return propertieImpl;
	}

	public long propertieId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String value;
}