package com.trianz.lms.util;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.trianz.lms.controller.ApplyLeaveController;
import com.trianz.lms.model.LMSEmployeeDetails;
import com.trianz.lms.model.LMSLeaveInformation;
import com.trianz.lms.model.LMSProjectDetails;
import com.trianz.lms.model.LeaveBalance;
import com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil;
import com.trianz.lms.service.LMSProjectDetailsLocalServiceUtil;
import com.trianz.lms.service.LeaveBalanceLocalServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.AddressException;


public class LeaveWorkFlowHandler extends BaseWorkflowHandler{

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return LMSLeaveInformation.class.getName();
	}

	@Override
	public String getType(Locale arg0) {
		// TODO Auto-generated method stub
		return "Leave";
	}

	@Override
	public Object updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException, SystemException {

//long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
//long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));//getterutil is used to get the default values
int sno=(Integer) workflowContext.get("sno");
String LeaveReqId=(String)workflowContext.get("leaveRequestId");
String leaveApproverEmail = (String)workflowContext.get("approverEmail");
int index = (Integer) workflowContext.get("index");

String loggedInUserEmail=(String) workflowContext.get("loggedInUserEmail");
//String eachworkflowInstanceId=(String) workflowContext.get("eachworkflowInstanceId");
//System.out.println("eachworkflowInstanceId"+eachworkflowInstanceId);

//LMSLeaveInformation leaveInfo= LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation((int)(sno));
LMSLeaveInformation leaveInfo= LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(LeaveReqId);
String pendingsubjectforApprover=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getEmployeeId()).getEmployeeName()+" has applied for leave";
String rejectionSubjectforApprover="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getEmployeeId()).getEmployeeName())+" has been rejected";
String incompleteSubjectforApprover="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getEmployeeId()).getEmployeeName())+" is approved by you.Waiting for other Approver's approval";
//String inactiveSubjectforApproverSupervisor="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getEmployeeId()).getEmployeeName())+" has been cancelled";
String approvalSubjectforApprover="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getEmployeeId()).getEmployeeName())+" has been approved";


int leaveRequestedEmployeeId=leaveInfo.getEmployeeId();
List<LMSProjectDetails>projectListofLeaveRequestedEmployeeId=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(leaveRequestedEmployeeId);
ApplyLeaveController ac=new ApplyLeaveController();
String approveremails=leaveInfo.getApproverEmails();
List<String>uniqueapprovermailsList=ac.uniqueApproversList(projectListofLeaveRequestedEmployeeId);

List<String> updatedapproverlist=new ArrayList<String>();
/*for(int i=0;i<projectListofLeaveRequestedEmployeeId.size();i++)
{
	String approver=approveremails;
	updatedapproverlist.addAll(Arrays.asList(approver.split(",")));
	//System.out.println("each approver==="+updatedapproverlist.get(i));
}
*/
for(int i=0;i<uniqueapprovermailsList.size();i++)
{
	String approver=approveremails;
	updatedapproverlist.addAll(Arrays.asList(approver.split(",")));
	
}








String ApproverEmail=updatedapproverlist.get(index-1).toString();
String Approver=ApproverEmail.replaceAll("'", "");
System.out.println("Approver in handler==="+Approver);


String mailBody = "content/mail/template/mail-body.tmpl";
InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
String body;


Date date = new Date();
DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
String strtDate = df.format(leaveInfo.getStartDate());
String endDate=df.format(leaveInfo.getEndDate());
String currentdate=df.format(date);
if(status==0){
	System.out.println("in handler==workflow status approved===");
	leaveInfo.setApprovalStatus("Approved");	
	System.out.println("in handler==approved set to leaveInfo===");

}
else if(status==1){
	leaveInfo.setApprovalStatus("Pending");	
	
}
else if(status==4){
	
	leaveInfo.setApprovalStatus("Rejected");	
}
else if(status==5){//for deleted leaves
	
	leaveInfo.setApprovalStatus("Inactive");	
	
}
else if(status==6){//waiting for other approver
	
	leaveInfo.setApprovalStatus("Incomplete");	
	
}
else{
	
	leaveInfo.setApprovalStatus("Pending");
}
LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveInfo);
System.out.println("status in handler===="+leaveInfo.getApprovalStatus());

