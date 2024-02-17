package ru.eight.handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Выбор
 */
public class ChoiceHandler implements HttpHandler {

    private PostGetRequestHandler requestHandler;
    private final String GET_METHOD = "GET";
    private final String POST_METHOD = "POST";

    public ChoiceHandler(PostGetRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if (exchange.getRequestMethod().equals(GET_METHOD)) {
            requestHandler.handlerGetMapping(exchange);
        } else if (exchange.getRequestMethod().equals(POST_METHOD)) {
            requestHandler.handlerPostMapping(exchange);
        } else {
        }
    }
}
