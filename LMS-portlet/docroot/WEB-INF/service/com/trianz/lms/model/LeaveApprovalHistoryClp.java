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
import com.trianz.lms.service.LeaveApprovalHistoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LeaveApprovalHistoryClp extends BaseModelImpl<LeaveApprovalHistory>
	implements LeaveApprovalHistory {
	public LeaveApprovalHistoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveApprovalHistory.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveApprovalHistory.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _SNo;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setSNo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _SNo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SNo", getSNo());
		attributes.put("LeaveRequestId", getLeaveRequestId());
		attributes.put("ApproverID", getApproverID());
		attributes.put("LeaveStatus", getLeaveStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer SNo = (Integer)attributes.get("SNo");

		if (SNo != null) {
			setSNo(SNo);
		}

		String LeaveRequestId = (String)attributes.get("LeaveRequestId");

		if (LeaveRequestId != null) {
			setLeaveRequestId(LeaveRequestId);
		}

		Integer ApproverID = (Integer)attributes.get("ApproverID");

		if (ApproverID != null) {
			setApproverID(ApproverID);
		}

		String LeaveStatus = (String)attributes.get("LeaveStatus");

		if (LeaveStatus != null) {
			setLeaveStatus(LeaveStatus);
		}
	}

	@Override
	public int getSNo() {
		return _SNo;
	}

	@Override
	public void setSNo(int SNo) {
		_SNo = SNo;

		if (_leaveApprovalHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _leaveApprovalHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSNo", int.class);

				method.invoke(_leaveApprovalHistoryRemoteModel, SNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveRequestId() {
		return _LeaveRequestId;
	}

	@Override
	public void setLeaveRequestId(String LeaveRequestId) {
		_LeaveRequestId = LeaveRequestId;

		if (_leaveApprovalHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _leaveApprovalHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRequestId",
						String.class);

				method.invoke(_leaveApprovalHistoryRemoteModel, LeaveRequestId);
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

		if (_leaveApprovalHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _leaveApprovalHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverID", int.class);

				method.invoke(_leaveApprovalHistoryRemoteModel, ApproverID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveStatus() {
		return _LeaveStatus;
	}

	@Override
	public void setLeaveStatus(String LeaveStatus) {
		_LeaveStatus = LeaveStatus;

		if (_leaveApprovalHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _leaveApprovalHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveStatus", String.class);

				method.invoke(_leaveApprovalHistoryRemoteModel, LeaveStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveApprovalHistoryRemoteModel() {
		return _leaveApprovalHistoryRemoteModel;
	}

	public void setLeaveApprovalHistoryRemoteModel(
		BaseModel<?> leaveApprovalHistoryRemoteModel) {
		_leaveApprovalHistoryRemoteModel = leaveApprovalHistoryRemoteModel;
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

		Class<?> remoteModelClass = _leaveApprovalHistoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveApprovalHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveApprovalHistoryLocalServiceUtil.addLeaveApprovalHistory(this);
		}
		else {
			LeaveApprovalHistoryLocalServiceUtil.updateLeaveApprovalHistory(this);
		}
	}

	@Override
	public LeaveApprovalHistory toEscapedModel() {
		return (LeaveApprovalHistory)ProxyUtil.newProxyInstance(LeaveApprovalHistory.class.getClassLoader(),
			new Class[] { LeaveApprovalHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveApprovalHistoryClp clone = new LeaveApprovalHistoryClp();

		clone.setSNo(getSNo());
		clone.setLeaveRequestId(getLeaveRequestId());
		clone.setApproverID(getApproverID());
		clone.setLeaveStatus(getLeaveStatus());

		return clone;
	}

	@Override
	public int compareTo(LeaveApprovalHistory leaveApprovalHistory) {
		int primaryKey = leaveApprovalHistory.getPrimaryKey();

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

		if (!(obj instanceof LeaveApprovalHistoryClp)) {
			return false;
		}

		LeaveApprovalHistoryClp leaveApprovalHistory = (LeaveApprovalHistoryClp)obj;

		int primaryKey = leaveApprovalHistory.getPrimaryKey();

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

		sb.append("{SNo=");
		sb.append(getSNo());
		sb.append(", LeaveRequestId=");
		sb.append(getLeaveRequestId());
		sb.append(", ApproverID=");
		sb.append(getApproverID());
		sb.append(", LeaveStatus=");
		sb.append(getLeaveStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LeaveApprovalHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>SNo</column-name><column-value><![CDATA[");
		sb.append(getSNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveRequestId</column-name><column-value><![CDATA[");
		sb.append(getLeaveRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverID</column-name><column-value><![CDATA[");
		sb.append(getApproverID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveStatus</column-name><column-value><![CDATA[");
		sb.append(getLeaveStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _SNo;
	private String _LeaveRequestId;
	private int _ApproverID;
	private String _LeaveStatus;
	private BaseModel<?> _leaveApprovalHistoryRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}