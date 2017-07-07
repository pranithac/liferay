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
import com.trianz.lms.service.LMSHolidaysLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSHolidaysClp extends BaseModelImpl<LMSHolidays>
	implements LMSHolidays {
	public LMSHolidaysClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LMSHolidays.class;
	}

	@Override
	public String getModelClassName() {
		return LMSHolidays.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _HolidayId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setHolidayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _HolidayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("HolidayId", getHolidayId());
		attributes.put("HolidayDate", getHolidayDate());
		attributes.put("Occassion", getOccassion());
		attributes.put("HolidayYear", getHolidayYear());
		attributes.put("LocationsApplicable", getLocationsApplicable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer HolidayId = (Integer)attributes.get("HolidayId");

		if (HolidayId != null) {
			setHolidayId(HolidayId);
		}

		Date HolidayDate = (Date)attributes.get("HolidayDate");

		if (HolidayDate != null) {
			setHolidayDate(HolidayDate);
		}

		String Occassion = (String)attributes.get("Occassion");

		if (Occassion != null) {
			setOccassion(Occassion);
		}

		Integer HolidayYear = (Integer)attributes.get("HolidayYear");

		if (HolidayYear != null) {
			setHolidayYear(HolidayYear);
		}

		String LocationsApplicable = (String)attributes.get(
				"LocationsApplicable");

		if (LocationsApplicable != null) {
			setLocationsApplicable(LocationsApplicable);
		}
	}

	@Override
	public int getHolidayId() {
		return _HolidayId;
	}

	@Override
	public void setHolidayId(int HolidayId) {
		_HolidayId = HolidayId;

		if (_lmsHolidaysRemoteModel != null) {
			try {
				Class<?> clazz = _lmsHolidaysRemoteModel.getClass();

				Method method = clazz.getMethod("setHolidayId", int.class);

				method.invoke(_lmsHolidaysRemoteModel, HolidayId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getHolidayDate() {
		return _HolidayDate;
	}

	@Override
	public void setHolidayDate(Date HolidayDate) {
		_HolidayDate = HolidayDate;

		if (_lmsHolidaysRemoteModel != null) {
			try {
				Class<?> clazz = _lmsHolidaysRemoteModel.getClass();

				Method method = clazz.getMethod("setHolidayDate", Date.class);

				method.invoke(_lmsHolidaysRemoteModel, HolidayDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOccassion() {
		return _Occassion;
	}

	@Override
	public void setOccassion(String Occassion) {
		_Occassion = Occassion;

		if (_lmsHolidaysRemoteModel != null) {
			try {
				Class<?> clazz = _lmsHolidaysRemoteModel.getClass();

				Method method = clazz.getMethod("setOccassion", String.class);

				method.invoke(_lmsHolidaysRemoteModel, Occassion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHolidayYear() {
		return _HolidayYear;
	}

	@Override
	public void setHolidayYear(int HolidayYear) {
		_HolidayYear = HolidayYear;

		if (_lmsHolidaysRemoteModel != null) {
			try {
				Class<?> clazz = _lmsHolidaysRemoteModel.getClass();

				Method method = clazz.getMethod("setHolidayYear", int.class);

				method.invoke(_lmsHolidaysRemoteModel, HolidayYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocationsApplicable() {
		return _LocationsApplicable;
	}

	@Override
	public void setLocationsApplicable(String LocationsApplicable) {
		_LocationsApplicable = LocationsApplicable;

		if (_lmsHolidaysRemoteModel != null) {
			try {
				Class<?> clazz = _lmsHolidaysRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationsApplicable",
						String.class);

				method.invoke(_lmsHolidaysRemoteModel, LocationsApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSHolidaysRemoteModel() {
		return _lmsHolidaysRemoteModel;
	}

	public void setLMSHolidaysRemoteModel(BaseModel<?> lmsHolidaysRemoteModel) {
		_lmsHolidaysRemoteModel = lmsHolidaysRemoteModel;
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

		Class<?> remoteModelClass = _lmsHolidaysRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsHolidaysRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSHolidaysLocalServiceUtil.addLMSHolidays(this);
		}
		else {
			LMSHolidaysLocalServiceUtil.updateLMSHolidays(this);
		}
	}

	@Override
	public LMSHolidays toEscapedModel() {
		return (LMSHolidays)ProxyUtil.newProxyInstance(LMSHolidays.class.getClassLoader(),
			new Class[] { LMSHolidays.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSHolidaysClp clone = new LMSHolidaysClp();

		clone.setHolidayId(getHolidayId());
		clone.setHolidayDate(getHolidayDate());
		clone.setOccassion(getOccassion());
		clone.setHolidayYear(getHolidayYear());
		clone.setLocationsApplicable(getLocationsApplicable());

		return clone;
	}

	@Override
	public int compareTo(LMSHolidays lmsHolidays) {
		int value = 0;

		if (getHolidayId() < lmsHolidays.getHolidayId()) {
			value = -1;
		}
		else if (getHolidayId() > lmsHolidays.getHolidayId()) {
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

		if (!(obj instanceof LMSHolidaysClp)) {
			return false;
		}

		LMSHolidaysClp lmsHolidays = (LMSHolidaysClp)obj;

		int primaryKey = lmsHolidays.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{HolidayId=");
		sb.append(getHolidayId());
		sb.append(", HolidayDate=");
		sb.append(getHolidayDate());
		sb.append(", Occassion=");
		sb.append(getOccassion());
		sb.append(", HolidayYear=");
		sb.append(getHolidayYear());
		sb.append(", LocationsApplicable=");
		sb.append(getLocationsApplicable());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSHolidays");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>HolidayId</column-name><column-value><![CDATA[");
		sb.append(getHolidayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HolidayDate</column-name><column-value><![CDATA[");
		sb.append(getHolidayDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Occassion</column-name><column-value><![CDATA[");
		sb.append(getOccassion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HolidayYear</column-name><column-value><![CDATA[");
		sb.append(getHolidayYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LocationsApplicable</column-name><column-value><![CDATA[");
		sb.append(getLocationsApplicable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _HolidayId;
	private Date _HolidayDate;
	private String _Occassion;
	private int _HolidayYear;
	private String _LocationsApplicable;
	private BaseModel<?> _lmsHolidaysRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}