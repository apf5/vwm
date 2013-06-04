/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.consistent.tracking.hook.events;


import com.liferay.consistent.tracking.model.Browser;
import com.liferay.consistent.tracking.model.OS;
import com.liferay.consistent.tracking.model.Userlog;
import com.liferay.consistent.tracking.service.BrowserLocalServiceUtil;
import com.liferay.consistent.tracking.service.OSLocalServiceUtil;
import com.liferay.consistent.tracking.service.UserlogLocalServiceUtil;
import com.liferay.consistent.tracking.util.PortletKeys;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.bitwalker.useragentutils.UserAgent;

/**
 *  @author Jorge Loayza
 */
public class LoginPostAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
		throws ActionException {

		try {
			doRun(request, response);
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	protected void doRun(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		Date now = new Date();
		HttpSession session = request.getSession();
		User user = PortalUtil.getUser(request);
		Company company = PortalUtil.getCompany(request);
		
		String userAgentString = request.getHeader(HttpHeaders.USER_AGENT);
		UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
		
		OS os = OSLocalServiceUtil.getOS(userAgent.getOperatingSystem().getName());
		Browser browser = BrowserLocalServiceUtil.getBrowser(userAgent.getBrowser().getName());
		
		Userlog userlog = UserlogLocalServiceUtil.addUserlog(
				company.getCompanyId(),
				user.getUserId(), 
				user.getFullName(), 
				request.getServerName(), request.getServerPort(), 
				request.getRemoteHost(), request.getRemoteAddr(), 
				os.getOsId(),userAgent.getOperatingSystem().getManufacturer().getName(), 
				browser.getBrowserId(), userAgent.getBrowser().getVersion(userAgentString).getVersion(), 
				session.getId(), now);
		
		session.setAttribute(PortletKeys.USER_LOG_ID, userlog.getUserlogId());
		
	}

}