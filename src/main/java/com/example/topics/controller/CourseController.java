package com.example.topics.controller;

import com.example.topics.model.entity.Course;
import com.example.topics.model.entity.Topic;
import com.example.topics.service.CourseServiceImplementation;
import com.sun.istack.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class CourseController {

    private final CourseServiceImplementation courseService;

    public CourseController(CourseServiceImplementation courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.findAllCoursesByTopic(topicId);
    }

    @GetMapping("/{id}/courses/{courseId}")
    public Optional<Course> getCourseById(@PathVariable String id, @PathVariable String courseId) {
        return courseService.findCourseById(courseId);
    }

    @PostMapping(value = "/add/{topicId}/courses")
    public String addCourse(@NotNull @RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        return courseService.addCourse(course) ? "Course added successfully!" : "Please try again";
    }

    @PutMapping(value = "/update/{topicId}/courses/{id}")
    public String updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
        course.setTopic((new Topic(topicId, "", "")));
        return courseService.updateCourse(course) ? "Course updated successfully!" : "Please try again";
    }

    @DeleteMapping(value = "/delete/{topicId}/courses/{id}")
    public String deleteCourse(@PathVariable String id, @PathVariable String topicId) {
        return courseService.deleteCourse(id) ? "Course deleted successfully!" : "Please try again";
    }

}
