<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %> 
<%@ page import="java.text.SimpleDateFormat" %>
 <jsp:include page="/jsp/Navigation.jsp" />



<portlet:defineObjects />
<style>
.projLink{
width:30%;
padding:1em;
height:4em;
display:inline-block;
}
#pName {
    padding: 22px 2px 2px 38px;
    display: block;
    float: left;
    width: 6em;
    background: darkturquoise;
    height: 3em;
    font-weight: bold;
    color: #fff;
    border:1px solid #ccc;
}
#pDetails {
    display: block;
    width: 17em;
    background: paleturquoise;
    padding-left: 10em;
    /* padding: 3px 0px 0px 11px; */
    height: 4.7em;
    border:1px solid #ccc;
}
#mDashboard hr{
margin:0;}
#projects a {
    width: 30%;
    display: block;
  float:left;
    height: 5em;
}
#projects {
    height: 5em;
}
#mDashboard {
    padding: 0em 0em 0em 1em;
}
</style>


<%ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String loggedInEmailId = themeDisplay.getUser().getEmailAddress();

		
%>


<%//System.out.println("No of tasks: "+pendingwftasks.size()); %>

 <portlet:renderURL var="Reportees">
    <portlet:param name="jspPage" value="/jsp/Reportees.jsp" />
</portlet:renderURL> 
<div id="mDashboard">
<p><b>Select a project to view leave requests :</b><a href="<%= Reportees %>" class="icon-user icon-large" style="float:right;color:#ee702a;padding:4px;margin:0;border:none;"> View Pending Requests By Employee </a></p>
<hr>




<%List<LMSProjectDetails> projDetails = LMSProjectDetailsLocalServiceUtil.getProjectsOfApprover(loggedInEmailId);
List<LMSProjectDetails> uniqueProjs = new ArrayList<LMSProjectDetails>();

 /*************** formating Current Date *********************/
Date currentDateget = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
String cdateString  = df.format(currentDateget);
Date currentDate = df.parse(cdateString);


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



for(int l=0;l<uniqueProjs.size();l++){
	int noEmp = 0;

%>
 <portlet:renderURL var="Requests">
    <portlet:param name="jspPage" value="/jsp/ProjectRequests.jsp" />
	<portlet:param name="projCode" value="<%=uniqueProjs.get(l).getProjectCode() %>" />
</portlet:renderURL>

<a href="<%=Requests%>" class="projLink">
<div id="projects">
<div id="pName"><%=uniqueProjs.get(l).getProjectName()%></div>
<div id="pDetails">Project Code : <%=uniqueProjs.get(l).getProjectCode()%><br/>
<%List<LMSProjectDetails> employeeRecords = LMSProjectDetailsLocalServiceUtil.getProjectsByApprover(loggedInEmailId, uniqueProjs.get(l).getProjectCode());

List<LMSProjectDetails> uniqueEmployees = new ArrayList<LMSProjectDetails>();

int sizeEmp= (employeeRecords.size())-1;
for(int m=0;m<employeeRecords.size();m++){
	
	uniqueEmployees.add(employeeRecords.get(m));
}
for(int k=0;k<sizeEmp;k++){
	for(int j=k+1;j<employeeRecords.size();j++){	
		
	
if(((employeeRecords.get(j).getEmployeeId())==(employeeRecords.get(k).getEmployeeId()))){
	uniqueEmployees.remove(employeeRecords.get(j));
}	
	
}
}


List<Integer> employeesOnLeave = new ArrayList<Integer>();



for(int p=0;p<uniqueEmployees.size();p++){
	
	List<LMSLeaveInformation> leavesApplied = LMSLeaveInformationLocalServiceUtil.getleavesByApprovalStatus(employeeRecords.get(p).getEmployeeId(), "Approved");
	
	
	
	for(int z=0;z<leavesApplied.size();z++){
		
		List<LMSProjectDetails> empProjects = LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(leavesApplied.get(z).getEmployeeId());
		List<String> projCodesList = new ArrayList<String>();
		for(int i=0;i<empProjects.size();i++){
			projCodesList.add(empProjects.get(i).getProjectCode());
			
		}
		
		
		if((projCodesList).contains(uniqueProjs.get(l).getProjectCode())){
			//System.out.println("Project codes matched");
			 /*************** formating Start Date *********************/
			Date startDateget = leavesApplied.get(z).getStartDate();
			String sDate = df.format(startDateget);
			Date startDate = df.parse(sDate);
			 /*************** formating End Date *********************/
			Date endDateget = leavesApplied.get(z).getEndDate();
			String eDate = df.format(endDateget);
			Date endDate = df.parse(eDate);
			
		
		
			
		if((currentDate.compareTo(startDate)== 0) && (currentDate.compareTo(endDate)<= 0)){
		
			//System.out.println(leavesApplied.get(z).getEmployeeId()+" is on leave today in the project: "+uniqueProjs.get(l).getProjectName()+"with leave ID: "+leavesApplied.get(z).getLeaveRequestId());
			noEmp++;
			//System.out.println("No of employees on leave: "+noEmp);
		}
		
		%><% 
		}
		
	}
	
	
	
}
Set<Integer> uniqueEmployeesOnLeave = new HashSet<Integer>(employeesOnLeave);


uniqueEmployeesOnLeave.addAll(employeesOnLeave);
employeesOnLeave.clear();
employeesOnLeave.addAll(uniqueEmployeesOnLeave);



%>

No of Employees: <%=employeeRecords.size()%><br/>
No of Employees on Leave Today: <%=noEmp%>

</div>
</div>
</a>
<%}%>


</div>
<hr>

<br/>

