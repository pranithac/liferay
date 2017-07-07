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

import com.trianz.lms.model.securaxEmployeeHrs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing securaxEmployeeHrs in entity cache.
 *
 * @author
 * @see securaxEmployeeHrs
 * @generated
 */
public class securaxEmployeeHrsCacheModel implements CacheModel<securaxEmployeeHrs>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{EmployeeId=");
		sb.append(EmployeeId);
		sb.append(", PunchDate=");
		sb.append(PunchDate);
		sb.append(", PunchInTime=");
		sb.append(PunchInTime);
		sb.append(", PunchOutTime=");
		sb.append(PunchOutTime);
		sb.append(", WorkHrsPerday=");
		sb.append(WorkHrsPerday);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", OT=");
		sb.append(OT);
		sb.append(", Created_By=");
		sb.append(Created_By);
		sb.append(", Created_Date=");
		sb.append(Created_Date);
		sb.append(", Modified_By=");
		sb.append(Modified_By);
		sb.append(", Modified_Date=");
		sb.append(Modified_Date);
		sb.append(", S_Id=");
		sb.append(S_Id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public securaxEmployeeHrs toEntityModel() {
		securaxEmployeeHrsImpl securaxEmployeeHrsImpl = new securaxEmployeeHrsImpl();

		securaxEmployeeHrsImpl.setEmployeeId(EmployeeId);

		if (PunchDate == Long.MIN_VALUE) {
			securaxEmployeeHrsImpl.setPunchDate(null);
		}
		else {
			securaxEmployeeHrsImpl.setPunchDate(new Date(PunchDate));
		}

		if (PunchInTime == Long.MIN_VALUE) {
			securaxEmployeeHrsImpl.setPunchInTime(null);
		}
		else {
			securaxEmployeeHrsImpl.setPunchInTime(new Date(PunchInTime));
		}

		if (PunchOutTime == Long.MIN_VALUE) {
			securaxEmployeeHrsImpl.setPunchOutTime(null);
		}
		else {
			securaxEmployeeHrsImpl.setPunchOutTime(new Date(PunchOutTime));
		}

		if (WorkHrsPerday == Long.MIN_VALUE) {
			securaxEmployeeHrsImpl.setWorkHrsPerday(null);
		}
		else {
			securaxEmployeeHrsImpl.setWorkHrsPerday(new Date(WorkHrsPerday));
		}

		if (Status == null) {
			securaxEmployeeHrsImpl.setStatus(StringPool.BLANK);
		}
		else {
			securaxEmployeeHrsImpl.setStatus(Status);
		}

		if (OT == Long.MIN_VALUE) {
			securaxEmployeeHrsImpl.setOT(null);
		}
		else {
			securaxEmployeeHrsImpl.setOT(new Date(OT));
		}

		securaxEmployeeHrsImpl.setCreated_By(Created_By);

		if (Created_Date == Long.MIN_VALUE) {
			securaxEmployeeHrsImpl.setCreated_Date(null);
		}
		else {
			securaxEmployeeHrsImpl.setCreated_Date(new Date(Created_Date));
		}

		securaxEmployeeHrsImpl.setModified_By(Modified_By);

		if (Modified_Date == Long.MIN_VALUE) {
			securaxEmployeeHrsImpl.setModified_Date(null);
		}
		else {
			securaxEmployeeHrsImpl.setModified_Date(new Date(Modified_Date));
		}

		securaxEmployeeHrsImpl.setS_Id(S_Id);

		securaxEmployeeHrsImpl.resetOriginalValues();

		return securaxEmployeeHrsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		EmployeeId = objectInput.readInt();
		PunchDate = objectInput.readLong();
		PunchInTime = objectInput.readLong();
		PunchOutTime = objectInput.readLong();
		WorkHrsPerday = objectInput.readLong();
		Status = objectInput.readUTF();
		OT = objectInput.readLong();
		Created_By = objectInput.readInt();
		Created_Date = objectInput.readLong();
		Modified_By = objectInput.readInt();
		Modified_Date = objectInput.readLong();
		S_Id = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(EmployeeId);
		objectOutput.writeLong(PunchDate);
		objectOutput.writeLong(PunchInTime);
		objectOutput.writeLong(PunchOutTime);
		objectOutput.writeLong(WorkHrsPerday);

		if (Status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Status);
		}

		objectOutput.writeLong(OT);
		objectOutput.writeInt(Created_By);
		objectOutput.writeLong(Created_Date);
		objectOutput.writeInt(Modified_By);
		objectOutput.writeLong(Modified_Date);
		objectOutput.writeInt(S_Id);
	}

	public int EmployeeId;
	public long PunchDate;
	public long PunchInTime;
	public long PunchOutTime;
	public long WorkHrsPerday;
	public String Status;
	public long OT;
	public int Created_By;
	public long Created_Date;
	public int Modified_By;
	public long Modified_Date;
	public int S_Id;
}