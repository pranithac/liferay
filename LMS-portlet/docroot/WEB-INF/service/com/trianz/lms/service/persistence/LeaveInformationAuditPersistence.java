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

import com.trianz.lms.model.LeaveInformationAudit;

/**
 * The persistence interface for the leave information audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveInformationAuditPersistenceImpl
 * @see LeaveInformationAuditUtil
 * @generated
 */
public interface LeaveInformationAuditPersistence extends BasePersistence<LeaveInformationAudit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveInformationAuditUtil} to access the leave information audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leave information audits where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the matching leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveInformationAudit> findByLeaveRequestId(
		int LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave information audits where LeaveRequestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveInformationAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveRequestId the leave request ID
	* @param start the lower bound of the range of leave information audits
	* @param end the upper bound of the range of leave information audits (not inclusive)
	* @return the range of matching leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveInformationAudit> findByLeaveRequestId(
		int LeaveRequestId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave information audits where LeaveRequestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveInformationAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveRequestId the leave request ID
	* @param start the lower bound of the range of leave information audits
	* @param end the upper bound of the range of leave information audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveInformationAudit> findByLeaveRequestId(
		int LeaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first leave information audit in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave information audit
	* @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a matching leave information audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit findByLeaveRequestId_First(
		int LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationAuditException;

	/**
	* Returns the first leave information audit in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave information audit, or <code>null</code> if a matching leave information audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit fetchByLeaveRequestId_First(
		int LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last leave information audit in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave information audit
	* @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a matching leave information audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit findByLeaveRequestId_Last(
		int LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationAuditException;

	/**
	* Returns the last leave information audit in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave information audit, or <code>null</code> if a matching leave information audit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit fetchByLeaveRequestId_Last(
		int LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave information audits before and after the current leave information audit in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LogId the primary key of the current leave information audit
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave information audit
	* @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a leave information audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit[] findByLeaveRequestId_PrevAndNext(
		int LogId, int LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationAuditException;

	/**
	* Removes all the leave information audits where LeaveRequestId = &#63; from the database.
	*
	* @param LeaveRequestId the leave request ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLeaveRequestId(int LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave information audits where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the number of matching leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveRequestId(int LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the leave information audit in the entity cache if it is enabled.
	*
	* @param leaveInformationAudit the leave information audit
	*/
	public void cacheResult(
		com.trianz.lms.model.LeaveInformationAudit leaveInformationAudit);

	/**
	* Caches the leave information audits in the entity cache if it is enabled.
	*
	* @param leaveInformationAudits the leave information audits
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LeaveInformationAudit> leaveInformationAudits);

	/**
	* Creates a new leave information audit with the primary key. Does not add the leave information audit to the database.
	*
	* @param LogId the primary key for the new leave information audit
	* @return the new leave information audit
	*/
	public com.trianz.lms.model.LeaveInformationAudit create(int LogId);

	/**
	* Removes the leave information audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LogId the primary key of the leave information audit
	* @return the leave information audit that was removed
	* @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a leave information audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit remove(int LogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationAuditException;

	public com.trianz.lms.model.LeaveInformationAudit updateImpl(
		com.trianz.lms.model.LeaveInformationAudit leaveInformationAudit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave information audit with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveInformationAuditException} if it could not be found.
	*
	* @param LogId the primary key of the leave information audit
	* @return the leave information audit
	* @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a leave information audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit findByPrimaryKey(
		int LogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveInformationAuditException;

	/**
	* Returns the leave information audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LogId the primary key of the leave information audit
	* @return the leave information audit, or <code>null</code> if a leave information audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LeaveInformationAudit fetchByPrimaryKey(
		int LogId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave information audits.
	*
	* @return the leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveInformationAudit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave information audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveInformationAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave information audits
	* @param end the upper bound of the range of leave information audits (not inclusive)
	* @return the range of leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveInformationAudit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave information audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveInformationAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave information audits
	* @param end the upper bound of the range of leave information audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LeaveInformationAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the leave information audits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave information audits.
	*
	* @return the number of leave information audits
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}