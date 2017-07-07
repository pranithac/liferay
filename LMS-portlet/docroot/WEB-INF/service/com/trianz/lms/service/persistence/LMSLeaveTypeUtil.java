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

import com.trianz.lms.model.LMSLeaveType;

import java.util.List;

/**
 * The persistence utility for the l m s leave type service. This utility wraps {@link LMSLeaveTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeaveTypePersistence
 * @see LMSLeaveTypePersistenceImpl
 * @generated
 */
public class LMSLeaveTypeUtil {
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
	public static void clearCache(LMSLeaveType lmsLeaveType) {
		getPersistence().clearCache(lmsLeaveType);
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
	public static List<LMSLeaveType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSLeaveType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSLeaveType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LMSLeaveType update(LMSLeaveType lmsLeaveType)
		throws SystemException {
		return getPersistence().update(lmsLeaveType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LMSLeaveType update(LMSLeaveType lmsLeaveType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lmsLeaveType, serviceContext);
	}

	/**
	* Returns the l m s leave type where LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	*
	* @param LeaveTypeCode the leave type code
	* @return the matching l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType findByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence().findByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the l m s leave type where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveTypeCode the leave type code
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the l m s leave type where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveTypeCode the leave type code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeCode(
		int LeaveTypeCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeCode(LeaveTypeCode, retrieveFromCache);
	}

	/**
	* Removes the l m s leave type where LeaveTypeCode = &#63; from the database.
	*
	* @param LeaveTypeCode the leave type code
	* @return the l m s leave type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType removeByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence().removeByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the number of l m s leave types where LeaveTypeCode = &#63;.
	*
	* @param LeaveTypeCode the leave type code
	* @return the number of matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveTypeCode(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the l m s leave type where LeaveTypeName = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	*
	* @param LeaveTypeName the leave type name
	* @return the matching l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType findByLeaveTypeName(
		java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence().findByLeaveTypeName(LeaveTypeName);
	}

	/**
	* Returns the l m s leave type where LeaveTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveTypeName the leave type name
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeName(
		java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLeaveTypeName(LeaveTypeName);
	}

	/**
	* Returns the l m s leave type where LeaveTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveTypeName the leave type name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeName(
		java.lang.String LeaveTypeName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeName(LeaveTypeName, retrieveFromCache);
	}

	/**
	* Removes the l m s leave type where LeaveTypeName = &#63; from the database.
	*
	* @param LeaveTypeName the leave type name
	* @return the l m s leave type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType removeByLeaveTypeName(
		java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence().removeByLeaveTypeName(LeaveTypeName);
	}

	/**
	* Returns the number of l m s leave types where LeaveTypeName = &#63;.
	*
	* @param LeaveTypeName the leave type name
	* @return the number of matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveTypeName(java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveTypeName(LeaveTypeName);
	}

	/**
	* Returns all the l m s leave types where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @return the matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSLeaveType> findByCountriesApplicable(
		java.lang.String CountriesApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountriesApplicable(CountriesApplicable);
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
	public static java.util.List<com.trianz.lms.model.LMSLeaveType> findByCountriesApplicable(
		java.lang.String CountriesApplicable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountriesApplicable(CountriesApplicable, start, end);
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
	public static java.util.List<com.trianz.lms.model.LMSLeaveType> findByCountriesApplicable(
		java.lang.String CountriesApplicable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountriesApplicable(CountriesApplicable, start, end,
			orderByComparator);
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
	public static com.trianz.lms.model.LMSLeaveType findByCountriesApplicable_First(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence()
				   .findByCountriesApplicable_First(CountriesApplicable,
			orderByComparator);
	}

	/**
	* Returns the first l m s leave type in the ordered set where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType fetchByCountriesApplicable_First(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountriesApplicable_First(CountriesApplicable,
			orderByComparator);
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
	public static com.trianz.lms.model.LMSLeaveType findByCountriesApplicable_Last(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence()
				   .findByCountriesApplicable_Last(CountriesApplicable,
			orderByComparator);
	}

	/**
	* Returns the last l m s leave type in the ordered set where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType fetchByCountriesApplicable_Last(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountriesApplicable_Last(CountriesApplicable,
			orderByComparator);
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
	public static com.trianz.lms.model.LMSLeaveType[] findByCountriesApplicable_PrevAndNext(
		int LeaveTypeCode, java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence()
				   .findByCountriesApplicable_PrevAndNext(LeaveTypeCode,
			CountriesApplicable, orderByComparator);
	}

	/**
	* Removes all the l m s leave types where CountriesApplicable = &#63; from the database.
	*
	* @param CountriesApplicable the countries applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountriesApplicable(
		java.lang.String CountriesApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountriesApplicable(CountriesApplicable);
	}

	/**
	* Returns the number of l m s leave types where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @return the number of matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountriesApplicable(
		java.lang.String CountriesApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountriesApplicable(CountriesApplicable);
	}

	/**
	* Caches the l m s leave type in the entity cache if it is enabled.
	*
	* @param lmsLeaveType the l m s leave type
	*/
	public static void cacheResult(
		com.trianz.lms.model.LMSLeaveType lmsLeaveType) {
		getPersistence().cacheResult(lmsLeaveType);
	}

	/**
	* Caches the l m s leave types in the entity cache if it is enabled.
	*
	* @param lmsLeaveTypes the l m s leave types
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LMSLeaveType> lmsLeaveTypes) {
		getPersistence().cacheResult(lmsLeaveTypes);
	}

	/**
	* Creates a new l m s leave type with the primary key. Does not add the l m s leave type to the database.
	*
	* @param LeaveTypeCode the primary key for the new l m s leave type
	* @return the new l m s leave type
	*/
	public static com.trianz.lms.model.LMSLeaveType create(int LeaveTypeCode) {
		return getPersistence().create(LeaveTypeCode);
	}

	/**
	* Removes the l m s leave type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type that was removed
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType remove(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence().remove(LeaveTypeCode);
	}

	public static com.trianz.lms.model.LMSLeaveType updateImpl(
		com.trianz.lms.model.LMSLeaveType lmsLeaveType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsLeaveType);
	}

	/**
	* Returns the l m s leave type with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType findByPrimaryKey(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException {
		return getPersistence().findByPrimaryKey(LeaveTypeCode);
	}

	/**
	* Returns the l m s leave type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type, or <code>null</code> if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeaveType fetchByPrimaryKey(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(LeaveTypeCode);
	}

	/**
	* Returns all the l m s leave types.
	*
	* @return the l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSLeaveType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.trianz.lms.model.LMSLeaveType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.trianz.lms.model.LMSLeaveType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s leave types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s leave types.
	*
	* @return the number of l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSLeaveTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSLeaveTypePersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LMSLeaveTypePersistence.class.getName());

			ReferenceRegistry.registerReference(LMSLeaveTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LMSLeaveTypePersistence persistence) {
	}

	private static LMSLeaveTypePersistence _persistence;
}