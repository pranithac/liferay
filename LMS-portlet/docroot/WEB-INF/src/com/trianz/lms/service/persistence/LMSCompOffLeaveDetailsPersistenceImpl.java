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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.CharPool;
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

import com.trianz.lms.NoSuchCompOffLeaveDetailsException;
import com.trianz.lms.model.LMSCompOffLeaveDetails;
import com.trianz.lms.model.impl.LMSCompOffLeaveDetailsImpl;
import com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the l m s comp off leave details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSCompOffLeaveDetailsPersistence
 * @see LMSCompOffLeaveDetailsUtil
 * @generated
 */
public class LMSCompOffLeaveDetailsPersistenceImpl extends BasePersistenceImpl<LMSCompOffLeaveDetails>
	implements LMSCompOffLeaveDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSCompOffLeaveDetailsUtil} to access the l m s comp off leave details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSCompOffLeaveDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmployeeID",
			new String[] { Integer.class.getName(), Date.class.getName() },
			LMSCompOffLeaveDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			LMSCompOffLeaveDetailsModelImpl.COMPOFFDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeID",
			new String[] { Integer.class.getName(), Date.class.getName() });

	/**
	 * Returns the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; or throws a {@link com.trianz.lms.NoSuchCompOffLeaveDetailsException} if it could not be found.
	 *
	 * @param EmployeeID the employee i d
	 * @param CompoffDate the compoff date
	 * @return the matching l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findByEmployeeID(int EmployeeID,
		Date CompoffDate)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = fetchByEmployeeID(EmployeeID,
				CompoffDate);

		if (lmsCompOffLeaveDetails == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EmployeeID=");
			msg.append(EmployeeID);

			msg.append(", CompoffDate=");
			msg.append(CompoffDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCompOffLeaveDetailsException(msg.toString());
		}

		return lmsCompOffLeaveDetails;
	}

	/**
	 * Returns the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EmployeeID the employee i d
	 * @param CompoffDate the compoff date
	 * @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByEmployeeID(int EmployeeID,
		Date CompoffDate) throws SystemException {
		return fetchByEmployeeID(EmployeeID, CompoffDate, true);
	}

	/**
	 * Returns the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EmployeeID the employee i d
	 * @param CompoffDate the compoff date
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByEmployeeID(int EmployeeID,
		Date CompoffDate, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { EmployeeID, CompoffDate };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof LMSCompOffLeaveDetails) {
			LMSCompOffLeaveDetails lmsCompOffLeaveDetails = (LMSCompOffLeaveDetails)result;

			if ((EmployeeID != lmsCompOffLeaveDetails.getEmployeeID()) ||
					!Validator.equals(CompoffDate,
						lmsCompOffLeaveDetails.getCompoffDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			boolean bindCompoffDate = false;

			if (CompoffDate == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEID_COMPOFFDATE_1);
			}
			else {
				bindCompoffDate = true;

				query.append(_FINDER_COLUMN_EMPLOYEEID_COMPOFFDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeID);

				if (bindCompoffDate) {
					qPos.add(CalendarUtil.getTimestamp(CompoffDate));
				}

				List<LMSCompOffLeaveDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSCompOffLeaveDetailsPersistenceImpl.fetchByEmployeeID(int, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSCompOffLeaveDetails lmsCompOffLeaveDetails = list.get(0);

					result = lmsCompOffLeaveDetails;

					cacheResult(lmsCompOffLeaveDetails);

					if ((lmsCompOffLeaveDetails.getEmployeeID() != EmployeeID) ||
							(lmsCompOffLeaveDetails.getCompoffDate() == null) ||
							!lmsCompOffLeaveDetails.getCompoffDate()
													   .equals(CompoffDate)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
							finderArgs, lmsCompOffLeaveDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
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
			return (LMSCompOffLeaveDetails)result;
		}
	}

	/**
	 * Removes the l m s comp off leave details where EmployeeID = &#63; and CompoffDate = &#63; from the database.
	 *
	 * @param EmployeeID the employee i d
	 * @param CompoffDate the compoff date
	 * @return the l m s comp off leave details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails removeByEmployeeID(int EmployeeID,
		Date CompoffDate)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = findByEmployeeID(EmployeeID,
				CompoffDate);

		return remove(lmsCompOffLeaveDetails);
	}

	/**
	 * Returns the number of l m s comp off leave detailses where EmployeeID = &#63; and CompoffDate = &#63;.
	 *
	 * @param EmployeeID the employee i d
	 * @param CompoffDate the compoff date
	 * @return the number of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployeeID(int EmployeeID, Date CompoffDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { EmployeeID, CompoffDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			boolean bindCompoffDate = false;

			if (CompoffDate == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEID_COMPOFFDATE_1);
			}
			else {
				bindCompoffDate = true;

				query.append(_FINDER_COLUMN_EMPLOYEEID_COMPOFFDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeID);

				if (bindCompoffDate) {
					qPos.add(CalendarUtil.getTimestamp(CompoffDate));
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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "lmsCompOffLeaveDetails.id.EmployeeID = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEID_COMPOFFDATE_1 = "lmsCompOffLeaveDetails.id.CompoffDate IS NULL";
	private static final String _FINDER_COLUMN_EMPLOYEEID_COMPOFFDATE_2 = "lmsCompOffLeaveDetails.id.CompoffDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEDBY =
		new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApprovedBy",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_APPROVEDBY =
		new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByApprovedBy",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	 *
	 * @param ApprovedBy the approved by
	 * @return the matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findByApprovedBy(String ApprovedBy)
		throws SystemException {
		return findByApprovedBy(ApprovedBy, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ApprovedBy the approved by
	 * @param start the lower bound of the range of l m s comp off leave detailses
	 * @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	 * @return the range of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findByApprovedBy(String ApprovedBy,
		int start, int end) throws SystemException {
		return findByApprovedBy(ApprovedBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ApprovedBy the approved by
	 * @param start the lower bound of the range of l m s comp off leave detailses
	 * @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findByApprovedBy(String ApprovedBy,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEDBY;
		finderArgs = new Object[] { ApprovedBy, start, end, orderByComparator };

		List<LMSCompOffLeaveDetails> list = (List<LMSCompOffLeaveDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSCompOffLeaveDetails lmsCompOffLeaveDetails : list) {
				if (!StringUtil.wildcardMatches(
							lmsCompOffLeaveDetails.getApprovedBy(), ApprovedBy,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			boolean bindApprovedBy = false;

			if (ApprovedBy == null) {
				query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_1);
			}
			else if (ApprovedBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_3);
			}
			else {
				bindApprovedBy = true;

				query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSCompOffLeaveDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApprovedBy) {
					qPos.add(ApprovedBy);
				}

				if (!pagination) {
					list = (List<LMSCompOffLeaveDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSCompOffLeaveDetails>(list);
				}
				else {
					list = (List<LMSCompOffLeaveDetails>)QueryUtil.list(q,
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
	 * Returns the first l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	 *
	 * @param ApprovedBy the approved by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findByApprovedBy_First(String ApprovedBy,
		OrderByComparator orderByComparator)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = fetchByApprovedBy_First(ApprovedBy,
				orderByComparator);

		if (lmsCompOffLeaveDetails != null) {
			return lmsCompOffLeaveDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApprovedBy=");
		msg.append(ApprovedBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompOffLeaveDetailsException(msg.toString());
	}

	/**
	 * Returns the first l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	 *
	 * @param ApprovedBy the approved by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByApprovedBy_First(String ApprovedBy,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSCompOffLeaveDetails> list = findByApprovedBy(ApprovedBy, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	 *
	 * @param ApprovedBy the approved by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findByApprovedBy_Last(String ApprovedBy,
		OrderByComparator orderByComparator)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = fetchByApprovedBy_Last(ApprovedBy,
				orderByComparator);

		if (lmsCompOffLeaveDetails != null) {
			return lmsCompOffLeaveDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApprovedBy=");
		msg.append(ApprovedBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompOffLeaveDetailsException(msg.toString());
	}

	/**
	 * Returns the last l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	 *
	 * @param ApprovedBy the approved by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByApprovedBy_Last(String ApprovedBy,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByApprovedBy(ApprovedBy);

		if (count == 0) {
			return null;
		}

		List<LMSCompOffLeaveDetails> list = findByApprovedBy(ApprovedBy,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s comp off leave detailses before and after the current l m s comp off leave details in the ordered set where ApprovedBy LIKE &#63;.
	 *
	 * @param lmsCompOffLeaveDetailsPK the primary key of the current l m s comp off leave details
	 * @param ApprovedBy the approved by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails[] findByApprovedBy_PrevAndNext(
		LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK, String ApprovedBy,
		OrderByComparator orderByComparator)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = findByPrimaryKey(lmsCompOffLeaveDetailsPK);

		Session session = null;

		try {
			session = openSession();

			LMSCompOffLeaveDetails[] array = new LMSCompOffLeaveDetailsImpl[3];

			array[0] = getByApprovedBy_PrevAndNext(session,
					lmsCompOffLeaveDetails, ApprovedBy, orderByComparator, true);

			array[1] = lmsCompOffLeaveDetails;

			array[2] = getByApprovedBy_PrevAndNext(session,
					lmsCompOffLeaveDetails, ApprovedBy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSCompOffLeaveDetails getByApprovedBy_PrevAndNext(
		Session session, LMSCompOffLeaveDetails lmsCompOffLeaveDetails,
		String ApprovedBy, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSCOMPOFFLEAVEDETAILS_WHERE);

		boolean bindApprovedBy = false;

		if (ApprovedBy == null) {
			query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_1);
		}
		else if (ApprovedBy.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_3);
		}
		else {
			bindApprovedBy = true;

			query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_2);
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
			query.append(LMSCompOffLeaveDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApprovedBy) {
			qPos.add(ApprovedBy);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsCompOffLeaveDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSCompOffLeaveDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s comp off leave detailses where ApprovedBy LIKE &#63; from the database.
	 *
	 * @param ApprovedBy the approved by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApprovedBy(String ApprovedBy) throws SystemException {
		for (LMSCompOffLeaveDetails lmsCompOffLeaveDetails : findByApprovedBy(
				ApprovedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsCompOffLeaveDetails);
		}
	}

	/**
	 * Returns the number of l m s comp off leave detailses where ApprovedBy LIKE &#63;.
	 *
	 * @param ApprovedBy the approved by
	 * @return the number of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApprovedBy(String ApprovedBy) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_APPROVEDBY;

		Object[] finderArgs = new Object[] { ApprovedBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			boolean bindApprovedBy = false;

			if (ApprovedBy == null) {
				query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_1);
			}
			else if (ApprovedBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_3);
			}
			else {
				bindApprovedBy = true;

				query.append(_FINDER_COLUMN_APPROVEDBY_APPROVEDBY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApprovedBy) {
					qPos.add(ApprovedBy);
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

	private static final String _FINDER_COLUMN_APPROVEDBY_APPROVEDBY_1 = "lmsCompOffLeaveDetails.ApprovedBy LIKE NULL";
	private static final String _FINDER_COLUMN_APPROVEDBY_APPROVEDBY_2 = "lmsCompOffLeaveDetails.ApprovedBy LIKE ?";
	private static final String _FINDER_COLUMN_APPROVEDBY_APPROVEDBY_3 = "(lmsCompOffLeaveDetails.ApprovedBy IS NULL OR lmsCompOffLeaveDetails.ApprovedBy LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEREMPID =
		new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApproverEmpId",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMPID =
		new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApproverEmpId",
			new String[] { Integer.class.getName() },
			LMSCompOffLeaveDetailsModelImpl.APPROVEREMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEREMPID = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApproverEmpId",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @return the matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findByApproverEmpId(
		int ApproverEmployeeID) throws SystemException {
		return findByApproverEmpId(ApproverEmployeeID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @param start the lower bound of the range of l m s comp off leave detailses
	 * @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	 * @return the range of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findByApproverEmpId(
		int ApproverEmployeeID, int start, int end) throws SystemException {
		return findByApproverEmpId(ApproverEmployeeID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @param start the lower bound of the range of l m s comp off leave detailses
	 * @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findByApproverEmpId(
		int ApproverEmployeeID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMPID;
			finderArgs = new Object[] { ApproverEmployeeID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEREMPID;
			finderArgs = new Object[] {
					ApproverEmployeeID,
					
					start, end, orderByComparator
				};
		}

		List<LMSCompOffLeaveDetails> list = (List<LMSCompOffLeaveDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSCompOffLeaveDetails lmsCompOffLeaveDetails : list) {
				if ((ApproverEmployeeID != lmsCompOffLeaveDetails.getApproverEmployeeID())) {
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

			query.append(_SQL_SELECT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_APPROVEREMPID_APPROVEREMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSCompOffLeaveDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ApproverEmployeeID);

				if (!pagination) {
					list = (List<LMSCompOffLeaveDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSCompOffLeaveDetails>(list);
				}
				else {
					list = (List<LMSCompOffLeaveDetails>)QueryUtil.list(q,
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
	 * Returns the first l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findByApproverEmpId_First(
		int ApproverEmployeeID, OrderByComparator orderByComparator)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = fetchByApproverEmpId_First(ApproverEmployeeID,
				orderByComparator);

		if (lmsCompOffLeaveDetails != null) {
			return lmsCompOffLeaveDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmployeeID=");
		msg.append(ApproverEmployeeID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompOffLeaveDetailsException(msg.toString());
	}

	/**
	 * Returns the first l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByApproverEmpId_First(
		int ApproverEmployeeID, OrderByComparator orderByComparator)
		throws SystemException {
		List<LMSCompOffLeaveDetails> list = findByApproverEmpId(ApproverEmployeeID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findByApproverEmpId_Last(
		int ApproverEmployeeID, OrderByComparator orderByComparator)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = fetchByApproverEmpId_Last(ApproverEmployeeID,
				orderByComparator);

		if (lmsCompOffLeaveDetails != null) {
			return lmsCompOffLeaveDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmployeeID=");
		msg.append(ApproverEmployeeID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompOffLeaveDetailsException(msg.toString());
	}

	/**
	 * Returns the last l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByApproverEmpId_Last(
		int ApproverEmployeeID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByApproverEmpId(ApproverEmployeeID);

		if (count == 0) {
			return null;
		}

		List<LMSCompOffLeaveDetails> list = findByApproverEmpId(ApproverEmployeeID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s comp off leave detailses before and after the current l m s comp off leave details in the ordered set where ApproverEmployeeID = &#63;.
	 *
	 * @param lmsCompOffLeaveDetailsPK the primary key of the current l m s comp off leave details
	 * @param ApproverEmployeeID the approver employee i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails[] findByApproverEmpId_PrevAndNext(
		LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK,
		int ApproverEmployeeID, OrderByComparator orderByComparator)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = findByPrimaryKey(lmsCompOffLeaveDetailsPK);

		Session session = null;

		try {
			session = openSession();

			LMSCompOffLeaveDetails[] array = new LMSCompOffLeaveDetailsImpl[3];

			array[0] = getByApproverEmpId_PrevAndNext(session,
					lmsCompOffLeaveDetails, ApproverEmployeeID,
					orderByComparator, true);

			array[1] = lmsCompOffLeaveDetails;

			array[2] = getByApproverEmpId_PrevAndNext(session,
					lmsCompOffLeaveDetails, ApproverEmployeeID,
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

	protected LMSCompOffLeaveDetails getByApproverEmpId_PrevAndNext(
		Session session, LMSCompOffLeaveDetails lmsCompOffLeaveDetails,
		int ApproverEmployeeID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSCOMPOFFLEAVEDETAILS_WHERE);

		query.append(_FINDER_COLUMN_APPROVEREMPID_APPROVEREMPLOYEEID_2);

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
			query.append(LMSCompOffLeaveDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ApproverEmployeeID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsCompOffLeaveDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSCompOffLeaveDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s comp off leave detailses where ApproverEmployeeID = &#63; from the database.
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApproverEmpId(int ApproverEmployeeID)
		throws SystemException {
		for (LMSCompOffLeaveDetails lmsCompOffLeaveDetails : findByApproverEmpId(
				ApproverEmployeeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsCompOffLeaveDetails);
		}
	}

	/**
	 * Returns the number of l m s comp off leave detailses where ApproverEmployeeID = &#63;.
	 *
	 * @param ApproverEmployeeID the approver employee i d
	 * @return the number of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApproverEmpId(int ApproverEmployeeID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPROVEREMPID;

		Object[] finderArgs = new Object[] { ApproverEmployeeID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_APPROVEREMPID_APPROVEREMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ApproverEmployeeID);

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

	private static final String _FINDER_COLUMN_APPROVEREMPID_APPROVEREMPLOYEEID_2 =
		"lmsCompOffLeaveDetails.ApproverEmployeeID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COMPOFFID = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBycompOffId", new String[] { Integer.class.getName() },
			LMSCompOffLeaveDetailsModelImpl.COMPOFFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPOFFID = new FinderPath(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycompOffId",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the l m s comp off leave details where CompOffId = &#63; or throws a {@link com.trianz.lms.NoSuchCompOffLeaveDetailsException} if it could not be found.
	 *
	 * @param CompOffId the comp off ID
	 * @return the matching l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findBycompOffId(int CompOffId)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = fetchBycompOffId(CompOffId);

		if (lmsCompOffLeaveDetails == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("CompOffId=");
			msg.append(CompOffId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCompOffLeaveDetailsException(msg.toString());
		}

		return lmsCompOffLeaveDetails;
	}

	/**
	 * Returns the l m s comp off leave details where CompOffId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param CompOffId the comp off ID
	 * @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchBycompOffId(int CompOffId)
		throws SystemException {
		return fetchBycompOffId(CompOffId, true);
	}

	/**
	 * Returns the l m s comp off leave details where CompOffId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param CompOffId the comp off ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s comp off leave details, or <code>null</code> if a matching l m s comp off leave details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchBycompOffId(int CompOffId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { CompOffId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COMPOFFID,
					finderArgs, this);
		}

		if (result instanceof LMSCompOffLeaveDetails) {
			LMSCompOffLeaveDetails lmsCompOffLeaveDetails = (LMSCompOffLeaveDetails)result;

			if ((CompOffId != lmsCompOffLeaveDetails.getCompOffId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_COMPOFFID_COMPOFFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CompOffId);

				List<LMSCompOffLeaveDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPOFFID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSCompOffLeaveDetailsPersistenceImpl.fetchBycompOffId(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSCompOffLeaveDetails lmsCompOffLeaveDetails = list.get(0);

					result = lmsCompOffLeaveDetails;

					cacheResult(lmsCompOffLeaveDetails);

					if ((lmsCompOffLeaveDetails.getCompOffId() != CompOffId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPOFFID,
							finderArgs, lmsCompOffLeaveDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPOFFID,
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
			return (LMSCompOffLeaveDetails)result;
		}
	}

	/**
	 * Removes the l m s comp off leave details where CompOffId = &#63; from the database.
	 *
	 * @param CompOffId the comp off ID
	 * @return the l m s comp off leave details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails removeBycompOffId(int CompOffId)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = findBycompOffId(CompOffId);

		return remove(lmsCompOffLeaveDetails);
	}

	/**
	 * Returns the number of l m s comp off leave detailses where CompOffId = &#63;.
	 *
	 * @param CompOffId the comp off ID
	 * @return the number of matching l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycompOffId(int CompOffId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPOFFID;

		Object[] finderArgs = new Object[] { CompOffId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSCOMPOFFLEAVEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_COMPOFFID_COMPOFFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CompOffId);

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

	private static final String _FINDER_COLUMN_COMPOFFID_COMPOFFID_2 = "lmsCompOffLeaveDetails.CompOffId = ?";

	public LMSCompOffLeaveDetailsPersistenceImpl() {
		setModelClass(LMSCompOffLeaveDetails.class);
	}

	/**
	 * Caches the l m s comp off leave details in the entity cache if it is enabled.
	 *
	 * @param lmsCompOffLeaveDetails the l m s comp off leave details
	 */
	@Override
	public void cacheResult(LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		EntityCacheUtil.putResult(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			lmsCompOffLeaveDetails.getPrimaryKey(), lmsCompOffLeaveDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] {
				lmsCompOffLeaveDetails.getEmployeeID(),
				lmsCompOffLeaveDetails.getCompoffDate()
			}, lmsCompOffLeaveDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPOFFID,
			new Object[] { lmsCompOffLeaveDetails.getCompOffId() },
			lmsCompOffLeaveDetails);

		lmsCompOffLeaveDetails.resetOriginalValues();
	}

	/**
	 * Caches the l m s comp off leave detailses in the entity cache if it is enabled.
	 *
	 * @param lmsCompOffLeaveDetailses the l m s comp off leave detailses
	 */
	@Override
	public void cacheResult(
		List<LMSCompOffLeaveDetails> lmsCompOffLeaveDetailses) {
		for (LMSCompOffLeaveDetails lmsCompOffLeaveDetails : lmsCompOffLeaveDetailses) {
			if (EntityCacheUtil.getResult(
						LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LMSCompOffLeaveDetailsImpl.class,
						lmsCompOffLeaveDetails.getPrimaryKey()) == null) {
				cacheResult(lmsCompOffLeaveDetails);
			}
			else {
				lmsCompOffLeaveDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s comp off leave detailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSCompOffLeaveDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSCompOffLeaveDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s comp off leave details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		EntityCacheUtil.removeResult(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			lmsCompOffLeaveDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsCompOffLeaveDetails);
	}

	@Override
	public void clearCache(
		List<LMSCompOffLeaveDetails> lmsCompOffLeaveDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSCompOffLeaveDetails lmsCompOffLeaveDetails : lmsCompOffLeaveDetailses) {
			EntityCacheUtil.removeResult(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LMSCompOffLeaveDetailsImpl.class,
				lmsCompOffLeaveDetails.getPrimaryKey());

			clearUniqueFindersCache(lmsCompOffLeaveDetails);
		}
	}

	protected void cacheUniqueFindersCache(
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		if (lmsCompOffLeaveDetails.isNew()) {
			Object[] args = new Object[] {
					lmsCompOffLeaveDetails.getEmployeeID(),
					lmsCompOffLeaveDetails.getCompoffDate()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args,
				lmsCompOffLeaveDetails);

			args = new Object[] { lmsCompOffLeaveDetails.getCompOffId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPOFFID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPOFFID, args,
				lmsCompOffLeaveDetails);
		}
		else {
			LMSCompOffLeaveDetailsModelImpl lmsCompOffLeaveDetailsModelImpl = (LMSCompOffLeaveDetailsModelImpl)lmsCompOffLeaveDetails;

			if ((lmsCompOffLeaveDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsCompOffLeaveDetails.getEmployeeID(),
						lmsCompOffLeaveDetails.getCompoffDate()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					args, lmsCompOffLeaveDetails);
			}

			if ((lmsCompOffLeaveDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COMPOFFID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsCompOffLeaveDetails.getCompOffId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPOFFID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPOFFID, args,
					lmsCompOffLeaveDetails);
			}
		}
	}

	protected void clearUniqueFindersCache(
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		LMSCompOffLeaveDetailsModelImpl lmsCompOffLeaveDetailsModelImpl = (LMSCompOffLeaveDetailsModelImpl)lmsCompOffLeaveDetails;

		Object[] args = new Object[] {
				lmsCompOffLeaveDetails.getEmployeeID(),
				lmsCompOffLeaveDetails.getCompoffDate()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);

		if ((lmsCompOffLeaveDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsCompOffLeaveDetailsModelImpl.getOriginalEmployeeID(),
					lmsCompOffLeaveDetailsModelImpl.getOriginalCompoffDate()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}

		args = new Object[] { lmsCompOffLeaveDetails.getCompOffId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPOFFID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPOFFID, args);

		if ((lmsCompOffLeaveDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COMPOFFID.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsCompOffLeaveDetailsModelImpl.getOriginalCompOffId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPOFFID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPOFFID, args);
		}
	}

	/**
	 * Creates a new l m s comp off leave details with the primary key. Does not add the l m s comp off leave details to the database.
	 *
	 * @param lmsCompOffLeaveDetailsPK the primary key for the new l m s comp off leave details
	 * @return the new l m s comp off leave details
	 */
	@Override
	public LMSCompOffLeaveDetails create(
		LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK) {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = new LMSCompOffLeaveDetailsImpl();

		lmsCompOffLeaveDetails.setNew(true);
		lmsCompOffLeaveDetails.setPrimaryKey(lmsCompOffLeaveDetailsPK);

		return lmsCompOffLeaveDetails;
	}

	/**
	 * Removes the l m s comp off leave details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	 * @return the l m s comp off leave details that was removed
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails remove(
		LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		return remove((Serializable)lmsCompOffLeaveDetailsPK);
	}

	/**
	 * Removes the l m s comp off leave details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s comp off leave details
	 * @return the l m s comp off leave details that was removed
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails remove(Serializable primaryKey)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSCompOffLeaveDetails lmsCompOffLeaveDetails = (LMSCompOffLeaveDetails)session.get(LMSCompOffLeaveDetailsImpl.class,
					primaryKey);

			if (lmsCompOffLeaveDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompOffLeaveDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsCompOffLeaveDetails);
		}
		catch (NoSuchCompOffLeaveDetailsException nsee) {
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
	protected LMSCompOffLeaveDetails removeImpl(
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails)
		throws SystemException {
		lmsCompOffLeaveDetails = toUnwrappedModel(lmsCompOffLeaveDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsCompOffLeaveDetails)) {
				lmsCompOffLeaveDetails = (LMSCompOffLeaveDetails)session.get(LMSCompOffLeaveDetailsImpl.class,
						lmsCompOffLeaveDetails.getPrimaryKeyObj());
			}

			if (lmsCompOffLeaveDetails != null) {
				session.delete(lmsCompOffLeaveDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsCompOffLeaveDetails != null) {
			clearCache(lmsCompOffLeaveDetails);
		}

		return lmsCompOffLeaveDetails;
	}

	@Override
	public LMSCompOffLeaveDetails updateImpl(
		com.trianz.lms.model.LMSCompOffLeaveDetails lmsCompOffLeaveDetails)
		throws SystemException {
		lmsCompOffLeaveDetails = toUnwrappedModel(lmsCompOffLeaveDetails);

		boolean isNew = lmsCompOffLeaveDetails.isNew();

		LMSCompOffLeaveDetailsModelImpl lmsCompOffLeaveDetailsModelImpl = (LMSCompOffLeaveDetailsModelImpl)lmsCompOffLeaveDetails;

		Session session = null;

		try {
			session = openSession();

			if (lmsCompOffLeaveDetails.isNew()) {
				session.save(lmsCompOffLeaveDetails);

				lmsCompOffLeaveDetails.setNew(false);
			}
			else {
				session.merge(lmsCompOffLeaveDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSCompOffLeaveDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsCompOffLeaveDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsCompOffLeaveDetailsModelImpl.getOriginalApproverEmployeeID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVEREMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMPID,
					args);

				args = new Object[] {
						lmsCompOffLeaveDetailsModelImpl.getApproverEmployeeID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVEREMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMPID,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSCompOffLeaveDetailsImpl.class,
			lmsCompOffLeaveDetails.getPrimaryKey(), lmsCompOffLeaveDetails);

		clearUniqueFindersCache(lmsCompOffLeaveDetails);
		cacheUniqueFindersCache(lmsCompOffLeaveDetails);

		return lmsCompOffLeaveDetails;
	}

	protected LMSCompOffLeaveDetails toUnwrappedModel(
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		if (lmsCompOffLeaveDetails instanceof LMSCompOffLeaveDetailsImpl) {
			return lmsCompOffLeaveDetails;
		}

		LMSCompOffLeaveDetailsImpl lmsCompOffLeaveDetailsImpl = new LMSCompOffLeaveDetailsImpl();

		lmsCompOffLeaveDetailsImpl.setNew(lmsCompOffLeaveDetails.isNew());
		lmsCompOffLeaveDetailsImpl.setPrimaryKey(lmsCompOffLeaveDetails.getPrimaryKey());

		lmsCompOffLeaveDetailsImpl.setApprovedBy(lmsCompOffLeaveDetails.getApprovedBy());
		lmsCompOffLeaveDetailsImpl.setCreatedDate(lmsCompOffLeaveDetails.getCreatedDate());
		lmsCompOffLeaveDetailsImpl.setEmployeeID(lmsCompOffLeaveDetails.getEmployeeID());
		lmsCompOffLeaveDetailsImpl.setStatus(lmsCompOffLeaveDetails.getStatus());
		lmsCompOffLeaveDetailsImpl.setCompoffDate(lmsCompOffLeaveDetails.getCompoffDate());
		lmsCompOffLeaveDetailsImpl.setCompOffId(lmsCompOffLeaveDetails.getCompOffId());
		lmsCompOffLeaveDetailsImpl.setApproverEmployeeID(lmsCompOffLeaveDetails.getApproverEmployeeID());

		return lmsCompOffLeaveDetailsImpl;
	}

	/**
	 * Returns the l m s comp off leave details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s comp off leave details
	 * @return the l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = fetchByPrimaryKey(primaryKey);

		if (lmsCompOffLeaveDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompOffLeaveDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsCompOffLeaveDetails;
	}

	/**
	 * Returns the l m s comp off leave details with the primary key or throws a {@link com.trianz.lms.NoSuchCompOffLeaveDetailsException} if it could not be found.
	 *
	 * @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	 * @return the l m s comp off leave details
	 * @throws com.trianz.lms.NoSuchCompOffLeaveDetailsException if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails findByPrimaryKey(
		LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws NoSuchCompOffLeaveDetailsException, SystemException {
		return findByPrimaryKey((Serializable)lmsCompOffLeaveDetailsPK);
	}

	/**
	 * Returns the l m s comp off leave details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s comp off leave details
	 * @return the l m s comp off leave details, or <code>null</code> if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = (LMSCompOffLeaveDetails)EntityCacheUtil.getResult(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LMSCompOffLeaveDetailsImpl.class, primaryKey);

		if (lmsCompOffLeaveDetails == _nullLMSCompOffLeaveDetails) {
			return null;
		}

		if (lmsCompOffLeaveDetails == null) {
			Session session = null;

			try {
				session = openSession();

				lmsCompOffLeaveDetails = (LMSCompOffLeaveDetails)session.get(LMSCompOffLeaveDetailsImpl.class,
						primaryKey);

				if (lmsCompOffLeaveDetails != null) {
					cacheResult(lmsCompOffLeaveDetails);
				}
				else {
					EntityCacheUtil.putResult(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LMSCompOffLeaveDetailsImpl.class, primaryKey,
						_nullLMSCompOffLeaveDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSCompOffLeaveDetailsModelImpl.ENTITY_CACHE_ENABLED,
					LMSCompOffLeaveDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsCompOffLeaveDetails;
	}

	/**
	 * Returns the l m s comp off leave details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lmsCompOffLeaveDetailsPK the primary key of the l m s comp off leave details
	 * @return the l m s comp off leave details, or <code>null</code> if a l m s comp off leave details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSCompOffLeaveDetails fetchByPrimaryKey(
		LMSCompOffLeaveDetailsPK lmsCompOffLeaveDetailsPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)lmsCompOffLeaveDetailsPK);
	}

	/**
	 * Returns all the l m s comp off leave detailses.
	 *
	 * @return the l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s comp off leave detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s comp off leave detailses
	 * @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	 * @return the range of l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s comp off leave detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSCompOffLeaveDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s comp off leave detailses
	 * @param end the upper bound of the range of l m s comp off leave detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s comp off leave detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSCompOffLeaveDetails> findAll(int start, int end,
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

		List<LMSCompOffLeaveDetails> list = (List<LMSCompOffLeaveDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSCOMPOFFLEAVEDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSCOMPOFFLEAVEDETAILS;

				if (pagination) {
					sql = sql.concat(LMSCompOffLeaveDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSCompOffLeaveDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSCompOffLeaveDetails>(list);
				}
				else {
					list = (List<LMSCompOffLeaveDetails>)QueryUtil.list(q,
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
	 * Removes all the l m s comp off leave detailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSCompOffLeaveDetails lmsCompOffLeaveDetails : findAll()) {
			remove(lmsCompOffLeaveDetails);
		}
	}

	/**
	 * Returns the number of l m s comp off leave detailses.
	 *
	 * @return the number of l m s comp off leave detailses
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

				Query q = session.createQuery(_SQL_COUNT_LMSCOMPOFFLEAVEDETAILS);

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
	 * Initializes the l m s comp off leave details persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSCompOffLeaveDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSCompOffLeaveDetails>> listenersList = new ArrayList<ModelListener<LMSCompOffLeaveDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSCompOffLeaveDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSCompOffLeaveDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSCOMPOFFLEAVEDETAILS = "SELECT lmsCompOffLeaveDetails FROM LMSCompOffLeaveDetails lmsCompOffLeaveDetails";
	private static final String _SQL_SELECT_LMSCOMPOFFLEAVEDETAILS_WHERE = "SELECT lmsCompOffLeaveDetails FROM LMSCompOffLeaveDetails lmsCompOffLeaveDetails WHERE ";
	private static final String _SQL_COUNT_LMSCOMPOFFLEAVEDETAILS = "SELECT COUNT(lmsCompOffLeaveDetails) FROM LMSCompOffLeaveDetails lmsCompOffLeaveDetails";
	private static final String _SQL_COUNT_LMSCOMPOFFLEAVEDETAILS_WHERE = "SELECT COUNT(lmsCompOffLeaveDetails) FROM LMSCompOffLeaveDetails lmsCompOffLeaveDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsCompOffLeaveDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSCompOffLeaveDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSCompOffLeaveDetails exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSCompOffLeaveDetailsPersistenceImpl.class);
	private static LMSCompOffLeaveDetails _nullLMSCompOffLeaveDetails = new LMSCompOffLeaveDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSCompOffLeaveDetails> toCacheModel() {
				return _nullLMSCompOffLeaveDetailsCacheModel;
			}
		};

	private static CacheModel<LMSCompOffLeaveDetails> _nullLMSCompOffLeaveDetailsCacheModel =
		new CacheModel<LMSCompOffLeaveDetails>() {
			@Override
			public LMSCompOffLeaveDetails toEntityModel() {
				return _nullLMSCompOffLeaveDetails;
			}
		};
}