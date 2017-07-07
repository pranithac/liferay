<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@ page import="com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil" %>


<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil" %>

<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowHandlerUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowHandlerUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %>

<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactory" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@page import="com.trianz.lms.NoSuchLeaveInformationException" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.trianz.lms.util.DateFormatter" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowInstance" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="java.io.Serializable" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowHandler" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
 <%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="java.text.DateFormat" %>
<jsp:include page="/jsp/WorkFlowTasks.jsp" />
<%--  <jsp:include page="/jsp/Navigation.jsp" />
 --%>

<portlet:defineObjects />


<%
ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String loggedInEmailId = themeDisplay.getUser().getEmailAddress();
String ApproverEmail = themeDisplay.getUser().getEmailAddress();
//System.out.println("Approver email id " + ApproverEmail);
String ApproverName = themeDisplay.getUser().getFullName();
List<LMSEmployeeDetails> employeesBySupervisor = LMSEmployeeDetailsLocalServiceUtil.getEmployeesBySupervisorEmail(ApproverEmail);
//System.out.println("employeesBySupervisor " + employeesBySupervisor.size());
List<LMSProjectDetails> employeesByApprover = LMSProjectDetailsLocalServiceUtil.getEmployeesByApproverEmail(ApproverEmail);
//System.out.println("employeesByApprover " + employeesByApprover.size());


List<Integer> employeesList = new ArrayList<Integer>();
//System.out.println(employeesList.size() + "======");
for(LMSEmployeeDetails supEmp : employeesBySupervisor){
	//System.out.println(supEmp.getEmployeeId());
	employeesList.add(supEmp.getEmployeeId());
	//System.out.println(employeesList.size());	
}

for(LMSProjectDetails appEmp : employeesByApprover){
	//System.out.println("inside proj method " + appEmp.getEmployeeId());
	int empId = appEmp.getEmployeeId();
	if(employeesList.contains(empId) == false){
		//System.out.println(empId);
		String empName  = LMSEmployeeDetailsLocalServiceUtil.fetchLMSEmployeeDetails(empId).getEmployeeName();
		employeesList.add(empId);
	}
}




/**************  To get Workflow tasks list******************/
String[] assetTypes = WorkflowHandlerUtil.getSearchableAssetTypes();
ArrayList<String> LeaveAssets = new ArrayList<String>();

for(int i=0;i<assetTypes.length;i++){
	//System.out.println("Asset Type:" +assetTypes[i]);
	if((assetTypes[i]).equalsIgnoreCase("com.trianz.lms.model.LMSLeaveInformation")){
		
		LeaveAssets.add(assetTypes[i]);
	}
}
String[] LeaveAssetsArray=new String[LeaveAssets.size()];
LeaveAssetsArray = LeaveAssets.toArray(LeaveAssetsArray);

int end=WorkflowTaskManagerUtil.getWorkflowTaskCount(themeDisplay.getCompanyId(), false);
OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil.getOrderByComparatorFactory();
	 //OrderByComparator comparator = orderByComparatorFactory.create("DLFILEENTRY", "FILEENTRYID",true);
OrderByComparator comparator = null;



List<WorkflowTask> pendingwftasks = WorkflowTaskManagerUtil.search(themeDisplay.getCompanyId(), themeDisplay.getUserId(), "", LeaveAssetsArray, false, false, 0, end,comparator);
List<WorkflowTask>completedWorkfloTasks =  WorkflowTaskManagerUtil.search(themeDisplay.getCompanyId(), themeDisplay.getUserId(), "", LeaveAssetsArray, true, false,0, end,comparator);
Collections.reverse(pendingwftasks);
Collections.reverse(completedWorkfloTasks);
List<WorkflowTask> allworkflowtasks = new ArrayList<WorkflowTask>();

allworkflowtasks.addAll(pendingwftasks);
allworkflowtasks.addAll(completedWorkfloTasks);

LMSEmployeeDetails loginEmpDetails = LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(ApproverEmail);
int loginEmpID = loginEmpDetails.getEmployeeId();

/**************  To get Workflow tasks list end Here******************/
 %>
<!--   To get auto approved requests list -->
 <%

