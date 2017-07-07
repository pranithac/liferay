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

import com.trianz.lms.NoSuchProjectDetailsException;
import com.trianz.lms.model.LMSProjectDetails;
import com.trianz.lms.model.impl.LMSProjectDetailsImpl;
import com.trianz.lms.model.impl.LMSProjectDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s project details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSProjectDetailsPersistence
 * @see LMSProjectDetailsUtil
 * @generated
 */
public class LMSProjectDetailsPersistenceImpl extends BasePersistenceImpl<LMSProjectDetails>
	implements LMSProjectDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSProjectDetailsUtil} to access the l m s project details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSProjectDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] { Integer.class.getName() },
			LMSProjectDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the l m s project detailses where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @return the matching l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSProjectDetails> findByEmployeeId(int EmployeeId)
		throws SystemException {
		return findByEmployeeId(EmployeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSProjectDetails> findByEmployeeId(int EmployeeId, int start,
		int end) throws SystemException {
		return findByEmployeeId(EmployeeId, start, end, null);
	}

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
	@Override
	public List<LMSProjectDetails> findByEmployeeId(int EmployeeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<LMSProjectDetails> list = (List<LMSProjectDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSProjectDetails lmsProjectDetails : list) {
				if ((EmployeeId != lmsProjectDetails.getEmployeeId())) {
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

			query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSProjectDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

				if (!pagination) {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSProjectDetails>(list);
				}
				else {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
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
	 * Returns the first l m s project details in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByEmployeeId_First(int EmployeeId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByEmployeeId_First(EmployeeId,
				orderByComparator);

		if (lmsProjectDetails != null) {
			return lmsProjectDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("EmployeeId=");
		msg.append(EmployeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectDetailsException(msg.toString());
	}

	/**
	 * Returns the first l m s project details in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByEmployeeId_First(int EmployeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSProjectDetails> list = findByEmployeeId(EmployeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s project details in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByEmployeeId_Last(int EmployeeId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByEmployeeId_Last(EmployeeId,
				orderByComparator);

		if (lmsProjectDetails != null) {
			return lmsProjectDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("EmployeeId=");
		msg.append(EmployeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectDetailsException(msg.toString());
	}

	/**
	 * Returns the last l m s project details in the ordered set where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByEmployeeId_Last(int EmployeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmployeeId(EmployeeId);

		if (count == 0) {
			return null;
		}

		List<LMSProjectDetails> list = findByEmployeeId(EmployeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSProjectDetails[] findByEmployeeId_PrevAndNext(int AssignmentID,
		int EmployeeId, OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = findByPrimaryKey(AssignmentID);

		Session session = null;

		try {
			session = openSession();

			LMSProjectDetails[] array = new LMSProjectDetailsImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(session, lmsProjectDetails,
					EmployeeId, orderByComparator, true);

			array[1] = lmsProjectDetails;

			array[2] = getByEmployeeId_PrevAndNext(session, lmsProjectDetails,
					EmployeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSProjectDetails getByEmployeeId_PrevAndNext(Session session,
		LMSProjectDetails lmsProjectDetails, int EmployeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

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
			query.append(LMSProjectDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(EmployeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsProjectDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSProjectDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s project detailses where EmployeeId = &#63; from the database.
	 *
	 * @param EmployeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmployeeId(int EmployeeId) throws SystemException {
		for (LMSProjectDetails lmsProjectDetails : findByEmployeeId(
				EmployeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsProjectDetails);
		}
	}

	/**
	 * Returns the number of l m s project detailses where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @return the number of matching l m s project detailses
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

			query.append(_SQL_COUNT_LMSPROJECTDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "lmsProjectDetails.EmployeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECTCODE = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProjectCode",
			new String[] { String.class.getName(), Integer.class.getName() },
			LMSProjectDetailsModelImpl.PROJECTCODE_COLUMN_BITMASK |
			LMSProjectDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTCODE = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectCode",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; or throws a {@link com.trianz.lms.NoSuchProjectDetailsException} if it could not be found.
	 *
	 * @param ProjectCode the project code
	 * @param EmployeeId the employee ID
	 * @return the matching l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByProjectCode(String ProjectCode,
		int EmployeeId) throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByProjectCode(ProjectCode,
				EmployeeId);

		if (lmsProjectDetails == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ProjectCode=");
			msg.append(ProjectCode);

			msg.append(", EmployeeId=");
			msg.append(EmployeeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProjectDetailsException(msg.toString());
		}

		return lmsProjectDetails;
	}

	/**
	 * Returns the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ProjectCode the project code
	 * @param EmployeeId the employee ID
	 * @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByProjectCode(String ProjectCode,
		int EmployeeId) throws SystemException {
		return fetchByProjectCode(ProjectCode, EmployeeId, true);
	}

	/**
	 * Returns the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ProjectCode the project code
	 * @param EmployeeId the employee ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByProjectCode(String ProjectCode,
		int EmployeeId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ProjectCode, EmployeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROJECTCODE,
					finderArgs, this);
		}

		if (result instanceof LMSProjectDetails) {
			LMSProjectDetails lmsProjectDetails = (LMSProjectDetails)result;

			if (!Validator.equals(ProjectCode,
						lmsProjectDetails.getProjectCode()) ||
					(EmployeeId != lmsProjectDetails.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

			boolean bindProjectCode = false;

			if (ProjectCode == null) {
				query.append(_FINDER_COLUMN_PROJECTCODE_PROJECTCODE_1);
			}
			else if (ProjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROJECTCODE_PROJECTCODE_3);
			}
			else {
				bindProjectCode = true;

				query.append(_FINDER_COLUMN_PROJECTCODE_PROJECTCODE_2);
			}

			query.append(_FINDER_COLUMN_PROJECTCODE_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProjectCode) {
					qPos.add(ProjectCode);
				}

				qPos.add(EmployeeId);

				List<LMSProjectDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSProjectDetailsPersistenceImpl.fetchByProjectCode(String, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSProjectDetails lmsProjectDetails = list.get(0);

					result = lmsProjectDetails;

					cacheResult(lmsProjectDetails);

					if ((lmsProjectDetails.getProjectCode() == null) ||
							!lmsProjectDetails.getProjectCode()
												  .equals(ProjectCode) ||
							(lmsProjectDetails.getEmployeeId() != EmployeeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODE,
							finderArgs, lmsProjectDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTCODE,
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
			return (LMSProjectDetails)result;
		}
	}

	/**
	 * Removes the l m s project details where ProjectCode = &#63; and EmployeeId = &#63; from the database.
	 *
	 * @param ProjectCode the project code
	 * @param EmployeeId the employee ID
	 * @return the l m s project details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails removeByProjectCode(String ProjectCode,
		int EmployeeId) throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = findByProjectCode(ProjectCode,
				EmployeeId);

		return remove(lmsProjectDetails);
	}

	/**
	 * Returns the number of l m s project detailses where ProjectCode = &#63; and EmployeeId = &#63;.
	 *
	 * @param ProjectCode the project code
	 * @param EmployeeId the employee ID
	 * @return the number of matching l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProjectCode(String ProjectCode, int EmployeeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTCODE;

		Object[] finderArgs = new Object[] { ProjectCode, EmployeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LMSPROJECTDETAILS_WHERE);

			boolean bindProjectCode = false;

			if (ProjectCode == null) {
				query.append(_FINDER_COLUMN_PROJECTCODE_PROJECTCODE_1);
			}
			else if (ProjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROJECTCODE_PROJECTCODE_3);
			}
			else {
				bindProjectCode = true;

				query.append(_FINDER_COLUMN_PROJECTCODE_PROJECTCODE_2);
			}

			query.append(_FINDER_COLUMN_PROJECTCODE_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProjectCode) {
					qPos.add(ProjectCode);
				}

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

	private static final String _FINDER_COLUMN_PROJECTCODE_PROJECTCODE_1 = "lmsProjectDetails.ProjectCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PROJECTCODE_PROJECTCODE_2 = "lmsProjectDetails.ProjectCode = ? AND ";
	private static final String _FINDER_COLUMN_PROJECTCODE_PROJECTCODE_3 = "(lmsProjectDetails.ProjectCode IS NULL OR lmsProjectDetails.ProjectCode = '') AND ";
	private static final String _FINDER_COLUMN_PROJECTCODE_EMPLOYEEID_2 = "lmsProjectDetails.EmployeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProjectCodetogetName",
			new String[] { String.class.getName() },
			LMSProjectDetailsModelImpl.PROJECTCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTCODETOGETNAME = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProjectCodetogetName",
			new String[] { String.class.getName() });

	/**
	 * Returns the l m s project details where ProjectCode = &#63; or throws a {@link com.trianz.lms.NoSuchProjectDetailsException} if it could not be found.
	 *
	 * @param ProjectCode the project code
	 * @return the matching l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByProjectCodetogetName(String ProjectCode)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByProjectCodetogetName(ProjectCode);

		if (lmsProjectDetails == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ProjectCode=");
			msg.append(ProjectCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProjectDetailsException(msg.toString());
		}

		return lmsProjectDetails;
	}

	/**
	 * Returns the l m s project details where ProjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ProjectCode the project code
	 * @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByProjectCodetogetName(String ProjectCode)
		throws SystemException {
		return fetchByProjectCodetogetName(ProjectCode, true);
	}

	/**
	 * Returns the l m s project details where ProjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ProjectCode the project code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByProjectCodetogetName(String ProjectCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ProjectCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
					finderArgs, this);
		}

		if (result instanceof LMSProjectDetails) {
			LMSProjectDetails lmsProjectDetails = (LMSProjectDetails)result;

			if (!Validator.equals(ProjectCode,
						lmsProjectDetails.getProjectCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

			boolean bindProjectCode = false;

			if (ProjectCode == null) {
				query.append(_FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_1);
			}
			else if (ProjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_3);
			}
			else {
				bindProjectCode = true;

				query.append(_FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProjectCode) {
					qPos.add(ProjectCode);
				}

				List<LMSProjectDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSProjectDetailsPersistenceImpl.fetchByProjectCodetogetName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSProjectDetails lmsProjectDetails = list.get(0);

					result = lmsProjectDetails;

					cacheResult(lmsProjectDetails);

					if ((lmsProjectDetails.getProjectCode() == null) ||
							!lmsProjectDetails.getProjectCode()
												  .equals(ProjectCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
							finderArgs, lmsProjectDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
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
			return (LMSProjectDetails)result;
		}
	}

	/**
	 * Removes the l m s project details where ProjectCode = &#63; from the database.
	 *
	 * @param ProjectCode the project code
	 * @return the l m s project details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails removeByProjectCodetogetName(String ProjectCode)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = findByProjectCodetogetName(ProjectCode);

		return remove(lmsProjectDetails);
	}

	/**
	 * Returns the number of l m s project detailses where ProjectCode = &#63;.
	 *
	 * @param ProjectCode the project code
	 * @return the number of matching l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProjectCodetogetName(String ProjectCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTCODETOGETNAME;

		Object[] finderArgs = new Object[] { ProjectCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSPROJECTDETAILS_WHERE);

			boolean bindProjectCode = false;

			if (ProjectCode == null) {
				query.append(_FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_1);
			}
			else if (ProjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_3);
			}
			else {
				bindProjectCode = true;

				query.append(_FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProjectCode) {
					qPos.add(ProjectCode);
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

	private static final String _FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_1 =
		"lmsProjectDetails.ProjectCode IS NULL";
	private static final String _FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_2 =
		"lmsProjectDetails.ProjectCode = ?";
	private static final String _FINDER_COLUMN_PROJECTCODETOGETNAME_PROJECTCODE_3 =
		"(lmsProjectDetails.ProjectCode IS NULL OR lmsProjectDetails.ProjectCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEREMAILID =
		new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApproverEmailId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILID =
		new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApproverEmailId",
			new String[] { String.class.getName() },
			LMSProjectDetailsModelImpl.APPROVEREMAIL_COLUMN_BITMASK |
			LMSProjectDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEREMAILID = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApproverEmailId", new String[] { String.class.getName() });

	/**
	 * Returns all the l m s project detailses where ApproverEmail = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @return the matching l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSProjectDetails> findByApproverEmailId(String ApproverEmail)
		throws SystemException {
		return findByApproverEmailId(ApproverEmail, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSProjectDetails> findByApproverEmailId(String ApproverEmail,
		int start, int end) throws SystemException {
		return findByApproverEmailId(ApproverEmail, start, end, null);
	}

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
	@Override
	public List<LMSProjectDetails> findByApproverEmailId(String ApproverEmail,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILID;
			finderArgs = new Object[] { ApproverEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVEREMAILID;
			finderArgs = new Object[] {
					ApproverEmail,
					
					start, end, orderByComparator
				};
		}

		List<LMSProjectDetails> list = (List<LMSProjectDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSProjectDetails lmsProjectDetails : list) {
				if (!Validator.equals(ApproverEmail,
							lmsProjectDetails.getApproverEmail())) {
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

			query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

			boolean bindApproverEmail = false;

			if (ApproverEmail == null) {
				query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_1);
			}
			else if (ApproverEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_3);
			}
			else {
				bindApproverEmail = true;

				query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSProjectDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApproverEmail) {
					qPos.add(ApproverEmail);
				}

				if (!pagination) {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSProjectDetails>(list);
				}
				else {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
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
	 * Returns the first l m s project details in the ordered set where ApproverEmail = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByApproverEmailId_First(String ApproverEmail,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByApproverEmailId_First(ApproverEmail,
				orderByComparator);

		if (lmsProjectDetails != null) {
			return lmsProjectDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmail=");
		msg.append(ApproverEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectDetailsException(msg.toString());
	}

	/**
	 * Returns the first l m s project details in the ordered set where ApproverEmail = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByApproverEmailId_First(
		String ApproverEmail, OrderByComparator orderByComparator)
		throws SystemException {
		List<LMSProjectDetails> list = findByApproverEmailId(ApproverEmail, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s project details in the ordered set where ApproverEmail = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByApproverEmailId_Last(String ApproverEmail,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByApproverEmailId_Last(ApproverEmail,
				orderByComparator);

		if (lmsProjectDetails != null) {
			return lmsProjectDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmail=");
		msg.append(ApproverEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectDetailsException(msg.toString());
	}

	/**
	 * Returns the last l m s project details in the ordered set where ApproverEmail = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByApproverEmailId_Last(String ApproverEmail,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByApproverEmailId(ApproverEmail);

		if (count == 0) {
			return null;
		}

		List<LMSProjectDetails> list = findByApproverEmailId(ApproverEmail,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSProjectDetails[] findByApproverEmailId_PrevAndNext(
		int AssignmentID, String ApproverEmail,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = findByPrimaryKey(AssignmentID);

		Session session = null;

		try {
			session = openSession();

			LMSProjectDetails[] array = new LMSProjectDetailsImpl[3];

			array[0] = getByApproverEmailId_PrevAndNext(session,
					lmsProjectDetails, ApproverEmail, orderByComparator, true);

			array[1] = lmsProjectDetails;

			array[2] = getByApproverEmailId_PrevAndNext(session,
					lmsProjectDetails, ApproverEmail, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSProjectDetails getByApproverEmailId_PrevAndNext(
		Session session, LMSProjectDetails lmsProjectDetails,
		String ApproverEmail, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

		boolean bindApproverEmail = false;

		if (ApproverEmail == null) {
			query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_1);
		}
		else if (ApproverEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_3);
		}
		else {
			bindApproverEmail = true;

			query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_2);
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
			query.append(LMSProjectDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApproverEmail) {
			qPos.add(ApproverEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsProjectDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSProjectDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s project detailses where ApproverEmail = &#63; from the database.
	 *
	 * @param ApproverEmail the approver email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApproverEmailId(String ApproverEmail)
		throws SystemException {
		for (LMSProjectDetails lmsProjectDetails : findByApproverEmailId(
				ApproverEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsProjectDetails);
		}
	}

	/**
	 * Returns the number of l m s project detailses where ApproverEmail = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @return the number of matching l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApproverEmailId(String ApproverEmail)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPROVEREMAILID;

		Object[] finderArgs = new Object[] { ApproverEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSPROJECTDETAILS_WHERE);

			boolean bindApproverEmail = false;

			if (ApproverEmail == null) {
				query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_1);
			}
			else if (ApproverEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_3);
			}
			else {
				bindApproverEmail = true;

				query.append(_FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApproverEmail) {
					qPos.add(ApproverEmail);
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

	private static final String _FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_1 = "lmsProjectDetails.ApproverEmail IS NULL";
	private static final String _FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_2 = "lmsProjectDetails.ApproverEmail = ?";
	private static final String _FINDER_COLUMN_APPROVEREMAILID_APPROVEREMAIL_3 = "(lmsProjectDetails.ApproverEmail IS NULL OR lmsProjectDetails.ApproverEmail = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVERANDPROJECT =
		new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApproverandProject",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVERANDPROJECT =
		new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSProjectDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApproverandProject",
			new String[] { String.class.getName(), String.class.getName() },
			LMSProjectDetailsModelImpl.APPROVEREMAIL_COLUMN_BITMASK |
			LMSProjectDetailsModelImpl.PROJECTCODE_COLUMN_BITMASK |
			LMSProjectDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVERANDPROJECT = new FinderPath(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApproverandProject",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param ProjectCode the project code
	 * @return the matching l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSProjectDetails> findByApproverandProject(
		String ApproverEmail, String ProjectCode) throws SystemException {
		return findByApproverandProject(ApproverEmail, ProjectCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSProjectDetails> findByApproverandProject(
		String ApproverEmail, String ProjectCode, int start, int end)
		throws SystemException {
		return findByApproverandProject(ApproverEmail, ProjectCode, start, end,
			null);
	}

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
	@Override
	public List<LMSProjectDetails> findByApproverandProject(
		String ApproverEmail, String ProjectCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVERANDPROJECT;
			finderArgs = new Object[] { ApproverEmail, ProjectCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVERANDPROJECT;
			finderArgs = new Object[] {
					ApproverEmail, ProjectCode,
					
					start, end, orderByComparator
				};
		}

		List<LMSProjectDetails> list = (List<LMSProjectDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSProjectDetails lmsProjectDetails : list) {
				if (!Validator.equals(ApproverEmail,
							lmsProjectDetails.getApproverEmail()) ||
						!Validator.equals(ProjectCode,
							lmsProjectDetails.getProjectCode())) {
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

			query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

			boolean bindApproverEmail = false;

			if (ApproverEmail == null) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_1);
			}
			else if (ApproverEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_3);
			}
			else {
				bindApproverEmail = true;

				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_2);
			}

			boolean bindProjectCode = false;

			if (ProjectCode == null) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_1);
			}
			else if (ProjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_3);
			}
			else {
				bindProjectCode = true;

				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSProjectDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApproverEmail) {
					qPos.add(ApproverEmail);
				}

				if (bindProjectCode) {
					qPos.add(ProjectCode);
				}

				if (!pagination) {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSProjectDetails>(list);
				}
				else {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
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
	 * Returns the first l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param ProjectCode the project code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByApproverandProject_First(
		String ApproverEmail, String ProjectCode,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByApproverandProject_First(ApproverEmail,
				ProjectCode, orderByComparator);

		if (lmsProjectDetails != null) {
			return lmsProjectDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmail=");
		msg.append(ApproverEmail);

		msg.append(", ProjectCode=");
		msg.append(ProjectCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectDetailsException(msg.toString());
	}

	/**
	 * Returns the first l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param ProjectCode the project code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByApproverandProject_First(
		String ApproverEmail, String ProjectCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSProjectDetails> list = findByApproverandProject(ApproverEmail,
				ProjectCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSProjectDetails findByApproverandProject_Last(
		String ApproverEmail, String ProjectCode,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByApproverandProject_Last(ApproverEmail,
				ProjectCode, orderByComparator);

		if (lmsProjectDetails != null) {
			return lmsProjectDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ApproverEmail=");
		msg.append(ApproverEmail);

		msg.append(", ProjectCode=");
		msg.append(ProjectCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectDetailsException(msg.toString());
	}

	/**
	 * Returns the last l m s project details in the ordered set where ApproverEmail = &#63; and ProjectCode = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param ProjectCode the project code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s project details, or <code>null</code> if a matching l m s project details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByApproverandProject_Last(
		String ApproverEmail, String ProjectCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByApproverandProject(ApproverEmail, ProjectCode);

		if (count == 0) {
			return null;
		}

		List<LMSProjectDetails> list = findByApproverandProject(ApproverEmail,
				ProjectCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LMSProjectDetails[] findByApproverandProject_PrevAndNext(
		int AssignmentID, String ApproverEmail, String ProjectCode,
		OrderByComparator orderByComparator)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = findByPrimaryKey(AssignmentID);

		Session session = null;

		try {
			session = openSession();

			LMSProjectDetails[] array = new LMSProjectDetailsImpl[3];

			array[0] = getByApproverandProject_PrevAndNext(session,
					lmsProjectDetails, ApproverEmail, ProjectCode,
					orderByComparator, true);

			array[1] = lmsProjectDetails;

			array[2] = getByApproverandProject_PrevAndNext(session,
					lmsProjectDetails, ApproverEmail, ProjectCode,
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

	protected LMSProjectDetails getByApproverandProject_PrevAndNext(
		Session session, LMSProjectDetails lmsProjectDetails,
		String ApproverEmail, String ProjectCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSPROJECTDETAILS_WHERE);

		boolean bindApproverEmail = false;

		if (ApproverEmail == null) {
			query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_1);
		}
		else if (ApproverEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_3);
		}
		else {
			bindApproverEmail = true;

			query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_2);
		}

		boolean bindProjectCode = false;

		if (ProjectCode == null) {
			query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_1);
		}
		else if (ProjectCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_3);
		}
		else {
			bindProjectCode = true;

			query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_2);
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
			query.append(LMSProjectDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApproverEmail) {
			qPos.add(ApproverEmail);
		}

		if (bindProjectCode) {
			qPos.add(ProjectCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsProjectDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSProjectDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63; from the database.
	 *
	 * @param ApproverEmail the approver email
	 * @param ProjectCode the project code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApproverandProject(String ApproverEmail,
		String ProjectCode) throws SystemException {
		for (LMSProjectDetails lmsProjectDetails : findByApproverandProject(
				ApproverEmail, ProjectCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lmsProjectDetails);
		}
	}

	/**
	 * Returns the number of l m s project detailses where ApproverEmail = &#63; and ProjectCode = &#63;.
	 *
	 * @param ApproverEmail the approver email
	 * @param ProjectCode the project code
	 * @return the number of matching l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApproverandProject(String ApproverEmail,
		String ProjectCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPROVERANDPROJECT;

		Object[] finderArgs = new Object[] { ApproverEmail, ProjectCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LMSPROJECTDETAILS_WHERE);

			boolean bindApproverEmail = false;

			if (ApproverEmail == null) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_1);
			}
			else if (ApproverEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_3);
			}
			else {
				bindApproverEmail = true;

				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_2);
			}

			boolean bindProjectCode = false;

			if (ProjectCode == null) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_1);
			}
			else if (ProjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_3);
			}
			else {
				bindProjectCode = true;

				query.append(_FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApproverEmail) {
					qPos.add(ApproverEmail);
				}

				if (bindProjectCode) {
					qPos.add(ProjectCode);
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

	private static final String _FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_1 =
		"lmsProjectDetails.ApproverEmail IS NULL AND ";
	private static final String _FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_2 =
		"lmsProjectDetails.ApproverEmail = ? AND ";
	private static final String _FINDER_COLUMN_APPROVERANDPROJECT_APPROVEREMAIL_3 =
		"(lmsProjectDetails.ApproverEmail IS NULL OR lmsProjectDetails.ApproverEmail = '') AND ";
	private static final String _FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_1 = "lmsProjectDetails.ProjectCode IS NULL";
	private static final String _FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_2 = "lmsProjectDetails.ProjectCode = ?";
	private static final String _FINDER_COLUMN_APPROVERANDPROJECT_PROJECTCODE_3 = "(lmsProjectDetails.ProjectCode IS NULL OR lmsProjectDetails.ProjectCode = '')";

	public LMSProjectDetailsPersistenceImpl() {
		setModelClass(LMSProjectDetails.class);
	}

	/**
	 * Caches the l m s project details in the entity cache if it is enabled.
	 *
	 * @param lmsProjectDetails the l m s project details
	 */
	@Override
	public void cacheResult(LMSProjectDetails lmsProjectDetails) {
		EntityCacheUtil.putResult(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsImpl.class, lmsProjectDetails.getPrimaryKey(),
			lmsProjectDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODE,
			new Object[] {
				lmsProjectDetails.getProjectCode(),
				lmsProjectDetails.getEmployeeId()
			}, lmsProjectDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
			new Object[] { lmsProjectDetails.getProjectCode() },
			lmsProjectDetails);

		lmsProjectDetails.resetOriginalValues();
	}

	/**
	 * Caches the l m s project detailses in the entity cache if it is enabled.
	 *
	 * @param lmsProjectDetailses the l m s project detailses
	 */
	@Override
	public void cacheResult(List<LMSProjectDetails> lmsProjectDetailses) {
		for (LMSProjectDetails lmsProjectDetails : lmsProjectDetailses) {
			if (EntityCacheUtil.getResult(
						LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LMSProjectDetailsImpl.class,
						lmsProjectDetails.getPrimaryKey()) == null) {
				cacheResult(lmsProjectDetails);
			}
			else {
				lmsProjectDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s project detailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSProjectDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSProjectDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s project details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSProjectDetails lmsProjectDetails) {
		EntityCacheUtil.removeResult(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsImpl.class, lmsProjectDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsProjectDetails);
	}

	@Override
	public void clearCache(List<LMSProjectDetails> lmsProjectDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSProjectDetails lmsProjectDetails : lmsProjectDetailses) {
			EntityCacheUtil.removeResult(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LMSProjectDetailsImpl.class, lmsProjectDetails.getPrimaryKey());

			clearUniqueFindersCache(lmsProjectDetails);
		}
	}

	protected void cacheUniqueFindersCache(LMSProjectDetails lmsProjectDetails) {
		if (lmsProjectDetails.isNew()) {
			Object[] args = new Object[] {
					lmsProjectDetails.getProjectCode(),
					lmsProjectDetails.getEmployeeId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECTCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODE, args,
				lmsProjectDetails);

			args = new Object[] { lmsProjectDetails.getProjectCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECTCODETOGETNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
				args, lmsProjectDetails);
		}
		else {
			LMSProjectDetailsModelImpl lmsProjectDetailsModelImpl = (LMSProjectDetailsModelImpl)lmsProjectDetails;

			if ((lmsProjectDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROJECTCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsProjectDetails.getProjectCode(),
						lmsProjectDetails.getEmployeeId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECTCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODE,
					args, lmsProjectDetails);
			}

			if ((lmsProjectDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { lmsProjectDetails.getProjectCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECTCODETOGETNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
					args, lmsProjectDetails);
			}
		}
	}

	protected void clearUniqueFindersCache(LMSProjectDetails lmsProjectDetails) {
		LMSProjectDetailsModelImpl lmsProjectDetailsModelImpl = (LMSProjectDetailsModelImpl)lmsProjectDetails;

		Object[] args = new Object[] {
				lmsProjectDetails.getProjectCode(),
				lmsProjectDetails.getEmployeeId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTCODE, args);

		if ((lmsProjectDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECTCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsProjectDetailsModelImpl.getOriginalProjectCode(),
					lmsProjectDetailsModelImpl.getOriginalEmployeeId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTCODE, args);
		}

		args = new Object[] { lmsProjectDetails.getProjectCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTCODETOGETNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
			args);

		if ((lmsProjectDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsProjectDetailsModelImpl.getOriginalProjectCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTCODETOGETNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTCODETOGETNAME,
				args);
		}
	}

	/**
	 * Creates a new l m s project details with the primary key. Does not add the l m s project details to the database.
	 *
	 * @param AssignmentID the primary key for the new l m s project details
	 * @return the new l m s project details
	 */
	@Override
	public LMSProjectDetails create(int AssignmentID) {
		LMSProjectDetails lmsProjectDetails = new LMSProjectDetailsImpl();

		lmsProjectDetails.setNew(true);
		lmsProjectDetails.setPrimaryKey(AssignmentID);

		return lmsProjectDetails;
	}

	/**
	 * Removes the l m s project details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AssignmentID the primary key of the l m s project details
	 * @return the l m s project details that was removed
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails remove(int AssignmentID)
		throws NoSuchProjectDetailsException, SystemException {
		return remove((Serializable)AssignmentID);
	}

	/**
	 * Removes the l m s project details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s project details
	 * @return the l m s project details that was removed
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails remove(Serializable primaryKey)
		throws NoSuchProjectDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSProjectDetails lmsProjectDetails = (LMSProjectDetails)session.get(LMSProjectDetailsImpl.class,
					primaryKey);

			if (lmsProjectDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsProjectDetails);
		}
		catch (NoSuchProjectDetailsException nsee) {
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
	protected LMSProjectDetails removeImpl(LMSProjectDetails lmsProjectDetails)
		throws SystemException {
		lmsProjectDetails = toUnwrappedModel(lmsProjectDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsProjectDetails)) {
				lmsProjectDetails = (LMSProjectDetails)session.get(LMSProjectDetailsImpl.class,
						lmsProjectDetails.getPrimaryKeyObj());
			}

			if (lmsProjectDetails != null) {
				session.delete(lmsProjectDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsProjectDetails != null) {
			clearCache(lmsProjectDetails);
		}

		return lmsProjectDetails;
	}

	@Override
	public LMSProjectDetails updateImpl(
		com.trianz.lms.model.LMSProjectDetails lmsProjectDetails)
		throws SystemException {
		lmsProjectDetails = toUnwrappedModel(lmsProjectDetails);

		boolean isNew = lmsProjectDetails.isNew();

		LMSProjectDetailsModelImpl lmsProjectDetailsModelImpl = (LMSProjectDetailsModelImpl)lmsProjectDetails;

		Session session = null;

		try {
			session = openSession();

			if (lmsProjectDetails.isNew()) {
				session.save(lmsProjectDetails);

				lmsProjectDetails.setNew(false);
			}
			else {
				session.merge(lmsProjectDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSProjectDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsProjectDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsProjectDetailsModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { lmsProjectDetailsModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((lmsProjectDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsProjectDetailsModelImpl.getOriginalApproverEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVEREMAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILID,
					args);

				args = new Object[] {
						lmsProjectDetailsModelImpl.getApproverEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVEREMAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVEREMAILID,
					args);
			}

			if ((lmsProjectDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVERANDPROJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsProjectDetailsModelImpl.getOriginalApproverEmail(),
						lmsProjectDetailsModelImpl.getOriginalProjectCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVERANDPROJECT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVERANDPROJECT,
					args);

				args = new Object[] {
						lmsProjectDetailsModelImpl.getApproverEmail(),
						lmsProjectDetailsModelImpl.getProjectCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVERANDPROJECT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVERANDPROJECT,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSProjectDetailsImpl.class, lmsProjectDetails.getPrimaryKey(),
			lmsProjectDetails);

		clearUniqueFindersCache(lmsProjectDetails);
		cacheUniqueFindersCache(lmsProjectDetails);

		return lmsProjectDetails;
	}

	protected LMSProjectDetails toUnwrappedModel(
		LMSProjectDetails lmsProjectDetails) {
		if (lmsProjectDetails instanceof LMSProjectDetailsImpl) {
			return lmsProjectDetails;
		}

		LMSProjectDetailsImpl lmsProjectDetailsImpl = new LMSProjectDetailsImpl();

		lmsProjectDetailsImpl.setNew(lmsProjectDetails.isNew());
		lmsProjectDetailsImpl.setPrimaryKey(lmsProjectDetails.getPrimaryKey());

		lmsProjectDetailsImpl.setEmployeeId(lmsProjectDetails.getEmployeeId());
		lmsProjectDetailsImpl.setProjectCode(lmsProjectDetails.getProjectCode());
		lmsProjectDetailsImpl.setProjectName(lmsProjectDetails.getProjectName());
		lmsProjectDetailsImpl.setApproverName(lmsProjectDetails.getApproverName());
		lmsProjectDetailsImpl.setApproverID(lmsProjectDetails.getApproverID());
		lmsProjectDetailsImpl.setApproverEmail(lmsProjectDetails.getApproverEmail());
		lmsProjectDetailsImpl.setAssignmentID(lmsProjectDetails.getAssignmentID());

		return lmsProjectDetailsImpl;
	}

	/**
	 * Returns the l m s project details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s project details
	 * @return the l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectDetailsException, SystemException {
		LMSProjectDetails lmsProjectDetails = fetchByPrimaryKey(primaryKey);

		if (lmsProjectDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsProjectDetails;
	}

	/**
	 * Returns the l m s project details with the primary key or throws a {@link com.trianz.lms.NoSuchProjectDetailsException} if it could not be found.
	 *
	 * @param AssignmentID the primary key of the l m s project details
	 * @return the l m s project details
	 * @throws com.trianz.lms.NoSuchProjectDetailsException if a l m s project details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails findByPrimaryKey(int AssignmentID)
		throws NoSuchProjectDetailsException, SystemException {
		return findByPrimaryKey((Serializable)AssignmentID);
	}

	/**
	 * Returns the l m s project details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s project details
	 * @return the l m s project details, or <code>null</code> if a l m s project details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSProjectDetails lmsProjectDetails = (LMSProjectDetails)EntityCacheUtil.getResult(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LMSProjectDetailsImpl.class, primaryKey);

		if (lmsProjectDetails == _nullLMSProjectDetails) {
			return null;
		}

		if (lmsProjectDetails == null) {
			Session session = null;

			try {
				session = openSession();

				lmsProjectDetails = (LMSProjectDetails)session.get(LMSProjectDetailsImpl.class,
						primaryKey);

				if (lmsProjectDetails != null) {
					cacheResult(lmsProjectDetails);
				}
				else {
					EntityCacheUtil.putResult(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LMSProjectDetailsImpl.class, primaryKey,
						_nullLMSProjectDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSProjectDetailsModelImpl.ENTITY_CACHE_ENABLED,
					LMSProjectDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsProjectDetails;
	}

	/**
	 * Returns the l m s project details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AssignmentID the primary key of the l m s project details
	 * @return the l m s project details, or <code>null</code> if a l m s project details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSProjectDetails fetchByPrimaryKey(int AssignmentID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)AssignmentID);
	}

	/**
	 * Returns all the l m s project detailses.
	 *
	 * @return the l m s project detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSProjectDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LMSProjectDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<LMSProjectDetails> findAll(int start, int end,
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

		List<LMSProjectDetails> list = (List<LMSProjectDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSPROJECTDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSPROJECTDETAILS;

				if (pagination) {
					sql = sql.concat(LMSProjectDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSProjectDetails>(list);
				}
				else {
					list = (List<LMSProjectDetails>)QueryUtil.list(q,
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
	 * Removes all the l m s project detailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSProjectDetails lmsProjectDetails : findAll()) {
			remove(lmsProjectDetails);
		}
	}

	/**
	 * Returns the number of l m s project detailses.
	 *
	 * @return the number of l m s project detailses
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

				Query q = session.createQuery(_SQL_COUNT_LMSPROJECTDETAILS);

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
	 * Initializes the l m s project details persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSProjectDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSProjectDetails>> listenersList = new ArrayList<ModelListener<LMSProjectDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSProjectDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSProjectDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSPROJECTDETAILS = "SELECT lmsProjectDetails FROM LMSProjectDetails lmsProjectDetails";
	private static final String _SQL_SELECT_LMSPROJECTDETAILS_WHERE = "SELECT lmsProjectDetails FROM LMSProjectDetails lmsProjectDetails WHERE ";
	private static final String _SQL_COUNT_LMSPROJECTDETAILS = "SELECT COUNT(lmsProjectDetails) FROM LMSProjectDetails lmsProjectDetails";
	private static final String _SQL_COUNT_LMSPROJECTDETAILS_WHERE = "SELECT COUNT(lmsProjectDetails) FROM LMSProjectDetails lmsProjectDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsProjectDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSProjectDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSProjectDetails exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSProjectDetailsPersistenceImpl.class);
	private static LMSProjectDetails _nullLMSProjectDetails = new LMSProjectDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSProjectDetails> toCacheModel() {
				return _nullLMSProjectDetailsCacheModel;
			}
		};

	private static CacheModel<LMSProjectDetails> _nullLMSProjectDetailsCacheModel =
		new CacheModel<LMSProjectDetails>() {
			@Override
			public LMSProjectDetails toEntityModel() {
				return _nullLMSProjectDetails;
			}
		};
}