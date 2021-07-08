package com.example.topics.controller;

import com.example.topics.model.entity.Topic;
import com.example.topics.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    private final TopicService topicService;

    public TopicsController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable String id) {
        return topicService.findTopicById(id);
    }

    @PostMapping(value = "/add")
    public String addTopic(@RequestBody Topic topic) {
       return topicService.addTopic(topic) ? "Topic added successfully!" : "Please try again";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        return topicService.updateTopic(topic, id) ? "Topic updated successfully!" : "Please try again";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTopic(@PathVariable String id) {
        return topicService.deleteTopic(id) ? "Topic deleted successfully!" : "Please try again";
    }

}
