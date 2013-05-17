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

package com.liferay.consistent.tracking.service.impl;

import com.liferay.consistent.tracking.NoSuchPortletPropertyException;
import com.liferay.consistent.tracking.model.PortletProperty;
import com.liferay.consistent.tracking.model.impl.PortletPropertyImpl;
import com.liferay.consistent.tracking.service.base.PortletPropertyLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * The implementation of the portlet property local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.PortletPropertyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.PortletPropertyLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.PortletPropertyLocalServiceUtil
 */
public class PortletPropertyLocalServiceImpl
	extends PortletPropertyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.PortletPropertyLocalServiceUtil} to access the portlet property local service.
	 */
		private PortletProperty addProperty(long companyId,String name, String value)
			throws SystemException {

			PortletProperty property = new PortletPropertyImpl();
			property.setName(name);
			property.setCompanyId(companyId);
			property.setValue(value);
			return addPortletProperty(property);
			//Configuration.setPropertyInTheCache(name,value);
		}

		public Properties getAllProperties() throws SystemException {
			Properties properties = new Properties();

			List<PortletProperty> propertiesFromDatabase = 
					portletPropertyLocalService.getPortletProperties(-1,-1);
				

			for (PortletProperty property: propertiesFromDatabase){
				properties.setProperty(
						property.getName(), property.getValue());
			}

			return properties;
		}
		
		public Properties getPropertiesByCompany(long companyId) throws SystemException {
			Properties properties = new Properties();

			List<PortletProperty> propertiesFromDatabase = 
					portletPropertyPersistence.findByCompanyId(companyId);
				
			for (PortletProperty property: propertiesFromDatabase){
				properties.setProperty(
						property.getName(), property.getValue());
			}

			return properties;
		}

		public void updateAllProperties(long companyId, HashMap<String,String> properties)
			throws SystemException {

			Set<Map.Entry<String,String>> entries = properties.entrySet();
			for (Map.Entry<String,String> entry : entries) {
				String name = entry.getKey();
				String value = entry.getValue();
				try {
					PortletProperty property = portletPropertyPersistence.findByName(companyId, name);
					property.setValue(value);
					updatePortletProperty(property);
				}
				catch (NoSuchPortletPropertyException e) {
					addProperty(companyId,name,value);
				}
				//Configuration.setPropertyInTheCache(name,value);
			}
		}

		public PortletProperty setProperty(long companyId,String name, String value)
			throws SystemException{

			PortletProperty property=null;
			try {
				property = portletPropertyPersistence.findByName(companyId,name);
				property.setValue(value);
				updatePortletProperty(property);
			} catch (NoSuchPortletPropertyException e) {
				property = addProperty(companyId,name,value);
			}
			
			return property;
			//Configuration.setPropertyInTheCache(name,value);
		}
}