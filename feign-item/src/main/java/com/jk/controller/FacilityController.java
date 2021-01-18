package com.jk.controller;

import com.jk.pojo.FacilityBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 15:29
 */
@Controller
@RequestMapping("facility")
public class FacilityController {

    @Autowired
    private UserService userService;


    //查询设备
    @RequestMapping("findFacilityClient")
    @ResponseBody
    public List<FacilityBean> findFacilityClient(){
        return userService.findFacility();
    }

    @RequestMapping("findFacilityMy")
    @ResponseBody
    public HashMap<String,Object> findFacilityMy(int page,int rows){
        return userService.findFacilityMy();
    }
}
