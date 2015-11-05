package com.job.mngmnt.util;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class  DateUtil {
	
	
	public static Timestamp convertStringToTimestamp(String strDate) {
	    try {
	      DateFormat formatter;
	      formatter = new SimpleDateFormat("yyyy-mm-dd");
	      Date date = (Date) formatter.parse(strDate);
	      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (ParseException e) {
	      System.out.println("Exception :" + e);
	      return null;
	    }
	  }

}
