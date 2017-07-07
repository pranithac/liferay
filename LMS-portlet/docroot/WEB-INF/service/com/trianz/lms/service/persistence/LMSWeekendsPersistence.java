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

import com.trianz.lms.model.LMSWeekends;

/**
 * The persistence interface for the l m s weekends service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSWeekendsPersistenceImpl
 * @see LMSWeekendsUtil
 * @generated
 */
public interface LMSWeekendsPersistence extends BasePersistence<LMSWeekends> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSWeekendsUtil} to access the l m s weekends persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the l m s weekends where Location = &#63; or throws a {@link com.trianz.lms.NoSuchWeekendsException} if it could not be found.
	*
	* @param Location the location
	* @return the matching l m s weekends
	* @throws com.trianz.lms.NoSuchWeekendsException if a matching l m s weekends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSWeekends findByLocation(
		java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException;

	/**
	* Returns the l m s weekends where Location = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param Location the location
	* @return the matching l m s weekends, or <code>null</code> if a matching l m s weekends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSWeekends fetchByLocation(
		java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s weekends where Location = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param Location the location
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s weekends, or <code>null</code> if a matching l m s weekends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSWeekends fetchByLocation(
		java.lang.String Location, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s weekends where Location = &#63; from the database.
	*
	* @param Location the location
	* @return the l m s weekends that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSWeekends removeByLocation(
		java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException;

	/**
	* Returns the number of l m s weekendses where Location = &#63;.
	*
	* @param Location the location
	* @return the number of matching l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLocation(java.lang.String Location)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l m s weekends in the entity cache if it is enabled.
	*
	* @param lmsWeekends the l m s weekends
	*/
	public void cacheResult(com.trianz.lms.model.LMSWeekends lmsWeekends);

	/**
	* Caches the l m s weekendses in the entity cache if it is enabled.
	*
	* @param lmsWeekendses the l m s weekendses
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSWeekends> lmsWeekendses);

	/**
	* Creates a new l m s weekends with the primary key. Does not add the l m s weekends to the database.
	*
	* @param LocationId the primary key for the new l m s weekends
	* @return the new l m s weekends
	*/
	public com.trianz.lms.model.LMSWeekends create(int LocationId);

	/**
	* Removes the l m s weekends with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends that was removed
	* @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSWeekends remove(int LocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException;

	public com.trianz.lms.model.LMSWeekends updateImpl(
		com.trianz.lms.model.LMSWeekends lmsWeekends)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s weekends with the primary key or throws a {@link com.trianz.lms.NoSuchWeekendsException} if it could not be found.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends
	* @throws com.trianz.lms.NoSuchWeekendsException if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSWeekends findByPrimaryKey(int LocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchWeekendsException;

	/**
	* Returns the l m s weekends with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LocationId the primary key of the l m s weekends
	* @return the l m s weekends, or <code>null</code> if a l m s weekends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSWeekends fetchByPrimaryKey(int LocationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s weekendses.
	*
	* @return the l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSWeekends> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSWeekends> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSWeekends> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s weekendses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s weekendses.
	*
	* @return the number of l m s weekendses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}