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

import com.liferay.portal.service.persistence.BasePersistence;

import com.trianz.lms.model.LMSLeaveType;

/**
 * The persistence interface for the l m s leave type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeaveTypePersistenceImpl
 * @see LMSLeaveTypeUtil
 * @generated
 */
public interface LMSLeaveTypePersistence extends BasePersistence<LMSLeaveType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSLeaveTypeUtil} to access the l m s leave type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the l m s leave type where LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	*
	* @param LeaveTypeCode the leave type code
	* @return the matching l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType findByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Returns the l m s leave type where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveTypeCode the leave type code
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave type where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveTypeCode the leave type code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeCode(
		int LeaveTypeCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s leave type where LeaveTypeCode = &#63; from the database.
	*
	* @param LeaveTypeCode the leave type code
	* @return the l m s leave type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType removeByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Returns the number of l m s leave types where LeaveTypeCode = &#63;.
	*
	* @param LeaveTypeCode the leave type code
	* @return the number of matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveTypeCode(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave type where LeaveTypeName = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	*
	* @param LeaveTypeName the leave type name
	* @return the matching l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType findByLeaveTypeName(
		java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Returns the l m s leave type where LeaveTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveTypeName the leave type name
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeName(
		java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave type where LeaveTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveTypeName the leave type name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType fetchByLeaveTypeName(
		java.lang.String LeaveTypeName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s leave type where LeaveTypeName = &#63; from the database.
	*
	* @param LeaveTypeName the leave type name
	* @return the l m s leave type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType removeByLeaveTypeName(
		java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Returns the number of l m s leave types where LeaveTypeName = &#63;.
	*
	* @param LeaveTypeName the leave type name
	* @return the number of matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveTypeName(java.lang.String LeaveTypeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s leave types where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @return the matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveType> findByCountriesApplicable(
		java.lang.String CountriesApplicable)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSLeaveType> findByCountriesApplicable(
		java.lang.String CountriesApplicable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSLeaveType> findByCountriesApplicable(
		java.lang.String CountriesApplicable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s leave type in the ordered set where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType findByCountriesApplicable_First(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Returns the first l m s leave type in the ordered set where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType fetchByCountriesApplicable_First(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s leave type in the ordered set where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType findByCountriesApplicable_Last(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Returns the last l m s leave type in the ordered set where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s leave type, or <code>null</code> if a matching l m s leave type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType fetchByCountriesApplicable_Last(
		java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.trianz.lms.model.LMSLeaveType[] findByCountriesApplicable_PrevAndNext(
		int LeaveTypeCode, java.lang.String CountriesApplicable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Removes all the l m s leave types where CountriesApplicable = &#63; from the database.
	*
	* @param CountriesApplicable the countries applicable
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountriesApplicable(
		java.lang.String CountriesApplicable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave types where CountriesApplicable = &#63;.
	*
	* @param CountriesApplicable the countries applicable
	* @return the number of matching l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountriesApplicable(java.lang.String CountriesApplicable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s leave type in the entity cache if it is enabled.
	*
	* @param lmsLeaveType the l m s leave type
	*/
	public void cacheResult(com.trianz.lms.model.LMSLeaveType lmsLeaveType);

	/**
	* Caches the l m s leave types in the entity cache if it is enabled.
	*
	* @param lmsLeaveTypes the l m s leave types
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSLeaveType> lmsLeaveTypes);

	/**
	* Creates a new l m s leave type with the primary key. Does not add the l m s leave type to the database.
	*
	* @param LeaveTypeCode the primary key for the new l m s leave type
	* @return the new l m s leave type
	*/
	public com.trianz.lms.model.LMSLeaveType create(int LeaveTypeCode);

	/**
	* Removes the l m s leave type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type that was removed
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType remove(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	public com.trianz.lms.model.LMSLeaveType updateImpl(
		com.trianz.lms.model.LMSLeaveType lmsLeaveType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave type with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveTypeException} if it could not be found.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type
	* @throws com.trianz.lms.NoSuchLeaveTypeException if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType findByPrimaryKey(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveTypeException;

	/**
	* Returns the l m s leave type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LeaveTypeCode the primary key of the l m s leave type
	* @return the l m s leave type, or <code>null</code> if a l m s leave type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeaveType fetchByPrimaryKey(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s leave types.
	*
	* @return the l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeaveType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSLeaveType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSLeaveType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s leave types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave types.
	*
	* @return the number of l m s leave types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}