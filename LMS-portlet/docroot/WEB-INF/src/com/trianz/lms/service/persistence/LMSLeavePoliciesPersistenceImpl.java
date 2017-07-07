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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.trianz.lms.NoSuchLeavePoliciesException;
import com.trianz.lms.model.LMSLeavePolicies;
import com.trianz.lms.model.impl.LMSLeavePoliciesImpl;
import com.trianz.lms.model.impl.LMSLeavePoliciesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s leave policies service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeavePoliciesPersistence
 * @see LMSLeavePoliciesUtil
 * @generated
 */
public class LMSLeavePoliciesPersistenceImpl extends BasePersistenceImpl<LMSLeavePolicies>
	implements LMSLeavePoliciesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSLeavePoliciesUtil} to access the l m s leave policies persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSLeavePoliciesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeavePoliciesModelImpl.FINDER_CACHE_ENABLED,
			LMSLeavePoliciesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeavePoliciesModelImpl.FINDER_CACHE_ENABLED,
			LMSLeavePoliciesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeavePoliciesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LMSLeavePoliciesPersistenceImpl() {
		setModelClass(LMSLeavePolicies.class);
	}

	/**
	 * Caches the l m s leave policies in the entity cache if it is enabled.
	 *
	 * @param lmsLeavePolicies the l m s leave policies
	 */
	@Override
	public void cacheResult(LMSLeavePolicies lmsLeavePolicies) {
		EntityCacheUtil.putResult(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeavePoliciesImpl.class, lmsLeavePolicies.getPrimaryKey(),
			lmsLeavePolicies);

		lmsLeavePolicies.resetOriginalValues();
	}

	/**
	 * Caches the l m s leave policieses in the entity cache if it is enabled.
	 *
	 * @param lmsLeavePolicieses the l m s leave policieses
	 */
	@Override
	public void cacheResult(List<LMSLeavePolicies> lmsLeavePolicieses) {
		for (LMSLeavePolicies lmsLeavePolicies : lmsLeavePolicieses) {
			if (EntityCacheUtil.getResult(
						LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
						LMSLeavePoliciesImpl.class,
						lmsLeavePolicies.getPrimaryKey()) == null) {
				cacheResult(lmsLeavePolicies);
			}
			else {
				lmsLeavePolicies.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s leave policieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSLeavePoliciesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSLeavePoliciesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s leave policies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSLeavePolicies lmsLeavePolicies) {
		EntityCacheUtil.removeResult(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeavePoliciesImpl.class, lmsLeavePolicies.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LMSLeavePolicies> lmsLeavePolicieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSLeavePolicies lmsLeavePolicies : lmsLeavePolicieses) {
			EntityCacheUtil.removeResult(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
				LMSLeavePoliciesImpl.class, lmsLeavePolicies.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l m s leave policies with the primary key. Does not add the l m s leave policies to the database.
	 *
	 * @param PolicyId the primary key for the new l m s leave policies
	 * @return the new l m s leave policies
	 */
	@Override
	public LMSLeavePolicies create(int PolicyId) {
		LMSLeavePolicies lmsLeavePolicies = new LMSLeavePoliciesImpl();

		lmsLeavePolicies.setNew(true);
		lmsLeavePolicies.setPrimaryKey(PolicyId);

		return lmsLeavePolicies;
	}

	/**
	 * Removes the l m s leave policies with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PolicyId the primary key of the l m s leave policies
	 * @return the l m s leave policies that was removed
	 * @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeavePolicies remove(int PolicyId)
		throws NoSuchLeavePoliciesException, SystemException {
		return remove((Serializable)PolicyId);
	}

	/**
	 * Removes the l m s leave policies with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s leave policies
	 * @return the l m s leave policies that was removed
	 * @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeavePolicies remove(Serializable primaryKey)
		throws NoSuchLeavePoliciesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSLeavePolicies lmsLeavePolicies = (LMSLeavePolicies)session.get(LMSLeavePoliciesImpl.class,
					primaryKey);

			if (lmsLeavePolicies == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeavePoliciesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsLeavePolicies);
		}
		catch (NoSuchLeavePoliciesException nsee) {
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
	protected LMSLeavePolicies removeImpl(LMSLeavePolicies lmsLeavePolicies)
		throws SystemException {
		lmsLeavePolicies = toUnwrappedModel(lmsLeavePolicies);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lmsLeavePolicies)) {
				lmsLeavePolicies = (LMSLeavePolicies)session.get(LMSLeavePoliciesImpl.class,
						lmsLeavePolicies.getPrimaryKeyObj());
			}

			if (lmsLeavePolicies != null) {
				session.delete(lmsLeavePolicies);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lmsLeavePolicies != null) {
			clearCache(lmsLeavePolicies);
		}

		return lmsLeavePolicies;
	}

	@Override
	public LMSLeavePolicies updateImpl(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies)
		throws SystemException {
		lmsLeavePolicies = toUnwrappedModel(lmsLeavePolicies);

		boolean isNew = lmsLeavePolicies.isNew();

		Session session = null;

		try {
			session = openSession();

			if (lmsLeavePolicies.isNew()) {
				session.save(lmsLeavePolicies);

				lmsLeavePolicies.setNew(false);
			}
			else {
				session.merge(lmsLeavePolicies);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
			LMSLeavePoliciesImpl.class, lmsLeavePolicies.getPrimaryKey(),
			lmsLeavePolicies);

		return lmsLeavePolicies;
	}

	protected LMSLeavePolicies toUnwrappedModel(
		LMSLeavePolicies lmsLeavePolicies) {
		if (lmsLeavePolicies instanceof LMSLeavePoliciesImpl) {
			return lmsLeavePolicies;
		}

		LMSLeavePoliciesImpl lmsLeavePoliciesImpl = new LMSLeavePoliciesImpl();

		lmsLeavePoliciesImpl.setNew(lmsLeavePolicies.isNew());
		lmsLeavePoliciesImpl.setPrimaryKey(lmsLeavePolicies.getPrimaryKey());

		lmsLeavePoliciesImpl.setPolicyId(lmsLeavePolicies.getPolicyId());
		lmsLeavePoliciesImpl.setProject(lmsLeavePolicies.getProject());
		lmsLeavePoliciesImpl.setLeaveTypesApplicable(lmsLeavePolicies.getLeaveTypesApplicable());
		lmsLeavePoliciesImpl.setLocationsApplicable(lmsLeavePolicies.getLocationsApplicable());

		return lmsLeavePoliciesImpl;
	}

	/**
	 * Returns the l m s leave policies with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s leave policies
	 * @return the l m s leave policies
	 * @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeavePolicies findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeavePoliciesException, SystemException {
		LMSLeavePolicies lmsLeavePolicies = fetchByPrimaryKey(primaryKey);

		if (lmsLeavePolicies == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeavePoliciesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lmsLeavePolicies;
	}

	/**
	 * Returns the l m s leave policies with the primary key or throws a {@link com.trianz.lms.NoSuchLeavePoliciesException} if it could not be found.
	 *
	 * @param PolicyId the primary key of the l m s leave policies
	 * @return the l m s leave policies
	 * @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeavePolicies findByPrimaryKey(int PolicyId)
		throws NoSuchLeavePoliciesException, SystemException {
		return findByPrimaryKey((Serializable)PolicyId);
	}

	/**
	 * Returns the l m s leave policies with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s leave policies
	 * @return the l m s leave policies, or <code>null</code> if a l m s leave policies with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeavePolicies fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LMSLeavePolicies lmsLeavePolicies = (LMSLeavePolicies)EntityCacheUtil.getResult(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
				LMSLeavePoliciesImpl.class, primaryKey);

		if (lmsLeavePolicies == _nullLMSLeavePolicies) {
			return null;
		}

		if (lmsLeavePolicies == null) {
			Session session = null;

			try {
				session = openSession();

				lmsLeavePolicies = (LMSLeavePolicies)session.get(LMSLeavePoliciesImpl.class,
						primaryKey);

				if (lmsLeavePolicies != null) {
					cacheResult(lmsLeavePolicies);
				}
				else {
					EntityCacheUtil.putResult(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
						LMSLeavePoliciesImpl.class, primaryKey,
						_nullLMSLeavePolicies);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LMSLeavePoliciesModelImpl.ENTITY_CACHE_ENABLED,
					LMSLeavePoliciesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lmsLeavePolicies;
	}

	/**
	 * Returns the l m s leave policies with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PolicyId the primary key of the l m s leave policies
	 * @return the l m s leave policies, or <code>null</code> if a l m s leave policies with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSLeavePolicies fetchByPrimaryKey(int PolicyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)PolicyId);
	}

	/**
	 * Returns all the l m s leave policieses.
	 *
	 * @return the l m s leave policieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeavePolicies> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s leave policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeavePoliciesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s leave policieses
	 * @param end the upper bound of the range of l m s leave policieses (not inclusive)
	 * @return the range of l m s leave policieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeavePolicies> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s leave policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LMSLeavePoliciesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s leave policieses
	 * @param end the upper bound of the range of l m s leave policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s leave policieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LMSLeavePolicies> findAll(int start, int end,
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

		List<LMSLeavePolicies> list = (List<LMSLeavePolicies>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSLEAVEPOLICIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSLEAVEPOLICIES;

				if (pagination) {
					sql = sql.concat(LMSLeavePoliciesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LMSLeavePolicies>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LMSLeavePolicies>(list);
				}
				else {
					list = (List<LMSLeavePolicies>)QueryUtil.list(q,
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
	 * Removes all the l m s leave policieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LMSLeavePolicies lmsLeavePolicies : findAll()) {
			remove(lmsLeavePolicies);
		}
	}

	/**
	 * Returns the number of l m s leave policieses.
	 *
	 * @return the number of l m s leave policieses
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

				Query q = session.createQuery(_SQL_COUNT_LMSLEAVEPOLICIES);

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
	 * Initializes the l m s leave policies persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.trianz.lms.model.LMSLeavePolicies")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSLeavePolicies>> listenersList = new ArrayList<ModelListener<LMSLeavePolicies>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSLeavePolicies>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSLeavePoliciesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LMSLEAVEPOLICIES = "SELECT lmsLeavePolicies FROM LMSLeavePolicies lmsLeavePolicies";
	private static final String _SQL_COUNT_LMSLEAVEPOLICIES = "SELECT COUNT(lmsLeavePolicies) FROM LMSLeavePolicies lmsLeavePolicies";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsLeavePolicies.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSLeavePolicies exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSLeavePoliciesPersistenceImpl.class);
	private static LMSLeavePolicies _nullLMSLeavePolicies = new LMSLeavePoliciesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSLeavePolicies> toCacheModel() {
				return _nullLMSLeavePoliciesCacheModel;
			}
		};

	private static CacheModel<LMSLeavePolicies> _nullLMSLeavePoliciesCacheModel = new CacheModel<LMSLeavePolicies>() {
			@Override
			public LMSLeavePolicies toEntityModel() {
				return _nullLMSLeavePolicies;
			}
		};
}