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
 * This class is a wrapper for {@link WFHManulPunch}.
 * </p>
 *
 * @author
 * @see WFHManulPunch
 * @generated
 */
public class WFHManulPunchWrapper implements WFHManulPunch,
	ModelWrapper<WFHManulPunch> {
	public WFHManulPunchWrapper(WFHManulPunch wfhManulPunch) {
		_wfhManulPunch = wfhManulPunch;
	}

	@Override
	public Class<?> getModelClass() {
		return WFHManulPunch.class;
	}

	@Override
	public String getModelClassName() {
		return WFHManulPunch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("WFHManualPunchId", getWFHManualPunchId());
		attributes.put("WFHID", getWFHID());
		attributes.put("Intime", getIntime());
		attributes.put("OutTime", getOutTime());
		attributes.put("CreatedBy", getCreatedBy());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("ModifiedBy", getModifiedBy());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("PUNCHDATE", getPUNCHDATE());
		attributes.put("EmployeeID", getEmployeeID());
		attributes.put("IsApproved", getIsApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer WFHManualPunchId = (Integer)attributes.get("WFHManualPunchId");

		if (WFHManualPunchId != null) {
			setWFHManualPunchId(WFHManualPunchId);
		}

		Integer WFHID = (Integer)attributes.get("WFHID");

		if (WFHID != null) {
			setWFHID(WFHID);
		}

		Date Intime = (Date)attributes.get("Intime");

		if (Intime != null) {
			setIntime(Intime);
		}

		Date OutTime = (Date)attributes.get("OutTime");

		if (OutTime != null) {
			setOutTime(OutTime);
		}

		String CreatedBy = (String)attributes.get("CreatedBy");

		if (CreatedBy != null) {
			setCreatedBy(CreatedBy);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		String ModifiedBy = (String)attributes.get("ModifiedBy");

		if (ModifiedBy != null) {
			setModifiedBy(ModifiedBy);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		Date PUNCHDATE = (Date)attributes.get("PUNCHDATE");

		if (PUNCHDATE != null) {
			setPUNCHDATE(PUNCHDATE);
		}

		Integer EmployeeID = (Integer)attributes.get("EmployeeID");

		if (EmployeeID != null) {
			setEmployeeID(EmployeeID);
		}

		Boolean IsApproved = (Boolean)attributes.get("IsApproved");

		if (IsApproved != null) {
			setIsApproved(IsApproved);
		}
	}

	/**
	* Returns the primary key of this w f h manul punch.
	*
	* @return the primary key of this w f h manul punch
	*/
	@Override
	public int getPrimaryKey() {
		return _wfhManulPunch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w f h manul punch.
	*
	* @param primaryKey the primary key of this w f h manul punch
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_wfhManulPunch.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the w f h manual punch ID of this w f h manul punch.
	*
	* @return the w f h manual punch ID of this w f h manul punch
	*/
	@Override
	public int getWFHManualPunchId() {
		return _wfhManulPunch.getWFHManualPunchId();
	}

	/**
	* Sets the w f h manual punch ID of this w f h manul punch.
	*
	* @param WFHManualPunchId the w f h manual punch ID of this w f h manul punch
	*/
	@Override
	public void setWFHManualPunchId(int WFHManualPunchId) {
		_wfhManulPunch.setWFHManualPunchId(WFHManualPunchId);
	}

	/**
	* Returns the w f h i d of this w f h manul punch.
	*
	* @return the w f h i d of this w f h manul punch
	*/
	@Override
	public int getWFHID() {
		return _wfhManulPunch.getWFHID();
	}

	/**
	* Sets the w f h i d of this w f h manul punch.
	*
	* @param WFHID the w f h i d of this w f h manul punch
	*/
	@Override
	public void setWFHID(int WFHID) {
		_wfhManulPunch.setWFHID(WFHID);
	}

	/**
	* Returns the intime of this w f h manul punch.
	*
	* @return the intime of this w f h manul punch
	*/
	@Override
	public java.util.Date getIntime() {
		return _wfhManulPunch.getIntime();
	}

	/**
	* Sets the intime of this w f h manul punch.
	*
	* @param Intime the intime of this w f h manul punch
	*/
	@Override
	public void setIntime(java.util.Date Intime) {
		_wfhManulPunch.setIntime(Intime);
	}

	/**
	* Returns the out time of this w f h manul punch.
	*
	* @return the out time of this w f h manul punch
	*/
	@Override
	public java.util.Date getOutTime() {
		return _wfhManulPunch.getOutTime();
	}

	/**
	* Sets the out time of this w f h manul punch.
	*
	* @param OutTime the out time of this w f h manul punch
	*/
	@Override
	public void setOutTime(java.util.Date OutTime) {
		_wfhManulPunch.setOutTime(OutTime);
	}

	/**
	* Returns the created by of this w f h manul punch.
	*
	* @return the created by of this w f h manul punch
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfhManulPunch.getCreatedBy();
	}

	/**
	* Sets the created by of this w f h manul punch.
	*
	* @param CreatedBy the created by of this w f h manul punch
	*/
	@Override
	public void setCreatedBy(java.lang.String CreatedBy) {
		_wfhManulPunch.setCreatedBy(CreatedBy);
	}

	/**
	* Returns the created date of this w f h manul punch.
	*
	* @return the created date of this w f h manul punch
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _wfhManulPunch.getCreatedDate();
	}

	/**
	* Sets the created date of this w f h manul punch.
	*
	* @param CreatedDate the created date of this w f h manul punch
	*/
	@Override
	public void setCreatedDate(java.util.Date CreatedDate) {
		_wfhManulPunch.setCreatedDate(CreatedDate);
	}

	/**
	* Returns the modified by of this w f h manul punch.
	*
	* @return the modified by of this w f h manul punch
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfhManulPunch.getModifiedBy();
	}

	/**
	* Sets the modified by of this w f h manul punch.
	*
	* @param ModifiedBy the modified by of this w f h manul punch
	*/
	@Override
	public void setModifiedBy(java.lang.String ModifiedBy) {
		_wfhManulPunch.setModifiedBy(ModifiedBy);
	}

	/**
	* Returns the modified date of this w f h manul punch.
	*
	* @return the modified date of this w f h manul punch
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _wfhManulPunch.getModifiedDate();
	}

	/**
	* Sets the modified date of this w f h manul punch.
	*
	* @param ModifiedDate the modified date of this w f h manul punch
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_wfhManulPunch.setModifiedDate(ModifiedDate);
	}

	/**
	* Returns the p u n c h d a t e of this w f h manul punch.
	*
	* @return the p u n c h d a t e of this w f h manul punch
	*/
	@Override
	public java.util.Date getPUNCHDATE() {
		return _wfhManulPunch.getPUNCHDATE();
	}

	/**
	* Sets the p u n c h d a t e of this w f h manul punch.
	*
	* @param PUNCHDATE the p u n c h d a t e of this w f h manul punch
	*/
	@Override
	public void setPUNCHDATE(java.util.Date PUNCHDATE) {
		_wfhManulPunch.setPUNCHDATE(PUNCHDATE);
	}

	/**
	* Returns the employee i d of this w f h manul punch.
	*
	* @return the employee i d of this w f h manul punch
	*/
	@Override
	public int getEmployeeID() {
		return _wfhManulPunch.getEmployeeID();
	}

	/**
	* Sets the employee i d of this w f h manul punch.
	*
	* @param EmployeeID the employee i d of this w f h manul punch
	*/
	@Override
	public void setEmployeeID(int EmployeeID) {
		_wfhManulPunch.setEmployeeID(EmployeeID);
	}

	/**
	* Returns the is approved of this w f h manul punch.
	*
	* @return the is approved of this w f h manul punch
	*/
	@Override
	public boolean getIsApproved() {
		return _wfhManulPunch.getIsApproved();
	}

	/**
	* Returns <code>true</code> if this w f h manul punch is is approved.
	*
	* @return <code>true</code> if this w f h manul punch is is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApproved() {
		return _wfhManulPunch.isIsApproved();
	}

	/**
	* Sets whether this w f h manul punch is is approved.
	*
	* @param IsApproved the is approved of this w f h manul punch
	*/
	@Override
	public void setIsApproved(boolean IsApproved) {
		_wfhManulPunch.setIsApproved(IsApproved);
	}

	@Override
	public boolean isNew() {
		return _wfhManulPunch.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_wfhManulPunch.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _wfhManulPunch.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfhManulPunch.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _wfhManulPunch.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _wfhManulPunch.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wfhManulPunch.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wfhManulPunch.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_wfhManulPunch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_wfhManulPunch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wfhManulPunch.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WFHManulPunchWrapper((WFHManulPunch)_wfhManulPunch.clone());
	}

	@Override
	public int compareTo(com.trianz.lms.model.WFHManulPunch wfhManulPunch) {
		return _wfhManulPunch.compareTo(wfhManulPunch);
	}

	@Override
	public int hashCode() {
		return _wfhManulPunch.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.WFHManulPunch> toCacheModel() {
		return _wfhManulPunch.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.WFHManulPunch toEscapedModel() {
		return new WFHManulPunchWrapper(_wfhManulPunch.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.WFHManulPunch toUnescapedModel() {
		return new WFHManulPunchWrapper(_wfhManulPunch.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wfhManulPunch.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfhManulPunch.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wfhManulPunch.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFHManulPunchWrapper)) {
			return false;
		}

		WFHManulPunchWrapper wfhManulPunchWrapper = (WFHManulPunchWrapper)obj;

		if (Validator.equals(_wfhManulPunch, wfhManulPunchWrapper._wfhManulPunch)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WFHManulPunch getWrappedWFHManulPunch() {
		return _wfhManulPunch;
	}

	@Override
	public WFHManulPunch getWrappedModel() {
		return _wfhManulPunch;
	}

	@Override
	public void resetOriginalValues() {
		_wfhManulPunch.resetOriginalValues();
	}

	private WFHManulPunch _wfhManulPunch;
}