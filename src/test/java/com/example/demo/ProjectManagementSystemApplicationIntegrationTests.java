package com.example.demo;

import com.example.demo.entity.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectManagementSystemApplicationIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateProject() throws Exception {
        Project project = new Project();
        project.setName("Test Project");
        project.setDescription("Test Description");
        project.setStartDate(LocalDate.now());
        project.setEndDate(LocalDate.now().plusDays(30));

        mockMvc.perform(MockMvcRequestBuilders.post("/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(project)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void testGetAllProjects() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/project"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetProjectById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/project/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateProject() throws Exception {
        Project project = new Project();
        project.setName("Updated Project");
        project.setDescription("Updated Description");

        mockMvc.perform(MockMvcRequestBuilders.put("/project/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(project)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
 
    @Test
    void testDeleteProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/project/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
