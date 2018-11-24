package com.wade.financialexperience.dao;


import com.wade.financialexperience.core.MyMapper;
import com.wade.financialexperience.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends MyMapper<User> {

}