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
 * Provides a wrapper for {@link LMSCompOffLeaveDetailsLocalService}.
 *
 * @author
 * @see LMSCompOffLeaveDetailsLocalService
 * @generated
 */
public class LMSCompOffLeaveDetailsLocalServiceWrapper
	implements LMSCompOffLeaveDetailsLocalService,
		ServiceWrapper<LMSCompOffLeaveDetailsLocalService> {
	public LMSCompOffLeaveDetailsLocalServiceWrapper(
		LMSCompOffLeaveDetailsLocalService lmsCompOffLeaveDetailsLocalService) {
		_lmsCompOffLeaveDetailsLocalService = lmsCompOffLeaveDetailsLocalService;
	}

	/**
	* Adds the l m s comp off leave details to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsCompOffLeaveDetails the l m s comp off leave details
	* @return the l m s comp off leave details that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails addLMSCompOffLeaveDetails(
		com.trianz.lms.model.LMSCompOffLeaveDetails lmsCompOffLeaveDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.addLMSCompOffLeaveDetails(lmsCompOffLeaveDetails);
	}

	/**
	* Creates a new l m s comp off leave details with the primary key. Does not add the l m s comp off leave details to the database.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key for the new l m s comp off leave details
	* @return the new l m s comp off leave details
	*/
	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails createLMSCompOffLeaveDetails(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK) {
		return _lmsCompOffLeaveDetailsLocalService.createLMSCompOffLeaveDetails(lmsCompOffLeaveDetailsPK);
	}

	/**
	* Deletes the l m s comp off leave details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	* @return the l m s comp off leave details that was removed
	* @throws PortalException if a l m s comp off leave details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails deleteLMSCompOffLeaveDetails(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.deleteLMSCompOffLeaveDetails(lmsCompOffLeaveDetailsPK);
	}

	/**
	* Deletes the l m s comp off leave details from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsCompOffLeaveDetails the l m s comp off leave details
	* @return the l m s comp off leave details that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails deleteLMSCompOffLeaveDetails(
		com.trianz.lms.model.LMSCompOffLeaveDetails lmsCompOffLeaveDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.deleteLMSCompOffLeaveDetails(lmsCompOffLeaveDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lmsCompOffLeaveDetailsLocalService.dynamicQuery();
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
		return _lmsCompOffLeaveDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsCompOffLeaveDetailsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsCompOffLeaveDetailsLocalService.dynamicQuery(dynamicQuery,
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
		return _lmsCompOffLeaveDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lmsCompOffLeaveDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchLMSCompOffLeaveDetails(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.fetchLMSCompOffLeaveDetails(lmsCompOffLeaveDetailsPK);
	}

	/**
	* Returns the l m s comp off leave details with the primary key.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	* @return the l m s comp off leave details
	* @throws PortalException if a l m s comp off leave details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails getLMSCompOffLeaveDetails(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.getLMSCompOffLeaveDetails(lmsCompOffLeaveDetailsPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l m s comp off leave detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s comp off leave detailses
	* @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	* @return the range of l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> getLMSCompOffLeaveDetailses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.getLMSCompOffLeaveDetailses(start,
			end);
	}

	/**
	* Returns the number of l m s comp off leave detailses.
	*
	* @return the number of l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLMSCompOffLeaveDetailsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.getLMSCompOffLeaveDetailsesCount();
	}

	/**
	* Updates the l m s comp off leave details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsCompOffLeaveDetails the l m s comp off leave details
	* @return the l m s comp off leave details that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails updateLMSCompOffLeaveDetails(
		com.trianz.lms.model.LMSCompOffLeaveDetails lmsCompOffLeaveDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsCompOffLeaveDetailsLocalService.updateLMSCompOffLeaveDetails(lmsCompOffLeaveDetails);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lmsCompOffLeaveDetailsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsCompOffLeaveDetailsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lmsCompOffLeaveDetailsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails getCompOfDetailsbyEmpIdDate(
		int empID, java.util.Date compOffDate) {
		return _lmsCompOffLeaveDetailsLocalService.getCompOfDetailsbyEmpIdDate(empID,
			compOffDate);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> getCompoffDetailsbyApprovalName(
		java.lang.String ApprovalName) {
		return _lmsCompOffLeaveDetailsLocalService.getCompoffDetailsbyApprovalName(ApprovalName);
	}

	@Override
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> getCompoffDetailsbyApproverEmpId(
		int AppEmpId) {
		return _lmsCompOffLeaveDetailsLocalService.getCompoffDetailsbyApproverEmpId(AppEmpId);
	}

	@Override
	public com.trianz.lms.model.LMSCompOffLeaveDetails getCompOffDetailsbyCompOffId(
		int compOffId) {
		return _lmsCompOffLeaveDetailsLocalService.getCompOffDetailsbyCompOffId(compOffId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LMSCompOffLeaveDetailsLocalService getWrappedLMSCompOffLeaveDetailsLocalService() {
		return _lmsCompOffLeaveDetailsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLMSCompOffLeaveDetailsLocalService(
		LMSCompOffLeaveDetailsLocalService lmsCompOffLeaveDetailsLocalService) {
		_lmsCompOffLeaveDetailsLocalService = lmsCompOffLeaveDetailsLocalService;
	}

	@Override
	public LMSCompOffLeaveDetailsLocalService getWrappedService() {
		return _lmsCompOffLeaveDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		LMSCompOffLeaveDetailsLocalService lmsCompOffLeaveDetailsLocalService) {
		_lmsCompOffLeaveDetailsLocalService = lmsCompOffLeaveDetailsLocalService;
	}

	private LMSCompOffLeaveDetailsLocalService _lmsCompOffLeaveDetailsLocalService;
}