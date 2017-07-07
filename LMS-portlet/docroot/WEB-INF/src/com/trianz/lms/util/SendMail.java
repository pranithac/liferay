package com.trianz.lms.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.StringUtil;

import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;
import com.trianz.lms.NoSuchEmployeeDetailsException;
import com.trianz.lms.controller.ApplyLeaveController;
import com.trianz.lms.model.LMSEmployeeDetails;
import com.trianz.lms.model.LMSLeaveInformation;
import com.trianz.lms.model.LMSMailNotifications;


import com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil;
import com.trianz.lms.service.LMSMailNotificationsLocalServiceUtil;



import java.io.IOException;
import java.io.InputStream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;




public  class SendMail {

	
	public static void sendmail(int status,LMSLeaveInformation leaveRequest) throws AddressException, IOException, PortalException, SystemException{
		
		
		
		 
		/*
		 String approvermail=(String) workflowContext.get("loggedInUserEmail");
		
		System.out.println("approval mail in sendmail"+approvermail);*/
		int leaveRequestId=leaveRequest.getSNo();
		int employeeId=LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(leaveRequestId).getEmployeeId();
	
		
		//LMSEmployeeDetails approverdetails=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getApproverID());
      
		LMSEmployeeDetails supervisordetails=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getSupervisorID());
		//added by pranitha
		//LMSLeaveInformation leaveInfo=LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveRequest.getLeaveRequestId());
		
		
	
		 String mailBody = "content/mail/template/mail-body.tmpl";
			InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
			String body = StringUtil.read(inputStream);
		
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String strtDate = df.format(leaveRequest.getStartDate());
			String endDate=df.format(leaveRequest.getEndDate());
			String currentdate=df.format(date);
		//	List<LMSProjectDetails>projectDetailsList=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(employeeId);
			
