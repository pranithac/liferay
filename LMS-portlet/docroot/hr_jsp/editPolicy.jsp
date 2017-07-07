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


<% 

int PolicyId = Integer.parseInt(request.getParameter("PolicyIdtoeditJsp"));
LMSLeavePolicies leavePolicy = LMSLeavePoliciesLocalServiceUtil.getLMSLeavePolicies(PolicyId);
List<String> leavetypesApplicable = new ArrayList<String>();
List<String> locationsApplicable = new ArrayList<String>();

	leavetypesApplicable.addAll(Arrays.asList(leavePolicy.getLeaveTypesApplicable().split(",")));
	locationsApplicable.addAll(Arrays.asList(leavePolicy.getLocationsApplicable().split(",")));



List<LMSLeaveType>leaveTypestoselect=new ArrayList<LMSLeaveType>();
for(String leavecodeStr :leavetypesApplicable)
{
	try
	{
	int leaveTypeCode = Integer.parseInt(leavecodeStr);
	leaveTypestoselect.add(LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(leaveTypeCode));
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
	
}

List<LMSLeaveType> LeaveTypes = LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypes(0, LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount());


List<LMSEmployeeDetails> empLocations = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeLocations();




%>

<portlet:actionURL  name="updateLeavePolicy" var="updateLeavePolicy">
<portlet:param name="PolicyId" value="<%= String.valueOf(leavePolicy.getPolicyId()) %>"/>
</portlet:actionURL>

<div id="mainContent">
<div id="fieldRequired">This field is required.</div>
<aui:form action="<%=updateLeavePolicy%>" method="post" name="updatePolicy" id="updatePolicy" >
<aui:row>
<aui:column cssClass="span6">
<aui:input id="project" name="project" inlineLabel="true" label="Select Project<span style='color: red;'>*</span>" value="<%=LMSProjectDetailsLocalServiceUtil.getProjectNameByprojectCode(leavePolicy.getProject()).getProjectName() %>">
</aui:input>


 </aui:column>

</aui:row>
<aui:row>
 <aui:column cssClass="span6">
<aui:select id="leaveTypes" name="leaveTypes" inlineLabel="true" label="Select Applicable Leave Types<span style='color: red;'>*</span>" multiple="true" size="10" helpMessage="Press Ctrl to select multiple leave types">
<%for(int j=0;j<LeaveTypes.size();j++){
	int count=0;
	for(LMSLeaveType leavetype : leaveTypestoselect)
	{
		if(leavetype.getLeaveTypeCode()==LeaveTypes.get(j).getLeaveTypeCode()){
			count++;
		}
	}
	if(count>0)
	{
	%>
	<option value='<%=LeaveTypes.get(j).getLeaveTypeCode()%>' selected="selected"><%=LeaveTypes.get(j).getLeaveTypeName() %></option>
	<%}
	else
	{
%>

<option value='<%=LeaveTypes.get(j).getLeaveTypeCode()%>'><%=LeaveTypes.get(j).getLeaveTypeName() %></option>
<%}
}%>
</aui:select>
</aui:column>
<aui:column cssClass="span6">
<aui:select id="holidays" name="holidays" inlineLabel="true" label="Select Applicable Holidays<span style='color: red;'>*</span>" multiple="true" size="10" helpMessage="Press Ctrl to select multiple holidays">
<%for(int j=0;j<empLocations.size();j++){
if(locationsApplicable.contains(String.valueOf(empLocations.get(j))))
{
%>
<option value='<%=empLocations.get(j)%>' selected="selected"><%= empLocations.get(j) %></option>
<%}else
	{%>
<option value='<%=empLocations.get(j)%>' ><%= empLocations.get(j) %></option>
<%}
}%>
</aui:select>
</aui:column>
</aui:row>

<br/><br/>
<div> 
<aui:button type="button" name="submit" value="Save" cssClass="btn btn-primary" onClick="checkValidation();"/>
<aui:button type="reset" name="cancel" cssClass="btn btn-primary" value="Cancel"/>
</div>
</aui:form>
</div>
<script>

$(document).ready(function(){
	
	$('#fieldRequired').hide();
	
});

function checkValidation(){
	
 	 var rtnvalue=true;
 
	var projectv= $('#<portlet:namespace />project').val();
	var leaveType = $('#<portlet:namespace />leaveTypes > option:selected');
	var holidaysv = $('#<portlet:namespace />holidays > option:selected');
	
	if(leaveType.length==0){
		
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />leaveTypes').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
		
	}
	
	if(holidaysv.length==0){
		
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />holidays').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
		
	}
	
if((projectv=='select')||(projectv=="")){
	
	if($('#fieldRequired')){
		$('#fieldRequired').remove();
	}
	
	$('#<portlet:namespace />project').after('<div id="fieldRequired">**This field is required.</div>');
	
	rtnvalue=false;
	return rtnvalue;
}


if(rtnvalue){
	
	disableScreen();
	 document.forms["<portlet:namespace />updatePolicy"].submit();
}

return rtnvalue;
	
} 

function disableScreen() {
    // creates <div class="overlay"></div> and 
    // adds it to the DOM
    var div= document.createElement("div");
    div.className += "overlay";
    document.body.appendChild(div);
    
}
</script>
