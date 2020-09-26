package com.example.lab_1_user.data;

import com.example.lab_1_user.entities.User;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class UserData {
    private List<User> users;
    public UserData() {
        users = new ArrayList<User>();
        users.add(new User(1, "Filip", "Osoianu", "filip.osoianu@gmail.com", new Date()));
        users.add(new User(2, "Jora", "Jorik", "jora.jorik@gmail.com", new Date()));
        users.add(new User(3, "Jorik", "Jora", "jorik.jora@gmail.com", new Date()));
    }

    public List<User> fetchUsers() {
        return users;
    }


    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;

            }
        }
        return null;
    }


    // create user
    public User createUser(int id, String firstName, String lastName, String email, Date birtDate) {
        User newUser = new User(id, firstName, lastName, email, birtDate);
        users.add(newUser);
        return newUser;
    }

    // update user
    public User updateUser(int id, String firstName, String lastName, String email, Date birthDate) {
        for (User user : users) {
            if (user.getId() == id) {
                int userIndex = users.indexOf(user);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setBirthDate(birthDate);
                users.set(userIndex, user);
                return user;
            }
        }

        return null;
    }

    // delete blog by id
    public boolean delete(int id) {
        int userIndex = -1;
        for (User user : users) {
            if (user.getId() == id) {
                userIndex = users.indexOf(user);
            }
        }
        if (userIndex > -1) {
            users.remove(userIndex);
        }
        return true;
    }

}