int count=0;


String sleaveRequestId=String.valueOf(leaveInfo.getLeaveRequestId());
//String sSnofromwfcontext=String.valueOf(sno);
if(projectListofLeaveRequestedEmployeeId.size()>0){
 System.out.println("projectListofLeaveRequestedEmployeeId====="+projectListofLeaveRequestedEmployeeId.size());
 
if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Pending"))
{ 	 
	count=uniqueapprovermailsList.size();
	 System.out.println("uniqueapprovermailsList in handler====="+uniqueapprovermailsList.size());

	 //count=projectListofLeaveRequestedEmployeeId.size();
	 leaveInfo.setApprovers(count);
	 LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveInfo);

	 System.out.println("count ==pending"+count);
	
	
}

if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Incomplete"))
{
	count=leaveInfo.getApprovers();
	 System.out.println("count ==incomplete"+count);

}


if(status==6){//incomplete status


System.out.println("logged in User Email from wfcontext"+loggedInUserEmail);

if(loggedInUserEmail.equalsIgnoreCase(Approver)&&sleaveRequestId.equalsIgnoreCase(LeaveReqId)&&leaveInfo.getApprovalStatus().equalsIgnoreCase("Incomplete"))
{
	 
    count--;
    
   
	 leaveInfo.setApprovers(count);
	 LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveInfo);
	 System.out.println("approvers count after decrementing==="+leaveInfo.getApprovers());
		
}


