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
 * Provides a wrapper for {@link LeaveCategoriesLocalService}.
 *
 * @author
 * @see LeaveCategoriesLocalService
 * @generated
 */
public class LeaveCategoriesLocalServiceWrapper
	implements LeaveCategoriesLocalService,
		ServiceWrapper<LeaveCategoriesLocalService> {
	public LeaveCategoriesLocalServiceWrapper(
		LeaveCategoriesLocalService leaveCategoriesLocalService) {
		_leaveCategoriesLocalService = leaveCategoriesLocalService;
	}

	/**
	* Adds the leave categories to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveCategories the leave categories
	* @return the leave categories that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveCategories addLeaveCategories(
		com.trianz.lms.model.LeaveCategories leaveCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.addLeaveCategories(leaveCategories);
	}

	/**
	* Creates a new leave categories with the primary key. Does not add the leave categories to the database.
	*
	* @param LeaveTypeCode the primary key for the new leave categories
	* @return the new leave categories
	*/
	@Override
	public com.trianz.lms.model.LeaveCategories createLeaveCategories(
		int LeaveTypeCode) {
		return _leaveCategoriesLocalService.createLeaveCategories(LeaveTypeCode);
	}

	/**
	* Deletes the leave categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LeaveTypeCode the primary key of the leave categories
	* @return the leave categories that was removed
	* @throws PortalException if a leave categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveCategories deleteLeaveCategories(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.deleteLeaveCategories(LeaveTypeCode);
	}

	/**
	* Deletes the leave categories from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveCategories the leave categories
	* @return the leave categories that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveCategories deleteLeaveCategories(
		com.trianz.lms.model.LeaveCategories leaveCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.deleteLeaveCategories(leaveCategories);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveCategoriesLocalService.dynamicQuery();
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
		return _leaveCategoriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveCategoriesLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveCategoriesLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _leaveCategoriesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveCategoriesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.trianz.lms.model.LeaveCategories fetchLeaveCategories(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.fetchLeaveCategories(LeaveTypeCode);
	}

	/**
	* Returns the leave categories with the primary key.
	*
	* @param LeaveTypeCode the primary key of the leave categories
	* @return the leave categories
	* @throws PortalException if a leave categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveCategories getLeaveCategories(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.getLeaveCategories(LeaveTypeCode);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave categorieses
	* @param end the upper bound of the range of leave categorieses (not inclusive)
	* @return the range of leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.trianz.lms.model.LeaveCategories> getLeaveCategorieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.getLeaveCategorieses(start, end);
	}

	/**
	* Returns the number of leave categorieses.
	*
	* @return the number of leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveCategoriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.getLeaveCategoriesesCount();
	}

	/**
	* Updates the leave categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveCategories the leave categories
	* @return the leave categories that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveCategories updateLeaveCategories(
		com.trianz.lms.model.LeaveCategories leaveCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.updateLeaveCategories(leaveCategories);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveCategoriesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveCategoriesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveCategoriesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getCategoryByLeaveType(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return _leaveCategoriesLocalService.getCategoryByLeaveType(LeaveTypeCode);
	}

	@Override
	public java.lang.String getCategoryNameByID(java.lang.String CategoryCode,
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return _leaveCategoriesLocalService.getCategoryNameByID(CategoryCode,
			LeaveTypeCode);
	}

	@Override
	public java.lang.String getCategoryIdByName(java.lang.String CategoryName,
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return _leaveCategoriesLocalService.getCategoryIdByName(CategoryName,
			LeaveTypeCode);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LeaveCategories> getCategoriesByName(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCategoriesLocalService.getCategoriesByName(categoryName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveCategoriesLocalService getWrappedLeaveCategoriesLocalService() {
		return _leaveCategoriesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveCategoriesLocalService(
		LeaveCategoriesLocalService leaveCategoriesLocalService) {
		_leaveCategoriesLocalService = leaveCategoriesLocalService;
	}

	@Override
	public LeaveCategoriesLocalService getWrappedService() {
		return _leaveCategoriesLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveCategoriesLocalService leaveCategoriesLocalService) {
		_leaveCategoriesLocalService = leaveCategoriesLocalService;
	}

	private LeaveCategoriesLocalService _leaveCategoriesLocalService;
}