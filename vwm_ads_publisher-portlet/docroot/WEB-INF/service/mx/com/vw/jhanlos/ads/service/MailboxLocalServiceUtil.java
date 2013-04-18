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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the mailbox local service. This utility wraps {@link mx.com.vw.jhanlos.ads.service.impl.MailboxLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jorge Loayza
 * @see MailboxLocalService
 * @see mx.com.vw.jhanlos.ads.service.base.MailboxLocalServiceBaseImpl
 * @see mx.com.vw.jhanlos.ads.service.impl.MailboxLocalServiceImpl
 * @generated
 */
public class MailboxLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link mx.com.vw.jhanlos.ads.service.impl.MailboxLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the mailbox to the database. Also notifies the appropriate model listeners.
	*
	* @param mailbox the mailbox
	* @return the mailbox that was added
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox addMailbox(
		mx.com.vw.jhanlos.ads.model.Mailbox mailbox)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMailbox(mailbox);
	}

	/**
	* Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	*
	* @param mailboxId the primary key for the new mailbox
	* @return the new mailbox
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox createMailbox(
		long mailboxId) {
		return getService().createMailbox(mailboxId);
	}

	/**
	* Deletes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox that was removed
	* @throws PortalException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox deleteMailbox(
		long mailboxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMailbox(mailboxId);
	}

	/**
	* Deletes the mailbox from the database. Also notifies the appropriate model listeners.
	*
	* @param mailbox the mailbox
	* @return the mailbox that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox deleteMailbox(
		mx.com.vw.jhanlos.ads.model.Mailbox mailbox)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMailbox(mailbox);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static mx.com.vw.jhanlos.ads.model.Mailbox fetchMailbox(
		long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMailbox(mailboxId);
	}

	/**
	* Returns the mailbox with the primary key.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox
	* @throws PortalException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox getMailbox(long mailboxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMailbox(mailboxId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the mailboxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of mailboxs
	* @param end the upper bound of the range of mailboxs (not inclusive)
	* @return the range of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<mx.com.vw.jhanlos.ads.model.Mailbox> getMailboxs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMailboxs(start, end);
	}

	/**
	* Returns the number of mailboxs.
	*
	* @return the number of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public static int getMailboxsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMailboxsCount();
	}

	/**
	* Updates the mailbox in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mailbox the mailbox
	* @return the mailbox that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox updateMailbox(
		mx.com.vw.jhanlos.ads.model.Mailbox mailbox)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMailbox(mailbox);
	}

	/**
	* Updates the mailbox in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mailbox the mailbox
	* @param merge whether to merge the mailbox with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the mailbox that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static mx.com.vw.jhanlos.ads.model.Mailbox updateMailbox(
		mx.com.vw.jhanlos.ads.model.Mailbox mailbox, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMailbox(mailbox, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static MailboxLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MailboxLocalService.class.getName());

			if (invokableLocalService instanceof MailboxLocalService) {
				_service = (MailboxLocalService)invokableLocalService;
			}
			else {
				_service = new MailboxLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MailboxLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(MailboxLocalService service) {
	}

	private static MailboxLocalService _service;
}