package com.maleda.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Learning;
import com.maleda.learningplatform.entity.User;

public interface LearningRepository extends JpaRepository<Learning, Long> {

	Learning findByUserAndCourse(User user, Course course);
}