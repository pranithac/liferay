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

import com.trianz.lms.model.LMSLeavePolicies;

import java.util.List;

/**
 * The persistence utility for the l m s leave policies service. This utility wraps {@link LMSLeavePoliciesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LMSLeavePoliciesPersistence
 * @see LMSLeavePoliciesPersistenceImpl
 * @generated
 */
public class LMSLeavePoliciesUtil {
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
	public static void clearCache(LMSLeavePolicies lmsLeavePolicies) {
		getPersistence().clearCache(lmsLeavePolicies);
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
	public static List<LMSLeavePolicies> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSLeavePolicies> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSLeavePolicies> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LMSLeavePolicies update(LMSLeavePolicies lmsLeavePolicies)
		throws SystemException {
		return getPersistence().update(lmsLeavePolicies);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LMSLeavePolicies update(LMSLeavePolicies lmsLeavePolicies,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lmsLeavePolicies, serviceContext);
	}

	/**
	* Caches the l m s leave policies in the entity cache if it is enabled.
	*
	* @param lmsLeavePolicies the l m s leave policies
	*/
	public static void cacheResult(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies) {
		getPersistence().cacheResult(lmsLeavePolicies);
	}

	/**
	* Caches the l m s leave policieses in the entity cache if it is enabled.
	*
	* @param lmsLeavePolicieses the l m s leave policieses
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LMSLeavePolicies> lmsLeavePolicieses) {
		getPersistence().cacheResult(lmsLeavePolicieses);
	}

	/**
	* Creates a new l m s leave policies with the primary key. Does not add the l m s leave policies to the database.
	*
	* @param PolicyId the primary key for the new l m s leave policies
	* @return the new l m s leave policies
	*/
	public static com.trianz.lms.model.LMSLeavePolicies create(int PolicyId) {
		return getPersistence().create(PolicyId);
	}

	/**
	* Removes the l m s leave policies with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies that was removed
	* @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies remove(int PolicyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeavePoliciesException {
		return getPersistence().remove(PolicyId);
	}

	public static com.trianz.lms.model.LMSLeavePolicies updateImpl(
		com.trianz.lms.model.LMSLeavePolicies lmsLeavePolicies)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsLeavePolicies);
	}

	/**
	* Returns the l m s leave policies with the primary key or throws a {@link com.trianz.lms.NoSuchLeavePoliciesException} if it could not be found.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies
	* @throws com.trianz.lms.NoSuchLeavePoliciesException if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies findByPrimaryKey(
		int PolicyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeavePoliciesException {
		return getPersistence().findByPrimaryKey(PolicyId);
	}

	/**
	* Returns the l m s leave policies with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PolicyId the primary key of the l m s leave policies
	* @return the l m s leave policies, or <code>null</code> if a l m s leave policies with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LMSLeavePolicies fetchByPrimaryKey(
		int PolicyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(PolicyId);
	}

	/**
	* Returns all the l m s leave policieses.
	*
	* @return the l m s leave policieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LMSLeavePolicies> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.trianz.lms.model.LMSLeavePolicies> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.trianz.lms.model.LMSLeavePolicies> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s leave policieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s leave policieses.
	*
	* @return the number of l m s leave policieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSLeavePoliciesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSLeavePoliciesPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LMSLeavePoliciesPersistence.class.getName());

			ReferenceRegistry.registerReference(LMSLeavePoliciesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LMSLeavePoliciesPersistence persistence) {
	}

	private static LMSLeavePoliciesPersistence _persistence;
}