			/*if(projectDetailsList!=null)
			{
			for(LMSProjectDetails project:projectDetailsList) 
				{
				String approvermail=project.getApproverEmail();*/
			
				
		if(status==0)//approved or autoapproved
		{
			String approvalSubjectforEmployee="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence has been approved";
			String approvalSubjectforSupervisor="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName())+" has been approved";
			
			/*if((leaveRequest.getProjectCode()).equalsIgnoreCase("TRZ-809")){
				triggerEmailForEmployee(employeeId,approvalSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
				triggerEmailForApprover(employeeId,approvalSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);	
				
			}
			else{}*/
			triggerEmailForEmployee(employeeId,approvalSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
			triggerEmailForSupervisor(employeeId,approvalSubjectforSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

			//triggerEmailForApprover(employeeId,approvalSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);
			/*if(projectDetailsList!=null)
			{
				System.out.println("not leave of absence pjct===sending mails to both approver and supervisor");
			for(LMSProjectDetails project:projectDetailsList) 
				{
				String approvermail=project.getApproverEmail();
			triggerEmailForApprover(employeeId,approvalSubjectforApproverSupervisor,approvermail,leaveInfo,body,strtDate,endDate,currentdate);
			triggerEmailForSupervisor(employeeId,approvalSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

				}
			}else
			{
				System.out.println("leave of absence pjct===sending mails to supervisor");

				triggerEmailForSupervisor(employeeId,approvalSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);
	
			}
			*/
			 
		}else if(status==5){//inactive deleted by hr/employee
			// send individual mails to emp
			//System.out.println("inactive status====cancel comments"+leaveInfo.getComments());
			
			//String deletionSubjectforEmployee="[TEST MAIL: PLS IGNORE]FYI:Leave of Absence has been cancelled";
			//String deletionSubjectforApproverSupervisor="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName())+" has been cancelled";
			/*if((leaveRequest.getProjectCode()).equalsIgnoreCase("TRZ-809")){
			triggerEmailForEmployee(employeeId,deletionSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
			triggerEmailForApprover(employeeId,deletionSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);
			}
			else{}*/
				//triggerEmailForEmployee(employeeId,deletionSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
				//triggerEmailForSupervisor(employeeId,deletionSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

				//triggerEmailForApprover(employeeId,deletionSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);
				/*if(projectDetailsList!=null)
				{
					System.out.println("not leave of absence pjct===sending mails to both approver and supervisor");

				for(LMSProjectDetails project:projectDetailsList) 
					{
					String approvermail=project.getApproverEmail();
				
				triggerEmailForApprover(employeeId,deletionSubjectforApproverSupervisor,approvermail,leaveInfo,body,strtDate,endDate,currentdate);
			triggerEmailForSupervisor(employeeId,deletionSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

			
					}
				}
				else
				{
					System.out.println("leave of absence pjct===sending mails to  supervisor");

					triggerEmailForSupervisor(employeeId,deletionSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);
		
				}*/
			
		LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(leaveRequest.getSNo()).setApprovalStatus("Inactive");
		LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(leaveRequest.getSNo()));
		
		}
		else if(status==4)//rejected by approver
		{
			String rejectionSubjectforEmployee="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence has been rejected";
			String rejectionSubjectforSupervisor="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName())+" has been rejected";
			/*if((leaveRequest.getProjectCode()).equalsIgnoreCase("TRZ-809")){
			triggerEmailForEmployee(employeeId,rejectionSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
			triggerEmailForApprover(employeeId,rejectionSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);
			}
			else{}*/
				triggerEmailForEmployee(employeeId,rejectionSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
				triggerEmailForSupervisor(employeeId,rejectionSubjectforSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

				//triggerEmailForApprover(employeeId,rejectionSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);
				/*if(projectDetailsList.size()>0)
				{
					System.out.println("not leave of absence pjct===sending mails to both approver and supervisor");

				for(LMSProjectDetails project:projectDetailsList) 
					{
					String approvermail=project.getApproverEmail();
				
				triggerEmailForApprover(employeeId,rejectionSubjectforApproverSupervisor,approvermail,leaveInfo,body,strtDate,endDate,currentdate);
			triggerEmailForSupervisor(employeeId,rejectionSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);
					}
				}else
				{
					System.out.println("leave of absence pjct===sending mails to  supervisor");

					triggerEmailForSupervisor(employeeId,rejectionSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

				}*/
		
		}
		
		else if(status==6)//waiting for other approvers approval
		{
			String incompleteSubjectforEmployee="[TEST MAIL: PLS IGNORE]FYI:Leave of Absence is waiting for other Approvers approval";
			String incompleteSubjectforSupervisor="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName())+" is approved.Waiting for other Approver's approval";
			/*if((leaveRequest.getProjectCode()).equalsIgnoreCase("TRZ-809")){
			triggerEmailForEmployee(employeeId,rejectionSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
			triggerEmailForApprover(employeeId,rejectionSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);
			}
			else{}*/
				triggerEmailForEmployee(employeeId,incompleteSubjectforEmployee,leaveRequest,body,strtDate,endDate,currentdate);
				triggerEmailForSupervisor(employeeId,incompleteSubjectforSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

				//triggerEmailForApprover(employeeId,rejectionSubjectforApproverSupervisor,approverdetails,leaveRequest,body,strtDate,endDate,currentdate);
				/*if(projectDetailsList!=null)
				{
					System.out.println("not leave of absence pjct===sending mails to both approver and supervisor");

				for(LMSProjectDetails project:projectDetailsList) 
					{
					String approvermail=project.getApproverEmail();
				
				triggerEmailForApprover(employeeId,rejectionSubjectforApproverSupervisor,approvermail,leaveInfo,body,strtDate,endDate,currentdate);
			triggerEmailForSupervisor(employeeId,rejectionSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);
					}
				}else{
					System.out.println("leave of absence pjct===sending mails to  supervisor");

					triggerEmailForSupervisor(employeeId,rejectionSubjectforApproverSupervisor,supervisordetails,leaveRequest,body,strtDate,endDate,currentdate);

				}*/
		
		}
		
			/*	}
			}*/
	
	}

	

	public static void triggerEmailForEmployee(int employeeId, String subjectforEmployee
			, LMSLeaveInformation leaveRequest, String body, String strtDate, String endDate, String currentdate) throws AddressException, IOException, PortalException, SystemException {
	
		System.out.println("mailto employee: ");

		
		//String projectCode=leaveRequest.getProjectCode();
		
		InternetAddress fromAddress = null;
		fromAddress = new InternetAddress("pranitha.chittoju@trianz.com");
		
		InternetAddress ToAddress = null;
		/*********Hardcoded-PLs Change********************/
		//ToAddress = new InternetAddress(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeEmailID());
		ToAddress =new InternetAddress("pranitha.chittoju@trianz.com");
		 String leaveRequestId=String.valueOf(leaveRequest.getLeaveRequestId());
		
		System.out.println("to address of mail sent to employee: "+ToAddress);

		LMSMailNotifications mailNotifications = LMSMailNotificationsLocalServiceUtil.createLMSMailNotifications(LMSMailNotificationsLocalServiceUtil.getLMSMailNotificationsesCount()+1);
		
		//String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$PCODE$]","[$CURRENTDATE$]","[$COMMENTS$]","[$APPROVEURL$]"};
		//String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$PCODE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]","[$button$]"};
		String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]"};

		//String[] replaceStr = {LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName(),strtDate,endDate,projectCode,currentdate,"",""};
		String leaveRequestedEmployeename=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName();
		if(leaveRequest.getApprovalStatus().equalsIgnoreCase("Inactive"))
		{
			String Comments ="Comments: Your leave has been cancelled";
			
			//String[] replaceStr = {LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName(),strtDate,endDate,projectCode,currentdate,leaveRequestId,Comments,"<input type='submit' value='Submit' name='submit'/>"};
			String[] replaceStr = {leaveRequestedEmployeename,strtDate,endDate,currentdate,leaveRequestId,Comments};

			String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
			
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setSubject(subjectforEmployee);
			mailMessage.setBody(mailbodyAfterReplace);
			mailMessage.setFrom(fromAddress);
			mailMessage.setTo(ToAddress);
			try {
				MailEngine.send(mailMessage);
				System.out.println("Send mail send mail method : Mail Sent Successfully to employee");
				mailNotifications.setLeaveRequestId(leaveRequest.getLeaveRequestId());
				mailNotifications.setFromAddrs(String.valueOf(fromAddress));  
				mailNotifications.setToAddrs(String.valueOf(ToAddress));
				mailNotifications.setComments("Mail sent for Employee");
				LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(mailNotifications);
				System.out.println("MailNotification Details Stored in Database");
			} catch (MailEngineException e) {
				// TODO Auto-generated catch block
				System.out.println("mail not sent");
				e.printStackTrace();
			}
			
			
		}else{
			String Comments = "Comments: "+leaveRequest.getComments();
			//String[] replaceStr = {LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName(),strtDate,endDate,projectCode,currentdate,leaveRequestId,Comments,"<input type='submit' value='Submit' name='submit'/>"};
			String[] replaceStr = {leaveRequestedEmployeename,strtDate,endDate,currentdate,leaveRequestId,Comments};

			String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
			
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setSubject(subjectforEmployee);
			mailMessage.setBody(mailbodyAfterReplace);
			mailMessage.setFrom(fromAddress);
			mailMessage.setTo(ToAddress);
			try {
				MailEngine.send(mailMessage);
				mailNotifications.setLeaveRequestId(leaveRequest.getLeaveRequestId());
				mailNotifications.setFromAddrs(String.valueOf(fromAddress));  
				mailNotifications.setToAddrs(String.valueOf(ToAddress));
				mailNotifications.setComments("Mail sent for Employee");
				LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(mailNotifications);
				System.out.println("MailNotification Details Stored in Database");
				
				System.out.println("Send mail send mail method : Mail Sent Successfully to employee "+leaveRequestedEmployeename);

			} catch (MailEngineException e) {
				// TODO Auto-generated catch block
				System.out.println("mail not sent");
				e.printStackTrace();
			}
			
		}
		
			
		
	}

	public static void triggerEmailForApprover(int employeeId, String subjectforApproverSupervisor,String approvermail,
		
			LMSLeaveInformation leaveRequest, String body, String strtDate, String endDate, String currentdate) throws AddressException, NoSuchEmployeeDetailsException, SystemException {
		// TODO Auto-generated method stub
		System.out.println("in send mail class::triggerEmailForApprover");
		LMSMailNotifications mailNotifications = LMSMailNotificationsLocalServiceUtil.createLMSMailNotifications(LMSMailNotificationsLocalServiceUtil.getLMSMailNotificationsesCount()+1);
		//String projectCode=leaveRequest.getProjectCode();
		InternetAddress fromAddress = null;
		fromAddress = new InternetAddress("pranitha.chittoju@trianz.com");
		//System.out.println("approver EmailID()======="+approverdetails.getEmployeeEmailID());

		//String approverEmailTo= approverdetails.getEmployeeEmailID();
System.out.println("approvermail in triggerapprovermail=="+approvermail);
		InternetAddress ToAddress = null;
		//ToAddress = new InternetAddress(approvermail);
		/*********Hardcoded-PLs Change********************/
		
		ToAddress =new InternetAddress("pranitha.chittoju@trianz.com");
		 String leaveRequestId=String.valueOf(leaveRequest.getLeaveRequestId());
		//ApplyLeaveController applyLeave = new ApplyLeaveController();
		
		System.out.println("to address of mail sent to approver: "+ToAddress);
		//User user = applyLeave.getApproverUser();
			
		//String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$PCODE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]"};
		String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]"};
		//String username =user.getScreenName();
		
		//String password = user.getPasswordUnencrypted();
		//String approveURL="Approve/Reject URL :"+"http://localhost:8080/web/guest/apply-leave?parameterAutoLoginLogin="+username+"&parameterAutoLoginPassword="+password;
	//	String approverName=approverdetails.getEmployeeName();
		LMSEmployeeDetails approverdetails=LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(approvermail);
		String approverName=approverdetails.getEmployeeName();
		if(leaveRequest.getApprovalStatus().equalsIgnoreCase("Inactive"))
		{
			String Comments ="Comments: Your leave has been cancelled";
			//String[] replaceStr = {approverName,strtDate,endDate,projectCode,currentdate,leaveRequestId,Comments};
			String[] replaceStr = {approverName,strtDate,endDate,currentdate,leaveRequestId,Comments};
			String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
			
			//System.out.println("BODY AFTER REPLACING----"+body);
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setSubject(subjectforApproverSupervisor);
			mailMessage.setBody(mailbodyAfterReplace);
			mailMessage.setFrom(fromAddress);
			
			mailMessage.setTo(ToAddress);
			try {
				MailEngine.send(mailMessage);
				System.out.println("Send mail method : Mail Sent Successfully to Approver "+approverName);
				mailNotifications.setLeaveRequestId(leaveRequest.getLeaveRequestId());
				mailNotifications.setFromAddrs(String.valueOf(fromAddress));  
				mailNotifications.setToAddrs(String.valueOf(ToAddress));
				mailNotifications.setComments("Mail sent for Approver");
				LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(mailNotifications);
				System.out.println("MailNotification Details Stored in Database");
			} catch (MailEngineException e) {
				// TODO Auto-generated catch block
				System.out.println("mail not sent");
				e.printStackTrace();
			}
			
		}else{
		String Comments = "Comments: "+leaveRequest.getComments();
		
		
		System.out.println("Leave Info Comments in approver email::"+leaveRequest.getComments());
		//String[] replaceStr = {approverName,strtDate,endDate,projectCode,currentdate,leaveRequestId,Comments};
		String[] replaceStr = {approverName,strtDate,endDate,currentdate,leaveRequestId,Comments};

		String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
		
		//System.out.println("BODY AFTER REPLACING----"+body);
		
		MailMessage mailMessage = new MailMessage();
		mailMessage.setHTMLFormat(true);
		mailMessage.setSubject(subjectforApproverSupervisor);
		mailMessage.setBody(mailbodyAfterReplace);
		mailMessage.setFrom(fromAddress);
		
		mailMessage.setTo(ToAddress);
		try {
			MailEngine.send(mailMessage);
			System.out.println("Send mail method : Mail Sent Successfully to Approver "+approverName);
			mailNotifications.setLeaveRequestId(leaveRequest.getLeaveRequestId());
			mailNotifications.setFromAddrs(String.valueOf(fromAddress));  
			mailNotifications.setToAddrs(String.valueOf(ToAddress));
			mailNotifications.setComments("Mail sent for Approver");
			LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(mailNotifications);
			System.out.println("MailNotification Details Stored in Database");
		} catch (MailEngineException e) {
			// TODO Auto-generated catch block
			System.out.println("mail not sent");
			e.printStackTrace();
		}
		
		

		}
	
	
	
		
	

	}


	
	public static void triggerEmailForSupervisor(int employeeId, String subjectforSupervisor,
			LMSEmployeeDetails supervisordetails,
			LMSLeaveInformation leaveRequest, String body, String strtDate, String endDate, String currentdate) throws AddressException, SystemException {
		// TODO Auto-generated method stub
		System.out.println("in send mail class::triggerEmailForSupervisor");
		LMSMailNotifications mailNotifications = LMSMailNotificationsLocalServiceUtil.createLMSMailNotifications(LMSMailNotificationsLocalServiceUtil.getLMSMailNotificationsesCount()+1);
		//String projectCode=leaveRequest.getProjectCode();
		InternetAddress fromAddress = null;
		fromAddress = new InternetAddress("pranitha.chittoju@trianz.com");
		System.out.println("supervisor EmailID()========="+supervisordetails.getEmployeeEmailID());

		
		//String supervisorEmailTo= supervisordetails.getEmployeeEmailID();

		InternetAddress ToAddress = null;
		//ToAddress = new InternetAddress(supervisorEmailTo);
	/*********Hardcoded-PLs Change********************/
		
		ToAddress =new InternetAddress("pranitha.chittoju@trianz.com");
		 String leaveRequestId=String.valueOf(leaveRequest.getLeaveRequestId());
		
		 System.out.println("to address of mail sent to supervisor: "+ToAddress);
		//String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$PCODE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]"};
		 String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]"};
		 String supervisorName=supervisordetails.getEmployeeName();
		
		if(leaveRequest.getApprovalStatus().equalsIgnoreCase("Inactive"))
		{
			String Comments ="Comments: Your leave has been cancelled";
			//String[] replaceStr = {supervisorName,strtDate,endDate,projectCode,currentdate,leaveRequestId,Comments};
			String[] replaceStr = {supervisorName,strtDate,endDate,currentdate,leaveRequestId,Comments};
			String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
			
			//System.out.println("BODY AFTER REPLACING----"+body);
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setSubject(subjectforSupervisor);
			mailMessage.setBody(mailbodyAfterReplace);
			mailMessage.setFrom(fromAddress);
			
			mailMessage.setTo(ToAddress);
			try {
				MailEngine.send(mailMessage);
				System.out.println("Send mail send mail method : Mail Sent Successfully to Supervisor "+supervisorName);
				mailNotifications.setLeaveRequestId(leaveRequest.getLeaveRequestId());
				mailNotifications.setFromAddrs(String.valueOf(fromAddress));  
				mailNotifications.setToAddrs(String.valueOf(ToAddress));
				mailNotifications.setComments("Mail sent for Supervisor");
				LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(mailNotifications);
				System.out.println("MailNotification Details Stored in Database");
			} catch (MailEngineException e) {
				// TODO Auto-generated catch block
				System.out.println("mail not sent");
				e.printStackTrace();
			}
		}
		else{
		
		
		String Comments = "Comments: "+leaveRequest.getComments();
		System.out.println("Leave Info Comments in supervisor email::"+leaveRequest.getComments());
		//String[] replaceStr = {supervisorName,strtDate,endDate,projectCode,currentdate,leaveRequestId,Comments};
		String[] replaceStr = {supervisorName,strtDate,endDate,currentdate,leaveRequestId,Comments};
		String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
		
		//System.out.println("BODY AFTER REPLACING----"+body);
		
		MailMessage mailMessage = new MailMessage();
		mailMessage.setHTMLFormat(true);
		mailMessage.setSubject(subjectforSupervisor);
		mailMessage.setBody(mailbodyAfterReplace);
		mailMessage.setFrom(fromAddress);
		
		mailMessage.setTo(ToAddress);
		try {
			MailEngine.send(mailMessage);
			System.out.println("Send mail send mail method : Mail Sent Successfully to Supervisor "+supervisorName);
			mailNotifications.setLeaveRequestId(leaveRequest.getLeaveRequestId());
			mailNotifications.setFromAddrs(String.valueOf(fromAddress));  
			mailNotifications.setToAddrs(String.valueOf(ToAddress));
			mailNotifications.setComments("Mail sent for Supervisor");
			LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(mailNotifications);
			System.out.println("MailNotification Details Stored in Database");
		} catch (MailEngineException e) {
			// TODO Auto-generated catch block
			System.out.println("mail not sent");
			e.printStackTrace();
		}
		}
	
	}
	
