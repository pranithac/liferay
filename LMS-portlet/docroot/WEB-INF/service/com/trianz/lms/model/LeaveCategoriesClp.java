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

package com.trianz.lms.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.trianz.lms.service.ClpSerializer;
import com.trianz.lms.service.LeaveCategoriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LeaveCategoriesClp extends BaseModelImpl<LeaveCategories>
	implements LeaveCategories {
	public LeaveCategoriesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveCategories.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveCategories.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _LeaveTypeCode;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setLeaveTypeCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _LeaveTypeCode;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LeaveCategoryCode", getLeaveCategoryCode());
		attributes.put("LeaveCategory", getLeaveCategory());
		attributes.put("LeaveTypeCode", getLeaveTypeCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String LeaveCategoryCode = (String)attributes.get("LeaveCategoryCode");

		if (LeaveCategoryCode != null) {
			setLeaveCategoryCode(LeaveCategoryCode);
		}

		String LeaveCategory = (String)attributes.get("LeaveCategory");

		if (LeaveCategory != null) {
			setLeaveCategory(LeaveCategory);
		}

		Integer LeaveTypeCode = (Integer)attributes.get("LeaveTypeCode");

		if (LeaveTypeCode != null) {
			setLeaveTypeCode(LeaveTypeCode);
		}
	}

	@Override
	public String getLeaveCategoryCode() {
		return _LeaveCategoryCode;
	}

	@Override
	public void setLeaveCategoryCode(String LeaveCategoryCode) {
		_LeaveCategoryCode = LeaveCategoryCode;

		if (_leaveCategoriesRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCategoriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveCategoryCode",
						String.class);

				method.invoke(_leaveCategoriesRemoteModel, LeaveCategoryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveCategory() {
		return _LeaveCategory;
	}

	@Override
	public void setLeaveCategory(String LeaveCategory) {
		_LeaveCategory = LeaveCategory;

		if (_leaveCategoriesRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCategoriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveCategory", String.class);

				method.invoke(_leaveCategoriesRemoteModel, LeaveCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLeaveTypeCode() {
		return _LeaveTypeCode;
	}

	@Override
	public void setLeaveTypeCode(int LeaveTypeCode) {
		_LeaveTypeCode = LeaveTypeCode;

		if (_leaveCategoriesRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCategoriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeCode", int.class);

				method.invoke(_leaveCategoriesRemoteModel, LeaveTypeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveCategoriesRemoteModel() {
		return _leaveCategoriesRemoteModel;
	}

	public void setLeaveCategoriesRemoteModel(
		BaseModel<?> leaveCategoriesRemoteModel) {
		_leaveCategoriesRemoteModel = leaveCategoriesRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _leaveCategoriesRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_leaveCategoriesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveCategoriesLocalServiceUtil.addLeaveCategories(this);
		}
		else {
			LeaveCategoriesLocalServiceUtil.updateLeaveCategories(this);
		}
	}

	@Override
	public LeaveCategories toEscapedModel() {
		return (LeaveCategories)ProxyUtil.newProxyInstance(LeaveCategories.class.getClassLoader(),
			new Class[] { LeaveCategories.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveCategoriesClp clone = new LeaveCategoriesClp();

		clone.setLeaveCategoryCode(getLeaveCategoryCode());
		clone.setLeaveCategory(getLeaveCategory());
		clone.setLeaveTypeCode(getLeaveTypeCode());

		return clone;
	}

	@Override
	public int compareTo(LeaveCategories leaveCategories) {
		int value = 0;

		value = getLeaveCategoryCode()
					.compareTo(leaveCategories.getLeaveCategoryCode());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveCategoriesClp)) {
			return false;
		}

		LeaveCategoriesClp leaveCategories = (LeaveCategoriesClp)obj;

		int primaryKey = leaveCategories.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{LeaveCategoryCode=");
		sb.append(getLeaveCategoryCode());
		sb.append(", LeaveCategory=");
		sb.append(getLeaveCategory());
		sb.append(", LeaveTypeCode=");
		sb.append(getLeaveTypeCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LeaveCategories");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>LeaveCategoryCode</column-name><column-value><![CDATA[");
		sb.append(getLeaveCategoryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveCategory</column-name><column-value><![CDATA[");
		sb.append(getLeaveCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveTypeCode</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypeCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _LeaveCategoryCode;
	private String _LeaveCategory;
	private int _LeaveTypeCode;
	private BaseModel<?> _leaveCategoriesRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}