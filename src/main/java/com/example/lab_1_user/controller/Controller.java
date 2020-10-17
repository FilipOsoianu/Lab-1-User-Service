package com.example.lab_1_user.controller;

import com.example.lab_1_user.jms.Sender;
import com.example.lab_1_user.repositories.StatusRepository;
import com.example.lab_1_user.repositories.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

@RestController
public class Controller {
    @Autowired
    private Sender sender;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatusRepository statusRepository;

    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public ResponseEntity request(final HttpServletRequest request) throws JMSException, IOException, ParseException {
        String header = request.getHeader("priority");
        int priority = header == null ? 4 : Integer.parseInt(header);
        String url = request.getRequestURI();
        String method = request.getMethod();
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        String jsonString = new JSONObject().put("url", url).put("method", method).put("body", sb).toString();
        TextMessage textMessage = (TextMessage) sender.send(jsonString, priority);

        JSONObject jsonObject = new JSONObject(textMessage.getText());
        switch (jsonObject.getString("method")) {
            case "GET":
                if (jsonObject.getString("url").equals("/user")) {
                    return new ResponseEntity(UserController.getUsers(userRepository), HttpStatus.OK);
                } else if (jsonObject.getString("url").equals("/status")) {
                    return new ResponseEntity(UserController.getStatus(statusRepository), HttpStatus.OK);
                } else if (jsonObject.getString("url").contains("/user/")) {
                    String id = jsonObject.getString("url").substring(6);
                    if (id.isEmpty()) {
                        return new ResponseEntity(HttpStatus.BAD_REQUEST);
                    } else
                        try {
                            return new ResponseEntity(UserController.getUser(userRepository, Integer.parseInt(jsonObject.getString("url").substring(6))), HttpStatus.OK);
                        } catch (NumberFormatException nfe) {
                            return new ResponseEntity(HttpStatus.BAD_REQUEST);
                        }
                } else {
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
                }
            case "POST":
                if (jsonObject.getString("url").equals("/user")) {
                    return new ResponseEntity(UserController.createUser(userRepository, jsonObject.getString("body")), HttpStatus.OK);
                } else
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
            case "PUT":
                if (jsonObject.getString("url").contains("/user/")) {
                    if (jsonObject.getString("url").substring(6).isEmpty()) {
                        return new ResponseEntity(HttpStatus.BAD_REQUEST);
                    } else {
                        try {

                            return new ResponseEntity(UserController.updateUser(userRepository, Integer.parseInt(jsonObject.getString("url").substring(6)), jsonObject.getString("body")), HttpStatus.OK);
                        } catch (NumberFormatException nfe) {
                            return new ResponseEntity(HttpStatus.BAD_REQUEST);
                        }
                    }
                }
            case "DELETE":
                if (jsonObject.getString("url").contains("/user/")) {
                    if (jsonObject.getString("url").substring(6).isEmpty()) {
                        return new ResponseEntity(HttpStatus.BAD_REQUEST);
                    } else
                        UserController.deleteUser(userRepository, jsonObject.getString("url").substring(6));
                }
            default:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

