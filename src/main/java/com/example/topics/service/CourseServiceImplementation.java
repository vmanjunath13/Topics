package com.example.topics.service;

import com.example.topics.model.entity.Course;
import com.example.topics.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService {

    private final CourseRepository courseRepository;


    private List<Course> CoursesList = new ArrayList<>(Arrays.asList(
            new Course("spring", "spring framework", "spring framework desc", ""),
            new Course("springboot", "spring boot framework", "spring boot framework desc", ""),
            new Course("java", "java", "java desc", "")
    ));

    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAllCoursesByTopic(String topicId) {
        return new ArrayList<>(courseRepository.findByTopicId(topicId));
    }


    public Optional<Course> findCourseById(String id) {
        return courseRepository.findById(id);
    }


    public boolean addCourse(Course Course) {
        courseRepository.save(Course);
        return true;
    }


    public boolean updateCourse(Course Course) {
        courseRepository.save(Course);
        return true;
    }


    public boolean deleteCourse(String id) {
        courseRepository.deleteById(id);
        return true;
    }


}
