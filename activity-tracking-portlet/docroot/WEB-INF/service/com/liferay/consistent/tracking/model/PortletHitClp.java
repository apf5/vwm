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

import com.liferay.consistent.tracking.service.PortletHitLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jorge Loayza Soloisolo
 */
public class PortletHitClp extends BaseModelImpl<PortletHit>
	implements PortletHit {
	public PortletHitClp() {
	}

	public Class<?> getModelClass() {
		return PortletHit.class;
	}

	public String getModelClassName() {
		return PortletHit.class.getName();
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
		attributes.put("portletId", getPortletId());
		attributes.put("guest", getGuest());
		attributes.put("userId", getUserId());
		attributes.put("userlogId", getUserlogId());
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

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Boolean guest = (Boolean)attributes.get("guest");

		if (guest != null) {
			setGuest(guest);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
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

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getUserlogId() {
		return _userlogId;
	}

	public void setUserlogId(long userlogId) {
		_userlogId = userlogId;
	}

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_accessDate = accessDate;
	}

	public BaseModel<?> getPortletHitRemoteModel() {
		return _portletHitRemoteModel;
	}

	public void setPortletHitRemoteModel(BaseModel<?> portletHitRemoteModel) {
		_portletHitRemoteModel = portletHitRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PortletHitLocalServiceUtil.addPortletHit(this);
		}
		else {
			PortletHitLocalServiceUtil.updatePortletHit(this);
		}
	}

	@Override
	public PortletHit toEscapedModel() {
		return (PortletHit)Proxy.newProxyInstance(PortletHit.class.getClassLoader(),
			new Class[] { PortletHit.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortletHitClp clone = new PortletHitClp();

		clone.setHitId(getHitId());
		clone.setCompanyId(getCompanyId());
		clone.setPortletId(getPortletId());
		clone.setGuest(getGuest());
		clone.setUserId(getUserId());
		clone.setUserlogId(getUserlogId());
		clone.setAccessDate(getAccessDate());

		return clone;
	}

	public int compareTo(PortletHit portletHit) {
		int value = 0;

		if (getAccessDate() < portletHit.getAccessDate()) {
			value = -1;
		}
		else if (getAccessDate() > portletHit.getAccessDate()) {
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

		PortletHitClp portletHit = null;

		try {
			portletHit = (PortletHitClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = portletHit.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{hitId=");
		sb.append(getHitId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", guest=");
		sb.append(getGuest());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userlogId=");
		sb.append(getUserlogId());
		sb.append(", accessDate=");
		sb.append(getAccessDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.PortletHit");
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
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guest</column-name><column-value><![CDATA[");
		sb.append(getGuest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userlogId</column-name><column-value><![CDATA[");
		sb.append(getUserlogId());
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
	private String _portletId;
	private boolean _guest;
	private long _userId;
	private String _userUuid;
	private long _userlogId;
	private long _accessDate;
	private BaseModel<?> _portletHitRemoteModel;
}