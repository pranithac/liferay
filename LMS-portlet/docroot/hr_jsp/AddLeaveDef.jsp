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
<%@ page import="com.trianz.lms.service.*" %>
<%@ page import="com.trianz.lms.model.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<jsp:include page="/jsp/Navigation.jsp" />
<portlet:defineObjects />
<portlet:actionURL var="addLeaveTypeURL" name="addLeaveType">
<portlet:param name="actionStatus" value="add"/>
</portlet:actionURL>
<portlet:resourceURL var="getLeaveCategoryUrl">
<portlet:param name="GetSubList" value="Categories"/>
</portlet:resourceURL>
<portlet:resourceURL var="getLeaveReasonUrl">
<portlet:param name="GetSubList" value="Reasons"/>
</portlet:resourceURL>



<%List<LMSEmployeeDetails> empLocations = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeCountries();%>


<% 

List<LMSLeaveType> getAllLeaveTypes = LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypes(0, LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount());
List<String> existingLeaveTypes = new ArrayList<String>();

for(LMSLeaveType leaveType : getAllLeaveTypes)
{
	existingLeaveTypes.add(leaveType.getLeaveTypeName());
}
%>
 



 
 <script>

 function validLeaveType(val)
 {
	  
	 var givenName = val.toLocaleLowerCase();
	  <% for(String leaveName :existingLeaveTypes)
	  {%>
	  		var leaveName = '<%=leaveName%>';
	  		
	  	 if(givenName.localeCompare(leaveName.toLocaleLowerCase()) == 0)
	  		{ 
		  		if($('#fieldRequired')){
					$('#fieldRequired').remove();
				}
		  		$('#<portlet:namespace />leaveTypeName').after('<div id="fieldRequired">This Leave Name Already Exists.Please enter new name.</div>');
		  		
	  		} 
	  	 
	  		
	  <%}%> 
 }
function getSubLists(val){
	
	
	getAbsenceCategories(val);
	/* getAbsenceReasons(val); */
	
	
	
}
function getAbsenceCategories(val){
	 AUI().use('aui-io-request', function(A){
	        A.io.request('${getLeaveCategoryUrl}', {
	               method: 'post',
	               data: {
	            	   <portlet:namespace />leaveType:val,
	               },
	               on: {
	                   	success: function() {
	                      $('#<portlet:namespace />absenceCategory').html('');
	                        $('#<portlet:namespace />absenceCategory').val(this.get('responseData'));
	                    }
	              }
	        });
	    });
}


function checkCategory(val){
	//alert(val);
	if(val=='newCategory'){
		//alert('add new cat');

		$('#newCat').css("display","block");
	}
	else{
	
		$('#newCat').css("display","none");
	}
	
}

function showCrediVal()
{
	var checkedValue = $('input[name="<portlet:namespace />monthlyCredit"]:checked').val();
	
	if(checkedValue == 'yes')
		{
			$('#creditValue').show();
			$('#balanceReset').show();
		}
	else
		{
			$('#creditValue').hide();
			$('#balanceReset').hide();
		}
}

var existingCategoryCodes=[];

</script>


  <h1 style="color:teal;font-size: 20px;">Add New Leave Type</h1>

 <div id="addLeaveDef">
 <div id="fieldRequired">This field is required.</div>

 <aui:form method="post" action="<%=addLeaveTypeURL%>" id="addLeaveType" name="addLeaveType">
<aui:row>

<aui:column cssClass="span6">
 <aui:input type="text" name="leaveTypeName" label="Leave Type Name<span style='color: red;'>*</span>"  showRequiredLabel="false" inlineLabel="true" onChange="validLeaveType(this.value);" onClick="removeErrMsg();">
 <aui:validator name="custom"            
                                  errorMessage="Please enter Alphabets only">
                                    function (val, fieldNode, ruleValue)
                                       {
                                           var result = true;
                                           var pattern=/[^a-z|^A-Z|^\s]/;
                                          var check = val.match(pattern);
                                          if(check!=null)
                                         {
                                            result=false;
                                          }
                                          
                                      return result;
                                        }
                            </aui:validator>
                            </aui:input>
 </aui:column>
 <aui:column cssClass="span6">
 <aui:select label="Select Category of Leave<span style='color: red;'>*</span>" name="category" id="category" onChange="checkCategory(this.value);"  showRequiredLabel="false" inlineLabel="true" onClick="removeErrMsg();">
<aui:option value=''>--Select--</aui:option>
<%List<LeaveCategories> leaveCategoriesObjects = LeaveCategoriesLocalServiceUtil.getLeaveCategorieses(0, LeaveCategoriesLocalServiceUtil.getLeaveCategoriesesCount());
List<String> categoryNames=new ArrayList<String>();
for(int n=0;n<leaveCategoriesObjects.size();n++){
	categoryNames.add(leaveCategoriesObjects.get(n).getLeaveCategory());%>
	
	<script>
	existingCategoryCodes[<%=n%>]="<%= leaveCategoriesObjects.get(n).getLeaveCategoryCode()%>";

	</script>
	
<% }


