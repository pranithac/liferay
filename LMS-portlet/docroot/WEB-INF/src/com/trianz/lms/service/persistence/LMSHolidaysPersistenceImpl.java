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

import com.trianz.lms.NoSuchHolidaysException;
import com.trianz.lms.model.LMSHolidays;
import com.trianz.lms.model.impl.LMSHolidaysImpl;
import com.trianz.lms.model.impl.LMSHolidaysModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s holidays service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSHolidaysPersistence
 * @see LMSHolidaysUtil
 * @generated
 */
public class LMSHolidaysPersistenceImpl extends BasePersistenceImpl<LMSHolidays>
	implements LMSHolidaysPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSHolidaysUtil} to access the l m s holidays persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSHolidaysImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysModelImpl.FINDER_CACHE_ENABLED, LMSHolidaysImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysModelImpl.FINDER_CACHE_ENABLED, LMSHolidaysImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOLIDAYYEAR =
		new FinderPath(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysModelImpl.FINDER_CACHE_ENABLED, LMSHolidaysImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHolidayYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYYEAR =
		new FinderPath(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysModelImpl.FINDER_CACHE_ENABLED, LMSHolidaysImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHolidayYear",
			new String[] { Integer.class.getName() },
			LMSHolidaysModelImpl.HOLIDAYYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOLIDAYYEAR = new FinderPath(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHolidayYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the l m s holidayses where HolidayYear = &#63;.
	 *
	 * @param HolidayYear the holiday year
	 * @return the matching l m s holidayses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSHolidays> findByHolidayYear(int HolidayYear)
		throws SystemException {
		return findByHolidayYear(HolidayYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s holidayses where HolidayYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSHolidaysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param HolidayYear the holiday year
	 * @param start the lower bound of the range of l m s holidayses
	 * @param end the upper bound of the range of l m s holidayses (not inclusive)
	 * @return the range of matching l m s holidayses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSHolidays> findByHolidayYear(int HolidayYear, int start,
		int end) throws SystemException {
		return findByHolidayYear(HolidayYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s holidayses where HolidayYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSHolidaysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param HolidayYear the holiday year
	 * @param start the lower bound of the range of l m s holidayses
	 * @param end the upper bound of the range of l m s holidayses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s holidayses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSHolidays> findByHolidayYear(int HolidayYear, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYYEAR;
			finderArgs = new Object[] { HolidayYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOLIDAYYEAR;
			finderArgs = new Object[] { HolidayYear, start, end, orderByComparator };
		}

		List<LMSHolidays> list = (List<LMSHolidays>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LMSHolidays lmsHolidays : list) {
				if ((HolidayYear != lmsHolidays.getHolidayYear())) {
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

			query.append(_SQL_SELECT_LMSHOLIDAYS_WHERE);

			query.append(_FINDER_COLUMN_HOLIDAYYEAR_HOLIDAYYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LMSHolidaysModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(HolidayYear);

				if (!pagination) {
					list = (List<LMSHolidays>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSHolidays>(list);
				}
				else {
					list = (List<LMSHolidays>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first l m s holidays in the ordered set where HolidayYear = &#63;.
	 *
	 * @param HolidayYear the holiday year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s holidays
	 * @throws com.trianz.lms.NoSuchHolidaysException if a matching l m s holidays could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays findByHolidayYear_First(int HolidayYear,
		OrderByComparator orderByComparator)
		throws NoSuchHolidaysException, SystemException {
		LMSHolidays lmsHolidays = fetchByHolidayYear_First(HolidayYear,
				orderByComparator);

		if (lmsHolidays != null) {
			return lmsHolidays;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("HolidayYear=");
		msg.append(HolidayYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHolidaysException(msg.toString());
	}

	/**
	 * Returns the first l m s holidays in the ordered set where HolidayYear = &#63;.
	 *
	 * @param HolidayYear the holiday year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s holidays, or <code>null</code> if a matching l m s holidays could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays fetchByHolidayYear_First(int HolidayYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<LMSHolidays> list = findByHolidayYear(HolidayYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l m s holidays in the ordered set where HolidayYear = &#63;.
	 *
	 * @param HolidayYear the holiday year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s holidays
	 * @throws com.trianz.lms.NoSuchHolidaysException if a matching l m s holidays could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays findByHolidayYear_Last(int HolidayYear,
		OrderByComparator orderByComparator)
		throws NoSuchHolidaysException, SystemException {
		LMSHolidays lmsHolidays = fetchByHolidayYear_Last(HolidayYear,
				orderByComparator);

		if (lmsHolidays != null) {
			return lmsHolidays;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("HolidayYear=");
		msg.append(HolidayYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHolidaysException(msg.toString());
	}

	/**
	 * Returns the last l m s holidays in the ordered set where HolidayYear = &#63;.
	 *
	 * @param HolidayYear the holiday year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s holidays, or <code>null</code> if a matching l m s holidays could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays fetchByHolidayYear_Last(int HolidayYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHolidayYear(HolidayYear);

		if (count == 0) {
			return null;
		}

		List<LMSHolidays> list = findByHolidayYear(HolidayYear, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l m s holidayses before and after the current l m s holidays in the ordered set where HolidayYear = &#63;.
	 *
	 * @param HolidayId the primary key of the current l m s holidays
	 * @param HolidayYear the holiday year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s holidays
	 * @throws com.trianz.lms.NoSuchHolidaysException if a l m s holidays with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays[] findByHolidayYear_PrevAndNext(int HolidayId,
		int HolidayYear, OrderByComparator orderByComparator)
		throws NoSuchHolidaysException, SystemException {
		LMSHolidays lmsHolidays = findByPrimaryKey(HolidayId);

		Session session = null;

		try {
			session = openSession();

			LMSHolidays[] array = new LMSHolidaysImpl[3];

			array[0] = getByHolidayYear_PrevAndNext(session, lmsHolidays,
					HolidayYear, orderByComparator, true);

			array[1] = lmsHolidays;

			array[2] = getByHolidayYear_PrevAndNext(session, lmsHolidays,
					HolidayYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LMSHolidays getByHolidayYear_PrevAndNext(Session session,
		LMSHolidays lmsHolidays, int HolidayYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSHOLIDAYS_WHERE);

		query.append(_FINDER_COLUMN_HOLIDAYYEAR_HOLIDAYYEAR_2);

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
			query.append(LMSHolidaysModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(HolidayYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsHolidays);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSHolidays> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l m s holidayses where HolidayYear = &#63; from the database.
	 *
	 * @param HolidayYear the holiday year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHolidayYear(int HolidayYear) throws SystemException {
		for (LMSHolidays lmsHolidays : findByHolidayYear(HolidayYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lmsHolidays);
		}
	}

	/**
	 * Returns the number of l m s holidayses where HolidayYear = &#63;.
	 *
	 * @param HolidayYear the holiday year
	 * @return the number of matching l m s holidayses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHolidayYear(int HolidayYear) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HOLIDAYYEAR;

		Object[] finderArgs = new Object[] { HolidayYear };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSHOLIDAYS_WHERE);

			query.append(_FINDER_COLUMN_HOLIDAYYEAR_HOLIDAYYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(HolidayYear);

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

	private static final String _FINDER_COLUMN_HOLIDAYYEAR_HOLIDAYYEAR_2 = "lmsHolidays.HolidayYear = ?";

	public LMSHolidaysPersistenceImpl() {
		setModelClass(LMSHolidays.class);
	}

	/**
	 * Caches the l m s holidays in the entity cache if it is enabled.
	 *
	 * @param lmsHolidays the l m s holidays
	 */
	@Override
	public void cacheResult(LMSHolidays lmsHolidays) {
		EntityCacheUtil.putResult(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysImpl.class, lmsHolidays.getPrimaryKey(), lmsHolidays);

		lmsHolidays.resetOriginalValues();
	}

	/**
	 * Caches the l m s holidayses in the entity cache if it is enabled.
	 *
	 * @param lmsHolidayses the l m s holidayses
	 */
	@Override
	public void cacheResult(List<LMSHolidays> lmsHolidayses) {
		for (LMSHolidays lmsHolidays : lmsHolidayses) {
			if (EntityCacheUtil.getResult(
						LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
						LMSHolidaysImpl.class, lmsHolidays.getPrimaryKey()) == null) {
				cacheResult(lmsHolidays);
			}
			else {
				lmsHolidays.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s holidayses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSHolidaysImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSHolidaysImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s holidays.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSHolidays lmsHolidays) {
		EntityCacheUtil.removeResult(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysImpl.class, lmsHolidays.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LMSHolidays> lmsHolidayses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSHolidays lmsHolidays : lmsHolidayses) {
			EntityCacheUtil.removeResult(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
				LMSHolidaysImpl.class, lmsHolidays.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l m s holidays with the primary key. Does not add the l m s holidays to the database.
	 *
	 * @param HolidayId the primary key for the new l m s holidays
	 * @return the new l m s holidays
	 */
	@Override
	public LMSHolidays create(int HolidayId) {
		LMSHolidays lmsHolidays = new LMSHolidaysImpl();

		lmsHolidays.setNew(true);
		lmsHolidays.setPrimaryKey(HolidayId);

		return lmsHolidays;
	}

	/**
	 * Removes the l m s holidays with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param HolidayId the primary key of the l m s holidays
	 * @return the l m s holidays that was removed
	 * @throws com.trianz.lms.NoSuchHolidaysException if a l m s holidays with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays remove(int HolidayId)
		throws NoSuchHolidaysException, SystemException {
		return remove((Serializable)HolidayId);
	}

	/**
	 * Removes the l m s holidays with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s holidays
	 * @return the l m s holidays that was removed
	 * @throws com.trianz.lms.NoSuchHolidaysException if a l m s holidays with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays remove(Serializable primaryKey)
		throws NoSuchHolidaysException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSHolidays lmsHolidays = (LMSHolidays)session.get(LMSHolidaysImpl.class,
					primaryKey);

			if (lmsHolidays == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHolidaysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsHolidays);
		}
		catch (NoSuchHolidaysException nsee) {
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
	protected LMSHolidays removeImpl(LMSHolidays lmsHolidays)
		throws SystemException {
		lmsHolidays = toUnwrappedModel(lmsHolidays);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsHolidays)) {
				lmsHolidays = (LMSHolidays)session.get(LMSHolidaysImpl.class,
						lmsHolidays.getPrimaryKeyObj());
			}

			if (lmsHolidays != null) {
				session.delete(lmsHolidays);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsHolidays != null) {
			clearCache(lmsHolidays);
		}

		return lmsHolidays;
	}

	@Override
	public LMSHolidays updateImpl(com.trianz.lms.model.LMSHolidays lmsHolidays)
		throws SystemException {
		lmsHolidays = toUnwrappedModel(lmsHolidays);

		boolean isNew = lmsHolidays.isNew();

		LMSHolidaysModelImpl lmsHolidaysModelImpl = (LMSHolidaysModelImpl)lmsHolidays;

		Session session = null;

		try {
			session = openSession();

			if (lmsHolidays.isNew()) {
				session.save(lmsHolidays);

				lmsHolidays.setNew(false);
			}
			else {
				session.merge(lmsHolidays);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSHolidaysModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsHolidaysModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsHolidaysModelImpl.getOriginalHolidayYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOLIDAYYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYYEAR,
					args);

				args = new Object[] { lmsHolidaysModelImpl.getHolidayYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOLIDAYYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYYEAR,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
			LMSHolidaysImpl.class, lmsHolidays.getPrimaryKey(), lmsHolidays);

		return lmsHolidays;
	}

	protected LMSHolidays toUnwrappedModel(LMSHolidays lmsHolidays) {
		if (lmsHolidays instanceof LMSHolidaysImpl) {
			return lmsHolidays;
		}

		LMSHolidaysImpl lmsHolidaysImpl = new LMSHolidaysImpl();

		lmsHolidaysImpl.setNew(lmsHolidays.isNew());
		lmsHolidaysImpl.setPrimaryKey(lmsHolidays.getPrimaryKey());

		lmsHolidaysImpl.setHolidayId(lmsHolidays.getHolidayId());
		lmsHolidaysImpl.setHolidayDate(lmsHolidays.getHolidayDate());
		lmsHolidaysImpl.setOccassion(lmsHolidays.getOccassion());
		lmsHolidaysImpl.setHolidayYear(lmsHolidays.getHolidayYear());
		lmsHolidaysImpl.setLocationsApplicable(lmsHolidays.getLocationsApplicable());

		return lmsHolidaysImpl;
	}

	/**
	 * Returns the l m s holidays with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s holidays
	 * @return the l m s holidays
	 * @throws com.trianz.lms.NoSuchHolidaysException if a l m s holidays with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHolidaysException, SystemException {
		LMSHolidays lmsHolidays = fetchByPrimaryKey(primaryKey);

		if (lmsHolidays == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHolidaysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsHolidays;
	}

	/**
	 * Returns the l m s holidays with the primary key or throws a {@link com.trianz.lms.NoSuchHolidaysException} if it could not be found.
	 *
	 * @param HolidayId the primary key of the l m s holidays
	 * @return the l m s holidays
	 * @throws com.trianz.lms.NoSuchHolidaysException if a l m s holidays with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays findByPrimaryKey(int HolidayId)
		throws NoSuchHolidaysException, SystemException {
		return findByPrimaryKey((Serializable)HolidayId);
	}

	/**
	 * Returns the l m s holidays with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s holidays
	 * @return the l m s holidays, or <code>null</code> if a l m s holidays with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSHolidays lmsHolidays = (LMSHolidays)EntityCacheUtil.getResult(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
				LMSHolidaysImpl.class, primaryKey);

		if (lmsHolidays == _nullLMSHolidays) {
			return null;
		}

		if (lmsHolidays == null) {
			Session session = null;

			try {
				session = openSession();

				lmsHolidays = (LMSHolidays)session.get(LMSHolidaysImpl.class,
						primaryKey);

				if (lmsHolidays != null) {
					cacheResult(lmsHolidays);
				}
				else {
					EntityCacheUtil.putResult(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
						LMSHolidaysImpl.class, primaryKey, _nullLMSHolidays);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSHolidaysModelImpl.ENTITY_CACHE_ENABLED,
					LMSHolidaysImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsHolidays;
	}

	/**
	 * Returns the l m s holidays with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param HolidayId the primary key of the l m s holidays
	 * @return the l m s holidays, or <code>null</code> if a l m s holidays with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSHolidays fetchByPrimaryKey(int HolidayId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)HolidayId);
	}

	/**
	 * Returns all the l m s holidayses.
	 *
	 * @return the l m s holidayses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSHolidays> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s holidayses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSHolidaysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s holidayses
	 * @param end the upper bound of the range of l m s holidayses (not inclusive)
	 * @return the range of l m s holidayses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSHolidays> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s holidayses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSHolidaysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s holidayses
	 * @param end the upper bound of the range of l m s holidayses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s holidayses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSHolidays> findAll(int start, int end,
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

		List<LMSHolidays> list = (List<LMSHolidays>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSHOLIDAYS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSHOLIDAYS;

				if (pagination) {
					sql = sql.concat(LMSHolidaysModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSHolidays>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSHolidays>(list);
				}
				else {
					list = (List<LMSHolidays>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l m s holidayses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSHolidays lmsHolidays : findAll()) {
			remove(lmsHolidays);
		}
	}

	/**
	 * Returns the number of l m s holidayses.
	 *
	 * @return the number of l m s holidayses
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

				Query q = session.createQuery(_SQL_COUNT_LMSHOLIDAYS);

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
	 * Initializes the l m s holidays persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSHolidays")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSHolidays>> listenersList = new ArrayList<ModelListener<LMSHolidays>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSHolidays>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSHolidaysImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSHOLIDAYS = "SELECT lmsHolidays FROM LMSHolidays lmsHolidays";
	private static final String _SQL_SELECT_LMSHOLIDAYS_WHERE = "SELECT lmsHolidays FROM LMSHolidays lmsHolidays WHERE ";
	private static final String _SQL_COUNT_LMSHOLIDAYS = "SELECT COUNT(lmsHolidays) FROM LMSHolidays lmsHolidays";
	private static final String _SQL_COUNT_LMSHOLIDAYS_WHERE = "SELECT COUNT(lmsHolidays) FROM LMSHolidays lmsHolidays WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsHolidays.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSHolidays exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSHolidays exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSHolidaysPersistenceImpl.class);
	private static LMSHolidays _nullLMSHolidays = new LMSHolidaysImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSHolidays> toCacheModel() {
				return _nullLMSHolidaysCacheModel;
			}
		};

	private static CacheModel<LMSHolidays> _nullLMSHolidaysCacheModel = new CacheModel<LMSHolidays>() {
			@Override
			public LMSHolidays toEntityModel() {
				return _nullLMSHolidays;
			}
		};
}