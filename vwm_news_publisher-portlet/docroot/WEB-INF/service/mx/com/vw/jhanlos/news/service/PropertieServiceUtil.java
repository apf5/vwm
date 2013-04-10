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

package mx.com.vw.jhanlos.news.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the propertie remote service. This utility wraps {@link mx.com.vw.jhanlos.news.service.impl.PropertieServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jorge Loayza
 * @see PropertieService
 * @see mx.com.vw.jhanlos.news.service.base.PropertieServiceBaseImpl
 * @see mx.com.vw.jhanlos.news.service.impl.PropertieServiceImpl
 * @generated
 */
public class PropertieServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link mx.com.vw.jhanlos.news.service.impl.PropertieServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static mx.com.vw.jhanlos.news.model.Propertie[] getInitValues() {
		return getService().getInitValues();
	}

	public static java.lang.String getOrganizationsGroups()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizationsGroups();
	}

	public static mx.com.vw.jhanlos.news.model.Propertie getInitValue(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInitValue(name);
	}

	public static java.lang.String saveConfig(long organizationId,
		long structureId, long templateIdM, long templateIdO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .saveConfig(organizationId, structureId, templateIdM,
			templateIdO);
	}

	public static void clearService() {
		_service = null;
	}

	public static PropertieService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PropertieService.class.getName());

			if (invokableService instanceof PropertieService) {
				_service = (PropertieService)invokableService;
			}
			else {
				_service = new PropertieServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(PropertieServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PropertieService service) {
	}

	private static PropertieService _service;
}