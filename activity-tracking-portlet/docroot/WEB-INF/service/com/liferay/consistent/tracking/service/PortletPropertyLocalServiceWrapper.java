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
 * This class is a wrapper for {@link PortletPropertyLocalService}.
 * </p>
 *
 * @author    Jorge Loayza Soloisolo
 * @see       PortletPropertyLocalService
 * @generated
 */
public class PortletPropertyLocalServiceWrapper
	implements PortletPropertyLocalService,
		ServiceWrapper<PortletPropertyLocalService> {
	public PortletPropertyLocalServiceWrapper(
		PortletPropertyLocalService portletPropertyLocalService) {
		_portletPropertyLocalService = portletPropertyLocalService;
	}

	/**
	* Adds the portlet property to the database. Also notifies the appropriate model listeners.
	*
	* @param portletProperty the portlet property
	* @return the portlet property that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty addPortletProperty(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.addPortletProperty(portletProperty);
	}

	/**
	* Creates a new portlet property with the primary key. Does not add the portlet property to the database.
	*
	* @param propertyId the primary key for the new portlet property
	* @return the new portlet property
	*/
	public com.liferay.consistent.tracking.model.PortletProperty createPortletProperty(
		long propertyId) {
		return _portletPropertyLocalService.createPortletProperty(propertyId);
	}

	/**
	* Deletes the portlet property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the portlet property
	* @return the portlet property that was removed
	* @throws PortalException if a portlet property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty deletePortletProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.deletePortletProperty(propertyId);
	}

	/**
	* Deletes the portlet property from the database. Also notifies the appropriate model listeners.
	*
	* @param portletProperty the portlet property
	* @return the portlet property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty deletePortletProperty(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.deletePortletProperty(portletProperty);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portletPropertyLocalService.dynamicQuery();
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
		return _portletPropertyLocalService.dynamicQuery(dynamicQuery);
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
		return _portletPropertyLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _portletPropertyLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _portletPropertyLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.consistent.tracking.model.PortletProperty fetchPortletProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.fetchPortletProperty(propertyId);
	}

	/**
	* Returns the portlet property with the primary key.
	*
	* @param propertyId the primary key of the portlet property
	* @return the portlet property
	* @throws PortalException if a portlet property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty getPortletProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.getPortletProperty(propertyId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the portlet properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet properties
	* @param end the upper bound of the range of portlet properties (not inclusive)
	* @return the range of portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consistent.tracking.model.PortletProperty> getPortletProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.getPortletProperties(start, end);
	}

	/**
	* Returns the number of portlet properties.
	*
	* @return the number of portlet properties
	* @throws SystemException if a system exception occurred
	*/
	public int getPortletPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.getPortletPropertiesCount();
	}

	/**
	* Updates the portlet property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletProperty the portlet property
	* @return the portlet property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty updatePortletProperty(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.updatePortletProperty(portletProperty);
	}

	/**
	* Updates the portlet property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletProperty the portlet property
	* @param merge whether to merge the portlet property with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portlet property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consistent.tracking.model.PortletProperty updatePortletProperty(
		com.liferay.consistent.tracking.model.PortletProperty portletProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.updatePortletProperty(portletProperty,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _portletPropertyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portletPropertyLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portletPropertyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.Properties getAllProperties()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.getAllProperties();
	}

	public java.util.Properties getPropertiesByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.getPropertiesByCompany(companyId);
	}

	public void updateAllProperties(long companyId,
		java.util.HashMap<java.lang.String, java.lang.String> properties)
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletPropertyLocalService.updateAllProperties(companyId, properties);
	}

	public com.liferay.consistent.tracking.model.PortletProperty setProperty(
		long companyId, java.lang.String name, java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPropertyLocalService.setProperty(companyId, name, value);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PortletPropertyLocalService getWrappedPortletPropertyLocalService() {
		return _portletPropertyLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPortletPropertyLocalService(
		PortletPropertyLocalService portletPropertyLocalService) {
		_portletPropertyLocalService = portletPropertyLocalService;
	}

	public PortletPropertyLocalService getWrappedService() {
		return _portletPropertyLocalService;
	}

	public void setWrappedService(
		PortletPropertyLocalService portletPropertyLocalService) {
		_portletPropertyLocalService = portletPropertyLocalService;
	}

	private PortletPropertyLocalService _portletPropertyLocalService;
}