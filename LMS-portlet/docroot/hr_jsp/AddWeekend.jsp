<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>



<jsp:include page="/jsp/Navigation.jsp" />
<portlet:actionURL var="saveWeekendsURL" name="saveWeekends">

</portlet:actionURL>
 <portlet:renderURL var="viewWeekend">
    <portlet:param name="jspPage" value="/hr_jsp/ViewWeekends.jsp" />
</portlet:renderURL> 
<%List<LMSEmployeeDetails> empLocations = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeCountries();%>
<h1 style="color:teal;font-size: 20px;">Configure Weekend Days</h1>
<div id="mainContent">
<a href="<%=viewWeekend%>" class="icon-eye-open" style="float:right;color:#ee702a;padding:4px;margin:0;border:none;">View Weekend Days </a>
<aui:form method="post" action="<%=saveWeekendsURL %>">
<aui:select name="location" label="Select Location" inlineLabel="true" required="true" showRequiredLabel="false">
<%for(int i=0;i<empLocations.size();i++){ %>
<aui:option value="<%=empLocations.get(i) %>"><%=empLocations.get(i) %></aui:option>
<%} %>
</aui:select>
<aui:select name="weekends" multiple="true" label="Select Weekend Days" inlineLabel="true" required="true" showRequiredLabel="false" helpMessage="Maximum of two days can be selected">

<aui:option value="Monday">Monday</aui:option>
<aui:option value="Tuesday">Tuesday</aui:option>
<aui:option value="Wednesday">Wednesday</aui:option>
<aui:option value="Thursday">Thursday</aui:option>
<aui:option value="Friday">Friday</aui:option>
<aui:option value="Saturday">Saturday</aui:option>
<aui:option value="Sunday">Sunday</aui:option>
</aui:select>



<aui:button type="submit" name="submit" value="Save" cssClass="btn btn-primary"/>
<aui:button type="reset" name="cancel" value="Cancel"/>
</aui:form>

</div>