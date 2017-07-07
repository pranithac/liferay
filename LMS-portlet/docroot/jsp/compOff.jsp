<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<jsp:include page="/jsp/Navigation.jsp" />

<portlet:defineObjects />

<portlet:actionURL var="applyCompOff" name="applyCompOff">
</portlet:actionURL>
<portlet:resourceURL var="getProjectDetailsUrl">
<portlet:param name="GetSubList" value="CompOffProject"/>
</portlet:resourceURL>
<portlet:resourceURL var="getApproverUrl">
<portlet:param name="GetSubList" value="compOffApprover"/>
</portlet:resourceURL>
<portlet:resourceURL var="validateCompOffDateUrl">
<portlet:param name="GetSubList" value="CompOffDate"/>
</portlet:resourceURL>
<link href="<%=request.getContextPath()%>/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js" type="text/javascript"></script>




<h1 style="color:teal;font-size: 20px;">Request Compensatory Off</h1>
<div id="mainContent">

<aui:form action="<%=applyCompOff%>"  method="post" id="CompOffForm" name="CompOffForm" >

<%
	String duplicateRecordExpection = String.valueOf(request.getAttribute("duplicate"));
%>

<span class="alert alert-danger" id="duplicateMsg"><%= duplicateRecordExpection%></span>


	<aui:fieldset>
			<aui:row>
					<aui:column cssClass="span6">
							<aui:input type="text" id="datepicker" label="Date Worked on :<span style='color: red;'>*</span>" name="compDate" readonly="true" onChange="validateCompOffDate();"></aui:input>
							<span id="errorCompOff" class="inValid">Please Select Valid Date</span>
					</aui:column>
				
					<aui:column  cssClass="span6">
							<span id="TimeSheetDetails">
								<span id="message"></span>
								<span class = "timesheetDetails" id="loginTime"></span>
								<span class = "timesheetDetails" id="logoutTime"></span>
								<span class = "timesheetDetails" id="totalHrs"></span>
							</span>					
					</aui:column>
			</aui:row>
					
			<aui:row>
					<aui:column cssClass="span6">
						<aui:select name="project" label="Project<span style='color: red;'>*</span>" id="projectName" required="true" showRequiredLabel="false" onChange="getApprover();" />							
						<span id="errorPorj" class="inValid">Please Select Valid Project</span>							
					</aui:column>
				
					<aui:column  cssClass="span6">
							<aui:input type="text" name="approver" id="approver" label="Approver" readonly="true" />	
							<aui:input type="text" name="approverId" id="approverId" label="" readonly="true" />			
					</aui:column>
			</aui:row>
			<aui:row>
				<div id="comments">
					<aui:fieldset label="Comments">
					<aui:input type="textarea" name="comments"/>
					</aui:fieldset >
				</div>
				
					<aui:column  cssClass="span4">
							<aui:button id="submit" type="button" name="submit" value="Request" onClick="validateProject();" cssClass="btn btn-primary " />				
					</aui:column>
			</aui:row>
	</aui:fieldset>
</aui:form>
<script>
function validateProject(){
	//alert('test');
	var approverId = $('#<portlet:namespace />approverId').val();
	var compOffDate = $('#<portlet:namespace/>datepicker').val();
	var totalHrs = $('#tHrs').text();
	console.log("approverId " + approverId + " compOffDate " + compOffDate +" totalHrs " + totalHrs);
	if((approverId!= "" && approverId!="0") && (compOffDate!= "" && totalHrs != "")){
		document.forms["<portlet:namespace />CompOffForm"].submit();
	}if(compOffDate == "" || totalHrs == ""){
		//alert('test');
		$('#errorCompOff').css("display", "block");	
	}if(approverId == "" || approverId =="0"){
		$('#errorPorj').css("display", "block");	
	}else{
		
		console.log("error in validate proj");
	}
}
function getProjectDetails(){
	 AUI().use('aui-io-request', function(A){
	        A.io.request('${getProjectDetailsUrl}', {
	               method: 'post',
	              
	               on: {
	                   	success: function() {
	                   		
	                   		//alert(this.get('responseData'));
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
                   		var responseData  = this.get('responseData');
                   		var approverName = responseData.split('=')[0];
                   		var approverId = responseData.split('=')[1];
                   		
                   		$('#<portlet:namespace />approver').html('');
                        $('#<portlet:namespace />approver').val(approverName);
                        $('#<portlet:namespace />approverId').val(approverId);
                        $("#errorPorj").css("display", "none");
                    }
              }
        });
    });
}

