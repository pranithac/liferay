<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<jsp:include page="/jsp/Navigation.jsp" />

<%@ page import= "com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import= "com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>


<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<portlet:defineObjects />

<liferay-portlet:renderURL varImpl="iteratorURL">
<portlet:param name="jspPage" value="/jsp/LeaveTypeList.jsp" />
</liferay-portlet:renderURL>
<portlet:renderURL var="addHoliday">
    <portlet:param name="jspPage" value="/jsp/AddHoliday.jsp" />
</portlet:renderURL>









<%ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

PortletURL portletURL = renderResponse.createRenderURL();

  portletURL.setParameter("jspPage", "/hr_jsp/LeaveTypeList.jsp");	   
  //List<LeaveType> leaveTypesList = LeaveTypeLocalServiceUtil.getLeaveTypes(0, LeaveTypeLocalServiceUtil.getLeaveTypesCount());
  
  List<LMSLeaveType> leaveTypeList = LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypes(0, LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount());
  List<LMSLeaveType> leaveTypesListtoIterate = ListUtil.copy(leaveTypeList);
  List<LMSEmployeeDetails> empCountries = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeCountries();
  
  //System.out.println(empCountries);
%>

  <h1 style="color:teal;font-size: 20px;">View/Edit Leave Types</h1>
<div id="mainContent">

 <table id="leaveHistoryDatatable" >
  
 
    <thead>
        <tr>
         
           
            <th>Leave Type </th>
             <%  
				
				  
					 for(int j=0;j< empCountries.size();j++ ){
						 if(empCountries.get(j)!=null){
		         				%>
		         				<th>Applicable in <%=String.valueOf(empCountries.get(j))%> </th>
		         				<%
		         			
						 }}
			 %> 
            <th>Leave Category</th>
            <th>Monthly Credit</th>
			<th>Credit values</th>
			<th>Credit Reset Applicable</th>
			
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
  <%  for(LMSLeaveType leavetype : leaveTypesListtoIterate){
  
	  String[] countriesStringArray  = leavetype.getCountriesApplicable().split(",");
	  List<String> countriesStringList = (List<String>) Arrays.asList(countriesStringArray);
	  //System.out.println(countriesStringList);
  %> 
  
        <tr>
          <%--  <td><%= leaveinfo.getLeaveRequestId()%></td> --%>
           
        	 
        	  <td><%=leavetype.getLeaveTypeName()%></td>
           <%for(int i=0;i< empCountries.size();i++){
        	   if(empCountries.get(i)!=null){
         	
         			if(countriesStringList.indexOf(String.valueOf(empCountries.get(i)))!= -1){
         				%>
         				
         				<td> Yes </td>
         				
         				<%
         			}else{
         				%>
         				<td> No </td>
         				<%
         			}
         		
        	   }} %>
          <td><%=LeaveCategoriesLocalServiceUtil.getCategoryByLeaveType(leavetype.getLeaveTypeCode()) %></td>
          <td><%= leavetype.getMonthlyAccrual() %></td>
          <td><%= leavetype.getAccrualValue() %></td>
            
          <td><%=leavetype.getCreditReset()%></td>
      
         	
            
             <td>
             <portlet:actionURL var="editLeaveDefURL" name="editLeaveDef">
		<portlet:param name="typeCode" value="<%=String.valueOf(leavetype.getLeaveTypeCode())%>"/>
			</portlet:actionURL>     
             
              <liferay-ui:icon iconCssClass="icon-edit" message="Edit" url="<%=editLeaveDefURL%>" />
        
        <portlet:actionURL var="deleteLeaveDefURL" name="deleteLeaveDef">
       <portlet:param name="LeaveTypeCode" value="<%=String.valueOf(leavetype.getLeaveTypeCode())%>"/>
			</portlet:actionURL>
       
       
        <liferay-ui:icon iconCssClass="icon-trash" message="Delete" url="<%=deleteLeaveDefURL%>" />
      
  
   

   </td>
        </tr>
      
      <%} %>
    </tbody>
</table>
</div>
<script>

$(document).ready(function(){
	
	//$('#history').hide();
    var table= $('#leaveHistoryDatatable').DataTable({
    	"iDisplayLength": 5,
    	"bSort" : false,
    	"columnDefs": [
   	                {"className": "dt-center", "targets": "_all"}
   	              ],
    	
    });
});
</script>