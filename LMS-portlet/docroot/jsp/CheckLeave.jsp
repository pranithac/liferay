<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.trianz.lms.model.LeaveBalance" %>
<%@page import="com.trianz.lms.service.LeaveBalanceLocalServiceUtil" %>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<jsp:include page="/jsp/Navigation.jsp" />

<portlet:defineObjects />
<%-- <portlet:actionURL var="LeaveBalanceURL" windowState="normal" name="getLeaveBalances"/> --%>
<portlet:resourceURL var="LeaveBalanceURL">
<portlet:param name="GetSubList" value="getUpdatedLeaves"/>
</portlet:resourceURL>

<%ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String emailId = themeDisplay.getUser().getEmailAddress();

int employeeId= LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(emailId).getEmployeeId(); %>
<script>
  $( function() {
    $( "#<portlet:namespace />effDate" ).datepicker({
    	changeMonth: true,
		changeYear: true,
		 yearRange:'-5:+5',
    	 showOn:"button",
         buttonImage: "<%=request.getContextPath()%>/css/images/calendar.png",
         buttonImageOnly: true,
    	//dateFormat: "dd-M-yy",
    	dateFormat: "yy-mm-dd",
    	
    });
  } );
  </script>


 <h1 style="color:teal;font-size: 20px;">Leave Balances</h1>
<div id = "mainContent">
	
	
	<%
	//System.out.println(request.getParameter("ELLeaveBal"));
	String CLBalance = "0";
	String ELBalance = "0";
	String CompBalance = "0";
	String Message = " ";
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date dateobj = new Date();
	String effectiveDate = df.format(dateobj);
	//System.out.println("request.getParameter('message')" + request.getParameter("message"));
	if(request.getParameter("status")== null){
		//System.out.println("inside if jsp");
		
		
		LeaveBalance leavebal = LeaveBalanceLocalServiceUtil.getLeaveBalanceByEmpID(employeeId);
		CLBalance = String.valueOf(leavebal.getCLBalance());
		ELBalance = String.valueOf(leavebal.getELBalance());;
		Message = " ";
	}else{
		//System.out.println("inside else jsp");
		CLBalance = request.getParameter("CLLeaveBal");
		ELBalance = request.getParameter("ELLeaveBal");
		Message = request.getParameter("status");
		effectiveDate = request.getParameter("EffectiveDate");

	}
	LeaveBalance leavebalTemp = LeaveBalanceLocalServiceUtil.getLeaveBalanceByEmpID(employeeId);
	CompBalance = String.valueOf(leavebalTemp.getCompOffLeaveBalance());
	System.out.println("effective date " + effectiveDate);
	%>
	<span id="message"><%=Message%></span>
	<aui:fieldset label="Balances as of today">
	<aui:row>
		<div class = "span4">
			<aui:col>
				<b><aui:input id="clBal" cssClass="leave"  name="Contingency Leave bal" label = "Contingency Leave Balance :" type="text" readonly="true" value = "<%=CLBalance%>"></aui:input></b>
			</aui:col>
		</div>
		<div class = "span4">
			<aui:col>
				<b><aui:input id="elBal" cssClass="leave" label = "Earned Leave Balance :" name="Earned Leave bal"  type="text" readonly="true" value = "<%=ELBalance%>"></aui:input></b>
			</aui:col>
		</div>
		<div class = "span4">
			<aui:col>
				<b><aui:input id="compBal" cssClass="leave" label = "Compensatory Leave Balance :" name="Compensatory Leave bal"  type="text" readonly="true" value = "<%=CompBalance%>"></aui:input></b>
			</aui:col>
		</div>
	</aui:row>
	</aui:fieldset>
	<aui:fieldset label="Select the date for which you wish to view Your balances">
	
	<aui:row>
		<div class = "span6">
			<aui:col>
				<aui:input type="text" label="Effective Date :" name = "effDate" id = "effDate"  readonly="true"  value = "<%=effectiveDate%>" onChange="getleaveBalances(this.value);"></aui:input>
			</aui:col>
		</div>
<%-- 		<div class = "span6">
			<aui:col>
				<aui:button type="submit"  value="Show Leave Balances"></aui:button>
			</aui:col>
		</div> --%>
	</aui:row>
	</aui:fieldset>
</div>



<script>
$(document).ready(function(){
	var d = new Date();
	var month = d.getMonth()+1;
	var currentDate = d.getFullYear()+"-"+month+"-"+d.getDate();
	//console.log(currentDate);
	//getleaveBalances(currentDate);
});


function getleaveBalances(val){
	//console.log('getting leave categories' + val);
	 $.ajax({
         url: '${LeaveBalanceURL}',
         data: {
      	   <portlet:namespace />effDate:val,
         },
         type: "get",
         success: function(data){
        	 var responseArray = data.split('=');
        	 var message = responseArray[0];
        	 var ELBalance = responseArray[1];
        	 var CLBalance = responseArray[2];
        	 $('#<portlet:namespace />clBal').html('');
        	 $('#<portlet:namespace />elBal').html('');
        	 $('#message').html('');
        	 
        	 $('#<portlet:namespace />clBal').val(CLBalance);
        	 $('#<portlet:namespace />elBal').val(ELBalance);
        	 $('#message').val(message);
         }
       });
}
</script>