package com.walkthrough.demo.controller;

import com.walkthrough.demo.entitie.User;
import com.walkthrough.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestTest {

    public final UserService userService;

    @PostMapping("/add")
    public String sayHi(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
        userService.addUser(id, name, age);
        return "user added";
    }

    @GetMapping("/read")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/read/name")
    public List<User> getByName(@RequestParam String name) {
        return userService.getUsersByName(name);
    }

    //o metoda pentru modificarea utilizatorilor si una pentru stergere
}
