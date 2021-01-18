package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.UserDao;
import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import com.jk.utils.CheckSumBuilder;
import com.jk.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/13
 * Time: 10:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserDao userDao;

    @Override
    public String getCode(String userPhone) {
        Object object = redisTemplate.opsForValue().get(userPhone);
        if (object!=null) {
            return "您已发送验证码，请稍后再试";
        }
        String url = "https://api.netease.im/sms/sendcode.action";
        HashMap<String, Object> headparams = new HashMap<String, Object>();
        HashMap<String, Object> params = new HashMap<String, Object>();

        String appKey = "9d92700d7e42cf5b68e8117efd21ec63";
        long nonce = Math.round((Math.random()*899999+100000));
        long curTime = System.currentTimeMillis()/1000;
        String appSecret = "17aef6216e5d";
        String checkSum = CheckSumBuilder.getCheckSum(appSecret , nonce+"", curTime+"");
        headparams.put("AppKey", appKey);
        headparams.put("Nonce", nonce);
        headparams.put("CurTime", curTime);
        headparams.put("CheckSum", checkSum);

        params.put("mobile", userPhone);
        params.put("templateid", "14880572");
        params.put("authCode", nonce);

        String value = HttpClientUtil.post2(url, headparams, params);
        JSONObject valueObj = JSONObject.parseObject(value);
        int code = valueObj.getIntValue("code");
        if (code==200) {
            //redisTemplate.opsForValue().set(userPhone, nonce,10, TimeUnit.MINUTES);
            redisTemplate.opsForValue().set(userPhone, nonce);
            return "验证码发送成功";
        }
        return "验证码发送失败";
    }

    @Override
    public String redisUser(UserBean userBean) {
        Object object = redisTemplate.opsForValue().get(userBean.getUserPhone());
        if (object!=null){
            String code2 = object.toString();
            if (!userBean.getUserCode().equals(code2)) {
                return "验证码错误";
            }else {
                //redisTemplate.delete(userBean.getUserPhone());

                userDao.addOneUser(userBean);

                return userBean.getUserId()+"";
            }
        }else {
            return "验证码错误";
        }
    }

    @Override
    public String userLogin(UserBean userBean) {
        UserBean user = userDao.findUserPhone(userBean.getUserPhone());
        if (user!=null){
            if (userBean.getUserPwd().equals(user.getUserPwd())){
                return "登陆成功！！！";
            }else {
                return "密码错误";
            }
        }else {
            return "账号不存在";
        }

    }

    @Override
    public String continueAddUser(UserBean userBean) {
        return userDao.continueAddUser(userBean);
    }
}
