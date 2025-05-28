package com.example.three_layer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.three_layer.dto.TaskItem3PatchRequest;
import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3UpdateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskItem3ControllerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @WithMockUser(username = "user")
  @Test
  void addTaskItem_タスクを新しく作成できる() throws JsonProcessingException, Exception {
    // リクエストDTO
    var req = new TaskItem3Request();
    req.setTitle("掃除");
    req.setDone(false);

    mockMvc
        .perform(
            post("/task3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data.title").value("掃除"))
        .andExpect(jsonPath("$.data.done").value(false));
  }

  @WithMockUser(username = "user", roles = "USER")
  @Test
  void addTaskItem_不正な値が入力されたなら例外を投げる() throws Exception {
    var invalid = new TaskItem3Request();

    mockMvc
        .perform(
            post("/task3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalid)))
        .andExpect(status().isBadRequest());
  }

  @Sql(statements = {"INSERT INTO task_item3 (id, title, done) VALUES (1, '掃除', false)"})
  @WithMockUser(username = "user", roles = "USER")
  @Test
  void testUpdateTaskItem() throws JsonProcessingException, Exception {
    var req = new TaskItem3UpdateRequest();
    req.setTitle("掃除");
    req.setDone(true);

    mockMvc
        .perform(
            put("/task3/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data.title").value("掃除"))
        .andExpect(jsonPath("$.data.done").value(true));
  }

  @Sql(statements = {"INSERT INTO task_item3 (id, title, done) VALUES (1, '掃除', false)"})
  @WithMockUser(username = "user", roles = "USER")
  @Test
  void testPatchTaskItem() throws JsonProcessingException, Exception {
    var req = new TaskItem3PatchRequest();
    req.setTitle(null);
    req.setDone(null);

    mockMvc
        .perform(
            patch("/task3/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data.title").value("掃除"))
        .andExpect(jsonPath("$.data.done").value(false));
  }

  @WithMockUser(username = "user", roles = "USER")
  @Test
  void deleteTaskItem_一般ユーザーはタスクを削除できない() throws Exception {
    mockMvc.perform(delete("/task3/1")).andExpect(status().isForbidden());
  }

  @Sql(
      statements = {
        "INSERT INTO task_item3 (id, title, done) VALUES (1, '掃除', false)"
      }) // テーブル名はクラス名からJPAがスネークケースで生成 TaskItem3 -> task_item3
  @WithMockUser(username = "admin", roles = "ADMIN")
  @Test
  void deleteTaskItem_管理ユーザーはタスクを削除できる() throws Exception {
    mockMvc
        .perform(delete("/task3/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true));
  }

  @WithMockUser(username = "admin", roles = "ADMIN")
  @Test
  void deleteTaskItem_存在しないタスクなら例外を投げる() throws Exception {
    mockMvc.perform(delete("/task3/999")).andExpect(status().isNotFound());
  }
}
