package com.trianz.lms.util;



import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.trianz.lms.model.LMSLeaveInformation;


import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class LeaveAssetRenderer extends BaseAssetRenderer{

	private LMSLeaveInformation leaveInfo;
	
	
	public LeaveAssetRenderer(LMSLeaveInformation leave) {
		
		leaveInfo = leave;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return LMSLeaveInformation.class.getName();
	}

	@Override
	public long getClassPK() {
		// TODO Auto-generated method stub
		return leaveInfo.getPrimaryKey();
	}



	@Override
	public String getSummary(Locale arg0) {
		// TODO Auto-generated method stub
		return leaveInfo.getApprovalStatus();
	}

	@Override
	public String getTitle(Locale arg0) {
		// TODO Auto-generated method stub
		return String.valueOf(leaveInfo.getLeaveRequestId());
	}

	


	@Override
	public String render(RenderRequest request, RenderResponse response, String template)
			throws Exception {
		// TODO Auto-generated method stub
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			request.setAttribute("leaveObject",leaveInfo);
			return "/jsp/viewleave.jsp";
			}
			else
			{
			return null;
			}
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		return null;
	}

}