function validateCompOffDate(){
	var selectedDate = $('#<portlet:namespace />datepicker').val();
	if(selectedDate!=""){
		$("#errorCompOff").css("display", "none");
	}
	
	
	AUI().use('aui-io-request', function(A){
        A.io.request('${validateCompOffDateUrl}', {
               method: 'post',
              data: {
            	   <portlet:namespace />compDate:$('#<portlet:namespace />datepicker').val(),
               }, 
               on: {
                   	success: function() {
                   		var responseString = this.get('responseData');
                   		
                   		//console.log(responseString);
                   		
                   		if(responseString!=null){
                   			var responseArray = responseString.split("-");
                       		console.log(responseString.split("-"));
                       		
                       		var message = responseArray[0];
                       		var loginTime = responseArray[1];
                       		var logoutTime = responseArray[2];
                       		var totalHrs = responseArray[3];
                       		var isValid = responseArray[4];
                       		console.log("isValid " + isValid.trim() + "login time : " + loginTime);
                       	 	$('#message').html('');
                        	 $('#message').text(message+"");
                        	 $('#TimeSheetDetails').css("display", "block");	
                        	 $('#message').addClass('inValid');
                        	 $('#message').removeClass('valid');
                        	 //document.getElementById('<portlet:namespace />submit').setAttribute('disabled', 'disabled');
                            if(loginTime!=""){
                            	//console.log('in login time not empty ');
                            	$('#message').append('<br>');
                            	
                            	$('#loginTime').html('');
                            	$('#loginTime').html("<b>Login Time : </b>"+loginTime+"");
                            	$('#loginTime').append('<br>');
                            	
                           		$('#logoutTime').html('');
                           		$('#logoutTime').html("<b>Logout Time : </b>"+logoutTime+"");
                           		$('#logoutTime').append('<br>');
                           		
                           		$('#totalHrs').html('');
                                $('#totalHrs').html("<b>Total Hours worked for : </b><span id='tHrs'>"+totalHrs+"</span>");
                                $('#totalHrs').append('<br>');
                                
                                if(isValid.trim() == "true"){
                                	//alert('is valid true ');
                                	$('#message').removeClass('inValid');
                                	$('#message').addClass('valid');
                                	document.getElementById('<portlet:namespace />submit').removeAttribute('disabled');
                                }
                                
                            } if(loginTime == ""){
                            	
                            	console.log('in login time empty ');
    	                       	 $('#loginTime').html('');
    	                       	 $('#logoutTime').html('');
    	                       	 $('#totalHrs').html('');
                           		
    	                         $('#loginTime').text("");
    	                         $('#logoutTime').text("");
    	                         $('#totalHrs').text("");
                            }
                  			
                   		}
                   		
                    }
              }
        });
    });
}


$(document).ready(function(){
	getProjectDetails();
	$( "#<portlet:namespace />datepicker" ).datepicker({
		changeMonth: true,
		changeYear: true,
		 yearRange:'-10:',
    	 showOn:"button",
         buttonImage: "<%=request.getContextPath()%>/css/images/calendar.png",
         buttonImageOnly: true,
    	dateFormat: "yy-mm-dd",
    	maxDate : new Date(),
    });
	
	$('#TimeSheetDetails').css("display", "none");
	//document.getElementById('<portlet:namespace />submit').setAttribute('disabled', 'disabled');
	$("#<portlet:namespace />approverId").css("display","none");
	var duplicateMsg = $("#duplicateMsg").text();
	if(duplicateMsg == "null"){
		$("#duplicateMsg").css("display","none");
	}
	$("#errorPorj").css("display", "none");
	$("#errorCompOff").css("display", "none");
});

</script>

</div>