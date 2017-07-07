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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.trianz.lms.model.LMSMailNotifications;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LMSMailNotifications in entity cache.
 *
 * @author
 * @see LMSMailNotifications
 * @generated
 */
public class LMSMailNotificationsCacheModel implements CacheModel<LMSMailNotifications>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{MailNotfnId=");
		sb.append(MailNotfnId);
		sb.append(", LeaveRequestId=");
		sb.append(LeaveRequestId);
		sb.append(", FromAddrs=");
		sb.append(FromAddrs);
		sb.append(", ToAddrs=");
		sb.append(ToAddrs);
		sb.append(", Comments=");
		sb.append(Comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSMailNotifications toEntityModel() {
		LMSMailNotificationsImpl lmsMailNotificationsImpl = new LMSMailNotificationsImpl();

		lmsMailNotificationsImpl.setMailNotfnId(MailNotfnId);

		if (LeaveRequestId == null) {
			lmsMailNotificationsImpl.setLeaveRequestId(StringPool.BLANK);
		}
		else {
			lmsMailNotificationsImpl.setLeaveRequestId(LeaveRequestId);
		}

		if (FromAddrs == null) {
			lmsMailNotificationsImpl.setFromAddrs(StringPool.BLANK);
		}
		else {
			lmsMailNotificationsImpl.setFromAddrs(FromAddrs);
		}

		if (ToAddrs == null) {
			lmsMailNotificationsImpl.setToAddrs(StringPool.BLANK);
		}
		else {
			lmsMailNotificationsImpl.setToAddrs(ToAddrs);
		}

		if (Comments == null) {
			lmsMailNotificationsImpl.setComments(StringPool.BLANK);
		}
		else {
			lmsMailNotificationsImpl.setComments(Comments);
		}

		lmsMailNotificationsImpl.resetOriginalValues();

		return lmsMailNotificationsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		MailNotfnId = objectInput.readInt();
		LeaveRequestId = objectInput.readUTF();
		FromAddrs = objectInput.readUTF();
		ToAddrs = objectInput.readUTF();
		Comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(MailNotfnId);

		if (LeaveRequestId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveRequestId);
		}

		if (FromAddrs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FromAddrs);
		}

		if (ToAddrs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ToAddrs);
		}

		if (Comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Comments);
		}
	}

	public int MailNotfnId;
	public String LeaveRequestId;
	public String FromAddrs;
	public String ToAddrs;
	public String Comments;
}