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

import com.liferay.consistent.tracking.model.Filelog;
import com.liferay.consistent.tracking.service.base.FilelogLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;


import java.util.Date;

/**
 * The implementation of the filelog local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.FilelogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.FilelogLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.FilelogLocalServiceUtil
 */
public class FilelogLocalServiceImpl extends FilelogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.FilelogLocalServiceUtil} to access the filelog local service.
	 */
	public Filelog addFilelogDownload(long companyId, long fileId,String fileVersion, boolean guest, 
			long userlogId, Date access) throws SystemException{
		Filelog filelog = filelogPersistence.create(
				counterLocalService.increment(
						Filelog.class.getName()));
		
		filelog.setCompanyId(companyId);
		filelog.setFileId(fileId);
		filelog.setFileVersion(fileVersion);
		filelog.setGuest(guest);
		filelog.setTrafic(true);
		filelog.setUserlogId(-1);
		if (!guest) {
			filelog.setUserlogId(userlogId);
		}
		filelog.setStatus(false);
		filelog.setAccessDate(access.getTime());
				
		return filelogPersistence.update(filelog, false);
	}
	
		
	public Filelog updateElapseFilelog(long filelogId,long elapseLoad) throws SystemException{
		
		Filelog filelog = filelogPersistence.fetchByPrimaryKey(filelogId);
		filelog.setElapseLoad(elapseLoad);	
		filelog.setStatus(true);
		return filelogPersistence.update(filelog, false);
	}
	
	public Filelog addFilelogUpload(long companyId, long fileId, String fileVersion, boolean guest, 
			long userlogId, long elapseLoad, Date access) throws SystemException{
		Filelog filelog = filelogPersistence.create(
				counterLocalService.increment(
						Filelog.class.getName()));
		
		filelog.setCompanyId(companyId);
		filelog.setFileId(fileId);
		filelog.setFileVersion(fileVersion);
		filelog.setGuest(guest);
		filelog.setTrafic(false);
		filelog.setUserlogId(-1);
		if (guest) {
			filelog.setUserlogId(userlogId);
		}
		filelog.setStatus(true);
		filelog.setAccessDate(access.getTime());
		filelog.setElapseLoad(elapseLoad);
				
		return filelogPersistence.update(filelog, false);
	}
		
}