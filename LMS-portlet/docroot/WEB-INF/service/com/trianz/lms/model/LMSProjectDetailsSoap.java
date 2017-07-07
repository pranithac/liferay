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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSProjectDetailsServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSProjectDetailsServiceSoap
 * @generated
 */
public class LMSProjectDetailsSoap implements Serializable {
	public static LMSProjectDetailsSoap toSoapModel(LMSProjectDetails model) {
		LMSProjectDetailsSoap soapModel = new LMSProjectDetailsSoap();

		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectCode(model.getProjectCode());
		soapModel.setProjectName(model.getProjectName());
		soapModel.setApproverName(model.getApproverName());
		soapModel.setApproverID(model.getApproverID());
		soapModel.setApproverEmail(model.getApproverEmail());
		soapModel.setAssignmentID(model.getAssignmentID());

		return soapModel;
	}

	public static LMSProjectDetailsSoap[] toSoapModels(
		LMSProjectDetails[] models) {
		LMSProjectDetailsSoap[] soapModels = new LMSProjectDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSProjectDetailsSoap[][] toSoapModels(
		LMSProjectDetails[][] models) {
		LMSProjectDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSProjectDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSProjectDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSProjectDetailsSoap[] toSoapModels(
		List<LMSProjectDetails> models) {
		List<LMSProjectDetailsSoap> soapModels = new ArrayList<LMSProjectDetailsSoap>(models.size());

		for (LMSProjectDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSProjectDetailsSoap[soapModels.size()]);
	}

	public LMSProjectDetailsSoap() {
	}

	public int getPrimaryKey() {
		return _AssignmentID;
	}

	public void setPrimaryKey(int pk) {
		setAssignmentID(pk);
	}

	public int getEmployeeId() {
		return _EmployeeId;
	}

	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;
	}

	public String getProjectCode() {
		return _ProjectCode;
	}

	public void setProjectCode(String ProjectCode) {
		_ProjectCode = ProjectCode;
	}

	public String getProjectName() {
		return _ProjectName;
	}

	public void setProjectName(String ProjectName) {
		_ProjectName = ProjectName;
	}

	public String getApproverName() {
		return _ApproverName;
	}

	public void setApproverName(String ApproverName) {
		_ApproverName = ApproverName;
	}

	public int getApproverID() {
		return _ApproverID;
	}

	public void setApproverID(int ApproverID) {
		_ApproverID = ApproverID;
	}

	public String getApproverEmail() {
		return _ApproverEmail;
	}

	public void setApproverEmail(String ApproverEmail) {
		_ApproverEmail = ApproverEmail;
	}

	public int getAssignmentID() {
		return _AssignmentID;
	}

	public void setAssignmentID(int AssignmentID) {
		_AssignmentID = AssignmentID;
	}

	private int _EmployeeId;
	private String _ProjectCode;
	private String _ProjectName;
	private String _ApproverName;
	private int _ApproverID;
	private String _ApproverEmail;
	private int _AssignmentID;
}