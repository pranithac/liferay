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
<jsp:include page="/jsp/Navigation.jsp" />
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> 

<portlet:defineObjects />



<portlet:actionURL var="applyLeave" name="applyLeave">
<portlet:param name="LeaveReqNo" value=""/>
<portlet:param name="isDraft" value="N"/>
</portlet:actionURL>
<portlet:actionURL var="DraftURL" name="applyLeave">
<portlet:param name="LeaveReqNo" value=""/>
<portlet:param name="isDraft" value="Y"/>
</portlet:actionURL>

<portlet:resourceURL var="getLeaveCategoryUrl">
<portlet:param name="GetSubList" value="Categories"/>
</portlet:resourceURL>
<portlet:resourceURL var="getLeavetypesURL">
<portlet:param name="GetSubList" value="LeaveTypes"/>
</portlet:resourceURL>
<%-- <portlet:resourceURL var="getLeaveReasonUrl">
<portlet:param name="GetSubList" value="Reasons"/>
</portlet:resourceURL> --%>
<portlet:resourceURL var="getProjectDetailsUrl">
<portlet:param name="GetSubList" value="Project"/>
</portlet:resourceURL>
<portlet:resourceURL var="getApproverUrl">
<portlet:param name="GetSubList" value="Approver"/>
</portlet:resourceURL>
<portlet:resourceURL var="calculateDurationUrl">
<portlet:param name="GetSubList" value="Duration"/>
</portlet:resourceURL>




<script>
$(document).ready(function(){
	
	getLeaveTypes();
	$('#fieldRequired').hide();
	$('#ELError').hide();
	$('#CLError').hide();
	$('#comOffError').hide();
	/* getProjectDetails(); */
		$('#startdateValidationMsg').hide();
		$('#enddateValidationMsg').hide();
	
});
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
	if(StartDate1!=""){
		 $('#startdateValidationMsg').hide();
		
	}
	if(EndDate1!=""){
		 $('#enddateValidationMsg').hide();
		
	}
	if((EndDate1!="")&&(StartDate1!="")){
	
		durationButton();
	}
	
}
function checkifSelected()
{
	
	var abType= $('#<portlet:namespace />absenceType').val();
	if((abType!='select')&&(abType!="")){
		//alert('inside if==');
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
	}
	
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
	console.log('getting leave categories');
	 $.ajax({
         url: '${getLeaveCategoryUrl}',
         data: {
      	   <portlet:namespace />leaveType:val,
         },
         type: "get",
         success: function(data){
        	 $('#<portlet:namespace />absenceCategory').html('');
             $('#<portlet:namespace />absenceCategory').val(data);
         }
       });
	 
}




/**********************************Implementing jQuery Ajax Calls********************************************/

 
 
 
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
 
function durationButton(){
	console.log('getting duration');
	 $.ajax({
         url: '${calculateDurationUrl}',
         type: "get",
         data: {
        	 <portlet:namespace />LeaveType:$('#<portlet:namespace />absenceType').find(":selected").val(),
      	   <portlet:namespace />startDate:$('#<portlet:namespace />startDate').val(),
      	   <portlet:namespace />endDate:$('#<portlet:namespace />endDate').val(),
         },
         success: function(data){
        		var res =data;
                //	alert(res);
                		var errMsg =res+"";
                		//alert($("input[name=<portlet:namespace />day]:checked").val());
                	   var daySelect=$('input[name=<portlet:namespace />day]:checked').val();
                	   //alert("day select "+daySelect);
                	   
                	   if('Insufficient EL Balance' === errMsg.trim()){
             		
             			//alert("Insufficient EL Balance!!!!!!!");
             			//alert("Showing message");
             			$('#CLError').hide();
             			$('#comOffError').hide();
             			$('#ELError').show();
             			 $('#<portlet:namespace/>total').val("");
             			
             		}
             		else if('Insufficient CompOff Balance' === errMsg.trim()){
             		
             			//alert("Insufficient CL Balance!!!!!!!");
             			$('#ELError').hide();
             			$('#comOffError').show();
             			$('#CLError').hide();
             			 $('#<portlet:namespace/>total').val("");
             			
             		}
                	   
             		else if('Insufficient CL Balance' === errMsg.trim())
             				{
             					$('#comOffError').hide();
             					$('#ELError').hide();
                     			$('#CLError').show();
                     			 $('#<portlet:namespace/>total').val("");
             			
             				}
             		else{
             			$('#comOffError').hide();
             			$('#ELError').hide();
             			$('#CLError').hide();
             			
             		$('#<portlet:namespace />total').html('');
             		
             		var days = parseInt(res);
             		//alert("duration from controller" +days);
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
             	    //$('#<portlet:namespace/>total').val(total);
								//alert("Total "+total);
             	  
             		}
         }
       });
	 
	 
	
}
 
 /******************End of jQuery Ajax Calls************************************************/


 
 
 
 

function saveAsDraft(){
	
	var url = '<%=DraftURL.toString()%>';
    document.forms["<portlet:namespace />ApplyLeave"].action=url;
    document.forms["<portlet:namespace />ApplyLeave"].submit();
   
	
}


function clearCalendar(){
	$('#<portlet:namespace />startDate').datepicker('option', 'maxDate', null );
	$('#<portlet:namespace />endDate').datepicker('option', 'minDate', null );
}


