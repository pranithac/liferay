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

import com.trianz.lms.NoSuchWeekendsException;
import com.trianz.lms.model.LMSWeekends;
import com.trianz.lms.model.impl.LMSWeekendsImpl;
import com.trianz.lms.model.impl.LMSWeekendsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s weekends service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSWeekendsPersistence
 * @see LMSWeekendsUtil
 * @generated
 */
public class LMSWeekendsPersistenceImpl extends BasePersistenceImpl<LMSWeekends>
	implements LMSWeekendsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSWeekendsUtil} to access the l m s weekends persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSWeekendsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsModelImpl.FINDER_CACHE_ENABLED, LMSWeekendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsModelImpl.FINDER_CACHE_ENABLED, LMSWeekendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LOCATION = new FinderPath(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsModelImpl.FINDER_CACHE_ENABLED, LMSWeekendsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLocation",
			new String[] { String.class.getName() },
			LMSWeekendsModelImpl.LOCATION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATION = new FinderPath(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocation",
			new String[] { String.class.getName() });

	/**
	 * Returns the l m s weekends where Location = &#63; or throws a {@link com.trianz.lms.NoSuchWeekendsException} if it could not be found.
	 *
	 * @param Location the location
	 * @return the matching l m s weekends
	 * @throws com.trianz.lms.NoSuchWeekendsException if a matching l m s weekends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends findByLocation(String Location)
		throws NoSuchWeekendsException, SystemException {
		LMSWeekends lmsWeekends = fetchByLocation(Location);

		if (lmsWeekends == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("Location=");
			msg.append(Location);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWeekendsException(msg.toString());
		}

		return lmsWeekends;
	}

	/**
	 * Returns the l m s weekends where Location = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Location the location
	 * @return the matching l m s weekends, or <code>null</code> if a matching l m s weekends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends fetchByLocation(String Location)
		throws SystemException {
		return fetchByLocation(Location, true);
	}

	/**
	 * Returns the l m s weekends where Location = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Location the location
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s weekends, or <code>null</code> if a matching l m s weekends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends fetchByLocation(String Location,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { Location };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LOCATION,
					finderArgs, this);
		}

		if (result instanceof LMSWeekends) {
			LMSWeekends lmsWeekends = (LMSWeekends)result;

			if (!Validator.equals(Location, lmsWeekends.getLocation())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSWEEKENDS_WHERE);

			boolean bindLocation = false;

			if (Location == null) {
				query.append(_FINDER_COLUMN_LOCATION_LOCATION_1);
			}
			else if (Location.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				query.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocation) {
					qPos.add(Location);
				}

				List<LMSWeekends> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCATION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LMSWeekendsPersistenceImpl.fetchByLocation(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LMSWeekends lmsWeekends = list.get(0);

					result = lmsWeekends;

					cacheResult(lmsWeekends);

					if ((lmsWeekends.getLocation() == null) ||
							!lmsWeekends.getLocation().equals(Location)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCATION,
							finderArgs, lmsWeekends);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCATION,
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
			return (LMSWeekends)result;
		}
	}

	/**
	 * Removes the l m s weekends where Location = &#63; from the database.
	 *
	 * @param Location the location
	 * @return the l m s weekends that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends removeByLocation(String Location)
		throws NoSuchWeekendsException, SystemException {
		LMSWeekends lmsWeekends = findByLocation(Location);

		return remove(lmsWeekends);
	}

	/**
	 * Returns the number of l m s weekendses where Location = &#63;.
	 *
	 * @param Location the location
	 * @return the number of matching l m s weekendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLocation(String Location) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCATION;

		Object[] finderArgs = new Object[] { Location };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSWEEKENDS_WHERE);

			boolean bindLocation = false;

			if (Location == null) {
				query.append(_FINDER_COLUMN_LOCATION_LOCATION_1);
			}
			else if (Location.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				query.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocation) {
					qPos.add(Location);
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

	private static final String _FINDER_COLUMN_LOCATION_LOCATION_1 = "lmsWeekends.Location IS NULL";
	private static final String _FINDER_COLUMN_LOCATION_LOCATION_2 = "lmsWeekends.Location = ?";
	private static final String _FINDER_COLUMN_LOCATION_LOCATION_3 = "(lmsWeekends.Location IS NULL OR lmsWeekends.Location = '')";

	public LMSWeekendsPersistenceImpl() {
		setModelClass(LMSWeekends.class);
	}

	/**
	 * Caches the l m s weekends in the entity cache if it is enabled.
	 *
	 * @param lmsWeekends the l m s weekends
	 */
	@Override
	public void cacheResult(LMSWeekends lmsWeekends) {
		EntityCacheUtil.putResult(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsImpl.class, lmsWeekends.getPrimaryKey(), lmsWeekends);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCATION,
			new Object[] { lmsWeekends.getLocation() }, lmsWeekends);

		lmsWeekends.resetOriginalValues();
	}

	/**
	 * Caches the l m s weekendses in the entity cache if it is enabled.
	 *
	 * @param lmsWeekendses the l m s weekendses
	 */
	@Override
	public void cacheResult(List<LMSWeekends> lmsWeekendses) {
		for (LMSWeekends lmsWeekends : lmsWeekendses) {
			if (EntityCacheUtil.getResult(
						LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
						LMSWeekendsImpl.class, lmsWeekends.getPrimaryKey()) == null) {
				cacheResult(lmsWeekends);
			}
			else {
				lmsWeekends.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s weekendses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSWeekendsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSWeekendsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s weekends.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSWeekends lmsWeekends) {
		EntityCacheUtil.removeResult(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsImpl.class, lmsWeekends.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsWeekends);
	}

	@Override
	public void clearCache(List<LMSWeekends> lmsWeekendses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSWeekends lmsWeekends : lmsWeekendses) {
			EntityCacheUtil.removeResult(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
				LMSWeekendsImpl.class, lmsWeekends.getPrimaryKey());

			clearUniqueFindersCache(lmsWeekends);
		}
	}

	protected void cacheUniqueFindersCache(LMSWeekends lmsWeekends) {
		if (lmsWeekends.isNew()) {
			Object[] args = new Object[] { lmsWeekends.getLocation() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCATION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCATION, args,
				lmsWeekends);
		}
		else {
			LMSWeekendsModelImpl lmsWeekendsModelImpl = (LMSWeekendsModelImpl)lmsWeekends;

			if ((lmsWeekendsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LOCATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { lmsWeekends.getLocation() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCATION, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCATION, args,
					lmsWeekends);
			}
		}
	}

	protected void clearUniqueFindersCache(LMSWeekends lmsWeekends) {
		LMSWeekendsModelImpl lmsWeekendsModelImpl = (LMSWeekendsModelImpl)lmsWeekends;

		Object[] args = new Object[] { lmsWeekends.getLocation() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCATION, args);

		if ((lmsWeekendsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LOCATION.getColumnBitmask()) != 0) {
			args = new Object[] { lmsWeekendsModelImpl.getOriginalLocation() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCATION, args);
		}
	}

	/**
	 * Creates a new l m s weekends with the primary key. Does not add the l m s weekends to the database.
	 *
	 * @param LocationId the primary key for the new l m s weekends
	 * @return the new l m s weekends
	 */
	@Override
	public LMSWeekends create(int LocationId) {
		LMSWeekends lmsWeekends = new LMSWeekendsImpl();

		lmsWeekends.setNew(true);
		lmsWeekends.setPrimaryKey(LocationId);

		return lmsWeekends;
	}

	/**
	 * Removes the l m s weekends with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LocationId the primary key of the l m s weekends
	 * @return the l m s weekends that was removed
	 * @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends remove(int LocationId)
		throws NoSuchWeekendsException, SystemException {
		return remove((Serializable)LocationId);
	}

	/**
	 * Removes the l m s weekends with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s weekends
	 * @return the l m s weekends that was removed
	 * @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends remove(Serializable primaryKey)
		throws NoSuchWeekendsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSWeekends lmsWeekends = (LMSWeekends)session.get(LMSWeekendsImpl.class,
					primaryKey);

			if (lmsWeekends == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWeekendsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsWeekends);
		}
		catch (NoSuchWeekendsException nsee) {
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
	protected LMSWeekends removeImpl(LMSWeekends lmsWeekends)
		throws SystemException {
		lmsWeekends = toUnwrappedModel(lmsWeekends);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsWeekends)) {
				lmsWeekends = (LMSWeekends)session.get(LMSWeekendsImpl.class,
						lmsWeekends.getPrimaryKeyObj());
			}

			if (lmsWeekends != null) {
				session.delete(lmsWeekends);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsWeekends != null) {
			clearCache(lmsWeekends);
		}

		return lmsWeekends;
	}

	@Override
	public LMSWeekends updateImpl(com.trianz.lms.model.LMSWeekends lmsWeekends)
		throws SystemException {
		lmsWeekends = toUnwrappedModel(lmsWeekends);

		boolean isNew = lmsWeekends.isNew();

		Session session = null;

		try {
			session = openSession();

			if (lmsWeekends.isNew()) {
				session.save(lmsWeekends);

				lmsWeekends.setNew(false);
			}
			else {
				session.merge(lmsWeekends);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSWeekendsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
			LMSWeekendsImpl.class, lmsWeekends.getPrimaryKey(), lmsWeekends);

		clearUniqueFindersCache(lmsWeekends);
		cacheUniqueFindersCache(lmsWeekends);

		return lmsWeekends;
	}

	protected LMSWeekends toUnwrappedModel(LMSWeekends lmsWeekends) {
		if (lmsWeekends instanceof LMSWeekendsImpl) {
			return lmsWeekends;
		}

		LMSWeekendsImpl lmsWeekendsImpl = new LMSWeekendsImpl();

		lmsWeekendsImpl.setNew(lmsWeekends.isNew());
		lmsWeekendsImpl.setPrimaryKey(lmsWeekends.getPrimaryKey());

		lmsWeekendsImpl.setLocationId(lmsWeekends.getLocationId());
		lmsWeekendsImpl.setLocation(lmsWeekends.getLocation());
		lmsWeekendsImpl.setWeekendDays(lmsWeekends.getWeekendDays());

		return lmsWeekendsImpl;
	}

	/**
	 * Returns the l m s weekends with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s weekends
	 * @return the l m s weekends
	 * @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWeekendsException, SystemException {
		LMSWeekends lmsWeekends = fetchByPrimaryKey(primaryKey);

		if (lmsWeekends == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWeekendsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsWeekends;
	}

	/**
	 * Returns the l m s weekends with the primary key or throws a {@link com.trianz.lms.NoSuchWeekendsException} if it could not be found.
	 *
	 * @param LocationId the primary key of the l m s weekends
	 * @return the l m s weekends
	 * @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends findByPrimaryKey(int LocationId)
		throws NoSuchWeekendsException, SystemException {
		return findByPrimaryKey((Serializable)LocationId);
	}

	/**
	 * Returns the l m s weekends with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s weekends
	 * @return the l m s weekends, or <code>null</code> if a l m s weekends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSWeekends lmsWeekends = (LMSWeekends)EntityCacheUtil.getResult(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
				LMSWeekendsImpl.class, primaryKey);

		if (lmsWeekends == _nullLMSWeekends) {
			return null;
		}

		if (lmsWeekends == null) {
			Session session = null;

			try {
				session = openSession();

				lmsWeekends = (LMSWeekends)session.get(LMSWeekendsImpl.class,
						primaryKey);

				if (lmsWeekends != null) {
					cacheResult(lmsWeekends);
				}
				else {
					EntityCacheUtil.putResult(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
						LMSWeekendsImpl.class, primaryKey, _nullLMSWeekends);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSWeekendsModelImpl.ENTITY_CACHE_ENABLED,
					LMSWeekendsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsWeekends;
	}

	/**
	 * Returns the l m s weekends with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LocationId the primary key of the l m s weekends
	 * @return the l m s weekends, or <code>null</code> if a l m s weekends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSWeekends fetchByPrimaryKey(int LocationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)LocationId);
	}

	/**
	 * Returns all the l m s weekendses.
	 *
	 * @return the l m s weekendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSWeekends> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s weekendses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSWeekendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s weekendses
	 * @param end the upper bound of the range of l m s weekendses (not inclusive)
	 * @return the range of l m s weekendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSWeekends> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s weekendses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSWeekendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s weekendses
	 * @param end the upper bound of the range of l m s weekendses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s weekendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSWeekends> findAll(int start, int end,
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

		List<LMSWeekends> list = (List<LMSWeekends>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSWEEKENDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSWEEKENDS;

				if (pagination) {
					sql = sql.concat(LMSWeekendsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSWeekends>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSWeekends>(list);
				}
				else {
					list = (List<LMSWeekends>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l m s weekendses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSWeekends lmsWeekends : findAll()) {
			remove(lmsWeekends);
		}
	}

	/**
	 * Returns the number of l m s weekendses.
	 *
	 * @return the number of l m s weekendses
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

				Query q = session.createQuery(_SQL_COUNT_LMSWEEKENDS);

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
	 * Initializes the l m s weekends persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSWeekends")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSWeekends>> listenersList = new ArrayList<ModelListener<LMSWeekends>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSWeekends>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSWeekendsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSWEEKENDS = "SELECT lmsWeekends FROM LMSWeekends lmsWeekends";
	private static final String _SQL_SELECT_LMSWEEKENDS_WHERE = "SELECT lmsWeekends FROM LMSWeekends lmsWeekends WHERE ";
	private static final String _SQL_COUNT_LMSWEEKENDS = "SELECT COUNT(lmsWeekends) FROM LMSWeekends lmsWeekends";
	private static final String _SQL_COUNT_LMSWEEKENDS_WHERE = "SELECT COUNT(lmsWeekends) FROM LMSWeekends lmsWeekends WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsWeekends.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSWeekends exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSWeekends exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSWeekendsPersistenceImpl.class);
	private static LMSWeekends _nullLMSWeekends = new LMSWeekendsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSWeekends> toCacheModel() {
				return _nullLMSWeekendsCacheModel;
			}
		};

	private static CacheModel<LMSWeekends> _nullLMSWeekendsCacheModel = new CacheModel<LMSWeekends>() {
			@Override
			public LMSWeekends toEntityModel() {
				return _nullLMSWeekends;
			}
		};
}