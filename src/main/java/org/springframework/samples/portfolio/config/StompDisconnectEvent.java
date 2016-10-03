package org.springframework.samples.portfolio.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Configuration
@EnableScheduling
@ComponentScan("org.springframework.samples")
@EnableWebSocketMessageBroker
public class StompDisconnectEvent implements ApplicationListener<SessionDisconnectEvent> {
	 
    private final Log logger = LogFactory.getLog(SessionDisconnectEvent.class);
 
    public void onApplicationEvent(SessionDisconnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
 
       // String  company = sha.getNativeHeader("company").get(0);
        logger.debug("Connect event xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx [sessionId: " + sha.getSessionId() +"; company:  ]");
    }
}