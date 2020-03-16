package com.jiuli.liping.service;

import com.jiuli.liping.vo.UserInfo;

/**
 * Author zyl
 * Date  2019-12-03
 */
public interface WeiXinService {
    public UserInfo getUserInfo(String code);

    String sendMessage();
}
