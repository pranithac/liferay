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
 * This class is a wrapper for {@link securaxEmployeeHrs}.
 * </p>
 *
 * @author
 * @see securaxEmployeeHrs
 * @generated
 */
public class securaxEmployeeHrsWrapper implements securaxEmployeeHrs,
	ModelWrapper<securaxEmployeeHrs> {
	public securaxEmployeeHrsWrapper(securaxEmployeeHrs securaxEmployeeHrs) {
		_securaxEmployeeHrs = securaxEmployeeHrs;
	}

	@Override
	public Class<?> getModelClass() {
		return securaxEmployeeHrs.class;
	}

	@Override
	public String getModelClassName() {
		return securaxEmployeeHrs.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("PunchDate", getPunchDate());
		attributes.put("PunchInTime", getPunchInTime());
		attributes.put("PunchOutTime", getPunchOutTime());
		attributes.put("WorkHrsPerday", getWorkHrsPerday());
		attributes.put("Status", getStatus());
		attributes.put("OT", getOT());
		attributes.put("Created_By", getCreated_By());
		attributes.put("Created_Date", getCreated_Date());
		attributes.put("Modified_By", getModified_By());
		attributes.put("Modified_Date", getModified_Date());
		attributes.put("S_Id", getS_Id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		Date PunchDate = (Date)attributes.get("PunchDate");

		if (PunchDate != null) {
			setPunchDate(PunchDate);
		}

		Date PunchInTime = (Date)attributes.get("PunchInTime");

		if (PunchInTime != null) {
			setPunchInTime(PunchInTime);
		}

		Date PunchOutTime = (Date)attributes.get("PunchOutTime");

		if (PunchOutTime != null) {
			setPunchOutTime(PunchOutTime);
		}

		Date WorkHrsPerday = (Date)attributes.get("WorkHrsPerday");

		if (WorkHrsPerday != null) {
			setWorkHrsPerday(WorkHrsPerday);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date OT = (Date)attributes.get("OT");

		if (OT != null) {
			setOT(OT);
		}

		Integer Created_By = (Integer)attributes.get("Created_By");

		if (Created_By != null) {
			setCreated_By(Created_By);
		}

		Date Created_Date = (Date)attributes.get("Created_Date");

		if (Created_Date != null) {
			setCreated_Date(Created_Date);
		}

		Integer Modified_By = (Integer)attributes.get("Modified_By");

		if (Modified_By != null) {
			setModified_By(Modified_By);
		}

		Date Modified_Date = (Date)attributes.get("Modified_Date");

		if (Modified_Date != null) {
			setModified_Date(Modified_Date);
		}

		Integer S_Id = (Integer)attributes.get("S_Id");

		if (S_Id != null) {
			setS_Id(S_Id);
		}
	}

	/**
	* Returns the primary key of this securax employee hrs.
	*
	* @return the primary key of this securax employee hrs
	*/
	@Override
	public int getPrimaryKey() {
		return _securaxEmployeeHrs.getPrimaryKey();
	}

	/**
	* Sets the primary key of this securax employee hrs.
	*
	* @param primaryKey the primary key of this securax employee hrs
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_securaxEmployeeHrs.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this securax employee hrs.
	*
	* @return the employee ID of this securax employee hrs
	*/
	@Override
	public int getEmployeeId() {
		return _securaxEmployeeHrs.getEmployeeId();
	}

	/**
	* Sets the employee ID of this securax employee hrs.
	*
	* @param EmployeeId the employee ID of this securax employee hrs
	*/
	@Override
	public void setEmployeeId(int EmployeeId) {
		_securaxEmployeeHrs.setEmployeeId(EmployeeId);
	}

	/**
	* Returns the punch date of this securax employee hrs.
	*
	* @return the punch date of this securax employee hrs
	*/
	@Override
	public java.util.Date getPunchDate() {
		return _securaxEmployeeHrs.getPunchDate();
	}

	/**
	* Sets the punch date of this securax employee hrs.
	*
	* @param PunchDate the punch date of this securax employee hrs
	*/
	@Override
	public void setPunchDate(java.util.Date PunchDate) {
		_securaxEmployeeHrs.setPunchDate(PunchDate);
	}

	/**
	* Returns the punch in time of this securax employee hrs.
	*
	* @return the punch in time of this securax employee hrs
	*/
	@Override
	public java.util.Date getPunchInTime() {
		return _securaxEmployeeHrs.getPunchInTime();
	}

	/**
	* Sets the punch in time of this securax employee hrs.
	*
	* @param PunchInTime the punch in time of this securax employee hrs
	*/
	@Override
	public void setPunchInTime(java.util.Date PunchInTime) {
		_securaxEmployeeHrs.setPunchInTime(PunchInTime);
	}

	/**
	* Returns the punch out time of this securax employee hrs.
	*
	* @return the punch out time of this securax employee hrs
	*/
	@Override
	public java.util.Date getPunchOutTime() {
		return _securaxEmployeeHrs.getPunchOutTime();
	}

	/**
	* Sets the punch out time of this securax employee hrs.
	*
	* @param PunchOutTime the punch out time of this securax employee hrs
	*/
	@Override
	public void setPunchOutTime(java.util.Date PunchOutTime) {
		_securaxEmployeeHrs.setPunchOutTime(PunchOutTime);
	}

	/**
	* Returns the work hrs perday of this securax employee hrs.
	*
	* @return the work hrs perday of this securax employee hrs
	*/
	@Override
	public java.util.Date getWorkHrsPerday() {
		return _securaxEmployeeHrs.getWorkHrsPerday();
	}

	/**
	* Sets the work hrs perday of this securax employee hrs.
	*
	* @param WorkHrsPerday the work hrs perday of this securax employee hrs
	*/
	@Override
	public void setWorkHrsPerday(java.util.Date WorkHrsPerday) {
		_securaxEmployeeHrs.setWorkHrsPerday(WorkHrsPerday);
	}

	/**
	* Returns the status of this securax employee hrs.
	*
	* @return the status of this securax employee hrs
	*/
	@Override
	public java.lang.String getStatus() {
		return _securaxEmployeeHrs.getStatus();
	}

	/**
	* Sets the status of this securax employee hrs.
	*
	* @param Status the status of this securax employee hrs
	*/
	@Override
	public void setStatus(java.lang.String Status) {
		_securaxEmployeeHrs.setStatus(Status);
	}

	/**
	* Returns the o t of this securax employee hrs.
	*
	* @return the o t of this securax employee hrs
	*/
	@Override
	public java.util.Date getOT() {
		return _securaxEmployeeHrs.getOT();
	}

	/**
	* Sets the o t of this securax employee hrs.
	*
	* @param OT the o t of this securax employee hrs
	*/
	@Override
	public void setOT(java.util.Date OT) {
		_securaxEmployeeHrs.setOT(OT);
	}

	/**
	* Returns the created_ by of this securax employee hrs.
	*
	* @return the created_ by of this securax employee hrs
	*/
	@Override
	public int getCreated_By() {
		return _securaxEmployeeHrs.getCreated_By();
	}

	/**
	* Sets the created_ by of this securax employee hrs.
	*
	* @param Created_By the created_ by of this securax employee hrs
	*/
	@Override
	public void setCreated_By(int Created_By) {
		_securaxEmployeeHrs.setCreated_By(Created_By);
	}

	/**
	* Returns the created_ date of this securax employee hrs.
	*
	* @return the created_ date of this securax employee hrs
	*/
	@Override
	public java.util.Date getCreated_Date() {
		return _securaxEmployeeHrs.getCreated_Date();
	}

	/**
	* Sets the created_ date of this securax employee hrs.
	*
	* @param Created_Date the created_ date of this securax employee hrs
	*/
	@Override
	public void setCreated_Date(java.util.Date Created_Date) {
		_securaxEmployeeHrs.setCreated_Date(Created_Date);
	}

	/**
	* Returns the modified_ by of this securax employee hrs.
	*
	* @return the modified_ by of this securax employee hrs
	*/
	@Override
	public int getModified_By() {
		return _securaxEmployeeHrs.getModified_By();
	}

	/**
	* Sets the modified_ by of this securax employee hrs.
	*
	* @param Modified_By the modified_ by of this securax employee hrs
	*/
	@Override
	public void setModified_By(int Modified_By) {
		_securaxEmployeeHrs.setModified_By(Modified_By);
	}

	/**
	* Returns the modified_ date of this securax employee hrs.
	*
	* @return the modified_ date of this securax employee hrs
	*/
	@Override
	public java.util.Date getModified_Date() {
		return _securaxEmployeeHrs.getModified_Date();
	}

	/**
	* Sets the modified_ date of this securax employee hrs.
	*
	* @param Modified_Date the modified_ date of this securax employee hrs
	*/
	@Override
	public void setModified_Date(java.util.Date Modified_Date) {
		_securaxEmployeeHrs.setModified_Date(Modified_Date);
	}

	/**
	* Returns the s_ ID of this securax employee hrs.
	*
	* @return the s_ ID of this securax employee hrs
	*/
	@Override
	public int getS_Id() {
		return _securaxEmployeeHrs.getS_Id();
	}

	/**
	* Sets the s_ ID of this securax employee hrs.
	*
	* @param S_Id the s_ ID of this securax employee hrs
	*/
	@Override
	public void setS_Id(int S_Id) {
		_securaxEmployeeHrs.setS_Id(S_Id);
	}

	@Override
	public boolean isNew() {
		return _securaxEmployeeHrs.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_securaxEmployeeHrs.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _securaxEmployeeHrs.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_securaxEmployeeHrs.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _securaxEmployeeHrs.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _securaxEmployeeHrs.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_securaxEmployeeHrs.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _securaxEmployeeHrs.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_securaxEmployeeHrs.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_securaxEmployeeHrs.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_securaxEmployeeHrs.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new securaxEmployeeHrsWrapper((securaxEmployeeHrs)_securaxEmployeeHrs.clone());
	}

	@Override
	public int compareTo(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs) {
		return _securaxEmployeeHrs.compareTo(securaxEmployeeHrs);
	}

	@Override
	public int hashCode() {
		return _securaxEmployeeHrs.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.securaxEmployeeHrs> toCacheModel() {
		return _securaxEmployeeHrs.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.securaxEmployeeHrs toEscapedModel() {
		return new securaxEmployeeHrsWrapper(_securaxEmployeeHrs.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.securaxEmployeeHrs toUnescapedModel() {
		return new securaxEmployeeHrsWrapper(_securaxEmployeeHrs.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _securaxEmployeeHrs.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _securaxEmployeeHrs.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_securaxEmployeeHrs.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof securaxEmployeeHrsWrapper)) {
			return false;
		}

		securaxEmployeeHrsWrapper securaxEmployeeHrsWrapper = (securaxEmployeeHrsWrapper)obj;

		if (Validator.equals(_securaxEmployeeHrs,
					securaxEmployeeHrsWrapper._securaxEmployeeHrs)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public securaxEmployeeHrs getWrappedsecuraxEmployeeHrs() {
		return _securaxEmployeeHrs;
	}

	@Override
	public securaxEmployeeHrs getWrappedModel() {
		return _securaxEmployeeHrs;
	}

	@Override
	public void resetOriginalValues() {
		_securaxEmployeeHrs.resetOriginalValues();
	}

	private securaxEmployeeHrs _securaxEmployeeHrs;
}