package com.corn.toy.simple.controller;

import com.corn.toy.simple.constants.Level;
import com.corn.toy.simple.entity.User;
import com.corn.toy.simple.bind.LevelPropertyEditor;
import com.corn.toy.simple.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SimpleController {

    @Autowired
    private UserValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
    }

    @GetMapping("/add")
    public void add(@ModelAttribute User user, BindingResult result){
        log.info("User : {}", user);
        this.validator.validate(user, result);
        if(result.hasErrors()){
            log.info("오류가 발견되었을 때..");
            System.out.println(result.getAllErrors());
        }else{
            log.info("오류가 없을 때..");
        }
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
