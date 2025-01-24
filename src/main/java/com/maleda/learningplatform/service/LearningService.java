package com.maleda.learningplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maleda.learningplatform.dto.EnrollRequest;
import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Learning;
import com.maleda.learningplatform.entity.Progress;
import com.maleda.learningplatform.entity.User;
import com.maleda.learningplatform.repository.CourseRepository;
import com.maleda.learningplatform.repository.LearningRepository;
import com.maleda.learningplatform.repository.ProgressRepository;
import com.maleda.learningplatform.repository.UserRepository;
import java.util.*;

@Service
public class LearningService {

    @Autowired
    private LearningRepository learningRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private ProgressRepository progressRepository;

    public List<Course> getLearningCourses(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Course> learningCourses = new ArrayList<>();

            for (Learning learning : user.getLearningCourses()) {
                Course course = learning.getCourse();
                learningCourses.add(course);
            }

            return learningCourses;
        }

        return null;
    }
    
    public List<Learning> getEnrollments() {
    	return learningRepository.findAll();
    }

    public String enrollCourse(EnrollRequest enrollRequest) {
        User user = userRepository.findById(enrollRequest.getUserId()).orElse(null);
        Course course = courseRepository.findById(enrollRequest.getCourseId()).orElse(null);

        if (user != null && course != null) {
            Learning existingLearning = learningRepository.findByUserAndCourse(user, course);
            if (existingLearning != null) {
                return "Course already enrolled";
            }

            Progress progress = new Progress();
            progress.setUser(user);
            progress.setCourse(course);
            progressRepository.save(progress);

            Learning learning = new Learning();
            learning.setUser(user);
            learning.setCourse(course);
            learningRepository.save(learning);

            return "Enrolled successfully";
        }

        return "Failed to enroll";
    }


    public void unenrollCourse(Long id) {
        learningRepository.deleteById(id);
    }
}

