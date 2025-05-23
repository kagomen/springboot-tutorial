package com.example.three_layer.controller;

import com.example.three_layer.entity.TaskItem3;
import com.example.three_layer.service.TaskItem3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "タスク管理API(三層アーキテクチャ, DI)")
@RestController // ハンドラーメソッドの戻り値がレスポンスボディに書き出されるようになる
@RequestMapping("/task3")
// @RequiredArgsConstructor // Bean登録したクラスのコンストラクタを生成
public class TaskItem3Controller {

  private final TaskItem3Service service;

  @Autowired
  public TaskItem3Controller(TaskItem3Service service) {
    this.service = service;
  }

  @Operation(summary = "タスク一覧取得")
  @GetMapping
  public List<TaskItem3> getAll() {
    return service.findAll();
  }

  @Operation(summary = "タスク追加")
  @PostMapping
  public TaskItem3 addTaskItem(@RequestBody TaskItem3 taskItem) {
    return service.save(taskItem);
  }

  @Operation(summary = "タスク削除")
  @DeleteMapping("/{id}")
  public void deleteTaskItem(@PathVariable Integer id) { // @PathVariable: URLに含まれる変数を引数として受け取る
    service.deleteById(id);
  }
}
