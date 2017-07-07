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
import com.trianz.lms.service.WFHManulPunchLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class WFHManulPunchClp extends BaseModelImpl<WFHManulPunch>
	implements WFHManulPunch {
	public WFHManulPunchClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WFHManulPunch.class;
	}

	@Override
	public String getModelClassName() {
		return WFHManulPunch.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _WFHManualPunchId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setWFHManualPunchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _WFHManualPunchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("WFHManualPunchId", getWFHManualPunchId());
		attributes.put("WFHID", getWFHID());
		attributes.put("Intime", getIntime());
		attributes.put("OutTime", getOutTime());
		attributes.put("CreatedBy", getCreatedBy());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("ModifiedBy", getModifiedBy());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("PUNCHDATE", getPUNCHDATE());
		attributes.put("EmployeeID", getEmployeeID());
		attributes.put("IsApproved", getIsApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer WFHManualPunchId = (Integer)attributes.get("WFHManualPunchId");

		if (WFHManualPunchId != null) {
			setWFHManualPunchId(WFHManualPunchId);
		}

		Integer WFHID = (Integer)attributes.get("WFHID");

		if (WFHID != null) {
			setWFHID(WFHID);
		}

		Date Intime = (Date)attributes.get("Intime");

		if (Intime != null) {
			setIntime(Intime);
		}

		Date OutTime = (Date)attributes.get("OutTime");

		if (OutTime != null) {
			setOutTime(OutTime);
		}

		String CreatedBy = (String)attributes.get("CreatedBy");

		if (CreatedBy != null) {
			setCreatedBy(CreatedBy);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		String ModifiedBy = (String)attributes.get("ModifiedBy");

		if (ModifiedBy != null) {
			setModifiedBy(ModifiedBy);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		Date PUNCHDATE = (Date)attributes.get("PUNCHDATE");

		if (PUNCHDATE != null) {
			setPUNCHDATE(PUNCHDATE);
		}

		Integer EmployeeID = (Integer)attributes.get("EmployeeID");

		if (EmployeeID != null) {
			setEmployeeID(EmployeeID);
		}

		Boolean IsApproved = (Boolean)attributes.get("IsApproved");

		if (IsApproved != null) {
			setIsApproved(IsApproved);
		}
	}

	@Override
	public int getWFHManualPunchId() {
		return _WFHManualPunchId;
	}

	@Override
	public void setWFHManualPunchId(int WFHManualPunchId) {
		_WFHManualPunchId = WFHManualPunchId;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setWFHManualPunchId", int.class);

				method.invoke(_wfhManulPunchRemoteModel, WFHManualPunchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getWFHID() {
		return _WFHID;
	}

	@Override
	public void setWFHID(int WFHID) {
		_WFHID = WFHID;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setWFHID", int.class);

				method.invoke(_wfhManulPunchRemoteModel, WFHID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getIntime() {
		return _Intime;
	}

	@Override
	public void setIntime(Date Intime) {
		_Intime = Intime;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setIntime", Date.class);

				method.invoke(_wfhManulPunchRemoteModel, Intime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOutTime() {
		return _OutTime;
	}

	@Override
	public void setOutTime(Date OutTime) {
		_OutTime = OutTime;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setOutTime", Date.class);

				method.invoke(_wfhManulPunchRemoteModel, OutTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedBy() {
		return _CreatedBy;
	}

	@Override
	public void setCreatedBy(String CreatedBy) {
		_CreatedBy = CreatedBy;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_wfhManulPunchRemoteModel, CreatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _CreatedDate;
	}

	@Override
	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_wfhManulPunchRemoteModel, CreatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedBy() {
		return _ModifiedBy;
	}

	@Override
	public void setModifiedBy(String ModifiedBy) {
		_ModifiedBy = ModifiedBy;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", String.class);

				method.invoke(_wfhManulPunchRemoteModel, ModifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_wfhManulPunchRemoteModel, ModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPUNCHDATE() {
		return _PUNCHDATE;
	}

	@Override
	public void setPUNCHDATE(Date PUNCHDATE) {
		_PUNCHDATE = PUNCHDATE;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setPUNCHDATE", Date.class);

				method.invoke(_wfhManulPunchRemoteModel, PUNCHDATE);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEmployeeID() {
		return _EmployeeID;
	}

	@Override
	public void setEmployeeID(int EmployeeID) {
		_EmployeeID = EmployeeID;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeID", int.class);

				method.invoke(_wfhManulPunchRemoteModel, EmployeeID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsApproved() {
		return _IsApproved;
	}

	@Override
	public boolean isIsApproved() {
		return _IsApproved;
	}

	@Override
	public void setIsApproved(boolean IsApproved) {
		_IsApproved = IsApproved;

		if (_wfhManulPunchRemoteModel != null) {
			try {
				Class<?> clazz = _wfhManulPunchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproved", boolean.class);

				method.invoke(_wfhManulPunchRemoteModel, IsApproved);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWFHManulPunchRemoteModel() {
		return _wfhManulPunchRemoteModel;
	}

	public void setWFHManulPunchRemoteModel(
		BaseModel<?> wfhManulPunchRemoteModel) {
		_wfhManulPunchRemoteModel = wfhManulPunchRemoteModel;
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

		Class<?> remoteModelClass = _wfhManulPunchRemoteModel.getClass();

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

		Object returnValue = method.invoke(_wfhManulPunchRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WFHManulPunchLocalServiceUtil.addWFHManulPunch(this);
		}
		else {
			WFHManulPunchLocalServiceUtil.updateWFHManulPunch(this);
		}
	}

	@Override
	public WFHManulPunch toEscapedModel() {
		return (WFHManulPunch)ProxyUtil.newProxyInstance(WFHManulPunch.class.getClassLoader(),
			new Class[] { WFHManulPunch.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WFHManulPunchClp clone = new WFHManulPunchClp();

		clone.setWFHManualPunchId(getWFHManualPunchId());
		clone.setWFHID(getWFHID());
		clone.setIntime(getIntime());
		clone.setOutTime(getOutTime());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedBy(getModifiedBy());
		clone.setModifiedDate(getModifiedDate());
		clone.setPUNCHDATE(getPUNCHDATE());
		clone.setEmployeeID(getEmployeeID());
		clone.setIsApproved(getIsApproved());

		return clone;
	}

	@Override
	public int compareTo(WFHManulPunch wfhManulPunch) {
		int primaryKey = wfhManulPunch.getPrimaryKey();

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

		if (!(obj instanceof WFHManulPunchClp)) {
			return false;
		}

		WFHManulPunchClp wfhManulPunch = (WFHManulPunchClp)obj;

		int primaryKey = wfhManulPunch.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{WFHManualPunchId=");
		sb.append(getWFHManualPunchId());
		sb.append(", WFHID=");
		sb.append(getWFHID());
		sb.append(", Intime=");
		sb.append(getIntime());
		sb.append(", OutTime=");
		sb.append(getOutTime());
		sb.append(", CreatedBy=");
		sb.append(getCreatedBy());
		sb.append(", CreatedDate=");
		sb.append(getCreatedDate());
		sb.append(", ModifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", PUNCHDATE=");
		sb.append(getPUNCHDATE());
		sb.append(", EmployeeID=");
		sb.append(getEmployeeID());
		sb.append(", IsApproved=");
		sb.append(getIsApproved());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.WFHManulPunch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>WFHManualPunchId</column-name><column-value><![CDATA[");
		sb.append(getWFHManualPunchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>WFHID</column-name><column-value><![CDATA[");
		sb.append(getWFHID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Intime</column-name><column-value><![CDATA[");
		sb.append(getIntime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>OutTime</column-name><column-value><![CDATA[");
		sb.append(getOutTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreatedBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreatedDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PUNCHDATE</column-name><column-value><![CDATA[");
		sb.append(getPUNCHDATE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmployeeID</column-name><column-value><![CDATA[");
		sb.append(getEmployeeID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IsApproved</column-name><column-value><![CDATA[");
		sb.append(getIsApproved());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _WFHManualPunchId;
	private int _WFHID;
	private Date _Intime;
	private Date _OutTime;
	private String _CreatedBy;
	private Date _CreatedDate;
	private String _ModifiedBy;
	private Date _ModifiedDate;
	private Date _PUNCHDATE;
	private int _EmployeeID;
	private boolean _IsApproved;
	private BaseModel<?> _wfhManulPunchRemoteModel;
	private Class<?> _clpSerializerClass = com.trianz.lms.service.ClpSerializer.class;
}