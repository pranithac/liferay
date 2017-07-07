package com.trianz.lms.controller;


import com.liferay.portal.NoSuchWorkflowDefinitionLinkException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.trianz.lms.NoSuchEmployeeDetailsException;
import com.trianz.lms.NoSuchLeaveCategoriesException;
import com.trianz.lms.NoSuchWFHManulPunchException;
import com.trianz.lms.NoSuchWeekendsException;
import com.trianz.lms.NoSuchsecuraxEmployeeHrsException;
import com.trianz.lms.model.*;
import com.trianz.lms.service.*;
import com.trianz.lms.util.SendMail;






import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


import java.util.Set;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;



public class ApplyLeaveController extends MVCPortlet {
	
	private static User loggedUser = null;
	private static User leaveApproverUser=null;
	Log logger = LogFactoryUtil.getLog(ApplyLeaveController.class.getName());


	public String appliedLeaveType="";
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
			
	
		try {
			
			
			
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			loggedUser = themeDisplay.getUser();
			
		int loggedInEmpId = getLoggedInEmployeeId(resourceRequest, resourceResponse);
			
		String listType = resourceRequest.getParameter("GetSubList");
		if(loggedInEmpId!=0){
		if(listType!=null){
		logger.info("Ajax Called For : " +listType);
		int leaveType = ParamUtil.getInteger(resourceRequest, "leaveType");
	
		resourceResponse.setContentType("text/html");
		PrintWriter ListValue = resourceResponse.getWriter();
		
		
		
		if ((listType.equalsIgnoreCase("LeaveTypes"))){
			
			logger.info("Inside Leave Type Ajax Call :  Starts Here ");
			String leaveTypeCodetoSelect = resourceRequest.getParameter("leaveTypecode");
			
			String leaveReqId = resourceRequest.getParameter("LeaveReqNo");
			//Getting all leave policies Here
			List<LMSLeavePolicies> leavePolicy = LMSLeavePoliciesLocalServiceUtil.getLMSLeavePolicieses(0, LMSLeavePoliciesLocalServiceUtil.getLMSLeavePoliciesesCount());
			//get All LeaveTypes Here
			List<LMSLeaveType> getAllLeaveTypes = LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypes(0, LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount());
			int EmpID=0;
			//If from Edit page Ajax method is called
			if(leaveReqId!=null)
			{
				LMSLeaveInformation leavinfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqId);
				EmpID = leavinfo.getEmployeeId();
			}
			else
			{
				EmpID=loggedInEmpId;
			}
			List<LMSProjectDetails> employeeProjectDetails  = LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(EmpID);
			List<String> empLeaveTypes = new ArrayList<String>();
			
			
			//Comparing Project code to Apply Leave Policy to Employee
			int numberOfProjectsAssigned=0;
			for(LMSLeavePolicies empLeavepolicy : leavePolicy)
			{
					for(LMSProjectDetails projectdetails : employeeProjectDetails)
					{
						if(empLeavepolicy.getProject().equalsIgnoreCase(projectdetails.getProjectCode()))
						{
							numberOfProjectsAssigned++;
							empLeaveTypes.addAll(Arrays.asList(empLeavepolicy.getLeaveTypesApplicable().split(",")));
						}
					}
				
			}
			logger.info("Number of Projects Assigned==="+numberOfProjectsAssigned);
			List<LMSLeaveType> leaveTypestoDisplay = new ArrayList<LMSLeaveType>();
			if(numberOfProjectsAssigned==0||numberOfProjectsAssigned>1)
			{
				LMSEmployeeDetails loginEmployeeDetails = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(loggedInEmpId);
				String EmployeeCountry = loginEmployeeDetails.getRegion();
				logger.info("Employee Country"+EmployeeCountry);
				leaveTypestoDisplay = LMSLeaveTypeLocalServiceUtil.getLeaveTypesByLocation(EmployeeCountry);
			}
			else
			{
				//Getting leaveType list to display on Employee Screen
				
				for(String leavecodeStr :empLeaveTypes)
				{
					
					int leaveTypeCode = Integer.parseInt(leavecodeStr.replaceAll("'", ""));
					leaveTypestoDisplay.add(LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(leaveTypeCode));
					
				}
			}
			String leaveTypes="";
			if(leaveTypeCodetoSelect!=null)
			{
				
				int leaveTypcodeSelect = Integer.parseInt(leaveTypeCodetoSelect);
			 leaveTypes = "<option value=\""+leaveTypcodeSelect+"\">"+LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(leaveTypcodeSelect)+"</option>" ;
			}
			else
			{
				leaveTypes = "<option value=\"select\">--Select--</option>" ;
			}
			
			for(int i=0;i<leaveTypestoDisplay.size();i++){
					
					leaveTypes = leaveTypes+"<option value=\""+leaveTypestoDisplay.get(i).getLeaveTypeCode()+"\">"+leaveTypestoDisplay.get(i).getLeaveTypeName()+"</option>";	
				}
			
			ListValue.println(leaveTypes);
			ListValue.flush();
			ListValue.close();
			logger.info(" Leave Type Ajax Call :  Ends here ");
			}
	
		else if(listType.equalsIgnoreCase("AutoComplete"))
		{
			logger.info("Inside AutoComplete Ajax Call :  Starts Here ");	
			
			JSONArray namesJSONArray = JSONFactoryUtil.createJSONArray();
			String  employeeName = ParamUtil.getString(resourceRequest, "EmployeeName");
			
			DynamicQuery employeeNameQuery = DynamicQueryFactoryUtil.forClass(LMSEmployeeDetails.class,PortalClassLoaderUtil.getClassLoader());
			
			Criterion criterion = RestrictionsFactoryUtil.like("EmployeeName",
			StringPool.PERCENT + employeeName + StringPool.PERCENT);
			employeeNameQuery.add(criterion);
			JSONObject employeeNameJSON = null;
		                                                                                                                   
			try {
			List<LMSEmployeeDetails> employeeList = LMSEmployeeDetailsLocalServiceUtil.dynamicQuery(employeeNameQuery);
			
			
			for (LMSEmployeeDetails employeeNameList : employeeList) {
				employeeNameJSON = JSONFactoryUtil.createJSONObject();
				
				employeeNameJSON.put("employeeNames",employeeNameList.getEmployeeName());
				namesJSONArray.put(employeeNameJSON);
			}} catch (Exception e) {
			}
			
			
			
			ListValue.println(namesJSONArray.toString());
			ListValue.flush();
			ListValue.close();
			logger.info(" AutoComplete Ajax Call :  Ends Here ");	
				
		}
		else if ((listType.equalsIgnoreCase("categories")&&(leaveType!=0))){
			
			try {
				
				logger.info("Inside Categories Ajax Call :  Starts Here ");	
				
				String category = LeaveCategoriesLocalServiceUtil.getCategoryByLeaveType(leaveType);
				
				ListValue.println(category);
				ListValue.flush();
				ListValue.close();

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchLeaveCategoriesException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			}
			logger.info("Inside Categories Ajax Call :  Ends Here ");	
		}
	
		else if (listType.equalsIgnoreCase("Duration")){
			logger.info("Inside Duration Ajax Call :  Starts Here ");	
			
			String LeaveType = resourceRequest.getParameter("LeaveType");
			int LeaveTypeCode=0;
			String LeaveTypeName="";
			if(!(LeaveType.equals(null))){
			if(!(LeaveType.equalsIgnoreCase("select"))){
				LeaveTypeCode = Integer.parseInt(LeaveType);	
				LeaveTypeName = LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(LeaveTypeCode);
			}	
				
			}
			String StartDate = resourceRequest.getParameter("startDate");
			String EndDate = resourceRequest.getParameter("endDate");
			
			double duration=0.0;
			double holidays=0.0;
			double workingDays = 0;
			
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			if((StartDate=="")||(EndDate=="")){
				duration=0.0;
				
			}
			else{
			try {
				Date startDate = formatter.parse(StartDate);
				Date endDate = formatter.parse(EndDate);
				
				Calendar sDate = Calendar.getInstance();
				Calendar eDate = Calendar.getInstance();
				sDate.setTime(startDate);
				eDate.setTime(endDate);
				 
				
				Calendar dayStart = (Calendar) sDate.clone();
				Calendar dayEnd = (Calendar) eDate.clone();
				
			
				 while (!dayStart.after(dayEnd)) {
		        	
		            	   duration++;
		              
		               dayStart.add(Calendar.DATE,1);
		           }
				
				
		           while (!sDate.after(eDate)) {
		        	   
		        	   
		               if ((Calendar.SATURDAY != sDate.get(Calendar.DAY_OF_WEEK))
		                  &&(Calendar.SUNDAY != sDate.get(Calendar.DAY_OF_WEEK))) {
		            	   workingDays++;
		               }
		               sDate.add(Calendar.DATE,1);
		           }
		         
				/*************Checking holidays between leave start and End Date**************/
		        // Getting Employee base location
					LMSEmployeeDetails employeeDetails = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(getLoggedInEmployeeId(resourceRequest, resourceResponse));
					String employeeLocation = employeeDetails.getLocation();
				
		         //Getting all leave policies Here

					String leaveReqId = resourceRequest.getParameter("LeaveReqNo");
					//Getting all leave policies Here
					List<LMSLeavePolicies> leavePolicy = LMSLeavePoliciesLocalServiceUtil.getLMSLeavePolicieses(0, LMSLeavePoliciesLocalServiceUtil.getLMSLeavePoliciesesCount());
					//Getting Employee Project Assignments here
					
					int EmpID=0;
					//If from Edit page Ajax method is called
					if(leaveReqId!=null)
					{
						LMSLeaveInformation leavinfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqId);
						EmpID = leavinfo.getEmployeeId();
					}
					else
					{
						EmpID=loggedInEmpId;
					}
					List<LMSProjectDetails> employeeProjectDetails  = LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(EmpID);
					List<String> empHolidayIds = new ArrayList<String>();
					
					
					List<LMSHolidays> holidayList = new ArrayList<LMSHolidays>();
					Date [] holidaysDates = new Date[0];
					//Comparing Project code to Apply Leave Policy to Employee
					int numberofProjectsAssigned=0;
					for(LMSLeavePolicies empLeavepolicy : leavePolicy)
					{
							for(LMSProjectDetails projectdetails : employeeProjectDetails)
							{
								if(empLeavepolicy.getProject().equalsIgnoreCase(projectdetails.getProjectCode()))
								{
									numberofProjectsAssigned++;
									empHolidayIds.addAll(Arrays.asList(empLeavepolicy.getLocationsApplicable().split(",")));
								}
							}
						
					}
					
				
					if(numberofProjectsAssigned==0||numberofProjectsAssigned>1)
					{
						holidayList.addAll(LMSHolidaysLocalServiceUtil.getHolidaysByLocation(employeeLocation));
						
					}
					else
					{
							for(String locationAp :empHolidayIds)
							{
								holidayList.addAll(LMSHolidaysLocalServiceUtil.getHolidaysByLocation(locationAp));
							}
					}
				
					//Getting Unique Holidays List

						Set<LMSHolidays> uniqueCategories = new HashSet<LMSHolidays>(holidayList);
						uniqueCategories.addAll(holidayList);
						holidayList.clear();
						holidayList.addAll(uniqueCategories);
					
				//Extracting Holiday Dates into Date Array
					int sizeofArray = holidayList.size();
					holidaysDates = new Date[sizeofArray];
					 int i=0;
					 
					for (LMSHolidays lmsHolidaysList : holidayList) {
						
						holidaysDates[i] = lmsHolidaysList.getHolidayDate();
						 i++;
					}
					
					
				//Checking Holiday date is between start and end  date
					for(int j=0;j<holidaysDates.length;j++){
						
						if(holidaysDates[j].compareTo(startDate)>= 0 && holidaysDates[j].compareTo(endDate)<= 0)
						{
							holidays++;
							logger.info("Holiday Between these Dates is "+ holidaysDates[j]);
						}
					}
				logger.info("Number of Holidays: "+holidays);
				logger.info("Number of Working workingDays: "+workingDays);
				
				/************************* Checking Holidays Ends here ********************************/
				LeaveBalance balance=LeaveBalanceLocalServiceUtil.getLeaveBalance(getLoggedInEmployeeId(resourceRequest, resourceResponse));
				if((LeaveTypeName.toLowerCase()).contains("earned")){
					
					logger.info("Earned Leave Balance:  " +balance.getELBalance());
					duration = workingDays-holidays;
					
					
					if((balance.getELBalance())<duration){
						logger.info("Insufficient EL Balance");
						ListValue.println("Insufficient EL Balance");
						ListValue.flush();
						ListValue.close();
					}
					else{
						ListValue.println(duration);
						ListValue.flush();
						ListValue.close();
						
					}
					
					
				}else if((LeaveTypeName.toLowerCase()).contains("contingency")){
					
					logger.info("Contingency Leave Balance:  " +balance.getCLBalance());
					duration = workingDays-holidays;
					if((balance.getCLBalance())<duration){
						
						logger.info("Insufficient CL Balance");
						ListValue.println("Insufficient CL Balance");
						ListValue.flush();
						ListValue.close();
					}
					else{
						ListValue.println(duration);
						ListValue.flush();
						ListValue.close();
						
					}
					
				}
				else if((LeaveTypeName.toLowerCase()).contains("compensatory"))
				{
					logger.info("CompOff Leave Balance:  " +balance.getCompOffLeaveBalance());
					duration = workingDays-holidays;
					if((balance.getCompOffLeaveBalance())<duration){
						
						logger.info("Insufficient CompOff Balance");
						ListValue.println("Insufficient CompOff Balance");
						ListValue.flush();
						ListValue.close();
					}
					else{
						ListValue.println(duration);
						ListValue.flush();
						ListValue.close();
						
					}
					
				}
				else if((LeaveTypeName.toLowerCase()).contains("without")){
					logger.info("Applying  Leave without Pay");
					duration = duration-holidays;
						ListValue.println(duration);
						ListValue.flush();
						ListValue.close();
						
					}
					
				
				else{
					ListValue.println(duration);
					ListValue.flush();
					ListValue.close();
					
				}
				logger.info(" Duration Ajax Call :  Ends Here ");	
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			ListValue.println(duration);
			ListValue.flush();
			ListValue.close();
			

		}
	
		else if(listType.equalsIgnoreCase("Users")){
			logger.info("Inside Users Ajax Call :  Starts Here ");	
			try {
				WorkFlowTasksController.getUsers(resourceRequest, resourceResponse);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Users Ajax Call :  Ends Here ");		
		}	
			else if (listType.equalsIgnoreCase("CompOffProject")) {
				
				logger.info("Inside CompOff Project Ajax Call :  Starts Here ");	
			
			try {
				
				List <LMSProjectDetails> projDetails =LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(loggedInEmpId);
				int size = projDetails.size();
				String projNames = "<option value=\"select\">--Select--</option>" +"<option value=\"TRZ-809\">Leave of Absence</option>";
				
				
				for(int i=0;i<size;i++){
					if((resourceRequest.getParameter("project"))!=null){
					if((projDetails.get(i).getProjectCode()).equalsIgnoreCase(resourceRequest.getParameter("project"))){
						logger.info("project to be set on load: "+resourceRequest.getParameter("project"));
						projNames = projNames+"<option value=\""+projDetails.get(i).getProjectCode()+"\" selected>"+projDetails.get(i).getProjectName()+"</option>";	
					}
					else if((resourceRequest.getParameter("project")).equalsIgnoreCase("TRZ-809")){
						logger.info("project to be set on load is TRZ-809");
						projNames="<option value=\"select\">--Select--</option>" +"<option value=\"TRZ-809\" selected>Leave of Absence</option>"+"<option value=\""+projDetails.get(i).getProjectCode()+"\">"+projDetails.get(i).getProjectName()+"</option>";
						
					}
					else{
						projNames = projNames+"<option value=\""+projDetails.get(i).getProjectCode()+"\">"+projDetails.get(i).getProjectName()+"</option>";
					}
					}
					else{
						projNames = projNames+"<option value=\""+projDetails.get(i).getProjectCode()+"\">"+projDetails.get(i).getProjectName()+"</option>";
					}	
				
				}
				ListValue.println(projNames.toString());
				ListValue.flush();
				ListValue.close();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info(" CompOff Project Ajax Call :  Ends Here ");
			
			}
		else if (listType.equalsIgnoreCase("compOffApprover")){
			
			logger.info("Inside CompOff Approver Ajax Call :  Starts Here ");
				String projectName = resourceRequest.getParameter("projName");
				String approver="";
				int approverId = 0;
				try {
					List <LMSProjectDetails> projDetails =LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(getLoggedInEmployeeId(resourceRequest, resourceResponse));
					String supervisor = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(getLoggedInEmployeeId(resourceRequest, resourceResponse)).getSupervisorName();
					int supervisorEmpId = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(getLoggedInEmployeeId(resourceRequest, resourceResponse)).getSupervisorId();
					int size = projDetails.size();
					if(projectName.equalsIgnoreCase("TRZ-809")){
						approver = supervisor;
						approverId = supervisorEmpId;
					}
					else{
					for (int j = 0; j < size; j++) {
						
					if(projectName.equalsIgnoreCase(projDetails.get(j).getProjectCode())){
									approver = projDetails.get(j).getApproverName();
									approverId = projDetails.get(j).getApproverID();
					}
					}
					}
					ListValue.println(approver+"="+approverId);
					ListValue.flush();
					ListValue.close();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				logger.info(" CompOff Approver Ajax Call :  Ends Here ");
				}
		
		else if (listType.equalsIgnoreCase("CompOffDate")){
			
			logger.info("Inside CompOff Date Ajax Call :  Starts Here ");
				Map<String,String> responseMap = new HashMap<String,String>(); 
				String message="You cannot select a Working Day";
				try {
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
				String compoffString = resourceRequest.getParameter("compDate");
				Date compoffDate = new Date();
				compoffDate = fm.parse(compoffString);
				logger.info(compoffDate);
				SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
				
				List<LMSHolidays> holidayList = new ArrayList<LMSHolidays>();
				String employeeLocation = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(loggedInEmpId).getLocation();
				String employeeCountry = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(loggedInEmpId).getRegion();
				//Getting Holidays List based on Employee Location
				 holidayList = LMSHolidaysLocalServiceUtil.getHolidaysByLocation(employeeLocation);
				String empWeekends = String.valueOf(LMSWeekendsLocalServiceUtil.getLMSWeekendsByLocation(employeeCountry).getWeekendDays());
				String[] weekendsArray = empWeekends.split(",");
				List<String> weekendsList = Arrays.asList(weekendsArray);
				securaxEmployeeHrs	hrs = null;
				WFHManulPunch mhrs = null;
				logger.info(weekendsList);
				try{
					logger.info("employee hours : ");
					hrs = securaxEmployeeHrsLocalServiceUtil.getsecureHrsPunchDateByEmployeeId(loggedInEmpId, compoffDate);
					logger.info("hrs : " + hrs);
				}catch(NoSuchsecuraxEmployeeHrsException e){
					logger.info("No Employee Details exists in securaxEmployeeHrs for employee : " + loggedInEmpId + " date :" + compoffDate);
					//e.printStackTrace();
				}

				if(hrs == null){
					try{
					mhrs =	WFHManulPunchLocalServiceUtil.getManualPunchInDetails(loggedInEmpId, compoffDate);
					logger.info("mhrs : " + mhrs);
					}catch(NoSuchWFHManulPunchException e){
						logger.info("No Employee Details exists in WFHManulPunch for employee : " + loggedInEmpId + " date :" + compoffDate);
						//e.printStackTrace();
					}
				}
				String totalHrs = "";
				String logoutTime = "";
				String loginTime = "";
				String isValid = "false";
				if(hrs!=null){
				if(hrs.getPunchInTime()!=null){
					
					loginTime = hrs.getPunchInTime().toString().split(" ")[1];
					logoutTime =  hrs.getPunchOutTime().toString().split(" ")[1];
					final int MILLI_TO_HOUR = 1000 * 60 * 60;
					totalHrs = String.valueOf(((hrs.getPunchOutTime().getTime()  - hrs.getPunchInTime().getTime() )/MILLI_TO_HOUR));
					
					
					responseMap.put("inTime", loginTime);
					responseMap.put("outTime", logoutTime);
					responseMap.put("totalHrs", totalHrs);
					
					
					for(LMSHolidays hlist : holidayList){
					
						if(fm.format(hlist.getHolidayDate()).equals(fm.format(compoffDate))){
							
							message = "you worked on a Holiday";
							isValid = "true";
						}				
					}
					
					
					if(simpleDateformat.format(compoffDate).equalsIgnoreCase(weekendsArray[0]) || simpleDateformat.format(compoffDate).equalsIgnoreCase(weekendsArray[1])){  //should be made dynami based on region
						message = "you worked on a weekend";
						isValid = "true";
					}
					
					
					
				}else if(hrs.getPunchInTime()==null){
						message = "Please Select A day you have worked for";
					}
					
				}else if(mhrs!=null){
					
						if(mhrs.getIntime()!=null){
							
							loginTime = mhrs.getIntime().toString().split(" ")[1];
							logoutTime =  mhrs.getOutTime().toString().split(" ")[1];
							final int MILLI_TO_HOUR = 1000 * 60 * 60;
							totalHrs = String.valueOf(((mhrs.getOutTime().getTime()  - mhrs.getIntime().getTime() )/MILLI_TO_HOUR));
							
							
							responseMap.put("inTime", loginTime);
							responseMap.put("outTime", logoutTime);
							responseMap.put("totalHrs", totalHrs);
							
							logger.info(" loginTime : " + loginTime + " logoutTime : " + logoutTime +  " totalHrs : " + totalHrs);
							for(LMSHolidays hlist : holidayList){
							
								if(fm.format(hlist.getHolidayDate()).equals(fm.format(compoffDate))){
									
									message = "you worked on a Holiday";
									isValid = "true";
								}				
							}
							
							
							if(simpleDateformat.format(compoffDate).equalsIgnoreCase(weekendsArray[0]) || simpleDateformat.format(compoffDate).equalsIgnoreCase(weekendsArray[1])){  //should be made dynami based on region
								message = "you worked on a weekend";
								isValid = "true";
							}
							
							
							
						}else if(mhrs.getIntime()==null){
							message = "Please Select A day you have worked for";
						}
						
				}else{
					message = "Please Select A day you have worked for";
				}
				
					responseMap.put("message", message);
					responseMap.put("isValid", isValid.trim());
					String responseString = ""+message+"-"+loginTime+"-"+logoutTime+"-"+totalHrs+"-"+isValid;
					
					logger.info("Response String: "+""+message+"-"+loginTime+"-"+logoutTime+"-"+totalHrs+"-"+isValid);
					ListValue.println(responseString);
					ListValue.flush();
					ListValue.close();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				logger.info(" CompOff Date Ajax Call :  Ends Here ");
			}else if(listType.equalsIgnoreCase("getUpdatedLeaves")){
				logger.info("Inside get Updated Leave Ajax Call :  Starts Here ");
				String effectiveDate = resourceRequest.getParameter("effDate");
				String balances = getLeaveBalances(resourceRequest,resourceResponse, effectiveDate);
				ListValue.println(balances);
				ListValue.flush();
				ListValue.close();
				
				logger.info(" get Updated Leave Ajax Call :  Ends Here ");
			}
		else{
				
		
		}
		
	
	}	
	
	}
		}
		catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			/**********phani******************/ catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		

		super.serveResource(resourceRequest, resourceResponse);
		
	}
	public List<String> uniqueApproversList(List<LMSProjectDetails> projectListofLoggedInEmployee) {
	       
		List<String> uniqueList = new ArrayList<String>();
		for (LMSProjectDetails project : projectListofLoggedInEmployee) {
			
    		
    		if(!uniqueList.isEmpty()&&uniqueList!=null)
    		{
    			if(!(uniqueList.contains(project.getApproverEmail())))
    			{
    				//logger.info("no duplicates --added to list--");
    				
    				uniqueList.add(project.getApproverEmail());
    				
    			}
    		}
    		else{
    			//logger.info("empty list===");
    			uniqueList.add(project.getApproverEmail());
    		}
		}
		return uniqueList;
        }

	public void applyLeave(ActionRequest request,ActionResponse response) throws IOException, ParseException, SystemException, PortalException, AddressException{
		
		logger.info("Inside applyLeave Method :  Starts Here ");
		
		
		LMSLeaveInformation leaveRequest;
		String isDraft=request.getParameter("isDraft");
		
		
		if(isDraft.equalsIgnoreCase("N")){
		//response.setRenderParameter("absenceStatus", request.getParameter("absenceStatus"));
		response.setRenderParameter("absenceType", request.getParameter("absenceType"));
		response.setRenderParameter("absenceCategory", request.getParameter("absenceCategory"));
		if(request.getParameter("absenceReason")!=null){
		response.setRenderParameter("absenceReason", request.getParameter("absenceReason"));
		}
		response.setRenderParameter("startDate", request.getParameter("startDate"));
		response.setRenderParameter("endDate", request.getParameter("endDate"));
		response.setRenderParameter("day",request.getParameter("day"));
		response.setRenderParameter("total", request.getParameter("total"));
		//response.setRenderParameter("project", request.getParameter("project"));
		//response.setRenderParameter("approver", request.getParameter("approver"));
		response.setRenderParameter("comments", request.getParameter("comments"));
		response.setRenderParameter("isDraft", request.getParameter("isDraft"));
		
		}
		
		List<LMSLeaveInformation> getAllLeaveRecords = LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformations(0, LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformationsCount());
		List<Integer>getAllSno = new ArrayList<Integer>();
		for(LMSLeaveInformation leaveinfo : getAllLeaveRecords)
		{
			getAllSno.add(leaveinfo.getSNo());
			
		}
		List<Integer>copyOfgetAllSno = new ArrayList<Integer>(getAllSno);
		Collections.sort(copyOfgetAllSno);
		int sNotoCreate = copyOfgetAllSno.get(copyOfgetAllSno.size()-1)+1;
		System.out.println(sNotoCreate);
		
		
		if((request.getParameter("LeaveReqNo"))!=null){
		if(((request.getParameter("LeaveReqNo")).isEmpty())){
			
			leaveRequest=LMSLeaveInformationLocalServiceUtil.createLMSLeaveInformation(sNotoCreate);
		}
		else{
			leaveRequest=LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId((request.getParameter("LeaveReqNo")));		
		}
		}
		else{
			
			leaveRequest=LMSLeaveInformationLocalServiceUtil.createLMSLeaveInformation(sNotoCreate);
		}
		leaveRequest.setCreatedDate(new Date());

		leaveRequest.setEmployeeId(getLoggedInEmployeeId(request, response));
		
		logger.info("absenceType"+"    :" +request.getParameter("absenceType"));
		logger.info("absenceCategory"+"    :" +request.getParameter("absenceCategory"));
		logger.info("startDate"+"    :" +request.getParameter("startDate"));
		logger.info("endDate"+"    :" +request.getParameter("endDate"));
		logger.info("total"+"    :" +request.getParameter("total"));
		logger.info("comments"+"    :" +request.getParameter("comments"));
		logger.info("isDraft"+"    :" +request.getParameter("isDraft"));
	
		if(((request.getParameter("LeaveReqNo"))!=null)&&((request.getParameter("LeaveReqNo"))!="")){
			leaveRequest.setLeaveRequestId(request.getParameter("LeaveReqNo"));
			}
			else{
				leaveRequest.setLeaveRequestId("TRZ"+"00"+leaveRequest.getSNo());	
				
			}
		
		if(((request.getParameter("absenceType"))!=null)&&(!(request.getParameter("absenceType")).equalsIgnoreCase("select"))){
		
		leaveRequest.setAbsenceType(LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(Integer.parseInt(request.getParameter("absenceType"))));
		leaveRequest.setLeaveTypeCode(Integer.parseInt(request.getParameter("absenceType")));
		leaveRequest.setLeaveCategoryCode(LeaveCategoriesLocalServiceUtil.getCategoryIdByName(request.getParameter("absenceCategory"),Integer.parseInt(request.getParameter("absenceType"))));
		}
		else{
			
			leaveRequest.setAbsenceType("");
			leaveRequest.setLeaveTypeCode(0);
			leaveRequest.setLeaveCategoryCode("");
			
		}
		
		leaveRequest.setSupervisorID(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(getLoggedInEmployeeId(request, response)).getSupervisorId());


		if(((request.getParameter("startDate"))!=null)&&((request.getParameter("startDate"))!="")){
			
		leaveRequest.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate")));
		}
		else{
			
			leaveRequest.setStartDate(null);
		}
		if(((request.getParameter("endDate"))!=null)&&((request.getParameter("endDate"))!="")){
			
			leaveRequest.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate")));
			}
			else{
				
				leaveRequest.setEndDate(null);
			}
		if(((request.getParameter("total"))!=null)&&(!((request.getParameter("total")).isEmpty()))){
			leaveRequest.setDuration(Double.parseDouble(request.getParameter("total")));
			}
		else{
			leaveRequest.setDuration(0);
		}

		leaveRequest.setComments(request.getParameter("comments"));
		leaveRequest.setIsDraft(request.getParameter("isDraft"));
		StringBuilder approversList = new StringBuilder();

		List<LMSProjectDetails>projectListofLoggedInEmployee=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(leaveRequest.getEmployeeId());
		/*for(LMSProjectDetails project:projectListofLoggedInEmployee)
		{
			
			String approvermail=project.getApproverEmail();
			approversList.append("'").append(approvermail.replace("'", "\\'")).append("',");

		}*/
		if((!projectListofLoggedInEmployee.isEmpty())&&(projectListofLoggedInEmployee!=null))
		{
			List<String> uniqueApproversList=uniqueApproversList(projectListofLoggedInEmployee);
			logger.info("uniqueprojectlist size=="+uniqueApproversList.size());
			for(String project:uniqueApproversList)
			{
				
				String approvermail=project;
				approversList.append("'").append(approvermail.replace("'", "\\'")).append("',");

			}
			logger.info("approversList ====="+approversList.toString());

			leaveRequest.setApproverEmails(approversList.toString());
		}
			

		
		if(isDraft.equalsIgnoreCase("Y")){
			leaveRequest.setApprovalStatus("Saved as Draft");
			if((request.getParameter("LeaveReqNo"))!=null){
				if(((request.getParameter("LeaveReqNo")).isEmpty())){
					
					
					LMSLeaveInformationLocalServiceUtil.addLMSLeaveInformation(leaveRequest);
					LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
					
					log.setLeaveRequestId(leaveRequest.getSNo());
					log.setAction("Created Draft");
					log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName());
					log.setCreatedDate(new Date());
					LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
				}
				else{
					LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveRequest);	
					LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
					
					log.setLeaveRequestId(leaveRequest.getSNo());
					log.setAction("Updated Draft");
					log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName());
					log.setCreatedDate(new Date());
					LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
				}
				}
				else{
					
					LMSLeaveInformationLocalServiceUtil.addLMSLeaveInformation(leaveRequest);
					LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
					
					log.setLeaveRequestId(leaveRequest.getSNo());
					log.setAction("Created Draft");
					log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName());
					log.setCreatedDate(new Date());
					LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
				}
			response.setRenderParameter("mvcPath","/jsp/LeaveHistory.jsp");
			logger.info("applyLeave Method  for Save as Draft:  Ends Here ");
		}
		else{
			/*******************************************check past dated or future dated*********************************/
	
			
			
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String inputDate = df.format(leaveRequest.getStartDate());
			//String projectcode=leaveRequest.getProjectCode();
            Date inputStartDate = df.parse(inputDate);

			String Date=df.format(new Date());
			
          
            Date currentDate = df.parse(Date);
            int check=inputStartDate.compareTo(currentDate);
            
           
           
            // approval of pm  i.e approver & fyi to employee and supervisor
            //comparing current date and start date

            if(inputStartDate.before(currentDate)||check !=0 && check != 1)//past dated autoapproval
				{
            	String mailBody = "content/mail/template/mail-body.tmpl";
            	InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
            	String body;
            	body = StringUtil.read(inputStream);


            	Date date = new Date();
            	DateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
            	
					
					leaveRequest.setApprovalStatus("Approved");
					logger.info("past dated:::Autoapproval===========");
					
					if((request.getParameter("LeaveReqNo"))!=null){
						if(((request.getParameter("LeaveReqNo")).isEmpty())){
						int logId = ((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
						LMSLeaveInformationLocalServiceUtil.addLMSLeaveInformation(leaveRequest);
						
						LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit(logId);
						
						
						
						log.setLeaveRequestId(leaveRequest.getSNo());
						log.setAction("Auto Approved Leave Request");
						log.setActionBy("");
						log.setCreatedDate(new Date());
						
						LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
						}
						else
						{
							LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveRequest);	
							LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
						
							log.setLeaveRequestId(leaveRequest.getSNo());
							log.setAction("Auto Approved Leave Request");
							log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName());
							
							log.setCreatedDate(new Date());
							LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
						}
					}
						else
						{
							LMSLeaveInformationLocalServiceUtil.addLMSLeaveInformation(leaveRequest);
							int logId = ((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
							LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit(logId);
							
							
							
							log.setLeaveRequestId(leaveRequest.getSNo());
							log.setAction("Auto Approved Leave Request");
							log.setActionBy("");
							log.setCreatedDate(new Date());
							
							LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
						}
				    
						//SendMail.sendmail(0,leaveRequest);
						 List<LMSProjectDetails>projectListofLeaveRequestedEmployeeId=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(leaveRequest.getEmployeeId());

						/*if(projectListofLeaveRequestedEmployeeId.size()>0){
							for(LMSProjectDetails project:projectListofLoggedInEmployee) 
							{
								String leaveApproverEmail=project.getApproverEmail();
								String strtDate = dateformat.format(leaveRequest.getStartDate());
				            	String endDate=dateformat.format(leaveRequest.getEndDate());
				            	String currentdate=df.format(date);
							String approvalSubjectforApproverSupervisor="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName())+" has been approved";

							SendMail.triggerEmailForApprover(leaveRequest.getEmployeeId(),approvalSubjectforApproverSupervisor,leaveApproverEmail,leaveRequest,body,strtDate,endDate,currentdate);	
							}
							SendMail.sendmail(0,leaveRequest);
								}*/
						 if(projectListofLeaveRequestedEmployeeId.size()>0){
							 
							 List<String> uniqueApproversList=uniqueApproversList(projectListofLeaveRequestedEmployeeId);
								for(String approvermail:uniqueApproversList) 
								{
									String strtDate = dateformat.format(leaveRequest.getStartDate());
					            	String endDate=dateformat.format(leaveRequest.getEndDate());
					            	String currentdate=df.format(date);
								String approvalSubjectforApproverSupervisor="[TEST MAIL: PLS IGNORE]FYI: Leave of Absence for ".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName())+" has been approved";

								SendMail.triggerEmailForApprover(leaveRequest.getEmployeeId(),approvalSubjectforApproverSupervisor,approvermail,leaveRequest,body,strtDate,endDate,currentdate);	
							}
							SendMail.sendmail(0,leaveRequest);
								}
									else
								{
									//SendMail.sendmail(0,leaveRequest);

								}

						//deducting leave balances 
						
						LeaveBalance lbalance = LeaveBalanceLocalServiceUtil.getLeaveBalance(leaveRequest.getEmployeeId());
						double elBal = lbalance.getELBalance();
						double clBal = lbalance.getCLBalance();
						double compBal = lbalance.getCompOffLeaveBalance();
						logger.info(" initial EL bal : " + elBal + " ,CL : " + clBal + ",CompOff " + compBal);
						double duration = leaveRequest.getDuration();
						String leaveType = leaveRequest.getAbsenceType();
						leaveType = leaveType.replace("\n", "").replace("\r", "");
						logger.info("duration of leave : " + duration + " and leave type : " + leaveType);
						if(("Contingency Leave").equalsIgnoreCase(leaveType.trim())){
							logger.info(" deducting CL leaves ");
							clBal-=duration;
						}else if(("Earned Leave").equalsIgnoreCase(leaveType.trim())){
							logger.info(" deducting EL leaves ");
							elBal-=duration;				
						}else if(("Compensatory Off").equalsIgnoreCase(leaveType.trim())){
							logger.info(" deducting compoff leaves ");
							compBal-=duration;
						}else{
								logger.info("neither EL nor CL");					
							}
						logger.info(" final  EL : "+elBal +"  CL  " + clBal + " CompBal  "+ compBal ) ;
						lbalance.setELBalance(elBal);
						lbalance.setCLBalance(clBal);
						lbalance.setCompOffLeaveBalance(compBal);
						LeaveBalanceLocalServiceUtil.updateLeaveBalance(lbalance);
						
						
						//SendMail.sendmail(0,leaveRequest);
					response.setRenderParameter("mvcPath", "/jsp/LeaveSummary.jsp");
					logger.info("applyLeave Method for Auto Approval:  Ends Here ");
					
				}
				else//future dated
				{
					
					
					leaveRequest.setApprovalStatus("Pending");
					
						
						
						
						if((request.getParameter("LeaveReqNo"))!=null){
							if(((request.getParameter("LeaveReqNo")).isEmpty())){
								
								int logId = ((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
								LMSLeaveInformationLocalServiceUtil.addLMSLeaveInformation(leaveRequest);
								
								LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit(logId);
								
								log.setLeaveRequestId(leaveRequest.getSNo());
								log.setAction("Submitted Leave Request");
								log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName());
								log.setCreatedDate(new Date());
								
								LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
							}
							else{
								LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveRequest);	
								LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
							
								log.setLeaveRequestId(leaveRequest.getSNo());
								log.setAction("Submitted Leave Request");
								log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName());
								
								log.setCreatedDate(new Date());
								LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
							}
							}
							else{
								int logId = ((LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1));
								LMSLeaveInformationLocalServiceUtil.addLMSLeaveInformation(leaveRequest);
								
								LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit(logId);
								
								
								
								log.setLeaveRequestId(leaveRequest.getSNo());
								log.setAction("Submitted Leave Request");
								log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequest.getEmployeeId()).getEmployeeName());
								log.setCreatedDate(new Date());
								
								
								
								LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
							}
						