List<LMSLeaveInformation>autoApprovedLeaveRequests=new ArrayList<LMSLeaveInformation>();
DateFormat df =new SimpleDateFormat("dd-MMM-yyyy");
List<LMSLeaveInformation>leavesOfApprover=LMSLeaveInformationLocalServiceUtil.getLeavesByApproverMail(loggedInEmailId);

for(LMSLeaveInformation approverleave:leavesOfApprover)
{
 if(approverleave.getApprovalStatus().equalsIgnoreCase("Approved"))
         {

    String Date=df.format(new Date());
 Date currentDate = df.parse(Date);
 
    String inputDate = df.format(approverleave.getStartDate());
    Date inputStartDate = df.parse(inputDate);
    
     int check=inputStartDate.compareTo(currentDate);
    
     if(inputStartDate.before(currentDate)||check !=0 && check != 1)//past dated autoapproval leaves
		{
          
         autoApprovedLeaveRequests.add(approverleave);
         
         
         }
    }
}

 %>

<!-- table will come here  -->


<%
String emailId = themeDisplay.getUser().getEmailAddress();
 %>

 <%
String callApproveURL = "javascript:callApproveAction()";
String callRejectURL = "javascript:callRejectAction()";
String callDelegateURL ="javascript:callDelegateAction()";
%>
 <%String viewStatusURL = "javascript:callStatusAction()";%> 
 <h1 style="color:teal;font-size: 20px;">Pending Requests By Employee</h1>
<div id="filters"><div class="filterCri"><label>Filter By Employee :</label><span id="leaveTypeFilter"></span></div></div>

  <div class="container">
    <ul class="nav nav-tabs">
  <li ><a href="#"  id="pending" data-toggle="tab">Pending Leaves</a></li>
  <li><a href="#"  id="approved" data-toggle="tab">Approved Leaves</a></li>
  <li><a href="#"  id="cancelled" data-toggle="tab">Cancelled Leaves</a></li>
  <li><a href="#"  id="reject" data-toggle="tab">Rejected Leaves</a></li>
  <li class="active"><a href="#"  id="total" data-toggle="tab">Total Leaves</a></li>
</ul>
   <div class="tab-content">
