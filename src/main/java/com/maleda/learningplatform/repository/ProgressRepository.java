package com.maleda.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Progress;
import com.maleda.learningplatform.entity.User;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

	Progress findByUserAndCourse(User user, Course course);
}
