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

import com.trianz.lms.model.LMSHolidays;

import java.util.List;

/**
 * The persistence utility for the l m s holidays service. This utility wraps {@link LMSHolidaysPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSHolidaysPersistence
 * @see LMSHolidaysPersistenceImpl
 * @generated
 */
public class LMSHolidaysUtil {
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
	public static void clearCache(LMSHolidays lmsHolidays) {
		getPersistence().clearCache(lmsHolidays);
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
	public static List<LMSHolidays> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSHolidays> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSHolidays> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LMSHolidays update(LMSHolidays lmsHolidays)
		throws SystemException {
		return getPersistence().update(lmsHolidays);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LMSHolidays update(LMSHolidays lmsHolidays,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lmsHolidays, serviceContext);
	}

	/**
	* Returns all the l m s holidayses where HolidayYear = &#63;.
	*
	* @param HolidayYear the holiday year
	* @return the matching l m s holidayses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSHolidays> findByHolidayYear(
		int HolidayYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHolidayYear(HolidayYear);
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
	public static java.util.List<com.trianz.lms.model.LMSHolidays> findByHolidayYear(
		int HolidayYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHolidayYear(HolidayYear, start, end);
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
	public static java.util.List<com.trianz.lms.model.LMSHolidays> findByHolidayYear(
		int HolidayYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHolidayYear(HolidayYear, start, end, orderByComparator);
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
	public static com.trianz.lms.model.LMSHolidays findByHolidayYear_First(
		int HolidayYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchHolidaysException {
		return getPersistence()
				   .findByHolidayYear_First(HolidayYear, orderByComparator);
	}

	/**
	* Returns the first l m s holidays in the ordered set where HolidayYear = &#63;.
	*
	* @param HolidayYear the holiday year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s holidays, or <code>null</code> if a matching l m s holidays could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSHolidays fetchByHolidayYear_First(
		int HolidayYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHolidayYear_First(HolidayYear, orderByComparator);
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
	public static com.trianz.lms.model.LMSHolidays findByHolidayYear_Last(
		int HolidayYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchHolidaysException {
		return getPersistence()
				   .findByHolidayYear_Last(HolidayYear, orderByComparator);
	}

	/**
	* Returns the last l m s holidays in the ordered set where HolidayYear = &#63;.
	*
	* @param HolidayYear the holiday year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s holidays, or <code>null</code> if a matching l m s holidays could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSHolidays fetchByHolidayYear_Last(
		int HolidayYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHolidayYear_Last(HolidayYear, orderByComparator);
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
	public static com.trianz.lms.model.LMSHolidays[] findByHolidayYear_PrevAndNext(
		int HolidayId, int HolidayYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchHolidaysException {
		return getPersistence()
				   .findByHolidayYear_PrevAndNext(HolidayId, HolidayYear,
			orderByComparator);
	}

	/**
	* Removes all the l m s holidayses where HolidayYear = &#63; from the database.
	*
	* @param HolidayYear the holiday year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHolidayYear(int HolidayYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHolidayYear(HolidayYear);
	}

	/**
	* Returns the number of l m s holidayses where HolidayYear = &#63;.
	*
	* @param HolidayYear the holiday year
	* @return the number of matching l m s holidayses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHolidayYear(int HolidayYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHolidayYear(HolidayYear);
	}

	/**
	* Caches the l m s holidays in the entity cache if it is enabled.
	*
	* @param lmsHolidays the l m s holidays
	*/
	public static void cacheResult(com.trianz.lms.model.LMSHolidays lmsHolidays) {
		getPersistence().cacheResult(lmsHolidays);
	}

	/**
	* Caches the l m s holidayses in the entity cache if it is enabled.
	*
	* @param lmsHolidayses the l m s holidayses
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LMSHolidays> lmsHolidayses) {
		getPersistence().cacheResult(lmsHolidayses);
	}

	/**
	* Creates a new l m s holidays with the primary key. Does not add the l m s holidays to the database.
	*
	* @param HolidayId the primary key for the new l m s holidays
	* @return the new l m s holidays
	*/
	public static com.trianz.lms.model.LMSHolidays create(int HolidayId) {
		return getPersistence().create(HolidayId);
	}

	/**
	* Removes the l m s holidays with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param HolidayId the primary key of the l m s holidays
	* @return the l m s holidays that was removed
	* @throws com.trianz.lms.NoSuchHolidaysException if a l m s holidays with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSHolidays remove(int HolidayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchHolidaysException {
		return getPersistence().remove(HolidayId);
	}

	public static com.trianz.lms.model.LMSHolidays updateImpl(
		com.trianz.lms.model.LMSHolidays lmsHolidays)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsHolidays);
	}

	/**
	* Returns the l m s holidays with the primary key or throws a {@link com.trianz.lms.NoSuchHolidaysException} if it could not be found.
	*
	* @param HolidayId the primary key of the l m s holidays
	* @return the l m s holidays
	* @throws com.trianz.lms.NoSuchHolidaysException if a l m s holidays with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSHolidays findByPrimaryKey(
		int HolidayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchHolidaysException {
		return getPersistence().findByPrimaryKey(HolidayId);
	}

	/**
	* Returns the l m s holidays with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param HolidayId the primary key of the l m s holidays
	* @return the l m s holidays, or <code>null</code> if a l m s holidays with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSHolidays fetchByPrimaryKey(
		int HolidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(HolidayId);
	}

	/**
	* Returns all the l m s holidayses.
	*
	* @return the l m s holidayses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSHolidays> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.trianz.lms.model.LMSHolidays> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.trianz.lms.model.LMSHolidays> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s holidayses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s holidayses.
	*
	* @return the number of l m s holidayses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSHolidaysPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSHolidaysPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LMSHolidaysPersistence.class.getName());

			ReferenceRegistry.registerReference(LMSHolidaysUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LMSHolidaysPersistence persistence) {
	}

	private static LMSHolidaysPersistence _persistence;
}