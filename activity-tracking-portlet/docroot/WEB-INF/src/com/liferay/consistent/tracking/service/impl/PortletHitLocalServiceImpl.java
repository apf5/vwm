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

import com.liferay.consistent.tracking.model.PortletHit;
import com.liferay.consistent.tracking.service.base.PortletHitLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

/**
 * The implementation of the portlet hit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.PortletHitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.PortletHitLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.PortletHitLocalServiceUtil
 */
public class PortletHitLocalServiceImpl extends PortletHitLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.PortletHitLocalServiceUtil} to access the portlet hit local service.
	 */
	
	public PortletHit addPortletHit(long companyId,String portletId, boolean guest, long userId, long userlogId, Date access) throws SystemException{
		
		PortletHit portletHit = 
				portletHitPersistence.create(
						counterLocalService.increment(
								PortletHit.class.getName()));
		
		portletHit.setCompanyId(companyId);
		portletHit.setPortletId(portletId);
		portletHit.setGuest(guest);
		if (guest) {
			portletHit.setUserId(-1);
			portletHit.setUserlogId(-1);
			
		} else {
			portletHit.setUserId(userId);
			portletHit.setUserlogId(userlogId);
		}
		portletHit.setAccessDate(access.getTime());
				
		return portletHitPersistence.update(portletHit, false);
	}
	
}