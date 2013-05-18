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

import com.liferay.consistent.tracking.model.SiteHit;
import com.liferay.consistent.tracking.model.SiteHitModel;

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
 * The base model implementation for the SiteHit service. Represents a row in the &quot;CONSIS_TRACK_SiteHit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.consistent.tracking.model.SiteHitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SiteHitImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SiteHitImpl
 * @see com.liferay.consistent.tracking.model.SiteHit
 * @see com.liferay.consistent.tracking.model.SiteHitModel
 * @generated
 */
public class SiteHitModelImpl extends BaseModelImpl<SiteHit>
	implements SiteHitModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a site hit model instance should use the {@link com.liferay.consistent.tracking.model.SiteHit} interface instead.
	 */
	public static final String TABLE_NAME = "CONSIS_TRACK_SiteHit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hitId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "siteId", Types.BIGINT },
			{ "guest", Types.BOOLEAN },
			{ "accessDate", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table CONSIS_TRACK_SiteHit (hitId LONG not null primary key,companyId LONG,siteId LONG,guest BOOLEAN,accessDate LONG)";
	public static final String TABLE_SQL_DROP = "drop table CONSIS_TRACK_SiteHit";
	public static final String ORDER_BY_JPQL = " ORDER BY siteHit.siteId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CONSIS_TRACK_SiteHit.siteId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.consistent.tracking.model.SiteHit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.consistent.tracking.model.SiteHit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.consistent.tracking.model.SiteHit"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GUEST_COLUMN_BITMASK = 2L;
	public static long SITEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.consistent.tracking.model.SiteHit"));

	public SiteHitModelImpl() {
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

	public Class<?> getModelClass() {
		return SiteHit.class;
	}

	public String getModelClassName() {
		return SiteHit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("siteId", getSiteId());
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

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
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

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_columnBitmask = -1L;

		if (!_setOriginalSiteId) {
			_setOriginalSiteId = true;

			_originalSiteId = _siteId;
		}

		_siteId = siteId;
	}

	public long getOriginalSiteId() {
		return _originalSiteId;
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

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_accessDate = accessDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SiteHit.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SiteHit toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (SiteHit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		SiteHitImpl siteHitImpl = new SiteHitImpl();

		siteHitImpl.setHitId(getHitId());
		siteHitImpl.setCompanyId(getCompanyId());
		siteHitImpl.setSiteId(getSiteId());
		siteHitImpl.setGuest(getGuest());
		siteHitImpl.setAccessDate(getAccessDate());

		siteHitImpl.resetOriginalValues();

		return siteHitImpl;
	}

	public int compareTo(SiteHit siteHit) {
		int value = 0;

		if (getSiteId() < siteHit.getSiteId()) {
			value = -1;
		}
		else if (getSiteId() > siteHit.getSiteId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		SiteHit siteHit = null;

		try {
			siteHit = (SiteHit)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = siteHit.getPrimaryKey();

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
		SiteHitModelImpl siteHitModelImpl = this;

		siteHitModelImpl._originalCompanyId = siteHitModelImpl._companyId;

		siteHitModelImpl._setOriginalCompanyId = false;

		siteHitModelImpl._originalSiteId = siteHitModelImpl._siteId;

		siteHitModelImpl._setOriginalSiteId = false;

		siteHitModelImpl._originalGuest = siteHitModelImpl._guest;

		siteHitModelImpl._setOriginalGuest = false;

		siteHitModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SiteHit> toCacheModel() {
		SiteHitCacheModel siteHitCacheModel = new SiteHitCacheModel();

		siteHitCacheModel.hitId = getHitId();

		siteHitCacheModel.companyId = getCompanyId();

		siteHitCacheModel.siteId = getSiteId();

		siteHitCacheModel.guest = getGuest();

		siteHitCacheModel.accessDate = getAccessDate();

		return siteHitCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{hitId=");
		sb.append(getHitId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", siteId=");
		sb.append(getSiteId());
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
		sb.append("com.liferay.consistent.tracking.model.SiteHit");
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
			"<column><column-name>siteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
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

	private static ClassLoader _classLoader = SiteHit.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			SiteHit.class
		};
	private long _hitId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _siteId;
	private long _originalSiteId;
	private boolean _setOriginalSiteId;
	private boolean _guest;
	private boolean _originalGuest;
	private boolean _setOriginalGuest;
	private long _accessDate;
	private long _columnBitmask;
	private SiteHit _escapedModelProxy;
}