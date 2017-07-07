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
import com.trianz.lms.service.LMSMailNotificationsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class LMSMailNotificationsClp extends BaseModelImpl<LMSMailNotifications>
	implements LMSMailNotifications {
	public LMSMailNotificationsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LMSMailNotifications.class;
	}

	@Override
	public String getModelClassName() {
		return LMSMailNotifications.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _MailNotfnId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setMailNotfnId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _MailNotfnId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("MailNotfnId", getMailNotfnId());
		attributes.put("LeaveRequestId", getLeaveRequestId());
		attributes.put("FromAddrs", getFromAddrs());
		attributes.put("ToAddrs", getToAddrs());
		attributes.put("Comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer MailNotfnId = (Integer)attributes.get("MailNotfnId");

		if (MailNotfnId != null) {
			setMailNotfnId(MailNotfnId);
		}

		String LeaveRequestId = (String)attributes.get("LeaveRequestId");

		if (LeaveRequestId != null) {
			setLeaveRequestId(LeaveRequestId);
		}

		String FromAddrs = (String)attributes.get("FromAddrs");

		if (FromAddrs != null) {
			setFromAddrs(FromAddrs);
		}

		String ToAddrs = (String)attributes.get("ToAddrs");

		if (ToAddrs != null) {
			setToAddrs(ToAddrs);
		}

		String Comments = (String)attributes.get("Comments");

		if (Comments != null) {
			setComments(Comments);
		}
	}

	@Override
	public int getMailNotfnId() {
		return _MailNotfnId;
	}

	@Override
	public void setMailNotfnId(int MailNotfnId) {
		_MailNotfnId = MailNotfnId;

		if (_lmsMailNotificationsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsMailNotificationsRemoteModel.getClass();

				Method method = clazz.getMethod("setMailNotfnId", int.class);

				method.invoke(_lmsMailNotificationsRemoteModel, MailNotfnId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveRequestId() {
		return _LeaveRequestId;
	}

	@Override
	public void setLeaveRequestId(String LeaveRequestId) {
		_LeaveRequestId = LeaveRequestId;

		if (_lmsMailNotificationsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsMailNotificationsRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRequestId",
						String.class);

				method.invoke(_lmsMailNotificationsRemoteModel, LeaveRequestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromAddrs() {
		return _FromAddrs;
	}

	@Override
	public void setFromAddrs(String FromAddrs) {
		_FromAddrs = FromAddrs;

		if (_lmsMailNotificationsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsMailNotificationsRemoteModel.getClass();

				Method method = clazz.getMethod("setFromAddrs", String.class);

				method.invoke(_lmsMailNotificationsRemoteModel, FromAddrs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToAddrs() {
		return _ToAddrs;
	}

	@Override
	public void setToAddrs(String ToAddrs) {
		_ToAddrs = ToAddrs;

		if (_lmsMailNotificationsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsMailNotificationsRemoteModel.getClass();

				Method method = clazz.getMethod("setToAddrs", String.class);

				method.invoke(_lmsMailNotificationsRemoteModel, ToAddrs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _Comments;
	}

	@Override
	public void setComments(String Comments) {
		_Comments = Comments;

		if (_lmsMailNotificationsRemoteModel != null) {
			try {
				Class<?> clazz = _lmsMailNotificationsRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_lmsMailNotificationsRemoteModel, Comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSMailNotificationsRemoteModel() {
		return _lmsMailNotificationsRemoteModel;
	}

	public void setLMSMailNotificationsRemoteModel(
		BaseModel<?> lmsMailNotificationsRemoteModel) {
		_lmsMailNotificationsRemoteModel = lmsMailNotificationsRemoteModel;
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

		Class<?> remoteModelClass = _lmsMailNotificationsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lmsMailNotificationsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(this);
		}
		else {
			LMSMailNotificationsLocalServiceUtil.updateLMSMailNotifications(this);
		}
	}

	@Override
	public LMSMailNotifications toEscapedModel() {
		return (LMSMailNotifications)ProxyUtil.newProxyInstance(LMSMailNotifications.class.getClassLoader(),
			new Class[] { LMSMailNotifications.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSMailNotificationsClp clone = new LMSMailNotificationsClp();

		clone.setMailNotfnId(getMailNotfnId());
		clone.setLeaveRequestId(getLeaveRequestId());
		clone.setFromAddrs(getFromAddrs());
		clone.setToAddrs(getToAddrs());
		clone.setComments(getComments());

		return clone;
	}

	@Override
	public int compareTo(LMSMailNotifications lmsMailNotifications) {
		int primaryKey = lmsMailNotifications.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSMailNotificationsClp)) {
			return false;
		}

		LMSMailNotificationsClp lmsMailNotifications = (LMSMailNotificationsClp)obj;

		int primaryKey = lmsMailNotifications.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{MailNotfnId=");
		sb.append(getMailNotfnId());
		sb.append(", LeaveRequestId=");
		sb.append(getLeaveRequestId());
		sb.append(", FromAddrs=");
		sb.append(getFromAddrs());
		sb.append(", ToAddrs=");
		sb.append(getToAddrs());
		sb.append(", Comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSMailNotifications");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>MailNotfnId</column-name><column-value><![CDATA[");
		sb.append(getMailNotfnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LeaveRequestId</column-name><column-value><![CDATA[");
		sb.append(getLeaveRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FromAddrs</column-name><column-value><![CDATA[");
		sb.append(getFromAddrs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ToAddrs</column-name><column-value><![CDATA[");
		sb.append(getToAddrs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _MailNotfnId;
	private String _LeaveRequestId;
	private String _FromAddrs;
	private String _ToAddrs;
	private String _Comments;
	private BaseModel<?> _lmsMailNotificationsRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}