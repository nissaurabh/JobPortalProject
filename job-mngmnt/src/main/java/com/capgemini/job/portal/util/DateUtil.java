package com.capgemini.job.portal.util;

/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * The Class DateUtil.
 * 
 * @author sbasired
 */
public final class  DateUtil {
	
	 static final String ZULU_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	 static final DateFormat ZULU_DATE_FORMATTER = new SimpleDateFormat(ZULU_DATE_FORMAT);
	
	
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
	      formatter = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = (Date) formatter.parse(strDate);
	      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (ParseException e) {
	      return null;
	    }
	  }
	
	
	/**
	 * @param strDate
	 * @return
	 */
	public static String convertUTCToString(String dateString) {
		ZULU_DATE_FORMATTER.setTimeZone(TimeZone.getTimeZone("UTC"));
		final SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		try {
			Date date = (Date) ZULU_DATE_FORMATTER.parse(dateString);
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (ParseException e) {
			try{
				dateFormat.parse(dateString);
				return dateString;
			} catch(ParseException pe){
				return null;
			}
		}
	}
	
	
	/**
	 * @param timestamp
	 * @return
	 */
	public static String convertTimestamptoDate(final Timestamp timestamp) {
		String dateString = "";
		if(null!=timestamp){
			dateString = new SimpleDateFormat("MM/dd/yyyy").format(timestamp);
		}
	    return dateString;
	  }
	
}
