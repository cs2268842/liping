package com.jiuli.liping.controller;

import com.jiuli.liping.service.WeiXinService;
import com.jiuli.liping.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author zyl
 * Date  2019-11-28
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/weixin")
public class WeiXinController {
    @Autowired
    WeiXinService weiXinService;
    /**
     * 获得人员信息
     * @param code
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public UserInfo getUserInfo(@RequestBody String code) {
        UserInfo userInfo = weiXinService.getUserInfo(code);
        return userInfo;
    }

    /**
     * 微信推送消息
     * @param code
     * @return
     */
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public String sendMessage(@RequestBody String code) {
        String message = weiXinService.sendMessage();
        return message;
    }
}
