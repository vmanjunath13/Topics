package com.example.topics.repository;

import com.example.topics.model.entity.Course;
import com.example.topics.model.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findByTopicId(String topicId);


}
