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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.trianz.lms.model.LMSWeekends;

import java.util.List;

/**
 * The persistence utility for the l m s weekends service. This utility wraps {@link LMSWeekendsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSWeekendsPersistence
 * @see LMSWeekendsPersistenceImpl
 * @generated
 */
public class LMSWeekendsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LMSWeekends lmsWeekends) {
		getPersistence().clearCache(lmsWeekends);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LMSWeekends> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSWeekends> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSWeekends> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LMSWeekends update(LMSWeekends lmsWeekends)
		throws SystemException {
		return getPersistence().update(lmsWeekends);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LMSWeekends update(LMSWeekends lmsWeekends,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lmsWeekends, serviceContext);
	}

	/**
	* Returns the l m s weekends where Location = &#63; or throws a {@link com.trianz.lms.NoSuchWeekendsException} if it could not be found.
	*
	* @param Location the location
	* @return the matching l m s weekends
	* @throws com.trianz.lms.NoSuchWeekendsException if a matching l m s weekends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSWeekends findByLocation(
		java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException {
		return getPersistence().findByLocation(Location);
	}

	/**
	* Returns the l m s weekends where Location = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param Location the location
	* @return the matching l m s weekends, or <code>null</code> if a matching l m s weekends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSWeekends fetchByLocation(
		java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLocation(Location);
	}

	/**
	* Returns the l m s weekends where Location = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param Location the location
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s weekends, or <code>null</code> if a matching l m s weekends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSWeekends fetchByLocation(
		java.lang.String Location, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLocation(Location, retrieveFromCache);
	}

	/**
	* Removes the l m s weekends where Location = &#63; from the database.
	*
	* @param Location the location
	* @return the l m s weekends that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSWeekends removeByLocation(
		java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException {
		return getPersistence().removeByLocation(Location);
	}

	/**
	* Returns the number of l m s weekendses where Location = &#63;.
	*
	* @param Location the location
	* @return the number of matching l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocation(java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocation(Location);
	}

	/**
	* Caches the l m s weekends in the entity cache if it is enabled.
	*
	* @param lmsWeekends the l m s weekends
	*/
	public static void cacheResult(com.trianz.lms.model.LMSWeekends lmsWeekends) {
		getPersistence().cacheResult(lmsWeekends);
	}

	/**
	* Caches the l m s weekendses in the entity cache if it is enabled.
	*
	* @param lmsWeekendses the l m s weekendses
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LMSWeekends> lmsWeekendses) {
		getPersistence().cacheResult(lmsWeekendses);
	}

	/**
	* Creates a new l m s weekends with the primary key. Does not add the l m s weekends to the database.
	*
	* @param LocationId the primary key for the new l m s weekends
	* @return the new l m s weekends
	*/
	public static com.trianz.lms.model.LMSWeekends create(int LocationId) {
		return getPersistence().create(LocationId);
	}

	/**
	* Removes the l m s weekends with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends that was removed
	* @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSWeekends remove(int LocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException {
		return getPersistence().remove(LocationId);
	}

	public static com.trianz.lms.model.LMSWeekends updateImpl(
		com.trianz.lms.model.LMSWeekends lmsWeekends)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsWeekends);
	}

	/**
	* Returns the l m s weekends with the primary key or throws a {@link com.trianz.lms.NoSuchWeekendsException} if it could not be found.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends
	* @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSWeekends findByPrimaryKey(
		int LocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException {
		return getPersistence().findByPrimaryKey(LocationId);
	}

	/**
	* Returns the l m s weekends with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends, or <code>null</code> if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSWeekends fetchByPrimaryKey(
		int LocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(LocationId);
	}

	/**
	* Returns all the l m s weekendses.
	*
	* @return the l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSWeekends> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.trianz.lms.model.LMSWeekends> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.trianz.lms.model.LMSWeekends> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s weekendses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s weekendses.
	*
	* @return the number of l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSWeekendsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSWeekendsPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LMSWeekendsPersistence.class.getName());

			ReferenceRegistry.registerReference(LMSWeekendsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LMSWeekendsPersistence persistence) {
	}

	private static LMSWeekendsPersistence _persistence;
}