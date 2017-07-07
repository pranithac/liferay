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
import com.trianz.lms.service.LeaveBalanceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LeaveBalanceClp extends BaseModelImpl<LeaveBalance>
	implements LeaveBalance {
	public LeaveBalanceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveBalance.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveBalance.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _EmployeeId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setEmployeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _EmployeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("ELBalance", getELBalance());
		attributes.put("CLBalance", getCLBalance());
		attributes.put("CompOffLeaveBalance", getCompOffLeaveBalance());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		Double ELBalance = (Double)attributes.get("ELBalance");

		if (ELBalance != null) {
			setELBalance(ELBalance);
		}

		Double CLBalance = (Double)attributes.get("CLBalance");

		if (CLBalance != null) {
			setCLBalance(CLBalance);
		}

		Double CompOffLeaveBalance = (Double)attributes.get(
				"CompOffLeaveBalance");

		if (CompOffLeaveBalance != null) {
			setCompOffLeaveBalance(CompOffLeaveBalance);
		}
	}

	@Override
	public int getEmployeeId() {
		return _EmployeeId;
	}

	@Override
	public void setEmployeeId(int EmployeeId) {
		_EmployeeId = EmployeeId;

		if (_leaveBalanceRemoteModel != null) {
			try {
				Class<?> clazz = _leaveBalanceRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", int.class);

				method.invoke(_leaveBalanceRemoteModel, EmployeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getELBalance() {
		return _ELBalance;
	}

	@Override
	public void setELBalance(double ELBalance) {
		_ELBalance = ELBalance;

		if (_leaveBalanceRemoteModel != null) {
			try {
				Class<?> clazz = _leaveBalanceRemoteModel.getClass();

				Method method = clazz.getMethod("setELBalance", double.class);

				method.invoke(_leaveBalanceRemoteModel, ELBalance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCLBalance() {
		return _CLBalance;
	}

	@Override
	public void setCLBalance(double CLBalance) {
		_CLBalance = CLBalance;

		if (_leaveBalanceRemoteModel != null) {
			try {
				Class<?> clazz = _leaveBalanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCLBalance", double.class);

				method.invoke(_leaveBalanceRemoteModel, CLBalance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCompOffLeaveBalance() {
		return _CompOffLeaveBalance;
	}

	@Override
	public void setCompOffLeaveBalance(double CompOffLeaveBalance) {
		_CompOffLeaveBalance = CompOffLeaveBalance;

		if (_leaveBalanceRemoteModel != null) {
			try {
				Class<?> clazz = _leaveBalanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompOffLeaveBalance",
						double.class);

				method.invoke(_leaveBalanceRemoteModel, CompOffLeaveBalance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveBalanceRemoteModel() {
		return _leaveBalanceRemoteModel;
	}

	public void setLeaveBalanceRemoteModel(BaseModel<?> leaveBalanceRemoteModel) {
		_leaveBalanceRemoteModel = leaveBalanceRemoteModel;
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

		Class<?> remoteModelClass = _leaveBalanceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveBalanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveBalanceLocalServiceUtil.addLeaveBalance(this);
		}
		else {
			LeaveBalanceLocalServiceUtil.updateLeaveBalance(this);
		}
	}

	@Override
	public LeaveBalance toEscapedModel() {
		return (LeaveBalance)ProxyUtil.newProxyInstance(LeaveBalance.class.getClassLoader(),
			new Class[] { LeaveBalance.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveBalanceClp clone = new LeaveBalanceClp();

		clone.setEmployeeId(getEmployeeId());
		clone.setELBalance(getELBalance());
		clone.setCLBalance(getCLBalance());
		clone.setCompOffLeaveBalance(getCompOffLeaveBalance());

		return clone;
	}

	@Override
	public int compareTo(LeaveBalance leaveBalance) {
		int value = 0;

		if (getEmployeeId() < leaveBalance.getEmployeeId()) {
			value = -1;
		}
		else if (getEmployeeId() > leaveBalance.getEmployeeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof LeaveBalanceClp)) {
			return false;
		}

		LeaveBalanceClp leaveBalance = (LeaveBalanceClp)obj;

		int primaryKey = leaveBalance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{EmployeeId=");
		sb.append(getEmployeeId());
		sb.append(", ELBalance=");
		sb.append(getELBalance());
		sb.append(", CLBalance=");
		sb.append(getCLBalance());
		sb.append(", CompOffLeaveBalance=");
		sb.append(getCompOffLeaveBalance());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LeaveBalance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>EmployeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ELBalance</column-name><column-value><![CDATA[");
		sb.append(getELBalance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CLBalance</column-name><column-value><![CDATA[");
		sb.append(getCLBalance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CompOffLeaveBalance</column-name><column-value><![CDATA[");
		sb.append(getCompOffLeaveBalance());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _EmployeeId;
	private double _ELBalance;
	private double _CLBalance;
	private double _CompOffLeaveBalance;
	private BaseModel<?> _leaveBalanceRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}