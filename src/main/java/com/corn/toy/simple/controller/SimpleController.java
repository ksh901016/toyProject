package com.corn.toy.simple.controller;

import com.corn.toy.simple.constants.Level;
import com.corn.toy.simple.entity.User;
import com.corn.toy.simple.property.LevelPropertyEditor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class SimpleController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
    }

    @GetMapping("/binding")
    public void binding(@RequestParam Level level){
        log.debug("level : {}", level);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }

    @PostMapping("/users")
    public void users(@RequestBody @RequestParam String productSeq){
        System.out.println("#########");
        System.out.println(productSeq);
        System.out.println("#########");
    }

}
