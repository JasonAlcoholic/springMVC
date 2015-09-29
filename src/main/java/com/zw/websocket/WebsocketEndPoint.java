package com.zw.websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;  
 
public class WebsocketEndPoint extends TextWebSocketHandler {  
	
	private static final Logger logger = LogManager.getLogger(WebsocketEndPoint.class);
 
   @Override  
   protected void handleTextMessage(WebSocketSession session,  
           TextMessage message) throws Exception { 
	   String sessionId = session.getId();
	   logger.info("sessionId = " + sessionId);
       TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
       session.sendMessage(returnMessage);  
   }  
} 