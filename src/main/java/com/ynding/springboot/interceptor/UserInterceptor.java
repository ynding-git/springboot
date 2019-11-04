package com.ynding.springboot.interceptor;

import com.ynding.springboot.entity.User;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Map;

/**
 * 用户拦截
 */
public class UserInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
            /*if (raw instanceof Map) {
                //这里就是token
                Object name = ((Map) raw).get(Constants.TOKEN_KEY);
                if (name instanceof LinkedList) {
                    // 设置当前访问器的认证用户
                    String token = ((LinkedList) name).get(0).toString();
                    String username = null;
                    try {
                        Map<String, Claim> claimMap = JWTUtils.verifyToken(token);
                        username = claimMap.get("username").asString();
                        if(username == null){
                            throw new RuntimeException("websocket认证失败");
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        throw new RuntimeException("websocket认证失败", e);
                    } catch (ValidTokenException e) {
                        e.printStackTrace();
                        throw new RuntimeException("websocket认证失败", e);
                    }
                    User user = User.builder().username(username).build();
                    accessor.setUser(user);

                }
            }*/
        }

        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {

    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        return false;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        return null;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {

    }

}