						response.setRenderParameter("mvcPath", "/jsp/LeaveSummary.jsp");
						initiateWorkflow(request, response,leaveRequest.getLeaveRequestId());
						logger.info("applyLeave Method  for Future Date:  Ends Here ");
					}
		}
	}
	
	
/*****This method called when HR enters Leave Request ID OR Employee Name OR Employee ID to get that Employee leave history ***/
	
	
	public void hrGetEmployeeLeaveInformation(ActionRequest request, ActionResponse response)throws IOException,PortalException, SystemException, ParseException
	{
		logger.info("Inside hrGetEmployeeLeaveInformation Method:  Starts Here ");
		
		String leaveRequestID = request.getParameter("LeaveReqNo");
		String employeeName = request.getParameter("EmployeeName");
		String employeeID = request.getParameter("EmployeeID");
		
		
		if(leaveRequestID!=null || employeeName!=null||employeeID!=null)
		{
		
			request.getPortletSession().setAttribute("leaveRequestID", leaveRequestID, PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().setAttribute("EmployeeName", employeeName, PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().setAttribute("EmployeeID", employeeID, PortletSession.APPLICATION_SCOPE);
			
		
		response.setRenderParameter("mvcPath", "/hr_jsp/GetEmployeeLeaveInformation.jsp");
		logger.info(" hrGetEmployeeLeaveInformation Method:  Ends Here ");
		}
		else
		{
				
			response.setRenderParameter("mvcPath", "/hr_jsp/SearchLeave.jsp");
			logger.info(" hrGetEmployeeLeaveInformation Method:  Ends Here ");
		}
		
		
			
		
	}
	
	
	
	
/*****This method called when HR enters Leave Request ID OR Employee Name OR Employee ID to get that Employee leave history  Ends Here***/	
	
	
//When HR gets request to Edit the Leave, This page will display Particular leave details based on Leave Request Id	
	public void hrEditLeave(ActionRequest request,ActionResponse response) throws IOException, ParseException, SystemException, PortalException, AddressException{
		
		logger.info("Inside hrEditLeave Method:  Starts Here ");
		
		String leaveReqNo = request.getParameter("LeaveReqNo");
		LMSLeaveInformation leaveInfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqNo);
		String notifyHRMsg = "";
		
		if(leaveInfo.getApprovalStatus().equalsIgnoreCase("Approved"))
		{
		
		response.setRenderParameter("ReqEmployeeID", String.valueOf(leaveInfo.getEmployeeId()));
		response.setRenderParameter("LeaveReqNumber", String.valueOf(leaveReqNo));
		

				
		if((!(leaveInfo.getAbsenceType()).isEmpty()) && (leaveInfo.getAbsenceType())!=null){
			
			response.setRenderParameter("absenceType", leaveInfo.getAbsenceType());
			response.setRenderParameter("absenceTypeCode", String.valueOf(leaveInfo.getLeaveTypeCode()));
			appliedLeaveType = leaveInfo.getAbsenceType();
			
			}
		
			
		if((!(leaveInfo.getLeaveCategoryCode()).isEmpty()) && (leaveInfo.getLeaveCategoryCode())!=null){
		
			response.setRenderParameter("absenceCategory",LeaveCategoriesLocalServiceUtil.getCategoryNameByID(leaveInfo.getLeaveCategoryCode(), leaveInfo.getLeaveTypeCode()));
		}
		
		
	
		if((leaveInfo.getStartDate()!=null)){
			
			response.setRenderParameter("startDatetoSet", new SimpleDateFormat("yyyy-MM-dd").format(leaveInfo.getStartDate()));
		}
		
		
		if((leaveInfo.getEndDate()!=null)){
			
			response.setRenderParameter("endDatetoSet", new SimpleDateFormat("yyyy-MM-dd").format(leaveInfo.getEndDate()));
		}
		
		
		
		if((leaveInfo.getDuration())%1==0.0){
		
			response.setRenderParameter("day", "fullDay");
		}else{
			response.setRenderParameter("day", "halfDay");
		}
		if((leaveInfo.getDuration()!=0.00)){
			
			response.setRenderParameter("total", String.valueOf(leaveInfo.getDuration()));
			
		}
	
		
		response.setRenderParameter("comments",leaveInfo.getComments());
		response.setRenderParameter("mvcPath","/hr_jsp/HREditLeave.jsp");	
		logger.info(" hrEditLeave Method: Successfully Ends Here ");
		
		}
		else
		{
			 notifyHRMsg = "Not a approved request";
			response.setRenderParameter("notificationMsg", notifyHRMsg);
			logger.info("hrEditLeave Method with Warning message   Ends Here ");
			
		}
		
		
	}

	
	public void hrUpdateLeave(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ParseException
	{
		
		logger.info("Inside hrUpdateLeave Method:  Starts Here ");
		String leaveReqNumber = request.getParameter("LeaveReqNo");
		logger.info("Updating Leave Req Number"+leaveReqNumber); 
		
		int newabsenceTypeCode = Integer.parseInt(request.getParameter("absenceType"));
		String absenceCategory =request.getParameter("absenceCategory");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String duration = request.getParameter("total");
		String comments = request.getParameter("comments");
		
		double newDuration =  Double.parseDouble(duration);
		
		LMSLeaveInformation leaveReqtoUpdate = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqNumber);
		double previousDuration = leaveReqtoUpdate.getDuration();
		int previousLeaveTypeCode = leaveReqtoUpdate.getLeaveTypeCode();
		String previousLeaveTypeName = LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(previousLeaveTypeCode);
		//Getting old LeaveType leaves Here
		LMSLeaveType oldLeatypeDetails = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(previousLeaveTypeCode);
		//Getting New Leavetype Details here
		LMSLeaveType newleaveTypeDetailsbyCode = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(newabsenceTypeCode);
		//Getting login Employee Leavebal details here
		LeaveBalance lbalance = LeaveBalanceLocalServiceUtil.getLeaveBalance(leaveReqtoUpdate.getEmployeeId());
		
		double duratnNeedtoBeUpdated = 0.0;
		double baltoBeUpdated=0.0;
		duratnNeedtoBeUpdated = (previousDuration-newDuration);
		if(previousLeaveTypeCode == newabsenceTypeCode)
		{
			
			
			if((previousLeaveTypeName.toLowerCase()).contains("earned"))
			{
				baltoBeUpdated = lbalance.getELBalance()+duratnNeedtoBeUpdated;
				lbalance.setELBalance(baltoBeUpdated);
			}
			else if((previousLeaveTypeName.toLowerCase()).contains("compensatory"))
			{
				baltoBeUpdated = lbalance.getCompOffLeaveBalance()+duratnNeedtoBeUpdated;
				lbalance.setCompOffLeaveBalance(baltoBeUpdated);
			}
			else if((previousLeaveTypeName.toLowerCase()).contains("contingency"))
			{
				baltoBeUpdated = lbalance.getCLBalance()+duratnNeedtoBeUpdated;
				lbalance.setCLBalance(baltoBeUpdated);
			}
		}
		
		else{
	
			
						//Updating earned Leave Balances
						if((previousLeaveTypeName.toLowerCase()).contains("earned"))
						{
							if(duratnNeedtoBeUpdated == 0)
							{
							 baltoBeUpdated = lbalance.getELBalance()+previousDuration;
							
							}
							
							else
							{
							 baltoBeUpdated = lbalance.getELBalance()+Math.abs(duratnNeedtoBeUpdated);
							}
							
							
							lbalance.setELBalance(baltoBeUpdated);
						}
						//Updating CompOff LeaveBal
						else if((previousLeaveTypeName.toLowerCase()).contains("compensatory"))
						{
							if(duratnNeedtoBeUpdated == 0)
							{
							
							baltoBeUpdated = lbalance.getCompOffLeaveBalance()+previousDuration;
							}
							else
							{
								baltoBeUpdated = lbalance.getCompOffLeaveBalance()+Math.abs(duratnNeedtoBeUpdated);
							}
							lbalance.setCompOffLeaveBalance(baltoBeUpdated);
						}
						//Updating Contigency LeaveBal
						else if((previousLeaveTypeName.toLowerCase()).contains("contingency"))
						{
							if(duratnNeedtoBeUpdated == 0)
							{
							baltoBeUpdated = lbalance.getCLBalance()+Math.abs(duratnNeedtoBeUpdated);
							}
							else
							{
								baltoBeUpdated = lbalance.getCLBalance()+previousDuration;
							}
							lbalance.setCLBalance(baltoBeUpdated);
						}
					
					//}
			
			
		
	}
		
		
		LeaveBalanceLocalServiceUtil.updateLeaveBalance(lbalance);
		updateLeaveBal(newabsenceTypeCode,leaveReqtoUpdate.getEmployeeId(),newDuration);
		
		//To get LeaveTypeCategory code by CategoryName
		
		List<LeaveCategories> categoryCode = LeaveCategoriesLocalServiceUtil.getCategoriesByName(absenceCategory);
		
		
		//To update Edited Details
		leaveReqtoUpdate.setLeaveTypeCode(newabsenceTypeCode);
		leaveReqtoUpdate.setAbsenceType(newleaveTypeDetailsbyCode.getLeaveTypeName());
		leaveReqtoUpdate.setComments(comments);
		leaveReqtoUpdate.setDuration(Double.parseDouble(duration));
		leaveReqtoUpdate.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		leaveReqtoUpdate.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		leaveReqtoUpdate.setLeaveCategoryCode(categoryCode.get(0).getLeaveCategoryCode());
	
		
		LMSEmployeeDetails requestedEmployeeDetails = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveReqtoUpdate.getEmployeeId());
		
		leaveReqtoUpdate.setSupervisorID(requestedEmployeeDetails.getSupervisorId());
		
		
		LMSLeaveInformationLocalServiceUtil.updateLMSLeaveInformation(leaveReqtoUpdate);
		LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit(LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1);
		
		log.setLeaveRequestId(leaveReqtoUpdate.getSNo());
		log.setAction("Updated Leave Request");
		log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(getLoggedInEmployeeId(request, response)).getEmployeeName());
		log.setCreatedDate(new Date());
		LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
		
		//To show in Leave Summary Page
		
		response.setRenderParameter("absenceType", String.valueOf(leaveReqtoUpdate.getLeaveTypeCode()));
		response.setRenderParameter("absenceCategory", LeaveCategoriesLocalServiceUtil.getCategoryNameByID(leaveReqtoUpdate.getLeaveCategoryCode(), leaveReqtoUpdate.getLeaveTypeCode()));
		response.setRenderParameter("startDate", new SimpleDateFormat("yyyy-MM-dd").format(leaveReqtoUpdate.getStartDate()));
		response.setRenderParameter("endDate", new SimpleDateFormat("yyyy-MM-dd").format(leaveReqtoUpdate.getEndDate()));
		response.setRenderParameter("total", String.valueOf(leaveReqtoUpdate.getDuration()));
		response.setRenderParameter("comments", leaveReqtoUpdate.getComments());
		
		response.setRenderParameter("mvcPath", "/jsp/LeaveSummary.jsp");
		logger.info(" hrUpdateLeave Method:  Ends Here ");
		
	}
	
		
	private  void updateLeaveBal(int leaveTypeCode , int EmployeeID, double duration) throws PortalException, SystemException
	{
		logger.info("Inside  updateLeaveBal Method :  Starts Here ");
		LeaveBalance lbalance = LeaveBalanceLocalServiceUtil.getLeaveBalance(EmployeeID);
		String LeaveTypeName = LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(leaveTypeCode);
		double newDuration =0.0;
		if((LeaveTypeName.toLowerCase()).contains("earned"))
		{
			newDuration = (lbalance.getELBalance()- duration);
			lbalance.setELBalance(newDuration);
		}
		else if((LeaveTypeName.toLowerCase()).contains("compensatory"))
		{
			newDuration = (lbalance.getCompOffLeaveBalance()- duration);
			lbalance.setCompOffLeaveBalance(newDuration);
		}
		else if((LeaveTypeName.toLowerCase()).contains("contingency"))
		{
			newDuration = (lbalance.getCLBalance()- duration);
			lbalance.setCLBalance(newDuration);
		}
		
		LeaveBalanceLocalServiceUtil.updateLeaveBalance(lbalance);
		logger.info(" updateLeaveBal Method :  Ends Here ");
	}
		
