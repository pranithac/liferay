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

package com.trianz.lms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.trianz.lms.model.WFHManulPunch;

import java.util.List;

/**
 * The persistence utility for the w f h manul punch service. This utility wraps {@link WFHManulPunchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see WFHManulPunchPersistence
 * @see WFHManulPunchPersistenceImpl
 * @generated
 */
public class WFHManulPunchUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WFHManulPunch wfhManulPunch) {
		getPersistence().clearCache(wfhManulPunch);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WFHManulPunch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFHManulPunch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFHManulPunch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WFHManulPunch update(WFHManulPunch wfhManulPunch)
		throws SystemException {
		return getPersistence().update(wfhManulPunch);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WFHManulPunch update(WFHManulPunch wfhManulPunch,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wfhManulPunch, serviceContext);
	}

	/**
	* Returns the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; or throws a {@link com.trianz.lms.NoSuchWFHManulPunchException} if it could not be found.
	*
	* @param EmployeeID the employee i d
	* @param PUNCHDATE the p u n c h d a t e
	* @return the matching w f h manul punch
	* @throws com.trianz.lms.NoSuchWFHManulPunchException if a matching w f h manul punch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch findByEmployeeID(
		int EmployeeID, java.util.Date PUNCHDATE)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWFHManulPunchException {
		return getPersistence().findByEmployeeID(EmployeeID, PUNCHDATE);
	}

	/**
	* Returns the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeID the employee i d
	* @param PUNCHDATE the p u n c h d a t e
	* @return the matching w f h manul punch, or <code>null</code> if a matching w f h manul punch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch fetchByEmployeeID(
		int EmployeeID, java.util.Date PUNCHDATE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmployeeID(EmployeeID, PUNCHDATE);
	}

	/**
	* Returns the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeID the employee i d
	* @param PUNCHDATE the p u n c h d a t e
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching w f h manul punch, or <code>null</code> if a matching w f h manul punch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch fetchByEmployeeID(
		int EmployeeID, java.util.Date PUNCHDATE, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmployeeID(EmployeeID, PUNCHDATE, retrieveFromCache);
	}

	/**
	* Removes the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; from the database.
	*
	* @param EmployeeID the employee i d
	* @param PUNCHDATE the p u n c h d a t e
	* @return the w f h manul punch that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch removeByEmployeeID(
		int EmployeeID, java.util.Date PUNCHDATE)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWFHManulPunchException {
		return getPersistence().removeByEmployeeID(EmployeeID, PUNCHDATE);
	}

	/**
	* Returns the number of w f h manul punchs where EmployeeID = &#63; and PUNCHDATE = &#63;.
	*
	* @param EmployeeID the employee i d
	* @param PUNCHDATE the p u n c h d a t e
	* @return the number of matching w f h manul punchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmployeeID(int EmployeeID, java.util.Date PUNCHDATE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmployeeID(EmployeeID, PUNCHDATE);
	}

	/**
	* Caches the w f h manul punch in the entity cache if it is enabled.
	*
	* @param wfhManulPunch the w f h manul punch
	*/
	public static void cacheResult(
		com.trianz.lms.model.WFHManulPunch wfhManulPunch) {
		getPersistence().cacheResult(wfhManulPunch);
	}

	/**
	* Caches the w f h manul punchs in the entity cache if it is enabled.
	*
	* @param wfhManulPunchs the w f h manul punchs
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.WFHManulPunch> wfhManulPunchs) {
		getPersistence().cacheResult(wfhManulPunchs);
	}

	/**
	* Creates a new w f h manul punch with the primary key. Does not add the w f h manul punch to the database.
	*
	* @param WFHManualPunchId the primary key for the new w f h manul punch
	* @return the new w f h manul punch
	*/
	public static com.trianz.lms.model.WFHManulPunch create(
		int WFHManualPunchId) {
		return getPersistence().create(WFHManualPunchId);
	}

	/**
	* Removes the w f h manul punch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WFHManualPunchId the primary key of the w f h manul punch
	* @return the w f h manul punch that was removed
	* @throws com.trianz.lms.NoSuchWFHManulPunchException if a w f h manul punch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch remove(
		int WFHManualPunchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWFHManulPunchException {
		return getPersistence().remove(WFHManualPunchId);
	}

	public static com.trianz.lms.model.WFHManulPunch updateImpl(
		com.trianz.lms.model.WFHManulPunch wfhManulPunch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wfhManulPunch);
	}

	/**
	* Returns the w f h manul punch with the primary key or throws a {@link com.trianz.lms.NoSuchWFHManulPunchException} if it could not be found.
	*
	* @param WFHManualPunchId the primary key of the w f h manul punch
	* @return the w f h manul punch
	* @throws com.trianz.lms.NoSuchWFHManulPunchException if a w f h manul punch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch findByPrimaryKey(
		int WFHManualPunchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWFHManulPunchException {
		return getPersistence().findByPrimaryKey(WFHManualPunchId);
	}

	/**
	* Returns the w f h manul punch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param WFHManualPunchId the primary key of the w f h manul punch
	* @return the w f h manul punch, or <code>null</code> if a w f h manul punch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.WFHManulPunch fetchByPrimaryKey(
		int WFHManualPunchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(WFHManualPunchId);
	}

	/**
	* Returns all the w f h manul punchs.
	*
	* @return the w f h manul punchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.WFHManulPunch> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.trianz.lms.model.WFHManulPunch> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the w f h manul punchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.WFHManulPunchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of w f h manul punchs
	* @param end the upper bound of the range of w f h manul punchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w f h manul punchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.WFHManulPunch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w f h manul punchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w f h manul punchs.
	*
	* @return the number of w f h manul punchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WFHManulPunchPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WFHManulPunchPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					WFHManulPunchPersistence.class.getName());

			ReferenceRegistry.registerReference(WFHManulPunchUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WFHManulPunchPersistence persistence) {
	}

	private static WFHManulPunchPersistence _persistence;
}