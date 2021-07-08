package com.example.topics.service;

import com.example.topics.model.entity.Topic;
import com.example.topics.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImplementation implements TopicService {

    private final TopicRepository topicRepository;



    private List<Topic> topicsList = new ArrayList<>(Arrays.asList(
            new Topic("spring", "spring framework", "spring framework desc"),
            new Topic("springboot", "spring boot framework", "spring boot framework desc"),
            new Topic("java", "java", "java desc")
    ));

    public TopicServiceImplementation(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> findAllTopics() {
        return new ArrayList<>(topicRepository.findAll());
    }


    public Optional<Topic> findTopicById(String id) {
        return topicRepository.findById(id);
    }


    public boolean addTopic(Topic topic) {
        topicRepository.save(topic);
        return true;
    }


    public boolean updateTopic(Topic topic, String id) {
        topicRepository.save(topic);
        return true;
    }


    public boolean deleteTopic(String id) {
        topicRepository.deleteById(id);
        return true;
    }


}
