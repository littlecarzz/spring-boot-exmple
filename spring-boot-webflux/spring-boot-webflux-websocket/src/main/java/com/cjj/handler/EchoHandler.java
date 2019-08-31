package com.cjj.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/31 16:20
 */
@Component
public class EchoHandler implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(
                session.receive()
                        .map(webSocketMessage -> session.textMessage("服务端返回：小明， -> " + webSocketMessage.getPayloadAsText())));
    }
}
