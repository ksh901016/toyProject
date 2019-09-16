package com.corn.toy.user.controller;

import com.corn.toy.user.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private static List<User> entityList = new ArrayList<>();
    static{
        entityList.add(new User("어린깡냉", "20", "01/01/2019"));
        entityList.add(new User("KANG", "30", "01/01/2020"));
        entityList.add(new User("나이많은 깡냉", "40", "01/01/2021"));
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return entityList;
    }

    @GetMapping("/users/{name}")
    public List<User> getUserByName(@PathVariable String name){
        return entityList.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @PostMapping("/users")
    public User add(@RequestBody User user){
        entityList.add(user);
        return user;
    }
}
