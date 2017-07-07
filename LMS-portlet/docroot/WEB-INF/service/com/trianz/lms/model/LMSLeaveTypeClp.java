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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.trianz.lms.service.ClpSerializer;
import com.trianz.lms.service.LMSLeaveTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSLeaveTypeClp extends BaseModelImpl<LMSLeaveType>
	implements LMSLeaveType {
	public LMSLeaveTypeClp() {
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
	public int getPrimaryKey() {
		return _LeaveTypeCode;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setLeaveTypeCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _LeaveTypeCode;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
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

	@Override
	public int getLeaveTypeCode() {
		return _LeaveTypeCode;
	}

	@Override
	public void setLeaveTypeCode(int LeaveTypeCode) {
		_LeaveTypeCode = LeaveTypeCode;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeCode", int.class);

				method.invoke(_lmsLeaveTypeRemoteModel, LeaveTypeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveTypeName() {
		return _LeaveTypeName;
	}

	@Override
	public void setLeaveTypeName(String LeaveTypeName) {
		_LeaveTypeName = LeaveTypeName;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeName", String.class);

				method.invoke(_lmsLeaveTypeRemoteModel, LeaveTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountriesApplicable() {
		return _CountriesApplicable;
	}

	@Override
	public void setCountriesApplicable(String CountriesApplicable) {
		_CountriesApplicable = CountriesApplicable;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCountriesApplicable",
						String.class);

				method.invoke(_lmsLeaveTypeRemoteModel, CountriesApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMonthlyAccrual() {
		return _MonthlyAccrual;
	}

	@Override
	public void setMonthlyAccrual(String MonthlyAccrual) {
		_MonthlyAccrual = MonthlyAccrual;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMonthlyAccrual",
						String.class);

				method.invoke(_lmsLeaveTypeRemoteModel, MonthlyAccrual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAccrualValue() {
		return _AccrualValue;
	}

	@Override
	public void setAccrualValue(double AccrualValue) {
		_AccrualValue = AccrualValue;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setAccrualValue", double.class);

				method.invoke(_lmsLeaveTypeRemoteModel, AccrualValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreditReset() {
		return _CreditReset;
	}

	@Override
	public void setCreditReset(String CreditReset) {
		_CreditReset = CreditReset;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditReset", String.class);

				method.invoke(_lmsLeaveTypeRemoteModel, CreditReset);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResetInterval() {
		return _ResetInterval;
	}

	@Override
	public void setResetInterval(String ResetInterval) {
		_ResetInterval = ResetInterval;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setResetInterval", String.class);

				method.invoke(_lmsLeaveTypeRemoteModel, ResetInterval);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResetDay() {
		return _ResetDay;
	}

	@Override
	public void setResetDay(int ResetDay) {
		_ResetDay = ResetDay;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setResetDay", int.class);

				method.invoke(_lmsLeaveTypeRemoteModel, ResetDay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExcludeWeekEnds() {
		return _ExcludeWeekEnds;
	}

	@Override
	public void setExcludeWeekEnds(String ExcludeWeekEnds) {
		_ExcludeWeekEnds = ExcludeWeekEnds;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setExcludeWeekEnds",
						String.class);

				method.invoke(_lmsLeaveTypeRemoteModel, ExcludeWeekEnds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExcludeHolidays() {
		return _ExcludeHolidays;
	}

	@Override
	public void setExcludeHolidays(String ExcludeHolidays) {
		_ExcludeHolidays = ExcludeHolidays;

		if (_lmsLeaveTypeRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setExcludeHolidays",
						String.class);

				method.invoke(_lmsLeaveTypeRemoteModel, ExcludeHolidays);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSLeaveTypeRemoteModel() {
		return _lmsLeaveTypeRemoteModel;
	}

	public void setLMSLeaveTypeRemoteModel(BaseModel<?> lmsLeaveTypeRemoteModel) {
		_lmsLeaveTypeRemoteModel = lmsLeaveTypeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _lmsLeaveTypeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_lmsLeaveTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSLeaveTypeLocalServiceUtil.addLMSLeaveType(this);
		}
		else {
			LMSLeaveTypeLocalServiceUtil.updateLMSLeaveType(this);
		}
	}

	@Override
	public LMSLeaveType toEscapedModel() {
		return (LMSLeaveType)ProxyUtil.newProxyInstance(LMSLeaveType.class.getClassLoader(),
			new Class[] { LMSLeaveType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSLeaveTypeClp clone = new LMSLeaveTypeClp();

		clone.setLeaveTypeCode(getLeaveTypeCode());
		clone.setLeaveTypeName(getLeaveTypeName());
		clone.setCountriesApplicable(getCountriesApplicable());
		clone.setMonthlyAccrual(getMonthlyAccrual());
		clone.setAccrualValue(getAccrualValue());
		clone.setCreditReset(getCreditReset());
		clone.setResetInterval(getResetInterval());
		clone.setResetDay(getResetDay());
		clone.setExcludeWeekEnds(getExcludeWeekEnds());
		clone.setExcludeHolidays(getExcludeHolidays());

		return clone;
	}

	@Override
	public int compareTo(LMSLeaveType lmsLeaveType) {
		int value = 0;

		if (getLeaveTypeCode() < lmsLeaveType.getLeaveTypeCode()) {
			value = -1;
		}
		else if (getLeaveTypeCode() > lmsLeaveType.getLeaveTypeCode()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSLeaveTypeClp)) {
			return false;
		}

		LMSLeaveTypeClp lmsLeaveType = (LMSLeaveTypeClp)obj;

		int primaryKey = lmsLeaveType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{LeaveTypeCode=");
		sb.append(getLeaveTypeCode());
		sb.append(", LeaveTypeName=");
		sb.append(getLeaveTypeName());
		sb.append(", CountriesApplicable=");
		sb.append(getCountriesApplicable());
		sb.append(", MonthlyAccrual=");
		sb.append(getMonthlyAccrual());
		sb.append(", AccrualValue=");
		sb.append(getAccrualValue());
		sb.append(", CreditReset=");
		sb.append(getCreditReset());
		sb.append(", ResetInterval=");
		sb.append(getResetInterval());
		sb.append(", ResetDay=");
		sb.append(getResetDay());
		sb.append(", ExcludeWeekEnds=");
		sb.append(getExcludeWeekEnds());
		sb.append(", ExcludeHolidays=");
		sb.append(getExcludeHolidays());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSLeaveType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>LeaveTypeCode</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveTypeName</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CountriesApplicable</column-name><column-value><![CDATA[");
		sb.append(getCountriesApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MonthlyAccrual</column-name><column-value><![CDATA[");
		sb.append(getMonthlyAccrual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AccrualValue</column-name><column-value><![CDATA[");
		sb.append(getAccrualValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreditReset</column-name><column-value><![CDATA[");
		sb.append(getCreditReset());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ResetInterval</column-name><column-value><![CDATA[");
		sb.append(getResetInterval());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ResetDay</column-name><column-value><![CDATA[");
		sb.append(getResetDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ExcludeWeekEnds</column-name><column-value><![CDATA[");
		sb.append(getExcludeWeekEnds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ExcludeHolidays</column-name><column-value><![CDATA[");
		sb.append(getExcludeHolidays());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _lmsLeaveTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}