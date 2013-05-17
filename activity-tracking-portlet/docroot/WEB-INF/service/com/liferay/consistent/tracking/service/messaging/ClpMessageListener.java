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

package com.liferay.consistent.tracking.service.messaging;

import com.liferay.consistent.tracking.service.BrowserLocalServiceUtil;
import com.liferay.consistent.tracking.service.BrowsinglogLocalServiceUtil;
import com.liferay.consistent.tracking.service.ClpSerializer;
import com.liferay.consistent.tracking.service.FilelogLocalServiceUtil;
import com.liferay.consistent.tracking.service.OSLocalServiceUtil;
import com.liferay.consistent.tracking.service.OrganizationHitLocalServiceUtil;
import com.liferay.consistent.tracking.service.PhraseLocalServiceUtil;
import com.liferay.consistent.tracking.service.PortletHitLocalServiceUtil;
import com.liferay.consistent.tracking.service.PortletPropertyLocalServiceUtil;
import com.liferay.consistent.tracking.service.SearchPhraseHitLocalServiceUtil;
import com.liferay.consistent.tracking.service.SearchWordHitLocalServiceUtil;
import com.liferay.consistent.tracking.service.SiteHitLocalServiceUtil;
import com.liferay.consistent.tracking.service.TrackEventLocalServiceUtil;
import com.liferay.consistent.tracking.service.UserlogLocalServiceUtil;
import com.liferay.consistent.tracking.service.WordLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			BrowserLocalServiceUtil.clearService();

			BrowsinglogLocalServiceUtil.clearService();

			FilelogLocalServiceUtil.clearService();

			OrganizationHitLocalServiceUtil.clearService();

			OSLocalServiceUtil.clearService();

			PhraseLocalServiceUtil.clearService();

			PortletHitLocalServiceUtil.clearService();

			PortletPropertyLocalServiceUtil.clearService();

			SearchPhraseHitLocalServiceUtil.clearService();

			SearchWordHitLocalServiceUtil.clearService();

			SiteHitLocalServiceUtil.clearService();

			TrackEventLocalServiceUtil.clearService();

			UserlogLocalServiceUtil.clearService();

			WordLocalServiceUtil.clearService();
		}
	}
}