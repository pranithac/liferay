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

import com.trianz.lms.NoSuchsecuraxEmployeeHrsException;
import com.trianz.lms.model.impl.securaxEmployeeHrsImpl;
import com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl;
import com.trianz.lms.model.securaxEmployeeHrs;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the securax employee hrs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see securaxEmployeeHrsPersistence
 * @see securaxEmployeeHrsUtil
 * @generated
 */
public class securaxEmployeeHrsPersistenceImpl extends BasePersistenceImpl<securaxEmployeeHrs>
	implements securaxEmployeeHrsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link securaxEmployeeHrsUtil} to access the securax employee hrs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = securaxEmployeeHrsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsModelImpl.FINDER_CACHE_ENABLED,
			securaxEmployeeHrsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsModelImpl.FINDER_CACHE_ENABLED,
			securaxEmployeeHrsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsModelImpl.FINDER_CACHE_ENABLED,
			securaxEmployeeHrsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmployeeId",
			new String[] { Integer.class.getName(), Date.class.getName() },
			securaxEmployeeHrsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			securaxEmployeeHrsModelImpl.PUNCHDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Integer.class.getName(), Date.class.getName() });

	/**
	 * Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or throws a {@link com.trianz.lms.NoSuchsecuraxEmployeeHrsException} if it could not be found.
	 *
	 * @param EmployeeId the employee ID
	 * @param PunchDate the punch date
	 * @return the matching securax employee hrs
	 * @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a matching securax employee hrs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs findByEmployeeId(int EmployeeId, Date PunchDate)
		throws NoSuchsecuraxEmployeeHrsException, SystemException {
		securaxEmployeeHrs securaxEmployeeHrs = fetchByEmployeeId(EmployeeId,
				PunchDate);

		if (securaxEmployeeHrs == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EmployeeId=");
			msg.append(EmployeeId);

			msg.append(", PunchDate=");
			msg.append(PunchDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchsecuraxEmployeeHrsException(msg.toString());
		}

		return securaxEmployeeHrs;
	}

	/**
	 * Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EmployeeId the employee ID
	 * @param PunchDate the punch date
	 * @return the matching securax employee hrs, or <code>null</code> if a matching securax employee hrs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs fetchByEmployeeId(int EmployeeId, Date PunchDate)
		throws SystemException {
		return fetchByEmployeeId(EmployeeId, PunchDate, true);
	}

	/**
	 * Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EmployeeId the employee ID
	 * @param PunchDate the punch date
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching securax employee hrs, or <code>null</code> if a matching securax employee hrs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs fetchByEmployeeId(int EmployeeId, Date PunchDate,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { EmployeeId, PunchDate };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof securaxEmployeeHrs) {
			securaxEmployeeHrs securaxEmployeeHrs = (securaxEmployeeHrs)result;

			if ((EmployeeId != securaxEmployeeHrs.getEmployeeId()) ||
					!Validator.equals(PunchDate,
						securaxEmployeeHrs.getPunchDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SECURAXEMPLOYEEHRS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			boolean bindPunchDate = false;

			if (PunchDate == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_1);
			}
			else {
				bindPunchDate = true;

				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

				if (bindPunchDate) {
					qPos.add(CalendarUtil.getTimestamp(PunchDate));
				}

				List<securaxEmployeeHrs> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"securaxEmployeeHrsPersistenceImpl.fetchByEmployeeId(int, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					securaxEmployeeHrs securaxEmployeeHrs = list.get(0);

					result = securaxEmployeeHrs;

					cacheResult(securaxEmployeeHrs);

					if ((securaxEmployeeHrs.getEmployeeId() != EmployeeId) ||
							(securaxEmployeeHrs.getPunchDate() == null) ||
							!securaxEmployeeHrs.getPunchDate().equals(PunchDate)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
							finderArgs, securaxEmployeeHrs);
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
			return (securaxEmployeeHrs)result;
		}
	}

	/**
	 * Removes the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; from the database.
	 *
	 * @param EmployeeId the employee ID
	 * @param PunchDate the punch date
	 * @return the securax employee hrs that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs removeByEmployeeId(int EmployeeId, Date PunchDate)
		throws NoSuchsecuraxEmployeeHrsException, SystemException {
		securaxEmployeeHrs securaxEmployeeHrs = findByEmployeeId(EmployeeId,
				PunchDate);

		return remove(securaxEmployeeHrs);
	}

	/**
	 * Returns the number of securax employee hrses where EmployeeId = &#63; and PunchDate = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @param PunchDate the punch date
	 * @return the number of matching securax employee hrses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployeeId(int EmployeeId, Date PunchDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { EmployeeId, PunchDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SECURAXEMPLOYEEHRS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			boolean bindPunchDate = false;

			if (PunchDate == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_1);
			}
			else {
				bindPunchDate = true;

				query.append(_FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

				if (bindPunchDate) {
					qPos.add(CalendarUtil.getTimestamp(PunchDate));
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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "securaxEmployeeHrs.EmployeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_1 = "securaxEmployeeHrs.PunchDate IS NULL";
	private static final String _FINDER_COLUMN_EMPLOYEEID_PUNCHDATE_2 = "securaxEmployeeHrs.PunchDate = ?";

	public securaxEmployeeHrsPersistenceImpl() {
		setModelClass(securaxEmployeeHrs.class);
	}

	/**
	 * Caches the securax employee hrs in the entity cache if it is enabled.
	 *
	 * @param securaxEmployeeHrs the securax employee hrs
	 */
	@Override
	public void cacheResult(securaxEmployeeHrs securaxEmployeeHrs) {
		EntityCacheUtil.putResult(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsImpl.class, securaxEmployeeHrs.getPrimaryKey(),
			securaxEmployeeHrs);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] {
				securaxEmployeeHrs.getEmployeeId(),
				securaxEmployeeHrs.getPunchDate()
			}, securaxEmployeeHrs);

		securaxEmployeeHrs.resetOriginalValues();
	}

	/**
	 * Caches the securax employee hrses in the entity cache if it is enabled.
	 *
	 * @param securaxEmployeeHrses the securax employee hrses
	 */
	@Override
	public void cacheResult(List<securaxEmployeeHrs> securaxEmployeeHrses) {
		for (securaxEmployeeHrs securaxEmployeeHrs : securaxEmployeeHrses) {
			if (EntityCacheUtil.getResult(
						securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
						securaxEmployeeHrsImpl.class,
						securaxEmployeeHrs.getPrimaryKey()) == null) {
				cacheResult(securaxEmployeeHrs);
			}
			else {
				securaxEmployeeHrs.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all securax employee hrses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(securaxEmployeeHrsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(securaxEmployeeHrsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the securax employee hrs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(securaxEmployeeHrs securaxEmployeeHrs) {
		EntityCacheUtil.removeResult(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsImpl.class, securaxEmployeeHrs.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(securaxEmployeeHrs);
	}

	@Override
	public void clearCache(List<securaxEmployeeHrs> securaxEmployeeHrses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (securaxEmployeeHrs securaxEmployeeHrs : securaxEmployeeHrses) {
			EntityCacheUtil.removeResult(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
				securaxEmployeeHrsImpl.class, securaxEmployeeHrs.getPrimaryKey());

			clearUniqueFindersCache(securaxEmployeeHrs);
		}
	}

	protected void cacheUniqueFindersCache(
		securaxEmployeeHrs securaxEmployeeHrs) {
		if (securaxEmployeeHrs.isNew()) {
			Object[] args = new Object[] {
					securaxEmployeeHrs.getEmployeeId(),
					securaxEmployeeHrs.getPunchDate()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args,
				securaxEmployeeHrs);
		}
		else {
			securaxEmployeeHrsModelImpl securaxEmployeeHrsModelImpl = (securaxEmployeeHrsModelImpl)securaxEmployeeHrs;

			if ((securaxEmployeeHrsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						securaxEmployeeHrs.getEmployeeId(),
						securaxEmployeeHrs.getPunchDate()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					args, securaxEmployeeHrs);
			}
		}
	}

	protected void clearUniqueFindersCache(
		securaxEmployeeHrs securaxEmployeeHrs) {
		securaxEmployeeHrsModelImpl securaxEmployeeHrsModelImpl = (securaxEmployeeHrsModelImpl)securaxEmployeeHrs;

		Object[] args = new Object[] {
				securaxEmployeeHrs.getEmployeeId(),
				securaxEmployeeHrs.getPunchDate()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);

		if ((securaxEmployeeHrsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					securaxEmployeeHrsModelImpl.getOriginalEmployeeId(),
					securaxEmployeeHrsModelImpl.getOriginalPunchDate()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}
	}

	/**
	 * Creates a new securax employee hrs with the primary key. Does not add the securax employee hrs to the database.
	 *
	 * @param EmployeeId the primary key for the new securax employee hrs
	 * @return the new securax employee hrs
	 */
	@Override
	public securaxEmployeeHrs create(int EmployeeId) {
		securaxEmployeeHrs securaxEmployeeHrs = new securaxEmployeeHrsImpl();

		securaxEmployeeHrs.setNew(true);
		securaxEmployeeHrs.setPrimaryKey(EmployeeId);

		return securaxEmployeeHrs;
	}

	/**
	 * Removes the securax employee hrs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param EmployeeId the primary key of the securax employee hrs
	 * @return the securax employee hrs that was removed
	 * @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs remove(int EmployeeId)
		throws NoSuchsecuraxEmployeeHrsException, SystemException {
		return remove((Serializable)EmployeeId);
	}

	/**
	 * Removes the securax employee hrs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the securax employee hrs
	 * @return the securax employee hrs that was removed
	 * @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs remove(Serializable primaryKey)
		throws NoSuchsecuraxEmployeeHrsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			securaxEmployeeHrs securaxEmployeeHrs = (securaxEmployeeHrs)session.get(securaxEmployeeHrsImpl.class,
					primaryKey);

			if (securaxEmployeeHrs == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchsecuraxEmployeeHrsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(securaxEmployeeHrs);
		}
		catch (NoSuchsecuraxEmployeeHrsException nsee) {
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
	protected securaxEmployeeHrs removeImpl(
		securaxEmployeeHrs securaxEmployeeHrs) throws SystemException {
		securaxEmployeeHrs = toUnwrappedModel(securaxEmployeeHrs);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(securaxEmployeeHrs)) {
				securaxEmployeeHrs = (securaxEmployeeHrs)session.get(securaxEmployeeHrsImpl.class,
						securaxEmployeeHrs.getPrimaryKeyObj());
			}

			if (securaxEmployeeHrs != null) {
				session.delete(securaxEmployeeHrs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (securaxEmployeeHrs != null) {
			clearCache(securaxEmployeeHrs);
		}

		return securaxEmployeeHrs;
	}

	@Override
	public securaxEmployeeHrs updateImpl(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs)
		throws SystemException {
		securaxEmployeeHrs = toUnwrappedModel(securaxEmployeeHrs);

		boolean isNew = securaxEmployeeHrs.isNew();

		Session session = null;

		try {
			session = openSession();

			if (securaxEmployeeHrs.isNew()) {
				session.save(securaxEmployeeHrs);

				securaxEmployeeHrs.setNew(false);
			}
			else {
				session.merge(securaxEmployeeHrs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !securaxEmployeeHrsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
			securaxEmployeeHrsImpl.class, securaxEmployeeHrs.getPrimaryKey(),
			securaxEmployeeHrs);

		clearUniqueFindersCache(securaxEmployeeHrs);
		cacheUniqueFindersCache(securaxEmployeeHrs);

		return securaxEmployeeHrs;
	}

	protected securaxEmployeeHrs toUnwrappedModel(
		securaxEmployeeHrs securaxEmployeeHrs) {
		if (securaxEmployeeHrs instanceof securaxEmployeeHrsImpl) {
			return securaxEmployeeHrs;
		}

		securaxEmployeeHrsImpl securaxEmployeeHrsImpl = new securaxEmployeeHrsImpl();

		securaxEmployeeHrsImpl.setNew(securaxEmployeeHrs.isNew());
		securaxEmployeeHrsImpl.setPrimaryKey(securaxEmployeeHrs.getPrimaryKey());

		securaxEmployeeHrsImpl.setEmployeeId(securaxEmployeeHrs.getEmployeeId());
		securaxEmployeeHrsImpl.setPunchDate(securaxEmployeeHrs.getPunchDate());
		securaxEmployeeHrsImpl.setPunchInTime(securaxEmployeeHrs.getPunchInTime());
		securaxEmployeeHrsImpl.setPunchOutTime(securaxEmployeeHrs.getPunchOutTime());
		securaxEmployeeHrsImpl.setWorkHrsPerday(securaxEmployeeHrs.getWorkHrsPerday());
		securaxEmployeeHrsImpl.setStatus(securaxEmployeeHrs.getStatus());
		securaxEmployeeHrsImpl.setOT(securaxEmployeeHrs.getOT());
		securaxEmployeeHrsImpl.setCreated_By(securaxEmployeeHrs.getCreated_By());
		securaxEmployeeHrsImpl.setCreated_Date(securaxEmployeeHrs.getCreated_Date());
		securaxEmployeeHrsImpl.setModified_By(securaxEmployeeHrs.getModified_By());
		securaxEmployeeHrsImpl.setModified_Date(securaxEmployeeHrs.getModified_Date());
		securaxEmployeeHrsImpl.setS_Id(securaxEmployeeHrs.getS_Id());

		return securaxEmployeeHrsImpl;
	}

	/**
	 * Returns the securax employee hrs with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the securax employee hrs
	 * @return the securax employee hrs
	 * @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchsecuraxEmployeeHrsException, SystemException {
		securaxEmployeeHrs securaxEmployeeHrs = fetchByPrimaryKey(primaryKey);

		if (securaxEmployeeHrs == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchsecuraxEmployeeHrsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return securaxEmployeeHrs;
	}

	/**
	 * Returns the securax employee hrs with the primary key or throws a {@link com.trianz.lms.NoSuchsecuraxEmployeeHrsException} if it could not be found.
	 *
	 * @param EmployeeId the primary key of the securax employee hrs
	 * @return the securax employee hrs
	 * @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs findByPrimaryKey(int EmployeeId)
		throws NoSuchsecuraxEmployeeHrsException, SystemException {
		return findByPrimaryKey((Serializable)EmployeeId);
	}

	/**
	 * Returns the securax employee hrs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the securax employee hrs
	 * @return the securax employee hrs, or <code>null</code> if a securax employee hrs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		securaxEmployeeHrs securaxEmployeeHrs = (securaxEmployeeHrs)EntityCacheUtil.getResult(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
				securaxEmployeeHrsImpl.class, primaryKey);

		if (securaxEmployeeHrs == _nullsecuraxEmployeeHrs) {
			return null;
		}

		if (securaxEmployeeHrs == null) {
			Session session = null;

			try {
				session = openSession();

				securaxEmployeeHrs = (securaxEmployeeHrs)session.get(securaxEmployeeHrsImpl.class,
						primaryKey);

				if (securaxEmployeeHrs != null) {
					cacheResult(securaxEmployeeHrs);
				}
				else {
					EntityCacheUtil.putResult(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
						securaxEmployeeHrsImpl.class, primaryKey,
						_nullsecuraxEmployeeHrs);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(securaxEmployeeHrsModelImpl.ENTITY_CACHE_ENABLED,
					securaxEmployeeHrsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return securaxEmployeeHrs;
	}

	/**
	 * Returns the securax employee hrs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param EmployeeId the primary key of the securax employee hrs
	 * @return the securax employee hrs, or <code>null</code> if a securax employee hrs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public securaxEmployeeHrs fetchByPrimaryKey(int EmployeeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)EmployeeId);
	}

	/**
	 * Returns all the securax employee hrses.
	 *
	 * @return the securax employee hrses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<securaxEmployeeHrs> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the securax employee hrses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of securax employee hrses
	 * @param end the upper bound of the range of securax employee hrses (not inclusive)
	 * @return the range of securax employee hrses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<securaxEmployeeHrs> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the securax employee hrses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.securaxEmployeeHrsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of securax employee hrses
	 * @param end the upper bound of the range of securax employee hrses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of securax employee hrses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<securaxEmployeeHrs> findAll(int start, int end,
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

		List<securaxEmployeeHrs> list = (List<securaxEmployeeHrs>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SECURAXEMPLOYEEHRS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SECURAXEMPLOYEEHRS;

				if (pagination) {
					sql = sql.concat(securaxEmployeeHrsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<securaxEmployeeHrs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<securaxEmployeeHrs>(list);
				}
				else {
					list = (List<securaxEmployeeHrs>)QueryUtil.list(q,
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
	 * Removes all the securax employee hrses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (securaxEmployeeHrs securaxEmployeeHrs : findAll()) {
			remove(securaxEmployeeHrs);
		}
	}

	/**
	 * Returns the number of securax employee hrses.
	 *
	 * @return the number of securax employee hrses
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

				Query q = session.createQuery(_SQL_COUNT_SECURAXEMPLOYEEHRS);

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
	 * Initializes the securax employee hrs persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.securaxEmployeeHrs")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<securaxEmployeeHrs>> listenersList = new ArrayList<ModelListener<securaxEmployeeHrs>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<securaxEmployeeHrs>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(securaxEmployeeHrsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SECURAXEMPLOYEEHRS = "SELECT securaxEmployeeHrs FROM securaxEmployeeHrs securaxEmployeeHrs";
	private static final String _SQL_SELECT_SECURAXEMPLOYEEHRS_WHERE = "SELECT securaxEmployeeHrs FROM securaxEmployeeHrs securaxEmployeeHrs WHERE ";
	private static final String _SQL_COUNT_SECURAXEMPLOYEEHRS = "SELECT COUNT(securaxEmployeeHrs) FROM securaxEmployeeHrs securaxEmployeeHrs";
	private static final String _SQL_COUNT_SECURAXEMPLOYEEHRS_WHERE = "SELECT COUNT(securaxEmployeeHrs) FROM securaxEmployeeHrs securaxEmployeeHrs WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "securaxEmployeeHrs.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No securaxEmployeeHrs exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No securaxEmployeeHrs exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(securaxEmployeeHrsPersistenceImpl.class);
	private static securaxEmployeeHrs _nullsecuraxEmployeeHrs = new securaxEmployeeHrsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<securaxEmployeeHrs> toCacheModel() {
				return _nullsecuraxEmployeeHrsCacheModel;
			}
		};

	private static CacheModel<securaxEmployeeHrs> _nullsecuraxEmployeeHrsCacheModel =
		new CacheModel<securaxEmployeeHrs>() {
			@Override
			public securaxEmployeeHrs toEntityModel() {
				return _nullsecuraxEmployeeHrs;
			}
		};
}