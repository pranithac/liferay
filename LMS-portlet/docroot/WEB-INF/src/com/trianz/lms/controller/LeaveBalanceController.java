package com.trianz.lms.controller;

/*import com.leaveBalance.controllers.model.LMSEmployeeDetails;
import com.leaveBalance.controllers.model.LeaveBalance;
import com.leaveBalance.controllers.model.LeaveInformation;
import com.leaveBalance.controllers.service.LMSEmployeeDetailsLocalServiceUtil;
import com.leaveBalance.controllers.service.LeaveBalanceLocalServiceUtil;
import com.leaveBalance.controllers.service.LeaveInformationLocalServiceUtil;
import com.leaveBalance.utility.JdbcLeaveBalance;*/
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.trianz.lms.NoSuchEmployeeDetailsException;
import com.trianz.lms.NoSuchLeaveBalanceException;
import com.trianz.lms.model.LMSEmployeeDetails;
import com.trianz.lms.model.LMSLeaveInformation;
import com.trianz.lms.model.LMSLeaveType;



import com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil;
import com.trianz.lms.service.LMSLeaveTypeLocalServiceUtil;






import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class LeaveBalanceController extends MVCPortlet {
	private static final Logger logger = Logger.getLogger(LeaveBalanceController.class.getName());
	
	
	public static int getLoggedInEmployeeId(PortletRequest request,PortletResponse response) throws NoSuchEmployeeDetailsException, SystemException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String emailId = themeDisplay.getUser().getEmailAddress();
		
		return LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(emailId).getEmployeeId();
		
		
		
		
	}
	public static String  getLeaveBalances(ResourceRequest resourceRequest, ResourceResponse resourceResponse,String effDateString)  {
		String finalResponse = "";
		try {
			
			List<LMSLeaveInformation> totalLeaveRecords = LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformations(0, LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformationsCount());
			
			/*for(LMSLeaveInformation linfo : totalLeaveRecords){
				if(linfo.getLeaveTypeCode() == 5){
					LMSLeaveInformationLocalServiceUtil.deleteLMSLeaveInformation(linfo);
				}
			}*/
					
			/*JdbcLeaveBalance jbal = new JdbcLeaveBalance();
			jbal.getdate();*/

			//LeaveController lc = new LeaveController(); 
			//System.out.println(lc.getLoggedInEmployeeId(req, res));
			int employeeId = getLoggedInEmployeeId(resourceRequest, resourceResponse);
			//LeaveBalance leavebal = LeaveBalanceLocalServiceUtil.getLeaveBalanceByEmpID(employeeId);
			LMSEmployeeDetails empDetails = LMSEmployeeDetailsLocalServiceUtil.getLMSEmployeeDetails(employeeId);
			Calendar caleff = Calendar.getInstance();
			Calendar caljoin = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date joiningDate = empDetails.getJoiningDate();           // if effective date is less than joining date need to validate
			
			System.out.println("actual joining date : " + joiningDate);
			
			//String effDateString = req.getParameter("effDate");
			//System.out.println("actual effective date : " + effDateString);
			
			Date effectiveDate = df.parse(effDateString);
			caleff.setTime(effectiveDate);
			caljoin.setTime(joiningDate);
			//caljoin.add(Calendar.DATE, 2);	// adding 2 days to joining date
			String message = "";
			double finalELLeave = 0;
			double finalCLLeave = 0;
			System.out.println("Employee Id " + employeeId + "joining date : " + caljoin.getTime());
			if(caleff.getTime().after(caljoin.getTime())){   //effective date should not be before the date of joining
				//System.out.println(effectiveDate.before(joiningDate));
				//System.out.println("effective date : " + caleff.getTime());
				
								
				int numberOfYears = caleff.get(Calendar.YEAR)-caljoin.get(Calendar.YEAR);
				int numberofMonths = caleff.get(Calendar.MONTH)-caljoin.get(Calendar.MONTH);
				//int numberofDays = caleff.get(Calendar.DATE)-caljoin.get(Calendar.DATE);

				//System.out.println(caleff.get(Calendar.DATE) + "---"  +caleff.get(Calendar.MONTH) + "==== " + caleff.get(Calendar.YEAR) );
				//System.out.println(caljoin.get(Calendar.DATE) + "---"  + caljoin.get(Calendar.MONTH) + "==== " + caljoin.get(Calendar.YEAR));
				System.out.println( " numberOfYears " + numberOfYears + " numberofMonths " + numberofMonths);
				
				int totalNumberOfMonths = 0;
				if(numberOfYears!=0){
						totalNumberOfMonths+=  numberOfYears*12;;	
				}if(numberofMonths!=0){
					totalNumberOfMonths+= numberofMonths;
				}
				System.out.println(" totalNumberOfMonths " + totalNumberOfMonths);
				
				
				int ELLeaveTypeCode = LMSLeaveTypeLocalServiceUtil.getLeaveTypeCodeByName("Earned Leave");
				
			
				int CLLeaveTypeCode = LMSLeaveTypeLocalServiceUtil.getLeaveTypeCodeByName("Contingency Leave");
				
				//int CompOffLeaveTypeCode = 2;
				
				LMSLeaveType ELLeave = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(ELLeaveTypeCode);
				LMSLeaveType CLLeave = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(CLLeaveTypeCode);
				//LMSLeaveType CmpOffLeave = LMSLeaveTypeLocalServiceUtil.getLMSLeaveType(CompOffLeaveTypeCode);
				
				double totalEarnedLeaves = totalNumberOfMonths*ELLeave.getAccrualValue();
				double totalContingencyLeaves = totalNumberOfMonths*CLLeave.getAccrualValue();
				System.out.println(" totalEarnedLeaves " + totalEarnedLeaves + " === " + " totalContingencyLeaves " +  totalContingencyLeaves);
				//if joining date is less than 15th of the month, that calculation should be performed
				
				List<LMSLeaveInformation> leaveinfo = LMSLeaveInformationLocalServiceUtil.getleavesByEmployeeID(employeeId);
				System.out.println("LeaveInformation : " +leaveinfo.size() );
				
				double ELCount = 0;
				double CLCount = 0;
				for(LMSLeaveInformation linfo: leaveinfo){
					String absenceType = linfo.getAbsenceType();
					Calendar calStartDate = Calendar.getInstance();
					Date startDate = linfo.getStartDate();
					
					if(startDate!=null){
					calStartDate.setTime(startDate);
					//calStartDate.add(Calendar.DATE, 2);
					String approvalStatus = linfo.getApprovalStatus();
					
					//System.out.println("start date of leave " + calStartDate.getTime());
					//System.out.println("effective date : " + effectiveDate);
					System.out.println("absenceType : " + absenceType + " approval status " + approvalStatus  + " leave Request ID " + linfo.getLeaveRequestId());
					                                        
					if(absenceType.equals("Earned Leave") && !(calStartDate.getTime()).after(effectiveDate) && approvalStatus.equals("Approved")){
						System.out.println("inside Earned Leave" + linfo.getDuration());
						ELCount+=linfo.getDuration();									
					}else if(absenceType.equals("Contingency Leave") && !(calStartDate.getTime()).after(effectiveDate) && approvalStatus.equals("Approved")){
						System.out.println("inside Contingency Leave" + linfo.getDuration());
						CLCount +=linfo.getDuration();					
					}
				}
				}
				System.out.println("ELCount to be deducted from totalEarnedLeaves : " + ELCount + " CLCount to be deducted from totalContingencyLeaves " + CLCount);
			//if date of joining is after 15th of the month
			//System.out.println("joining date only " + caljoin.get(Calendar.DATE));
			if(caljoin.get(Calendar.DATE)>15){
				System.out.println("date of joining is greater then 15th ");
				finalELLeave = totalEarnedLeaves-ELCount;
				finalCLLeave = totalContingencyLeaves-CLCount;
				
				finalELLeave-=0.5;
				finalCLLeave-=0.5;
			}else{
				System.out.println("date of joining is less then 15th ");
				finalELLeave = totalEarnedLeaves-ELCount;
				finalCLLeave = totalContingencyLeaves-CLCount;
			}			
			System.out.println("EmployeeId " + employeeId + " final EL Leave " + finalELLeave + " final CL Leave " + finalCLLeave );
			
			message = "Leave Balances till " + (df.format(effectiveDate));
				
			}else{
				message = "Please select the effective date on or after Your Date of Joining";				
			}
			
			//res.setRenderParameter("status", message);
			//res.setRenderParameter("ELLeaveBal", finalELLeave+"");
			//res.setRenderParameter("CLLeaveBal", finalCLLeave+"");
			finalResponse = message+"="+finalELLeave+"="+finalCLLeave;
			
			System.out.println("finalResponse leave balances : " + finalResponse);
		}catch (NoSuchLeaveBalanceException e) { 
			e.printStackTrace();
		} 
		catch (SystemException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return finalResponse;
		// res.setRenderParameter("mvcPath",
				//	"/jsp/CheckLeave.jsp");
	}
}
