package ru.eight.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * ��������� Get � Post ��������
 */

public class PostGetRequestHandler {

    public void handlerGetMapping(HttpExchange exchange) throws IOException {
        String response = "��������� ����� �������" + " ����� �����";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        System.out.println("����� �����");

    }

    public void handlerPostMapping(HttpExchange exchange) throws IOException {
        InputStreamReader inputStreamReader =
            new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            requestBody.append(line);
        }
        bufferedReader.close();

        String postBody = requestBody.toString();
        System.out.println("POST Body: " + postBody);

        // ���������� ������� ��������� ��������� �������
        exchange.sendResponseHeaders(200, postBody.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(postBody.getBytes());
        outputStream.close();
    }

}
