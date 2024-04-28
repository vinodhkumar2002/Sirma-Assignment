package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceimpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    // Methods for CRUD operations
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

   public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project project) {
        project.setId(id); // Ensure the ID is set
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

	@Override
	public void deleteProject() {
		projectRepository.deleteAll();
		
	}
}