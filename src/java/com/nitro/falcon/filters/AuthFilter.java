package com.nitro.falcon.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AuthFilter
 * @author leops
 */
public class AuthFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        // Do nothing
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        if(httpRequest.getSession().getAttribute("user") == null) {
            httpResponse.sendRedirect(
                    request.getServletContext().getContextPath() + "/login"
            );
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Do nothing
    }
}
