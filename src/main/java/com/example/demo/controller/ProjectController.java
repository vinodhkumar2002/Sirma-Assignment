package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@Api(tags="projectManagement" ,description="end points for managing projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    @ApiOperation(value = "Get all projects", notes = "Retrieves all projects from the system")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    @ApiOperation(value = "Get project based on id", notes = "Retrieves  project from the system based on id")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/project")
    @ApiOperation(value = "Create a new project", notes = "Creates a new project in the system")
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @PutMapping("/project/{id}")
    @ApiOperation(value = "updates the values based on id", notes = "updates project from the system based on id given")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id, @Valid @RequestBody Project project) {
        Project updatedProject = projectService.updateProject(id, project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }
    @DeleteMapping("/project")
    @ApiOperation(value = "Delete all projects", notes = "Deletes all projects from the system")
    public ResponseEntity<Void> deleteProject() {
        projectService.deleteProject();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/project/{id}")
    @ApiOperation(value = "delete project", notes = "Delete projects from the system based on id")
    public ResponseEntity<Void> deleteProjectById(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}