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
 * This class is a wrapper for {@link LMSLeaveType}.
 * </p>
 *
 * @author
 * @see LMSLeaveType
 * @generated
 */
public class LMSLeaveTypeWrapper implements LMSLeaveType,
	ModelWrapper<LMSLeaveType> {
	public LMSLeaveTypeWrapper(LMSLeaveType lmsLeaveType) {
		_lmsLeaveType = lmsLeaveType;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSLeaveType.class;
	}

	@Override
	public String getModelClassName() {
		return LMSLeaveType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LeaveTypeCode", getLeaveTypeCode());
		attributes.put("LeaveTypeName", getLeaveTypeName());
		attributes.put("CountriesApplicable", getCountriesApplicable());
		attributes.put("MonthlyAccrual", getMonthlyAccrual());
		attributes.put("AccrualValue", getAccrualValue());
		attributes.put("CreditReset", getCreditReset());
		attributes.put("ResetInterval", getResetInterval());
		attributes.put("ResetDay", getResetDay());
		attributes.put("ExcludeWeekEnds", getExcludeWeekEnds());
		attributes.put("ExcludeHolidays", getExcludeHolidays());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer LeaveTypeCode = (Integer)attributes.get("LeaveTypeCode");

		if (LeaveTypeCode != null) {
			setLeaveTypeCode(LeaveTypeCode);
		}

		String LeaveTypeName = (String)attributes.get("LeaveTypeName");

		if (LeaveTypeName != null) {
			setLeaveTypeName(LeaveTypeName);
		}

		String CountriesApplicable = (String)attributes.get(
				"CountriesApplicable");

		if (CountriesApplicable != null) {
			setCountriesApplicable(CountriesApplicable);
		}

		String MonthlyAccrual = (String)attributes.get("MonthlyAccrual");

		if (MonthlyAccrual != null) {
			setMonthlyAccrual(MonthlyAccrual);
		}

		Double AccrualValue = (Double)attributes.get("AccrualValue");

		if (AccrualValue != null) {
			setAccrualValue(AccrualValue);
		}

		String CreditReset = (String)attributes.get("CreditReset");

		if (CreditReset != null) {
			setCreditReset(CreditReset);
		}

		String ResetInterval = (String)attributes.get("ResetInterval");

		if (ResetInterval != null) {
			setResetInterval(ResetInterval);
		}

		Integer ResetDay = (Integer)attributes.get("ResetDay");

		if (ResetDay != null) {
			setResetDay(ResetDay);
		}

		String ExcludeWeekEnds = (String)attributes.get("ExcludeWeekEnds");

		if (ExcludeWeekEnds != null) {
			setExcludeWeekEnds(ExcludeWeekEnds);
		}

		String ExcludeHolidays = (String)attributes.get("ExcludeHolidays");

		if (ExcludeHolidays != null) {
			setExcludeHolidays(ExcludeHolidays);
		}
	}

	/**
	* Returns the primary key of this l m s leave type.
	*
	* @return the primary key of this l m s leave type
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsLeaveType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s leave type.
	*
	* @param primaryKey the primary key of this l m s leave type
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsLeaveType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave type code of this l m s leave type.
	*
	* @return the leave type code of this l m s leave type
	*/
	@Override
	public int getLeaveTypeCode() {
		return _lmsLeaveType.getLeaveTypeCode();
	}

	/**
	* Sets the leave type code of this l m s leave type.
	*
	* @param LeaveTypeCode the leave type code of this l m s leave type
	*/
	@Override
	public void setLeaveTypeCode(int LeaveTypeCode) {
		_lmsLeaveType.setLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the leave type name of this l m s leave type.
	*
	* @return the leave type name of this l m s leave type
	*/
	@Override
	public java.lang.String getLeaveTypeName() {
		return _lmsLeaveType.getLeaveTypeName();
	}

	/**
	* Sets the leave type name of this l m s leave type.
	*
	* @param LeaveTypeName the leave type name of this l m s leave type
	*/
	@Override
	public void setLeaveTypeName(java.lang.String LeaveTypeName) {
		_lmsLeaveType.setLeaveTypeName(LeaveTypeName);
	}

	/**
	* Returns the countries applicable of this l m s leave type.
	*
	* @return the countries applicable of this l m s leave type
	*/
	@Override
	public java.lang.String getCountriesApplicable() {
		return _lmsLeaveType.getCountriesApplicable();
	}

	/**
	* Sets the countries applicable of this l m s leave type.
	*
	* @param CountriesApplicable the countries applicable of this l m s leave type
	*/
	@Override
	public void setCountriesApplicable(java.lang.String CountriesApplicable) {
		_lmsLeaveType.setCountriesApplicable(CountriesApplicable);
	}

	/**
	* Returns the monthly accrual of this l m s leave type.
	*
	* @return the monthly accrual of this l m s leave type
	*/
	@Override
	public java.lang.String getMonthlyAccrual() {
		return _lmsLeaveType.getMonthlyAccrual();
	}

	/**
	* Sets the monthly accrual of this l m s leave type.
	*
	* @param MonthlyAccrual the monthly accrual of this l m s leave type
	*/
	@Override
	public void setMonthlyAccrual(java.lang.String MonthlyAccrual) {
		_lmsLeaveType.setMonthlyAccrual(MonthlyAccrual);
	}

	/**
	* Returns the accrual value of this l m s leave type.
	*
	* @return the accrual value of this l m s leave type
	*/
	@Override
	public double getAccrualValue() {
		return _lmsLeaveType.getAccrualValue();
	}

	/**
	* Sets the accrual value of this l m s leave type.
	*
	* @param AccrualValue the accrual value of this l m s leave type
	*/
	@Override
	public void setAccrualValue(double AccrualValue) {
		_lmsLeaveType.setAccrualValue(AccrualValue);
	}

	/**
	* Returns the credit reset of this l m s leave type.
	*
	* @return the credit reset of this l m s leave type
	*/
	@Override
	public java.lang.String getCreditReset() {
		return _lmsLeaveType.getCreditReset();
	}

	/**
	* Sets the credit reset of this l m s leave type.
	*
	* @param CreditReset the credit reset of this l m s leave type
	*/
	@Override
	public void setCreditReset(java.lang.String CreditReset) {
		_lmsLeaveType.setCreditReset(CreditReset);
	}

	/**
	* Returns the reset interval of this l m s leave type.
	*
	* @return the reset interval of this l m s leave type
	*/
	@Override
	public java.lang.String getResetInterval() {
		return _lmsLeaveType.getResetInterval();
	}

	/**
	* Sets the reset interval of this l m s leave type.
	*
	* @param ResetInterval the reset interval of this l m s leave type
	*/
	@Override
	public void setResetInterval(java.lang.String ResetInterval) {
		_lmsLeaveType.setResetInterval(ResetInterval);
	}

	/**
	* Returns the reset day of this l m s leave type.
	*
	* @return the reset day of this l m s leave type
	*/
	@Override
	public int getResetDay() {
		return _lmsLeaveType.getResetDay();
	}

	/**
	* Sets the reset day of this l m s leave type.
	*
	* @param ResetDay the reset day of this l m s leave type
	*/
	@Override
	public void setResetDay(int ResetDay) {
		_lmsLeaveType.setResetDay(ResetDay);
	}

	/**
	* Returns the exclude week ends of this l m s leave type.
	*
	* @return the exclude week ends of this l m s leave type
	*/
	@Override
	public java.lang.String getExcludeWeekEnds() {
		return _lmsLeaveType.getExcludeWeekEnds();
	}

	/**
	* Sets the exclude week ends of this l m s leave type.
	*
	* @param ExcludeWeekEnds the exclude week ends of this l m s leave type
	*/
	@Override
	public void setExcludeWeekEnds(java.lang.String ExcludeWeekEnds) {
		_lmsLeaveType.setExcludeWeekEnds(ExcludeWeekEnds);
	}

	/**
	* Returns the exclude holidays of this l m s leave type.
	*
	* @return the exclude holidays of this l m s leave type
	*/
	@Override
	public java.lang.String getExcludeHolidays() {
		return _lmsLeaveType.getExcludeHolidays();
	}

	/**
	* Sets the exclude holidays of this l m s leave type.
	*
	* @param ExcludeHolidays the exclude holidays of this l m s leave type
	*/
	@Override
	public void setExcludeHolidays(java.lang.String ExcludeHolidays) {
		_lmsLeaveType.setExcludeHolidays(ExcludeHolidays);
	}

	@Override
	public boolean isNew() {
		return _lmsLeaveType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsLeaveType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsLeaveType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsLeaveType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsLeaveType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsLeaveType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsLeaveType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsLeaveType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsLeaveType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsLeaveType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsLeaveType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSLeaveTypeWrapper((LMSLeaveType)_lmsLeaveType.clone());
	}

	@Override
	public int compareTo(com.trianz.lms.model.LMSLeaveType lmsLeaveType) {
		return _lmsLeaveType.compareTo(lmsLeaveType);
	}

	@Override
	public int hashCode() {
		return _lmsLeaveType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSLeaveType> toCacheModel() {
		return _lmsLeaveType.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSLeaveType toEscapedModel() {
		return new LMSLeaveTypeWrapper(_lmsLeaveType.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSLeaveType toUnescapedModel() {
		return new LMSLeaveTypeWrapper(_lmsLeaveType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsLeaveType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsLeaveType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsLeaveType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSLeaveTypeWrapper)) {
			return false;
		}

		LMSLeaveTypeWrapper lmsLeaveTypeWrapper = (LMSLeaveTypeWrapper)obj;

		if (Validator.equals(_lmsLeaveType, lmsLeaveTypeWrapper._lmsLeaveType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSLeaveType getWrappedLMSLeaveType() {
		return _lmsLeaveType;
	}

	@Override
	public LMSLeaveType getWrappedModel() {
		return _lmsLeaveType;
	}

	@Override
	public void resetOriginalValues() {
		_lmsLeaveType.resetOriginalValues();
	}

	private LMSLeaveType _lmsLeaveType;
}