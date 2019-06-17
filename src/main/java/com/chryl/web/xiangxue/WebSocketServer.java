package com.chryl.web.xiangxue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By Chr on 2019/6/17.
 */

@ServerEndpoint(value = "/ws/asset")
@Component
@Slf4j
public class WebSocketServer {
    //在线数量
    private static final AtomicInteger onlineCount = new AtomicInteger(0);

    //线程安全set,存放每个客户端对应的Session对象
    private static CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<>();
    //线程安全map,存放每个客户端sessionid和用户名对应关系
    private static Map<String, String> sessionMap = new ConcurrentHashMap<>();

    //连接建立成功调用的方法
    @OnOpen
    public void opOpen(Session session) {
        //将用户session,session和用户名对应关系存入本地缓存
        sessionSet.add(session);
        Map<String, List<String>> pathParameters = session.getRequestParameterMap();
        String userId = pathParameters.get("toUserId").get(0);
        sessionMap.put(session.getId(), userId);
        log.info("有链接加入,当前连接数为:{}", onlineCount.incrementAndGet());

        try {
            //通知所有用户新用户上线
//            broadCastInfo("系统通知@^用户[" + userId + "]加入群聊");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //

    //

    //

}
