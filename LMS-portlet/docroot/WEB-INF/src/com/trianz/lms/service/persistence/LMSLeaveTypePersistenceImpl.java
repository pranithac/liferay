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

import com.trianz.lms.NoSuchLeaveTypeException;
import com.trianz.lms.model.LMSLeaveType;
import com.trianz.lms.model.impl.LMSLeaveTypeImpl;
import com.trianz.lms.model.impl.LMSLeaveTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s leave type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeaveTypePersistence
 * @see LMSLeaveTypeUtil
 * @generated
 */
public class LMSLeaveTypePersistenceImpl extends BasePersistenceImpl<LMSLeaveType>
	implements LMSLeaveTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSLeaveTypeUtil} to access the l m s leave type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSLeaveTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, LMSLeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, LMSLeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVETYPECODE = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, LMSLeaveTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveTypeCode",
			new String[] { Integer.class.getName() },
			LMSLeaveTypeModelImpl.LEAVETYPECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPECODE = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeCode",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the l m s leave type where LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the matching l m s leave type
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType findByLeaveTypeCode(int LeaveTypeCode)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = fetchByLeaveTypeCode(LeaveTypeCode);

		if (lmsLeaveType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("LeaveTypeCode=");
			msg.append(LeaveTypeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveTypeException(msg.toString());
		}

		return lmsLeaveType;
	}

	/**
	 * Returns the l m s leave type where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByLeaveTypeCode(int LeaveTypeCode)
		throws SystemException {
		return fetchByLeaveTypeCode(LeaveTypeCode, true);
	}

	/**
	 * Returns the l m s leave type where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByLeaveTypeCode(int LeaveTypeCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { LeaveTypeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
					finderArgs, this);
		}

		if (result instanceof LMSLeaveType) {
			LMSLeaveType lmsLeaveType = (LMSLeaveType)result;

			if ((LeaveTypeCode != lmsLeaveType.getLeaveTypeCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSLEAVETYPE_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPECODE_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(LeaveTypeCode);

				List<LMSLeaveType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSLeaveTypePersistenceImpl.fetchByLeaveTypeCode(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSLeaveType lmsLeaveType = list.get(0);

					result = lmsLeaveType;

					cacheResult(lmsLeaveType);

					if ((lmsLeaveType.getLeaveTypeCode() != LeaveTypeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
							finderArgs, lmsLeaveType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
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
			return (LMSLeaveType)result;
		}
	}

	/**
	 * Removes the l m s leave type where LeaveTypeCode = &#63; from the database.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the l m s leave type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType removeByLeaveTypeCode(int LeaveTypeCode)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = findByLeaveTypeCode(LeaveTypeCode);

		return remove(lmsLeaveType);
	}

	/**
	 * Returns the number of l m s leave types where LeaveTypeCode = &#63;.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the number of matching l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveTypeCode(int LeaveTypeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVETYPECODE;

		Object[] finderArgs = new Object[] { LeaveTypeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSLEAVETYPE_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPECODE_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(LeaveTypeCode);

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

	private static final String _FINDER_COLUMN_LEAVETYPECODE_LEAVETYPECODE_2 = "lmsLeaveType.LeaveTypeCode = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVETYPENAME = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, LMSLeaveTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveTypeName",
			new String[] { String.class.getName() },
			LMSLeaveTypeModelImpl.LEAVETYPENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPENAME = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeName",
			new String[] { String.class.getName() });

	/**
	 * Returns the l m s leave type where LeaveTypeName = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	 *
	 * @param LeaveTypeName the leave type name
	 * @return the matching l m s leave type
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType findByLeaveTypeName(String LeaveTypeName)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = fetchByLeaveTypeName(LeaveTypeName);

		if (lmsLeaveType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("LeaveTypeName=");
			msg.append(LeaveTypeName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveTypeException(msg.toString());
		}

		return lmsLeaveType;
	}

	/**
	 * Returns the l m s leave type where LeaveTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeaveTypeName the leave type name
	 * @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByLeaveTypeName(String LeaveTypeName)
		throws SystemException {
		return fetchByLeaveTypeName(LeaveTypeName, true);
	}

	/**
	 * Returns the l m s leave type where LeaveTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeaveTypeName the leave type name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByLeaveTypeName(String LeaveTypeName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { LeaveTypeName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME,
					finderArgs, this);
		}

		if (result instanceof LMSLeaveType) {
			LMSLeaveType lmsLeaveType = (LMSLeaveType)result;

			if (!Validator.equals(LeaveTypeName, lmsLeaveType.getLeaveTypeName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSLEAVETYPE_WHERE);

			boolean bindLeaveTypeName = false;

			if (LeaveTypeName == null) {
				query.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_1);
			}
			else if (LeaveTypeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_3);
			}
			else {
				bindLeaveTypeName = true;

				query.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveTypeName) {
					qPos.add(LeaveTypeName);
				}

				List<LMSLeaveType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSLeaveTypePersistenceImpl.fetchByLeaveTypeName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSLeaveType lmsLeaveType = list.get(0);

					result = lmsLeaveType;

					cacheResult(lmsLeaveType);

					if ((lmsLeaveType.getLeaveTypeName() == null) ||
							!lmsLeaveType.getLeaveTypeName()
											 .equals(LeaveTypeName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME,
							finderArgs, lmsLeaveType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME,
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
			return (LMSLeaveType)result;
		}
	}

	/**
	 * Removes the l m s leave type where LeaveTypeName = &#63; from the database.
	 *
	 * @param LeaveTypeName the leave type name
	 * @return the l m s leave type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType removeByLeaveTypeName(String LeaveTypeName)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = findByLeaveTypeName(LeaveTypeName);

		return remove(lmsLeaveType);
	}

	/**
	 * Returns the number of l m s leave types where LeaveTypeName = &#63;.
	 *
	 * @param LeaveTypeName the leave type name
	 * @return the number of matching l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveTypeName(String LeaveTypeName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVETYPENAME;

		Object[] finderArgs = new Object[] { LeaveTypeName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSLEAVETYPE_WHERE);

			boolean bindLeaveTypeName = false;

			if (LeaveTypeName == null) {
				query.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_1);
			}
			else if (LeaveTypeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_3);
			}
			else {
				bindLeaveTypeName = true;

				query.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveTypeName) {
					qPos.add(LeaveTypeName);
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

	private static final String _FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_1 = "lmsLeaveType.LeaveTypeName IS NULL";
	private static final String _FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_2 = "lmsLeaveType.LeaveTypeName = ?";
	private static final String _FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_3 = "(lmsLeaveType.LeaveTypeName IS NULL OR lmsLeaveType.LeaveTypeName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRIESAPPLICABLE =
		new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, LMSLeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountriesApplicable",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRIESAPPLICABLE =
		new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, LMSLeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountriesApplicable",
			new String[] { String.class.getName() },
			LMSLeaveTypeModelImpl.COUNTRIESAPPLICABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRIESAPPLICABLE = new FinderPath(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountriesApplicable",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l m s leave types where CountriesApplicable = &#63;.
	 *
	 * @param CountriesApplicable the countries applicable
	 * @return the matching l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveType> findByCountriesApplicable(
		String CountriesApplicable) throws SystemException {
		return findByCountriesApplicable(CountriesApplicable,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s leave types where CountriesApplicable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CountriesApplicable the countries applicable
	 * @param start the lower bound of the range of l m s leave types
	 * @param end the upper bound of the range of l m s leave types (not inclusive)
	 * @return the range of matching l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveType> findByCountriesApplicable(
		String CountriesApplicable, int start, int end)
		throws SystemException {
		return findByCountriesApplicable(CountriesApplicable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s leave types where CountriesApplicable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CountriesApplicable the countries applicable
	 * @param start the lower bound of the range of l m s leave types
	 * @param end the upper bound of the range of l m s leave types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveType> findByCountriesApplicable(
		String CountriesApplicable, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRIESAPPLICABLE;
			finderArgs = new Object[] { CountriesApplicable };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRIESAPPLICABLE;
			finderArgs = new Object[] {
					CountriesApplicable,
					
					start, end, orderByComparator
				};
		}

		List<LMSLeaveType> list = (List<LMSLeaveType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSLeaveType lmsLeaveType : list) {
				if (!Validator.equals(CountriesApplicable,
							lmsLeaveType.getCountriesApplicable())) {
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

			query.append(_SQL_SELECT_LMSLEAVETYPE_WHERE);

			boolean bindCountriesApplicable = false;

			if (CountriesApplicable == null) {
				query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_1);
			}
			else if (CountriesApplicable.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_3);
			}
			else {
				bindCountriesApplicable = true;

				query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSLeaveTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountriesApplicable) {
					qPos.add(CountriesApplicable);
				}

				if (!pagination) {
					list = (List<LMSLeaveType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeaveType>(list);
				}
				else {
					list = (List<LMSLeaveType>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first l m s leave type in the ordered set where CountriesApplicable = &#63;.
	 *
	 * @param CountriesApplicable the countries applicable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave type
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType findByCountriesApplicable_First(
		String CountriesApplicable, OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = fetchByCountriesApplicable_First(CountriesApplicable,
				orderByComparator);

		if (lmsLeaveType != null) {
			return lmsLeaveType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CountriesApplicable=");
		msg.append(CountriesApplicable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeException(msg.toString());
	}

	/**
	 * Returns the first l m s leave type in the ordered set where CountriesApplicable = &#63;.
	 *
	 * @param CountriesApplicable the countries applicable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByCountriesApplicable_First(
		String CountriesApplicable, OrderByComparator orderByComparator)
		throws SystemException {
		List<LMSLeaveType> list = findByCountriesApplicable(CountriesApplicable,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s leave type in the ordered set where CountriesApplicable = &#63;.
	 *
	 * @param CountriesApplicable the countries applicable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave type
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType findByCountriesApplicable_Last(
		String CountriesApplicable, OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = fetchByCountriesApplicable_Last(CountriesApplicable,
				orderByComparator);

		if (lmsLeaveType != null) {
			return lmsLeaveType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CountriesApplicable=");
		msg.append(CountriesApplicable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeException(msg.toString());
	}

	/**
	 * Returns the last l m s leave type in the ordered set where CountriesApplicable = &#63;.
	 *
	 * @param CountriesApplicable the countries applicable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByCountriesApplicable_Last(
		String CountriesApplicable, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountriesApplicable(CountriesApplicable);

		if (count == 0) {
			return null;
		}

		List<LMSLeaveType> list = findByCountriesApplicable(CountriesApplicable,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s leave types before and after the current l m s leave type in the ordered set where CountriesApplicable = &#63;.
	 *
	 * @param LeaveTypeCode the primary key of the current l m s leave type
	 * @param CountriesApplicable the countries applicable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s leave type
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType[] findByCountriesApplicable_PrevAndNext(
		int LeaveTypeCode, String CountriesApplicable,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = findByPrimaryKey(LeaveTypeCode);

		Session session = null;

		try {
			session = openSession();

			LMSLeaveType[] array = new LMSLeaveTypeImpl[3];

			array[0] = getByCountriesApplicable_PrevAndNext(session,
					lmsLeaveType, CountriesApplicable, orderByComparator, true);

			array[1] = lmsLeaveType;

			array[2] = getByCountriesApplicable_PrevAndNext(session,
					lmsLeaveType, CountriesApplicable, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSLeaveType getByCountriesApplicable_PrevAndNext(
		Session session, LMSLeaveType lmsLeaveType, String CountriesApplicable,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSLEAVETYPE_WHERE);

		boolean bindCountriesApplicable = false;

		if (CountriesApplicable == null) {
			query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_1);
		}
		else if (CountriesApplicable.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_3);
		}
		else {
			bindCountriesApplicable = true;

			query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_2);
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
			query.append(LMSLeaveTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCountriesApplicable) {
			qPos.add(CountriesApplicable);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsLeaveType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSLeaveType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s leave types where CountriesApplicable = &#63; from the database.
	 *
	 * @param CountriesApplicable the countries applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountriesApplicable(String CountriesApplicable)
		throws SystemException {
		for (LMSLeaveType lmsLeaveType : findByCountriesApplicable(
				CountriesApplicable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsLeaveType);
		}
	}

	/**
	 * Returns the number of l m s leave types where CountriesApplicable = &#63;.
	 *
	 * @param CountriesApplicable the countries applicable
	 * @return the number of matching l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountriesApplicable(String CountriesApplicable)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRIESAPPLICABLE;

		Object[] finderArgs = new Object[] { CountriesApplicable };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSLEAVETYPE_WHERE);

			boolean bindCountriesApplicable = false;

			if (CountriesApplicable == null) {
				query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_1);
			}
			else if (CountriesApplicable.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_3);
			}
			else {
				bindCountriesApplicable = true;

				query.append(_FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountriesApplicable) {
					qPos.add(CountriesApplicable);
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

	private static final String _FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_1 =
		"lmsLeaveType.CountriesApplicable IS NULL";
	private static final String _FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_2 =
		"lmsLeaveType.CountriesApplicable = ?";
	private static final String _FINDER_COLUMN_COUNTRIESAPPLICABLE_COUNTRIESAPPLICABLE_3 =
		"(lmsLeaveType.CountriesApplicable IS NULL OR lmsLeaveType.CountriesApplicable = '')";

	public LMSLeaveTypePersistenceImpl() {
		setModelClass(LMSLeaveType.class);
	}

	/**
	 * Caches the l m s leave type in the entity cache if it is enabled.
	 *
	 * @param lmsLeaveType the l m s leave type
	 */
	@Override
	public void cacheResult(LMSLeaveType lmsLeaveType) {
		EntityCacheUtil.putResult(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeImpl.class, lmsLeaveType.getPrimaryKey(), lmsLeaveType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
			new Object[] { lmsLeaveType.getLeaveTypeCode() }, lmsLeaveType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME,
			new Object[] { lmsLeaveType.getLeaveTypeName() }, lmsLeaveType);

		lmsLeaveType.resetOriginalValues();
	}

	/**
	 * Caches the l m s leave types in the entity cache if it is enabled.
	 *
	 * @param lmsLeaveTypes the l m s leave types
	 */
	@Override
	public void cacheResult(List<LMSLeaveType> lmsLeaveTypes) {
		for (LMSLeaveType lmsLeaveType : lmsLeaveTypes) {
			if (EntityCacheUtil.getResult(
						LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
						LMSLeaveTypeImpl.class, lmsLeaveType.getPrimaryKey()) == null) {
				cacheResult(lmsLeaveType);
			}
			else {
				lmsLeaveType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s leave types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSLeaveTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSLeaveTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s leave type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSLeaveType lmsLeaveType) {
		EntityCacheUtil.removeResult(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeImpl.class, lmsLeaveType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsLeaveType);
	}

	@Override
	public void clearCache(List<LMSLeaveType> lmsLeaveTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSLeaveType lmsLeaveType : lmsLeaveTypes) {
			EntityCacheUtil.removeResult(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
				LMSLeaveTypeImpl.class, lmsLeaveType.getPrimaryKey());

			clearUniqueFindersCache(lmsLeaveType);
		}
	}

	protected void cacheUniqueFindersCache(LMSLeaveType lmsLeaveType) {
		if (lmsLeaveType.isNew()) {
			Object[] args = new Object[] { lmsLeaveType.getLeaveTypeCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE, args,
				lmsLeaveType);

			args = new Object[] { lmsLeaveType.getLeaveTypeName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPENAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME, args,
				lmsLeaveType);
		}
		else {
			LMSLeaveTypeModelImpl lmsLeaveTypeModelImpl = (LMSLeaveTypeModelImpl)lmsLeaveType;

			if ((lmsLeaveTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LEAVETYPECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { lmsLeaveType.getLeaveTypeCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
					args, lmsLeaveType);
			}

			if ((lmsLeaveTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LEAVETYPENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { lmsLeaveType.getLeaveTypeName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPENAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME,
					args, lmsLeaveType);
			}
		}
	}

	protected void clearUniqueFindersCache(LMSLeaveType lmsLeaveType) {
		LMSLeaveTypeModelImpl lmsLeaveTypeModelImpl = (LMSLeaveTypeModelImpl)lmsLeaveType;

		Object[] args = new Object[] { lmsLeaveType.getLeaveTypeCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE, args);

		if ((lmsLeaveTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVETYPECODE.getColumnBitmask()) != 0) {
			args = new Object[] { lmsLeaveTypeModelImpl.getOriginalLeaveTypeCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
				args);
		}

		args = new Object[] { lmsLeaveType.getLeaveTypeName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPENAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME, args);

		if ((lmsLeaveTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVETYPENAME.getColumnBitmask()) != 0) {
			args = new Object[] { lmsLeaveTypeModelImpl.getOriginalLeaveTypeName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPENAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPENAME,
				args);
		}
	}

	/**
	 * Creates a new l m s leave type with the primary key. Does not add the l m s leave type to the database.
	 *
	 * @param LeaveTypeCode the primary key for the new l m s leave type
	 * @return the new l m s leave type
	 */
	@Override
	public LMSLeaveType create(int LeaveTypeCode) {
		LMSLeaveType lmsLeaveType = new LMSLeaveTypeImpl();

		lmsLeaveType.setNew(true);
		lmsLeaveType.setPrimaryKey(LeaveTypeCode);

		return lmsLeaveType;
	}

	/**
	 * Removes the l m s leave type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LeaveTypeCode the primary key of the l m s leave type
	 * @return the l m s leave type that was removed
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType remove(int LeaveTypeCode)
		throws NoSuchLeaveTypeException, SystemException {
		return remove((Serializable)LeaveTypeCode);
	}

	/**
	 * Removes the l m s leave type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s leave type
	 * @return the l m s leave type that was removed
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType remove(Serializable primaryKey)
		throws NoSuchLeaveTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSLeaveType lmsLeaveType = (LMSLeaveType)session.get(LMSLeaveTypeImpl.class,
					primaryKey);

			if (lmsLeaveType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsLeaveType);
		}
		catch (NoSuchLeaveTypeException nsee) {
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
	protected LMSLeaveType removeImpl(LMSLeaveType lmsLeaveType)
		throws SystemException {
		lmsLeaveType = toUnwrappedModel(lmsLeaveType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsLeaveType)) {
				lmsLeaveType = (LMSLeaveType)session.get(LMSLeaveTypeImpl.class,
						lmsLeaveType.getPrimaryKeyObj());
			}

			if (lmsLeaveType != null) {
				session.delete(lmsLeaveType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsLeaveType != null) {
			clearCache(lmsLeaveType);
		}

		return lmsLeaveType;
	}

	@Override
	public LMSLeaveType updateImpl(
		com.trianz.lms.model.LMSLeaveType lmsLeaveType)
		throws SystemException {
		lmsLeaveType = toUnwrappedModel(lmsLeaveType);

		boolean isNew = lmsLeaveType.isNew();

		LMSLeaveTypeModelImpl lmsLeaveTypeModelImpl = (LMSLeaveTypeModelImpl)lmsLeaveType;

		Session session = null;

		try {
			session = openSession();

			if (lmsLeaveType.isNew()) {
				session.save(lmsLeaveType);

				lmsLeaveType.setNew(false);
			}
			else {
				session.merge(lmsLeaveType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSLeaveTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsLeaveTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRIESAPPLICABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsLeaveTypeModelImpl.getOriginalCountriesApplicable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRIESAPPLICABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRIESAPPLICABLE,
					args);

				args = new Object[] {
						lmsLeaveTypeModelImpl.getCountriesApplicable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRIESAPPLICABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRIESAPPLICABLE,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeaveTypeImpl.class, lmsLeaveType.getPrimaryKey(), lmsLeaveType);

		clearUniqueFindersCache(lmsLeaveType);
		cacheUniqueFindersCache(lmsLeaveType);

		return lmsLeaveType;
	}

	protected LMSLeaveType toUnwrappedModel(LMSLeaveType lmsLeaveType) {
		if (lmsLeaveType instanceof LMSLeaveTypeImpl) {
			return lmsLeaveType;
		}

		LMSLeaveTypeImpl lmsLeaveTypeImpl = new LMSLeaveTypeImpl();

		lmsLeaveTypeImpl.setNew(lmsLeaveType.isNew());
		lmsLeaveTypeImpl.setPrimaryKey(lmsLeaveType.getPrimaryKey());

		lmsLeaveTypeImpl.setLeaveTypeCode(lmsLeaveType.getLeaveTypeCode());
		lmsLeaveTypeImpl.setLeaveTypeName(lmsLeaveType.getLeaveTypeName());
		lmsLeaveTypeImpl.setCountriesApplicable(lmsLeaveType.getCountriesApplicable());
		lmsLeaveTypeImpl.setMonthlyAccrual(lmsLeaveType.getMonthlyAccrual());
		lmsLeaveTypeImpl.setAccrualValue(lmsLeaveType.getAccrualValue());
		lmsLeaveTypeImpl.setCreditReset(lmsLeaveType.getCreditReset());
		lmsLeaveTypeImpl.setResetInterval(lmsLeaveType.getResetInterval());
		lmsLeaveTypeImpl.setResetDay(lmsLeaveType.getResetDay());
		lmsLeaveTypeImpl.setExcludeWeekEnds(lmsLeaveType.getExcludeWeekEnds());
		lmsLeaveTypeImpl.setExcludeHolidays(lmsLeaveType.getExcludeHolidays());

		return lmsLeaveTypeImpl;
	}

	/**
	 * Returns the l m s leave type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s leave type
	 * @return the l m s leave type
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTypeException, SystemException {
		LMSLeaveType lmsLeaveType = fetchByPrimaryKey(primaryKey);

		if (lmsLeaveType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsLeaveType;
	}

	/**
	 * Returns the l m s leave type with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	 *
	 * @param LeaveTypeCode the primary key of the l m s leave type
	 * @return the l m s leave type
	 * @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType findByPrimaryKey(int LeaveTypeCode)
		throws NoSuchLeaveTypeException, SystemException {
		return findByPrimaryKey((Serializable)LeaveTypeCode);
	}

	/**
	 * Returns the l m s leave type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s leave type
	 * @return the l m s leave type, or <code>null</code> if a l m s leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSLeaveType lmsLeaveType = (LMSLeaveType)EntityCacheUtil.getResult(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
				LMSLeaveTypeImpl.class, primaryKey);

		if (lmsLeaveType == _nullLMSLeaveType) {
			return null;
		}

		if (lmsLeaveType == null) {
			Session session = null;

			try {
				session = openSession();

				lmsLeaveType = (LMSLeaveType)session.get(LMSLeaveTypeImpl.class,
						primaryKey);

				if (lmsLeaveType != null) {
					cacheResult(lmsLeaveType);
				}
				else {
					EntityCacheUtil.putResult(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
						LMSLeaveTypeImpl.class, primaryKey, _nullLMSLeaveType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSLeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
					LMSLeaveTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsLeaveType;
	}

	/**
	 * Returns the l m s leave type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LeaveTypeCode the primary key of the l m s leave type
	 * @return the l m s leave type, or <code>null</code> if a l m s leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeaveType fetchByPrimaryKey(int LeaveTypeCode)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)LeaveTypeCode);
	}

	/**
	 * Returns all the l m s leave types.
	 *
	 * @return the l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s leave types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s leave types
	 * @param end the upper bound of the range of l m s leave types (not inclusive)
	 * @return the range of l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s leave types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s leave types
	 * @param end the upper bound of the range of l m s leave types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeaveType> findAll(int start, int end,
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

		List<LMSLeaveType> list = (List<LMSLeaveType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSLEAVETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSLEAVETYPE;

				if (pagination) {
					sql = sql.concat(LMSLeaveTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSLeaveType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeaveType>(list);
				}
				else {
					list = (List<LMSLeaveType>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the l m s leave types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSLeaveType lmsLeaveType : findAll()) {
			remove(lmsLeaveType);
		}
	}

	/**
	 * Returns the number of l m s leave types.
	 *
	 * @return the number of l m s leave types
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

				Query q = session.createQuery(_SQL_COUNT_LMSLEAVETYPE);

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
	 * Initializes the l m s leave type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSLeaveType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSLeaveType>> listenersList = new ArrayList<ModelListener<LMSLeaveType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSLeaveType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSLeaveTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSLEAVETYPE = "SELECT lmsLeaveType FROM LMSLeaveType lmsLeaveType";
	private static final String _SQL_SELECT_LMSLEAVETYPE_WHERE = "SELECT lmsLeaveType FROM LMSLeaveType lmsLeaveType WHERE ";
	private static final String _SQL_COUNT_LMSLEAVETYPE = "SELECT COUNT(lmsLeaveType) FROM LMSLeaveType lmsLeaveType";
	private static final String _SQL_COUNT_LMSLEAVETYPE_WHERE = "SELECT COUNT(lmsLeaveType) FROM LMSLeaveType lmsLeaveType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsLeaveType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSLeaveType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSLeaveType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSLeaveTypePersistenceImpl.class);
	private static LMSLeaveType _nullLMSLeaveType = new LMSLeaveTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSLeaveType> toCacheModel() {
				return _nullLMSLeaveTypeCacheModel;
			}
		};

	private static CacheModel<LMSLeaveType> _nullLMSLeaveTypeCacheModel = new CacheModel<LMSLeaveType>() {
			@Override
			public LMSLeaveType toEntityModel() {
				return _nullLMSLeaveType;
			}
		};
}