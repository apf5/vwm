
package com.liferay.consistent.tracking.hook.events;


import com.liferay.consistent.tracking.service.UserlogLocalServiceUtil;
import com.liferay.consistent.tracking.util.PortletKeys;
import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

/**
 * @author Jorge Loayza
 */
public class UserlogSessionDestroyAction extends SessionAction {

	@Override
	public void run(HttpSession session) {
		Long userlogId = (Long)session.getAttribute(PortletKeys.USER_LOG_ID);
		if (userlogId!=null) {
			try {
				UserlogLocalServiceUtil.updateTimeSlapse(userlogId);
			} catch (SystemException ex) {
				Logger.getLogger(UserlogSessionDestroyAction.class.getName()).log(Level.SEVERE, null, ex);				
			}
			session.removeAttribute(PortletKeys.USER_LOG_ID);
		}
		
	}

}