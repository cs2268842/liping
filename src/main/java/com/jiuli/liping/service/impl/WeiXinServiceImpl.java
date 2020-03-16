package com.jiuli.liping.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiuli.liping.service.UserlistService;
import com.jiuli.liping.service.WeiXinService;
import com.jiuli.liping.util.WeiXinUtils;
import com.jiuli.liping.vo.AccessToken;
import com.jiuli.liping.vo.Members;
import com.jiuli.liping.vo.UserInfo;
import com.jiuli.liping.vo.Userlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Author zyl
 * Date  2019-12-03
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {
    @Autowired
    private UserlistService userlistService;
    //获得token的json串
    public String getToken(){
        try {
            //String urls = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wwef2fadef61221778&corpsecret=4hRqvR3e0zY3Lgn5OtbfFKlYbBKDRpuz-qwx1X7DJ_c";
            String urls = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wwef2fadef61221778&corpsecret=memyUeFwa-wkNsbxuJ9KC0iyiQyFef523ebl6YScgus";

            JSONObject jsonss = WeiXinUtils.getWeiXinApi(urls);
            return jsonss.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    //获得访问user的详细信息
    public UserInfo getUserInfo(String code) {
        UserInfo userInfo = new UserInfo();
        try {
            //获得token    json串开始
            String token = getToken();
            //解析json
            JSONObject json = JSONObject.parseObject(token);
            AccessToken accessToken = new AccessToken();
            accessToken.setAccess_token(json.getString("access_token"));
            //获得token    json串结束

            //获得useridjson串开始
            String urls = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+accessToken.getAccess_token()+"&"+code;
            JSONObject jsonss = WeiXinUtils.getWeiXinApi(urls);

            //获得user详细信息开始
            //解析json，获得userid
            JSONObject json2 = JSONObject.parseObject(jsonss.toString());
            Members members = new Members();
            members.setUserId(json2.getString("UserId"));
            String urls2 = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken.getAccess_token()+"&userid="+members.getUserId();
            JSONObject jsonss2 = WeiXinUtils.getWeiXinApi(urls2);

            //获得user详细信息结束，返回json串
            JSONObject json3 = JSONObject.parseObject(jsonss2.toString());
            if(!("0".equals(json3.getString("errcode")))){
                userInfo.setFlag(1);
                userInfo.setMessage("调用失败");
                return userInfo;
            }
            //position就是08851
            Userlist ul = new Userlist();
            ul.setWechatId(json3.getString("userid"));
            ul.setUserName(json3.getString("name"));
            ul.setUserNum(json3.getString("position"));
            ul.setAvatar(json3.getString("avatar"));
            ul.setThumb_avatar(json3.getString("thumb_avatar"));
            ul.setMobile(json3.getString("mobile"));
            ul.setJurisdictionId(1);//普通权限
            Timestamp nowTime = new Timestamp(System.currentTimeMillis());
            ul.setCreatTime(nowTime);
            //部门
            List<Userlist> userHr = userlistService.getDepartMentByHR(ul.getUserNum());
            if(userHr.size()>0) {
                String dp="";
                for (Userlist use: userHr) {
                    dp+=use.getDepartmentDescribe()+",";
                }
                if(dp!="")
                    ul.setDepartmentDescribe(dp.substring(0,dp.length()-1));
            }else{
                ul.setDepartmentDescribe("");
            }
            int fl = userlistService.getCount(ul);
            if(fl==0) {
                ul.setLastTime(nowTime);
                userlistService.insert(ul);
            }else if(fl==1){
                ul.setLastTime(nowTime);
                userlistService.update(ul);
            }
            //userInfo.setPosition(json3.getString("position"));
            userInfo.setFlag(0);
            userInfo.setUserlist(ul);
            userInfo.setMessage("调用成功");
            return userInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInfo.setFlag(1);
        userInfo.setMessage("调用失败");
        return userInfo;
    }

    /**
     * 消息推送
     */
    public String sendMessage() {
        //获得token    json串开始
        String token = getToken();
        //解析json
        JSONObject json = JSONObject.parseObject(token);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token(json.getString("access_token"));
        //获得token    json串结束
        String urls = "https://qyapi.weixin.qq.com/cgi-bin/message/send?"+accessToken.getAccess_token();
        String param = "{" +
                "\"touser\" :\"UserID1|UserID2|UserID3\" ," +
                "\"toparty\" : \"PartyID1|PartyID2\" ," +
                "\"totag\" : \"TagID1 | TagID2\", "+
                "\"msgtype\" : \"text\", "+
                "\"agentid\" : 1, "+
                "\"text\" : { \"content\" : \"你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。\" },"+
                "\"safe\" : 0, "+
                "\"enable_id_trans\" : 0, "+
                "\"enable_duplicate_check\" : 0, " +
                "}";
        String json1 = WeiXinUtils.getWeiXinApiPost(urls, param);
        return json1;
    }
}