public void hrcancelLeave(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		 int loggedInhrEmployeeId= LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(themeDisplay.getUser().getEmailAddress()).getEmployeeId();
	 String deletionSubjectforEmployee="[TEST MAIL: PLS IGNORE]FYI:Leave of Absence has been cancelled";
			String leaveReqId = request.getParameter("LeaveReqNo");
			LMSLeaveInformation linfo=LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqId);
				int leaveRequestedEmployeeId=linfo.getEmployeeId();
				String deletionSubjectforHR="[TEST MAIL: PLS IGNORE]FYI:Leave of Absence for".concat(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveRequestedEmployeeId).getEmployeeName())+" has been cancelled";			
			int Sno= linfo.getSNo();
			long companyId=themeDisplay.getCompanyId();
			
			/****************** Updating Leave Balance code starts Here *********************/
			int EmployeeId = linfo.getEmployeeId();
			LeaveBalance lbalanceToUpdate = LeaveBalanceLocalServiceUtil.getLeaveBalance(EmployeeId);
			LMSLeaveType leaveTypetoCheckAcrl = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(linfo.getLeaveTypeCode());
			double duration = 0.0;
			String LeaveTypeName=LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(linfo.getLeaveTypeCode());
			if(leaveTypetoCheckAcrl.getMonthlyAccrual().equalsIgnoreCase("yes"))
			{
					if((LeaveTypeName.toLowerCase()).contains("earned"))
					{
						duration = lbalanceToUpdate.getELBalance()+linfo.getDuration();
						lbalanceToUpdate.setELBalance(duration);
					}
					else if((LeaveTypeName.toLowerCase()).contains("compensatory"))
					{
						duration = lbalanceToUpdate.getCompOffLeaveBalance()+linfo.getDuration();
						lbalanceToUpdate.setCompOffLeaveBalance(duration);
					}
					else if((LeaveTypeName.toLowerCase()).contains("contingency"))
					{
						duration = lbalanceToUpdate.getCLBalance()+linfo.getDuration();
						lbalanceToUpdate.setCLBalance(duration);
					}
			}
					
			LeaveBalanceLocalServiceUtil.updateLeaveBalance(lbalanceToUpdate);
			/*************** Updating Leave Balance code Ends Here *********************************/
			
			logger.info("Sno in cancel leave: " +Sno);
			int leaveReqEmpId=linfo.getEmployeeId();
			 List<LMSProjectDetails>projectListofleaveReqEmpId=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(leaveReqEmpId);
			 logger.info("apply leavecontroller ===approvers list size"+projectListofleaveReqEmpId.size());
				
				for(LMSProjectDetails project:projectListofleaveReqEmpId) 
				{
					int approverid=project.getApproverID();
					String concatedkey=String.valueOf(approverid)+String.valueOf(Sno);//sno
					long classPK=Long.parseLong(concatedkey);
					
					
					
					
			WorkflowInstanceLink wfInstanceLink=WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, themeDisplay.getScopeGroupId(), LMSLeaveInformation.class.getName(), classPK);
			
			long workflowInstanceId=wfInstanceLink.getWorkflowInstanceId();
			WorkflowInstance wfInstance=WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowInstanceId);
			logger.info("wf instance definition name---"+wfInstance.getWorkflowDefinitionName());
			Map<String, Serializable> workflowContext=wfInstance.getWorkflowContext();
			WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.STATUS_INACTIVE, workflowContext);
			
				}
			
				System.out.println("in hr cancel==approved status updated to cancelled===");
				String mailBody = "content/mail/template/mail-body.tmpl";
				InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
				String body;
				
				try {
					body = StringUtil.read(inputStream);
					Date date = new Date();
					DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
					String strtDate = df.format(linfo.getStartDate());
					String endDate=df.format(linfo.getEndDate());
					String currentdate=df.format(date);
					SendMail.triggerEmailForEmployee(leaveRequestedEmployeeId,deletionSubjectforEmployee,linfo,body,strtDate,endDate,currentdate);
					SendMail.triggerEmailForEmployee(loggedInhrEmployeeId,deletionSubjectforHR,linfo,body,strtDate,endDate,currentdate);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			response.setRenderParameter("mvcPath", "/hr_jsp/GetEmployeeLeaveInformation.jsp");
			
		}



	public void employeecancelLeave(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		 String deletionSubjectforEmployee="[TEST MAIL: PLS IGNORE]FYI:Leave of Absence has been cancelled";

				String leaveReqId = request.getParameter("LeaveReqNo");
				LMSLeaveInformation linfo=LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqId);
				int Sno= linfo.getSNo();
				long companyId=themeDisplay.getCompanyId();
				logger.info("Sno in emp cancel leave: " +Sno);
				
			/****************** Updating Leave Balance code starts Here *********************/
			int EmployeeId = linfo.getEmployeeId();
			LeaveBalance lbalanceToUpdate = LeaveBalanceLocalServiceUtil.getLeaveBalance(EmployeeId);
			LMSLeaveType leaveTypetoCheckAcrl = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(linfo.getLeaveTypeCode());
			double duration = 0.0;
			String LeaveTypeName=LMSLeaveTypeLocalServiceUtil.getLeaveTypeNameByCode(linfo.getLeaveTypeCode());
			
		/**	if(leaveTypetoCheckAcrl.getMonthlyAccrual().equalsIgnoreCase("yes"))
			{
					if((LeaveTypeName.toLowerCase()).contains("earned"))
					{
						duration = lbalanceToUpdate.getELBalance()+linfo.getDuration();
						lbalanceToUpdate.setELBalance(duration);
					}
					else if((LeaveTypeName.toLowerCase()).contains("compensatory"))
					{
						duration = lbalanceToUpdate.getCompOffLeaveBalance()+linfo.getDuration();
						lbalanceToUpdate.setCompOffLeaveBalance(duration);
					}
					else if((LeaveTypeName.toLowerCase()).contains("contingency"))
					{
						duration = lbalanceToUpdate.getCLBalance()+linfo.getDuration();
						lbalanceToUpdate.setCLBalance(duration);
					}
			}**/
					
			LeaveBalanceLocalServiceUtil.updateLeaveBalance(lbalanceToUpdate);
			/*************** Updating Leave Balance code Ends Here *********************************/
				int loggedInEmployeeId= LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(themeDisplay.getUser().getEmailAddress()).getEmployeeId();
				 List<LMSProjectDetails>projectListofLoggedInEmployee=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(loggedInEmployeeId);
					logger.info("apply leavecontroller ===approvers list size"+projectListofLoggedInEmployee.size());
					
					for(LMSProjectDetails project:projectListofLoggedInEmployee) 
					{
						int approverid=project.getApproverID();
						String concatedkey=String.valueOf(approverid)+String.valueOf(Sno);//sno
						long classPK=Long.parseLong(concatedkey);
						WorkflowInstanceLink wfInstanceLink=WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, themeDisplay.getScopeGroupId(), LMSLeaveInformation.class.getName(), classPK);
						long workflowInstanceId=wfInstanceLink.getWorkflowInstanceId();
						WorkflowInstance wfInstance=WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowInstanceId);
						//logger.info("wf instance definition name---"+wfInstance.getWorkflowDefinitionName());
						Map<String, Serializable> workflowContext=wfInstance.getWorkflowContext();
					//	workflowContext.put("approverEmail", project.getApproverEmail());
						int pendingcount=WorkflowTaskManagerUtil.getWorkflowTaskCount(companyId, false);
						//logger.info("pendingwfcount"+pendingcount);
						List<WorkflowTask>pendingwfTaskList=WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, 0, pendingcount, null);
								
						//logger.info("pendingwfTaskList size==="+pendingwfTaskList.size());
						
					
						for(WorkflowTask pendingtask:pendingwfTaskList)
						{
							//logger.info("pending taskid"+pendingtask.getWorkflowTaskId());
							if(pendingtask.getWorkflowInstanceId()==workflowInstanceId)
							{
								logger.info("matched");
								//completing task by redirecting to Cancelled transition
								WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), pendingtask.getWorkflowTaskId(),"Cancelled", "cancelling", workflowContext);
								

							}
							
							
						}
					}
				
				
				
				
				
				
				
				
				
				logger.info("in employee cancel ==pending status updated to cancelled======");
				String mailBody = "content/mail/template/mail-body.tmpl";
				InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
				String body;
				
				try {
					body = StringUtil.read(inputStream);
					Date date = new Date();
					DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
					String strtDate = df.format(linfo.getStartDate());
					String endDate=df.format(linfo.getEndDate());
					String currentdate=df.format(date);
					
					SendMail.triggerEmailForEmployee(loggedInEmployeeId,deletionSubjectforEmployee,linfo,body,strtDate,endDate,currentdate);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LeaveInformationAudit log=LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit(LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1);
				log.setLeaveRequestId(Sno);
				log.setAction(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(Sno).getEmployeeId()).getEmployeeName() + " Canceled Leave");
				log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(Sno).getEmployeeId()).getEmployeeName());
				log.setCreatedDate(new Date());
				LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
				
				response.setRenderParameter("mvcPath", "/jsp/LeaveHistory.jsp");
				
			}
	
