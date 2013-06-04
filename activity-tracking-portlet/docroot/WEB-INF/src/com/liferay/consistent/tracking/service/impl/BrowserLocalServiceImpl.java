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

package com.liferay.consistent.tracking.service.impl;

import com.liferay.consistent.tracking.NoSuchBrowserException;
import com.liferay.consistent.tracking.model.Browser;
import com.liferay.consistent.tracking.service.base.BrowserLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the browser local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consistent.tracking.service.BrowserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see com.liferay.consistent.tracking.service.base.BrowserLocalServiceBaseImpl
 * @see com.liferay.consistent.tracking.service.BrowserLocalServiceUtil
 */
public class BrowserLocalServiceImpl extends BrowserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.consistent.tracking.service.BrowserLocalServiceUtil} to access the browser local service.
	 */
	
	public Browser getBrowser(String name)
			throws SystemException{
		Browser browser = null;
		
		try {
			
			browser = browserPersistence.findByName(name);
			
		} catch (NoSuchBrowserException e) {
			browser = browserPersistence.create(counterLocalService.increment(
					Browser.class.getName()));
			browser.setName(name);
			browserPersistence.update(browser, false);
		}
			
		return browser;
	}
}