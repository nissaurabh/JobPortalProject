/**
 * 
 */
package com.capgemini.wws.filefeed;

import java.text.SimpleDateFormat;

/**
 * @author sryarlag
 *
 */
public class WWSUtil {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

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
	
	
}
