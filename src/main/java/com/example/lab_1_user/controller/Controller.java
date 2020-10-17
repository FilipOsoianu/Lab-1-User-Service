package com.example.lab_1_user.controller;

import com.example.lab_1_user.jms.Receiver;
import com.example.lab_1_user.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
public class Controller {
    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @RequestMapping(value = "/**/{[path:[^\\.]*}")

    public void index(final HttpServletRequest request) throws InterruptedException {
        String header = request.getHeader("priority");
        int priority = Integer.parseInt(header);

        System.out.println("dadada");
        sender.send("Hello Spring JMS ActiveMQ! =" + priority, priority);
        Thread.sleep(10000);

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}
