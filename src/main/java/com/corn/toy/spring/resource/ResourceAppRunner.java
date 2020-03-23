package com.corn.toy.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

@Component
public class ResourceAppRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("== resources ==");

        System.out.println(resourceLoader.getClass());

        Resource servletContextResource = resourceLoader.getResource("test.txt");
        System.out.println(servletContextResource.getClass());

        Resource classPathResource = resourceLoader.getResource("classpath:test.txt");
        System.out.println(classPathResource.getClass());

        System.out.println("== resources ==");
    }
}