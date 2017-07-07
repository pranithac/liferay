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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LMSWeekends}.
 * </p>
 *
 * @author
 * @see LMSWeekends
 * @generated
 */
public class LMSWeekendsWrapper implements LMSWeekends,
	ModelWrapper<LMSWeekends> {
	public LMSWeekendsWrapper(LMSWeekends lmsWeekends) {
		_lmsWeekends = lmsWeekends;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSWeekends.class;
	}

	@Override
	public String getModelClassName() {
		return LMSWeekends.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LocationId", getLocationId());
		attributes.put("Location", getLocation());
		attributes.put("WeekendDays", getWeekendDays());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer LocationId = (Integer)attributes.get("LocationId");

		if (LocationId != null) {
			setLocationId(LocationId);
		}

		String Location = (String)attributes.get("Location");

		if (Location != null) {
			setLocation(Location);
		}

		String WeekendDays = (String)attributes.get("WeekendDays");

		if (WeekendDays != null) {
			setWeekendDays(WeekendDays);
		}
	}

	/**
	* Returns the primary key of this l m s weekends.
	*
	* @return the primary key of this l m s weekends
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsWeekends.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s weekends.
	*
	* @param primaryKey the primary key of this l m s weekends
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsWeekends.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the location ID of this l m s weekends.
	*
	* @return the location ID of this l m s weekends
	*/
	@Override
	public int getLocationId() {
		return _lmsWeekends.getLocationId();
	}

	/**
	* Sets the location ID of this l m s weekends.
	*
	* @param LocationId the location ID of this l m s weekends
	*/
	@Override
	public void setLocationId(int LocationId) {
		_lmsWeekends.setLocationId(LocationId);
	}

	/**
	* Returns the location of this l m s weekends.
	*
	* @return the location of this l m s weekends
	*/
	@Override
	public java.lang.String getLocation() {
		return _lmsWeekends.getLocation();
	}

	/**
	* Sets the location of this l m s weekends.
	*
	* @param Location the location of this l m s weekends
	*/
	@Override
	public void setLocation(java.lang.String Location) {
		_lmsWeekends.setLocation(Location);
	}

	/**
	* Returns the weekend days of this l m s weekends.
	*
	* @return the weekend days of this l m s weekends
	*/
	@Override
	public java.lang.String getWeekendDays() {
		return _lmsWeekends.getWeekendDays();
	}

	/**
	* Sets the weekend days of this l m s weekends.
	*
	* @param WeekendDays the weekend days of this l m s weekends
	*/
	@Override
	public void setWeekendDays(java.lang.String WeekendDays) {
		_lmsWeekends.setWeekendDays(WeekendDays);
	}

	@Override
	public boolean isNew() {
		return _lmsWeekends.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsWeekends.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsWeekends.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsWeekends.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsWeekends.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsWeekends.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsWeekends.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsWeekends.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsWeekends.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsWeekends.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsWeekends.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSWeekendsWrapper((LMSWeekends)_lmsWeekends.clone());
	}

	@Override
	public int compareTo(com.trianz.lms.model.LMSWeekends lmsWeekends) {
		return _lmsWeekends.compareTo(lmsWeekends);
	}

	@Override
	public int hashCode() {
		return _lmsWeekends.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSWeekends> toCacheModel() {
		return _lmsWeekends.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSWeekends toEscapedModel() {
		return new LMSWeekendsWrapper(_lmsWeekends.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSWeekends toUnescapedModel() {
		return new LMSWeekendsWrapper(_lmsWeekends.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsWeekends.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsWeekends.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsWeekends.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSWeekendsWrapper)) {
			return false;
		}

		LMSWeekendsWrapper lmsWeekendsWrapper = (LMSWeekendsWrapper)obj;

		if (Validator.equals(_lmsWeekends, lmsWeekendsWrapper._lmsWeekends)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSWeekends getWrappedLMSWeekends() {
		return _lmsWeekends;
	}

	@Override
	public LMSWeekends getWrappedModel() {
		return _lmsWeekends;
	}

	@Override
	public void resetOriginalValues() {
		_lmsWeekends.resetOriginalValues();
	}

	private LMSWeekends _lmsWeekends;
}