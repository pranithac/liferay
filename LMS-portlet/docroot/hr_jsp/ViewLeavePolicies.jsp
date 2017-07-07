<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js" type="text/javascript"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
 <jsp:include page="/jsp/Navigation.jsp" />
 <%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet" />
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js" type="text/javascript"></script>
<portlet:actionURL var="addLeavePolicy" name="addLeavePolicy"></portlet:actionURL>
<% 
List<LMSLeavePolicies> leavePolicies = LMSLeavePoliciesLocalServiceUtil.getLMSLeavePolicieses(0, LMSLeavePoliciesLocalServiceUtil.getLMSLeavePoliciesesCount());


%>
<h1 style="color:teal;font-size: 20px;">View/Edit Leave Policies</h1>

<div id="mainContent">
 <table id="leavePolicy" >
  
 
    <thead>
        <tr>
         
            <th>Project Name</th>
            <th>Leave Types Applicable</th>
            <th>Locations</th>
            <th>Actions</th>
            
        </tr>
    </thead>
    <tbody>
  <% for(LMSLeavePolicies leavePolicy : leavePolicies){
  
	  List<String> leaveTypes = new ArrayList<String>();
	  List<String> locations = new ArrayList<String>();
		
	  String leaveTypesApplicable="";
	  leaveTypes.addAll(Arrays.asList(leavePolicy.getLeaveTypesApplicable().split(",")));

	  for(String leavetypec : leaveTypes)
	  {
		  System.out.print("LeaveTypes"+leavetypec);
		  
		  if(leavetypec!=null){
	 		
	 		try{
	 			int leavetypeCode = Integer.parseInt(leavetypec);
	 		 leaveTypesApplicable = leaveTypesApplicable.concat(LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(leavetypeCode)+",");
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.print(e);
	 		}
		  }
		 
		  
	 	
			  
	  }
	  
	 
		  
	  
			
  
  %> 
  
        <tr>
        		<portlet:actionURL var="editLeavePolicyURL" name="editLeavePolicy">
				<portlet:param name="PolicyID" value="<%=String.valueOf(leavePolicy.getPolicyId()) %>"/>
				</portlet:actionURL>
				
				<portlet:actionURL var="deleteLeavePolicyURL" name="deleteLeavePolicy">
				<portlet:param name="PolicyIDtoDelete" value="<%=String.valueOf(leavePolicy.getPolicyId()) %>"/>
				</portlet:actionURL>
        
        
      			<td><%= LMSProjectDetailsLocalServiceUtil.getProjectNameByprojectCode(leavePolicy.getProject()).getProjectName() %></td>
      			
      			
      			<td><%=leaveTypesApplicable %></td>
      			<td><%=leavePolicy.getLocationsApplicable() %></td>
      			<td>
      			<liferay-ui:icon iconCssClass="icon-edit actionIcon" message="Edit" url="<%= editLeavePolicyURL %>" />
   				  <liferay-ui:icon iconCssClass="icon-trash actionIcon" message="Delete" url="<%=deleteLeavePolicyURL %>" />
     </td>
      </tr>
      <%}
      %>
    </tbody>
</table>
</div>
<script>
$(document).ready(function(){
	
	//$('#mainContent').hide();
    var table= $('#leavePolicy').DataTable({
    	"iDisplayLength": 5,
    	"bSort" : false,
    	"bSort":false,
   	 	"columnDefs": [
                       {"className": "dt-center", "targets": "_all"}
                       
                   ],
    	
    });
});
</script>