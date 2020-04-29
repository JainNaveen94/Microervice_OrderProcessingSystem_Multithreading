package com.navtech.logging.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulRequestLoggingFilter extends ZuulFilter{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// it specify that filter is applied or not
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		// Logging the Request Related Information on Zuul Console
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request ===> {}  request uri ====> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// Used to specify when it is called. Here, pre mean before request other are error, post etc
		return "pre";
	}

	@Override
	public int filterOrder() {
		// If there are more then one logging filter then we can manage there order through this method by specify it property
		return 1;
	}
	
	

}
