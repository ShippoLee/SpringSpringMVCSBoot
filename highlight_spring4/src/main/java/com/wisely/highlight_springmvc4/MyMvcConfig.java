package com.wisely.highlight_springmvc4;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import com.wisely.highlight_springmvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by Ares on 2018/8/23.
 */
@Configuration
//@EnableWebMvc开启SpringMVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@EnableWebMvc
//开启计划任务的支持
@EnableScheduling
@ComponentScan("com.wisely.highlight_springmvc4")
//继承WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置
public class MyMvcConfig extends WebMvcConfigurerAdapter{


    //配置拦截器的Bean
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    //重写 addInterceptors方法， 注册拦截器
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");

    }

    //实际开发中涉及的大量的页面转向，可通过在配置中重写addViewControllers来简化配置
    //即可替代HelloController
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index11").setViewName("/index");

        //添加转向到upload页面的Controller
        registry.addViewController("/toUpload").setViewName("/upload");

        //添加Converter映射页面
        registry.addViewController("/converter").setViewName("/converter");

        //添加转向sse.jsp页面的映射
        registry.addViewController("/sse").setViewName("/sse");
        
        //添加viewController
        registry.addViewController("/async").setViewName("/async");
    }

    //通过重写configurePathMatch方法可不忽略"."后面的 参数
    //e.p:url:http://localhost:8080/highlight_springmvc4/anno/pathvar/aaa.yyycan access....,str:aaa.yyy
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }


    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver =
                new CommonsMultipartResolver();

        multipartResolver.setMaxUploadSize(1000000);

        return multipartResolver;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }




    

    /**
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    */
}
