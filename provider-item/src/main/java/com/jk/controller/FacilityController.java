package com.jk.controller;

import com.jk.pojo.FacilityBean;
import com.jk.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 15:33
 */
@Controller
@RequestMapping("facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @RequestMapping("findFacility")
    @ResponseBody
    public List<FacilityBean> findFacility(){
        return facilityService.findFacility();
    }
}
