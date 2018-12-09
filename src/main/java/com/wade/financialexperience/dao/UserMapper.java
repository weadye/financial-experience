/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/11/25  .
 */

package com.wade.financialexperience.dao;


import com.wade.financialexperience.core.MyMapper;
import com.wade.financialexperience.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends MyMapper<User> {

    User selectByName(String name);

    User selectByOpenid(String openid);
}