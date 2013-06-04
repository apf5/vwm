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

import com.liferay.consistent.tracking.NoSuchUserlogException;
import com.liferay.consistent.tracking.model.Userlog;
import com.liferay.consistent.tracking.service.base.UserlogLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The implementation of the userlog local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.UserlogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.UserlogLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.UserlogLocalServiceUtil
 */
public class UserlogLocalServiceImpl extends UserlogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.UserlogLocalServiceUtil} to access the userlog local service.
	 */
	
	public Userlog addUserlog(
			long companyId, long userId, String userName,
			String serverName, int serverPort,
			String remoteHost, String remoteAddress, 
			long osId, String osManufacturer, 
			long browserId, String browserVersion,
			String sessionId, Date accessDate) throws SystemException{
		
		Userlog userlog = userlogPersistence.create(
				counterLocalService.increment(
						Userlog.class.getName()));
		
		userlog.setCompanyId(companyId);
		userlog.setUserId(userId);
		userlog.setUserName(userName);
		
		userlog.setServerName(serverName);
		userlog.setServerPort(serverPort);
		userlog.setRemoteHost(remoteHost);
		userlog.setRemoteAddress(remoteAddress);
		
		userlog.setOsId(osId);
		userlog.setOsManufacturer(osManufacturer);
		
		userlog.setBrowserId(browserId);
		userlog.setBrowserVersion(browserVersion);
		
		userlog.setSessionId(sessionId);
		userlog.setTimeSlapse(-1);
		userlog.setAccessDate(accessDate.getTime());
				
		return userlogPersistence.update(userlog, false);
		
	}
	
	public  Userlog updateTimeSlapse(long userlogId) throws SystemException{
		
		Date now = new Date();
		
		Userlog userlog = null;
		
		try {
			userlog = userlogPersistence.findByPrimaryKey(userlogId);
			long accessDate = userlog.getAccessDate();
			userlog.setTimeSlapse(now.getTime() - accessDate);
			userlogPersistence.update(userlog, false);
		} catch (NoSuchUserlogException e) {
			Logger.getLogger(UserlogLocalServiceImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		        
		return userlog;
		
	}
}