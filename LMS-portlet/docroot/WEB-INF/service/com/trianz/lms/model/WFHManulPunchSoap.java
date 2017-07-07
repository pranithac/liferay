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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.WFHManulPunchServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.WFHManulPunchServiceSoap
 * @generated
 */
public class WFHManulPunchSoap implements Serializable {
	public static WFHManulPunchSoap toSoapModel(WFHManulPunch model) {
		WFHManulPunchSoap soapModel = new WFHManulPunchSoap();

		soapModel.setWFHManualPunchId(model.getWFHManualPunchId());
		soapModel.setWFHID(model.getWFHID());
		soapModel.setIntime(model.getIntime());
		soapModel.setOutTime(model.getOutTime());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPUNCHDATE(model.getPUNCHDATE());
		soapModel.setEmployeeID(model.getEmployeeID());
		soapModel.setIsApproved(model.getIsApproved());

		return soapModel;
	}

	public static WFHManulPunchSoap[] toSoapModels(WFHManulPunch[] models) {
		WFHManulPunchSoap[] soapModels = new WFHManulPunchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFHManulPunchSoap[][] toSoapModels(WFHManulPunch[][] models) {
		WFHManulPunchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFHManulPunchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFHManulPunchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFHManulPunchSoap[] toSoapModels(List<WFHManulPunch> models) {
		List<WFHManulPunchSoap> soapModels = new ArrayList<WFHManulPunchSoap>(models.size());

		for (WFHManulPunch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFHManulPunchSoap[soapModels.size()]);
	}

	public WFHManulPunchSoap() {
	}

	public int getPrimaryKey() {
		return _WFHManualPunchId;
	}

	public void setPrimaryKey(int pk) {
		setWFHManualPunchId(pk);
	}

	public int getWFHManualPunchId() {
		return _WFHManualPunchId;
	}

	public void setWFHManualPunchId(int WFHManualPunchId) {
		_WFHManualPunchId = WFHManualPunchId;
	}

	public int getWFHID() {
		return _WFHID;
	}

	public void setWFHID(int WFHID) {
		_WFHID = WFHID;
	}

	public Date getIntime() {
		return _Intime;
	}

	public void setIntime(Date Intime) {
		_Intime = Intime;
	}

	public Date getOutTime() {
		return _OutTime;
	}

	public void setOutTime(Date OutTime) {
		_OutTime = OutTime;
	}

	public String getCreatedBy() {
		return _CreatedBy;
	}

	public void setCreatedBy(String CreatedBy) {
		_CreatedBy = CreatedBy;
	}

	public Date getCreatedDate() {
		return _CreatedDate;
	}

	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;
	}

	public String getModifiedBy() {
		return _ModifiedBy;
	}

	public void setModifiedBy(String ModifiedBy) {
		_ModifiedBy = ModifiedBy;
	}

	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;
	}

	public Date getPUNCHDATE() {
		return _PUNCHDATE;
	}

	public void setPUNCHDATE(Date PUNCHDATE) {
		_PUNCHDATE = PUNCHDATE;
	}

	public int getEmployeeID() {
		return _EmployeeID;
	}

	public void setEmployeeID(int EmployeeID) {
		_EmployeeID = EmployeeID;
	}

	public boolean getIsApproved() {
		return _IsApproved;
	}

	public boolean isIsApproved() {
		return _IsApproved;
	}

	public void setIsApproved(boolean IsApproved) {
		_IsApproved = IsApproved;
	}

	private int _WFHManualPunchId;
	private int _WFHID;
	private Date _Intime;
	private Date _OutTime;
	private String _CreatedBy;
	private Date _CreatedDate;
	private String _ModifiedBy;
	private Date _ModifiedDate;
	private Date _PUNCHDATE;
	private int _EmployeeID;
	private boolean _IsApproved;
}