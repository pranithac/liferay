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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSLeavePoliciesServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSLeavePoliciesServiceSoap
 * @generated
 */
public class LMSLeavePoliciesSoap implements Serializable {
	public static LMSLeavePoliciesSoap toSoapModel(LMSLeavePolicies model) {
		LMSLeavePoliciesSoap soapModel = new LMSLeavePoliciesSoap();

		soapModel.setPolicyId(model.getPolicyId());
		soapModel.setProject(model.getProject());
		soapModel.setLeaveTypesApplicable(model.getLeaveTypesApplicable());
		soapModel.setLocationsApplicable(model.getLocationsApplicable());

		return soapModel;
	}

	public static LMSLeavePoliciesSoap[] toSoapModels(LMSLeavePolicies[] models) {
		LMSLeavePoliciesSoap[] soapModels = new LMSLeavePoliciesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSLeavePoliciesSoap[][] toSoapModels(
		LMSLeavePolicies[][] models) {
		LMSLeavePoliciesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSLeavePoliciesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSLeavePoliciesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSLeavePoliciesSoap[] toSoapModels(
		List<LMSLeavePolicies> models) {
		List<LMSLeavePoliciesSoap> soapModels = new ArrayList<LMSLeavePoliciesSoap>(models.size());

		for (LMSLeavePolicies model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSLeavePoliciesSoap[soapModels.size()]);
	}

	public LMSLeavePoliciesSoap() {
	}

	public int getPrimaryKey() {
		return _PolicyId;
	}

	public void setPrimaryKey(int pk) {
		setPolicyId(pk);
	}

	public int getPolicyId() {
		return _PolicyId;
	}

	public void setPolicyId(int PolicyId) {
		_PolicyId = PolicyId;
	}

	public String getProject() {
		return _Project;
	}

	public void setProject(String Project) {
		_Project = Project;
	}

	public String getLeaveTypesApplicable() {
		return _LeaveTypesApplicable;
	}

	public void setLeaveTypesApplicable(String LeaveTypesApplicable) {
		_LeaveTypesApplicable = LeaveTypesApplicable;
	}

	public String getLocationsApplicable() {
		return _LocationsApplicable;
	}

	public void setLocationsApplicable(String LocationsApplicable) {
		_LocationsApplicable = LocationsApplicable;
	}

	private int _PolicyId;
	private String _Project;
	private String _LeaveTypesApplicable;
	private String _LocationsApplicable;
}