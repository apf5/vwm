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

package mx.com.vw.jhanlos.ads.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import mx.com.vw.jhanlos.ads.model.MailboxAdmin;
import mx.com.vw.jhanlos.ads.service.MailboxAdminLocalService;
import mx.com.vw.jhanlos.ads.service.MailboxAdminService;
import mx.com.vw.jhanlos.ads.service.MailboxLocalService;
import mx.com.vw.jhanlos.ads.service.MailboxService;
import mx.com.vw.jhanlos.ads.service.PropertieLocalService;
import mx.com.vw.jhanlos.ads.service.PropertieService;
import mx.com.vw.jhanlos.ads.service.persistence.MailboxAdminPersistence;
import mx.com.vw.jhanlos.ads.service.persistence.MailboxPersistence;
import mx.com.vw.jhanlos.ads.service.persistence.PropertiePersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the mailbox admin remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link mx.com.vw.jhanlos.ads.service.impl.MailboxAdminServiceImpl}.
 * </p>
 *
 * @author Jorge Loayza
 * @see mx.com.vw.jhanlos.ads.service.impl.MailboxAdminServiceImpl
 * @see mx.com.vw.jhanlos.ads.service.MailboxAdminServiceUtil
 * @generated
 */
public abstract class MailboxAdminServiceBaseImpl extends BaseServiceImpl
	implements MailboxAdminService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link mx.com.vw.jhanlos.ads.service.MailboxAdminServiceUtil} to access the mailbox admin remote service.
	 */

	/**
	 * Returns the mailbox local service.
	 *
	 * @return the mailbox local service
	 */
	public MailboxLocalService getMailboxLocalService() {
		return mailboxLocalService;
	}

	/**
	 * Sets the mailbox local service.
	 *
	 * @param mailboxLocalService the mailbox local service
	 */
	public void setMailboxLocalService(MailboxLocalService mailboxLocalService) {
		this.mailboxLocalService = mailboxLocalService;
	}

	/**
	 * Returns the mailbox remote service.
	 *
	 * @return the mailbox remote service
	 */
	public MailboxService getMailboxService() {
		return mailboxService;
	}

	/**
	 * Sets the mailbox remote service.
	 *
	 * @param mailboxService the mailbox remote service
	 */
	public void setMailboxService(MailboxService mailboxService) {
		this.mailboxService = mailboxService;
	}

	/**
	 * Returns the mailbox persistence.
	 *
	 * @return the mailbox persistence
	 */
	public MailboxPersistence getMailboxPersistence() {
		return mailboxPersistence;
	}

	/**
	 * Sets the mailbox persistence.
	 *
	 * @param mailboxPersistence the mailbox persistence
	 */
	public void setMailboxPersistence(MailboxPersistence mailboxPersistence) {
		this.mailboxPersistence = mailboxPersistence;
	}

	/**
	 * Returns the mailbox admin local service.
	 *
	 * @return the mailbox admin local service
	 */
	public MailboxAdminLocalService getMailboxAdminLocalService() {
		return mailboxAdminLocalService;
	}

	/**
	 * Sets the mailbox admin local service.
	 *
	 * @param mailboxAdminLocalService the mailbox admin local service
	 */
	public void setMailboxAdminLocalService(
		MailboxAdminLocalService mailboxAdminLocalService) {
		this.mailboxAdminLocalService = mailboxAdminLocalService;
	}

	/**
	 * Returns the mailbox admin remote service.
	 *
	 * @return the mailbox admin remote service
	 */
	public MailboxAdminService getMailboxAdminService() {
		return mailboxAdminService;
	}

	/**
	 * Sets the mailbox admin remote service.
	 *
	 * @param mailboxAdminService the mailbox admin remote service
	 */
	public void setMailboxAdminService(MailboxAdminService mailboxAdminService) {
		this.mailboxAdminService = mailboxAdminService;
	}

	/**
	 * Returns the mailbox admin persistence.
	 *
	 * @return the mailbox admin persistence
	 */
	public MailboxAdminPersistence getMailboxAdminPersistence() {
		return mailboxAdminPersistence;
	}

	/**
	 * Sets the mailbox admin persistence.
	 *
	 * @param mailboxAdminPersistence the mailbox admin persistence
	 */
	public void setMailboxAdminPersistence(
		MailboxAdminPersistence mailboxAdminPersistence) {
		this.mailboxAdminPersistence = mailboxAdminPersistence;
	}

	/**
	 * Returns the propertie local service.
	 *
	 * @return the propertie local service
	 */
	public PropertieLocalService getPropertieLocalService() {
		return propertieLocalService;
	}

	/**
	 * Sets the propertie local service.
	 *
	 * @param propertieLocalService the propertie local service
	 */
	public void setPropertieLocalService(
		PropertieLocalService propertieLocalService) {
		this.propertieLocalService = propertieLocalService;
	}

	/**
	 * Returns the propertie remote service.
	 *
	 * @return the propertie remote service
	 */
	public PropertieService getPropertieService() {
		return propertieService;
	}

	/**
	 * Sets the propertie remote service.
	 *
	 * @param propertieService the propertie remote service
	 */
	public void setPropertieService(PropertieService propertieService) {
		this.propertieService = propertieService;
	}

	/**
	 * Returns the propertie persistence.
	 *
	 * @return the propertie persistence
	 */
	public PropertiePersistence getPropertiePersistence() {
		return propertiePersistence;
	}

	/**
	 * Sets the propertie persistence.
	 *
	 * @param propertiePersistence the propertie persistence
	 */
	public void setPropertiePersistence(
		PropertiePersistence propertiePersistence) {
		this.propertiePersistence = propertiePersistence;
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
	}

	public void destroy() {
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
		return MailboxAdmin.class;
	}

	protected String getModelClassName() {
		return MailboxAdmin.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = mailboxAdminPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = MailboxLocalService.class)
	protected MailboxLocalService mailboxLocalService;
	@BeanReference(type = MailboxService.class)
	protected MailboxService mailboxService;
	@BeanReference(type = MailboxPersistence.class)
	protected MailboxPersistence mailboxPersistence;
	@BeanReference(type = MailboxAdminLocalService.class)
	protected MailboxAdminLocalService mailboxAdminLocalService;
	@BeanReference(type = MailboxAdminService.class)
	protected MailboxAdminService mailboxAdminService;
	@BeanReference(type = MailboxAdminPersistence.class)
	protected MailboxAdminPersistence mailboxAdminPersistence;
	@BeanReference(type = PropertieLocalService.class)
	protected PropertieLocalService propertieLocalService;
	@BeanReference(type = PropertieService.class)
	protected PropertieService propertieService;
	@BeanReference(type = PropertiePersistence.class)
	protected PropertiePersistence propertiePersistence;
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
	private MailboxAdminServiceClpInvoker _clpInvoker = new MailboxAdminServiceClpInvoker();
}