package com.maleda.learningplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
}