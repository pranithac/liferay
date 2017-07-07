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
 * This class is a wrapper for {@link LMSLeavePolicies}.
 * </p>
 *
 * @author
 * @see LMSLeavePolicies
 * @generated
 */
public class LMSLeavePoliciesWrapper implements LMSLeavePolicies,
	ModelWrapper<LMSLeavePolicies> {
	public LMSLeavePoliciesWrapper(LMSLeavePolicies lmsLeavePolicies) {
		_lmsLeavePolicies = lmsLeavePolicies;
	}

	@Override
	public Class<?> getModelClass() {
		return LMSLeavePolicies.class;
	}

	@Override
	public String getModelClassName() {
		return LMSLeavePolicies.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PolicyId", getPolicyId());
		attributes.put("Project", getProject());
		attributes.put("LeaveTypesApplicable", getLeaveTypesApplicable());
		attributes.put("LocationsApplicable", getLocationsApplicable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer PolicyId = (Integer)attributes.get("PolicyId");

		if (PolicyId != null) {
			setPolicyId(PolicyId);
		}

		String Project = (String)attributes.get("Project");

		if (Project != null) {
			setProject(Project);
		}

		String LeaveTypesApplicable = (String)attributes.get(
				"LeaveTypesApplicable");

		if (LeaveTypesApplicable != null) {
			setLeaveTypesApplicable(LeaveTypesApplicable);
		}

		String LocationsApplicable = (String)attributes.get(
				"LocationsApplicable");

		if (LocationsApplicable != null) {
			setLocationsApplicable(LocationsApplicable);
		}
	}

	/**
	* Returns the primary key of this l m s leave policies.
	*
	* @return the primary key of this l m s leave policies
	*/
	@Override
	public int getPrimaryKey() {
		return _lmsLeavePolicies.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s leave policies.
	*
	* @param primaryKey the primary key of this l m s leave policies
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_lmsLeavePolicies.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the policy ID of this l m s leave policies.
	*
	* @return the policy ID of this l m s leave policies
	*/
	@Override
	public int getPolicyId() {
		return _lmsLeavePolicies.getPolicyId();
	}

	/**
	* Sets the policy ID of this l m s leave policies.
	*
	* @param PolicyId the policy ID of this l m s leave policies
	*/
	@Override
	public void setPolicyId(int PolicyId) {
		_lmsLeavePolicies.setPolicyId(PolicyId);
	}

	/**
	* Returns the project of this l m s leave policies.
	*
	* @return the project of this l m s leave policies
	*/
	@Override
	public java.lang.String getProject() {
		return _lmsLeavePolicies.getProject();
	}

	/**
	* Sets the project of this l m s leave policies.
	*
	* @param Project the project of this l m s leave policies
	*/
	@Override
	public void setProject(java.lang.String Project) {
		_lmsLeavePolicies.setProject(Project);
	}

	/**
	* Returns the leave types applicable of this l m s leave policies.
	*
	* @return the leave types applicable of this l m s leave policies
	*/
	@Override
	public java.lang.String getLeaveTypesApplicable() {
		return _lmsLeavePolicies.getLeaveTypesApplicable();
	}

	/**
	* Sets the leave types applicable of this l m s leave policies.
	*
	* @param LeaveTypesApplicable the leave types applicable of this l m s leave policies
	*/
	@Override
	public void setLeaveTypesApplicable(java.lang.String LeaveTypesApplicable) {
		_lmsLeavePolicies.setLeaveTypesApplicable(LeaveTypesApplicable);
	}

	/**
	* Returns the locations applicable of this l m s leave policies.
	*
	* @return the locations applicable of this l m s leave policies
	*/
	@Override
	public java.lang.String getLocationsApplicable() {
		return _lmsLeavePolicies.getLocationsApplicable();
	}

	/**
	* Sets the locations applicable of this l m s leave policies.
	*
	* @param LocationsApplicable the locations applicable of this l m s leave policies
	*/
	@Override
	public void setLocationsApplicable(java.lang.String LocationsApplicable) {
		_lmsLeavePolicies.setLocationsApplicable(LocationsApplicable);
	}

	@Override
	public boolean isNew() {
		return _lmsLeavePolicies.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lmsLeavePolicies.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lmsLeavePolicies.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lmsLeavePolicies.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lmsLeavePolicies.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsLeavePolicies.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsLeavePolicies.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsLeavePolicies.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lmsLeavePolicies.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lmsLeavePolicies.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsLeavePolicies.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSLeavePoliciesWrapper((LMSLeavePolicies)_lmsLeavePolicies.clone());
	}

	@Override
	public int compareTo(com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies) {
		return _lmsLeavePolicies.compareTo(lmsLeavePolicies);
	}

	@Override
	public int hashCode() {
		return _lmsLeavePolicies.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.trianz.lms.model.LMSLeavePolicies> toCacheModel() {
		return _lmsLeavePolicies.toCacheModel();
	}

	@Override
	public com.trianz.lms.model.LMSLeavePolicies toEscapedModel() {
		return new LMSLeavePoliciesWrapper(_lmsLeavePolicies.toEscapedModel());
	}

	@Override
	public com.trianz.lms.model.LMSLeavePolicies toUnescapedModel() {
		return new LMSLeavePoliciesWrapper(_lmsLeavePolicies.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsLeavePolicies.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lmsLeavePolicies.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsLeavePolicies.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSLeavePoliciesWrapper)) {
			return false;
		}

		LMSLeavePoliciesWrapper lmsLeavePoliciesWrapper = (LMSLeavePoliciesWrapper)obj;

		if (Validator.equals(_lmsLeavePolicies,
					lmsLeavePoliciesWrapper._lmsLeavePolicies)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LMSLeavePolicies getWrappedLMSLeavePolicies() {
		return _lmsLeavePolicies;
	}

	@Override
	public LMSLeavePolicies getWrappedModel() {
		return _lmsLeavePolicies;
	}

	@Override
	public void resetOriginalValues() {
		_lmsLeavePolicies.resetOriginalValues();
	}

	private LMSLeavePolicies _lmsLeavePolicies;
}