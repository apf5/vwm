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

package com.liferay.consistent.tracking.service.base;

import com.liferay.consistent.tracking.model.Phrase;
import com.liferay.consistent.tracking.service.BrowserLocalService;
import com.liferay.consistent.tracking.service.BrowsinglogLocalService;
import com.liferay.consistent.tracking.service.FilelogLocalService;
import com.liferay.consistent.tracking.service.OSLocalService;
import com.liferay.consistent.tracking.service.OrganizationHitLocalService;
import com.liferay.consistent.tracking.service.PhraseLocalService;
import com.liferay.consistent.tracking.service.PortletHitLocalService;
import com.liferay.consistent.tracking.service.PortletPropertyLocalService;
import com.liferay.consistent.tracking.service.SearchPhraseHitLocalService;
import com.liferay.consistent.tracking.service.SearchWordHitLocalService;
import com.liferay.consistent.tracking.service.SiteHitLocalService;
import com.liferay.consistent.tracking.service.TrackEventLocalService;
import com.liferay.consistent.tracking.service.TrackingLocalService;
import com.liferay.consistent.tracking.service.TrackingService;
import com.liferay.consistent.tracking.service.UserlogLocalService;
import com.liferay.consistent.tracking.service.WordLocalService;
import com.liferay.consistent.tracking.service.persistence.BrowserPersistence;
import com.liferay.consistent.tracking.service.persistence.BrowsinglogPersistence;
import com.liferay.consistent.tracking.service.persistence.FilelogPersistence;
import com.liferay.consistent.tracking.service.persistence.OSPersistence;
import com.liferay.consistent.tracking.service.persistence.OrganizationHitPersistence;
import com.liferay.consistent.tracking.service.persistence.PhrasePersistence;
import com.liferay.consistent.tracking.service.persistence.PortletHitPersistence;
import com.liferay.consistent.tracking.service.persistence.PortletPropertyPersistence;
import com.liferay.consistent.tracking.service.persistence.SearchPhraseHitPersistence;
import com.liferay.consistent.tracking.service.persistence.SearchWordHitPersistence;
import com.liferay.consistent.tracking.service.persistence.SiteHitPersistence;
import com.liferay.consistent.tracking.service.persistence.TrackEventPersistence;
import com.liferay.consistent.tracking.service.persistence.UserlogPersistence;
import com.liferay.consistent.tracking.service.persistence.WordPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the phrase local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.consistent.tracking.service.impl.PhraseLocalServiceImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.impl.PhraseLocalServiceImpl
 * @see com.liferay.consistent.tracking.service.PhraseLocalServiceUtil
 * @generated
 */
