package com.trianz.lms.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.trianz.lms.model.LMSLeaveInformation;

import com.trianz.lms.service.LMSLeaveInformationLocalServiceUtil;


public class LeaveAssetRendererFactory extends BaseAssetRendererFactory {

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub

		LMSLeaveInformation leaveInfo=LMSLeaveInformationLocalServiceUtil.getLMSLeaveInformation((int) classPK);
		return new LeaveAssetRenderer(leaveInfo);//provides asset object to asset renderer
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return LMSLeaveInformation.class.getName();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Leave";
	}

}
