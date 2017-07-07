<%@page import="java.awt.datatransfer.StringSelection"%>
<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

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

<liferay-portlet:renderURL varImpl="iteratorURL">
<portlet:param name="jspPage" value="/jsp/LeaveHistory.jsp" />
</liferay-portlet:renderURL>




<%ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String emailId = themeDisplay.getUser().getEmailAddress();


int employeeId= LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(emailId).getEmployeeId();

List<LMSLeaveInformation> employeeLeaves = LMSLeaveInformationLocalServiceUtil.getleavesByEmployeeID(employeeId);
List<LMSLeaveInformation>copyOfemployeeLeaves  = ListUtil.copy(employeeLeaves);
//Collections.reverse(copyOfemployeeLeaves);


		   
%>
<h1 style="color:teal;font-size: 20px;">Leave History</h1><br>

 <div id="filters"><div class="filterCri"><label>Filter By Leave Type :</label><span id="leaveTypeFilter"></span></div></div>
<%String viewStatusURL = "javascript:callStatusAction()";%> 
  <div class="container">
    <ul class="nav nav-tabs">
  <li ><a href="#"  id="pending" data-toggle="tab">Pending Leaves</a></li>
  <li><a  href="#"  id="approved" data-toggle="tab">Approved Leaves</a></li>
  <li><a href="#"  id="cancelled" data-toggle="tab">Cancelled Leaves</a></li>
  <li><a href="#"  id="reject" data-toggle="tab">Rejected Leaves</a></li>
  <li class="active"><a href="#"  id="total" data-toggle="tab">Total Leaves</a></li>
</ul>
   <div class="tab-content">
   <div id="mainContent" class="tab-pane fade in active">
   
 

  <table id="leaveHistoryDatatable" >
  
 
    <thead>
        <tr>
          
            <th>Applied On</th>
            <th>Leave Type</th>
            <th>Start Date</th>
            <th>End Date</th>
           <!--  <th>Leave Category</th> -->
            <th>Duration</th>
            <th>Approval Status</th>
            
            <th>Actions</th>
             <th>Request ID</th>
        </tr>
    </thead>
    <tbody>
  <%  for(LMSLeaveInformation leaveinfo : copyOfemployeeLeaves){%> 
  
        <tr>
         <%--   <td><%= leaveinfo.getLeaveRequestId()%></td> --%>
           
        	 <td><%= new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getCreatedDate())%></td>
        	  <td><%=leaveinfo.getAbsenceType()%></td>
            <td> <%if(leaveinfo.getStartDate()!=null){%><%= new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getStartDate())%><%} %></td>
            <td>  <%if(leaveinfo.getEndDate()!=null){%><%= new SimpleDateFormat("yyyy-MM-dd").format(leaveinfo.getEndDate())%><%} %></td>
            
             
         <%--     <td><%if(leaveinfo.getLeaveCategoryCode()!=null){%><%= LeaveCategoriesLocalServiceUtil.getCategoryNameByID(leaveinfo.getLeaveCategoryCode(), leaveinfo.getLeaveTypeCode())%><%} %></td> --%>
             <td><%if(leaveinfo.getDuration()!=0.0){%><%= leaveinfo.getDuration() %><%} %></td>

             <td><%if(leaveinfo.getApprovalStatus()!=null){%><%=leaveinfo.getApprovalStatus()%><%} %></td>
          
              
              
             
             
             <td>
             <portlet:actionURL var="editLeaveURL" name="editLeave">
			<portlet:param name="LeaveReqNo" value="<%=leaveinfo.getLeaveRequestId()%>"/>
			</portlet:actionURL>
        <portlet:actionURL var="deleteLeaveURL" name="deleteLeave">
        <portlet:param name="LeaveReqNo" value="<%=leaveinfo.getLeaveRequestId()%>"/>
		</portlet:actionURL>
		
		   <portlet:actionURL var="cancelLeaveURL" name="employeecancelLeave">
        <portlet:param name="LeaveReqNo" value="<%=leaveinfo.getLeaveRequestId()%>"/>
			</portlet:actionURL>
             
             
      
  
  <%if((leaveinfo.getIsDraft()).equalsIgnoreCase("Y")){ %>
  
   <!--     <div class="dropdown">
  <button class="dropbtn">Actions</button>
  <div class="dropdown-content"> -->
    <liferay-ui:icon iconCssClass="icon-edit actionIcon" message="Edit" url="<%=editLeaveURL%>" />
     <liferay-ui:icon iconCssClass="icon-trash actionIcon" message="Delete" url="<%=deleteLeaveURL%>" />
     <span class="viewStatus" id="<%=String.valueOf(leaveinfo.getLeaveRequestId()) %>" onClick="getId(this.id)"><liferay-ui:icon iconCssClass="icon-eye-open" message="View Status" url='#' ></liferay-ui:icon></span>
     
     <!--  </div>
      </div>
             -->  
    <%} 
  
  else{%>
  <span class="viewStatus" id="<%=String.valueOf(leaveinfo.getLeaveRequestId()) %>" onClick="getId(this.id)"><liferay-ui:icon iconCssClass="icon-eye-open" message="View Status" url='#' ></liferay-ui:icon></span>
    <%if((leaveinfo.getApprovalStatus()).equalsIgnoreCase("Pending")){%>
    <liferay-ui:icon iconCssClass="icon-remove-sign actionIcon" message="Cancel" url="<%=cancelLeaveURL%>" />
        
        
        
   <%}
    }%>
  
 

             
          
    
    
 
    
      
  
    
   
