package com.maleda.learningplatform.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maleda.learningplatform.dto.ProgressRequest;
import com.maleda.learningplatform.entity.Progress;
import com.maleda.learningplatform.service.ProgressService;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(allowCredentials = "")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/{userId}/{courseId}")
    public float getProgress(@PathVariable Long userId, @PathVariable Long courseId) {
        return progressService.getProgress(userId, courseId);
    }

    @PutMapping("/update-progress")
    public ResponseEntity<String> updateProgress(@RequestBody ProgressRequest request) {
        return progressService.updateProgress(request);
    }
    
    @PutMapping("/update-duration")
    public ResponseEntity<String> updateDuration(@RequestBody ProgressRequest request) {
        return progressService.updateDuration(request);
    }
}