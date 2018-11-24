/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/11/25  .
 */

package com.wade.financialexperience.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface MyMapper<T> extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
