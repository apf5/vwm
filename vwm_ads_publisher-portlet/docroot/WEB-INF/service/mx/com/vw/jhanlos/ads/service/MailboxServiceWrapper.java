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

package mx.com.vw.jhanlos.ads.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link MailboxService}.
 * </p>
 *
 * @author    Jorge Loayza
 * @see       MailboxService
 * @generated
 */
public class MailboxServiceWrapper implements MailboxService,
	ServiceWrapper<MailboxService> {
	public MailboxServiceWrapper(MailboxService mailboxService) {
		_mailboxService = mailboxService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _mailboxService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_mailboxService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _mailboxService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> getMailboxes()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxService.getMailboxes();
	}

	public mx.com.vw.jhanlos.ads.model.Mailbox addMailbox(
		java.lang.String name, long imageId, java.lang.String mailboxAdmins)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxService.addMailbox(name, imageId, mailboxAdmins);
	}

	public java.lang.String addMailboxIcon(java.io.File imgIcon)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxService.addMailboxIcon(imgIcon);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public MailboxService getWrappedMailboxService() {
		return _mailboxService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedMailboxService(MailboxService mailboxService) {
		_mailboxService = mailboxService;
	}

	public MailboxService getWrappedService() {
		return _mailboxService;
	}

	public void setWrappedService(MailboxService mailboxService) {
		_mailboxService = mailboxService;
	}

	private MailboxService _mailboxService;
}