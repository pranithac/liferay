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

import com.trianz.lms.model.LeaveCategories;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LeaveCategories in entity cache.
 *
 * @author
 * @see LeaveCategories
 * @generated
 */
public class LeaveCategoriesCacheModel implements CacheModel<LeaveCategories>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{LeaveCategoryCode=");
		sb.append(LeaveCategoryCode);
		sb.append(", LeaveCategory=");
		sb.append(LeaveCategory);
		sb.append(", LeaveTypeCode=");
		sb.append(LeaveTypeCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveCategories toEntityModel() {
		LeaveCategoriesImpl leaveCategoriesImpl = new LeaveCategoriesImpl();

		if (LeaveCategoryCode == null) {
			leaveCategoriesImpl.setLeaveCategoryCode(StringPool.BLANK);
		}
		else {
			leaveCategoriesImpl.setLeaveCategoryCode(LeaveCategoryCode);
		}

		if (LeaveCategory == null) {
			leaveCategoriesImpl.setLeaveCategory(StringPool.BLANK);
		}
		else {
			leaveCategoriesImpl.setLeaveCategory(LeaveCategory);
		}

		leaveCategoriesImpl.setLeaveTypeCode(LeaveTypeCode);

		leaveCategoriesImpl.resetOriginalValues();

		return leaveCategoriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		LeaveCategoryCode = objectInput.readUTF();
		LeaveCategory = objectInput.readUTF();
		LeaveTypeCode = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (LeaveCategoryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveCategoryCode);
		}

		if (LeaveCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveCategory);
		}

		objectOutput.writeInt(LeaveTypeCode);
	}

	public String LeaveCategoryCode;
	public String LeaveCategory;
	public int LeaveTypeCode;
}