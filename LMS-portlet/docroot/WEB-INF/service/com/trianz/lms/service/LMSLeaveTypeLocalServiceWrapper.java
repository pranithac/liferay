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
 * Provides a wrapper for {@link LMSLeaveTypeLocalService}.
 *
 * @author
 * @see LMSLeaveTypeLocalService
 * @generated
 */
public class LMSLeaveTypeLocalServiceWrapper implements LMSLeaveTypeLocalService,
	ServiceWrapper<LMSLeaveTypeLocalService> {
	public LMSLeaveTypeLocalServiceWrapper(
		LMSLeaveTypeLocalService lmsLeaveTypeLocalService) {
		_lmsLeaveTypeLocalService = lmsLeaveTypeLocalService;
	}

	/**
	* Adds the l m s leave type to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsLeaveType the l m s leave type
	* @return the l m s leave type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSLeaveType addLMSLeaveType(
		com.trianz.lms.model.LMSLeaveType lmsLeaveType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.addLMSLeaveType(lmsLeaveType);
	}

	/**
	* Creates a new l m s leave type with the primary key. Does not add the l m s leave type to the database.
	*
	* @param LeaveTypeCode the primary key for the new l m s leave type
	* @return the new l m s leave type
	*/
	@Override
	public com.trianz.lms.model.LMSLeaveType createLMSLeaveType(
		int LeaveTypeCode) {
		return _lmsLeaveTypeLocalService.createLMSLeaveType(LeaveTypeCode);
	}

	/**
	* Deletes the l m s leave type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type that was removed
	* @throws PortalException if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSLeaveType deleteLMSLeaveType(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.deleteLMSLeaveType(LeaveTypeCode);
	}

	/**
	* Deletes the l m s leave type from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsLeaveType the l m s leave type
	* @return the l m s leave type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSLeaveType deleteLMSLeaveType(
		com.trianz.lms.model.LMSLeaveType lmsLeaveType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.deleteLMSLeaveType(lmsLeaveType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lmsLeaveTypeLocalService.dynamicQuery();
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
		return _lmsLeaveTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsLeaveTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsLeaveTypeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _lmsLeaveTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lmsLeaveTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.trianz.lms.model.LMSLeaveType fetchLMSLeaveType(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.fetchLMSLeaveType(LeaveTypeCode);
	}

	/**
	* Returns the l m s leave type with the primary key.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type
	* @throws PortalException if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSLeaveType getLMSLeaveType(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.getLMSLeaveType(LeaveTypeCode);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l m s leave types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s leave types
	* @param end the upper bound of the range of l m s leave types (not inclusive)
	* @return the range of l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.trianz.lms.model.LMSLeaveType> getLMSLeaveTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.getLMSLeaveTypes(start, end);
	}

	/**
	* Returns the number of l m s leave types.
	*
	* @return the number of l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLMSLeaveTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.getLMSLeaveTypesCount();
	}

	/**
	* Updates the l m s leave type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsLeaveType the l m s leave type
	* @return the l m s leave type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSLeaveType updateLMSLeaveType(
		com.trianz.lms.model.LMSLeaveType lmsLeaveType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.updateLMSLeaveType(lmsLeaveType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lmsLeaveTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsLeaveTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lmsLeaveTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getLeaveTypeNameByCode(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return _lmsLeaveTypeLocalService.getLeaveTypeNameByCode(LeaveTypeCode);
	}

	@Override
	public int getLeaveTypeCodeByName(java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return _lmsLeaveTypeLocalService.getLeaveTypeCodeByName(LeaveTypeName);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LMSLeaveType> getLeaveTypesByLocation(
		java.lang.String Country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsLeaveTypeLocalService.getLeaveTypesByLocation(Country);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LMSLeaveTypeLocalService getWrappedLMSLeaveTypeLocalService() {
		return _lmsLeaveTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLMSLeaveTypeLocalService(
		LMSLeaveTypeLocalService lmsLeaveTypeLocalService) {
		_lmsLeaveTypeLocalService = lmsLeaveTypeLocalService;
	}

	@Override
	public LMSLeaveTypeLocalService getWrappedService() {
		return _lmsLeaveTypeLocalService;
	}

	@Override
	public void setWrappedService(
		LMSLeaveTypeLocalService lmsLeaveTypeLocalService) {
		_lmsLeaveTypeLocalService = lmsLeaveTypeLocalService;
	}

	private LMSLeaveTypeLocalService _lmsLeaveTypeLocalService;
}