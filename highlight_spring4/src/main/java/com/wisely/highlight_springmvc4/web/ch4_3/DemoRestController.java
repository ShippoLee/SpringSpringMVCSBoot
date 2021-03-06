package com.wisely.highlight_springmvc4.web.ch4_3;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ares on 2018/8/24.
 */
//使用@RestController，声明是控制器，并且返回数据时不需要@ResponseBody
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    //返回数据的媒体类型为json
    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"})
    public DemoObj getjson(DemoObj obj){
        //直接返回对象，对象会自动转换成json
        return  new DemoObj(obj.getId() + 1,obj.getName() + "yy....");
    }
    //返回数据的媒体类型为xml
    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"})//4
    public DemoObj getxml(DemoObj obj){
        //直接返回对象，对象会自动转换成xml
        return new DemoObj(obj.getId() + 1,obj.getName() + "yy....");//5
    }




}
