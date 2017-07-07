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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.trianz.lms.NoSuchMailNotificationsException;
import com.trianz.lms.model.LMSMailNotifications;
import com.trianz.lms.model.impl.LMSMailNotificationsImpl;
import com.trianz.lms.model.impl.LMSMailNotificationsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s mail notifications service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSMailNotificationsPersistence
 * @see LMSMailNotificationsUtil
 * @generated
 */
public class LMSMailNotificationsPersistenceImpl extends BasePersistenceImpl<LMSMailNotifications>
	implements LMSMailNotificationsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSMailNotificationsUtil} to access the l m s mail notifications persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSMailNotificationsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsModelImpl.FINDER_CACHE_ENABLED,
			LMSMailNotificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsModelImpl.FINDER_CACHE_ENABLED,
			LMSMailNotificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVEREQUESTID =
		new FinderPath(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsModelImpl.FINDER_CACHE_ENABLED,
			LMSMailNotificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveRequestId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID =
		new FinderPath(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsModelImpl.FINDER_CACHE_ENABLED,
			LMSMailNotificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveRequestId",
			new String[] { String.class.getName() },
			LMSMailNotificationsModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVEREQUESTID = new FinderPath(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveRequestId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l m s mail notificationses where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the matching l m s mail notificationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSMailNotifications> findByLeaveRequestId(
		String LeaveRequestId) throws SystemException {
		return findByLeaveRequestId(LeaveRequestId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LMSMailNotifications> findByLeaveRequestId(
		String LeaveRequestId, int start, int end) throws SystemException {
		return findByLeaveRequestId(LeaveRequestId, start, end, null);
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
	@Override
	public List<LMSMailNotifications> findByLeaveRequestId(
		String LeaveRequestId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID;
			finderArgs = new Object[] { LeaveRequestId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVEREQUESTID;
			finderArgs = new Object[] {
					LeaveRequestId,
					
					start, end, orderByComparator
				};
		}

		List<LMSMailNotifications> list = (List<LMSMailNotifications>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSMailNotifications lmsMailNotifications : list) {
				if (!Validator.equals(LeaveRequestId,
							lmsMailNotifications.getLeaveRequestId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LMSMAILNOTIFICATIONS_WHERE);

			boolean bindLeaveRequestId = false;

			if (LeaveRequestId == null) {
				query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_1);
			}
			else if (LeaveRequestId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_3);
			}
			else {
				bindLeaveRequestId = true;

				query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSMailNotificationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveRequestId) {
					qPos.add(LeaveRequestId);
				}

				if (!pagination) {
					list = (List<LMSMailNotifications>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSMailNotifications>(list);
				}
				else {
					list = (List<LMSMailNotifications>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LMSMailNotifications findByLeaveRequestId_First(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws NoSuchMailNotificationsException, SystemException {
		LMSMailNotifications lmsMailNotifications = fetchByLeaveRequestId_First(LeaveRequestId,
				orderByComparator);

		if (lmsMailNotifications != null) {
			return lmsMailNotifications;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveRequestId=");
		msg.append(LeaveRequestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMailNotificationsException(msg.toString());
	}

	/**
	 * Returns the first l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s mail notifications, or <code>null</code> if a matching l m s mail notifications could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications fetchByLeaveRequestId_First(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws SystemException {
		List<LMSMailNotifications> list = findByLeaveRequestId(LeaveRequestId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LMSMailNotifications findByLeaveRequestId_Last(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws NoSuchMailNotificationsException, SystemException {
		LMSMailNotifications lmsMailNotifications = fetchByLeaveRequestId_Last(LeaveRequestId,
				orderByComparator);

		if (lmsMailNotifications != null) {
			return lmsMailNotifications;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveRequestId=");
		msg.append(LeaveRequestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMailNotificationsException(msg.toString());
	}

	/**
	 * Returns the last l m s mail notifications in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s mail notifications, or <code>null</code> if a matching l m s mail notifications could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications fetchByLeaveRequestId_Last(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLeaveRequestId(LeaveRequestId);

		if (count == 0) {
			return null;
		}

		List<LMSMailNotifications> list = findByLeaveRequestId(LeaveRequestId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LMSMailNotifications[] findByLeaveRequestId_PrevAndNext(
		int MailNotfnId, String LeaveRequestId,
		OrderByComparator orderByComparator)
		throws NoSuchMailNotificationsException, SystemException {
		LMSMailNotifications lmsMailNotifications = findByPrimaryKey(MailNotfnId);

		Session session = null;

		try {
			session = openSession();

			LMSMailNotifications[] array = new LMSMailNotificationsImpl[3];

			array[0] = getByLeaveRequestId_PrevAndNext(session,
					lmsMailNotifications, LeaveRequestId, orderByComparator,
					true);

			array[1] = lmsMailNotifications;

			array[2] = getByLeaveRequestId_PrevAndNext(session,
					lmsMailNotifications, LeaveRequestId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSMailNotifications getByLeaveRequestId_PrevAndNext(
		Session session, LMSMailNotifications lmsMailNotifications,
		String LeaveRequestId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSMAILNOTIFICATIONS_WHERE);

		boolean bindLeaveRequestId = false;

		if (LeaveRequestId == null) {
			query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_1);
		}
		else if (LeaveRequestId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_3);
		}
		else {
			bindLeaveRequestId = true;

			query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LMSMailNotificationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLeaveRequestId) {
			qPos.add(LeaveRequestId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsMailNotifications);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSMailNotifications> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s mail notificationses where LeaveRequestId = &#63; from the database.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveRequestId(String LeaveRequestId)
		throws SystemException {
		for (LMSMailNotifications lmsMailNotifications : findByLeaveRequestId(
				LeaveRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsMailNotifications);
		}
	}

	/**
	 * Returns the number of l m s mail notificationses where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the number of matching l m s mail notificationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveRequestId(String LeaveRequestId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVEREQUESTID;

		Object[] finderArgs = new Object[] { LeaveRequestId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSMAILNOTIFICATIONS_WHERE);

			boolean bindLeaveRequestId = false;

			if (LeaveRequestId == null) {
				query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_1);
			}
			else if (LeaveRequestId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_3);
			}
			else {
				bindLeaveRequestId = true;

				query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveRequestId) {
					qPos.add(LeaveRequestId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_1 = "lmsMailNotifications.LeaveRequestId IS NULL";
	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2 = "lmsMailNotifications.LeaveRequestId = ?";
	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_3 = "(lmsMailNotifications.LeaveRequestId IS NULL OR lmsMailNotifications.LeaveRequestId = '')";

	public LMSMailNotificationsPersistenceImpl() {
		setModelClass(LMSMailNotifications.class);
	}

	/**
	 * Caches the l m s mail notifications in the entity cache if it is enabled.
	 *
	 * @param lmsMailNotifications the l m s mail notifications
	 */
	@Override
	public void cacheResult(LMSMailNotifications lmsMailNotifications) {
		EntityCacheUtil.putResult(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsImpl.class,
			lmsMailNotifications.getPrimaryKey(), lmsMailNotifications);

		lmsMailNotifications.resetOriginalValues();
	}

	/**
	 * Caches the l m s mail notificationses in the entity cache if it is enabled.
	 *
	 * @param lmsMailNotificationses the l m s mail notificationses
	 */
	@Override
	public void cacheResult(List<LMSMailNotifications> lmsMailNotificationses) {
		for (LMSMailNotifications lmsMailNotifications : lmsMailNotificationses) {
			if (EntityCacheUtil.getResult(
						LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
						LMSMailNotificationsImpl.class,
						lmsMailNotifications.getPrimaryKey()) == null) {
				cacheResult(lmsMailNotifications);
			}
			else {
				lmsMailNotifications.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s mail notificationses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSMailNotificationsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSMailNotificationsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s mail notifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSMailNotifications lmsMailNotifications) {
		EntityCacheUtil.removeResult(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsImpl.class, lmsMailNotifications.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LMSMailNotifications> lmsMailNotificationses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSMailNotifications lmsMailNotifications : lmsMailNotificationses) {
			EntityCacheUtil.removeResult(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
				LMSMailNotificationsImpl.class,
				lmsMailNotifications.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l m s mail notifications with the primary key. Does not add the l m s mail notifications to the database.
	 *
	 * @param MailNotfnId the primary key for the new l m s mail notifications
	 * @return the new l m s mail notifications
	 */
	@Override
	public LMSMailNotifications create(int MailNotfnId) {
		LMSMailNotifications lmsMailNotifications = new LMSMailNotificationsImpl();

		lmsMailNotifications.setNew(true);
		lmsMailNotifications.setPrimaryKey(MailNotfnId);

		return lmsMailNotifications;
	}

	/**
	 * Removes the l m s mail notifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MailNotfnId the primary key of the l m s mail notifications
	 * @return the l m s mail notifications that was removed
	 * @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications remove(int MailNotfnId)
		throws NoSuchMailNotificationsException, SystemException {
		return remove((Serializable)MailNotfnId);
	}

	/**
	 * Removes the l m s mail notifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s mail notifications
	 * @return the l m s mail notifications that was removed
	 * @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications remove(Serializable primaryKey)
		throws NoSuchMailNotificationsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSMailNotifications lmsMailNotifications = (LMSMailNotifications)session.get(LMSMailNotificationsImpl.class,
					primaryKey);

			if (lmsMailNotifications == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMailNotificationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsMailNotifications);
		}
		catch (NoSuchMailNotificationsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LMSMailNotifications removeImpl(
		LMSMailNotifications lmsMailNotifications) throws SystemException {
		lmsMailNotifications = toUnwrappedModel(lmsMailNotifications);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsMailNotifications)) {
				lmsMailNotifications = (LMSMailNotifications)session.get(LMSMailNotificationsImpl.class,
						lmsMailNotifications.getPrimaryKeyObj());
			}

			if (lmsMailNotifications != null) {
				session.delete(lmsMailNotifications);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsMailNotifications != null) {
			clearCache(lmsMailNotifications);
		}

		return lmsMailNotifications;
	}

	@Override
	public LMSMailNotifications updateImpl(
		com.trianz.lms.model.LMSMailNotifications lmsMailNotifications)
		throws SystemException {
		lmsMailNotifications = toUnwrappedModel(lmsMailNotifications);

		boolean isNew = lmsMailNotifications.isNew();

		LMSMailNotificationsModelImpl lmsMailNotificationsModelImpl = (LMSMailNotificationsModelImpl)lmsMailNotifications;

		Session session = null;

		try {
			session = openSession();

			if (lmsMailNotifications.isNew()) {
				session.save(lmsMailNotifications);

				lmsMailNotifications.setNew(false);
			}
			else {
				session.merge(lmsMailNotifications);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSMailNotificationsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsMailNotificationsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsMailNotificationsModelImpl.getOriginalLeaveRequestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID,
					args);

				args = new Object[] {
						lmsMailNotificationsModelImpl.getLeaveRequestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
			LMSMailNotificationsImpl.class,
			lmsMailNotifications.getPrimaryKey(), lmsMailNotifications);

		return lmsMailNotifications;
	}

	protected LMSMailNotifications toUnwrappedModel(
		LMSMailNotifications lmsMailNotifications) {
		if (lmsMailNotifications instanceof LMSMailNotificationsImpl) {
			return lmsMailNotifications;
		}

		LMSMailNotificationsImpl lmsMailNotificationsImpl = new LMSMailNotificationsImpl();

		lmsMailNotificationsImpl.setNew(lmsMailNotifications.isNew());
		lmsMailNotificationsImpl.setPrimaryKey(lmsMailNotifications.getPrimaryKey());

		lmsMailNotificationsImpl.setMailNotfnId(lmsMailNotifications.getMailNotfnId());
		lmsMailNotificationsImpl.setLeaveRequestId(lmsMailNotifications.getLeaveRequestId());
		lmsMailNotificationsImpl.setFromAddrs(lmsMailNotifications.getFromAddrs());
		lmsMailNotificationsImpl.setToAddrs(lmsMailNotifications.getToAddrs());
		lmsMailNotificationsImpl.setComments(lmsMailNotifications.getComments());

		return lmsMailNotificationsImpl;
	}

	/**
	 * Returns the l m s mail notifications with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s mail notifications
	 * @return the l m s mail notifications
	 * @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMailNotificationsException, SystemException {
		LMSMailNotifications lmsMailNotifications = fetchByPrimaryKey(primaryKey);

		if (lmsMailNotifications == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMailNotificationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsMailNotifications;
	}

	/**
	 * Returns the l m s mail notifications with the primary key or throws a {@link com.trianz.lms.NoSuchMailNotificationsException} if it could not be found.
	 *
	 * @param MailNotfnId the primary key of the l m s mail notifications
	 * @return the l m s mail notifications
	 * @throws com.trianz.lms.NoSuchMailNotificationsException if a l m s mail notifications with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications findByPrimaryKey(int MailNotfnId)
		throws NoSuchMailNotificationsException, SystemException {
		return findByPrimaryKey((Serializable)MailNotfnId);
	}

	/**
	 * Returns the l m s mail notifications with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s mail notifications
	 * @return the l m s mail notifications, or <code>null</code> if a l m s mail notifications with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSMailNotifications lmsMailNotifications = (LMSMailNotifications)EntityCacheUtil.getResult(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
				LMSMailNotificationsImpl.class, primaryKey);

		if (lmsMailNotifications == _nullLMSMailNotifications) {
			return null;
		}

		if (lmsMailNotifications == null) {
			Session session = null;

			try {
				session = openSession();

				lmsMailNotifications = (LMSMailNotifications)session.get(LMSMailNotificationsImpl.class,
						primaryKey);

				if (lmsMailNotifications != null) {
					cacheResult(lmsMailNotifications);
				}
				else {
					EntityCacheUtil.putResult(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
						LMSMailNotificationsImpl.class, primaryKey,
						_nullLMSMailNotifications);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSMailNotificationsModelImpl.ENTITY_CACHE_ENABLED,
					LMSMailNotificationsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsMailNotifications;
	}

	/**
	 * Returns the l m s mail notifications with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MailNotfnId the primary key of the l m s mail notifications
	 * @return the l m s mail notifications, or <code>null</code> if a l m s mail notifications with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSMailNotifications fetchByPrimaryKey(int MailNotfnId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)MailNotfnId);
	}

	/**
	 * Returns all the l m s mail notificationses.
	 *
	 * @return the l m s mail notificationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSMailNotifications> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LMSMailNotifications> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<LMSMailNotifications> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LMSMailNotifications> list = (List<LMSMailNotifications>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSMAILNOTIFICATIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSMAILNOTIFICATIONS;

				if (pagination) {
					sql = sql.concat(LMSMailNotificationsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSMailNotifications>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSMailNotifications>(list);
				}
				else {
					list = (List<LMSMailNotifications>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the l m s mail notificationses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSMailNotifications lmsMailNotifications : findAll()) {
			remove(lmsMailNotifications);
		}
	}

	/**
	 * Returns the number of l m s mail notificationses.
	 *
	 * @return the number of l m s mail notificationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LMSMAILNOTIFICATIONS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the l m s mail notifications persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSMailNotifications")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSMailNotifications>> listenersList = new ArrayList<ModelListener<LMSMailNotifications>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSMailNotifications>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LMSMailNotificationsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSMAILNOTIFICATIONS = "SELECT lmsMailNotifications FROM LMSMailNotifications lmsMailNotifications";
	private static final String _SQL_SELECT_LMSMAILNOTIFICATIONS_WHERE = "SELECT lmsMailNotifications FROM LMSMailNotifications lmsMailNotifications WHERE ";
	private static final String _SQL_COUNT_LMSMAILNOTIFICATIONS = "SELECT COUNT(lmsMailNotifications) FROM LMSMailNotifications lmsMailNotifications";
	private static final String _SQL_COUNT_LMSMAILNOTIFICATIONS_WHERE = "SELECT COUNT(lmsMailNotifications) FROM LMSMailNotifications lmsMailNotifications WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsMailNotifications.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSMailNotifications exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSMailNotifications exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSMailNotificationsPersistenceImpl.class);
	private static LMSMailNotifications _nullLMSMailNotifications = new LMSMailNotificationsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSMailNotifications> toCacheModel() {
				return _nullLMSMailNotificationsCacheModel;
			}
		};

	private static CacheModel<LMSMailNotifications> _nullLMSMailNotificationsCacheModel =
		new CacheModel<LMSMailNotifications>() {
			@Override
			public LMSMailNotifications toEntityModel() {
				return _nullLMSMailNotifications;
			}
		};
}