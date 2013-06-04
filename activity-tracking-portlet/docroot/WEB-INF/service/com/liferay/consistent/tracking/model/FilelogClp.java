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

import com.liferay.consistent.tracking.service.FilelogLocalServiceUtil;

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
public class FilelogClp extends BaseModelImpl<Filelog> implements Filelog {
	public FilelogClp() {
	}

	public Class<?> getModelClass() {
		return Filelog.class;
	}

	public String getModelClassName() {
		return Filelog.class.getName();
	}

	public long getPrimaryKey() {
		return _FilelogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFilelogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_FilelogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FilelogId", getFilelogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("guest", getGuest());
		attributes.put("userlogId", getUserlogId());
		attributes.put("fileId", getFileId());
		attributes.put("fileVersion", getFileVersion());
		attributes.put("accessDate", getAccessDate());
		attributes.put("elapseLoad", getElapseLoad());
		attributes.put("trafic", getTrafic());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FilelogId = (Long)attributes.get("FilelogId");

		if (FilelogId != null) {
			setFilelogId(FilelogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Boolean guest = (Boolean)attributes.get("guest");

		if (guest != null) {
			setGuest(guest);
		}

		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileVersion = (String)attributes.get("fileVersion");

		if (fileVersion != null) {
			setFileVersion(fileVersion);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}

		Long elapseLoad = (Long)attributes.get("elapseLoad");

		if (elapseLoad != null) {
			setElapseLoad(elapseLoad);
		}

		Boolean trafic = (Boolean)attributes.get("trafic");

		if (trafic != null) {
			setTrafic(trafic);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getFilelogId() {
		return _FilelogId;
	}

	public void setFilelogId(long FilelogId) {
		_FilelogId = FilelogId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getUserlogId() {
		return _userlogId;
	}

	public void setUserlogId(long userlogId) {
		_userlogId = userlogId;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileVersion() {
		return _fileVersion;
	}

	public void setFileVersion(String fileVersion) {
		_fileVersion = fileVersion;
	}

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_accessDate = accessDate;
	}

	public long getElapseLoad() {
		return _elapseLoad;
	}

	public void setElapseLoad(long elapseLoad) {
		_elapseLoad = elapseLoad;
	}

	public boolean getTrafic() {
		return _trafic;
	}

	public boolean isTrafic() {
		return _trafic;
	}

	public void setTrafic(boolean trafic) {
		_trafic = trafic;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public BaseModel<?> getFilelogRemoteModel() {
		return _filelogRemoteModel;
	}

	public void setFilelogRemoteModel(BaseModel<?> filelogRemoteModel) {
		_filelogRemoteModel = filelogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FilelogLocalServiceUtil.addFilelog(this);
		}
		else {
			FilelogLocalServiceUtil.updateFilelog(this);
		}
	}

	@Override
	public Filelog toEscapedModel() {
		return (Filelog)Proxy.newProxyInstance(Filelog.class.getClassLoader(),
			new Class[] { Filelog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FilelogClp clone = new FilelogClp();

		clone.setFilelogId(getFilelogId());
		clone.setCompanyId(getCompanyId());
		clone.setGuest(getGuest());
		clone.setUserlogId(getUserlogId());
		clone.setFileId(getFileId());
		clone.setFileVersion(getFileVersion());
		clone.setAccessDate(getAccessDate());
		clone.setElapseLoad(getElapseLoad());
		clone.setTrafic(getTrafic());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(Filelog filelog) {
		int value = 0;

		if (getAccessDate() < filelog.getAccessDate()) {
			value = -1;
		}
		else if (getAccessDate() > filelog.getAccessDate()) {
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

		FilelogClp filelog = null;

		try {
			filelog = (FilelogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = filelog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{FilelogId=");
		sb.append(getFilelogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", guest=");
		sb.append(getGuest());
		sb.append(", userlogId=");
		sb.append(getUserlogId());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", fileVersion=");
		sb.append(getFileVersion());
		sb.append(", accessDate=");
		sb.append(getAccessDate());
		sb.append(", elapseLoad=");
		sb.append(getElapseLoad());
		sb.append(", trafic=");
		sb.append(getTrafic());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.Filelog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>FilelogId</column-name><column-value><![CDATA[");
		sb.append(getFilelogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guest</column-name><column-value><![CDATA[");
		sb.append(getGuest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userlogId</column-name><column-value><![CDATA[");
		sb.append(getUserlogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileVersion</column-name><column-value><![CDATA[");
		sb.append(getFileVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessDate</column-name><column-value><![CDATA[");
		sb.append(getAccessDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elapseLoad</column-name><column-value><![CDATA[");
		sb.append(getElapseLoad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trafic</column-name><column-value><![CDATA[");
		sb.append(getTrafic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _FilelogId;
	private long _companyId;
	private boolean _guest;
	private long _userlogId;
	private long _fileId;
	private String _fileVersion;
	private long _accessDate;
	private long _elapseLoad;
	private boolean _trafic;
	private boolean _status;
	private BaseModel<?> _filelogRemoteModel;
}