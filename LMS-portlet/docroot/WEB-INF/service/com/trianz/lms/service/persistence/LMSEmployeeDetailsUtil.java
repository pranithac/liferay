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

import com.trianz.lms.model.LMSEmployeeDetails;

import java.util.List;

/**
 * The persistence utility for the l m s employee details service. This utility wraps {@link LMSEmployeeDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSEmployeeDetailsPersistence
 * @see LMSEmployeeDetailsPersistenceImpl
 * @generated
 */
public class LMSEmployeeDetailsUtil {
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
	public static void clearCache(LMSEmployeeDetails lmsEmployeeDetails) {
		getPersistence().clearCache(lmsEmployeeDetails);
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
	public static List<LMSEmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSEmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSEmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LMSEmployeeDetails update(
		LMSEmployeeDetails lmsEmployeeDetails) throws SystemException {
		return getPersistence().update(lmsEmployeeDetails);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LMSEmployeeDetails update(
		LMSEmployeeDetails lmsEmployeeDetails, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(lmsEmployeeDetails, serviceContext);
	}

	/**
	* Returns the l m s employee details where EmployeeEmailID = &#63; or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails findByemailId(
		java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence().findByemailId(EmployeeEmailID);
	}

	/**
	* Returns the l m s employee details where EmployeeEmailID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails fetchByemailId(
		java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByemailId(EmployeeEmailID);
	}

	/**
	* Returns the l m s employee details where EmployeeEmailID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeEmailID the employee email i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails fetchByemailId(
		java.lang.String EmployeeEmailID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemailId(EmployeeEmailID, retrieveFromCache);
	}

	/**
	* Removes the l m s employee details where EmployeeEmailID = &#63; from the database.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the l m s employee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails removeByemailId(
		java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence().removeByemailId(EmployeeEmailID);
	}

	/**
	* Returns the number of l m s employee detailses where EmployeeEmailID = &#63;.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the number of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemailId(java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemailId(EmployeeEmailID);
	}

	/**
	* Returns all the l m s employee detailses where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @return the matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findBysupervisorEmail(
		java.lang.String SupervisorEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysupervisorEmail(SupervisorEmail);
	}

	/**
	* Returns a range of all the l m s employee detailses where SupervisorEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param SupervisorEmail the supervisor email
	* @param start the lower bound of the range of l m s employee detailses
	* @param end the upper bound of the range of l m s employee detailses (not inclusive)
	* @return the range of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findBysupervisorEmail(
		java.lang.String SupervisorEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysupervisorEmail(SupervisorEmail, start, end);
	}

	/**
	* Returns an ordered range of all the l m s employee detailses where SupervisorEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param SupervisorEmail the supervisor email
	* @param start the lower bound of the range of l m s employee detailses
	* @param end the upper bound of the range of l m s employee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findBysupervisorEmail(
		java.lang.String SupervisorEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysupervisorEmail(SupervisorEmail, start, end,
			orderByComparator);
	}

	/**
	* Returns the first l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails findBysupervisorEmail_First(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence()
				   .findBysupervisorEmail_First(SupervisorEmail,
			orderByComparator);
	}

	/**
	* Returns the first l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails fetchBysupervisorEmail_First(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysupervisorEmail_First(SupervisorEmail,
			orderByComparator);
	}

	/**
	* Returns the last l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails findBysupervisorEmail_Last(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence()
				   .findBysupervisorEmail_Last(SupervisorEmail,
			orderByComparator);
	}

	/**
	* Returns the last l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails fetchBysupervisorEmail_Last(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysupervisorEmail_Last(SupervisorEmail,
			orderByComparator);
	}

	/**
	* Returns the l m s employee detailses before and after the current l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param EmployeeId the primary key of the current l m s employee details
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails[] findBysupervisorEmail_PrevAndNext(
		int EmployeeId, java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence()
				   .findBysupervisorEmail_PrevAndNext(EmployeeId,
			SupervisorEmail, orderByComparator);
	}

	/**
	* Removes all the l m s employee detailses where SupervisorEmail = &#63; from the database.
	*
	* @param SupervisorEmail the supervisor email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysupervisorEmail(java.lang.String SupervisorEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysupervisorEmail(SupervisorEmail);
	}

	/**
	* Returns the number of l m s employee detailses where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @return the number of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysupervisorEmail(java.lang.String SupervisorEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysupervisorEmail(SupervisorEmail);
	}

	/**
	* Returns the l m s employee details where EmployeeName = &#63; or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param EmployeeName the employee name
	* @return the matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails findByEmployeeName(
		java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence().findByEmployeeName(EmployeeName);
	}

	/**
	* Returns the l m s employee details where EmployeeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeName the employee name
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails fetchByEmployeeName(
		java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmployeeName(EmployeeName);
	}

	/**
	* Returns the l m s employee details where EmployeeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeName the employee name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails fetchByEmployeeName(
		java.lang.String EmployeeName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmployeeName(EmployeeName, retrieveFromCache);
	}

	/**
	* Removes the l m s employee details where EmployeeName = &#63; from the database.
	*
	* @param EmployeeName the employee name
	* @return the l m s employee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails removeByEmployeeName(
		java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence().removeByEmployeeName(EmployeeName);
	}

	/**
	* Returns the number of l m s employee detailses where EmployeeName = &#63;.
	*
	* @param EmployeeName the employee name
	* @return the number of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmployeeName(java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmployeeName(EmployeeName);
	}

	/**
	* Caches the l m s employee details in the entity cache if it is enabled.
	*
	* @param lmsEmployeeDetails the l m s employee details
	*/
	public static void cacheResult(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails) {
		getPersistence().cacheResult(lmsEmployeeDetails);
	}

	/**
	* Caches the l m s employee detailses in the entity cache if it is enabled.
	*
	* @param lmsEmployeeDetailses the l m s employee detailses
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LMSEmployeeDetails> lmsEmployeeDetailses) {
		getPersistence().cacheResult(lmsEmployeeDetailses);
	}

	/**
	* Creates a new l m s employee details with the primary key. Does not add the l m s employee details to the database.
	*
	* @param EmployeeId the primary key for the new l m s employee details
	* @return the new l m s employee details
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails create(int EmployeeId) {
		return getPersistence().create(EmployeeId);
	}

	/**
	* Removes the l m s employee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details that was removed
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails remove(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence().remove(EmployeeId);
	}

	public static com.trianz.lms.model.LMSEmployeeDetails updateImpl(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsEmployeeDetails);
	}

	/**
	* Returns the l m s employee details with the primary key or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails findByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException {
		return getPersistence().findByPrimaryKey(EmployeeId);
	}

	/**
	* Returns the l m s employee details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details, or <code>null</code> if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSEmployeeDetails fetchByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(EmployeeId);
	}

	/**
	* Returns all the l m s employee detailses.
	*
	* @return the l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l m s employee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s employee detailses
	* @param end the upper bound of the range of l m s employee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s employee detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s employee detailses.
	*
	* @return the number of l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSEmployeeDetailsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSEmployeeDetailsPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LMSEmployeeDetailsPersistence.class.getName());

			ReferenceRegistry.registerReference(LMSEmployeeDetailsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LMSEmployeeDetailsPersistence persistence) {
	}

	private static LMSEmployeeDetailsPersistence _persistence;
}