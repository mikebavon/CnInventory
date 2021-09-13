package com.cohort.interceptor;

import javax.servlet.*;
import java.io.IOException;

public class ItemFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("urlIntercept","THIS WAS SET IN FILTER...");

    }

    public void destroy() {

    }

}