public void editLeave(ActionRequest request,ActionResponse response) throws IOException, ParseException, SystemException, PortalException{
		
		String leaveReqNo = request.getParameter("LeaveReqNo");
	
		
		logger.info("Leave Request Number in edit leave: " +leaveReqNo);
		response.setRenderParameter("LeaveRequestNo",String.valueOf(leaveReqNo));
		LMSLeaveInformation leaveInfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqNo);
		
				if((!(leaveInfo.getAbsenceType()).isEmpty()) && (leaveInfo.getAbsenceType())!=null){
			
			response.setRenderParameter("absenceType", leaveInfo.getAbsenceType());
			response.setRenderParameter("absenceTypeCode", String.valueOf(leaveInfo.getLeaveTypeCode()));
		}
		
			
				if((!(leaveInfo.getLeaveCategoryCode()).isEmpty()) && (leaveInfo.getLeaveCategoryCode())!=null){
			
			response.setRenderParameter("absenceCategory",LeaveCategoriesLocalServiceUtil.getCategoryNameByID(leaveInfo.getLeaveCategoryCode(), leaveInfo.getLeaveTypeCode()));
		}
		
		
		
		/*
		if((leaveInfo.getLeaveReasonCode())!=0){
			
			
			response.setRenderParameter("absenceReasonCode", String.valueOf(leaveInfo.getLeaveReasonCode()));
			response.setRenderParameter("absenceReason", LeaveReasonLocalServiceUtil.getReasonByLeaveType(leaveInfo.getLeaveReasonCode()));
			
		}*/
		
		if((leaveInfo.getStartDate()!=null)){
			
			response.setRenderParameter("startDatetoSet", new SimpleDateFormat("yyyy-MM-dd").format(leaveInfo.getStartDate()));
		}
		
		
		if((leaveInfo.getEndDate()!=null)){
			
			response.setRenderParameter("endDatetoSet", new SimpleDateFormat("yyyy-MM-dd").format(leaveInfo.getEndDate()));
		}
		
		
		//logger.info("modulus value: "+ (leaveInfo.getDuration())%1);
		if((leaveInfo.getDuration())%1==0.0){
		
			response.setRenderParameter("day", "fullDay");
		}else{
			response.setRenderParameter("day", "halfDay");
		}
		if((leaveInfo.getDuration()!=0.00)){
			
			response.setRenderParameter("total", String.valueOf(leaveInfo.getDuration()));
			
		}
		


	/*if((leaveInfo.getApproverID())!=0){
		
		response.setRenderParameter("approver", LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getApproverID()).getEmployeeName());
	}*/
	
	
		response.setRenderParameter("comments",leaveInfo.getComments());
		
		
		response.setRenderParameter("mvcPath","/jsp/EditLeave.jsp");
	
	
	}

