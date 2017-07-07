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

package com.trianz.lms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LMSEmployeeDetailsService}.
 *
 * @author
 * @see LMSEmployeeDetailsService
 * @generated
 */
public class LMSEmployeeDetailsServiceWrapper
	implements LMSEmployeeDetailsService,
		ServiceWrapper<LMSEmployeeDetailsService> {
	public LMSEmployeeDetailsServiceWrapper(
		LMSEmployeeDetailsService lmsEmployeeDetailsService) {
		_lmsEmployeeDetailsService = lmsEmployeeDetailsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lmsEmployeeDetailsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsEmployeeDetailsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lmsEmployeeDetailsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LMSEmployeeDetailsService getWrappedLMSEmployeeDetailsService() {
		return _lmsEmployeeDetailsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLMSEmployeeDetailsService(
		LMSEmployeeDetailsService lmsEmployeeDetailsService) {
		_lmsEmployeeDetailsService = lmsEmployeeDetailsService;
	}

	@Override
	public LMSEmployeeDetailsService getWrappedService() {
		return _lmsEmployeeDetailsService;
	}

	@Override
	public void setWrappedService(
		LMSEmployeeDetailsService lmsEmployeeDetailsService) {
		_lmsEmployeeDetailsService = lmsEmployeeDetailsService;
	}

	private LMSEmployeeDetailsService _lmsEmployeeDetailsService;
}