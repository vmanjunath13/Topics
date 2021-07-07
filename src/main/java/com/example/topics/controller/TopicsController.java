package com.example.topics.controller;

import com.example.topics.model.entity.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @RequestMapping("/topics")
    public List<Topic> getALlTopics() {
        return Arrays.asList(
                new Topic("spring", "spring framework", "spring framework desc"),
                new Topic("springboot", "spring boot framework", "spring boot framework desc"),
                new Topic("java", "java", "java desc")
        );
    }
}
