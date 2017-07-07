<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="com.trianz.lms.controller.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<jsp:include page="/jsp/Navigation.jsp" />


<portlet:defineObjects />

<portlet:actionURL var="hrUpdateLeaveURL" name="hrUpdateLeave" >
<portlet:param name="LeaveReqNo" value='<%=request.getParameter("LeaveReqNumber") %>'/>
</portlet:actionURL>
<portlet:actionURL var="cancelLeaveURL" name="hrcancelLeave">
<portlet:param name="LeaveReqNo" value='<%=request.getParameter("LeaveReqNumber") %>'/>
</portlet:actionURL>
<portlet:resourceURL var="getLeaveCategoryUrl">
<portlet:param name="GetSubList" value="Categories"/>
</portlet:resourceURL>
<%-- <portlet:resourceURL var="getLeaveReasonUrl">
<portlet:param name="GetSubList" value="Reasons"/>
</portlet:resourceURL> --%>
<portlet:resourceURL var="getProjectDetailsUrl">
<portlet:param name="GetSubList" value="HRProjects"/>
<portlet:param name="employeeId" value='<%=request.getParameter("ReqEmployeeID") %>'/>
</portlet:resourceURL>
<portlet:resourceURL var="getApproverUrl">
<portlet:param name="GetSubList" value="HRapprover"/>
<portlet:param name="employeeId" value='<%=request.getParameter("ReqEmployeeID") %>'/>
</portlet:resourceURL>
<portlet:resourceURL var="calculateDurationUrl">
<portlet:param name="GetSubList" value="Duration"/>
<portlet:param name="LeaveReqNo" value='<%=request.getParameter("LeaveReqNumber") %>'/>
</portlet:resourceURL>
<portlet:resourceURL var="getLeavetypesURL">
<portlet:param name="GetSubList" value="LeaveTypes"/>
<portlet:param name="LeaveReqNo" value='<%=request.getParameter("LeaveReqNumber") %>'/>
<portlet:param name="leaveTypecode" value='<%=request.getParameter("absenceTypeCode") %>'/>

</portlet:resourceURL>

<%
List<LMSLeaveType> LeaveTypes = LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypes(0, LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount());
%>


<script>


$( function() {
    $( "#<portlet:namespace />startDate" ).datepicker({
    	changeMonth: true,
    	changeYear: true,
    	 yearRange:'-5:+5',
    	 showOn:"button",
    	 buttonImage: "<%=request.getContextPath()%>/css/images/calendar.png",
    	 buttonImageOnly: true,
    	dateFormat: "yy-mm-dd",
 	onSelect: function(selectedDate) {
 		
 		
         $('#<portlet:namespace />endDate').datepicker('option', 'minDate', selectedDate );
         callDuration();
   }
    	
    });
$( "#<portlet:namespace />endDate" ).datepicker({
	changeMonth: true,
	changeYear: true,
	 yearRange:'-5:+5',
	 showOn:"button",
	 buttonImage: "<%=request.getContextPath()%>/css/images/calendar.png",
	 buttonImageOnly: true,
    	dateFormat: "yy-mm-dd",
    	
  onSelect: function(selectedDate) {
      $('#<portlet:namespace />startDate').datepicker('option', 'maxDate', selectedDate );
      callDuration();
}
    });
  } );
  
  
  
function callDuration()
{
	EndDate1 = $('#<portlet:namespace />endDate').val();
	StartDate1 = $('#<portlet:namespace />startDate').val();
	if((EndDate1!="")&&(StartDate1!="")){
	
		durationButton();
	}
	
}

function getLeaveTypes(){
	console.log('getting leave types');
	 $.ajax({
         url: '${getLeavetypesURL}',
         type: "get",
         success: function(data){
        	 $('#<portlet:namespace />absenceType').html('');
             $('#<portlet:namespace />absenceType').append(data);
         }
       });
	 
	
}
function getSubLists(val){
	
	$('#<portlet:namespace />total').val('');
	getAbsenceCategories(val);
	//getAbsenceReasons(val);
	EndDate = $('#<portlet:namespace />endDate').val();
	StartDate = $('#<portlet:namespace />startDate').val();
	if((EndDate!="")&&(StartDate!="")){
	
		durationButton();
	}
	
	
}
function getAbsenceCategories(val){
	 AUI().use('aui-io-request', function(A){
	        A.io.request('${getLeaveCategoryUrl}', {
	               method: 'post',
	               data: {
	            	   <portlet:namespace />leaveType:val,
	               },
	               on: {
	                   	success: function() {
	                      $('#<portlet:namespace />absenceCategory').html('');
	                        $('#<portlet:namespace />absenceCategory').val(this.get('responseData'));
	                    }
	              }
	        });
	    });
}


