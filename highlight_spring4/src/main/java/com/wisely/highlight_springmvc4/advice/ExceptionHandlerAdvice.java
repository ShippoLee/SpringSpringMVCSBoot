package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ares on 2018/8/24.
 */

//@ControllerAdvice声明一个控制器建言，@ControllerAdvice组合了@Component注解，所以自动注册为Spring的Bean
@ControllerAdvice
public class ExceptionHandlerAdvice {
    /**
     *
     * @ExceptionHandle在此处定义为全局处理
     * 通过@ExceptionHandler的value属性可过滤拦截的条件
     * 在此处，我们拦截所有的Exception
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception,WebRequest request){
        ModelAndView modelAndView = new ModelAndView(("error"));//error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return  modelAndView;
    }

    /**
     * @ModelAttribute注解将键值对添加到全局
     * 所有注解的@RequestMapping 的方法可获得此键值对
     *
     * @param model
     */
    @ModelAttribute
    public  void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    /**
     * 通过@InitBinder注解定制WebDataBinder
     *
     * @param webDataBinder
     */
    @InitBinder
    private  void  initBinder(WebDataBinder webDataBinder){
        //此处忽略request参数的id,更多配置，参考API
        webDataBinder.setDisallowedFields("id");
    }
}
