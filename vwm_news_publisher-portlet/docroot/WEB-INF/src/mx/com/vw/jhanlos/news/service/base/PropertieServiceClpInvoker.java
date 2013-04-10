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

package mx.com.vw.jhanlos.news.service.base;

import mx.com.vw.jhanlos.news.service.PropertieServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class PropertieServiceClpInvoker {
	public PropertieServiceClpInvoker() {
		_methodName22 = "getBeanIdentifier";

		_methodParameterTypes22 = new String[] {  };

		_methodName23 = "setBeanIdentifier";

		_methodParameterTypes23 = new String[] { "java.lang.String" };

		_methodName28 = "getInitValues";

		_methodParameterTypes28 = new String[] {  };

		_methodName29 = "getOrganizationsGroups";

		_methodParameterTypes29 = new String[] {  };

		_methodName30 = "getInitValue";

		_methodParameterTypes30 = new String[] { "java.lang.String" };

		_methodName31 = "saveConfig";

		_methodParameterTypes31 = new String[] { "long", "long", "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return PropertieServiceUtil.getBeanIdentifier();
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			PropertieServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return PropertieServiceUtil.getInitValues();
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return PropertieServiceUtil.getOrganizationsGroups();
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return PropertieServiceUtil.getInitValue((java.lang.String)arguments[0]);
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return PropertieServiceUtil.saveConfig(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
}