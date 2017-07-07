package com.trianz.lms.util;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter extends MVCPortlet {

	
	
	public static String DateFormat(Date inputDate) throws ParseException{
		
		String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(inputDate);
		
		return formattedDate;
		
		
	}
	
	
}
