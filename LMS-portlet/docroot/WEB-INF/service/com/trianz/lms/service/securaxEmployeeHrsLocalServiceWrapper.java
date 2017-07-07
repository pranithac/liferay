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
 * Provides a wrapper for {@link securaxEmployeeHrsLocalService}.
 *
 * @author
 * @see securaxEmployeeHrsLocalService
 * @generated
 */
public class securaxEmployeeHrsLocalServiceWrapper
	implements securaxEmployeeHrsLocalService,
		ServiceWrapper<securaxEmployeeHrsLocalService> {
	public securaxEmployeeHrsLocalServiceWrapper(
		securaxEmployeeHrsLocalService securaxEmployeeHrsLocalService) {
		_securaxEmployeeHrsLocalService = securaxEmployeeHrsLocalService;
	}

	/**
	* Adds the securax employee hrs to the database. Also notifies the appropriate model listeners.
	*
	* @param securaxEmployeeHrs the securax employee hrs
	* @return the securax employee hrs that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.securaxEmployeeHrs addsecuraxEmployeeHrs(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.addsecuraxEmployeeHrs(securaxEmployeeHrs);
	}

	/**
	* Creates a new securax employee hrs with the primary key. Does not add the securax employee hrs to the database.
	*
	* @param EmployeeId the primary key for the new securax employee hrs
	* @return the new securax employee hrs
	*/
	@Override
	public com.trianz.lms.model.securaxEmployeeHrs createsecuraxEmployeeHrs(
		int EmployeeId) {
		return _securaxEmployeeHrsLocalService.createsecuraxEmployeeHrs(EmployeeId);
	}

	/**
	* Deletes the securax employee hrs with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs that was removed
	* @throws PortalException if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.securaxEmployeeHrs deletesecuraxEmployeeHrs(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.deletesecuraxEmployeeHrs(EmployeeId);
	}

	/**
	* Deletes the securax employee hrs from the database. Also notifies the appropriate model listeners.
	*
	* @param securaxEmployeeHrs the securax employee hrs
	* @return the securax employee hrs that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.securaxEmployeeHrs deletesecuraxEmployeeHrs(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.deletesecuraxEmployeeHrs(securaxEmployeeHrs);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _securaxEmployeeHrsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.trianz.lms.model.securaxEmployeeHrs fetchsecuraxEmployeeHrs(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.fetchsecuraxEmployeeHrs(EmployeeId);
	}

	/**
	* Returns the securax employee hrs with the primary key.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs
	* @throws PortalException if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.securaxEmployeeHrs getsecuraxEmployeeHrs(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.getsecuraxEmployeeHrs(EmployeeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the securax employee hrses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of securax employee hrses
	* @param end the upper bound of the range of securax employee hrses (not inclusive)
	* @return the range of securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.trianz.lms.model.securaxEmployeeHrs> getsecuraxEmployeeHrses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.getsecuraxEmployeeHrses(start,
			end);
	}

	/**
	* Returns the number of securax employee hrses.
	*
	* @return the number of securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getsecuraxEmployeeHrsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.getsecuraxEmployeeHrsesCount();
	}

	/**
	* Updates the securax employee hrs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param securaxEmployeeHrs the securax employee hrs
	* @return the securax employee hrs that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.securaxEmployeeHrs updatesecuraxEmployeeHrs(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securaxEmployeeHrsLocalService.updatesecuraxEmployeeHrs(securaxEmployeeHrs);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _securaxEmployeeHrsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_securaxEmployeeHrsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _securaxEmployeeHrsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.trianz.lms.model.securaxEmployeeHrs getsecureHrsPunchDateByEmployeeId(
		int employeeId, java.util.Date punchDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException {
		return _securaxEmployeeHrsLocalService.getsecureHrsPunchDateByEmployeeId(employeeId,
			punchDate);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public securaxEmployeeHrsLocalService getWrappedsecuraxEmployeeHrsLocalService() {
		return _securaxEmployeeHrsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedsecuraxEmployeeHrsLocalService(
		securaxEmployeeHrsLocalService securaxEmployeeHrsLocalService) {
		_securaxEmployeeHrsLocalService = securaxEmployeeHrsLocalService;
	}

	@Override
	public securaxEmployeeHrsLocalService getWrappedService() {
		return _securaxEmployeeHrsLocalService;
	}

	@Override
	public void setWrappedService(
		securaxEmployeeHrsLocalService securaxEmployeeHrsLocalService) {
		_securaxEmployeeHrsLocalService = securaxEmployeeHrsLocalService;
	}

	private securaxEmployeeHrsLocalService _securaxEmployeeHrsLocalService;
}