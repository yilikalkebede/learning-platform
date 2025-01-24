package com.maleda.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Long> {

	List<Questions> findByCourse(Course course); 
}
