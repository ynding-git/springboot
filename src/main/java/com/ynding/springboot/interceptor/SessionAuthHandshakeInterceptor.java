package com.ynding.springboot.interceptor;

import com.ynding.springboot.exception.CmiException;
import com.ynding.springboot.o.bo.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 定义handshake握手拦截器
 * 这里有个逻辑就是当webscoket建立连接的时候被拦截，获取当前应用的session，
 * 将用户登录信息获取出来，如果用户未登录，那么不好意思拒绝连接，如果已经登陆了，那么将用户绑定到stomp的session中，
 * UserInterceptor拦截器就调用了这个用户信息。
 */
@Slf4j
public class SessionAuthHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        HttpSession session = getSession(request);
        if(session == null || session.getAttribute(Constants.SESSION_USER) == null){
            log.error("websocket权限拒绝");
//            return false;
            throw new CmiException("websocket权限拒绝");
        }
        attributes.put(Constants.WEBSOCKET_USER_KEY,session.getAttribute(Constants.SESSION_USER));
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }

    private HttpSession getSession(ServerHttpRequest request) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            return serverRequest.getServletRequest().getSession(false);
        }
        return null;
    }

}