	public static void delegateMail(LMSLeaveInformation leaveInfo,String delegateEmailTo,String delegateEmailToUserName ) throws AddressException, IOException, PortalException, SystemException{
	       System.out.println("in delegate mail");
	       int employeeId=leaveInfo.getEmployeeId();
	      /* LMSEmployeeDetails approverdetails=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getApproverID());
	       String delegateFromEmail= approverdetails.getEmployeeEmailID();
	       System.out.println("delegateFromEmail==="+delegateFromEmail);*/
	       String leaveRequestId=String.valueOf(leaveInfo.getLeaveRequestId());

	       Date date = new Date();
	       DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	       String strtDate = df.format(leaveInfo.getStartDate());
	       String endDate=df.format(leaveInfo.getEndDate());
	       String currentdate=df.format(date);
	       
	       LMSMailNotifications mailNotifications = LMSMailNotificationsLocalServiceUtil.createLMSMailNotifications(LMSMailNotificationsLocalServiceUtil.getLMSMailNotificationsesCount()+1);
	       String mailBody = "content/mail/template/mail-body.tmpl";
	       InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
	       String body = StringUtil.read(inputStream);
	       String delegateSubject="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName())+" is delegated to you.";

	       
	       
	       InternetAddress fromAddress = null;
	       fromAddress = new InternetAddress("pranitha.chittoju@trianz.com");
	       InternetAddress ToAddress = null;
	       //ToAddress = new InternetAddress(delegateEmailTo);
	   	/*********Hardcoded-PLs Change********************/
			
			ToAddress =new InternetAddress("pranitha.chittoju@trianz.com");
			System.out.println("to address of mail sent to delegated user: "+ToAddress);
	       String comments = "Comments: "+leaveInfo.getComments();
	       //String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$PCODE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]"};
	       String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$CURRENTDATE$]","[$LEAVEREQUESTID$]","[$COMMENTS$]"};
	      // String[] replaceStr = {delegateEmailToUserName,strtDate,endDate,leaveInfo.getProjectCode(),currentdate,leaveRequestId,comments};
	       String[] replaceStr = {delegateEmailToUserName,strtDate,endDate,currentdate,leaveRequestId,comments};