<div id="mainContent" class="tab-pane fade in active">
 
 <table id="employeeLeavehistory">

    <thead>
		<tr>
		 
		   <th>Employee Name</th>
		   <th>Applied On</th>
		    <th>Leave Type</th>
            <th>Start Date</th>
            <th>End Date</th>
        
           <!--  <th>Leave Category</th> -->
            <th>Duration</th>
            <th>Approval Status</th>
            <th>Request ID</th>
            <th>Actions</th>
         
           </tr>
           </thead>
    
    
    <tbody>
  <%  for(WorkflowTask workFlowTask : allworkflowtasks){
  
	  WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), workFlowTask.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		/* String className = (String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME);
		long classPK = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		
		WorkflowHandler workflowHandler = WorkflowHandlerRegistryUtil.getWorkflowHandler(className);

		
		String LeaveReqId = workflowHandler.getTitle(classPK,themeDisplay.getLocale());
		*/
		String LeaveReqId=(String)workflowContext.get("leaveRequestId");
 
		//System.out.print("LeaveReqID"+LeaveReqId);

		if(LeaveReqId!=null){
			LMSLeaveInformation leaveinfo;
		
		
		try{
			leaveinfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(LeaveReqId);
			LMSEmployeeDetails employee = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(LeaveReqId).getEmployeeId());
		List<LeaveApprovalHistory> leaveApprovalHistory = LeaveApprovalHistoryLocalServiceUtil.getLeaveApprovalHistorybyLeavereqId(LeaveReqId);
  %> 
  
  <portlet:actionURL var="approveLeaveURL" name="approveLeave">
<portlet:param name="taskId" value="<%=String.valueOf(workFlowTask.getWorkflowTaskId())%>"/>
<portlet:param name="Sno" value="<%=String.valueOf(leaveinfo.getPrimaryKey())%>"/>

</portlet:actionURL>
<portlet:actionURL var="rejectLeaveURL" name="rejectLeave">
<portlet:param name="taskId" value="<%=String.valueOf(workFlowTask.getWorkflowTaskId())%>"/>
<portlet:param name="Sno" value="<%=String.valueOf(leaveinfo.getPrimaryKey())%>"/>

</portlet:actionURL>
<portlet:actionURL var="delegate" name="delegateLeave">
<portlet:param name="taskId" value="<%=String.valueOf(workFlowTask.getWorkflowTaskId())%>"/>
<portlet:param name="Sno" value="<%=String.valueOf(leaveinfo.getPrimaryKey())%>"/>

</portlet:actionURL>     
        <tr>
           <td><%=employee.getEmployeeName()%></td>
             <td><%= new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getCreatedDate()) %></td>
              <td><%=leaveinfo.getAbsenceType()%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getStartDate())%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getEndDate())%></td>
            
            <%--  <%if(leaveinfo.getLeaveCategoryCode()!=null && leaveinfo.getLeaveTypeCode()!=0){ %>
             <td><%= LeaveCategoriesLocalServiceUtil.getCategoryNameByID(leaveinfo.getLeaveCategoryCode(), leaveinfo.getLeaveTypeCode())%></td>
             <%}
             else
             { %>
            	 
            	  <td> </td>
             <%}% --%>
             <td><%= leaveinfo.getDuration() %></td>

             <td><%=leaveinfo.getApprovalStatus()%></td>
              <td><%=leaveinfo.getSNo()%></td>
             
                  
	<% 
		int count =0;
	for(LeaveApprovalHistory leaveApprovalh : leaveApprovalHistory){
        	    if(leaveApprovalh.getApproverID() == loginEmpID)
        	   	{ 
        	    	count++;
       	   	}
	}

	 if(count==0&&!"Approved".equalsIgnoreCase(leaveinfo.getApprovalStatus())&&!"Inactive".equalsIgnoreCase(leaveinfo.getApprovalStatus()))
    {   %>
             
             <td>
             
             <liferay-ui:icon iconCssClass="icon-ok" message="Approve" url="<%=callApproveURL %>"/>
        <liferay-ui:icon iconCssClass="icon-remove" message="Reject" url="<%=callRejectURL%>" />
		<liferay-ui:icon iconCssClass="icon-user" message="Delegate" url="<%=callDelegateURL%>" />
		
		<div id="myModalApprove" style="display:none;" class="modal">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Approval Comments</h4>
      </div>
     <aui:form method="post"  action="<%=approveLeaveURL%>" >
      <div class="modal-body">
      <aui:input type="textarea" label="" resizable="false" name="approveComments" maxlength="200" placeholder="Enter only 200 characters"/>  
       <aui:button type="submit"  class="btn btn-primary" value="OK"></aui:button>
   	 </div>
      
   	 
</aui:form>
</div>
  </div>
</div>	


<div id="myModalReject" style="display:none;" class="modal">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Rejection Comments</h4>
      </div>
     <aui:form method="post" action="<%=rejectLeaveURL%>" >
      <div class="modal-body">
      <aui:input type="textarea" label="" resizable="false" name="rejectComments" maxlength="200" placeholder="Enter only 200 characters"/> 
      <aui:button type="submit" id = "coments" class="btn btn-primary" value="OK" ></aui:button> 
    </div>
      
     
   
 </aui:form> 
 </div>
  </div>
</div>

<div id="myModalDelegate" style="display:none;" class="modal">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Delegate Comments</h4>
      </div>
      <aui:form action="<%=delegate%>" method="post" id="delegate" name="delegateToOthers"  >
      <div class="modal-body" style="height:13em;">

<aui:select id="emailId" name="emailId" label="Email Id<span style='color: red;'>*</span>" inlineLabel="true" onChange="removeErrmsg();"
helpMessage="Leave Requests can only be delegated to other supervisors or project heads" onmousedown="if(this.options.length>10){this.size=8;}" onchange='this.size=0;' onblur="this.size=0;" />
 <aui:input type="textarea" label="" resizable="false" name="delegateComments" maxlength="200" placeholder="Enter only 200 characters"/> 


 <aui:button type="button" name="submit" class="btn btn-primary" value="Delegate" onClick="checkValidation();"/>
</div>


</aui:form>
  </div>
  
</div>
</div>
    </td>
    <%} 
    else {
    
    %> 
	 <td> </td>

<%} %>
              
              
        </tr>
        <%    		
    	}
		catch (Exception e) {
			
			System.out.println(e);
		} 
		} }

    %>
      <!-- for autoapproved requests -->
      <%for(LMSLeaveInformation approvedLeave : autoApprovedLeaveRequests){ %>
     <tr>
     <td><%= LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(approvedLeave.getEmployeeId()).getEmployeeName()%></td>
             <td><%=new SimpleDateFormat("yyyy-MM-dd").format( approvedLeave.getCreatedDate()) %></td>
              <td><%=approvedLeave.getAbsenceType()%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format( approvedLeave.getStartDate())%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(approvedLeave.getEndDate()) %></td>
             <td><%= approvedLeave.getDuration() %></td>

             <td><%=approvedLeave.getApprovalStatus()%></td>
             <td><%=approvedLeave.getSNo()%></td>
             <td></td>
     
     </tr> 
     <%} %>
    </tbody>
   
