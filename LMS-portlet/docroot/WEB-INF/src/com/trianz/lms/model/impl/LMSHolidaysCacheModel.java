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

import com.trianz.lms.model.LMSHolidays;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LMSHolidays in entity cache.
 *
 * @author
 * @see LMSHolidays
 * @generated
 */
public class LMSHolidaysCacheModel implements CacheModel<LMSHolidays>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{HolidayId=");
		sb.append(HolidayId);
		sb.append(", HolidayDate=");
		sb.append(HolidayDate);
		sb.append(", Occassion=");
		sb.append(Occassion);
		sb.append(", HolidayYear=");
		sb.append(HolidayYear);
		sb.append(", LocationsApplicable=");
		sb.append(LocationsApplicable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSHolidays toEntityModel() {
		LMSHolidaysImpl lmsHolidaysImpl = new LMSHolidaysImpl();

		lmsHolidaysImpl.setHolidayId(HolidayId);

		if (HolidayDate == Long.MIN_VALUE) {
			lmsHolidaysImpl.setHolidayDate(null);
		}
		else {
			lmsHolidaysImpl.setHolidayDate(new Date(HolidayDate));
		}

		if (Occassion == null) {
			lmsHolidaysImpl.setOccassion(StringPool.BLANK);
		}
		else {
			lmsHolidaysImpl.setOccassion(Occassion);
		}

		lmsHolidaysImpl.setHolidayYear(HolidayYear);

		if (LocationsApplicable == null) {
			lmsHolidaysImpl.setLocationsApplicable(StringPool.BLANK);
		}
		else {
			lmsHolidaysImpl.setLocationsApplicable(LocationsApplicable);
		}

		lmsHolidaysImpl.resetOriginalValues();

		return lmsHolidaysImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		HolidayId = objectInput.readInt();
		HolidayDate = objectInput.readLong();
		Occassion = objectInput.readUTF();
		HolidayYear = objectInput.readInt();
		LocationsApplicable = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(HolidayId);
		objectOutput.writeLong(HolidayDate);

		if (Occassion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Occassion);
		}

		objectOutput.writeInt(HolidayYear);

		if (LocationsApplicable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LocationsApplicable);
		}
	}

	public int HolidayId;
	public long HolidayDate;
	public String Occassion;
	public int HolidayYear;
	public String LocationsApplicable;
}