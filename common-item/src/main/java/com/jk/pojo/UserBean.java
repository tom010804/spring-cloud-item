package com.jk.pojo;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/12
 * Time: 19:23
 */
@Data
public class UserBean {


    private Integer userId;//用户ID
    private String userName;//用户姓名
    private String userPhone;//用户手机号
    private String userPwd;//用户密码
    private String membersNumber;//成员编号
    private String createTime;//入职时间  注册门店时间
    private String theFunction;//职能
    private Integer sex;//性别
    private Integer merchantsId;//商家ID   （用户ID）
    private Integer userType;//用户类型

    //用户信息字段
    private String shopName;//门店名称
    private String shopLocation;//门店位置
    private String shopLogo;//门店LOGO
    private String signInName;//注册名称
    private String socialCode;//社会信用代码
    private String certificateNumber;//税务登记号码
    private String signInArea;//注册地址
    private String userSfz;//用户身份证
}
