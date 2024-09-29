package com.volunteer.platform.service;

import com.volunteer.platform.model.Feedback;
import com.volunteer.platform.model.Project;

import java.util.List;

public interface FeedbackService {
    void submitFeedback(Feedback feedback);
    List<Feedback> getFeedbackForProject(Project project);
    void deleteFeedback(Feedback feedback);
}
