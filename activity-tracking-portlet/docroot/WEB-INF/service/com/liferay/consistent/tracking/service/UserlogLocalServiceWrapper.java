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
 * This class is a wrapper for {@link UserlogLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       UserlogLocalService
 * @generated
 */
public class UserlogLocalServiceWrapper implements UserlogLocalService,
	ServiceWrapper<UserlogLocalService> {
	public UserlogLocalServiceWrapper(UserlogLocalService userlogLocalService) {
		_userlogLocalService = userlogLocalService;
	}

	/**
	* Adds the userlog to the database. Also notifies the appropriate model listeners.
	*
	* @param userlog the userlog
	* @return the userlog that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog addUserlog(
		com.liferay.consistent.tracking.model.Userlog userlog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.addUserlog(userlog);
	}

	/**
	* Creates a new userlog with the primary key. Does not add the userlog to the database.
	*
	* @param userlogId the primary key for the new userlog
	* @return the new userlog
	*/
	public com.liferay.consistent.tracking.model.Userlog createUserlog(
		long userlogId) {
		return _userlogLocalService.createUserlog(userlogId);
	}

	/**
	* Deletes the userlog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog that was removed
	* @throws PortalException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog deleteUserlog(
		long userlogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.deleteUserlog(userlogId);
	}

	/**
	* Deletes the userlog from the database. Also notifies the appropriate model listeners.
	*
	* @param userlog the userlog
	* @return the userlog that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog deleteUserlog(
		com.liferay.consistent.tracking.model.Userlog userlog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.deleteUserlog(userlog);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userlogLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.Userlog fetchUserlog(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.fetchUserlog(userlogId);
	}

	/**
	* Returns the userlog with the primary key.
	*
	* @param userlogId the primary key of the userlog
	* @return the userlog
	* @throws PortalException if a userlog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog getUserlog(
		long userlogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.getUserlog(userlogId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the userlogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of userlogs
	* @param end the upper bound of the range of userlogs (not inclusive)
	* @return the range of userlogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Userlog> getUserlogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.getUserlogs(start, end);
	}

	/**
	* Returns the number of userlogs.
	*
	* @return the number of userlogs
	* @throws SystemException if a system exception occurred
	*/
	public int getUserlogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.getUserlogsCount();
	}

	/**
	* Updates the userlog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userlog the userlog
	* @return the userlog that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog updateUserlog(
		com.liferay.consistent.tracking.model.Userlog userlog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.updateUserlog(userlog);
	}

	/**
	* Updates the userlog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userlog the userlog
	* @param merge whether to merge the userlog with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the userlog that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Userlog updateUserlog(
		com.liferay.consistent.tracking.model.Userlog userlog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.updateUserlog(userlog, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userlogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userlogLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userlogLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.liferay.consistent.tracking.model.Userlog addUserlog(
		long companyId, long userId, java.lang.String userName,
		java.lang.String serverName, int serverPort,
		java.lang.String remoteHost, java.lang.String remoteAddress, long osId,
		java.lang.String osManufacturer, long browserId,
		java.lang.String browserVersion, java.lang.String sessionId,
		java.util.Date accessDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.addUserlog(companyId, userId, userName,
			serverName, serverPort, remoteHost, remoteAddress, osId,
			osManufacturer, browserId, browserVersion, sessionId, accessDate);
	}

	public com.liferay.consistent.tracking.model.Userlog updateTimeSlapse(
		long userlogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userlogLocalService.updateTimeSlapse(userlogId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserlogLocalService getWrappedUserlogLocalService() {
		return _userlogLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserlogLocalService(
		UserlogLocalService userlogLocalService) {
		_userlogLocalService = userlogLocalService;
	}

	public UserlogLocalService getWrappedService() {
		return _userlogLocalService;
	}

	public void setWrappedService(UserlogLocalService userlogLocalService) {
		_userlogLocalService = userlogLocalService;
	}

	private UserlogLocalService _userlogLocalService;
}