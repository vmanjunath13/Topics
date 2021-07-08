package com.example.topics.service;

import com.example.topics.model.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicServiceImplementation implements TopicService {

    private List<Topic> topicsList = new ArrayList<>(Arrays.asList(
            new Topic("spring", "spring framework", "spring framework desc"),
            new Topic("springboot", "spring boot framework", "spring boot framework desc"),
            new Topic("java", "java", "java desc")
    ));

    @Override
    public List<Topic> findAllTopics() {
        return topicsList;
    }

    @Override
    public Topic findTopicById(String id) {
        return topicsList.stream().filter(t -> id.equals(t.getId())).findFirst().get();
    }

    @Override
    public boolean addTopic(Topic topic) {
        return topicsList.add(topic);
    }

    @Override
    public boolean updateTopic(Topic topic, String id) {
        for (int i = 0; i < topicsList.size(); i++) {
            if(topicsList.get(i).getId().equals(id)) {
                topicsList.set(i, topic);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteTopic(String id) {
        return topicsList.removeIf(t -> id.equals(t.getId()));
    }


}
