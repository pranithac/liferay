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
import com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSEmployeeDetailsClp extends BaseModelImpl<LMSEmployeeDetails>
	implements LMSEmployeeDetails {
	public LMSEmployeeDetailsClp() {
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
	public int getPrimaryKey() {
		return _EmployeeId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setEmployeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _EmployeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
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

	@Override
	public int getEmployeeId() {
		return _EmployeeId;
	}

	@Override
	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", int.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, EmployeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeName() {
		return _EmployeeName;
	}

	@Override
	public void setEmployeeName(String EmployeeName) {
		_EmployeeName = EmployeeName;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeName", String.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, EmployeeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeEmailID() {
		return _EmployeeEmailID;
	}

	@Override
	public void setEmployeeEmailID(String EmployeeEmailID) {
		_EmployeeEmailID = EmployeeEmailID;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeEmailID",
						String.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, EmployeeEmailID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJoiningDate() {
		return _JoiningDate;
	}

	@Override
	public void setJoiningDate(Date JoiningDate) {
		_JoiningDate = JoiningDate;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setJoiningDate", Date.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, JoiningDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSupervisorId() {
		return _SupervisorId;
	}

	@Override
	public void setSupervisorId(int SupervisorId) {
		_SupervisorId = SupervisorId;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorId", int.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, SupervisorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupervisorName() {
		return _SupervisorName;
	}

	@Override
	public void setSupervisorName(String SupervisorName) {
		_SupervisorName = SupervisorName;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorName",
						String.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, SupervisorName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupervisorEmail() {
		return _SupervisorEmail;
	}

	@Override
	public void setSupervisorEmail(String SupervisorEmail) {
		_SupervisorEmail = SupervisorEmail;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorEmail",
						String.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, SupervisorEmail);
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

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, Location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegion() {
		return _Region;
	}

	@Override
	public void setRegion(String Region) {
		_Region = Region;

		if (_lmsEmployeeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsEmployeeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setRegion", String.class);

				method.invoke(_lmsEmployeeDetailsRemoteModel, Region);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSEmployeeDetailsRemoteModel() {
		return _lmsEmployeeDetailsRemoteModel;
	}

	public void setLMSEmployeeDetailsRemoteModel(
		BaseModel<?> lmsEmployeeDetailsRemoteModel) {
		_lmsEmployeeDetailsRemoteModel = lmsEmployeeDetailsRemoteModel;
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

		Class<?> remoteModelClass = _lmsEmployeeDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsEmployeeDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSEmployeeDetailsLocalServiceUtil.addLMSEmployeeDetails(this);
		}
		else {
			LMSEmployeeDetailsLocalServiceUtil.updateLMSEmployeeDetails(this);
		}
	}

	@Override
	public LMSEmployeeDetails toEscapedModel() {
		return (LMSEmployeeDetails)ProxyUtil.newProxyInstance(LMSEmployeeDetails.class.getClassLoader(),
			new Class[] { LMSEmployeeDetails.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSEmployeeDetailsClp clone = new LMSEmployeeDetailsClp();

		clone.setEmployeeId(getEmployeeId());
		clone.setEmployeeName(getEmployeeName());
		clone.setEmployeeEmailID(getEmployeeEmailID());
		clone.setJoiningDate(getJoiningDate());
		clone.setSupervisorId(getSupervisorId());
		clone.setSupervisorName(getSupervisorName());
		clone.setSupervisorEmail(getSupervisorEmail());
		clone.setLocation(getLocation());
		clone.setRegion(getRegion());

		return clone;
	}

	@Override
	public int compareTo(LMSEmployeeDetails lmsEmployeeDetails) {
		int value = 0;

		if (getEmployeeId() < lmsEmployeeDetails.getEmployeeId()) {
			value = -1;
		}
		else if (getEmployeeId() > lmsEmployeeDetails.getEmployeeId()) {
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

		if (!(obj instanceof LMSEmployeeDetailsClp)) {
			return false;
		}

		LMSEmployeeDetailsClp lmsEmployeeDetails = (LMSEmployeeDetailsClp)obj;

		int primaryKey = lmsEmployeeDetails.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{EmployeeId=");
		sb.append(getEmployeeId());
		sb.append(", EmployeeName=");
		sb.append(getEmployeeName());
		sb.append(", EmployeeEmailID=");
		sb.append(getEmployeeEmailID());
		sb.append(", JoiningDate=");
		sb.append(getJoiningDate());
		sb.append(", SupervisorId=");
		sb.append(getSupervisorId());
		sb.append(", SupervisorName=");
		sb.append(getSupervisorName());
		sb.append(", SupervisorEmail=");
		sb.append(getSupervisorEmail());
		sb.append(", Location=");
		sb.append(getLocation());
		sb.append(", Region=");
		sb.append(getRegion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSEmployeeDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>EmployeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmployeeName</column-name><column-value><![CDATA[");
		sb.append(getEmployeeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmployeeEmailID</column-name><column-value><![CDATA[");
		sb.append(getEmployeeEmailID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JoiningDate</column-name><column-value><![CDATA[");
		sb.append(getJoiningDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SupervisorId</column-name><column-value><![CDATA[");
		sb.append(getSupervisorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SupervisorName</column-name><column-value><![CDATA[");
		sb.append(getSupervisorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SupervisorEmail</column-name><column-value><![CDATA[");
		sb.append(getSupervisorEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Region</column-name><column-value><![CDATA[");
		sb.append(getRegion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _EmployeeId;
	private String _EmployeeName;
	private String _EmployeeEmailID;
	private Date _JoiningDate;
	private int _SupervisorId;
	private String _SupervisorName;
	private String _SupervisorEmail;
	private String _Location;
	private String _Region;
	private BaseModel<?> _lmsEmployeeDetailsRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}