function checkValidation(){
  var rtnvalue=true;
	var abType= $('#<portlet:namespace />absenceType').val();
	var startDate =$('#<portlet:namespace />startDate').val();
	var endDate =$('#<portlet:namespace />endDate').val();
	var project = $('#<portlet:namespace />projectName').val();
	
	//alert("abType" +abType +"startDate"+startDate +"endDate"+endDate +"project"+project);
	
	if((abType=='select')||(abType=="")){
		
		//alert('no absence type');
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />absenceType').after('<div id="fieldRequired">**This field is required.</div>');
		//event.preventDefault();
		rtnvalue=false;
		return rtnvalue;
		
	}
if(startDate==""){
	//alert('no start date');
	/* if($('#fieldRequired')){
		$('#fieldRequired').remove();
	} */
	$('#startdateValidationMsg').show();
	//event.preventDefault();
	rtnvalue=false;
	return rtnvalue;
	}
if(endDate==""){
	//alert('no end date');
	/* if($('#fieldRequired')){
		$('#fieldRequired').remove();
	} */
	$('#enddateValidationMsg').show();
	//event.preventDefault();
	rtnvalue=false;
	return rtnvalue;
}
if((project=='select')||(project=="")){
	//alert('no project type');
	if($('#fieldRequired')){
		$('#fieldRequired').remove();
	}
	
	$('#<portlet:namespace />projectName').after('<div id="fieldRequired">**This field is required.</div>');
	//event.preventDefault();
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
	
		disableScreen();
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

<!-- <style>
.ui-datepicker-trigger{

    position: absolute;
    }
    #startdateValidationMsg,#enddateValidationMsg
    {
    position: relative;
    top: -18px;
    }
</style> -->




<div id="mainContent">
<div id="fieldRequired">This field is required.</div>


<div id="CLError" class="alert alert-danger">You have insufficient contingency leave balance. Please reduce duration.</div>
<div id="ELError" class="alert alert-danger">You have insufficient earned leave balance. Please reduce duration.</div>
<div id="comOffError" class="alert alert-danger">You have insufficient CompOff leave balance. Please reduce duration.</div>
<aui:form action="${applyLeave}" method="post" id="applyLeave" name="ApplyLeave" >
<aui:fieldset>
<aui:row>
<%-- <aui:input type="text" name="absenceStatus" value="Confirmed" label="Absence Status" readonly="true"/> --%>

<aui:column cssClass="span6">
<aui:select name="absenceType" id="absenceType" label="Absence Type<span style='color: red;'>*</span>" onChange="getSubLists(this.value);" onClick="checkifSelected();">

</aui:select>
</aui:column>
<aui:column  cssClass="span6"><aui:input type="text" name="absenceCategory" id="absenceCategory" label="Absence Category" readonly="true"/></aui:column>
</aui:row>
<aui:row>


<%-- <aui:column cssClass="span6"><aui:select name="absenceReason" id="absenceReason" label="Absence Reason"/></aui:column> --%>


</aui:row>
</aui:fieldset>
<aui:fieldset>
<aui:row>
<aui:column cssClass="span6">
<aui:input type = "text" label="Start Date<span style='color: red;'>*</span>" name="startDate" id="startDate" onkeydown="return false;" readonly="true" onChange="callDuration();" ></aui:input>
 <div id="startdateValidationMsg" >**This field is required.</div>
 </aui:column>
 <aui:column cssClass="span6">
<aui:input  type = "text" label="End Date<span style='color: red;'>*</span>" name="endDate" id="endDate"  onkeydown="return false;" readonly="true" onChange="callDuration();" ></aui:input>
<div id="enddateValidationMsg" >**This field is required.</div>
</aui:column>
</aui:row>
<aui:row><aui:column cssClass="span6">

<aui:input  type="radio" name="day" value="halfDay" label="Half Day" onChange="changeDuration();"/>
<aui:input type="radio" name="day"  checked="<%= true %>" value="fullDay" label="Full Day" onChange="changeDuration();" />
</aui:column>


<aui:column cssClass="span6"><aui:input type="text" label="Duration(In Days)" name="total" id="total" readonly="true" value="0"/></aui:column>
</aui:row>
<aui:row>


</aui:row>
</aui:fieldset>


<div id="comments">
<aui:fieldset label="Comments">
<aui:input type="textarea" name="comments" maxlength="200" placeholder="Enter only 200 characters"/>

</aui:fieldset ></div>
<aui:button-row>


<%-- <aui:button type="button" name="submit" value="Apply" onClick='duration();' cssClass="btn btn-primary" /> --%>
<aui:button type="button" name="submit" value="Apply" cssClass="btn btn-primary" onClick="checkValidation();"/>
<aui:button type="button" name="save" value="Save For Later" onClick="saveAsDraft();disableScreen(); " cssClass="btn btn-primary"/>
<aui:button type="reset" name="cancel" value="Cancel" cssClass="btn btn-primary" onClick="clearCalendar();"/>
</aui:button-row>

</aui:form>


</div>



<script>


function disableScreen() {
    // creates <div class="overlay"></div> and 
    // adds it to the DOM
    var div= document.createElement("div");
    div.className += "overlay";
    document.body.appendChild(div);
    
}

</script>
   















