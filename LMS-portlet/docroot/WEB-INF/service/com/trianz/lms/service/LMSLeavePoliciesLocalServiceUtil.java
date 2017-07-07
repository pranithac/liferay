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
 * Provides the local service utility for LMSLeavePolicies. This utility wraps
 * {@link com.trianz.lms.service.impl.LMSLeavePoliciesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author
 * @see LMSLeavePoliciesLocalService
 * @see com.trianz.lms.service.base.LMSLeavePoliciesLocalServiceBaseImpl
 * @see com.trianz.lms.service.impl.LMSLeavePoliciesLocalServiceImpl
 * @generated
 */
public class LMSLeavePoliciesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.trianz.lms.service.impl.LMSLeavePoliciesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l m s leave policies to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsLeavePolicies the l m s leave policies
	* @return the l m s leave policies that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies addLMSLeavePolicies(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLMSLeavePolicies(lmsLeavePolicies);
	}

	/**
	* Creates a new l m s leave policies with the primary key. Does not add the l m s leave policies to the database.
	*
	* @param PolicyId the primary key for the new l m s leave policies
	* @return the new l m s leave policies
	*/
	public static com.trianz.lms.model.LMSLeavePolicies createLMSLeavePolicies(
		int PolicyId) {
		return getService().createLMSLeavePolicies(PolicyId);
	}

	/**
	* Deletes the l m s leave policies with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies that was removed
	* @throws PortalException if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies deleteLMSLeavePolicies(
		int PolicyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSLeavePolicies(PolicyId);
	}

	/**
	* Deletes the l m s leave policies from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsLeavePolicies the l m s leave policies
	* @return the l m s leave policies that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies deleteLMSLeavePolicies(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLMSLeavePolicies(lmsLeavePolicies);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeavePoliciesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeavePoliciesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.trianz.lms.model.LMSLeavePolicies fetchLMSLeavePolicies(
		int PolicyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLMSLeavePolicies(PolicyId);
	}

	/**
	* Returns the l m s leave policies with the primary key.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies
	* @throws PortalException if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies getLMSLeavePolicies(
		int PolicyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSLeavePolicies(PolicyId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l m s leave policieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeavePoliciesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s leave policieses
	* @param end the upper bound of the range of l m s leave policieses (not inclusive)
	* @return the range of l m s leave policieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSLeavePolicies> getLMSLeavePolicieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSLeavePolicieses(start, end);
	}

	/**
	* Returns the number of l m s leave policieses.
	*
	* @return the number of l m s leave policieses
	* @throws SystemException if a system exception occurred
	*/
	public static int getLMSLeavePoliciesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSLeavePoliciesesCount();
	}

	/**
	* Updates the l m s leave policies in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsLeavePolicies the l m s leave policies
	* @return the l m s leave policies that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies updateLMSLeavePolicies(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLMSLeavePolicies(lmsLeavePolicies);
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

	public static void clearService() {
		_service = null;
	}

	public static LMSLeavePoliciesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LMSLeavePoliciesLocalService.class.getName());

			if (invokableLocalService instanceof LMSLeavePoliciesLocalService) {
				_service = (LMSLeavePoliciesLocalService)invokableLocalService;
			}
			else {
				_service = new LMSLeavePoliciesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LMSLeavePoliciesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LMSLeavePoliciesLocalService service) {
	}

	private static LMSLeavePoliciesLocalService _service;
}