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

import com.trianz.lms.model.LMSLeaveInformation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LMSLeaveInformation in entity cache.
 *
 * @author
 * @see LMSLeaveInformation
 * @generated
 */
public class LMSLeaveInformationCacheModel implements CacheModel<LMSLeaveInformation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{SNo=");
		sb.append(SNo);
		sb.append(", LeaveRequestId=");
		sb.append(LeaveRequestId);
		sb.append(", EmployeeId=");
		sb.append(EmployeeId);
		sb.append(", AbsenceType=");
		sb.append(AbsenceType);
		sb.append(", LeaveTypeCode=");
		sb.append(LeaveTypeCode);
		sb.append(", LeaveCategoryCode=");
		sb.append(LeaveCategoryCode);
		sb.append(", SupervisorID=");
		sb.append(SupervisorID);
		sb.append(", StartDate=");
		sb.append(StartDate);
		sb.append(", EndDate=");
		sb.append(EndDate);
		sb.append(", Duration=");
		sb.append(Duration);
		sb.append(", ApprovalStatus=");
		sb.append(ApprovalStatus);
		sb.append(", Comments=");
		sb.append(Comments);
		sb.append(", isDraft=");
		sb.append(isDraft);
		sb.append(", Approvers=");
		sb.append(Approvers);
		sb.append(", CreatedDate=");
		sb.append(CreatedDate);
		sb.append(", ApproverEmails=");
		sb.append(ApproverEmails);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LMSLeaveInformation toEntityModel() {
		LMSLeaveInformationImpl lmsLeaveInformationImpl = new LMSLeaveInformationImpl();

		lmsLeaveInformationImpl.setSNo(SNo);

		if (LeaveRequestId == null) {
			lmsLeaveInformationImpl.setLeaveRequestId(StringPool.BLANK);
		}
		else {
			lmsLeaveInformationImpl.setLeaveRequestId(LeaveRequestId);
		}

		lmsLeaveInformationImpl.setEmployeeId(EmployeeId);

		if (AbsenceType == null) {
			lmsLeaveInformationImpl.setAbsenceType(StringPool.BLANK);
		}
		else {
			lmsLeaveInformationImpl.setAbsenceType(AbsenceType);
		}

		lmsLeaveInformationImpl.setLeaveTypeCode(LeaveTypeCode);

		if (LeaveCategoryCode == null) {
			lmsLeaveInformationImpl.setLeaveCategoryCode(StringPool.BLANK);
		}
		else {
			lmsLeaveInformationImpl.setLeaveCategoryCode(LeaveCategoryCode);
		}

		lmsLeaveInformationImpl.setSupervisorID(SupervisorID);

		if (StartDate == Long.MIN_VALUE) {
			lmsLeaveInformationImpl.setStartDate(null);
		}
		else {
			lmsLeaveInformationImpl.setStartDate(new Date(StartDate));
		}

		if (EndDate == Long.MIN_VALUE) {
			lmsLeaveInformationImpl.setEndDate(null);
		}
		else {
			lmsLeaveInformationImpl.setEndDate(new Date(EndDate));
		}

		lmsLeaveInformationImpl.setDuration(Duration);

		if (ApprovalStatus == null) {
			lmsLeaveInformationImpl.setApprovalStatus(StringPool.BLANK);
		}
		else {
			lmsLeaveInformationImpl.setApprovalStatus(ApprovalStatus);
		}

		if (Comments == null) {
			lmsLeaveInformationImpl.setComments(StringPool.BLANK);
		}
		else {
			lmsLeaveInformationImpl.setComments(Comments);
		}

		if (isDraft == null) {
			lmsLeaveInformationImpl.setIsDraft(StringPool.BLANK);
		}
		else {
			lmsLeaveInformationImpl.setIsDraft(isDraft);
		}

		lmsLeaveInformationImpl.setApprovers(Approvers);

		if (CreatedDate == Long.MIN_VALUE) {
			lmsLeaveInformationImpl.setCreatedDate(null);
		}
		else {
			lmsLeaveInformationImpl.setCreatedDate(new Date(CreatedDate));
		}

		if (ApproverEmails == null) {
			lmsLeaveInformationImpl.setApproverEmails(StringPool.BLANK);
		}
		else {
			lmsLeaveInformationImpl.setApproverEmails(ApproverEmails);
		}

		lmsLeaveInformationImpl.resetOriginalValues();

		return lmsLeaveInformationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		SNo = objectInput.readInt();
		LeaveRequestId = objectInput.readUTF();
		EmployeeId = objectInput.readInt();
		AbsenceType = objectInput.readUTF();
		LeaveTypeCode = objectInput.readInt();
		LeaveCategoryCode = objectInput.readUTF();
		SupervisorID = objectInput.readInt();
		StartDate = objectInput.readLong();
		EndDate = objectInput.readLong();
		Duration = objectInput.readDouble();
		ApprovalStatus = objectInput.readUTF();
		Comments = objectInput.readUTF();
		isDraft = objectInput.readUTF();
		Approvers = objectInput.readInt();
		CreatedDate = objectInput.readLong();
		ApproverEmails = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(SNo);

		if (LeaveRequestId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveRequestId);
		}

		objectOutput.writeInt(EmployeeId);

		if (AbsenceType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(AbsenceType);
		}

		objectOutput.writeInt(LeaveTypeCode);

		if (LeaveCategoryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LeaveCategoryCode);
		}

		objectOutput.writeInt(SupervisorID);
		objectOutput.writeLong(StartDate);
		objectOutput.writeLong(EndDate);
		objectOutput.writeDouble(Duration);

		if (ApprovalStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ApprovalStatus);
		}

		if (Comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Comments);
		}

		if (isDraft == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isDraft);
		}

		objectOutput.writeInt(Approvers);
		objectOutput.writeLong(CreatedDate);

		if (ApproverEmails == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ApproverEmails);
		}
	}

	public int SNo;
	public String LeaveRequestId;
	public int EmployeeId;
	public String AbsenceType;
	public int LeaveTypeCode;
	public String LeaveCategoryCode;
	public int SupervisorID;
	public long StartDate;
	public long EndDate;
	public double Duration;
	public String ApprovalStatus;
	public String Comments;
	public String isDraft;
	public int Approvers;
	public long CreatedDate;
	public String ApproverEmails;
}