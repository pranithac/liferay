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

import com.trianz.lms.NoSuchEmployeeDetailsException;
import com.trianz.lms.model.LMSEmployeeDetails;
import com.trianz.lms.model.impl.LMSEmployeeDetailsImpl;
import com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSEmployeeDetailsPersistence
 * @see LMSEmployeeDetailsUtil
 * @generated
 */
public class LMSEmployeeDetailsPersistenceImpl extends BasePersistenceImpl<LMSEmployeeDetails>
	implements LMSEmployeeDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSEmployeeDetailsUtil} to access the l m s employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSEmployeeDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILID = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemailId", new String[] { String.class.getName() },
			LMSEmployeeDetailsModelImpl.EMPLOYEEEMAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILID = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailId",
			new String[] { String.class.getName() });

	/**
	 * Returns the l m s employee details where EmployeeEmailID = &#63; or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	 *
	 * @param EmployeeEmailID the employee email i d
	 * @return the matching l m s employee details
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails findByemailId(String EmployeeEmailID)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = fetchByemailId(EmployeeEmailID);

		if (lmsEmployeeDetails == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EmployeeEmailID=");
			msg.append(EmployeeEmailID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmployeeDetailsException(msg.toString());
		}

		return lmsEmployeeDetails;
	}

	/**
	 * Returns the l m s employee details where EmployeeEmailID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EmployeeEmailID the employee email i d
	 * @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchByemailId(String EmployeeEmailID)
		throws SystemException {
		return fetchByemailId(EmployeeEmailID, true);
	}

	/**
	 * Returns the l m s employee details where EmployeeEmailID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EmployeeEmailID the employee email i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchByemailId(String EmployeeEmailID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { EmployeeEmailID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILID,
					finderArgs, this);
		}

		if (result instanceof LMSEmployeeDetails) {
			LMSEmployeeDetails lmsEmployeeDetails = (LMSEmployeeDetails)result;

			if (!Validator.equals(EmployeeEmailID,
						lmsEmployeeDetails.getEmployeeEmailID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSEMPLOYEEDETAILS_WHERE);

			boolean bindEmployeeEmailID = false;

			if (EmployeeEmailID == null) {
				query.append(_FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_1);
			}
			else if (EmployeeEmailID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_3);
			}
			else {
				bindEmployeeEmailID = true;

				query.append(_FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmployeeEmailID) {
					qPos.add(EmployeeEmailID);
				}

				List<LMSEmployeeDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSEmployeeDetailsPersistenceImpl.fetchByemailId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSEmployeeDetails lmsEmployeeDetails = list.get(0);

					result = lmsEmployeeDetails;

					cacheResult(lmsEmployeeDetails);

					if ((lmsEmployeeDetails.getEmployeeEmailID() == null) ||
							!lmsEmployeeDetails.getEmployeeEmailID()
												   .equals(EmployeeEmailID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID,
							finderArgs, lmsEmployeeDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILID,
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
			return (LMSEmployeeDetails)result;
		}
	}

	/**
	 * Removes the l m s employee details where EmployeeEmailID = &#63; from the database.
	 *
	 * @param EmployeeEmailID the employee email i d
	 * @return the l m s employee details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails removeByemailId(String EmployeeEmailID)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = findByemailId(EmployeeEmailID);

		return remove(lmsEmployeeDetails);
	}

	/**
	 * Returns the number of l m s employee detailses where EmployeeEmailID = &#63;.
	 *
	 * @param EmployeeEmailID the employee email i d
	 * @return the number of matching l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemailId(String EmployeeEmailID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILID;

		Object[] finderArgs = new Object[] { EmployeeEmailID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSEMPLOYEEDETAILS_WHERE);

			boolean bindEmployeeEmailID = false;

			if (EmployeeEmailID == null) {
				query.append(_FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_1);
			}
			else if (EmployeeEmailID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_3);
			}
			else {
				bindEmployeeEmailID = true;

				query.append(_FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmployeeEmailID) {
					qPos.add(EmployeeEmailID);
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

	private static final String _FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_1 = "lmsEmployeeDetails.EmployeeEmailID IS NULL";
	private static final String _FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_2 = "lmsEmployeeDetails.EmployeeEmailID = ?";
	private static final String _FINDER_COLUMN_EMAILID_EMPLOYEEEMAILID_3 = "(lmsEmployeeDetails.EmployeeEmailID IS NULL OR lmsEmployeeDetails.EmployeeEmailID = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPERVISOREMAIL =
		new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysupervisorEmail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPERVISOREMAIL =
		new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysupervisorEmail",
			new String[] { String.class.getName() },
			LMSEmployeeDetailsModelImpl.SUPERVISOREMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUPERVISOREMAIL = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysupervisorEmail", new String[] { String.class.getName() });

	/**
	 * Returns all the l m s employee detailses where SupervisorEmail = &#63;.
	 *
	 * @param SupervisorEmail the supervisor email
	 * @return the matching l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSEmployeeDetails> findBysupervisorEmail(
		String SupervisorEmail) throws SystemException {
		return findBysupervisorEmail(SupervisorEmail, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s employee detailses where SupervisorEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param SupervisorEmail the supervisor email
	 * @param start the lower bound of the range of l m s employee detailses
	 * @param end the upper bound of the range of l m s employee detailses (not inclusive)
	 * @return the range of matching l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSEmployeeDetails> findBysupervisorEmail(
		String SupervisorEmail, int start, int end) throws SystemException {
		return findBysupervisorEmail(SupervisorEmail, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s employee detailses where SupervisorEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param SupervisorEmail the supervisor email
	 * @param start the lower bound of the range of l m s employee detailses
	 * @param end the upper bound of the range of l m s employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSEmployeeDetails> findBysupervisorEmail(
		String SupervisorEmail, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPERVISOREMAIL;
			finderArgs = new Object[] { SupervisorEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPERVISOREMAIL;
			finderArgs = new Object[] {
					SupervisorEmail,
					
					start, end, orderByComparator
				};
		}

		List<LMSEmployeeDetails> list = (List<LMSEmployeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSEmployeeDetails lmsEmployeeDetails : list) {
				if (!Validator.equals(SupervisorEmail,
							lmsEmployeeDetails.getSupervisorEmail())) {
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

			query.append(_SQL_SELECT_LMSEMPLOYEEDETAILS_WHERE);

			boolean bindSupervisorEmail = false;

			if (SupervisorEmail == null) {
				query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_1);
			}
			else if (SupervisorEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_3);
			}
			else {
				bindSupervisorEmail = true;

				query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSEmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSupervisorEmail) {
					qPos.add(SupervisorEmail);
				}

				if (!pagination) {
					list = (List<LMSEmployeeDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSEmployeeDetails>(list);
				}
				else {
					list = (List<LMSEmployeeDetails>)QueryUtil.list(q,
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
	 * Returns the first l m s employee details in the ordered set where SupervisorEmail = &#63;.
	 *
	 * @param SupervisorEmail the supervisor email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s employee details
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails findBysupervisorEmail_First(
		String SupervisorEmail, OrderByComparator orderByComparator)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = fetchBysupervisorEmail_First(SupervisorEmail,
				orderByComparator);

		if (lmsEmployeeDetails != null) {
			return lmsEmployeeDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("SupervisorEmail=");
		msg.append(SupervisorEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeDetailsException(msg.toString());
	}

	/**
	 * Returns the first l m s employee details in the ordered set where SupervisorEmail = &#63;.
	 *
	 * @param SupervisorEmail the supervisor email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchBysupervisorEmail_First(
		String SupervisorEmail, OrderByComparator orderByComparator)
		throws SystemException {
		List<LMSEmployeeDetails> list = findBysupervisorEmail(SupervisorEmail,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s employee details in the ordered set where SupervisorEmail = &#63;.
	 *
	 * @param SupervisorEmail the supervisor email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s employee details
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails findBysupervisorEmail_Last(
		String SupervisorEmail, OrderByComparator orderByComparator)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = fetchBysupervisorEmail_Last(SupervisorEmail,
				orderByComparator);

		if (lmsEmployeeDetails != null) {
			return lmsEmployeeDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("SupervisorEmail=");
		msg.append(SupervisorEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeDetailsException(msg.toString());
	}

	/**
	 * Returns the last l m s employee details in the ordered set where SupervisorEmail = &#63;.
	 *
	 * @param SupervisorEmail the supervisor email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchBysupervisorEmail_Last(
		String SupervisorEmail, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBysupervisorEmail(SupervisorEmail);

		if (count == 0) {
			return null;
		}

		List<LMSEmployeeDetails> list = findBysupervisorEmail(SupervisorEmail,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s employee detailses before and after the current l m s employee details in the ordered set where SupervisorEmail = &#63;.
	 *
	 * @param EmployeeId the primary key of the current l m s employee details
	 * @param SupervisorEmail the supervisor email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s employee details
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails[] findBysupervisorEmail_PrevAndNext(
		int EmployeeId, String SupervisorEmail,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = findByPrimaryKey(EmployeeId);

		Session session = null;

		try {
			session = openSession();

			LMSEmployeeDetails[] array = new LMSEmployeeDetailsImpl[3];

			array[0] = getBysupervisorEmail_PrevAndNext(session,
					lmsEmployeeDetails, SupervisorEmail, orderByComparator, true);

			array[1] = lmsEmployeeDetails;

			array[2] = getBysupervisorEmail_PrevAndNext(session,
					lmsEmployeeDetails, SupervisorEmail, orderByComparator,
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

	protected LMSEmployeeDetails getBysupervisorEmail_PrevAndNext(
		Session session, LMSEmployeeDetails lmsEmployeeDetails,
		String SupervisorEmail, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSEMPLOYEEDETAILS_WHERE);

		boolean bindSupervisorEmail = false;

		if (SupervisorEmail == null) {
			query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_1);
		}
		else if (SupervisorEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_3);
		}
		else {
			bindSupervisorEmail = true;

			query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_2);
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
			query.append(LMSEmployeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSupervisorEmail) {
			qPos.add(SupervisorEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsEmployeeDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSEmployeeDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s employee detailses where SupervisorEmail = &#63; from the database.
	 *
	 * @param SupervisorEmail the supervisor email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysupervisorEmail(String SupervisorEmail)
		throws SystemException {
		for (LMSEmployeeDetails lmsEmployeeDetails : findBysupervisorEmail(
				SupervisorEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsEmployeeDetails);
		}
	}

	/**
	 * Returns the number of l m s employee detailses where SupervisorEmail = &#63;.
	 *
	 * @param SupervisorEmail the supervisor email
	 * @return the number of matching l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysupervisorEmail(String SupervisorEmail)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUPERVISOREMAIL;

		Object[] finderArgs = new Object[] { SupervisorEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSEMPLOYEEDETAILS_WHERE);

			boolean bindSupervisorEmail = false;

			if (SupervisorEmail == null) {
				query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_1);
			}
			else if (SupervisorEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_3);
			}
			else {
				bindSupervisorEmail = true;

				query.append(_FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSupervisorEmail) {
					qPos.add(SupervisorEmail);
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

	private static final String _FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_1 =
		"lmsEmployeeDetails.SupervisorEmail IS NULL";
	private static final String _FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_2 =
		"lmsEmployeeDetails.SupervisorEmail = ?";
	private static final String _FINDER_COLUMN_SUPERVISOREMAIL_SUPERVISOREMAIL_3 =
		"(lmsEmployeeDetails.SupervisorEmail IS NULL OR lmsEmployeeDetails.SupervisorEmail = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEENAME = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmployeeName", new String[] { String.class.getName() },
			LMSEmployeeDetailsModelImpl.EMPLOYEENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEENAME = new FinderPath(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeName",
			new String[] { String.class.getName() });

	/**
	 * Returns the l m s employee details where EmployeeName = &#63; or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	 *
	 * @param EmployeeName the employee name
	 * @return the matching l m s employee details
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails findByEmployeeName(String EmployeeName)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = fetchByEmployeeName(EmployeeName);

		if (lmsEmployeeDetails == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EmployeeName=");
			msg.append(EmployeeName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmployeeDetailsException(msg.toString());
		}

		return lmsEmployeeDetails;
	}

	/**
	 * Returns the l m s employee details where EmployeeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EmployeeName the employee name
	 * @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchByEmployeeName(String EmployeeName)
		throws SystemException {
		return fetchByEmployeeName(EmployeeName, true);
	}

	/**
	 * Returns the l m s employee details where EmployeeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EmployeeName the employee name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s employee details, or <code>null</code> if a matching l m s employee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchByEmployeeName(String EmployeeName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { EmployeeName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME,
					finderArgs, this);
		}

		if (result instanceof LMSEmployeeDetails) {
			LMSEmployeeDetails lmsEmployeeDetails = (LMSEmployeeDetails)result;

			if (!Validator.equals(EmployeeName,
						lmsEmployeeDetails.getEmployeeName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSEMPLOYEEDETAILS_WHERE);

			boolean bindEmployeeName = false;

			if (EmployeeName == null) {
				query.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_1);
			}
			else if (EmployeeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
			}
			else {
				bindEmployeeName = true;

				query.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmployeeName) {
					qPos.add(EmployeeName);
				}

				List<LMSEmployeeDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSEmployeeDetailsPersistenceImpl.fetchByEmployeeName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSEmployeeDetails lmsEmployeeDetails = list.get(0);

					result = lmsEmployeeDetails;

					cacheResult(lmsEmployeeDetails);

					if ((lmsEmployeeDetails.getEmployeeName() == null) ||
							!lmsEmployeeDetails.getEmployeeName()
												   .equals(EmployeeName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME,
							finderArgs, lmsEmployeeDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME,
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
			return (LMSEmployeeDetails)result;
		}
	}

	/**
	 * Removes the l m s employee details where EmployeeName = &#63; from the database.
	 *
	 * @param EmployeeName the employee name
	 * @return the l m s employee details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails removeByEmployeeName(String EmployeeName)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = findByEmployeeName(EmployeeName);

		return remove(lmsEmployeeDetails);
	}

	/**
	 * Returns the number of l m s employee detailses where EmployeeName = &#63;.
	 *
	 * @param EmployeeName the employee name
	 * @return the number of matching l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployeeName(String EmployeeName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEENAME;

		Object[] finderArgs = new Object[] { EmployeeName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSEMPLOYEEDETAILS_WHERE);

			boolean bindEmployeeName = false;

			if (EmployeeName == null) {
				query.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_1);
			}
			else if (EmployeeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
			}
			else {
				bindEmployeeName = true;

				query.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmployeeName) {
					qPos.add(EmployeeName);
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

	private static final String _FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_1 = "lmsEmployeeDetails.EmployeeName IS NULL";
	private static final String _FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2 = "lmsEmployeeDetails.EmployeeName = ?";
	private static final String _FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3 = "(lmsEmployeeDetails.EmployeeName IS NULL OR lmsEmployeeDetails.EmployeeName = '')";

	public LMSEmployeeDetailsPersistenceImpl() {
		setModelClass(LMSEmployeeDetails.class);
	}

	/**
	 * Caches the l m s employee details in the entity cache if it is enabled.
	 *
	 * @param lmsEmployeeDetails the l m s employee details
	 */
	@Override
	public void cacheResult(LMSEmployeeDetails lmsEmployeeDetails) {
		EntityCacheUtil.putResult(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class, lmsEmployeeDetails.getPrimaryKey(),
			lmsEmployeeDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID,
			new Object[] { lmsEmployeeDetails.getEmployeeEmailID() },
			lmsEmployeeDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME,
			new Object[] { lmsEmployeeDetails.getEmployeeName() },
			lmsEmployeeDetails);

		lmsEmployeeDetails.resetOriginalValues();
	}

	/**
	 * Caches the l m s employee detailses in the entity cache if it is enabled.
	 *
	 * @param lmsEmployeeDetailses the l m s employee detailses
	 */
	@Override
	public void cacheResult(List<LMSEmployeeDetails> lmsEmployeeDetailses) {
		for (LMSEmployeeDetails lmsEmployeeDetails : lmsEmployeeDetailses) {
			if (EntityCacheUtil.getResult(
						LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LMSEmployeeDetailsImpl.class,
						lmsEmployeeDetails.getPrimaryKey()) == null) {
				cacheResult(lmsEmployeeDetails);
			}
			else {
				lmsEmployeeDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s employee detailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSEmployeeDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSEmployeeDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s employee details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSEmployeeDetails lmsEmployeeDetails) {
		EntityCacheUtil.removeResult(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class, lmsEmployeeDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsEmployeeDetails);
	}

	@Override
	public void clearCache(List<LMSEmployeeDetails> lmsEmployeeDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSEmployeeDetails lmsEmployeeDetails : lmsEmployeeDetailses) {
			EntityCacheUtil.removeResult(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LMSEmployeeDetailsImpl.class, lmsEmployeeDetails.getPrimaryKey());

			clearUniqueFindersCache(lmsEmployeeDetails);
		}
	}

	protected void cacheUniqueFindersCache(
		LMSEmployeeDetails lmsEmployeeDetails) {
		if (lmsEmployeeDetails.isNew()) {
			Object[] args = new Object[] { lmsEmployeeDetails.getEmployeeEmailID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID, args,
				lmsEmployeeDetails);

			args = new Object[] { lmsEmployeeDetails.getEmployeeName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEENAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME, args,
				lmsEmployeeDetails);
		}
		else {
			LMSEmployeeDetailsModelImpl lmsEmployeeDetailsModelImpl = (LMSEmployeeDetailsModelImpl)lmsEmployeeDetails;

			if ((lmsEmployeeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsEmployeeDetails.getEmployeeEmailID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID, args,
					lmsEmployeeDetails);
			}

			if ((lmsEmployeeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPLOYEENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsEmployeeDetails.getEmployeeName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEENAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME,
					args, lmsEmployeeDetails);
			}
		}
	}

	protected void clearUniqueFindersCache(
		LMSEmployeeDetails lmsEmployeeDetails) {
		LMSEmployeeDetailsModelImpl lmsEmployeeDetailsModelImpl = (LMSEmployeeDetailsModelImpl)lmsEmployeeDetails;

		Object[] args = new Object[] { lmsEmployeeDetails.getEmployeeEmailID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILID, args);

		if ((lmsEmployeeDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILID.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsEmployeeDetailsModelImpl.getOriginalEmployeeEmailID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILID, args);
		}

		args = new Object[] { lmsEmployeeDetails.getEmployeeName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEENAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME, args);

		if ((lmsEmployeeDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEENAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					lmsEmployeeDetailsModelImpl.getOriginalEmployeeName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEENAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEENAME, args);
		}
	}

	/**
	 * Creates a new l m s employee details with the primary key. Does not add the l m s employee details to the database.
	 *
	 * @param EmployeeId the primary key for the new l m s employee details
	 * @return the new l m s employee details
	 */
	@Override
	public LMSEmployeeDetails create(int EmployeeId) {
		LMSEmployeeDetails lmsEmployeeDetails = new LMSEmployeeDetailsImpl();

		lmsEmployeeDetails.setNew(true);
		lmsEmployeeDetails.setPrimaryKey(EmployeeId);

		return lmsEmployeeDetails;
	}

	/**
	 * Removes the l m s employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param EmployeeId the primary key of the l m s employee details
	 * @return the l m s employee details that was removed
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails remove(int EmployeeId)
		throws NoSuchEmployeeDetailsException, SystemException {
		return remove((Serializable)EmployeeId);
	}

	/**
	 * Removes the l m s employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s employee details
	 * @return the l m s employee details that was removed
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails remove(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSEmployeeDetails lmsEmployeeDetails = (LMSEmployeeDetails)session.get(LMSEmployeeDetailsImpl.class,
					primaryKey);

			if (lmsEmployeeDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsEmployeeDetails);
		}
		catch (NoSuchEmployeeDetailsException nsee) {
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
	protected LMSEmployeeDetails removeImpl(
		LMSEmployeeDetails lmsEmployeeDetails) throws SystemException {
		lmsEmployeeDetails = toUnwrappedModel(lmsEmployeeDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsEmployeeDetails)) {
				lmsEmployeeDetails = (LMSEmployeeDetails)session.get(LMSEmployeeDetailsImpl.class,
						lmsEmployeeDetails.getPrimaryKeyObj());
			}

			if (lmsEmployeeDetails != null) {
				session.delete(lmsEmployeeDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsEmployeeDetails != null) {
			clearCache(lmsEmployeeDetails);
		}

		return lmsEmployeeDetails;
	}

	@Override
	public LMSEmployeeDetails updateImpl(
		com.trianz.lms.model.LMSEmployeeDetails lmsEmployeeDetails)
		throws SystemException {
		lmsEmployeeDetails = toUnwrappedModel(lmsEmployeeDetails);

		boolean isNew = lmsEmployeeDetails.isNew();

		LMSEmployeeDetailsModelImpl lmsEmployeeDetailsModelImpl = (LMSEmployeeDetailsModelImpl)lmsEmployeeDetails;

		Session session = null;

		try {
			session = openSession();

			if (lmsEmployeeDetails.isNew()) {
				session.save(lmsEmployeeDetails);

				lmsEmployeeDetails.setNew(false);
			}
			else {
				session.merge(lmsEmployeeDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSEmployeeDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsEmployeeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPERVISOREMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsEmployeeDetailsModelImpl.getOriginalSupervisorEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUPERVISOREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPERVISOREMAIL,
					args);

				args = new Object[] {
						lmsEmployeeDetailsModelImpl.getSupervisorEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUPERVISOREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPERVISOREMAIL,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LMSEmployeeDetailsImpl.class, lmsEmployeeDetails.getPrimaryKey(),
			lmsEmployeeDetails);

		clearUniqueFindersCache(lmsEmployeeDetails);
		cacheUniqueFindersCache(lmsEmployeeDetails);

		return lmsEmployeeDetails;
	}

	protected LMSEmployeeDetails toUnwrappedModel(
		LMSEmployeeDetails lmsEmployeeDetails) {
		if (lmsEmployeeDetails instanceof LMSEmployeeDetailsImpl) {
			return lmsEmployeeDetails;
		}

		LMSEmployeeDetailsImpl lmsEmployeeDetailsImpl = new LMSEmployeeDetailsImpl();

		lmsEmployeeDetailsImpl.setNew(lmsEmployeeDetails.isNew());
		lmsEmployeeDetailsImpl.setPrimaryKey(lmsEmployeeDetails.getPrimaryKey());

		lmsEmployeeDetailsImpl.setEmployeeId(lmsEmployeeDetails.getEmployeeId());
		lmsEmployeeDetailsImpl.setEmployeeName(lmsEmployeeDetails.getEmployeeName());
		lmsEmployeeDetailsImpl.setEmployeeEmailID(lmsEmployeeDetails.getEmployeeEmailID());
		lmsEmployeeDetailsImpl.setJoiningDate(lmsEmployeeDetails.getJoiningDate());
		lmsEmployeeDetailsImpl.setSupervisorId(lmsEmployeeDetails.getSupervisorId());
		lmsEmployeeDetailsImpl.setSupervisorName(lmsEmployeeDetails.getSupervisorName());
		lmsEmployeeDetailsImpl.setSupervisorEmail(lmsEmployeeDetails.getSupervisorEmail());
		lmsEmployeeDetailsImpl.setLocation(lmsEmployeeDetails.getLocation());
		lmsEmployeeDetailsImpl.setRegion(lmsEmployeeDetails.getRegion());

		return lmsEmployeeDetailsImpl;
	}

	/**
	 * Returns the l m s employee details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s employee details
	 * @return the l m s employee details
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException, SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = fetchByPrimaryKey(primaryKey);

		if (lmsEmployeeDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsEmployeeDetails;
	}

	/**
	 * Returns the l m s employee details with the primary key or throws a {@link com.trianz.lms.NoSuchEmployeeDetailsException} if it could not be found.
	 *
	 * @param EmployeeId the primary key of the l m s employee details
	 * @return the l m s employee details
	 * @throws com.trianz.lms.NoSuchEmployeeDetailsException if a l m s employee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails findByPrimaryKey(int EmployeeId)
		throws NoSuchEmployeeDetailsException, SystemException {
		return findByPrimaryKey((Serializable)EmployeeId);
	}

	/**
	 * Returns the l m s employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s employee details
	 * @return the l m s employee details, or <code>null</code> if a l m s employee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSEmployeeDetails lmsEmployeeDetails = (LMSEmployeeDetails)EntityCacheUtil.getResult(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LMSEmployeeDetailsImpl.class, primaryKey);

		if (lmsEmployeeDetails == _nullLMSEmployeeDetails) {
			return null;
		}

		if (lmsEmployeeDetails == null) {
			Session session = null;

			try {
				session = openSession();

				lmsEmployeeDetails = (LMSEmployeeDetails)session.get(LMSEmployeeDetailsImpl.class,
						primaryKey);

				if (lmsEmployeeDetails != null) {
					cacheResult(lmsEmployeeDetails);
				}
				else {
					EntityCacheUtil.putResult(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LMSEmployeeDetailsImpl.class, primaryKey,
						_nullLMSEmployeeDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSEmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
					LMSEmployeeDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsEmployeeDetails;
	}

	/**
	 * Returns the l m s employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param EmployeeId the primary key of the l m s employee details
	 * @return the l m s employee details, or <code>null</code> if a l m s employee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSEmployeeDetails fetchByPrimaryKey(int EmployeeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)EmployeeId);
	}

	/**
	 * Returns all the l m s employee detailses.
	 *
	 * @return the l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSEmployeeDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s employee detailses
	 * @param end the upper bound of the range of l m s employee detailses (not inclusive)
	 * @return the range of l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSEmployeeDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSEmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s employee detailses
	 * @param end the upper bound of the range of l m s employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s employee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSEmployeeDetails> findAll(int start, int end,
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

		List<LMSEmployeeDetails> list = (List<LMSEmployeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSEMPLOYEEDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSEMPLOYEEDETAILS;

				if (pagination) {
					sql = sql.concat(LMSEmployeeDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSEmployeeDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSEmployeeDetails>(list);
				}
				else {
					list = (List<LMSEmployeeDetails>)QueryUtil.list(q,
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
	 * Removes all the l m s employee detailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSEmployeeDetails lmsEmployeeDetails : findAll()) {
			remove(lmsEmployeeDetails);
		}
	}

	/**
	 * Returns the number of l m s employee detailses.
	 *
	 * @return the number of l m s employee detailses
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

				Query q = session.createQuery(_SQL_COUNT_LMSEMPLOYEEDETAILS);

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
	 * Initializes the l m s employee details persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSEmployeeDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSEmployeeDetails>> listenersList = new ArrayList<ModelListener<LMSEmployeeDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSEmployeeDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSEmployeeDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSEMPLOYEEDETAILS = "SELECT lmsEmployeeDetails FROM LMSEmployeeDetails lmsEmployeeDetails";
	private static final String _SQL_SELECT_LMSEMPLOYEEDETAILS_WHERE = "SELECT lmsEmployeeDetails FROM LMSEmployeeDetails lmsEmployeeDetails WHERE ";
	private static final String _SQL_COUNT_LMSEMPLOYEEDETAILS = "SELECT COUNT(lmsEmployeeDetails) FROM LMSEmployeeDetails lmsEmployeeDetails";
	private static final String _SQL_COUNT_LMSEMPLOYEEDETAILS_WHERE = "SELECT COUNT(lmsEmployeeDetails) FROM LMSEmployeeDetails lmsEmployeeDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsEmployeeDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSEmployeeDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSEmployeeDetails exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSEmployeeDetailsPersistenceImpl.class);
	private static LMSEmployeeDetails _nullLMSEmployeeDetails = new LMSEmployeeDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSEmployeeDetails> toCacheModel() {
				return _nullLMSEmployeeDetailsCacheModel;
			}
		};

	private static CacheModel<LMSEmployeeDetails> _nullLMSEmployeeDetailsCacheModel =
		new CacheModel<LMSEmployeeDetails>() {
			@Override
			public LMSEmployeeDetails toEntityModel() {
				return _nullLMSEmployeeDetails;
			}
		};
}