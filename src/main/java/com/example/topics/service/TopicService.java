package com.example.topics.service;

import com.example.topics.model.entity.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> findAllTopics();
    Topic findTopicById(String id);
    boolean addTopic(Topic topic);
    boolean updateTopic(Topic topic, String id);
    boolean deleteTopic(String id);
}
