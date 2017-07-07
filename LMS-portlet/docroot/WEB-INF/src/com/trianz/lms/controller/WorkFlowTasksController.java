package com.trianz.lms.controller;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.portal.kernel.util.WebKeys;

import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.User;

import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portal.theme.ThemeDisplay;

import com.liferay.util.bridges.mvc.MVCPortlet;

import com.trianz.lms.model.LMSEmployeeDetails;
import com.trianz.lms.model.LMSLeaveInformation;
import com.trianz.lms.model.LMSProjectDetails;
import com.trianz.lms.model.LeaveApprovalHistory;
import com.trianz.lms.model.LeaveBalance;

import com.trianz.lms.model.LeaveInformationAudit;
import com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil;
import com.trianz.lms.service.LMSProjectDetailsLocalServiceUtil;
import com.trianz.lms.service.LeaveApprovalHistoryLocalServiceUtil;
import com.trianz.lms.service.LeaveBalanceLocalServiceUtil;
import com.trianz.lms.service.LeaveInformationAuditLocalServiceUtil;

import com.trianz.lms.util.SendMail;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


public class WorkFlowTasksController extends MVCPortlet {
	
	private static final Logger logger = Logger.getLogger(WorkFlowTasksController.class.getName());
	
public static void getUsers(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException, SystemException {
    
    PrintWriter ListValue = resourceResponse.getWriter();

    List<LMSProjectDetails> projectsList=LMSProjectDetailsLocalServiceUtil.getLMSProjectDetailses(0,LMSProjectDetailsLocalServiceUtil.getLMSProjectDetailsesCount());
    List<LMSEmployeeDetails> employeeList = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetailses(0, LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetailsesCount());
    List<String> userList = new ArrayList<String>();
    
    int projSize = projectsList.size();
    int empSize = employeeList.size();
    for(int i=0;i<projSize;i++){
           
           userList.add(projectsList.get(i).getApproverEmail());
         
    }
    
    for(int j=0;j<empSize;j++){
           
           userList.add(employeeList.get(j).getSupervisorEmail());
          
    }
    
    
    Set<String> uniqueUsers=new HashSet<String>();
    uniqueUsers.addAll(userList);
    userList.clear();
    userList.addAll(uniqueUsers);
    
    
    
    int size = userList.size();
    String userNames = "<option value=\"select\">--Select--</option>";
  
    for(int i=0;i<size;i++){
           
           userNames = userNames +"<option value=\""+userList.get(i)+"\">"+ userList.get(i)+"</option> ";
                  
    }
    ListValue.println(userNames.toString());
    
    ListValue.flush();
    ListValue.close();
   
}
	
public static void rejectLeave(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		
	System.out.println("Rejecting Leave==");
	


	int taskID = Integer.parseInt(request.getParameter("taskId"));
	String rejectComments = request.getParameter("rejectComments");
	//String leaveReqId = request.getParameter("LeaveReqNo");
	//System.out.println("LeaveReqNo: "+leaveReqId);
	//LMSLeaveInformation linfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqId);
	int Sno = Integer.parseInt(request.getParameter("Sno"));
	System.out.println("Sno: "+Sno);
	LMSLeaveInformation linfo=LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(Sno);
	linfo.setComments(rejectComments);
	LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(linfo);
	WorkflowTask workFlowTask=WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskID);
	WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), workFlowTask.getWorkflowInstanceId());
	Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
	String loggedInUserEmail=themeDisplay.getUser().getEmailAddress();
	workflowContext.put("loggedInUserEmail", loggedInUserEmail);
	WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), taskID,"Rejected", "rejecting", workflowContext);
	
	LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
	
	log.setLeaveRequestId(linfo.getSNo());
	log.setAction("Rejected Leave Request");
	log.setActionBy(themeDisplay.getUser().getFullName());
	log.setCreatedDate(new Date());
	LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
	LeaveApprovalHistory leaveappHistory=LeaveApprovalHistoryLocalServiceUtil.createLeaveApprovalHistory(LeaveApprovalHistoryLocalServiceUtil.getLeaveApprovalHistoriesCount()+1);
	
	int approverEmployeeId=LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(loggedInUserEmail).getEmployeeId();
	leaveappHistory.setApproverID(approverEmployeeId);
	leaveappHistory.setLeaveRequestId(linfo.getLeaveRequestId());
	leaveappHistory.setLeaveStatus("Rejected");
	LeaveApprovalHistoryLocalServiceUtil.addLeaveApprovalHistory(leaveappHistory);
	System.out.println("rejected data added in LeaveApprovalHistory table===");
	System.out.println("get project code in wfcontroller from jsp=="+request.getParameter("projectCode"));
	if( request.getParameter("projectCode")!=null){
	response.setRenderParameter("projCode", request.getParameter("projectCode"));
	}
	response.setRenderParameter("jspPage","/jsp/AllProjectRequests.jsp");

}
	public static void approveLeave(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		System.out.println("Approving Leave");
		long taskID = Integer.parseInt(request.getParameter("taskId"));//workflowtaskid
		
		String leaveRequestId = request.getParameter("leaveRequestId");

		String approveComments = request.getParameter("approveComments");
		int Sno = Integer.parseInt(request.getParameter("Sno"));
		System.out.println("SNO IN WFCONTROLLER====="+request.getParameter("Sno"));
		//Long LeaveRequestId = (long) leaveReqId;
		String loggedInUserEmail=themeDisplay.getUser().getEmailAddress();
		System.out.println("Sno:"+Sno);
		LMSLeaveInformation linfo = LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(Sno);
		linfo.setComments(approveComments);
		LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(linfo);
		WorkflowTask workFlowTask=WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskID);
		System.out.println("Work Flow Task Id: "+taskID);
		System.out.println("Work Flow Task completion status: "+workFlowTask.isCompleted());
		System.out.println("workflowinstance id from WorkflowTaskManagerUtil "+workFlowTask.getWorkflowInstanceId());

		
		 
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), workFlowTask.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		workflowContext.put("loggedInUserEmail", loggedInUserEmail);
		
		String s=(String) workflowContext.get("loggedInUserEmail");
		System.out.println("loggedin user from wf context====="+s);
		WorkflowTask task=WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), taskID, "Incomplete", "pending for approver", workflowContext);

		System.out.println("completed task to incomplete for "+themeDisplay.getUser().getFullName()+"with task id"+taskID);

		
				/*
				if(task.isCompleted()){
					LeaveBalance lbalance = LeaveBalanceLocalServiceUtil.getLeaveBalance(linfo.getEmployeeId());
					double elBal = lbalance.getELBalance();
					double clBal = lbalance.getCLBalance();
					double compBal = lbalance.getCompOffLeaveBalance();
					System.out.println(" initial EL bal : " + elBal + " ,CL : " + clBal + ",CompOff " + compBal);
					double duration = linfo.getDuration();
					String leaveType = linfo.getAbsenceType();
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
				}
				*/

				LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
				
				log.setLeaveRequestId(linfo.getSNo());
				log.setAction("Approved Leave Request");
				log.setActionBy(themeDisplay.getUser().getFullName());
				log.setCreatedDate(new Date());
				LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
				
				LeaveApprovalHistory leaveappHistory=LeaveApprovalHistoryLocalServiceUtil.createLeaveApprovalHistory(LeaveApprovalHistoryLocalServiceUtil.getLeaveApprovalHistoriesCount()+1);
				
				int approverEmployeeId=LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(loggedInUserEmail).getEmployeeId();
				leaveappHistory.setApproverID(approverEmployeeId);
				leaveappHistory.setLeaveRequestId(leaveRequestId);
				leaveappHistory.setLeaveStatus("Approved");
				LeaveApprovalHistoryLocalServiceUtil.addLeaveApprovalHistory(leaveappHistory);
				System.out.println("approved data added in LeaveApprovalHistory table===");
				if( request.getParameter("projectCode")!=null){
					response.setRenderParameter("projCode", request.getParameter("projectCode"));
					}
					response.setRenderParameter("jspPage","/jsp/AllProjectRequests.jsp");

	}
	
	

