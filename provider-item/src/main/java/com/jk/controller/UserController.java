package com.jk.controller;

import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/13
 * Time: 10:45
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //获取短信验证码
    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(String userPhone){
        return userService.getCode(userPhone);
    }

    //新增用户信息并进行验证码验证
    @RequestMapping("redisUser")
    @ResponseBody
    public String redisUser(@RequestBody UserBean userBean){
        return userService.redisUser(userBean);
    }
}
