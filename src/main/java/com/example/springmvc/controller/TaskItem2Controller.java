package com.example.springmvc.controller;

import com.example.springmvc.model.TaskItem;
import com.example.springmvc.repository.TaskItemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "タスク管理API")
@RestController
@RequestMapping("/tasks2")
public class TaskItem2Controller {

  private final TaskItemRepository repository;

  // SpringBootがTaskItemRepositoryを探して、ここに注入（DI）する（コンストラクタインジェクション）
  public TaskItem2Controller(TaskItemRepository repository) {
    this.repository = repository;
  }

  @Operation(summary = "タスク一覧取得（DB）")
  @GetMapping
  public Collection<TaskItem> getTaskItems() {
    return repository.findAll();
  }

  @Operation(summary = "タスク追加（DB）")
  @PostMapping
  public TaskItem addTaskItem(@RequestBody TaskItem taskItem) {
    return repository.save(taskItem);
  }

  @Operation(summary = "タスク削除（DB）")
  @DeleteMapping("/{id}")
  public void deleteTaskItem(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
