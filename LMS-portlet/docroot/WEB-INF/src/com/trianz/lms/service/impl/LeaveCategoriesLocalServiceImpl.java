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
import com.trianz.lms.NoSuchLeaveCategoriesException;
import com.trianz.lms.model.LeaveCategories;
import com.trianz.lms.service.base.LeaveCategoriesLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LeaveCategoriesUtil;

import java.util.List;

/**
 * The implementation of the leave categories local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LeaveCategoriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LeaveCategoriesLocalServiceBaseImpl
 * @see com.trianz.lms.service.LeaveCategoriesLocalServiceUtil
 */
public class LeaveCategoriesLocalServiceImpl
	extends LeaveCategoriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LeaveCategoriesLocalServiceUtil} to access the leave categories local service.
	 */
	public String getCategoryByLeaveType(int LeaveTypeCode) throws SystemException, NoSuchLeaveCategoriesException{
		 return LeaveCategoriesUtil.findByLeaveTypeCode(LeaveTypeCode).getLeaveCategory();
		
	}
	public String getCategoryNameByID(String CategoryCode, int LeaveTypeCode) throws NoSuchLeaveCategoriesException, SystemException{
		return LeaveCategoriesUtil.findByLeaveCategoryCode(CategoryCode, LeaveTypeCode).getLeaveCategory();
	}
	public String getCategoryIdByName(String CategoryName, int LeaveTypeCode) throws NoSuchLeaveCategoriesException, SystemException{
		return LeaveCategoriesUtil.findByCategoryName(CategoryName, LeaveTypeCode).getLeaveCategoryCode();
	}
	public List<LeaveCategories> getCategoriesByName(String categoryName) throws SystemException{
		
		
		return LeaveCategoriesUtil.findByLeaveCategory(categoryName);
		}
	
	
}