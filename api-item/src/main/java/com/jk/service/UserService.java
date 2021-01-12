package com.jk.service;

import com.jk.pojo.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/12
 * Time: 19:19
 */
@FeignClient(value = "provider-item")
public interface UserService {

    @RequestMapping("singOn")
    String singOn(UserBean userBean);

}
