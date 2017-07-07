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
 * Provides a wrapper for {@link WFHManulPunchService}.
 *
 * @author
 * @see WFHManulPunchService
 * @generated
 */
public class WFHManulPunchServiceWrapper implements WFHManulPunchService,
	ServiceWrapper<WFHManulPunchService> {
	public WFHManulPunchServiceWrapper(
		WFHManulPunchService wfhManulPunchService) {
		_wfhManulPunchService = wfhManulPunchService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _wfhManulPunchService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wfhManulPunchService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wfhManulPunchService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.trianz.lms.model.WFHManulPunch getManualPunchInDetails(
		int employeeId, java.util.Date manualPunchInDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWFHManulPunchException {
		return _wfhManulPunchService.getManualPunchInDetails(employeeId,
			manualPunchInDate);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WFHManulPunchService getWrappedWFHManulPunchService() {
		return _wfhManulPunchService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWFHManulPunchService(
		WFHManulPunchService wfhManulPunchService) {
		_wfhManulPunchService = wfhManulPunchService;
	}

	@Override
	public WFHManulPunchService getWrappedService() {
		return _wfhManulPunchService;
	}

	@Override
	public void setWrappedService(WFHManulPunchService wfhManulPunchService) {
		_wfhManulPunchService = wfhManulPunchService;
	}

	private WFHManulPunchService _wfhManulPunchService;
}