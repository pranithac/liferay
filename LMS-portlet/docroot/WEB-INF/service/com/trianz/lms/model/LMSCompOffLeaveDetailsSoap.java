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

import com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSCompOffLeaveDetailsServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSCompOffLeaveDetailsServiceSoap
 * @generated
 */
public class LMSCompOffLeaveDetailsSoap implements Serializable {
	public static LMSCompOffLeaveDetailsSoap toSoapModel(
		LMSCompOffLeaveDetails model) {
		LMSCompOffLeaveDetailsSoap soapModel = new LMSCompOffLeaveDetailsSoap();

		soapModel.setApprovedBy(model.getApprovedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setEmployeeID(model.getEmployeeID());
		soapModel.setStatus(model.getStatus());
		soapModel.setCompoffDate(model.getCompoffDate());
		soapModel.setCompOffId(model.getCompOffId());
		soapModel.setApproverEmployeeID(model.getApproverEmployeeID());

		return soapModel;
	}

	public static LMSCompOffLeaveDetailsSoap[] toSoapModels(
		LMSCompOffLeaveDetails[] models) {
		LMSCompOffLeaveDetailsSoap[] soapModels = new LMSCompOffLeaveDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSCompOffLeaveDetailsSoap[][] toSoapModels(
		LMSCompOffLeaveDetails[][] models) {
		LMSCompOffLeaveDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSCompOffLeaveDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSCompOffLeaveDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSCompOffLeaveDetailsSoap[] toSoapModels(
		List<LMSCompOffLeaveDetails> models) {
		List<LMSCompOffLeaveDetailsSoap> soapModels = new ArrayList<LMSCompOffLeaveDetailsSoap>(models.size());

		for (LMSCompOffLeaveDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSCompOffLeaveDetailsSoap[soapModels.size()]);
	}

	public LMSCompOffLeaveDetailsSoap() {
	}

	public LMSCompOffLeaveDetailsPK getPrimaryKey() {
		return new LMSCompOffLeaveDetailsPK(_EmployeeID, _CompoffDate);
	}

	public void setPrimaryKey(LMSCompOffLeaveDetailsPK pk) {
		setEmployeeID(pk.EmployeeID);
		setCompoffDate(pk.CompoffDate);
	}

	public String getApprovedBy() {
		return _ApprovedBy;
	}

	public void setApprovedBy(String ApprovedBy) {
		_ApprovedBy = ApprovedBy;
	}

	public Date getCreatedDate() {
		return _CreatedDate;
	}

	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;
	}

	public int getEmployeeID() {
		return _EmployeeID;
	}

	public void setEmployeeID(int EmployeeID) {
		_EmployeeID = EmployeeID;
	}

	public String getStatus() {
		return _Status;
	}

	public void setStatus(String Status) {
		_Status = Status;
	}

	public Date getCompoffDate() {
		return _CompoffDate;
	}

	public void setCompoffDate(Date CompoffDate) {
		_CompoffDate = CompoffDate;
	}

	public int getCompOffId() {
		return _CompOffId;
	}

	public void setCompOffId(int CompOffId) {
		_CompOffId = CompOffId;
	}

	public int getApproverEmployeeID() {
		return _ApproverEmployeeID;
	}

	public void setApproverEmployeeID(int ApproverEmployeeID) {
		_ApproverEmployeeID = ApproverEmployeeID;
	}

	private String _ApprovedBy;
	private Date _CreatedDate;
	private int _EmployeeID;
	private String _Status;
	private Date _CompoffDate;
	private int _CompOffId;
	private int _ApproverEmployeeID;
}