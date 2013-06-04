package com.liferay.consistent.tracking.hook.model.listener;

import com.liferay.consistent.tracking.service.FilelogLocalServiceUtil;
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

import java.util.Date;

public class DLFileEntryListener extends BaseModelListener<DLFileEntry>{
	
	private long startTime=0;
	private Date access;
	
	@Override
	public void onBeforeCreate(DLFileEntry model) throws ModelListenerException {
		access = new Date();
		startTime = System.currentTimeMillis();	
	}
	
	@Override
	public void onAfterCreate(DLFileEntry model) throws ModelListenerException {
		
		long elapseTime = System.currentTimeMillis() - startTime;
				
		try {
			User user = UserLocalServiceUtil.fetchUserById(model.getUserId());
			FilelogLocalServiceUtil.addFilelogUpload(model.getCompanyId(), 
					model.getFileEntryId(), 
					model.getFileVersion().getVersion(),user.getDefaultUser(), 
					user.getUserId(),
					elapseTime, access);
		} catch (SystemException e) {
			_log.error("Unable to save filelog to upload documents " + e);
		} catch (PortalException e) {
			_log.error("Unable to save filelog to upload documents " + e);
		}
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(DLFileEntryListener.class);
		
}