Set<String> uniqueCategories = new HashSet<String>(categoryNames);
uniqueCategories.addAll(categoryNames);
categoryNames.clear();
categoryNames.addAll(uniqueCategories);


//list2.addAll(uniqueCategories);
for(int i=0;i<categoryNames.size();i++){%>
<aui:option value='<%=categoryNames.get(i)%>'><%=categoryNames.get(i) %></aui:option>

<%} %>
<aui:option value='newCategory'>Add New Category</aui:option>
 </aui:select>
</aui:column>
 </aui:row>
 <aui:row>

<div id="newCat" style="display:none;">

 <aui:column cssClass="span6">
 <div id="messageSpan2" class="alert alert-danger">Already Existing Code, Please Enter new Leave Category Code</div>
<aui:input type='text' name='categoryCode' id='categoryCode' label="Add New Category Code<span style='color: red;'>*</span>" onChange="checkWithExistingCategoryCode();" inlineLabel="true" onClick="removeErrMsg();">
 <aui:validator name="alphanum" errorMessage="Please enter only alphanumeric characters"/></aui:input>
 </aui:column>
 <aui:column cssClass="span6">
<aui:input type='text' name='categoryName' id='categoryName' label="Add New Category Name<span style='color: red;'>*</span>" inlineLabel="true" onClick="removeErrMsg();">
<aui:validator name="custom"            
                                  errorMessage="Please enter Alphabets only">
                                    function (val, fieldNode, ruleValue)
                                       {
                                           var result = true;
                                           var pattern=/[^a-z|^A-Z|^\s]/;
                                          var check = val.match(pattern);
                                          if(check!=null)
                                         {
                                            result=false;
                                          }
                                          
                                      return result;
                                        }
                            </aui:validator>
      
       </aui:input>
</aui:column>
</div>


</aui:row>
<aui:row>

<aui:column cssClass="span6">
<aui:select name="locations" multiple="true" label="Select Applicable Locations<span style='color: red;'>*</span>" inlineLabel="true"  showRequiredLabel="false" size="3" onClick="removeErrMsg();">
<%for(int i=0;i<empLocations.size();i++){
	if(empLocations.get(i)!=null){%>%>
<aui:option value="<%=empLocations.get(i)%>"><%=empLocations.get(i)%></aui:option>

<%}} %>
</aui:select>
</aui:column>
</aui:row>

<aui:row>

<aui:column>
<label>Credit Leave Balances Monthly?</label>
</aui:column>


<aui:column>
<aui:input type="radio" name="monthlyCredit" label="Yes" value="yes" onClick="showCrediVal();" inlineLabel="true"></aui:input>

<aui:input type="radio" name="monthlyCredit" label="No" value="no" onClick="showCrediVal();" inlineLabel="true" checked="true"></aui:input>

</aui:column>
<span id="creditValue" style="display:none;">
<aui:column>
<aui:input type="text" label="Monthly Credit balance" name="monthlyCreditVal" placeholder="in Days" inlineLabel="true">
<aui:validator name="number" errorMessage="Enter only numbers"></aui:validator>
</aui:input>
</aui:column>
</span>
</aui:row>




<div id="balanceReset" style="display:none;">

	<aui:row>
		<aui:column>
			<label>Balance Reset Applicable?</label>
		</aui:column>
		<aui:column>
			<aui:input  name ="resetBalance" label="Yes" type="radio" value="yes" onClick="showExpirationOption();" inlineLabel="true"></aui:input>
			<aui:input  name ="resetBalance" label="No" type="radio"  value="no" onClick="showExpirationOption();" inlineLabel="true" checked="true"></aui:input>
		</aui:column>
		
<div id="resetInterval" style="display:none;">

<aui:column>
<aui:select onChange="getExpirationInterval(this.value)" name="resetInterval" label="Reset Interval" inlineLabel="true">
<aui:option value="">--Select--</aui:option>
<aui:option value="monthly">Monthly</aui:option>
<aui:option value="yearly">Yearly</aui:option>
<aui:option value="days">After a limit of accrual</aui:option>
</aui:select>
</aui:column>
</div>
</aui:row>

<aui:row>
<span id="monthlyInterval">
<aui:column>

<aui:select name="montlyInterval" label="Day of the Month" inlineLabel="true" onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;">
<% for(int i=1;i<=31;i++){%>
<aui:option value="<%=i %>"><%=i %></aui:option>
<%} %>
</aui:select>

</aui:column>
</span>
</aui:row>
<aui:row>


<span id="dayYearlyInterval">
<aui:column cssClass="span6">

<aui:select  name="dayYearlyInterval" label="day" inlineLabel="true" onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;" >
<% for(int i=1;i<=31;i++){%>
<aui:option value="<%=i %>"><%=i %></aui:option>
<%} %>
</aui:select>

</aui:column>
</span>
<span id="monthYearlyInterval">
<aui:column cssClass="span6">

<aui:select name="monthYearlyInterval" label="month" inlineLabel="true" onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;" >
<% for(int i=1;i<13;i++){%>
<aui:option value="<%=i %>"><%=i %></aui:option>

	<%
	}%>
</aui:select>

</aui:column>
</span>

