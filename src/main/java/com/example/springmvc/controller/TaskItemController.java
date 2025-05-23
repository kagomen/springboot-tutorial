package com.example.springmvc.controller;

import com.example.springmvc.model.TaskItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "タスク管理API")
@RestController // 自動でJSONにパースして返す
@RequestMapping("/tasks")
public class TaskItemController {

  private final Map<Integer, TaskItem> taskItems = new HashMap<>();
  private int nextId = 1;

  @Operation(summary = "タスク一覧取得")
  @GetMapping
  public Collection<TaskItem> getTaskItems() {
    return taskItems.values();
  }

  @Operation(summary = "タスク追加")
  @PostMapping
  public TaskItem addTaskItem(@RequestBody TaskItem taskItem) { // JSONが自動でパースされ、オブジェクトとして受け取る
    taskItem.setId(nextId++);
    taskItems.put(taskItem.getId(), taskItem);
    return taskItem;
  }

  @Operation(summary = "タスク削除")
  @DeleteMapping("/{id}")
  public void deleteTaskItem(@PathVariable Integer id) {
    taskItems.remove(id);
  }
}