$(document).ready(function(){
		getProjectDetails();
		
		$('#fieldRequired').hide();
		$('#ELError').hide();
		$('#CLError').hide();
		$('#comOffError').hide();
		getLeaveTypes();
		
});
function getProjectDetails(){
	 AUI().use('aui-io-request', function(A){
	        A.io.request('${getProjectDetailsUrl}', {
	               method: 'post',
	              
	               on: {
	                   	success: function() {
	                   		
	                   		
	                   		$('#<portlet:namespace />projectName').html('');
	                        $('#<portlet:namespace />projectName').append(this.get('responseData'));
	                    }
	              }
	        });
	    });
}
function getApprover(){
	AUI().use('aui-io-request', function(A){
        A.io.request('${getApproverUrl}', {
               method: 'post',
              data: {
            	   <portlet:namespace />projName:$('#<portlet:namespace />projectName').find(":selected").val(),
               }, 
               on: {
                   	success: function() {
                   		
                   	
                   		$('#<portlet:namespace />approver').html('');
                        $('#<portlet:namespace />approver').val(this.get('responseData'));
                    }
              }
        });
    });
	
	
}
<%-- function saveAsDraft(){
	
	var url = '<%=DraftURL.toString()%>';
    document.forms["<portlet:namespace />ApplyLeave"].action=url;
    document.forms["<portlet:namespace />ApplyLeave"].submit();
   
	
} --%>

function durationButton(){
	
	
	AUI().use('aui-io-request', function(A){
        A.io.request('${calculateDurationUrl}', {
               method: 'post',
              data: {
            	  <portlet:namespace />LeaveType:$('#<portlet:namespace />absenceType').find(":selected").val(),
            	   <portlet:namespace />startDate:$('#<portlet:namespace />startDate').val(),
            	   <portlet:namespace />endDate:$('#<portlet:namespace />endDate').val(),
            	   
               }, 
               on: {
                   	success: function() {
                   		var res = this.get('responseData');
                   		
                  
                   		var errMsg =res+"";
                   		
                   	   var daySelect=$('input[name=<portlet:namespace />day]:checked').val();
                   	  
                   	   
                   	   if('Insufficient EL Balance' === errMsg.trim()){
                		
                			
                			$('#CLError').hide();
                			$('#ELError').show();
                			$('#comOffError').hide();
                			
                		}
                   	   
                   	else if('Insufficient CompOff Balance' === errMsg.trim()){
                		
            			
            			$('#ELError').hide();
            			$('#comOffError').show();
            			$('#CLError').hide();
            			
            		}
                		else if('Insufficient CL Balance' === errMsg.trim()){
                		
                			
                			$('#ELError').hide();
                			$('#CLError').show();
                			$('#comOffError').hide();
                		}
                		else{
                			
                			$('#ELError').hide();
                			$('#CLError').hide();
                			
                		$('#<portlet:namespace />total').html('');
                		
                		var days = parseInt(res);
                	
                		var total;

                	    if(daySelect==='fullDay'){
                		  
                		   total=days;
                		   $('#<portlet:namespace/>total').val(total);
                		   }
                		    else if(daySelect==='halfDay'){
                		    days =days-0.5;
                		    total=days;
                		   $('#<portlet:namespace/>total').val(total);
                		   }
                	   
                		}
              
                   	}
              }
        });
    });
	
}

function checkValidation(){
  var rtnvalue=true;
	var abType= $('#<portlet:namespace />absenceType').val();
	var startDate =$('#<portlet:namespace />startDate').val();
	var endDate =$('#<portlet:namespace />endDate').val();
	var project = $('#<portlet:namespace />projectName').val();
	
	
	
	if((abType=='select')||(abType=="")){
		
		
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />absenceType').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
		
	}
if(startDate==""){

	if($('#fieldRequired')){
		$('#fieldRequired').remove();
	}
	
	$('#<portlet:namespace />startDate').after('<div id="fieldRequired">**This field is required.</div>');
	
	rtnvalue=false;
	return rtnvalue;
	}
if(endDate==""){

	if($('#fieldRequired')){
		$('#fieldRequired').remove();
	}
	
	$('#<portlet:namespace />endDate').after('<div id="fieldRequired">**This field is required.</div>');
	
	rtnvalue=false;
	return rtnvalue;
}
if((project=='select')||(project=="")){
	
	if($('#fieldRequired')){
		$('#fieldRequired').remove();
	}
	
	$('#<portlet:namespace />projectName').after('<div id="fieldRequired">**This field is required.</div>');
	
	rtnvalue=false;
	return rtnvalue;
}

if($('#<portlet:namespace/>total').val()==0)
{
if($('#fieldRequired')){
	$('#fieldRequired').remove();
}

$('#<portlet:namespace />total').after('<div id="fieldRequired">**Duration cannot be Zero.You cannot select Weekends/Holidays as leave apply date.</div>');
	rtnvalue=false;
	return rtnvalue;
}

if(rtnvalue){
	
	 document.forms["<portlet:namespace />ApplyLeave"].submit();
}
//rtnvalue=true;
return rtnvalue;
	
	} 
	
