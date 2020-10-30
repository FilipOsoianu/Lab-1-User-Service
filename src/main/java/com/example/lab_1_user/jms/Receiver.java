package com.example.lab_1_user.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;

import static com.example.lab_1_user.config.ActiveMQConfig.USER_QUEUE;

public class Receiver {
    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = USER_QUEUE)
    public void receive(Message message) throws JMSException {
        jmsTemplate.send(message.getJMSReplyTo(), session -> {
//            TO CHECK PRIORITY
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           System.out.println(message);
            jmsTemplate.setPriority(message.getJMSPriority());
                    return message;
                }
        );
    }
}
