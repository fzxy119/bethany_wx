package com.bethany.context;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Enumeration;

public class SafeFilter implements Filter {


	private static final Logger logger = LoggerFactory.getLogger(SafeFilter.class);
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String uri = ((HttpServletRequest)request).getRequestURI();
		if(StringUtils.isNotEmpty(uri) &&  !uri.contains("/res/")) {
			Enumeration parames = request.getParameterNames();
			StringBuilder sb = new StringBuilder();
			while (parames.hasMoreElements()) {
				Object key = parames.nextElement();
				sb.append(key).append(">").append(request.getParameter(key + "")).append("|");
			}
			logger.info(String.format("SafeFilter:url:[%s]:ip:[%s]:parames:[%s]", uri, request.getRemoteAddr() + "", sb.toString()));
		}
		chain.doFilter(new XssHttpServletRequestWrapper(
				(HttpServletRequest) request), response);
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}

class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	public XssHttpServletRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}

	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (value == null)
			return null;
		return cleanXSS(value);
	}

	private String cleanXSS(String value) {
		
		//value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		//value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
//		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']","\"\"");
		value = value.replaceAll("(?i)javascript", "");//忽略大小写全部替换
		value = value.replaceAll("(?i)script", "");//忽略大小写全部替换
		value = value.replaceAll("(?i)alert", "");//忽略大小写全部替换
		value = value.replaceAll("(?i)select", "");//忽略大小写全部替换
		value = value.replaceAll("(?i)update", "");//忽略大小写全部替换
		value = value.replaceAll("(?i)delete", "");//忽略大小写全部替换
		value = value.replaceAll("(?i)from", "");//忽略大小写全部替换
		value = value.replaceAll("(?i)iframe", "");//忽略大小写全部替换
		return value;
	}
}
