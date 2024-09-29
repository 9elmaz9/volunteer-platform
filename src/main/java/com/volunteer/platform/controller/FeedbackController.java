package com.volunteer.platform.controller;

import com.volunteer.platform.model.Feedback;
import com.volunteer.platform.model.Project;
import com.volunteer.platform.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public void submitFeedback(@RequestBody Feedback feedback) {
        feedbackService.submitFeedback(feedback);
    }

    @GetMapping("/project/{projectId}")
    public List<Feedback> getFeedbackForProject(@PathVariable Long projectId) {
        Project project = new Project();
        project.setId(projectId);
        return feedbackService.getFeedbackForProject(project);
    }

    @DeleteMapping("/{feedbackId}")
    public void deleteFeedback(@PathVariable Long feedbackId) {
        Feedback feedback = new Feedback();
        feedback.setId(feedbackId);
        feedbackService.deleteFeedback(feedback);
    }
}
