package com.cxm.webrtc.websocket;

/**
 * Created by Administrator on 2018/4/5.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * websocket
 * 消息推送(个人和广播)
 */
@Controller
public class WebSocketController {
    @Autowired
    private WebSocketServer socketServer;

    @RequestMapping(value = "index")
    public String index() {
        return "index.html";
    }

    /**
     * 个人信息推送
     *
     * @return
     */
    @RequestMapping("sendmsg")
    @ResponseBody
    public String sendmsg(String msg, String username) {
        //第一个参数 :msg 发送的信息内容
        //第二个参数为用户长连接传的username
        socketServer.sendMessage(msg, username);
        return "success";
    }

}