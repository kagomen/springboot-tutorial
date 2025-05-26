package com.example.three_layer.controller;

import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3Response;
import com.example.three_layer.dto.TaskItem3UpdateRequest;
import com.example.three_layer.entity.TaskItem3;
import com.example.three_layer.mapper.TaskItem3Mapper;
import com.example.three_layer.service.TaskItem3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "タスク管理API(三層アーキテクチャ, DI)")
@RestController // ハンドラーメソッドの戻り値がレスポンスボディに書き出されるようになる
@RequestMapping("/task3")
// @RequiredArgsConstructor // Bean登録したクラスのコンストラクタを生成
public class TaskItem3Controller {

  private final TaskItem3Service service;
  private final TaskItem3Mapper mapper;

  @Autowired
  public TaskItem3Controller(TaskItem3Service service, TaskItem3Mapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @Operation(summary = "タスク一覧取得")
  @GetMapping
  public List<TaskItem3Response> getAll() {
    List<TaskItem3> taskItems = service.findAll();
    return taskItems.stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  @Operation(summary = "タスク追加")
  @PostMapping
  public TaskItem3Response addTaskItem(@RequestBody @Valid TaskItem3Request req) {
    var taskItem = mapper.toEntity(req);
    return mapper.toDTO(service.save(taskItem));
  }

  @Operation(summary = "タスク更新")
  @PutMapping("/{id}")
  public TaskItem3Response updateTaskItem(
      @PathVariable Integer id, @RequestBody @Valid TaskItem3UpdateRequest req) {
    var taskItem = mapper.toEntity(id, req);
    var result = service.update(id, taskItem);
    return mapper.toDTO(result);
  }

  @Operation(summary = "タスク削除")
  @DeleteMapping("/{id}")
  public void deleteTaskItem(@PathVariable Integer id) { // @PathVariable: URLに含まれる変数を引数として受け取る
    service.deleteById(id);
  }
}
