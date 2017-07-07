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
import com.trianz.lms.service.securaxEmployeeHrsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class securaxEmployeeHrsClp extends BaseModelImpl<securaxEmployeeHrs>
	implements securaxEmployeeHrs {
	public securaxEmployeeHrsClp() {
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

	@Override
	public int getEmployeeId() {
		return _EmployeeId;
	}

	@Override
	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", int.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, EmployeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPunchDate() {
		return _PunchDate;
	}

	@Override
	public void setPunchDate(Date PunchDate) {
		_PunchDate = PunchDate;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setPunchDate", Date.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, PunchDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPunchInTime() {
		return _PunchInTime;
	}

	@Override
	public void setPunchInTime(Date PunchInTime) {
		_PunchInTime = PunchInTime;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setPunchInTime", Date.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, PunchInTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPunchOutTime() {
		return _PunchOutTime;
	}

	@Override
	public void setPunchOutTime(Date PunchOutTime) {
		_PunchOutTime = PunchOutTime;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setPunchOutTime", Date.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, PunchOutTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getWorkHrsPerday() {
		return _WorkHrsPerday;
	}

	@Override
	public void setWorkHrsPerday(Date WorkHrsPerday) {
		_WorkHrsPerday = WorkHrsPerday;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkHrsPerday", Date.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, WorkHrsPerday);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _Status;
	}

	@Override
	public void setStatus(String Status) {
		_Status = Status;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, Status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOT() {
		return _OT;
	}

	@Override
	public void setOT(Date OT) {
		_OT = OT;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setOT", Date.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, OT);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCreated_By() {
		return _Created_By;
	}

	@Override
	public void setCreated_By(int Created_By) {
		_Created_By = Created_By;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreated_By", int.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, Created_By);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreated_Date() {
		return _Created_Date;
	}

	@Override
	public void setCreated_Date(Date Created_Date) {
		_Created_Date = Created_Date;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreated_Date", Date.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, Created_Date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getModified_By() {
		return _Modified_By;
	}

	@Override
	public void setModified_By(int Modified_By) {
		_Modified_By = Modified_By;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setModified_By", int.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, Modified_By);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModified_Date() {
		return _Modified_Date;
	}

	@Override
	public void setModified_Date(Date Modified_Date) {
		_Modified_Date = Modified_Date;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setModified_Date", Date.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, Modified_Date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getS_Id() {
		return _S_Id;
	}

	@Override
	public void setS_Id(int S_Id) {
		_S_Id = S_Id;

		if (_securaxEmployeeHrsRemoteModel != null) {
			try {
				Class<?> clazz = _securaxEmployeeHrsRemoteModel.getClass();

				Method method = clazz.getMethod("setS_Id", int.class);

				method.invoke(_securaxEmployeeHrsRemoteModel, S_Id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getsecuraxEmployeeHrsRemoteModel() {
		return _securaxEmployeeHrsRemoteModel;
	}

	public void setsecuraxEmployeeHrsRemoteModel(
		BaseModel<?> securaxEmployeeHrsRemoteModel) {
		_securaxEmployeeHrsRemoteModel = securaxEmployeeHrsRemoteModel;
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

		Class<?> remoteModelClass = _securaxEmployeeHrsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_securaxEmployeeHrsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			securaxEmployeeHrsLocalServiceUtil.addsecuraxEmployeeHrs(this);
		}
		else {
			securaxEmployeeHrsLocalServiceUtil.updatesecuraxEmployeeHrs(this);
		}
	}

	@Override
	public securaxEmployeeHrs toEscapedModel() {
		return (securaxEmployeeHrs)ProxyUtil.newProxyInstance(securaxEmployeeHrs.class.getClassLoader(),
			new Class[] { securaxEmployeeHrs.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		securaxEmployeeHrsClp clone = new securaxEmployeeHrsClp();

		clone.setEmployeeId(getEmployeeId());
		clone.setPunchDate(getPunchDate());
		clone.setPunchInTime(getPunchInTime());
		clone.setPunchOutTime(getPunchOutTime());
		clone.setWorkHrsPerday(getWorkHrsPerday());
		clone.setStatus(getStatus());
		clone.setOT(getOT());
		clone.setCreated_By(getCreated_By());
		clone.setCreated_Date(getCreated_Date());
		clone.setModified_By(getModified_By());
		clone.setModified_Date(getModified_Date());
		clone.setS_Id(getS_Id());

		return clone;
	}

	@Override
	public int compareTo(securaxEmployeeHrs securaxEmployeeHrs) {
		int value = 0;

		if (getEmployeeId() < securaxEmployeeHrs.getEmployeeId()) {
			value = -1;
		}
		else if (getEmployeeId() > securaxEmployeeHrs.getEmployeeId()) {
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

		if (!(obj instanceof securaxEmployeeHrsClp)) {
			return false;
		}

		securaxEmployeeHrsClp securaxEmployeeHrs = (securaxEmployeeHrsClp)obj;

		int primaryKey = securaxEmployeeHrs.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{EmployeeId=");
		sb.append(getEmployeeId());
		sb.append(", PunchDate=");
		sb.append(getPunchDate());
		sb.append(", PunchInTime=");
		sb.append(getPunchInTime());
		sb.append(", PunchOutTime=");
		sb.append(getPunchOutTime());
		sb.append(", WorkHrsPerday=");
		sb.append(getWorkHrsPerday());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", OT=");
		sb.append(getOT());
		sb.append(", Created_By=");
		sb.append(getCreated_By());
		sb.append(", Created_Date=");
		sb.append(getCreated_Date());
		sb.append(", Modified_By=");
		sb.append(getModified_By());
		sb.append(", Modified_Date=");
		sb.append(getModified_Date());
		sb.append(", S_Id=");
		sb.append(getS_Id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.securaxEmployeeHrs");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>EmployeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PunchDate</column-name><column-value><![CDATA[");
		sb.append(getPunchDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PunchInTime</column-name><column-value><![CDATA[");
		sb.append(getPunchInTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PunchOutTime</column-name><column-value><![CDATA[");
		sb.append(getPunchOutTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>WorkHrsPerday</column-name><column-value><![CDATA[");
		sb.append(getWorkHrsPerday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>OT</column-name><column-value><![CDATA[");
		sb.append(getOT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Created_By</column-name><column-value><![CDATA[");
		sb.append(getCreated_By());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Created_Date</column-name><column-value><![CDATA[");
		sb.append(getCreated_Date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Modified_By</column-name><column-value><![CDATA[");
		sb.append(getModified_By());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Modified_Date</column-name><column-value><![CDATA[");
		sb.append(getModified_Date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>S_Id</column-name><column-value><![CDATA[");
		sb.append(getS_Id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _EmployeeId;
	private Date _PunchDate;
	private Date _PunchInTime;
	private Date _PunchOutTime;
	private Date _WorkHrsPerday;
	private String _Status;
	private Date _OT;
	private int _Created_By;
	private Date _Created_Date;
	private int _Modified_By;
	private Date _Modified_Date;
	private int _S_Id;
	private BaseModel<?> _securaxEmployeeHrsRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}