package com.jk.controller;

import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:54
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("findHsOrder")
    @ResponseBody
    public HashMap<String,Object> findHsOrder(int page,int rows){
        return orderService.findHsOrder(page,rows);
    }

    @RequestMapping("findDhOrder")
    @ResponseBody
    public HashMap<String,Object> findDhOrder(int page,int rows){
        return orderService.findDhOrder(page,rows);
    }
}
