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

package mx.com.vw.jhanlos.ads.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link mx.com.vw.jhanlos.ads.service.http.PropertieServiceSoap}.
 *
 * @author    Jorge Loayza
 * @see       mx.com.vw.jhanlos.ads.service.http.PropertieServiceSoap
 * @generated
 */
public class PropertieSoap implements Serializable {
	public static PropertieSoap toSoapModel(Propertie model) {
		PropertieSoap soapModel = new PropertieSoap();

		soapModel.setPropertieId(model.getPropertieId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static PropertieSoap[] toSoapModels(Propertie[] models) {
		PropertieSoap[] soapModels = new PropertieSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PropertieSoap[][] toSoapModels(Propertie[][] models) {
		PropertieSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PropertieSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PropertieSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PropertieSoap[] toSoapModels(List<Propertie> models) {
		List<PropertieSoap> soapModels = new ArrayList<PropertieSoap>(models.size());

		for (Propertie model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PropertieSoap[soapModels.size()]);
	}

	public PropertieSoap() {
	}

	public long getPrimaryKey() {
		return _propertieId;
	}

	public void setPrimaryKey(long pk) {
		setPropertieId(pk);
	}

	public long getPropertieId() {
		return _propertieId;
	}

	public void setPropertieId(long propertieId) {
		_propertieId = propertieId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	public long getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _propertieId;
	private long _companyId;
	private long _userId;
	private long _createDate;
	private long _modifiedDate;
	private String _name;
	private String _value;
}