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

package mx.com.vw.jhanlos.ads.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

import java.util.List;

import mx.com.vw.jhanlos.ads.model.Propertie;
import mx.com.vw.jhanlos.ads.service.PropertieLocalServiceUtil;
import mx.com.vw.jhanlos.ads.service.base.PropertieServiceBaseImpl;
import mx.com.vw.jhanlos.ads.util.AdsOrganization;
import mx.com.vw.jhanlos.ads.util.PortletKeys;


/**
 * The implementation of the propertie remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link mx.com.vw.jhanlos.ads.service.PropertieService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jorge Loayza
 * @see mx.com.vw.jhanlos.ads.service.base.PropertieServiceBaseImpl
 * @see mx.com.vw.jhanlos.ads.service.PropertieServiceUtil
 */
public class PropertieServiceImpl extends PropertieServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link mx.com.vw.jhanlos.ads.service.PropertieServiceUtil} to access the propertie remote service.
	 */
	
public Propertie[] getInitValues(){
		
		Propertie organization = null;
		Propertie structure = null;
		Propertie template = null;
		
		
		try {
			
			organization = getInitValue(
					PortletKeys.CURRENT_GROUP);
			structure = getInitValue(
					PortletKeys.CURRENT_STRUCTURE);
			template = getInitValue(
					PortletKeys.CURRENT_TEMPLATE);
					
		} catch (SystemException e) {
			e.printStackTrace();
		}
				
		return new Propertie[]{organization,structure,template};
	}
	
	public String getOrganizationsGroups() throws SystemException{
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(-1, -1);
		AdsOrganization nOrganization;
		for (Organization organization : organizations) {
			nOrganization = new AdsOrganization(organization.getName(), organization.getGroupId());
			jsonArray.put(nOrganization.toJSON());
		}
		return jsonArray.toString();
	}
		
	public Propertie getInitValue(String name) throws SystemException{
		
		return PropertieLocalServiceUtil.getValue(name,-1);
	}
	
	
	public String saveConfig(long groupId,long structureId,long templateId) throws SystemException{
		
		/**
		 * GroupLocalServiceUtil
		 * JournalStructureLocalServiceUtil
		 * JournalTemplateLocalServiceUtil
		 * 
		 *
		 * 
		 */
		/**
		try {
			
		} catch (Exception e) {
			throw new SystemException("mensaje");
		}
		if (true) {
			throw new SystemException("mensaje");
		}
		*/
		
		
		PropertieLocalServiceUtil.setValue(PortletKeys.CURRENT_GROUP, groupId);
		PropertieLocalServiceUtil.setValue(PortletKeys.CURRENT_STRUCTURE, structureId);
		PropertieLocalServiceUtil.setValue(PortletKeys.CURRENT_TEMPLATE, templateId);
		
				
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("msg", "Ok");
		return jsonObject.toString();
		
	}
}