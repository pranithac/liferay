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

<portlet:actionURL var="addLeavePolicy" name="addLeavePolicy"></portlet:actionURL>

  <%List<LMSEmployeeDetails> empLocations = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeLocations();%>
<% 
List<LMSLeaveType> LeaveTypes = LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypes(0, LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount());

List<LMSProjectDetails> projDetails = LMSProjectDetailsLocalServiceUtil.getLMSProjectDetailses(0,LMSProjectDetailsLocalServiceUtil.getLMSProjectDetailsesCount());
List<LMSProjectDetails> uniqueProjs = new ArrayList<LMSProjectDetails>();


int size= (projDetails.size())-1;
for(int m=0;m<projDetails.size();m++){
	
	uniqueProjs.add(projDetails.get(m));
}
for(int k=0;k<size;k++){
	for(int j=k+1;j<projDetails.size();j++){	
		
	
if(((projDetails.get(j).getProjectCode().equalsIgnoreCase(projDetails.get(k).getProjectCode())))){
	uniqueProjs.remove(projDetails.get(j));
}	
	
}
}
%>
<h1 style="color:teal;font-size: 20px;">Add Leave Policy</h1>

<div id="mainContent">
<div id="fieldRequired">This field is required.</div>
<aui:form action="${addLeavePolicy}" method="post" id="AddLeavePolicy" name="AddLeavePolicy" >
<aui:row>
<aui:column cssClass="span6">
<aui:select id="project" name="project" inlineLabel="true" label="Select Project<span style='color: red;'>*</span>">
<%for(int j=0;j<uniqueProjs.size();j++){%>
<option value='<%=uniqueProjs.get(j).getProjectCode()%>'><%=uniqueProjs.get(j).getProjectName() %></option>
<%}%>
</aui:select>
 </aui:column>

</aui:row>
<aui:row>
 <aui:column cssClass="span6">
<aui:select id="leaveTypes" name="leaveTypes" inlineLabel="true" label="Select Applicable Leave Types<span style='color: red;'>*</span>" multiple="true" size="10" helpMessage="Press Ctrl to select multiple leave types">
<%for(int j=0;j<LeaveTypes.size();j++){%>
<option value='<%=LeaveTypes.get(j).getLeaveTypeCode()%>'><%=LeaveTypes.get(j).getLeaveTypeName() %></option>
<%}%>
</aui:select>
</aui:column>
<aui:column cssClass="span6">
<aui:select id="holidays" name="holidays" inlineLabel="true" label="Select Applicable Holidays<span style='color: red;'>*</span>" multiple="true" size="10" helpMessage="Press Ctrl to select multiple holidays">
<%for(int j=0;j<empLocations.size();j++){
if(empLocations.get(j)!=null){%>
<option value='<%=empLocations.get(j)%>'><%=empLocations.get(j)%></option>
<%}}%>
</aui:select>
</aui:column>
</aui:row>

<br/><br/>
<div>
<aui:button type="button" name="submit" value="Save" cssClass="btn btn-primary" onClick="checkValidation();"/>
<aui:button type="reset" name="cancel" value="Cancel" cssClass="btn btn-primary"/>
</div>
</aui:form>
</div>
<!-- Validating  all fields in AddLeavePolicy JSP -->

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
	 document.forms["<portlet:namespace />AddLeavePolicy"].submit();
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
