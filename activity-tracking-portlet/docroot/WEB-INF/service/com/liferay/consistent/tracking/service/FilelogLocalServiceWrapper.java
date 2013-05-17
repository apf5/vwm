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
 * This class is a wrapper for {@link FilelogLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       FilelogLocalService
 * @generated
 */
public class FilelogLocalServiceWrapper implements FilelogLocalService,
	ServiceWrapper<FilelogLocalService> {
	public FilelogLocalServiceWrapper(FilelogLocalService filelogLocalService) {
		_filelogLocalService = filelogLocalService;
	}

	/**
	* Adds the filelog to the database. Also notifies the appropriate model listeners.
	*
	* @param filelog the filelog
	* @return the filelog that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog addFilelog(
		com.liferay.consistent.tracking.model.Filelog filelog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.addFilelog(filelog);
	}

	/**
	* Creates a new filelog with the primary key. Does not add the filelog to the database.
	*
	* @param FilelogId the primary key for the new filelog
	* @return the new filelog
	*/
	public com.liferay.consistent.tracking.model.Filelog createFilelog(
		long FilelogId) {
		return _filelogLocalService.createFilelog(FilelogId);
	}

	/**
	* Deletes the filelog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog that was removed
	* @throws PortalException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog deleteFilelog(
		long FilelogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.deleteFilelog(FilelogId);
	}

	/**
	* Deletes the filelog from the database. Also notifies the appropriate model listeners.
	*
	* @param filelog the filelog
	* @return the filelog that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog deleteFilelog(
		com.liferay.consistent.tracking.model.Filelog filelog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.deleteFilelog(filelog);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _filelogLocalService.dynamicQuery();
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
		return _filelogLocalService.dynamicQuery(dynamicQuery);
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
		return _filelogLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _filelogLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _filelogLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.Filelog fetchFilelog(
		long FilelogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.fetchFilelog(FilelogId);
	}

	/**
	* Returns the filelog with the primary key.
	*
	* @param FilelogId the primary key of the filelog
	* @return the filelog
	* @throws PortalException if a filelog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog getFilelog(
		long FilelogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.getFilelog(FilelogId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the filelogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of filelogs
	* @param end the upper bound of the range of filelogs (not inclusive)
	* @return the range of filelogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Filelog> getFilelogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.getFilelogs(start, end);
	}

	/**
	* Returns the number of filelogs.
	*
	* @return the number of filelogs
	* @throws SystemException if a system exception occurred
	*/
	public int getFilelogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.getFilelogsCount();
	}

	/**
	* Updates the filelog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param filelog the filelog
	* @return the filelog that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog updateFilelog(
		com.liferay.consistent.tracking.model.Filelog filelog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.updateFilelog(filelog);
	}

	/**
	* Updates the filelog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param filelog the filelog
	* @param merge whether to merge the filelog with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the filelog that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Filelog updateFilelog(
		com.liferay.consistent.tracking.model.Filelog filelog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _filelogLocalService.updateFilelog(filelog, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _filelogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_filelogLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _filelogLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FilelogLocalService getWrappedFilelogLocalService() {
		return _filelogLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFilelogLocalService(
		FilelogLocalService filelogLocalService) {
		_filelogLocalService = filelogLocalService;
	}

	public FilelogLocalService getWrappedService() {
		return _filelogLocalService;
	}

	public void setWrappedService(FilelogLocalService filelogLocalService) {
		_filelogLocalService = filelogLocalService;
	}

	private FilelogLocalService _filelogLocalService;
}