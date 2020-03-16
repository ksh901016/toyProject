package com.corn.toy.spring.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSourceAppRunner implements ApplicationRunner {
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(applicationContext.getMessage("greeting", new String[]{"corn"}, Locale.KOREA));
        System.out.println(applicationContext.getMessage("greeting", new String[]{"corn"}, Locale.getDefault()));
    }
}
