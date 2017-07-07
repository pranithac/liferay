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
import com.trianz.lms.service.LMSLeavePoliciesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSLeavePoliciesClp extends BaseModelImpl<LMSLeavePolicies>
	implements LMSLeavePolicies {
	public LMSLeavePoliciesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LMSLeavePolicies.class;
	}

	@Override
	public String getModelClassName() {
		return LMSLeavePolicies.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _PolicyId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setPolicyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PolicyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PolicyId", getPolicyId());
		attributes.put("Project", getProject());
		attributes.put("LeaveTypesApplicable", getLeaveTypesApplicable());
		attributes.put("LocationsApplicable", getLocationsApplicable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer PolicyId = (Integer)attributes.get("PolicyId");

		if (PolicyId != null) {
			setPolicyId(PolicyId);
		}

		String Project = (String)attributes.get("Project");

		if (Project != null) {
			setProject(Project);
		}

		String LeaveTypesApplicable = (String)attributes.get(
				"LeaveTypesApplicable");

		if (LeaveTypesApplicable != null) {
			setLeaveTypesApplicable(LeaveTypesApplicable);
		}

		String LocationsApplicable = (String)attributes.get(
				"LocationsApplicable");

		if (LocationsApplicable != null) {
			setLocationsApplicable(LocationsApplicable);
		}
	}

	@Override
	public int getPolicyId() {
		return _PolicyId;
	}

	@Override
	public void setPolicyId(int PolicyId) {
		_PolicyId = PolicyId;

		if (_lmsLeavePoliciesRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeavePoliciesRemoteModel.getClass();

				Method method = clazz.getMethod("setPolicyId", int.class);

				method.invoke(_lmsLeavePoliciesRemoteModel, PolicyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProject() {
		return _Project;
	}

	@Override
	public void setProject(String Project) {
		_Project = Project;

		if (_lmsLeavePoliciesRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeavePoliciesRemoteModel.getClass();

				Method method = clazz.getMethod("setProject", String.class);

				method.invoke(_lmsLeavePoliciesRemoteModel, Project);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveTypesApplicable() {
		return _LeaveTypesApplicable;
	}

	@Override
	public void setLeaveTypesApplicable(String LeaveTypesApplicable) {
		_LeaveTypesApplicable = LeaveTypesApplicable;

		if (_lmsLeavePoliciesRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeavePoliciesRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypesApplicable",
						String.class);

				method.invoke(_lmsLeavePoliciesRemoteModel, LeaveTypesApplicable);
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

		if (_lmsLeavePoliciesRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeavePoliciesRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationsApplicable",
						String.class);

				method.invoke(_lmsLeavePoliciesRemoteModel, LocationsApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSLeavePoliciesRemoteModel() {
		return _lmsLeavePoliciesRemoteModel;
	}

	public void setLMSLeavePoliciesRemoteModel(
		BaseModel<?> lmsLeavePoliciesRemoteModel) {
		_lmsLeavePoliciesRemoteModel = lmsLeavePoliciesRemoteModel;
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

		Class<?> remoteModelClass = _lmsLeavePoliciesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsLeavePoliciesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSLeavePoliciesLocalServiceUtil.addLMSLeavePolicies(this);
		}
		else {
			LMSLeavePoliciesLocalServiceUtil.updateLMSLeavePolicies(this);
		}
	}

	@Override
	public LMSLeavePolicies toEscapedModel() {
		return (LMSLeavePolicies)ProxyUtil.newProxyInstance(LMSLeavePolicies.class.getClassLoader(),
			new Class[] { LMSLeavePolicies.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSLeavePoliciesClp clone = new LMSLeavePoliciesClp();

		clone.setPolicyId(getPolicyId());
		clone.setProject(getProject());
		clone.setLeaveTypesApplicable(getLeaveTypesApplicable());
		clone.setLocationsApplicable(getLocationsApplicable());

		return clone;
	}

	@Override
	public int compareTo(LMSLeavePolicies lmsLeavePolicies) {
		int primaryKey = lmsLeavePolicies.getPrimaryKey();

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

		if (!(obj instanceof LMSLeavePoliciesClp)) {
			return false;
		}

		LMSLeavePoliciesClp lmsLeavePolicies = (LMSLeavePoliciesClp)obj;

		int primaryKey = lmsLeavePolicies.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{PolicyId=");
		sb.append(getPolicyId());
		sb.append(", Project=");
		sb.append(getProject());
		sb.append(", LeaveTypesApplicable=");
		sb.append(getLeaveTypesApplicable());
		sb.append(", LocationsApplicable=");
		sb.append(getLocationsApplicable());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSLeavePolicies");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PolicyId</column-name><column-value><![CDATA[");
		sb.append(getPolicyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Project</column-name><column-value><![CDATA[");
		sb.append(getProject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveTypesApplicable</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypesApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LocationsApplicable</column-name><column-value><![CDATA[");
		sb.append(getLocationsApplicable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _PolicyId;
	private String _Project;
	private String _LeaveTypesApplicable;
	private String _LocationsApplicable;
	private BaseModel<?> _lmsLeavePoliciesRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}