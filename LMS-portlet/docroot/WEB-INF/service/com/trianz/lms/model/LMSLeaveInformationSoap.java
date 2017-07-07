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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSLeaveInformationServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSLeaveInformationServiceSoap
 * @generated
 */
public class LMSLeaveInformationSoap implements Serializable {
	public static LMSLeaveInformationSoap toSoapModel(LMSLeaveInformation model) {
		LMSLeaveInformationSoap soapModel = new LMSLeaveInformationSoap();

		soapModel.setSNo(model.getSNo());
		soapModel.setLeaveRequestId(model.getLeaveRequestId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setAbsenceType(model.getAbsenceType());
		soapModel.setLeaveTypeCode(model.getLeaveTypeCode());
		soapModel.setLeaveCategoryCode(model.getLeaveCategoryCode());
		soapModel.setSupervisorID(model.getSupervisorID());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setDuration(model.getDuration());
		soapModel.setApprovalStatus(model.getApprovalStatus());
		soapModel.setComments(model.getComments());
		soapModel.setIsDraft(model.getIsDraft());
		soapModel.setApprovers(model.getApprovers());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setApproverEmails(model.getApproverEmails());

		return soapModel;
	}

	public static LMSLeaveInformationSoap[] toSoapModels(
		LMSLeaveInformation[] models) {
		LMSLeaveInformationSoap[] soapModels = new LMSLeaveInformationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSLeaveInformationSoap[][] toSoapModels(
		LMSLeaveInformation[][] models) {
		LMSLeaveInformationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSLeaveInformationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSLeaveInformationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSLeaveInformationSoap[] toSoapModels(
		List<LMSLeaveInformation> models) {
		List<LMSLeaveInformationSoap> soapModels = new ArrayList<LMSLeaveInformationSoap>(models.size());

		for (LMSLeaveInformation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSLeaveInformationSoap[soapModels.size()]);
	}

	public LMSLeaveInformationSoap() {
	}

	public int getPrimaryKey() {
		return _SNo;
	}

	public void setPrimaryKey(int pk) {
		setSNo(pk);
	}

	public int getSNo() {
		return _SNo;
	}

	public void setSNo(int SNo) {
		_SNo = SNo;
	}

	public String getLeaveRequestId() {
		return _LeaveRequestId;
	}

	public void setLeaveRequestId(String LeaveRequestId) {
		_LeaveRequestId = LeaveRequestId;
	}

	public int getEmployeeId() {
		return _EmployeeId;
	}

	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;
	}

	public String getAbsenceType() {
		return _AbsenceType;
	}

	public void setAbsenceType(String AbsenceType) {
		_AbsenceType = AbsenceType;
	}

	public int getLeaveTypeCode() {
		return _LeaveTypeCode;
	}

	public void setLeaveTypeCode(int LeaveTypeCode) {
		_LeaveTypeCode = LeaveTypeCode;
	}

	public String getLeaveCategoryCode() {
		return _LeaveCategoryCode;
	}

	public void setLeaveCategoryCode(String LeaveCategoryCode) {
		_LeaveCategoryCode = LeaveCategoryCode;
	}

	public int getSupervisorID() {
		return _SupervisorID;
	}

	public void setSupervisorID(int SupervisorID) {
		_SupervisorID = SupervisorID;
	}

	public Date getStartDate() {
		return _StartDate;
	}

	public void setStartDate(Date StartDate) {
		_StartDate = StartDate;
	}

	public Date getEndDate() {
		return _EndDate;
	}

	public void setEndDate(Date EndDate) {
		_EndDate = EndDate;
	}

	public double getDuration() {
		return _Duration;
	}

	public void setDuration(double Duration) {
		_Duration = Duration;
	}

	public String getApprovalStatus() {
		return _ApprovalStatus;
	}

	public void setApprovalStatus(String ApprovalStatus) {
		_ApprovalStatus = ApprovalStatus;
	}

	public String getComments() {
		return _Comments;
	}

	public void setComments(String Comments) {
		_Comments = Comments;
	}

	public String getIsDraft() {
		return _isDraft;
	}

	public void setIsDraft(String isDraft) {
		_isDraft = isDraft;
	}

	public int getApprovers() {
		return _Approvers;
	}

	public void setApprovers(int Approvers) {
		_Approvers = Approvers;
	}

	public Date getCreatedDate() {
		return _CreatedDate;
	}

	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;
	}

	public String getApproverEmails() {
		return _ApproverEmails;
	}

	public void setApproverEmails(String ApproverEmails) {
		_ApproverEmails = ApproverEmails;
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
}