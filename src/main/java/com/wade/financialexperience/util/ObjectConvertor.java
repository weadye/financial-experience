/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/12/9  .
 */

package com.wade.financialexperience.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author wade.ye
 * @date 18-12-9 下午8:13
 */
public class ObjectConvertor {
    public static Mapper mapper = new DozerBeanMapper();

    public static <T> T getObject(Object source, Class<T> t){
        return mapper.map(source, t);
    }
}
