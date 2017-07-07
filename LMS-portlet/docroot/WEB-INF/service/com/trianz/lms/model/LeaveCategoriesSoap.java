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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LeaveCategoriesServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LeaveCategoriesServiceSoap
 * @generated
 */
public class LeaveCategoriesSoap implements Serializable {
	public static LeaveCategoriesSoap toSoapModel(LeaveCategories model) {
		LeaveCategoriesSoap soapModel = new LeaveCategoriesSoap();

		soapModel.setLeaveCategoryCode(model.getLeaveCategoryCode());
		soapModel.setLeaveCategory(model.getLeaveCategory());
		soapModel.setLeaveTypeCode(model.getLeaveTypeCode());

		return soapModel;
	}

	public static LeaveCategoriesSoap[] toSoapModels(LeaveCategories[] models) {
		LeaveCategoriesSoap[] soapModels = new LeaveCategoriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveCategoriesSoap[][] toSoapModels(
		LeaveCategories[][] models) {
		LeaveCategoriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveCategoriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveCategoriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveCategoriesSoap[] toSoapModels(
		List<LeaveCategories> models) {
		List<LeaveCategoriesSoap> soapModels = new ArrayList<LeaveCategoriesSoap>(models.size());

		for (LeaveCategories model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveCategoriesSoap[soapModels.size()]);
	}

	public LeaveCategoriesSoap() {
	}

	public int getPrimaryKey() {
		return _LeaveTypeCode;
	}

	public void setPrimaryKey(int pk) {
		setLeaveTypeCode(pk);
	}

	public String getLeaveCategoryCode() {
		return _LeaveCategoryCode;
	}

	public void setLeaveCategoryCode(String LeaveCategoryCode) {
		_LeaveCategoryCode = LeaveCategoryCode;
	}

	public String getLeaveCategory() {
		return _LeaveCategory;
	}

	public void setLeaveCategory(String LeaveCategory) {
		_LeaveCategory = LeaveCategory;
	}

	public int getLeaveTypeCode() {
		return _LeaveTypeCode;
	}

	public void setLeaveTypeCode(int LeaveTypeCode) {
		_LeaveTypeCode = LeaveTypeCode;
	}

	private String _LeaveCategoryCode;
	private String _LeaveCategory;
	private int _LeaveTypeCode;
}