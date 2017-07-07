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
import com.trianz.lms.NoSuchWFHManulPunchException;
import com.trianz.lms.model.WFHManulPunch;
import com.trianz.lms.service.base.WFHManulPunchServiceBaseImpl;
import com.trianz.lms.service.persistence.WFHManulPunchUtil;

import java.util.Date;

/**
 * The implementation of the w f h manul punch remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.WFHManulPunchService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.WFHManulPunchServiceBaseImpl
 * @see com.trianz.lms.service.WFHManulPunchServiceUtil
 */
public class WFHManulPunchServiceImpl extends WFHManulPunchServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.WFHManulPunchServiceUtil} to access the w f h manul punch remote service.
	 */
	
	public WFHManulPunch getManualPunchInDetails(int employeeId, Date manualPunchInDate) throws NoSuchWFHManulPunchException, SystemException{
		
		return WFHManulPunchUtil.findByEmployeeID(employeeId, manualPunchInDate );
	}
}