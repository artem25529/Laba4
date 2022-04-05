package com.es.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

@MessageDriven(mappedName = "jms/dest", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class Consumer implements MessageListener {
    private static final Path PATH = Paths.get("E:\\Programs\\glassfish5\\file.txt");

    @Override
    public void onMessage(Message message) {
        try {
            String msg = ((TextMessage) message).getText();
            List<String> lines = Files.readAllLines(PATH);
            lines.add(msg);
            lines.sort(Comparator.comparingInt(String::length));
            Files.write(PATH, lines);
        } catch (JMSException | IOException e) {
            e.printStackTrace();
        }
    }
}

