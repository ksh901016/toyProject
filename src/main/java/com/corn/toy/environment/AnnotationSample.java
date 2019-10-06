package com.corn.toy.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:app.properties")
public class AnnotationSample implements ApplicationRunner {

    @Autowired
    ApplicationContext context;

    @Value("${app.name}")
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Environment environment = context.getEnvironment();
        System.out.println(environment.getProperty("app.name"));
        System.out.println(environment.getProperty("app.pw"));
        System.out.println("=====" + name + "=====");
    }
}
