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

import com.liferay.consistent.tracking.model.SiteHit;
import com.liferay.consistent.tracking.service.base.SiteHitLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;


import java.util.Date;

/**
 * The implementation of the site hit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.SiteHitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.SiteHitLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.SiteHitLocalServiceUtil
 */
public class SiteHitLocalServiceImpl extends SiteHitLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.SiteHitLocalServiceUtil} to access the site hit local service.
	 */
	
	public SiteHit addSiteHit(long companyId,long siteId,boolean guest,Date access) throws SystemException{
		SiteHit siteHit =
				siteHitPersistence.create(
				counterLocalService.increment(
						SiteHit.class.getName()));
		siteHit.setCompanyId(companyId);
		siteHit.setSiteId(siteId);
		siteHit.setGuest(guest);
		siteHit.setAccessDate(access.getTime());
		
		return siteHitPersistence.update(siteHit, false);
	}
	
}