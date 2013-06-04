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
 * This class is a wrapper for {@link SearchWordHitLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       SearchWordHitLocalService
 * @generated
 */
public class SearchWordHitLocalServiceWrapper
	implements SearchWordHitLocalService,
		ServiceWrapper<SearchWordHitLocalService> {
	public SearchWordHitLocalServiceWrapper(
		SearchWordHitLocalService searchWordHitLocalService) {
		_searchWordHitLocalService = searchWordHitLocalService;
	}

	/**
	* Adds the search word hit to the database. Also notifies the appropriate model listeners.
	*
	* @param searchWordHit the search word hit
	* @return the search word hit that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchWordHit addSearchWordHit(
		com.liferay.consistent.tracking.model.SearchWordHit searchWordHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.addSearchWordHit(searchWordHit);
	}

	/**
	* Creates a new search word hit with the primary key. Does not add the search word hit to the database.
	*
	* @param hitId the primary key for the new search word hit
	* @return the new search word hit
	*/
	public com.liferay.consistent.tracking.model.SearchWordHit createSearchWordHit(
		long hitId) {
		return _searchWordHitLocalService.createSearchWordHit(hitId);
	}

	/**
	* Deletes the search word hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the search word hit
	* @return the search word hit that was removed
	* @throws PortalException if a search word hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchWordHit deleteSearchWordHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.deleteSearchWordHit(hitId);
	}

	/**
	* Deletes the search word hit from the database. Also notifies the appropriate model listeners.
	*
	* @param searchWordHit the search word hit
	* @return the search word hit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchWordHit deleteSearchWordHit(
		com.liferay.consistent.tracking.model.SearchWordHit searchWordHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.deleteSearchWordHit(searchWordHit);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _searchWordHitLocalService.dynamicQuery();
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
		return _searchWordHitLocalService.dynamicQuery(dynamicQuery);
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
		return _searchWordHitLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _searchWordHitLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _searchWordHitLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.SearchWordHit fetchSearchWordHit(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.fetchSearchWordHit(hitId);
	}

	/**
	* Returns the search word hit with the primary key.
	*
	* @param hitId the primary key of the search word hit
	* @return the search word hit
	* @throws PortalException if a search word hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchWordHit getSearchWordHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.getSearchWordHit(hitId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the search word hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of search word hits
	* @param end the upper bound of the range of search word hits (not inclusive)
	* @return the range of search word hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchWordHit> getSearchWordHits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.getSearchWordHits(start, end);
	}

	/**
	* Returns the number of search word hits.
	*
	* @return the number of search word hits
	* @throws SystemException if a system exception occurred
	*/
	public int getSearchWordHitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.getSearchWordHitsCount();
	}

	/**
	* Updates the search word hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchWordHit the search word hit
	* @return the search word hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchWordHit updateSearchWordHit(
		com.liferay.consistent.tracking.model.SearchWordHit searchWordHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.updateSearchWordHit(searchWordHit);
	}

	/**
	* Updates the search word hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchWordHit the search word hit
	* @param merge whether to merge the search word hit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the search word hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchWordHit updateSearchWordHit(
		com.liferay.consistent.tracking.model.SearchWordHit searchWordHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.updateSearchWordHit(searchWordHit,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _searchWordHitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_searchWordHitLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _searchWordHitLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.liferay.consistent.tracking.model.SearchWordHit addSearchWordHit(
		long companyId, long wordId, boolean guest, java.util.Date access)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchWordHitLocalService.addSearchWordHit(companyId, wordId,
			guest, access);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SearchWordHitLocalService getWrappedSearchWordHitLocalService() {
		return _searchWordHitLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSearchWordHitLocalService(
		SearchWordHitLocalService searchWordHitLocalService) {
		_searchWordHitLocalService = searchWordHitLocalService;
	}

	public SearchWordHitLocalService getWrappedService() {
		return _searchWordHitLocalService;
	}

	public void setWrappedService(
		SearchWordHitLocalService searchWordHitLocalService) {
		_searchWordHitLocalService = searchWordHitLocalService;
	}

	private SearchWordHitLocalService _searchWordHitLocalService;
}