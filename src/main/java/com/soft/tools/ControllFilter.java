
package com.soft.tools;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/**
* @author 作者:大飞
* @version 创建时间：2018年12月27日 下午4:24:22
* 主要解决跨域问题
* 类说明
*/

public class ControllFilter implements ContainerResponseFilter {
	 
	public static final String ALLOWED_METHODS = "GET, POST, PUT, DELETE, OPTIONS, HEAD";
	public final static int MAX_AGE = 30 * 60;
	public final static String DEFAULT_ALLOWED_HEADERS = "origin,accept,content-type";
 
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		final MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", getRequestedHeaders(requestContext));
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
		headers.add("Access-Control-Max-Age", MAX_AGE);
		headers.add("x-responded-by", "cors-response-filter");
	}
 
	private String getRequestedHeaders(ContainerRequestContext responseContext) {
		List<String> headers = responseContext.getHeaders().get("Access-Control-Request-Headers");
		return createHeaderList(headers);
	}
 
	private String createHeaderList(List<String> headers) {
		if (headers == null || headers.isEmpty()) {
			return DEFAULT_ALLOWED_HEADERS;
		}
		StringBuilder retVal = new StringBuilder();
		for (int i = 0; i < headers.size(); i++) {
			String header = (String) headers.get(i);
			retVal.append(header);
			retVal.append(',');
		}
		retVal.append(DEFAULT_ALLOWED_HEADERS);
		return retVal.toString();
	}
}

