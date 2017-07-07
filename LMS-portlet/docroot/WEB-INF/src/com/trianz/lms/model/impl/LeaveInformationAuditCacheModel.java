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

import com.trianz.lms.model.LeaveInformationAudit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveInformationAudit in entity cache.
 *
 * @author
 * @see LeaveInformationAudit
 * @generated
 */
public class LeaveInformationAuditCacheModel implements CacheModel<LeaveInformationAudit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{LogId=");
		sb.append(LogId);
		sb.append(", LeaveRequestId=");
		sb.append(LeaveRequestId);
		sb.append(", Action=");
		sb.append(Action);
		sb.append(", ActionBy=");
		sb.append(ActionBy);
		sb.append(", CreatedDate=");
		sb.append(CreatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveInformationAudit toEntityModel() {
		LeaveInformationAuditImpl leaveInformationAuditImpl = new LeaveInformationAuditImpl();

		leaveInformationAuditImpl.setLogId(LogId);
		leaveInformationAuditImpl.setLeaveRequestId(LeaveRequestId);

		if (Action == null) {
			leaveInformationAuditImpl.setAction(StringPool.BLANK);
		}
		else {
			leaveInformationAuditImpl.setAction(Action);
		}

		if (ActionBy == null) {
			leaveInformationAuditImpl.setActionBy(StringPool.BLANK);
		}
		else {
			leaveInformationAuditImpl.setActionBy(ActionBy);
		}

		if (CreatedDate == Long.MIN_VALUE) {
			leaveInformationAuditImpl.setCreatedDate(null);
		}
		else {
			leaveInformationAuditImpl.setCreatedDate(new Date(CreatedDate));
		}

		leaveInformationAuditImpl.resetOriginalValues();

		return leaveInformationAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		LogId = objectInput.readInt();
		LeaveRequestId = objectInput.readInt();
		Action = objectInput.readUTF();
		ActionBy = objectInput.readUTF();
		CreatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(LogId);
		objectOutput.writeInt(LeaveRequestId);

		if (Action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Action);
		}

		if (ActionBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ActionBy);
		}

		objectOutput.writeLong(CreatedDate);
	}

	public int LogId;
	public int LeaveRequestId;
	public String Action;
	public String ActionBy;
	public long CreatedDate;
}