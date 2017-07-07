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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.trianz.lms.service.ClpSerializer;
import com.trianz.lms.service.LMSCompOffLeaveDetailsLocalServiceUtil;
import com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSCompOffLeaveDetailsClp extends BaseModelImpl<LMSCompOffLeaveDetails>
	implements LMSCompOffLeaveDetails {
	public LMSCompOffLeaveDetailsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LMSCompOffLeaveDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSCompOffLeaveDetails.class.getName();
	}

	@Override
	public LMSCompOffLeaveDetailsPK getPrimaryKey() {
		return new LMSCompOffLeaveDetailsPK(_EmployeeID, _CompoffDate);
	}

	@Override
	public void setPrimaryKey(LMSCompOffLeaveDetailsPK primaryKey) {
		setEmployeeID(primaryKey.EmployeeID);
		setCompoffDate(primaryKey.CompoffDate);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new LMSCompOffLeaveDetailsPK(_EmployeeID, _CompoffDate);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((LMSCompOffLeaveDetailsPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ApprovedBy", getApprovedBy());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("EmployeeID", getEmployeeID());
		attributes.put("Status", getStatus());
		attributes.put("CompoffDate", getCompoffDate());
		attributes.put("CompOffId", getCompOffId());
		attributes.put("ApproverEmployeeID", getApproverEmployeeID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String ApprovedBy = (String)attributes.get("ApprovedBy");

		if (ApprovedBy != null) {
			setApprovedBy(ApprovedBy);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		Integer EmployeeID = (Integer)attributes.get("EmployeeID");

		if (EmployeeID != null) {
			setEmployeeID(EmployeeID);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date CompoffDate = (Date)attributes.get("CompoffDate");

		if (CompoffDate != null) {
			setCompoffDate(CompoffDate);
		}

		Integer CompOffId = (Integer)attributes.get("CompOffId");

		if (CompOffId != null) {
			setCompOffId(CompOffId);
		}

		Integer ApproverEmployeeID = (Integer)attributes.get(
				"ApproverEmployeeID");

		if (ApproverEmployeeID != null) {
			setApproverEmployeeID(ApproverEmployeeID);
		}
	}

	@Override
	public String getApprovedBy() {
		return _ApprovedBy;
	}

	@Override
	public void setApprovedBy(String ApprovedBy) {
		_ApprovedBy = ApprovedBy;

		if (_lmsCompOffLeaveDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsCompOffLeaveDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovedBy", String.class);

				method.invoke(_lmsCompOffLeaveDetailsRemoteModel, ApprovedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _CreatedDate;
	}

	@Override
	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;

		if (_lmsCompOffLeaveDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsCompOffLeaveDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_lmsCompOffLeaveDetailsRemoteModel, CreatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEmployeeID() {
		return _EmployeeID;
	}

	@Override
	public void setEmployeeID(int EmployeeID) {
		_EmployeeID = EmployeeID;

		if (_lmsCompOffLeaveDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsCompOffLeaveDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeID", int.class);

				method.invoke(_lmsCompOffLeaveDetailsRemoteModel, EmployeeID);
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

		if (_lmsCompOffLeaveDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsCompOffLeaveDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_lmsCompOffLeaveDetailsRemoteModel, Status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCompoffDate() {
		return _CompoffDate;
	}

	@Override
	public void setCompoffDate(Date CompoffDate) {
		_CompoffDate = CompoffDate;

		if (_lmsCompOffLeaveDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsCompOffLeaveDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompoffDate", Date.class);

				method.invoke(_lmsCompOffLeaveDetailsRemoteModel, CompoffDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCompOffId() {
		return _CompOffId;
	}

	@Override
	public void setCompOffId(int CompOffId) {
		_CompOffId = CompOffId;

		if (_lmsCompOffLeaveDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsCompOffLeaveDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompOffId", int.class);

				method.invoke(_lmsCompOffLeaveDetailsRemoteModel, CompOffId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApproverEmployeeID() {
		return _ApproverEmployeeID;
	}

	@Override
	public void setApproverEmployeeID(int ApproverEmployeeID) {
		_ApproverEmployeeID = ApproverEmployeeID;

		if (_lmsCompOffLeaveDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsCompOffLeaveDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverEmployeeID",
						int.class);

				method.invoke(_lmsCompOffLeaveDetailsRemoteModel,
					ApproverEmployeeID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSCompOffLeaveDetailsRemoteModel() {
		return _lmsCompOffLeaveDetailsRemoteModel;
	}

	public void setLMSCompOffLeaveDetailsRemoteModel(
		BaseModel<?> lmsCompOffLeaveDetailsRemoteModel) {
		_lmsCompOffLeaveDetailsRemoteModel = lmsCompOffLeaveDetailsRemoteModel;
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

		Class<?> remoteModelClass = _lmsCompOffLeaveDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsCompOffLeaveDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSCompOffLeaveDetailsLocalServiceUtil.addLMSCompOffLeaveDetails(this);
		}
		else {
			LMSCompOffLeaveDetailsLocalServiceUtil.updateLMSCompOffLeaveDetails(this);
		}
	}

	@Override
	public LMSCompOffLeaveDetails toEscapedModel() {
		return (LMSCompOffLeaveDetails)ProxyUtil.newProxyInstance(LMSCompOffLeaveDetails.class.getClassLoader(),
			new Class[] { LMSCompOffLeaveDetails.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSCompOffLeaveDetailsClp clone = new LMSCompOffLeaveDetailsClp();

		clone.setApprovedBy(getApprovedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setEmployeeID(getEmployeeID());
		clone.setStatus(getStatus());
		clone.setCompoffDate(getCompoffDate());
		clone.setCompOffId(getCompOffId());
		clone.setApproverEmployeeID(getApproverEmployeeID());

		return clone;
	}

	@Override
	public int compareTo(LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		int value = 0;

		value = DateUtil.compareTo(getCompoffDate(),
				lmsCompOffLeaveDetails.getCompoffDate());

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

		if (!(obj instanceof LMSCompOffLeaveDetailsClp)) {
			return false;
		}

		LMSCompOffLeaveDetailsClp lmsCompOffLeaveDetails = (LMSCompOffLeaveDetailsClp)obj;

		LMSCompOffLeaveDetailsPK primaryKey = lmsCompOffLeaveDetails.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ApprovedBy=");
		sb.append(getApprovedBy());
		sb.append(", CreatedDate=");
		sb.append(getCreatedDate());
		sb.append(", EmployeeID=");
		sb.append(getEmployeeID());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", CompoffDate=");
		sb.append(getCompoffDate());
		sb.append(", CompOffId=");
		sb.append(getCompOffId());
		sb.append(", ApproverEmployeeID=");
		sb.append(getApproverEmployeeID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSCompOffLeaveDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ApprovedBy</column-name><column-value><![CDATA[");
		sb.append(getApprovedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreatedDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmployeeID</column-name><column-value><![CDATA[");
		sb.append(getEmployeeID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CompoffDate</column-name><column-value><![CDATA[");
		sb.append(getCompoffDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CompOffId</column-name><column-value><![CDATA[");
		sb.append(getCompOffId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverEmployeeID</column-name><column-value><![CDATA[");
		sb.append(getApproverEmployeeID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _ApprovedBy;
	private Date _CreatedDate;
	private int _EmployeeID;
	private String _Status;
	private Date _CompoffDate;
	private int _CompOffId;
	private int _ApproverEmployeeID;
	private BaseModel<?> _lmsCompOffLeaveDetailsRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}