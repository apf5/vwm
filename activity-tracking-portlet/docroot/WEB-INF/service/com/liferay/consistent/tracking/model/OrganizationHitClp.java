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

package com.liferay.consistent.tracking.model;

import com.liferay.consistent.tracking.service.OrganizationHitLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza Soloisolo
 */
public class OrganizationHitClp extends BaseModelImpl<OrganizationHit>
	implements OrganizationHit {
	public OrganizationHitClp() {
	}

	public Class<?> getModelClass() {
		return OrganizationHit.class;
	}

	public String getModelClassName() {
		return OrganizationHit.class.getName();
	}

	public long getPrimaryKey() {
		return _hitId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHitId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hitId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("guest", getGuest());
		attributes.put("accessDate", getAccessDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long hitId = (Long)attributes.get("hitId");

		if (hitId != null) {
			setHitId(hitId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Boolean guest = (Boolean)attributes.get("guest");

		if (guest != null) {
			setGuest(guest);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}
	}

	public long getHitId() {
		return _hitId;
	}

	public void setHitId(long hitId) {
		_hitId = hitId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public boolean getGuest() {
		return _guest;
	}

	public boolean isGuest() {
		return _guest;
	}

	public void setGuest(boolean guest) {
		_guest = guest;
	}

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_accessDate = accessDate;
	}

	public BaseModel<?> getOrganizationHitRemoteModel() {
		return _organizationHitRemoteModel;
	}

	public void setOrganizationHitRemoteModel(
		BaseModel<?> organizationHitRemoteModel) {
		_organizationHitRemoteModel = organizationHitRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OrganizationHitLocalServiceUtil.addOrganizationHit(this);
		}
		else {
			OrganizationHitLocalServiceUtil.updateOrganizationHit(this);
		}
	}

	@Override
	public OrganizationHit toEscapedModel() {
		return (OrganizationHit)Proxy.newProxyInstance(OrganizationHit.class.getClassLoader(),
			new Class[] { OrganizationHit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrganizationHitClp clone = new OrganizationHitClp();

		clone.setHitId(getHitId());
		clone.setCompanyId(getCompanyId());
		clone.setOrganizationId(getOrganizationId());
		clone.setGuest(getGuest());
		clone.setAccessDate(getAccessDate());

		return clone;
	}

	public int compareTo(OrganizationHit organizationHit) {
		int value = 0;

		if (getAccessDate() < organizationHit.getAccessDate()) {
			value = -1;
		}
		else if (getAccessDate() > organizationHit.getAccessDate()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrganizationHitClp organizationHit = null;

		try {
			organizationHit = (OrganizationHitClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = organizationHit.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{hitId=");
		sb.append(getHitId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", guest=");
		sb.append(getGuest());
		sb.append(", accessDate=");
		sb.append(getAccessDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.OrganizationHit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hitId</column-name><column-value><![CDATA[");
		sb.append(getHitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guest</column-name><column-value><![CDATA[");
		sb.append(getGuest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessDate</column-name><column-value><![CDATA[");
		sb.append(getAccessDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hitId;
	private long _companyId;
	private long _organizationId;
	private boolean _guest;
	private long _accessDate;
	private BaseModel<?> _organizationHitRemoteModel;
}