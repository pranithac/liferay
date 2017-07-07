

<%@page import="java.sql.SQLException"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.trianz.lms.util.DateFormatter" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import= "org.apache.commons.beanutils.BeanComparator"%>
<%@ page import= "com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import= "com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import=" javax.portlet.PortletSession" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<jsp:include page="/jsp/Navigation.jsp" />
<portlet:defineObjects />

<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<LMSLeaveInformation> searchContainer = null;
%>



 <liferay-portlet:renderURL varImpl="iteratorURL">
<portlet:param name="jspPage" value="/hr_jsp/GetEmployeeLeaveInformation.jsp" />

</liferay-portlet:renderURL>
 
<%

/* PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("jspPage", "/hr_jsp/GetEmployeeLeaveInformation.jsp"); */

String viewStatusURL = "javascript:callStatusAction()";
String leaveReqNO  = (String) renderRequest.getPortletSession().getAttribute("leaveRequestID",PortletSession.APPLICATION_SCOPE);
String employeeID =  (String)renderRequest.getPortletSession().getAttribute("EmployeeID",PortletSession.APPLICATION_SCOPE);
String employeeName = (String)renderRequest.getPortletSession().getAttribute("EmployeeName",PortletSession.APPLICATION_SCOPE);



List<LMSLeaveInformation> leaveInformation = new ArrayList<LMSLeaveInformation>();

if(!leaveReqNO.isEmpty())
{
	String leaveReqId = leaveReqNO;
	
	try{
	
	leaveInformation.add(LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqId));
	}
	catch (Exception e)
	{
		 System.out.println(e);
	       
	}
	
}
else if(!employeeID.isEmpty())
{
	
	try
	{
		int employeeidtogetList = Integer.parseInt(employeeID);
		
		leaveInformation = LMSLeaveInformationLocalServiceUtil.getleavesByEmployeeID(employeeidtogetList);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
		
	
}
else if(!employeeName.isEmpty())
{
	LMSEmployeeDetails employeeDetailsByname =  null;
	try
	{
	 employeeDetailsByname = LMSEmployeeDetailsLocalServiceUtil.getEmployeeByName(employeeName);
	
	
	//System.out.println("EmployeeID"+employeeDetailsByname.getEmployeeId());
	if(employeeDetailsByname!=null)
	{
		leaveInformation = LMSLeaveInformationLocalServiceUtil.getleavesByEmployeeID(employeeDetailsByname.getEmployeeId());
	}
	}
	catch (Exception e)
	{
		 System.out.println(e);
	       
	    
	}
}

List<LMSLeaveInformation> copyOfleaveInormation = new ArrayList<LMSLeaveInformation>();

for(LMSLeaveInformation leaveinfo : leaveInformation)
{
	if(leaveinfo.getApprovalStatus().equalsIgnoreCase("Approved")||leaveinfo.getApprovalStatus().equalsIgnoreCase("Pending")||leaveinfo.getApprovalStatus().equalsIgnoreCase("Incomplete"))
	{
		copyOfleaveInormation.add(leaveinfo);
	}
}


%> 
  

 <div id="filters"><div class="filterCri"><label>Filter By Leave Type :</label><span id="leaveTypeFilter"></span></div></div>

  <div class="container">
    <ul class="nav nav-tabs">
  <li ><a href="#"   id="pending" data-toggle="tab">Pending Leaves</a></li>
  <li><a href="#"  id="approved" data-toggle="tab">Approved Leaves</a></li>
  <li><a href="#"  id="cancelled" data-toggle="tab">Cancelled Leaves</a></li>
  <li><a href="#"  id="reject" data-toggle="tab">Rejected Leaves</a></li>
  <li class="active"><a  href="#" id="total" data-toggle="tab">Total Leaves</a></li>
</ul>
   <div class="tab-content">
   <div id="mainContent" class="tab-pane fade in active">

  <table id="leaveHistoryDatatable">
    <thead>
        <tr>
            <th>Applied On</th>
            <th>Leave Type</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Duration</th>
            <th>Approval Status</th>
            <th>Actions</th>
            
        </tr>
    </thead>
     <tbody>
     <%for(LMSLeaveInformation leaveinfo : copyOfleaveInormation){%> 
  
        <tr>
           <td><%=  new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getCreatedDate())%></td>
           <td><%=leaveinfo.getAbsenceType()%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getStartDate())%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getEndDate())%></td>
             
             <td><%= leaveinfo.getDuration() %></td>

             <td><%=leaveinfo.getApprovalStatus()%></td>
             
             <td>
             
             <portlet:actionURL var="editLeaveURL" name="hrEditLeave">
			<portlet:param name="LeaveReqNo" value="<%=String.valueOf(leaveinfo.getLeaveRequestId())%>"/>
				</portlet:actionURL>
             
             <%if((leaveinfo.getApprovalStatus()).equalsIgnoreCase("Approved")||(leaveinfo.getApprovalStatus()).equalsIgnoreCase("Incomplete")){%>
    

     <liferay-ui:icon iconCssClass="icon-edit" message="Update" url="<%=editLeaveURL%>" />
        
    <portlet:actionURL var="cancelLeaveURL" name="hrcancelLeave">
        <portlet:param name="LeaveReqNo" value="<%=String.valueOf(leaveinfo.getLeaveRequestId())%>"/>
</portlet:actionURL>
        <liferay-ui:icon iconCssClass="icon-remove-sign" message="Cancel" url="<%=cancelLeaveURL%>" />
        <span class="viewStatus" id="<%=String.valueOf(leaveinfo.getLeaveRequestId()) %>" onClick="getId(this.id)"><liferay-ui:icon iconCssClass="icon-eye-open" message="View Status" url='#' ></liferay-ui:icon></span>
        
   <%}
              
              else{ %>
             
           <span class="viewStatus" id="<%=String.valueOf(leaveinfo.getLeaveRequestId()) %>" onClick="getId(this.id)"><liferay-ui:icon iconCssClass="icon-eye-open" message="View Status" url='#' ></liferay-ui:icon></span>  
           <%} %>
             <div id="<%=String.valueOf(leaveinfo.getLeaveRequestId()) %>viewStat" style="display:none;">
    <%int SNo= leaveinfo.getSNo();%>


