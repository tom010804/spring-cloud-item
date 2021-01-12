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
}
