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

import com.trianz.lms.model.LMSMailNotifications;

/**
 * The persistence interface for the l m s mail notifications service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSMailNotificationsPersistenceImpl
 * @see LMSMailNotificationsUtil
 * @generated
 */
public interface LMSMailNotificationsPersistence extends BasePersistence<LMSMailNotifications> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSMailNotificationsUtil} to access the l m s mail notifications persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the l m s mail notificationses where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the matching l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSMailNotifications> findByLeaveRequestId(
		java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s mail notificationses where LeaveRequestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSMailNotificationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveRequestId the leave request ID
	* @param start the lower bound of the range of l m s mail notificationses
	* @param end the upper bound of the range of l m s mail notificationses (not inclusive)
	* @return the range of matching l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSMailNotifications> findByLeaveRequestId(
		java.lang.String LeaveRequestId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s mail notificationses where LeaveRequestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSMailNotificationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveRequestId the leave request ID
	* @param start the lower bound of the range of l m s mail notificationses
	* @param end the upper bound of the range of l m s mail notificationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSMailNotifications> findByLeaveRequestId(
		java.lang.String LeaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s mail notifications
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications findByLeaveRequestId_First(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException;

	/**
	* Returns the first l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s mail notifications, or <code>null</code> if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications fetchByLeaveRequestId_First(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s mail notifications
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications findByLeaveRequestId_Last(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException;

	/**
	* Returns the last l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s mail notifications, or <code>null</code> if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications fetchByLeaveRequestId_Last(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s mail notificationses before and after the current l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param MailNotfnId the primary key of the current l m s mail notifications
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s mail notifications
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications[] findByLeaveRequestId_PrevAndNext(
		int MailNotfnId, java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException;

	/**
	* Removes all the l m s mail notificationses where LeaveRequestId = &#63; from the database.
	*
	* @param LeaveRequestId the leave request ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLeaveRequestId(java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s mail notificationses where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the number of matching l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveRequestId(java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s mail notifications in the entity cache if it is enabled.
	*
	* @param lmsMailNotifications the l m s mail notifications
	*/
	public void cacheResult(
		com.trianz.lms.model.LMSMailNotifications lmsMailNotifications);

	/**
	* Caches the l m s mail notificationses in the entity cache if it is enabled.
	*
	* @param lmsMailNotificationses the l m s mail notificationses
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSMailNotifications> lmsMailNotificationses);

	/**
	* Creates a new l m s mail notifications with the primary key. Does not add the l m s mail notifications to the database.
	*
	* @param MailNotfnId the primary key for the new l m s mail notifications
	* @return the new l m s mail notifications
	*/
	public com.trianz.lms.model.LMSMailNotifications create(int MailNotfnId);

	/**
	* Removes the l m s mail notifications with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MailNotfnId the primary key of the l m s mail notifications
	* @return the l m s mail notifications that was removed
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications remove(int MailNotfnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException;

	public com.trianz.lms.model.LMSMailNotifications updateImpl(
		com.trianz.lms.model.LMSMailNotifications lmsMailNotifications)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s mail notifications with the primary key or throws a {@link com.trianz.lms.NoSuchMailNotificationsException} if it could not be found.
	*
	* @param MailNotfnId the primary key of the l m s mail notifications
	* @return the l m s mail notifications
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications findByPrimaryKey(
		int MailNotfnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException;

	/**
	* Returns the l m s mail notifications with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param MailNotfnId the primary key of the l m s mail notifications
	* @return the l m s mail notifications, or <code>null</code> if a l m s mail notifications with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSMailNotifications fetchByPrimaryKey(
		int MailNotfnId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s mail notificationses.
	*
	* @return the l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSMailNotifications> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s mail notificationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSMailNotificationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s mail notificationses
	* @param end the upper bound of the range of l m s mail notificationses (not inclusive)
	* @return the range of l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSMailNotifications> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s mail notificationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSMailNotificationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l m s mail notificationses
	* @param end the upper bound of the range of l m s mail notificationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSMailNotifications> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s mail notificationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s mail notificationses.
	*
	* @return the number of l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}