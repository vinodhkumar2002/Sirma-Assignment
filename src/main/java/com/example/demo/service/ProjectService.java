package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Project;

public interface ProjectService {
	 public List<Project> getAllProjects();
	 public Optional<Project> getProjectById(Long id);
	 public Project createProject(Project project);
	 public Project updateProject(Long id, Project project);
	 public void deleteProject(Long id);
	public void deleteProject();
}
