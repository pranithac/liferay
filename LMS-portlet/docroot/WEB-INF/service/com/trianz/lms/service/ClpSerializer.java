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

package com.trianz.lms.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.trianz.lms.model.LMSCompOffLeaveDetailsClp;
import com.trianz.lms.model.LMSEmployeeDetailsClp;
import com.trianz.lms.model.LMSHolidaysClp;
import com.trianz.lms.model.LMSLeaveInformationClp;
import com.trianz.lms.model.LMSLeavePoliciesClp;
import com.trianz.lms.model.LMSLeaveTypeClp;
import com.trianz.lms.model.LMSMailNotificationsClp;
import com.trianz.lms.model.LMSProjectDetailsClp;
import com.trianz.lms.model.LMSWeekendsClp;
import com.trianz.lms.model.LeaveApprovalHistoryClp;
import com.trianz.lms.model.LeaveBalanceClp;
import com.trianz.lms.model.LeaveCategoriesClp;
import com.trianz.lms.model.LeaveInformationAuditClp;
import com.trianz.lms.model.WFHManulPunchClp;
import com.trianz.lms.model.securaxEmployeeHrsClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author $author$
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"LMS-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"LMS-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "LMS-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(LeaveApprovalHistoryClp.class.getName())) {
			return translateInputLeaveApprovalHistory(oldModel);
		}

		if (oldModelClassName.equals(LeaveBalanceClp.class.getName())) {
			return translateInputLeaveBalance(oldModel);
		}

		if (oldModelClassName.equals(LeaveCategoriesClp.class.getName())) {
			return translateInputLeaveCategories(oldModel);
		}

		if (oldModelClassName.equals(LeaveInformationAuditClp.class.getName())) {
			return translateInputLeaveInformationAudit(oldModel);
		}

		if (oldModelClassName.equals(LMSCompOffLeaveDetailsClp.class.getName())) {
			return translateInputLMSCompOffLeaveDetails(oldModel);
		}

		if (oldModelClassName.equals(LMSEmployeeDetailsClp.class.getName())) {
			return translateInputLMSEmployeeDetails(oldModel);
		}

		if (oldModelClassName.equals(LMSHolidaysClp.class.getName())) {
			return translateInputLMSHolidays(oldModel);
		}

		if (oldModelClassName.equals(LMSLeaveInformationClp.class.getName())) {
			return translateInputLMSLeaveInformation(oldModel);
		}

		if (oldModelClassName.equals(LMSLeavePoliciesClp.class.getName())) {
			return translateInputLMSLeavePolicies(oldModel);
		}

		if (oldModelClassName.equals(LMSLeaveTypeClp.class.getName())) {
			return translateInputLMSLeaveType(oldModel);
		}

		if (oldModelClassName.equals(LMSMailNotificationsClp.class.getName())) {
			return translateInputLMSMailNotifications(oldModel);
		}

		if (oldModelClassName.equals(LMSProjectDetailsClp.class.getName())) {
			return translateInputLMSProjectDetails(oldModel);
		}

		if (oldModelClassName.equals(LMSWeekendsClp.class.getName())) {
			return translateInputLMSWeekends(oldModel);
		}

		if (oldModelClassName.equals(securaxEmployeeHrsClp.class.getName())) {
			return translateInputsecuraxEmployeeHrs(oldModel);
		}

		if (oldModelClassName.equals(WFHManulPunchClp.class.getName())) {
			return translateInputWFHManulPunch(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputLeaveApprovalHistory(
		BaseModel<?> oldModel) {
		LeaveApprovalHistoryClp oldClpModel = (LeaveApprovalHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveApprovalHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveBalance(BaseModel<?> oldModel) {
		LeaveBalanceClp oldClpModel = (LeaveBalanceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveBalanceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveCategories(BaseModel<?> oldModel) {
		LeaveCategoriesClp oldClpModel = (LeaveCategoriesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveCategoriesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveInformationAudit(
		BaseModel<?> oldModel) {
		LeaveInformationAuditClp oldClpModel = (LeaveInformationAuditClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveInformationAuditRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSCompOffLeaveDetails(
		BaseModel<?> oldModel) {
		LMSCompOffLeaveDetailsClp oldClpModel = (LMSCompOffLeaveDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSCompOffLeaveDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSEmployeeDetails(BaseModel<?> oldModel) {
		LMSEmployeeDetailsClp oldClpModel = (LMSEmployeeDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSEmployeeDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSHolidays(BaseModel<?> oldModel) {
		LMSHolidaysClp oldClpModel = (LMSHolidaysClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSHolidaysRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSLeaveInformation(
		BaseModel<?> oldModel) {
		LMSLeaveInformationClp oldClpModel = (LMSLeaveInformationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSLeaveInformationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSLeavePolicies(BaseModel<?> oldModel) {
		LMSLeavePoliciesClp oldClpModel = (LMSLeavePoliciesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSLeavePoliciesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSLeaveType(BaseModel<?> oldModel) {
		LMSLeaveTypeClp oldClpModel = (LMSLeaveTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSLeaveTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSMailNotifications(
		BaseModel<?> oldModel) {
		LMSMailNotificationsClp oldClpModel = (LMSMailNotificationsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSMailNotificationsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSProjectDetails(BaseModel<?> oldModel) {
		LMSProjectDetailsClp oldClpModel = (LMSProjectDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSProjectDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLMSWeekends(BaseModel<?> oldModel) {
		LMSWeekendsClp oldClpModel = (LMSWeekendsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLMSWeekendsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputsecuraxEmployeeHrs(BaseModel<?> oldModel) {
		securaxEmployeeHrsClp oldClpModel = (securaxEmployeeHrsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getsecuraxEmployeeHrsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWFHManulPunch(BaseModel<?> oldModel) {
		WFHManulPunchClp oldClpModel = (WFHManulPunchClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWFHManulPunchRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LeaveApprovalHistoryImpl")) {
			return translateOutputLeaveApprovalHistory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LeaveBalanceImpl")) {
			return translateOutputLeaveBalance(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LeaveCategoriesImpl")) {
			return translateOutputLeaveCategories(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LeaveInformationAuditImpl")) {
			return translateOutputLeaveInformationAudit(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSCompOffLeaveDetailsImpl")) {
			return translateOutputLMSCompOffLeaveDetails(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSEmployeeDetailsImpl")) {
			return translateOutputLMSEmployeeDetails(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSHolidaysImpl")) {
			return translateOutputLMSHolidays(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSLeaveInformationImpl")) {
			return translateOutputLMSLeaveInformation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSLeavePoliciesImpl")) {
			return translateOutputLMSLeavePolicies(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSLeaveTypeImpl")) {
			return translateOutputLMSLeaveType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSMailNotificationsImpl")) {
			return translateOutputLMSMailNotifications(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSProjectDetailsImpl")) {
			return translateOutputLMSProjectDetails(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.LMSWeekendsImpl")) {
			return translateOutputLMSWeekends(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.securaxEmployeeHrsImpl")) {
			return translateOutputsecuraxEmployeeHrs(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.trianz.lms.model.impl.WFHManulPunchImpl")) {
			return translateOutputWFHManulPunch(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.trianz.lms.NoSuchLeaveApprovalHistoryException")) {
			return new com.trianz.lms.NoSuchLeaveApprovalHistoryException();
		}

		if (className.equals("com.trianz.lms.NoSuchLeaveBalanceException")) {
			return new com.trianz.lms.NoSuchLeaveBalanceException();
		}

		if (className.equals("com.trianz.lms.NoSuchLeaveCategoriesException")) {
			return new com.trianz.lms.NoSuchLeaveCategoriesException();
		}

		if (className.equals(
					"com.trianz.lms.NoSuchLeaveInformationAuditException")) {
			return new com.trianz.lms.NoSuchLeaveInformationAuditException();
		}

		if (className.equals(
					"com.trianz.lms.NoSuchCompOffLeaveDetailsException")) {
			return new com.trianz.lms.NoSuchCompOffLeaveDetailsException();
		}

		if (className.equals("com.trianz.lms.NoSuchEmployeeDetailsException")) {
			return new com.trianz.lms.NoSuchEmployeeDetailsException();
		}

		if (className.equals("com.trianz.lms.NoSuchHolidaysException")) {
			return new com.trianz.lms.NoSuchHolidaysException();
		}

		if (className.equals("com.trianz.lms.NoSuchLeaveInformationException")) {
			return new com.trianz.lms.NoSuchLeaveInformationException();
		}

		if (className.equals("com.trianz.lms.NoSuchLeavePoliciesException")) {
			return new com.trianz.lms.NoSuchLeavePoliciesException();
		}

		if (className.equals("com.trianz.lms.NoSuchLeaveTypeException")) {
			return new com.trianz.lms.NoSuchLeaveTypeException();
		}

		if (className.equals("com.trianz.lms.NoSuchMailNotificationsException")) {
			return new com.trianz.lms.NoSuchMailNotificationsException();
		}

		if (className.equals("com.trianz.lms.NoSuchProjectDetailsException")) {
			return new com.trianz.lms.NoSuchProjectDetailsException();
		}

		if (className.equals("com.trianz.lms.NoSuchWeekendsException")) {
			return new com.trianz.lms.NoSuchWeekendsException();
		}

		if (className.equals("com.trianz.lms.NoSuchsecuraxEmployeeHrsException")) {
			return new com.trianz.lms.NoSuchsecuraxEmployeeHrsException();
		}

		if (className.equals("com.trianz.lms.NoSuchWFHManulPunchException")) {
			return new com.trianz.lms.NoSuchWFHManulPunchException();
		}

		return throwable;
	}

	public static Object translateOutputLeaveApprovalHistory(
		BaseModel<?> oldModel) {
		LeaveApprovalHistoryClp newModel = new LeaveApprovalHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveApprovalHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveBalance(BaseModel<?> oldModel) {
		LeaveBalanceClp newModel = new LeaveBalanceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveBalanceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveCategories(BaseModel<?> oldModel) {
		LeaveCategoriesClp newModel = new LeaveCategoriesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveCategoriesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveInformationAudit(
		BaseModel<?> oldModel) {
		LeaveInformationAuditClp newModel = new LeaveInformationAuditClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveInformationAuditRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSCompOffLeaveDetails(
		BaseModel<?> oldModel) {
		LMSCompOffLeaveDetailsClp newModel = new LMSCompOffLeaveDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSCompOffLeaveDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSEmployeeDetails(
		BaseModel<?> oldModel) {
		LMSEmployeeDetailsClp newModel = new LMSEmployeeDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSEmployeeDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSHolidays(BaseModel<?> oldModel) {
		LMSHolidaysClp newModel = new LMSHolidaysClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSHolidaysRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSLeaveInformation(
		BaseModel<?> oldModel) {
		LMSLeaveInformationClp newModel = new LMSLeaveInformationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSLeaveInformationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSLeavePolicies(BaseModel<?> oldModel) {
		LMSLeavePoliciesClp newModel = new LMSLeavePoliciesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSLeavePoliciesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSLeaveType(BaseModel<?> oldModel) {
		LMSLeaveTypeClp newModel = new LMSLeaveTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSLeaveTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSMailNotifications(
		BaseModel<?> oldModel) {
		LMSMailNotificationsClp newModel = new LMSMailNotificationsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSMailNotificationsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSProjectDetails(BaseModel<?> oldModel) {
		LMSProjectDetailsClp newModel = new LMSProjectDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSProjectDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLMSWeekends(BaseModel<?> oldModel) {
		LMSWeekendsClp newModel = new LMSWeekendsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLMSWeekendsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputsecuraxEmployeeHrs(
		BaseModel<?> oldModel) {
		securaxEmployeeHrsClp newModel = new securaxEmployeeHrsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setsecuraxEmployeeHrsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWFHManulPunch(BaseModel<?> oldModel) {
		WFHManulPunchClp newModel = new WFHManulPunchClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWFHManulPunchRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}