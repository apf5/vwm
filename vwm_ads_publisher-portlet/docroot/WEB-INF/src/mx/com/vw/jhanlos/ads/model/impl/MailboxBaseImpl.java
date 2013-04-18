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

package mx.com.vw.jhanlos.ads.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import mx.com.vw.jhanlos.ads.model.Mailbox;
import mx.com.vw.jhanlos.ads.service.MailboxLocalServiceUtil;

/**
 * The extended model base implementation for the Mailbox service. Represents a row in the &quot;vwm_ads_Mailbox&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MailboxImpl}.
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxImpl
 * @see mx.com.vw.jhanlos.ads.model.Mailbox
 * @generated
 */
public abstract class MailboxBaseImpl extends MailboxModelImpl
	implements Mailbox {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a mailbox model instance should use the {@link Mailbox} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			MailboxLocalServiceUtil.addMailbox(this);
		}
		else {
			MailboxLocalServiceUtil.updateMailbox(this);
		}
	}
}