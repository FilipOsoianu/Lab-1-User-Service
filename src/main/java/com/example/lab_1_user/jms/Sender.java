package com.example.lab_1_user.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;

import static com.example.lab_1_user.config.ActiveMQConfig.USER_QUEUE;


public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public Message send(String message, int priority) {
//        TO CHECK LIMIT NUMBER OF TASKS
//        System.out.println(message);
        return jmsTemplate.sendAndReceive(USER_QUEUE, session -> {
            jmsTemplate.setExplicitQosEnabled(true);
            jmsTemplate.setPriority(priority);
            return session.createTextMessage(message);
        });
    }
}