<%List<LeaveInformationAudit> logs = LeaveInformationAuditLocalServiceUtil.getAuditRecordsByLeaveRequest(SNo);%>
      
      
      
      <% 
      if(logs.size()>0){
    	  for(int p=0;p<logs.size();p++){
     
      %>
      
      <%=logs.get(p).getActionBy()+" "+ logs.get(p).getAction() +" "+"on"+" "+logs.get(p).getCreatedDate()%><br/><br/>
      <%}  }else{%>
      
      No actions performed on this leave request ID.
      <%} %>
    </div>
             
             </td>
              </tr>
              <%} %>
              
              
              
              
              
              </table>
  </div>
  </div>
  </div>
  

<script>
function getId(val){
	var b=$('#'+val+'viewStat');
	
var modalhtml="";
modalhtml+='<div id="myModalDelegate" class="modal">';
modalhtml+='<div class="modal-dialog">';
modalhtml+='<div class="modal-content">';
modalhtml+='<div class="modal-header">';
modalhtml+=' <a href="#" class="close" data-dismiss="modal" onclick="closeModal();"><i class="icon-remove"></i></a>';
modalhtml+='<h4 class="modal-title">Leave Request Status</h4>';
modalhtml+='</div>';
modalhtml+='<div class="modal-body">';
		
modalhtml+=b.html();
modalhtml+='</div></div></div></div>';
	$('#mainContent').append(modalhtml);
	
}
function callStatusAction(){
	
	var a=$('#viewStatus');
	var b=a.next('a');
	alert(b.attr('id'));

	
}
function closeModal(){
	
	$('.modal').hide();
	
}
$(document).ready(function(){
   var table= $('#leaveHistoryDatatable').DataTable({
    	"iDisplayLength": 5,
    	"bSort" : false,
    
    });
 $("#leaveTypeFilter").each( function ( i ) {
 		
 		var select = $('<select ><option value="">----Select---</option></select>')
            .appendTo( $(this).empty() )
            .on( 'change', function () {
                var val = $(this).val();
 				
                table.column( 1 )
                    .search( val ? '^'+$(this).val()+'$' : val, true, false )
                    .draw();
            } );
 		
 		
 			table.column( 1 ).data().unique().sort().each( function ( d, j ) {  
 				select.append( '<option value="'+d+'">'+d+'</option>' );
 	        } );	
 		}
        
 	
 );
 $("#approvalStatusFilter").each( function ( i ) {
 	
 	var select = $('<select ><option value="">----Select---</option></select>')
        .appendTo( $(this).empty() )
        .on( 'change', function () {
            var val = $(this).val();
 			
            table.column(5 )
                .search( val ? '^'+$(this).val()+'$' : val, true, false )
                .draw();
        } );
 	
 	
 		table.column( 5 ).data().unique().sort().each( function ( d, j ) {  
 			select.append( '<option value="'+d+'">'+d+'</option>' );
        } );	
 	}
    

 );
 $('#pending').click(function(){
 	$('#mainContent').show();
 	
 	table.column( 5 )
     .search( 'Pending' ? '^'+'Pending'+'$' : 'Pending', true, false )
     .draw();


 });
$('#approved').click(function(){
	 $('#mainContent').show();
 	
 	table.column( 5)
     .search( 'Approved' ? '^'+'Approved'+'$' : 'Approved', true, false )
     .draw();


 });
$('#cancelled').click(function(){
	 $('#mainContent').show();
	
	table.column(5 )
  .search( 'Inactive' ? '^'+'Inactive'+'$' : 'Inactive', true, false )
  .draw();


});
$('#reject').click(function(){
	 $('#mainContent').show();
	
	table.column( 5 )
  .search( 'Rejected' ? '^'+'Rejected'+'$' : 'Rejected', true, false )
  .draw();


});
 
$('#total').click(function()
		{
				$('#mainContent').show();
				table.column(5 )
		        .search( '' ? '^'+''+'$' : '', true, false ).draw();
				
		});



});

</script>
