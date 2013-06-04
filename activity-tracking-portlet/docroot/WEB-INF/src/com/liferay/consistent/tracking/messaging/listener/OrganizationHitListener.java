package com.liferay.consistent.tracking.messaging.listener;

import com.liferay.consistent.tracking.service.OrganizationHitLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.Date;

public class OrganizationHitListener implements MessageListener{

	@Override
	public void receive(Message message) throws MessageListenerException {
				
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}
	
	protected void doReceive(Message message)throws Exception {
			
		OrganizationHitLocalServiceUtil.addOrganizationHit(
				message.getLong("companyId"), 
				message.getLong("organizationId"), 
				message.getBoolean("guest"), 
				(Date)message.get("access"));
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(OrganizationHitListener.class);
}