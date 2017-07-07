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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSLeaveTypeServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSLeaveTypeServiceSoap
 * @generated
 */
public class LMSLeaveTypeSoap implements Serializable {
	public static LMSLeaveTypeSoap toSoapModel(LMSLeaveType model) {
		LMSLeaveTypeSoap soapModel = new LMSLeaveTypeSoap();

		soapModel.setLeaveTypeCode(model.getLeaveTypeCode());
		soapModel.setLeaveTypeName(model.getLeaveTypeName());
		soapModel.setCountriesApplicable(model.getCountriesApplicable());
		soapModel.setMonthlyAccrual(model.getMonthlyAccrual());
		soapModel.setAccrualValue(model.getAccrualValue());
		soapModel.setCreditReset(model.getCreditReset());
		soapModel.setResetInterval(model.getResetInterval());
		soapModel.setResetDay(model.getResetDay());
		soapModel.setExcludeWeekEnds(model.getExcludeWeekEnds());
		soapModel.setExcludeHolidays(model.getExcludeHolidays());

		return soapModel;
	}

	public static LMSLeaveTypeSoap[] toSoapModels(LMSLeaveType[] models) {
		LMSLeaveTypeSoap[] soapModels = new LMSLeaveTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSLeaveTypeSoap[][] toSoapModels(LMSLeaveType[][] models) {
		LMSLeaveTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSLeaveTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSLeaveTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSLeaveTypeSoap[] toSoapModels(List<LMSLeaveType> models) {
		List<LMSLeaveTypeSoap> soapModels = new ArrayList<LMSLeaveTypeSoap>(models.size());

		for (LMSLeaveType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSLeaveTypeSoap[soapModels.size()]);
	}

	public LMSLeaveTypeSoap() {
	}

	public int getPrimaryKey() {
		return _LeaveTypeCode;
	}

	public void setPrimaryKey(int pk) {
		setLeaveTypeCode(pk);
	}

	public int getLeaveTypeCode() {
		return _LeaveTypeCode;
	}

	public void setLeaveTypeCode(int LeaveTypeCode) {
		_LeaveTypeCode = LeaveTypeCode;
	}

	public String getLeaveTypeName() {
		return _LeaveTypeName;
	}

	public void setLeaveTypeName(String LeaveTypeName) {
		_LeaveTypeName = LeaveTypeName;
	}

	public String getCountriesApplicable() {
		return _CountriesApplicable;
	}

	public void setCountriesApplicable(String CountriesApplicable) {
		_CountriesApplicable = CountriesApplicable;
	}

	public String getMonthlyAccrual() {
		return _MonthlyAccrual;
	}

	public void setMonthlyAccrual(String MonthlyAccrual) {
		_MonthlyAccrual = MonthlyAccrual;
	}

	public double getAccrualValue() {
		return _AccrualValue;
	}

	public void setAccrualValue(double AccrualValue) {
		_AccrualValue = AccrualValue;
	}

	public String getCreditReset() {
		return _CreditReset;
	}

	public void setCreditReset(String CreditReset) {
		_CreditReset = CreditReset;
	}

	public String getResetInterval() {
		return _ResetInterval;
	}

	public void setResetInterval(String ResetInterval) {
		_ResetInterval = ResetInterval;
	}

	public int getResetDay() {
		return _ResetDay;
	}

	public void setResetDay(int ResetDay) {
		_ResetDay = ResetDay;
	}

	public String getExcludeWeekEnds() {
		return _ExcludeWeekEnds;
	}

	public void setExcludeWeekEnds(String ExcludeWeekEnds) {
		_ExcludeWeekEnds = ExcludeWeekEnds;
	}

	public String getExcludeHolidays() {
		return _ExcludeHolidays;
	}

	public void setExcludeHolidays(String ExcludeHolidays) {
		_ExcludeHolidays = ExcludeHolidays;
	}

	private int _LeaveTypeCode;
	private String _LeaveTypeName;
	private String _CountriesApplicable;
	private String _MonthlyAccrual;
	private double _AccrualValue;
	private String _CreditReset;
	private String _ResetInterval;
	private int _ResetDay;
	private String _ExcludeWeekEnds;
	private String _ExcludeHolidays;
}