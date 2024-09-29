package com.volunteer.platform.service;

import com.volunteer.platform.model.Feedback;
import com.volunteer.platform.model.Project;
import com.volunteer.platform.repository.FeedbackRepository;
import com.volunteer.platform.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void submitFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbackForProject(Project project) {
        return feedbackRepository.findByProject(project);
    }

    @Override
    public void deleteFeedback(Feedback feedback) {
        feedbackRepository.delete(feedback);
    }
}
