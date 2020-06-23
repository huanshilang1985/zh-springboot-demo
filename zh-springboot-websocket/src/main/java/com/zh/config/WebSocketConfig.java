package com.zh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket配置
 *
 * @author he.zhang
 * @since 2020/3/12 19:47
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 配置消息代理
     * @param config 代理注册器
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 允许客户端订阅的前缀，数组
        config.enableSimpleBroker("/topic");
        //带有app前缀的url，会转发到controller的对应方法
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 注册客户端监听的端口
     * @param registry 端口注册器
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/zh").withSockJS();
    }

}