</table>



</div>

</div>
</div>




<script>



function callApproveAction(){
	
	$('#myModalApprove').modal('show'); 
	$('.modal-backdrop').remove();
}
function callRejectAction(){
	
	$('#myModalReject').modal('show'); 
	$('.modal-backdrop').remove();
}
function callDelegateAction(){
	
	$('#myModalDelegate').modal('show'); 
	$('.modal-backdrop').remove();
}

$(document).ready(function(){
    var table=$('#employeeLeavehistory').DataTable({
    	"iDisplayLength": 5,
    	"order": [[ 7, "desc" ]],
    	
   		 "columnDefs": [
                       {"className": "dt-center", "targets": [0,1,2,3,4,5,6,8]},
                       { "visible": false, "targets":7 },
                       { "targets": [0,1,2,3,4,5,6,8], "orderable": false }
                   ],
   	              
   	    
    });
    //table.fnSort( [ [0,'desc'] ] );
    $("#leaveTypeFilter").each( function ( i ) {
 		
 		var select = $('<select ><option value="">----Select---</option></select>')
            .appendTo( $(this).empty() )
            .on( 'change', function () {
                var val = $(this).val();
 				
                table.column( 0 )
                    .search( val ? '^'+$(this).val()+'$' : val, true, false )
                    .draw();
            } );
 		
 		
 			table.column( 0 ).data().unique().sort().each( function ( d, j ) {  
 				select.append( '<option value="'+d+'">'+d+'</option>' );
 	        } );	
 		}
        
 	
 );

 $('#pending').click(function(){
		$('#mainContent').show();
		
		table.column( 6 )
	    .search( 'Pending' ? '^'+'Pending'+'$' : 'Pending', true, false )
	    .draw();


	});
	$('#approved').click(function(){
	 $('#mainContent').show();
		
		table.column(6 )
	    .search( 'Approved' ? '^'+'Approved'+'$' : 'Approved', true, false )
	    .draw();


	});
	$('#cancelled').click(function(){
	 $('#mainContent').show();
		
		table.column( 6 )
	 .search( 'Inactive' ? '^'+'Inactive'+'$' : 'Inactive', true, false )
	 .draw();


	});
	$('#reject').click(function(){
	 $('#mainContent').show();
		
		table.column( 6 )
	 .search( 'Rejected' ? '^'+'Rejected'+'$' : 'Rejected', true, false )
	 .draw();


	});
	$('#total').click(function()
	   		{
	   				$('#mainContent').show();
	   				table.column( 6 )
	   		        .search( '' ? '^'+''+'$' : '', true, false ).draw();
	   				
	   		});

	
});

/***************** check Deligate Email Select Validation Starts Here *************************************/
  function checkValidation(){
	  var rtnvalue=true;
		var email= $('#<portlet:namespace />emailId').val();
		
		if((email=='select')||(email=="")){
			
			if($('#fieldRequired')){
				$('#fieldRequired').remove();
			}
			
			$('#<portlet:namespace />emailId').after('<div id="fieldRequired">**This field is required.</div>');
			rtnvalue=false;
			return rtnvalue;
			
}
if(rtnvalue){
		
		 document.forms["<portlet:namespace />delegateToOthers"].submit();
		}
}
/***************** check Deligate Email Select Validation  Ends Here*************************************/
 function removeErrmsg()
 {
	 $('#fieldRequired').remove();
	 
 }
</script>

