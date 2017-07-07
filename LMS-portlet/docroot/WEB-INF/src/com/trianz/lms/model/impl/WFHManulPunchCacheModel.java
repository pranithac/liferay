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

import com.trianz.lms.model.WFHManulPunch;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFHManulPunch in entity cache.
 *
 * @author
 * @see WFHManulPunch
 * @generated
 */
public class WFHManulPunchCacheModel implements CacheModel<WFHManulPunch>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{WFHManualPunchId=");
		sb.append(WFHManualPunchId);
		sb.append(", WFHID=");
		sb.append(WFHID);
		sb.append(", Intime=");
		sb.append(Intime);
		sb.append(", OutTime=");
		sb.append(OutTime);
		sb.append(", CreatedBy=");
		sb.append(CreatedBy);
		sb.append(", CreatedDate=");
		sb.append(CreatedDate);
		sb.append(", ModifiedBy=");
		sb.append(ModifiedBy);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append(", PUNCHDATE=");
		sb.append(PUNCHDATE);
		sb.append(", EmployeeID=");
		sb.append(EmployeeID);
		sb.append(", IsApproved=");
		sb.append(IsApproved);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFHManulPunch toEntityModel() {
		WFHManulPunchImpl wfhManulPunchImpl = new WFHManulPunchImpl();

		wfhManulPunchImpl.setWFHManualPunchId(WFHManualPunchId);
		wfhManulPunchImpl.setWFHID(WFHID);

		if (Intime == Long.MIN_VALUE) {
			wfhManulPunchImpl.setIntime(null);
		}
		else {
			wfhManulPunchImpl.setIntime(new Date(Intime));
		}

		if (OutTime == Long.MIN_VALUE) {
			wfhManulPunchImpl.setOutTime(null);
		}
		else {
			wfhManulPunchImpl.setOutTime(new Date(OutTime));
		}

		if (CreatedBy == null) {
			wfhManulPunchImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfhManulPunchImpl.setCreatedBy(CreatedBy);
		}

		if (CreatedDate == Long.MIN_VALUE) {
			wfhManulPunchImpl.setCreatedDate(null);
		}
		else {
			wfhManulPunchImpl.setCreatedDate(new Date(CreatedDate));
		}

		if (ModifiedBy == null) {
			wfhManulPunchImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfhManulPunchImpl.setModifiedBy(ModifiedBy);
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			wfhManulPunchImpl.setModifiedDate(null);
		}
		else {
			wfhManulPunchImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (PUNCHDATE == Long.MIN_VALUE) {
			wfhManulPunchImpl.setPUNCHDATE(null);
		}
		else {
			wfhManulPunchImpl.setPUNCHDATE(new Date(PUNCHDATE));
		}

		wfhManulPunchImpl.setEmployeeID(EmployeeID);
		wfhManulPunchImpl.setIsApproved(IsApproved);

		wfhManulPunchImpl.resetOriginalValues();

		return wfhManulPunchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		WFHManualPunchId = objectInput.readInt();
		WFHID = objectInput.readInt();
		Intime = objectInput.readLong();
		OutTime = objectInput.readLong();
		CreatedBy = objectInput.readUTF();
		CreatedDate = objectInput.readLong();
		ModifiedBy = objectInput.readUTF();
		ModifiedDate = objectInput.readLong();
		PUNCHDATE = objectInput.readLong();
		EmployeeID = objectInput.readInt();
		IsApproved = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(WFHManualPunchId);
		objectOutput.writeInt(WFHID);
		objectOutput.writeLong(Intime);
		objectOutput.writeLong(OutTime);

		if (CreatedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CreatedBy);
		}

		objectOutput.writeLong(CreatedDate);

		if (ModifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ModifiedBy);
		}

		objectOutput.writeLong(ModifiedDate);
		objectOutput.writeLong(PUNCHDATE);
		objectOutput.writeInt(EmployeeID);
		objectOutput.writeBoolean(IsApproved);
	}

	public int WFHManualPunchId;
	public int WFHID;
	public long Intime;
	public long OutTime;
	public String CreatedBy;
	public long CreatedDate;
	public String ModifiedBy;
	public long ModifiedDate;
	public long PUNCHDATE;
	public int EmployeeID;
	public boolean IsApproved;
}