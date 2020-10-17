package com.example.lab_1_user.jms;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class Receiver {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver.class);


    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "helloworld.q")
    public void receive(String message) throws InterruptedException {

        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }
}