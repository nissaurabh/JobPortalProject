/**
 * 
 */
package com.capgemini.wws.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sryarlag
 *
 */
public class WWSUtil {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	public static String NEED_STATUS_OPEN = "Open";
	
	public static String NEED_STATUS_CLOSED = "Closed";
	

	/**
	 * returns the string with no spaces and in upper case.
	 * @param str
	 * @return
	 */
	public static String getWWSComparableString(String str) {
		return str.replaceAll(" ", "").replaceAll(",", "").toUpperCase();
	}
	
	/**
	 * String null or empty check
	 * @param value
	 * @return
	 */
	public static boolean nullOrEmpty(String value) {
		if (null == value || "".equals(value.trim()) || "null".equalsIgnoreCase(value.trim())) {
			return true;
		}
		return false;
	}
	
	/**
	 * converts the string supplied in "MM/dd/yyyy" format to Date, returns null in case of errors
	 * @param date
	 * @return
	 */
	public static Date getDate(String date) {
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
