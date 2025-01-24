package com.maleda.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
