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
import com.trianz.lms.NoSuchProjectDetailsException;
import com.trianz.lms.model.LMSProjectDetails;
import com.trianz.lms.service.base.LMSProjectDetailsLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LMSProjectDetailsUtil;

import java.util.List;

/**
 * The implementation of the l m s project details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LMSProjectDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LMSProjectDetailsLocalServiceBaseImpl
 * @see com.trianz.lms.service.LMSProjectDetailsLocalServiceUtil
 */
public class LMSProjectDetailsLocalServiceImpl
	extends LMSProjectDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LMSProjectDetailsLocalServiceUtil} to access the l m s project details local service.
	 */
	public List<LMSProjectDetails> getProjectsByEmployeeId(int EmployeeId) throws SystemException{
		return LMSProjectDetailsUtil.findByEmployeeId(EmployeeId);
		
	}
	public LMSProjectDetails getProjectNameById(String projectId,int employeeId) throws NoSuchProjectDetailsException, SystemException{
		
		return LMSProjectDetailsUtil.findByProjectCode(projectId, employeeId);
	}
	public List<LMSProjectDetails> getEmployeesByApproverEmail(String emailId) throws SystemException{
		return LMSProjectDetailsUtil.findByApproverEmailId(emailId);
}
	public List<LMSProjectDetails> getProjectsOfApprover(String emailId) throws SystemException{
		return LMSProjectDetailsUtil.findByApproverEmailId(emailId);
}
	public List<LMSProjectDetails> getProjectsByApprover(String emailId,String projCode) throws SystemException{
		return LMSProjectDetailsUtil.findByApproverandProject(emailId, projCode);
}
	
public LMSProjectDetails getProjectNameByprojectCode(String projectcode) throws NoSuchProjectDetailsException, SystemException{
		
		return LMSProjectDetailsUtil.findByProjectCodetogetName(projectcode);
	}

}