	       String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
	       
	       MailMessage mailMessage = new MailMessage();
	       mailMessage.setHTMLFormat(true);
	       mailMessage.setSubject(delegateSubject);
	       mailMessage.setBody(mailbodyAfterReplace);
	       mailMessage.setFrom(fromAddress);
	       
	       mailMessage.setTo(ToAddress);
	    try {
	              MailEngine.send(mailMessage);
	              System.out.println("delegate send mail method : Mail Sent Successfully to Delegated User");
	              mailNotifications.setLeaveRequestId(leaveRequestId);
					mailNotifications.setFromAddrs(String.valueOf(fromAddress));  
					mailNotifications.setToAddrs(String.valueOf(ToAddress));
					mailNotifications.setComments("Mail sent for Delegate");
					LMSMailNotificationsLocalServiceUtil.addLMSMailNotifications(mailNotifications);
					System.out.println("MailNotification Details Stored in Database");
	       } catch (MailEngineException e) {
	              // TODO Auto-generated catch block
	              System.out.println("mail not sent");
	              e.printStackTrace();
	       }

	       }
	       

	
public static void sendmailEL(int employeeId) throws AddressException, IOException, PortalException, SystemException{
		System.out.println("in Send Mail Method Called");
		System.out.println("loggedin employee email address"+LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeEmailID());
		 String mailBody = "content/mail/template/EL-Mail-Body.tmpl";
		InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
		String body = StringUtil.read(inputStream);
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String currentdate=df.format(date);
		String mailSubject = "[TEST MAIL: PLS IGNORE]Earned Leave Limit Exceeded 45";
		triggerEmailForEmployeeEL(employeeId,mailSubject,body,currentdate);
	}