if(leaveInfo.getApprovers()==0)
{
	System.out.println("all approvers approved==========");
		System.out.println("make it approved");
		WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.STATUS_APPROVED, workflowContext);
		leaveInfo.setApprovalStatus("Approved");
		 LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveInfo);

		 
		 /****** updating leavebalances after all approvers approve start *******/
		 LeaveBalance lbalance = LeaveBalanceLocalServiceUtil.getLeaveBalance(leaveInfo.getEmployeeId());
			double elBal = lbalance.getELBalance();
			double clBal = lbalance.getCLBalance();
			double compBal = lbalance.getCompOffLeaveBalance();
			System.out.println(" initial EL bal : " + elBal + " ,CL : " + clBal + ",CompOff " + compBal);
			double duration = leaveInfo.getDuration();
			String leaveType = leaveInfo.getAbsenceType();
			leaveType = leaveType.replace("\n", "").replace("\r", "");
			System.out.println("duration of leave : " + duration + " and leave type : " + leaveType);
			if(("Contingency Leave").equalsIgnoreCase(leaveType.trim())){
				System.out.println(" deducting CL leaves ");
				clBal-=duration;
			}else if(("Earned Leave").equalsIgnoreCase(leaveType.trim())){
				System.out.println(" deducting EL leaves ");
				elBal-=duration;				
			}else if(("Compensatory Off").equalsIgnoreCase(leaveType.trim())){
				System.out.println(" deducting compoff leaves ");
				compBal-=duration;
			}else{
					System.out.println("neither EL nor CL");					
				}
			System.out.println(" final  EL : "+elBal +"  CL  " + clBal + " CompBal  "+ compBal ) ;
			lbalance.setELBalance(elBal);
			lbalance.setCLBalance(clBal);
			lbalance.setCompOffLeaveBalance(compBal);
			LeaveBalanceLocalServiceUtil.updateLeaveBalance(lbalance);
			 /****** updating leavebalances after all approvers approve end *******/

		 
		System.out.println("updated status to approved");
}	


	}
}
else{//leave of absence project
	if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Pending"))
	{
		count=1;
		leaveInfo.setApprovers(count);
		 LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveInfo);

		 System.out.println("count ==pending"+count);
		}
	if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Incomplete"))
	{
		count=leaveInfo.getApprovers();
		 System.out.println("count ==incomplete"+count);

	}

	if(status==6){//incomplete status
		
		System.out.println("logged in User Email from wfcontext"+loggedInUserEmail);
		LMSEmployeeDetails supervisordetails=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getSupervisorID());
		String supervisoremail=supervisordetails.getSupervisorName();

		 if(loggedInUserEmail.equalsIgnoreCase(supervisoremail)&&sleaveRequestId.equalsIgnoreCase(LeaveReqId)&&leaveInfo.getApprovalStatus().equalsIgnoreCase("Incomplete"))
		 {
			 
		     count--;
		     
		    
			 leaveInfo.setApprovers(count);
			 LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveInfo);
			 System.out.println("approvers count after decrementing==="+leaveInfo.getApprovers());
				
		}
		
		if(leaveInfo.getApprovers()==0)
		{
			System.out.println("all approvers approved==========");
				System.out.println("make it approved");
				WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.STATUS_APPROVED, workflowContext);
				leaveInfo.setApprovalStatus("Approved");
				 LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveInfo);

				System.out.println("updated status to approved");
		}	


			}
	
	
}







		try {
			body = StringUtil.read(inputStream);
			if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Pending"))
			{
				System.out.println("IN PENDING");
				if(projectListofLeaveRequestedEmployeeId.size()>0){	
			SendMail.triggerEmailForApprover(leaveInfo.getEmployeeId(),pendingsubjectforApprover,leaveApproverEmail,leaveInfo,body,strtDate,endDate,currentdate);	
				}
				}
			else if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Rejected"))
			{
				System.out.println("IN REJECTED");
			if(projectListofLeaveRequestedEmployeeId.size()>0){	 
			SendMail.triggerEmailForApprover(leaveInfo.getEmployeeId(),rejectionSubjectforApprover,Approver,leaveInfo,body,strtDate,endDate,currentdate);	

			
			ac.sendmailforactionstatus(leaveInfo);
			}else{
				ac.sendmailforactionstatus(leaveInfo);

			}
			}
			else if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Incomplete"))
			{				System.out.println("IN INCOMPLETE");

				
				if(projectListofLeaveRequestedEmployeeId.size()>0){		 
			SendMail.triggerEmailForApprover(leaveInfo.getEmployeeId(),incompleteSubjectforApprover,Approver,leaveInfo,body,strtDate,endDate,currentdate);	

			ac.sendmailforactionstatus(leaveInfo);
				}else
				{
					ac.sendmailforactionstatus(leaveInfo);

				}
			}
			
			if(status==0&&leaveInfo.getApprovalStatus().equalsIgnoreCase("Approved"))
			{
				
				System.out.println("IN APPROVED");

				if(projectListofLeaveRequestedEmployeeId.size()>0){		 
 
			SendMail.triggerEmailForApprover(leaveInfo.getEmployeeId(),approvalSubjectforApprover,Approver,leaveInfo,body,strtDate,endDate,currentdate);	

			ac.sendmailforactionstatus(leaveInfo);
				}
				else
				{
					ac.sendmailforactionstatus(leaveInfo);

				}
			}
			
			
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	


if (status == WorkflowConstants.STATUS_APPROVED) {
//AssetEntryLocalServiceUtil.updateVisible(LeaveInformation.class.getName(),
//resourcePrimKey, true);
AssetEntryLocalServiceUtil.updateVisible(LMSLeaveInformation.class.getName(),sno, true);
} else {
	//AssetEntryLocalServiceUtil.updateVisible(LeaveInformation.class.getName(),
	//resourcePrimKey, false);
AssetEntryLocalServiceUtil.updateVisible(LMSLeaveInformation.class.getName(),
sno, false);
}
return leaveInfo;
	}
	
	
	

}
