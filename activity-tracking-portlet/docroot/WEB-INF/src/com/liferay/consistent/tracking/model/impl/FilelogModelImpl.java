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
import com.liferay.consistent.tracking.model.FilelogModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Filelog service. Represents a row in the &quot;CONSIS_TRACK_Filelog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.consistent.tracking.model.FilelogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FilelogImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see FilelogImpl
 * @see com.liferay.consistent.tracking.model.Filelog
 * @see com.liferay.consistent.tracking.model.FilelogModel
 * @generated
 */
public class FilelogModelImpl extends BaseModelImpl<Filelog>
	implements FilelogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a filelog model instance should use the {@link com.liferay.consistent.tracking.model.Filelog} interface instead.
	 */
	public static final String TABLE_NAME = "CONSIS_TRACK_Filelog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "FilelogId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "guest", Types.BOOLEAN },
			{ "userlogId", Types.BIGINT },
			{ "fileId", Types.BIGINT },
			{ "accessDate", Types.BIGINT },
			{ "elapseLoad", Types.BIGINT },
			{ "trafic", Types.BOOLEAN },
			{ "status", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table CONSIS_TRACK_Filelog (FilelogId LONG not null primary key,companyId LONG,guest BOOLEAN,userlogId LONG,fileId LONG,accessDate LONG,elapseLoad LONG,trafic BOOLEAN,status BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table CONSIS_TRACK_Filelog";
	public static final String ORDER_BY_JPQL = " ORDER BY filelog.accessDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CONSIS_TRACK_Filelog.accessDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.consistent.tracking.model.Filelog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.consistent.tracking.model.Filelog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.consistent.tracking.model.Filelog"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GUEST_COLUMN_BITMASK = 2L;
	public static long USERLOGID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.consistent.tracking.model.Filelog"));

	public FilelogModelImpl() {
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

	public Class<?> getModelClass() {
		return Filelog.class;
	}

	public String getModelClassName() {
		return Filelog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FilelogId", getFilelogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("guest", getGuest());
		attributes.put("userlogId", getUserlogId());
		attributes.put("fileId", getFileId());
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
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public boolean getGuest() {
		return _guest;
	}

	public boolean isGuest() {
		return _guest;
	}

	public void setGuest(boolean guest) {
		_columnBitmask |= GUEST_COLUMN_BITMASK;

		if (!_setOriginalGuest) {
			_setOriginalGuest = true;

			_originalGuest = _guest;
		}

		_guest = guest;
	}

	public boolean getOriginalGuest() {
		return _originalGuest;
	}

	public long getUserlogId() {
		return _userlogId;
	}

	public void setUserlogId(long userlogId) {
		_columnBitmask |= USERLOGID_COLUMN_BITMASK;

		if (!_setOriginalUserlogId) {
			_setOriginalUserlogId = true;

			_originalUserlogId = _userlogId;
		}

		_userlogId = userlogId;
	}

	public long getOriginalUserlogId() {
		return _originalUserlogId;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_columnBitmask = -1L;

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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Filelog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Filelog toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Filelog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		FilelogImpl filelogImpl = new FilelogImpl();

		filelogImpl.setFilelogId(getFilelogId());
		filelogImpl.setCompanyId(getCompanyId());
		filelogImpl.setGuest(getGuest());
		filelogImpl.setUserlogId(getUserlogId());
		filelogImpl.setFileId(getFileId());
		filelogImpl.setAccessDate(getAccessDate());
		filelogImpl.setElapseLoad(getElapseLoad());
		filelogImpl.setTrafic(getTrafic());
		filelogImpl.setStatus(getStatus());

		filelogImpl.resetOriginalValues();

		return filelogImpl;
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

		Filelog filelog = null;

		try {
			filelog = (Filelog)obj;
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
	public void resetOriginalValues() {
		FilelogModelImpl filelogModelImpl = this;

		filelogModelImpl._originalCompanyId = filelogModelImpl._companyId;

		filelogModelImpl._setOriginalCompanyId = false;

		filelogModelImpl._originalGuest = filelogModelImpl._guest;

		filelogModelImpl._setOriginalGuest = false;

		filelogModelImpl._originalUserlogId = filelogModelImpl._userlogId;

		filelogModelImpl._setOriginalUserlogId = false;

		filelogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Filelog> toCacheModel() {
		FilelogCacheModel filelogCacheModel = new FilelogCacheModel();

		filelogCacheModel.FilelogId = getFilelogId();

		filelogCacheModel.companyId = getCompanyId();

		filelogCacheModel.guest = getGuest();

		filelogCacheModel.userlogId = getUserlogId();

		filelogCacheModel.fileId = getFileId();

		filelogCacheModel.accessDate = getAccessDate();

		filelogCacheModel.elapseLoad = getElapseLoad();

		filelogCacheModel.trafic = getTrafic();

		filelogCacheModel.status = getStatus();

		return filelogCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

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
		StringBundler sb = new StringBundler(31);

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

	private static ClassLoader _classLoader = Filelog.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Filelog.class
		};
	private long _FilelogId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private boolean _guest;
	private boolean _originalGuest;
	private boolean _setOriginalGuest;
	private long _userlogId;
	private long _originalUserlogId;
	private boolean _setOriginalUserlogId;
	private long _fileId;
	private long _accessDate;
	private long _elapseLoad;
	private boolean _trafic;
	private boolean _status;
	private long _columnBitmask;
	private Filelog _escapedModelProxy;
}