private void initiateWorkflow(ActionRequest request,ActionResponse response, String LeaveReqId) throws PortalException, SystemException {
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	LMSLeaveInformation leaveInfo = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(LeaveReqId);
	
	try{
	
	WorkflowDefinitionLink workflowDefinitionLink=null;
	try{
		
	workflowDefinitionLink=
	WorkflowDefinitionLinkLocalServiceUtil.
	getDefaultWorkflowDefinitionLink(themeDisplay.getCompanyId(), LMSLeaveInformation.class.getName(), 0, 0);
	}catch (Exception e) {
		if(e instanceof NoSuchWorkflowDefinitionLinkException){
			SessionMessages.add(request.getPortletSession(),"workflow-not-enabled");
			}
			e.printStackTrace();
			}
	com.liferay.portal.service.ServiceContext serviceContext = ServiceContextFactory.getInstance(LMSLeaveInformation.class.getName(), request);
	//checking workflow defintion is enabled to leave asset or not
	if(leaveInfo!=null&&workflowDefinitionLink!=null){
		//add leave asset in asset entry table
		
		AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
				LMSLeaveInformation.class.getName(), leaveInfo.getSNo(),
		serviceContext.getAssetCategoryIds(),
		serviceContext.getAssetTagNames());
		
		logger.info("in applyleave controller====PK==="+leaveInfo.getPrimaryKey());
		 Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
		 workflowContext.put("loggedinUserId", themeDisplay.getUserId());
		 workflowContext.put("sno", leaveInfo.getPrimaryKey());
		 workflowContext.put("leaveRequestId", LeaveReqId);
		 
//for getting all the approvers 
		 
		 int loggedInEmployeeId= LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(themeDisplay.getUser().getEmailAddress()).getEmployeeId();
	
		 /*******  Sending email to employee and supervisor *******/
		  String pendingsubjectforEmployee="[TEST MAIL: PLS IGNORE] FYI:Leave of Absence has been forwarded";
	String pendingsubjectforSupervisor=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(loggedInEmployeeId).getEmployeeName()+" has applied for leave";
	LMSEmployeeDetails supervisordetails=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getSupervisorID());
	//List<LMSProjectDetails>projectDetailsList=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(loggedInEmployeeId);

	String mailBody = "content/mail/template/mail-body.tmpl";
	InputStream inputStream = ApplyLeaveController.class.getClassLoader().getResourceAsStream(mailBody);
	String body;
	
	body = StringUtil.read(inputStream);
	Date date = new Date();
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	String strtDate = df.format(leaveInfo.getStartDate());
	String endDate=df.format(leaveInfo.getEndDate());
	String currentdate=df.format(date);
	SendMail.triggerEmailForEmployee(loggedInEmployeeId,pendingsubjectforEmployee,leaveInfo,body,strtDate,endDate,currentdate);
	
		  /******************/
		  
		 
		 
		 
		 
		 
		 
		 List<LMSProjectDetails>projectListofLoggedInEmployee=LMSProjectDetailsLocalServiceUtil.getProjectsByEmployeeId(loggedInEmployeeId);
 int index = 0;

 if(projectListofLoggedInEmployee.size()>0)
 {
	 List<String>uniqueApprovers=uniqueApproversList(projectListofLoggedInEmployee);
		SendMail.triggerEmailForSupervisor(loggedInEmployeeId,pendingsubjectforSupervisor,supervisordetails,leaveInfo,body,strtDate,endDate,currentdate); 	
		 logger.info("apply leavecontroller ===approvers list size"+uniqueApprovers.size());

	 for(String approvermail:uniqueApprovers)
	 {
	 index++; 
	 logger.info("index==="+index);
	 List<LMSProjectDetails>approverDetail=LMSProjectDetailsLocalServiceUtil.getEmployeesByApproverEmail(approvermail);
	 
	 for(LMSProjectDetails eachApprover:approverDetail){
		 int approverid=eachApprover.getApproverID();
		User approverUserForWorkflow=UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), approvermail);
		logger.info("approver name"+approverUserForWorkflow.getFullName());
		workflowContext.put("approverUserForWorkflow", approverUserForWorkflow);
		workflowContext.put("approverEmail", approvermail);
		workflowContext.put("index", index);
		 User user=(User) workflowContext.get("approverUserForWorkflow");
			
		// logger.info("from get workflow context==="+ user.getFullName());
		String concatedkey=String.valueOf(approverid)+String.valueOf(leaveInfo.getPrimaryKey());//sno
		long wfprimarykey=Long.parseLong(concatedkey);
		logger.info("concated wfprimarykey "+wfprimarykey);
		WorkflowHandlerRegistryUtil.startWorkflowInstance(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),LMSLeaveInformation.class.getName(), wfprimarykey, leaveInfo, serviceContext, workflowContext);

		logger.info("started wrkflow instance====");
		
		
	 }
	 
 }
 }
			/*if(projectListofLoggedInEmployee.size()>0)
			{
				
				SendMail.triggerEmailForSupervisor(loggedInEmployeeId,pendingsubjectforApproverSupervisor,supervisordetails,leaveInfo,body,strtDate,endDate,currentdate); 	
		 logger.info("apply leavecontroller ===approvers list size"+projectListofLoggedInEmployee.size());
			
			for(LMSProjectDetails project:projectListofLoggedInEmployee) 
			{
				index++;
				System.out.println("index==="+index);
				int approverid=project.getApproverID();
				logger.info("iterating all the projects of emp==="+approverid);
				User approverUserForWorkflow=UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), project.getApproverEmail());
				
				logger.info("approver name"+approverUserForWorkflow.getFullName());
				workflowContext.put("approverUserForWorkflow", approverUserForWorkflow);
				workflowContext.put("approverEmail", approverUserForWorkflow.getEmailAddress());
				workflowContext.put("index", index);
				 User user=(User) workflowContext.get("approverUserForWorkflow");
				
				 logger.info("from get workflow context==="+ user.getFullName());
				String concatedkey=String.valueOf(approverid)+String.valueOf(leaveInfo.getPrimaryKey());//sno
				long wfprimarykey=Long.parseLong(concatedkey);
				logger.info("concated wfprimarykey "+wfprimarykey);
				WorkflowHandlerRegistryUtil.startWorkflowInstance(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),LMSLeaveInformation.class.getName(), wfprimarykey, leaveInfo, serviceContext, workflowContext);

				logger.info("started wrkflow instance====");
				
				
				

			}
					
			}*/
			else{
				index++;
				System.out.println("index==="+index);
				System.out.println("for leave of absence project==supervisor is approver===");
				//LMSEmployeeDetails supervisordetails=LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(leaveInfo.getSupervisorID());
				User approverUserForWorkflow=UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), supervisordetails.getSupervisorEmail());
				int supervisorid=supervisordetails.getSupervisorId();
				
				logger.info("approver name"+approverUserForWorkflow.getFullName());
				workflowContext.put("approverUserForWorkflow", approverUserForWorkflow);
				workflowContext.put("approverEmail", approverUserForWorkflow.getEmailAddress());
				workflowContext.put("index", index);
				 User user=(User) workflowContext.get("approverUserForWorkflow");
				
				 logger.info("from get workflow context==="+ user.getFullName());
				String concatedkey=String.valueOf(supervisorid)+String.valueOf(leaveInfo.getPrimaryKey());//sno
				long wfprimarykey=Long.parseLong(concatedkey);
				logger.info("concated wfprimarykey "+wfprimarykey);
				WorkflowHandlerRegistryUtil.startWorkflowInstance(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),LMSLeaveInformation.class.getName(), wfprimarykey, leaveInfo, serviceContext, workflowContext);

				logger.info("started wrkflow instance====");
			}
		
	}
	if(leaveInfo==null){
		SessionErrors.add(request.getPortletSession(),"leave-submit-failed");
		}else{
		SessionMessages.add(request.getPortletSession(),"leave-submit-success");
		}
	}catch (Exception e) {
		if(e instanceof NoSuchWorkflowDefinitionLinkException){
			SessionMessages.add(request.getPortletSession(),"workflow-not-enabled");
			}
			e.printStackTrace();
			}
	
	
	
}
public void deleteLeave(ActionRequest request,ActionResponse response) throws IOException, ParseException, SystemException, PortalException{
	logger.info("deleteLeave Method starts here");
	String leaveReqNo = request.getParameter("LeaveReqNo");
	logger.info("leaveRequest id to Delete "+leaveReqNo);
	
	LMSLeaveInformation leaveinfoTodelete = LMSLeaveInformationLocalServiceUtil.getLeaveByLeaveRequestId(leaveReqNo);
	int Sno = leaveinfoTodelete.getSNo();
	//Creating leavinformation Audit instance 
	LeaveInformationAudit log=	LeaveInformationAuditLocalServiceUtil.createLeaveInformationAudit(LeaveInformationAuditLocalServiceUtil.getLeaveInformationAuditsCount()+1);
	log.setActionBy(LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation(Sno).getEmployeeId()).getEmployeeName());
	
	//Deleting Leave Request
	LMSLeaveInformationLocalServiceUtil.deleteLMSLeaveInformation(Sno);
	
	response.setRenderParameter("mvcPath", "/jsp/LeaveHistory.jsp");
	
	log.setLeaveRequestId(Sno);
	log.setAction("Deleted Leave Request");
	
	log.setCreatedDate(new Date());
	LeaveInformationAuditLocalServiceUtil.addLeaveInformationAudit(log);
	logger.info("deleteLeave Method ends here");
	
}
	
	
	public static int getLoggedInEmployeeId(PortletRequest request,PortletResponse response){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String emailId = themeDisplay.getUser().getEmailAddress();
		
		try {
			return LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(emailId).getEmployeeId();
		} catch (NoSuchEmployeeDetailsException e) {
		
			return 0;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return 0;
		}
		
		
		
		
	}
	
