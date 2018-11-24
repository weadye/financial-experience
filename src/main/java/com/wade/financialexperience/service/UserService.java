/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/11/25  .
 */

package com.wade.financialexperience.service;

import com.wade.financialexperience.model.entity.User;

public interface UserService extends BaseService<User> {
    String login(String username, String password);
}
