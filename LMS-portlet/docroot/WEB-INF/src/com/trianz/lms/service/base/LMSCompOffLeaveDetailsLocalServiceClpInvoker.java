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

package com.trianz.lms.service.base;

import com.trianz.lms.service.LMSCompOffLeaveDetailsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author
 * @generated
 */
public class LMSCompOffLeaveDetailsLocalServiceClpInvoker {
	public LMSCompOffLeaveDetailsLocalServiceClpInvoker() {
		_methodName0 = "addLMSCompOffLeaveDetails";

		_methodParameterTypes0 = new String[] {
				"com.trianz.lms.model.LMSCompOffLeaveDetails"
			};

		_methodName1 = "createLMSCompOffLeaveDetails";

		_methodParameterTypes1 = new String[] {
				"com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK"
			};

		_methodName2 = "deleteLMSCompOffLeaveDetails";

		_methodParameterTypes2 = new String[] {
				"com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK"
			};

		_methodName3 = "deleteLMSCompOffLeaveDetails";

		_methodParameterTypes3 = new String[] {
				"com.trianz.lms.model.LMSCompOffLeaveDetails"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchLMSCompOffLeaveDetails";

		_methodParameterTypes10 = new String[] {
				"com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK"
			};

		_methodName11 = "getLMSCompOffLeaveDetails";

		_methodParameterTypes11 = new String[] {
				"com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLMSCompOffLeaveDetailses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLMSCompOffLeaveDetailsesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLMSCompOffLeaveDetails";

		_methodParameterTypes15 = new String[] {
				"com.trianz.lms.model.LMSCompOffLeaveDetails"
			};

		_methodName118 = "getBeanIdentifier";

		_methodParameterTypes118 = new String[] {  };

		_methodName119 = "setBeanIdentifier";

		_methodParameterTypes119 = new String[] { "java.lang.String" };

		_methodName124 = "getCompOfDetailsbyEmpIdDate";

		_methodParameterTypes124 = new String[] { "int", "java.util.Date" };

		_methodName125 = "getCompoffDetailsbyApprovalName";

		_methodParameterTypes125 = new String[] { "java.lang.String" };

		_methodName126 = "getCompoffDetailsbyApproverEmpId";

		_methodParameterTypes126 = new String[] { "int" };

		_methodName127 = "getCompOffDetailsbyCompOffId";

		_methodParameterTypes127 = new String[] { "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.addLMSCompOffLeaveDetails((com.trianz.lms.model.LMSCompOffLeaveDetails)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.createLMSCompOffLeaveDetails((com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.deleteLMSCompOffLeaveDetails((com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.deleteLMSCompOffLeaveDetails((com.trianz.lms.model.LMSCompOffLeaveDetails)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.fetchLMSCompOffLeaveDetails((com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getLMSCompOffLeaveDetails((com.trianz.lms.service.persistence.LMSCompOffLeaveDetailsPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getLMSCompOffLeaveDetailses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getLMSCompOffLeaveDetailsesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.updateLMSCompOffLeaveDetails((com.trianz.lms.model.LMSCompOffLeaveDetails)arguments[0]);
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			LMSCompOffLeaveDetailsLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getCompOfDetailsbyEmpIdDate(((Integer)arguments[0]).intValue(),
				(java.util.Date)arguments[1]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getCompoffDetailsbyApprovalName((java.lang.String)arguments[0]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getCompoffDetailsbyApproverEmpId(((Integer)arguments[0]).intValue());
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return LMSCompOffLeaveDetailsLocalServiceUtil.getCompOffDetailsbyCompOffId(((Integer)arguments[0]).intValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
}