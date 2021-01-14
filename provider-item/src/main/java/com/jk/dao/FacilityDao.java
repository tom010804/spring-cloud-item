package com.jk.dao;

import com.jk.pojo.FacilityBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 15:35
 */
@Mapper
public interface FacilityDao {

    List<FacilityBean> findFacility();
}
