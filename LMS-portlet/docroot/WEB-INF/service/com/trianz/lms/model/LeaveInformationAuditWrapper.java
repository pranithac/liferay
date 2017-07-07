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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LeaveInformationAudit}.
 * </p>
 *
 * @author
 * @see LeaveInformationAudit
 * @generated
 */
public class LeaveInformationAuditWrapper implements LeaveInformationAudit,
	ModelWrapper<LeaveInformationAudit> {
	public LeaveInformationAuditWrapper(
		LeaveInformationAudit leaveInformationAudit) {
		_leaveInformationAudit = leaveInformationAudit;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveInformationAudit.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveInformationAudit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LogId", getLogId());
		attributes.put("LeaveRequestId", getLeaveRequestId());
		attributes.put("Action", getAction());
		attributes.put("ActionBy", getActionBy());
		attributes.put("CreatedDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer LogId = (Integer)attributes.get("LogId");

		if (LogId != null) {
			setLogId(LogId);
		}

		Integer LeaveRequestId = (Integer)attributes.get("LeaveRequestId");

		if (LeaveRequestId != null) {
			setLeaveRequestId(LeaveRequestId);
		}

		String Action = (String)attributes.get("Action");

		if (Action != null) {
			setAction(Action);
		}

		String ActionBy = (String)attributes.get("ActionBy");

		if (ActionBy != null) {
			setActionBy(ActionBy);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}
	}

	/**
	* Returns the primary key of this leave information audit.
	*
	* @return the primary key of this leave information audit
	*/
	@Override
	public int getPrimaryKey() {
		return _leaveInformationAudit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave information audit.
	*
	* @param primaryKey the primary key of this leave information audit
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_leaveInformationAudit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the log ID of this leave information audit.
	*
	* @return the log ID of this leave information audit
	*/
	@Override
	public int getLogId() {
		return _leaveInformationAudit.getLogId();
	}

	/**
	* Sets the log ID of this leave information audit.
	*
	* @param LogId the log ID of this leave information audit
	*/
	@Override
	public void setLogId(int LogId) {
		_leaveInformationAudit.setLogId(LogId);
	}

	/**
	* Returns the leave request ID of this leave information audit.
	*
	* @return the leave request ID of this leave information audit
	*/
	@Override
	public int getLeaveRequestId() {
		return _leaveInformationAudit.getLeaveRequestId();
	}

	/**
	* Sets the leave request ID of this leave information audit.
	*
	* @param LeaveRequestId the leave request ID of this leave information audit
	*/
	@Override
	public void setLeaveRequestId(int LeaveRequestId) {
		_leaveInformationAudit.setLeaveRequestId(LeaveRequestId);
	}

	/**
	* Returns the action of this leave information audit.
	*
	* @return the action of this leave information audit
	*/
	@Override
	public java.lang.String getAction() {
		return _leaveInformationAudit.getAction();
	}

	/**
	* Sets the action of this leave information audit.
	*
	* @param Action the action of this leave information audit
	*/
	@Override
	public void setAction(java.lang.String Action) {
		_leaveInformationAudit.setAction(Action);
	}

	/**
	* Returns the action by of this leave information audit.
	*
	* @return the action by of this leave information audit
	*/
	@Override
	public java.lang.String getActionBy() {
		return _leaveInformationAudit.getActionBy();
	}

	/**
	* Sets the action by of this leave information audit.
	*
	* @param ActionBy the action by of this leave information audit
	*/
	@Override
	public void setActionBy(java.lang.String ActionBy) {
		_leaveInformationAudit.setActionBy(ActionBy);
	}

	/**
	* Returns the created date of this leave information audit.
	*
	* @return the created date of this leave information audit
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _leaveInformationAudit.getCreatedDate();
	}

	/**
	* Sets the created date of this leave information audit.
	*
	* @param CreatedDate the created date of this leave information audit
	*/
	@Override
	public void setCreatedDate(java.util.Date CreatedDate) {
		_leaveInformationAudit.setCreatedDate(CreatedDate);
	}

	@Override
	public boolean isNew() {
		return _leaveInformationAudit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveInformationAudit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveInformationAudit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveInformationAudit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveInformationAudit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveInformationAudit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveInformationAudit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveInformationAudit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveInformationAudit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveInformationAudit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveInformationAudit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveInformationAuditWrapper((LeaveInformationAudit)_leaveInformationAudit.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.LeaveInformationAudit leaveInformationAudit) {
		return _leaveInformationAudit.compareTo(leaveInformationAudit);
	}

	@Override
	public int hashCode() {
		return _leaveInformationAudit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LeaveInformationAudit> toCacheModel() {
		return _leaveInformationAudit.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LeaveInformationAudit toEscapedModel() {
		return new LeaveInformationAuditWrapper(_leaveInformationAudit.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LeaveInformationAudit toUnescapedModel() {
		return new LeaveInformationAuditWrapper(_leaveInformationAudit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveInformationAudit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveInformationAudit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveInformationAudit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveInformationAuditWrapper)) {
			return false;
		}

		LeaveInformationAuditWrapper leaveInformationAuditWrapper = (LeaveInformationAuditWrapper)obj;

		if (Validator.equals(_leaveInformationAudit,
					leaveInformationAuditWrapper._leaveInformationAudit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveInformationAudit getWrappedLeaveInformationAudit() {
		return _leaveInformationAudit;
	}

	@Override
	public LeaveInformationAudit getWrappedModel() {
		return _leaveInformationAudit;
	}

	@Override
	public void resetOriginalValues() {
		_leaveInformationAudit.resetOriginalValues();
	}

	private LeaveInformationAudit _leaveInformationAudit;
}