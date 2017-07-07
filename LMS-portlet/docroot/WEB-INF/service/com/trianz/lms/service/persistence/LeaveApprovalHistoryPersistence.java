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

import com.trianz.lms.model.LeaveApprovalHistory;

/**
 * The persistence interface for the leave approval history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveApprovalHistoryPersistenceImpl
 * @see LeaveApprovalHistoryUtil
 * @generated
 */
public interface LeaveApprovalHistoryPersistence extends BasePersistence<LeaveApprovalHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveApprovalHistoryUtil} to access the leave approval history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leave approval histories where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the matching leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> findByLeaveRequestId(
		java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave approval histories where LeaveRequestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveRequestId the leave request ID
	* @param start the lower bound of the range of leave approval histories
	* @param end the upper bound of the range of leave approval histories (not inclusive)
	* @return the range of matching leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> findByLeaveRequestId(
		java.lang.String LeaveRequestId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave approval histories where LeaveRequestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveRequestId the leave request ID
	* @param start the lower bound of the range of leave approval histories
	* @param end the upper bound of the range of leave approval histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> findByLeaveRequestId(
		java.lang.String LeaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first leave approval history in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave approval history
	* @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a matching leave approval history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory findByLeaveRequestId_First(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveApprovalHistoryException;

	/**
	* Returns the first leave approval history in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave approval history, or <code>null</code> if a matching leave approval history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory fetchByLeaveRequestId_First(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last leave approval history in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave approval history
	* @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a matching leave approval history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory findByLeaveRequestId_Last(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveApprovalHistoryException;

	/**
	* Returns the last leave approval history in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave approval history, or <code>null</code> if a matching leave approval history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory fetchByLeaveRequestId_Last(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave approval histories before and after the current leave approval history in the ordered set where LeaveRequestId = &#63;.
	*
	* @param SNo the primary key of the current leave approval history
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave approval history
	* @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a leave approval history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory[] findByLeaveRequestId_PrevAndNext(
		int SNo, java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveApprovalHistoryException;

	/**
	* Removes all the leave approval histories where LeaveRequestId = &#63; from the database.
	*
	* @param LeaveRequestId the leave request ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLeaveRequestId(java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave approval histories where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the number of matching leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveRequestId(java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the leave approval history in the entity cache if it is enabled.
	*
	* @param leaveApprovalHistory the leave approval history
	*/
	public void cacheResult(
		com.trianz.lms.model.LeaveApprovalHistory leaveApprovalHistory);

	/**
	* Caches the leave approval histories in the entity cache if it is enabled.
	*
	* @param leaveApprovalHistories the leave approval histories
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LeaveApprovalHistory> leaveApprovalHistories);

	/**
	* Creates a new leave approval history with the primary key. Does not add the leave approval history to the database.
	*
	* @param SNo the primary key for the new leave approval history
	* @return the new leave approval history
	*/
	public com.trianz.lms.model.LeaveApprovalHistory create(int SNo);

	/**
	* Removes the leave approval history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SNo the primary key of the leave approval history
	* @return the leave approval history that was removed
	* @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a leave approval history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory remove(int SNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveApprovalHistoryException;

	public com.trianz.lms.model.LeaveApprovalHistory updateImpl(
		com.trianz.lms.model.LeaveApprovalHistory leaveApprovalHistory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave approval history with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveApprovalHistoryException} if it could not be found.
	*
	* @param SNo the primary key of the leave approval history
	* @return the leave approval history
	* @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a leave approval history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory findByPrimaryKey(int SNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveApprovalHistoryException;

	/**
	* Returns the leave approval history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SNo the primary key of the leave approval history
	* @return the leave approval history, or <code>null</code> if a leave approval history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveApprovalHistory fetchByPrimaryKey(int SNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave approval histories.
	*
	* @return the leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave approval histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave approval histories
	* @param end the upper bound of the range of leave approval histories (not inclusive)
	* @return the range of leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave approval histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave approval histories
	* @param end the upper bound of the range of leave approval histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveApprovalHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the leave approval histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave approval histories.
	*
	* @return the number of leave approval histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}