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

import com.trianz.lms.NoSuchLeaveBalanceException;
import com.trianz.lms.model.LeaveBalance;
import com.trianz.lms.model.impl.LeaveBalanceImpl;
import com.trianz.lms.model.impl.LeaveBalanceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave balance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveBalancePersistence
 * @see LeaveBalanceUtil
 * @generated
 */
public class LeaveBalancePersistenceImpl extends BasePersistenceImpl<LeaveBalance>
	implements LeaveBalancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveBalanceUtil} to access the leave balance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveBalanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceModelImpl.FINDER_CACHE_ENABLED, LeaveBalanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceModelImpl.FINDER_CACHE_ENABLED, LeaveBalanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceModelImpl.FINDER_CACHE_ENABLED, LeaveBalanceImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeID",
			new String[] { Integer.class.getName() },
			LeaveBalanceModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeID",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the leave balance where EmployeeId = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveBalanceException} if it could not be found.
	 *
	 * @param EmployeeId the employee ID
	 * @return the matching leave balance
	 * @throws com.trianz.lms.NoSuchLeaveBalanceException if a matching leave balance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance findByEmployeeID(int EmployeeId)
		throws NoSuchLeaveBalanceException, SystemException {
		LeaveBalance leaveBalance = fetchByEmployeeID(EmployeeId);

		if (leaveBalance == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EmployeeId=");
			msg.append(EmployeeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveBalanceException(msg.toString());
		}

		return leaveBalance;
	}

	/**
	 * Returns the leave balance where EmployeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EmployeeId the employee ID
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance fetchByEmployeeID(int EmployeeId)
		throws SystemException {
		return fetchByEmployeeID(EmployeeId, true);
	}

	/**
	 * Returns the leave balance where EmployeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EmployeeId the employee ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance fetchByEmployeeID(int EmployeeId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { EmployeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof LeaveBalance) {
			LeaveBalance leaveBalance = (LeaveBalance)result;

			if ((EmployeeId != leaveBalance.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EmployeeId);

				List<LeaveBalance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LeaveBalancePersistenceImpl.fetchByEmployeeID(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LeaveBalance leaveBalance = list.get(0);

					result = leaveBalance;

					cacheResult(leaveBalance);

					if ((leaveBalance.getEmployeeId() != EmployeeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
							finderArgs, leaveBalance);
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
			return (LeaveBalance)result;
		}
	}

	/**
	 * Removes the leave balance where EmployeeId = &#63; from the database.
	 *
	 * @param EmployeeId the employee ID
	 * @return the leave balance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance removeByEmployeeID(int EmployeeId)
		throws NoSuchLeaveBalanceException, SystemException {
		LeaveBalance leaveBalance = findByEmployeeID(EmployeeId);

		return remove(leaveBalance);
	}

	/**
	 * Returns the number of leave balances where EmployeeId = &#63;.
	 *
	 * @param EmployeeId the employee ID
	 * @return the number of matching leave balances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployeeID(int EmployeeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { EmployeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "leaveBalance.EmployeeId = ?";

	public LeaveBalancePersistenceImpl() {
		setModelClass(LeaveBalance.class);
	}

	/**
	 * Caches the leave balance in the entity cache if it is enabled.
	 *
	 * @param leaveBalance the leave balance
	 */
	@Override
	public void cacheResult(LeaveBalance leaveBalance) {
		EntityCacheUtil.putResult(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceImpl.class, leaveBalance.getPrimaryKey(), leaveBalance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] { leaveBalance.getEmployeeId() }, leaveBalance);

		leaveBalance.resetOriginalValues();
	}

	/**
	 * Caches the leave balances in the entity cache if it is enabled.
	 *
	 * @param leaveBalances the leave balances
	 */
	@Override
	public void cacheResult(List<LeaveBalance> leaveBalances) {
		for (LeaveBalance leaveBalance : leaveBalances) {
			if (EntityCacheUtil.getResult(
						LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
						LeaveBalanceImpl.class, leaveBalance.getPrimaryKey()) == null) {
				cacheResult(leaveBalance);
			}
			else {
				leaveBalance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave balances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveBalanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveBalanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave balance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveBalance leaveBalance) {
		EntityCacheUtil.removeResult(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceImpl.class, leaveBalance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(leaveBalance);
	}

	@Override
	public void clearCache(List<LeaveBalance> leaveBalances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveBalance leaveBalance : leaveBalances) {
			EntityCacheUtil.removeResult(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
				LeaveBalanceImpl.class, leaveBalance.getPrimaryKey());

			clearUniqueFindersCache(leaveBalance);
		}
	}

	protected void cacheUniqueFindersCache(LeaveBalance leaveBalance) {
		if (leaveBalance.isNew()) {
			Object[] args = new Object[] { leaveBalance.getEmployeeId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args,
				leaveBalance);
		}
		else {
			LeaveBalanceModelImpl leaveBalanceModelImpl = (LeaveBalanceModelImpl)leaveBalance;

			if ((leaveBalanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { leaveBalance.getEmployeeId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					args, leaveBalance);
			}
		}
	}

	protected void clearUniqueFindersCache(LeaveBalance leaveBalance) {
		LeaveBalanceModelImpl leaveBalanceModelImpl = (LeaveBalanceModelImpl)leaveBalance;

		Object[] args = new Object[] { leaveBalance.getEmployeeId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);

		if ((leaveBalanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			args = new Object[] { leaveBalanceModelImpl.getOriginalEmployeeId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}
	}

	/**
	 * Creates a new leave balance with the primary key. Does not add the leave balance to the database.
	 *
	 * @param EmployeeId the primary key for the new leave balance
	 * @return the new leave balance
	 */
	@Override
	public LeaveBalance create(int EmployeeId) {
		LeaveBalance leaveBalance = new LeaveBalanceImpl();

		leaveBalance.setNew(true);
		leaveBalance.setPrimaryKey(EmployeeId);

		return leaveBalance;
	}

	/**
	 * Removes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param EmployeeId the primary key of the leave balance
	 * @return the leave balance that was removed
	 * @throws com.trianz.lms.NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance remove(int EmployeeId)
		throws NoSuchLeaveBalanceException, SystemException {
		return remove((Serializable)EmployeeId);
	}

	/**
	 * Removes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave balance
	 * @return the leave balance that was removed
	 * @throws com.trianz.lms.NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance remove(Serializable primaryKey)
		throws NoSuchLeaveBalanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveBalance leaveBalance = (LeaveBalance)session.get(LeaveBalanceImpl.class,
					primaryKey);

			if (leaveBalance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveBalanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveBalance);
		}
		catch (NoSuchLeaveBalanceException nsee) {
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
	protected LeaveBalance removeImpl(LeaveBalance leaveBalance)
		throws SystemException {
		leaveBalance = toUnwrappedModel(leaveBalance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveBalance)) {
				leaveBalance = (LeaveBalance)session.get(LeaveBalanceImpl.class,
						leaveBalance.getPrimaryKeyObj());
			}

			if (leaveBalance != null) {
				session.delete(leaveBalance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveBalance != null) {
			clearCache(leaveBalance);
		}

		return leaveBalance;
	}

	@Override
	public LeaveBalance updateImpl(
		com.trianz.lms.model.LeaveBalance leaveBalance)
		throws SystemException {
		leaveBalance = toUnwrappedModel(leaveBalance);

		boolean isNew = leaveBalance.isNew();

		Session session = null;

		try {
			session = openSession();

			if (leaveBalance.isNew()) {
				session.save(leaveBalance);

				leaveBalance.setNew(false);
			}
			else {
				session.merge(leaveBalance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveBalanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
			LeaveBalanceImpl.class, leaveBalance.getPrimaryKey(), leaveBalance);

		clearUniqueFindersCache(leaveBalance);
		cacheUniqueFindersCache(leaveBalance);

		return leaveBalance;
	}

	protected LeaveBalance toUnwrappedModel(LeaveBalance leaveBalance) {
		if (leaveBalance instanceof LeaveBalanceImpl) {
			return leaveBalance;
		}

		LeaveBalanceImpl leaveBalanceImpl = new LeaveBalanceImpl();

		leaveBalanceImpl.setNew(leaveBalance.isNew());
		leaveBalanceImpl.setPrimaryKey(leaveBalance.getPrimaryKey());

		leaveBalanceImpl.setEmployeeId(leaveBalance.getEmployeeId());
		leaveBalanceImpl.setELBalance(leaveBalance.getELBalance());
		leaveBalanceImpl.setCLBalance(leaveBalance.getCLBalance());
		leaveBalanceImpl.setCompOffLeaveBalance(leaveBalance.getCompOffLeaveBalance());

		return leaveBalanceImpl;
	}

	/**
	 * Returns the leave balance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave balance
	 * @return the leave balance
	 * @throws com.trianz.lms.NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveBalanceException, SystemException {
		LeaveBalance leaveBalance = fetchByPrimaryKey(primaryKey);

		if (leaveBalance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveBalanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveBalance;
	}

	/**
	 * Returns the leave balance with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveBalanceException} if it could not be found.
	 *
	 * @param EmployeeId the primary key of the leave balance
	 * @return the leave balance
	 * @throws com.trianz.lms.NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance findByPrimaryKey(int EmployeeId)
		throws NoSuchLeaveBalanceException, SystemException {
		return findByPrimaryKey((Serializable)EmployeeId);
	}

	/**
	 * Returns the leave balance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave balance
	 * @return the leave balance, or <code>null</code> if a leave balance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveBalance leaveBalance = (LeaveBalance)EntityCacheUtil.getResult(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
				LeaveBalanceImpl.class, primaryKey);

		if (leaveBalance == _nullLeaveBalance) {
			return null;
		}

		if (leaveBalance == null) {
			Session session = null;

			try {
				session = openSession();

				leaveBalance = (LeaveBalance)session.get(LeaveBalanceImpl.class,
						primaryKey);

				if (leaveBalance != null) {
					cacheResult(leaveBalance);
				}
				else {
					EntityCacheUtil.putResult(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
						LeaveBalanceImpl.class, primaryKey, _nullLeaveBalance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveBalanceModelImpl.ENTITY_CACHE_ENABLED,
					LeaveBalanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveBalance;
	}

	/**
	 * Returns the leave balance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param EmployeeId the primary key of the leave balance
	 * @return the leave balance, or <code>null</code> if a leave balance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveBalance fetchByPrimaryKey(int EmployeeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)EmployeeId);
	}

	/**
	 * Returns all the leave balances.
	 *
	 * @return the leave balances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveBalance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of leave balances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveBalance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveBalanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave balances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveBalance> findAll(int start, int end,
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

		List<LeaveBalance> list = (List<LeaveBalance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVEBALANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEBALANCE;

				if (pagination) {
					sql = sql.concat(LeaveBalanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveBalance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveBalance>(list);
				}
				else {
					list = (List<LeaveBalance>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave balances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveBalance leaveBalance : findAll()) {
			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances.
	 *
	 * @return the number of leave balances
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

				Query q = session.createQuery(_SQL_COUNT_LEAVEBALANCE);

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
	 * Initializes the leave balance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LeaveBalance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveBalance>> listenersList = new ArrayList<ModelListener<LeaveBalance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveBalance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveBalanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVEBALANCE = "SELECT leaveBalance FROM LeaveBalance leaveBalance";
	private static final String _SQL_SELECT_LEAVEBALANCE_WHERE = "SELECT leaveBalance FROM LeaveBalance leaveBalance WHERE ";
	private static final String _SQL_COUNT_LEAVEBALANCE = "SELECT COUNT(leaveBalance) FROM LeaveBalance leaveBalance";
	private static final String _SQL_COUNT_LEAVEBALANCE_WHERE = "SELECT COUNT(leaveBalance) FROM LeaveBalance leaveBalance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveBalance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveBalance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveBalance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveBalancePersistenceImpl.class);
	private static LeaveBalance _nullLeaveBalance = new LeaveBalanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveBalance> toCacheModel() {
				return _nullLeaveBalanceCacheModel;
			}
		};

	private static CacheModel<LeaveBalance> _nullLeaveBalanceCacheModel = new CacheModel<LeaveBalance>() {
			@Override
			public LeaveBalance toEntityModel() {
				return _nullLeaveBalance;
			}
		};
}