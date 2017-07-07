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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LeaveApprovalHistoryServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LeaveApprovalHistoryServiceSoap
 * @generated
 */
public class LeaveApprovalHistorySoap implements Serializable {
	public static LeaveApprovalHistorySoap toSoapModel(
		LeaveApprovalHistory model) {
		LeaveApprovalHistorySoap soapModel = new LeaveApprovalHistorySoap();

		soapModel.setSNo(model.getSNo());
		soapModel.setLeaveRequestId(model.getLeaveRequestId());
		soapModel.setApproverID(model.getApproverID());
		soapModel.setLeaveStatus(model.getLeaveStatus());

		return soapModel;
	}

	public static LeaveApprovalHistorySoap[] toSoapModels(
		LeaveApprovalHistory[] models) {
		LeaveApprovalHistorySoap[] soapModels = new LeaveApprovalHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveApprovalHistorySoap[][] toSoapModels(
		LeaveApprovalHistory[][] models) {
		LeaveApprovalHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveApprovalHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveApprovalHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveApprovalHistorySoap[] toSoapModels(
		List<LeaveApprovalHistory> models) {
		List<LeaveApprovalHistorySoap> soapModels = new ArrayList<LeaveApprovalHistorySoap>(models.size());

		for (LeaveApprovalHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveApprovalHistorySoap[soapModels.size()]);
	}

	public LeaveApprovalHistorySoap() {
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

	public int getApproverID() {
		return _ApproverID;
	}

	public void setApproverID(int ApproverID) {
		_ApproverID = ApproverID;
	}

	public String getLeaveStatus() {
		return _LeaveStatus;
	}

	public void setLeaveStatus(String LeaveStatus) {
		_LeaveStatus = LeaveStatus;
	}

	private int _SNo;
	private String _LeaveRequestId;
	private int _ApproverID;
	private String _LeaveStatus;
}