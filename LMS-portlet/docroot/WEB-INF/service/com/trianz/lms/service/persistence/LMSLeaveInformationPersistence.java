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

import com.trianz.lms.model.LMSLeaveInformation;

/**
 * The persistence interface for the l m s leave information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeaveInformationPersistenceImpl
 * @see LMSLeaveInformationUtil
 * @generated
 */
public interface LMSLeaveInformationPersistence extends BasePersistence<LMSLeaveInformation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSLeaveInformationUtil} to access the l m s leave information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the l m s leave informations where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @return the matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByEmployeeId(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s leave informations where EmployeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param EmployeeId the employee ID
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @return the range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByEmployeeId(
		int EmployeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s leave informations where EmployeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param EmployeeId the employee ID
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByEmployeeId(
		int EmployeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s leave information in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByEmployeeId_First(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the first l m s leave information in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByEmployeeId_First(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s leave information in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByEmployeeId_Last(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the last l m s leave information in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByEmployeeId_Last(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave informations before and after the current l m s leave information in the ordered set where EmployeeId = &#63;.
	*
	* @param SNo the primary key of the current l m s leave information
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation[] findByEmployeeId_PrevAndNext(
		int SNo, int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Removes all the l m s leave informations where EmployeeId = &#63; from the database.
	*
	* @param EmployeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmployeeId(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave informations where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @return the number of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmployeeId(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave information where LeaveRequestId = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveInformationException} if it could not be found.
	*
	* @param LeaveRequestId the leave request ID
	* @return the matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByLeaveRequestId(
		java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the l m s leave information where LeaveRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveRequestId the leave request ID
	* @return the matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByLeaveRequestId(
		java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave information where LeaveRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveRequestId the leave request ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByLeaveRequestId(
		java.lang.String LeaveRequestId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s leave information where LeaveRequestId = &#63; from the database.
	*
	* @param LeaveRequestId the leave request ID
	* @return the l m s leave information that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation removeByLeaveRequestId(
		java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the number of l m s leave informations where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the number of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveRequestId(java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @return the matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByapprovalStatus(
		int EmployeeId, java.lang.String ApprovalStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @return the range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByapprovalStatus(
		int EmployeeId, java.lang.String ApprovalStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByapprovalStatus(
		int EmployeeId, java.lang.String ApprovalStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByapprovalStatus_First(
		int EmployeeId, java.lang.String ApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the first l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByapprovalStatus_First(
		int EmployeeId, java.lang.String ApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByapprovalStatus_Last(
		int EmployeeId, java.lang.String ApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the last l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByapprovalStatus_Last(
		int EmployeeId, java.lang.String ApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave informations before and after the current l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* @param SNo the primary key of the current l m s leave information
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation[] findByapprovalStatus_PrevAndNext(
		int SNo, int EmployeeId, java.lang.String ApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Removes all the l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63; from the database.
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByapprovalStatus(int EmployeeId,
		java.lang.String ApprovalStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param ApprovalStatus the approval status
	* @return the number of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByapprovalStatus(int EmployeeId,
		java.lang.String ApprovalStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s leave informations where isDraft = &#63;.
	*
	* @param isDraft the is draft
	* @return the matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByDrafts(
		java.lang.String isDraft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s leave informations where isDraft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isDraft the is draft
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @return the range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByDrafts(
		java.lang.String isDraft, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s leave informations where isDraft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isDraft the is draft
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByDrafts(
		java.lang.String isDraft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s leave information in the ordered set where isDraft = &#63;.
	*
	* @param isDraft the is draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByDrafts_First(
		java.lang.String isDraft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the first l m s leave information in the ordered set where isDraft = &#63;.
	*
	* @param isDraft the is draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByDrafts_First(
		java.lang.String isDraft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s leave information in the ordered set where isDraft = &#63;.
	*
	* @param isDraft the is draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByDrafts_Last(
		java.lang.String isDraft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the last l m s leave information in the ordered set where isDraft = &#63;.
	*
	* @param isDraft the is draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByDrafts_Last(
		java.lang.String isDraft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave informations before and after the current l m s leave information in the ordered set where isDraft = &#63;.
	*
	* @param SNo the primary key of the current l m s leave information
	* @param isDraft the is draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation[] findByDrafts_PrevAndNext(
		int SNo, java.lang.String isDraft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Removes all the l m s leave informations where isDraft = &#63; from the database.
	*
	* @param isDraft the is draft
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDrafts(java.lang.String isDraft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave informations where isDraft = &#63;.
	*
	* @param isDraft the is draft
	* @return the number of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByDrafts(java.lang.String isDraft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s leave informations where ApproverEmails = &#63;.
	*
	* @param ApproverEmails the approver emails
	* @return the matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByApproverEmails(
		java.lang.String ApproverEmails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s leave informations where ApproverEmails = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmails the approver emails
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @return the range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByApproverEmails(
		java.lang.String ApproverEmails, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s leave informations where ApproverEmails = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmails the approver emails
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findByApproverEmails(
		java.lang.String ApproverEmails, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s leave information in the ordered set where ApproverEmails = &#63;.
	*
	* @param ApproverEmails the approver emails
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByApproverEmails_First(
		java.lang.String ApproverEmails,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the first l m s leave information in the ordered set where ApproverEmails = &#63;.
	*
	* @param ApproverEmails the approver emails
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByApproverEmails_First(
		java.lang.String ApproverEmails,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s leave information in the ordered set where ApproverEmails = &#63;.
	*
	* @param ApproverEmails the approver emails
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByApproverEmails_Last(
		java.lang.String ApproverEmails,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the last l m s leave information in the ordered set where ApproverEmails = &#63;.
	*
	* @param ApproverEmails the approver emails
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByApproverEmails_Last(
		java.lang.String ApproverEmails,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave informations before and after the current l m s leave information in the ordered set where ApproverEmails = &#63;.
	*
	* @param SNo the primary key of the current l m s leave information
	* @param ApproverEmails the approver emails
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation[] findByApproverEmails_PrevAndNext(
		int SNo, java.lang.String ApproverEmails,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Removes all the l m s leave informations where ApproverEmails = &#63; from the database.
	*
	* @param ApproverEmails the approver emails
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApproverEmails(java.lang.String ApproverEmails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave informations where ApproverEmails = &#63;.
	*
	* @param ApproverEmails the approver emails
	* @return the number of matching l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByApproverEmails(java.lang.String ApproverEmails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s leave information in the entity cache if it is enabled.
	*
	* @param lmsLeaveInformation the l m s leave information
	*/
	public void cacheResult(
		com.trianz.lms.model.LMSLeaveInformation lmsLeaveInformation);

	/**
	* Caches the l m s leave informations in the entity cache if it is enabled.
	*
	* @param lmsLeaveInformations the l m s leave informations
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSLeaveInformation> lmsLeaveInformations);

	/**
	* Creates a new l m s leave information with the primary key. Does not add the l m s leave information to the database.
	*
	* @param SNo the primary key for the new l m s leave information
	* @return the new l m s leave information
	*/
	public com.trianz.lms.model.LMSLeaveInformation create(int SNo);

	/**
	* Removes the l m s leave information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SNo the primary key of the l m s leave information
	* @return the l m s leave information that was removed
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation remove(int SNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	public com.trianz.lms.model.LMSLeaveInformation updateImpl(
		com.trianz.lms.model.LMSLeaveInformation lmsLeaveInformation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave information with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveInformationException} if it could not be found.
	*
	* @param SNo the primary key of the l m s leave information
	* @return the l m s leave information
	* @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation findByPrimaryKey(int SNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationException;

	/**
	* Returns the l m s leave information with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SNo the primary key of the l m s leave information
	* @return the l m s leave information, or <code>null</code> if a l m s leave information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveInformation fetchByPrimaryKey(int SNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s leave informations.
	*
	* @return the l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s leave informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @return the range of l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s leave informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s leave informations
	* @param end the upper bound of the range of l m s leave informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s leave informations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave informations.
	*
	* @return the number of l m s leave informations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}