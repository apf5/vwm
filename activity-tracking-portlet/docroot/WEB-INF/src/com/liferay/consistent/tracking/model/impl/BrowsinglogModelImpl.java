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
import com.liferay.consistent.tracking.model.BrowsinglogModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
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
 * The base model implementation for the Browsinglog service. Represents a row in the &quot;CONSIS_TRACK_Browsinglog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.consistent.tracking.model.BrowsinglogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BrowsinglogImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see BrowsinglogImpl
 * @see com.liferay.consistent.tracking.model.Browsinglog
 * @see com.liferay.consistent.tracking.model.BrowsinglogModel
 * @generated
 */
public class BrowsinglogModelImpl extends BaseModelImpl<Browsinglog>
	implements BrowsinglogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a browsinglog model instance should use the {@link com.liferay.consistent.tracking.model.Browsinglog} interface instead.
	 */
	public static final String TABLE_NAME = "CONSIS_TRACK_Browsinglog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "browsinglogId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userlogId", Types.BIGINT },
			{ "userAgent", Types.VARCHAR },
			{ "url", Types.VARCHAR },
			{ "plId", Types.BIGINT },
			{ "accessName", Types.VARCHAR },
			{ "accessFound", Types.BOOLEAN },
			{ "accessDate", Types.BIGINT },
			{ "elapseLoad", Types.BIGINT },
			{ "uploadSize", Types.BIGINT },
			{ "downloadSize", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table CONSIS_TRACK_Browsinglog (browsinglogId LONG not null primary key,companyId LONG,userlogId LONG,userAgent VARCHAR(75) null,url VARCHAR(75) null,plId LONG,accessName VARCHAR(75) null,accessFound BOOLEAN,accessDate LONG,elapseLoad LONG,uploadSize LONG,downloadSize LONG)";
	public static final String TABLE_SQL_DROP = "drop table CONSIS_TRACK_Browsinglog";
	public static final String ORDER_BY_JPQL = " ORDER BY browsinglog.accessDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CONSIS_TRACK_Browsinglog.accessDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.consistent.tracking.model.Browsinglog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.consistent.tracking.model.Browsinglog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.consistent.tracking.model.Browsinglog"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long USERLOGID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.consistent.tracking.model.Browsinglog"));

	public BrowsinglogModelImpl() {
	}

	public long getPrimaryKey() {
		return _browsinglogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBrowsinglogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_browsinglogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Browsinglog.class;
	}

	public String getModelClassName() {
		return Browsinglog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("browsinglogId", getBrowsinglogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userlogId", getUserlogId());
		attributes.put("userAgent", getUserAgent());
		attributes.put("url", getUrl());
		attributes.put("plId", getPlId());
		attributes.put("accessName", getAccessName());
		attributes.put("accessFound", getAccessFound());
		attributes.put("accessDate", getAccessDate());
		attributes.put("elapseLoad", getElapseLoad());
		attributes.put("uploadSize", getUploadSize());
		attributes.put("downloadSize", getDownloadSize());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long browsinglogId = (Long)attributes.get("browsinglogId");

		if (browsinglogId != null) {
			setBrowsinglogId(browsinglogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userlogId = (Long)attributes.get("userlogId");

		if (userlogId != null) {
			setUserlogId(userlogId);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long plId = (Long)attributes.get("plId");

		if (plId != null) {
			setPlId(plId);
		}

		String accessName = (String)attributes.get("accessName");

		if (accessName != null) {
			setAccessName(accessName);
		}

		Boolean accessFound = (Boolean)attributes.get("accessFound");

		if (accessFound != null) {
			setAccessFound(accessFound);
		}

		Long accessDate = (Long)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}

		Long elapseLoad = (Long)attributes.get("elapseLoad");

		if (elapseLoad != null) {
			setElapseLoad(elapseLoad);
		}

		Long uploadSize = (Long)attributes.get("uploadSize");

		if (uploadSize != null) {
			setUploadSize(uploadSize);
		}

		Long downloadSize = (Long)attributes.get("downloadSize");

		if (downloadSize != null) {
			setDownloadSize(downloadSize);
		}
	}

	public long getBrowsinglogId() {
		return _browsinglogId;
	}

	public void setBrowsinglogId(long browsinglogId) {
		_browsinglogId = browsinglogId;
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

	public String getUserAgent() {
		if (_userAgent == null) {
			return StringPool.BLANK;
		}
		else {
			return _userAgent;
		}
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	public void setUrl(String url) {
		_url = url;
	}

	public long getPlId() {
		return _plId;
	}

	public void setPlId(long plId) {
		_plId = plId;
	}

	public String getAccessName() {
		if (_accessName == null) {
			return StringPool.BLANK;
		}
		else {
			return _accessName;
		}
	}

	public void setAccessName(String accessName) {
		_accessName = accessName;
	}

	public boolean getAccessFound() {
		return _accessFound;
	}

	public boolean isAccessFound() {
		return _accessFound;
	}

	public void setAccessFound(boolean accessFound) {
		_accessFound = accessFound;
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

	public long getUploadSize() {
		return _uploadSize;
	}

	public void setUploadSize(long uploadSize) {
		_uploadSize = uploadSize;
	}

	public long getDownloadSize() {
		return _downloadSize;
	}

	public void setDownloadSize(long downloadSize) {
		_downloadSize = downloadSize;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Browsinglog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Browsinglog toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Browsinglog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		BrowsinglogImpl browsinglogImpl = new BrowsinglogImpl();

		browsinglogImpl.setBrowsinglogId(getBrowsinglogId());
		browsinglogImpl.setCompanyId(getCompanyId());
		browsinglogImpl.setUserlogId(getUserlogId());
		browsinglogImpl.setUserAgent(getUserAgent());
		browsinglogImpl.setUrl(getUrl());
		browsinglogImpl.setPlId(getPlId());
		browsinglogImpl.setAccessName(getAccessName());
		browsinglogImpl.setAccessFound(getAccessFound());
		browsinglogImpl.setAccessDate(getAccessDate());
		browsinglogImpl.setElapseLoad(getElapseLoad());
		browsinglogImpl.setUploadSize(getUploadSize());
		browsinglogImpl.setDownloadSize(getDownloadSize());

		browsinglogImpl.resetOriginalValues();

		return browsinglogImpl;
	}

	public int compareTo(Browsinglog browsinglog) {
		int value = 0;

		if (getAccessDate() < browsinglog.getAccessDate()) {
			value = -1;
		}
		else if (getAccessDate() > browsinglog.getAccessDate()) {
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

		Browsinglog browsinglog = null;

		try {
			browsinglog = (Browsinglog)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = browsinglog.getPrimaryKey();

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
		BrowsinglogModelImpl browsinglogModelImpl = this;

		browsinglogModelImpl._originalCompanyId = browsinglogModelImpl._companyId;

		browsinglogModelImpl._setOriginalCompanyId = false;

		browsinglogModelImpl._originalUserlogId = browsinglogModelImpl._userlogId;

		browsinglogModelImpl._setOriginalUserlogId = false;

		browsinglogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Browsinglog> toCacheModel() {
		BrowsinglogCacheModel browsinglogCacheModel = new BrowsinglogCacheModel();

		browsinglogCacheModel.browsinglogId = getBrowsinglogId();

		browsinglogCacheModel.companyId = getCompanyId();

		browsinglogCacheModel.userlogId = getUserlogId();

		browsinglogCacheModel.userAgent = getUserAgent();

		String userAgent = browsinglogCacheModel.userAgent;

		if ((userAgent != null) && (userAgent.length() == 0)) {
			browsinglogCacheModel.userAgent = null;
		}

		browsinglogCacheModel.url = getUrl();

		String url = browsinglogCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			browsinglogCacheModel.url = null;
		}

		browsinglogCacheModel.plId = getPlId();

		browsinglogCacheModel.accessName = getAccessName();

		String accessName = browsinglogCacheModel.accessName;

		if ((accessName != null) && (accessName.length() == 0)) {
			browsinglogCacheModel.accessName = null;
		}

		browsinglogCacheModel.accessFound = getAccessFound();

		browsinglogCacheModel.accessDate = getAccessDate();

		browsinglogCacheModel.elapseLoad = getElapseLoad();

		browsinglogCacheModel.uploadSize = getUploadSize();

		browsinglogCacheModel.downloadSize = getDownloadSize();

		return browsinglogCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{browsinglogId=");
		sb.append(getBrowsinglogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userlogId=");
		sb.append(getUserlogId());
		sb.append(", userAgent=");
		sb.append(getUserAgent());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", plId=");
		sb.append(getPlId());
		sb.append(", accessName=");
		sb.append(getAccessName());
		sb.append(", accessFound=");
		sb.append(getAccessFound());
		sb.append(", accessDate=");
		sb.append(getAccessDate());
		sb.append(", elapseLoad=");
		sb.append(getElapseLoad());
		sb.append(", uploadSize=");
		sb.append(getUploadSize());
		sb.append(", downloadSize=");
		sb.append(getDownloadSize());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consistent.tracking.model.Browsinglog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>browsinglogId</column-name><column-value><![CDATA[");
		sb.append(getBrowsinglogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userlogId</column-name><column-value><![CDATA[");
		sb.append(getUserlogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userAgent</column-name><column-value><![CDATA[");
		sb.append(getUserAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plId</column-name><column-value><![CDATA[");
		sb.append(getPlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessName</column-name><column-value><![CDATA[");
		sb.append(getAccessName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessFound</column-name><column-value><![CDATA[");
		sb.append(getAccessFound());
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
			"<column><column-name>uploadSize</column-name><column-value><![CDATA[");
		sb.append(getUploadSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadSize</column-name><column-value><![CDATA[");
		sb.append(getDownloadSize());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Browsinglog.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Browsinglog.class
		};
	private long _browsinglogId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userlogId;
	private long _originalUserlogId;
	private boolean _setOriginalUserlogId;
	private String _userAgent;
	private String _url;
	private long _plId;
	private String _accessName;
	private boolean _accessFound;
	private long _accessDate;
	private long _elapseLoad;
	private long _uploadSize;
	private long _downloadSize;
	private long _columnBitmask;
	private Browsinglog _escapedModelProxy;
}