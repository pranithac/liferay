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
import com.trianz.lms.service.LeaveInformationAuditLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LeaveInformationAuditClp extends BaseModelImpl<LeaveInformationAudit>
	implements LeaveInformationAudit {
	public LeaveInformationAuditClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveInformationAudit.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveInformationAudit.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _LogId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _LogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LogId", getLogId());
		attributes.put("LeaveRequestId", getLeaveRequestId());
		attributes.put("Action", getAction());
		attributes.put("ActionBy", getActionBy());
		attributes.put("CreatedDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer LogId = (Integer)attributes.get("LogId");

		if (LogId != null) {
			setLogId(LogId);
		}

		Integer LeaveRequestId = (Integer)attributes.get("LeaveRequestId");

		if (LeaveRequestId != null) {
			setLeaveRequestId(LeaveRequestId);
		}

		String Action = (String)attributes.get("Action");

		if (Action != null) {
			setAction(Action);
		}

		String ActionBy = (String)attributes.get("ActionBy");

		if (ActionBy != null) {
			setActionBy(ActionBy);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}
	}

	@Override
	public int getLogId() {
		return _LogId;
	}

	@Override
	public void setLogId(int LogId) {
		_LogId = LogId;

		if (_leaveInformationAuditRemoteModel != null) {
			try {
				Class<?> clazz = _leaveInformationAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setLogId", int.class);

				method.invoke(_leaveInformationAuditRemoteModel, LogId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLeaveRequestId() {
		return _LeaveRequestId;
	}

	@Override
	public void setLeaveRequestId(int LeaveRequestId) {
		_LeaveRequestId = LeaveRequestId;

		if (_leaveInformationAuditRemoteModel != null) {
			try {
				Class<?> clazz = _leaveInformationAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRequestId", int.class);

				method.invoke(_leaveInformationAuditRemoteModel, LeaveRequestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAction() {
		return _Action;
	}

	@Override
	public void setAction(String Action) {
		_Action = Action;

		if (_leaveInformationAuditRemoteModel != null) {
			try {
				Class<?> clazz = _leaveInformationAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", String.class);

				method.invoke(_leaveInformationAuditRemoteModel, Action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActionBy() {
		return _ActionBy;
	}

	@Override
	public void setActionBy(String ActionBy) {
		_ActionBy = ActionBy;

		if (_leaveInformationAuditRemoteModel != null) {
			try {
				Class<?> clazz = _leaveInformationAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setActionBy", String.class);

				method.invoke(_leaveInformationAuditRemoteModel, ActionBy);
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

		if (_leaveInformationAuditRemoteModel != null) {
			try {
				Class<?> clazz = _leaveInformationAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_leaveInformationAuditRemoteModel, CreatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveInformationAuditRemoteModel() {
		return _leaveInformationAuditRemoteModel;
	}

	public void setLeaveInformationAuditRemoteModel(
		BaseModel<?> leaveInformationAuditRemoteModel) {
		_leaveInformationAuditRemoteModel = leaveInformationAuditRemoteModel;
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

		Class<?> remoteModelClass = _leaveInformationAuditRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveInformationAuditRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(this);
		}
		else {
			LeaveInformationAuditLocalServiceUtil.updateLeaveInformationAudit(this);
		}
	}

	@Override
	public LeaveInformationAudit toEscapedModel() {
		return (LeaveInformationAudit)ProxyUtil.newProxyInstance(LeaveInformationAudit.class.getClassLoader(),
			new Class[] { LeaveInformationAudit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveInformationAuditClp clone = new LeaveInformationAuditClp();

		clone.setLogId(getLogId());
		clone.setLeaveRequestId(getLeaveRequestId());
		clone.setAction(getAction());
		clone.setActionBy(getActionBy());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(LeaveInformationAudit leaveInformationAudit) {
		int primaryKey = leaveInformationAudit.getPrimaryKey();

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

		if (!(obj instanceof LeaveInformationAuditClp)) {
			return false;
		}

		LeaveInformationAuditClp leaveInformationAudit = (LeaveInformationAuditClp)obj;

		int primaryKey = leaveInformationAudit.getPrimaryKey();

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

		sb.append("{LogId=");
		sb.append(getLogId());
		sb.append(", LeaveRequestId=");
		sb.append(getLeaveRequestId());
		sb.append(", Action=");
		sb.append(getAction());
		sb.append(", ActionBy=");
		sb.append(getActionBy());
		sb.append(", CreatedDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LeaveInformationAudit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>LogId</column-name><column-value><![CDATA[");
		sb.append(getLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveRequestId</column-name><column-value><![CDATA[");
		sb.append(getLeaveRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ActionBy</column-name><column-value><![CDATA[");
		sb.append(getActionBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreatedDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _LogId;
	private int _LeaveRequestId;
	private String _Action;
	private String _ActionBy;
	private Date _CreatedDate;
	private BaseModel<?> _leaveInformationAuditRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}