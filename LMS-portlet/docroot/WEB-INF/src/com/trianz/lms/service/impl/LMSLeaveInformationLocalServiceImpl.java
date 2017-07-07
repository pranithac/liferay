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

package com.trianz.lms.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.trianz.lms.NoSuchLeaveInformationException;
import com.trianz.lms.model.LMSLeaveInformation;
import com.trianz.lms.model.LMSLeaveType;
import com.trianz.lms.service.base.LMSLeaveInformationLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LMSLeaveInformationUtil;
import com.trianz.lms.service.persistence.LMSLeaveTypeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The implementation of the l m s leave information local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LMSLeaveInformationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LMSLeaveInformationLocalServiceBaseImpl
 * @see com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil
 */
public class LMSLeaveInformationLocalServiceImpl
	extends LMSLeaveInformationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil} to access the l m s leave information local service.
	 */
	public List<LMSLeaveInformation> getleavesByEmployeeID(int EmployeeId) throws SystemException{
		return LMSLeaveInformationUtil.findByEmployeeId(EmployeeId);
		
		
	}
	public List<LMSLeaveInformation> getleavesByApprovalStatus(int employeeId, String status) throws SystemException{
		
		return LMSLeaveInformationUtil.findByapprovalStatus(employeeId, status);
	}
	
	public LMSLeaveInformation getLeaveByLeaveRequestId(String leaveReqId) throws NoSuchLeaveInformationException, SystemException{
		
		return LMSLeaveInformationUtil.findByLeaveRequestId(leaveReqId);
	}
public List<LMSLeaveInformation> getLeavesByApproverMail(String approverMail) throws NoSuchLeaveInformationException, SystemException{

	List<LMSLeaveInformation> allLeaveInfo = LMSLeaveInformationUtil.findAll();
	List<LMSLeaveInformation> LeavesOfApprover = new ArrayList<LMSLeaveInformation>();
	List<String> approverLeaveInfo = new ArrayList<String>();
	for(int i=0;i<allLeaveInfo.size();i++){
		String approversLeaveInfo = allLeaveInfo.get(i).getApproverEmails();
		//System.out.println("approversLeaveInfo as string==="+approversLeaveInfo);
		approverLeaveInfo.addAll(Arrays.asList(approversLeaveInfo.split(",")));
		
		/*for(String approver:approverLeaveInfo){
			System.out.println("each approver"+approver);
		}
		System.out.println("approversLeaveInfo as list==="+approverLeaveInfo.get(0));
*/
		boolean value=containsIgnoreCase(approverMail,approverLeaveInfo);
		
		if(value){//matched
			//System.out.println("matched===");
			LeavesOfApprover.add(allLeaveInfo.get(i));
		}
		
	}
	
	
		return LeavesOfApprover;
	}
	
public boolean containsIgnoreCase(String str, List<String> list){
	//System.out.println("inside containsIgnoreCase method==");
    for(String i : list){
        if(i.equalsIgnoreCase("'"+str+"'"))
            return true;
    }
    return false;
}
}