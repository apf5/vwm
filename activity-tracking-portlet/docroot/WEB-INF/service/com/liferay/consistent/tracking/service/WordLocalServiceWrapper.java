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
 * This class is a wrapper for {@link WordLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       WordLocalService
 * @generated
 */
public class WordLocalServiceWrapper implements WordLocalService,
	ServiceWrapper<WordLocalService> {
	public WordLocalServiceWrapper(WordLocalService wordLocalService) {
		_wordLocalService = wordLocalService;
	}

	/**
	* Adds the word to the database. Also notifies the appropriate model listeners.
	*
	* @param word the word
	* @return the word that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word addWord(
		com.liferay.consistent.tracking.model.Word word)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.addWord(word);
	}

	/**
	* Creates a new word with the primary key. Does not add the word to the database.
	*
	* @param wordId the primary key for the new word
	* @return the new word
	*/
	public com.liferay.consistent.tracking.model.Word createWord(long wordId) {
		return _wordLocalService.createWord(wordId);
	}

	/**
	* Deletes the word with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordId the primary key of the word
	* @return the word that was removed
	* @throws PortalException if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word deleteWord(long wordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.deleteWord(wordId);
	}

	/**
	* Deletes the word from the database. Also notifies the appropriate model listeners.
	*
	* @param word the word
	* @return the word that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word deleteWord(
		com.liferay.consistent.tracking.model.Word word)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.deleteWord(word);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wordLocalService.dynamicQuery();
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
		return _wordLocalService.dynamicQuery(dynamicQuery);
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
		return _wordLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _wordLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _wordLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.Word fetchWord(long wordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.fetchWord(wordId);
	}

	/**
	* Returns the word with the primary key.
	*
	* @param wordId the primary key of the word
	* @return the word
	* @throws PortalException if a word with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word getWord(long wordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.getWord(wordId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the words.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of words
	* @param end the upper bound of the range of words (not inclusive)
	* @return the range of words
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.Word> getWords(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.getWords(start, end);
	}

	/**
	* Returns the number of words.
	*
	* @return the number of words
	* @throws SystemException if a system exception occurred
	*/
	public int getWordsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.getWordsCount();
	}

	/**
	* Updates the word in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param word the word
	* @return the word that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word updateWord(
		com.liferay.consistent.tracking.model.Word word)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.updateWord(word);
	}

	/**
	* Updates the word in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param word the word
	* @param merge whether to merge the word with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the word that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.Word updateWord(
		com.liferay.consistent.tracking.model.Word word, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wordLocalService.updateWord(word, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wordLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wordLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wordLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WordLocalService getWrappedWordLocalService() {
		return _wordLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWordLocalService(WordLocalService wordLocalService) {
		_wordLocalService = wordLocalService;
	}

	public WordLocalService getWrappedService() {
		return _wordLocalService;
	}

	public void setWrappedService(WordLocalService wordLocalService) {
		_wordLocalService = wordLocalService;
	}

	private WordLocalService _wordLocalService;
}