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
<%@ page import="java.util.*" %>
 <portlet:renderURL var="addWeekend">
    <portlet:param name="jspPage" value="/hr_jsp/AddWeekend.jsp" />
</portlet:renderURL> 
<jsp:include page="/jsp/Navigation.jsp" />
<portlet:defineObjects />
<portlet:actionURL var="saveHolidayURL" name="saveHoliday">
<portlet:param name="actionStatus" value="add"/>
</portlet:actionURL>

   <%List<LMSEmployeeDetails> empLocations = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeLocations();%>
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
  
<h1 style="color:teal;font-size: 20px;">Add New Holiday</h1>
  
  <div id="mainContent">
  

  
 <a href="<%= addWeekend %>" class="icon-wrench" style="float:right;color:#ee702a;padding:4px;margin:0;border:none;"> Configure Weekend Days </a>
    
<aui:form method="post" action="<%=saveHolidayURL %>">
<aui:input type="text" id="datepicker" label="Date Of Occasion<span style='color: red;'>*</span>" name="occDate" inlineLabel="true" readonly="true" required="true" showRequiredLabel="false"></aui:input>
<aui:input type="text" id="occDesc" label="Name of Occasion <span style='color: red;'>*</span>" name="occDesc" inlineLabel="true" required="true" showRequiredLabel="false"></aui:input>

<aui:select name="locations" multiple="true" label="Select Applicable Locations <span style='color: red;'>*</span>" inlineLabel="true" required="true" showRequiredLabel="false">
<%for(int i=0;i<empLocations.size();i++){ 
if(empLocations.get(i)!=null){%>
<aui:option value="<%=empLocations.get(i) %>"><%=empLocations.get(i) %></aui:option>
<%}} %>
</aui:select>
<%-- <aui:select name="optionals" multiple="true" label="Select Optional Locations" inlineLabel="true">
<aui:option value="bangalore">Bangalore</aui:option>
<aui:option value="chennai">Chennai</aui:option>
<aui:option value="hyderabad">Hyderabad</aui:option>
<aui:option value="noida">Noida</aui:option>
<aui:option value="mumbai">Mumbai</aui:option>
<aui:option value="usa">USA</aui:option>
</aui:select> --%>
<aui:button-row>


<aui:button type="submit" name="submit" value="Save" cssClass="btn btn-primary"/>
<aui:button type="reset" name="cancel" value="Cancel"/>

</aui:button-row>

</aui:form>
   

</div>













