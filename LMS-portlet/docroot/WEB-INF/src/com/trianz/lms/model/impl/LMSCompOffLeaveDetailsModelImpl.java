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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.trianz.lms.model.LMSCompOffLeaveDetails;
import com.trianz.lms.model.LMSCompOffLeaveDetailsModel;
import com.trianz.lms.model.LMSCompOffLeaveDetailsSoap;
import com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LMSCompOffLeaveDetails service. Represents a row in the &quot;LMSCompOffLeaveDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.trianz.lms.model.LMSCompOffLeaveDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LMSCompOffLeaveDetailsImpl}.
 * </p>
 *
 * @author
 * @see LMSCompOffLeaveDetailsImpl
 * @see com.trianz.lms.model.LMSCompOffLeaveDetails
 * @see com.trianz.lms.model.LMSCompOffLeaveDetailsModel
 * @generated
 */
@JSON(strict = true)
public class LMSCompOffLeaveDetailsModelImpl extends BaseModelImpl<LMSCompOffLeaveDetails>
	implements LMSCompOffLeaveDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a l m s comp off leave details model instance should use the {@link com.trianz.lms.model.LMSCompOffLeaveDetails} interface instead.
	 */
	public static final String TABLE_NAME = "LMSCompOffLeaveDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ApprovedBy", Types.VARCHAR },
			{ "CreatedDate", Types.TIMESTAMP },
			{ "EmployeeID", Types.INTEGER },
			{ "Status", Types.VARCHAR },
			{ "CompoffDate", Types.TIMESTAMP },
			{ "CompOffId", Types.INTEGER },
			{ "ApproverEmployeeID", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table LMSCompOffLeaveDetails (ApprovedBy VARCHAR(75) null,CreatedDate DATE null,EmployeeID INTEGER not null,Status VARCHAR(75) null,CompoffDate DATE not null,CompOffId INTEGER,ApproverEmployeeID INTEGER,primary key (EmployeeID, CompoffDate))";
	public static final String TABLE_SQL_DROP = "drop table LMSCompOffLeaveDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY lmsCompOffLeaveDetails.id.CompoffDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LMSCompOffLeaveDetails.CompoffDate ASC";
	public static final String DATA_SOURCE = "devDS";
	public static final String SESSION_FACTORY = "devSessionFactory";
	public static final String TX_MANAGER = "devTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.trianz.lms.model.LMSCompOffLeaveDetails"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.trianz.lms.model.LMSCompOffLeaveDetails"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.trianz.lms.model.LMSCompOffLeaveDetails"),
			true);
	public static long APPROVEDBY_COLUMN_BITMASK = 1L;
	public static long APPROVEREMPLOYEEID_COLUMN_BITMASK = 2L;
	public static long COMPOFFID_COLUMN_BITMASK = 4L;
	public static long COMPOFFDATE_COLUMN_BITMASK = 8L;
	public static long EMPLOYEEID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LMSCompOffLeaveDetails toModel(
		LMSCompOffLeaveDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LMSCompOffLeaveDetails model = new LMSCompOffLeaveDetailsImpl();

		model.setApprovedBy(soapModel.getApprovedBy());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setEmployeeID(soapModel.getEmployeeID());
		model.setStatus(soapModel.getStatus());
		model.setCompoffDate(soapModel.getCompoffDate());
		model.setCompOffId(soapModel.getCompOffId());
		model.setApproverEmployeeID(soapModel.getApproverEmployeeID());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LMSCompOffLeaveDetails> toModels(
		LMSCompOffLeaveDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LMSCompOffLeaveDetails> models = new ArrayList<LMSCompOffLeaveDetails>(soapModels.length);

		for (LMSCompOffLeaveDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.trianz.lms.model.LMSCompOffLeaveDetails"));

	public LMSCompOffLeaveDetailsModelImpl() {
	}

	@Override
	public LMSCompOffLeaveDetailsPK getPrimaryKey() {
		return new LMSCompOffLeaveDetailsPK(_EmployeeID, _CompoffDate);
	}

	@Override
	public void setPrimaryKey(LMSCompOffLeaveDetailsPK primaryKey) {
		setEmployeeID(primaryKey.EmployeeID);
		setCompoffDate(primaryKey.CompoffDate);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new LMSCompOffLeaveDetailsPK(_EmployeeID, _CompoffDate);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((LMSCompOffLeaveDetailsPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return LMSCompOffLeaveDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSCompOffLeaveDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ApprovedBy", getApprovedBy());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("EmployeeID", getEmployeeID());
		attributes.put("Status", getStatus());
		attributes.put("CompoffDate", getCompoffDate());
		attributes.put("CompOffId", getCompOffId());
		attributes.put("ApproverEmployeeID", getApproverEmployeeID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String ApprovedBy = (String)attributes.get("ApprovedBy");

		if (ApprovedBy != null) {
			setApprovedBy(ApprovedBy);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		Integer EmployeeID = (Integer)attributes.get("EmployeeID");

		if (EmployeeID != null) {
			setEmployeeID(EmployeeID);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date CompoffDate = (Date)attributes.get("CompoffDate");

		if (CompoffDate != null) {
			setCompoffDate(CompoffDate);
		}

		Integer CompOffId = (Integer)attributes.get("CompOffId");

		if (CompOffId != null) {
			setCompOffId(CompOffId);
		}

		Integer ApproverEmployeeID = (Integer)attributes.get(
				"ApproverEmployeeID");

		if (ApproverEmployeeID != null) {
			setApproverEmployeeID(ApproverEmployeeID);
		}
	}

	@JSON
	@Override
	public String getApprovedBy() {
		if (_ApprovedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _ApprovedBy;
		}
	}

	@Override
	public void setApprovedBy(String ApprovedBy) {
		_columnBitmask |= APPROVEDBY_COLUMN_BITMASK;

		if (_originalApprovedBy == null) {
			_originalApprovedBy = _ApprovedBy;
		}

		_ApprovedBy = ApprovedBy;
	}

	public String getOriginalApprovedBy() {
		return GetterUtil.getString(_originalApprovedBy);
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _CreatedDate;
	}

	@Override
	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;
	}

	@JSON
	@Override
	public int getEmployeeID() {
		return _EmployeeID;
	}

	@Override
	public void setEmployeeID(int EmployeeID) {
		_columnBitmask |= EMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalEmployeeID) {
			_setOriginalEmployeeID = true;

			_originalEmployeeID = _EmployeeID;
		}

		_EmployeeID = EmployeeID;
	}

	public int getOriginalEmployeeID() {
		return _originalEmployeeID;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_Status == null) {
			return StringPool.BLANK;
		}
		else {
			return _Status;
		}
	}

	@Override
	public void setStatus(String Status) {
		_Status = Status;
	}

	@JSON
	@Override
	public Date getCompoffDate() {
		return _CompoffDate;
	}

	@Override
	public void setCompoffDate(Date CompoffDate) {
		_columnBitmask = -1L;

		if (_originalCompoffDate == null) {
			_originalCompoffDate = _CompoffDate;
		}

		_CompoffDate = CompoffDate;
	}

	public Date getOriginalCompoffDate() {
		return _originalCompoffDate;
	}

	@JSON
	@Override
	public int getCompOffId() {
		return _CompOffId;
	}

	@Override
	public void setCompOffId(int CompOffId) {
		_columnBitmask |= COMPOFFID_COLUMN_BITMASK;

		if (!_setOriginalCompOffId) {
			_setOriginalCompOffId = true;

			_originalCompOffId = _CompOffId;
		}

		_CompOffId = CompOffId;
	}

	public int getOriginalCompOffId() {
		return _originalCompOffId;
	}

	@JSON
	@Override
	public int getApproverEmployeeID() {
		return _ApproverEmployeeID;
	}

	@Override
	public void setApproverEmployeeID(int ApproverEmployeeID) {
		_columnBitmask |= APPROVEREMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalApproverEmployeeID) {
			_setOriginalApproverEmployeeID = true;

			_originalApproverEmployeeID = _ApproverEmployeeID;
		}

		_ApproverEmployeeID = ApproverEmployeeID;
	}

	public int getOriginalApproverEmployeeID() {
		return _originalApproverEmployeeID;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public LMSCompOffLeaveDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LMSCompOffLeaveDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LMSCompOffLeaveDetailsImpl lmsCompOffLeaveDetailsImpl = new LMSCompOffLeaveDetailsImpl();

		lmsCompOffLeaveDetailsImpl.setApprovedBy(getApprovedBy());
		lmsCompOffLeaveDetailsImpl.setCreatedDate(getCreatedDate());
		lmsCompOffLeaveDetailsImpl.setEmployeeID(getEmployeeID());
		lmsCompOffLeaveDetailsImpl.setStatus(getStatus());
		lmsCompOffLeaveDetailsImpl.setCompoffDate(getCompoffDate());
		lmsCompOffLeaveDetailsImpl.setCompOffId(getCompOffId());
		lmsCompOffLeaveDetailsImpl.setApproverEmployeeID(getApproverEmployeeID());

		lmsCompOffLeaveDetailsImpl.resetOriginalValues();

		return lmsCompOffLeaveDetailsImpl;
	}

	@Override
	public int compareTo(LMSCompOffLeaveDetails lmsCompOffLeaveDetails) {
		int value = 0;

		value = DateUtil.compareTo(getCompoffDate(),
				lmsCompOffLeaveDetails.getCompoffDate());

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

		if (!(obj instanceof LMSCompOffLeaveDetails)) {
			return false;
		}

		LMSCompOffLeaveDetails lmsCompOffLeaveDetails = (LMSCompOffLeaveDetails)obj;

		LMSCompOffLeaveDetailsPK primaryKey = lmsCompOffLeaveDetails.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		LMSCompOffLeaveDetailsModelImpl lmsCompOffLeaveDetailsModelImpl = this;

		lmsCompOffLeaveDetailsModelImpl._originalApprovedBy = lmsCompOffLeaveDetailsModelImpl._ApprovedBy;

		lmsCompOffLeaveDetailsModelImpl._originalEmployeeID = lmsCompOffLeaveDetailsModelImpl._EmployeeID;

		lmsCompOffLeaveDetailsModelImpl._setOriginalEmployeeID = false;

		lmsCompOffLeaveDetailsModelImpl._originalCompoffDate = lmsCompOffLeaveDetailsModelImpl._CompoffDate;

		lmsCompOffLeaveDetailsModelImpl._originalCompOffId = lmsCompOffLeaveDetailsModelImpl._CompOffId;

		lmsCompOffLeaveDetailsModelImpl._setOriginalCompOffId = false;

		lmsCompOffLeaveDetailsModelImpl._originalApproverEmployeeID = lmsCompOffLeaveDetailsModelImpl._ApproverEmployeeID;

		lmsCompOffLeaveDetailsModelImpl._setOriginalApproverEmployeeID = false;

		lmsCompOffLeaveDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LMSCompOffLeaveDetails> toCacheModel() {
		LMSCompOffLeaveDetailsCacheModel lmsCompOffLeaveDetailsCacheModel = new LMSCompOffLeaveDetailsCacheModel();

		lmsCompOffLeaveDetailsCacheModel.ApprovedBy = getApprovedBy();

		String ApprovedBy = lmsCompOffLeaveDetailsCacheModel.ApprovedBy;

		if ((ApprovedBy != null) && (ApprovedBy.length() == 0)) {
			lmsCompOffLeaveDetailsCacheModel.ApprovedBy = null;
		}

		Date CreatedDate = getCreatedDate();

		if (CreatedDate != null) {
			lmsCompOffLeaveDetailsCacheModel.CreatedDate = CreatedDate.getTime();
		}
		else {
			lmsCompOffLeaveDetailsCacheModel.CreatedDate = Long.MIN_VALUE;
		}

		lmsCompOffLeaveDetailsCacheModel.EmployeeID = getEmployeeID();

		lmsCompOffLeaveDetailsCacheModel.Status = getStatus();

		String Status = lmsCompOffLeaveDetailsCacheModel.Status;

		if ((Status != null) && (Status.length() == 0)) {
			lmsCompOffLeaveDetailsCacheModel.Status = null;
		}

		Date CompoffDate = getCompoffDate();

		if (CompoffDate != null) {
			lmsCompOffLeaveDetailsCacheModel.CompoffDate = CompoffDate.getTime();
		}
		else {
			lmsCompOffLeaveDetailsCacheModel.CompoffDate = Long.MIN_VALUE;
		}

		lmsCompOffLeaveDetailsCacheModel.CompOffId = getCompOffId();

		lmsCompOffLeaveDetailsCacheModel.ApproverEmployeeID = getApproverEmployeeID();

		return lmsCompOffLeaveDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ApprovedBy=");
		sb.append(getApprovedBy());
		sb.append(", CreatedDate=");
		sb.append(getCreatedDate());
		sb.append(", EmployeeID=");
		sb.append(getEmployeeID());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", CompoffDate=");
		sb.append(getCompoffDate());
		sb.append(", CompOffId=");
		sb.append(getCompOffId());
		sb.append(", ApproverEmployeeID=");
		sb.append(getApproverEmployeeID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSCompOffLeaveDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ApprovedBy</column-name><column-value><![CDATA[");
		sb.append(getApprovedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreatedDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmployeeID</column-name><column-value><![CDATA[");
		sb.append(getEmployeeID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CompoffDate</column-name><column-value><![CDATA[");
		sb.append(getCompoffDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CompOffId</column-name><column-value><![CDATA[");
		sb.append(getCompOffId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverEmployeeID</column-name><column-value><![CDATA[");
		sb.append(getApproverEmployeeID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LMSCompOffLeaveDetails.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			LMSCompOffLeaveDetails.class
		};
	private String _ApprovedBy;
	private String _originalApprovedBy;
	private Date _CreatedDate;
	private int _EmployeeID;
	private int _originalEmployeeID;
	private boolean _setOriginalEmployeeID;
	private String _Status;
	private Date _CompoffDate;
	private Date _originalCompoffDate;
	private int _CompOffId;
	private int _originalCompOffId;
	private boolean _setOriginalCompOffId;
	private int _ApproverEmployeeID;
	private int _originalApproverEmployeeID;
	private boolean _setOriginalApproverEmployeeID;
	private long _columnBitmask;
	private LMSCompOffLeaveDetails _escapedModel;
}