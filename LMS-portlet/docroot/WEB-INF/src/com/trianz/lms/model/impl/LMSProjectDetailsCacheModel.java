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

import com.trianz.lms.model.LMSProjectDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LMSProjectDetails in entity cache.
 *
 * @author
 * @see LMSProjectDetails
 * @generated
 */
public class LMSProjectDetailsCacheModel implements CacheModel<LMSProjectDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{EmployeeId=");
		sb.append(EmployeeId);
		sb.append(", ProjectCode=");
		sb.append(ProjectCode);
		sb.append(", ProjectName=");
		sb.append(ProjectName);
		sb.append(", ApproverName=");
		sb.append(ApproverName);
		sb.append(", ApproverID=");
		sb.append(ApproverID);
		sb.append(", ApproverEmail=");
		sb.append(ApproverEmail);
		sb.append(", AssignmentID=");
		sb.append(AssignmentID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSProjectDetails toEntityModel() {
		LMSProjectDetailsImpl lmsProjectDetailsImpl = new LMSProjectDetailsImpl();

		lmsProjectDetailsImpl.setEmployeeId(EmployeeId);

		if (ProjectCode == null) {
			lmsProjectDetailsImpl.setProjectCode(StringPool.BLANK);
		}
		else {
			lmsProjectDetailsImpl.setProjectCode(ProjectCode);
		}

		if (ProjectName == null) {
			lmsProjectDetailsImpl.setProjectName(StringPool.BLANK);
		}
		else {
			lmsProjectDetailsImpl.setProjectName(ProjectName);
		}

		if (ApproverName == null) {
			lmsProjectDetailsImpl.setApproverName(StringPool.BLANK);
		}
		else {
			lmsProjectDetailsImpl.setApproverName(ApproverName);
		}

		lmsProjectDetailsImpl.setApproverID(ApproverID);

		if (ApproverEmail == null) {
			lmsProjectDetailsImpl.setApproverEmail(StringPool.BLANK);
		}
		else {
			lmsProjectDetailsImpl.setApproverEmail(ApproverEmail);
		}

		lmsProjectDetailsImpl.setAssignmentID(AssignmentID);

		lmsProjectDetailsImpl.resetOriginalValues();

		return lmsProjectDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		EmployeeId = objectInput.readInt();
		ProjectCode = objectInput.readUTF();
		ProjectName = objectInput.readUTF();
		ApproverName = objectInput.readUTF();
		ApproverID = objectInput.readInt();
		ApproverEmail = objectInput.readUTF();
		AssignmentID = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(EmployeeId);

		if (ProjectCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ProjectCode);
		}

		if (ProjectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ProjectName);
		}

		if (ApproverName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ApproverName);
		}

		objectOutput.writeInt(ApproverID);

		if (ApproverEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ApproverEmail);
		}

		objectOutput.writeInt(AssignmentID);
	}

	public int EmployeeId;
	public String ProjectCode;
	public String ProjectName;
	public String ApproverName;
	public int ApproverID;
	public String ApproverEmail;
	public int AssignmentID;
}