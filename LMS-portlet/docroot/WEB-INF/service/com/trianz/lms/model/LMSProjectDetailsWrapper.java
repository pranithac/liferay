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
 * This class is a wrapper for {@link LMSProjectDetails}.
 * </p>
 *
 * @author
 * @see LMSProjectDetails
 * @generated
 */
public class LMSProjectDetailsWrapper implements LMSProjectDetails,
	ModelWrapper<LMSProjectDetails> {
	public LMSProjectDetailsWrapper(LMSProjectDetails lmsProjectDetails) {
		_lmsProjectDetails = lmsProjectDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSProjectDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSProjectDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("ProjectCode", getProjectCode());
		attributes.put("ProjectName", getProjectName());
		attributes.put("ApproverName", getApproverName());
		attributes.put("ApproverID", getApproverID());
		attributes.put("ApproverEmail", getApproverEmail());
		attributes.put("AssignmentID", getAssignmentID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		String ProjectCode = (String)attributes.get("ProjectCode");

		if (ProjectCode != null) {
			setProjectCode(ProjectCode);
		}

		String ProjectName = (String)attributes.get("ProjectName");

		if (ProjectName != null) {
			setProjectName(ProjectName);
		}

		String ApproverName = (String)attributes.get("ApproverName");

		if (ApproverName != null) {
			setApproverName(ApproverName);
		}

		Integer ApproverID = (Integer)attributes.get("ApproverID");

		if (ApproverID != null) {
			setApproverID(ApproverID);
		}

		String ApproverEmail = (String)attributes.get("ApproverEmail");

		if (ApproverEmail != null) {
			setApproverEmail(ApproverEmail);
		}

		Integer AssignmentID = (Integer)attributes.get("AssignmentID");

		if (AssignmentID != null) {
			setAssignmentID(AssignmentID);
		}
	}

	/**
	* Returns the primary key of this l m s project details.
	*
	* @return the primary key of this l m s project details
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsProjectDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s project details.
	*
	* @param primaryKey the primary key of this l m s project details
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsProjectDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this l m s project details.
	*
	* @return the employee ID of this l m s project details
	*/
	@Override
	public int getEmployeeId() {
		return _lmsProjectDetails.getEmployeeId();
	}

	/**
	* Sets the employee ID of this l m s project details.
	*
	* @param EmployeeId the employee ID of this l m s project details
	*/
	@Override
	public void setEmployeeId(int EmployeeId) {
		_lmsProjectDetails.setEmployeeId(EmployeeId);
	}

	/**
	* Returns the project code of this l m s project details.
	*
	* @return the project code of this l m s project details
	*/
	@Override
	public java.lang.String getProjectCode() {
		return _lmsProjectDetails.getProjectCode();
	}

	/**
	* Sets the project code of this l m s project details.
	*
	* @param ProjectCode the project code of this l m s project details
	*/
	@Override
	public void setProjectCode(java.lang.String ProjectCode) {
		_lmsProjectDetails.setProjectCode(ProjectCode);
	}

	/**
	* Returns the project name of this l m s project details.
	*
	* @return the project name of this l m s project details
	*/
	@Override
	public java.lang.String getProjectName() {
		return _lmsProjectDetails.getProjectName();
	}

	/**
	* Sets the project name of this l m s project details.
	*
	* @param ProjectName the project name of this l m s project details
	*/
	@Override
	public void setProjectName(java.lang.String ProjectName) {
		_lmsProjectDetails.setProjectName(ProjectName);
	}

	/**
	* Returns the approver name of this l m s project details.
	*
	* @return the approver name of this l m s project details
	*/
	@Override
	public java.lang.String getApproverName() {
		return _lmsProjectDetails.getApproverName();
	}

	/**
	* Sets the approver name of this l m s project details.
	*
	* @param ApproverName the approver name of this l m s project details
	*/
	@Override
	public void setApproverName(java.lang.String ApproverName) {
		_lmsProjectDetails.setApproverName(ApproverName);
	}

	/**
	* Returns the approver i d of this l m s project details.
	*
	* @return the approver i d of this l m s project details
	*/
	@Override
	public int getApproverID() {
		return _lmsProjectDetails.getApproverID();
	}

	/**
	* Sets the approver i d of this l m s project details.
	*
	* @param ApproverID the approver i d of this l m s project details
	*/
	@Override
	public void setApproverID(int ApproverID) {
		_lmsProjectDetails.setApproverID(ApproverID);
	}

	/**
	* Returns the approver email of this l m s project details.
	*
	* @return the approver email of this l m s project details
	*/
	@Override
	public java.lang.String getApproverEmail() {
		return _lmsProjectDetails.getApproverEmail();
	}

	/**
	* Sets the approver email of this l m s project details.
	*
	* @param ApproverEmail the approver email of this l m s project details
	*/
	@Override
	public void setApproverEmail(java.lang.String ApproverEmail) {
		_lmsProjectDetails.setApproverEmail(ApproverEmail);
	}

	/**
	* Returns the assignment i d of this l m s project details.
	*
	* @return the assignment i d of this l m s project details
	*/
	@Override
	public int getAssignmentID() {
		return _lmsProjectDetails.getAssignmentID();
	}

	/**
	* Sets the assignment i d of this l m s project details.
	*
	* @param AssignmentID the assignment i d of this l m s project details
	*/
	@Override
	public void setAssignmentID(int AssignmentID) {
		_lmsProjectDetails.setAssignmentID(AssignmentID);
	}

	@Override
	public boolean isNew() {
		return _lmsProjectDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsProjectDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsProjectDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsProjectDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsProjectDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsProjectDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsProjectDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsProjectDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsProjectDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsProjectDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsProjectDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSProjectDetailsWrapper((LMSProjectDetails)_lmsProjectDetails.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails) {
		return _lmsProjectDetails.compareTo(lmsProjectDetails);
	}

	@Override
	public int hashCode() {
		return _lmsProjectDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSProjectDetails> toCacheModel() {
		return _lmsProjectDetails.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSProjectDetails toEscapedModel() {
		return new LMSProjectDetailsWrapper(_lmsProjectDetails.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSProjectDetails toUnescapedModel() {
		return new LMSProjectDetailsWrapper(_lmsProjectDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsProjectDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsProjectDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsProjectDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSProjectDetailsWrapper)) {
			return false;
		}

		LMSProjectDetailsWrapper lmsProjectDetailsWrapper = (LMSProjectDetailsWrapper)obj;

		if (Validator.equals(_lmsProjectDetails,
					lmsProjectDetailsWrapper._lmsProjectDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSProjectDetails getWrappedLMSProjectDetails() {
		return _lmsProjectDetails;
	}

	@Override
	public LMSProjectDetails getWrappedModel() {
		return _lmsProjectDetails;
	}

	@Override
	public void resetOriginalValues() {
		_lmsProjectDetails.resetOriginalValues();
	}

	private LMSProjectDetails _lmsProjectDetails;
}