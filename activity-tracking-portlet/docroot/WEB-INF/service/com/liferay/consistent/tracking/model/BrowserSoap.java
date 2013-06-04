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
public class BrowserSoap implements Serializable {
	public static BrowserSoap toSoapModel(Browser model) {
		BrowserSoap soapModel = new BrowserSoap();

		soapModel.setBrowserId(model.getBrowserId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static BrowserSoap[] toSoapModels(Browser[] models) {
		BrowserSoap[] soapModels = new BrowserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BrowserSoap[][] toSoapModels(Browser[][] models) {
		BrowserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BrowserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BrowserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BrowserSoap[] toSoapModels(List<Browser> models) {
		List<BrowserSoap> soapModels = new ArrayList<BrowserSoap>(models.size());

		for (Browser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BrowserSoap[soapModels.size()]);
	}

	public BrowserSoap() {
	}

	public long getPrimaryKey() {
		return _browserId;
	}

	public void setPrimaryKey(long pk) {
		setBrowserId(pk);
	}

	public long getBrowserId() {
		return _browserId;
	}

	public void setBrowserId(long browserId) {
		_browserId = browserId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _browserId;
	private String _name;
}