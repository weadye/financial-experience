/*
 * Copyright (c)
 * @author: Wade.Ye
 * @email: ye_jianquan@126.com
 * created at 2018/12/9  .
 */

package com.wade.financialexperience.model.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wade.ye
 * @date 18-12-9 下午1:35
 */
public class WXUserDTO {
    @JSONField(name = "openid")
    private String openId;
    @JSONField(name = "session_key")
    private String sessionKey;
    @JSONField(name = "unionid")
    private String unionId;
    @JSONField(name = "errcode")
    private Integer errCode;
    @JSONField(name = "errmsg")
    private String errMsg;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
