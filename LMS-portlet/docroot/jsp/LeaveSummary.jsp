<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<jsp:include page="/jsp/Navigation.jsp" />


<portlet:defineObjects />

<%ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String emailId = themeDisplay.getUser().getEmailAddress();

int employeeId= LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(emailId).getEmployeeId(); %>
<div id="summary">
<aui:form>
<aui:fieldset label="Leave Summary">

<div id="summarydiv">
<aui:row>
<aui:column>Absence Type</aui:column>
<aui:column><%=LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(Integer.parseInt(request.getParameter("absenceType")))%></aui:column>
</aui:row>
<aui:row>
<aui:column>Absence Category</aui:column>
<aui:column><%=request.getParameter("absenceCategory") %></aui:column>
</aui:row>
<%-- <aui:row>
<aui:column>Absence Reason</aui:column>
<% if(((request.getParameter("absenceReason"))!="")&&((request.getParameter("absenceReason"))!=null)){%>
<aui:column><%=LeaveReasonLocalServiceUtil.getReasonByLeaveType(Integer.parseInt(request.getParameter("absenceReason")))%></aui:column>
<%}else {%>
<aui:column></aui:column>
<%} %>
</aui:row> --%>
<aui:row>
<aui:column>Start Date</aui:column>
<aui:column><%=request.getParameter("startDate") %></aui:column>
</aui:row>
<aui:row>
<aui:column>End Date</aui:column>
<aui:column><%=request.getParameter("endDate") %></aui:column>
</aui:row>


<aui:row>
<aui:column>Duration of Leave(In Days)</aui:column>
<aui:column><%=request.getParameter("total") %></aui:column>
</aui:row>
<%-- <aui:row>
<aui:column>Project</aui:column>

<%if((request.getParameter("project").equalsIgnoreCase("TRZ-809"))){ %>
<aui:column>Leave of Absence</aui:column>
<%}else{ %>
<aui:column><%=LMSProjectDetailsLocalServiceUtil.getProjectNameById(request.getParameter("project"), employeeId).getProjectName()%></aui:column>
<%} %>
</aui:row> --%>
<%-- <aui:row>
<aui:column>Approver</aui:column>
<aui:column><%=request.getParameter("approver") %></aui:column>
</aui:row> --%>
<aui:row>
<aui:column>Comments</aui:column>
<aui:column><%=request.getParameter("comments") %></aui:column>
</aui:row>
</div>
</aui:fieldset>
</aui:form>
</div>