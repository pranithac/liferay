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
 * Provides a wrapper for {@link LMSProjectDetailsLocalService}.
 *
 * @author
 * @see LMSProjectDetailsLocalService
 * @generated
 */
public class LMSProjectDetailsLocalServiceWrapper
	implements LMSProjectDetailsLocalService,
		ServiceWrapper<LMSProjectDetailsLocalService> {
	public LMSProjectDetailsLocalServiceWrapper(
		LMSProjectDetailsLocalService lmsProjectDetailsLocalService) {
		_lmsProjectDetailsLocalService = lmsProjectDetailsLocalService;
	}

	/**
	* Adds the l m s project details to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsProjectDetails the l m s project details
	* @return the l m s project details that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSProjectDetails addLMSProjectDetails(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.addLMSProjectDetails(lmsProjectDetails);
	}

	/**
	* Creates a new l m s project details with the primary key. Does not add the l m s project details to the database.
	*
	* @param AssignmentID the primary key for the new l m s project details
	* @return the new l m s project details
	*/
	@Override
	public com.trianz.lms.model.LMSProjectDetails createLMSProjectDetails(
		int AssignmentID) {
		return _lmsProjectDetailsLocalService.createLMSProjectDetails(AssignmentID);
	}

	/**
	* Deletes the l m s project details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param AssignmentID the primary key of the l m s project details
	* @return the l m s project details that was removed
	* @throws PortalException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSProjectDetails deleteLMSProjectDetails(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.deleteLMSProjectDetails(AssignmentID);
	}

	/**
	* Deletes the l m s project details from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsProjectDetails the l m s project details
	* @return the l m s project details that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSProjectDetails deleteLMSProjectDetails(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.deleteLMSProjectDetails(lmsProjectDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lmsProjectDetailsLocalService.dynamicQuery();
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
		return _lmsProjectDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsProjectDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsProjectDetailsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _lmsProjectDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lmsProjectDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.trianz.lms.model.LMSProjectDetails fetchLMSProjectDetails(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.fetchLMSProjectDetails(AssignmentID);
	}

	/**
	* Returns the l m s project details with the primary key.
	*
	* @param AssignmentID the primary key of the l m s project details
	* @return the l m s project details
	* @throws PortalException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSProjectDetails getLMSProjectDetails(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getLMSProjectDetails(AssignmentID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l m s project detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @return the range of l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> getLMSProjectDetailses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getLMSProjectDetailses(start, end);
	}

	/**
	* Returns the number of l m s project detailses.
	*
	* @return the number of l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLMSProjectDetailsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getLMSProjectDetailsesCount();
	}

	/**
	* Updates the l m s project details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsProjectDetails the l m s project details
	* @return the l m s project details that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSProjectDetails updateLMSProjectDetails(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.updateLMSProjectDetails(lmsProjectDetails);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lmsProjectDetailsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsProjectDetailsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lmsProjectDetailsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> getProjectsByEmployeeId(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getProjectsByEmployeeId(EmployeeId);
	}

	@Override
	public com.trianz.lms.model.LMSProjectDetails getProjectNameById(
		java.lang.String projectId, int employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException {
		return _lmsProjectDetailsLocalService.getProjectNameById(projectId,
			employeeId);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> getEmployeesByApproverEmail(
		java.lang.String emailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getEmployeesByApproverEmail(emailId);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> getProjectsOfApprover(
		java.lang.String emailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getProjectsOfApprover(emailId);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> getProjectsByApprover(
		java.lang.String emailId, java.lang.String projCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsProjectDetailsLocalService.getProjectsByApprover(emailId,
			projCode);
	}

	@Override
	public com.trianz.lms.model.LMSProjectDetails getProjectNameByprojectCode(
		java.lang.String projectcode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException {
		return _lmsProjectDetailsLocalService.getProjectNameByprojectCode(projectcode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LMSProjectDetailsLocalService getWrappedLMSProjectDetailsLocalService() {
		return _lmsProjectDetailsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLMSProjectDetailsLocalService(
		LMSProjectDetailsLocalService lmsProjectDetailsLocalService) {
		_lmsProjectDetailsLocalService = lmsProjectDetailsLocalService;
	}

	@Override
	public LMSProjectDetailsLocalService getWrappedService() {
		return _lmsProjectDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		LMSProjectDetailsLocalService lmsProjectDetailsLocalService) {
		_lmsProjectDetailsLocalService = lmsProjectDetailsLocalService;
	}

	private LMSProjectDetailsLocalService _lmsProjectDetailsLocalService;
}