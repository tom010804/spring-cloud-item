package com.jk.controller;

import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/12
 * Time: 19:18
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("singOnClient")
    @ResponseBody
    public String singOnClient(UserBean userBean){
        return userService.singOn(userBean);
    }

    //获取验证码
    @RequestMapping("getCodeClient")
    @ResponseBody
    public String getCodeClient(String userPhone){
        return userService.getCode(userPhone);
    }

    //将门店信息存入到redis
    @RequestMapping("redisUserClient")
    @ResponseBody
    public String redisUserClient(UserBean userBean){
        return userService.redisUser(userBean);
    }

    //登录
    @RequestMapping("userLoginClient")
    @ResponseBody
    public String userLoginClient(UserBean userBean, HttpSession session){
        String s = userService.userLogin(userBean);
        /*if (s=="登陆成功！！！"){
            session.setAttribute("user",userBean);
        }
        UserBean user = (UserBean) session.getAttribute("user");
        System.out.println(user.getUserPhone());*/
        return s;
    }

    @RequestMapping("continueAddUserClient")
    @ResponseBody
    public String continueAddUserClient(UserBean userBean){
        return userService.continueAddUser(userBean);
    }
}
