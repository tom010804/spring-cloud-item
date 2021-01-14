package com.jk.dao;

import com.jk.pojo.OrderBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:57
 */
@Mapper
public interface OrderDao {
    int findHsOrderTotal();

    List<OrderBean> findHsOrder(int start, int rows);

    int findDhOrderTotal();

    List<OrderBean> findDhOrder(int start, int rows);
}
