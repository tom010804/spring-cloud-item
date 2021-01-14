package com.jk.service;

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

    @RequestMapping("singOn")
    String singOn(@RequestBody UserBean userBean);

    @RequestMapping("user/getCode")
    String getCode(@RequestParam String userPhone);

    @RequestMapping("user/redisUser")
    String redisUser(@RequestBody UserBean userBean);

    @RequestMapping("tree/findTree")
    List<TreeBean> findTree();

    @RequestMapping("order/findHsOrder")
    HashMap<String, Object> findHsOrder(@RequestParam int page, @RequestParam int rows);

    @RequestMapping("order/findDhOrder")
    HashMap<String, Object> findDhOrder(@RequestParam int page, @RequestParam int rows);
}
