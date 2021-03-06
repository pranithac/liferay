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

package com.trianz.lms.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.trianz.lms.model.LMSEmployeeDetails;
import com.trianz.lms.model.LMSEmployeeDetailsModel;
import com.trianz.lms.model.LMSEmployeeDetailsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LMSEmployeeDetails service. Represents a row in the &quot;LMSEmployeeDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.trianz.lms.model.LMSEmployeeDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LMSEmployeeDetailsImpl}.
 * </p>
 *
 * @author
 * @see LMSEmployeeDetailsImpl
 * @see com.trianz.lms.model.LMSEmployeeDetails
 * @see com.trianz.lms.model.LMSEmployeeDetailsModel
 * @generated
 */
@JSON(strict = true)
public class LMSEmployeeDetailsModelImpl extends BaseModelImpl<LMSEmployeeDetails>
	implements LMSEmployeeDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a l m s employee details model instance should use the {@link com.trianz.lms.model.LMSEmployeeDetails} interface instead.
	 */
	public static final String TABLE_NAME = "LMSEmployeeDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "EmployeeId", Types.INTEGER },
			{ "EmployeeName", Types.VARCHAR },
			{ "EmployeeEmailID", Types.VARCHAR },
			{ "JoiningDate", Types.TIMESTAMP },
			{ "SupervisorId", Types.INTEGER },
			{ "SupervisorName", Types.VARCHAR },
			{ "SupervisorEmail", Types.VARCHAR },
			{ "Location", Types.VARCHAR },
			{ "Region", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table LMSEmployeeDetails (EmployeeId INTEGER not null primary key,EmployeeName VARCHAR(75) null,EmployeeEmailID VARCHAR(75) null,JoiningDate DATE null,SupervisorId INTEGER,SupervisorName VARCHAR(75) null,SupervisorEmail VARCHAR(75) null,Location VARCHAR(75) null,Region VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table LMSEmployeeDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY lmsEmployeeDetails.EmployeeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LMSEmployeeDetails.EmployeeId ASC";
	public static final String DATA_SOURCE = "devDS";
	public static final String SESSION_FACTORY = "devSessionFactory";
	public static final String TX_MANAGER = "devTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.trianz.lms.model.LMSEmployeeDetails"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.trianz.lms.model.LMSEmployeeDetails"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.trianz.lms.model.LMSEmployeeDetails"),
			true);
	public static long EMPLOYEEEMAILID_COLUMN_BITMASK = 1L;
	public static long EMPLOYEENAME_COLUMN_BITMASK = 2L;
	public static long SUPERVISOREMAIL_COLUMN_BITMASK = 4L;
	public static long EMPLOYEEID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LMSEmployeeDetails toModel(LMSEmployeeDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LMSEmployeeDetails model = new LMSEmployeeDetailsImpl();

		model.setEmployeeId(soapModel.getEmployeeId());
		model.setEmployeeName(soapModel.getEmployeeName());
		model.setEmployeeEmailID(soapModel.getEmployeeEmailID());
		model.setJoiningDate(soapModel.getJoiningDate());
		model.setSupervisorId(soapModel.getSupervisorId());
		model.setSupervisorName(soapModel.getSupervisorName());
		model.setSupervisorEmail(soapModel.getSupervisorEmail());
		model.setLocation(soapModel.getLocation());
		model.setRegion(soapModel.getRegion());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LMSEmployeeDetails> toModels(
		LMSEmployeeDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LMSEmployeeDetails> models = new ArrayList<LMSEmployeeDetails>(soapModels.length);

		for (LMSEmployeeDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.trianz.lms.model.LMSEmployeeDetails"));

	public LMSEmployeeDetailsModelImpl() {
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
	public Class<?> getModelClass() {
		return LMSEmployeeDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSEmployeeDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("EmployeeName", getEmployeeName());
		attributes.put("EmployeeEmailID", getEmployeeEmailID());
		attributes.put("JoiningDate", getJoiningDate());
		attributes.put("SupervisorId", getSupervisorId());
		attributes.put("SupervisorName", getSupervisorName());
		attributes.put("SupervisorEmail", getSupervisorEmail());
		attributes.put("Location", getLocation());
		attributes.put("Region", getRegion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		String EmployeeName = (String)attributes.get("EmployeeName");

		if (EmployeeName != null) {
			setEmployeeName(EmployeeName);
		}

		String EmployeeEmailID = (String)attributes.get("EmployeeEmailID");

		if (EmployeeEmailID != null) {
			setEmployeeEmailID(EmployeeEmailID);
		}

		Date JoiningDate = (Date)attributes.get("JoiningDate");

		if (JoiningDate != null) {
			setJoiningDate(JoiningDate);
		}

		Integer SupervisorId = (Integer)attributes.get("SupervisorId");

		if (SupervisorId != null) {
			setSupervisorId(SupervisorId);
		}

		String SupervisorName = (String)attributes.get("SupervisorName");

		if (SupervisorName != null) {
			setSupervisorName(SupervisorName);
		}

		String SupervisorEmail = (String)attributes.get("SupervisorEmail");

		if (SupervisorEmail != null) {
			setSupervisorEmail(SupervisorEmail);
		}

		String Location = (String)attributes.get("Location");

		if (Location != null) {
			setLocation(Location);
		}

		String Region = (String)attributes.get("Region");

		if (Region != null) {
			setRegion(Region);
		}
	}

	@JSON
	@Override
	public int getEmployeeId() {
		return _EmployeeId;
	}

	@Override
	public void setEmployeeId(int EmployeeId) {
		_columnBitmask = -1L;

		_EmployeeId = EmployeeId;
	}

	@JSON
	@Override
	public String getEmployeeName() {
		if (_EmployeeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _EmployeeName;
		}
	}

	@Override
	public void setEmployeeName(String EmployeeName) {
		_columnBitmask |= EMPLOYEENAME_COLUMN_BITMASK;

		if (_originalEmployeeName == null) {
			_originalEmployeeName = _EmployeeName;
		}

		_EmployeeName = EmployeeName;
	}

	public String getOriginalEmployeeName() {
		return GetterUtil.getString(_originalEmployeeName);
	}

	@JSON
	@Override
	public String getEmployeeEmailID() {
		if (_EmployeeEmailID == null) {
			return StringPool.BLANK;
		}
		else {
			return _EmployeeEmailID;
		}
	}

	@Override
	public void setEmployeeEmailID(String EmployeeEmailID) {
		_columnBitmask |= EMPLOYEEEMAILID_COLUMN_BITMASK;

		if (_originalEmployeeEmailID == null) {
			_originalEmployeeEmailID = _EmployeeEmailID;
		}

		_EmployeeEmailID = EmployeeEmailID;
	}

	public String getOriginalEmployeeEmailID() {
		return GetterUtil.getString(_originalEmployeeEmailID);
	}

	@JSON
	@Override
	public Date getJoiningDate() {
		return _JoiningDate;
	}

	@Override
	public void setJoiningDate(Date JoiningDate) {
		_JoiningDate = JoiningDate;
	}

	@JSON
	@Override
	public int getSupervisorId() {
		return _SupervisorId;
	}

	@Override
	public void setSupervisorId(int SupervisorId) {
		_SupervisorId = SupervisorId;
	}

	@JSON
	@Override
	public String getSupervisorName() {
		if (_SupervisorName == null) {
			return StringPool.BLANK;
		}
		else {
			return _SupervisorName;
		}
	}

	@Override
	public void setSupervisorName(String SupervisorName) {
		_SupervisorName = SupervisorName;
	}

	@JSON
	@Override
	public String getSupervisorEmail() {
		if (_SupervisorEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _SupervisorEmail;
		}
	}

	@Override
	public void setSupervisorEmail(String SupervisorEmail) {
		_columnBitmask |= SUPERVISOREMAIL_COLUMN_BITMASK;

		if (_originalSupervisorEmail == null) {
			_originalSupervisorEmail = _SupervisorEmail;
		}

		_SupervisorEmail = SupervisorEmail;
	}

	public String getOriginalSupervisorEmail() {
		return GetterUtil.getString(_originalSupervisorEmail);
	}

	@JSON
	@Override
	public String getLocation() {
		if (_Location == null) {
			return StringPool.BLANK;
		}
		else {
			return _Location;
		}
	}

	@Override
	public void setLocation(String Location) {
		_Location = Location;
	}

	@JSON
	@Override
	public String getRegion() {
		if (_Region == null) {
			return StringPool.BLANK;
		}
		else {
			return _Region;
		}
	}

	@Override
	public void setRegion(String Region) {
		_Region = Region;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public LMSEmployeeDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LMSEmployeeDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LMSEmployeeDetailsImpl lmsEmployeeDetailsImpl = new LMSEmployeeDetailsImpl();

		lmsEmployeeDetailsImpl.setEmployeeId(getEmployeeId());
		lmsEmployeeDetailsImpl.setEmployeeName(getEmployeeName());
		lmsEmployeeDetailsImpl.setEmployeeEmailID(getEmployeeEmailID());
		lmsEmployeeDetailsImpl.setJoiningDate(getJoiningDate());
		lmsEmployeeDetailsImpl.setSupervisorId(getSupervisorId());
		lmsEmployeeDetailsImpl.setSupervisorName(getSupervisorName());
		lmsEmployeeDetailsImpl.setSupervisorEmail(getSupervisorEmail());
		lmsEmployeeDetailsImpl.setLocation(getLocation());
		lmsEmployeeDetailsImpl.setRegion(getRegion());

		lmsEmployeeDetailsImpl.resetOriginalValues();

		return lmsEmployeeDetailsImpl;
	}

	@Override
	public int compareTo(LMSEmployeeDetails lmsEmployeeDetails) {
		int value = 0;

		if (getEmployeeId() < lmsEmployeeDetails.getEmployeeId()) {
			value = -1;
		}
		else if (getEmployeeId() > lmsEmployeeDetails.getEmployeeId()) {
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

		if (!(obj instanceof LMSEmployeeDetails)) {
			return false;
		}

		LMSEmployeeDetails lmsEmployeeDetails = (LMSEmployeeDetails)obj;

		int primaryKey = lmsEmployeeDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LMSEmployeeDetailsModelImpl lmsEmployeeDetailsModelImpl = this;

		lmsEmployeeDetailsModelImpl._originalEmployeeName = lmsEmployeeDetailsModelImpl._EmployeeName;

		lmsEmployeeDetailsModelImpl._originalEmployeeEmailID = lmsEmployeeDetailsModelImpl._EmployeeEmailID;

		lmsEmployeeDetailsModelImpl._originalSupervisorEmail = lmsEmployeeDetailsModelImpl._SupervisorEmail;

		lmsEmployeeDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LMSEmployeeDetails> toCacheModel() {
		LMSEmployeeDetailsCacheModel lmsEmployeeDetailsCacheModel = new LMSEmployeeDetailsCacheModel();

		lmsEmployeeDetailsCacheModel.EmployeeId = getEmployeeId();

		lmsEmployeeDetailsCacheModel.EmployeeName = getEmployeeName();

		String EmployeeName = lmsEmployeeDetailsCacheModel.EmployeeName;

		if ((EmployeeName != null) && (EmployeeName.length() == 0)) {
			lmsEmployeeDetailsCacheModel.EmployeeName = null;
		}

		lmsEmployeeDetailsCacheModel.EmployeeEmailID = getEmployeeEmailID();

		String EmployeeEmailID = lmsEmployeeDetailsCacheModel.EmployeeEmailID;

		if ((EmployeeEmailID != null) && (EmployeeEmailID.length() == 0)) {
			lmsEmployeeDetailsCacheModel.EmployeeEmailID = null;
		}

		Date JoiningDate = getJoiningDate();

		if (JoiningDate != null) {
			lmsEmployeeDetailsCacheModel.JoiningDate = JoiningDate.getTime();
		}
		else {
			lmsEmployeeDetailsCacheModel.JoiningDate = Long.MIN_VALUE;
		}

		lmsEmployeeDetailsCacheModel.SupervisorId = getSupervisorId();

		lmsEmployeeDetailsCacheModel.SupervisorName = getSupervisorName();

		String SupervisorName = lmsEmployeeDetailsCacheModel.SupervisorName;

		if ((SupervisorName != null) && (SupervisorName.length() == 0)) {
			lmsEmployeeDetailsCacheModel.SupervisorName = null;
		}

		lmsEmployeeDetailsCacheModel.SupervisorEmail = getSupervisorEmail();

		String SupervisorEmail = lmsEmployeeDetailsCacheModel.SupervisorEmail;

		if ((SupervisorEmail != null) && (SupervisorEmail.length() == 0)) {
			lmsEmployeeDetailsCacheModel.SupervisorEmail = null;
		}

		lmsEmployeeDetailsCacheModel.Location = getLocation();

		String Location = lmsEmployeeDetailsCacheModel.Location;

		if ((Location != null) && (Location.length() == 0)) {
			lmsEmployeeDetailsCacheModel.Location = null;
		}

		lmsEmployeeDetailsCacheModel.Region = getRegion();

		String Region = lmsEmployeeDetailsCacheModel.Region;

		if ((Region != null) && (Region.length() == 0)) {
			lmsEmployeeDetailsCacheModel.Region = null;
		}

		return lmsEmployeeDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{EmployeeId=");
		sb.append(getEmployeeId());
		sb.append(", EmployeeName=");
		sb.append(getEmployeeName());
		sb.append(", EmployeeEmailID=");
		sb.append(getEmployeeEmailID());
		sb.append(", JoiningDate=");
		sb.append(getJoiningDate());
		sb.append(", SupervisorId=");
		sb.append(getSupervisorId());
		sb.append(", SupervisorName=");
		sb.append(getSupervisorName());
		sb.append(", SupervisorEmail=");
		sb.append(getSupervisorEmail());
		sb.append(", Location=");
		sb.append(getLocation());
		sb.append(", Region=");
		sb.append(getRegion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSEmployeeDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>EmployeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmployeeName</column-name><column-value><![CDATA[");
		sb.append(getEmployeeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmployeeEmailID</column-name><column-value><![CDATA[");
		sb.append(getEmployeeEmailID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JoiningDate</column-name><column-value><![CDATA[");
		sb.append(getJoiningDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SupervisorId</column-name><column-value><![CDATA[");
		sb.append(getSupervisorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SupervisorName</column-name><column-value><![CDATA[");
		sb.append(getSupervisorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SupervisorEmail</column-name><column-value><![CDATA[");
		sb.append(getSupervisorEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Region</column-name><column-value><![CDATA[");
		sb.append(getRegion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LMSEmployeeDetails.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			LMSEmployeeDetails.class
		};
	private int _EmployeeId;
	private String _EmployeeName;
	private String _originalEmployeeName;
	private String _EmployeeEmailID;
	private String _originalEmployeeEmailID;
	private Date _JoiningDate;
	private int _SupervisorId;
	private String _SupervisorName;
	private String _SupervisorEmail;
	private String _originalSupervisorEmail;
	private String _Location;
	private String _Region;
	private long _columnBitmask;
	private LMSEmployeeDetails _escapedModel;
}