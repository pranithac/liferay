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
import com.trianz.lms.NoSuchLeaveTypeException;
import com.trianz.lms.model.LMSLeaveType;
import com.trianz.lms.service.base.LMSLeaveTypeLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LMSLeaveTypeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The implementation of the l m s leave type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LMSLeaveTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LMSLeaveTypeLocalServiceBaseImpl
 * @see com.trianz.lms.service.LMSLeaveTypeLocalServiceUtil
 */
public class LMSLeaveTypeLocalServiceImpl
	extends LMSLeaveTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LMSLeaveTypeLocalServiceUtil} to access the l m s leave type local service.
	 */
public String getLeaveTypeNameByCode(int LeaveTypeCode) throws NoSuchLeaveTypeException, SystemException{
		
		return LMSLeaveTypeUtil.findByLeaveTypeCode(LeaveTypeCode).getLeaveTypeName();
	}
public int getLeaveTypeCodeByName(String LeaveTypeName) throws NoSuchLeaveTypeException, SystemException{
	
	return LMSLeaveTypeUtil.findByLeaveTypeName(LeaveTypeName).getLeaveTypeCode();
}
public List<LMSLeaveType> getLeaveTypesByLocation(String Country) throws SystemException{

	List<LMSLeaveType> allLeaveTypes = LMSLeaveTypeUtil.findAll();
	List<LMSLeaveType> LeaveTypesOfLocation = new ArrayList<LMSLeaveType>();
	List<String> locationLeaveTypes = new ArrayList<String>();
	for(int i=0;i<allLeaveTypes.size();i++){
		String locationsApplicable = allLeaveTypes.get(i).getCountriesApplicable();
		//System.out.println("locationsApplicable " + locationsApplicable);
		locationLeaveTypes.addAll(Arrays.asList(locationsApplicable.split(",")));
		if(locationLeaveTypes.contains(Country)){
			LeaveTypesOfLocation.add(allLeaveTypes.get(i));
		}
		locationLeaveTypes.clear();
	}
	return LeaveTypesOfLocation;
	
}
}