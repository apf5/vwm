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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Jorge Loayza Soloisolo
 * @generated
 */
public class BrowsinglogSoap implements Serializable {
	public static BrowsinglogSoap toSoapModel(Browsinglog model) {
		BrowsinglogSoap soapModel = new BrowsinglogSoap();

		soapModel.setBrowsinglogId(model.getBrowsinglogId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserlogId(model.getUserlogId());
		soapModel.setUserAgent(model.getUserAgent());
		soapModel.setUrl(model.getUrl());
		soapModel.setPlId(model.getPlId());
		soapModel.setAccessName(model.getAccessName());
		soapModel.setAccessFound(model.getAccessFound());
		soapModel.setAccessDate(model.getAccessDate());
		soapModel.setElapseLoad(model.getElapseLoad());
		soapModel.setUploadSize(model.getUploadSize());
		soapModel.setDownloadSize(model.getDownloadSize());

		return soapModel;
	}

	public static BrowsinglogSoap[] toSoapModels(Browsinglog[] models) {
		BrowsinglogSoap[] soapModels = new BrowsinglogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BrowsinglogSoap[][] toSoapModels(Browsinglog[][] models) {
		BrowsinglogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BrowsinglogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BrowsinglogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BrowsinglogSoap[] toSoapModels(List<Browsinglog> models) {
		List<BrowsinglogSoap> soapModels = new ArrayList<BrowsinglogSoap>(models.size());

		for (Browsinglog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BrowsinglogSoap[soapModels.size()]);
	}

	public BrowsinglogSoap() {
	}

	public long getPrimaryKey() {
		return _browsinglogId;
	}

	public void setPrimaryKey(long pk) {
		setBrowsinglogId(pk);
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
		_companyId = companyId;
	}

	public long getUserlogId() {
		return _userlogId;
	}

	public void setUserlogId(long userlogId) {
		_userlogId = userlogId;
	}

	public String getUserAgent() {
		return _userAgent;
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	public String getUrl() {
		return _url;
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
		return _accessName;
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

	private long _browsinglogId;
	private long _companyId;
	private long _userlogId;
	private String _userAgent;
	private String _url;
	private long _plId;
	private String _accessName;
	private boolean _accessFound;
	private long _accessDate;
	private long _elapseLoad;
	private long _uploadSize;
	private long _downloadSize;
}