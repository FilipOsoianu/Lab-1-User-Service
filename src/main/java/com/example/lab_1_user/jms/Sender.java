package com.example.lab_1_user.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.TextMessage;

import static com.example.lab_1_user.config.ActiveMQConfig.ORDER_QUEUE;

public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String message, int priority) {
        System.out.println(message);
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setPriority(priority);
        jmsTemplate.convertAndSend("helloworld.q", message);
    }
}
