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

import com.trianz.lms.model.LMSEmployeeDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LMSEmployeeDetails in entity cache.
 *
 * @author
 * @see LMSEmployeeDetails
 * @generated
 */
public class LMSEmployeeDetailsCacheModel implements CacheModel<LMSEmployeeDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{EmployeeId=");
		sb.append(EmployeeId);
		sb.append(", EmployeeName=");
		sb.append(EmployeeName);
		sb.append(", EmployeeEmailID=");
		sb.append(EmployeeEmailID);
		sb.append(", JoiningDate=");
		sb.append(JoiningDate);
		sb.append(", SupervisorId=");
		sb.append(SupervisorId);
		sb.append(", SupervisorName=");
		sb.append(SupervisorName);
		sb.append(", SupervisorEmail=");
		sb.append(SupervisorEmail);
		sb.append(", Location=");
		sb.append(Location);
		sb.append(", Region=");
		sb.append(Region);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSEmployeeDetails toEntityModel() {
		LMSEmployeeDetailsImpl lmsEmployeeDetailsImpl = new LMSEmployeeDetailsImpl();

		lmsEmployeeDetailsImpl.setEmployeeId(EmployeeId);

		if (EmployeeName == null) {
			lmsEmployeeDetailsImpl.setEmployeeName(StringPool.BLANK);
		}
		else {
			lmsEmployeeDetailsImpl.setEmployeeName(EmployeeName);
		}

		if (EmployeeEmailID == null) {
			lmsEmployeeDetailsImpl.setEmployeeEmailID(StringPool.BLANK);
		}
		else {
			lmsEmployeeDetailsImpl.setEmployeeEmailID(EmployeeEmailID);
		}

		if (JoiningDate == Long.MIN_VALUE) {
			lmsEmployeeDetailsImpl.setJoiningDate(null);
		}
		else {
			lmsEmployeeDetailsImpl.setJoiningDate(new Date(JoiningDate));
		}

		lmsEmployeeDetailsImpl.setSupervisorId(SupervisorId);

		if (SupervisorName == null) {
			lmsEmployeeDetailsImpl.setSupervisorName(StringPool.BLANK);
		}
		else {
			lmsEmployeeDetailsImpl.setSupervisorName(SupervisorName);
		}

		if (SupervisorEmail == null) {
			lmsEmployeeDetailsImpl.setSupervisorEmail(StringPool.BLANK);
		}
		else {
			lmsEmployeeDetailsImpl.setSupervisorEmail(SupervisorEmail);
		}

		if (Location == null) {
			lmsEmployeeDetailsImpl.setLocation(StringPool.BLANK);
		}
		else {
			lmsEmployeeDetailsImpl.setLocation(Location);
		}

		if (Region == null) {
			lmsEmployeeDetailsImpl.setRegion(StringPool.BLANK);
		}
		else {
			lmsEmployeeDetailsImpl.setRegion(Region);
		}

		lmsEmployeeDetailsImpl.resetOriginalValues();

		return lmsEmployeeDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		EmployeeId = objectInput.readInt();
		EmployeeName = objectInput.readUTF();
		EmployeeEmailID = objectInput.readUTF();
		JoiningDate = objectInput.readLong();
		SupervisorId = objectInput.readInt();
		SupervisorName = objectInput.readUTF();
		SupervisorEmail = objectInput.readUTF();
		Location = objectInput.readUTF();
		Region = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(EmployeeId);

		if (EmployeeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(EmployeeName);
		}

		if (EmployeeEmailID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(EmployeeEmailID);
		}

		objectOutput.writeLong(JoiningDate);
		objectOutput.writeInt(SupervisorId);

		if (SupervisorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SupervisorName);
		}

		if (SupervisorEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SupervisorEmail);
		}

		if (Location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Location);
		}

		if (Region == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Region);
		}
	}

	public int EmployeeId;
	public String EmployeeName;
	public String EmployeeEmailID;
	public long JoiningDate;
	public int SupervisorId;
	public String SupervisorName;
	public String SupervisorEmail;
	public String Location;
	public String Region;
}