private static void triggerEmailForEmployeeEL(int employeeId, String mailSubject,  String body, String currentdate) throws AddressException, IOException, PortalException, SystemException {
	System.out.println("in send mail class::triggerEmailForEmployee");
	InternetAddress fromAddress = null;
	fromAddress = new InternetAddress("trinetdev@trianz.com");
	InternetAddress ToAddress = null;
	//ToAddress = new InternetAddress(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeEmailID());
	/*********Hardcoded-PLs Change********************/
	
	ToAddress =new InternetAddress("pooja.dussa@trianz.com");
	System.out.println("to address of mail sent to employee for EL notification"+ToAddress);
	//String[] findStrs = {"[$FULLNAME$]","[$SDATE$]","[$EDATE$]","[$PCODE$]","[$CURRENTDATE$]","[$COMMENTS$]","[$APPROVEURL$]"};
	String[] findStrs = {"[$FULLNAME$]","[$CURRENTDATE$]"};
	//String[] replaceStr = {LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName(),strtDate,endDate,projectCode,currentdate,"",""};
	String[] replaceStr = {LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId).getEmployeeName(),currentdate};
	String mailbodyAfterReplace = StringUtil.replace(body,findStrs,replaceStr);
	MailMessage mailMessage = new MailMessage();
	mailMessage.setHTMLFormat(true);
	mailMessage.setSubject(mailSubject);
	mailMessage.setBody(mailbodyAfterReplace);
	mailMessage.setFrom(fromAddress);
	mailMessage.setTo(ToAddress);
	try {
		MailEngine.send(mailMessage);
		System.out.println("Send mail send mail method : Mail Sent Successfully to Employee regarding EL's");
	} catch (MailEngineException e) {
		// TODO Auto-generated catch block
		System.out.println("mail not sent");
		e.printStackTrace();
	}
}

}
