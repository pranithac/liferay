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
 * Provides the local service utility for WFHManulPunch. This utility wraps
 * {@link com.trianz.lms.service.impl.WFHManulPunchLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author
 * @see WFHManulPunchLocalService
 * @see com.trianz.lms.service.base.WFHManulPunchLocalServiceBaseImpl
 * @see com.trianz.lms.service.impl.WFHManulPunchLocalServiceImpl
 * @generated
 */
public class WFHManulPunchLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.trianz.lms.service.impl.WFHManulPunchLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the w f h manul punch to the database. Also notifies the appropriate model listeners.
	*
	* @param wfhManulPunch the w f h manul punch
	* @return the w f h manul punch that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch addWFHManulPunch(
		com.trianz.lms.model.WFHManulPunch wfhManulPunch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWFHManulPunch(wfhManulPunch);
	}

	/**
	* Creates a new w f h manul punch with the primary key. Does not add the w f h manul punch to the database.
	*
	* @param WFHManualPunchId the primary key for the new w f h manul punch
	* @return the new w f h manul punch
	*/
	public static com.trianz.lms.model.WFHManulPunch createWFHManulPunch(
		int WFHManualPunchId) {
		return getService().createWFHManulPunch(WFHManualPunchId);
	}

	/**
	* Deletes the w f h manul punch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WFHManualPunchId the primary key of the w f h manul punch
	* @return the w f h manul punch that was removed
	* @throws PortalException if a w f h manul punch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch deleteWFHManulPunch(
		int WFHManualPunchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWFHManulPunch(WFHManualPunchId);
	}

	/**
	* Deletes the w f h manul punch from the database. Also notifies the appropriate model listeners.
	*
	* @param wfhManulPunch the w f h manul punch
	* @return the w f h manul punch that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch deleteWFHManulPunch(
		com.trianz.lms.model.WFHManulPunch wfhManulPunch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWFHManulPunch(wfhManulPunch);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.WFHManulPunchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.WFHManulPunchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.trianz.lms.model.WFHManulPunch fetchWFHManulPunch(
		int WFHManualPunchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWFHManulPunch(WFHManualPunchId);
	}

	/**
	* Returns the w f h manul punch with the primary key.
	*
	* @param WFHManualPunchId the primary key of the w f h manul punch
	* @return the w f h manul punch
	* @throws PortalException if a w f h manul punch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch getWFHManulPunch(
		int WFHManualPunchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWFHManulPunch(WFHManualPunchId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the w f h manul punchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.WFHManulPunchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of w f h manul punchs
	* @param end the upper bound of the range of w f h manul punchs (not inclusive)
	* @return the range of w f h manul punchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.WFHManulPunch> getWFHManulPunchs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWFHManulPunchs(start, end);
	}

	/**
	* Returns the number of w f h manul punchs.
	*
	* @return the number of w f h manul punchs
	* @throws SystemException if a system exception occurred
	*/
	public static int getWFHManulPunchsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWFHManulPunchsCount();
	}

	/**
	* Updates the w f h manul punch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfhManulPunch the w f h manul punch
	* @return the w f h manul punch that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch updateWFHManulPunch(
		com.trianz.lms.model.WFHManulPunch wfhManulPunch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWFHManulPunch(wfhManulPunch);
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

	public static com.trianz.lms.model.WFHManulPunch getManualPunchInDetails(
		int employeeId, java.util.Date manualPunchInDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWFHManulPunchException {
		return getService()
				   .getManualPunchInDetails(employeeId, manualPunchInDate);
	}

	public static void clearService() {
		_service = null;
	}

	public static WFHManulPunchLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WFHManulPunchLocalService.class.getName());

			if (invokableLocalService instanceof WFHManulPunchLocalService) {
				_service = (WFHManulPunchLocalService)invokableLocalService;
			}
			else {
				_service = new WFHManulPunchLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WFHManulPunchLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WFHManulPunchLocalService service) {
	}

	private static WFHManulPunchLocalService _service;
}