package com.wisely.highlight_springmvc4.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ares on 2018/8/24.
 */
//继承HandlerInterceptorAdapter类来实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter {

    //重写preHandle方法， 在请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    //重写postHandle方法，在请求完成后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.print("本次请求的处理时间为：" + new Long(endTime - startTime) + "ms");

        request.setAttribute("handlingTime",endTime - startTime);
    }



}
