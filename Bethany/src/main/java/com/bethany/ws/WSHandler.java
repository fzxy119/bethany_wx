package com.bethany.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;


/**
 * Created by chenxiao on 2017/7/24at 17:43
 */
public class WSHandler implements WebSocketHandler {

    private static Logger logger = LoggerFactory.getLogger(WSHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.info("WSHandler:afterConnectionEstablished:"+webSocketSession.getAttributes());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.info("WSHandler:handleMessage:" + webSocketSession.getAttributes() + ":" + webSocketMessage.getPayload());
        TextMessage tx = new TextMessage("ni hao ");
        webSocketSession.sendMessage(tx);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        logger.info("WSHandler:handleTransportError:"+webSocketSession.getAttributes()+":"+throwable.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.info("WSHandler:afterConnectionClosed:"+webSocketSession.getAttributes()+":"+closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
