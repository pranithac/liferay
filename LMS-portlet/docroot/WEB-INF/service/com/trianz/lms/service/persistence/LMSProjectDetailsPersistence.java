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

import com.trianz.lms.model.LMSProjectDetails;

/**
 * The persistence interface for the l m s project details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSProjectDetailsPersistenceImpl
 * @see LMSProjectDetailsUtil
 * @generated
 */
public interface LMSProjectDetailsPersistence extends BasePersistence<LMSProjectDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSProjectDetailsUtil} to access the l m s project details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the l m s project detailses where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @return the matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByEmployeeId(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s project detailses where EmployeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param EmployeeId the employee ID
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @return the range of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByEmployeeId(
		int EmployeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s project detailses where EmployeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param EmployeeId the employee ID
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByEmployeeId(
		int EmployeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s project details in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByEmployeeId_First(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the first l m s project details in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByEmployeeId_First(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s project details in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByEmployeeId_Last(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the last l m s project details in the ordered set where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByEmployeeId_Last(
		int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project detailses before and after the current l m s project details in the ordered set where EmployeeId = &#63;.
	*
	* @param AssignmentID the primary key of the current l m s project details
	* @param EmployeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails[] findByEmployeeId_PrevAndNext(
		int AssignmentID, int EmployeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Removes all the l m s project detailses where EmployeeId = &#63; from the database.
	*
	* @param EmployeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmployeeId(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s project detailses where EmployeeId = &#63;.
	*
	* @param EmployeeId the employee ID
	* @return the number of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmployeeId(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; or throws a {@link com.trianz.lms.NoSuchProjectDetailsException} if it could not be found.
	*
	* @param ProjectCode the project code
	* @param EmployeeId the employee ID
	* @return the matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByProjectCode(
		java.lang.String ProjectCode, int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ProjectCode the project code
	* @param EmployeeId the employee ID
	* @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByProjectCode(
		java.lang.String ProjectCode, int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ProjectCode the project code
	* @param EmployeeId the employee ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByProjectCode(
		java.lang.String ProjectCode, int EmployeeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; from the database.
	*
	* @param ProjectCode the project code
	* @param EmployeeId the employee ID
	* @return the l m s project details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails removeByProjectCode(
		java.lang.String ProjectCode, int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the number of l m s project detailses where ProjectCode = &#63; and EmployeeId = &#63;.
	*
	* @param ProjectCode the project code
	* @param EmployeeId the employee ID
	* @return the number of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectCode(java.lang.String ProjectCode, int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project details where ProjectCode = &#63; or throws a {@link com.trianz.lms.NoSuchProjectDetailsException} if it could not be found.
	*
	* @param ProjectCode the project code
	* @return the matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByProjectCodetogetName(
		java.lang.String ProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the l m s project details where ProjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ProjectCode the project code
	* @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByProjectCodetogetName(
		java.lang.String ProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project details where ProjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ProjectCode the project code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByProjectCodetogetName(
		java.lang.String ProjectCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s project details where ProjectCode = &#63; from the database.
	*
	* @param ProjectCode the project code
	* @return the l m s project details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails removeByProjectCodetogetName(
		java.lang.String ProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the number of l m s project detailses where ProjectCode = &#63;.
	*
	* @param ProjectCode the project code
	* @return the number of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectCodetogetName(java.lang.String ProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s project detailses where ApproverEmail = &#63;.
	*
	* @param ApproverEmail the approver email
	* @return the matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByApproverEmailId(
		java.lang.String ApproverEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s project detailses where ApproverEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmail the approver email
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @return the range of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByApproverEmailId(
		java.lang.String ApproverEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s project detailses where ApproverEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmail the approver email
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByApproverEmailId(
		java.lang.String ApproverEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s project details in the ordered set where ApproverEmail = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByApproverEmailId_First(
		java.lang.String ApproverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the first l m s project details in the ordered set where ApproverEmail = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByApproverEmailId_First(
		java.lang.String ApproverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s project details in the ordered set where ApproverEmail = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByApproverEmailId_Last(
		java.lang.String ApproverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the last l m s project details in the ordered set where ApproverEmail = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByApproverEmailId_Last(
		java.lang.String ApproverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project detailses before and after the current l m s project details in the ordered set where ApproverEmail = &#63;.
	*
	* @param AssignmentID the primary key of the current l m s project details
	* @param ApproverEmail the approver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails[] findByApproverEmailId_PrevAndNext(
		int AssignmentID, java.lang.String ApproverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Removes all the l m s project detailses where ApproverEmail = &#63; from the database.
	*
	* @param ApproverEmail the approver email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApproverEmailId(java.lang.String ApproverEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s project detailses where ApproverEmail = &#63;.
	*
	* @param ApproverEmail the approver email
	* @return the number of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByApproverEmailId(java.lang.String ApproverEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @return the matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByApproverandProject(
		java.lang.String ApproverEmail, java.lang.String ProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @return the range of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByApproverandProject(
		java.lang.String ApproverEmail, java.lang.String ProjectCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findByApproverandProject(
		java.lang.String ApproverEmail, java.lang.String ProjectCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByApproverandProject_First(
		java.lang.String ApproverEmail, java.lang.String ProjectCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the first l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByApproverandProject_First(
		java.lang.String ApproverEmail, java.lang.String ProjectCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByApproverandProject_Last(
		java.lang.String ApproverEmail, java.lang.String ProjectCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the last l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByApproverandProject_Last(
		java.lang.String ApproverEmail, java.lang.String ProjectCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project detailses before and after the current l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* @param AssignmentID the primary key of the current l m s project details
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails[] findByApproverandProject_PrevAndNext(
		int AssignmentID, java.lang.String ApproverEmail,
		java.lang.String ProjectCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Removes all the l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63; from the database.
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApproverandProject(java.lang.String ApproverEmail,
		java.lang.String ProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63;.
	*
	* @param ApproverEmail the approver email
	* @param ProjectCode the project code
	* @return the number of matching l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByApproverandProject(java.lang.String ApproverEmail,
		java.lang.String ProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s project details in the entity cache if it is enabled.
	*
	* @param lmsProjectDetails the l m s project details
	*/
	public void cacheResult(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails);

	/**
	* Caches the l m s project detailses in the entity cache if it is enabled.
	*
	* @param lmsProjectDetailses the l m s project detailses
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSProjectDetails> lmsProjectDetailses);

	/**
	* Creates a new l m s project details with the primary key. Does not add the l m s project details to the database.
	*
	* @param AssignmentID the primary key for the new l m s project details
	* @return the new l m s project details
	*/
	public com.trianz.lms.model.LMSProjectDetails create(int AssignmentID);

	/**
	* Removes the l m s project details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param AssignmentID the primary key of the l m s project details
	* @return the l m s project details that was removed
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails remove(int AssignmentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	public com.trianz.lms.model.LMSProjectDetails updateImpl(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s project details with the primary key or throws a {@link com.trianz.lms.NoSuchProjectDetailsException} if it could not be found.
	*
	* @param AssignmentID the primary key of the l m s project details
	* @return the l m s project details
	* @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails findByPrimaryKey(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchProjectDetailsException;

	/**
	* Returns the l m s project details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param AssignmentID the primary key of the l m s project details
	* @return the l m s project details, or <code>null</code> if a l m s project details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSProjectDetails fetchByPrimaryKey(
		int AssignmentID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s project detailses.
	*
	* @return the l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s project detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @return the range of l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s project detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSProjectDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s project detailses
	* @param end the upper bound of the range of l m s project detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSProjectDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s project detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s project detailses.
	*
	* @return the number of l m s project detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}