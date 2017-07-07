<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<jsp:include page="/jsp/Navigation.jsp" />
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<portlet:defineObjects />

<portlet:actionURL var="approveCompOffURL" name="approveCompoff">
</portlet:actionURL>

<portlet:actionURL var="rejectCompOffURL" name="rejectCompoff">
</portlet:actionURL>

<portlet:actionURL var="delegateCompOffURL" name="delegateCompoff">
</portlet:actionURL>

<portlet:resourceURL var="getUsers">
<portlet:param name="GetSubList" value="Users"/>
</portlet:resourceURL>

<link href="<%=request.getContextPath()%>/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js" type="text/javascript"></script>


<style>
	.testSpan{
		background-color:red;
	}
	#approversList{
		display : none;
	}
	#myModal label{
	    width: 31% !important;
	}
	.aui .modal-body {
		height: 10em !important; 
	}
</style>
<div id="mainContent">

<%
ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String ApproverName = themeDisplay.getUser().getFullName();

int EmployeeId = LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(themeDisplay.getUser().getEmailAddress()).getEmployeeId();
System.out.println("Approver name : " + ApproverName + " Approver EmployeeId : " + EmployeeId);
List<LMSCompOffLeaveDetails> approversList =  LMSCompOffLeaveDetailsLocalServiceUtil.getCompoffDetailsbyApproverEmpId(EmployeeId);
System.out.println("approversList size " + approversList.size());
List<LMSCompOffLeaveDetails> finalCompOffsList = new ArrayList<LMSCompOffLeaveDetails>();
for(LMSCompOffLeaveDetails compOff : approversList){
//System.out.println("compOff ID " + compOff.getCompOffId());
	if(compOff.getStatus().equalsIgnoreCase("NotUsed")){
		finalCompOffsList.add(compOff);
	}
}
System.out.println("pending compoff requests : " + finalCompOffsList.size());

%>
<h1 style="color:teal;font-size: 20px;">Compensatory Off Requests</h1>

<div id="myModal" style="display:none;" class="modal">
   <div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content" id = "modalContent">
		</div>
 </div> 
</div>

<input type = "text" id="approversList" name="approversList" />

<table id="compOffHistory" >
  
 
    <thead>
        <tr>
           
            <th>Comp Off ID</th>
            <th>Employee Name</th>
         	 <th>Comp Off Date</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
  <%  for(LMSCompOffLeaveDetails compOfflist : finalCompOffsList){%> 
  
        <tr>
         
              <td><%= compOfflist.getCompOffId() %></td>
              <td><%= LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(compOfflist.getEmployeeID()).getEmployeeName() %></td>
              <td><%=new SimpleDateFormat("yyyy-MM-dd").format(compOfflist.getCompoffDate()) %></td>
              <td>
              <%String compOffId =  String.valueOf(compOfflist.getCompOffId());
		System.out.println(compOffId);
	%>
	
	 
	 	<span  id="<%=String.valueOf(compOfflist.getCompOffId())%>"  onClick="callApproveAction(this.id)">
        	<liferay-ui:icon iconCssClass="icon-ok" message="Approve" url="#" />
        </span>
        <span  id="<%=String.valueOf(compOfflist.getCompOffId())%>" onClick="callRejectAction(this.id)">
        	<liferay-ui:icon iconCssClass="icon-remove" message="Reject" url="#" />
        </span>
              
              <%--  <liferay-ui:icon id="<%=String.valueOf(compOfflist.getCompOffId())%>" iconCssClass="icon-ok" message="Approve"  onClick="callApproveAction(this.id)"/>
        		<liferay-ui:icon id="<%=String.valueOf(compOfflist.getCompOffId())%>" iconCssClass="icon-remove" message="Reject" onClick="callRejectAction(this.id)" />
               --%>
              </td>
             
           </tr>
  
  <%} %>
 
      
      
    </tbody>
</table>



<script>

	
$(document).ready(function(){
	
	
    var table= $('#compOffHistory').DataTable({
    	"iDisplayLength": 5,
    	"bSort" : false,
    	"columnDefs": [
   	                {"className": "dt-center", "targets": "_all"}
   	              ],
    });
    getUsers();
});
	function callApproveAction(compOffId){
	 	var html="";
			
			html+= '<div class="modal-header">';
			html+= '<button type="button" class="close" data-dismiss="modal">&times;</button>';
			html+= '<h4 class="modal-title">Approve</h4>';	
			html+=' </div>';
			
			html+='<form  method="post"  action="${approveCompOffURL}"  >';
			html+='<div class="modal-body" >';
			html+='<span class="compoffDetails"> <label class="compOffLable">Comp Off Request Id :</label><input  readonly type = "text" id="<portlet:namespace />compOffRequest" name = "<portlet:namespace />compOffRequest"/></span>';
			html+='<span class="compoffDetails"> <label class="compOffLable">Comments :</label> <textarea resizable="true" name="approveComments"></textarea> </span>';
			html+='<button type="submit"  class="btn btn-primary" value="OK">OK</button>';
			html+='</div>';
			html+='</form>'; 
		$("#modalContent").html(html); 
		$("#<portlet:namespace />compOffRequest").val(compOffId);
		$('#myModal').modal('show'); 
		$('.modal-backdrop').remove();
	}
	function callRejectAction(compOffId){
		var html="";
		
		html+= '<div class="modal-header">';
		html+= '<button type="button" class="close" data-dismiss="modal">&times;</button>';
		html+= '<h4 class="modal-title">Reject</h4>';	
		html+=' </div>';
		
		html+='<form  method="post" action="${rejectCompOffURL}"  >';
		html+='<div class="modal-body" >';
		html+='<span class="compoffDetails"><label class="compOffLable">Comp Off Request Id :</label> <input readonly type = "text" id="<portlet:namespace />compOffRequest" name = "<portlet:namespace />compOffRequest"/></span>';
		html+='<span class="compoffDetails"><label class="compOffLable">Comments :</label> <textarea resizable="true" name="approveComments"></textarea> <span>';
		html+='<button type="submit"  class="btn btn-primary" value="OK">OK</button>';
		html+='</div>';
		html+='</form>'; 
			

		$("#modalContent").html(html); 
		$("#<portlet:namespace />compOffRequest").val(compOffId);
		$('#myModal').modal('show'); 
		$('.modal-backdrop').remove();
	}
	
	function getUsers(){
	       AUI().use('aui-io-request', function(A){
	               A.io.request('<%=getUsers%>', {
	                      method: 'post',
	                    
	                      on: {
	                            success: function() {
	                               $('#approversList').val(this.get('responseData'));
	                           }
	                     }
	               });
	           });
	}
</script>