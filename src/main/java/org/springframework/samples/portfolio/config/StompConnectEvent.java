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

@Configuration
@EnableScheduling
@ComponentScan("org.springframework.samples")
@EnableWebSocketMessageBroker
public class StompConnectEvent implements ApplicationListener<SessionConnectEvent> {
	 
    private final Log logger = LogFactory.getLog(StompConnectEvent.class);
 
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
 
       // String  company = sha.getNativeHeader("company").get(0);
        logger.debug("Connect ++++++++++++++++++++++++++++++++++++++++++++++++++++++ event [sessionId: " + sha.getSessionId() +"; company:  ]");
    }
}