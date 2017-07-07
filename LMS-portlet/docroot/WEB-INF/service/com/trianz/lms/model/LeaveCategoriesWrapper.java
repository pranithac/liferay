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
 * This class is a wrapper for {@link LeaveCategories}.
 * </p>
 *
 * @author
 * @see LeaveCategories
 * @generated
 */
public class LeaveCategoriesWrapper implements LeaveCategories,
	ModelWrapper<LeaveCategories> {
	public LeaveCategoriesWrapper(LeaveCategories leaveCategories) {
		_leaveCategories = leaveCategories;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveCategories.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveCategories.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LeaveCategoryCode", getLeaveCategoryCode());
		attributes.put("LeaveCategory", getLeaveCategory());
		attributes.put("LeaveTypeCode", getLeaveTypeCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String LeaveCategoryCode = (String)attributes.get("LeaveCategoryCode");

		if (LeaveCategoryCode != null) {
			setLeaveCategoryCode(LeaveCategoryCode);
		}

		String LeaveCategory = (String)attributes.get("LeaveCategory");

		if (LeaveCategory != null) {
			setLeaveCategory(LeaveCategory);
		}

		Integer LeaveTypeCode = (Integer)attributes.get("LeaveTypeCode");

		if (LeaveTypeCode != null) {
			setLeaveTypeCode(LeaveTypeCode);
		}
	}

	/**
	* Returns the primary key of this leave categories.
	*
	* @return the primary key of this leave categories
	*/
	@Override
	public int getPrimaryKey() {
		return _leaveCategories.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave categories.
	*
	* @param primaryKey the primary key of this leave categories
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_leaveCategories.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave category code of this leave categories.
	*
	* @return the leave category code of this leave categories
	*/
	@Override
	public java.lang.String getLeaveCategoryCode() {
		return _leaveCategories.getLeaveCategoryCode();
	}

	/**
	* Sets the leave category code of this leave categories.
	*
	* @param LeaveCategoryCode the leave category code of this leave categories
	*/
	@Override
	public void setLeaveCategoryCode(java.lang.String LeaveCategoryCode) {
		_leaveCategories.setLeaveCategoryCode(LeaveCategoryCode);
	}

	/**
	* Returns the leave category of this leave categories.
	*
	* @return the leave category of this leave categories
	*/
	@Override
	public java.lang.String getLeaveCategory() {
		return _leaveCategories.getLeaveCategory();
	}

	/**
	* Sets the leave category of this leave categories.
	*
	* @param LeaveCategory the leave category of this leave categories
	*/
	@Override
	public void setLeaveCategory(java.lang.String LeaveCategory) {
		_leaveCategories.setLeaveCategory(LeaveCategory);
	}

	/**
	* Returns the leave type code of this leave categories.
	*
	* @return the leave type code of this leave categories
	*/
	@Override
	public int getLeaveTypeCode() {
		return _leaveCategories.getLeaveTypeCode();
	}

	/**
	* Sets the leave type code of this leave categories.
	*
	* @param LeaveTypeCode the leave type code of this leave categories
	*/
	@Override
	public void setLeaveTypeCode(int LeaveTypeCode) {
		_leaveCategories.setLeaveTypeCode(LeaveTypeCode);
	}

	@Override
	public boolean isNew() {
		return _leaveCategories.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveCategories.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveCategories.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveCategories.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveCategories.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveCategories.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveCategories.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveCategories.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveCategories.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveCategories.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveCategories.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveCategoriesWrapper((LeaveCategories)_leaveCategories.clone());
	}

	@Override
	public int compareTo(com.trianz.lms.model.LeaveCategories leaveCategories) {
		return _leaveCategories.compareTo(leaveCategories);
	}

	@Override
	public int hashCode() {
		return _leaveCategories.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LeaveCategories> toCacheModel() {
		return _leaveCategories.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LeaveCategories toEscapedModel() {
		return new LeaveCategoriesWrapper(_leaveCategories.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LeaveCategories toUnescapedModel() {
		return new LeaveCategoriesWrapper(_leaveCategories.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveCategories.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveCategories.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveCategories.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveCategoriesWrapper)) {
			return false;
		}

		LeaveCategoriesWrapper leaveCategoriesWrapper = (LeaveCategoriesWrapper)obj;

		if (Validator.equals(_leaveCategories,
					leaveCategoriesWrapper._leaveCategories)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveCategories getWrappedLeaveCategories() {
		return _leaveCategories;
	}

	@Override
	public LeaveCategories getWrappedModel() {
		return _leaveCategories;
	}

	@Override
	public void resetOriginalValues() {
		_leaveCategories.resetOriginalValues();
	}

	private LeaveCategories _leaveCategories;
}