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

import com.liferay.consistent.tracking.service.PortletPropertyLocalServiceUtil;
import com.liferay.consistent.tracking.service.base.TrackingLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the tracking local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.TrackingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.TrackingLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.TrackingLocalServiceUtil
 */
public class TrackingLocalServiceImpl extends TrackingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.TrackingLocalServiceUtil} to access the tracking local service.
	 */
	
	public String setUser(String  user, String email){
		
		try {
			PortletPropertyLocalServiceUtil.setProperty(1, user	, email);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User email: "+user);
		System.out.println("User name: "+email);
		return email;
	}
}