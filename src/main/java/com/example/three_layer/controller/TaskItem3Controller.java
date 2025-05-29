package com.example.three_layer.controller;

import com.example.three_layer.common.ApiResponse;
import com.example.three_layer.common.Meta;
import com.example.three_layer.dto.TaskItem3PatchRequest;
import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3Response;
import com.example.three_layer.dto.TaskItem3UpdateRequest;
import com.example.three_layer.mapper.TaskItem3Mapper;
import com.example.three_layer.service.TaskItem3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

  @Operation(summary = "ページ付きのタスク一覧取得", description = "ソート条件を ['title,asc'] のように指定しないとうまく実行できない")
  @GetMapping
  public ApiResponse<List<TaskItem3Response>> getAll(
      @PageableDefault(size = 10) Pageable pageable) {
    var page = service.findAll(pageable);
    var data = page.getContent().stream().map(mapper::toDTO).toList();
    return ApiResponse.ok(data, Meta.fromPage(page));
  }

  @Operation(summary = "タスク追加")
  @PostMapping
  public ApiResponse<TaskItem3Response> addTaskItem(@RequestBody @Valid TaskItem3Request req) {
    var result = mapper.toDTO(service.save(req));
    return ApiResponse.ok(result);
  }

  @Operation(summary = "タスク更新")
  @PutMapping("/{id}")
  public ApiResponse<TaskItem3Response> updateTaskItem(
      @PathVariable Integer id, @RequestBody @Valid TaskItem3UpdateRequest req) {
    var result = mapper.toDTO(service.update(id, req));
    return ApiResponse.ok(result);
  }

  @Operation(summary = "タスク部分更新")
  @PatchMapping("/{id}")
  public ApiResponse<TaskItem3Response> patchTaskItem(
      @PathVariable Integer id, @RequestBody @Valid TaskItem3PatchRequest req) {
    var result = mapper.toDTO(service.partialUpdate(id, req));
    return ApiResponse.ok(result);
  }

  @PreAuthorize("hasRole('ADMIN')") // ADMINユーザのみ操作可能
  @Operation(summary = "タスク削除")
  @DeleteMapping("/{id}")
  public ApiResponse<Void> deleteTaskItem(
      @PathVariable Integer id) { // @PathVariable: URLに含まれる変数を引数として受け取る
    service.deleteById(id);
    return ApiResponse.ok(null);
  }
}
