package com.jk.dao;

import com.jk.pojo.TreeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:16
 */
@Mapper
public interface TreeDao {

    @Select("select * from t_tree where pid = #{pid}")
    List<TreeBean> findTree(int pid);
}