<div id="<%=String.valueOf(leaveinfo.getLeaveRequestId()) %>viewStat" style="display:none;">
    <%int SNo= leaveinfo.getSNo();%>


<%List<LeaveInformationAudit> logs = LeaveInformationAuditLocalServiceUtil.getAuditRecordsByLeaveRequest(SNo);%>
      
      
      
      <% 
      if(logs.size()>0){
    	  for(int p=0;p<logs.size();p++){
     
      %>
      
      <%=logs.get(p).getActionBy()+" "+ logs.get(p).getAction() +" "+"on"+" "+new SimpleDateFormat("yyyy-MM-dd").format(logs.get(p).getCreatedDate())%><br/><br/>
      <%}  }else{%>
      
      No actions performed on this leave request ID.
      <%} %>
    </div>
     </td>
    <td><%=leaveinfo.getSNo()%></td>
      <%    		
    	}
    %>
          
  
        </tr>
      
      
    </tbody>
</table>
  
     </div>

</div>
</div>
<script>
function getId(val){
	 b=$('#'+val+'viewStat');
	
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
	
	//$('#mainContent').hide();
    var table= $('#leaveHistoryDatatable').DataTable({
    	"iDisplayLength": 5,
    	"order": [[ 7, "desc" ]],
    	 "columnDefs": [
                        {"className": "dt-center", "targets": [0,1,2,3,4,5,6]},
                        { "visible": false, "targets":7 },
                        { "targets": [0,1,2,3,4,5,6], "orderable": false }
                    ],
    	                     
    	                     
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
    /* $("#approvalStatusFilter").each( function ( i ) {
    	
		var select = $('<select ><option value="">----Select---</option></select>')
            .appendTo( $(this).empty() )
            .on( 'change', function () {
                var val = $(this).val();
				
                table.column( 6 )
                    .search( val ? '^'+$(this).val()+'$' : val, true, false )
                    .draw();
            } );
 		
		
			table.column( 6 ).data().unique().sort().each( function ( d, j ) {  
				select.append( '<option value="'+d+'">'+d+'</option>' );
	        } );	
		}); */
    $('#pending').click(function(){
    	$('#mainContent').show();
    	
    	table.column( 5 )
        .search( 'Pending' ? '^'+'Pending'+'$' : 'Pending', true, false )
        .draw();


    });
 $('#approved').click(function(){
	 $('#mainContent').show();
    	
    	table.column( 5 )
        .search( 'Approved' ? '^'+'Approved'+'$' : 'Approved', true, false )
        .draw();


    });
 $('#cancelled').click(function(){
	 $('#mainContent').show();
 	
 	table.column( 5 )
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
 				table.column( 5 )
 		        .search( '' ? '^'+''+'$' : '', true, false ).draw();
 				
 		});

  
});
</script>
