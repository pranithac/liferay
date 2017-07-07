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
 * This class is a wrapper for {@link LeaveApprovalHistory}.
 * </p>
 *
 * @author
 * @see LeaveApprovalHistory
 * @generated
 */
public class LeaveApprovalHistoryWrapper implements LeaveApprovalHistory,
	ModelWrapper<LeaveApprovalHistory> {
	public LeaveApprovalHistoryWrapper(
		LeaveApprovalHistory leaveApprovalHistory) {
		_leaveApprovalHistory = leaveApprovalHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveApprovalHistory.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveApprovalHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SNo", getSNo());
		attributes.put("LeaveRequestId", getLeaveRequestId());
		attributes.put("ApproverID", getApproverID());
		attributes.put("LeaveStatus", getLeaveStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer SNo = (Integer)attributes.get("SNo");

		if (SNo != null) {
			setSNo(SNo);
		}

		String LeaveRequestId = (String)attributes.get("LeaveRequestId");

		if (LeaveRequestId != null) {
			setLeaveRequestId(LeaveRequestId);
		}

		Integer ApproverID = (Integer)attributes.get("ApproverID");

		if (ApproverID != null) {
			setApproverID(ApproverID);
		}

		String LeaveStatus = (String)attributes.get("LeaveStatus");

		if (LeaveStatus != null) {
			setLeaveStatus(LeaveStatus);
		}
	}

	/**
	* Returns the primary key of this leave approval history.
	*
	* @return the primary key of this leave approval history
	*/
	@Override
	public int getPrimaryKey() {
		return _leaveApprovalHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave approval history.
	*
	* @param primaryKey the primary key of this leave approval history
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_leaveApprovalHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the s no of this leave approval history.
	*
	* @return the s no of this leave approval history
	*/
	@Override
	public int getSNo() {
		return _leaveApprovalHistory.getSNo();
	}

	/**
	* Sets the s no of this leave approval history.
	*
	* @param SNo the s no of this leave approval history
	*/
	@Override
	public void setSNo(int SNo) {
		_leaveApprovalHistory.setSNo(SNo);
	}

	/**
	* Returns the leave request ID of this leave approval history.
	*
	* @return the leave request ID of this leave approval history
	*/
	@Override
	public java.lang.String getLeaveRequestId() {
		return _leaveApprovalHistory.getLeaveRequestId();
	}

	/**
	* Sets the leave request ID of this leave approval history.
	*
	* @param LeaveRequestId the leave request ID of this leave approval history
	*/
	@Override
	public void setLeaveRequestId(java.lang.String LeaveRequestId) {
		_leaveApprovalHistory.setLeaveRequestId(LeaveRequestId);
	}

	/**
	* Returns the approver i d of this leave approval history.
	*
	* @return the approver i d of this leave approval history
	*/
	@Override
	public int getApproverID() {
		return _leaveApprovalHistory.getApproverID();
	}

	/**
	* Sets the approver i d of this leave approval history.
	*
	* @param ApproverID the approver i d of this leave approval history
	*/
	@Override
	public void setApproverID(int ApproverID) {
		_leaveApprovalHistory.setApproverID(ApproverID);
	}

	/**
	* Returns the leave status of this leave approval history.
	*
	* @return the leave status of this leave approval history
	*/
	@Override
	public java.lang.String getLeaveStatus() {
		return _leaveApprovalHistory.getLeaveStatus();
	}

	/**
	* Sets the leave status of this leave approval history.
	*
	* @param LeaveStatus the leave status of this leave approval history
	*/
	@Override
	public void setLeaveStatus(java.lang.String LeaveStatus) {
		_leaveApprovalHistory.setLeaveStatus(LeaveStatus);
	}

	@Override
	public boolean isNew() {
		return _leaveApprovalHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveApprovalHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveApprovalHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveApprovalHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveApprovalHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveApprovalHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveApprovalHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveApprovalHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveApprovalHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveApprovalHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveApprovalHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveApprovalHistoryWrapper((LeaveApprovalHistory)_leaveApprovalHistory.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.LeaveApprovalHistory leaveApprovalHistory) {
		return _leaveApprovalHistory.compareTo(leaveApprovalHistory);
	}

	@Override
	public int hashCode() {
		return _leaveApprovalHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LeaveApprovalHistory> toCacheModel() {
		return _leaveApprovalHistory.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LeaveApprovalHistory toEscapedModel() {
		return new LeaveApprovalHistoryWrapper(_leaveApprovalHistory.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LeaveApprovalHistory toUnescapedModel() {
		return new LeaveApprovalHistoryWrapper(_leaveApprovalHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveApprovalHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveApprovalHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveApprovalHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveApprovalHistoryWrapper)) {
			return false;
		}

		LeaveApprovalHistoryWrapper leaveApprovalHistoryWrapper = (LeaveApprovalHistoryWrapper)obj;

		if (Validator.equals(_leaveApprovalHistory,
					leaveApprovalHistoryWrapper._leaveApprovalHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveApprovalHistory getWrappedLeaveApprovalHistory() {
		return _leaveApprovalHistory;
	}

	@Override
	public LeaveApprovalHistory getWrappedModel() {
		return _leaveApprovalHistory;
	}

	@Override
	public void resetOriginalValues() {
		_leaveApprovalHistory.resetOriginalValues();
	}

	private LeaveApprovalHistory _leaveApprovalHistory;
}