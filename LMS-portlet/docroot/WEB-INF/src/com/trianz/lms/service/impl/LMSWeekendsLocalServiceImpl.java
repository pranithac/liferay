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
import com.trianz.lms.NoSuchWeekendsException;
import com.trianz.lms.model.LMSWeekends;
import com.trianz.lms.service.base.LMSWeekendsLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LMSWeekendsUtil;

/**
 * The implementation of the l m s weekends local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LMSWeekendsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LMSWeekendsLocalServiceBaseImpl
 * @see com.trianz.lms.service.LMSWeekendsLocalServiceUtil
 */
public class LMSWeekendsLocalServiceImpl extends LMSWeekendsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LMSWeekendsLocalServiceUtil} to access the l m s weekends local service.
	 */
	
	public LMSWeekends getLMSWeekendsByLocation(String Location) throws NoSuchWeekendsException, SystemException{
		
		return LMSWeekendsUtil.findByLocation(Location);
	}
}