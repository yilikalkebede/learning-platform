package com.maleda.learningplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maleda.learningplatform.dto.DiscussionRequest;
import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Discussion;
import com.maleda.learningplatform.entity.User;
import com.maleda.learningplatform.service.CourseService;
import com.maleda.learningplatform.service.DiscussionService;
import com.maleda.learningplatform.service.UserService;

@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseId}")
    public ResponseEntity<List<Discussion>> getDiscussionsAndCourse(
            @PathVariable Long courseId
    ) {
        Course course = courseService.getCourseById(courseId);
        List<Discussion> discussions = discussionService.getDiscussionsCourse(course);
        return ResponseEntity.ok(discussions);
    }
    @PostMapping("/addMessage")
    public ResponseEntity<Discussion> createDiscussion(
            @RequestBody DiscussionRequest discussionRequest
    ) {
    	System.out.println(discussionRequest.getCourse_id() +" "+discussionRequest.getName()+" "+discussionRequest.getContent());
        Course course = courseService.getCourseById(discussionRequest.getCourse_id());
        Discussion discussion = new Discussion();
        discussion.setuName(discussionRequest.getName());
        discussion.setCourse(course);
        discussion.setContent(discussionRequest.getContent());
        Discussion createdDiscussion = discussionService.createDiscussion(discussion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscussion);
    }
}
