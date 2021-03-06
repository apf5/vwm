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

import com.liferay.consistent.tracking.model.SearchWordHit;
import com.liferay.consistent.tracking.model.SearchWordHitModel;

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
 * The base model implementation for the SearchWordHit service. Represents a row in the &quot;CONSIS_TRACK_SearchWordHit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.consistent.tracking.model.SearchWordHitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SearchWordHitImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see SearchWordHitImpl
 * @see com.liferay.consistent.tracking.model.SearchWordHit
 * @see com.liferay.consistent.tracking.model.SearchWordHitModel
 * @generated
 */
public class SearchWordHitModelImpl extends BaseModelImpl<SearchWordHit>
	implements SearchWordHitModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a search word hit model instance should use the {@link com.liferay.consistent.tracking.model.SearchWordHit} interface instead.
	 */
	public static final String TABLE_NAME = "CONSIS_TRACK_SearchWordHit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hitId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "wordId", Types.BIGINT },
			{ "guest", Types.BOOLEAN },
			{ "accessDate", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table CONSIS_TRACK_SearchWordHit (hitId LONG not null primary key,companyId LONG,wordId LONG,guest BOOLEAN,accessDate LONG)";
	public static final String TABLE_SQL_DROP = "drop table CONSIS_TRACK_SearchWordHit";
	public static final String ORDER_BY_JPQL = " ORDER BY searchWordHit.accessDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CONSIS_TRACK_SearchWordHit.accessDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.consistent.tracking.model.SearchWordHit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.consistent.tracking.model.SearchWordHit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.consistent.tracking.model.SearchWordHit"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GUEST_COLUMN_BITMASK = 2L;
	public static long WORDID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.consistent.tracking.model.SearchWordHit"));

	public SearchWordHitModelImpl() {
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
		return SearchWordHit.class;
	}

	public String getModelClassName() {
		return SearchWordHit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hitId", getHitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("wordId", getWordId());
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

		Long wordId = (Long)attributes.get("wordId");

		if (wordId != null) {
			setWordId(wordId);
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

	public long getWordId() {
		return _wordId;
	}

	public void setWordId(long wordId) {
		_columnBitmask |= WORDID_COLUMN_BITMASK;

		if (!_setOriginalWordId) {
			_setOriginalWordId = true;

			_originalWordId = _wordId;
		}

		_wordId = wordId;
	}

	public long getOriginalWordId() {
		return _originalWordId;
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
		_columnBitmask = -1L;

		_accessDate = accessDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SearchWordHit.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SearchWordHit toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (SearchWordHit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		SearchWordHitImpl searchWordHitImpl = new SearchWordHitImpl();

		searchWordHitImpl.setHitId(getHitId());
		searchWordHitImpl.setCompanyId(getCompanyId());
		searchWordHitImpl.setWordId(getWordId());
		searchWordHitImpl.setGuest(getGuest());
		searchWordHitImpl.setAccessDate(getAccessDate());

		searchWordHitImpl.resetOriginalValues();

		return searchWordHitImpl;
	}

	public int compareTo(SearchWordHit searchWordHit) {
		int value = 0;

		if (getAccessDate() < searchWordHit.getAccessDate()) {
			value = -1;
		}
		else if (getAccessDate() > searchWordHit.getAccessDate()) {
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

		SearchWordHit searchWordHit = null;

		try {
			searchWordHit = (SearchWordHit)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = searchWordHit.getPrimaryKey();

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
		SearchWordHitModelImpl searchWordHitModelImpl = this;

		searchWordHitModelImpl._originalCompanyId = searchWordHitModelImpl._companyId;

		searchWordHitModelImpl._setOriginalCompanyId = false;

		searchWordHitModelImpl._originalWordId = searchWordHitModelImpl._wordId;

		searchWordHitModelImpl._setOriginalWordId = false;

		searchWordHitModelImpl._originalGuest = searchWordHitModelImpl._guest;

		searchWordHitModelImpl._setOriginalGuest = false;

		searchWordHitModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SearchWordHit> toCacheModel() {
		SearchWordHitCacheModel searchWordHitCacheModel = new SearchWordHitCacheModel();

		searchWordHitCacheModel.hitId = getHitId();

		searchWordHitCacheModel.companyId = getCompanyId();

		searchWordHitCacheModel.wordId = getWordId();

		searchWordHitCacheModel.guest = getGuest();

		searchWordHitCacheModel.accessDate = getAccessDate();

		return searchWordHitCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{hitId=");
		sb.append(getHitId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", wordId=");
		sb.append(getWordId());
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
		sb.append("com.liferay.consistent.tracking.model.SearchWordHit");
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
			"<column><column-name>wordId</column-name><column-value><![CDATA[");
		sb.append(getWordId());
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

	private static ClassLoader _classLoader = SearchWordHit.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			SearchWordHit.class
		};
	private long _hitId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _wordId;
	private long _originalWordId;
	private boolean _setOriginalWordId;
	private boolean _guest;
	private boolean _originalGuest;
	private boolean _setOriginalGuest;
	private long _accessDate;
	private long _columnBitmask;
	private SearchWordHit _escapedModelProxy;
}