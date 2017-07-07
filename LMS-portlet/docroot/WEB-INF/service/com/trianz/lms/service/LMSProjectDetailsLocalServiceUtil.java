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
 * Provides the local service utility for LMSProjectDetails. This utility wraps
 * {@link com.trianz.lms.service.impl.LMSProjectDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author
 * @see LMSProjectDetailsLocalService
 * @see com.trianz.lms.service.base.LMSProjectDetailsLocalServiceBaseImpl
 * @see com.trianz.lms.service.impl.LMSProjectDetailsLocalServiceImpl
 * @generated
 */
public class LMSProjectDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.trianz.lms.service.impl.LMSProjectDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l m s project details to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsProjectDetails the l m s project details
	* @return the l m s project details that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSProjectDetails addLMSProjectDetails(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLMSProjectDetails(lmsProjectDetails);
	}

	/**
	* Creates a new l m s project details with the primary key. Does not add the l m s project details to the database.
	*
	* @param AssignmentID the primary key for the new l m s project details
	* @return the new l m s project details
	*/
	public static com.trianz.lms.model.LMSProjectDetails createLMSProjectDetails(
		int AssignmentID) {
		return getService().createLMSProjectDetails(AssignmentID);
	}

	/**
	* Deletes the l m s project details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param AssignmentID the primary key of the l m s project details
	* @return the l m s project details that was removed
	* @throws PortalException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSProjectDetails deleteLMSProjectDetails(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSProjectDetails(AssignmentID);
	}

	/**
	* Deletes the l m s project details from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsProjectDetails the l m s project details
	* @return the l m s project details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSProjectDetails deleteLMSProjectDetails(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSProjectDetails(lmsProjectDetails);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.trianz.lms.model.LMSProjectDetails fetchLMSProjectDetails(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLMSProjectDetails(AssignmentID);
	}

	/**
	* Returns the l m s project details with the primary key.
	*
	* @param AssignmentID the primary key of the l m s project details
	* @return the l m s project details
	* @throws PortalException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSProjectDetails getLMSProjectDetails(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSProjectDetails(AssignmentID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.trianz.lms.model.LMSProjectDetails> getLMSProjectDetailses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSProjectDetailses(start, end);
	}

	/**
	* Returns the number of l m s project detailses.
	*
	* @return the number of l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int getLMSProjectDetailsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSProjectDetailsesCount();
	}

	/**
	* Updates the l m s project details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsProjectDetails the l m s project details
	* @return the l m s project details that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSProjectDetails updateLMSProjectDetails(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLMSProjectDetails(lmsProjectDetails);
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

	public static java.util.List<com.trianz.lms.model.LMSProjectDetails> getProjectsByEmployeeId(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectsByEmployeeId(EmployeeId);
	}

	public static com.trianz.lms.model.LMSProjectDetails getProjectNameById(
		java.lang.String projectId, int employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException {
		return getService().getProjectNameById(projectId, employeeId);
	}

	public static java.util.List<com.trianz.lms.model.LMSProjectDetails> getEmployeesByApproverEmail(
		java.lang.String emailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeesByApproverEmail(emailId);
	}

	public static java.util.List<com.trianz.lms.model.LMSProjectDetails> getProjectsOfApprover(
		java.lang.String emailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectsOfApprover(emailId);
	}

	public static java.util.List<com.trianz.lms.model.LMSProjectDetails> getProjectsByApprover(
		java.lang.String emailId, java.lang.String projCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectsByApprover(emailId, projCode);
	}

	public static com.trianz.lms.model.LMSProjectDetails getProjectNameByprojectCode(
		java.lang.String projectcode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException {
		return getService().getProjectNameByprojectCode(projectcode);
	}

	public static void clearService() {
		_service = null;
	}

	public static LMSProjectDetailsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LMSProjectDetailsLocalService.class.getName());

			if (invokableLocalService instanceof LMSProjectDetailsLocalService) {
				_service = (LMSProjectDetailsLocalService)invokableLocalService;
			}
			else {
				_service = new LMSProjectDetailsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LMSProjectDetailsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LMSProjectDetailsLocalService service) {
	}

	private static LMSProjectDetailsLocalService _service;
}