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
 * Provides a wrapper for {@link LMSWeekendsLocalService}.
 *
 * @author
 * @see LMSWeekendsLocalService
 * @generated
 */
public class LMSWeekendsLocalServiceWrapper implements LMSWeekendsLocalService,
	ServiceWrapper<LMSWeekendsLocalService> {
	public LMSWeekendsLocalServiceWrapper(
		LMSWeekendsLocalService lmsWeekendsLocalService) {
		_lmsWeekendsLocalService = lmsWeekendsLocalService;
	}

	/**
	* Adds the l m s weekends to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsWeekends the l m s weekends
	* @return the l m s weekends that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSWeekends addLMSWeekends(
		com.trianz.lms.model.LMSWeekends lmsWeekends)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.addLMSWeekends(lmsWeekends);
	}

	/**
	* Creates a new l m s weekends with the primary key. Does not add the l m s weekends to the database.
	*
	* @param LocationId the primary key for the new l m s weekends
	* @return the new l m s weekends
	*/
	@Override
	public com.trianz.lms.model.LMSWeekends createLMSWeekends(int LocationId) {
		return _lmsWeekendsLocalService.createLMSWeekends(LocationId);
	}

	/**
	* Deletes the l m s weekends with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends that was removed
	* @throws PortalException if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSWeekends deleteLMSWeekends(int LocationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.deleteLMSWeekends(LocationId);
	}

	/**
	* Deletes the l m s weekends from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsWeekends the l m s weekends
	* @return the l m s weekends that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSWeekends deleteLMSWeekends(
		com.trianz.lms.model.LMSWeekends lmsWeekends)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.deleteLMSWeekends(lmsWeekends);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lmsWeekendsLocalService.dynamicQuery();
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
		return _lmsWeekendsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSWeekendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsWeekendsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSWeekendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lmsWeekendsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _lmsWeekendsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lmsWeekendsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.trianz.lms.model.LMSWeekends fetchLMSWeekends(int LocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.fetchLMSWeekends(LocationId);
	}

	/**
	* Returns the l m s weekends with the primary key.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends
	* @throws PortalException if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSWeekends getLMSWeekends(int LocationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.getLMSWeekends(LocationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l m s weekendses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSWeekendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s weekendses
	* @param end the upper bound of the range of l m s weekendses (not inclusive)
	* @return the range of l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.trianz.lms.model.LMSWeekends> getLMSWeekendses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.getLMSWeekendses(start, end);
	}

	/**
	* Returns the number of l m s weekendses.
	*
	* @return the number of l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLMSWeekendsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.getLMSWeekendsesCount();
	}

	/**
	* Updates the l m s weekends in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsWeekends the l m s weekends
	* @return the l m s weekends that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.trianz.lms.model.LMSWeekends updateLMSWeekends(
		com.trianz.lms.model.LMSWeekends lmsWeekends)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsWeekendsLocalService.updateLMSWeekends(lmsWeekends);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lmsWeekendsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsWeekendsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lmsWeekendsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.trianz.lms.model.LMSWeekends getLMSWeekendsByLocation(
		java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException {
		return _lmsWeekendsLocalService.getLMSWeekendsByLocation(Location);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LMSWeekendsLocalService getWrappedLMSWeekendsLocalService() {
		return _lmsWeekendsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLMSWeekendsLocalService(
		LMSWeekendsLocalService lmsWeekendsLocalService) {
		_lmsWeekendsLocalService = lmsWeekendsLocalService;
	}

	@Override
	public LMSWeekendsLocalService getWrappedService() {
		return _lmsWeekendsLocalService;
	}

	@Override
	public void setWrappedService(
		LMSWeekendsLocalService lmsWeekendsLocalService) {
		_lmsWeekendsLocalService = lmsWeekendsLocalService;
	}

	private LMSWeekendsLocalService _lmsWeekendsLocalService;
}