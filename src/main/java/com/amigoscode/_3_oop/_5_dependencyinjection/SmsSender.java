package com.amigoscode._3_oop._5_dependencyinjection;

public class SmsSender implements MessageSender {

    @Override
    public void send(String to, String message) {
        System.out.printf("[SMS] Sending to %s: %s", to, message);
    }
}
