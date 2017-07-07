package com.trianz.lms.controller;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.trianz.lms.NoSuchEmployeeDetailsException;
import com.trianz.lms.NoSuchsecuraxEmployeeHrsException;
import com.trianz.lms.model.LMSCompOffLeaveDetails;
import com.trianz.lms.model.LeaveBalance;
import com.trianz.lms.service.LMSCompOffLeaveDetailsLocalServiceUtil;
import com.trianz.lms.service.LMSEmployeeDetailsLocalServiceUtil;
import com.trianz.lms.service.LeaveBalanceLocalServiceUtil;
import com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public class CompensatoryOffController extends MVCPortlet{

	
	public static void applyCompOff(ActionRequest request, ActionResponse response) throws NoSuchEmployeeDetailsException, SystemException, NoSuchsecuraxEmployeeHrsException, ParseException{
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		int employeeId = LMSEmployeeDetailsLocalServiceUtil.getEmployeeByEmailId(themeDisplay.getUser().getEmailAddress()).getEmployeeId();
	
		Date currentDate = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date CompOffRequestDate = fmt.parse(request.getParameter("compDate"));
		String approverName = request.getParameter("approver");
		int approverId = Integer.parseInt(request.getParameter("approverId"));
		System.out.println(approverName + "  ----- " + approverId);
		LMSCompOffLeaveDetails cmpOffLeave ;
			LMSCompOffLeaveDetailsPK lpk = new LMSCompOffLeaveDetailsPK() ;
			lpk.setCompoffDate(CompOffRequestDate);
			lpk.setEmployeeID(employeeId);
			//cmpOffLeave = LMSCompOffLeaveDetailsLocalServiceUtil.createLMSCompOffLeaveDetails(LMSCompOffLeaveDetailsLocalServiceUtil.getLMSCompOffLeaveDetailsesCount()+1);
			cmpOffLeave = LMSCompOffLeaveDetailsLocalServiceUtil.createLMSCompOffLeaveDetails(lpk);
			cmpOffLeave.setApprovedBy(approverName);
			cmpOffLeave.setCompOffId(LMSCompOffLeaveDetailsLocalServiceUtil.getLMSCompOffLeaveDetailsesCount()+1);
			cmpOffLeave.setCreatedDate(currentDate);
			cmpOffLeave.setStatus("NotUsed");
			cmpOffLeave.setApproverEmployeeID(approverId); 
			try{
		LMSCompOffLeaveDetailsLocalServiceUtil.addLMSCompOffLeaveDetails(cmpOffLeave);
			}catch (Exception e){
				System.out.println("duplicate record exception");
				request.setAttribute("duplicate", "You have already Applied CompOff For "+CompOffRequestDate);
				//e.printStackTrace();
			}
		//System.out.println(" CompOffRequestDate : " + CompOffRequestDate + " projectName : " + projectName + " approverName : " + approverName + " comments : " + comments);
		response.setRenderParameter("jspPage","/jsp/compOff.jsp");
	}
	
	public static void approveCompoff(ActionRequest request, ActionResponse response){
		try {
		int requestId = Integer.parseInt(request.getParameter("compOffRequest"));
		System.out.println("approval request Id " +requestId);
		LMSCompOffLeaveDetails compOff = LMSCompOffLeaveDetailsLocalServiceUtil.getCompOffDetailsbyCompOffId(requestId);
		LMSCompOffLeaveDetailsPK lpk = new LMSCompOffLeaveDetailsPK() ;
		lpk.setCompoffDate(compOff.getCompoffDate());
		lpk.setEmployeeID(compOff.getEmployeeID());

		
		LMSCompOffLeaveDetails compOffRecord = LMSCompOffLeaveDetailsLocalServiceUtil.getLMSCompOffLeaveDetails(lpk);
		compOffRecord.setStatus("Approved");
		LMSCompOffLeaveDetailsLocalServiceUtil.updateLMSCompOffLeaveDetails(compOffRecord); //changing status of compoff request.
		
		
		
		int EmployeeID = compOff.getEmployeeID();
		LeaveBalance lbal = LeaveBalanceLocalServiceUtil.getLeaveBalance(EmployeeID);
		double compOffbal = lbal.getCompOffLeaveBalance();
		//System.out.println("compOffbal befor adding : " + compOffbal);
		compOffbal+=1;
		//System.out.println("compOffbal befor adding : " + compOffbal);
		lbal.setCompOffLeaveBalance(compOffbal);
		LeaveBalanceLocalServiceUtil.updateLeaveBalance(lbal); // adding compoff balance to the user
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setRenderParameter("mvcPath","/jsp/compoffApproval.jsp");
		
	}
	
	public static void rejectCompoff(ActionRequest request, ActionResponse response){
		try {
		int requestId = Integer.parseInt(request.getParameter("compOffRequest"));
		System.out.println("rejection request Id " + requestId);
		
		LMSCompOffLeaveDetails compOff = LMSCompOffLeaveDetailsLocalServiceUtil.getCompOffDetailsbyCompOffId(requestId);
		LMSCompOffLeaveDetailsPK lpk = new LMSCompOffLeaveDetailsPK() ;
		lpk.setCompoffDate(compOff.getCompoffDate());
		lpk.setEmployeeID(compOff.getEmployeeID());

		LMSCompOffLeaveDetails compOffRecord = LMSCompOffLeaveDetailsLocalServiceUtil.getLMSCompOffLeaveDetails(lpk);
		compOffRecord.setStatus("Rejected");
		LMSCompOffLeaveDetailsLocalServiceUtil.updateLMSCompOffLeaveDetails(compOffRecord); //changing status of compoff request to rejected.
			
			//int EmployeeID = compOff.getEmployeeID();
		
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		response.setRenderParameter("mvcPath","/jsp/compoffApproval.jsp");
		}
}
