package com.maleda.learningplatform.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maleda.learningplatform.dto.EnrollRequest;
import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Learning;
import com.maleda.learningplatform.service.LearningService;

import java.util.List;

@RestController
@RequestMapping("/api/learning")
public class LearningController {

    @Autowired
    private LearningService learningService;

    @GetMapping("/{userId}")
    public List<Course> getLearningCourses(@PathVariable Long userId) {
        return learningService.getLearningCourses(userId);
    }
    
    @GetMapping
    public List<Learning> getEnrollments() {
        return learningService.getEnrollments();
    }

    @PostMapping
    public String enrollCourse(@RequestBody EnrollRequest enrollRequest) {
    	System.out.println(enrollRequest.getCourseId() +" = "+enrollRequest.getUserId());
        return learningService.enrollCourse(enrollRequest);
    }

    @DeleteMapping("/{id}")
    public void unenrollCourse(@PathVariable Long id) {
        learningService.unenrollCourse(id);
    }
}
