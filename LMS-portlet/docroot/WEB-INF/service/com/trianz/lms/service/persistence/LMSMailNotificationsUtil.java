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

import com.trianz.lms.model.LMSMailNotifications;

import java.util.List;

/**
 * The persistence utility for the l m s mail notifications service. This utility wraps {@link LMSMailNotificationsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSMailNotificationsPersistence
 * @see LMSMailNotificationsPersistenceImpl
 * @generated
 */
public class LMSMailNotificationsUtil {
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
	public static void clearCache(LMSMailNotifications lmsMailNotifications) {
		getPersistence().clearCache(lmsMailNotifications);
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
	public static List<LMSMailNotifications> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSMailNotifications> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSMailNotifications> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LMSMailNotifications update(
		LMSMailNotifications lmsMailNotifications) throws SystemException {
		return getPersistence().update(lmsMailNotifications);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LMSMailNotifications update(
		LMSMailNotifications lmsMailNotifications, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(lmsMailNotifications, serviceContext);
	}

	/**
	* Returns all the l m s mail notificationses where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the matching l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSMailNotifications> findByLeaveRequestId(
		java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveRequestId(LeaveRequestId);
	}

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
	public static java.util.List<com.trianz.lms.model.LMSMailNotifications> findByLeaveRequestId(
		java.lang.String LeaveRequestId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveRequestId(LeaveRequestId, start, end);
	}

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
	public static java.util.List<com.trianz.lms.model.LMSMailNotifications> findByLeaveRequestId(
		java.lang.String LeaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLeaveRequestId(LeaveRequestId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s mail notifications
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSMailNotifications findByLeaveRequestId_First(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException {
		return getPersistence()
				   .findByLeaveRequestId_First(LeaveRequestId, orderByComparator);
	}

	/**
	* Returns the first l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s mail notifications, or <code>null</code> if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSMailNotifications fetchByLeaveRequestId_First(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveRequestId_First(LeaveRequestId,
			orderByComparator);
	}

	/**
	* Returns the last l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s mail notifications
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSMailNotifications findByLeaveRequestId_Last(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException {
		return getPersistence()
				   .findByLeaveRequestId_Last(LeaveRequestId, orderByComparator);
	}

	/**
	* Returns the last l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s mail notifications, or <code>null</code> if a matching l m s mail notifications could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSMailNotifications fetchByLeaveRequestId_Last(
		java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveRequestId_Last(LeaveRequestId, orderByComparator);
	}

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
	public static com.trianz.lms.model.LMSMailNotifications[] findByLeaveRequestId_PrevAndNext(
		int MailNotfnId, java.lang.String LeaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException {
		return getPersistence()
				   .findByLeaveRequestId_PrevAndNext(MailNotfnId,
			LeaveRequestId, orderByComparator);
	}

	/**
	* Removes all the l m s mail notificationses where LeaveRequestId = &#63; from the database.
	*
	* @param LeaveRequestId the leave request ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLeaveRequestId(java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLeaveRequestId(LeaveRequestId);
	}

	/**
	* Returns the number of l m s mail notificationses where LeaveRequestId = &#63;.
	*
	* @param LeaveRequestId the leave request ID
	* @return the number of matching l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveRequestId(java.lang.String LeaveRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveRequestId(LeaveRequestId);
	}

	/**
	* Caches the l m s mail notifications in the entity cache if it is enabled.
	*
	* @param lmsMailNotifications the l m s mail notifications
	*/
	public static void cacheResult(
		com.trianz.lms.model.LMSMailNotifications lmsMailNotifications) {
		getPersistence().cacheResult(lmsMailNotifications);
	}

	/**
	* Caches the l m s mail notificationses in the entity cache if it is enabled.
	*
	* @param lmsMailNotificationses the l m s mail notificationses
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LMSMailNotifications> lmsMailNotificationses) {
		getPersistence().cacheResult(lmsMailNotificationses);
	}

	/**
	* Creates a new l m s mail notifications with the primary key. Does not add the l m s mail notifications to the database.
	*
	* @param MailNotfnId the primary key for the new l m s mail notifications
	* @return the new l m s mail notifications
	*/
	public static com.trianz.lms.model.LMSMailNotifications create(
		int MailNotfnId) {
		return getPersistence().create(MailNotfnId);
	}

	/**
	* Removes the l m s mail notifications with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MailNotfnId the primary key of the l m s mail notifications
	* @return the l m s mail notifications that was removed
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSMailNotifications remove(
		int MailNotfnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException {
		return getPersistence().remove(MailNotfnId);
	}

	public static com.trianz.lms.model.LMSMailNotifications updateImpl(
		com.trianz.lms.model.LMSMailNotifications lmsMailNotifications)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsMailNotifications);
	}

	/**
	* Returns the l m s mail notifications with the primary key or throws a {@link com.trianz.lms.NoSuchMailNotificationsException} if it could not be found.
	*
	* @param MailNotfnId the primary key of the l m s mail notifications
	* @return the l m s mail notifications
	* @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSMailNotifications findByPrimaryKey(
		int MailNotfnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchMailNotificationsException {
		return getPersistence().findByPrimaryKey(MailNotfnId);
	}

	/**
	* Returns the l m s mail notifications with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param MailNotfnId the primary key of the l m s mail notifications
	* @return the l m s mail notifications, or <code>null</code> if a l m s mail notifications with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSMailNotifications fetchByPrimaryKey(
		int MailNotfnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(MailNotfnId);
	}

	/**
	* Returns all the l m s mail notificationses.
	*
	* @return the l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSMailNotifications> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.trianz.lms.model.LMSMailNotifications> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.trianz.lms.model.LMSMailNotifications> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s mail notificationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s mail notificationses.
	*
	* @return the number of l m s mail notificationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSMailNotificationsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSMailNotificationsPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LMSMailNotificationsPersistence.class.getName());

			ReferenceRegistry.registerReference(LMSMailNotificationsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LMSMailNotificationsPersistence persistence) {
	}

	private static LMSMailNotificationsPersistence _persistence;
}