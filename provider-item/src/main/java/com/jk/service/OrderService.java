package com.jk.service;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:56
 */
public interface OrderService {
    HashMap<String, Object> findHsOrder(int page, int rows);

    HashMap<String, Object> findDhOrder(int page, int rows);
}
