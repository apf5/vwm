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

package com.liferay.consistent.tracking.model.impl;

import com.liferay.consistent.tracking.model.Userlog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Userlog in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see Userlog
 * @generated
 */
public class UserlogCacheModel implements CacheModel<Userlog>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{userlogId=");
		sb.append(userlogId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", serverName=");
		sb.append(serverName);
		sb.append(", serverPort=");
		sb.append(serverPort);
		sb.append(", remoteHost=");
		sb.append(remoteHost);
		sb.append(", remoteAddress=");
		sb.append(remoteAddress);
		sb.append(", osId=");
		sb.append(osId);
		sb.append(", browserId=");
		sb.append(browserId);
		sb.append(", sessionId=");
		sb.append(sessionId);
		sb.append(", accessDate=");
		sb.append(accessDate);
		sb.append(", timeSlapse=");
		sb.append(timeSlapse);
		sb.append("}");

		return sb.toString();
	}

	public Userlog toEntityModel() {
		UserlogImpl userlogImpl = new UserlogImpl();

		userlogImpl.setUserlogId(userlogId);
		userlogImpl.setCompanyId(companyId);
		userlogImpl.setUserId(userId);

		if (userName == null) {
			userlogImpl.setUserName(StringPool.BLANK);
		}
		else {
			userlogImpl.setUserName(userName);
		}

		if (serverName == null) {
			userlogImpl.setServerName(StringPool.BLANK);
		}
		else {
			userlogImpl.setServerName(serverName);
		}

		userlogImpl.setServerPort(serverPort);

		if (remoteHost == null) {
			userlogImpl.setRemoteHost(StringPool.BLANK);
		}
		else {
			userlogImpl.setRemoteHost(remoteHost);
		}

		if (remoteAddress == null) {
			userlogImpl.setRemoteAddress(StringPool.BLANK);
		}
		else {
			userlogImpl.setRemoteAddress(remoteAddress);
		}

		userlogImpl.setOsId(osId);
		userlogImpl.setBrowserId(browserId);

		if (sessionId == null) {
			userlogImpl.setSessionId(StringPool.BLANK);
		}
		else {
			userlogImpl.setSessionId(sessionId);
		}

		userlogImpl.setAccessDate(accessDate);
		userlogImpl.setTimeSlapse(timeSlapse);

		userlogImpl.resetOriginalValues();

		return userlogImpl;
	}

	public long userlogId;
	public long companyId;
	public long userId;
	public String userName;
	public String serverName;
	public int serverPort;
	public String remoteHost;
	public String remoteAddress;
	public long osId;
	public long browserId;
	public String sessionId;
	public long accessDate;
	public long timeSlapse;
}