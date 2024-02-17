package ru.eight.variables;

/**
 * Константы для ServerNotification
 */
public enum ConstantForServerNotification {

    SERVER_STARTING_ON_PORT("Сервер запущен на порте 8083...");

    private String mess;

    public String getMess() {
        return mess;
    }

    ConstantForServerNotification(String mess) {
        this.mess = mess;
    }
}
