package com.maleda.learningplatform.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maleda.learningplatform.entity.Assessment;
import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.User;
import com.maleda.learningplatform.service.AssessmentService;
import com.maleda.learningplatform.service.CourseService;
import com.maleda.learningplatform.service.UserService;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/user/{userId}/course/{courseId}")
    public ResponseEntity<List<Assessment>> getAssessmentsByUserAndCourse(
            @PathVariable Long userId,
            @PathVariable Long courseId
    ) {
    	User user = userService.getUserById(userId);
        Course course = courseService.getCourseById(courseId);

        List<Assessment> assessments = assessmentService.getAssessmentsByUserAndCourse(user, course);
        return ResponseEntity.ok(assessments);
    }
    
    @GetMapping("/perfomance/{userId}")
    public ResponseEntity<List<Assessment>> getAssessmentsByUser(@PathVariable Long userId){
    	User user = userService.getUserById(userId);
    	return assessmentService.getAssessmentByUser(user);
    }
    
    @PostMapping("/add/{userId}/{courseId}")
    public ResponseEntity<Assessment> addAssessmentWithMarks(
            @PathVariable Long userId,
            @PathVariable Long courseId,
            @RequestBody Assessment assessment) {
    	
        User user = userService.getUserById(userId);
        Course course = courseService.getCourseById(courseId);
        return assessmentService.saveAssessment(user , course, assessment);
    }
}
