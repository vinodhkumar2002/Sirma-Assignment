package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagementSystemApllicationTests{
	@Autowired
	private ProjectService projectService;
	@MockBean
	private ProjectRepository projectRepository;
	@Test
	public void getAllProjectsTest() {
		when(projectRepository.findAll()).thenReturn(Stream.of(new Project(1L,"vk","vk",null,null),new Project(2L,"vk","vk",null,null)).collect(Collectors.toList()));
		assertEquals(2,projectService.getAllProjects().size());
	}
	@Test
	public void getProjectByIdTests() {
		        Project project = new Project(1L, "Project 1", "Description 1", null, null);
		        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
		        Optional<Project> result = projectService.getProjectById(1L);
		        assertEquals(project, result);
		        verify(projectRepository, times(1)).findById(1L);
		    }
	 	@Test
	   public void createProject() {
	        Project project = new Project(1L, "Project 1", "Description 1", null, null);
	        when(projectRepository.save(project)).thenReturn(project);
	        Project result = projectService.createProject(project);
	        assertEquals(project, result);
	        verify(projectRepository, times(1)).save(project);
	    }
	 
	 	@Test
	    void updateProject() {
	        Project project = new Project(1L, "Project 1", "Description 1", null, null);
	        when(projectRepository.existsById(1L)).thenReturn(true);
	        when(projectRepository.save(project)).thenReturn(project);
	        Project result = projectService.updateProject(1L, project);
	        assertEquals(project, result);
	        verify(projectRepository, times(1)).save(project);
	    }

	    @Test
	    void deleteProject() {
	        long projectId = 1L;
	        projectService.deleteProject(projectId);
	        verify(projectRepository, times(1)).deleteById(projectId);
	    }

	  



	}


