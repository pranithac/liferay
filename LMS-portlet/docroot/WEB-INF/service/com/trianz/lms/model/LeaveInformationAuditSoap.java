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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LeaveInformationAuditServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LeaveInformationAuditServiceSoap
 * @generated
 */
public class LeaveInformationAuditSoap implements Serializable {
	public static LeaveInformationAuditSoap toSoapModel(
		LeaveInformationAudit model) {
		LeaveInformationAuditSoap soapModel = new LeaveInformationAuditSoap();

		soapModel.setLogId(model.getLogId());
		soapModel.setLeaveRequestId(model.getLeaveRequestId());
		soapModel.setAction(model.getAction());
		soapModel.setActionBy(model.getActionBy());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static LeaveInformationAuditSoap[] toSoapModels(
		LeaveInformationAudit[] models) {
		LeaveInformationAuditSoap[] soapModels = new LeaveInformationAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveInformationAuditSoap[][] toSoapModels(
		LeaveInformationAudit[][] models) {
		LeaveInformationAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveInformationAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveInformationAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveInformationAuditSoap[] toSoapModels(
		List<LeaveInformationAudit> models) {
		List<LeaveInformationAuditSoap> soapModels = new ArrayList<LeaveInformationAuditSoap>(models.size());

		for (LeaveInformationAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveInformationAuditSoap[soapModels.size()]);
	}

	public LeaveInformationAuditSoap() {
	}

	public int getPrimaryKey() {
		return _LogId;
	}

	public void setPrimaryKey(int pk) {
		setLogId(pk);
	}

	public int getLogId() {
		return _LogId;
	}

	public void setLogId(int LogId) {
		_LogId = LogId;
	}

	public int getLeaveRequestId() {
		return _LeaveRequestId;
	}

	public void setLeaveRequestId(int LeaveRequestId) {
		_LeaveRequestId = LeaveRequestId;
	}

	public String getAction() {
		return _Action;
	}

	public void setAction(String Action) {
		_Action = Action;
	}

	public String getActionBy() {
		return _ActionBy;
	}

	public void setActionBy(String ActionBy) {
		_ActionBy = ActionBy;
	}

	public Date getCreatedDate() {
		return _CreatedDate;
	}

	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;
	}

	private int _LogId;
	private int _LeaveRequestId;
	private String _Action;
	private String _ActionBy;
	private Date _CreatedDate;
}