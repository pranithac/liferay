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
 * This class is a wrapper for {@link LMSCompOffLeaveDetails}.
 * </p>
 *
 * @author
 * @see LMSCompOffLeaveDetails
 * @generated
 */
public class LMSCompOffLeaveDetailsWrapper implements LMSCompOffLeaveDetails,
	ModelWrapper<LMSCompOffLeaveDetails> {
	public LMSCompOffLeaveDetailsWrapper(
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		_lmsCompOffLeaveDetails = lmsCompOffLeaveDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSCompOffLeaveDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSCompOffLeaveDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ApprovedBy", getApprovedBy());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("EmployeeID", getEmployeeID());
		attributes.put("Status", getStatus());
		attributes.put("CompoffDate", getCompoffDate());
		attributes.put("CompOffId", getCompOffId());
		attributes.put("ApproverEmployeeID", getApproverEmployeeID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String ApprovedBy = (String)attributes.get("ApprovedBy");

		if (ApprovedBy != null) {
			setApprovedBy(ApprovedBy);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		Integer EmployeeID = (Integer)attributes.get("EmployeeID");

		if (EmployeeID != null) {
			setEmployeeID(EmployeeID);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date CompoffDate = (Date)attributes.get("CompoffDate");

		if (CompoffDate != null) {
			setCompoffDate(CompoffDate);
		}

		Integer CompOffId = (Integer)attributes.get("CompOffId");

		if (CompOffId != null) {
			setCompOffId(CompOffId);
		}

		Integer ApproverEmployeeID = (Integer)attributes.get(
				"ApproverEmployeeID");

		if (ApproverEmployeeID != null) {
			setApproverEmployeeID(ApproverEmployeeID);
		}
	}

	/**
	* Returns the primary key of this l m s comp off leave details.
	*
	* @return the primary key of this l m s comp off leave details
	*/
	@Override
	public com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK getPrimaryKey() {
		return _lmsCompOffLeaveDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s comp off leave details.
	*
	* @param primaryKey the primary key of this l m s comp off leave details
	*/
	@Override
	public void setPrimaryKey(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK primaryKey) {
		_lmsCompOffLeaveDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the approved by of this l m s comp off leave details.
	*
	* @return the approved by of this l m s comp off leave details
	*/
	@Override
	public java.lang.String getApprovedBy() {
		return _lmsCompOffLeaveDetails.getApprovedBy();
	}

	/**
	* Sets the approved by of this l m s comp off leave details.
	*
	* @param ApprovedBy the approved by of this l m s comp off leave details
	*/
	@Override
	public void setApprovedBy(java.lang.String ApprovedBy) {
		_lmsCompOffLeaveDetails.setApprovedBy(ApprovedBy);
	}

	/**
	* Returns the created date of this l m s comp off leave details.
	*
	* @return the created date of this l m s comp off leave details
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _lmsCompOffLeaveDetails.getCreatedDate();
	}

	/**
	* Sets the created date of this l m s comp off leave details.
	*
	* @param CreatedDate the created date of this l m s comp off leave details
	*/
	@Override
	public void setCreatedDate(java.util.Date CreatedDate) {
		_lmsCompOffLeaveDetails.setCreatedDate(CreatedDate);
	}

	/**
	* Returns the employee i d of this l m s comp off leave details.
	*
	* @return the employee i d of this l m s comp off leave details
	*/
	@Override
	public int getEmployeeID() {
		return _lmsCompOffLeaveDetails.getEmployeeID();
	}

	/**
	* Sets the employee i d of this l m s comp off leave details.
	*
	* @param EmployeeID the employee i d of this l m s comp off leave details
	*/
	@Override
	public void setEmployeeID(int EmployeeID) {
		_lmsCompOffLeaveDetails.setEmployeeID(EmployeeID);
	}

	/**
	* Returns the status of this l m s comp off leave details.
	*
	* @return the status of this l m s comp off leave details
	*/
	@Override
	public java.lang.String getStatus() {
		return _lmsCompOffLeaveDetails.getStatus();
	}

	/**
	* Sets the status of this l m s comp off leave details.
	*
	* @param Status the status of this l m s comp off leave details
	*/
	@Override
	public void setStatus(java.lang.String Status) {
		_lmsCompOffLeaveDetails.setStatus(Status);
	}

	/**
	* Returns the compoff date of this l m s comp off leave details.
	*
	* @return the compoff date of this l m s comp off leave details
	*/
	@Override
	public java.util.Date getCompoffDate() {
		return _lmsCompOffLeaveDetails.getCompoffDate();
	}

	/**
	* Sets the compoff date of this l m s comp off leave details.
	*
	* @param CompoffDate the compoff date of this l m s comp off leave details
	*/
	@Override
	public void setCompoffDate(java.util.Date CompoffDate) {
		_lmsCompOffLeaveDetails.setCompoffDate(CompoffDate);
	}

	/**
	* Returns the comp off ID of this l m s comp off leave details.
	*
	* @return the comp off ID of this l m s comp off leave details
	*/
	@Override
	public int getCompOffId() {
		return _lmsCompOffLeaveDetails.getCompOffId();
	}

	/**
	* Sets the comp off ID of this l m s comp off leave details.
	*
	* @param CompOffId the comp off ID of this l m s comp off leave details
	*/
	@Override
	public void setCompOffId(int CompOffId) {
		_lmsCompOffLeaveDetails.setCompOffId(CompOffId);
	}

	/**
	* Returns the approver employee i d of this l m s comp off leave details.
	*
	* @return the approver employee i d of this l m s comp off leave details
	*/
	@Override
	public int getApproverEmployeeID() {
		return _lmsCompOffLeaveDetails.getApproverEmployeeID();
	}

	/**
	* Sets the approver employee i d of this l m s comp off leave details.
	*
	* @param ApproverEmployeeID the approver employee i d of this l m s comp off leave details
	*/
	@Override
	public void setApproverEmployeeID(int ApproverEmployeeID) {
		_lmsCompOffLeaveDetails.setApproverEmployeeID(ApproverEmployeeID);
	}

	@Override
	public boolean isNew() {
		return _lmsCompOffLeaveDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsCompOffLeaveDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsCompOffLeaveDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsCompOffLeaveDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsCompOffLeaveDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsCompOffLeaveDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsCompOffLeaveDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsCompOffLeaveDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsCompOffLeaveDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsCompOffLeaveDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsCompOffLeaveDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSCompOffLeaveDetailsWrapper((LMSCompOffLeaveDetails)_lmsCompOffLeaveDetails.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		return _lmsCompOffLeaveDetails.compareTo(lmsCompOffLeaveDetails);
	}

	@Override
	public int hashCode() {
		return _lmsCompOffLeaveDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSCompOffLeaveDetails> toCacheModel() {
		return _lmsCompOffLeaveDetails.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails toEscapedModel() {
		return new LMSCompOffLeaveDetailsWrapper(_lmsCompOffLeaveDetails.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails toUnescapedModel() {
		return new LMSCompOffLeaveDetailsWrapper(_lmsCompOffLeaveDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsCompOffLeaveDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsCompOffLeaveDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsCompOffLeaveDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSCompOffLeaveDetailsWrapper)) {
			return false;
		}

		LMSCompOffLeaveDetailsWrapper lmsCompOffLeaveDetailsWrapper = (LMSCompOffLeaveDetailsWrapper)obj;

		if (Validator.equals(_lmsCompOffLeaveDetails,
					lmsCompOffLeaveDetailsWrapper._lmsCompOffLeaveDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSCompOffLeaveDetails getWrappedLMSCompOffLeaveDetails() {
		return _lmsCompOffLeaveDetails;
	}

	@Override
	public LMSCompOffLeaveDetails getWrappedModel() {
		return _lmsCompOffLeaveDetails;
	}

	@Override
	public void resetOriginalValues() {
		_lmsCompOffLeaveDetails.resetOriginalValues();
	}

	private LMSCompOffLeaveDetails _lmsCompOffLeaveDetails;
}