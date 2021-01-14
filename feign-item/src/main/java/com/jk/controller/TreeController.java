package com.jk.controller;

import com.jk.pojo.TreeBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:13
 */
@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private UserService userService;

    @RequestMapping("findTreeClient")
    @ResponseBody
    public List<TreeBean> findTreeClient(){
        return userService.findTree();
    }
}
