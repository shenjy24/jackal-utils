package com.jonas.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class CustomWebSocketClient extends WebSocketClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomWebSocketClient.class);

    public CustomWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    public CustomWebSocketClient(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        LOGGER.info("Open a WebSocket connection on client. ");
    }

    @Override
    public void onMessage(String s) {
        LOGGER.info("WebSocketClient receives a message: " + s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        LOGGER.info("Close a WebSocket connection on client. ");
    }

    @Override
    public void onError(Exception e) {
        LOGGER.error("WebSocketClient exception. ", e);
    }

    public static void main(String[] args) {
        try {
            String serverUrl = "ws://localhost:18088/ws/server";
            URI recognizeUri = new URI(serverUrl);
            CustomWebSocketClient client = new CustomWebSocketClient(recognizeUri, new Draft_6455());
            client.connect();
            client.send("This is a message from client. ");
        } catch (URISyntaxException e) {
            LOGGER.error("连接异常", e);
        }
    }
}
