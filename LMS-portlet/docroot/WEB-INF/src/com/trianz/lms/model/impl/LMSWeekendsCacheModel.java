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

import com.trianz.lms.model.LMSWeekends;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LMSWeekends in entity cache.
 *
 * @author
 * @see LMSWeekends
 * @generated
 */
public class LMSWeekendsCacheModel implements CacheModel<LMSWeekends>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{LocationId=");
		sb.append(LocationId);
		sb.append(", Location=");
		sb.append(Location);
		sb.append(", WeekendDays=");
		sb.append(WeekendDays);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSWeekends toEntityModel() {
		LMSWeekendsImpl lmsWeekendsImpl = new LMSWeekendsImpl();

		lmsWeekendsImpl.setLocationId(LocationId);

		if (Location == null) {
			lmsWeekendsImpl.setLocation(StringPool.BLANK);
		}
		else {
			lmsWeekendsImpl.setLocation(Location);
		}

		if (WeekendDays == null) {
			lmsWeekendsImpl.setWeekendDays(StringPool.BLANK);
		}
		else {
			lmsWeekendsImpl.setWeekendDays(WeekendDays);
		}

		lmsWeekendsImpl.resetOriginalValues();

		return lmsWeekendsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		LocationId = objectInput.readInt();
		Location = objectInput.readUTF();
		WeekendDays = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(LocationId);

		if (Location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Location);
		}

		if (WeekendDays == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(WeekendDays);
		}
	}

	public int LocationId;
	public String Location;
	public String WeekendDays;
}