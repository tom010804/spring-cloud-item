package com.jk.service;

import com.jk.pojo.FacilityBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/12
 * Time: 19:19
 */
@FeignClient(value = "provider-item")
public interface UserService {

    //登录
    @RequestMapping("singOn")
    String singOn(@RequestBody UserBean userBean);

    //获取验证码
    @RequestMapping("user/getCode")
    String getCode(@RequestParam String userPhone);

    //短信验证以及增加注册信息
    @RequestMapping("user/redisUser")
    String redisUser(@RequestBody UserBean userBean);

    //左侧树
    @RequestMapping("tree/findTree")
    List<TreeBean> findTree();

    //查询回收订单信息
    @RequestMapping("order/findHsOrder")
    HashMap<String, Object> findHsOrder(@RequestParam int page, @RequestParam int rows);

    //查询兑换订单信息
    @RequestMapping("order/findDhOrder")
    HashMap<String, Object> findDhOrder(@RequestParam int page, @RequestParam int rows);

    //查询所有设备
    @RequestMapping("facility/findFacility")
    List<FacilityBean> findFacility();

    //登录
    @RequestMapping("user/userLogin")
    String userLogin(@RequestBody UserBean userBean);

    @RequestMapping("user/continueAddUser")
    String continueAddUser(UserBean userBean);

    //查询我的设备
    @RequestMapping("facility/findFacilityMy")
    HashMap<String, Object> findFacilityMy();
}
