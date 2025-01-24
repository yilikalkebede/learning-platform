package com.maleda.learningplatform.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.entity.Discussion;
import com.maleda.learningplatform.repository.DiscussionRepository;


@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    public List<Discussion> getDiscussionsCourse(Course course) {
        return discussionRepository.findByCourse(course);
    }
    public Discussion createDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }
}
