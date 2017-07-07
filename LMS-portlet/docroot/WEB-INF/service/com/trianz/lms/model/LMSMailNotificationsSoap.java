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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.trianz.lms.service.http.LMSMailNotificationsServiceSoap}.
 *
 * @author
 * @see com.trianz.lms.service.http.LMSMailNotificationsServiceSoap
 * @generated
 */
public class LMSMailNotificationsSoap implements Serializable {
	public static LMSMailNotificationsSoap toSoapModel(
		LMSMailNotifications model) {
		LMSMailNotificationsSoap soapModel = new LMSMailNotificationsSoap();

		soapModel.setMailNotfnId(model.getMailNotfnId());
		soapModel.setLeaveRequestId(model.getLeaveRequestId());
		soapModel.setFromAddrs(model.getFromAddrs());
		soapModel.setToAddrs(model.getToAddrs());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static LMSMailNotificationsSoap[] toSoapModels(
		LMSMailNotifications[] models) {
		LMSMailNotificationsSoap[] soapModels = new LMSMailNotificationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSMailNotificationsSoap[][] toSoapModels(
		LMSMailNotifications[][] models) {
		LMSMailNotificationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSMailNotificationsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSMailNotificationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSMailNotificationsSoap[] toSoapModels(
		List<LMSMailNotifications> models) {
		List<LMSMailNotificationsSoap> soapModels = new ArrayList<LMSMailNotificationsSoap>(models.size());

		for (LMSMailNotifications model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSMailNotificationsSoap[soapModels.size()]);
	}

	public LMSMailNotificationsSoap() {
	}

	public int getPrimaryKey() {
		return _MailNotfnId;
	}

	public void setPrimaryKey(int pk) {
		setMailNotfnId(pk);
	}

	public int getMailNotfnId() {
		return _MailNotfnId;
	}

	public void setMailNotfnId(int MailNotfnId) {
		_MailNotfnId = MailNotfnId;
	}

	public String getLeaveRequestId() {
		return _LeaveRequestId;
	}

	public void setLeaveRequestId(String LeaveRequestId) {
		_LeaveRequestId = LeaveRequestId;
	}

	public String getFromAddrs() {
		return _FromAddrs;
	}

	public void setFromAddrs(String FromAddrs) {
		_FromAddrs = FromAddrs;
	}

	public String getToAddrs() {
		return _ToAddrs;
	}

	public void setToAddrs(String ToAddrs) {
		_ToAddrs = ToAddrs;
	}

	public String getComments() {
		return _Comments;
	}

	public void setComments(String Comments) {
		_Comments = Comments;
	}

	private int _MailNotfnId;
	private String _LeaveRequestId;
	private String _FromAddrs;
	private String _ToAddrs;
	private String _Comments;
}