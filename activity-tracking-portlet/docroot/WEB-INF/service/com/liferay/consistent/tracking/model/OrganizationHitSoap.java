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
public class OrganizationHitSoap implements Serializable {
	public static OrganizationHitSoap toSoapModel(OrganizationHit model) {
		OrganizationHitSoap soapModel = new OrganizationHitSoap();

		soapModel.setHitId(model.getHitId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setGuest(model.getGuest());
		soapModel.setAccessDate(model.getAccessDate());

		return soapModel;
	}

	public static OrganizationHitSoap[] toSoapModels(OrganizationHit[] models) {
		OrganizationHitSoap[] soapModels = new OrganizationHitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationHitSoap[][] toSoapModels(
		OrganizationHit[][] models) {
		OrganizationHitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationHitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationHitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationHitSoap[] toSoapModels(
		List<OrganizationHit> models) {
		List<OrganizationHitSoap> soapModels = new ArrayList<OrganizationHitSoap>(models.size());

		for (OrganizationHit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationHitSoap[soapModels.size()]);
	}

	public OrganizationHitSoap() {
	}

	public long getPrimaryKey() {
		return _hitId;
	}

	public void setPrimaryKey(long pk) {
		setHitId(pk);
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
		_companyId = companyId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
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

	public long getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(long accessDate) {
		_accessDate = accessDate;
	}

	private long _hitId;
	private long _companyId;
	private long _organizationId;
	private boolean _guest;
	private long _accessDate;
}