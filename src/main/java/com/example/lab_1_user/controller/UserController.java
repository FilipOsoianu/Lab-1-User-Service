package com.example.lab_1_user.controller;

import com.example.lab_1_user.entities.Status;
import com.example.lab_1_user.entities.User;
import com.example.lab_1_user.repositories.StatusRepository;
import com.example.lab_1_user.repositories.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static org.hibernate.internal.util.collections.ArrayHelper.toList;

public class UserController {



    public static Status getStatus(StatusRepository statusRepository) {
        return statusRepository.getStatus();
    }

    public static List<User> getUsers(UserRepository userRepository) {
        return userRepository.findAll();
    }

    public static User getUser(UserRepository userRepository, int id) {
        return userRepository.findUserById(id);
    }

    public static User createUser(UserRepository userRepository, String json) throws ParseException {
        Map<String, String> body = toMap(new JSONObject(json));
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String email = body.get("email");
        LocalDate birthDate = LocalDate.parse(body.get("birthDate"));
        return userRepository.save(new User(firstName, lastName, email, birthDate));
    }

    public static User updateUser(UserRepository userRepository, int id, String json) throws ParseException {
        Map<String, String> body = toMap(new JSONObject(json));

        User user = userRepository.findUserById(id);

        user.setFirstName(body.get("firstName"));
        user.setLastName(body.get("lastName"));
        user.setEmail(body.get("email"));
        user.setBirthDate(LocalDate.parse(body.get("birthDate")));

        return userRepository.save(user);
    }

    public static void deleteUser(UserRepository userRepository, String id) {
        int userId = Integer.parseInt(id);
        userRepository.deleteById(userId);
    }


    public static Map<String, String> toMap(JSONObject object) throws JSONException {
        Map<String, String> map = new HashMap<>();
        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList(value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, (String) value);
        }
        return map;
    }

}