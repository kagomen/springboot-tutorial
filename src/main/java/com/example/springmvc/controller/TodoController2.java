package com.example.springmvc.controller;

import com.example.springmvc.model.Todo;
import com.example.springmvc.repository.TodoRepository;
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

@Tag(name = "Todo API")
@RestController
@RequestMapping("/todos2")
public class TodoController2 {

  private final TodoRepository repository;

  // SpringBootがTodoRepositoryを探して、ここに注入（DI）する（コンストラクタインジェクション）
  public TodoController2(TodoRepository repository) {
    this.repository = repository;
  }

  @Operation(summary = "Todo一覧取得（DB）")
  @GetMapping
  public Collection<Todo> getTodos() {
    return repository.findAll();
  }

  @Operation(summary = "Todo追加（DB）")
  @PostMapping
  public Todo addTodo(@RequestBody Todo todo) {
    return repository.save(todo);
  }

  @Operation(summary = "Todo削除（DB）")
  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
