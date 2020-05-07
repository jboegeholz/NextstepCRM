package de.creatronix.artist3k.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class ValidateLoginServlet implements Filter {
	Logger log = Logger.getLogger(ValidateLoginServlet.class);
	private static final long serialVersionUID = -3345805934648857470L;
	private String contextName = null;

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		log.info("doFilter");
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}

		String url = ((HttpServletRequest) req).getRequestURL().toString();
		int lastIndex = url.lastIndexOf(contextName) + contextName.length();
		String page = url.substring(lastIndex);
		
		if (null == page) {
			page = "invalid";
		}
		log.info("Page: " + page);
		if (((HttpServletRequest) req).getSession().getAttribute("user") != null
				|| page.equals("/nextstep-booking/login.do") || page.contains("/nextstep-booking/loginsubmit.do")) {
			log.info("User ok");
			filter.doFilter(req, resp);
		} else {
			log.error("No valid user");
			req.getRequestDispatcher("/login.do").forward(req, resp);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		// contextName = config.getInitParameter("contextName");
		ServletContext context = config.getServletContext();
		contextName = context.getServletContextName();
		if (null == contextName) {
			throw new ServletException("no context name set");
		}
	}

	public void destroy() {
		// NOP
	}

}
