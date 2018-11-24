/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/11/25  .
 */

package com.wade.financialexperience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//redis
@EnableCaching
@SpringBootApplication
public class FinancialExperienceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialExperienceApplication.class, args);
    }
}
