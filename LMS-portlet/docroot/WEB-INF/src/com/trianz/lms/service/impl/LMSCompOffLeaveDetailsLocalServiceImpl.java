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
import com.trianz.lms.NoSuchCompOffLeaveDetailsException;
import com.trianz.lms.model.LMSCompOffLeaveDetails;
import com.trianz.lms.service.base.LMSCompOffLeaveDetailsLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the l m s comp off leave details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LMSCompOffLeaveDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LMSCompOffLeaveDetailsLocalServiceBaseImpl
 * @see com.trianz.lms.service.LMSCompOffLeaveDetailsLocalServiceUtil
 */
public class LMSCompOffLeaveDetailsLocalServiceImpl
	extends LMSCompOffLeaveDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LMSCompOffLeaveDetailsLocalServiceUtil} to access the l m s comp off leave details local service.
	 */
	
	public LMSCompOffLeaveDetails getCompOfDetailsbyEmpIdDate(int empID,Date compOffDate){
		LMSCompOffLeaveDetails cmpDetails = null;
		
		try {
			
			
			
			cmpDetails =  LMSCompOffLeaveDetailsUtil.findByEmployeeID(empID, compOffDate);
		} catch (NoSuchCompOffLeaveDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cmpDetails;
		
	}
	public List<LMSCompOffLeaveDetails> getCompoffDetailsbyApprovalName(String ApprovalName){
		List<LMSCompOffLeaveDetails> leaveDetails = new ArrayList<LMSCompOffLeaveDetails>();
		try {
			leaveDetails =  LMSCompOffLeaveDetailsUtil.findByApprovedBy(ApprovalName);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveDetails;
		
	}

	public List<LMSCompOffLeaveDetails> getCompoffDetailsbyApproverEmpId(int AppEmpId){
		List<LMSCompOffLeaveDetails> leaveDetails = new ArrayList<LMSCompOffLeaveDetails>();
		try {
			leaveDetails =  LMSCompOffLeaveDetailsUtil.findByApproverEmpId(AppEmpId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveDetails;
	}
	
	public LMSCompOffLeaveDetails getCompOffDetailsbyCompOffId(int compOffId){
		LMSCompOffLeaveDetails cmpDetails = null;
		try {
			cmpDetails = LMSCompOffLeaveDetailsUtil.findBycompOffId(compOffId);
		} catch (NoSuchCompOffLeaveDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cmpDetails;
	}
}