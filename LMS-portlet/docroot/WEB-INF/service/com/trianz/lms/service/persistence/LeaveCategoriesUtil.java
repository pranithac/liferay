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

import com.trianz.lms.model.LeaveCategories;

import java.util.List;

/**
 * The persistence utility for the leave categories service. This utility wraps {@link LeaveCategoriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see LeaveCategoriesPersistence
 * @see LeaveCategoriesPersistenceImpl
 * @generated
 */
public class LeaveCategoriesUtil {
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
	public static void clearCache(LeaveCategories leaveCategories) {
		getPersistence().clearCache(leaveCategories);
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
	public static List<LeaveCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LeaveCategories update(LeaveCategories leaveCategories)
		throws SystemException {
		return getPersistence().update(leaveCategories);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LeaveCategories update(LeaveCategories leaveCategories,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(leaveCategories, serviceContext);
	}

	/**
	* Returns the leave categories where LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	*
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories findByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence().findByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveTypeCode the leave type code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveTypeCode(
		int LeaveTypeCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeCode(LeaveTypeCode, retrieveFromCache);
	}

	/**
	* Removes the leave categories where LeaveTypeCode = &#63; from the database.
	*
	* @param LeaveTypeCode the leave type code
	* @return the leave categories that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories removeByLeaveTypeCode(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence().removeByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the number of leave categorieses where LeaveTypeCode = &#63;.
	*
	* @param LeaveTypeCode the leave type code
	* @return the number of matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveTypeCode(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveTypeCode(LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	*
	* @param LeaveCategoryCode the leave category code
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories findByLeaveCategoryCode(
		java.lang.String LeaveCategoryCode, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .findByLeaveCategoryCode(LeaveCategoryCode, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveCategoryCode the leave category code
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveCategoryCode(
		java.lang.String LeaveCategoryCode, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveCategoryCode(LeaveCategoryCode, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveCategoryCode the leave category code
	* @param LeaveTypeCode the leave type code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveCategoryCode(
		java.lang.String LeaveCategoryCode, int LeaveTypeCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveCategoryCode(LeaveCategoryCode, LeaveTypeCode,
			retrieveFromCache);
	}

	/**
	* Removes the leave categories where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63; from the database.
	*
	* @param LeaveCategoryCode the leave category code
	* @param LeaveTypeCode the leave type code
	* @return the leave categories that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories removeByLeaveCategoryCode(
		java.lang.String LeaveCategoryCode, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .removeByLeaveCategoryCode(LeaveCategoryCode, LeaveTypeCode);
	}

	/**
	* Returns the number of leave categorieses where LeaveCategoryCode = &#63; and LeaveTypeCode = &#63;.
	*
	* @param LeaveCategoryCode the leave category code
	* @param LeaveTypeCode the leave type code
	* @return the number of matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveCategoryCode(
		java.lang.String LeaveCategoryCode, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLeaveCategoryCode(LeaveCategoryCode, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories findByLeaveCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .findByLeaveCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveCategoryName(LeaveCategory, LeaveTypeCode,
			retrieveFromCache);
	}

	/**
	* Removes the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; from the database.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the leave categories that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories removeByLeaveCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .removeByLeaveCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns the number of leave categorieses where LeaveCategory = &#63; and LeaveTypeCode = &#63;.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the number of matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveCategoryName(java.lang.String LeaveCategory,
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLeaveCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories findByCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence().findByCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName(LeaveCategory, LeaveTypeCode,
			retrieveFromCache);
	}

	/**
	* Removes the leave categories where LeaveCategory = &#63; and LeaveTypeCode = &#63; from the database.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the leave categories that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories removeByCategoryName(
		java.lang.String LeaveCategory, int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .removeByCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns the number of leave categorieses where LeaveCategory = &#63; and LeaveTypeCode = &#63;.
	*
	* @param LeaveCategory the leave category
	* @param LeaveTypeCode the leave type code
	* @return the number of matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryName(java.lang.String LeaveCategory,
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryName(LeaveCategory, LeaveTypeCode);
	}

	/**
	* Returns all the leave categorieses where LeaveCategory = &#63;.
	*
	* @param LeaveCategory the leave category
	* @return the matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveCategories> findByLeaveCategory(
		java.lang.String LeaveCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveCategory(LeaveCategory);
	}

	/**
	* Returns a range of all the leave categorieses where LeaveCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveCategory the leave category
	* @param start the lower bound of the range of leave categorieses
	* @param end the upper bound of the range of leave categorieses (not inclusive)
	* @return the range of matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveCategories> findByLeaveCategory(
		java.lang.String LeaveCategory, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveCategory(LeaveCategory, start, end);
	}

	/**
	* Returns an ordered range of all the leave categorieses where LeaveCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param LeaveCategory the leave category
	* @param start the lower bound of the range of leave categorieses
	* @param end the upper bound of the range of leave categorieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveCategories> findByLeaveCategory(
		java.lang.String LeaveCategory, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLeaveCategory(LeaveCategory, start, end,
			orderByComparator);
	}

	/**
	* Returns the first leave categories in the ordered set where LeaveCategory = &#63;.
	*
	* @param LeaveCategory the leave category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories findByLeaveCategory_First(
		java.lang.String LeaveCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .findByLeaveCategory_First(LeaveCategory, orderByComparator);
	}

	/**
	* Returns the first leave categories in the ordered set where LeaveCategory = &#63;.
	*
	* @param LeaveCategory the leave category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveCategory_First(
		java.lang.String LeaveCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveCategory_First(LeaveCategory, orderByComparator);
	}

	/**
	* Returns the last leave categories in the ordered set where LeaveCategory = &#63;.
	*
	* @param LeaveCategory the leave category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories findByLeaveCategory_Last(
		java.lang.String LeaveCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .findByLeaveCategory_Last(LeaveCategory, orderByComparator);
	}

	/**
	* Returns the last leave categories in the ordered set where LeaveCategory = &#63;.
	*
	* @param LeaveCategory the leave category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave categories, or <code>null</code> if a matching leave categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByLeaveCategory_Last(
		java.lang.String LeaveCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveCategory_Last(LeaveCategory, orderByComparator);
	}

	/**
	* Returns the leave categorieses before and after the current leave categories in the ordered set where LeaveCategory = &#63;.
	*
	* @param LeaveTypeCode the primary key of the current leave categories
	* @param LeaveCategory the leave category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories[] findByLeaveCategory_PrevAndNext(
		int LeaveTypeCode, java.lang.String LeaveCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence()
				   .findByLeaveCategory_PrevAndNext(LeaveTypeCode,
			LeaveCategory, orderByComparator);
	}

	/**
	* Removes all the leave categorieses where LeaveCategory = &#63; from the database.
	*
	* @param LeaveCategory the leave category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLeaveCategory(java.lang.String LeaveCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLeaveCategory(LeaveCategory);
	}

	/**
	* Returns the number of leave categorieses where LeaveCategory = &#63;.
	*
	* @param LeaveCategory the leave category
	* @return the number of matching leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveCategory(java.lang.String LeaveCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveCategory(LeaveCategory);
	}

	/**
	* Caches the leave categories in the entity cache if it is enabled.
	*
	* @param leaveCategories the leave categories
	*/
	public static void cacheResult(
		com.trianz.lms.model.LeaveCategories leaveCategories) {
		getPersistence().cacheResult(leaveCategories);
	}

	/**
	* Caches the leave categorieses in the entity cache if it is enabled.
	*
	* @param leaveCategorieses the leave categorieses
	*/
	public static void cacheResult(
		java.util.List<com.trianz.lms.model.LeaveCategories> leaveCategorieses) {
		getPersistence().cacheResult(leaveCategorieses);
	}

	/**
	* Creates a new leave categories with the primary key. Does not add the leave categories to the database.
	*
	* @param LeaveTypeCode the primary key for the new leave categories
	* @return the new leave categories
	*/
	public static com.trianz.lms.model.LeaveCategories create(int LeaveTypeCode) {
		return getPersistence().create(LeaveTypeCode);
	}

	/**
	* Removes the leave categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LeaveTypeCode the primary key of the leave categories
	* @return the leave categories that was removed
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories remove(int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence().remove(LeaveTypeCode);
	}

	public static com.trianz.lms.model.LeaveCategories updateImpl(
		com.trianz.lms.model.LeaveCategories leaveCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(leaveCategories);
	}

	/**
	* Returns the leave categories with the primary key or throws a {@link com.trianz.lms.NoSuchLeaveCategoriesException} if it could not be found.
	*
	* @param LeaveTypeCode the primary key of the leave categories
	* @return the leave categories
	* @throws com.trianz.lms.NoSuchLeaveCategoriesException if a leave categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories findByPrimaryKey(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.trianz.lms.NoSuchLeaveCategoriesException {
		return getPersistence().findByPrimaryKey(LeaveTypeCode);
	}

	/**
	* Returns the leave categories with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LeaveTypeCode the primary key of the leave categories
	* @return the leave categories, or <code>null</code> if a leave categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.trianz.lms.model.LeaveCategories fetchByPrimaryKey(
		int LeaveTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(LeaveTypeCode);
	}

	/**
	* Returns all the leave categorieses.
	*
	* @return the leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveCategories> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave categorieses
	* @param end the upper bound of the range of leave categorieses (not inclusive)
	* @return the range of leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveCategories> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.trianz.lms.model.impl.LeaveCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave categorieses
	* @param end the upper bound of the range of leave categorieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.trianz.lms.model.LeaveCategories> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the leave categorieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave categorieses.
	*
	* @return the number of leave categorieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LeaveCategoriesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LeaveCategoriesPersistence)PortletBeanLocatorUtil.locate(com.trianz.lms.service.ClpSerializer.getServletContextName(),
					LeaveCategoriesPersistence.class.getName());

			ReferenceRegistry.registerReference(LeaveCategoriesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LeaveCategoriesPersistence persistence) {
	}

	private static LeaveCategoriesPersistence _persistence;
}