package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * Created by Ares on 2018/8/23.
 */
//利用Controller注解声明是一个控制器
@Controller
public class HelloController {

    //利用@RequestMapping配置URL和方法之间的映射
//    @RequestMapping("/index")
//    public String hello(){
//        //通过上面ViewResolver的Bean配置，返回值为index
//        //说明我们的页面放置的路径是/WEB-INF/classes/views/index.jsp
//        return "index";
//    }

//    public  void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/index").setViewName("/index");
//    }


}
