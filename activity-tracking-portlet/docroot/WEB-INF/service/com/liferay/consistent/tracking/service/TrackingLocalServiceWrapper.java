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

package com.liferay.consistent.tracking.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TrackingLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       TrackingLocalService
 * @generated
 */
public class TrackingLocalServiceWrapper implements TrackingLocalService,
	ServiceWrapper<TrackingLocalService> {
	public TrackingLocalServiceWrapper(
		TrackingLocalService trackingLocalService) {
		_trackingLocalService = trackingLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _trackingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trackingLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _trackingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.lang.String setUser(java.lang.String user,
		java.lang.String email) {
		return _trackingLocalService.setUser(user, email);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TrackingLocalService getWrappedTrackingLocalService() {
		return _trackingLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTrackingLocalService(
		TrackingLocalService trackingLocalService) {
		_trackingLocalService = trackingLocalService;
	}

	public TrackingLocalService getWrappedService() {
		return _trackingLocalService;
	}

	public void setWrappedService(TrackingLocalService trackingLocalService) {
		_trackingLocalService = trackingLocalService;
	}

	private TrackingLocalService _trackingLocalService;
}