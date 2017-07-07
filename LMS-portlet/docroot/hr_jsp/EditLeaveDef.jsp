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
<portlet:actionURL var="updateLeaveTypeURL" name="updateLeaveType">
<portlet:param name="actionStatus" value="add"/>
<portlet:param name="leaveTypeCode" value='<%= request.getParameter("leaveTypeCode") %>'/>

</portlet:actionURL>
<portlet:resourceURL var="getLeaveCategoryUrl">
<portlet:param name="GetSubList" value="Categories"/>
</portlet:resourceURL>
<portlet:resourceURL var="getLeaveReasonUrl">
<portlet:param name="GetSubList" value="Reasons"/>
</portlet:resourceURL>

<%-- <%="Reset Interval value: "+request.getParameter("ResetIntervalType") %> --%>
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
<style>
.required
{
padding:12px;
}
</style>
<%List<LMSEmployeeDetails> empLocations = LMSEmployeeDetailsLocalServiceUtil.getDistinctEmployeeCountries();
	



LMSLeaveType leaveTypetoEdit = null;
List<String> countriesApplicable= new ArrayList<String>();
	if(request.getParameter("leaveTypeCode")!=null)
	{
		try
		{
			int leaveCodeint = Integer.parseInt(request.getParameter("leaveTypeCode"));
			 leaveTypetoEdit = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(leaveCodeint);
			 countriesApplicable.addAll(Arrays.asList(leaveTypetoEdit.getCountriesApplicable().split(",")));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

%>
 <div id="addLeaveDef">
 <div id="fieldRequired">This field is required.</div>
 <aui:form method="post" action="${updateLeaveTypeURL}" id="updateLeaveType" name="updateLeaveType">
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
                            </aui:validator></aui:input>
	 </aui:column>
	
	  <aui:column cssClass="span6">
	
 <aui:select label="Select Category of Leave<span style='color: red;'>*</span>" name="category" id="category" onChange="checkCategory(this.value);"  showRequiredLabel="false" inlineLabel="true"  onClick="removeErrMsg();">
	
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
                            </aui:validator></aui:input>
	</aui:column>
	</div>
	
	</aui:row>
	<aui:row>
	 <aui:column cssClass="span6">
	
<aui:select name="locations" multiple="true" label="Select Applicable Locations<span style='color: red;'>*</span>" inlineLabel="true" showRequiredLabel="false" size="3" onClick="removeErrMsg();">
	<%for(int i=0;i<empLocations.size();i++){ 
	
		if(countriesApplicable.contains(String.valueOf(empLocations.get(i))))
		{
			
			
	%>
	<aui:option value="<%=empLocations.get(i)%>" selected="true"><%=empLocations.get(i)%></aui:option>
	
	<%}
		else
		{%>
			<aui:option value="<%=empLocations.get(i)%>" ><%=empLocations.get(i)%></aui:option>
		<%}
	
	}%>
	</aui:select>
	</aui:column>
	</aui:row>
	<aui:row>
	 <aui:column>
	<label>Credit Leave Balances Monthly?</label>
	</aui:column>
	
	<%if((request.getParameter("MontlyCredit")).equalsIgnoreCase("Yes")){%>
	<aui:column>
	
	<aui:input type="radio" name="monthlyCredit" label="Yes" value="yes" onClick="showCrediVal();" checked="true" inlineLabel="true"></aui:input>
	
	<aui:input type="radio" name="monthlyCredit" label="No" value="no" onClick="showCrediVal();" inlineLabel="true" ></aui:input>
	</aui:column>
	
		<span id="creditValue" >
		<aui:column>
		<aui:input type="text" label="Monthly Credit balance" name="monthlyCreditVal"  inlineLabel="true">
		<aui:validator name="number" errorMessage="Enter only numbers"></aui:validator>
		</aui:input>
		</aui:column>
		</span>
		
	<% }
	
	else if((request.getParameter("MontlyCredit")).equalsIgnoreCase("no"))
	{%>
	<aui:column>
	<aui:input type="radio" name="monthlyCredit" label="Yes" value="yes" onClick="showCrediVal();" inlineLabel="true"></aui:input>
	<aui:input type="radio" name="monthlyCredit" label="No" value="no" onClick="showCrediVal();" inlineLabel="true" checked="true"></aui:input>
	</aui:column>
	<span id="creditValue" style="display:none;" >
	<aui:column>
	<aui:input type="text" label="Monthly Credit balance" name="monthlyCreditVal"  >
	<aui:validator name="number" errorMessage="Enter only numbers"></aui:validator>
	</aui:input>
	</aui:column>
	</span>
	<%} 
	else
	{%>
	<aui:column>
		<aui:input type="radio" name="monthlyCredit" label="Yes" value="yes" onClick="showCrediVal();" inlineLabel="true"  ></aui:input>
		<aui:input type="radio" name="monthlyCredit" label="No" value="no" onClick="showCrediVal();" inlineLabel="true" checked="true"></aui:input>
		</aui:column>
		
		<span id="creditValue" style="display:none;">
		<aui:column>
		<aui:input type="text" label="Monthly Credit balance" name="monthlyCreditVal" inlineLabel="true" ></aui:input>
		</aui:column>
		</span>
	<% } %>
	
	
	
	</aui:row>

	<div id="balanceReset" style="display:none;">
		<aui:row>
	<aui:column>
				<label>Balance Reset Applicable?</label>
			</aui:column>
			
			<aui:column>
			<%if(request.getParameter("CreditRest").equalsIgnoreCase("yes")) 
			{%>
				<aui:input  name ="resetBalance" label="Yes" type="radio"  value="yes" checked="true" onClick="showExpirationOption();" inlineLabel="true"></aui:input>
				<aui:input  name ="resetBalance" label="No" type="radio"   value="no" onClick="showExpirationOption();" inlineLabel="true"></aui:input>
			<%}else if(request.getParameter("CreditRest").equalsIgnoreCase("no"))
				{%>
				<aui:input  name ="resetBalance" label="Yes" type="radio"  value="yes" onClick="showExpirationOption();" inlineLabel="true"></aui:input>
				<aui:input  name ="resetBalance" label="No" type="radio"   value="no" checked="true" onClick="showExpirationOption();" inlineLabel="true"></aui:input>
				
				<%}
				else
				{%>
					<aui:input  name ="resetBalance" label="Yes" type="radio"  value="yes" onClick="showExpirationOption();" inlineLabel="true"></aui:input>
				<aui:input  name ="resetBalance" label="No" type="radio"   value="no" onClick="showExpirationOption();" inlineLabel="true" checked="true"></aui:input>
					
				<%}%>
			</aui:column>
	
	<%if(request.getParameter("CreditRest").equalsIgnoreCase("yes")){ %>
	
	
		<div id="resetInterval" >
		
		<aui:column cssClass="span6">
		<aui:select onChange="getExpirationInterval(this.value)" name="resetInterval" label="Reset Interval" inlineLabel="true" id="resetIntervalType">
		<%if(request.getParameter("ResetIntervalType").equalsIgnoreCase("monthly")) {%>
		<aui:option value="monthly" selected="true">Monthly</aui:option>
		<aui:option value="yearly">Yearly</aui:option>
		<aui:option value="days">After a limit of accrual</aui:option>
		<%}else if(request.getParameter("ResetIntervalType").equalsIgnoreCase("yearly")) {%>
		
		<aui:option value="monthly">Monthly</aui:option>
		<aui:option value="yearly" selected="true">Yearly</aui:option>
		<aui:option value="days">After a limit of accrual</aui:option>
		<%}else if(request.getParameter("ResetIntervalType").equalsIgnoreCase("days")){ %>
		<aui:option value="monthly">Monthly</aui:option>
		<aui:option value="yearly">Yearly</aui:option>
		<aui:option value="days" selected="true">After a limit of accrual</aui:option>
		<%} %>
		
		</aui:select>
		</aui:column>
		
		</div>
		<%}else{%>
	<div id="resetInterval" style="display:none;">
	
	<aui:column cssClass="span6" >
	<aui:select onChange="getExpirationInterval(this.value)" name="resetInterval" label="Reset Interval" inlineLabel="true" id="resetIntervalType">
	<aui:option value="">--Select--</aui:option>
	<aui:option value="monthly">Monthly</aui:option>
	<aui:option value="yearly">Yearly</aui:option>
	<aui:option value="days">After a limit of accrual</aui:option>
	</aui:select>
	</aui:column>
	</div>
		<aui:row>
				<span id="monthlyInterval" style="display:none;">
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
			<span id="dayYearlyInterval" style="display:none;">
			<aui:column cssClass="span6" >
			
				<aui:select  name="dayYearlyInterval" label="day" inlineLabel="true"  onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;">
				<% for(int i=1;i<=31;i++){%>
				<aui:option value="<%=i %>"><%=i %></aui:option>
				<%} %>
				</aui:select>
				
				</aui:column>
				</span>
				<span id="monthYearlyInterval" style="display:none;">
				<aui:column cssClass="span6">
				
				<aui:select name="monthYearlyInterval" label="month" inlineLabel="true" onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;" >
				<% for(int i=1;i<13;i++){%>
				<aui:option value="<%=i %>"><%=i %></aui:option>
				
					<%
					}%>
				</aui:select>
			
			</aui:column>
			</span>
			
			<span id="maxAccrual"  style="display:none;">
				<aui:column id="daysInterval" >
				
				<aui:input type="text" name="maxAccrual" label="Maximum Accrual Value" inlineLabel="true" />
				
				</aui:column>
			</span>
</aui:row>

	
	<%}%>
</aui:row> 
	
	
	
	
	
	
	<%if(request.getParameter("CreditRest").equalsIgnoreCase("yes")){  %>
	
	<%if(request.getParameter("ResetIntervalType").equalsIgnoreCase("monthly")) {%>
	<aui:row>
	<span id="monthlyInterval" >
	<aui:column>
	
	
	<aui:select name="monthlyInterval" label="day of the month" inlineLabel="true" onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;">
	
	<% 
	int check=0;
	if(request.getParameter("ResetDay")!=null)
	{
		 check = Integer.parseInt(request.getParameter("ResetDay"));
	}
				for(int i=0;i<=31;i++){
				
				
					if(check == i)
					{
					%>
					<aui:option value="<%=i %>" selected="true"><%=i %></aui:option>
					<%
					}
					else
					{%>
						<aui:option value="<%=i %>" ><%=i %></aui:option>
					<%}
				
			}%>
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
	
	<aui:select name="monthYearlyInterval" label="month" inlineLabel="true"  onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;">
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
	
	
	<% }else if(request.getParameter("ResetIntervalType").equalsIgnoreCase("yearly")) {
		
		String check="";
		if(request.getParameter("ResetDay")!=null){
			 check = request.getParameter("ResetDay");
			
		}
		%>
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
	
	
	<aui:select name="dayYearlyInterval" label="day" inlineLabel="true" onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;">
	
	<% 
	
	for(int i=1;i<=31;i++){
		if(check.length()==4)
		{
			if(Integer.parseInt(check.substring(0, 2))==i)
			{%>
				 <aui:option value="<%=i %>" selected="true"><%=i %></aui:option> 
			<%}
			else
			{%>
				 <aui:option value="<%=i %>" selected="true"><%=i %></aui:option> 
			<%}
			
			
		}else
		{
			if(Integer.parseInt(check.substring(0,1))==i)
			{%>
			<aui:option value="<%=i %>" selected="true"><%=i %></aui:option> 
		<%}else
		{%>
		
		<%}}
	}%>
	</aui:select>
	</aui:column>
	</span>
	
	<span id="monthYearlyInterval">
	<aui:column cssClass="span6">
	<aui:select name="monthYearlyInterval" label="month" inlineLabel="true" onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;" >
	<% for(int i=1;i<13;i++) {
	
		if(check.length()==4)
		{
			if(Integer.parseInt(check.substring(2,4))==i)
			{%>
				 <aui:option value="<%=i %>" selected="true"><%=i %></aui:option> 
			<%}else
			{%>
			<aui:option value="<%=i %>" ><%=i %></aui:option> 
		<%
		}
		}else
			{
			if(Integer.parseInt(check.substring(2,3))==i)
			{%>
				<aui:option value="<%=i %>" selected="true"><%=i %></aui:option> 
			<%}
			else
			{%>
				<aui:option value="<%=i %>" ><%=i %></aui:option> 
			<%}
		}
			
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
	
	<%}else if(request.getParameter("ResetIntervalType").equalsIgnoreCase("days"))
	{%>
	
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
	
	<aui:select name="monthYearlyInterval" label="month" inlineLabel="true"   onmousedown="if(this.options.length>10){this.size=10;}"  onblur="this.size=0;">
	<% for(int i=1;i<13;i++){%>
	<aui:option value="<%=i %>"><%=i %></aui:option>
	
		<%
		}%>
	</aui:select>
	
	</aui:column>
	</span>
	<span id="maxAccrual">
	<aui:column id="daysInterval" >
	
	<%if(request.getParameter("ResetDay")!=null){ %>
	<aui:input type="text" name="maxAccrual" value='<%=request.getParameter("ResetDay") %>' label="Maximum accrual value" inlineLabel="true" />
	<%}
	else
	{%>
	<aui:input type="text" name="maxAccrual"  label="Maximum accrual value" inlineLabel="true" />
	<%} %>
	
	</aui:column>
	</span>
		
	<%}
	
	
	%>


	
	<%}%>
	</div>
	
	<aui:row>
	<aui:column>
	<label>Exclude Week Ends</label>
	</aui:column>
	<aui:column>
	<%if((request.getParameter("ExcludeWeekEnds").equalsIgnoreCase("yes"))){ %>
	<aui:input  name ="excludeWeekends" label="Yes" type="radio" value="yes" checked="true" inlineLabel="true"></aui:input>
	<aui:input  name ="excludeWeekends" label="No" type="radio" value="no" inlineLabel="true"></aui:input>
	
	<%}
	else if((request.getParameter("ExcludeWeekEnds").equalsIgnoreCase("no"))) 
	{%>
	
	<aui:input  name ="excludeWeekends" label="Yes" type="radio" value="yes" inlineLabel="true"></aui:input>
	<aui:input  name ="excludeWeekends" label="No" type="radio" value="no"  checked="true" inlineLabel="true"></aui:input>
	
	<%} 
	else
	{%>
	
	<aui:input  name ="excludeWeekends" label="Yes" type="radio" value="yes" inlineLabel="true"></aui:input>
	<aui:input  name ="excludeWeekends" label="No" type="radio" value="no" inlineLabel="true" checked="true"></aui:input>
	
	<%} %>
	</aui:column>
	</aui:row>
	<aui:row>
	<aui:column>
	<label>Exclude Holidays</label>
	</aui:column>
	<aui:column>
	<%if((request.getParameter("ExcludeHolidays").equalsIgnoreCase("yes"))){ %>
	<aui:input  name ="excludeHolidays" label="Yes" type="radio" value="yes" checked="true" inlineLabel="true"></aui:input>
	<aui:input  name ="excludeHolidays" label="No" type="radio" value="no" inlineLabel="true"></aui:input>
	
	<%}
	
	else if((request.getParameter("ExcludeHolidays").equalsIgnoreCase("no"))){%>
	<aui:input  name ="excludeHolidays" label="Yes" type="radio" value="yes" inlineLabel="true"></aui:input>
	<aui:input  name ="excludeHolidays" label="No" type="radio" value="no" checked="true" inlineLabel="true"></aui:input>
	
	<%}else
		{%>
		
		<aui:input  name ="excludeHolidays" label="Yes" type="radio" value="yes" inlineLabel="true"></aui:input>
		<aui:input  name ="excludeHolidays" label="No" type="radio" value="no" inlineLabel="true" checked="true"></aui:input>
		
	<%}%>
	</aui:column>
	</aui:row>
	 
	<div>
		<aui:button type="button" name="submit" value="Save" cssClass="btn btn-primary" onClick="checkValidation();"/>
		<aui:button type="reset" name="cancel" cssClass="btn btn-primary" value="Cancel"/>
		
	</div>

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
	
	showCrediVal();
	showExpirationOption();
	getExpirationInterval($('#<portlet:namespace />resetIntervalType option:selected').val());
/* 	$('#daysInterval').hide();
	$('#dayYearlyInterval').hide();
	$('#monthYearlyInterval').hide();
	$('#maxAccrual').hide();
	$('#monthlyInterval').hide(); */
	$("#messageSpan2").hide();
	
	
	
	
	
	
});
function getExpirationInterval(val){
	//alert(val);
	if(val=='monthly'){
		
		//alert('monthly selected');
		$('#monthlyInterval').show();
		$('#dayYearlyInterval').hide();
		$('#monthYearlyInterval').hide();
		$('#maxAccrual').hide();
	}
	else if(val=='yearly'){
		//alert('yearly selected');
		$('#dayYearlyInterval').show();
		$('#monthYearlyInterval').show();
		$('#monthlyInterval').hide();
		$('#maxAccrual').hide();
	}
	else if(val=='days'){
	//	alert('days selected');
		$('#maxAccrual').show();
		$('#monthlyInterval').hide();
		$('#dayYearlyInterval').hide();
		$('#monthYearlyInterval').hide();
	}else{
		//alert('nothing selected');
		$('#maxAccrual').hide();
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
				/* $('#monthlyInterval').show();
				$('#dayYearlyInterval').show();
				$('#monthYearlyInterval').show();
				$('#maxAccrual').show(); */
			}
			
			else if(checkedValue == 'no')
			{
				
				$('#resetInterval').hide();
				$('#monthlyInterval').hide();
				$('#dayYearlyInterval').hide();
				$('#monthYearlyInterval').hide();
				$('#maxAccrual').hide();
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
	 document.forms["<portlet:namespace />updateLeaveType"].submit();
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
