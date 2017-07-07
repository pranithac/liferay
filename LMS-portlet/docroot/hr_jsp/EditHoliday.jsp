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
<%@ page import="java.util.*" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<link href="<%=request.getContextPath()%>/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js" type="text/javascript"></script>

<jsp:include page="/jsp/Navigation.jsp" />


<portlet:defineObjects />


<portlet:actionURL var="saveHolidayURL" name="saveEditHoliday">
<portlet:param name="actionStatus" value="edit"/>
<portlet:param name="HolidayId" value='<%=request.getParameter("HolidayId") %>'/>
</portlet:actionURL>

<portlet:renderURL  var="CancelHolidayURl" >
<portlet:param name="mvcPath" value="/hr_jsp/HolidaysView.jsp"/> 

</portlet:renderURL>


      

  <script>
  $( function() {
    $( "#<portlet:namespace />datepicker" ).datepicker({
    	changeMonth: true,
    	changeYear: true,
    	 yearRange:'-5:+5',
    	 showOn:"button",
    	 buttonImage: "<%=request.getContextPath()%>/css/images/calendar.png",
    	 buttonImageOnly: true,
    	dateFormat: "yy-mm-dd",
    	
    });
  } );
  </script>

  <div id="mainContent">
 <aui:form method="post" action="<%=saveHolidayURL %>">

<aui:input type="text" id="datepicker" label="Date Of Occasion<span style='color: red;'>*</span>" name="occDate" inlineLabel="true" readonly="true" required="true" showRequiredLabel="false" value='<%=request.getParameter("HolidayDate") %>'></aui:input>

<aui:input type="text" id="occDesc" label="Name of Occasion<span style='color: red;'>*</span>" name="occDesc" inlineLabel="true" required="true" showRequiredLabel="false" value='<%=request.getParameter("Occasion") %>'></aui:input>



<%
List<LMSEmployeeDetails> empUniqueLocations = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeLocations();
%>

<aui:select name="locations" multiple="true" label="Select Applicable Locations<span style='color: red;'>*</span>" inlineLabel="true" required="true" showRequiredLabel="false">
<%
	for(int i = 0; i<empUniqueLocations.size();i++){
		//System.out.println("employee unique locations " + empUniqueLocations.get(i));
	if(request.getParameter(String.valueOf(empUniqueLocations.get(i))) != null){	
		//System.out.println("inside if  " + request.getParameter(String.valueOf(empUniqueLocations.get(i))));
		if((request.getParameter(String.valueOf(empUniqueLocations.get(i)))).equalsIgnoreCase(String.valueOf(empUniqueLocations.get(i)))){%>
		
			<aui:option value="<%=empUniqueLocations.get(i) %>" selected="true"><%=String.valueOf(empUniqueLocations.get(i)) %></aui:option>
			
			<%}
	}else{%>
	<aui:option value="<%=empUniqueLocations.get(i) %>"><%=String.valueOf(empUniqueLocations.get(i)) %></aui:option>
<%} 
		
	}
%>
</aui:select>



<aui:button-row>

<aui:button type="submit" name="submit" value="Save" cssClass="btn btn-primary"/>
<aui:button type="reset" name="cancel" value="Cancel" onClick="<%= CancelHolidayURl %>"/>


</aui:button-row>

</aui:form>

</div>