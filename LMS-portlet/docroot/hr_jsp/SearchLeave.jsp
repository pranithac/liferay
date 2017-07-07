


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="com.trianz.lms.controller.*" %>
<%@ page import="java.util.*" %>
<jsp:include page="/jsp/Navigation.jsp" />

<%@ page import="java.text.SimpleDateFormat" %>


<portlet:actionURL var="hrGetEmployeeLeaveInformationURL" name="hrGetEmployeeLeaveInformation">

</portlet:actionURL>

<portlet:resourceURL var="getEmployeeNamesURL">
<portlet:param name="GetSubList" value="AutoComplete"/>
</portlet:resourceURL>

<script>
$(document).ready(function(){
	
	// getEmployeeNames();
	<%if((request.getParameter("showEditPage"))==null){%>
	$('#editLeaveForm').css("display","none");
	 $("#editLeaveForm").remove();
	<%}else{%>
	$('#editLeaveForm').css("display","block");
	<%}%>
	
	$('#showMessage').hide();
	var msg = $('#<portlet:namespace />MessgetoCkeck').val();
	if(msg=="Not a approved request")
		{
			$('#showMessage').show();
		}
	else
		{
			$('#showMessage').hide();
		}
	
	


	



});

</script>


<aui:script>
	AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) {
	var testData;
	new A.AutoCompleteList({
	allowBrowserAutocomplete: 'true',
	activateFirstItem: 'true',
	inputNode: '#<portlet:namespace />EmployeeName',
	resultTextLocator:'employeeNames',
	render: 'true',
	resultHighlighter: 'phraseMatch',
	resultFilters:['phraseMatch'],
	source:function(){
	var inputValue=A.one("#<portlet:namespace />EmployeeName").get('value');
	var myAjaxRequest=A.io.request('${getEmployeeNamesURL}',{
	dataType: 'json',
	method:'POST',
	data:{
	<portlet:namespace />EmployeeName:inputValue,
	},
	autoLoad:false,
	sync:false,
	on: {
	success:function(){
	var data=this.get('responseData');
	testData=data;
	}}
	});
	myAjaxRequest.start();
	return testData;},
	});
	});
	</aui:script>


<h1 style="color:teal;font-size: 20px;">Search to Cancel/Edit Leave Request</h1>
<div id="leaveSearch">
<aui:form name="searchLr" method="post" action="${hrGetEmployeeLeaveInformationURL}">




<aui:row>
<aui:input type="text" label="Enter the Leave Request ID" name="LeaveReqNo" inlineLabel="true" inlineField="true"/> 
<aui:button type="submit" value="Search" name="submit" />
</aui:row>
<aui:row>
<aui:input type="text" label="Enter  the  Employee ID" name="EmployeeID" inlineLabel="true" inlineField="true"/> 
<aui:button type="submit" value="Search" name="submit" />
</aui:row>
<aui:row>
<aui:input type="text" label="Enter the Employee Name" name="EmployeeName" inlineLabel="true" inlineField="true" /> 
<aui:button type="submit" value="Search" name="submit" />
</aui:row>
<div id="showMessage" class="alert alert-warning">You can only edit leaves which are approved. This request is still pending. Notify employee to cancel this leave and reapply.</div>
<aui:input  name="MessgetoCkeck" type="hidden" value='<%= request.getParameter("notificationMsg")%>'></aui:input>
</aui:form>
<hr>
<%-- <div id="editLeaveForm">
<jsp:include page="/hr_jsp/HREditLeave.jsp" />
</div> --%>
</div>