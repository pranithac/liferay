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

import com.liferay.portal.service.persistence.BasePersistence;

import com.trianz.lms.model.LMSEmployeeDetails;

/**
 * The persistence interface for the l m s employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSEmployeeDetailsPersistenceImpl
 * @see LMSEmployeeDetailsUtil
 * @generated
 */
public interface LMSEmployeeDetailsPersistence extends BasePersistence<LMSEmployeeDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSEmployeeDetailsUtil} to access the l m s employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the l m s employee details where EmployeeEmailID = &#63; or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails findByemailId(
		java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Returns the l m s employee details where EmployeeEmailID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails fetchByemailId(
		java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s employee details where EmployeeEmailID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeEmailID the employee email i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails fetchByemailId(
		java.lang.String EmployeeEmailID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s employee details where EmployeeEmailID = &#63; from the database.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the l m s employee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails removeByemailId(
		java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Returns the number of l m s employee detailses where EmployeeEmailID = &#63;.
	*
	* @param EmployeeEmailID the employee email i d
	* @return the number of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByemailId(java.lang.String EmployeeEmailID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s employee detailses where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @return the matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findBysupervisorEmail(
		java.lang.String SupervisorEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findBysupervisorEmail(
		java.lang.String SupervisorEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findBysupervisorEmail(
		java.lang.String SupervisorEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails findBysupervisorEmail_First(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Returns the first l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails fetchBysupervisorEmail_First(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails findBysupervisorEmail_Last(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Returns the last l m s employee details in the ordered set where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails fetchBysupervisorEmail_Last(
		java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.trianz.lms.model.LMSEmployeeDetails[] findBysupervisorEmail_PrevAndNext(
		int EmployeeId, java.lang.String SupervisorEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Removes all the l m s employee detailses where SupervisorEmail = &#63; from the database.
	*
	* @param SupervisorEmail the supervisor email
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysupervisorEmail(java.lang.String SupervisorEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s employee detailses where SupervisorEmail = &#63;.
	*
	* @param SupervisorEmail the supervisor email
	* @return the number of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countBysupervisorEmail(java.lang.String SupervisorEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s employee details where EmployeeName = &#63; or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param EmployeeName the employee name
	* @return the matching l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails findByEmployeeName(
		java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Returns the l m s employee details where EmployeeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeName the employee name
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails fetchByEmployeeName(
		java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s employee details where EmployeeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeName the employee name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails fetchByEmployeeName(
		java.lang.String EmployeeName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s employee details where EmployeeName = &#63; from the database.
	*
	* @param EmployeeName the employee name
	* @return the l m s employee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails removeByEmployeeName(
		java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Returns the number of l m s employee detailses where EmployeeName = &#63;.
	*
	* @param EmployeeName the employee name
	* @return the number of matching l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmployeeName(java.lang.String EmployeeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s employee details in the entity cache if it is enabled.
	*
	* @param lmsEmployeeDetails the l m s employee details
	*/
	public void cacheResult(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails);

	/**
	* Caches the l m s employee detailses in the entity cache if it is enabled.
	*
	* @param lmsEmployeeDetailses the l m s employee detailses
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSEmployeeDetails> lmsEmployeeDetailses);

	/**
	* Creates a new l m s employee details with the primary key. Does not add the l m s employee details to the database.
	*
	* @param EmployeeId the primary key for the new l m s employee details
	* @return the new l m s employee details
	*/
	public com.trianz.lms.model.LMSEmployeeDetails create(int EmployeeId);

	/**
	* Removes the l m s employee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details that was removed
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails remove(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	public com.trianz.lms.model.LMSEmployeeDetails updateImpl(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s employee details with the primary key or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details
	* @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails findByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchEmployeeDetailsException;

	/**
	* Returns the l m s employee details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param EmployeeId the primary key of the l m s employee details
	* @return the l m s employee details, or <code>null</code> if a l m s employee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSEmployeeDetails fetchByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s employee detailses.
	*
	* @return the l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSEmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s employee detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s employee detailses.
	*
	* @return the number of l m s employee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}