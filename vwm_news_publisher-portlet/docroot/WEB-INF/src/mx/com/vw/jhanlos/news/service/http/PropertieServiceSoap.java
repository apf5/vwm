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

package mx.com.vw.jhanlos.news.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import mx.com.vw.jhanlos.news.service.PropertieServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link mx.com.vw.jhanlos.news.service.PropertieServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link mx.com.vw.jhanlos.news.model.PropertieSoap}.
 * If the method in the service utility returns a
 * {@link mx.com.vw.jhanlos.news.model.Propertie}, that is translated to a
 * {@link mx.com.vw.jhanlos.news.model.PropertieSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Jorge Loayza
 * @see       PropertieServiceHttp
 * @see       mx.com.vw.jhanlos.news.model.PropertieSoap
 * @see       mx.com.vw.jhanlos.news.service.PropertieServiceUtil
 * @generated
 */
public class PropertieServiceSoap {
	public static mx.com.vw.jhanlos.news.model.PropertieSoap[] getInitValues()
		throws RemoteException {
		try {
			mx.com.vw.jhanlos.news.model.Propertie[] returnValue = PropertieServiceUtil.getInitValues();

			return mx.com.vw.jhanlos.news.model.PropertieSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getOrganizationsGroups()
		throws RemoteException {
		try {
			java.lang.String returnValue = PropertieServiceUtil.getOrganizationsGroups();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static mx.com.vw.jhanlos.news.model.PropertieSoap getInitValue(
		java.lang.String name) throws RemoteException {
		try {
			mx.com.vw.jhanlos.news.model.Propertie returnValue = PropertieServiceUtil.getInitValue(name);

			return mx.com.vw.jhanlos.news.model.PropertieSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String saveConfig(long organizationId,
		long structureId, long templateIdM, long templateIdO)
		throws RemoteException {
		try {
			java.lang.String returnValue = PropertieServiceUtil.saveConfig(organizationId,
					structureId, templateIdM, templateIdO);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PropertieServiceSoap.class);
}