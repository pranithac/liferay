package com.trianz.lms.controller;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;






import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;






import com.trianz.lms.NoSuchWeekendsException;
import com.trianz.lms.model.LMSHolidays;
import com.trianz.lms.model.LMSLeavePolicies;
import com.trianz.lms.model.LMSLeaveType;
import com.trianz.lms.model.LMSWeekends;
import com.trianz.lms.model.LeaveCategories;
import com.trianz.lms.service.*;



public class LMSAdminController extends MVCPortlet {
	
	private static final Logger logger = Logger.getLogger(LMSAdminController.class.getName());
	
	

	public static void saveHoliday(ActionRequest request, ActionResponse response) throws ParseException, SystemException, NumberFormatException, PortalException{
		logger.info("in save holiday ");
		
		String occDate = request.getParameter("occDate");
		String occDesc = request.getParameter("occDesc");
		
		String[] locations = request.getParameterValues("locations");
		List<String> locationsList = Arrays.asList(locations); 
		String allLocations = "";
		for(String location : locationsList){
			allLocations+=location+",";
		}
		StringBuilder allocationsSB = new StringBuilder(allLocations);
		allLocations = allocationsSB.deleteCharAt(allLocations.length() - 1).toString();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
	Date occationDate =	new SimpleDateFormat("yyyy-MM-dd").parse(occDate);
						
		int year = Integer.parseInt(df.format(occationDate));
		List<LMSHolidays> holidaysByYear = LMSHolidaysLocalServiceUtil.getHolidaysByYear(year);
		String isHolidaysExist = "";
		for(LMSHolidays holiday : holidaysByYear){
			
			//need to remove 
			Calendar c = Calendar.getInstance();
			c.setTime(holiday.getHolidayDate()); // Now use today date.
		//	c.add(Calendar.DATE, 2); // Adding 2 days
			
		if(occationDate.compareTo(c.getTime()) == 0){
			logger.info("allLocations " + allLocations + " holiday.getLocationsApplicable() " + holiday.getLocationsApplicable() );
				if(allLocations.equalsIgnoreCase(holiday.getLocationsApplicable())){
					logger.info(" occationDate " + occationDate + " holiday date " + c.getTime() + " holiday id " + holiday.getHolidayId());
					isHolidaysExist = "Holiday Already Exist for " + occDate +" and " + holiday.getLocationsApplicable() + "locations";	
				}
			}
		}
		
		if(isHolidaysExist.equalsIgnoreCase("")){
			LMSHolidays holidayList =LMSHolidaysLocalServiceUtil.createLMSHolidays(LMSHolidaysLocalServiceUtil.getLMSHolidaysesCount()+1);
			holidayList.setHolidayDate(occationDate);
			holidayList.setHolidayYear(year);
			holidayList.setOccassion(occDesc);
			holidayList.setLocationsApplicable(allLocations);
			LMSHolidaysLocalServiceUtil.addLMSHolidays(holidayList);
		}
		request.setAttribute("isHolidaysExist", isHolidaysExist);
		response.setRenderParameter("mvcPath","/hr_jsp/HolidaysView.jsp");
	}

	
	public static void saveEditHoliday(ActionRequest request, ActionResponse response) throws ParseException, SystemException, NumberFormatException, PortalException{
		
		logger.info("in saveEditHoliday ");
		
		String occDate = request.getParameter("occDate");
		String occDesc = request.getParameter("occDesc");
		
		String[] locations = request.getParameterValues("locations");
		List<String> locationsList = Arrays.asList(locations); 
		String allLocations = "";
		for(String location : locationsList){
			allLocations+=location+",";
		}
		StringBuilder allocationsSB = new StringBuilder(allLocations);
		allLocations = allocationsSB.deleteCharAt(allLocations.length() - 1).toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		Date occationDate =	new SimpleDateFormat("yyyy-MM-dd").parse(occDate);
	
		int year = Integer.parseInt(df.format(occationDate));
		List<LMSHolidays> holidaysByYear = LMSHolidaysLocalServiceUtil.getHolidaysByYear(year);
		String isHolidaysExist = "";
		for(LMSHolidays holiday : holidaysByYear){
			
			//need to remove 
			Calendar c = Calendar.getInstance();
			c.setTime(holiday.getHolidayDate()); // Now use today date.
			//c.add(Calendar.DATE, 2); // Adding 2 days
			
		if(occationDate.compareTo(c.getTime()) == 0){
			logger.info("allLocations " + allLocations + " holiday.getLocationsApplicable() " + holiday.getLocationsApplicable() );
				if(allLocations.equalsIgnoreCase(holiday.getLocationsApplicable())){
					logger.info(" occationDate " + occationDate + " holiday date " + c.getTime() + " holiday id " + holiday.getHolidayId());
					isHolidaysExist = "Holiday Already Exist for " + occDate +" and " + holiday.getLocationsApplicable() + "locations";	
				}
			}
		}
		
		
		if(isHolidaysExist.equalsIgnoreCase("")){
		LMSHolidays holidayList =LMSHolidaysLocalServiceUtil.getLMSHolidays(Integer.parseInt(request.getParameter("HolidayId")));
		holidayList.setHolidayDate(occationDate);
		holidayList.setHolidayYear(year);
		holidayList.setOccassion(occDesc);
		holidayList.setLocationsApplicable(allLocations);
		LMSHolidaysLocalServiceUtil.updateLMSHolidays(holidayList);
		}

		request.setAttribute("isHolidaysExist", isHolidaysExist);
		response.setRenderParameter("mvcPath","/hr_jsp/HolidaysView.jsp");
	}
	
	
	public static void editHoliday(ActionRequest request, ActionResponse response){
		logger.info("in edit holidays ");
		
		
		int HolidayId = Integer.parseInt(request.getParameter("HolidayID"));
		LMSHolidays holiday;
		try {
			holiday = LMSHolidaysLocalServiceUtil.getLMSHolidays(HolidayId);
			logger.info("Holiday ID in edit: "+String.valueOf(HolidayId));
			response.setRenderParameter("HolidayId",String.valueOf(HolidayId) );
			
			
			response.setRenderParameter("HolidayDate", new SimpleDateFormat("yyyy-MM-dd").format(holiday.getHolidayDate()));
			response.setRenderParameter("Occasion",holiday.getOccassion());
			
			
			String[] locStringArray = holiday.getLocationsApplicable().split(",");
			
			
			
			for(int i=0;i<locStringArray.length;i++){
				logger.info("response " + locStringArray[i]);
				response.setRenderParameter(locStringArray[i], locStringArray[i]);
			}
			/*response.setRenderParameter("Bangalore", holiday.getBangalore());
			response.setRenderParameter("Chennai",holiday.getChennai() );
			response.setRenderParameter("Hyderabad",holiday.getHyderabad() );
			response.setRenderParameter("NoidaDelhiNCR", holiday.getNoidaDelhiNCR());
			response.setRenderParameter("Mumbai", holiday.getMumbai());
			response.setRenderParameter("Virginia", holiday.getVirginia());
			response.setRenderParameter("California", holiday.getCalifornia());
			response.setRenderParameter("RAK", holiday.getRAK());
			response.setRenderParameter("Dubai", holiday.getDubai());*/
			
			response.setRenderParameter("mvcPath","/hr_jsp/EditHoliday.jsp");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
public static void deleteHoliday(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		
		//logger.info("Deleting Holiday");
		int HolidayId = Integer.parseInt(request.getParameter("HolidayID"));
		LMSHolidaysLocalServiceUtil.deleteLMSHolidays(HolidayId);
		response.setRenderParameter("mvcPath","/hr_jsp/HolidaysView.jsp");
		
	}



/***************************************Add Leave Method ends here ************************************************************/
public static  void addLeaveType(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ParseException{

//int leaveTypeCode = Integer.parseInt(request.getParameter("leaveTypeCode"));
String leaveTypeName = request.getParameter("leaveTypeName");
String leaveCategory = request.getParameter("category");
String leaveCategoryCode = request.getParameter("categoryCode");
String monthlyCredit = request.getParameter("monthlyCredit");
String monthlyCreditVal=request.getParameter("monthlyCreditVal");
String excludeWeekEnds = request.getParameter("excludeWeekends");
String excludeHolidays=request.getParameter("excludeHolidays");
String[] locationApplicable = request.getParameterValues("locations");
String resetBalance=request.getParameter("resetBalance");
String resetInterval=request.getParameter("resetInterval");
String monthlyIntervalStr=request.getParameter("montlyInterval");
String dayIntervalStr = request.getParameter("dayYearlyInterval");
String monthYearlyIntervalStr=request.getParameter("monthYearlyInterval");
String limitvalue = request.getParameter("maxAccrual");

int monthlyInterval = 0;
int intervalday=0;
//int monthYearlyInterval=0;
int maxAccrual=0;
double monthlyAccrualVal =0.0;

StringBuilder locationList = new StringBuilder();

if (locationApplicable.length > 0) {

	    for (String n : locationApplicable) {
	    	locationList.append(n+",");
	    }

}
locationList.deleteCharAt(locationList.length() - 1);

 monthlyAccrualVal=0.0;

if(monthlyCredit.equalsIgnoreCase("yes")){
	
	monthlyAccrualVal = Double.parseDouble(monthlyCreditVal);

}
if(leaveCategory.equalsIgnoreCase("newCategory"))
{
	leaveCategory = request.getParameter("categoryName");
}

List<LeaveCategories> leaveCategories = LeaveCategoriesLocalServiceUtil.getCategoriesByName(leaveCategory);


if(leaveCategoryCode.isEmpty()){
	 
	 leaveCategoryCode =  leaveCategories.get(0).getLeaveCategoryCode();

}

//Getting all Leave Types
List<LMSLeaveType> all = LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypes(0, LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount());


//Creating LeaveType Code to insert new Record

LeaveCategories  leaveCategoriesobj=LeaveCategoriesLocalServiceUtil.createLeaveCategories(LeaveCategoriesLocalServiceUtil.getLeaveCategoriesesCount()+1);
LMSLeaveType  leaveType= LMSLeaveTypeLocalServiceUtil.createLMSLeaveType(LMSLeaveTypeLocalServiceUtil.getLMSLeaveTypesCount()+1);
int leaveTypeCode=0;
if(all.size()>0)
{
 leaveTypeCode = all.get(all.size()-1).getLeaveTypeCode()+1;
leaveType.setLeaveTypeCode(leaveTypeCode);

leaveCategoriesobj.setLeaveTypeCode(leaveTypeCode);
}
else
{
	leaveCategoriesobj.setLeaveTypeCode(leaveType.getLeaveTypeCode());
}
if(resetBalance!=null){
if(resetBalance.equalsIgnoreCase("yes"))
{
	
	if(resetInterval.equalsIgnoreCase("monthly"))
	{
	if(monthlyIntervalStr != null){
		leaveType.setResetInterval(resetInterval);
		
		monthlyInterval = Integer.parseInt(monthlyIntervalStr);
		leaveType.setResetDay(monthlyInterval);
	}
	}
	else if(resetInterval.equalsIgnoreCase("yearly"))
		{
		
		
		leaveType.setResetInterval(resetInterval);
		
		if(dayIntervalStr !=null&&monthYearlyIntervalStr!= null)
		{
			
			int dayInterval = Integer.parseInt(dayIntervalStr);
			int monthYearlyInterval = Integer.parseInt(monthYearlyIntervalStr);
			
			String dayval="";
			String monthVal = "";
			if(dayInterval< 10)
			{
				dayval = "0"+ Integer.toString(dayInterval);
			}
			else
			{
				dayval = Integer.toString(dayInterval);
			}
			
			
			if(monthYearlyInterval<10)
			{
				monthVal = "0"+Integer.toString(monthYearlyInterval);
			}
			else
			{
				monthVal =Integer.toString(monthYearlyInterval);
			}
			 intervalday = Integer.parseInt(dayval+monthVal);
			 logger.info("dayvalue==conc"+intervalday);
			leaveType.setResetDay(intervalday);
			}
		}
	else if(resetInterval.equalsIgnoreCase("days"))
	{
		
		leaveType.setResetInterval(resetInterval);
		if(limitvalue!=null)
		{
			maxAccrual = Integer.parseInt(limitvalue);
			leaveType.setResetDay(maxAccrual);
			
		}
	}
	
}

}




leaveType.setLeaveTypeName(leaveTypeName);
leaveType.setMonthlyAccrual(monthlyCredit);
leaveType.setExcludeHolidays(excludeHolidays);
leaveType.setExcludeWeekEnds(excludeWeekEnds);
leaveType.setAccrualValue(monthlyAccrualVal);
leaveType.setCreditReset(resetBalance);


leaveType.setCountriesApplicable(locationList.toString());
leaveCategoriesobj.setLeaveCategory(leaveCategory);

leaveCategoriesobj.setLeaveCategoryCode(leaveCategoryCode);



LMSLeaveTypeLocalServiceUtil.addLMSLeaveType(leaveType);
LeaveCategoriesLocalServiceUtil.addLeaveCategories(leaveCategoriesobj);

response.setRenderParameter("mvcPath", "/hr_jsp/LeaveTypeList.jsp");
}

/***************************************Add Leave Method ends here ************************************************************/


/**********************************************Edit Leave Methos Starts Here *****************************************************/
public static void editLeaveDef(ActionRequest request,ActionResponse response) throws PortalException, SystemException, IOException
{
	
		logger.info("In Edit Leave Method");
		String leaveTypeCode = request.getParameter("typeCode");
		logger.info("leave Type Codee"+leaveTypeCode);
		int leaveTypeCodeint = Integer.parseInt(leaveTypeCode);
		
		LMSLeaveType leaveTypeobj = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(leaveTypeCodeint);
		LeaveCategories leaveCategory = LeaveCategoriesLocalServiceUtil.getLeaveCategories(leaveTypeCodeint);
		
	
		double MonthlyCreditVal =0.0;
		MonthlyCreditVal = leaveTypeobj.getAccrualValue();
		
		response.setRenderParameter("leaveTypeCode", leaveTypeCode);
		response.setRenderParameter("leaveTypeName", leaveTypeobj.getLeaveTypeName());
		response.setRenderParameter("category", leaveCategory.getLeaveCategory());
		
		
		response.setRenderParameter("MontlyCredit", leaveTypeobj.getMonthlyAccrual());
		response.setRenderParameter("monthlyCreditVal",MonthlyCreditVal+"");
		response.setRenderParameter("ExcludeWeekEnds", leaveTypeobj.getExcludeWeekEnds());
		response.setRenderParameter("ExcludeHolidays", leaveTypeobj.getExcludeHolidays());
		response.setRenderParameter("CreditRest", leaveTypeobj.getCreditReset());
		response.setRenderParameter("ResetIntervalType", leaveTypeobj.getResetInterval());
		response.setRenderParameter("ResetDay", String.valueOf(leaveTypeobj.getResetDay()));
		 	
		 logger.info("Controller Method ends here ");
		response.setRenderParameter("mvcPath", "/hr_jsp/EditLeaveDef.jsp");
		
}

/**********************************************Edit Leave Methos Ends Here *****************************************************/

public static void updateLeaveType(ActionRequest request,ActionResponse response) throws SystemException, PortalException
{
	logger.info(" In Update LeaveType Method");
	int leaveTypeCode = Integer.parseInt(request.getParameter("leaveTypeCode"));
	
	LMSLeaveType  leaveTypetoUpdate = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(leaveTypeCode);
	LeaveCategories leaveCategoryUpdate = LeaveCategoriesLocalServiceUtil.getLeaveCategories(leaveTypeCode);
	
	logger.info("code"+leaveTypeCode);
	String leaveTypeName = request.getParameter("leaveTypeName");
	String leaveCategory = request.getParameter("category");
	String leaveCategoryCode = request.getParameter("categoryCode");
	String monthlyCredit = request.getParameter("monthlyCredit");
	String monthlyCreditVal=request.getParameter("monthlyCreditVal");
	String excludeWeekEnds = request.getParameter("excludeWeekends");
	String excludeHolidays=request.getParameter("excludeHolidays");
	String[] locationApplicable = request.getParameterValues("locations");
	String resetBalance=request.getParameter("resetBalance");
	String resetInterval=request.getParameter("resetInterval");
	String monthlyIntervalStr=request.getParameter("montlyInterval");
	String dayIntervalStr = request.getParameter("dayYearlyInterval");
	String monthYearlyIntervalStr=request.getParameter("monthYearlyInterval");
	String limitvalue = request.getParameter("maxAccrual");
	 
	int monthlydayValue=0;
	int yearlyMonthvalue=0;
	int yearlyDayvalue=0;
	int maxAccrualVal=0;
	int CombinedInterval=0;
	StringBuilder locationList = new StringBuilder();
	
	if (locationApplicable.length > 0) {

	    for (String n : locationApplicable) {
	    	locationList.append(n+",");
	    }

	}
	locationList.deleteCharAt(locationList.length() - 1);
	
	leaveTypetoUpdate.setCountriesApplicable(locationList.toString());

	
	if(resetBalance.equalsIgnoreCase("yes"))
	{
		
		if(resetInterval.equalsIgnoreCase("monthly"))
		{
		if(monthlyIntervalStr != null){
			leaveTypetoUpdate.setResetInterval(resetInterval);
			
			monthlydayValue = Integer.parseInt(monthlyIntervalStr);
			leaveTypetoUpdate.setResetDay(monthlydayValue);
		}
		}
		else if(resetInterval.equalsIgnoreCase("yearly"))
			{
			
			
			leaveTypetoUpdate.setResetInterval(resetInterval);
			
			if(dayIntervalStr !=null&&monthYearlyIntervalStr!= null)
			{
				
				yearlyDayvalue = Integer.parseInt(dayIntervalStr);
				yearlyMonthvalue = Integer.parseInt(monthYearlyIntervalStr);
				
				String dayval="";
				String monthVal = "";
				if(yearlyDayvalue< 10)
				{
					dayval = "0"+ Integer.toString(yearlyDayvalue);
				}
				else
				{
					dayval = Integer.toString(yearlyDayvalue);
				}
				
				
				if(yearlyMonthvalue<10)
				{
					monthVal = "0"+Integer.toString(yearlyMonthvalue);
				}
				else
				{
					monthVal =Integer.toString(yearlyMonthvalue);
				}
				CombinedInterval = Integer.parseInt(dayval+monthVal);
				 logger.info("dayvalue==conc"+CombinedInterval);
				 leaveTypetoUpdate.setResetDay(CombinedInterval);
				}
			}
		else if(resetInterval.equalsIgnoreCase("days"))
		{
			
			leaveTypetoUpdate.setResetInterval(resetInterval);
			if(limitvalue!=null)
			{
				maxAccrualVal = Integer.parseInt(limitvalue);
				leaveTypetoUpdate.setResetDay(maxAccrualVal);
				
			}
		}

		
	}
	
	double monthlyAccrualVal=0.0;
	if(monthlyCredit !=null)
	{
	if(monthlyCredit.equalsIgnoreCase("yes")){
		//System.out.println("1");
		monthlyAccrualVal = Double.parseDouble(monthlyCreditVal);
		//System.out.println("2");

	}
	
		leaveTypetoUpdate.setMonthlyAccrual(monthlyCredit);
		leaveTypetoUpdate.setAccrualValue(monthlyAccrualVal);
	}
	
	
	
	if(leaveCategory.equalsIgnoreCase("newCategory"))
	{
		leaveCategory = request.getParameter("categoryName");
	}
	
	List<LeaveCategories> leaveCategories = LeaveCategoriesLocalServiceUtil.getCategoriesByName(leaveCategory);
	
	
	if(leaveCategoryCode.isEmpty()){
		 
		 leaveCategoryCode =  leaveCategories.get(0).getLeaveCategoryCode();
	
	}
	//leaveTypetoUpdate.setLeaveTypeCode(leaveTypeCode);
	
	if(leaveTypeName!=null){
	leaveTypetoUpdate.setLeaveTypeName(leaveTypeName);
	}
	
	
	if(excludeHolidays!=null){
		leaveTypetoUpdate.setExcludeHolidays(excludeHolidays);
	}
	if(excludeWeekEnds !=null){
	
	leaveTypetoUpdate.setExcludeWeekEnds(excludeWeekEnds);
	}
	
	leaveTypetoUpdate.setCreditReset(resetBalance);
	
	leaveCategoryUpdate.setLeaveCategory(leaveCategory);
	leaveCategoryUpdate.setLeaveCategoryCode(leaveCategoryCode);
	
		LMSLeaveTypeLocalServiceUtil.updateLMSLeaveType(leaveTypetoUpdate);
		LeaveCategoriesLocalServiceUtil.updateLeaveCategories(leaveCategoryUpdate);
		response.setRenderParameter("mvcPath", "/hr_jsp/LeaveTypeList.jsp"); 

}

public static void deleteLeaveDef(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
	
	int LeaveTypeCode=Integer.parseInt(request.getParameter("LeaveTypeCode"));
	LMSLeaveTypeLocalServiceUtil.deleteLMSLeaveType(LeaveTypeCode);
	LeaveCategoriesLocalServiceUtil.deleteLeaveCategories(LeaveTypeCode);
	response.setRenderParameter("mvcPath", "/hr_jsp/LeaveTypeList.jsp");
}
public static void addLeavePolicy(ActionRequest request, ActionResponse response) throws SystemException{

	String project = request.getParameter("project");
	String[] locations = ParamUtil.getParameterValues(request, "holidays");
	String[] leaveTypes = ParamUtil.getParameterValues(request, "leaveTypes");
	  StringBuilder locationList = new StringBuilder();
	  StringBuilder leaveTypesList = new StringBuilder();
	if (locations.length > 0) {
	  

	    for (String n : locations) {
	    	locationList.append(n+",");
	       
	    }

	    locationList.deleteCharAt(locationList.length() - 1);

	    
	} 
	if (leaveTypes.length > 0) {
		  

	    for (String n : leaveTypes) {
	    	leaveTypesList.append(n+",");
	        
	    }

	    leaveTypesList.deleteCharAt(leaveTypesList.length() - 1);

	    
	} 
	logger.info("Selected Project: " +project);
	logger.info("Selected Holidays" +locationList.toString());
	logger.info("Selected Leave Types: "+leaveTypesList.toString());
	
	List<LMSLeavePolicies> all = LMSLeavePoliciesLocalServiceUtil.getLMSLeavePolicieses(0, LMSLeavePoliciesLocalServiceUtil.getLMSLeavePoliciesesCount());
	LMSLeavePolicies leavePolicy = LMSLeavePoliciesLocalServiceUtil.createLMSLeavePolicies(LMSLeavePoliciesLocalServiceUtil.getLMSLeavePoliciesesCount()+1);
	if(all.size()>0)
	{
	int policyCode = all.get(all.size()-1).getPolicyId()+1;
	logger.info("Policy Id==="+policyCode);
	leavePolicy.setPolicyId(policyCode);
	}
	leavePolicy.setProject(project);
	
	leavePolicy.setLeaveTypesApplicable(leaveTypesList.toString());
	leavePolicy.setLocationsApplicable(locationList.toString()); 
	LMSLeavePoliciesLocalServiceUtil.addLMSLeavePolicies(leavePolicy);
	
	/********To get each item in array******************/
	List<String> locationListAp = new ArrayList<String>(Arrays.asList(locationList.toString().split(" , ")));
	List<String> leaveList = new ArrayList<String>(Arrays.asList(leaveTypesList.toString().split(" , ")));
	for(int i=0;i<locationListAp.size();i++){
	logger.info("Holiday array" +locationListAp.get(i));
	}
	
	for(int i=0;i<leaveList.size();i++){
		logger.info("Leave Type array" +leaveList.get(i));
	}
	/********To get each item in array******************/
	
	response.setRenderParameter("mvcPath", "/hr_jsp/ViewLeavePolicies.jsp");
}
public static void editLeavePolicy(ActionRequest request, ActionResponse response)
{
	String PolicyID = request.getParameter("PolicyID");
	response.setRenderParameter("PolicyIdtoeditJsp", PolicyID);
	response.setRenderParameter("mvcPath", "/hr_jsp/editPolicy.jsp");

}

public static void updateLeavePolicy(ActionRequest request, ActionResponse response) throws PortalException, SystemException
{
	
	logger.info("inside update leave Policy Method");
		int policyId  =Integer.parseInt(request.getParameter("PolicyId"));
		LMSLeavePolicies leavePolicyToUpdate = LMSLeavePoliciesLocalServiceUtil.getLMSLeavePolicies(policyId);
		String[] locations = ParamUtil.getParameterValues(request, "holidays");
		String[] leaveTypes = ParamUtil.getParameterValues(request, "leaveTypes");
		  StringBuilder locationsList = new StringBuilder();
		  StringBuilder leaveTypesList = new StringBuilder();
		if (locations.length > 0) {
		  

		    for (String n : locations) {
		    	locationsList.append(n+",");
		      
		    }

		    locationsList.deleteCharAt(locationsList.length() - 1);

		    
		} 
		if (leaveTypes.length > 0) {
			  

		    for (String n : leaveTypes) {
		    	leaveTypesList.append(n+",");
		      
		    }

		    leaveTypesList.deleteCharAt(leaveTypesList.length() - 1);

		    
		} 
		
		//Updating leavePolicy here
		leavePolicyToUpdate.setLeaveTypesApplicable(leaveTypesList.toString());
		leavePolicyToUpdate.setLocationsApplicable(locationsList.toString());
		LMSLeavePoliciesLocalServiceUtil.updateLMSLeavePolicies(leavePolicyToUpdate);
		response.setRenderParameter("mvcPath", "/hr_jsp/ViewLeavePolicies.jsp");
}

public static void deleteLeavePolicy(ActionRequest request, ActionResponse response) throws PortalException, SystemException
{
	logger.info("inside Delete leave Policy Method");
	int policyId  =Integer.parseInt(request.getParameter("PolicyIDtoDelete"));
	
	LMSLeavePoliciesLocalServiceUtil.deleteLMSLeavePolicies(policyId);
	response.setRenderParameter("mvcPath", "/hr_jsp/ViewLeavePolicies.jsp");
	
}
public static void saveWeekends(ActionRequest request, ActionResponse response) throws SystemException{
	
	String location = request.getParameter("location");
	String[] weekends = ParamUtil.getParameterValues(request, "weekends");
	StringBuilder weekendsList = new StringBuilder();
	if (weekends.length > 0) {
		  

	    for (String n : weekends) {
	    	weekendsList.append("'").append(n.replace("'", "\\'")).append("',");
	      
	    }

	    weekendsList.deleteCharAt(weekendsList.length() - 1);
	  

	    
	} 
	logger.info("Inserting weekends "+location+""+weekendsList.toString());
	try {
		
			LMSWeekends weekendDays = LMSWeekendsLocalServiceUtil.getLMSWeekendsByLocation(location);
			weekendDays.setLocation(location);
			weekendDays.setWeekendDays(weekendsList.toString().replace("'",""));
			LMSWeekendsLocalServiceUtil.updateLMSWeekends(weekendDays);
			response.setRenderParameter("mvcPath", "/hr_jsp/AddWeekend.jsp");
		
	} catch (NoSuchWeekendsException e) {
		LMSWeekends weekendDays = LMSWeekendsLocalServiceUtil.createLMSWeekends(LMSWeekendsLocalServiceUtil.getLMSWeekendsesCount()+1);
		weekendDays.setLocation(location);
		weekendDays.setWeekendDays(weekendsList.toString().replace("'",""));
		LMSWeekendsLocalServiceUtil.addLMSWeekends(weekendDays);
		response.setRenderParameter("mvcPath", "/hr_jsp/AddWeekend.jsp");
	}
	
}
}
