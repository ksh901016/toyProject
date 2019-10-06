package com.corn.toy.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JacksonTestController {

    @GetMapping("/enumTest")
    public JacksonModel test(){
        JacksonModel model = new JacksonModel();
        model.setTest(JacksonEnum.TEST1);
        return model;
    }
}
