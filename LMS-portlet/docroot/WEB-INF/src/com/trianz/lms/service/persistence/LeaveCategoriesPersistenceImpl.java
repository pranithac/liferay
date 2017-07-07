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

import com.trianz.lms.NoSuchLeaveCategoriesException;
import com.trianz.lms.model.LeaveCategories;
import com.trianz.lms.model.impl.LeaveCategoriesImpl;
import com.trianz.lms.model.impl.LeaveCategoriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveCategoriesPersistence
 * @see LeaveCategoriesUtil
 * @generated
 */
public class LeaveCategoriesPersistenceImpl extends BasePersistenceImpl<LeaveCategories>
	implements LeaveCategoriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveCategoriesUtil} to access the leave categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveCategoriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVETYPECODE = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLeaveTypeCode", new String[] { Integer.class.getName() },
			LeaveCategoriesModelImpl.LEAVETYPECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPECODE = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeCode",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the leave categories where LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByLeaveTypeCode(int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = fetchByLeaveTypeCode(LeaveTypeCode);

		if (leaveCategories == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("LeaveTypeCode=");
			msg.append(LeaveTypeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveCategoriesException(msg.toString());
		}

		return leaveCategories;
	}

	/**
	 * Returns the leave categories where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveTypeCode(int LeaveTypeCode)
		throws SystemException {
		return fetchByLeaveTypeCode(LeaveTypeCode, true);
	}

	/**
	 * Returns the leave categories where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveTypeCode(int LeaveTypeCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { LeaveTypeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
					finderArgs, this);
		}

		if (result instanceof LeaveCategories) {
			LeaveCategories leaveCategories = (LeaveCategories)result;

			if ((LeaveTypeCode != leaveCategories.getLeaveTypeCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEAVECATEGORIES_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPECODE_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(LeaveTypeCode);

				List<LeaveCategories> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LeaveCategoriesPersistenceImpl.fetchByLeaveTypeCode(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LeaveCategories leaveCategories = list.get(0);

					result = leaveCategories;

					cacheResult(leaveCategories);

					if ((leaveCategories.getLeaveTypeCode() != LeaveTypeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
							finderArgs, leaveCategories);
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
			return (LeaveCategories)result;
		}
	}

	/**
	 * Removes the leave categories where LeaveTypeCode = &#63; from the database.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the leave categories that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories removeByLeaveTypeCode(int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = findByLeaveTypeCode(LeaveTypeCode);

		return remove(leaveCategories);
	}

	/**
	 * Returns the number of leave categorieses where LeaveTypeCode = &#63;.
	 *
	 * @param LeaveTypeCode the leave type code
	 * @return the number of matching leave categorieses
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

			query.append(_SQL_COUNT_LEAVECATEGORIES_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPECODE_LEAVETYPECODE_2 = "leaveCategories.LeaveTypeCode = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLeaveCategoryCode",
			new String[] { String.class.getName(), Integer.class.getName() },
			LeaveCategoriesModelImpl.LEAVECATEGORYCODE_COLUMN_BITMASK |
			LeaveCategoriesModelImpl.LEAVETYPECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVECATEGORYCODE = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveCategoryCode",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	 *
	 * @param LeaveCategoryCode the leave category code
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByLeaveCategoryCode(String LeaveCategoryCode,
		int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = fetchByLeaveCategoryCode(LeaveCategoryCode,
				LeaveTypeCode);

		if (leaveCategories == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("LeaveCategoryCode=");
			msg.append(LeaveCategoryCode);

			msg.append(", LeaveTypeCode=");
			msg.append(LeaveTypeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveCategoriesException(msg.toString());
		}

		return leaveCategories;
	}

	/**
	 * Returns the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeaveCategoryCode the leave category code
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveCategoryCode(String LeaveCategoryCode,
		int LeaveTypeCode) throws SystemException {
		return fetchByLeaveCategoryCode(LeaveCategoryCode, LeaveTypeCode, true);
	}

	/**
	 * Returns the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeaveCategoryCode the leave category code
	 * @param LeaveTypeCode the leave type code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveCategoryCode(String LeaveCategoryCode,
		int LeaveTypeCode, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { LeaveCategoryCode, LeaveTypeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
					finderArgs, this);
		}

		if (result instanceof LeaveCategories) {
			LeaveCategories leaveCategories = (LeaveCategories)result;

			if (!Validator.equals(LeaveCategoryCode,
						leaveCategories.getLeaveCategoryCode()) ||
					(LeaveTypeCode != leaveCategories.getLeaveTypeCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategoryCode = false;

			if (LeaveCategoryCode == null) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_1);
			}
			else if (LeaveCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_3);
			}
			else {
				bindLeaveCategoryCode = true;

				query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_2);
			}

			query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategoryCode) {
					qPos.add(LeaveCategoryCode);
				}

				qPos.add(LeaveTypeCode);

				List<LeaveCategories> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LeaveCategoriesPersistenceImpl.fetchByLeaveCategoryCode(String, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LeaveCategories leaveCategories = list.get(0);

					result = leaveCategories;

					cacheResult(leaveCategories);

					if ((leaveCategories.getLeaveCategoryCode() == null) ||
							!leaveCategories.getLeaveCategoryCode()
												.equals(LeaveCategoryCode) ||
							(leaveCategories.getLeaveTypeCode() != LeaveTypeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
							finderArgs, leaveCategories);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
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
			return (LeaveCategories)result;
		}
	}

	/**
	 * Removes the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; from the database.
	 *
	 * @param LeaveCategoryCode the leave category code
	 * @param LeaveTypeCode the leave type code
	 * @return the leave categories that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories removeByLeaveCategoryCode(String LeaveCategoryCode,
		int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = findByLeaveCategoryCode(LeaveCategoryCode,
				LeaveTypeCode);

		return remove(leaveCategories);
	}

	/**
	 * Returns the number of leave categorieses where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63;.
	 *
	 * @param LeaveCategoryCode the leave category code
	 * @param LeaveTypeCode the leave type code
	 * @return the number of matching leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveCategoryCode(String LeaveCategoryCode,
		int LeaveTypeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVECATEGORYCODE;

		Object[] finderArgs = new Object[] { LeaveCategoryCode, LeaveTypeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategoryCode = false;

			if (LeaveCategoryCode == null) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_1);
			}
			else if (LeaveCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_3);
			}
			else {
				bindLeaveCategoryCode = true;

				query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_2);
			}

			query.append(_FINDER_COLUMN_LEAVECATEGORYCODE_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategoryCode) {
					qPos.add(LeaveCategoryCode);
				}

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

	private static final String _FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_1 =
		"leaveCategories.LeaveCategoryCode IS NULL AND ";
	private static final String _FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_2 =
		"leaveCategories.LeaveCategoryCode = ? AND ";
	private static final String _FINDER_COLUMN_LEAVECATEGORYCODE_LEAVECATEGORYCODE_3 =
		"(leaveCategories.LeaveCategoryCode IS NULL OR leaveCategories.LeaveCategoryCode = '') AND ";
	private static final String _FINDER_COLUMN_LEAVECATEGORYCODE_LEAVETYPECODE_2 =
		"leaveCategories.LeaveTypeCode = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLeaveCategoryName",
			new String[] { String.class.getName(), Integer.class.getName() },
			LeaveCategoriesModelImpl.LEAVECATEGORY_COLUMN_BITMASK |
			LeaveCategoriesModelImpl.LEAVETYPECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVECATEGORYNAME = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveCategoryName",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByLeaveCategoryName(String LeaveCategory,
		int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = fetchByLeaveCategoryName(LeaveCategory,
				LeaveTypeCode);

		if (leaveCategories == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("LeaveCategory=");
			msg.append(LeaveCategory);

			msg.append(", LeaveTypeCode=");
			msg.append(LeaveTypeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveCategoriesException(msg.toString());
		}

		return leaveCategories;
	}

	/**
	 * Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveCategoryName(String LeaveCategory,
		int LeaveTypeCode) throws SystemException {
		return fetchByLeaveCategoryName(LeaveCategory, LeaveTypeCode, true);
	}

	/**
	 * Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveCategoryName(String LeaveCategory,
		int LeaveTypeCode, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { LeaveCategory, LeaveTypeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
					finderArgs, this);
		}

		if (result instanceof LeaveCategories) {
			LeaveCategories leaveCategories = (LeaveCategories)result;

			if (!Validator.equals(LeaveCategory,
						leaveCategories.getLeaveCategory()) ||
					(LeaveTypeCode != leaveCategories.getLeaveTypeCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategory = false;

			if (LeaveCategory == null) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_1);
			}
			else if (LeaveCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_3);
			}
			else {
				bindLeaveCategory = true;

				query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_2);
			}

			query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategory) {
					qPos.add(LeaveCategory);
				}

				qPos.add(LeaveTypeCode);

				List<LeaveCategories> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LeaveCategoriesPersistenceImpl.fetchByLeaveCategoryName(String, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LeaveCategories leaveCategories = list.get(0);

					result = leaveCategories;

					cacheResult(leaveCategories);

					if ((leaveCategories.getLeaveCategory() == null) ||
							!leaveCategories.getLeaveCategory()
												.equals(LeaveCategory) ||
							(leaveCategories.getLeaveTypeCode() != LeaveTypeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
							finderArgs, leaveCategories);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
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
			return (LeaveCategories)result;
		}
	}

	/**
	 * Removes the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; from the database.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the leave categories that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories removeByLeaveCategoryName(String LeaveCategory,
		int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = findByLeaveCategoryName(LeaveCategory,
				LeaveTypeCode);

		return remove(leaveCategories);
	}

	/**
	 * Returns the number of leave categorieses where LeaveCategory = &#63; and LeaveTypeCode = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the number of matching leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveCategoryName(String LeaveCategory, int LeaveTypeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVECATEGORYNAME;

		Object[] finderArgs = new Object[] { LeaveCategory, LeaveTypeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategory = false;

			if (LeaveCategory == null) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_1);
			}
			else if (LeaveCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_3);
			}
			else {
				bindLeaveCategory = true;

				query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_2);
			}

			query.append(_FINDER_COLUMN_LEAVECATEGORYNAME_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategory) {
					qPos.add(LeaveCategory);
				}

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

	private static final String _FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_1 =
		"leaveCategories.LeaveCategory IS NULL AND ";
	private static final String _FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_2 =
		"leaveCategories.LeaveCategory = ? AND ";
	private static final String _FINDER_COLUMN_LEAVECATEGORYNAME_LEAVECATEGORY_3 =
		"(leaveCategories.LeaveCategory IS NULL OR leaveCategories.LeaveCategory = '') AND ";
	private static final String _FINDER_COLUMN_LEAVECATEGORYNAME_LEAVETYPECODE_2 =
		"leaveCategories.LeaveTypeCode = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORYNAME = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCategoryName",
			new String[] { String.class.getName(), Integer.class.getName() },
			LeaveCategoriesModelImpl.LEAVECATEGORY_COLUMN_BITMASK |
			LeaveCategoriesModelImpl.LEAVETYPECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByCategoryName(String LeaveCategory,
		int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = fetchByCategoryName(LeaveCategory,
				LeaveTypeCode);

		if (leaveCategories == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("LeaveCategory=");
			msg.append(LeaveCategory);

			msg.append(", LeaveTypeCode=");
			msg.append(LeaveTypeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveCategoriesException(msg.toString());
		}

		return leaveCategories;
	}

	/**
	 * Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByCategoryName(String LeaveCategory,
		int LeaveTypeCode) throws SystemException {
		return fetchByCategoryName(LeaveCategory, LeaveTypeCode, true);
	}

	/**
	 * Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByCategoryName(String LeaveCategory,
		int LeaveTypeCode, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { LeaveCategory, LeaveTypeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
					finderArgs, this);
		}

		if (result instanceof LeaveCategories) {
			LeaveCategories leaveCategories = (LeaveCategories)result;

			if (!Validator.equals(LeaveCategory,
						leaveCategories.getLeaveCategory()) ||
					(LeaveTypeCode != leaveCategories.getLeaveTypeCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategory = false;

			if (LeaveCategory == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_1);
			}
			else if (LeaveCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_3);
			}
			else {
				bindLeaveCategory = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_2);
			}

			query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategory) {
					qPos.add(LeaveCategory);
				}

				qPos.add(LeaveTypeCode);

				List<LeaveCategories> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LeaveCategoriesPersistenceImpl.fetchByCategoryName(String, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LeaveCategories leaveCategories = list.get(0);

					result = leaveCategories;

					cacheResult(leaveCategories);

					if ((leaveCategories.getLeaveCategory() == null) ||
							!leaveCategories.getLeaveCategory()
												.equals(LeaveCategory) ||
							(leaveCategories.getLeaveTypeCode() != LeaveTypeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
							finderArgs, leaveCategories);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
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
			return (LeaveCategories)result;
		}
	}

	/**
	 * Removes the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; from the database.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the leave categories that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories removeByCategoryName(String LeaveCategory,
		int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = findByCategoryName(LeaveCategory,
				LeaveTypeCode);

		return remove(leaveCategories);
	}

	/**
	 * Returns the number of leave categorieses where LeaveCategory = &#63; and LeaveTypeCode = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @param LeaveTypeCode the leave type code
	 * @return the number of matching leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryName(String LeaveCategory, int LeaveTypeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYNAME;

		Object[] finderArgs = new Object[] { LeaveCategory, LeaveTypeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategory = false;

			if (LeaveCategory == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_1);
			}
			else if (LeaveCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_3);
			}
			else {
				bindLeaveCategory = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_2);
			}

			query.append(_FINDER_COLUMN_CATEGORYNAME_LEAVETYPECODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategory) {
					qPos.add(LeaveCategory);
				}

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

	private static final String _FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_1 = "leaveCategories.LeaveCategory IS NULL AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_2 = "leaveCategories.LeaveCategory = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_LEAVECATEGORY_3 = "(leaveCategories.LeaveCategory IS NULL OR leaveCategories.LeaveCategory = '') AND ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_LEAVETYPECODE_2 = "leaveCategories.LeaveTypeCode = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVECATEGORY =
		new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLeaveCategory",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVECATEGORY =
		new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED,
			LeaveCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveCategory",
			new String[] { String.class.getName() },
			LeaveCategoriesModelImpl.LEAVECATEGORY_COLUMN_BITMASK |
			LeaveCategoriesModelImpl.LEAVECATEGORYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVECATEGORY = new FinderPath(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveCategory",
			new String[] { String.class.getName() });

	/**
	 * Returns all the leave categorieses where LeaveCategory = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @return the matching leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCategories> findByLeaveCategory(String LeaveCategory)
		throws SystemException {
		return findByLeaveCategory(LeaveCategory, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave categorieses where LeaveCategory = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param LeaveCategory the leave category
	 * @param start the lower bound of the range of leave categorieses
	 * @param end the upper bound of the range of leave categorieses (not inclusive)
	 * @return the range of matching leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCategories> findByLeaveCategory(String LeaveCategory,
		int start, int end) throws SystemException {
		return findByLeaveCategory(LeaveCategory, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave categorieses where LeaveCategory = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param LeaveCategory the leave category
	 * @param start the lower bound of the range of leave categorieses
	 * @param end the upper bound of the range of leave categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCategories> findByLeaveCategory(String LeaveCategory,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVECATEGORY;
			finderArgs = new Object[] { LeaveCategory };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVECATEGORY;
			finderArgs = new Object[] {
					LeaveCategory,
					
					start, end, orderByComparator
				};
		}

		List<LeaveCategories> list = (List<LeaveCategories>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveCategories leaveCategories : list) {
				if (!Validator.equals(LeaveCategory,
							leaveCategories.getLeaveCategory())) {
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

			query.append(_SQL_SELECT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategory = false;

			if (LeaveCategory == null) {
				query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_1);
			}
			else if (LeaveCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_3);
			}
			else {
				bindLeaveCategory = true;

				query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveCategoriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategory) {
					qPos.add(LeaveCategory);
				}

				if (!pagination) {
					list = (List<LeaveCategories>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveCategories>(list);
				}
				else {
					list = (List<LeaveCategories>)QueryUtil.list(q,
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
	 * Returns the first leave categories in the ordered set where LeaveCategory = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByLeaveCategory_First(String LeaveCategory,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = fetchByLeaveCategory_First(LeaveCategory,
				orderByComparator);

		if (leaveCategories != null) {
			return leaveCategories;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveCategory=");
		msg.append(LeaveCategory);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveCategoriesException(msg.toString());
	}

	/**
	 * Returns the first leave categories in the ordered set where LeaveCategory = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveCategory_First(String LeaveCategory,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveCategories> list = findByLeaveCategory(LeaveCategory, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave categories in the ordered set where LeaveCategory = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByLeaveCategory_Last(String LeaveCategory,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = fetchByLeaveCategory_Last(LeaveCategory,
				orderByComparator);

		if (leaveCategories != null) {
			return leaveCategories;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("LeaveCategory=");
		msg.append(LeaveCategory);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveCategoriesException(msg.toString());
	}

	/**
	 * Returns the last leave categories in the ordered set where LeaveCategory = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave categories, or <code>null</code> if a matching leave categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByLeaveCategory_Last(String LeaveCategory,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveCategory(LeaveCategory);

		if (count == 0) {
			return null;
		}

		List<LeaveCategories> list = findByLeaveCategory(LeaveCategory,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave categorieses before and after the current leave categories in the ordered set where LeaveCategory = &#63;.
	 *
	 * @param LeaveTypeCode the primary key of the current leave categories
	 * @param LeaveCategory the leave category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories[] findByLeaveCategory_PrevAndNext(
		int LeaveTypeCode, String LeaveCategory,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = findByPrimaryKey(LeaveTypeCode);

		Session session = null;

		try {
			session = openSession();

			LeaveCategories[] array = new LeaveCategoriesImpl[3];

			array[0] = getByLeaveCategory_PrevAndNext(session, leaveCategories,
					LeaveCategory, orderByComparator, true);

			array[1] = leaveCategories;

			array[2] = getByLeaveCategory_PrevAndNext(session, leaveCategories,
					LeaveCategory, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveCategories getByLeaveCategory_PrevAndNext(Session session,
		LeaveCategories leaveCategories, String LeaveCategory,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVECATEGORIES_WHERE);

		boolean bindLeaveCategory = false;

		if (LeaveCategory == null) {
			query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_1);
		}
		else if (LeaveCategory.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_3);
		}
		else {
			bindLeaveCategory = true;

			query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_2);
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
			query.append(LeaveCategoriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLeaveCategory) {
			qPos.add(LeaveCategory);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveCategories);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveCategories> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave categorieses where LeaveCategory = &#63; from the database.
	 *
	 * @param LeaveCategory the leave category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveCategory(String LeaveCategory)
		throws SystemException {
		for (LeaveCategories leaveCategories : findByLeaveCategory(
				LeaveCategory, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveCategories);
		}
	}

	/**
	 * Returns the number of leave categorieses where LeaveCategory = &#63;.
	 *
	 * @param LeaveCategory the leave category
	 * @return the number of matching leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveCategory(String LeaveCategory)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVECATEGORY;

		Object[] finderArgs = new Object[] { LeaveCategory };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVECATEGORIES_WHERE);

			boolean bindLeaveCategory = false;

			if (LeaveCategory == null) {
				query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_1);
			}
			else if (LeaveCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_3);
			}
			else {
				bindLeaveCategory = true;

				query.append(_FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveCategory) {
					qPos.add(LeaveCategory);
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

	private static final String _FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_1 = "leaveCategories.LeaveCategory IS NULL";
	private static final String _FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_2 = "leaveCategories.LeaveCategory = ?";
	private static final String _FINDER_COLUMN_LEAVECATEGORY_LEAVECATEGORY_3 = "(leaveCategories.LeaveCategory IS NULL OR leaveCategories.LeaveCategory = '')";

	public LeaveCategoriesPersistenceImpl() {
		setModelClass(LeaveCategories.class);
	}

	/**
	 * Caches the leave categories in the entity cache if it is enabled.
	 *
	 * @param leaveCategories the leave categories
	 */
	@Override
	public void cacheResult(LeaveCategories leaveCategories) {
		EntityCacheUtil.putResult(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesImpl.class, leaveCategories.getPrimaryKey(),
			leaveCategories);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
			new Object[] { leaveCategories.getLeaveTypeCode() }, leaveCategories);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
			new Object[] {
				leaveCategories.getLeaveCategoryCode(),
				leaveCategories.getLeaveTypeCode()
			}, leaveCategories);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
			new Object[] {
				leaveCategories.getLeaveCategory(),
				leaveCategories.getLeaveTypeCode()
			}, leaveCategories);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
			new Object[] {
				leaveCategories.getLeaveCategory(),
				leaveCategories.getLeaveTypeCode()
			}, leaveCategories);

		leaveCategories.resetOriginalValues();
	}

	/**
	 * Caches the leave categorieses in the entity cache if it is enabled.
	 *
	 * @param leaveCategorieses the leave categorieses
	 */
	@Override
	public void cacheResult(List<LeaveCategories> leaveCategorieses) {
		for (LeaveCategories leaveCategories : leaveCategorieses) {
			if (EntityCacheUtil.getResult(
						LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
						LeaveCategoriesImpl.class,
						leaveCategories.getPrimaryKey()) == null) {
				cacheResult(leaveCategories);
			}
			else {
				leaveCategories.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave categorieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveCategoriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveCategoriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveCategories leaveCategories) {
		EntityCacheUtil.removeResult(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesImpl.class, leaveCategories.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(leaveCategories);
	}

	@Override
	public void clearCache(List<LeaveCategories> leaveCategorieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveCategories leaveCategories : leaveCategorieses) {
			EntityCacheUtil.removeResult(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
				LeaveCategoriesImpl.class, leaveCategories.getPrimaryKey());

			clearUniqueFindersCache(leaveCategories);
		}
	}

	protected void cacheUniqueFindersCache(LeaveCategories leaveCategories) {
		if (leaveCategories.isNew()) {
			Object[] args = new Object[] { leaveCategories.getLeaveTypeCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE, args,
				leaveCategories);

			args = new Object[] {
					leaveCategories.getLeaveCategoryCode(),
					leaveCategories.getLeaveTypeCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
				args, leaveCategories);

			args = new Object[] {
					leaveCategories.getLeaveCategory(),
					leaveCategories.getLeaveTypeCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
				args, leaveCategories);

			args = new Object[] {
					leaveCategories.getLeaveCategory(),
					leaveCategories.getLeaveTypeCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME, args,
				leaveCategories);
		}
		else {
			LeaveCategoriesModelImpl leaveCategoriesModelImpl = (LeaveCategoriesModelImpl)leaveCategories;

			if ((leaveCategoriesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LEAVETYPECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { leaveCategories.getLeaveTypeCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
					args, leaveCategories);
			}

			if ((leaveCategoriesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveCategories.getLeaveCategoryCode(),
						leaveCategories.getLeaveTypeCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
					args, leaveCategories);
			}

			if ((leaveCategoriesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveCategories.getLeaveCategory(),
						leaveCategories.getLeaveTypeCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
					args, leaveCategories);
			}

			if ((leaveCategoriesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveCategories.getLeaveCategory(),
						leaveCategories.getLeaveTypeCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
					args, leaveCategories);
			}
		}
	}

	protected void clearUniqueFindersCache(LeaveCategories leaveCategories) {
		LeaveCategoriesModelImpl leaveCategoriesModelImpl = (LeaveCategoriesModelImpl)leaveCategories;

		Object[] args = new Object[] { leaveCategories.getLeaveTypeCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE, args);

		if ((leaveCategoriesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVETYPECODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					leaveCategoriesModelImpl.getOriginalLeaveTypeCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPECODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPECODE,
				args);
		}

		args = new Object[] {
				leaveCategories.getLeaveCategoryCode(),
				leaveCategories.getLeaveTypeCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
			args);

		if ((leaveCategoriesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					leaveCategoriesModelImpl.getOriginalLeaveCategoryCode(),
					leaveCategoriesModelImpl.getOriginalLeaveTypeCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYCODE,
				args);
		}

		args = new Object[] {
				leaveCategories.getLeaveCategory(),
				leaveCategories.getLeaveTypeCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
			args);

		if ((leaveCategoriesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					leaveCategoriesModelImpl.getOriginalLeaveCategory(),
					leaveCategoriesModelImpl.getOriginalLeaveTypeCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVECATEGORYNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVECATEGORYNAME,
				args);
		}

		args = new Object[] {
				leaveCategories.getLeaveCategory(),
				leaveCategories.getLeaveTypeCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME, args);

		if ((leaveCategoriesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					leaveCategoriesModelImpl.getOriginalLeaveCategory(),
					leaveCategoriesModelImpl.getOriginalLeaveTypeCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME, args);
		}
	}

	/**
	 * Creates a new leave categories with the primary key. Does not add the leave categories to the database.
	 *
	 * @param LeaveTypeCode the primary key for the new leave categories
	 * @return the new leave categories
	 */
	@Override
	public LeaveCategories create(int LeaveTypeCode) {
		LeaveCategories leaveCategories = new LeaveCategoriesImpl();

		leaveCategories.setNew(true);
		leaveCategories.setPrimaryKey(LeaveTypeCode);

		return leaveCategories;
	}

	/**
	 * Removes the leave categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LeaveTypeCode the primary key of the leave categories
	 * @return the leave categories that was removed
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories remove(int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		return remove((Serializable)LeaveTypeCode);
	}

	/**
	 * Removes the leave categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave categories
	 * @return the leave categories that was removed
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories remove(Serializable primaryKey)
		throws NoSuchLeaveCategoriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveCategories leaveCategories = (LeaveCategories)session.get(LeaveCategoriesImpl.class,
					primaryKey);

			if (leaveCategories == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveCategories);
		}
		catch (NoSuchLeaveCategoriesException nsee) {
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
	protected LeaveCategories removeImpl(LeaveCategories leaveCategories)
		throws SystemException {
		leaveCategories = toUnwrappedModel(leaveCategories);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveCategories)) {
				leaveCategories = (LeaveCategories)session.get(LeaveCategoriesImpl.class,
						leaveCategories.getPrimaryKeyObj());
			}

			if (leaveCategories != null) {
				session.delete(leaveCategories);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveCategories != null) {
			clearCache(leaveCategories);
		}

		return leaveCategories;
	}

	@Override
	public LeaveCategories updateImpl(
		com.trianz.lms.model.LeaveCategories leaveCategories)
		throws SystemException {
		leaveCategories = toUnwrappedModel(leaveCategories);

		boolean isNew = leaveCategories.isNew();

		LeaveCategoriesModelImpl leaveCategoriesModelImpl = (LeaveCategoriesModelImpl)leaveCategories;

		Session session = null;

		try {
			session = openSession();

			if (leaveCategories.isNew()) {
				session.save(leaveCategories);

				leaveCategories.setNew(false);
			}
			else {
				session.merge(leaveCategories);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveCategoriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveCategoriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVECATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveCategoriesModelImpl.getOriginalLeaveCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVECATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVECATEGORY,
					args);

				args = new Object[] { leaveCategoriesModelImpl.getLeaveCategory() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVECATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVECATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCategoriesImpl.class, leaveCategories.getPrimaryKey(),
			leaveCategories);

		clearUniqueFindersCache(leaveCategories);
		cacheUniqueFindersCache(leaveCategories);

		return leaveCategories;
	}

	protected LeaveCategories toUnwrappedModel(LeaveCategories leaveCategories) {
		if (leaveCategories instanceof LeaveCategoriesImpl) {
			return leaveCategories;
		}

		LeaveCategoriesImpl leaveCategoriesImpl = new LeaveCategoriesImpl();

		leaveCategoriesImpl.setNew(leaveCategories.isNew());
		leaveCategoriesImpl.setPrimaryKey(leaveCategories.getPrimaryKey());

		leaveCategoriesImpl.setLeaveCategoryCode(leaveCategories.getLeaveCategoryCode());
		leaveCategoriesImpl.setLeaveCategory(leaveCategories.getLeaveCategory());
		leaveCategoriesImpl.setLeaveTypeCode(leaveCategories.getLeaveTypeCode());

		return leaveCategoriesImpl;
	}

	/**
	 * Returns the leave categories with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave categories
	 * @return the leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveCategoriesException, SystemException {
		LeaveCategories leaveCategories = fetchByPrimaryKey(primaryKey);

		if (leaveCategories == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveCategories;
	}

	/**
	 * Returns the leave categories with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	 *
	 * @param LeaveTypeCode the primary key of the leave categories
	 * @return the leave categories
	 * @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories findByPrimaryKey(int LeaveTypeCode)
		throws NoSuchLeaveCategoriesException, SystemException {
		return findByPrimaryKey((Serializable)LeaveTypeCode);
	}

	/**
	 * Returns the leave categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave categories
	 * @return the leave categories, or <code>null</code> if a leave categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveCategories leaveCategories = (LeaveCategories)EntityCacheUtil.getResult(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
				LeaveCategoriesImpl.class, primaryKey);

		if (leaveCategories == _nullLeaveCategories) {
			return null;
		}

		if (leaveCategories == null) {
			Session session = null;

			try {
				session = openSession();

				leaveCategories = (LeaveCategories)session.get(LeaveCategoriesImpl.class,
						primaryKey);

				if (leaveCategories != null) {
					cacheResult(leaveCategories);
				}
				else {
					EntityCacheUtil.putResult(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
						LeaveCategoriesImpl.class, primaryKey,
						_nullLeaveCategories);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveCategoriesModelImpl.ENTITY_CACHE_ENABLED,
					LeaveCategoriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveCategories;
	}

	/**
	 * Returns the leave categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LeaveTypeCode the primary key of the leave categories
	 * @return the leave categories, or <code>null</code> if a leave categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCategories fetchByPrimaryKey(int LeaveTypeCode)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)LeaveTypeCode);
	}

	/**
	 * Returns all the leave categorieses.
	 *
	 * @return the leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCategories> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave categorieses
	 * @param end the upper bound of the range of leave categorieses (not inclusive)
	 * @return the range of leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCategories> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave categorieses
	 * @param end the upper bound of the range of leave categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCategories> findAll(int start, int end,
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

		List<LeaveCategories> list = (List<LeaveCategories>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVECATEGORIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVECATEGORIES;

				if (pagination) {
					sql = sql.concat(LeaveCategoriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveCategories>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveCategories>(list);
				}
				else {
					list = (List<LeaveCategories>)QueryUtil.list(q,
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
	 * Removes all the leave categorieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveCategories leaveCategories : findAll()) {
			remove(leaveCategories);
		}
	}

	/**
	 * Returns the number of leave categorieses.
	 *
	 * @return the number of leave categorieses
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

				Query q = session.createQuery(_SQL_COUNT_LEAVECATEGORIES);

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
	 * Initializes the leave categories persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LeaveCategories")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveCategories>> listenersList = new ArrayList<ModelListener<LeaveCategories>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveCategories>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveCategoriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVECATEGORIES = "SELECT leaveCategories FROM LeaveCategories leaveCategories";
	private static final String _SQL_SELECT_LEAVECATEGORIES_WHERE = "SELECT leaveCategories FROM LeaveCategories leaveCategories WHERE ";
	private static final String _SQL_COUNT_LEAVECATEGORIES = "SELECT COUNT(leaveCategories) FROM LeaveCategories leaveCategories";
	private static final String _SQL_COUNT_LEAVECATEGORIES_WHERE = "SELECT COUNT(leaveCategories) FROM LeaveCategories leaveCategories WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveCategories.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveCategories exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveCategories exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveCategoriesPersistenceImpl.class);
	private static LeaveCategories _nullLeaveCategories = new LeaveCategoriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveCategories> toCacheModel() {
				return _nullLeaveCategoriesCacheModel;
			}
		};

	private static CacheModel<LeaveCategories> _nullLeaveCategoriesCacheModel = new CacheModel<LeaveCategories>() {
			@Override
			public LeaveCategories toEntityModel() {
				return _nullLeaveCategories;
			}
		};
}