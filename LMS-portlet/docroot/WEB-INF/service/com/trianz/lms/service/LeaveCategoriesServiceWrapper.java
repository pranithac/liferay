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
 * Provides a wrapper for {@link LeaveCategoriesService}.
 *
 * @author
 * @see LeaveCategoriesService
 * @generated
 */
public class LeaveCategoriesServiceWrapper implements LeaveCategoriesService,
	ServiceWrapper<LeaveCategoriesService> {
	public LeaveCategoriesServiceWrapper(
		LeaveCategoriesService leaveCategoriesService) {
		_leaveCategoriesService = leaveCategoriesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveCategoriesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveCategoriesService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveCategoriesService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveCategoriesService getWrappedLeaveCategoriesService() {
		return _leaveCategoriesService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveCategoriesService(
		LeaveCategoriesService leaveCategoriesService) {
		_leaveCategoriesService = leaveCategoriesService;
	}

	@Override
	public LeaveCategoriesService getWrappedService() {
		return _leaveCategoriesService;
	}

	@Override
	public void setWrappedService(LeaveCategoriesService leaveCategoriesService) {
		_leaveCategoriesService = leaveCategoriesService;
	}

	private LeaveCategoriesService _leaveCategoriesService;
}