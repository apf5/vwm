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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppHelperLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;

import java.io.File;
import java.util.List;

import mx.com.vw.jhanlos.ads.model.Mailbox;
import mx.com.vw.jhanlos.ads.model.Propertie;

import mx.com.vw.jhanlos.ads.service.MailboxLocalServiceUtil;
import mx.com.vw.jhanlos.ads.service.PropertieLocalServiceUtil;
import mx.com.vw.jhanlos.ads.service.base.MailboxServiceBaseImpl;

import mx.com.vw.jhanlos.ads.service.persistence.MailboxUtil;
import mx.com.vw.jhanlos.ads.util.AdsUtil;
import mx.com.vw.jhanlos.ads.util.PortletKeys;


/**
 * The implementation of the mailbox remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link mx.com.vw.jhanlos.ads.service.MailboxService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jorge Loayza
 * @see mx.com.vw.jhanlos.ads.service.base.MailboxServiceBaseImpl
 * @see mx.com.vw.jhanlos.ads.service.MailboxServiceUtil
 */
public class MailboxServiceImpl extends MailboxServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link mx.com.vw.jhanlos.ads.service.MailboxServiceUtil} to access the mailbox remote service.
	 */
	
	public List<Mailbox> getMailboxes() throws PortalException, SystemException {
		
		return MailboxLocalServiceUtil.getMailboxs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public Mailbox addMailbox(String name,long imageId,String mailboxAdmins)  throws PortalException, SystemException {
		Mailbox rpt = MailboxUtil.create(counterLocalService.increment());
		rpt.setName(name);
		MailboxUtil.update(rpt, false);
		return rpt;
	}
	
	
	public String addMailboxIcon(File imgIcon)  throws PortalException, SystemException {
		
		//ServletResponseUtil.sendFile(request, response, fileName, inputStream, contentLength, contentType);
		///documents/<%= folder.getRepositoryId() %>/<%=file.getFolderId() %>/<%= file.getTitle()
		
		
		String mimeType = MimeTypesUtil.getContentType(imgIcon);
		String sourceFileName = imgIcon.getName(); 
		ServiceContext serviceContext = new ServiceContext();
		
		User user = getUser(); 
		Propertie porganization = PropertieLocalServiceUtil
				.getValue(PortletKeys.CURRENT_GROUP,user.getOrganizationIds()[0]);
		
		Organization organization = OrganizationLocalServiceUtil.getOrganization(
				Long.valueOf(porganization.getValue()));
		
		serviceContext.setScopeGroupId(organization.getGroupId());
		
		long repositoryId = DLFolderConstants
				.getDataRepositoryId(organization.getGroupId(), 
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		long folderId = DLFolderConstants.getFolderId(organization.getGroupId(),
				repositoryId);
		
		DLFolder folder = DLFolderLocalServiceUtil.getDLFolder(folderId); 
		
		FileEntry fEntry = DLAppLocalServiceUtil.addFileEntry(user.getUserId(), 
				repositoryId,folderId, sourceFileName, 
						mimeType, "icon", "icon", 
						"1.0", imgIcon, serviceContext);
		
		
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("imageId", fEntry.getFileEntryId());
		jsonObject.put("imageURL", AdsUtil.createURL(fEntry,folder));
		return jsonObject.toString();
		
	}
	
}
