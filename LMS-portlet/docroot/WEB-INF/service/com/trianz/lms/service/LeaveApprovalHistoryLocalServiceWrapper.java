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
 * Provides a wrapper for {@link LeaveApprovalHistoryLocalService}.
 *
 * @author
 * @see LeaveApprovalHistoryLocalService
 * @generated
 */
public class LeaveApprovalHistoryLocalServiceWrapper
	implements LeaveApprovalHistoryLocalService,
		ServiceWrapper<LeaveApprovalHistoryLocalService> {
	public LeaveApprovalHistoryLocalServiceWrapper(
		LeaveApprovalHistoryLocalService leaveApprovalHistoryLocalService) {
		_leaveApprovalHistoryLocalService = leaveApprovalHistoryLocalService;
	}

	/**
	* Adds the leave approval history to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApprovalHistory the leave approval history
	* @return the leave approval history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveApprovalHistory addLeaveApprovalHistory(
		com.trianz.lms.model.LeaveApprovalHistory leaveApprovalHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.addLeaveApprovalHistory(leaveApprovalHistory);
	}

	/**
	* Creates a new leave approval history with the primary key. Does not add the leave approval history to the database.
	*
	* @param SNo the primary key for the new leave approval history
	* @return the new leave approval history
	*/
	@Override
	public com.trianz.lms.model.LeaveApprovalHistory createLeaveApprovalHistory(
		int SNo) {
		return _leaveApprovalHistoryLocalService.createLeaveApprovalHistory(SNo);
	}

	/**
	* Deletes the leave approval history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SNo the primary key of the leave approval history
	* @return the leave approval history that was removed
	* @throws PortalException if a leave approval history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveApprovalHistory deleteLeaveApprovalHistory(
		int SNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.deleteLeaveApprovalHistory(SNo);
	}

	/**
	* Deletes the leave approval history from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApprovalHistory the leave approval history
	* @return the leave approval history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveApprovalHistory deleteLeaveApprovalHistory(
		com.trianz.lms.model.LeaveApprovalHistory leaveApprovalHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.deleteLeaveApprovalHistory(leaveApprovalHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveApprovalHistoryLocalService.dynamicQuery();
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
		return _leaveApprovalHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveApprovalHistoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveApprovalHistoryLocalService.dynamicQuery(dynamicQuery,
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
		return _leaveApprovalHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveApprovalHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.trianz.lms.model.LeaveApprovalHistory fetchLeaveApprovalHistory(
		int SNo) throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.fetchLeaveApprovalHistory(SNo);
	}

	/**
	* Returns the leave approval history with the primary key.
	*
	* @param SNo the primary key of the leave approval history
	* @return the leave approval history
	* @throws PortalException if a leave approval history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveApprovalHistory getLeaveApprovalHistory(
		int SNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.getLeaveApprovalHistory(SNo);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave approval histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave approval histories
	* @param end the upper bound of the range of leave approval histories (not inclusive)
	* @return the range of leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> getLeaveApprovalHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.getLeaveApprovalHistories(start,
			end);
	}

	/**
	* Returns the number of leave approval histories.
	*
	* @return the number of leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveApprovalHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.getLeaveApprovalHistoriesCount();
	}

	/**
	* Updates the leave approval history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveApprovalHistory the leave approval history
	* @return the leave approval history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LeaveApprovalHistory updateLeaveApprovalHistory(
		com.trianz.lms.model.LeaveApprovalHistory leaveApprovalHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.updateLeaveApprovalHistory(leaveApprovalHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveApprovalHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveApprovalHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveApprovalHistoryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> getLeaveApprovalHistorybyLeavereqId(
		java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveApprovalHistoryLocalService.getLeaveApprovalHistorybyLeavereqId(LeaveRequestId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveApprovalHistoryLocalService getWrappedLeaveApprovalHistoryLocalService() {
		return _leaveApprovalHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveApprovalHistoryLocalService(
		LeaveApprovalHistoryLocalService leaveApprovalHistoryLocalService) {
		_leaveApprovalHistoryLocalService = leaveApprovalHistoryLocalService;
	}

	@Override
	public LeaveApprovalHistoryLocalService getWrappedService() {
		return _leaveApprovalHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveApprovalHistoryLocalService leaveApprovalHistoryLocalService) {
		_leaveApprovalHistoryLocalService = leaveApprovalHistoryLocalService;
	}

	private LeaveApprovalHistoryLocalService _leaveApprovalHistoryLocalService;
}