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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.securaxEmployeeHrsServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.securaxEmployeeHrsServiceSoap
 * @generated
 */
public class securaxEmployeeHrsSoap implements Serializable {
	public static securaxEmployeeHrsSoap toSoapModel(securaxEmployeeHrs model) {
		securaxEmployeeHrsSoap soapModel = new securaxEmployeeHrsSoap();

		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setPunchDate(model.getPunchDate());
		soapModel.setPunchInTime(model.getPunchInTime());
		soapModel.setPunchOutTime(model.getPunchOutTime());
		soapModel.setWorkHrsPerday(model.getWorkHrsPerday());
		soapModel.setStatus(model.getStatus());
		soapModel.setOT(model.getOT());
		soapModel.setCreated_By(model.getCreated_By());
		soapModel.setCreated_Date(model.getCreated_Date());
		soapModel.setModified_By(model.getModified_By());
		soapModel.setModified_Date(model.getModified_Date());
		soapModel.setS_Id(model.getS_Id());

		return soapModel;
	}

	public static securaxEmployeeHrsSoap[] toSoapModels(
		securaxEmployeeHrs[] models) {
		securaxEmployeeHrsSoap[] soapModels = new securaxEmployeeHrsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static securaxEmployeeHrsSoap[][] toSoapModels(
		securaxEmployeeHrs[][] models) {
		securaxEmployeeHrsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new securaxEmployeeHrsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new securaxEmployeeHrsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static securaxEmployeeHrsSoap[] toSoapModels(
		List<securaxEmployeeHrs> models) {
		List<securaxEmployeeHrsSoap> soapModels = new ArrayList<securaxEmployeeHrsSoap>(models.size());

		for (securaxEmployeeHrs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new securaxEmployeeHrsSoap[soapModels.size()]);
	}

	public securaxEmployeeHrsSoap() {
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

	public Date getPunchDate() {
		return _PunchDate;
	}

	public void setPunchDate(Date PunchDate) {
		_PunchDate = PunchDate;
	}

	public Date getPunchInTime() {
		return _PunchInTime;
	}

	public void setPunchInTime(Date PunchInTime) {
		_PunchInTime = PunchInTime;
	}

	public Date getPunchOutTime() {
		return _PunchOutTime;
	}

	public void setPunchOutTime(Date PunchOutTime) {
		_PunchOutTime = PunchOutTime;
	}

	public Date getWorkHrsPerday() {
		return _WorkHrsPerday;
	}

	public void setWorkHrsPerday(Date WorkHrsPerday) {
		_WorkHrsPerday = WorkHrsPerday;
	}

	public String getStatus() {
		return _Status;
	}

	public void setStatus(String Status) {
		_Status = Status;
	}

	public Date getOT() {
		return _OT;
	}

	public void setOT(Date OT) {
		_OT = OT;
	}

	public int getCreated_By() {
		return _Created_By;
	}

	public void setCreated_By(int Created_By) {
		_Created_By = Created_By;
	}

	public Date getCreated_Date() {
		return _Created_Date;
	}

	public void setCreated_Date(Date Created_Date) {
		_Created_Date = Created_Date;
	}

	public int getModified_By() {
		return _Modified_By;
	}

	public void setModified_By(int Modified_By) {
		_Modified_By = Modified_By;
	}

	public Date getModified_Date() {
		return _Modified_Date;
	}

	public void setModified_Date(Date Modified_Date) {
		_Modified_Date = Modified_Date;
	}

	public int getS_Id() {
		return _S_Id;
	}

	public void setS_Id(int S_Id) {
		_S_Id = S_Id;
	}

	private int _EmployeeId;
	private Date _PunchDate;
	private Date _PunchInTime;
	private Date _PunchOutTime;
	private Date _WorkHrsPerday;
	private String _Status;
	private Date _OT;
	private int _Created_By;
	private Date _Created_Date;
	private int _Modified_By;
	private Date _Modified_Date;
	private int _S_Id;
}