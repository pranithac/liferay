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

import com.trianz.lms.model.LeaveBalance;

import java.util.List;

/**
 * The persistence utility for the leave balance service. This utility wraps {@link LeaveBalancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveBalancePersistence
 * @see LeaveBalancePersistenceImpl
 * @generated
 */
public class LeaveBalanceUtil {
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
	public static void clearCache(LeaveBalance leaveBalance) {
		getPersistence().clearCache(leaveBalance);
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
	public static List<LeaveBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LeaveBalance update(LeaveBalance leaveBalance)
		throws SystemException {
		return getPersistence().update(leaveBalance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LeaveBalance update(LeaveBalance leaveBalance,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(leaveBalance, serviceContext);
	}

	/**
	* Returns the leave balance where EmployeeId = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveBalanceException} if it could not be found.
	*
	* @param EmployeeId the employee ID
	* @return the matching leave balance
	* @throws com.trianz.lms.NoSuchLeaveBalanceException if a matching leave balance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveBalance findByEmployeeID(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveBalanceException {
		return getPersistence().findByEmployeeID(EmployeeId);
	}

	/**
	* Returns the leave balance where EmployeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeId the employee ID
	* @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveBalance fetchByEmployeeID(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmployeeID(EmployeeId);
	}

	/**
	* Returns the leave balance where EmployeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeId the employee ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveBalance fetchByEmployeeID(
		int EmployeeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmployeeID(EmployeeId, retrieveFromCache);
	}

	/**
	* Removes the leave balance where EmployeeId = &#63; from the database.
	*
	* @param EmployeeId the employee ID
	* @return the leave balance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveBalance removeByEmployeeID(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveBalanceException {
		return getPersistence().removeByEmployeeID(EmployeeId);
	}

	/**
	* Returns the number of leave balances where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @return the number of matching leave balances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmployeeID(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmployeeID(EmployeeId);
	}

	/**
	* Caches the leave balance in the entity cache if it is enabled.
	*
	* @param leaveBalance the leave balance
	*/
	public static void cacheResult(
		com.trianz.lms.model.LeaveBalance leaveBalance) {
		getPersistence().cacheResult(leaveBalance);
	}

	/**
	* Caches the leave balances in the entity cache if it is enabled.
	*
	* @param leaveBalances the leave balances
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LeaveBalance> leaveBalances) {
		getPersistence().cacheResult(leaveBalances);
	}

	/**
	* Creates a new leave balance with the primary key. Does not add the leave balance to the database.
	*
	* @param EmployeeId the primary key for the new leave balance
	* @return the new leave balance
	*/
	public static com.trianz.lms.model.LeaveBalance create(int EmployeeId) {
		return getPersistence().create(EmployeeId);
	}

	/**
	* Removes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EmployeeId the primary key of the leave balance
	* @return the leave balance that was removed
	* @throws com.trianz.lms.NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveBalance remove(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveBalanceException {
		return getPersistence().remove(EmployeeId);
	}

	public static com.trianz.lms.model.LeaveBalance updateImpl(
		com.trianz.lms.model.LeaveBalance leaveBalance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(leaveBalance);
	}

	/**
	* Returns the leave balance with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveBalanceException} if it could not be found.
	*
	* @param EmployeeId the primary key of the leave balance
	* @return the leave balance
	* @throws com.trianz.lms.NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveBalance findByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveBalanceException {
		return getPersistence().findByPrimaryKey(EmployeeId);
	}

	/**
	* Returns the leave balance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param EmployeeId the primary key of the leave balance
	* @return the leave balance, or <code>null</code> if a leave balance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveBalance fetchByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(EmployeeId);
	}

	/**
	* Returns all the leave balances.
	*
	* @return the leave balances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveBalance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave balances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave balances
	* @param end the upper bound of the range of leave balances (not inclusive)
	* @return the range of leave balances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveBalance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave balances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave balances
	* @param end the upper bound of the range of leave balances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave balances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveBalance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the leave balances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave balances.
	*
	* @return the number of leave balances
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LeaveBalancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LeaveBalancePersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LeaveBalancePersistence.class.getName());

			ReferenceRegistry.registerReference(LeaveBalanceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LeaveBalancePersistence persistence) {
	}

	private static LeaveBalancePersistence _persistence;
}