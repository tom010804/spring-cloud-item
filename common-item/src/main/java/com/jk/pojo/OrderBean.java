package com.jk.pojo;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:48
 */
@Data
public class OrderBean {

    private Integer id;
    private String orderId;
    private String createDate;
    private String userName;
    private String userPhone;
    private String recyclingSite;
    private Integer exchangeType;
    private String makeTime;
    private Integer currentState;
    private Integer userId;
    private Integer membersId;
    private Integer orderIStatus;
}
