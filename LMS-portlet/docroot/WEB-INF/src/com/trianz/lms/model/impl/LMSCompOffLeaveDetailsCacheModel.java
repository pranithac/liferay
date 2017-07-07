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

import com.trianz.lms.model.LMSCompOffLeaveDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LMSCompOffLeaveDetails in entity cache.
 *
 * @author
 * @see LMSCompOffLeaveDetails
 * @generated
 */
public class LMSCompOffLeaveDetailsCacheModel implements CacheModel<LMSCompOffLeaveDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ApprovedBy=");
		sb.append(ApprovedBy);
		sb.append(", CreatedDate=");
		sb.append(CreatedDate);
		sb.append(", EmployeeID=");
		sb.append(EmployeeID);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", CompoffDate=");
		sb.append(CompoffDate);
		sb.append(", CompOffId=");
		sb.append(CompOffId);
		sb.append(", ApproverEmployeeID=");
		sb.append(ApproverEmployeeID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSCompOffLeaveDetails toEntityModel() {
		LMSCompOffLeaveDetailsImpl lmsCompOffLeaveDetailsImpl = new LMSCompOffLeaveDetailsImpl();

		if (ApprovedBy == null) {
			lmsCompOffLeaveDetailsImpl.setApprovedBy(StringPool.BLANK);
		}
		else {
			lmsCompOffLeaveDetailsImpl.setApprovedBy(ApprovedBy);
		}

		if (CreatedDate == Long.MIN_VALUE) {
			lmsCompOffLeaveDetailsImpl.setCreatedDate(null);
		}
		else {
			lmsCompOffLeaveDetailsImpl.setCreatedDate(new Date(CreatedDate));
		}

		lmsCompOffLeaveDetailsImpl.setEmployeeID(EmployeeID);

		if (Status == null) {
			lmsCompOffLeaveDetailsImpl.setStatus(StringPool.BLANK);
		}
		else {
			lmsCompOffLeaveDetailsImpl.setStatus(Status);
		}

		if (CompoffDate == Long.MIN_VALUE) {
			lmsCompOffLeaveDetailsImpl.setCompoffDate(null);
		}
		else {
			lmsCompOffLeaveDetailsImpl.setCompoffDate(new Date(CompoffDate));
		}

		lmsCompOffLeaveDetailsImpl.setCompOffId(CompOffId);
		lmsCompOffLeaveDetailsImpl.setApproverEmployeeID(ApproverEmployeeID);

		lmsCompOffLeaveDetailsImpl.resetOriginalValues();

		return lmsCompOffLeaveDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ApprovedBy = objectInput.readUTF();
		CreatedDate = objectInput.readLong();
		EmployeeID = objectInput.readInt();
		Status = objectInput.readUTF();
		CompoffDate = objectInput.readLong();
		CompOffId = objectInput.readInt();
		ApproverEmployeeID = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (ApprovedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ApprovedBy);
		}

		objectOutput.writeLong(CreatedDate);
		objectOutput.writeInt(EmployeeID);

		if (Status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Status);
		}

		objectOutput.writeLong(CompoffDate);
		objectOutput.writeInt(CompOffId);
		objectOutput.writeInt(ApproverEmployeeID);
	}

	public String ApprovedBy;
	public long CreatedDate;
	public int EmployeeID;
	public String Status;
	public long CompoffDate;
	public int CompOffId;
	public int ApproverEmployeeID;
}