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
import com.trianz.lms.model.LMSHolidays;
import com.trianz.lms.model.LMSLeaveType;
import com.trianz.lms.service.LMSHolidaysLocalServiceUtil;
import com.trianz.lms.service.base.LMSHolidaysLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LMSHolidaysUtil;
import com.trianz.lms.service.persistence.LMSLeaveTypeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The implementation of the l m s holidays local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LMSHolidaysLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LMSHolidaysLocalServiceBaseImpl
 * @see com.trianz.lms.service.LMSHolidaysLocalServiceUtil
 */
public class LMSHolidaysLocalServiceImpl extends LMSHolidaysLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LMSHolidaysLocalServiceUtil} to access the l m s holidays local service.
	 */
	
	
	public List<LMSHolidays> getHolidaysByLocation(String City) throws SystemException{

		List<LMSHolidays> allHolidays = LMSHolidaysLocalServiceUtil.getLMSHolidayses(0, LMSHolidaysLocalServiceUtil.getLMSHolidaysesCount());
		List<LMSHolidays> HolidaysOfLocation = new ArrayList<LMSHolidays>();
		List<String> locationHolidays = new ArrayList<String>();
		for(int i=0;i<allHolidays.size();i++){
			String locationsApplicable = allHolidays.get(i).getLocationsApplicable();
			locationHolidays.addAll(Arrays.asList(locationsApplicable.split(",")));
			//System.out.println("Locations List of Holiday: "+"Holiday ID: "+allHolidays.get(i).getHolidayId()+""+locationHolidays);
			if(locationHolidays.contains(City)){
				//System.out.println("Holiday ID: "+allHolidays.get(i).getHolidayId()+""+"contains location: "+City);
				HolidaysOfLocation.add(allHolidays.get(i));
			}
			locationHolidays.clear();
		}
		
		return HolidaysOfLocation;
		
	}
	public List<LMSHolidays> getHolidaysByYear(int Year) throws SystemException{
		List<LMSHolidays> HolidaysOfYear = new ArrayList<LMSHolidays>();
		HolidaysOfYear = LMSHolidaysUtil.findByHolidayYear(Year);
		return HolidaysOfYear;
	}
	
}