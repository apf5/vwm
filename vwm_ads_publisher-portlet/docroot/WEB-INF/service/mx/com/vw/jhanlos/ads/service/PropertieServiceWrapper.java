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

package mx.com.vw.jhanlos.ads.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PropertieService}.
 * </p>
 *
 * @author    Jorge Loayza
 * @see       PropertieService
 * @generated
 */
public class PropertieServiceWrapper implements PropertieService,
	ServiceWrapper<PropertieService> {
	public PropertieServiceWrapper(PropertieService propertieService) {
		_propertieService = propertieService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _propertieService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_propertieService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _propertieService.invokeMethod(name, parameterTypes, arguments);
	}

	public mx.com.vw.jhanlos.ads.model.Propertie[] getInitValues() {
		return _propertieService.getInitValues();
	}

	public java.lang.String getOrganizationsGroups()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propertieService.getOrganizationsGroups();
	}

	public mx.com.vw.jhanlos.ads.model.Propertie getInitValue(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propertieService.getInitValue(name);
	}

	public java.lang.String saveConfig(long groupId, long structureId,
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propertieService.saveConfig(groupId, structureId, templateId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PropertieService getWrappedPropertieService() {
		return _propertieService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPropertieService(PropertieService propertieService) {
		_propertieService = propertieService;
	}

	public PropertieService getWrappedService() {
		return _propertieService;
	}

	public void setWrappedService(PropertieService propertieService) {
		_propertieService = propertieService;
	}

	private PropertieService _propertieService;
}