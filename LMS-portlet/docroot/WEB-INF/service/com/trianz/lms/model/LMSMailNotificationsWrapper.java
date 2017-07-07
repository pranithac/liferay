/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.trianz.lms.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LMSMailNotifications}.
 * </p>
 *
 * @author
 * @see LMSMailNotifications
 * @generated
 */
public class LMSMailNotificationsWrapper implements LMSMailNotifications,
	ModelWrapper<LMSMailNotifications> {
	public LMSMailNotificationsWrapper(
		LMSMailNotifications lmsMailNotifications) {
		_lmsMailNotifications = lmsMailNotifications;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSMailNotifications.class;
	}

	@Override
	public String getModelClassName() {
		return LMSMailNotifications.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("MailNotfnId", getMailNotfnId());
		attributes.put("LeaveRequestId", getLeaveRequestId());
		attributes.put("FromAddrs", getFromAddrs());
		attributes.put("ToAddrs", getToAddrs());
		attributes.put("Comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer MailNotfnId = (Integer)attributes.get("MailNotfnId");

		if (MailNotfnId != null) {
			setMailNotfnId(MailNotfnId);
		}

		String LeaveRequestId = (String)attributes.get("LeaveRequestId");

		if (LeaveRequestId != null) {
			setLeaveRequestId(LeaveRequestId);
		}

		String FromAddrs = (String)attributes.get("FromAddrs");

		if (FromAddrs != null) {
			setFromAddrs(FromAddrs);
		}

		String ToAddrs = (String)attributes.get("ToAddrs");

		if (ToAddrs != null) {
			setToAddrs(ToAddrs);
		}

		String Comments = (String)attributes.get("Comments");

		if (Comments != null) {
			setComments(Comments);
		}
	}

	/**
	* Returns the primary key of this l m s mail notifications.
	*
	* @return the primary key of this l m s mail notifications
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsMailNotifications.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s mail notifications.
	*
	* @param primaryKey the primary key of this l m s mail notifications
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsMailNotifications.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mail notfn ID of this l m s mail notifications.
	*
	* @return the mail notfn ID of this l m s mail notifications
	*/
	@Override
	public int getMailNotfnId() {
		return _lmsMailNotifications.getMailNotfnId();
	}

	/**
	* Sets the mail notfn ID of this l m s mail notifications.
	*
	* @param MailNotfnId the mail notfn ID of this l m s mail notifications
	*/
	@Override
	public void setMailNotfnId(int MailNotfnId) {
		_lmsMailNotifications.setMailNotfnId(MailNotfnId);
	}

	/**
	* Returns the leave request ID of this l m s mail notifications.
	*
	* @return the leave request ID of this l m s mail notifications
	*/
	@Override
	public java.lang.String getLeaveRequestId() {
		return _lmsMailNotifications.getLeaveRequestId();
	}

	/**
	* Sets the leave request ID of this l m s mail notifications.
	*
	* @param LeaveRequestId the leave request ID of this l m s mail notifications
	*/
	@Override
	public void setLeaveRequestId(java.lang.String LeaveRequestId) {
		_lmsMailNotifications.setLeaveRequestId(LeaveRequestId);
	}

	/**
	* Returns the from addrs of this l m s mail notifications.
	*
	* @return the from addrs of this l m s mail notifications
	*/
	@Override
	public java.lang.String getFromAddrs() {
		return _lmsMailNotifications.getFromAddrs();
	}

	/**
	* Sets the from addrs of this l m s mail notifications.
	*
	* @param FromAddrs the from addrs of this l m s mail notifications
	*/
	@Override
	public void setFromAddrs(java.lang.String FromAddrs) {
		_lmsMailNotifications.setFromAddrs(FromAddrs);
	}

	/**
	* Returns the to addrs of this l m s mail notifications.
	*
	* @return the to addrs of this l m s mail notifications
	*/
	@Override
	public java.lang.String getToAddrs() {
		return _lmsMailNotifications.getToAddrs();
	}

	/**
	* Sets the to addrs of this l m s mail notifications.
	*
	* @param ToAddrs the to addrs of this l m s mail notifications
	*/
	@Override
	public void setToAddrs(java.lang.String ToAddrs) {
		_lmsMailNotifications.setToAddrs(ToAddrs);
	}

	/**
	* Returns the comments of this l m s mail notifications.
	*
	* @return the comments of this l m s mail notifications
	*/
	@Override
	public java.lang.String getComments() {
		return _lmsMailNotifications.getComments();
	}

	/**
	* Sets the comments of this l m s mail notifications.
	*
	* @param Comments the comments of this l m s mail notifications
	*/
	@Override
	public void setComments(java.lang.String Comments) {
		_lmsMailNotifications.setComments(Comments);
	}

	@Override
	public boolean isNew() {
		return _lmsMailNotifications.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsMailNotifications.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsMailNotifications.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsMailNotifications.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsMailNotifications.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsMailNotifications.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsMailNotifications.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsMailNotifications.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsMailNotifications.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsMailNotifications.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsMailNotifications.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSMailNotificationsWrapper((LMSMailNotifications)_lmsMailNotifications.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.LMSMailNotifications lmsMailNotifications) {
		return _lmsMailNotifications.compareTo(lmsMailNotifications);
	}

	@Override
	public int hashCode() {
		return _lmsMailNotifications.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSMailNotifications> toCacheModel() {
		return _lmsMailNotifications.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSMailNotifications toEscapedModel() {
		return new LMSMailNotificationsWrapper(_lmsMailNotifications.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSMailNotifications toUnescapedModel() {
		return new LMSMailNotificationsWrapper(_lmsMailNotifications.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsMailNotifications.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsMailNotifications.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsMailNotifications.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSMailNotificationsWrapper)) {
			return false;
		}

		LMSMailNotificationsWrapper lmsMailNotificationsWrapper = (LMSMailNotificationsWrapper)obj;

		if (Validator.equals(_lmsMailNotifications,
					lmsMailNotificationsWrapper._lmsMailNotifications)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSMailNotifications getWrappedLMSMailNotifications() {
		return _lmsMailNotifications;
	}

	@Override
	public LMSMailNotifications getWrappedModel() {
		return _lmsMailNotifications;
	}

	@Override
	public void resetOriginalValues() {
		_lmsMailNotifications.resetOriginalValues();
	}

	private LMSMailNotifications _lmsMailNotifications;
}