package com.jk.service.impl;

import com.jk.dao.OrderDao;
import com.jk.pojo.OrderBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:56
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public HashMap<String, Object> findHsOrder(int page, int rows) {
        int total = orderDao.findHsOrderTotal();
        int start = (page-1)*rows;
        List<OrderBean> list = orderDao.findHsOrder(start,rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows", list);
        return map;
    }

    @Override
    public HashMap<String, Object> findDhOrder(int page, int rows) {
        int total = orderDao.findDhOrderTotal();
        int start = (page-1)*rows;
        List<OrderBean> list = orderDao.findDhOrder(start,rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows", list);
        return map;
    }
}
