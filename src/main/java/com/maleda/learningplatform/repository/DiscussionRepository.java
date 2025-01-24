package com.maleda.learningplatform.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {

    List<Discussion> findByCourse(Course course);
}
