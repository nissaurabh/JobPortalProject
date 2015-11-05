/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.job.mngmnt.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DateUtil.
 * 
 * @author sbasired
 */
public final class  DateUtil {
	
	
	/**
	 * create the job.
	 * 
	 * @param strDate
	 *            the strDate
	 * @return the timeStampDate
	 */
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
