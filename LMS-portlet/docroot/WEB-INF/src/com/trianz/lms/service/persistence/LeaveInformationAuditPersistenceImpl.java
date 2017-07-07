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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.trianz.lms.NoSuchLeaveInformationAuditException;
import com.trianz.lms.model.LeaveInformationAudit;
import com.trianz.lms.model.impl.LeaveInformationAuditImpl;
import com.trianz.lms.model.impl.LeaveInformationAuditModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave information audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveInformationAuditPersistence
 * @see LeaveInformationAuditUtil
 * @generated
 */
public class LeaveInformationAuditPersistenceImpl extends BasePersistenceImpl<LeaveInformationAudit>
	implements LeaveInformationAuditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveInformationAuditUtil} to access the leave information audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveInformationAuditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditModelImpl.FINDER_CACHE_ENABLED,
			LeaveInformationAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditModelImpl.FINDER_CACHE_ENABLED,
			LeaveInformationAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVEREQUESTID =
		new FinderPath(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditModelImpl.FINDER_CACHE_ENABLED,
			LeaveInformationAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveRequestId",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID =
		new FinderPath(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditModelImpl.FINDER_CACHE_ENABLED,
			LeaveInformationAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveRequestId",
			new String[] { Integer.class.getName() },
			LeaveInformationAuditModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVEREQUESTID = new FinderPath(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveRequestId",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the leave information audits where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the matching leave information audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveInformationAudit> findByLeaveRequestId(int LeaveRequestId)
		throws SystemException {
		return findByLeaveRequestId(LeaveRequestId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LeaveInformationAudit> findByLeaveRequestId(
		int LeaveRequestId, int start, int end) throws SystemException {
		return findByLeaveRequestId(LeaveRequestId, start, end, null);
	}

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
	@Override
	public List<LeaveInformationAudit> findByLeaveRequestId(
		int LeaveRequestId, int start, int end,
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

		List<LeaveInformationAudit> list = (List<LeaveInformationAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveInformationAudit leaveInformationAudit : list) {
				if ((LeaveRequestId != leaveInformationAudit.getLeaveRequestId())) {
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

			query.append(_SQL_SELECT_LEAVEINFORMATIONAUDIT_WHERE);

			query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveInformationAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(LeaveRequestId);

				if (!pagination) {
					list = (List<LeaveInformationAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveInformationAudit>(list);
				}
				else {
					list = (List<LeaveInformationAudit>)QueryUtil.list(q,
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
	 * Returns the first leave information audit in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave information audit
	 * @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a matching leave information audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit findByLeaveRequestId_First(
		int LeaveRequestId, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationAuditException, SystemException {
		LeaveInformationAudit leaveInformationAudit = fetchByLeaveRequestId_First(LeaveRequestId,
				orderByComparator);

		if (leaveInformationAudit != null) {
			return leaveInformationAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveRequestId=");
		msg.append(LeaveRequestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationAuditException(msg.toString());
	}

	/**
	 * Returns the first leave information audit in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave information audit, or <code>null</code> if a matching leave information audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit fetchByLeaveRequestId_First(
		int LeaveRequestId, OrderByComparator orderByComparator)
		throws SystemException {
		List<LeaveInformationAudit> list = findByLeaveRequestId(LeaveRequestId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave information audit in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave information audit
	 * @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a matching leave information audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit findByLeaveRequestId_Last(int LeaveRequestId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationAuditException, SystemException {
		LeaveInformationAudit leaveInformationAudit = fetchByLeaveRequestId_Last(LeaveRequestId,
				orderByComparator);

		if (leaveInformationAudit != null) {
			return leaveInformationAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveRequestId=");
		msg.append(LeaveRequestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationAuditException(msg.toString());
	}

	/**
	 * Returns the last leave information audit in the ordered set where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave information audit, or <code>null</code> if a matching leave information audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit fetchByLeaveRequestId_Last(
		int LeaveRequestId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLeaveRequestId(LeaveRequestId);

		if (count == 0) {
			return null;
		}

		List<LeaveInformationAudit> list = findByLeaveRequestId(LeaveRequestId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LeaveInformationAudit[] findByLeaveRequestId_PrevAndNext(int LogId,
		int LeaveRequestId, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationAuditException, SystemException {
		LeaveInformationAudit leaveInformationAudit = findByPrimaryKey(LogId);

		Session session = null;

		try {
			session = openSession();

			LeaveInformationAudit[] array = new LeaveInformationAuditImpl[3];

			array[0] = getByLeaveRequestId_PrevAndNext(session,
					leaveInformationAudit, LeaveRequestId, orderByComparator,
					true);

			array[1] = leaveInformationAudit;

			array[2] = getByLeaveRequestId_PrevAndNext(session,
					leaveInformationAudit, LeaveRequestId, orderByComparator,
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

	protected LeaveInformationAudit getByLeaveRequestId_PrevAndNext(
		Session session, LeaveInformationAudit leaveInformationAudit,
		int LeaveRequestId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVEINFORMATIONAUDIT_WHERE);

		query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

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
			query.append(LeaveInformationAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(LeaveRequestId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveInformationAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveInformationAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave information audits where LeaveRequestId = &#63; from the database.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveRequestId(int LeaveRequestId)
		throws SystemException {
		for (LeaveInformationAudit leaveInformationAudit : findByLeaveRequestId(
				LeaveRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveInformationAudit);
		}
	}

	/**
	 * Returns the number of leave information audits where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the number of matching leave information audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveRequestId(int LeaveRequestId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVEREQUESTID;

		Object[] finderArgs = new Object[] { LeaveRequestId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVEINFORMATIONAUDIT_WHERE);

			query.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(LeaveRequestId);

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

	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2 = "leaveInformationAudit.LeaveRequestId = ?";

	public LeaveInformationAuditPersistenceImpl() {
		setModelClass(LeaveInformationAudit.class);
	}

	/**
	 * Caches the leave information audit in the entity cache if it is enabled.
	 *
	 * @param leaveInformationAudit the leave information audit
	 */
	@Override
	public void cacheResult(LeaveInformationAudit leaveInformationAudit) {
		EntityCacheUtil.putResult(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditImpl.class,
			leaveInformationAudit.getPrimaryKey(), leaveInformationAudit);

		leaveInformationAudit.resetOriginalValues();
	}

	/**
	 * Caches the leave information audits in the entity cache if it is enabled.
	 *
	 * @param leaveInformationAudits the leave information audits
	 */
	@Override
	public void cacheResult(List<LeaveInformationAudit> leaveInformationAudits) {
		for (LeaveInformationAudit leaveInformationAudit : leaveInformationAudits) {
			if (EntityCacheUtil.getResult(
						LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
						LeaveInformationAuditImpl.class,
						leaveInformationAudit.getPrimaryKey()) == null) {
				cacheResult(leaveInformationAudit);
			}
			else {
				leaveInformationAudit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave information audits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveInformationAuditImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveInformationAuditImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave information audit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveInformationAudit leaveInformationAudit) {
		EntityCacheUtil.removeResult(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditImpl.class,
			leaveInformationAudit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveInformationAudit> leaveInformationAudits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveInformationAudit leaveInformationAudit : leaveInformationAudits) {
			EntityCacheUtil.removeResult(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
				LeaveInformationAuditImpl.class,
				leaveInformationAudit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave information audit with the primary key. Does not add the leave information audit to the database.
	 *
	 * @param LogId the primary key for the new leave information audit
	 * @return the new leave information audit
	 */
	@Override
	public LeaveInformationAudit create(int LogId) {
		LeaveInformationAudit leaveInformationAudit = new LeaveInformationAuditImpl();

		leaveInformationAudit.setNew(true);
		leaveInformationAudit.setPrimaryKey(LogId);

		return leaveInformationAudit;
	}

	/**
	 * Removes the leave information audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LogId the primary key of the leave information audit
	 * @return the leave information audit that was removed
	 * @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a leave information audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit remove(int LogId)
		throws NoSuchLeaveInformationAuditException, SystemException {
		return remove((Serializable)LogId);
	}

	/**
	 * Removes the leave information audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave information audit
	 * @return the leave information audit that was removed
	 * @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a leave information audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit remove(Serializable primaryKey)
		throws NoSuchLeaveInformationAuditException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveInformationAudit leaveInformationAudit = (LeaveInformationAudit)session.get(LeaveInformationAuditImpl.class,
					primaryKey);

			if (leaveInformationAudit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveInformationAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveInformationAudit);
		}
		catch (NoSuchLeaveInformationAuditException nsee) {
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
	protected LeaveInformationAudit removeImpl(
		LeaveInformationAudit leaveInformationAudit) throws SystemException {
		leaveInformationAudit = toUnwrappedModel(leaveInformationAudit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveInformationAudit)) {
				leaveInformationAudit = (LeaveInformationAudit)session.get(LeaveInformationAuditImpl.class,
						leaveInformationAudit.getPrimaryKeyObj());
			}

			if (leaveInformationAudit != null) {
				session.delete(leaveInformationAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveInformationAudit != null) {
			clearCache(leaveInformationAudit);
		}

		return leaveInformationAudit;
	}

	@Override
	public LeaveInformationAudit updateImpl(
		com.trianz.lms.model.LeaveInformationAudit leaveInformationAudit)
		throws SystemException {
		leaveInformationAudit = toUnwrappedModel(leaveInformationAudit);

		boolean isNew = leaveInformationAudit.isNew();

		LeaveInformationAuditModelImpl leaveInformationAuditModelImpl = (LeaveInformationAuditModelImpl)leaveInformationAudit;

		Session session = null;

		try {
			session = openSession();

			if (leaveInformationAudit.isNew()) {
				session.save(leaveInformationAudit);

				leaveInformationAudit.setNew(false);
			}
			else {
				session.merge(leaveInformationAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveInformationAuditModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveInformationAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveInformationAuditModelImpl.getOriginalLeaveRequestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID,
					args);

				args = new Object[] {
						leaveInformationAuditModelImpl.getLeaveRequestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEREQUESTID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
			LeaveInformationAuditImpl.class,
			leaveInformationAudit.getPrimaryKey(), leaveInformationAudit);

		return leaveInformationAudit;
	}

	protected LeaveInformationAudit toUnwrappedModel(
		LeaveInformationAudit leaveInformationAudit) {
		if (leaveInformationAudit instanceof LeaveInformationAuditImpl) {
			return leaveInformationAudit;
		}

		LeaveInformationAuditImpl leaveInformationAuditImpl = new LeaveInformationAuditImpl();

		leaveInformationAuditImpl.setNew(leaveInformationAudit.isNew());
		leaveInformationAuditImpl.setPrimaryKey(leaveInformationAudit.getPrimaryKey());

		leaveInformationAuditImpl.setLogId(leaveInformationAudit.getLogId());
		leaveInformationAuditImpl.setLeaveRequestId(leaveInformationAudit.getLeaveRequestId());
		leaveInformationAuditImpl.setAction(leaveInformationAudit.getAction());
		leaveInformationAuditImpl.setActionBy(leaveInformationAudit.getActionBy());
		leaveInformationAuditImpl.setCreatedDate(leaveInformationAudit.getCreatedDate());

		return leaveInformationAuditImpl;
	}

	/**
	 * Returns the leave information audit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave information audit
	 * @return the leave information audit
	 * @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a leave information audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveInformationAuditException, SystemException {
		LeaveInformationAudit leaveInformationAudit = fetchByPrimaryKey(primaryKey);

		if (leaveInformationAudit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveInformationAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveInformationAudit;
	}

	/**
	 * Returns the leave information audit with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveInformationAuditException} if it could not be found.
	 *
	 * @param LogId the primary key of the leave information audit
	 * @return the leave information audit
	 * @throws com.trianz.lms.NoSuchLeaveInformationAuditException if a leave information audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit findByPrimaryKey(int LogId)
		throws NoSuchLeaveInformationAuditException, SystemException {
		return findByPrimaryKey((Serializable)LogId);
	}

	/**
	 * Returns the leave information audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave information audit
	 * @return the leave information audit, or <code>null</code> if a leave information audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveInformationAudit leaveInformationAudit = (LeaveInformationAudit)EntityCacheUtil.getResult(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
				LeaveInformationAuditImpl.class, primaryKey);

		if (leaveInformationAudit == _nullLeaveInformationAudit) {
			return null;
		}

		if (leaveInformationAudit == null) {
			Session session = null;

			try {
				session = openSession();

				leaveInformationAudit = (LeaveInformationAudit)session.get(LeaveInformationAuditImpl.class,
						primaryKey);

				if (leaveInformationAudit != null) {
					cacheResult(leaveInformationAudit);
				}
				else {
					EntityCacheUtil.putResult(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
						LeaveInformationAuditImpl.class, primaryKey,
						_nullLeaveInformationAudit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveInformationAuditModelImpl.ENTITY_CACHE_ENABLED,
					LeaveInformationAuditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveInformationAudit;
	}

	/**
	 * Returns the leave information audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LogId the primary key of the leave information audit
	 * @return the leave information audit, or <code>null</code> if a leave information audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveInformationAudit fetchByPrimaryKey(int LogId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)LogId);
	}

	/**
	 * Returns all the leave information audits.
	 *
	 * @return the leave information audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveInformationAudit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LeaveInformationAudit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<LeaveInformationAudit> findAll(int start, int end,
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

		List<LeaveInformationAudit> list = (List<LeaveInformationAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVEINFORMATIONAUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEINFORMATIONAUDIT;

				if (pagination) {
					sql = sql.concat(LeaveInformationAuditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveInformationAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveInformationAudit>(list);
				}
				else {
					list = (List<LeaveInformationAudit>)QueryUtil.list(q,
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
	 * Removes all the leave information audits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveInformationAudit leaveInformationAudit : findAll()) {
			remove(leaveInformationAudit);
		}
	}

	/**
	 * Returns the number of leave information audits.
	 *
	 * @return the number of leave information audits
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

				Query q = session.createQuery(_SQL_COUNT_LEAVEINFORMATIONAUDIT);

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
	 * Initializes the leave information audit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LeaveInformationAudit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveInformationAudit>> listenersList = new ArrayList<ModelListener<LeaveInformationAudit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveInformationAudit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveInformationAuditImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVEINFORMATIONAUDIT = "SELECT leaveInformationAudit FROM LeaveInformationAudit leaveInformationAudit";
	private static final String _SQL_SELECT_LEAVEINFORMATIONAUDIT_WHERE = "SELECT leaveInformationAudit FROM LeaveInformationAudit leaveInformationAudit WHERE ";
	private static final String _SQL_COUNT_LEAVEINFORMATIONAUDIT = "SELECT COUNT(leaveInformationAudit) FROM LeaveInformationAudit leaveInformationAudit";
	private static final String _SQL_COUNT_LEAVEINFORMATIONAUDIT_WHERE = "SELECT COUNT(leaveInformationAudit) FROM LeaveInformationAudit leaveInformationAudit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveInformationAudit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveInformationAudit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveInformationAudit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveInformationAuditPersistenceImpl.class);
	private static LeaveInformationAudit _nullLeaveInformationAudit = new LeaveInformationAuditImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveInformationAudit> toCacheModel() {
				return _nullLeaveInformationAuditCacheModel;
			}
		};

	private static CacheModel<LeaveInformationAudit> _nullLeaveInformationAuditCacheModel =
		new CacheModel<LeaveInformationAudit>() {
			@Override
			public LeaveInformationAudit toEntityModel() {
				return _nullLeaveInformationAudit;
			}
		};
}