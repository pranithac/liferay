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

package com.trianz.lms.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.trianz.lms.service.ClpSerializer;
import com.trianz.lms.service.LMSCompOffLeaveDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSCompOffLeaveDetailsServiceUtil;
import com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSEmployeeDetailsServiceUtil;
import com.trianz.lms.service.LMSHolidaysLocalServiceUtil;
import com.trianz.lms.service.LMSHolidaysServiceUtil;
import com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil;
import com.trianz.lms.service.LMSLeaveInformationServiceUtil;
import com.trianz.lms.service.LMSLeavePoliciesLocalServiceUtil;
import com.trianz.lms.service.LMSLeavePoliciesServiceUtil;
import com.trianz.lms.service.LMSLeaveTypeLocalServiceUtil;
import com.trianz.lms.service.LMSLeaveTypeServiceUtil;
import com.trianz.lms.service.LMSMailNotificationsLocalServiceUtil;
import com.trianz.lms.service.LMSMailNotificationsServiceUtil;
import com.trianz.lms.service.LMSProjectDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSProjectDetailsServiceUtil;
import com.trianz.lms.service.LMSWeekendsLocalServiceUtil;
import com.trianz.lms.service.LMSWeekendsServiceUtil;
import com.trianz.lms.service.LeaveApprovalHistoryLocalServiceUtil;
import com.trianz.lms.service.LeaveApprovalHistoryServiceUtil;
import com.trianz.lms.service.LeaveBalanceLocalServiceUtil;
import com.trianz.lms.service.LeaveBalanceServiceUtil;
import com.trianz.lms.service.LeaveCategoriesLocalServiceUtil;
import com.trianz.lms.service.LeaveCategoriesServiceUtil;
import com.trianz.lms.service.LeaveInformationAuditLocalServiceUtil;
import com.trianz.lms.service.LeaveInformationAuditServiceUtil;
import com.trianz.lms.service.WFHManulPunchLocalServiceUtil;
import com.trianz.lms.service.WFHManulPunchServiceUtil;
import com.trianz.lms.service.securaxEmployeeHrsLocalServiceUtil;
import com.trianz.lms.service.securaxEmployeeHrsServiceUtil;

/**
 * @author $author$
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			LeaveApprovalHistoryLocalServiceUtil.clearService();

			LeaveApprovalHistoryServiceUtil.clearService();
			LeaveBalanceLocalServiceUtil.clearService();

			LeaveBalanceServiceUtil.clearService();
			LeaveCategoriesLocalServiceUtil.clearService();

			LeaveCategoriesServiceUtil.clearService();
			LeaveInformationAuditLocalServiceUtil.clearService();

			LeaveInformationAuditServiceUtil.clearService();
			LMSCompOffLeaveDetailsLocalServiceUtil.clearService();

			LMSCompOffLeaveDetailsServiceUtil.clearService();
			LMSEmployeeDetailsLocalServiceUtil.clearService();

			LMSEmployeeDetailsServiceUtil.clearService();
			LMSHolidaysLocalServiceUtil.clearService();

			LMSHolidaysServiceUtil.clearService();
			LMSLeaveInformationLocalServiceUtil.clearService();

			LMSLeaveInformationServiceUtil.clearService();
			LMSLeavePoliciesLocalServiceUtil.clearService();

			LMSLeavePoliciesServiceUtil.clearService();
			LMSLeaveTypeLocalServiceUtil.clearService();

			LMSLeaveTypeServiceUtil.clearService();
			LMSMailNotificationsLocalServiceUtil.clearService();

			LMSMailNotificationsServiceUtil.clearService();
			LMSProjectDetailsLocalServiceUtil.clearService();

			LMSProjectDetailsServiceUtil.clearService();
			LMSWeekendsLocalServiceUtil.clearService();

			LMSWeekendsServiceUtil.clearService();
			securaxEmployeeHrsLocalServiceUtil.clearService();

			securaxEmployeeHrsServiceUtil.clearService();
			WFHManulPunchLocalServiceUtil.clearService();

			WFHManulPunchServiceUtil.clearService();
		}
	}
}