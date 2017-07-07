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

import com.trianz.lms.model.LeaveApprovalHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LeaveApprovalHistory in entity cache.
 *
 * @author
 * @see LeaveApprovalHistory
 * @generated
 */
public class LeaveApprovalHistoryCacheModel implements CacheModel<LeaveApprovalHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{SNo=");
		sb.append(SNo);
		sb.append(", LeaveRequestId=");
		sb.append(LeaveRequestId);
		sb.append(", ApproverID=");
		sb.append(ApproverID);
		sb.append(", LeaveStatus=");
		sb.append(LeaveStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveApprovalHistory toEntityModel() {
		LeaveApprovalHistoryImpl leaveApprovalHistoryImpl = new LeaveApprovalHistoryImpl();

		leaveApprovalHistoryImpl.setSNo(SNo);

		if (LeaveRequestId == null) {
			leaveApprovalHistoryImpl.setLeaveRequestId(StringPool.BLANK);
		}
		else {
			leaveApprovalHistoryImpl.setLeaveRequestId(LeaveRequestId);
		}

		leaveApprovalHistoryImpl.setApproverID(ApproverID);

		if (LeaveStatus == null) {
			leaveApprovalHistoryImpl.setLeaveStatus(StringPool.BLANK);
		}
		else {
			leaveApprovalHistoryImpl.setLeaveStatus(LeaveStatus);
		}

		leaveApprovalHistoryImpl.resetOriginalValues();

		return leaveApprovalHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		SNo = objectInput.readInt();
		LeaveRequestId = objectInput.readUTF();
		ApproverID = objectInput.readInt();
		LeaveStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(SNo);

		if (LeaveRequestId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveRequestId);
		}

		objectOutput.writeInt(ApproverID);

		if (LeaveStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveStatus);
		}
	}

	public int SNo;
	public String LeaveRequestId;
	public int ApproverID;
	public String LeaveStatus;
}