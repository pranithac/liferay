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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSEmployeeDetailsServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSEmployeeDetailsServiceSoap
 * @generated
 */
public class LMSEmployeeDetailsSoap implements Serializable {
	public static LMSEmployeeDetailsSoap toSoapModel(LMSEmployeeDetails model) {
		LMSEmployeeDetailsSoap soapModel = new LMSEmployeeDetailsSoap();

		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setEmployeeName(model.getEmployeeName());
		soapModel.setEmployeeEmailID(model.getEmployeeEmailID());
		soapModel.setJoiningDate(model.getJoiningDate());
		soapModel.setSupervisorId(model.getSupervisorId());
		soapModel.setSupervisorName(model.getSupervisorName());
		soapModel.setSupervisorEmail(model.getSupervisorEmail());
		soapModel.setLocation(model.getLocation());
		soapModel.setRegion(model.getRegion());

		return soapModel;
	}

	public static LMSEmployeeDetailsSoap[] toSoapModels(
		LMSEmployeeDetails[] models) {
		LMSEmployeeDetailsSoap[] soapModels = new LMSEmployeeDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSEmployeeDetailsSoap[][] toSoapModels(
		LMSEmployeeDetails[][] models) {
		LMSEmployeeDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSEmployeeDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSEmployeeDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSEmployeeDetailsSoap[] toSoapModels(
		List<LMSEmployeeDetails> models) {
		List<LMSEmployeeDetailsSoap> soapModels = new ArrayList<LMSEmployeeDetailsSoap>(models.size());

		for (LMSEmployeeDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSEmployeeDetailsSoap[soapModels.size()]);
	}

	public LMSEmployeeDetailsSoap() {
	}

	public int getPrimaryKey() {
		return _EmployeeId;
	}

	public void setPrimaryKey(int pk) {
		setEmployeeId(pk);
	}

	public int getEmployeeId() {
		return _EmployeeId;
	}

	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;
	}

	public String getEmployeeName() {
		return _EmployeeName;
	}

	public void setEmployeeName(String EmployeeName) {
		_EmployeeName = EmployeeName;
	}

	public String getEmployeeEmailID() {
		return _EmployeeEmailID;
	}

	public void setEmployeeEmailID(String EmployeeEmailID) {
		_EmployeeEmailID = EmployeeEmailID;
	}

	public Date getJoiningDate() {
		return _JoiningDate;
	}

	public void setJoiningDate(Date JoiningDate) {
		_JoiningDate = JoiningDate;
	}

	public int getSupervisorId() {
		return _SupervisorId;
	}

	public void setSupervisorId(int SupervisorId) {
		_SupervisorId = SupervisorId;
	}

	public String getSupervisorName() {
		return _SupervisorName;
	}

	public void setSupervisorName(String SupervisorName) {
		_SupervisorName = SupervisorName;
	}

	public String getSupervisorEmail() {
		return _SupervisorEmail;
	}

	public void setSupervisorEmail(String SupervisorEmail) {
		_SupervisorEmail = SupervisorEmail;
	}

	public String getLocation() {
		return _Location;
	}

	public void setLocation(String Location) {
		_Location = Location;
	}

	public String getRegion() {
		return _Region;
	}

	public void setRegion(String Region) {
		_Region = Region;
	}

	private int _EmployeeId;
	private String _EmployeeName;
	private String _EmployeeEmailID;
	private Date _JoiningDate;
	private int _SupervisorId;
	private String _SupervisorName;
	private String _SupervisorEmail;
	private String _Location;
	private String _Region;
}