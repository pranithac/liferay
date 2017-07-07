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
import com.trianz.lms.service.LMSWeekendsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSWeekendsClp extends BaseModelImpl<LMSWeekends>
	implements LMSWeekends {
	public LMSWeekendsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LMSWeekends.class;
	}

	@Override
	public String getModelClassName() {
		return LMSWeekends.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _LocationId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setLocationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _LocationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LocationId", getLocationId());
		attributes.put("Location", getLocation());
		attributes.put("WeekendDays", getWeekendDays());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer LocationId = (Integer)attributes.get("LocationId");

		if (LocationId != null) {
			setLocationId(LocationId);
		}

		String Location = (String)attributes.get("Location");

		if (Location != null) {
			setLocation(Location);
		}

		String WeekendDays = (String)attributes.get("WeekendDays");

		if (WeekendDays != null) {
			setWeekendDays(WeekendDays);
		}
	}

	@Override
	public int getLocationId() {
		return _LocationId;
	}

	@Override
	public void setLocationId(int LocationId) {
		_LocationId = LocationId;

		if (_lmsWeekendsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsWeekendsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", int.class);

				method.invoke(_lmsWeekendsRemoteModel, LocationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _Location;
	}

	@Override
	public void setLocation(String Location) {
		_Location = Location;

		if (_lmsWeekendsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsWeekendsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_lmsWeekendsRemoteModel, Location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWeekendDays() {
		return _WeekendDays;
	}

	@Override
	public void setWeekendDays(String WeekendDays) {
		_WeekendDays = WeekendDays;

		if (_lmsWeekendsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsWeekendsRemoteModel.getClass();

				Method method = clazz.getMethod("setWeekendDays", String.class);

				method.invoke(_lmsWeekendsRemoteModel, WeekendDays);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSWeekendsRemoteModel() {
		return _lmsWeekendsRemoteModel;
	}

	public void setLMSWeekendsRemoteModel(BaseModel<?> lmsWeekendsRemoteModel) {
		_lmsWeekendsRemoteModel = lmsWeekendsRemoteModel;
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

		Class<?> remoteModelClass = _lmsWeekendsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsWeekendsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSWeekendsLocalServiceUtil.addLMSWeekends(this);
		}
		else {
			LMSWeekendsLocalServiceUtil.updateLMSWeekends(this);
		}
	}

	@Override
	public LMSWeekends toEscapedModel() {
		return (LMSWeekends)ProxyUtil.newProxyInstance(LMSWeekends.class.getClassLoader(),
			new Class[] { LMSWeekends.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSWeekendsClp clone = new LMSWeekendsClp();

		clone.setLocationId(getLocationId());
		clone.setLocation(getLocation());
		clone.setWeekendDays(getWeekendDays());

		return clone;
	}

	@Override
	public int compareTo(LMSWeekends lmsWeekends) {
		int primaryKey = lmsWeekends.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSWeekendsClp)) {
			return false;
		}

		LMSWeekendsClp lmsWeekends = (LMSWeekendsClp)obj;

		int primaryKey = lmsWeekends.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{LocationId=");
		sb.append(getLocationId());
		sb.append(", Location=");
		sb.append(getLocation());
		sb.append(", WeekendDays=");
		sb.append(getWeekendDays());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSWeekends");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>LocationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>WeekendDays</column-name><column-value><![CDATA[");
		sb.append(getWeekendDays());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _LocationId;
	private String _Location;
	private String _WeekendDays;
	private BaseModel<?> _lmsWeekendsRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}