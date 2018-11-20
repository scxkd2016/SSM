package com.example.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(displayName = "MyFilter",urlPatterns = "/servlet")
public class MyFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Enter Filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Out Filter");
    }
}
