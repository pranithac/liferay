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

import com.trianz.lms.model.LMSLeavePolicies;

/**
 * The persistence interface for the l m s leave policies service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeavePoliciesPersistenceImpl
 * @see LMSLeavePoliciesUtil
 * @generated
 */
public interface LMSLeavePoliciesPersistence extends BasePersistence<LMSLeavePolicies> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSLeavePoliciesUtil} to access the l m s leave policies persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the l m s leave policies in the entity cache if it is enabled.
	*
	* @param lmsLeavePolicies the l m s leave policies
	*/
	public void cacheResult(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies);

	/**
	* Caches the l m s leave policieses in the entity cache if it is enabled.
	*
	* @param lmsLeavePolicieses the l m s leave policieses
	*/
	public void cacheResult(
		java.util.List<com.trianz.lms.model.LMSLeavePolicies> lmsLeavePolicieses);

	/**
	* Creates a new l m s leave policies with the primary key. Does not add the l m s leave policies to the database.
	*
	* @param PolicyId the primary key for the new l m s leave policies
	* @return the new l m s leave policies
	*/
	public com.trianz.lms.model.LMSLeavePolicies create(int PolicyId);

	/**
	* Removes the l m s leave policies with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies that was removed
	* @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeavePolicies remove(int PolicyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeavePoliciesException;

	public com.trianz.lms.model.LMSLeavePolicies updateImpl(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s leave policies with the primary key or throws a {@link com.trianz.lms.NoSuchLeavePoliciesException} if it could not be found.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies
	* @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeavePolicies findByPrimaryKey(int PolicyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeavePoliciesException;

	/**
	* Returns the l m s leave policies with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies, or <code>null</code> if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.trianz.lms.model.LMSLeavePolicies fetchByPrimaryKey(int PolicyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s leave policieses.
	*
	* @return the l m s leave policieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.trianz.lms.model.LMSLeavePolicies> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSLeavePolicies> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.trianz.lms.model.LMSLeavePolicies> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s leave policieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s leave policieses.
	*
	* @return the number of l m s leave policieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}