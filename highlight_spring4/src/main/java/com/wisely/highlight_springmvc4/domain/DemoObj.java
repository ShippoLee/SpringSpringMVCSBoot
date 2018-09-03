package com.wisely.highlight_springmvc4.domain;

/**
 * Created by Ares on 2018/8/24.
 */
public class DemoObj {

    private Long id;
    private String name;

    //jackson 对对象和json做转换时一定需要此空构造
    public DemoObj(){
        super();
    }

    public DemoObj(Long id,String name){
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
