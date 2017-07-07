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

package com.trianz.lms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.trianz.lms.model.LMSLeavePolicies;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LMSLeavePolicies in entity cache.
 *
 * @author
 * @see LMSLeavePolicies
 * @generated
 */
public class LMSLeavePoliciesCacheModel implements CacheModel<LMSLeavePolicies>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{PolicyId=");
		sb.append(PolicyId);
		sb.append(", Project=");
		sb.append(Project);
		sb.append(", LeaveTypesApplicable=");
		sb.append(LeaveTypesApplicable);
		sb.append(", LocationsApplicable=");
		sb.append(LocationsApplicable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSLeavePolicies toEntityModel() {
		LMSLeavePoliciesImpl lmsLeavePoliciesImpl = new LMSLeavePoliciesImpl();

		lmsLeavePoliciesImpl.setPolicyId(PolicyId);

		if (Project == null) {
			lmsLeavePoliciesImpl.setProject(StringPool.BLANK);
		}
		else {
			lmsLeavePoliciesImpl.setProject(Project);
		}

		if (LeaveTypesApplicable == null) {
			lmsLeavePoliciesImpl.setLeaveTypesApplicable(StringPool.BLANK);
		}
		else {
			lmsLeavePoliciesImpl.setLeaveTypesApplicable(LeaveTypesApplicable);
		}

		if (LocationsApplicable == null) {
			lmsLeavePoliciesImpl.setLocationsApplicable(StringPool.BLANK);
		}
		else {
			lmsLeavePoliciesImpl.setLocationsApplicable(LocationsApplicable);
		}

		lmsLeavePoliciesImpl.resetOriginalValues();

		return lmsLeavePoliciesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PolicyId = objectInput.readInt();
		Project = objectInput.readUTF();
		LeaveTypesApplicable = objectInput.readUTF();
		LocationsApplicable = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(PolicyId);

		if (Project == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Project);
		}

		if (LeaveTypesApplicable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveTypesApplicable);
		}

		if (LocationsApplicable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LocationsApplicable);
		}
	}

	public int PolicyId;
	public String Project;
	public String LeaveTypesApplicable;
	public String LocationsApplicable;
}