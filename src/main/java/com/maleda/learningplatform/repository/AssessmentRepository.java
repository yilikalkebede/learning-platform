package com.maleda.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Assessment;
import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.User;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    List<Assessment> findByUserAndCourse(User user, Course course);

	List<Assessment> findByUser(User user);
}
