package com.volunteer.platform.repository;

import com.volunteer.platform.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
