/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/11/25  .
 */

package com.wade.financialexperience.service.impl;

import com.wade.financialexperience.dao.UserMapper;
import com.wade.financialexperience.model.entity.User;
import com.wade.financialexperience.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

import static java.util.concurrent.TimeUnit.SECONDS;


@Service("UserService")
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public String login(String username, String password){
        if (StringUtils.isNotEmpty(stringRedisTemplate.opsForValue().get(username))){
            return "Already logged at:" + stringRedisTemplate.opsForValue().get(username);
        }

        User user = userMapper.selectByName(username);
        if (user.getPassword().equals(password)){
            stringRedisTemplate.opsForValue().set(username, new Date().toString(),3 ,SECONDS);
            return "Success logged";
        }
        return "Password incorrect";
    }

    @Override
    public void save(User model) {

        User user = userMapper.selectByOpenid(model.getOpenid());
        if (user != null){
            throw new RuntimeException("user existed!");
        }
        super.save(model);
    }
}
