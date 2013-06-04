package com.liferay.consistent.tracking.hook.filter;

import com.liferay.portal.kernel.util.HtmlUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Jorge Loayza
 *
 */

public class PortalTrackingFilter implements Filter {

	@Override
	public void destroy() {
				
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		String keywords = HtmlUtil.extractText(servletRequest.getParameter("_3_keywords"));
		String url = ((HttpServletRequest) servletRequest).getRequestURL().toString();
		System.out.println("url: " + url);
		if (keywords==null) {
			System.out.println("Null keywords");
		} else {
			System.out.println("keys: " + keywords);
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
				
	}

}