public abstract class PhraseLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements PhraseLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.consistent.tracking.service.PhraseLocalServiceUtil} to access the phrase local service.
	 */

	/**
	 * Adds the phrase to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phrase the phrase
	 * @return the phrase that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Phrase addPhrase(Phrase phrase) throws SystemException {
		phrase.setNew(true);

		return phrasePersistence.update(phrase, false);
	}

	/**
	 * Creates a new phrase with the primary key. Does not add the phrase to the database.
	 *
	 * @param phraseId the primary key for the new phrase
	 * @return the new phrase
	 */
	public Phrase createPhrase(long phraseId) {
		return phrasePersistence.create(phraseId);
	}

	/**
	 * Deletes the phrase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase that was removed
	 * @throws PortalException if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Phrase deletePhrase(long phraseId)
		throws PortalException, SystemException {
		return phrasePersistence.remove(phraseId);
	}

	/**
	 * Deletes the phrase from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phrase the phrase
	 * @return the phrase that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Phrase deletePhrase(Phrase phrase) throws SystemException {
		return phrasePersistence.remove(phrase);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Phrase.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return phrasePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return phrasePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return phrasePersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return phrasePersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Phrase fetchPhrase(long phraseId) throws SystemException {
		return phrasePersistence.fetchByPrimaryKey(phraseId);
	}

	/**
	 * Returns the phrase with the primary key.
	 *
	 * @param phraseId the primary key of the phrase
	 * @return the phrase
	 * @throws PortalException if a phrase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Phrase getPhrase(long phraseId)
		throws PortalException, SystemException {
		return phrasePersistence.findByPrimaryKey(phraseId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return phrasePersistence.findByPrimaryKey(primaryKeyObj);
	}

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
	public List<Phrase> getPhrases(int start, int end)
		throws SystemException {
		return phrasePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of phrases.
	 *
	 * @return the number of phrases
	 * @throws SystemException if a system exception occurred
	 */
	public int getPhrasesCount() throws SystemException {
		return phrasePersistence.countAll();
	}

	/**
	 * Updates the phrase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phrase the phrase
	 * @return the phrase that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Phrase updatePhrase(Phrase phrase) throws SystemException {
		return updatePhrase(phrase, true);
	}

	/**
	 * Updates the phrase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phrase the phrase
	 * @param merge whether to merge the phrase with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the phrase that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Phrase updatePhrase(Phrase phrase, boolean merge)
		throws SystemException {
		phrase.setNew(false);

		return phrasePersistence.update(phrase, merge);
	}

	/**
	 * Returns the browser local service.
	 *
	 * @return the browser local service
	 */
	public BrowserLocalService getBrowserLocalService() {
		return browserLocalService;
	}

	/**
	 * Sets the browser local service.
	 *
	 * @param browserLocalService the browser local service
	 */
	public void setBrowserLocalService(BrowserLocalService browserLocalService) {
		this.browserLocalService = browserLocalService;
	}

	/**
	 * Returns the browser persistence.
	 *
	 * @return the browser persistence
	 */
	public BrowserPersistence getBrowserPersistence() {
		return browserPersistence;
	}

	/**
	 * Sets the browser persistence.
	 *
	 * @param browserPersistence the browser persistence
	 */
	public void setBrowserPersistence(BrowserPersistence browserPersistence) {
		this.browserPersistence = browserPersistence;
	}

	/**
	 * Returns the browsinglog local service.
	 *
	 * @return the browsinglog local service
	 */
	public BrowsinglogLocalService getBrowsinglogLocalService() {
		return browsinglogLocalService;
	}

	/**
	 * Sets the browsinglog local service.
	 *
	 * @param browsinglogLocalService the browsinglog local service
	 */
	public void setBrowsinglogLocalService(
		BrowsinglogLocalService browsinglogLocalService) {
		this.browsinglogLocalService = browsinglogLocalService;
	}

	/**
	 * Returns the browsinglog persistence.
	 *
	 * @return the browsinglog persistence
	 */
	public BrowsinglogPersistence getBrowsinglogPersistence() {
		return browsinglogPersistence;
	}

	/**
	 * Sets the browsinglog persistence.
	 *
	 * @param browsinglogPersistence the browsinglog persistence
	 */
	public void setBrowsinglogPersistence(
		BrowsinglogPersistence browsinglogPersistence) {
		this.browsinglogPersistence = browsinglogPersistence;
	}

	/**
	 * Returns the filelog local service.
	 *
	 * @return the filelog local service
	 */
	public FilelogLocalService getFilelogLocalService() {
		return filelogLocalService;
	}

	/**
	 * Sets the filelog local service.
	 *
	 * @param filelogLocalService the filelog local service
	 */
	public void setFilelogLocalService(FilelogLocalService filelogLocalService) {
		this.filelogLocalService = filelogLocalService;
	}

	/**
	 * Returns the filelog persistence.
	 *
	 * @return the filelog persistence
	 */
	public FilelogPersistence getFilelogPersistence() {
		return filelogPersistence;
	}

	/**
	 * Sets the filelog persistence.
	 *
	 * @param filelogPersistence the filelog persistence
	 */
	public void setFilelogPersistence(FilelogPersistence filelogPersistence) {
		this.filelogPersistence = filelogPersistence;
	}

	/**
	 * Returns the organization hit local service.
	 *
	 * @return the organization hit local service
	 */
	public OrganizationHitLocalService getOrganizationHitLocalService() {
		return organizationHitLocalService;
	}

	/**
	 * Sets the organization hit local service.
	 *
	 * @param organizationHitLocalService the organization hit local service
	 */
	public void setOrganizationHitLocalService(
		OrganizationHitLocalService organizationHitLocalService) {
		this.organizationHitLocalService = organizationHitLocalService;
	}

	/**
	 * Returns the organization hit persistence.
	 *
	 * @return the organization hit persistence
	 */
	public OrganizationHitPersistence getOrganizationHitPersistence() {
		return organizationHitPersistence;
	}

	/**
	 * Sets the organization hit persistence.
	 *
	 * @param organizationHitPersistence the organization hit persistence
	 */
	public void setOrganizationHitPersistence(
		OrganizationHitPersistence organizationHitPersistence) {
		this.organizationHitPersistence = organizationHitPersistence;
	}

	/**
	 * Returns the o s local service.
	 *
	 * @return the o s local service
	 */
	public OSLocalService getOSLocalService() {
		return osLocalService;
	}

	/**
	 * Sets the o s local service.
	 *
	 * @param osLocalService the o s local service
	 */
	public void setOSLocalService(OSLocalService osLocalService) {
		this.osLocalService = osLocalService;
	}

	/**
	 * Returns the o s persistence.
	 *
	 * @return the o s persistence
	 */
	public OSPersistence getOSPersistence() {
		return osPersistence;
	}

	/**
	 * Sets the o s persistence.
	 *
	 * @param osPersistence the o s persistence
	 */
	public void setOSPersistence(OSPersistence osPersistence) {
		this.osPersistence = osPersistence;
	}

	/**
	 * Returns the phrase local service.
	 *
	 * @return the phrase local service
	 */
	public PhraseLocalService getPhraseLocalService() {
		return phraseLocalService;
	}

	/**
	 * Sets the phrase local service.
	 *
	 * @param phraseLocalService the phrase local service
	 */
	public void setPhraseLocalService(PhraseLocalService phraseLocalService) {
		this.phraseLocalService = phraseLocalService;
	}

	/**
	 * Returns the phrase persistence.
	 *
	 * @return the phrase persistence
	 */
	public PhrasePersistence getPhrasePersistence() {
		return phrasePersistence;
	}

	/**
	 * Sets the phrase persistence.
	 *
	 * @param phrasePersistence the phrase persistence
	 */
	public void setPhrasePersistence(PhrasePersistence phrasePersistence) {
		this.phrasePersistence = phrasePersistence;
	}

	/**
	 * Returns the portlet hit local service.
	 *
	 * @return the portlet hit local service
	 */
	public PortletHitLocalService getPortletHitLocalService() {
		return portletHitLocalService;
	}

	/**
	 * Sets the portlet hit local service.
	 *
	 * @param portletHitLocalService the portlet hit local service
	 */
	public void setPortletHitLocalService(
		PortletHitLocalService portletHitLocalService) {
		this.portletHitLocalService = portletHitLocalService;
	}

	/**
	 * Returns the portlet hit persistence.
	 *
	 * @return the portlet hit persistence
	 */
	public PortletHitPersistence getPortletHitPersistence() {
		return portletHitPersistence;
	}

	/**
	 * Sets the portlet hit persistence.
	 *
	 * @param portletHitPersistence the portlet hit persistence
	 */
	public void setPortletHitPersistence(
		PortletHitPersistence portletHitPersistence) {
		this.portletHitPersistence = portletHitPersistence;
	}

	/**
	 * Returns the portlet property local service.
	 *
	 * @return the portlet property local service
	 */
	public PortletPropertyLocalService getPortletPropertyLocalService() {
		return portletPropertyLocalService;
	}

	/**
	 * Sets the portlet property local service.
	 *
	 * @param portletPropertyLocalService the portlet property local service
	 */
	public void setPortletPropertyLocalService(
		PortletPropertyLocalService portletPropertyLocalService) {
		this.portletPropertyLocalService = portletPropertyLocalService;
	}

	/**
	 * Returns the portlet property persistence.
	 *
	 * @return the portlet property persistence
	 */
	public PortletPropertyPersistence getPortletPropertyPersistence() {
		return portletPropertyPersistence;
	}

	/**
	 * Sets the portlet property persistence.
	 *
	 * @param portletPropertyPersistence the portlet property persistence
	 */
	public void setPortletPropertyPersistence(
		PortletPropertyPersistence portletPropertyPersistence) {
		this.portletPropertyPersistence = portletPropertyPersistence;
	}

	/**
	 * Returns the search phrase hit local service.
	 *
	 * @return the search phrase hit local service
	 */
	public SearchPhraseHitLocalService getSearchPhraseHitLocalService() {
		return searchPhraseHitLocalService;
	}

	/**
	 * Sets the search phrase hit local service.
	 *
	 * @param searchPhraseHitLocalService the search phrase hit local service
	 */
	public void setSearchPhraseHitLocalService(
		SearchPhraseHitLocalService searchPhraseHitLocalService) {
		this.searchPhraseHitLocalService = searchPhraseHitLocalService;
	}

	/**
	 * Returns the search phrase hit persistence.
	 *
	 * @return the search phrase hit persistence
	 */
	public SearchPhraseHitPersistence getSearchPhraseHitPersistence() {
		return searchPhraseHitPersistence;
	}

	/**
	 * Sets the search phrase hit persistence.
	 *
	 * @param searchPhraseHitPersistence the search phrase hit persistence
	 */
	public void setSearchPhraseHitPersistence(
		SearchPhraseHitPersistence searchPhraseHitPersistence) {
		this.searchPhraseHitPersistence = searchPhraseHitPersistence;
	}

	/**
	 * Returns the search word hit local service.
	 *
	 * @return the search word hit local service
	 */
	public SearchWordHitLocalService getSearchWordHitLocalService() {
		return searchWordHitLocalService;
	}

	/**
	 * Sets the search word hit local service.
	 *
	 * @param searchWordHitLocalService the search word hit local service
	 */
	public void setSearchWordHitLocalService(
		SearchWordHitLocalService searchWordHitLocalService) {
		this.searchWordHitLocalService = searchWordHitLocalService;
	}

	/**
	 * Returns the search word hit persistence.
	 *
	 * @return the search word hit persistence
	 */
	public SearchWordHitPersistence getSearchWordHitPersistence() {
		return searchWordHitPersistence;
	}

	/**
	 * Sets the search word hit persistence.
	 *
	 * @param searchWordHitPersistence the search word hit persistence
	 */
	public void setSearchWordHitPersistence(
		SearchWordHitPersistence searchWordHitPersistence) {
		this.searchWordHitPersistence = searchWordHitPersistence;
	}

	/**
	 * Returns the site hit local service.
	 *
	 * @return the site hit local service
	 */
	public SiteHitLocalService getSiteHitLocalService() {
		return siteHitLocalService;
	}

	/**
	 * Sets the site hit local service.
	 *
	 * @param siteHitLocalService the site hit local service
	 */
	public void setSiteHitLocalService(SiteHitLocalService siteHitLocalService) {
		this.siteHitLocalService = siteHitLocalService;
	}

	/**
	 * Returns the site hit persistence.
	 *
	 * @return the site hit persistence
	 */
	public SiteHitPersistence getSiteHitPersistence() {
		return siteHitPersistence;
	}

	/**
	 * Sets the site hit persistence.
	 *
	 * @param siteHitPersistence the site hit persistence
	 */
	public void setSiteHitPersistence(SiteHitPersistence siteHitPersistence) {
		this.siteHitPersistence = siteHitPersistence;
	}

	/**
	 * Returns the track event local service.
	 *
	 * @return the track event local service
	 */
	public TrackEventLocalService getTrackEventLocalService() {
		return trackEventLocalService;
	}

	/**
	 * Sets the track event local service.
	 *
	 * @param trackEventLocalService the track event local service
	 */
	public void setTrackEventLocalService(
		TrackEventLocalService trackEventLocalService) {
		this.trackEventLocalService = trackEventLocalService;
	}

	/**
	 * Returns the track event persistence.
	 *
	 * @return the track event persistence
	 */
	public TrackEventPersistence getTrackEventPersistence() {
		return trackEventPersistence;
	}

	/**
	 * Sets the track event persistence.
	 *
	 * @param trackEventPersistence the track event persistence
	 */
	public void setTrackEventPersistence(
		TrackEventPersistence trackEventPersistence) {
		this.trackEventPersistence = trackEventPersistence;
	}

	/**
	 * Returns the tracking local service.
	 *
	 * @return the tracking local service
	 */
	public TrackingLocalService getTrackingLocalService() {
		return trackingLocalService;
	}

	/**
	 * Sets the tracking local service.
	 *
	 * @param trackingLocalService the tracking local service
	 */
	public void setTrackingLocalService(
		TrackingLocalService trackingLocalService) {
		this.trackingLocalService = trackingLocalService;
	}

	/**
	 * Returns the tracking remote service.
	 *
	 * @return the tracking remote service
	 */
	public TrackingService getTrackingService() {
		return trackingService;
	}

	/**
	 * Sets the tracking remote service.
	 *
	 * @param trackingService the tracking remote service
	 */
	public void setTrackingService(TrackingService trackingService) {
		this.trackingService = trackingService;
	}

	/**
	 * Returns the userlog local service.
	 *
	 * @return the userlog local service
	 */
	public UserlogLocalService getUserlogLocalService() {
		return userlogLocalService;
	}

	/**
	 * Sets the userlog local service.
	 *
	 * @param userlogLocalService the userlog local service
	 */
	public void setUserlogLocalService(UserlogLocalService userlogLocalService) {
		this.userlogLocalService = userlogLocalService;
	}

	/**
	 * Returns the userlog persistence.
	 *
	 * @return the userlog persistence
	 */
	public UserlogPersistence getUserlogPersistence() {
		return userlogPersistence;
	}

	/**
	 * Sets the userlog persistence.
	 *
	 * @param userlogPersistence the userlog persistence
	 */
	public void setUserlogPersistence(UserlogPersistence userlogPersistence) {
		this.userlogPersistence = userlogPersistence;
	}

	/**
	 * Returns the word local service.
	 *
	 * @return the word local service
	 */
	public WordLocalService getWordLocalService() {
		return wordLocalService;
	}

	/**
	 * Sets the word local service.
	 *
	 * @param wordLocalService the word local service
	 */
	public void setWordLocalService(WordLocalService wordLocalService) {
		this.wordLocalService = wordLocalService;
	}

	/**
	 * Returns the word persistence.
	 *
	 * @return the word persistence
	 */
	public WordPersistence getWordPersistence() {
		return wordPersistence;
	}

	/**
	 * Sets the word persistence.
	 *
	 * @param wordPersistence the word persistence
	 */
	public void setWordPersistence(WordPersistence wordPersistence) {
		this.wordPersistence = wordPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.consistent.tracking.model.Phrase",
			phraseLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.consistent.tracking.model.Phrase");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Phrase.class;
	}

	protected String getModelClassName() {
		return Phrase.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = phrasePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = BrowserLocalService.class)
	protected BrowserLocalService browserLocalService;
	@BeanReference(type = BrowserPersistence.class)
	protected BrowserPersistence browserPersistence;
	@BeanReference(type = BrowsinglogLocalService.class)
	protected BrowsinglogLocalService browsinglogLocalService;
	@BeanReference(type = BrowsinglogPersistence.class)
	protected BrowsinglogPersistence browsinglogPersistence;
	@BeanReference(type = FilelogLocalService.class)
	protected FilelogLocalService filelogLocalService;
	@BeanReference(type = FilelogPersistence.class)
	protected FilelogPersistence filelogPersistence;
	@BeanReference(type = OrganizationHitLocalService.class)
	protected OrganizationHitLocalService organizationHitLocalService;
	@BeanReference(type = OrganizationHitPersistence.class)
	protected OrganizationHitPersistence organizationHitPersistence;
	@BeanReference(type = OSLocalService.class)
	protected OSLocalService osLocalService;
	@BeanReference(type = OSPersistence.class)
	protected OSPersistence osPersistence;
	@BeanReference(type = PhraseLocalService.class)
	protected PhraseLocalService phraseLocalService;
	@BeanReference(type = PhrasePersistence.class)
	protected PhrasePersistence phrasePersistence;
	@BeanReference(type = PortletHitLocalService.class)
	protected PortletHitLocalService portletHitLocalService;
	@BeanReference(type = PortletHitPersistence.class)
	protected PortletHitPersistence portletHitPersistence;
	@BeanReference(type = PortletPropertyLocalService.class)
	protected PortletPropertyLocalService portletPropertyLocalService;
	@BeanReference(type = PortletPropertyPersistence.class)
	protected PortletPropertyPersistence portletPropertyPersistence;
	@BeanReference(type = SearchPhraseHitLocalService.class)
	protected SearchPhraseHitLocalService searchPhraseHitLocalService;
	@BeanReference(type = SearchPhraseHitPersistence.class)
	protected SearchPhraseHitPersistence searchPhraseHitPersistence;
	@BeanReference(type = SearchWordHitLocalService.class)
	protected SearchWordHitLocalService searchWordHitLocalService;
	@BeanReference(type = SearchWordHitPersistence.class)
	protected SearchWordHitPersistence searchWordHitPersistence;
	@BeanReference(type = SiteHitLocalService.class)
	protected SiteHitLocalService siteHitLocalService;
	@BeanReference(type = SiteHitPersistence.class)
	protected SiteHitPersistence siteHitPersistence;
	@BeanReference(type = TrackEventLocalService.class)
	protected TrackEventLocalService trackEventLocalService;
	@BeanReference(type = TrackEventPersistence.class)
	protected TrackEventPersistence trackEventPersistence;
	@BeanReference(type = TrackingLocalService.class)
	protected TrackingLocalService trackingLocalService;
	@BeanReference(type = TrackingService.class)
	protected TrackingService trackingService;
	@BeanReference(type = UserlogLocalService.class)
	protected UserlogLocalService userlogLocalService;
	@BeanReference(type = UserlogPersistence.class)
	protected UserlogPersistence userlogPersistence;
	@BeanReference(type = WordLocalService.class)
	protected WordLocalService wordLocalService;
	@BeanReference(type = WordPersistence.class)
	protected WordPersistence wordPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private PhraseLocalServiceClpInvoker _clpInvoker = new PhraseLocalServiceClpInvoker();
}