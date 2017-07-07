<%@page import="com.trianz.lms.model.LMSEmployeeDetails"%>
<%@page import="com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil"%>
<%@page import="com.trianz.lms.model.LMSHolidays"%>
<%@page import="com.trianz.lms.service.LMSHolidaysLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ page import="java.util.*" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import= "org.apache.commons.beanutils.BeanComparator"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.RenderResponse" %>>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" type="text/css" />
<jsp:include page="/jsp/Navigation.jsp" />
<portlet:defineObjects />
<liferay-theme:defineObjects/>


<%

List<LMSHolidays> totalHolidays = LMSHolidaysLocalServiceUtil.getLMSHolidayses(0, LMSHolidaysLocalServiceUtil.getLMSHolidaysesCount());
//System.out.println("total holidays size : " + totalHolidays.size());


%>

<style>
	#holidaysList{
		    overflow-x: scroll;
    		height: 32em;
	}
	#hiddenYear{
		display:none;
	}
	#hiddenLocation{
		display:none;
	}
	#HolidaysTable_filter
		{
		display:none;
		}
	#filterYear{
		 display: inline;
	}
	
</style>
 <h1 style="color:teal;font-size: 20px;">View/Edit Holiday List</h1>
 

<%
	String isHolidaysExist = String.valueOf(request.getAttribute("isHolidaysExist"));
	
	if(isHolidaysExist.trim().equalsIgnoreCase("") || isHolidaysExist.trim() == "null"){
	}else{
%>
<span class="alert alert-danger" id="isHolidaysExist"><%= isHolidaysExist%></span>
<%} %>
 
 
<div id="hiddenYear" name="hiddenYear"> </div>
<div id="hiddenLocation" name="hiddenLocation"> </div>
	<% List<LMSEmployeeDetails> locationList = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeLocations();%>



<div id="holfilters">
<div class="holfilterCri">
<label>Filter By Year  </label><span id="filterYear"></span>
</div>
<div class="holfilterCri">
<aui:select name="Location" id="location" label="Filter By Location"  required="true" showRequiredLabel="false" inlineLabel="true">
	<aui:option value="select">--Select--</aui:option>
	<%for(int i = 0; i<locationList.size();i++){
		if(locationList.get(i)!=null){%>
		//System.out.println(emp.getEmployeeName());
		
		<aui:option value="<%=String.valueOf(locationList.get(i))%>"><%=String.valueOf(locationList.get(i))%></aui:option>
	
	<%
	}}
	%>
	</aui:select>
</div>
</div>




<div id="mainContent">
<table id="HolidaysTable" class = "stripe hover">
    <thead>
        <tr>
           <!--  <th>Holiday ID</th> -->
            <th>holidayDate</th>
            <th>Occassion</th>
          <%for(int j = 0; j<locationList.size();j++){
          if(locationList.get(j)!=null){%>
            <th><%=String.valueOf(locationList.get(j))%></th>
           <%}} %>
            
            <th>Actions</th>
            <th style="display:none;">Year</th>
        </tr>
    </thead>
    <tbody id="tableBody">
    
    
  <% 
  List<String> holidayLocations = new ArrayList<String>();
  for(LMSHolidays tholidays : totalHolidays){
	  String[] locationsApplicable = tholidays.getLocationsApplicable().split(",");
	  holidayLocations = (List<String>)Arrays.asList(locationsApplicable);
	  System.out.println(holidayLocations);
 
  %> 
        <tr >
          <%--  <td><%=tholidays.getHolidayID()%></td> --%>
           <td><%=new SimpleDateFormat("yyyy-MM-dd").format(tholidays.getHolidayDate())%></td>
           <td><%=tholidays.getOccassion()%></td>
           
           
           <% for(int k=0;k<locationList.size();k++){
        	   if(locationList.get(k)!=null){
       
              	if(holidayLocations.indexOf(locationList.get(k))!=-1){
              		%>
              			 <td>YES</td>
              		<%
              	}else{
              		%>
         			 <td>NO</td>
         		<%
              	}
           %>
           <%}} %>
        
            <td>
            	 <portlet:actionURL var="editHolidayURL" name="editHoliday">
				<portlet:param name="HolidayID" value="<%=String.valueOf(tholidays.getHolidayId())%>"/>
				</portlet:actionURL>
        	<liferay-ui:icon iconCssClass="icon-edit" message="Edit" url="<%=editHolidayURL%>" />
        
        <portlet:actionURL var="deleteHolidayURL" name="deleteHoliday">
       	<portlet:param name="HolidayID" value="<%=String.valueOf(tholidays.getHolidayId())%>"/>
			</portlet:actionURL>
        <liferay-ui:icon iconCssClass="icon-trash" message="Delete" url="<%=deleteHolidayURL%>" />
            
            
            </td>
           <td style="display:none;"><%=tholidays.getHolidayYear() %></td>
        </tr>
        <%    		
    	}
    %>
      
    </tbody>
</table>
</div>

<script>
$(document).ready(function(){
  var table =   $('#HolidaysTable').DataTable({
    	"iDisplayLength": 15,
    	
    	 "lengthChange": false,
    	 
    	 "columnDefs": [
    	                {"className": "dt-center", "targets": "_all"}
    	              ],
    	              
    	              "aoColumnDefs": [
										{"aTargets": [ 1 ], "bSortable": true },	
										{ "aTargets": [ '_all' ], "bSortable": false }	
										]	,
										
								    	 "bAutoWidth": false,
  				
    });
  

  
  $("#filterYear").each( function ( i ) {
		
		var select = $('<select><option value="">----Select---</option></select>')
          .appendTo( $(this).empty() )
          .on( 'change', function () {
              var val = $(this).val();
				console.log(val);
              table.column( 13 )
                  .search( val ? '^'+$(this).val()+'$' : val, true, false )
                  .draw();
          } );
		
		
			table.column(13).data().unique().sort().each( function ( d, j ) {  
				select.append( '<option value="'+d+'">'+d+'</option>' );
	        } );	
		});
  

	 
	 $('#<portlet:namespace />location').on( 'change', function () {
		
          var val = $(this).val();
          console.log('val : ' + val);
         var locationsTemp1 = "<%=locationList%>";
         //console.log(locationsTemp1);
          var locationsTemp2 = locationsTemp1.replace("[","");
          var locations = locationsTemp2.replace("]","");
          var locationsArray = locations.split(","); 
          var trimLocationArray = [];
          for(var l= 0;l<locationsArray.length; l++ ){
        	 // console.log(locationsArray[l].trim());
        	  var trimLocation = locationsArray[l].trim();
        	 trimLocationArray.push(trimLocation);
          }
          console.log(trimLocationArray);
          console.log(" index : " + trimLocationArray.indexOf(val) + " size " + trimLocationArray.length);
          var selectedLocationIndex = trimLocationArray.indexOf(val);
       	  
          for(var m =0;m<trimLocationArray.length;m++){
        	  
        		if(m==selectedLocationIndex){
        			table.column( selectedLocationIndex+2 ).search( 'Yes' ? '^'+'Yes'+'$' : 'Yes', true, false ).draw();
        			
        		}else{
        			table.column( m + 2 ).search('').draw();
        		}
          }
      } );
	
});





</script>
