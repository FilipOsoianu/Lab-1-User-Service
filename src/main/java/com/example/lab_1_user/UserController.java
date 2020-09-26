package com.example.lab_1_user;


import com.example.lab_1_user.data.UserData;
import com.example.lab_1_user.entities.User;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    UserData userData = new UserData();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


    @GetMapping("/user")
    public List<User> index() {
        return userData.fetchUsers();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        return userData.getUserById(userId);
    }

    @PostMapping("/user")
    public User create(@RequestBody Map<String, String> body) throws ParseException {
        int id = Integer.parseInt(body.get("id"));
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String email = body.get("email");
        Date birthDate = formatter.parse(body.get("birthDate"));
        return userData.createUser(id, firstName, lastName, email, birthDate);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException {
        int userId = Integer.parseInt(id);
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String email = body.get("email");
        Date birthDate = formatter.parse(body.get("birthDate"));

        return userData.updateUser(userId, firstName, lastName, email, birthDate);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        return userData.delete(userId);
    }

}