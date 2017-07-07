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
<%@page import="com.trianz.lms.NoSuchLeaveInformationException" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactory" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>

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
<%--  <jsp:include page="/jsp/Navigation.jsp" /> --%>
<jsp:include page="/jsp/WorkFlowTasks.jsp" />

 <portlet:renderURL var="Reportees">
    <portlet:param name="jspPage" value="/jsp/Reportees.jsp" />
</portlet:renderURL> 

<portlet:defineObjects />

<portlet:resourceURL var="getUsers">
<portlet:param name="GetSubList" value="Users"/>

</portlet:resourceURL>


<aui:script>
$(document).ready(function(){
              getUsers();
              getUsersCopy();
              
});

function getUsers(){
       AUI().use('aui-io-request', function(A){
               A.io.request('<%=getUsers%>', {
                      method: 'post',
                    
                      on: {
                            success: function() {
                                  $('#<portlet:namespace />emailId').html('');
                               $('#<portlet:namespace />emailId').append(this.get('responseData'));
                           }
                     }
               });
           });
}

function getUsersCopy(){
       AUI().use('aui-io-request', function(A){
               A.io.request('<%=getUsers%>', {
                      method: 'post',
                    
                      on: {
                            success: function() {
                                  $('#<portlet:namespace />emailIdforAll').html('');
                               $('#<portlet:namespace />emailIdforAll').append(this.get('responseData'));
                           }
                     }
               });
           });
}

</aui:script>



<%ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String loggedInEmailId = themeDisplay.getUser().getEmailAddress();
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




List<Long>taskIds = new ArrayList<Long>();
int deltaValue = 5;


LMSEmployeeDetails loginEmpDetails = LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(loggedInEmailId);
int loginEmpID = loginEmpDetails.getEmployeeId();
%>


<%
String callApproveURL = "javascript:callApproveAction()";
String callRejectURL = "javascript:callRejectAction()";
String callDelegateURL ="javascript:callDelegateAction()";
%>
<%String viewStatusURL = "javascript:callStatusAction()";%> 
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



 <div id="filters"><div class="filterCri"><label>Filter By LeaveType :</label><span id="leaveTypeFilter"></span></div></div>

  <div class="container">
    <ul class="nav nav-tabs">
  <li ><a href="#"  id="pending" data-toggle="tab">Pending Leaves</a></li>
  <li><a  href="#"  id="approved" data-toggle="tab">Approved Leaves</a></li>
  <li><a href="#"  id="cancelled" data-toggle="tab">Cancelled Leaves</a></li>
  <li><a href="#"  id="reject" data-toggle="tab">Rejected Leaves</a></li>
  <li class="active"><a href="#" id="total" data-toggle="tab">Total Leaves</a></li>
</ul>
   <div class="tab-content">
<div id="mainContent" class="tab-pane fade in active">

