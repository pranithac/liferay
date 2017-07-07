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

import com.trianz.lms.model.LMSLeaveType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LMSLeaveType in entity cache.
 *
 * @author
 * @see LMSLeaveType
 * @generated
 */
public class LMSLeaveTypeCacheModel implements CacheModel<LMSLeaveType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{LeaveTypeCode=");
		sb.append(LeaveTypeCode);
		sb.append(", LeaveTypeName=");
		sb.append(LeaveTypeName);
		sb.append(", CountriesApplicable=");
		sb.append(CountriesApplicable);
		sb.append(", MonthlyAccrual=");
		sb.append(MonthlyAccrual);
		sb.append(", AccrualValue=");
		sb.append(AccrualValue);
		sb.append(", CreditReset=");
		sb.append(CreditReset);
		sb.append(", ResetInterval=");
		sb.append(ResetInterval);
		sb.append(", ResetDay=");
		sb.append(ResetDay);
		sb.append(", ExcludeWeekEnds=");
		sb.append(ExcludeWeekEnds);
		sb.append(", ExcludeHolidays=");
		sb.append(ExcludeHolidays);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSLeaveType toEntityModel() {
		LMSLeaveTypeImpl lmsLeaveTypeImpl = new LMSLeaveTypeImpl();

		lmsLeaveTypeImpl.setLeaveTypeCode(LeaveTypeCode);

		if (LeaveTypeName == null) {
			lmsLeaveTypeImpl.setLeaveTypeName(StringPool.BLANK);
		}
		else {
			lmsLeaveTypeImpl.setLeaveTypeName(LeaveTypeName);
		}

		if (CountriesApplicable == null) {
			lmsLeaveTypeImpl.setCountriesApplicable(StringPool.BLANK);
		}
		else {
			lmsLeaveTypeImpl.setCountriesApplicable(CountriesApplicable);
		}

		if (MonthlyAccrual == null) {
			lmsLeaveTypeImpl.setMonthlyAccrual(StringPool.BLANK);
		}
		else {
			lmsLeaveTypeImpl.setMonthlyAccrual(MonthlyAccrual);
		}

		lmsLeaveTypeImpl.setAccrualValue(AccrualValue);

		if (CreditReset == null) {
			lmsLeaveTypeImpl.setCreditReset(StringPool.BLANK);
		}
		else {
			lmsLeaveTypeImpl.setCreditReset(CreditReset);
		}

		if (ResetInterval == null) {
			lmsLeaveTypeImpl.setResetInterval(StringPool.BLANK);
		}
		else {
			lmsLeaveTypeImpl.setResetInterval(ResetInterval);
		}

		lmsLeaveTypeImpl.setResetDay(ResetDay);

		if (ExcludeWeekEnds == null) {
			lmsLeaveTypeImpl.setExcludeWeekEnds(StringPool.BLANK);
		}
		else {
			lmsLeaveTypeImpl.setExcludeWeekEnds(ExcludeWeekEnds);
		}

		if (ExcludeHolidays == null) {
			lmsLeaveTypeImpl.setExcludeHolidays(StringPool.BLANK);
		}
		else {
			lmsLeaveTypeImpl.setExcludeHolidays(ExcludeHolidays);
		}

		lmsLeaveTypeImpl.resetOriginalValues();

		return lmsLeaveTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		LeaveTypeCode = objectInput.readInt();
		LeaveTypeName = objectInput.readUTF();
		CountriesApplicable = objectInput.readUTF();
		MonthlyAccrual = objectInput.readUTF();
		AccrualValue = objectInput.readDouble();
		CreditReset = objectInput.readUTF();
		ResetInterval = objectInput.readUTF();
		ResetDay = objectInput.readInt();
		ExcludeWeekEnds = objectInput.readUTF();
		ExcludeHolidays = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(LeaveTypeCode);

		if (LeaveTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveTypeName);
		}

		if (CountriesApplicable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CountriesApplicable);
		}

		if (MonthlyAccrual == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MonthlyAccrual);
		}

		objectOutput.writeDouble(AccrualValue);

		if (CreditReset == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CreditReset);
		}

		if (ResetInterval == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ResetInterval);
		}

		objectOutput.writeInt(ResetDay);

		if (ExcludeWeekEnds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ExcludeWeekEnds);
		}

		if (ExcludeHolidays == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ExcludeHolidays);
		}
	}

	public int LeaveTypeCode;
	public String LeaveTypeName;
	public String CountriesApplicable;
	public String MonthlyAccrual;
	public double AccrualValue;
	public String CreditReset;
	public String ResetInterval;
	public int ResetDay;
	public String ExcludeWeekEnds;
	public String ExcludeHolidays;
}