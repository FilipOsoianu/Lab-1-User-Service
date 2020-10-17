//package com.example.lab_1_user.controller;
//
//import com.example.lab_1_user.entities.Status;
//import com.example.lab_1_user.entities.User;
//import com.example.lab_1_user.repositories.StatusRepository;
//import com.example.lab_1_user.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    UserRepository userRepository;
//    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//
//    @Autowired
//    StatusRepository statusRepository;
//
//
//    @GetMapping("/status")
//    public Status getStatus() {
//
//        return statusRepository.getStatus();
//    }
//
//    @GetMapping("/user")
//    public List<User> index() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/user/{id}")
//    public User show(@PathVariable String id) {
//        int userId = Integer.parseInt(id);
//        return userRepository.findUserById(userId);
//    }
//
//    @PostMapping("/user")
//    public User create(@RequestBody Map<String, String> body) throws ParseException {
//        String firstName = body.get("firstName");
//        String lastName = body.get("lastName");
//        String email = body.get("email");
//        Date birthDate = formatter.parse(body.get("birthDate"));
//
//        return userRepository.save(new User(firstName, lastName, email, birthDate));
//    }
//
//    @PutMapping("/user/{id}")
//    public User update(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException {
//        int userId = Integer.parseInt(id);
//        User user = userRepository.findUserById(userId);
//
//        user.setFirstName(body.get("firstName"));
//        user.setLastName(body.get("lastName"));
//        user.setEmail(body.get("email"));
//        user.setBirthDate(formatter.parse(body.get("birthDate")));
//
//        return userRepository.save(user);
//    }
//
//    @DeleteMapping("user/{id}")
//    public void delete(@PathVariable String id) {
//        int userId = Integer.parseInt(id);
//        userRepository.deleteById(userId);
//    }
//
//}