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

import com.trianz.lms.NoSuchLeaveApprovalHistoryException;
import com.trianz.lms.model.LeaveApprovalHistory;
import com.trianz.lms.model.impl.LeaveApprovalHistoryImpl;
import com.trianz.lms.model.impl.LeaveApprovalHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave approval history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveApprovalHistoryPersistence
 * @see LeaveApprovalHistoryUtil
 * @generated
 */
public class LeaveApprovalHistoryPersistenceImpl extends BasePersistenceImpl<LeaveApprovalHistory>
	implements LeaveApprovalHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveApprovalHistoryUtil} to access the leave approval history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveApprovalHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryModelImpl.FINDER_CACHE_ENABLED,
			LeaveApprovalHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryModelImpl.FINDER_CACHE_ENABLED,
			LeaveApprovalHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVEREQUESTID =
		new FinderPath(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryModelImpl.FINDER_CACHE_ENABLED,
			LeaveApprovalHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveRequestId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID =
		new FinderPath(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryModelImpl.FINDER_CACHE_ENABLED,
			LeaveApprovalHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveRequestId",
			new String[] { String.class.getName() },
			LeaveApprovalHistoryModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVEREQUESTID = new FinderPath(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveRequestId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the leave approval histories where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the matching leave approval histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveApprovalHistory> findByLeaveRequestId(
		String LeaveRequestId) throws SystemException {
		return findByLeaveRequestId(LeaveRequestId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LeaveApprovalHistory> findByLeaveRequestId(
		String LeaveRequestId, int start, int end) throws SystemException {
		return findByLeaveRequestId(LeaveRequestId, start, end, null);
	}

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
	@Override
	public List<LeaveApprovalHistory> findByLeaveRequestId(
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

		List<LeaveApprovalHistory> list = (List<LeaveApprovalHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveApprovalHistory leaveApprovalHistory : list) {
				if (!Validator.equals(LeaveRequestId,
							leaveApprovalHistory.getLeaveRequestId())) {
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

			query.append(_SQL_SELECT_LEAVEAPPROVALHISTORY_WHERE);

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
				query.append(LeaveApprovalHistoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<LeaveApprovalHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveApprovalHistory>(list);
				}
				else {
					list = (List<LeaveApprovalHistory>)QueryUtil.list(q,
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
	 * Returns the first leave approval history in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave approval history
	 * @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a matching leave approval history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory findByLeaveRequestId_First(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws NoSuchLeaveApprovalHistoryException, SystemException {
		LeaveApprovalHistory leaveApprovalHistory = fetchByLeaveRequestId_First(LeaveRequestId,
				orderByComparator);

		if (leaveApprovalHistory != null) {
			return leaveApprovalHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveRequestId=");
		msg.append(LeaveRequestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveApprovalHistoryException(msg.toString());
	}

	/**
	 * Returns the first leave approval history in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave approval history, or <code>null</code> if a matching leave approval history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory fetchByLeaveRequestId_First(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws SystemException {
		List<LeaveApprovalHistory> list = findByLeaveRequestId(LeaveRequestId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave approval history in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave approval history
	 * @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a matching leave approval history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory findByLeaveRequestId_Last(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws NoSuchLeaveApprovalHistoryException, SystemException {
		LeaveApprovalHistory leaveApprovalHistory = fetchByLeaveRequestId_Last(LeaveRequestId,
				orderByComparator);

		if (leaveApprovalHistory != null) {
			return leaveApprovalHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveRequestId=");
		msg.append(LeaveRequestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveApprovalHistoryException(msg.toString());
	}

	/**
	 * Returns the last leave approval history in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave approval history, or <code>null</code> if a matching leave approval history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory fetchByLeaveRequestId_Last(
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLeaveRequestId(LeaveRequestId);

		if (count == 0) {
			return null;
		}

		List<LeaveApprovalHistory> list = findByLeaveRequestId(LeaveRequestId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LeaveApprovalHistory[] findByLeaveRequestId_PrevAndNext(int SNo,
		String LeaveRequestId, OrderByComparator orderByComparator)
		throws NoSuchLeaveApprovalHistoryException, SystemException {
		LeaveApprovalHistory leaveApprovalHistory = findByPrimaryKey(SNo);

		Session session = null;

		try {
			session = openSession();

			LeaveApprovalHistory[] array = new LeaveApprovalHistoryImpl[3];

			array[0] = getByLeaveRequestId_PrevAndNext(session,
					leaveApprovalHistory, LeaveRequestId, orderByComparator,
					true);

			array[1] = leaveApprovalHistory;

			array[2] = getByLeaveRequestId_PrevAndNext(session,
					leaveApprovalHistory, LeaveRequestId, orderByComparator,
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

	protected LeaveApprovalHistory getByLeaveRequestId_PrevAndNext(
		Session session, LeaveApprovalHistory leaveApprovalHistory,
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

		query.append(_SQL_SELECT_LEAVEAPPROVALHISTORY_WHERE);

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
			query.append(LeaveApprovalHistoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(leaveApprovalHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveApprovalHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave approval histories where LeaveRequestId = &#63; from the database.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveRequestId(String LeaveRequestId)
		throws SystemException {
		for (LeaveApprovalHistory leaveApprovalHistory : findByLeaveRequestId(
				LeaveRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveApprovalHistory);
		}
	}

	/**
	 * Returns the number of leave approval histories where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the number of matching leave approval histories
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

			query.append(_SQL_COUNT_LEAVEAPPROVALHISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_1 = "leaveApprovalHistory.LeaveRequestId IS NULL";
	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2 = "leaveApprovalHistory.LeaveRequestId = ?";
	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_3 = "(leaveApprovalHistory.LeaveRequestId IS NULL OR leaveApprovalHistory.LeaveRequestId = '')";

	public LeaveApprovalHistoryPersistenceImpl() {
		setModelClass(LeaveApprovalHistory.class);
	}

	/**
	 * Caches the leave approval history in the entity cache if it is enabled.
	 *
	 * @param leaveApprovalHistory the leave approval history
	 */
	@Override
	public void cacheResult(LeaveApprovalHistory leaveApprovalHistory) {
		EntityCacheUtil.putResult(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryImpl.class,
			leaveApprovalHistory.getPrimaryKey(), leaveApprovalHistory);

		leaveApprovalHistory.resetOriginalValues();
	}

	/**
	 * Caches the leave approval histories in the entity cache if it is enabled.
	 *
	 * @param leaveApprovalHistories the leave approval histories
	 */
	@Override
	public void cacheResult(List<LeaveApprovalHistory> leaveApprovalHistories) {
		for (LeaveApprovalHistory leaveApprovalHistory : leaveApprovalHistories) {
			if (EntityCacheUtil.getResult(
						LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
						LeaveApprovalHistoryImpl.class,
						leaveApprovalHistory.getPrimaryKey()) == null) {
				cacheResult(leaveApprovalHistory);
			}
			else {
				leaveApprovalHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave approval histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveApprovalHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveApprovalHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave approval history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveApprovalHistory leaveApprovalHistory) {
		EntityCacheUtil.removeResult(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryImpl.class, leaveApprovalHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveApprovalHistory> leaveApprovalHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveApprovalHistory leaveApprovalHistory : leaveApprovalHistories) {
			EntityCacheUtil.removeResult(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
				LeaveApprovalHistoryImpl.class,
				leaveApprovalHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave approval history with the primary key. Does not add the leave approval history to the database.
	 *
	 * @param SNo the primary key for the new leave approval history
	 * @return the new leave approval history
	 */
	@Override
	public LeaveApprovalHistory create(int SNo) {
		LeaveApprovalHistory leaveApprovalHistory = new LeaveApprovalHistoryImpl();

		leaveApprovalHistory.setNew(true);
		leaveApprovalHistory.setPrimaryKey(SNo);

		return leaveApprovalHistory;
	}

	/**
	 * Removes the leave approval history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SNo the primary key of the leave approval history
	 * @return the leave approval history that was removed
	 * @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a leave approval history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory remove(int SNo)
		throws NoSuchLeaveApprovalHistoryException, SystemException {
		return remove((Serializable)SNo);
	}

	/**
	 * Removes the leave approval history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave approval history
	 * @return the leave approval history that was removed
	 * @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a leave approval history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory remove(Serializable primaryKey)
		throws NoSuchLeaveApprovalHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveApprovalHistory leaveApprovalHistory = (LeaveApprovalHistory)session.get(LeaveApprovalHistoryImpl.class,
					primaryKey);

			if (leaveApprovalHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveApprovalHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveApprovalHistory);
		}
		catch (NoSuchLeaveApprovalHistoryException nsee) {
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
	protected LeaveApprovalHistory removeImpl(
		LeaveApprovalHistory leaveApprovalHistory) throws SystemException {
		leaveApprovalHistory = toUnwrappedModel(leaveApprovalHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveApprovalHistory)) {
				leaveApprovalHistory = (LeaveApprovalHistory)session.get(LeaveApprovalHistoryImpl.class,
						leaveApprovalHistory.getPrimaryKeyObj());
			}

			if (leaveApprovalHistory != null) {
				session.delete(leaveApprovalHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveApprovalHistory != null) {
			clearCache(leaveApprovalHistory);
		}

		return leaveApprovalHistory;
	}

	@Override
	public LeaveApprovalHistory updateImpl(
		com.trianz.lms.model.LeaveApprovalHistory leaveApprovalHistory)
		throws SystemException {
		leaveApprovalHistory = toUnwrappedModel(leaveApprovalHistory);

		boolean isNew = leaveApprovalHistory.isNew();

		LeaveApprovalHistoryModelImpl leaveApprovalHistoryModelImpl = (LeaveApprovalHistoryModelImpl)leaveApprovalHistory;

		Session session = null;

		try {
			session = openSession();

			if (leaveApprovalHistory.isNew()) {
				session.save(leaveApprovalHistory);

				leaveApprovalHistory.setNew(false);
			}
			else {
				session.merge(leaveApprovalHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveApprovalHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveApprovalHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveApprovalHistoryModelImpl.getOriginalLeaveRequestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID,
					args);

				args = new Object[] {
						leaveApprovalHistoryModelImpl.getLeaveRequestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApprovalHistoryImpl.class,
			leaveApprovalHistory.getPrimaryKey(), leaveApprovalHistory);

		return leaveApprovalHistory;
	}

	protected LeaveApprovalHistory toUnwrappedModel(
		LeaveApprovalHistory leaveApprovalHistory) {
		if (leaveApprovalHistory instanceof LeaveApprovalHistoryImpl) {
			return leaveApprovalHistory;
		}

		LeaveApprovalHistoryImpl leaveApprovalHistoryImpl = new LeaveApprovalHistoryImpl();

		leaveApprovalHistoryImpl.setNew(leaveApprovalHistory.isNew());
		leaveApprovalHistoryImpl.setPrimaryKey(leaveApprovalHistory.getPrimaryKey());

		leaveApprovalHistoryImpl.setSNo(leaveApprovalHistory.getSNo());
		leaveApprovalHistoryImpl.setLeaveRequestId(leaveApprovalHistory.getLeaveRequestId());
		leaveApprovalHistoryImpl.setApproverID(leaveApprovalHistory.getApproverID());
		leaveApprovalHistoryImpl.setLeaveStatus(leaveApprovalHistory.getLeaveStatus());

		return leaveApprovalHistoryImpl;
	}

	/**
	 * Returns the leave approval history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave approval history
	 * @return the leave approval history
	 * @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a leave approval history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveApprovalHistoryException, SystemException {
		LeaveApprovalHistory leaveApprovalHistory = fetchByPrimaryKey(primaryKey);

		if (leaveApprovalHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveApprovalHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveApprovalHistory;
	}

	/**
	 * Returns the leave approval history with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveApprovalHistoryException} if it could not be found.
	 *
	 * @param SNo the primary key of the leave approval history
	 * @return the leave approval history
	 * @throws com.trianz.lms.NoSuchLeaveApprovalHistoryException if a leave approval history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory findByPrimaryKey(int SNo)
		throws NoSuchLeaveApprovalHistoryException, SystemException {
		return findByPrimaryKey((Serializable)SNo);
	}

	/**
	 * Returns the leave approval history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave approval history
	 * @return the leave approval history, or <code>null</code> if a leave approval history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveApprovalHistory leaveApprovalHistory = (LeaveApprovalHistory)EntityCacheUtil.getResult(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
				LeaveApprovalHistoryImpl.class, primaryKey);

		if (leaveApprovalHistory == _nullLeaveApprovalHistory) {
			return null;
		}

		if (leaveApprovalHistory == null) {
			Session session = null;

			try {
				session = openSession();

				leaveApprovalHistory = (LeaveApprovalHistory)session.get(LeaveApprovalHistoryImpl.class,
						primaryKey);

				if (leaveApprovalHistory != null) {
					cacheResult(leaveApprovalHistory);
				}
				else {
					EntityCacheUtil.putResult(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
						LeaveApprovalHistoryImpl.class, primaryKey,
						_nullLeaveApprovalHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveApprovalHistoryModelImpl.ENTITY_CACHE_ENABLED,
					LeaveApprovalHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveApprovalHistory;
	}

	/**
	 * Returns the leave approval history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SNo the primary key of the leave approval history
	 * @return the leave approval history, or <code>null</code> if a leave approval history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveApprovalHistory fetchByPrimaryKey(int SNo)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)SNo);
	}

	/**
	 * Returns all the leave approval histories.
	 *
	 * @return the leave approval histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveApprovalHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LeaveApprovalHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<LeaveApprovalHistory> findAll(int start, int end,
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

		List<LeaveApprovalHistory> list = (List<LeaveApprovalHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVEAPPROVALHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEAPPROVALHISTORY;

				if (pagination) {
					sql = sql.concat(LeaveApprovalHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveApprovalHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveApprovalHistory>(list);
				}
				else {
					list = (List<LeaveApprovalHistory>)QueryUtil.list(q,
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
	 * Removes all the leave approval histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveApprovalHistory leaveApprovalHistory : findAll()) {
			remove(leaveApprovalHistory);
		}
	}

	/**
	 * Returns the number of leave approval histories.
	 *
	 * @return the number of leave approval histories
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

				Query q = session.createQuery(_SQL_COUNT_LEAVEAPPROVALHISTORY);

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
	 * Initializes the leave approval history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LeaveApprovalHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveApprovalHistory>> listenersList = new ArrayList<ModelListener<LeaveApprovalHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveApprovalHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveApprovalHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVEAPPROVALHISTORY = "SELECT leaveApprovalHistory FROM LeaveApprovalHistory leaveApprovalHistory";
	private static final String _SQL_SELECT_LEAVEAPPROVALHISTORY_WHERE = "SELECT leaveApprovalHistory FROM LeaveApprovalHistory leaveApprovalHistory WHERE ";
	private static final String _SQL_COUNT_LEAVEAPPROVALHISTORY = "SELECT COUNT(leaveApprovalHistory) FROM LeaveApprovalHistory leaveApprovalHistory";
	private static final String _SQL_COUNT_LEAVEAPPROVALHISTORY_WHERE = "SELECT COUNT(leaveApprovalHistory) FROM LeaveApprovalHistory leaveApprovalHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveApprovalHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveApprovalHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveApprovalHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveApprovalHistoryPersistenceImpl.class);
	private static LeaveApprovalHistory _nullLeaveApprovalHistory = new LeaveApprovalHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveApprovalHistory> toCacheModel() {
				return _nullLeaveApprovalHistoryCacheModel;
			}
		};

	private static CacheModel<LeaveApprovalHistory> _nullLeaveApprovalHistoryCacheModel =
		new CacheModel<LeaveApprovalHistory>() {
			@Override
			public LeaveApprovalHistory toEntityModel() {
				return _nullLeaveApprovalHistory;
			}
		};
}