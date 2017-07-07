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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSHolidaysServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSHolidaysServiceSoap
 * @generated
 */
public class LMSHolidaysSoap implements Serializable {
	public static LMSHolidaysSoap toSoapModel(LMSHolidays model) {
		LMSHolidaysSoap soapModel = new LMSHolidaysSoap();

		soapModel.setHolidayId(model.getHolidayId());
		soapModel.setHolidayDate(model.getHolidayDate());
		soapModel.setOccassion(model.getOccassion());
		soapModel.setHolidayYear(model.getHolidayYear());
		soapModel.setLocationsApplicable(model.getLocationsApplicable());

		return soapModel;
	}

	public static LMSHolidaysSoap[] toSoapModels(LMSHolidays[] models) {
		LMSHolidaysSoap[] soapModels = new LMSHolidaysSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSHolidaysSoap[][] toSoapModels(LMSHolidays[][] models) {
		LMSHolidaysSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSHolidaysSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSHolidaysSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSHolidaysSoap[] toSoapModels(List<LMSHolidays> models) {
		List<LMSHolidaysSoap> soapModels = new ArrayList<LMSHolidaysSoap>(models.size());

		for (LMSHolidays model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSHolidaysSoap[soapModels.size()]);
	}

	public LMSHolidaysSoap() {
	}

	public int getPrimaryKey() {
		return _HolidayId;
	}

	public void setPrimaryKey(int pk) {
		setHolidayId(pk);
	}

	public int getHolidayId() {
		return _HolidayId;
	}

	public void setHolidayId(int HolidayId) {
		_HolidayId = HolidayId;
	}

	public Date getHolidayDate() {
		return _HolidayDate;
	}

	public void setHolidayDate(Date HolidayDate) {
		_HolidayDate = HolidayDate;
	}

	public String getOccassion() {
		return _Occassion;
	}

	public void setOccassion(String Occassion) {
		_Occassion = Occassion;
	}

	public int getHolidayYear() {
		return _HolidayYear;
	}

	public void setHolidayYear(int HolidayYear) {
		_HolidayYear = HolidayYear;
	}

	public String getLocationsApplicable() {
		return _LocationsApplicable;
	}

	public void setLocationsApplicable(String LocationsApplicable) {
		_LocationsApplicable = LocationsApplicable;
	}

	private int _HolidayId;
	private Date _HolidayDate;
	private String _Occassion;
	private int _HolidayYear;
	private String _LocationsApplicable;
}