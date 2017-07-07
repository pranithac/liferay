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
import com.trianz.lms.NoSuchsecuraxEmployeeHrsException;
import com.trianz.lms.model.securaxEmployeeHrs;
import com.trianz.lms.service.base.securaxEmployeeHrsLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.securaxEmployeeHrsUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the securax employee hrs local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.securaxEmployeeHrsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.securaxEmployeeHrsLocalServiceBaseImpl
 * @see com.trianz.lms.service.securaxEmployeeHrsLocalServiceUtil
 */
public class securaxEmployeeHrsLocalServiceImpl
	extends securaxEmployeeHrsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.securaxEmployeeHrsLocalServiceUtil} to access the securax employee hrs local service.
	 */
	
	public securaxEmployeeHrs getsecureHrsPunchDateByEmployeeId(int employeeId, Date punchDate) throws SystemException, NoSuchsecuraxEmployeeHrsException{
		return securaxEmployeeHrsUtil.findByEmployeeId(employeeId, punchDate);
	}
	
}