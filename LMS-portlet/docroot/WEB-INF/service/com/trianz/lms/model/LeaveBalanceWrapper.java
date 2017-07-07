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
 * This class is a wrapper for {@link LeaveBalance}.
 * </p>
 *
 * @author
 * @see LeaveBalance
 * @generated
 */
public class LeaveBalanceWrapper implements LeaveBalance,
	ModelWrapper<LeaveBalance> {
	public LeaveBalanceWrapper(LeaveBalance leaveBalance) {
		_leaveBalance = leaveBalance;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveBalance.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveBalance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("ELBalance", getELBalance());
		attributes.put("CLBalance", getCLBalance());
		attributes.put("CompOffLeaveBalance", getCompOffLeaveBalance());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		Double ELBalance = (Double)attributes.get("ELBalance");

		if (ELBalance != null) {
			setELBalance(ELBalance);
		}

		Double CLBalance = (Double)attributes.get("CLBalance");

		if (CLBalance != null) {
			setCLBalance(CLBalance);
		}

		Double CompOffLeaveBalance = (Double)attributes.get(
				"CompOffLeaveBalance");

		if (CompOffLeaveBalance != null) {
			setCompOffLeaveBalance(CompOffLeaveBalance);
		}
	}

	/**
	* Returns the primary key of this leave balance.
	*
	* @return the primary key of this leave balance
	*/
	@Override
	public int getPrimaryKey() {
		return _leaveBalance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave balance.
	*
	* @param primaryKey the primary key of this leave balance
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_leaveBalance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this leave balance.
	*
	* @return the employee ID of this leave balance
	*/
	@Override
	public int getEmployeeId() {
		return _leaveBalance.getEmployeeId();
	}

	/**
	* Sets the employee ID of this leave balance.
	*
	* @param EmployeeId the employee ID of this leave balance
	*/
	@Override
	public void setEmployeeId(int EmployeeId) {
		_leaveBalance.setEmployeeId(EmployeeId);
	}

	/**
	* Returns the e l balance of this leave balance.
	*
	* @return the e l balance of this leave balance
	*/
	@Override
	public double getELBalance() {
		return _leaveBalance.getELBalance();
	}

	/**
	* Sets the e l balance of this leave balance.
	*
	* @param ELBalance the e l balance of this leave balance
	*/
	@Override
	public void setELBalance(double ELBalance) {
		_leaveBalance.setELBalance(ELBalance);
	}

	/**
	* Returns the c l balance of this leave balance.
	*
	* @return the c l balance of this leave balance
	*/
	@Override
	public double getCLBalance() {
		return _leaveBalance.getCLBalance();
	}

	/**
	* Sets the c l balance of this leave balance.
	*
	* @param CLBalance the c l balance of this leave balance
	*/
	@Override
	public void setCLBalance(double CLBalance) {
		_leaveBalance.setCLBalance(CLBalance);
	}

	/**
	* Returns the comp off leave balance of this leave balance.
	*
	* @return the comp off leave balance of this leave balance
	*/
	@Override
	public double getCompOffLeaveBalance() {
		return _leaveBalance.getCompOffLeaveBalance();
	}

	/**
	* Sets the comp off leave balance of this leave balance.
	*
	* @param CompOffLeaveBalance the comp off leave balance of this leave balance
	*/
	@Override
	public void setCompOffLeaveBalance(double CompOffLeaveBalance) {
		_leaveBalance.setCompOffLeaveBalance(CompOffLeaveBalance);
	}

	@Override
	public boolean isNew() {
		return _leaveBalance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveBalance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveBalance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveBalance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveBalance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveBalance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveBalance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveBalance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveBalance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveBalance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveBalance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveBalanceWrapper((LeaveBalance)_leaveBalance.clone());
	}

	@Override
	public int compareTo(com.trianz.lms.model.LeaveBalance leaveBalance) {
		return _leaveBalance.compareTo(leaveBalance);
	}

	@Override
	public int hashCode() {
		return _leaveBalance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LeaveBalance> toCacheModel() {
		return _leaveBalance.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LeaveBalance toEscapedModel() {
		return new LeaveBalanceWrapper(_leaveBalance.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LeaveBalance toUnescapedModel() {
		return new LeaveBalanceWrapper(_leaveBalance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveBalance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveBalance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveBalance.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveBalanceWrapper)) {
			return false;
		}

		LeaveBalanceWrapper leaveBalanceWrapper = (LeaveBalanceWrapper)obj;

		if (Validator.equals(_leaveBalance, leaveBalanceWrapper._leaveBalance)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveBalance getWrappedLeaveBalance() {
		return _leaveBalance;
	}

	@Override
	public LeaveBalance getWrappedModel() {
		return _leaveBalance;
	}

	@Override
	public void resetOriginalValues() {
		_leaveBalance.resetOriginalValues();
	}

	private LeaveBalance _leaveBalance;
}