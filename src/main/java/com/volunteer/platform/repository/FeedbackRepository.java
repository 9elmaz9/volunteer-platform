package com.volunteer.platform.repository;

import com.volunteer.platform.model.Feedback;
import com.volunteer.platform.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByProject(Project project);
}
