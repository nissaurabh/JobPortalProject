package com.capgemini.job.portal.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang.StringUtils;

/**
 * This Class used to get Query Params from MultivaluedMap.
 *
 * @author ppenamak
 */
public final class QueryParamUtil {
    
    /**
     * Instantiates a new query param util.
     */
    private QueryParamUtil() {
    }

    /** The instance. */
    private static QueryParamUtil instance = new QueryParamUtil();

    /**
     * Gets the single instance of QueryParamUtil.
     *
     * @return QueryParamUtil QueryParamUtil
     */
    public static QueryParamUtil getInstance() {

        return instance;

    }

    /**
     * This method return Query Map Params from MultivaluedMap.
     *
     * @param multivaluedMap            pass multivaluedMap as input
     * @return Query Map Params
     * @throws UnsupportedEncodingException 
     */
	public static Map<String, String> getQueryParamsFrmMultiMap(
			final MultivaluedMap<String, String> multivaluedMap) throws UnsupportedEncodingException {

		final Set<Map.Entry<String, List<String>>> multivaluedSet = multivaluedMap
				.entrySet();
		final Map<String, String> queryParams = new TreeMap<String, String>();
		for (final Map.Entry<String, List<String>> multivalue : multivaluedSet) {
			String key = multivalue.getKey();
			String value=multivalue.getValue().get(0);
			if(!StringUtils.isBlank(value)){
				if(StringUtils.contains(value, "+")){
					value=multivalue.getValue().get(0);
				}else{
					value=URLDecoder.decode(value,"UTF-8");
				}
				
			}
			if(StringUtils.isNotEmpty(value)){
				if(key.contains("date") || key.contains("dt")){
					queryParams.put(multivalue.getKey(),DateUtil.convertUTCToString(value));
				} else {
					queryParams.put(multivalue.getKey(),value);
				}
			}
		}
		return queryParams;
	}

}
