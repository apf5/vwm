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
public class FilelogSoap implements Serializable {
	public static FilelogSoap toSoapModel(Filelog model) {
		FilelogSoap soapModel = new FilelogSoap();

		soapModel.setFilelogId(model.getFilelogId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGuest(model.getGuest());
		soapModel.setUserlogId(model.getUserlogId());
		soapModel.setFileId(model.getFileId());
		soapModel.setAccessDate(model.getAccessDate());
		soapModel.setElapseLoad(model.getElapseLoad());
		soapModel.setTrafic(model.getTrafic());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static FilelogSoap[] toSoapModels(Filelog[] models) {
		FilelogSoap[] soapModels = new FilelogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FilelogSoap[][] toSoapModels(Filelog[][] models) {
		FilelogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FilelogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FilelogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FilelogSoap[] toSoapModels(List<Filelog> models) {
		List<FilelogSoap> soapModels = new ArrayList<FilelogSoap>(models.size());

		for (Filelog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FilelogSoap[soapModels.size()]);
	}

	public FilelogSoap() {
	}

	public long getPrimaryKey() {
		return _FilelogId;
	}

	public void setPrimaryKey(long pk) {
		setFilelogId(pk);
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

	private long _FilelogId;
	private long _companyId;
	private boolean _guest;
	private long _userlogId;
	private long _fileId;
	private long _accessDate;
	private long _elapseLoad;
	private boolean _trafic;
	private boolean _status;
}