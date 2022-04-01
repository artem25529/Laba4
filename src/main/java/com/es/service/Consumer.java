package com.es.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/dest", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class Consumer implements MessageListener {
    @EJB
    private MSGService msgService;

    @Override
    public void onMessage(Message message) {
        try {
            String msg = ((TextMessage) message).getText();
            msgService.add(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

