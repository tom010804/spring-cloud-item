package com.jk.service.impl;

import com.jk.dao.FacilityDao;
import com.jk.pojo.FacilityBean;
import com.jk.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/14
 * Time: 15:34
 */
@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityDao facilityDao;


    @Override
    public List<FacilityBean> findFacility() {
        return facilityDao.findFacility();
    }
}