function changeDuration(){
	EndDate = $('#<portlet:namespace />endDate').val();
	StartDate = $('#<portlet:namespace />startDate').val();
	if((EndDate!="")&&(StartDate!="")){
	
		durationButton();
	}
	
}
</script>


<div id="mainContent">
<div id="fieldRequired">This field is required.</div>




<div id="CLError" class="alert alert-danger">You have insufficient contingency leave balance. Please reduce duration.</div>
<div id="ELError" class="alert alert-danger">You have insufficient earned leave balance. Please reduce duration.</div>
<div id="comOffError" class="alert alert-danger">You have insufficient CompOff leave balance. Please reduce duration.</div>
<aui:form action="<%=hrUpdateLeaveURL %>" method="post" id="applyLeave" name="ApplyLeave" >
<aui:fieldset>
<aui:row>
<%-- <aui:input type="text" name="absenceStatus" value="Confirmed" label="Absence Status" readonly="true"/> --%>

<aui:column cssClass="span6">
<aui:select name="absenceType" id="absenceType" label="Absence Type" onChange="getSubLists(this.value);">
</aui:select>
</aui:column>
<aui:column  cssClass="span6"><aui:input type="text" name="absenceCategory" id="absenceCategory" label="Absence Category" readonly="true"/></aui:column>
</aui:row>
<%-- <aui:row>


<aui:column cssClass="span6"><aui:select name="absenceReason" id="absenceReason" label="Absence Reason"/></aui:column>


</aui:row> --%>
</aui:fieldset>
<aui:fieldset>
<aui:row>
<aui:column cssClass="span6">
<%if((request.getParameter("startDatetoSet"))!=null){ %>
<aui:input type = "text" label="Start Date" name="startDate" id="startDate"  value='<%=request.getParameter("startDatetoSet") %>' readonly="true"></aui:input>
 
 <%}else{ %>
 <aui:input type = "text" label="Start Date" name="startDate" id="startDate"  onkeydown="return false;"  readonly="true"></aui:input>
 <%} %>
 </aui:column>
 <aui:column cssClass="span6">
<%if((request.getParameter("endDatetoSet"))!=null){ %>
<aui:input type = "text" label="End Date" name="endDate" id="endDate" onChange="getStartdate();" value='<%=request.getParameter("endDatetoSet") %>' readonly="true" ></aui:input>
 
 <%}else{ %>
 <aui:input type = "text" label="End Date" name="endDate" id="endDate" onChange="getStartdate();"  readonly="true"></aui:input>
 <%} %>
</aui:column>


</aui:row>
<aui:row><aui:column cssClass="span6">

<aui:input  type="radio" name="day" value="halfDay" label="Half Day" onChange="changeDuration();"/>
<aui:input type="radio" name="day"  checked="<%= true %>" value="fullDay" label="Full Day" onChange="changeDuration();" />
</aui:column>
	<aui:column cssClass="span6"><aui:input type="text" label="Duration(In Days)" name="total" id="total" readonly="true" value="0"/></aui:column>
</aui:row>

</aui:fieldset>

<%-- <aui:fieldset>
<aui:row >
<aui:column cssClass="span6">
<aui:select name="project" label="Project" id="projectName" onChange="getApprover();" />
</aui:column>
<aui:column cssClass="span6">
<aui:input type="text" name="approver" id="approver" label="Approver" readonly="true" value='<%=request.getParameter("approver") %>'/>
</aui:column>
</aui:row>
</aui:fieldset> --%>

<div id="comments">
<aui:fieldset label="Comments">
<aui:input type="textarea" name="CancelComments" value='<%=request.getParameter("comments") %>' maxlength="200" placeholder="Enter only 200 characters"/>

</aui:fieldset></div>
<aui:button-row>
<aui:button type="cancel" name="cancel" value="Cancel Request" onClick="<%=cancelLeaveURL%>"/>


<aui:button type="button" name="submit" value="Update Request" cssClass="btn btn-primary" onClick="checkValidation();" />
</aui:button-row>

</aui:form>

</div>






















