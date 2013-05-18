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

package com.liferay.consistent.tracking.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Browsinglog service. Represents a row in the &quot;CONSIS_TRACK_Browsinglog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.consistent.tracking.model.impl.BrowsinglogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.consistent.tracking.model.impl.BrowsinglogImpl}.
 * </p>
 *
 * @author Jorge Loayza Soloisolo
 * @see Browsinglog
 * @see com.liferay.consistent.tracking.model.impl.BrowsinglogImpl
 * @see com.liferay.consistent.tracking.model.impl.BrowsinglogModelImpl
 * @generated
 */
public interface BrowsinglogModel extends BaseModel<Browsinglog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a browsinglog model instance should use the {@link Browsinglog} interface instead.
	 */

	/**
	 * Returns the primary key of this browsinglog.
	 *
	 * @return the primary key of this browsinglog
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this browsinglog.
	 *
	 * @param primaryKey the primary key of this browsinglog
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the browsinglog ID of this browsinglog.
	 *
	 * @return the browsinglog ID of this browsinglog
	 */
	public long getBrowsinglogId();

	/**
	 * Sets the browsinglog ID of this browsinglog.
	 *
	 * @param browsinglogId the browsinglog ID of this browsinglog
	 */
	public void setBrowsinglogId(long browsinglogId);

	/**
	 * Returns the company ID of this browsinglog.
	 *
	 * @return the company ID of this browsinglog
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this browsinglog.
	 *
	 * @param companyId the company ID of this browsinglog
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the userlog ID of this browsinglog.
	 *
	 * @return the userlog ID of this browsinglog
	 */
	public long getUserlogId();

	/**
	 * Sets the userlog ID of this browsinglog.
	 *
	 * @param userlogId the userlog ID of this browsinglog
	 */
	public void setUserlogId(long userlogId);

	/**
	 * Returns the user agent of this browsinglog.
	 *
	 * @return the user agent of this browsinglog
	 */
	@AutoEscape
	public String getUserAgent();

	/**
	 * Sets the user agent of this browsinglog.
	 *
	 * @param userAgent the user agent of this browsinglog
	 */
	public void setUserAgent(String userAgent);

	/**
	 * Returns the url of this browsinglog.
	 *
	 * @return the url of this browsinglog
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this browsinglog.
	 *
	 * @param url the url of this browsinglog
	 */
	public void setUrl(String url);

	/**
	 * Returns the pl ID of this browsinglog.
	 *
	 * @return the pl ID of this browsinglog
	 */
	public long getPlId();

	/**
	 * Sets the pl ID of this browsinglog.
	 *
	 * @param plId the pl ID of this browsinglog
	 */
	public void setPlId(long plId);

	/**
	 * Returns the access name of this browsinglog.
	 *
	 * @return the access name of this browsinglog
	 */
	@AutoEscape
	public String getAccessName();

	/**
	 * Sets the access name of this browsinglog.
	 *
	 * @param accessName the access name of this browsinglog
	 */
	public void setAccessName(String accessName);

	/**
	 * Returns the access found of this browsinglog.
	 *
	 * @return the access found of this browsinglog
	 */
	public boolean getAccessFound();

	/**
	 * Returns <code>true</code> if this browsinglog is access found.
	 *
	 * @return <code>true</code> if this browsinglog is access found; <code>false</code> otherwise
	 */
	public boolean isAccessFound();

	/**
	 * Sets whether this browsinglog is access found.
	 *
	 * @param accessFound the access found of this browsinglog
	 */
	public void setAccessFound(boolean accessFound);

	/**
	 * Returns the access date of this browsinglog.
	 *
	 * @return the access date of this browsinglog
	 */
	public long getAccessDate();

	/**
	 * Sets the access date of this browsinglog.
	 *
	 * @param accessDate the access date of this browsinglog
	 */
	public void setAccessDate(long accessDate);

	/**
	 * Returns the elapse load of this browsinglog.
	 *
	 * @return the elapse load of this browsinglog
	 */
	public long getElapseLoad();

	/**
	 * Sets the elapse load of this browsinglog.
	 *
	 * @param elapseLoad the elapse load of this browsinglog
	 */
	public void setElapseLoad(long elapseLoad);

	/**
	 * Returns the upload size of this browsinglog.
	 *
	 * @return the upload size of this browsinglog
	 */
	public long getUploadSize();

	/**
	 * Sets the upload size of this browsinglog.
	 *
	 * @param uploadSize the upload size of this browsinglog
	 */
	public void setUploadSize(long uploadSize);

	/**
	 * Returns the download size of this browsinglog.
	 *
	 * @return the download size of this browsinglog
	 */
	public long getDownloadSize();

	/**
	 * Sets the download size of this browsinglog.
	 *
	 * @param downloadSize the download size of this browsinglog
	 */
	public void setDownloadSize(long downloadSize);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Browsinglog browsinglog);

	public int hashCode();

	public CacheModel<Browsinglog> toCacheModel();

	public Browsinglog toEscapedModel();

	public String toString();

	public String toXmlString();
}