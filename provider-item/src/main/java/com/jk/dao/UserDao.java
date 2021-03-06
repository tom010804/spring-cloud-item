package com.jk.dao;

import com.jk.pojo.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/13
 * Time: 15:32
 */
@Mapper
public interface UserDao {

    void addOneUser(UserBean userBean);

    @Select("select * from t_user where userPhone = #{userPhone}")
    UserBean findUserPhone(String userPhone);

    String continueAddUser(UserBean userBean);
}
