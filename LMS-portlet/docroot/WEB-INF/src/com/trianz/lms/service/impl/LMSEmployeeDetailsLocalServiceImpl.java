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

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.trianz.lms.NoSuchEmployeeDetailsException;
import com.trianz.lms.model.LMSEmployeeDetails;
import com.trianz.lms.service.base.LMSEmployeeDetailsLocalServiceBaseImpl;
import com.trianz.lms.service.persistence.LMSEmployeeDetailsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the l m s employee details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.trianz.lms.service.LMSEmployeeDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.trianz.lms.service.base.LMSEmployeeDetailsLocalServiceBaseImpl
 * @see com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil
 */
public class LMSEmployeeDetailsLocalServiceImpl
	extends LMSEmployeeDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil} to access the l m s employee details local service.
	 */
	
	
	public LMSEmployeeDetails getEmployeeByEmailId(String EmployeeEmailID) throws NoSuchEmployeeDetailsException, SystemException{
		
		
		return LMSEmployeeDetailsUtil.findByemailId(EmployeeEmailID);
		
		
	}
	public List<LMSEmployeeDetails> getEmployeesBySupervisorEmail(String SupervisorEmail) throws NoSuchEmployeeDetailsException, SystemException{
		return LMSEmployeeDetailsUtil.findBysupervisorEmail(SupervisorEmail);
	}
public LMSEmployeeDetails getEmployeeByName(String EmployeeName) throws NoSuchEmployeeDetailsException, SystemException{
		
		
		return LMSEmployeeDetailsUtil.findByEmployeeName(EmployeeName);
		
		
	}
public List<LMSEmployeeDetails> getDistinctEmployeeCountries() throws SystemException{
	
	DynamicQuery query = DynamicQueryFactoryUtil.forClass(LMSEmployeeDetails.class,PortletClassLoaderUtil.getClassLoader());
Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("Region"));

	query.setProjection(projection);
	List<LMSEmployeeDetails> empList = LMSEmployeeDetailsUtil.findWithDynamicQuery(query);
	
	return empList;
	
}
public List<LMSEmployeeDetails> getDistinctEmployeeLocations() throws SystemException{
	
	DynamicQuery query = DynamicQueryFactoryUtil.forClass(LMSEmployeeDetails.class,PortletClassLoaderUtil.getClassLoader());
Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("Location"));

	query.setProjection(projection);
	List<LMSEmployeeDetails> empList = LMSEmployeeDetailsUtil.findWithDynamicQuery(query);
	
	return empList;
	
}
	

	
	
}