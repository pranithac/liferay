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

import com.trianz.lms.model.securaxEmployeeHrs;

/**
 * The persistence interface for the securax employee hrs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see securaxEmployeeHrsPersistenceImpl
 * @see securaxEmployeeHrsUtil
 * @generated
 */
public interface securaxEmployeeHrsPersistence extends BasePersistence<securaxEmployeeHrs> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link securaxEmployeeHrsUtil} to access the securax employee hrs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or throws a {@link com.trianz.lms.NoSuchsecuraxEmployeeHrsException} if it could not be found.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the matching securax employee hrs
	* @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a matching securax employee hrs could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.securaxEmployeeHrs findByEmployeeId(
		int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException;

	/**
	* Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the matching securax employee hrs, or <code>null</code> if a matching securax employee hrs could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.securaxEmployeeHrs fetchByEmployeeId(
		int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching securax employee hrs, or <code>null</code> if a matching securax employee hrs could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.securaxEmployeeHrs fetchByEmployeeId(
		int EmployeeId, java.util.Date PunchDate, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the securax employee hrs where EmployeeId = &#63; and PunchDate = &#63; from the database.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the securax employee hrs that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.securaxEmployeeHrs removeByEmployeeId(
		int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException;

	/**
	* Returns the number of securax employee hrses where EmployeeId = &#63; and PunchDate = &#63;.
	*
	* @param EmployeeId the employee ID
	* @param PunchDate the punch date
	* @return the number of matching securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmployeeId(int EmployeeId, java.util.Date PunchDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the securax employee hrs in the entity cache if it is enabled.
	*
	* @param securaxEmployeeHrs the securax employee hrs
	*/
	public void cacheResult(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs);

	/**
	* Caches the securax employee hrses in the entity cache if it is enabled.
	*
	* @param securaxEmployeeHrses the securax employee hrses
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.securaxEmployeeHrs> securaxEmployeeHrses);

	/**
	* Creates a new securax employee hrs with the primary key. Does not add the securax employee hrs to the database.
	*
	* @param EmployeeId the primary key for the new securax employee hrs
	* @return the new securax employee hrs
	*/
	public com.trianz.lms.model.securaxEmployeeHrs create(int EmployeeId);

	/**
	* Removes the securax employee hrs with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs that was removed
	* @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.securaxEmployeeHrs remove(int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException;

	public com.trianz.lms.model.securaxEmployeeHrs updateImpl(
		com.trianz.lms.model.securaxEmployeeHrs securaxEmployeeHrs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the securax employee hrs with the primary key or throws a {@link com.trianz.lms.NoSuchsecuraxEmployeeHrsException} if it could not be found.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs
	* @throws com.trianz.lms.NoSuchsecuraxEmployeeHrsException if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.securaxEmployeeHrs findByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchsecuraxEmployeeHrsException;

	/**
	* Returns the securax employee hrs with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param EmployeeId the primary key of the securax employee hrs
	* @return the securax employee hrs, or <code>null</code> if a securax employee hrs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.securaxEmployeeHrs fetchByPrimaryKey(
		int EmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the securax employee hrses.
	*
	* @return the securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.securaxEmployeeHrs> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.securaxEmployeeHrs> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.securaxEmployeeHrs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the securax employee hrses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of securax employee hrses.
	*
	* @return the number of securax employee hrses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}