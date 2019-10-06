package com.corn.toy.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Sample implements ApplicationRunner {
    @Autowired
    ApplicationContext context;
    @Autowired
    BookService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Environment environment = context.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(service);

        ConfigurableEnvironment env = (ConfigurableEnvironment) context.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        propertySources.addLast(new ResourcePropertySource("classpath:app.properties"));
        System.out.println(env.getProperty("app.name"));
        System.out.println(env.getProperty("app.pw"));
    }
}
