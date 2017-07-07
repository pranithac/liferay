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

import com.trianz.lms.model.LMSCompOffLeaveDetails;

/**
 * The persistence interface for the l m s comp off leave details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSCompOffLeaveDetailsPersistenceImpl
 * @see LMSCompOffLeaveDetailsUtil
 * @generated
 */
public interface LMSCompOffLeaveDetailsPersistence extends BasePersistence<LMSCompOffLeaveDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSCompOffLeaveDetailsUtil} to access the l m s comp off leave details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; or throws a {@link com.trianz.lms.NoSuchCompOffLeaveDetailsException} if it could not be found.
	*
	* @param EmployeeID the employee i d
	* @param CompoffDate the compoff date
	* @return the matching l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails findByEmployeeID(
		int EmployeeID, java.util.Date CompoffDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeID the employee i d
	* @param CompoffDate the compoff date
	* @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchByEmployeeID(
		int EmployeeID, java.util.Date CompoffDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeID the employee i d
	* @param CompoffDate the compoff date
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchByEmployeeID(
		int EmployeeID, java.util.Date CompoffDate, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; from the database.
	*
	* @param EmployeeID the employee i d
	* @param CompoffDate the compoff date
	* @return the l m s comp off leave details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails removeByEmployeeID(
		int EmployeeID, java.util.Date CompoffDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the number of l m s comp off leave detailses where EmployeeID = &#63; and CompoffDate = &#63;.
	*
	* @param EmployeeID the employee i d
	* @param CompoffDate the compoff date
	* @return the number of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmployeeID(int EmployeeID, java.util.Date CompoffDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	*
	* @param ApprovedBy the approved by
	* @return the matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findByApprovedBy(
		java.lang.String ApprovedBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApprovedBy the approved by
	* @param start the lower bound of the range of l m s comp off leave detailses
	* @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	* @return the range of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findByApprovedBy(
		java.lang.String ApprovedBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApprovedBy the approved by
	* @param start the lower bound of the range of l m s comp off leave detailses
	* @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findByApprovedBy(
		java.lang.String ApprovedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	*
	* @param ApprovedBy the approved by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails findByApprovedBy_First(
		java.lang.String ApprovedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the first l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	*
	* @param ApprovedBy the approved by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchByApprovedBy_First(
		java.lang.String ApprovedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	*
	* @param ApprovedBy the approved by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails findByApprovedBy_Last(
		java.lang.String ApprovedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the last l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	*
	* @param ApprovedBy the approved by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchByApprovedBy_Last(
		java.lang.String ApprovedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s comp off leave detailses before and after the current l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key of the current l m s comp off leave details
	* @param ApprovedBy the approved by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails[] findByApprovedBy_PrevAndNext(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK,
		java.lang.String ApprovedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Removes all the l m s comp off leave detailses where ApprovedBy LIKE &#63; from the database.
	*
	* @param ApprovedBy the approved by
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApprovedBy(java.lang.String ApprovedBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	*
	* @param ApprovedBy the approved by
	* @return the number of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByApprovedBy(java.lang.String ApprovedBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	*
	* @param ApproverEmployeeID the approver employee i d
	* @return the matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findByApproverEmpId(
		int ApproverEmployeeID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmployeeID the approver employee i d
	* @param start the lower bound of the range of l m s comp off leave detailses
	* @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	* @return the range of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findByApproverEmpId(
		int ApproverEmployeeID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmployeeID the approver employee i d
	* @param start the lower bound of the range of l m s comp off leave detailses
	* @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findByApproverEmpId(
		int ApproverEmployeeID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	*
	* @param ApproverEmployeeID the approver employee i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails findByApproverEmpId_First(
		int ApproverEmployeeID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the first l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	*
	* @param ApproverEmployeeID the approver employee i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchByApproverEmpId_First(
		int ApproverEmployeeID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	*
	* @param ApproverEmployeeID the approver employee i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails findByApproverEmpId_Last(
		int ApproverEmployeeID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the last l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	*
	* @param ApproverEmployeeID the approver employee i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchByApproverEmpId_Last(
		int ApproverEmployeeID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s comp off leave detailses before and after the current l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key of the current l m s comp off leave details
	* @param ApproverEmployeeID the approver employee i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails[] findByApproverEmpId_PrevAndNext(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK,
		int ApproverEmployeeID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Removes all the l m s comp off leave detailses where ApproverEmployeeID = &#63; from the database.
	*
	* @param ApproverEmployeeID the approver employee i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApproverEmpId(int ApproverEmployeeID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	*
	* @param ApproverEmployeeID the approver employee i d
	* @return the number of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByApproverEmpId(int ApproverEmployeeID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s comp off leave details where CompOffId = &#63; or throws a {@link com.trianz.lms.NoSuchCompOffLeaveDetailsException} if it could not be found.
	*
	* @param CompOffId the comp off ID
	* @return the matching l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails findBycompOffId(
		int CompOffId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the l m s comp off leave details where CompOffId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param CompOffId the comp off ID
	* @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchBycompOffId(
		int CompOffId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s comp off leave details where CompOffId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param CompOffId the comp off ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchBycompOffId(
		int CompOffId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s comp off leave details where CompOffId = &#63; from the database.
	*
	* @param CompOffId the comp off ID
	* @return the l m s comp off leave details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails removeBycompOffId(
		int CompOffId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the number of l m s comp off leave detailses where CompOffId = &#63;.
	*
	* @param CompOffId the comp off ID
	* @return the number of matching l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countBycompOffId(int CompOffId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s comp off leave details in the entity cache if it is enabled.
	*
	* @param lmsCompOffLeaveDetails the l m s comp off leave details
	*/
	public void cacheResult(
		com.trianz.lms.model.LMSCompOffLeaveDetails lmsCompOffLeaveDetails);

	/**
	* Caches the l m s comp off leave detailses in the entity cache if it is enabled.
	*
	* @param lmsCompOffLeaveDetailses the l m s comp off leave detailses
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> lmsCompOffLeaveDetailses);

	/**
	* Creates a new l m s comp off leave details with the primary key. Does not add the l m s comp off leave details to the database.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key for the new l m s comp off leave details
	* @return the new l m s comp off leave details
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails create(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK);

	/**
	* Removes the l m s comp off leave details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	* @return the l m s comp off leave details that was removed
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails remove(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	public com.trianz.lms.model.LMSCompOffLeaveDetails updateImpl(
		com.trianz.lms.model.LMSCompOffLeaveDetails lmsCompOffLeaveDetails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s comp off leave details with the primary key or throws a {@link com.trianz.lms.NoSuchCompOffLeaveDetailsException} if it could not be found.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	* @return the l m s comp off leave details
	* @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails findByPrimaryKey(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchCompOffLeaveDetailsException;

	/**
	* Returns the l m s comp off leave details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	* @return the l m s comp off leave details, or <code>null</code> if a l m s comp off leave details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSCompOffLeaveDetails fetchByPrimaryKey(
		com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s comp off leave detailses.
	*
	* @return the l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s comp off leave detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s comp off leave detailses
	* @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	* @return the range of l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s comp off leave detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s comp off leave detailses
	* @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSCompOffLeaveDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s comp off leave detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s comp off leave detailses.
	*
	* @return the number of l m s comp off leave detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}