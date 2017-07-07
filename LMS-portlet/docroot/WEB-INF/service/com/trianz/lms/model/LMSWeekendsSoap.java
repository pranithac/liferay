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
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSWeekendsServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSWeekendsServiceSoap
 * @generated
 */
public class LMSWeekendsSoap implements Serializable {
	public static LMSWeekendsSoap toSoapModel(LMSWeekends model) {
		LMSWeekendsSoap soapModel = new LMSWeekendsSoap();

		soapModel.setLocationId(model.getLocationId());
		soapModel.setLocation(model.getLocation());
		soapModel.setWeekendDays(model.getWeekendDays());

		return soapModel;
	}

	public static LMSWeekendsSoap[] toSoapModels(LMSWeekends[] models) {
		LMSWeekendsSoap[] soapModels = new LMSWeekendsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSWeekendsSoap[][] toSoapModels(LMSWeekends[][] models) {
		LMSWeekendsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSWeekendsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSWeekendsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSWeekendsSoap[] toSoapModels(List<LMSWeekends> models) {
		List<LMSWeekendsSoap> soapModels = new ArrayList<LMSWeekendsSoap>(models.size());

		for (LMSWeekends model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSWeekendsSoap[soapModels.size()]);
	}

	public LMSWeekendsSoap() {
	}

	public int getPrimaryKey() {
		return _LocationId;
	}

	public void setPrimaryKey(int pk) {
		setLocationId(pk);
	}

	public int getLocationId() {
		return _LocationId;
	}

	public void setLocationId(int LocationId) {
		_LocationId = LocationId;
	}

	public String getLocation() {
		return _Location;
	}

	public void setLocation(String Location) {
		_Location = Location;
	}

	public String getWeekendDays() {
		return _WeekendDays;
	}

	public void setWeekendDays(String WeekendDays) {
		_WeekendDays = WeekendDays;
	}

	private int _LocationId;
	private String _Location;
	private String _WeekendDays;
}