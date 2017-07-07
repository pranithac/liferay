<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css//jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js" type="text/javascript"></script>


<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

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





<portlet:defineObjects/>

<!-- 
<script>

$(document).ready(function() {
	$("#leaveNavList").navgoco({accordion: true});
	$('#leaveNav').find('a').each(function() {
		
		if ($(this).attr('href') === ($(location).attr("href"))) {

			$(this).css("color", "red");
			

		}

	}

	);
});
</script>  -->
<%ThemeDisplay themeDisplay  = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
String emailId = themeDisplay.getUser().getEmailAddress();
%>

<%List<LMSProjectDetails> projectsList=LMSProjectDetailsLocalServiceUtil.getLMSProjectDetailses(0,LMSProjectDetailsLocalServiceUtil.getLMSProjectDetailsesCount());
List<LMSEmployeeDetails> employeeList = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetailses(0, LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetailsesCount());
List<String> userList = new ArrayList<String>();


int projSize = projectsList.size();
int empSize = employeeList.size();
for(int i=0;i<projSize;i++){
	
	userList.add(projectsList.get(i).getApproverEmail().toLowerCase());

	
}

for(int j=0;j<empSize;j++){
	
	userList.add(employeeList.get(j).getSupervisorEmail().toLowerCase());	
	
}

HashSet<String> uniqueUsers=new HashSet<String>();
uniqueUsers.addAll(userList);
userList.clear();
userList.addAll(uniqueUsers);
%>      

<portlet:renderURL var="applyLeave">
<portlet:param name="jspPage" value="/jsp/ApplyLeave.jsp" />
</portlet:renderURL>
<portlet:renderURL var="leaveBalances">
<portlet:param name="jspPage" value="/jsp/CheckLeave.jsp" />
</portlet:renderURL>
<portlet:renderURL var="leaveHistory">
<portlet:param name="jspPage" value="/jsp/LeaveHistory.jsp" />
</portlet:renderURL>
<portlet:renderURL var="leaveRequests">
<portlet:param name="jspPage" value="/jsp/AllProjectRequests.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewLeaveTypes">
    <portlet:param name="jspPage" value="/hr_jsp/LeaveTypeList.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addLeaveTypes">
    <portlet:param name="jspPage" value="/hr_jsp/AddLeaveDef.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewHolidayList">
    <portlet:param name="jspPage" value="/hr_jsp/HolidaysView.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addHoliday">
    <portlet:param name="jspPage" value="/hr_jsp/AddHoliday.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editLeaveRequest">
    <portlet:param name="jspPage" value="/hr_jsp/SearchLeave.jsp" />
</portlet:renderURL>

<portlet:renderURL var="compOffRequest">
<portlet:param name="jspPage" value="/jsp/compOff.jsp" />
</portlet:renderURL>

<portlet:renderURL var="compOffApproval">
<portlet:param name="jspPage" value="/jsp/compoffApproval.jsp" />
</portlet:renderURL>

<portlet:renderURL var="addLeavePolicy">
<portlet:param name="jspPage" value="/hr_jsp/AddLeavePolicy.jsp" />
</portlet:renderURL>
<portlet:renderURL var="viewLeavePolicies">
<portlet:param name="jspPage" value="/hr_jsp/ViewLeavePolicies.jsp" />
</portlet:renderURL>
<div class="leaveNav-bar">
 
<ul class="leaveNav-menu">
<li><a>Employee Self Service<span></span></a> 
<ul>
<li><a href="<%=applyLeave%>"> Apply Leave</a></li>
<li><a href="<%=leaveBalances%>">Check Leave Balances</a></li>
<li><a href="<%=leaveHistory%>">View Leave History</a></li>
<li><a href="<%=compOffRequest%>">Request Compensatory Off</a></li>
</ul>
</li>
<%if(userList.contains(emailId)){%>
<li><a>Manager Services<span></span></a>
<ul>


<li><a href="<%=leaveRequests%>">View Leave Requests</a></li>
<li><a href="<%=compOffApproval%>">View Comp Off Requests</a></li>
</ul>
</li>

<%} %>
<li><a>HR Admin Services<span></span></a> 
<ul>
<li><a href="<%=viewLeaveTypes%>">View/Edit Leave Types</a></li>
<li><a href="<%=addLeaveTypes%>">Add New Leave Type</a></li>
<li><a href="<%=viewHolidayList%>">View/Edit Holiday List</a></li>
<li><a href="<%=addHoliday%>">Add New Holiday</a></li>
<li><a href="<%=editLeaveRequest%>">Cancel/Edit Leave Request</a></li>
<li><a href="<%=addLeavePolicy%>">Add Leave Policy</a></li>
<li><a href="<%=viewLeavePolicies%>">View/Edit Leave Policies</a></li>
</ul>

</li>

</ul>
<%-- <div class = "leaveBalance">
	
	
	<%
	

	int employeeId= LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(emailId).getEmployeeId(); 
	LeaveBalance leavebal = LeaveBalanceLocalServiceUtil.getLeaveBalanceByEmpID(employeeId);
	//String effectiveDate = df.format(dateobj);
	//System.out.println("request.getParameter('message')" + request.getParameter("message"));
	
		String CLBalance = String.valueOf(leavebal.getCLBalance());
		String ELBalance = String.valueOf(leavebal.getELBalance());
	
	
	%>
	
	<aui:fieldset label="Your available leave balances">
	<aui:row>
		
			<aui:column>
				<b>Contingency</b>
			</aui:column>
			<aui:column><%=CLBalance%> days
			</aui:column>
	</aui:row>
	<aui:row>
		
			<aui:column>
				<b>Earned</b>
			</aui:column>
			<aui:column><%=ELBalance%> days
			</aui:column>
		</aui:row>
	
	</aui:fieldset>

</div> --%>

</div>



