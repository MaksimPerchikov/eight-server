package ru.eight;

import static ru.eight.variables.ConstantForServerNotification.SERVER_STARTING_ON_PORT;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import ru.eight.handlers.ChoiceHandler;
import ru.eight.handlers.PostGetRequestHandler;
import ru.eight.service.ServiceNotification;

public class MainApplicationServer {

    public static void main(String[] args) throws IOException{
        startServer();
    }

    public static void startServer() throws IOException {
        ServiceNotification notification = new ServiceNotification();
        HttpServer server = HttpServer.create(new InetSocketAddress(8083), 0);
        server.createContext("/", new ChoiceHandler(new PostGetRequestHandler()));
        server.setExecutor(null);
        server.start();
        notification.showMeMessage(SERVER_STARTING_ON_PORT.getMess());
    }
}
