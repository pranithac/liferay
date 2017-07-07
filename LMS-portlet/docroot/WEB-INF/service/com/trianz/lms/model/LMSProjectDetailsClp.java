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
import com.trianz.lms.service.LMSProjectDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSProjectDetailsClp extends BaseModelImpl<LMSProjectDetails>
	implements LMSProjectDetails {
	public LMSProjectDetailsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LMSProjectDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSProjectDetails.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _AssignmentID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setAssignmentID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _AssignmentID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("ProjectCode", getProjectCode());
		attributes.put("ProjectName", getProjectName());
		attributes.put("ApproverName", getApproverName());
		attributes.put("ApproverID", getApproverID());
		attributes.put("ApproverEmail", getApproverEmail());
		attributes.put("AssignmentID", getAssignmentID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		String ProjectCode = (String)attributes.get("ProjectCode");

		if (ProjectCode != null) {
			setProjectCode(ProjectCode);
		}

		String ProjectName = (String)attributes.get("ProjectName");

		if (ProjectName != null) {
			setProjectName(ProjectName);
		}

		String ApproverName = (String)attributes.get("ApproverName");

		if (ApproverName != null) {
			setApproverName(ApproverName);
		}

		Integer ApproverID = (Integer)attributes.get("ApproverID");

		if (ApproverID != null) {
			setApproverID(ApproverID);
		}

		String ApproverEmail = (String)attributes.get("ApproverEmail");

		if (ApproverEmail != null) {
			setApproverEmail(ApproverEmail);
		}

		Integer AssignmentID = (Integer)attributes.get("AssignmentID");

		if (AssignmentID != null) {
			setAssignmentID(AssignmentID);
		}
	}

	@Override
	public int getEmployeeId() {
		return _EmployeeId;
	}

	@Override
	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;

		if (_lmsProjectDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsProjectDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", int.class);

				method.invoke(_lmsProjectDetailsRemoteModel, EmployeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectCode() {
		return _ProjectCode;
	}

	@Override
	public void setProjectCode(String ProjectCode) {
		_ProjectCode = ProjectCode;

		if (_lmsProjectDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsProjectDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectCode", String.class);

				method.invoke(_lmsProjectDetailsRemoteModel, ProjectCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectName() {
		return _ProjectName;
	}

	@Override
	public void setProjectName(String ProjectName) {
		_ProjectName = ProjectName;

		if (_lmsProjectDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsProjectDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectName", String.class);

				method.invoke(_lmsProjectDetailsRemoteModel, ProjectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApproverName() {
		return _ApproverName;
	}

	@Override
	public void setApproverName(String ApproverName) {
		_ApproverName = ApproverName;

		if (_lmsProjectDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsProjectDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverName", String.class);

				method.invoke(_lmsProjectDetailsRemoteModel, ApproverName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApproverID() {
		return _ApproverID;
	}

	@Override
	public void setApproverID(int ApproverID) {
		_ApproverID = ApproverID;

		if (_lmsProjectDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsProjectDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverID", int.class);

				method.invoke(_lmsProjectDetailsRemoteModel, ApproverID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApproverEmail() {
		return _ApproverEmail;
	}

	@Override
	public void setApproverEmail(String ApproverEmail) {
		_ApproverEmail = ApproverEmail;

		if (_lmsProjectDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsProjectDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverEmail", String.class);

				method.invoke(_lmsProjectDetailsRemoteModel, ApproverEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAssignmentID() {
		return _AssignmentID;
	}

	@Override
	public void setAssignmentID(int AssignmentID) {
		_AssignmentID = AssignmentID;

		if (_lmsProjectDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsProjectDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentID", int.class);

				method.invoke(_lmsProjectDetailsRemoteModel, AssignmentID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSProjectDetailsRemoteModel() {
		return _lmsProjectDetailsRemoteModel;
	}

	public void setLMSProjectDetailsRemoteModel(
		BaseModel<?> lmsProjectDetailsRemoteModel) {
		_lmsProjectDetailsRemoteModel = lmsProjectDetailsRemoteModel;
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

		Class<?> remoteModelClass = _lmsProjectDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsProjectDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSProjectDetailsLocalServiceUtil.addLMSProjectDetails(this);
		}
		else {
			LMSProjectDetailsLocalServiceUtil.updateLMSProjectDetails(this);
		}
	}

	@Override
	public LMSProjectDetails toEscapedModel() {
		return (LMSProjectDetails)ProxyUtil.newProxyInstance(LMSProjectDetails.class.getClassLoader(),
			new Class[] { LMSProjectDetails.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSProjectDetailsClp clone = new LMSProjectDetailsClp();

		clone.setEmployeeId(getEmployeeId());
		clone.setProjectCode(getProjectCode());
		clone.setProjectName(getProjectName());
		clone.setApproverName(getApproverName());
		clone.setApproverID(getApproverID());
		clone.setApproverEmail(getApproverEmail());
		clone.setAssignmentID(getAssignmentID());

		return clone;
	}

	@Override
	public int compareTo(LMSProjectDetails lmsProjectDetails) {
		int value = 0;

		if (getEmployeeId() < lmsProjectDetails.getEmployeeId()) {
			value = -1;
		}
		else if (getEmployeeId() > lmsProjectDetails.getEmployeeId()) {
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

		if (!(obj instanceof LMSProjectDetailsClp)) {
			return false;
		}

		LMSProjectDetailsClp lmsProjectDetails = (LMSProjectDetailsClp)obj;

		int primaryKey = lmsProjectDetails.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{EmployeeId=");
		sb.append(getEmployeeId());
		sb.append(", ProjectCode=");
		sb.append(getProjectCode());
		sb.append(", ProjectName=");
		sb.append(getProjectName());
		sb.append(", ApproverName=");
		sb.append(getApproverName());
		sb.append(", ApproverID=");
		sb.append(getApproverID());
		sb.append(", ApproverEmail=");
		sb.append(getApproverEmail());
		sb.append(", AssignmentID=");
		sb.append(getAssignmentID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSProjectDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>EmployeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ProjectCode</column-name><column-value><![CDATA[");
		sb.append(getProjectCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ProjectName</column-name><column-value><![CDATA[");
		sb.append(getProjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverName</column-name><column-value><![CDATA[");
		sb.append(getApproverName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverID</column-name><column-value><![CDATA[");
		sb.append(getApproverID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverEmail</column-name><column-value><![CDATA[");
		sb.append(getApproverEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AssignmentID</column-name><column-value><![CDATA[");
		sb.append(getAssignmentID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _EmployeeId;
	private String _ProjectCode;
	private String _ProjectName;
	private String _ApproverName;
	private int _ApproverID;
	private String _ApproverEmail;
	private int _AssignmentID;
	private BaseModel<?> _lmsProjectDetailsRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}