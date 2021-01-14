package com.jk.service;

import com.jk.pojo.UserBean;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/13
 * Time: 10:45
 */
public interface UserService {
    String getCode(String userPhone);

    String redisUser(UserBean userBean);
}
