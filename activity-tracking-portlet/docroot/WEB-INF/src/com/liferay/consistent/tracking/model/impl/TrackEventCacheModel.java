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

import com.liferay.consistent.tracking.model.TrackEvent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing TrackEvent in entity cache.
 *
 * @author Jorge Loayza Soloisolo
 * @see TrackEvent
 * @generated
 */
public class TrackEventCacheModel implements CacheModel<TrackEvent>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{trackEventId=");
		sb.append(trackEventId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", userlogId=");
		sb.append(userlogId);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", message=");
		sb.append(message);
		sb.append(", clientHost=");
		sb.append(clientHost);
		sb.append(", clientAddr=");
		sb.append(clientAddr);
		sb.append(", serverName=");
		sb.append(serverName);
		sb.append(", serverPort=");
		sb.append(serverPort);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append("}");

		return sb.toString();
	}

	public TrackEvent toEntityModel() {
		TrackEventImpl trackEventImpl = new TrackEventImpl();

		trackEventImpl.setTrackEventId(trackEventId);
		trackEventImpl.setCompanyId(companyId);

		if (userName == null) {
			trackEventImpl.setUserName(StringPool.BLANK);
		}
		else {
			trackEventImpl.setUserName(userName);
		}

		trackEventImpl.setCreateDate(createDate);
		trackEventImpl.setUserlogId(userlogId);

		if (eventType == null) {
			trackEventImpl.setEventType(StringPool.BLANK);
		}
		else {
			trackEventImpl.setEventType(eventType);
		}

		if (className == null) {
			trackEventImpl.setClassName(StringPool.BLANK);
		}
		else {
			trackEventImpl.setClassName(className);
		}

		if (classPK == null) {
			trackEventImpl.setClassPK(StringPool.BLANK);
		}
		else {
			trackEventImpl.setClassPK(classPK);
		}

		if (message == null) {
			trackEventImpl.setMessage(StringPool.BLANK);
		}
		else {
			trackEventImpl.setMessage(message);
		}

		if (clientHost == null) {
			trackEventImpl.setClientHost(StringPool.BLANK);
		}
		else {
			trackEventImpl.setClientHost(clientHost);
		}

		if (clientAddr == null) {
			trackEventImpl.setClientAddr(StringPool.BLANK);
		}
		else {
			trackEventImpl.setClientAddr(clientAddr);
		}

		if (serverName == null) {
			trackEventImpl.setServerName(StringPool.BLANK);
		}
		else {
			trackEventImpl.setServerName(serverName);
		}

		trackEventImpl.setServerPort(serverPort);

		if (additionalInfo == null) {
			trackEventImpl.setAdditionalInfo(StringPool.BLANK);
		}
		else {
			trackEventImpl.setAdditionalInfo(additionalInfo);
		}

		trackEventImpl.resetOriginalValues();

		return trackEventImpl;
	}

	public long trackEventId;
	public long companyId;
	public String userName;
	public long createDate;
	public long userlogId;
	public String eventType;
	public String className;
	public String classPK;
	public String message;
	public String clientHost;
	public String clientAddr;
	public String serverName;
	public int serverPort;
	public String additionalInfo;
}