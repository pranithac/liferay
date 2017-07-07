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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LeaveBalanceServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LeaveBalanceServiceSoap
 * @generated
 */
public class LeaveBalanceSoap implements Serializable {
	public static LeaveBalanceSoap toSoapModel(LeaveBalance model) {
		LeaveBalanceSoap soapModel = new LeaveBalanceSoap();

		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setELBalance(model.getELBalance());
		soapModel.setCLBalance(model.getCLBalance());
		soapModel.setCompOffLeaveBalance(model.getCompOffLeaveBalance());

		return soapModel;
	}

	public static LeaveBalanceSoap[] toSoapModels(LeaveBalance[] models) {
		LeaveBalanceSoap[] soapModels = new LeaveBalanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveBalanceSoap[][] toSoapModels(LeaveBalance[][] models) {
		LeaveBalanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveBalanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveBalanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveBalanceSoap[] toSoapModels(List<LeaveBalance> models) {
		List<LeaveBalanceSoap> soapModels = new ArrayList<LeaveBalanceSoap>(models.size());

		for (LeaveBalance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveBalanceSoap[soapModels.size()]);
	}

	public LeaveBalanceSoap() {
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

	public double getELBalance() {
		return _ELBalance;
	}

	public void setELBalance(double ELBalance) {
		_ELBalance = ELBalance;
	}

	public double getCLBalance() {
		return _CLBalance;
	}

	public void setCLBalance(double CLBalance) {
		_CLBalance = CLBalance;
	}

	public double getCompOffLeaveBalance() {
		return _CompOffLeaveBalance;
	}

	public void setCompOffLeaveBalance(double CompOffLeaveBalance) {
		_CompOffLeaveBalance = CompOffLeaveBalance;
	}

	private int _EmployeeId;
	private double _ELBalance;
	private double _CLBalance;
	private double _CompOffLeaveBalance;
}