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
import com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSLeaveInformationClp extends BaseModelImpl<LMSLeaveInformation>
	implements LMSLeaveInformation {
	public LMSLeaveInformationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LMSLeaveInformation.class;
	}

	@Override
	public String getModelClassName() {
		return LMSLeaveInformation.class.getName();
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
		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("AbsenceType", getAbsenceType());
		attributes.put("LeaveTypeCode", getLeaveTypeCode());
		attributes.put("LeaveCategoryCode", getLeaveCategoryCode());
		attributes.put("SupervisorID", getSupervisorID());
		attributes.put("StartDate", getStartDate());
		attributes.put("EndDate", getEndDate());
		attributes.put("Duration", getDuration());
		attributes.put("ApprovalStatus", getApprovalStatus());
		attributes.put("Comments", getComments());
		attributes.put("isDraft", getIsDraft());
		attributes.put("Approvers", getApprovers());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("ApproverEmails", getApproverEmails());

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

		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		String AbsenceType = (String)attributes.get("AbsenceType");

		if (AbsenceType != null) {
			setAbsenceType(AbsenceType);
		}

		Integer LeaveTypeCode = (Integer)attributes.get("LeaveTypeCode");

		if (LeaveTypeCode != null) {
			setLeaveTypeCode(LeaveTypeCode);
		}

		String LeaveCategoryCode = (String)attributes.get("LeaveCategoryCode");

		if (LeaveCategoryCode != null) {
			setLeaveCategoryCode(LeaveCategoryCode);
		}

		Integer SupervisorID = (Integer)attributes.get("SupervisorID");

		if (SupervisorID != null) {
			setSupervisorID(SupervisorID);
		}

		Date StartDate = (Date)attributes.get("StartDate");

		if (StartDate != null) {
			setStartDate(StartDate);
		}

		Date EndDate = (Date)attributes.get("EndDate");

		if (EndDate != null) {
			setEndDate(EndDate);
		}

		Double Duration = (Double)attributes.get("Duration");

		if (Duration != null) {
			setDuration(Duration);
		}

		String ApprovalStatus = (String)attributes.get("ApprovalStatus");

		if (ApprovalStatus != null) {
			setApprovalStatus(ApprovalStatus);
		}

		String Comments = (String)attributes.get("Comments");

		if (Comments != null) {
			setComments(Comments);
		}

		String isDraft = (String)attributes.get("isDraft");

		if (isDraft != null) {
			setIsDraft(isDraft);
		}

		Integer Approvers = (Integer)attributes.get("Approvers");

		if (Approvers != null) {
			setApprovers(Approvers);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		String ApproverEmails = (String)attributes.get("ApproverEmails");

		if (ApproverEmails != null) {
			setApproverEmails(ApproverEmails);
		}
	}

	@Override
	public int getSNo() {
		return _SNo;
	}

	@Override
	public void setSNo(int SNo) {
		_SNo = SNo;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setSNo", int.class);

				method.invoke(_lmsLeaveInformationRemoteModel, SNo);
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

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRequestId",
						String.class);

				method.invoke(_lmsLeaveInformationRemoteModel, LeaveRequestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEmployeeId() {
		return _EmployeeId;
	}

	@Override
	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", int.class);

				method.invoke(_lmsLeaveInformationRemoteModel, EmployeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAbsenceType() {
		return _AbsenceType;
	}

	@Override
	public void setAbsenceType(String AbsenceType) {
		_AbsenceType = AbsenceType;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setAbsenceType", String.class);

				method.invoke(_lmsLeaveInformationRemoteModel, AbsenceType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLeaveTypeCode() {
		return _LeaveTypeCode;
	}

	@Override
	public void setLeaveTypeCode(int LeaveTypeCode) {
		_LeaveTypeCode = LeaveTypeCode;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeCode", int.class);

				method.invoke(_lmsLeaveInformationRemoteModel, LeaveTypeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveCategoryCode() {
		return _LeaveCategoryCode;
	}

	@Override
	public void setLeaveCategoryCode(String LeaveCategoryCode) {
		_LeaveCategoryCode = LeaveCategoryCode;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveCategoryCode",
						String.class);

				method.invoke(_lmsLeaveInformationRemoteModel, LeaveCategoryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSupervisorID() {
		return _SupervisorID;
	}

	@Override
	public void setSupervisorID(int SupervisorID) {
		_SupervisorID = SupervisorID;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorID", int.class);

				method.invoke(_lmsLeaveInformationRemoteModel, SupervisorID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _StartDate;
	}

	@Override
	public void setStartDate(Date StartDate) {
		_StartDate = StartDate;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_lmsLeaveInformationRemoteModel, StartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _EndDate;
	}

	@Override
	public void setEndDate(Date EndDate) {
		_EndDate = EndDate;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_lmsLeaveInformationRemoteModel, EndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getDuration() {
		return _Duration;
	}

	@Override
	public void setDuration(double Duration) {
		_Duration = Duration;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", double.class);

				method.invoke(_lmsLeaveInformationRemoteModel, Duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApprovalStatus() {
		return _ApprovalStatus;
	}

	@Override
	public void setApprovalStatus(String ApprovalStatus) {
		_ApprovalStatus = ApprovalStatus;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovalStatus",
						String.class);

				method.invoke(_lmsLeaveInformationRemoteModel, ApprovalStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _Comments;
	}

	@Override
	public void setComments(String Comments) {
		_Comments = Comments;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_lmsLeaveInformationRemoteModel, Comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsDraft() {
		return _isDraft;
	}

	@Override
	public void setIsDraft(String isDraft) {
		_isDraft = isDraft;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsDraft", String.class);

				method.invoke(_lmsLeaveInformationRemoteModel, isDraft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApprovers() {
		return _Approvers;
	}

	@Override
	public void setApprovers(int Approvers) {
		_Approvers = Approvers;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovers", int.class);

				method.invoke(_lmsLeaveInformationRemoteModel, Approvers);
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

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_lmsLeaveInformationRemoteModel, CreatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApproverEmails() {
		return _ApproverEmails;
	}

	@Override
	public void setApproverEmails(String ApproverEmails) {
		_ApproverEmails = ApproverEmails;

		if (_lmsLeaveInformationRemoteModel != null) {
			try {
				Class<?> clazz = _lmsLeaveInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverEmails",
						String.class);

				method.invoke(_lmsLeaveInformationRemoteModel, ApproverEmails);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSLeaveInformationRemoteModel() {
		return _lmsLeaveInformationRemoteModel;
	}

	public void setLMSLeaveInformationRemoteModel(
		BaseModel<?> lmsLeaveInformationRemoteModel) {
		_lmsLeaveInformationRemoteModel = lmsLeaveInformationRemoteModel;
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

		Class<?> remoteModelClass = _lmsLeaveInformationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsLeaveInformationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSLeaveInformationLocalServiceUtil.addLMSLeaveInformation(this);
		}
		else {
			LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(this);
		}
	}

	@Override
	public LMSLeaveInformation toEscapedModel() {
		return (LMSLeaveInformation)ProxyUtil.newProxyInstance(LMSLeaveInformation.class.getClassLoader(),
			new Class[] { LMSLeaveInformation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSLeaveInformationClp clone = new LMSLeaveInformationClp();

		clone.setSNo(getSNo());
		clone.setLeaveRequestId(getLeaveRequestId());
		clone.setEmployeeId(getEmployeeId());
		clone.setAbsenceType(getAbsenceType());
		clone.setLeaveTypeCode(getLeaveTypeCode());
		clone.setLeaveCategoryCode(getLeaveCategoryCode());
		clone.setSupervisorID(getSupervisorID());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setDuration(getDuration());
		clone.setApprovalStatus(getApprovalStatus());
		clone.setComments(getComments());
		clone.setIsDraft(getIsDraft());
		clone.setApprovers(getApprovers());
		clone.setCreatedDate(getCreatedDate());
		clone.setApproverEmails(getApproverEmails());

		return clone;
	}

	@Override
	public int compareTo(LMSLeaveInformation lmsLeaveInformation) {
		int value = 0;

		value = getLeaveRequestId()
					.compareTo(lmsLeaveInformation.getLeaveRequestId());

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

		if (!(obj instanceof LMSLeaveInformationClp)) {
			return false;
		}

		LMSLeaveInformationClp lmsLeaveInformation = (LMSLeaveInformationClp)obj;

		int primaryKey = lmsLeaveInformation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{SNo=");
		sb.append(getSNo());
		sb.append(", LeaveRequestId=");
		sb.append(getLeaveRequestId());
		sb.append(", EmployeeId=");
		sb.append(getEmployeeId());
		sb.append(", AbsenceType=");
		sb.append(getAbsenceType());
		sb.append(", LeaveTypeCode=");
		sb.append(getLeaveTypeCode());
		sb.append(", LeaveCategoryCode=");
		sb.append(getLeaveCategoryCode());
		sb.append(", SupervisorID=");
		sb.append(getSupervisorID());
		sb.append(", StartDate=");
		sb.append(getStartDate());
		sb.append(", EndDate=");
		sb.append(getEndDate());
		sb.append(", Duration=");
		sb.append(getDuration());
		sb.append(", ApprovalStatus=");
		sb.append(getApprovalStatus());
		sb.append(", Comments=");
		sb.append(getComments());
		sb.append(", isDraft=");
		sb.append(getIsDraft());
		sb.append(", Approvers=");
		sb.append(getApprovers());
		sb.append(", CreatedDate=");
		sb.append(getCreatedDate());
		sb.append(", ApproverEmails=");
		sb.append(getApproverEmails());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSLeaveInformation");
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
			"<column><column-name>EmployeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AbsenceType</column-name><column-value><![CDATA[");
		sb.append(getAbsenceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveTypeCode</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveCategoryCode</column-name><column-value><![CDATA[");
		sb.append(getLeaveCategoryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SupervisorID</column-name><column-value><![CDATA[");
		sb.append(getSupervisorID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>StartDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EndDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApprovalStatus</column-name><column-value><![CDATA[");
		sb.append(getApprovalStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDraft</column-name><column-value><![CDATA[");
		sb.append(getIsDraft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Approvers</column-name><column-value><![CDATA[");
		sb.append(getApprovers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreatedDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverEmails</column-name><column-value><![CDATA[");
		sb.append(getApproverEmails());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _SNo;
	private String _LeaveRequestId;
	private int _EmployeeId;
	private String _AbsenceType;
	private int _LeaveTypeCode;
	private String _LeaveCategoryCode;
	private int _SupervisorID;
	private Date _StartDate;
	private Date _EndDate;
	private double _Duration;
	private String _ApprovalStatus;
	private String _Comments;
	private String _isDraft;
	private int _Approvers;
	private Date _CreatedDate;
	private String _ApproverEmails;
	private BaseModel<?> _lmsLeaveInformationRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}