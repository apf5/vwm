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

package mx.com.vw.jhanlos.ads.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import mx.com.vw.jhanlos.ads.service.MailboxServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link mx.com.vw.jhanlos.ads.service.MailboxServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link mx.com.vw.jhanlos.ads.model.MailboxSoap}.
 * If the method in the service utility returns a
 * {@link mx.com.vw.jhanlos.ads.model.Mailbox}, that is translated to a
 * {@link mx.com.vw.jhanlos.ads.model.MailboxSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Jorge Loayza
 * @see       MailboxServiceHttp
 * @see       mx.com.vw.jhanlos.ads.model.MailboxSoap
 * @see       mx.com.vw.jhanlos.ads.service.MailboxServiceUtil
 * @generated
 */
public class MailboxServiceSoap {
	public static mx.com.vw.jhanlos.ads.model.MailboxSoap[] getMailboxes()
		throws RemoteException {
		try {
			java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> returnValue = MailboxServiceUtil.getMailboxes();

			return mx.com.vw.jhanlos.ads.model.MailboxSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static mx.com.vw.jhanlos.ads.model.MailboxSoap addMailbox(
		java.lang.String name, long imageId, java.lang.String mailboxAdmins)
		throws RemoteException {
		try {
			mx.com.vw.jhanlos.ads.model.Mailbox returnValue = MailboxServiceUtil.addMailbox(name,
					imageId, mailboxAdmins);

			return mx.com.vw.jhanlos.ads.model.MailboxSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MailboxServiceSoap.class);
}