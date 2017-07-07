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
import com.liferay.portal.model.CacheModel;

import com.trianz.lms.model.LeaveBalance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LeaveBalance in entity cache.
 *
 * @author
 * @see LeaveBalance
 * @generated
 */
public class LeaveBalanceCacheModel implements CacheModel<LeaveBalance>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{EmployeeId=");
		sb.append(EmployeeId);
		sb.append(", ELBalance=");
		sb.append(ELBalance);
		sb.append(", CLBalance=");
		sb.append(CLBalance);
		sb.append(", CompOffLeaveBalance=");
		sb.append(CompOffLeaveBalance);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveBalance toEntityModel() {
		LeaveBalanceImpl leaveBalanceImpl = new LeaveBalanceImpl();

		leaveBalanceImpl.setEmployeeId(EmployeeId);
		leaveBalanceImpl.setELBalance(ELBalance);
		leaveBalanceImpl.setCLBalance(CLBalance);
		leaveBalanceImpl.setCompOffLeaveBalance(CompOffLeaveBalance);

		leaveBalanceImpl.resetOriginalValues();

		return leaveBalanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		EmployeeId = objectInput.readInt();
		ELBalance = objectInput.readDouble();
		CLBalance = objectInput.readDouble();
		CompOffLeaveBalance = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(EmployeeId);
		objectOutput.writeDouble(ELBalance);
		objectOutput.writeDouble(CLBalance);
		objectOutput.writeDouble(CompOffLeaveBalance);
	}

	public int EmployeeId;
	public double ELBalance;
	public double CLBalance;
	public double CompOffLeaveBalance;
}