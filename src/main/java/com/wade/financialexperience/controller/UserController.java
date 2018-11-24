package com.wade.financialexperience.controller;

import com.wade.financialexperience.model.dto.UserCreationDTO;
import com.wade.financialexperience.model.entity.User;
import com.wade.financialexperience.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/user")
@Api("swaggerDemoController相关的api")
public class UserController {
    @Autowired
    private UserService userService;


    @ApiOperation(value = "get users", notes = "get users")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAll();
    }

    @ApiOperation(value = "注册", notes = "注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserCreationDTO userInfo ) {
        User user = new User();
        user.setName(userInfo.getName());
        user.setPassword(userInfo.getPassword());
        userService.save(user);
    }
    @ApiOperation(value = "log in", notes = "log in")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Integer login(@RequestParam(required = false) String name, @PathVariable(required = false) String password ) {
        return 1;
    }
}
