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

import com.trianz.lms.model.securaxEmployeeHrs;

import java.util.List;

/**
 * The persistence utility for the securax employee hrs service. This utility wraps {@link securaxEmployeeHrsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see securaxEmployeeHrsPersistence
 * @see securaxEmployeeHrsPersistenceImpl
 * @generated
 */
public class securaxEmployeeHrsUtil {
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
	public static void clearCache(securaxEmployeeHrs securaxEmployeeHrs) {
		getPersistence().clearCache(securaxEmployeeHrs);
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
	public static List<securaxEmployeeHrs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<securaxEmployeeHrs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<securaxEmployeeHrs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static securaxEmployeeHrs update(
		securaxEmployeeHrs securaxEmployeeHrs) throws SystemException {
		return getPersistence().update(securaxEmployeeHrs);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static securaxEmployeeHrs update(
		securaxEmployeeHrs securaxEmployeeHrs, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(securaxEmployeeHrs, serviceContext);
	}

	/**
	* Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or throws a {@link com.trianz.lms.NoSuchsecuraxEmployeeHrsException} if it could not be found.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the matching securax employee hrs
	* @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a matching securax employee hrs could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs findByEmployeeId(
		int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException {
		return getPersistence().findByEmployeeId(EmployeeId, PunchDate);
	}

	/**
	* Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the matching securax employee hrs, or <code>null</code> if a matching securax employee hrs could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs fetchByEmployeeId(
		int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmployeeId(EmployeeId, PunchDate);
	}

	/**
	* Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching securax employee hrs, or <code>null</code> if a matching securax employee hrs could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs fetchByEmployeeId(
		int EmployeeId, java.util.Date PunchDate, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmployeeId(EmployeeId, PunchDate, retrieveFromCache);
	}

	/**
	* Removes the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; from the database.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the securax employee hrs that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs removeByEmployeeId(
		int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException {
		return getPersistence().removeByEmployeeId(EmployeeId, PunchDate);
	}

	/**
	* Returns the number of securax employee hrses where EmployeeId = &#63; and PunchDate = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the number of matching securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmployeeId(int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmployeeId(EmployeeId, PunchDate);
	}

	/**
	* Caches the securax employee hrs in the entity cache if it is enabled.
	*
	* @param securaxEmployeeHrs the securax employee hrs
	*/
	public static void cacheResult(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs) {
		getPersistence().cacheResult(securaxEmployeeHrs);
	}

	/**
	* Caches the securax employee hrses in the entity cache if it is enabled.
	*
	* @param securaxEmployeeHrses the securax employee hrses
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.securaxEmployeeHrs> securaxEmployeeHrses) {
		getPersistence().cacheResult(securaxEmployeeHrses);
	}

	/**
	* Creates a new securax employee hrs with the primary key. Does not add the securax employee hrs to the database.
	*
	* @param EmployeeId the primary key for the new securax employee hrs
	* @return the new securax employee hrs
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs create(int EmployeeId) {
		return getPersistence().create(EmployeeId);
	}

	/**
	* Removes the securax employee hrs with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs that was removed
	* @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs remove(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException {
		return getPersistence().remove(EmployeeId);
	}

	public static com.trianz.lms.model.securaxEmployeeHrs updateImpl(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(securaxEmployeeHrs);
	}

	/**
	* Returns the securax employee hrs with the primary key or throws a {@link com.trianz.lms.NoSuchsecuraxEmployeeHrsException} if it could not be found.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs
	* @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs findByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException {
		return getPersistence().findByPrimaryKey(EmployeeId);
	}

	/**
	* Returns the securax employee hrs with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs, or <code>null</code> if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.securaxEmployeeHrs fetchByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(EmployeeId);
	}

	/**
	* Returns all the securax employee hrses.
	*
	* @return the securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.securaxEmployeeHrs> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the securax employee hrses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of securax employee hrses
	* @param end the upper bound of the range of securax employee hrses (not inclusive)
	* @return the range of securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.securaxEmployeeHrs> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the securax employee hrses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of securax employee hrses
	* @param end the upper bound of the range of securax employee hrses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.securaxEmployeeHrs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the securax employee hrses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of securax employee hrses.
	*
	* @return the number of securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static securaxEmployeeHrsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (securaxEmployeeHrsPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					securaxEmployeeHrsPersistence.class.getName());

			ReferenceRegistry.registerReference(securaxEmployeeHrsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(securaxEmployeeHrsPersistence persistence) {
	}

	private static securaxEmployeeHrsPersistence _persistence;
}