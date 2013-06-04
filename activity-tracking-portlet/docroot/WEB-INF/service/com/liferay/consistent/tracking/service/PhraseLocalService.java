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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the phrase local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see PhraseLocalServiceUtil
 * @see com.liferay.consistent.tracking.service.base.PhraseLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.impl.PhraseLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PhraseLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhraseLocalServiceUtil} to access the phrase local service. Add custom service methods to {@link com.liferay.consistent.tracking.service.impl.PhraseLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the phrase to the database. Also notifies the appropriate model listeners.
	*
	* @param phrase the phrase
	* @return the phrase that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase addPhrase(
		com.liferay.consistent.tracking.model.Phrase phrase)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new phrase with the primary key. Does not add the phrase to the database.
	*
	* @param phraseId the primary key for the new phrase
	* @return the new phrase
	*/
	public com.liferay.consistent.tracking.model.Phrase createPhrase(
		long phraseId);

	/**
	* Deletes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param phraseId the primary key of the phrase
	* @return the phrase that was removed
	* @throws PortalException if a phrase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase deletePhrase(
		long phraseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the phrase from the database. Also notifies the appropriate model listeners.
	*
	* @param phrase the phrase
	* @return the phrase that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase deletePhrase(
		com.liferay.consistent.tracking.model.Phrase phrase)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.consistent.tracking.model.Phrase fetchPhrase(
		long phraseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phrase with the primary key.
	*
	* @param phraseId the primary key of the phrase
	* @return the phrase
	* @throws PortalException if a phrase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.consistent.tracking.model.Phrase getPhrase(long phraseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the phrases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of phrases
	* @param end the upper bound of the range of phrases (not inclusive)
	* @return the range of phrases
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.consistent.tracking.model.Phrase> getPhrases(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phrases.
	*
	* @return the number of phrases
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPhrasesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the phrase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param phrase the phrase
	* @return the phrase that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase updatePhrase(
		com.liferay.consistent.tracking.model.Phrase phrase)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the phrase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param phrase the phrase
	* @param merge whether to merge the phrase with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the phrase that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Phrase updatePhrase(
		com.liferay.consistent.tracking.model.Phrase phrase, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.consistent.tracking.model.Phrase getPhrase(
		java.lang.String phraseName)
		throws com.liferay.portal.kernel.exception.SystemException;
}