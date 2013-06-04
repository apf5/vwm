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
public class OSSoap implements Serializable {
	public static OSSoap toSoapModel(OS model) {
		OSSoap soapModel = new OSSoap();

		soapModel.setOsId(model.getOsId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static OSSoap[] toSoapModels(OS[] models) {
		OSSoap[] soapModels = new OSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OSSoap[][] toSoapModels(OS[][] models) {
		OSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OSSoap[] toSoapModels(List<OS> models) {
		List<OSSoap> soapModels = new ArrayList<OSSoap>(models.size());

		for (OS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OSSoap[soapModels.size()]);
	}

	public OSSoap() {
	}

	public long getPrimaryKey() {
		return _osId;
	}

	public void setPrimaryKey(long pk) {
		setOsId(pk);
	}

	public long getOsId() {
		return _osId;
	}

	public void setOsId(long osId) {
		_osId = osId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _osId;
	private String _name;
}