public void sendmailforactionstatus(LMSLeaveInformation leaveInfo) throws AddressException, IOException, PortalException, SystemException{
		
		
		logger.info("in send mail for action status");

		
	    int actionstatus=0;
	    
	    if((leaveInfo.getApprovalStatus().equalsIgnoreCase("Approved"))){
	    	actionstatus = 0;
	    }
	    else if((leaveInfo.getApprovalStatus().equalsIgnoreCase("Pending"))){
	    	actionstatus = 1;
	    }
	    else if((leaveInfo.getApprovalStatus().equalsIgnoreCase("Rejected"))){
	    	actionstatus = 4;
	    }
	    else if((leaveInfo.getApprovalStatus().equalsIgnoreCase("Inactive"))){//for deleted leaves
	    	actionstatus = 5;
	    }
	    else if((leaveInfo.getApprovalStatus().equalsIgnoreCase("Incomplete"))){//for deleted leaves
	    	actionstatus = 6;
	    }
	    else{
	    	actionstatus = 1;
	    	
	    }  
	
		SendMail.sendmail(actionstatus,leaveInfo);

	}
public void viewStatus(ActionRequest request,ActionResponse response){
	response.setRenderParameter("LeaveReqNo", request.getParameter("LeaveReqNo"));
	
	response.setRenderParameter("mvcPath","/jsp/LeaveRequestLog.jsp");
	
}
public void addLeaveType(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	LMSAdminController.addLeaveType(request, response);;
}
public void editLeaveDef(ActionRequest request,ActionResponse response) throws PortalException, SystemException, IOException	{
	
	LMSAdminController.editLeaveDef(request,response);
}
public void updateLeaveType(ActionRequest request,ActionResponse response) throws PortalException, SystemException	{
	
	LMSAdminController.updateLeaveType(request,response);
}
public void deleteLeaveDef(ActionRequest request,ActionResponse response) throws PortalException, SystemException	{
	
	LMSAdminController.deleteLeaveDef(request,response);
}
public String getLeaveBalances(ResourceRequest request, ResourceResponse response, String effectiveDate) throws PortalException, SystemException	{
	
	String balances = LeaveBalanceController.getLeaveBalances(request,response,effectiveDate);
	return balances;
	
}
public void editHoliday(ActionRequest request,ActionResponse response) throws PortalException, SystemException	{
	
	LMSAdminController.editHoliday(request,response);
}
public void deleteHoliday(ActionRequest request,ActionResponse response) throws PortalException, SystemException	{
	
	LMSAdminController.deleteHoliday(request,response);
}