public static void delegateLeave(ActionRequest request,ActionResponse response) throws SystemException, PortalException, AddressException, IOException{
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	System.out.println("Delegating to others");
	String loggedInUserEmail=themeDisplay.getUser().getEmailAddress();

	long taskID= Long.parseLong(request.getParameter("taskId"));
	String delegateComments = request.getParameter("delegateComments");
	
	int Sno = Integer.parseInt(request.getParameter("Sno"));
	System.out.println("Sno: "+Sno);
	LMSLeaveInformation linfo=LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(Sno);
	linfo.setComments(delegateComments);
	LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(linfo);
	String delegateUserEmail=request.getParameter("emailId");
	System.out.println("delegateUserEmail"+delegateUserEmail);

	String approvermails=linfo.getApproverEmails();
	
	
	List<String> approverlist = new ArrayList<String>(Arrays.asList(approvermails.split(" , ")));
	
	for(String approver:approverlist)
	{
		System.out.println("approver"+approver);
		//String approvers=(approver.replaceAll("'", "")).replaceAll(",", "");
		//System.out.println("approvers"+approvers);
		
		
		 //Matcher match = Pattern.compile(loggedInUserEmail).matcher(approvers);
		 Matcher match =Pattern.compile(Pattern.quote(loggedInUserEmail), Pattern.CASE_INSENSITIVE).matcher(approver);

		// Matcher match =Pattern.compile(Pattern.quote(loggedInUserEmail), Pattern.CASE_INSENSITIVE).matcher(approvers);
		 while (match.find()) {
		        System.out.println("found!!!!!!!!"+match.start()+"end=="+(match.end()-1));
		        String approversafterreplaced=match.replaceAll(delegateUserEmail);
		       
		        System.out.println("approversafterreplaced=="+approversafterreplaced);
		        linfo.setApproverEmails(approversafterreplaced);
		    	LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(linfo);
		    	System.out.println("approvers updated in db");

		    }
/*
		if(approvers.contains(loggedInUserEmail)){
			System.out.println("matched approver");
			approvers.replace(loggedInUserEmail, delegateUserEmail);
			System.out.println("replaced approver with delegate user===");
		}
*/
	}
	System.out.println("taskID"+taskID);

	WorkflowTask workFlowTask=WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskID);
	long workflowInstanceId=workFlowTask.getWorkflowInstanceId();
	System.out.println("workflowInstanceId of the loggedin approver task"+workflowInstanceId);
	Date dueDate=workFlowTask.getDueDate();
	WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), workFlowTask.getWorkflowInstanceId());
	Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		User assigneeUser=UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), delegateUserEmail);
		String assigneeUserFullName =assigneeUser.getFullName();
		WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(), taskID, assigneeUser.getUserId(), "delegating to you", dueDate, workflowContext);
		
		//WorkflowInstanceManagerUtil.deleteWorkflowInstance(themeDisplay.getCompanyId(), workflowInstanceId);
		System.out.println("deleted workflowinstance for this approver");
		//long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)); 
		//LMSLeaveInformation leaveInfo= LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation((int)(resourcePrimKey));
		LMSLeaveInformation leaveInfo= LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(Sno);

		              
		SendMail.delegateMail(leaveInfo, delegateUserEmail, assigneeUserFullName);   
		
			
		LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
		log.setLeaveRequestId(linfo.getSNo());
		log.setAction("Delegated");
		log.setActionBy(themeDisplay.getUser().getFullName());
		log.setCreatedDate(new Date());
		LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
		
		
		
		LeaveApprovalHistory leaveappHistory=LeaveApprovalHistoryLocalServiceUtil.createLeaveApprovalHistory(LeaveApprovalHistoryLocalServiceUtil.getLeaveApprovalHistoriesCount()+1);
		
		int approverEmployeeId=LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(loggedInUserEmail).getEmployeeId();
		leaveappHistory.setApproverID(approverEmployeeId);
		leaveappHistory.setLeaveRequestId(linfo.getLeaveRequestId());
		leaveappHistory.setLeaveStatus("Delegated");
		LeaveApprovalHistoryLocalServiceUtil.addLeaveApprovalHistory(leaveappHistory);
		System.out.println("delegated data added in LeaveApprovalHistory table===");
		if( request.getParameter("projectCode")!=null){
			response.setRenderParameter("projCode", request.getParameter("projectCode"));
			}
		response.setRenderParameter("jspPage","/jsp/AllProjectRequests.jsp");
				
		
		
	
	
		
	}

	
	
		
	}




