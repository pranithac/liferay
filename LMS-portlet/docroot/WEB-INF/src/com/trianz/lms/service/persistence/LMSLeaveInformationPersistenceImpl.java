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

import com.trianz.lms.NoSuchLeaveInformationException;
import com.trianz.lms.model.LMSLeaveInformation;
import com.trianz.lms.model.impl.LMSLeaveInformationImpl;
import com.trianz.lms.model.impl.LMSLeaveInformationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s leave information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeaveInformationPersistence
 * @see LMSLeaveInformationUtil
 * @generated
 */
public class LMSLeaveInformationPersistenceImpl extends BasePersistenceImpl<LMSLeaveInformation>
	implements LMSLeaveInformationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSLeaveInformationUtil} to access the l m s leave information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSLeaveInformationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] { Integer.class.getName() },
			LMSLeaveInformationModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			LMSLeaveInformationModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the l m s leave informations where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @return the matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveInformation> findByEmployeeId(int EmployeeId)
		throws SystemException {
		return findByEmployeeId(EmployeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByEmployeeId(int EmployeeId,
		int start, int end) throws SystemException {
		return findByEmployeeId(EmployeeId, start, end, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByEmployeeId(int EmployeeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { EmployeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { EmployeeId, start, end, orderByComparator };
		}

		List<LMSLeaveInformation> list = (List<LMSLeaveInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSLeaveInformation lmsLeaveInformation : list) {
				if ((EmployeeId != lmsLeaveInformation.getEmployeeId())) {
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

			query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

				if (!pagination) {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeaveInformation>(list);
				}
				else {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
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
	 * Returns the first l m s leave information in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByEmployeeId_First(int EmployeeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByEmployeeId_First(EmployeeId,
				orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("EmployeeId=");
		msg.append(EmployeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the first l m s leave information in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByEmployeeId_First(int EmployeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSLeaveInformation> list = findByEmployeeId(EmployeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s leave information in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByEmployeeId_Last(int EmployeeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByEmployeeId_Last(EmployeeId,
				orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("EmployeeId=");
		msg.append(EmployeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the last l m s leave information in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByEmployeeId_Last(int EmployeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmployeeId(EmployeeId);

		if (count == 0) {
			return null;
		}

		List<LMSLeaveInformation> list = findByEmployeeId(EmployeeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSLeaveInformation[] findByEmployeeId_PrevAndNext(int SNo,
		int EmployeeId, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = findByPrimaryKey(SNo);

		Session session = null;

		try {
			session = openSession();

			LMSLeaveInformation[] array = new LMSLeaveInformationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(session,
					lmsLeaveInformation, EmployeeId, orderByComparator, true);

			array[1] = lmsLeaveInformation;

			array[2] = getByEmployeeId_PrevAndNext(session,
					lmsLeaveInformation, EmployeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSLeaveInformation getByEmployeeId_PrevAndNext(Session session,
		LMSLeaveInformation lmsLeaveInformation, int EmployeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(EmployeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsLeaveInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSLeaveInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s leave informations where EmployeeId = &#63; from the database.
	 *
	 * @param EmployeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmployeeId(int EmployeeId) throws SystemException {
		for (LMSLeaveInformation lmsLeaveInformation : findByEmployeeId(
				EmployeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsLeaveInformation);
		}
	}

	/**
	 * Returns the number of l m s leave informations where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @return the number of matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployeeId(int EmployeeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { EmployeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSLEAVEINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "lmsLeaveInformation.EmployeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVEREQUESTID = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLeaveRequestId", new String[] { String.class.getName() },
			LMSLeaveInformationModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVEREQUESTID = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveRequestId",
			new String[] { String.class.getName() });

	/**
	 * Returns the l m s leave information where LeaveRequestId = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveInformationException} if it could not be found.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByLeaveRequestId(String LeaveRequestId)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByLeaveRequestId(LeaveRequestId);

		if (lmsLeaveInformation == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("LeaveRequestId=");
			msg.append(LeaveRequestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveInformationException(msg.toString());
		}

		return lmsLeaveInformation;
	}

	/**
	 * Returns the l m s leave information where LeaveRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByLeaveRequestId(String LeaveRequestId)
		throws SystemException {
		return fetchByLeaveRequestId(LeaveRequestId, true);
	}

	/**
	 * Returns the l m s leave information where LeaveRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByLeaveRequestId(String LeaveRequestId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { LeaveRequestId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
					finderArgs, this);
		}

		if (result instanceof LMSLeaveInformation) {
			LMSLeaveInformation lmsLeaveInformation = (LMSLeaveInformation)result;

			if (!Validator.equals(LeaveRequestId,
						lmsLeaveInformation.getLeaveRequestId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

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

				List<LMSLeaveInformation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSLeaveInformationPersistenceImpl.fetchByLeaveRequestId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSLeaveInformation lmsLeaveInformation = list.get(0);

					result = lmsLeaveInformation;

					cacheResult(lmsLeaveInformation);

					if ((lmsLeaveInformation.getLeaveRequestId() == null) ||
							!lmsLeaveInformation.getLeaveRequestId()
													.equals(LeaveRequestId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
							finderArgs, lmsLeaveInformation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LMSLeaveInformation)result;
		}
	}

	/**
	 * Removes the l m s leave information where LeaveRequestId = &#63; from the database.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the l m s leave information that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation removeByLeaveRequestId(String LeaveRequestId)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = findByLeaveRequestId(LeaveRequestId);

		return remove(lmsLeaveInformation);
	}

	/**
	 * Returns the number of l m s leave informations where LeaveRequestId = &#63;.
	 *
	 * @param LeaveRequestId the leave request ID
	 * @return the number of matching l m s leave informations
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

			query.append(_SQL_COUNT_LMSLEAVEINFORMATION_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_1 = "lmsLeaveInformation.LeaveRequestId IS NULL";
	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2 = "lmsLeaveInformation.LeaveRequestId = ?";
	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_3 = "(lmsLeaveInformation.LeaveRequestId IS NULL OR lmsLeaveInformation.LeaveRequestId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVALSTATUS =
		new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapprovalStatus",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVALSTATUS =
		new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapprovalStatus",
			new String[] { Integer.class.getName(), String.class.getName() },
			LMSLeaveInformationModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			LMSLeaveInformationModelImpl.APPROVALSTATUS_COLUMN_BITMASK |
			LMSLeaveInformationModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVALSTATUS = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapprovalStatus",
			new String[] { Integer.class.getName(), String.class.getName() });

	/**
	 * Returns all the l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param ApprovalStatus the approval status
	 * @return the matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveInformation> findByapprovalStatus(int EmployeeId,
		String ApprovalStatus) throws SystemException {
		return findByapprovalStatus(EmployeeId, ApprovalStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByapprovalStatus(int EmployeeId,
		String ApprovalStatus, int start, int end) throws SystemException {
		return findByapprovalStatus(EmployeeId, ApprovalStatus, start, end, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByapprovalStatus(int EmployeeId,
		String ApprovalStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVALSTATUS;
			finderArgs = new Object[] { EmployeeId, ApprovalStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVALSTATUS;
			finderArgs = new Object[] {
					EmployeeId, ApprovalStatus,
					
					start, end, orderByComparator
				};
		}

		List<LMSLeaveInformation> list = (List<LMSLeaveInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSLeaveInformation lmsLeaveInformation : list) {
				if ((EmployeeId != lmsLeaveInformation.getEmployeeId()) ||
						!Validator.equals(ApprovalStatus,
							lmsLeaveInformation.getApprovalStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_APPROVALSTATUS_EMPLOYEEID_2);

			boolean bindApprovalStatus = false;

			if (ApprovalStatus == null) {
				query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_1);
			}
			else if (ApprovalStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_3);
			}
			else {
				bindApprovalStatus = true;

				query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

				if (bindApprovalStatus) {
					qPos.add(ApprovalStatus);
				}

				if (!pagination) {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeaveInformation>(list);
				}
				else {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
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
	 * Returns the first l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param ApprovalStatus the approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByapprovalStatus_First(int EmployeeId,
		String ApprovalStatus, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByapprovalStatus_First(EmployeeId,
				ApprovalStatus, orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("EmployeeId=");
		msg.append(EmployeeId);

		msg.append(", ApprovalStatus=");
		msg.append(ApprovalStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the first l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param ApprovalStatus the approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByapprovalStatus_First(int EmployeeId,
		String ApprovalStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<LMSLeaveInformation> list = findByapprovalStatus(EmployeeId,
				ApprovalStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSLeaveInformation findByapprovalStatus_Last(int EmployeeId,
		String ApprovalStatus, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByapprovalStatus_Last(EmployeeId,
				ApprovalStatus, orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("EmployeeId=");
		msg.append(EmployeeId);

		msg.append(", ApprovalStatus=");
		msg.append(ApprovalStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the last l m s leave information in the ordered set where EmployeeId = &#63; and ApprovalStatus = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param ApprovalStatus the approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByapprovalStatus_Last(int EmployeeId,
		String ApprovalStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByapprovalStatus(EmployeeId, ApprovalStatus);

		if (count == 0) {
			return null;
		}

		List<LMSLeaveInformation> list = findByapprovalStatus(EmployeeId,
				ApprovalStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSLeaveInformation[] findByapprovalStatus_PrevAndNext(int SNo,
		int EmployeeId, String ApprovalStatus,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = findByPrimaryKey(SNo);

		Session session = null;

		try {
			session = openSession();

			LMSLeaveInformation[] array = new LMSLeaveInformationImpl[3];

			array[0] = getByapprovalStatus_PrevAndNext(session,
					lmsLeaveInformation, EmployeeId, ApprovalStatus,
					orderByComparator, true);

			array[1] = lmsLeaveInformation;

			array[2] = getByapprovalStatus_PrevAndNext(session,
					lmsLeaveInformation, EmployeeId, ApprovalStatus,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSLeaveInformation getByapprovalStatus_PrevAndNext(
		Session session, LMSLeaveInformation lmsLeaveInformation,
		int EmployeeId, String ApprovalStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

		query.append(_FINDER_COLUMN_APPROVALSTATUS_EMPLOYEEID_2);

		boolean bindApprovalStatus = false;

		if (ApprovalStatus == null) {
			query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_1);
		}
		else if (ApprovalStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_3);
		}
		else {
			bindApprovalStatus = true;

			query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_2);
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
			query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(EmployeeId);

		if (bindApprovalStatus) {
			qPos.add(ApprovalStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsLeaveInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSLeaveInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63; from the database.
	 *
	 * @param EmployeeId the employee ID
	 * @param ApprovalStatus the approval status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByapprovalStatus(int EmployeeId, String ApprovalStatus)
		throws SystemException {
		for (LMSLeaveInformation lmsLeaveInformation : findByapprovalStatus(
				EmployeeId, ApprovalStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lmsLeaveInformation);
		}
	}

	/**
	 * Returns the number of l m s leave informations where EmployeeId = &#63; and ApprovalStatus = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param ApprovalStatus the approval status
	 * @return the number of matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByapprovalStatus(int EmployeeId, String ApprovalStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPROVALSTATUS;

		Object[] finderArgs = new Object[] { EmployeeId, ApprovalStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LMSLEAVEINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_APPROVALSTATUS_EMPLOYEEID_2);

			boolean bindApprovalStatus = false;

			if (ApprovalStatus == null) {
				query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_1);
			}
			else if (ApprovalStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_3);
			}
			else {
				bindApprovalStatus = true;

				query.append(_FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

				if (bindApprovalStatus) {
					qPos.add(ApprovalStatus);
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

	private static final String _FINDER_COLUMN_APPROVALSTATUS_EMPLOYEEID_2 = "lmsLeaveInformation.EmployeeId = ? AND ";
	private static final String _FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_1 = "lmsLeaveInformation.ApprovalStatus IS NULL";
	private static final String _FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_2 = "lmsLeaveInformation.ApprovalStatus = ?";
	private static final String _FINDER_COLUMN_APPROVALSTATUS_APPROVALSTATUS_3 = "(lmsLeaveInformation.ApprovalStatus IS NULL OR lmsLeaveInformation.ApprovalStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DRAFTS = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDrafts",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRAFTS =
		new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDrafts",
			new String[] { String.class.getName() },
			LMSLeaveInformationModelImpl.ISDRAFT_COLUMN_BITMASK |
			LMSLeaveInformationModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DRAFTS = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDrafts",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l m s leave informations where isDraft = &#63;.
	 *
	 * @param isDraft the is draft
	 * @return the matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveInformation> findByDrafts(String isDraft)
		throws SystemException {
		return findByDrafts(isDraft, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByDrafts(String isDraft, int start,
		int end) throws SystemException {
		return findByDrafts(isDraft, start, end, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByDrafts(String isDraft, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRAFTS;
			finderArgs = new Object[] { isDraft };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DRAFTS;
			finderArgs = new Object[] { isDraft, start, end, orderByComparator };
		}

		List<LMSLeaveInformation> list = (List<LMSLeaveInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSLeaveInformation lmsLeaveInformation : list) {
				if (!Validator.equals(isDraft, lmsLeaveInformation.getIsDraft())) {
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

			query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

			boolean bindIsDraft = false;

			if (isDraft == null) {
				query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_1);
			}
			else if (isDraft.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_3);
			}
			else {
				bindIsDraft = true;

				query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIsDraft) {
					qPos.add(isDraft);
				}

				if (!pagination) {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeaveInformation>(list);
				}
				else {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
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
	 * Returns the first l m s leave information in the ordered set where isDraft = &#63;.
	 *
	 * @param isDraft the is draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByDrafts_First(String isDraft,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByDrafts_First(isDraft,
				orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isDraft=");
		msg.append(isDraft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the first l m s leave information in the ordered set where isDraft = &#63;.
	 *
	 * @param isDraft the is draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByDrafts_First(String isDraft,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSLeaveInformation> list = findByDrafts(isDraft, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s leave information in the ordered set where isDraft = &#63;.
	 *
	 * @param isDraft the is draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByDrafts_Last(String isDraft,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByDrafts_Last(isDraft,
				orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isDraft=");
		msg.append(isDraft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the last l m s leave information in the ordered set where isDraft = &#63;.
	 *
	 * @param isDraft the is draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByDrafts_Last(String isDraft,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDrafts(isDraft);

		if (count == 0) {
			return null;
		}

		List<LMSLeaveInformation> list = findByDrafts(isDraft, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSLeaveInformation[] findByDrafts_PrevAndNext(int SNo,
		String isDraft, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = findByPrimaryKey(SNo);

		Session session = null;

		try {
			session = openSession();

			LMSLeaveInformation[] array = new LMSLeaveInformationImpl[3];

			array[0] = getByDrafts_PrevAndNext(session, lmsLeaveInformation,
					isDraft, orderByComparator, true);

			array[1] = lmsLeaveInformation;

			array[2] = getByDrafts_PrevAndNext(session, lmsLeaveInformation,
					isDraft, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSLeaveInformation getByDrafts_PrevAndNext(Session session,
		LMSLeaveInformation lmsLeaveInformation, String isDraft,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

		boolean bindIsDraft = false;

		if (isDraft == null) {
			query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_1);
		}
		else if (isDraft.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_3);
		}
		else {
			bindIsDraft = true;

			query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_2);
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
			query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIsDraft) {
			qPos.add(isDraft);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsLeaveInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSLeaveInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s leave informations where isDraft = &#63; from the database.
	 *
	 * @param isDraft the is draft
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDrafts(String isDraft) throws SystemException {
		for (LMSLeaveInformation lmsLeaveInformation : findByDrafts(isDraft,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsLeaveInformation);
		}
	}

	/**
	 * Returns the number of l m s leave informations where isDraft = &#63;.
	 *
	 * @param isDraft the is draft
	 * @return the number of matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDrafts(String isDraft) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DRAFTS;

		Object[] finderArgs = new Object[] { isDraft };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSLEAVEINFORMATION_WHERE);

			boolean bindIsDraft = false;

			if (isDraft == null) {
				query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_1);
			}
			else if (isDraft.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_3);
			}
			else {
				bindIsDraft = true;

				query.append(_FINDER_COLUMN_DRAFTS_ISDRAFT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIsDraft) {
					qPos.add(isDraft);
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

	private static final String _FINDER_COLUMN_DRAFTS_ISDRAFT_1 = "lmsLeaveInformation.isDraft IS NULL";
	private static final String _FINDER_COLUMN_DRAFTS_ISDRAFT_2 = "lmsLeaveInformation.isDraft = ?";
	private static final String _FINDER_COLUMN_DRAFTS_ISDRAFT_3 = "(lmsLeaveInformation.isDraft IS NULL OR lmsLeaveInformation.isDraft = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEREMAILS =
		new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApproverEmails",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILS =
		new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED,
			LMSLeaveInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApproverEmails",
			new String[] { String.class.getName() },
			LMSLeaveInformationModelImpl.APPROVEREMAILS_COLUMN_BITMASK |
			LMSLeaveInformationModelImpl.LEAVEREQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEREMAILS = new FinderPath(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApproverEmails",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l m s leave informations where ApproverEmails = &#63;.
	 *
	 * @param ApproverEmails the approver emails
	 * @return the matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveInformation> findByApproverEmails(String ApproverEmails)
		throws SystemException {
		return findByApproverEmails(ApproverEmails, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByApproverEmails(
		String ApproverEmails, int start, int end) throws SystemException {
		return findByApproverEmails(ApproverEmails, start, end, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findByApproverEmails(
		String ApproverEmails, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILS;
			finderArgs = new Object[] { ApproverEmails };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEREMAILS;
			finderArgs = new Object[] {
					ApproverEmails,
					
					start, end, orderByComparator
				};
		}

		List<LMSLeaveInformation> list = (List<LMSLeaveInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSLeaveInformation lmsLeaveInformation : list) {
				if (!Validator.equals(ApproverEmails,
							lmsLeaveInformation.getApproverEmails())) {
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

			query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

			boolean bindApproverEmails = false;

			if (ApproverEmails == null) {
				query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_1);
			}
			else if (ApproverEmails.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_3);
			}
			else {
				bindApproverEmails = true;

				query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApproverEmails) {
					qPos.add(ApproverEmails);
				}

				if (!pagination) {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeaveInformation>(list);
				}
				else {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
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
	 * Returns the first l m s leave information in the ordered set where ApproverEmails = &#63;.
	 *
	 * @param ApproverEmails the approver emails
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByApproverEmails_First(
		String ApproverEmails, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByApproverEmails_First(ApproverEmails,
				orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmails=");
		msg.append(ApproverEmails);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the first l m s leave information in the ordered set where ApproverEmails = &#63;.
	 *
	 * @param ApproverEmails the approver emails
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByApproverEmails_First(
		String ApproverEmails, OrderByComparator orderByComparator)
		throws SystemException {
		List<LMSLeaveInformation> list = findByApproverEmails(ApproverEmails,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s leave information in the ordered set where ApproverEmails = &#63;.
	 *
	 * @param ApproverEmails the approver emails
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByApproverEmails_Last(
		String ApproverEmails, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByApproverEmails_Last(ApproverEmails,
				orderByComparator);

		if (lmsLeaveInformation != null) {
			return lmsLeaveInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmails=");
		msg.append(ApproverEmails);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveInformationException(msg.toString());
	}

	/**
	 * Returns the last l m s leave information in the ordered set where ApproverEmails = &#63;.
	 *
	 * @param ApproverEmails the approver emails
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave information, or <code>null</code> if a matching l m s leave information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByApproverEmails_Last(
		String ApproverEmails, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByApproverEmails(ApproverEmails);

		if (count == 0) {
			return null;
		}

		List<LMSLeaveInformation> list = findByApproverEmails(ApproverEmails,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSLeaveInformation[] findByApproverEmails_PrevAndNext(int SNo,
		String ApproverEmails, OrderByComparator orderByComparator)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = findByPrimaryKey(SNo);

		Session session = null;

		try {
			session = openSession();

			LMSLeaveInformation[] array = new LMSLeaveInformationImpl[3];

			array[0] = getByApproverEmails_PrevAndNext(session,
					lmsLeaveInformation, ApproverEmails, orderByComparator, true);

			array[1] = lmsLeaveInformation;

			array[2] = getByApproverEmails_PrevAndNext(session,
					lmsLeaveInformation, ApproverEmails, orderByComparator,
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

	protected LMSLeaveInformation getByApproverEmails_PrevAndNext(
		Session session, LMSLeaveInformation lmsLeaveInformation,
		String ApproverEmails, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSLEAVEINFORMATION_WHERE);

		boolean bindApproverEmails = false;

		if (ApproverEmails == null) {
			query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_1);
		}
		else if (ApproverEmails.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_3);
		}
		else {
			bindApproverEmails = true;

			query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_2);
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
			query.append(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApproverEmails) {
			qPos.add(ApproverEmails);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsLeaveInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSLeaveInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s leave informations where ApproverEmails = &#63; from the database.
	 *
	 * @param ApproverEmails the approver emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApproverEmails(String ApproverEmails)
		throws SystemException {
		for (LMSLeaveInformation lmsLeaveInformation : findByApproverEmails(
				ApproverEmails, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsLeaveInformation);
		}
	}

	/**
	 * Returns the number of l m s leave informations where ApproverEmails = &#63;.
	 *
	 * @param ApproverEmails the approver emails
	 * @return the number of matching l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApproverEmails(String ApproverEmails)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPROVEREMAILS;

		Object[] finderArgs = new Object[] { ApproverEmails };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSLEAVEINFORMATION_WHERE);

			boolean bindApproverEmails = false;

			if (ApproverEmails == null) {
				query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_1);
			}
			else if (ApproverEmails.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_3);
			}
			else {
				bindApproverEmails = true;

				query.append(_FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApproverEmails) {
					qPos.add(ApproverEmails);
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

	private static final String _FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_1 = "lmsLeaveInformation.ApproverEmails IS NULL";
	private static final String _FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_2 = "lmsLeaveInformation.ApproverEmails = ?";
	private static final String _FINDER_COLUMN_APPROVEREMAILS_APPROVEREMAILS_3 = "(lmsLeaveInformation.ApproverEmails IS NULL OR lmsLeaveInformation.ApproverEmails = '')";

	public LMSLeaveInformationPersistenceImpl() {
		setModelClass(LMSLeaveInformation.class);
	}

	/**
	 * Caches the l m s leave information in the entity cache if it is enabled.
	 *
	 * @param lmsLeaveInformation the l m s leave information
	 */
	@Override
	public void cacheResult(LMSLeaveInformation lmsLeaveInformation) {
		EntityCacheUtil.putResult(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationImpl.class, lmsLeaveInformation.getPrimaryKey(),
			lmsLeaveInformation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
			new Object[] { lmsLeaveInformation.getLeaveRequestId() },
			lmsLeaveInformation);

		lmsLeaveInformation.resetOriginalValues();
	}

	/**
	 * Caches the l m s leave informations in the entity cache if it is enabled.
	 *
	 * @param lmsLeaveInformations the l m s leave informations
	 */
	@Override
	public void cacheResult(List<LMSLeaveInformation> lmsLeaveInformations) {
		for (LMSLeaveInformation lmsLeaveInformation : lmsLeaveInformations) {
			if (EntityCacheUtil.getResult(
						LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
						LMSLeaveInformationImpl.class,
						lmsLeaveInformation.getPrimaryKey()) == null) {
				cacheResult(lmsLeaveInformation);
			}
			else {
				lmsLeaveInformation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s leave informations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSLeaveInformationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSLeaveInformationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s leave information.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSLeaveInformation lmsLeaveInformation) {
		EntityCacheUtil.removeResult(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationImpl.class, lmsLeaveInformation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsLeaveInformation);
	}

	@Override
	public void clearCache(List<LMSLeaveInformation> lmsLeaveInformations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSLeaveInformation lmsLeaveInformation : lmsLeaveInformations) {
			EntityCacheUtil.removeResult(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
				LMSLeaveInformationImpl.class,
				lmsLeaveInformation.getPrimaryKey());

			clearUniqueFindersCache(lmsLeaveInformation);
		}
	}

	protected void cacheUniqueFindersCache(
		LMSLeaveInformation lmsLeaveInformation) {
		if (lmsLeaveInformation.isNew()) {
			Object[] args = new Object[] { lmsLeaveInformation.getLeaveRequestId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
				args, lmsLeaveInformation);
		}
		else {
			LMSLeaveInformationModelImpl lmsLeaveInformationModelImpl = (LMSLeaveInformationModelImpl)lmsLeaveInformation;

			if ((lmsLeaveInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LEAVEREQUESTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsLeaveInformation.getLeaveRequestId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
					args, lmsLeaveInformation);
			}
		}
	}

	protected void clearUniqueFindersCache(
		LMSLeaveInformation lmsLeaveInformation) {
		LMSLeaveInformationModelImpl lmsLeaveInformationModelImpl = (LMSLeaveInformationModelImpl)lmsLeaveInformation;

		Object[] args = new Object[] { lmsLeaveInformation.getLeaveRequestId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID, args);

		if ((lmsLeaveInformationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVEREQUESTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsLeaveInformationModelImpl.getOriginalLeaveRequestId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVEREQUESTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVEREQUESTID,
				args);
		}
	}

	/**
	 * Creates a new l m s leave information with the primary key. Does not add the l m s leave information to the database.
	 *
	 * @param SNo the primary key for the new l m s leave information
	 * @return the new l m s leave information
	 */
	@Override
	public LMSLeaveInformation create(int SNo) {
		LMSLeaveInformation lmsLeaveInformation = new LMSLeaveInformationImpl();

		lmsLeaveInformation.setNew(true);
		lmsLeaveInformation.setPrimaryKey(SNo);

		return lmsLeaveInformation;
	}

	/**
	 * Removes the l m s leave information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SNo the primary key of the l m s leave information
	 * @return the l m s leave information that was removed
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation remove(int SNo)
		throws NoSuchLeaveInformationException, SystemException {
		return remove((Serializable)SNo);
	}

	/**
	 * Removes the l m s leave information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s leave information
	 * @return the l m s leave information that was removed
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation remove(Serializable primaryKey)
		throws NoSuchLeaveInformationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSLeaveInformation lmsLeaveInformation = (LMSLeaveInformation)session.get(LMSLeaveInformationImpl.class,
					primaryKey);

			if (lmsLeaveInformation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsLeaveInformation);
		}
		catch (NoSuchLeaveInformationException nsee) {
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
	protected LMSLeaveInformation removeImpl(
		LMSLeaveInformation lmsLeaveInformation) throws SystemException {
		lmsLeaveInformation = toUnwrappedModel(lmsLeaveInformation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsLeaveInformation)) {
				lmsLeaveInformation = (LMSLeaveInformation)session.get(LMSLeaveInformationImpl.class,
						lmsLeaveInformation.getPrimaryKeyObj());
			}

			if (lmsLeaveInformation != null) {
				session.delete(lmsLeaveInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsLeaveInformation != null) {
			clearCache(lmsLeaveInformation);
		}

		return lmsLeaveInformation;
	}

	@Override
	public LMSLeaveInformation updateImpl(
		com.trianz.lms.model.LMSLeaveInformation lmsLeaveInformation)
		throws SystemException {
		lmsLeaveInformation = toUnwrappedModel(lmsLeaveInformation);

		boolean isNew = lmsLeaveInformation.isNew();

		LMSLeaveInformationModelImpl lmsLeaveInformationModelImpl = (LMSLeaveInformationModelImpl)lmsLeaveInformation;

		Session session = null;

		try {
			session = openSession();

			if (lmsLeaveInformation.isNew()) {
				session.save(lmsLeaveInformation);

				lmsLeaveInformation.setNew(false);
			}
			else {
				session.merge(lmsLeaveInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSLeaveInformationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsLeaveInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsLeaveInformationModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { lmsLeaveInformationModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((lmsLeaveInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVALSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsLeaveInformationModelImpl.getOriginalEmployeeId(),
						lmsLeaveInformationModelImpl.getOriginalApprovalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVALSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVALSTATUS,
					args);

				args = new Object[] {
						lmsLeaveInformationModelImpl.getEmployeeId(),
						lmsLeaveInformationModelImpl.getApprovalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVALSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVALSTATUS,
					args);
			}

			if ((lmsLeaveInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRAFTS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsLeaveInformationModelImpl.getOriginalIsDraft()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DRAFTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRAFTS,
					args);

				args = new Object[] { lmsLeaveInformationModelImpl.getIsDraft() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DRAFTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRAFTS,
					args);
			}

			if ((lmsLeaveInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsLeaveInformationModelImpl.getOriginalApproverEmails()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVEREMAILS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILS,
					args);

				args = new Object[] {
						lmsLeaveInformationModelImpl.getApproverEmails()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVEREMAILS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILS,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveInformationImpl.class, lmsLeaveInformation.getPrimaryKey(),
			lmsLeaveInformation);

		clearUniqueFindersCache(lmsLeaveInformation);
		cacheUniqueFindersCache(lmsLeaveInformation);

		return lmsLeaveInformation;
	}

	protected LMSLeaveInformation toUnwrappedModel(
		LMSLeaveInformation lmsLeaveInformation) {
		if (lmsLeaveInformation instanceof LMSLeaveInformationImpl) {
			return lmsLeaveInformation;
		}

		LMSLeaveInformationImpl lmsLeaveInformationImpl = new LMSLeaveInformationImpl();

		lmsLeaveInformationImpl.setNew(lmsLeaveInformation.isNew());
		lmsLeaveInformationImpl.setPrimaryKey(lmsLeaveInformation.getPrimaryKey());

		lmsLeaveInformationImpl.setSNo(lmsLeaveInformation.getSNo());
		lmsLeaveInformationImpl.setLeaveRequestId(lmsLeaveInformation.getLeaveRequestId());
		lmsLeaveInformationImpl.setEmployeeId(lmsLeaveInformation.getEmployeeId());
		lmsLeaveInformationImpl.setAbsenceType(lmsLeaveInformation.getAbsenceType());
		lmsLeaveInformationImpl.setLeaveTypeCode(lmsLeaveInformation.getLeaveTypeCode());
		lmsLeaveInformationImpl.setLeaveCategoryCode(lmsLeaveInformation.getLeaveCategoryCode());
		lmsLeaveInformationImpl.setSupervisorID(lmsLeaveInformation.getSupervisorID());
		lmsLeaveInformationImpl.setStartDate(lmsLeaveInformation.getStartDate());
		lmsLeaveInformationImpl.setEndDate(lmsLeaveInformation.getEndDate());
		lmsLeaveInformationImpl.setDuration(lmsLeaveInformation.getDuration());
		lmsLeaveInformationImpl.setApprovalStatus(lmsLeaveInformation.getApprovalStatus());
		lmsLeaveInformationImpl.setComments(lmsLeaveInformation.getComments());
		lmsLeaveInformationImpl.setIsDraft(lmsLeaveInformation.getIsDraft());
		lmsLeaveInformationImpl.setApprovers(lmsLeaveInformation.getApprovers());
		lmsLeaveInformationImpl.setCreatedDate(lmsLeaveInformation.getCreatedDate());
		lmsLeaveInformationImpl.setApproverEmails(lmsLeaveInformation.getApproverEmails());

		return lmsLeaveInformationImpl;
	}

	/**
	 * Returns the l m s leave information with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s leave information
	 * @return the l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveInformationException, SystemException {
		LMSLeaveInformation lmsLeaveInformation = fetchByPrimaryKey(primaryKey);

		if (lmsLeaveInformation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsLeaveInformation;
	}

	/**
	 * Returns the l m s leave information with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveInformationException} if it could not be found.
	 *
	 * @param SNo the primary key of the l m s leave information
	 * @return the l m s leave information
	 * @throws com.trianz.lms.NoSuchLeaveInformationException if a l m s leave information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation findByPrimaryKey(int SNo)
		throws NoSuchLeaveInformationException, SystemException {
		return findByPrimaryKey((Serializable)SNo);
	}

	/**
	 * Returns the l m s leave information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s leave information
	 * @return the l m s leave information, or <code>null</code> if a l m s leave information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSLeaveInformation lmsLeaveInformation = (LMSLeaveInformation)EntityCacheUtil.getResult(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
				LMSLeaveInformationImpl.class, primaryKey);

		if (lmsLeaveInformation == _nullLMSLeaveInformation) {
			return null;
		}

		if (lmsLeaveInformation == null) {
			Session session = null;

			try {
				session = openSession();

				lmsLeaveInformation = (LMSLeaveInformation)session.get(LMSLeaveInformationImpl.class,
						primaryKey);

				if (lmsLeaveInformation != null) {
					cacheResult(lmsLeaveInformation);
				}
				else {
					EntityCacheUtil.putResult(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
						LMSLeaveInformationImpl.class, primaryKey,
						_nullLMSLeaveInformation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSLeaveInformationModelImpl.ENTITY_CACHE_ENABLED,
					LMSLeaveInformationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsLeaveInformation;
	}

	/**
	 * Returns the l m s leave information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SNo the primary key of the l m s leave information
	 * @return the l m s leave information, or <code>null</code> if a l m s leave information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveInformation fetchByPrimaryKey(int SNo)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)SNo);
	}

	/**
	 * Returns all the l m s leave informations.
	 *
	 * @return the l m s leave informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveInformation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<LMSLeaveInformation> findAll(int start, int end,
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

		List<LMSLeaveInformation> list = (List<LMSLeaveInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSLEAVEINFORMATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSLEAVEINFORMATION;

				if (pagination) {
					sql = sql.concat(LMSLeaveInformationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeaveInformation>(list);
				}
				else {
					list = (List<LMSLeaveInformation>)QueryUtil.list(q,
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
	 * Removes all the l m s leave informations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSLeaveInformation lmsLeaveInformation : findAll()) {
			remove(lmsLeaveInformation);
		}
	}

	/**
	 * Returns the number of l m s leave informations.
	 *
	 * @return the number of l m s leave informations
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

				Query q = session.createQuery(_SQL_COUNT_LMSLEAVEINFORMATION);

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
	 * Initializes the l m s leave information persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSLeaveInformation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSLeaveInformation>> listenersList = new ArrayList<ModelListener<LMSLeaveInformation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSLeaveInformation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSLeaveInformationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSLEAVEINFORMATION = "SELECT lmsLeaveInformation FROM LMSLeaveInformation lmsLeaveInformation";
	private static final String _SQL_SELECT_LMSLEAVEINFORMATION_WHERE = "SELECT lmsLeaveInformation FROM LMSLeaveInformation lmsLeaveInformation WHERE ";
	private static final String _SQL_COUNT_LMSLEAVEINFORMATION = "SELECT COUNT(lmsLeaveInformation) FROM LMSLeaveInformation lmsLeaveInformation";
	private static final String _SQL_COUNT_LMSLEAVEINFORMATION_WHERE = "SELECT COUNT(lmsLeaveInformation) FROM LMSLeaveInformation lmsLeaveInformation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsLeaveInformation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSLeaveInformation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSLeaveInformation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSLeaveInformationPersistenceImpl.class);
	private static LMSLeaveInformation _nullLMSLeaveInformation = new LMSLeaveInformationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSLeaveInformation> toCacheModel() {
				return _nullLMSLeaveInformationCacheModel;
			}
		};

	private static CacheModel<LMSLeaveInformation> _nullLMSLeaveInformationCacheModel =
		new CacheModel<LMSLeaveInformation>() {
			@Override
			public LMSLeaveInformation toEntityModel() {
				return _nullLMSLeaveInformation;
			}
		};
}