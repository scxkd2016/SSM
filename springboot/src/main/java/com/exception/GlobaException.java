package com.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

//@ControllerAdvice
//public class GlobaException {
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView handler1(Exception e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", e.toString());
//        mv.setViewName("error1");
//        return mv;
//    }
//}

//@Configuration
//public class GlobaException {
//    @Bean
//    public SimpleMappingExceptionResolver exceptionHandler() {
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.put("java.lang.ArithmeticException", "error1");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }
//}

@Configuration
public class GlobaException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof java.lang.ArithmeticException) {
            modelAndView.addObject("error", e.toString());
            modelAndView.setViewName("error1");
            System.out.println("1111111111111111111111");
            return modelAndView;
        }
        if (e instanceof java.lang.NullPointerException) {
            modelAndView.addObject("error", e.toString());
            modelAndView.setViewName("error2");
            System.out.println("222222222222222222");
            return modelAndView;
        }
        return null;
    }
}
