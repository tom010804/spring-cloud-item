package com.jk.controller;

import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:53
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private UserService userService;

    @RequestMapping("findHsOrderClient")
    @ResponseBody
    public HashMap<String,Object> findHsOrderClient(int page,int rows){
        return userService.findHsOrder(page,rows);
    }
    @RequestMapping("findDhOrderClient")
    @ResponseBody
    public HashMap<String,Object> findDhOrderClient(int page,int rows){
        return userService.findDhOrder(page,rows);
    }
}
