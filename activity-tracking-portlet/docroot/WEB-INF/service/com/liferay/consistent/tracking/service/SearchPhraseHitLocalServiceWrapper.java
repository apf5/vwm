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
 * This class is a wrapper for {@link SearchPhraseHitLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       SearchPhraseHitLocalService
 * @generated
 */
public class SearchPhraseHitLocalServiceWrapper
	implements SearchPhraseHitLocalService,
		ServiceWrapper<SearchPhraseHitLocalService> {
	public SearchPhraseHitLocalServiceWrapper(
		SearchPhraseHitLocalService searchPhraseHitLocalService) {
		_searchPhraseHitLocalService = searchPhraseHitLocalService;
	}

	/**
	* Adds the search phrase hit to the database. Also notifies the appropriate model listeners.
	*
	* @param searchPhraseHit the search phrase hit
	* @return the search phrase hit that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit addSearchPhraseHit(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.addSearchPhraseHit(searchPhraseHit);
	}

	/**
	* Creates a new search phrase hit with the primary key. Does not add the search phrase hit to the database.
	*
	* @param hitId the primary key for the new search phrase hit
	* @return the new search phrase hit
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit createSearchPhraseHit(
		long hitId) {
		return _searchPhraseHitLocalService.createSearchPhraseHit(hitId);
	}

	/**
	* Deletes the search phrase hit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit that was removed
	* @throws PortalException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit deleteSearchPhraseHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.deleteSearchPhraseHit(hitId);
	}

	/**
	* Deletes the search phrase hit from the database. Also notifies the appropriate model listeners.
	*
	* @param searchPhraseHit the search phrase hit
	* @return the search phrase hit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit deleteSearchPhraseHit(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.deleteSearchPhraseHit(searchPhraseHit);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _searchPhraseHitLocalService.dynamicQuery();
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
		return _searchPhraseHitLocalService.dynamicQuery(dynamicQuery);
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
		return _searchPhraseHitLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _searchPhraseHitLocalService.dynamicQuery(dynamicQuery, start,
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
		return _searchPhraseHitLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.SearchPhraseHit fetchSearchPhraseHit(
		long hitId) throws com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.fetchSearchPhraseHit(hitId);
	}

	/**
	* Returns the search phrase hit with the primary key.
	*
	* @param hitId the primary key of the search phrase hit
	* @return the search phrase hit
	* @throws PortalException if a search phrase hit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit getSearchPhraseHit(
		long hitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.getSearchPhraseHit(hitId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the search phrase hits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of search phrase hits
	* @param end the upper bound of the range of search phrase hits (not inclusive)
	* @return the range of search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.SearchPhraseHit> getSearchPhraseHits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.getSearchPhraseHits(start, end);
	}

	/**
	* Returns the number of search phrase hits.
	*
	* @return the number of search phrase hits
	* @throws SystemException if a system exception occurred
	*/
	public int getSearchPhraseHitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.getSearchPhraseHitsCount();
	}

	/**
	* Updates the search phrase hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchPhraseHit the search phrase hit
	* @return the search phrase hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit updateSearchPhraseHit(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.updateSearchPhraseHit(searchPhraseHit);
	}

	/**
	* Updates the search phrase hit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchPhraseHit the search phrase hit
	* @param merge whether to merge the search phrase hit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the search phrase hit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.SearchPhraseHit updateSearchPhraseHit(
		com.liferay.consistent.tracking.model.SearchPhraseHit searchPhraseHit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchPhraseHitLocalService.updateSearchPhraseHit(searchPhraseHit,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _searchPhraseHitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_searchPhraseHitLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _searchPhraseHitLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SearchPhraseHitLocalService getWrappedSearchPhraseHitLocalService() {
		return _searchPhraseHitLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSearchPhraseHitLocalService(
		SearchPhraseHitLocalService searchPhraseHitLocalService) {
		_searchPhraseHitLocalService = searchPhraseHitLocalService;
	}

	public SearchPhraseHitLocalService getWrappedService() {
		return _searchPhraseHitLocalService;
	}

	public void setWrappedService(
		SearchPhraseHitLocalService searchPhraseHitLocalService) {
		_searchPhraseHitLocalService = searchPhraseHitLocalService;
	}

	private SearchPhraseHitLocalService _searchPhraseHitLocalService;
}