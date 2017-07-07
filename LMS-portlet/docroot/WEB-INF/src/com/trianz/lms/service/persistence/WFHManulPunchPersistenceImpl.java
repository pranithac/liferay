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

import com.trianz.lms.NoSuchWFHManulPunchException;
import com.trianz.lms.model.WFHManulPunch;
import com.trianz.lms.model.impl.WFHManulPunchImpl;
import com.trianz.lms.model.impl.WFHManulPunchModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the w f h manul punch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see WFHManulPunchPersistence
 * @see WFHManulPunchUtil
 * @generated
 */
public class WFHManulPunchPersistenceImpl extends BasePersistenceImpl<WFHManulPunch>
	implements WFHManulPunchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFHManulPunchUtil} to access the w f h manul punch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFHManulPunchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchModelImpl.FINDER_CACHE_ENABLED,
			WFHManulPunchImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchModelImpl.FINDER_CACHE_ENABLED,
			WFHManulPunchImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchModelImpl.FINDER_CACHE_ENABLED,
			WFHManulPunchImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmployeeID",
			new String[] { Integer.class.getName(), Date.class.getName() },
			WFHManulPunchModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			WFHManulPunchModelImpl.PUNCHDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeID",
			new String[] { Integer.class.getName(), Date.class.getName() });

	/**
	 * Returns the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; or throws a {@link com.trianz.lms.NoSuchWFHManulPunchException} if it could not be found.
	 *
	 * @param EmployeeID the employee i d
	 * @param PUNCHDATE the p u n c h d a t e
	 * @return the matching w f h manul punch
	 * @throws com.trianz.lms.NoSuchWFHManulPunchException if a matching w f h manul punch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch findByEmployeeID(int EmployeeID, Date PUNCHDATE)
		throws NoSuchWFHManulPunchException, SystemException {
		WFHManulPunch wfhManulPunch = fetchByEmployeeID(EmployeeID, PUNCHDATE);

		if (wfhManulPunch == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EmployeeID=");
			msg.append(EmployeeID);

			msg.append(", PUNCHDATE=");
			msg.append(PUNCHDATE);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWFHManulPunchException(msg.toString());
		}

		return wfhManulPunch;
	}

	/**
	 * Returns the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EmployeeID the employee i d
	 * @param PUNCHDATE the p u n c h d a t e
	 * @return the matching w f h manul punch, or <code>null</code> if a matching w f h manul punch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch fetchByEmployeeID(int EmployeeID, Date PUNCHDATE)
		throws SystemException {
		return fetchByEmployeeID(EmployeeID, PUNCHDATE, true);
	}

	/**
	 * Returns the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EmployeeID the employee i d
	 * @param PUNCHDATE the p u n c h d a t e
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching w f h manul punch, or <code>null</code> if a matching w f h manul punch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch fetchByEmployeeID(int EmployeeID, Date PUNCHDATE,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { EmployeeID, PUNCHDATE };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof WFHManulPunch) {
			WFHManulPunch wfhManulPunch = (WFHManulPunch)result;

			if ((EmployeeID != wfhManulPunch.getEmployeeID()) ||
					!Validator.equals(PUNCHDATE, wfhManulPunch.getPUNCHDATE())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WFHMANULPUNCH_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			boolean bindPUNCHDATE = false;

			if (PUNCHDATE == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_1);
			}
			else {
				bindPUNCHDATE = true;

				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeID);

				if (bindPUNCHDATE) {
					qPos.add(CalendarUtil.getTimestamp(PUNCHDATE));
				}

				List<WFHManulPunch> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"WFHManulPunchPersistenceImpl.fetchByEmployeeID(int, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					WFHManulPunch wfhManulPunch = list.get(0);

					result = wfhManulPunch;

					cacheResult(wfhManulPunch);

					if ((wfhManulPunch.getEmployeeID() != EmployeeID) ||
							(wfhManulPunch.getPUNCHDATE() == null) ||
							!wfhManulPunch.getPUNCHDATE().equals(PUNCHDATE)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
							finderArgs, wfhManulPunch);
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
			return (WFHManulPunch)result;
		}
	}

	/**
	 * Removes the w f h manul punch where EmployeeID = &#63; and PUNCHDATE = &#63; from the database.
	 *
	 * @param EmployeeID the employee i d
	 * @param PUNCHDATE the p u n c h d a t e
	 * @return the w f h manul punch that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch removeByEmployeeID(int EmployeeID, Date PUNCHDATE)
		throws NoSuchWFHManulPunchException, SystemException {
		WFHManulPunch wfhManulPunch = findByEmployeeID(EmployeeID, PUNCHDATE);

		return remove(wfhManulPunch);
	}

	/**
	 * Returns the number of w f h manul punchs where EmployeeID = &#63; and PUNCHDATE = &#63;.
	 *
	 * @param EmployeeID the employee i d
	 * @param PUNCHDATE the p u n c h d a t e
	 * @return the number of matching w f h manul punchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployeeID(int EmployeeID, Date PUNCHDATE)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { EmployeeID, PUNCHDATE };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WFHMANULPUNCH_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			boolean bindPUNCHDATE = false;

			if (PUNCHDATE == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_1);
			}
			else {
				bindPUNCHDATE = true;

				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeID);

				if (bindPUNCHDATE) {
					qPos.add(CalendarUtil.getTimestamp(PUNCHDATE));
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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "wfhManulPunch.EmployeeID = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_1 = "wfhManulPunch.PUNCHDATE IS NULL";
	private static final String _FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_2 = "wfhManulPunch.PUNCHDATE = ?";

	public WFHManulPunchPersistenceImpl() {
		setModelClass(WFHManulPunch.class);
	}

	/**
	 * Caches the w f h manul punch in the entity cache if it is enabled.
	 *
	 * @param wfhManulPunch the w f h manul punch
	 */
	@Override
	public void cacheResult(WFHManulPunch wfhManulPunch) {
		EntityCacheUtil.putResult(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchImpl.class, wfhManulPunch.getPrimaryKey(),
			wfhManulPunch);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] {
				wfhManulPunch.getEmployeeID(), wfhManulPunch.getPUNCHDATE()
			}, wfhManulPunch);

		wfhManulPunch.resetOriginalValues();
	}

	/**
	 * Caches the w f h manul punchs in the entity cache if it is enabled.
	 *
	 * @param wfhManulPunchs the w f h manul punchs
	 */
	@Override
	public void cacheResult(List<WFHManulPunch> wfhManulPunchs) {
		for (WFHManulPunch wfhManulPunch : wfhManulPunchs) {
			if (EntityCacheUtil.getResult(
						WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
						WFHManulPunchImpl.class, wfhManulPunch.getPrimaryKey()) == null) {
				cacheResult(wfhManulPunch);
			}
			else {
				wfhManulPunch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w f h manul punchs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WFHManulPunchImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WFHManulPunchImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w f h manul punch.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFHManulPunch wfhManulPunch) {
		EntityCacheUtil.removeResult(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchImpl.class, wfhManulPunch.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(wfhManulPunch);
	}

	@Override
	public void clearCache(List<WFHManulPunch> wfhManulPunchs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFHManulPunch wfhManulPunch : wfhManulPunchs) {
			EntityCacheUtil.removeResult(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
				WFHManulPunchImpl.class, wfhManulPunch.getPrimaryKey());

			clearUniqueFindersCache(wfhManulPunch);
		}
	}

	protected void cacheUniqueFindersCache(WFHManulPunch wfhManulPunch) {
		if (wfhManulPunch.isNew()) {
			Object[] args = new Object[] {
					wfhManulPunch.getEmployeeID(), wfhManulPunch.getPUNCHDATE()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args,
				wfhManulPunch);
		}
		else {
			WFHManulPunchModelImpl wfhManulPunchModelImpl = (WFHManulPunchModelImpl)wfhManulPunch;

			if ((wfhManulPunchModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfhManulPunch.getEmployeeID(),
						wfhManulPunch.getPUNCHDATE()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					args, wfhManulPunch);
			}
		}
	}

	protected void clearUniqueFindersCache(WFHManulPunch wfhManulPunch) {
		WFHManulPunchModelImpl wfhManulPunchModelImpl = (WFHManulPunchModelImpl)wfhManulPunch;

		Object[] args = new Object[] {
				wfhManulPunch.getEmployeeID(), wfhManulPunch.getPUNCHDATE()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);

		if ((wfhManulPunchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					wfhManulPunchModelImpl.getOriginalEmployeeID(),
					wfhManulPunchModelImpl.getOriginalPUNCHDATE()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}
	}

	/**
	 * Creates a new w f h manul punch with the primary key. Does not add the w f h manul punch to the database.
	 *
	 * @param WFHManualPunchId the primary key for the new w f h manul punch
	 * @return the new w f h manul punch
	 */
	@Override
	public WFHManulPunch create(int WFHManualPunchId) {
		WFHManulPunch wfhManulPunch = new WFHManulPunchImpl();

		wfhManulPunch.setNew(true);
		wfhManulPunch.setPrimaryKey(WFHManualPunchId);

		return wfhManulPunch;
	}

	/**
	 * Removes the w f h manul punch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param WFHManualPunchId the primary key of the w f h manul punch
	 * @return the w f h manul punch that was removed
	 * @throws com.trianz.lms.NoSuchWFHManulPunchException if a w f h manul punch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch remove(int WFHManualPunchId)
		throws NoSuchWFHManulPunchException, SystemException {
		return remove((Serializable)WFHManualPunchId);
	}

	/**
	 * Removes the w f h manul punch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w f h manul punch
	 * @return the w f h manul punch that was removed
	 * @throws com.trianz.lms.NoSuchWFHManulPunchException if a w f h manul punch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch remove(Serializable primaryKey)
		throws NoSuchWFHManulPunchException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WFHManulPunch wfhManulPunch = (WFHManulPunch)session.get(WFHManulPunchImpl.class,
					primaryKey);

			if (wfhManulPunch == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFHManulPunchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfhManulPunch);
		}
		catch (NoSuchWFHManulPunchException nsee) {
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
	protected WFHManulPunch removeImpl(WFHManulPunch wfhManulPunch)
		throws SystemException {
		wfhManulPunch = toUnwrappedModel(wfhManulPunch);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfhManulPunch)) {
				wfhManulPunch = (WFHManulPunch)session.get(WFHManulPunchImpl.class,
						wfhManulPunch.getPrimaryKeyObj());
			}

			if (wfhManulPunch != null) {
				session.delete(wfhManulPunch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfhManulPunch != null) {
			clearCache(wfhManulPunch);
		}

		return wfhManulPunch;
	}

	@Override
	public WFHManulPunch updateImpl(
		com.trianz.lms.model.WFHManulPunch wfhManulPunch)
		throws SystemException {
		wfhManulPunch = toUnwrappedModel(wfhManulPunch);

		boolean isNew = wfhManulPunch.isNew();

		Session session = null;

		try {
			session = openSession();

			if (wfhManulPunch.isNew()) {
				session.save(wfhManulPunch);

				wfhManulPunch.setNew(false);
			}
			else {
				session.merge(wfhManulPunch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WFHManulPunchModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
			WFHManulPunchImpl.class, wfhManulPunch.getPrimaryKey(),
			wfhManulPunch);

		clearUniqueFindersCache(wfhManulPunch);
		cacheUniqueFindersCache(wfhManulPunch);

		return wfhManulPunch;
	}

	protected WFHManulPunch toUnwrappedModel(WFHManulPunch wfhManulPunch) {
		if (wfhManulPunch instanceof WFHManulPunchImpl) {
			return wfhManulPunch;
		}

		WFHManulPunchImpl wfhManulPunchImpl = new WFHManulPunchImpl();

		wfhManulPunchImpl.setNew(wfhManulPunch.isNew());
		wfhManulPunchImpl.setPrimaryKey(wfhManulPunch.getPrimaryKey());

		wfhManulPunchImpl.setWFHManualPunchId(wfhManulPunch.getWFHManualPunchId());
		wfhManulPunchImpl.setWFHID(wfhManulPunch.getWFHID());
		wfhManulPunchImpl.setIntime(wfhManulPunch.getIntime());
		wfhManulPunchImpl.setOutTime(wfhManulPunch.getOutTime());
		wfhManulPunchImpl.setCreatedBy(wfhManulPunch.getCreatedBy());
		wfhManulPunchImpl.setCreatedDate(wfhManulPunch.getCreatedDate());
		wfhManulPunchImpl.setModifiedBy(wfhManulPunch.getModifiedBy());
		wfhManulPunchImpl.setModifiedDate(wfhManulPunch.getModifiedDate());
		wfhManulPunchImpl.setPUNCHDATE(wfhManulPunch.getPUNCHDATE());
		wfhManulPunchImpl.setEmployeeID(wfhManulPunch.getEmployeeID());
		wfhManulPunchImpl.setIsApproved(wfhManulPunch.isIsApproved());

		return wfhManulPunchImpl;
	}

	/**
	 * Returns the w f h manul punch with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w f h manul punch
	 * @return the w f h manul punch
	 * @throws com.trianz.lms.NoSuchWFHManulPunchException if a w f h manul punch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFHManulPunchException, SystemException {
		WFHManulPunch wfhManulPunch = fetchByPrimaryKey(primaryKey);

		if (wfhManulPunch == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFHManulPunchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfhManulPunch;
	}

	/**
	 * Returns the w f h manul punch with the primary key or throws a {@link com.trianz.lms.NoSuchWFHManulPunchException} if it could not be found.
	 *
	 * @param WFHManualPunchId the primary key of the w f h manul punch
	 * @return the w f h manul punch
	 * @throws com.trianz.lms.NoSuchWFHManulPunchException if a w f h manul punch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch findByPrimaryKey(int WFHManualPunchId)
		throws NoSuchWFHManulPunchException, SystemException {
		return findByPrimaryKey((Serializable)WFHManualPunchId);
	}

	/**
	 * Returns the w f h manul punch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w f h manul punch
	 * @return the w f h manul punch, or <code>null</code> if a w f h manul punch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WFHManulPunch wfhManulPunch = (WFHManulPunch)EntityCacheUtil.getResult(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
				WFHManulPunchImpl.class, primaryKey);

		if (wfhManulPunch == _nullWFHManulPunch) {
			return null;
		}

		if (wfhManulPunch == null) {
			Session session = null;

			try {
				session = openSession();

				wfhManulPunch = (WFHManulPunch)session.get(WFHManulPunchImpl.class,
						primaryKey);

				if (wfhManulPunch != null) {
					cacheResult(wfhManulPunch);
				}
				else {
					EntityCacheUtil.putResult(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
						WFHManulPunchImpl.class, primaryKey, _nullWFHManulPunch);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WFHManulPunchModelImpl.ENTITY_CACHE_ENABLED,
					WFHManulPunchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfhManulPunch;
	}

	/**
	 * Returns the w f h manul punch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param WFHManualPunchId the primary key of the w f h manul punch
	 * @return the w f h manul punch, or <code>null</code> if a w f h manul punch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WFHManulPunch fetchByPrimaryKey(int WFHManualPunchId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)WFHManualPunchId);
	}

	/**
	 * Returns all the w f h manul punchs.
	 *
	 * @return the w f h manul punchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WFHManulPunch> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w f h manul punchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.WFHManulPunchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of w f h manul punchs
	 * @param end the upper bound of the range of w f h manul punchs (not inclusive)
	 * @return the range of w f h manul punchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WFHManulPunch> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w f h manul punchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.WFHManulPunchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of w f h manul punchs
	 * @param end the upper bound of the range of w f h manul punchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w f h manul punchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WFHManulPunch> findAll(int start, int end,
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

		List<WFHManulPunch> list = (List<WFHManulPunch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WFHMANULPUNCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFHMANULPUNCH;

				if (pagination) {
					sql = sql.concat(WFHManulPunchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFHManulPunch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WFHManulPunch>(list);
				}
				else {
					list = (List<WFHManulPunch>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the w f h manul punchs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WFHManulPunch wfhManulPunch : findAll()) {
			remove(wfhManulPunch);
		}
	}

	/**
	 * Returns the number of w f h manul punchs.
	 *
	 * @return the number of w f h manul punchs
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

				Query q = session.createQuery(_SQL_COUNT_WFHMANULPUNCH);

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
	 * Initializes the w f h manul punch persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.WFHManulPunch")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WFHManulPunch>> listenersList = new ArrayList<ModelListener<WFHManulPunch>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WFHManulPunch>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WFHManulPunchImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WFHMANULPUNCH = "SELECT wfhManulPunch FROM WFHManulPunch wfhManulPunch";
	private static final String _SQL_SELECT_WFHMANULPUNCH_WHERE = "SELECT wfhManulPunch FROM WFHManulPunch wfhManulPunch WHERE ";
	private static final String _SQL_COUNT_WFHMANULPUNCH = "SELECT COUNT(wfhManulPunch) FROM WFHManulPunch wfhManulPunch";
	private static final String _SQL_COUNT_WFHMANULPUNCH_WHERE = "SELECT COUNT(wfhManulPunch) FROM WFHManulPunch wfhManulPunch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfhManulPunch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFHManulPunch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFHManulPunch exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WFHManulPunchPersistenceImpl.class);
	private static WFHManulPunch _nullWFHManulPunch = new WFHManulPunchImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WFHManulPunch> toCacheModel() {
				return _nullWFHManulPunchCacheModel;
			}
		};

	private static CacheModel<WFHManulPunch> _nullWFHManulPunchCacheModel = new CacheModel<WFHManulPunch>() {
			@Override
			public WFHManulPunch toEntityModel() {
				return _nullWFHManulPunch;
			}
		};
}