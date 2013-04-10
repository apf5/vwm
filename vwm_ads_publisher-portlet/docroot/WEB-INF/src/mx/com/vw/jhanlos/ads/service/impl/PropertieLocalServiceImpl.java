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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import mx.com.vw.jhanlos.ads.model.Propertie;
import mx.com.vw.jhanlos.ads.service.PropertieLocalServiceUtil;
import mx.com.vw.jhanlos.ads.service.base.PropertieLocalServiceBaseImpl;
import mx.com.vw.jhanlos.ads.service.persistence.PropertieUtil;


/**
 * The implementation of the propertie local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link mx.com.vw.jhanlos.ads.service.PropertieLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza
 * @see mx.com.vw.jhanlos.ads.service.base.PropertieLocalServiceBaseImpl
 * @see mx.com.vw.jhanlos.ads.service.PropertieLocalServiceUtil
 */
public class PropertieLocalServiceImpl extends PropertieLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link mx.com.vw.jhanlos.ads.service.PropertieLocalServiceUtil} to access the propertie local service.
	 */
	
public Propertie getValue(String name,Object defaultValue)throws SystemException{
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Propertie.class)
				.add(RestrictionsFactoryUtil.eq("name", name));
		
		Propertie rpt=null;
		List<Propertie> properties = PropertieLocalServiceUtil.dynamicQuery(query);
		if (properties.size()<1) {
			long propertieId = counterLocalService.increment();
			rpt = PropertieUtil.create(propertieId);
			rpt.setName(name);
			rpt.setValue(String.valueOf(defaultValue));
			PropertieUtil.update(rpt, false);
		} else {
			rpt = properties.get(0);
		}
		return rpt;
	}
	
	public Propertie setValue(String name,Object value)throws SystemException{
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Propertie.class)
				.add(RestrictionsFactoryUtil.eq("name", name));
		
		Propertie rpt=null;
		List<Propertie> properties = PropertieLocalServiceUtil.dynamicQuery(query);
		if (properties.size()<1) {
			long propertieId = counterLocalService.increment();
			rpt = PropertieUtil.create(propertieId);
			rpt.setName(name);
		} else {
			rpt = properties.get(0);
		}
		rpt.setValue(String.valueOf(value));
		rpt = PropertieUtil.update(rpt, false);
		return rpt;
	}
	
}