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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LMSHolidays}.
 * </p>
 *
 * @author
 * @see LMSHolidays
 * @generated
 */
public class LMSHolidaysWrapper implements LMSHolidays,
	ModelWrapper<LMSHolidays> {
	public LMSHolidaysWrapper(LMSHolidays lmsHolidays) {
		_lmsHolidays = lmsHolidays;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSHolidays.class;
	}

	@Override
	public String getModelClassName() {
		return LMSHolidays.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("HolidayId", getHolidayId());
		attributes.put("HolidayDate", getHolidayDate());
		attributes.put("Occassion", getOccassion());
		attributes.put("HolidayYear", getHolidayYear());
		attributes.put("LocationsApplicable", getLocationsApplicable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer HolidayId = (Integer)attributes.get("HolidayId");

		if (HolidayId != null) {
			setHolidayId(HolidayId);
		}

		Date HolidayDate = (Date)attributes.get("HolidayDate");

		if (HolidayDate != null) {
			setHolidayDate(HolidayDate);
		}

		String Occassion = (String)attributes.get("Occassion");

		if (Occassion != null) {
			setOccassion(Occassion);
		}

		Integer HolidayYear = (Integer)attributes.get("HolidayYear");

		if (HolidayYear != null) {
			setHolidayYear(HolidayYear);
		}

		String LocationsApplicable = (String)attributes.get(
				"LocationsApplicable");

		if (LocationsApplicable != null) {
			setLocationsApplicable(LocationsApplicable);
		}
	}

	/**
	* Returns the primary key of this l m s holidays.
	*
	* @return the primary key of this l m s holidays
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsHolidays.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s holidays.
	*
	* @param primaryKey the primary key of this l m s holidays
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsHolidays.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the holiday ID of this l m s holidays.
	*
	* @return the holiday ID of this l m s holidays
	*/
	@Override
	public int getHolidayId() {
		return _lmsHolidays.getHolidayId();
	}

	/**
	* Sets the holiday ID of this l m s holidays.
	*
	* @param HolidayId the holiday ID of this l m s holidays
	*/
	@Override
	public void setHolidayId(int HolidayId) {
		_lmsHolidays.setHolidayId(HolidayId);
	}

	/**
	* Returns the holiday date of this l m s holidays.
	*
	* @return the holiday date of this l m s holidays
	*/
	@Override
	public java.util.Date getHolidayDate() {
		return _lmsHolidays.getHolidayDate();
	}

	/**
	* Sets the holiday date of this l m s holidays.
	*
	* @param HolidayDate the holiday date of this l m s holidays
	*/
	@Override
	public void setHolidayDate(java.util.Date HolidayDate) {
		_lmsHolidays.setHolidayDate(HolidayDate);
	}

	/**
	* Returns the occassion of this l m s holidays.
	*
	* @return the occassion of this l m s holidays
	*/
	@Override
	public java.lang.String getOccassion() {
		return _lmsHolidays.getOccassion();
	}

	/**
	* Sets the occassion of this l m s holidays.
	*
	* @param Occassion the occassion of this l m s holidays
	*/
	@Override
	public void setOccassion(java.lang.String Occassion) {
		_lmsHolidays.setOccassion(Occassion);
	}

	/**
	* Returns the holiday year of this l m s holidays.
	*
	* @return the holiday year of this l m s holidays
	*/
	@Override
	public int getHolidayYear() {
		return _lmsHolidays.getHolidayYear();
	}

	/**
	* Sets the holiday year of this l m s holidays.
	*
	* @param HolidayYear the holiday year of this l m s holidays
	*/
	@Override
	public void setHolidayYear(int HolidayYear) {
		_lmsHolidays.setHolidayYear(HolidayYear);
	}

	/**
	* Returns the locations applicable of this l m s holidays.
	*
	* @return the locations applicable of this l m s holidays
	*/
	@Override
	public java.lang.String getLocationsApplicable() {
		return _lmsHolidays.getLocationsApplicable();
	}

	/**
	* Sets the locations applicable of this l m s holidays.
	*
	* @param LocationsApplicable the locations applicable of this l m s holidays
	*/
	@Override
	public void setLocationsApplicable(java.lang.String LocationsApplicable) {
		_lmsHolidays.setLocationsApplicable(LocationsApplicable);
	}

	@Override
	public boolean isNew() {
		return _lmsHolidays.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsHolidays.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsHolidays.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsHolidays.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsHolidays.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsHolidays.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsHolidays.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsHolidays.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsHolidays.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsHolidays.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsHolidays.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSHolidaysWrapper((LMSHolidays)_lmsHolidays.clone());
	}

	@Override
	public int compareTo(com.trianz.lms.model.LMSHolidays lmsHolidays) {
		return _lmsHolidays.compareTo(lmsHolidays);
	}

	@Override
	public int hashCode() {
		return _lmsHolidays.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSHolidays> toCacheModel() {
		return _lmsHolidays.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSHolidays toEscapedModel() {
		return new LMSHolidaysWrapper(_lmsHolidays.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSHolidays toUnescapedModel() {
		return new LMSHolidaysWrapper(_lmsHolidays.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsHolidays.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsHolidays.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsHolidays.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSHolidaysWrapper)) {
			return false;
		}

		LMSHolidaysWrapper lmsHolidaysWrapper = (LMSHolidaysWrapper)obj;

		if (Validator.equals(_lmsHolidays, lmsHolidaysWrapper._lmsHolidays)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSHolidays getWrappedLMSHolidays() {
		return _lmsHolidays;
	}

	@Override
	public LMSHolidays getWrappedModel() {
		return _lmsHolidays;
	}

	@Override
	public void resetOriginalValues() {
		_lmsHolidays.resetOriginalValues();
	}

	private LMSHolidays _lmsHolidays;
}