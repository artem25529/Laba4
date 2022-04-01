package com.es.service;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.*;

@Singleton
public class Producer {
    @Resource(mappedName = "jms/queue")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/dest")
    private Queue queue;

    public void sendJMSMessage(String message) {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            producer.send(createTestMessage(session, message));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private TextMessage createTestMessage(Session session, String message) throws JMSException {
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText(message);
        return textMessage;
    }
}
