package com.jk.service.impl;

import com.jk.dao.TreeDao;
import com.jk.pojo.TreeBean;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 11:16
 */
@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeDao treeDao;

    @Override
    public List<TreeBean> findTree() {
        int pid=0;
        List<TreeBean> list = tree(pid);
        return list;
    }


    private List<TreeBean> tree(int pid) {
        List<TreeBean> list=treeDao.findTree(pid);
        for (TreeBean tree:list){
            Integer id = tree.getId();
            List<TreeBean> list1 = tree(id);
            if (list1!=null && list1.size()>0){
                tree.setNodes(list1);
                tree.setSelectable(false);
            }else{
                tree.setSelectable(true);
            }
        }
        return list;
    }
}