<span id="maxAccrual">
<aui:column id="daysInterval">

<aui:input type="text" name="maxAccrual" label="Maximum Accrual Value" inlineLabel="true" />

</aui:column>
</span>
</aui:row>
</div>


<aui:row>

<aui:column>
<label>Exclude Weekends in Duration?</label>
</aui:column>
<aui:column>
<aui:input  name ="excludeWeekends" label="Yes" type="radio" value="yes" inlineLabel="true"></aui:input>

<aui:input  name ="excludeWeekends" label="No" type="radio" value="no" inlineLabel="true" checked="true"></aui:input>
</aui:column>
<br/><br/>
</aui:row>

<aui:row>
<div>
<aui:column>
<label>Exclude Holidays in Duration?</label>
</aui:column>
<aui:column>
<aui:input  name ="excludeHolidays" label="Yes" type="radio" value="yes" inlineLabel="true"></aui:input>

<aui:input  name ="excludeHolidays" label="No" type="radio" value="no" inlineLabel="true" checked="true"></aui:input>
</aui:column>
</div>
</aui:row>
<aui:button type="button" name="submit" value="Save" cssClass="btn btn-primary" onClick="checkValidation();"/>
<aui:button type="reset" name="cancel" value="Cancel" cssClass="btn btn-primary"/>

 
 </aui:form>
</div>
    
<script>
$(document).ready(function(){
	
	$('#fieldRequired').hide();
	$('#daysInterval').hide();
	$('#dayYearlyInterval').hide();
	$('#monthYearlyInterval').hide();
	$('#maxAccrual').hide();
	$('#monthlyInterval').hide();
	$("#messageSpan2").hide();
	
	
	
	
	
	
});
function getExpirationInterval(val){
	//alert(val);
	if(val=='monthly'){
		
		$('#monthlyInterval').show();
		$('#dayYearlyInterval').hide();
		$('#monthYearlyInterval').hide();
	}
	else if(val=='yearly'){
		$('#dayYearlyInterval').show();
		$('#monthYearlyInterval').show();
		$('#monthlyInterval').hide();
		$('#maxAccrual').hide();
	}else if(val==''){
		
		$('#maxAccrual').hide();
		$('#monthlyInterval').hide();
		$('#dayYearlyInterval').hide();
		$('#monthYearlyInterval').hide();
	}else{
		$('#maxAccrual').show();
		$('#monthlyInterval').hide();
		$('#dayYearlyInterval').hide();
		$('#monthYearlyInterval').hide();
		
	}
	
	
}
 
 
 
function checkWithExistingCategoryCode()
 {
	 
	 //alert("Inside Method");
	 var tempd = $('#<portlet:namespace />categoryCode').val();
	 //alert(tempd);
	//alert(existingCategoryCodes.join("\n"));
	  
	 if ($.inArray(tempd,existingCategoryCodes) > -1) 
	      
		 {
		 	$("#messageSpan2").show();
		 	$('#<portlet:namespace/>categoryCode').val("");
		 }
	 else
		 {
			 $("#messageSpan2").hide();
		 } 
	 
 }
 
 
 function showExpirationOption(){
	 var checkedValue = $('input[name="<portlet:namespace />resetBalance"]:checked').val();
		
		if(checkedValue == 'yes')
			{
				$('#resetInterval').show();
			}
		else
			{
				$('#resetInterval').hide();
			} 
 }
 
/****************  form validation starts here ******************************************/
 function removeErrMsg()
 {
	 $('#fieldRequired').hide();
 }
 
 function checkValidation(){
		
 	 var rtnvalue=true;
 	var leaveName = $('#<portlet:namespace />leaveTypeName').val();
	var newCategoryCode= $('#<portlet:namespace />categoryCode').val();
	var newCategoryName = $('#<portlet:namespace />categoryName').val();
	var CategorySelected = $('#<portlet:namespace />category').val();
	var countries = $('#<portlet:namespace />locations > option:selected'); 
	
	
	
	if((leaveName=="")){
		
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />leaveTypeName').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
	} 
	
	if((CategorySelected=='select')||(CategorySelected=="")){
		
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />category').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
	} 
	
	
	if(CategorySelected=='newCategory'){
		
		if((newCategoryCode=="")){
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />categoryCode').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
		
	}
		
	}
if(CategorySelected=='newCategory'){
		
		if((newCategoryName=="")){
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />categoryName').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
		
	}
		
	}
	if(countries.length==0){
		
		if($('#fieldRequired')){
			$('#fieldRequired').remove();
		}
		
		$('#<portlet:namespace />locations').after('<div id="fieldRequired">**This field is required.</div>');
		
		rtnvalue=false;
		return rtnvalue;
		
	}

if(rtnvalue){
	disableScreen();
	
	 document.forms["<portlet:namespace />addLeaveType"].submit();
}

return rtnvalue;
	
} 
 /****************  form validation Ends here ******************************************/
 function disableScreen() {
    // creates <div class="overlay"></div> and 
    // adds it to the DOM
    var div= document.createElement("div");
    div.className += "overlay";
    document.body.appendChild(div);
    
}
 </script>
