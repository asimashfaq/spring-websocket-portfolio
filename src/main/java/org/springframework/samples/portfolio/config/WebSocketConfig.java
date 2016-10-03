package org.springframework.samples.portfolio.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Configuration
@EnableScheduling
@ComponentScan("org.springframework.samples")
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/portfolio").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
	//	registry.enableSimpleBroker("/queue/", "/topic/");
		registry.enableStompBrokerRelay("/queue/", "/topic/")
	     .setRelayHost("50.116.63.192")
	        .setRelayPort(61613)
	        .setClientLogin("guest")
	        .setClientPasscode("guest")
	        .setSystemLogin("guest")
	        .setSystemPasscode("guest")
	        .setSystemHeartbeatReceiveInterval(5000)
	        .setSystemHeartbeatSendInterval(5000);;
		registry.setApplicationDestinationPrefixes("/app");
	}

}