<table id="employeeLeavehistory">

 
    <thead>
		<tr>
		<!--  <th>Request ID</th> -->
		 <th>Employee Name</th>
		 <th>Applied On</th>
		  <th>Leave Type</th>
            <th>Start Date</th>
            <th>End Date</th>
           
           <!--  <th>Leave Category</th> -->
            <th>Duration</th>
            <th>Approval Status</th>
            <th>Request ID</th>
          <!--  <th>Project</th> -->
           <th>Actions</th>
           
           </tr>
           </thead>
    
    
    <tbody>
  <%  for(WorkflowTask workFlowTask : allworkflowtasks){
  
	  WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), workFlowTask.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		
		String LeaveReqId=(String)workflowContext.get("leaveRequestId");

		if(LeaveReqId!=null){
			LMSLeaveInformation leaveinfo;
			try{
		LMSEmployeeDetails employee = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(LeaveReqId).getEmployeeId());
		List<LMSProjectDetails> employeeProjects = LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(employee.getEmployeeId());
		
		for(int i=0;i<employeeProjects.size();i++){
			if(request.getParameter("projCode")!=null){
			if(request.getParameter("projCode").equalsIgnoreCase(employeeProjects.get(i).getProjectCode())){
				
				
				
			
			
		
		leaveinfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(LeaveReqId);
		List<LeaveApprovalHistory> leaveApprovalHistory = LeaveApprovalHistoryLocalServiceUtil.getLeaveApprovalHistorybyLeavereqId(LeaveReqId);
  
  		//System.out.print("On jsp page-==="+leaveinfo.getPrimaryKey());
  
  %> 
   <portlet:actionURL var="approveLeaveURL" name="approveLeave">
<portlet:param name="taskId" value="<%=String.valueOf(workFlowTask.getWorkflowTaskId())%>"/>
<portlet:param name="Sno" value="<%=String.valueOf(leaveinfo.getPrimaryKey())%>"/>
<portlet:param name="leaveRequestId" value="<%=leaveinfo.getLeaveRequestId()%>"/>
<portlet:param name="projectCode" value="<%=employeeProjects.get(i).getProjectCode()%>"/>

</portlet:actionURL>
<portlet:actionURL var="rejectLeaveURL" name="rejectLeave">
<portlet:param name="taskId" value="<%=String.valueOf(workFlowTask.getWorkflowTaskId())%>"/>
<portlet:param name="Sno" value="<%=String.valueOf(leaveinfo.getPrimaryKey())%>"/>
<portlet:param name="projectCode" value="<%=employeeProjects.get(i).getProjectCode()%>"/>

</portlet:actionURL>
<portlet:actionURL var="delegate" name="delegateLeave">
<portlet:param name="taskId" value="<%=String.valueOf(workFlowTask.getWorkflowTaskId())%>"/>
<portlet:param name="Sno" value="<%=String.valueOf(leaveinfo.getPrimaryKey())%>"/>
<portlet:param name="projectCode" value="<%=employeeProjects.get(i).getProjectCode()%>"/>

</portlet:actionURL>     
        <tr>
           <td><%= employee.getEmployeeName() %></td>
             <td><%=new SimpleDateFormat("yyyy-MM-dd").format( leaveinfo.getCreatedDate()) %></td>
              <td><%=leaveinfo.getAbsenceType()%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format( leaveinfo.getStartDate())%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getEndDate()) %></td>
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
        	   	
        	   	
           }}}
		 
		
		}catch (Exception e) {
			
			System.out.println(e);
		} 
  }
 	   
	} 

    %>
       <%for(LMSLeaveInformation approvedLeave : autoApprovedLeaveRequests){ %>
       
       
        
       <% 
		LMSEmployeeDetails employee = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(approvedLeave.getLeaveRequestId()).getEmployeeId());

       List<LMSProjectDetails> employeeProjects = LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(employee.getEmployeeId());
		
		for(int i=0;i<employeeProjects.size();i++){
			if(request.getParameter("projCode")!=null){
			if(request.getParameter("projCode").equalsIgnoreCase(employeeProjects.get(i).getProjectCode())){%>
			
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
			
			
			
				
				
       <%}} }%>
       
       
      
       
       
       
     
     <%}%>
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
   var table= $('#employeeLeavehistory').DataTable({
    	"iDisplayLength": 5,
    	"order": [[ 7, "desc" ]],
    	 "columnDefs": [
                        {"className": "dt-center", "targets": [0,1,2,3,4,5,6,8]},
                        { "visible": false, "targets":7 },
                        { "targets": [0,1,2,3,4,5,6,8], "orderable": false }
                    ],
    	
    });
   
  
  
   $("#leaveTypeFilter").each( function ( i ) {
		
		var select = $('<select ><option value="">----Select---</option></select>')
           .appendTo( $(this).empty() )
           .on( 'change', function () {
               var val = $(this).val();
				
               table.column( 2 )
                   .search( val ? '^'+$(this).val()+'$' : val, true, false )
                   .draw();
           } );
		
		
			table.column( 2 ).data().unique().sort().each( function ( d, j ) {  
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