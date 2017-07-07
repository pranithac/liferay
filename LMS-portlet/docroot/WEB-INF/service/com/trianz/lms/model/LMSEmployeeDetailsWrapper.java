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
 * This class is a wrapper for {@link LMSEmployeeDetails}.
 * </p>
 *
 * @author
 * @see LMSEmployeeDetails
 * @generated
 */
public class LMSEmployeeDetailsWrapper implements LMSEmployeeDetails,
	ModelWrapper<LMSEmployeeDetails> {
	public LMSEmployeeDetailsWrapper(LMSEmployeeDetails lmsEmployeeDetails) {
		_lmsEmployeeDetails = lmsEmployeeDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSEmployeeDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSEmployeeDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("EmployeeName", getEmployeeName());
		attributes.put("EmployeeEmailID", getEmployeeEmailID());
		attributes.put("JoiningDate", getJoiningDate());
		attributes.put("SupervisorId", getSupervisorId());
		attributes.put("SupervisorName", getSupervisorName());
		attributes.put("SupervisorEmail", getSupervisorEmail());
		attributes.put("Location", getLocation());
		attributes.put("Region", getRegion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		String EmployeeName = (String)attributes.get("EmployeeName");

		if (EmployeeName != null) {
			setEmployeeName(EmployeeName);
		}

		String EmployeeEmailID = (String)attributes.get("EmployeeEmailID");

		if (EmployeeEmailID != null) {
			setEmployeeEmailID(EmployeeEmailID);
		}

		Date JoiningDate = (Date)attributes.get("JoiningDate");

		if (JoiningDate != null) {
			setJoiningDate(JoiningDate);
		}

		Integer SupervisorId = (Integer)attributes.get("SupervisorId");

		if (SupervisorId != null) {
			setSupervisorId(SupervisorId);
		}

		String SupervisorName = (String)attributes.get("SupervisorName");

		if (SupervisorName != null) {
			setSupervisorName(SupervisorName);
		}

		String SupervisorEmail = (String)attributes.get("SupervisorEmail");

		if (SupervisorEmail != null) {
			setSupervisorEmail(SupervisorEmail);
		}

		String Location = (String)attributes.get("Location");

		if (Location != null) {
			setLocation(Location);
		}

		String Region = (String)attributes.get("Region");

		if (Region != null) {
			setRegion(Region);
		}
	}

	/**
	* Returns the primary key of this l m s employee details.
	*
	* @return the primary key of this l m s employee details
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsEmployeeDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s employee details.
	*
	* @param primaryKey the primary key of this l m s employee details
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsEmployeeDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this l m s employee details.
	*
	* @return the employee ID of this l m s employee details
	*/
	@Override
	public int getEmployeeId() {
		return _lmsEmployeeDetails.getEmployeeId();
	}

	/**
	* Sets the employee ID of this l m s employee details.
	*
	* @param EmployeeId the employee ID of this l m s employee details
	*/
	@Override
	public void setEmployeeId(int EmployeeId) {
		_lmsEmployeeDetails.setEmployeeId(EmployeeId);
	}

	/**
	* Returns the employee name of this l m s employee details.
	*
	* @return the employee name of this l m s employee details
	*/
	@Override
	public java.lang.String getEmployeeName() {
		return _lmsEmployeeDetails.getEmployeeName();
	}

	/**
	* Sets the employee name of this l m s employee details.
	*
	* @param EmployeeName the employee name of this l m s employee details
	*/
	@Override
	public void setEmployeeName(java.lang.String EmployeeName) {
		_lmsEmployeeDetails.setEmployeeName(EmployeeName);
	}

	/**
	* Returns the employee email i d of this l m s employee details.
	*
	* @return the employee email i d of this l m s employee details
	*/
	@Override
	public java.lang.String getEmployeeEmailID() {
		return _lmsEmployeeDetails.getEmployeeEmailID();
	}

	/**
	* Sets the employee email i d of this l m s employee details.
	*
	* @param EmployeeEmailID the employee email i d of this l m s employee details
	*/
	@Override
	public void setEmployeeEmailID(java.lang.String EmployeeEmailID) {
		_lmsEmployeeDetails.setEmployeeEmailID(EmployeeEmailID);
	}

	/**
	* Returns the joining date of this l m s employee details.
	*
	* @return the joining date of this l m s employee details
	*/
	@Override
	public java.util.Date getJoiningDate() {
		return _lmsEmployeeDetails.getJoiningDate();
	}

	/**
	* Sets the joining date of this l m s employee details.
	*
	* @param JoiningDate the joining date of this l m s employee details
	*/
	@Override
	public void setJoiningDate(java.util.Date JoiningDate) {
		_lmsEmployeeDetails.setJoiningDate(JoiningDate);
	}

	/**
	* Returns the supervisor ID of this l m s employee details.
	*
	* @return the supervisor ID of this l m s employee details
	*/
	@Override
	public int getSupervisorId() {
		return _lmsEmployeeDetails.getSupervisorId();
	}

	/**
	* Sets the supervisor ID of this l m s employee details.
	*
	* @param SupervisorId the supervisor ID of this l m s employee details
	*/
	@Override
	public void setSupervisorId(int SupervisorId) {
		_lmsEmployeeDetails.setSupervisorId(SupervisorId);
	}

	/**
	* Returns the supervisor name of this l m s employee details.
	*
	* @return the supervisor name of this l m s employee details
	*/
	@Override
	public java.lang.String getSupervisorName() {
		return _lmsEmployeeDetails.getSupervisorName();
	}

	/**
	* Sets the supervisor name of this l m s employee details.
	*
	* @param SupervisorName the supervisor name of this l m s employee details
	*/
	@Override
	public void setSupervisorName(java.lang.String SupervisorName) {
		_lmsEmployeeDetails.setSupervisorName(SupervisorName);
	}

	/**
	* Returns the supervisor email of this l m s employee details.
	*
	* @return the supervisor email of this l m s employee details
	*/
	@Override
	public java.lang.String getSupervisorEmail() {
		return _lmsEmployeeDetails.getSupervisorEmail();
	}

	/**
	* Sets the supervisor email of this l m s employee details.
	*
	* @param SupervisorEmail the supervisor email of this l m s employee details
	*/
	@Override
	public void setSupervisorEmail(java.lang.String SupervisorEmail) {
		_lmsEmployeeDetails.setSupervisorEmail(SupervisorEmail);
	}

	/**
	* Returns the location of this l m s employee details.
	*
	* @return the location of this l m s employee details
	*/
	@Override
	public java.lang.String getLocation() {
		return _lmsEmployeeDetails.getLocation();
	}

	/**
	* Sets the location of this l m s employee details.
	*
	* @param Location the location of this l m s employee details
	*/
	@Override
	public void setLocation(java.lang.String Location) {
		_lmsEmployeeDetails.setLocation(Location);
	}

	/**
	* Returns the region of this l m s employee details.
	*
	* @return the region of this l m s employee details
	*/
	@Override
	public java.lang.String getRegion() {
		return _lmsEmployeeDetails.getRegion();
	}

	/**
	* Sets the region of this l m s employee details.
	*
	* @param Region the region of this l m s employee details
	*/
	@Override
	public void setRegion(java.lang.String Region) {
		_lmsEmployeeDetails.setRegion(Region);
	}

	@Override
	public boolean isNew() {
		return _lmsEmployeeDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsEmployeeDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsEmployeeDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsEmployeeDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsEmployeeDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsEmployeeDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsEmployeeDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsEmployeeDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsEmployeeDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsEmployeeDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsEmployeeDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSEmployeeDetailsWrapper((LMSEmployeeDetails)_lmsEmployeeDetails.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails) {
		return _lmsEmployeeDetails.compareTo(lmsEmployeeDetails);
	}

	@Override
	public int hashCode() {
		return _lmsEmployeeDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSEmployeeDetails> toCacheModel() {
		return _lmsEmployeeDetails.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSEmployeeDetails toEscapedModel() {
		return new LMSEmployeeDetailsWrapper(_lmsEmployeeDetails.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSEmployeeDetails toUnescapedModel() {
		return new LMSEmployeeDetailsWrapper(_lmsEmployeeDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsEmployeeDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsEmployeeDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsEmployeeDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSEmployeeDetailsWrapper)) {
			return false;
		}

		LMSEmployeeDetailsWrapper lmsEmployeeDetailsWrapper = (LMSEmployeeDetailsWrapper)obj;

		if (Validator.equals(_lmsEmployeeDetails,
					lmsEmployeeDetailsWrapper._lmsEmployeeDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSEmployeeDetails getWrappedLMSEmployeeDetails() {
		return _lmsEmployeeDetails;
	}

	@Override
	public LMSEmployeeDetails getWrappedModel() {
		return _lmsEmployeeDetails;
	}

	@Override
	public void resetOriginalValues() {
		_lmsEmployeeDetails.resetOriginalValues();
	}

	private LMSEmployeeDetails _lmsEmployeeDetails;
}