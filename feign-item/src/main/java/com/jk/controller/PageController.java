package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/12
 * Time: 19:44
 */
@Controller
@RequestMapping("page")
public class PageController {

    ///跳转登录页面
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    //跳转注册页面
    @RequestMapping("singOn")
    public String singOn(){
        return "singOn";
    }
    //跳转主页面
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    //跳转回收订单页面
    @RequestMapping("hsOrder")
    public String hsOrder(){
        return "hsOrder";
    }
    //跳转兑换订单页面
    @RequestMapping("dhOrder")
    public String dhOrder(){
        return "dhOrder";
    }
    //跳转到申请设备页面
    @RequestMapping("facility1")
    public String facility1(){
        return "facility1";
    }

    //跳转到设备管理页面
    @RequestMapping("facility2")
    public String facility2(){
        return "facility2";
    }
}