public void approveLeave(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
	
	WorkFlowTasksController.approveLeave(request,response);
}
public void rejectLeave(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
	
	WorkFlowTasksController.rejectLeave(request,response);
}
public void delegateLeave(ActionRequest request,ActionResponse response) throws AddressException, SystemException, PortalException, IOException{
	
	WorkFlowTasksController.delegateLeave(request,response);
}
public void applyCompOff(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	CompensatoryOffController.applyCompOff(request,response);
}
public void approveCompoff(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{

	CompensatoryOffController.approveCompoff(request,response);
}
public void rejectCompoff(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	//DocumentsDownload.getDownloads(request, response);
	CompensatoryOffController.rejectCompoff(request,response);
}
public void delegateCompoff(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	logger.info("in delegate method apply leave controller");
}
public void saveHoliday(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	LMSAdminController.saveHoliday(request, response);
}
public void saveEditHoliday(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	LMSAdminController.saveEditHoliday(request, response);
}
public void addLeavePolicy(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	LMSAdminController.addLeavePolicy(request, response);
}
public void editLeavePolicy(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	LMSAdminController.editLeavePolicy(request, response);
}

public void updateLeavePolicy(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	LMSAdminController.updateLeavePolicy(request, response);
}
public void deleteLeavePolicy(ActionRequest request,ActionResponse response) throws PortalException, SystemException, ParseException	{
	
	LMSAdminController.deleteLeavePolicy(request, response);
}
public void saveWeekends(ActionRequest request,ActionResponse response) throws SystemException, NoSuchWeekendsException{
	
	LMSAdminController.saveWeekends(request,response);
}
}
