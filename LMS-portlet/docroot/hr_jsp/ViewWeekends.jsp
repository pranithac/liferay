<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import= "com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="java.util.*" %>
<jsp:include page="/jsp/Navigation.jsp" />
 <portlet:renderURL var="addWeekend">
    <portlet:param name="jspPage" value="/hr_jsp/AddWeekend.jsp" />
</portlet:renderURL> 
<%
 
  List<LMSWeekends> weekendsList = LMSWeekendsLocalServiceUtil.getLMSWeekendses(0, LMSWeekendsLocalServiceUtil.getLMSWeekendsesCount());
  List<LMSWeekends> weekendstoIterate = ListUtil.copy(weekendsList);
		   
%>
<h1 style="color:teal;font-size: 20px;">Weekends</h1>
<a href="<%= addWeekend %>" class="icon-wrench" style="float:right;color:#ee702a;padding:4px;margin:0;border:none;"> Configure Weekend Days </a>
<div id="mainContent">
<table id="weekendsDatatable" >
  
 
    <thead>
        <tr>
         
            <th>Location</th>
            <th>Weekend Days</th>
            
        </tr>
    </thead>
    <tbody>
<%for(LMSWeekends weekend : weekendstoIterate){%> 
<tr>
<td><%=weekend.getLocation() %></td>
<td><%=weekend.getWeekendDays() %></td>
</tr>
<%} %>
  
</tbody>
</table>

</div>
<script>
$(document).ready(function(){
	
	//$('#history').hide();
    var table= $('#weekendsDatatable').DataTable({
    	"iDisplayLength": 5,
    	"bSort" : false,
    	"columnDefs": [
   	                {"className": "dt-center", "targets": "_all"}
   	              ],
    	
    });
});
</script>