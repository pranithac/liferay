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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LMSEmployeeDetails. This utility wraps
 * {@link com.trianz.lms.service.impl.LMSEmployeeDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author
 * @see LMSEmployeeDetailsLocalService
 * @see com.trianz.lms.service.base.LMSEmployeeDetailsLocalServiceBaseImpl
 * @see com.trianz.lms.service.impl.LMSEmployeeDetailsLocalServiceImpl
 * @generated
 */
public class LMSEmployeeDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.trianz.lms.service.impl.LMSEmployeeDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l m s employee details to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsEmployeeDetails the l m s employee details
	* @return the l m s employee details that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails addLMSEmployeeDetails(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLMSEmployeeDetails(lmsEmployeeDetails);
	}

	/**
	* Creates a new l m s employee details with the primary key. Does not add the l m s employee details to the database.
	*
	* @param EmployeeId the primary key for the new l m s employee details
	* @return the new l m s employee details
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails createLMSEmployeeDetails(
		int EmployeeId) {
		return getService().createLMSEmployeeDetails(EmployeeId);
	}

	/**
	* Deletes the l m s employee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details that was removed
	* @throws PortalException if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails deleteLMSEmployeeDetails(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSEmployeeDetails(EmployeeId);
	}

	/**
	* Deletes the l m s employee details from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsEmployeeDetails the l m s employee details
	* @return the l m s employee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails deleteLMSEmployeeDetails(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSEmployeeDetails(lmsEmployeeDetails);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.trianz.lms.model.LMSEmployeeDetails fetchLMSEmployeeDetails(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLMSEmployeeDetails(EmployeeId);
	}

	/**
	* Returns the l m s employee details with the primary key.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details
	* @throws PortalException if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails getLMSEmployeeDetails(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSEmployeeDetails(EmployeeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l m s employee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s employee detailses
	* @param end the upper bound of the range of l m s employee detailses (not inclusive)
	* @return the range of l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> getLMSEmployeeDetailses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSEmployeeDetailses(start, end);
	}

	/**
	* Returns the number of l m s employee detailses.
	*
	* @return the number of l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int getLMSEmployeeDetailsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSEmployeeDetailsesCount();
	}

	/**
	* Updates the l m s employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsEmployeeDetails the l m s employee details
	* @return the l m s employee details that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails updateLMSEmployeeDetails(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLMSEmployeeDetails(lmsEmployeeDetails);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.trianz.lms.model.LMSEmployeeDetails getEmployeeByEmailId(
		java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getService().getEmployeeByEmailId(EmployeeEmailID);
	}

	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> getEmployeesBySupervisorEmail(
		java.lang.String SupervisorEmail)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getService().getEmployeesBySupervisorEmail(SupervisorEmail);
	}

	public static com.trianz.lms.model.LMSEmployeeDetails getEmployeeByName(
		java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getService().getEmployeeByName(EmployeeName);
	}

	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> getDistinctEmployeeCountries()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDistinctEmployeeCountries();
	}

	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> getDistinctEmployeeLocations()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDistinctEmployeeLocations();
	}

	public static void clearService() {
		_service = null;
	}

	public static LMSEmployeeDetailsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LMSEmployeeDetailsLocalService.class.getName());

			if (invokableLocalService instanceof LMSEmployeeDetailsLocalService) {
				_service = (LMSEmployeeDetailsLocalService)invokableLocalService;
			}
			else {
				_service = new LMSEmployeeDetailsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LMSEmployeeDetailsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LMSEmployeeDetailsLocalService service) {
	}

	private static LMSEmployeeDetailsLocalService _service;
}