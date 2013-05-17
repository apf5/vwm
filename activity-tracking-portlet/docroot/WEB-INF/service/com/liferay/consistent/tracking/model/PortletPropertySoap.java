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
public class PortletPropertySoap implements Serializable {
	public static PortletPropertySoap toSoapModel(PortletProperty model) {
		PortletPropertySoap soapModel = new PortletPropertySoap();

		soapModel.setPropertyId(model.getPropertyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static PortletPropertySoap[] toSoapModels(PortletProperty[] models) {
		PortletPropertySoap[] soapModels = new PortletPropertySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortletPropertySoap[][] toSoapModels(
		PortletProperty[][] models) {
		PortletPropertySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortletPropertySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortletPropertySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortletPropertySoap[] toSoapModels(
		List<PortletProperty> models) {
		List<PortletPropertySoap> soapModels = new ArrayList<PortletPropertySoap>(models.size());

		for (PortletProperty model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortletPropertySoap[soapModels.size()]);
	}

	public PortletPropertySoap() {
	}

	public long getPrimaryKey() {
		return _propertyId;
	}

	public void setPrimaryKey(long pk) {
		setPropertyId(pk);
	}

	public long getPropertyId() {
		return _propertyId;
	}

	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	private long _propertyId;
	private long _companyId;
	private String _name;
	private String _value;
}