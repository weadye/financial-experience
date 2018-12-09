/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/11/25  .
 */

package com.wade.financialexperience.controller;

import com.wade.financialexperience.api.UserAPI;
import com.wade.financialexperience.model.dto.UserCreationDTO;
import com.wade.financialexperience.model.dto.WXUserDTO;
import com.wade.financialexperience.model.dto.WechatLoginCodeDTO;
import com.wade.financialexperience.model.entity.User;
import com.wade.financialexperience.service.UserService;
import com.wade.financialexperience.util.ObjectConvertor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/user")
@Api("User Controller相关的api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserAPI userAPI;


    @ApiOperation(value = "get users", notes = "get users")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getUsers() {

        /*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();*/
        return userService.findAll();
    }

    @ApiOperation(value = "注册", notes = "注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserCreationDTO userInfo ) {
        User user = new User();
        user.setUsername(userInfo.getName());
        user.setPassword(userInfo.getPassword());
        userService.save(user);
    }
    @ApiOperation(value = "log in", notes = "log in")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String name, @RequestParam(required = false) String password ) {
        //使用redis登录
        return userService.login(name, password);
    }
    @ApiOperation(value = "log in", notes = "log in")
    @RequestMapping(value = "/wechat/login", method = RequestMethod.POST)
    public WXUserDTO wechatLogin(@RequestBody WechatLoginCodeDTO codeDTO) {

        //old stringRedisTemplate.opsForValue().set(codeDTO.getCode(), new Date().toString(),5 ,MINUTES);
        /*new redisTemplate.opsForList().leftPush("user:list", codeDTO.getCode());
        return redisTemplate.opsForList().range("user:list", 0 , -1);*/

        WXUserDTO wxUser = userAPI.getUser(codeDTO.getCode());
        if(wxUser.getOpenId() == null){
            throw new RuntimeException(wxUser.getErrMsg());
        }
        User user = ObjectConvertor.getObject(wxUser, User.class);
        userService.save(user);
        return userAPI.getUser(codeDTO.getCode());
    }
}
