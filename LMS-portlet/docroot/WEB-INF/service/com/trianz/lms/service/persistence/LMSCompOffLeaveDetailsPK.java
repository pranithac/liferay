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

package com.trianz.lms.service.persistence;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Date;

/**
 * @author
 * @generated
 */
public class LMSCompOffLeaveDetailsPK implements Comparable<LMSCompOffLeaveDetailsPK>,
	Serializable {
	public int EmployeeID;
	public Date CompoffDate;

	public LMSCompOffLeaveDetailsPK() {
	}

	public LMSCompOffLeaveDetailsPK(int EmployeeID, Date CompoffDate) {
		this.EmployeeID = EmployeeID;
		this.CompoffDate = CompoffDate;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int EmployeeID) {
		this.EmployeeID = EmployeeID;
	}

	public Date getCompoffDate() {
		return CompoffDate;
	}

	public void setCompoffDate(Date CompoffDate) {
		this.CompoffDate = CompoffDate;
	}

	@Override
	public int compareTo(LMSCompOffLeaveDetailsPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (EmployeeID < pk.EmployeeID) {
			value = -1;
		}
		else if (EmployeeID > pk.EmployeeID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(CompoffDate, pk.CompoffDate);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSCompOffLeaveDetailsPK)) {
			return false;
		}

		LMSCompOffLeaveDetailsPK pk = (LMSCompOffLeaveDetailsPK)obj;

		if ((EmployeeID == pk.EmployeeID) &&
				(CompoffDate.equals(pk.CompoffDate))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(EmployeeID) + CompoffDate.toString()).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("EmployeeID");
		sb.append(StringPool.EQUAL);
		sb.append(EmployeeID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("CompoffDate");
		sb.append(StringPool.EQUAL);
		sb.append(CompoffDate);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}