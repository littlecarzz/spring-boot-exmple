package com.cjj;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.time.Duration;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/31 16:51
 */
public class WebSocketClient {
    /**
     * ReactorNettyWebSocketClient 是 WebFlux 默认 Reactor Netty 库提供的 WebSocketClient 实现。
     * execute 方法，与 ws://localhost:8080/echo 建立 WebSokcet 协议连接。
     * execute 需要传入 WebSocketHandler 的对象，用来处理消息，这里的实现和前面的 EchoHandler 类似。
     * 通过 WebSocketSession 的 send 方法来发送字符串“你好”到服务器端，然后通过 receive 方法来等待服务器端的响应并输出。
     * @param args
     */
    public static void main(String[] args) {
        ReactorNettyWebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://localhost:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("你好")))
                        .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(5000));
    }
}
