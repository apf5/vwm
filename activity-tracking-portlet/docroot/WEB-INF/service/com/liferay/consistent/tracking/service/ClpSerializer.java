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

import com.liferay.consistent.tracking.model.BrowserClp;
import com.liferay.consistent.tracking.model.BrowsinglogClp;
import com.liferay.consistent.tracking.model.FilelogClp;
import com.liferay.consistent.tracking.model.OSClp;
import com.liferay.consistent.tracking.model.OrganizationHitClp;
import com.liferay.consistent.tracking.model.PhraseClp;
import com.liferay.consistent.tracking.model.PortletHitClp;
import com.liferay.consistent.tracking.model.PortletPropertyClp;
import com.liferay.consistent.tracking.model.SearchPhraseHitClp;
import com.liferay.consistent.tracking.model.SearchWordHitClp;
import com.liferay.consistent.tracking.model.SiteHitClp;
import com.liferay.consistent.tracking.model.TrackEventClp;
import com.liferay.consistent.tracking.model.UserlogClp;
import com.liferay.consistent.tracking.model.WordClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"activity-tracking-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"activity-tracking-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "activity-tracking-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BrowserClp.class.getName())) {
			return translateInputBrowser(oldModel);
		}

		if (oldModelClassName.equals(BrowsinglogClp.class.getName())) {
			return translateInputBrowsinglog(oldModel);
		}

		if (oldModelClassName.equals(FilelogClp.class.getName())) {
			return translateInputFilelog(oldModel);
		}

		if (oldModelClassName.equals(OrganizationHitClp.class.getName())) {
			return translateInputOrganizationHit(oldModel);
		}

		if (oldModelClassName.equals(OSClp.class.getName())) {
			return translateInputOS(oldModel);
		}

		if (oldModelClassName.equals(PhraseClp.class.getName())) {
			return translateInputPhrase(oldModel);
		}

		if (oldModelClassName.equals(PortletHitClp.class.getName())) {
			return translateInputPortletHit(oldModel);
		}

		if (oldModelClassName.equals(PortletPropertyClp.class.getName())) {
			return translateInputPortletProperty(oldModel);
		}

		if (oldModelClassName.equals(SearchPhraseHitClp.class.getName())) {
			return translateInputSearchPhraseHit(oldModel);
		}

		if (oldModelClassName.equals(SearchWordHitClp.class.getName())) {
			return translateInputSearchWordHit(oldModel);
		}

		if (oldModelClassName.equals(SiteHitClp.class.getName())) {
			return translateInputSiteHit(oldModel);
		}

		if (oldModelClassName.equals(TrackEventClp.class.getName())) {
			return translateInputTrackEvent(oldModel);
		}

		if (oldModelClassName.equals(UserlogClp.class.getName())) {
			return translateInputUserlog(oldModel);
		}

		if (oldModelClassName.equals(WordClp.class.getName())) {
			return translateInputWord(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputBrowser(BaseModel<?> oldModel) {
		BrowserClp oldClpModel = (BrowserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBrowserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBrowsinglog(BaseModel<?> oldModel) {
		BrowsinglogClp oldClpModel = (BrowsinglogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBrowsinglogRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFilelog(BaseModel<?> oldModel) {
		FilelogClp oldClpModel = (FilelogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFilelogRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganizationHit(BaseModel<?> oldModel) {
		OrganizationHitClp oldClpModel = (OrganizationHitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganizationHitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOS(BaseModel<?> oldModel) {
		OSClp oldClpModel = (OSClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOSRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPhrase(BaseModel<?> oldModel) {
		PhraseClp oldClpModel = (PhraseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPhraseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPortletHit(BaseModel<?> oldModel) {
		PortletHitClp oldClpModel = (PortletHitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortletHitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPortletProperty(BaseModel<?> oldModel) {
		PortletPropertyClp oldClpModel = (PortletPropertyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortletPropertyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSearchPhraseHit(BaseModel<?> oldModel) {
		SearchPhraseHitClp oldClpModel = (SearchPhraseHitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSearchPhraseHitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSearchWordHit(BaseModel<?> oldModel) {
		SearchWordHitClp oldClpModel = (SearchWordHitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSearchWordHitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSiteHit(BaseModel<?> oldModel) {
		SiteHitClp oldClpModel = (SiteHitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSiteHitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTrackEvent(BaseModel<?> oldModel) {
		TrackEventClp oldClpModel = (TrackEventClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTrackEventRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserlog(BaseModel<?> oldModel) {
		UserlogClp oldClpModel = (UserlogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserlogRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWord(BaseModel<?> oldModel) {
		WordClp oldClpModel = (WordClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWordRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.BrowserImpl")) {
			return translateOutputBrowser(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.BrowsinglogImpl")) {
			return translateOutputBrowsinglog(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.FilelogImpl")) {
			return translateOutputFilelog(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.OrganizationHitImpl")) {
			return translateOutputOrganizationHit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.OSImpl")) {
			return translateOutputOS(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.PhraseImpl")) {
			return translateOutputPhrase(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.PortletHitImpl")) {
			return translateOutputPortletHit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.PortletPropertyImpl")) {
			return translateOutputPortletProperty(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.SearchPhraseHitImpl")) {
			return translateOutputSearchPhraseHit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.SearchWordHitImpl")) {
			return translateOutputSearchWordHit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.SiteHitImpl")) {
			return translateOutputSiteHit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.TrackEventImpl")) {
			return translateOutputTrackEvent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.UserlogImpl")) {
			return translateOutputUserlog(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.consistent.tracking.model.impl.WordImpl")) {
			return translateOutputWord(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchBrowserException")) {
			return new com.liferay.consistent.tracking.NoSuchBrowserException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchBrowsinglogException")) {
			return new com.liferay.consistent.tracking.NoSuchBrowsinglogException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchFilelogException")) {
			return new com.liferay.consistent.tracking.NoSuchFilelogException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchOrganizationHitException")) {
			return new com.liferay.consistent.tracking.NoSuchOrganizationHitException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchOSException")) {
			return new com.liferay.consistent.tracking.NoSuchOSException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchPhraseException")) {
			return new com.liferay.consistent.tracking.NoSuchPhraseException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchPortletHitException")) {
			return new com.liferay.consistent.tracking.NoSuchPortletHitException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchPortletPropertyException")) {
			return new com.liferay.consistent.tracking.NoSuchPortletPropertyException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchSearchPhraseHitException")) {
			return new com.liferay.consistent.tracking.NoSuchSearchPhraseHitException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchSearchWordHitException")) {
			return new com.liferay.consistent.tracking.NoSuchSearchWordHitException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchSiteHitException")) {
			return new com.liferay.consistent.tracking.NoSuchSiteHitException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchTrackEventException")) {
			return new com.liferay.consistent.tracking.NoSuchTrackEventException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchUserlogException")) {
			return new com.liferay.consistent.tracking.NoSuchUserlogException();
		}

		if (className.equals(
					"com.liferay.consistent.tracking.NoSuchWordException")) {
			return new com.liferay.consistent.tracking.NoSuchWordException();
		}

		return throwable;
	}

	public static Object translateOutputBrowser(BaseModel<?> oldModel) {
		BrowserClp newModel = new BrowserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBrowserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBrowsinglog(BaseModel<?> oldModel) {
		BrowsinglogClp newModel = new BrowsinglogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBrowsinglogRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFilelog(BaseModel<?> oldModel) {
		FilelogClp newModel = new FilelogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFilelogRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganizationHit(BaseModel<?> oldModel) {
		OrganizationHitClp newModel = new OrganizationHitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganizationHitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOS(BaseModel<?> oldModel) {
		OSClp newModel = new OSClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOSRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPhrase(BaseModel<?> oldModel) {
		PhraseClp newModel = new PhraseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPhraseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPortletHit(BaseModel<?> oldModel) {
		PortletHitClp newModel = new PortletHitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortletHitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPortletProperty(BaseModel<?> oldModel) {
		PortletPropertyClp newModel = new PortletPropertyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortletPropertyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSearchPhraseHit(BaseModel<?> oldModel) {
		SearchPhraseHitClp newModel = new SearchPhraseHitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSearchPhraseHitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSearchWordHit(BaseModel<?> oldModel) {
		SearchWordHitClp newModel = new SearchWordHitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSearchWordHitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSiteHit(BaseModel<?> oldModel) {
		SiteHitClp newModel = new SiteHitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSiteHitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTrackEvent(BaseModel<?> oldModel) {
		TrackEventClp newModel = new TrackEventClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTrackEventRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserlog(BaseModel<?> oldModel) {
		UserlogClp newModel = new UserlogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserlogRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWord(BaseModel<?> oldModel) {
		WordClp newModel = new WordClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWordRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}