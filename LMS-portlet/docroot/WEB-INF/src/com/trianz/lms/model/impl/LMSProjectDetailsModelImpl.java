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

import com.trianz.lms.model.LMSProjectDetails;
import com.trianz.lms.model.LMSProjectDetailsModel;
import com.trianz.lms.model.LMSProjectDetailsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LMSProjectDetails service. Represents a row in the &quot;LMSProjectDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.trianz.lms.model.LMSProjectDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LMSProjectDetailsImpl}.
 * </p>
 *
 * @author
 * @see LMSProjectDetailsImpl
 * @see com.trianz.lms.model.LMSProjectDetails
 * @see com.trianz.lms.model.LMSProjectDetailsModel
 * @generated
 */
@JSON(strict = true)
public class LMSProjectDetailsModelImpl extends BaseModelImpl<LMSProjectDetails>
	implements LMSProjectDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a l m s project details model instance should use the {@link com.trianz.lms.model.LMSProjectDetails} interface instead.
	 */
	public static final String TABLE_NAME = "LMSProjectDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "EmployeeId", Types.INTEGER },
			{ "ProjectCode", Types.VARCHAR },
			{ "ProjectName", Types.VARCHAR },
			{ "ApproverName", Types.VARCHAR },
			{ "ApproverID", Types.INTEGER },
			{ "ApproverEmail", Types.VARCHAR },
			{ "AssignmentID", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table LMSProjectDetails (EmployeeId INTEGER,ProjectCode VARCHAR(75) null,ProjectName VARCHAR(75) null,ApproverName VARCHAR(75) null,ApproverID INTEGER,ApproverEmail VARCHAR(75) null,AssignmentID INTEGER not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table LMSProjectDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY lmsProjectDetails.EmployeeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LMSProjectDetails.EmployeeId ASC";
	public static final String DATA_SOURCE = "devDS";
	public static final String SESSION_FACTORY = "devSessionFactory";
	public static final String TX_MANAGER = "devTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.trianz.lms.model.LMSProjectDetails"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.trianz.lms.model.LMSProjectDetails"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.trianz.lms.model.LMSProjectDetails"),
			true);
	public static long APPROVEREMAIL_COLUMN_BITMASK = 1L;
	public static long EMPLOYEEID_COLUMN_BITMASK = 2L;
	public static long PROJECTCODE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LMSProjectDetails toModel(LMSProjectDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LMSProjectDetails model = new LMSProjectDetailsImpl();

		model.setEmployeeId(soapModel.getEmployeeId());
		model.setProjectCode(soapModel.getProjectCode());
		model.setProjectName(soapModel.getProjectName());
		model.setApproverName(soapModel.getApproverName());
		model.setApproverID(soapModel.getApproverID());
		model.setApproverEmail(soapModel.getApproverEmail());
		model.setAssignmentID(soapModel.getAssignmentID());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LMSProjectDetails> toModels(
		LMSProjectDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LMSProjectDetails> models = new ArrayList<LMSProjectDetails>(soapModels.length);

		for (LMSProjectDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.trianz.lms.model.LMSProjectDetails"));

	public LMSProjectDetailsModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _AssignmentID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setAssignmentID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _AssignmentID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LMSProjectDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LMSProjectDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EmployeeId", getEmployeeId());
		attributes.put("ProjectCode", getProjectCode());
		attributes.put("ProjectName", getProjectName());
		attributes.put("ApproverName", getApproverName());
		attributes.put("ApproverID", getApproverID());
		attributes.put("ApproverEmail", getApproverEmail());
		attributes.put("AssignmentID", getAssignmentID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer EmployeeId = (Integer)attributes.get("EmployeeId");

		if (EmployeeId != null) {
			setEmployeeId(EmployeeId);
		}

		String ProjectCode = (String)attributes.get("ProjectCode");

		if (ProjectCode != null) {
			setProjectCode(ProjectCode);
		}

		String ProjectName = (String)attributes.get("ProjectName");

		if (ProjectName != null) {
			setProjectName(ProjectName);
		}

		String ApproverName = (String)attributes.get("ApproverName");

		if (ApproverName != null) {
			setApproverName(ApproverName);
		}

		Integer ApproverID = (Integer)attributes.get("ApproverID");

		if (ApproverID != null) {
			setApproverID(ApproverID);
		}

		String ApproverEmail = (String)attributes.get("ApproverEmail");

		if (ApproverEmail != null) {
			setApproverEmail(ApproverEmail);
		}

		Integer AssignmentID = (Integer)attributes.get("AssignmentID");

		if (AssignmentID != null) {
			setAssignmentID(AssignmentID);
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

		if (!_setOriginalEmployeeId) {
			_setOriginalEmployeeId = true;

			_originalEmployeeId = _EmployeeId;
		}

		_EmployeeId = EmployeeId;
	}

	public int getOriginalEmployeeId() {
		return _originalEmployeeId;
	}

	@JSON
	@Override
	public String getProjectCode() {
		if (_ProjectCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _ProjectCode;
		}
	}

	@Override
	public void setProjectCode(String ProjectCode) {
		_columnBitmask |= PROJECTCODE_COLUMN_BITMASK;

		if (_originalProjectCode == null) {
			_originalProjectCode = _ProjectCode;
		}

		_ProjectCode = ProjectCode;
	}

	public String getOriginalProjectCode() {
		return GetterUtil.getString(_originalProjectCode);
	}

	@JSON
	@Override
	public String getProjectName() {
		if (_ProjectName == null) {
			return StringPool.BLANK;
		}
		else {
			return _ProjectName;
		}
	}

	@Override
	public void setProjectName(String ProjectName) {
		_ProjectName = ProjectName;
	}

	@JSON
	@Override
	public String getApproverName() {
		if (_ApproverName == null) {
			return StringPool.BLANK;
		}
		else {
			return _ApproverName;
		}
	}

	@Override
	public void setApproverName(String ApproverName) {
		_ApproverName = ApproverName;
	}

	@JSON
	@Override
	public int getApproverID() {
		return _ApproverID;
	}

	@Override
	public void setApproverID(int ApproverID) {
		_ApproverID = ApproverID;
	}

	@JSON
	@Override
	public String getApproverEmail() {
		if (_ApproverEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _ApproverEmail;
		}
	}

	@Override
	public void setApproverEmail(String ApproverEmail) {
		_columnBitmask |= APPROVEREMAIL_COLUMN_BITMASK;

		if (_originalApproverEmail == null) {
			_originalApproverEmail = _ApproverEmail;
		}

		_ApproverEmail = ApproverEmail;
	}

	public String getOriginalApproverEmail() {
		return GetterUtil.getString(_originalApproverEmail);
	}

	@JSON
	@Override
	public int getAssignmentID() {
		return _AssignmentID;
	}

	@Override
	public void setAssignmentID(int AssignmentID) {
		_AssignmentID = AssignmentID;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public LMSProjectDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LMSProjectDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LMSProjectDetailsImpl lmsProjectDetailsImpl = new LMSProjectDetailsImpl();

		lmsProjectDetailsImpl.setEmployeeId(getEmployeeId());
		lmsProjectDetailsImpl.setProjectCode(getProjectCode());
		lmsProjectDetailsImpl.setProjectName(getProjectName());
		lmsProjectDetailsImpl.setApproverName(getApproverName());
		lmsProjectDetailsImpl.setApproverID(getApproverID());
		lmsProjectDetailsImpl.setApproverEmail(getApproverEmail());
		lmsProjectDetailsImpl.setAssignmentID(getAssignmentID());

		lmsProjectDetailsImpl.resetOriginalValues();

		return lmsProjectDetailsImpl;
	}

	@Override
	public int compareTo(LMSProjectDetails lmsProjectDetails) {
		int value = 0;

		if (getEmployeeId() < lmsProjectDetails.getEmployeeId()) {
			value = -1;
		}
		else if (getEmployeeId() > lmsProjectDetails.getEmployeeId()) {
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

		if (!(obj instanceof LMSProjectDetails)) {
			return false;
		}

		LMSProjectDetails lmsProjectDetails = (LMSProjectDetails)obj;

		int primaryKey = lmsProjectDetails.getPrimaryKey();

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
		LMSProjectDetailsModelImpl lmsProjectDetailsModelImpl = this;

		lmsProjectDetailsModelImpl._originalEmployeeId = lmsProjectDetailsModelImpl._EmployeeId;

		lmsProjectDetailsModelImpl._setOriginalEmployeeId = false;

		lmsProjectDetailsModelImpl._originalProjectCode = lmsProjectDetailsModelImpl._ProjectCode;

		lmsProjectDetailsModelImpl._originalApproverEmail = lmsProjectDetailsModelImpl._ApproverEmail;

		lmsProjectDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LMSProjectDetails> toCacheModel() {
		LMSProjectDetailsCacheModel lmsProjectDetailsCacheModel = new LMSProjectDetailsCacheModel();

		lmsProjectDetailsCacheModel.EmployeeId = getEmployeeId();

		lmsProjectDetailsCacheModel.ProjectCode = getProjectCode();

		String ProjectCode = lmsProjectDetailsCacheModel.ProjectCode;

		if ((ProjectCode != null) && (ProjectCode.length() == 0)) {
			lmsProjectDetailsCacheModel.ProjectCode = null;
		}

		lmsProjectDetailsCacheModel.ProjectName = getProjectName();

		String ProjectName = lmsProjectDetailsCacheModel.ProjectName;

		if ((ProjectName != null) && (ProjectName.length() == 0)) {
			lmsProjectDetailsCacheModel.ProjectName = null;
		}

		lmsProjectDetailsCacheModel.ApproverName = getApproverName();

		String ApproverName = lmsProjectDetailsCacheModel.ApproverName;

		if ((ApproverName != null) && (ApproverName.length() == 0)) {
			lmsProjectDetailsCacheModel.ApproverName = null;
		}

		lmsProjectDetailsCacheModel.ApproverID = getApproverID();

		lmsProjectDetailsCacheModel.ApproverEmail = getApproverEmail();

		String ApproverEmail = lmsProjectDetailsCacheModel.ApproverEmail;

		if ((ApproverEmail != null) && (ApproverEmail.length() == 0)) {
			lmsProjectDetailsCacheModel.ApproverEmail = null;
		}

		lmsProjectDetailsCacheModel.AssignmentID = getAssignmentID();

		return lmsProjectDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{EmployeeId=");
		sb.append(getEmployeeId());
		sb.append(", ProjectCode=");
		sb.append(getProjectCode());
		sb.append(", ProjectName=");
		sb.append(getProjectName());
		sb.append(", ApproverName=");
		sb.append(getApproverName());
		sb.append(", ApproverID=");
		sb.append(getApproverID());
		sb.append(", ApproverEmail=");
		sb.append(getApproverEmail());
		sb.append(", AssignmentID=");
		sb.append(getAssignmentID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.trianz.lms.model.LMSProjectDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>EmployeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ProjectCode</column-name><column-value><![CDATA[");
		sb.append(getProjectCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ProjectName</column-name><column-value><![CDATA[");
		sb.append(getProjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverName</column-name><column-value><![CDATA[");
		sb.append(getApproverName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverID</column-name><column-value><![CDATA[");
		sb.append(getApproverID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ApproverEmail</column-name><column-value><![CDATA[");
		sb.append(getApproverEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AssignmentID</column-name><column-value><![CDATA[");
		sb.append(getAssignmentID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LMSProjectDetails.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			LMSProjectDetails.class
		};
	private int _EmployeeId;
	private int _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private String _ProjectCode;
	private String _originalProjectCode;
	private String _ProjectName;
	private String _ApproverName;
	private int _ApproverID;
	private String _ApproverEmail;
	private String _originalApproverEmail;
	private int _AssignmentID;
	private long _columnBitmask;
	private LMSProjectDetails _escapedModel;
}