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
 * This class is a wrapper for {@link LMSLeaveInformation}.
 * </p>
 *
 * @author
 * @see LMSLeaveInformation
 * @generated
 */
public class LMSLeaveInformationWrapper implements LMSLeaveInformation,
	ModelWrapper<LMSLeaveInformation> {
	public LMSLeaveInformationWrapper(LMSLeaveInformation lmsLeaveInformation) {
		_lmsLeaveInformation = lmsLeaveInformation;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSLeaveInformation.class;
	}

	@Override
	public String getModelClassName() {
		return LMSLeaveInformation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SNo", getSNo());
		attributes.put("LeaveRequestId", getLeaveRequestId());
		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("AbsenceType", getAbsenceType());
		attributes.put("LeaveTypeCode", getLeaveTypeCode());
		attributes.put("LeaveCategoryCode", getLeaveCategoryCode());
		attributes.put("SupervisorID", getSupervisorID());
		attributes.put("StartDate", getStartDate());
		attributes.put("EndDate", getEndDate());
		attributes.put("Duration", getDuration());
		attributes.put("ApprovalStatus", getApprovalStatus());
		attributes.put("Comments", getComments());
		attributes.put("isDraft", getIsDraft());
		attributes.put("Approvers", getApprovers());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("ApproverEmails", getApproverEmails());

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

		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		String AbsenceType = (String)attributes.get("AbsenceType");

		if (AbsenceType != null) {
			setAbsenceType(AbsenceType);
		}

		Integer LeaveTypeCode = (Integer)attributes.get("LeaveTypeCode");

		if (LeaveTypeCode != null) {
			setLeaveTypeCode(LeaveTypeCode);
		}

		String LeaveCategoryCode = (String)attributes.get("LeaveCategoryCode");

		if (LeaveCategoryCode != null) {
			setLeaveCategoryCode(LeaveCategoryCode);
		}

		Integer SupervisorID = (Integer)attributes.get("SupervisorID");

		if (SupervisorID != null) {
			setSupervisorID(SupervisorID);
		}

		Date StartDate = (Date)attributes.get("StartDate");

		if (StartDate != null) {
			setStartDate(StartDate);
		}

		Date EndDate = (Date)attributes.get("EndDate");

		if (EndDate != null) {
			setEndDate(EndDate);
		}

		Double Duration = (Double)attributes.get("Duration");

		if (Duration != null) {
			setDuration(Duration);
		}

		String ApprovalStatus = (String)attributes.get("ApprovalStatus");

		if (ApprovalStatus != null) {
			setApprovalStatus(ApprovalStatus);
		}

		String Comments = (String)attributes.get("Comments");

		if (Comments != null) {
			setComments(Comments);
		}

		String isDraft = (String)attributes.get("isDraft");

		if (isDraft != null) {
			setIsDraft(isDraft);
		}

		Integer Approvers = (Integer)attributes.get("Approvers");

		if (Approvers != null) {
			setApprovers(Approvers);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		String ApproverEmails = (String)attributes.get("ApproverEmails");

		if (ApproverEmails != null) {
			setApproverEmails(ApproverEmails);
		}
	}

	/**
	* Returns the primary key of this l m s leave information.
	*
	* @return the primary key of this l m s leave information
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsLeaveInformation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s leave information.
	*
	* @param primaryKey the primary key of this l m s leave information
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsLeaveInformation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the s no of this l m s leave information.
	*
	* @return the s no of this l m s leave information
	*/
	@Override
	public int getSNo() {
		return _lmsLeaveInformation.getSNo();
	}

	/**
	* Sets the s no of this l m s leave information.
	*
	* @param SNo the s no of this l m s leave information
	*/
	@Override
	public void setSNo(int SNo) {
		_lmsLeaveInformation.setSNo(SNo);
	}

	/**
	* Returns the leave request ID of this l m s leave information.
	*
	* @return the leave request ID of this l m s leave information
	*/
	@Override
	public java.lang.String getLeaveRequestId() {
		return _lmsLeaveInformation.getLeaveRequestId();
	}

	/**
	* Sets the leave request ID of this l m s leave information.
	*
	* @param LeaveRequestId the leave request ID of this l m s leave information
	*/
	@Override
	public void setLeaveRequestId(java.lang.String LeaveRequestId) {
		_lmsLeaveInformation.setLeaveRequestId(LeaveRequestId);
	}

	/**
	* Returns the employee ID of this l m s leave information.
	*
	* @return the employee ID of this l m s leave information
	*/
	@Override
	public int getEmployeeId() {
		return _lmsLeaveInformation.getEmployeeId();
	}

	/**
	* Sets the employee ID of this l m s leave information.
	*
	* @param EmployeeId the employee ID of this l m s leave information
	*/
	@Override
	public void setEmployeeId(int EmployeeId) {
		_lmsLeaveInformation.setEmployeeId(EmployeeId);
	}

	/**
	* Returns the absence type of this l m s leave information.
	*
	* @return the absence type of this l m s leave information
	*/
	@Override
	public java.lang.String getAbsenceType() {
		return _lmsLeaveInformation.getAbsenceType();
	}

	/**
	* Sets the absence type of this l m s leave information.
	*
	* @param AbsenceType the absence type of this l m s leave information
	*/
	@Override
	public void setAbsenceType(java.lang.String AbsenceType) {
		_lmsLeaveInformation.setAbsenceType(AbsenceType);
	}

	/**
	* Returns the leave type code of this l m s leave information.
	*
	* @return the leave type code of this l m s leave information
	*/
	@Override
	public int getLeaveTypeCode() {
		return _lmsLeaveInformation.getLeaveTypeCode();
	}

	/**
	* Sets the leave type code of this l m s leave information.
	*
	* @param LeaveTypeCode the leave type code of this l m s leave information
	*/
	@Override
	public void setLeaveTypeCode(int LeaveTypeCode) {
		_lmsLeaveInformation.setLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the leave category code of this l m s leave information.
	*
	* @return the leave category code of this l m s leave information
	*/
	@Override
	public java.lang.String getLeaveCategoryCode() {
		return _lmsLeaveInformation.getLeaveCategoryCode();
	}

	/**
	* Sets the leave category code of this l m s leave information.
	*
	* @param LeaveCategoryCode the leave category code of this l m s leave information
	*/
	@Override
	public void setLeaveCategoryCode(java.lang.String LeaveCategoryCode) {
		_lmsLeaveInformation.setLeaveCategoryCode(LeaveCategoryCode);
	}

	/**
	* Returns the supervisor i d of this l m s leave information.
	*
	* @return the supervisor i d of this l m s leave information
	*/
	@Override
	public int getSupervisorID() {
		return _lmsLeaveInformation.getSupervisorID();
	}

	/**
	* Sets the supervisor i d of this l m s leave information.
	*
	* @param SupervisorID the supervisor i d of this l m s leave information
	*/
	@Override
	public void setSupervisorID(int SupervisorID) {
		_lmsLeaveInformation.setSupervisorID(SupervisorID);
	}

	/**
	* Returns the start date of this l m s leave information.
	*
	* @return the start date of this l m s leave information
	*/
	@Override
	public java.util.Date getStartDate() {
		return _lmsLeaveInformation.getStartDate();
	}

	/**
	* Sets the start date of this l m s leave information.
	*
	* @param StartDate the start date of this l m s leave information
	*/
	@Override
	public void setStartDate(java.util.Date StartDate) {
		_lmsLeaveInformation.setStartDate(StartDate);
	}

	/**
	* Returns the end date of this l m s leave information.
	*
	* @return the end date of this l m s leave information
	*/
	@Override
	public java.util.Date getEndDate() {
		return _lmsLeaveInformation.getEndDate();
	}

	/**
	* Sets the end date of this l m s leave information.
	*
	* @param EndDate the end date of this l m s leave information
	*/
	@Override
	public void setEndDate(java.util.Date EndDate) {
		_lmsLeaveInformation.setEndDate(EndDate);
	}

	/**
	* Returns the duration of this l m s leave information.
	*
	* @return the duration of this l m s leave information
	*/
	@Override
	public double getDuration() {
		return _lmsLeaveInformation.getDuration();
	}

	/**
	* Sets the duration of this l m s leave information.
	*
	* @param Duration the duration of this l m s leave information
	*/
	@Override
	public void setDuration(double Duration) {
		_lmsLeaveInformation.setDuration(Duration);
	}

	/**
	* Returns the approval status of this l m s leave information.
	*
	* @return the approval status of this l m s leave information
	*/
	@Override
	public java.lang.String getApprovalStatus() {
		return _lmsLeaveInformation.getApprovalStatus();
	}

	/**
	* Sets the approval status of this l m s leave information.
	*
	* @param ApprovalStatus the approval status of this l m s leave information
	*/
	@Override
	public void setApprovalStatus(java.lang.String ApprovalStatus) {
		_lmsLeaveInformation.setApprovalStatus(ApprovalStatus);
	}

	/**
	* Returns the comments of this l m s leave information.
	*
	* @return the comments of this l m s leave information
	*/
	@Override
	public java.lang.String getComments() {
		return _lmsLeaveInformation.getComments();
	}

	/**
	* Sets the comments of this l m s leave information.
	*
	* @param Comments the comments of this l m s leave information
	*/
	@Override
	public void setComments(java.lang.String Comments) {
		_lmsLeaveInformation.setComments(Comments);
	}

	/**
	* Returns the is draft of this l m s leave information.
	*
	* @return the is draft of this l m s leave information
	*/
	@Override
	public java.lang.String getIsDraft() {
		return _lmsLeaveInformation.getIsDraft();
	}

	/**
	* Sets the is draft of this l m s leave information.
	*
	* @param isDraft the is draft of this l m s leave information
	*/
	@Override
	public void setIsDraft(java.lang.String isDraft) {
		_lmsLeaveInformation.setIsDraft(isDraft);
	}

	/**
	* Returns the approvers of this l m s leave information.
	*
	* @return the approvers of this l m s leave information
	*/
	@Override
	public int getApprovers() {
		return _lmsLeaveInformation.getApprovers();
	}

	/**
	* Sets the approvers of this l m s leave information.
	*
	* @param Approvers the approvers of this l m s leave information
	*/
	@Override
	public void setApprovers(int Approvers) {
		_lmsLeaveInformation.setApprovers(Approvers);
	}

	/**
	* Returns the created date of this l m s leave information.
	*
	* @return the created date of this l m s leave information
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _lmsLeaveInformation.getCreatedDate();
	}

	/**
	* Sets the created date of this l m s leave information.
	*
	* @param CreatedDate the created date of this l m s leave information
	*/
	@Override
	public void setCreatedDate(java.util.Date CreatedDate) {
		_lmsLeaveInformation.setCreatedDate(CreatedDate);
	}

	/**
	* Returns the approver emails of this l m s leave information.
	*
	* @return the approver emails of this l m s leave information
	*/
	@Override
	public java.lang.String getApproverEmails() {
		return _lmsLeaveInformation.getApproverEmails();
	}

	/**
	* Sets the approver emails of this l m s leave information.
	*
	* @param ApproverEmails the approver emails of this l m s leave information
	*/
	@Override
	public void setApproverEmails(java.lang.String ApproverEmails) {
		_lmsLeaveInformation.setApproverEmails(ApproverEmails);
	}

	@Override
	public boolean isNew() {
		return _lmsLeaveInformation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsLeaveInformation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsLeaveInformation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsLeaveInformation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsLeaveInformation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsLeaveInformation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsLeaveInformation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsLeaveInformation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsLeaveInformation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsLeaveInformation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsLeaveInformation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSLeaveInformationWrapper((LMSLeaveInformation)_lmsLeaveInformation.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.LMSLeaveInformation lmsLeaveInformation) {
		return _lmsLeaveInformation.compareTo(lmsLeaveInformation);
	}

	@Override
	public int hashCode() {
		return _lmsLeaveInformation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSLeaveInformation> toCacheModel() {
		return _lmsLeaveInformation.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSLeaveInformation toEscapedModel() {
		return new LMSLeaveInformationWrapper(_lmsLeaveInformation.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSLeaveInformation toUnescapedModel() {
		return new LMSLeaveInformationWrapper(_lmsLeaveInformation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsLeaveInformation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsLeaveInformation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsLeaveInformation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSLeaveInformationWrapper)) {
			return false;
		}

		LMSLeaveInformationWrapper lmsLeaveInformationWrapper = (LMSLeaveInformationWrapper)obj;

		if (Validator.equals(_lmsLeaveInformation,
					lmsLeaveInformationWrapper._lmsLeaveInformation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSLeaveInformation getWrappedLMSLeaveInformation() {
		return _lmsLeaveInformation;
	}

	@Override
	public LMSLeaveInformation getWrappedModel() {
		return _lmsLeaveInformation;
	}

	@Override
	public void resetOriginalValues() {
		_lmsLeaveInformation.resetOriginalValues();
	}

	private LMSLeaveInformation _lmsLeaveInformation;
}